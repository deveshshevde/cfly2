package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;

public class NativeBlurFilter {
    static {
        b.a();
    }

    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
