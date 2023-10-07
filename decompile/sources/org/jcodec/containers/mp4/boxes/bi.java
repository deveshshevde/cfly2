package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class bi extends u {

    /* renamed from: c  reason: collision with root package name */
    int f33431c;

    /* renamed from: d  reason: collision with root package name */
    int f33432d;

    /* renamed from: e  reason: collision with root package name */
    int f33433e;

    /* renamed from: f  reason: collision with root package name */
    int f33434f;

    public bi() {
        super(new y(a()));
    }

    public bi(int i2, int i3, int i4, int i5) {
        super(new y(a()));
        this.f33431c = i2;
        this.f33432d = i3;
        this.f33433e = i4;
        this.f33434f = i5;
    }

    public static String a() {
        return "vmhd";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort((short) this.f33431c);
        byteBuffer.putShort((short) this.f33432d);
        byteBuffer.putShort((short) this.f33433e);
        byteBuffer.putShort((short) this.f33434f);
    }
}
