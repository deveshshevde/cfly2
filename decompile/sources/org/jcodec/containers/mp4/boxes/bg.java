package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class bg extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33423c;

    /* renamed from: d  reason: collision with root package name */
    private int f33424d;

    /* renamed from: e  reason: collision with root package name */
    private int f33425e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f33426f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f33427g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f33428h;

    /* renamed from: j  reason: collision with root package name */
    private int[] f33429j;

    public bg() {
        super(new y(a()));
    }

    public static String a() {
        return "trun";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33423c);
        if (b()) {
            byteBuffer.putInt(this.f33424d);
        }
        if (g()) {
            byteBuffer.putInt(this.f33425e);
        }
        for (int i2 = 0; i2 < this.f33423c; i2++) {
            if (f()) {
                byteBuffer.putInt(this.f33426f[i2]);
            }
            if (e()) {
                byteBuffer.putInt(this.f33427g[i2]);
            }
            if (d()) {
                byteBuffer.putInt(this.f33428h[i2]);
            }
            if (c()) {
                byteBuffer.putInt(this.f33429j[i2]);
            }
        }
    }

    public boolean b() {
        return (this.f33539b & 1) != 0;
    }

    public boolean c() {
        return (this.f33539b & 2048) != 0;
    }

    public boolean d() {
        return (this.f33539b & 1024) != 0;
    }

    public boolean e() {
        return (this.f33539b & 512) != 0;
    }

    public boolean f() {
        return (this.f33539b & 256) != 0;
    }

    public boolean g() {
        return (this.f33539b & 4) != 0;
    }
}
