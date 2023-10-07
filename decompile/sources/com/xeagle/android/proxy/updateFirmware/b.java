package com.xeagle.android.proxy.updateFirmware;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f24305a;

    public b() {
        a();
    }

    public int a(byte[] bArr, int i2) {
        int i3 = i2 & 1;
        int i4 = i2 - i3;
        int i5 = 0;
        while (i5 < i4) {
            this.f24305a += ((bArr[i5] & 255) << 8) + (bArr[i5 + 1] & 255);
            i5 += 2;
        }
        if (i3 == 1) {
            this.f24305a += ((bArr[i5] & 255) << 8) + 255;
        }
        return this.f24305a;
    }

    public void a() {
        this.f24305a = 0;
    }

    public int b() {
        return (this.f24305a >> 8) & 255;
    }

    public int c() {
        return this.f24305a & 255;
    }
}
