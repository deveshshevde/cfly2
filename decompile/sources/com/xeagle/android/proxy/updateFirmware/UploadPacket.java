package com.xeagle.android.proxy.updateFirmware;

import java.io.Serializable;

public class UploadPacket implements Serializable {
    private static final long serialVersionUID = 4722713921379950809L;

    /* renamed from: a  reason: collision with root package name */
    public int f24282a;

    /* renamed from: b  reason: collision with root package name */
    public int f24283b;

    /* renamed from: c  reason: collision with root package name */
    public int f24284c;

    /* renamed from: d  reason: collision with root package name */
    public int f24285d;

    /* renamed from: e  reason: collision with root package name */
    public a f24286e = new a();

    /* renamed from: f  reason: collision with root package name */
    public b f24287f;

    public boolean a() {
        return this.f24286e.a() >= 511 || this.f24286e.a() == this.f24282a;
    }

    public void b() {
        this.f24287f = new b();
        int i2 = 3;
        int a2 = this.f24286e.a() + 3;
        byte[] bArr = new byte[a2];
        int i3 = 0;
        bArr[0] = 126;
        bArr[1] = (byte) this.f24282a;
        bArr[2] = (byte) this.f24283b;
        this.f24286e.b();
        while (i3 < this.f24286e.a()) {
            bArr[i2] = this.f24286e.f24303a.get(i3);
            i3++;
            i2++;
        }
        this.f24287f.a(bArr, a2);
    }

    public void c() {
        this.f24287f = new b();
        int i2 = 5;
        int a2 = this.f24286e.a() + 5;
        byte[] bArr = new byte[a2];
        int i3 = 0;
        bArr[0] = 126;
        bArr[1] = (byte) this.f24282a;
        bArr[2] = (byte) this.f24283b;
        bArr[3] = (byte) this.f24284c;
        bArr[4] = (byte) this.f24285d;
        this.f24286e.b();
        while (i3 < this.f24286e.a()) {
            bArr[i2] = this.f24286e.f24303a.get(i3);
            i3++;
            i2++;
        }
        this.f24287f.a(bArr, a2);
    }

    public byte[] d() {
        int i2 = this.f24282a;
        byte[] bArr = new byte[(i2 + 3 + 2)];
        int i3 = 0;
        bArr[0] = 126;
        bArr[1] = (byte) i2;
        bArr[2] = (byte) this.f24283b;
        int i4 = 3;
        while (i3 < this.f24286e.a()) {
            bArr[i4] = this.f24286e.f24303a.get(i3);
            i3++;
            i4++;
        }
        b();
        bArr[i4] = (byte) this.f24287f.b();
        bArr[i4 + 1] = (byte) this.f24287f.c();
        return bArr;
    }

    public UploadMessage e() {
        int i2 = this.f24282a;
        if (i2 == 0) {
            return new DataAckMsg(this);
        }
        if (i2 == 2) {
            return new BootloaderAckMsg(this);
        }
        if (i2 != 4) {
            return null;
        }
        return new RecIntAckMsg(this);
    }
}
