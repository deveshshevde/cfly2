package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class j extends c {

    /* renamed from: a  reason: collision with root package name */
    private short f33514a;

    /* renamed from: b  reason: collision with root package name */
    private short f33515b;

    /* renamed from: c  reason: collision with root package name */
    private short f33516c;

    /* renamed from: d  reason: collision with root package name */
    private short f33517d;

    /* renamed from: e  reason: collision with root package name */
    private short f33518e;

    public j() {
        super(new y(a()));
    }

    public static String a() {
        return "crgn";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.f33514a);
        byteBuffer.putShort(this.f33515b);
        byteBuffer.putShort(this.f33516c);
        byteBuffer.putShort(this.f33517d);
        byteBuffer.putShort(this.f33518e);
    }
}
