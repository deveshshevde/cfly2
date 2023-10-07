package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class f extends u {

    /* renamed from: c  reason: collision with root package name */
    private long[] f33502c;

    public f() {
        super(new y(a(), 0));
    }

    public f(long[] jArr) {
        this();
        this.f33502c = jArr;
    }

    public static String a() {
        return "co64";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33502c.length);
        for (long putLong : this.f33502c) {
            byteBuffer.putLong(putLong);
        }
    }
}
