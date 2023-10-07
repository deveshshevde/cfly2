package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.containers.mp4.c;

public class aj extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33322c;

    /* renamed from: d  reason: collision with root package name */
    private long f33323d;

    /* renamed from: e  reason: collision with root package name */
    private float f33324e;

    /* renamed from: f  reason: collision with root package name */
    private float f33325f;

    /* renamed from: g  reason: collision with root package name */
    private long f33326g;

    /* renamed from: h  reason: collision with root package name */
    private long f33327h;

    /* renamed from: j  reason: collision with root package name */
    private int[] f33328j;

    /* renamed from: k  reason: collision with root package name */
    private int f33329k;

    public aj() {
        super(new y(a()));
    }

    public aj(int i2, long j2, float f2, float f3, long j3, long j4, int[] iArr, int i3) {
        super(new y(a()));
        this.f33322c = i2;
        this.f33323d = j2;
        this.f33324e = f2;
        this.f33325f = f3;
        this.f33326g = j3;
        this.f33327h = j4;
        this.f33328j = iArr;
        this.f33329k = i3;
    }

    public static String a() {
        return "mvhd";
    }

    private void a(ByteBuffer byteBuffer, float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        byteBuffer.putShort((short) ((int) (d2 * 256.0d)));
    }

    private void b(ByteBuffer byteBuffer, float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        byteBuffer.putInt((int) (d2 * 65536.0d));
    }

    private void c(ByteBuffer byteBuffer) {
        for (int i2 = 0; i2 < Math.min(9, this.f33328j.length); i2++) {
            byteBuffer.putInt(this.f33328j[i2]);
        }
        for (int min = Math.min(9, this.f33328j.length); min < 9; min++) {
            byteBuffer.putInt(0);
        }
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(c.a(this.f33326g));
        byteBuffer.putInt(c.a(this.f33327h));
        byteBuffer.putInt(this.f33322c);
        byteBuffer.putInt((int) this.f33323d);
        b(byteBuffer, this.f33324e);
        a(byteBuffer, this.f33325f);
        byteBuffer.put(new byte[10]);
        c(byteBuffer);
        byteBuffer.put(new byte[24]);
        byteBuffer.putInt(this.f33329k);
    }

    public int b() {
        return this.f33322c;
    }
}
