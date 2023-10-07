package com.xeagle.android.proxy.updateFirmware;

import android.util.Log;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f24303a = ByteBuffer.allocate(512);

    /* renamed from: b  reason: collision with root package name */
    public int f24304b;

    public int a() {
        return this.f24303a.position();
    }

    public void a(byte b2) {
        try {
            this.f24303a.put(b2);
        } catch (BufferOverflowException unused) {
            Log.i("UPLOAD", "add buffer exception： buffer over");
        }
    }

    public void b() {
        this.f24304b = 0;
    }

    public void b(byte b2) {
        a(b2);
    }

    public int c() {
        byte b2 = ((this.f24303a.get(this.f24304b + 3) & 255) << 24) | 0 | ((this.f24303a.get(this.f24304b + 2) & 255) << 16) | ((this.f24303a.get(this.f24304b + 1) & 255) << 8) | (this.f24303a.get(this.f24304b + 0) & 255);
        this.f24304b += 4;
        return b2;
    }
}
