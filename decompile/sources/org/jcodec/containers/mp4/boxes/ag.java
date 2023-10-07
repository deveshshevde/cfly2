package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ag extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33320c;

    public ag() {
        super(new y(a()));
    }

    public static String a() {
        return "mehd";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33320c);
    }
}
