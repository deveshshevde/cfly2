package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class av extends u {

    /* renamed from: c  reason: collision with root package name */
    private short f33360c;

    public av() {
        super(new y(a()));
    }

    public static String a() {
        return "smhd";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(this.f33360c);
        byteBuffer.putShort(0);
    }
}
