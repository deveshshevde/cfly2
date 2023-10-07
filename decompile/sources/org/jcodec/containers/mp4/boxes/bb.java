package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class bb extends u {

    /* renamed from: c  reason: collision with root package name */
    private long f33406c;

    public bb() {
        super(new y(a()));
    }

    public static String a() {
        return "tfdt";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        if (this.f33538a == 0) {
            byteBuffer.putInt((int) this.f33406c);
        } else if (this.f33538a == 1) {
            byteBuffer.putLong(this.f33406c);
        } else {
            throw new RuntimeException("Unsupported tfdt version");
        }
    }
}
