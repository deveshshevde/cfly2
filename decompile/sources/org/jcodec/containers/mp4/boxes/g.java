package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class g extends u {

    /* renamed from: c  reason: collision with root package name */
    private long[] f33503c;

    public g() {
        super(new y(a()));
    }

    public static String a() {
        return "stco";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33503c.length);
        for (long j2 : this.f33503c) {
            byteBuffer.putInt((int) j2);
        }
    }
}
