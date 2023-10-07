package com.google.android.exoplayer2.util;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f17155a;

    /* renamed from: b  reason: collision with root package name */
    private int f17156b;

    /* renamed from: c  reason: collision with root package name */
    private int f17157c;

    /* renamed from: d  reason: collision with root package name */
    private int f17158d;

    public p() {
        this.f17155a = ad.f11760f;
    }

    public p(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public p(byte[] bArr, int i2) {
        this.f17155a = bArr;
        this.f17158d = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f17158d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r2 = this;
            int r0 = r2.f17156b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f17158d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f17157c
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.util.a.b((boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.p.g():void");
    }

    public int a() {
        return ((this.f17158d - this.f17156b) * 8) - this.f17157c;
    }

    public void a(int i2) {
        int i3 = i2 / 8;
        this.f17156b = i3;
        this.f17157c = i2 - (i3 * 8);
        g();
    }

    public void a(int i2, int i3) {
        if (i3 < 32) {
            i2 &= (1 << i3) - 1;
        }
        int min = Math.min(8 - this.f17157c, i3);
        int i4 = this.f17157c;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.f17155a;
        int i6 = this.f17156b;
        bArr[i6] = (byte) (((65280 >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        int i7 = i3 - min;
        bArr[i6] = (byte) (((i2 >>> i7) << i5) | bArr[i6]);
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f17155a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f17155a;
        bArr2[i8] = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | bArr2[i8]);
        b(i3);
        g();
    }

    public void a(q qVar) {
        a(qVar.f17159a, qVar.c());
        a(qVar.d() * 8);
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i2) {
        this.f17155a = bArr;
        this.f17156b = 0;
        this.f17157c = 0;
        this.f17158d = i2;
    }

    public void a(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.f17155a;
            int i5 = this.f17156b;
            int i6 = i5 + 1;
            this.f17156b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f17157c;
            bArr[i2] = (byte) (b2 << i7);
            bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | bArr[i2]);
            i2++;
        }
        int i8 = i3 & 7;
        if (i8 != 0) {
            bArr[i4] = (byte) (bArr[i4] & (255 >> i8));
            int i9 = this.f17157c;
            if (i9 + i8 > 8) {
                byte b3 = bArr[i4];
                byte[] bArr3 = this.f17155a;
                int i10 = this.f17156b;
                this.f17156b = i10 + 1;
                bArr[i4] = (byte) (b3 | ((bArr3[i10] & 255) << i9));
                this.f17157c = i9 - 8;
            }
            int i11 = this.f17157c + i8;
            this.f17157c = i11;
            byte[] bArr4 = this.f17155a;
            int i12 = this.f17156b;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.f17157c = 0;
                this.f17156b = i12 + 1;
            }
            g();
        }
    }

    public int b() {
        return (this.f17156b * 8) + this.f17157c;
    }

    public void b(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f17156b + i3;
        this.f17156b = i4;
        int i5 = this.f17157c + (i2 - (i3 * 8));
        this.f17157c = i5;
        if (i5 > 7) {
            this.f17156b = i4 + 1;
            this.f17157c = i5 - 8;
        }
        g();
    }

    public void b(byte[] bArr, int i2, int i3) {
        a.b(this.f17157c == 0);
        System.arraycopy(this.f17155a, this.f17156b, bArr, i2, i3);
        this.f17156b += i3;
        g();
    }

    public int c() {
        a.b(this.f17157c == 0);
        return this.f17156b;
    }

    public int c(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f17157c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f17157c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f17157c = i5;
            byte[] bArr = this.f17155a;
            int i6 = this.f17156b;
            this.f17156b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f17155a;
        int i7 = this.f17156b;
        int i8 = (-1 >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f17157c = 0;
            this.f17156b = i7 + 1;
        }
        g();
        return i8;
    }

    public long d(int i2) {
        return i2 <= 32 ? ad.b(c(i2)) : ad.b(c(i2 - 32), c(32));
    }

    public void d() {
        int i2 = this.f17157c + 1;
        this.f17157c = i2;
        if (i2 == 8) {
            this.f17157c = 0;
            this.f17156b++;
        }
        g();
    }

    public void e(int i2) {
        a.b(this.f17157c == 0);
        this.f17156b += i2;
        g();
    }

    public boolean e() {
        boolean z2 = (this.f17155a[this.f17156b] & (128 >> this.f17157c)) != 0;
        d();
        return z2;
    }

    public void f() {
        if (this.f17157c != 0) {
            this.f17157c = 0;
            this.f17156b++;
            g();
        }
    }
}
