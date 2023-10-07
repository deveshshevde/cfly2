package com.google.android.exoplayer2.video;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import fi.f;
import java.nio.ByteBuffer;

public class VideoDecoderOutputBuffer extends f {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public ColorInfo colorInfo;
    public int colorspace;
    public ByteBuffer data;
    public int decoderPrivate;
    public int height;
    public int mode;
    private final a owner;
    public ByteBuffer supplementalData;
    public int width;
    public ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    public interface a {
        void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer);
    }

    public VideoDecoderOutputBuffer(a aVar) {
        this.owner = aVar;
    }

    private static boolean isSafeToMultiply(int i2, int i3) {
        return i2 >= 0 && i3 >= 0 && (i3 <= 0 || i2 < SubsamplingScaleImageView.TILE_SIZE_AUTO / i3);
    }

    public void init(long j2, int i2, ByteBuffer byteBuffer) {
        this.timeUs = j2;
        this.mode = i2;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.supplementalData = null;
            return;
        }
        addFlag(AMapEngineUtils.MAX_P20_WIDTH);
        int limit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 == null || byteBuffer2.capacity() < limit) {
            this.supplementalData = ByteBuffer.allocate(limit);
        } else {
            this.supplementalData.clear();
        }
        this.supplementalData.put(byteBuffer);
        this.supplementalData.flip();
        byteBuffer.position(0);
    }

    public void initForPrivateFrame(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public boolean initForYuvFrame(int i2, int i3, int i4, int i5, int i6) {
        this.width = i2;
        this.height = i3;
        this.colorspace = i6;
        int i7 = (int) ((((long) i3) + 1) / 2);
        if (isSafeToMultiply(i4, i3) && isSafeToMultiply(i5, i7)) {
            int i8 = i3 * i4;
            int i9 = i7 * i5;
            int i10 = (i9 * 2) + i8;
            if (isSafeToMultiply(i9, 2) && i10 >= i8) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i10) {
                    this.data = ByteBuffer.allocateDirect(i10);
                } else {
                    this.data.position(0);
                    this.data.limit(i10);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                byteBufferArr[0] = byteBuffer2.slice();
                byteBufferArr[0].limit(i8);
                byteBuffer2.position(i8);
                byteBufferArr[1] = byteBuffer2.slice();
                byteBufferArr[1].limit(i9);
                byteBuffer2.position(i8 + i9);
                byteBufferArr[2] = byteBuffer2.slice();
                byteBufferArr[2].limit(i9);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i4;
                iArr[1] = i5;
                iArr[2] = i5;
                return true;
            }
        }
        return false;
    }

    public void release() {
        this.owner.a(this);
    }
}
