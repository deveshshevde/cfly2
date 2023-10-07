package bq;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.p;

public final class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    private final p f5969a = p.a();

    /* renamed from: b  reason: collision with root package name */
    private final int f5970b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5971c;

    /* renamed from: d  reason: collision with root package name */
    private final DecodeFormat f5972d;

    /* renamed from: e  reason: collision with root package name */
    private final DownsampleStrategy f5973e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5974f;

    /* renamed from: g  reason: collision with root package name */
    private final PreferredColorSpace f5975g;

    public a(int i2, int i3, f fVar) {
        this.f5970b = i2;
        this.f5971c = i3;
        this.f5972d = (DecodeFormat) fVar.a(k.f10470a);
        this.f5973e = (DownsampleStrategy) fVar.a(DownsampleStrategy.f10435h);
        this.f5974f = fVar.a(k.f10474e) != null && ((Boolean) fVar.a(k.f10474e)).booleanValue();
        this.f5975g = (PreferredColorSpace) fVar.a(k.f10471b);
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named named;
        boolean z2 = false;
        if (this.f5969a.a(this.f5970b, this.f5971c, this.f5974f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f5972d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        });
        Size size = imageInfo.getSize();
        int i2 = this.f5970b;
        if (i2 == Integer.MIN_VALUE) {
            i2 = size.getWidth();
        }
        int i3 = this.f5971c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = size.getHeight();
        }
        float a2 = this.f5973e.a(size.getWidth(), size.getHeight(), i2, i3);
        int round = Math.round(((float) size.getWidth()) * a2);
        int round2 = Math.round(((float) size.getHeight()) * a2);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + a2);
        }
        imageDecoder.setTargetSize(round, round2);
        if (this.f5975g != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (this.f5975g == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z2 = true;
                }
                if (z2) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                }
            } else if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            named = ColorSpace.Named.SRGB;
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }
}
