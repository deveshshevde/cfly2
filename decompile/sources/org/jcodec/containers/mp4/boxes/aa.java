package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class aa extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f33310a;

    /* renamed from: b  reason: collision with root package name */
    private int f33311b;

    /* renamed from: c  reason: collision with root package name */
    private int f33312c;

    /* renamed from: d  reason: collision with root package name */
    private int f33313d;

    public aa() {
        super(new y(a()));
    }

    public static String a() {
        return "load";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f33310a);
        byteBuffer.putInt(this.f33311b);
        byteBuffer.putInt(this.f33312c);
        byteBuffer.putInt(this.f33313d);
    }
}
