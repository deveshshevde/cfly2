package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;

public class NativeRoundingFilter {
    static {
        b.a();
    }

    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z2);

    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z2);
}
