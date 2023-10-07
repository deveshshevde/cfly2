package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public NALUnitType f33008a;

    /* renamed from: b  reason: collision with root package name */
    public int f33009b;

    public c(NALUnitType nALUnitType, int i2) {
        this.f33008a = nALUnitType;
        this.f33009b = i2;
    }

    public static c a(ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get() & 255;
        return new c(NALUnitType.a(b2 & 31), (b2 >> 5) & 3);
    }

    public void b(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) (this.f33008a.a() | (this.f33009b << 5)));
    }
}
