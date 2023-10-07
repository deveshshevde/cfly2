package com.facebook.imagepipeline.nativecode;

import dt.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NativeJpegTranscoder implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11364a;

    /* renamed from: b  reason: collision with root package name */
    private int f11365b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11366c;

    static {
        c.a();
    }

    public NativeJpegTranscoder(boolean z2, int i2, boolean z3) {
        this.f11364a = z2;
        this.f11365b = i2;
        this.f11366c = z3;
    }

    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;
}
