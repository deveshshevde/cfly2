package com.facebook.animated.gif;

import java.nio.ByteBuffer;

public class GifImage {
    private long mNativeContext;

    public GifImage() {
    }

    GifImage(long j2) {
        this.mNativeContext = j2;
    }

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native GifImage nativeCreateFromNativeMemory(long j2, int i2);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i2);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }
}
