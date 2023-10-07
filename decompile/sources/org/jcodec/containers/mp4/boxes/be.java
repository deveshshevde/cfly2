package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.containers.mp4.c;

public class be extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33413c;

    /* renamed from: d  reason: collision with root package name */
    private long f33414d;

    /* renamed from: e  reason: collision with root package name */
    private float f33415e;

    /* renamed from: f  reason: collision with root package name */
    private float f33416f;

    /* renamed from: g  reason: collision with root package name */
    private long f33417g;

    /* renamed from: h  reason: collision with root package name */
    private long f33418h;

    /* renamed from: j  reason: collision with root package name */
    private float f33419j;

    /* renamed from: k  reason: collision with root package name */
    private short f33420k;

    /* renamed from: l  reason: collision with root package name */
    private long f33421l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f33422m;

    public be() {
        super(new y(a()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public be(int i2, long j2, float f2, float f3, long j3, long j4, float f4, short s2, long j5, int[] iArr) {
        super(new y(a()));
        this.f33413c = i2;
        this.f33414d = j2;
        this.f33415e = f2;
        this.f33416f = f3;
        this.f33417g = j3;
        this.f33418h = j4;
        this.f33419j = f4;
        this.f33420k = s2;
        this.f33421l = j5;
        this.f33422m = iArr;
    }

    public static String a() {
        return "tkhd";
    }

    private void c(ByteBuffer byteBuffer) {
        for (int i2 = 0; i2 < 9; i2++) {
            byteBuffer.putInt(this.f33422m[i2]);
        }
    }

    private void d(ByteBuffer byteBuffer) {
        double d2 = (double) this.f33419j;
        Double.isNaN(d2);
        byteBuffer.putShort((short) ((int) (d2 * 256.0d)));
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(c.a(this.f33417g));
        byteBuffer.putInt(c.a(this.f33418h));
        byteBuffer.putInt(this.f33413c);
        byteBuffer.putInt(0);
        byteBuffer.putInt((int) this.f33414d);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f33420k);
        byteBuffer.putShort((short) ((int) this.f33421l));
        d(byteBuffer);
        byteBuffer.putShort(0);
        c(byteBuffer);
        byteBuffer.putInt((int) (this.f33415e * 65536.0f));
        byteBuffer.putInt((int) (this.f33416f * 65536.0f));
    }
}
