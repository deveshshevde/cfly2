package com.facebook.animated.gif;

import android.graphics.Bitmap;

public class GifFrame {
    private long mNativeContext;

    GifFrame(long j2) {
        this.mNativeContext = j2;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDisposalMode();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetTransparentPixelColor();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeHasTransparency();

    private native void nativeRenderFrame(int i2, int i3, Bitmap bitmap);

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }
}
