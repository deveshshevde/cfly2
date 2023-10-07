package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class bd extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33407c;

    /* renamed from: d  reason: collision with root package name */
    private long f33408d;

    /* renamed from: e  reason: collision with root package name */
    private int f33409e;

    /* renamed from: f  reason: collision with root package name */
    private int f33410f;

    /* renamed from: g  reason: collision with root package name */
    private int f33411g;

    /* renamed from: h  reason: collision with root package name */
    private int f33412h;

    public bd() {
        super(new y(a()));
    }

    public static String a() {
        return "tfhd";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33407c);
        if (b()) {
            byteBuffer.putLong(this.f33408d);
        }
        if (c()) {
            byteBuffer.putInt(this.f33409e);
        }
        if (d()) {
            byteBuffer.putInt(this.f33410f);
        }
        if (e()) {
            byteBuffer.putInt(this.f33411g);
        }
        if (f()) {
            byteBuffer.putInt(this.f33412h);
        }
    }

    public boolean b() {
        return (this.f33539b & 1) != 0;
    }

    public boolean c() {
        return (this.f33539b & 2) != 0;
    }

    public boolean d() {
        return (this.f33539b & 8) != 0;
    }

    public boolean e() {
        return (this.f33539b & 16) != 0;
    }

    public boolean f() {
        return (this.f33539b & 32) != 0;
    }
}
