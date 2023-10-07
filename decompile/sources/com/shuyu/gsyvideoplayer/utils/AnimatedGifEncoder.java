package com.shuyu.gsyvideoplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.IOException;
import java.io.OutputStream;

public class AnimatedGifEncoder {
    protected boolean closeStream = false;
    protected int colorDepth;
    protected byte[] colorTab;
    protected int delay = 0;
    protected int dispose = -1;
    protected boolean firstFrame = true;
    protected int height;
    protected Bitmap image;
    protected byte[] indexedPixels;
    protected OutputStream out;
    protected int palSize = 7;
    protected byte[] pixels;
    protected int repeat = -1;
    protected int sample = 10;
    protected boolean sizeSet = false;
    protected boolean started = false;
    protected int transIndex;
    protected int transparent = -1;
    protected boolean[] usedEntry = new boolean[256];
    protected int width;

    /* renamed from: x  reason: collision with root package name */
    protected int f21692x = 0;

    /* renamed from: y  reason: collision with root package name */
    protected int f21693y = 0;

    public boolean addFrame(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.sizeSet) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            getImagePixels();
            analyzePixels();
            if (this.firstFrame) {
                writeLSD();
                writePalette();
                if (this.repeat >= 0) {
                    writeNetscapeExt();
                }
            }
            writeGraphicCtrlExt();
            writeImageDesc();
            if (!this.firstFrame) {
                writePalette();
            }
            writePixels();
            this.firstFrame = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void analyzePixels() {
        byte[] bArr = this.pixels;
        int length = bArr.length;
        int i2 = length / 3;
        this.indexedPixels = new byte[i2];
        NeuQuant neuQuant = new NeuQuant(bArr, length, this.sample);
        this.colorTab = neuQuant.process();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr2 = this.colorTab;
            if (i4 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i4];
            int i5 = i4 + 2;
            bArr2[i4] = bArr2[i5];
            bArr2[i5] = b2;
            this.usedEntry[i4 / 3] = false;
            i4 += 3;
        }
        int i6 = 0;
        while (i3 < i2) {
            byte[] bArr3 = this.pixels;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int map = neuQuant.map(bArr3[i6] & 255, bArr3[i7] & 255, bArr3[i8] & 255);
            this.usedEntry[map] = true;
            this.indexedPixels[i3] = (byte) map;
            i3++;
            i6 = i8 + 1;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        int i9 = this.transparent;
        if (i9 != -1) {
            this.transIndex = findClosest(i9);
        }
    }

    /* access modifiers changed from: protected */
    public int findClosest(int i2) {
        byte[] bArr = this.colorTab;
        if (bArr == null) {
            return -1;
        }
        byte b2 = (i2 >> 16) & 255;
        byte b3 = (i2 >> 8) & 255;
        int i3 = 0;
        byte b4 = (i2 >> 0) & 255;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 16777216;
        while (i3 < length) {
            byte[] bArr2 = this.colorTab;
            int i6 = i3 + 1;
            int i7 = b2 - (bArr2[i3] & 255);
            int i8 = i6 + 1;
            int i9 = b3 - (bArr2[i6] & 255);
            int i10 = b4 - (bArr2[i8] & 255);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            if (this.usedEntry[i12] && i11 < i5) {
                i5 = i11;
                i4 = i12;
            }
            i3 = i8 + 1;
        }
        return i4;
    }

    public boolean finish() {
        boolean z2;
        if (!this.started) {
            return false;
        }
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.closeStream) {
                this.out.close();
            }
            z2 = true;
        } catch (IOException unused) {
            z2 = false;
        }
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return z2;
    }

    /* access modifiers changed from: protected */
    public int[] getImageData(Bitmap bitmap) {
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        int[] iArr = new int[(width2 * height2)];
        bitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        return iArr;
    }

    /* access modifiers changed from: protected */
    public void getImagePixels() {
        int width2 = this.image.getWidth();
        int height2 = this.image.getHeight();
        int i2 = this.width;
        if (!(width2 == i2 && height2 == this.height)) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] imageData = getImageData(this.image);
        this.pixels = new byte[(imageData.length * 3)];
        for (int i3 = 0; i3 < imageData.length; i3++) {
            int i4 = imageData[i3];
            int i5 = i3 * 3;
            byte[] bArr = this.pixels;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i4 >> 0) & 255);
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            bArr[i6 + 1] = (byte) ((i4 >> 16) & 255);
        }
    }

    public void setDelay(int i2) {
        this.delay = i2 / 10;
    }

    public void setDispose(int i2) {
        if (i2 >= 0) {
            this.dispose = i2;
        }
    }

    public void setFrameRate(float f2) {
        if (f2 != 0.0f) {
            this.delay = (int) (100.0f / f2);
        }
    }

    public void setPosition(int i2, int i3) {
        this.f21692x = i2;
        this.f21693y = i3;
    }

    public void setQuality(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        this.sample = i2;
    }

    public void setRepeat(int i2) {
        if (i2 >= 0) {
            this.repeat = i2;
        }
    }

    public void setSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
        if (i2 < 1) {
            this.width = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        }
        if (i3 < 1) {
            this.height = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
        }
        this.sizeSet = true;
    }

    public void setTransparent(int i2) {
        this.transparent = i2;
    }

    public boolean start(OutputStream outputStream) {
        boolean z2 = false;
        if (outputStream == null) {
            return false;
        }
        this.closeStream = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
            z2 = true;
        } catch (IOException unused) {
        }
        this.started = z2;
        return z2;
    }

    /* access modifiers changed from: protected */
    public void writeGraphicCtrlExt() throws IOException {
        int i2;
        int i3;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == -1) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = 1;
            i2 = 2;
        }
        int i4 = this.dispose;
        if (i4 >= 0) {
            i2 = i4 & 7;
        }
        this.out.write(i3 | (i2 << 2) | 0 | 0);
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    /* access modifiers changed from: protected */
    public void writeImageDesc() throws IOException {
        int i2;
        OutputStream outputStream;
        this.out.write(44);
        writeShort(this.f21692x);
        writeShort(this.f21693y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame) {
            outputStream = this.out;
            i2 = 0;
        } else {
            outputStream = this.out;
            i2 = this.palSize | 128;
        }
        outputStream.write(i2);
    }

    /* access modifiers changed from: protected */
    public void writeLSD() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
        this.out.write(0);
        this.out.write(0);
    }

    /* access modifiers changed from: protected */
    public void writeNetscapeExt() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    /* access modifiers changed from: protected */
    public void writePalette() throws IOException {
        OutputStream outputStream = this.out;
        byte[] bArr = this.colorTab;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.colorTab.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.out.write(0);
        }
    }

    /* access modifiers changed from: protected */
    public void writePixels() throws IOException {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    /* access modifiers changed from: protected */
    public void writeShort(int i2) throws IOException {
        this.out.write(i2 & 255);
        this.out.write((i2 >> 8) & 255);
    }

    /* access modifiers changed from: protected */
    public void writeString(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.out.write((byte) str.charAt(i2));
        }
    }
}
