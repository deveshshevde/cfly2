package com.facebook.imagepipeline.nativecode;

import dn.b;
import dt.a;

public class NativeJpegTranscoderFactory {

    /* renamed from: a  reason: collision with root package name */
    private final int f11367a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11368b;

    public NativeJpegTranscoderFactory(int i2, boolean z2) {
        this.f11367a = i2;
        this.f11368b = z2;
    }

    public a createImageTranscoder(b bVar, boolean z2) {
        if (bVar != dn.a.f26755a) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.f11367a, this.f11368b);
    }
}
