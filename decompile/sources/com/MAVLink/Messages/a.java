package com.MAVLink.Messages;

import android.util.Log;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f6281a = ByteBuffer.allocate(512);

    /* renamed from: b  reason: collision with root package name */
    public int f6282b;

    public int a() {
        return this.f6281a.position();
    }

    public void a(byte b2) {
        try {
            this.f6281a.put(b2);
        } catch (BufferOverflowException unused) {
            Log.i("BUF", "BUFF OVER");
        }
    }

    public void a(float f2) {
        a(Float.floatToIntBits(f2));
    }

    public void a(int i2) {
        a((byte) (i2 >> 0));
        a((byte) (i2 >> 8));
        a((byte) (i2 >> 16));
        a((byte) (i2 >> 24));
    }

    public void a(short s2) {
        a((byte) (s2 >> 0));
        a((byte) (s2 >> 8));
    }

    public void b() {
        this.f6282b = 0;
    }

    public void b(byte b2) {
        a(b2);
    }

    public byte c() {
        byte b2 = (byte) ((this.f6281a.get(this.f6282b + 0) & 255) | 0);
        this.f6282b++;
        return b2;
    }

    public short d() {
        short s2 = (short) (((short) (((this.f6281a.get(this.f6282b + 1) & 255) << 8) | 0)) | (this.f6281a.get(this.f6282b + 0) & 255));
        this.f6282b += 2;
        return s2;
    }

    public int e() {
        byte b2 = ((this.f6281a.get(this.f6282b + 3) & 255) << 24) | 0 | ((this.f6281a.get(this.f6282b + 2) & 255) << 16) | ((this.f6281a.get(this.f6282b + 1) & 255) << 8) | (this.f6281a.get(this.f6282b + 0) & 255);
        this.f6282b += 4;
        return b2;
    }

    public long f() {
        long j2 = ((((long) this.f6281a.get(this.f6282b + 7)) & 255) << 56) | 0 | ((((long) this.f6281a.get(this.f6282b + 6)) & 255) << 48) | ((((long) this.f6281a.get(this.f6282b + 5)) & 255) << 40) | ((((long) this.f6281a.get(this.f6282b + 4)) & 255) << 32) | ((((long) this.f6281a.get(this.f6282b + 3)) & 255) << 24) | ((((long) this.f6281a.get(this.f6282b + 2)) & 255) << 16) | ((((long) this.f6281a.get(this.f6282b + 1)) & 255) << 8) | (255 & ((long) this.f6281a.get(this.f6282b + 0)));
        this.f6282b += 8;
        return j2;
    }

    public float g() {
        return Float.intBitsToFloat(e());
    }

    public void h() {
        this.f6282b = 0;
        this.f6281a.clear();
    }
}
