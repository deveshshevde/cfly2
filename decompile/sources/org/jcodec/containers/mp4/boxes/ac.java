package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.containers.mp4.c;

public class ac extends u {

    /* renamed from: c  reason: collision with root package name */
    private long f33314c;

    /* renamed from: d  reason: collision with root package name */
    private long f33315d;

    /* renamed from: e  reason: collision with root package name */
    private int f33316e;

    /* renamed from: f  reason: collision with root package name */
    private long f33317f;

    /* renamed from: g  reason: collision with root package name */
    private int f33318g;

    /* renamed from: h  reason: collision with root package name */
    private int f33319h;

    public ac() {
        super(new y(a()));
    }

    public ac(int i2, long j2, int i3, long j3, long j4, int i4) {
        super(new y(a()));
        this.f33316e = i2;
        this.f33317f = j2;
        this.f33318g = i3;
        this.f33314c = j3;
        this.f33315d = j4;
        this.f33319h = i4;
    }

    public static String a() {
        return "mdhd";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(c.a(this.f33314c));
        byteBuffer.putInt(c.a(this.f33315d));
        byteBuffer.putInt(this.f33316e);
        byteBuffer.putInt((int) this.f33317f);
        byteBuffer.putShort((short) this.f33318g);
        byteBuffer.putShort((short) this.f33319h);
    }
}
