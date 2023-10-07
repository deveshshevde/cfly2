package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class w extends u {

    /* renamed from: c  reason: collision with root package name */
    private short f33541c;

    /* renamed from: d  reason: collision with root package name */
    private short f33542d;

    /* renamed from: e  reason: collision with root package name */
    private short f33543e;

    /* renamed from: f  reason: collision with root package name */
    private short f33544f;

    /* renamed from: g  reason: collision with root package name */
    private short f33545g;

    public w() {
        this(new y(a()));
    }

    public w(y yVar) {
        super(yVar);
    }

    public static String a() {
        return "gmin";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(this.f33541c);
        byteBuffer.putShort(this.f33542d);
        byteBuffer.putShort(this.f33543e);
        byteBuffer.putShort(this.f33544f);
        byteBuffer.putShort(this.f33545g);
        byteBuffer.putShort(0);
    }
}
