package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ba extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33401c;

    /* renamed from: d  reason: collision with root package name */
    private int f33402d;

    /* renamed from: e  reason: collision with root package name */
    private int f33403e;

    /* renamed from: f  reason: collision with root package name */
    private int f33404f;

    /* renamed from: g  reason: collision with root package name */
    private int f33405g;

    public ba() {
        super(new y(a()));
    }

    public static String a() {
        return "trex";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33401c);
        byteBuffer.putInt(this.f33402d);
        byteBuffer.putInt(this.f33403e);
        byteBuffer.putInt(this.f33404f);
        byteBuffer.putInt(this.f33405g);
    }
}
