package com.google.android.exoplayer2.util;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f17162a;

    /* renamed from: b  reason: collision with root package name */
    private int f17163b;

    /* renamed from: c  reason: collision with root package name */
    private int f17164c;

    /* renamed from: d  reason: collision with root package name */
    private int f17165d;

    public r(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3);
    }

    private boolean d(int i2) {
        if (2 <= i2 && i2 < this.f17163b) {
            byte[] bArr = this.f17162a;
            return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
        }
    }

    private int f() {
        int i2 = 0;
        int i3 = 0;
        while (!b()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = c(i3);
        }
        return i4 + i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f17163b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r2 = this;
            int r0 = r2.f17164c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f17163b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f17165d
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.r.g():void");
    }

    public void a() {
        int i2 = 1;
        int i3 = this.f17165d + 1;
        this.f17165d = i3;
        if (i3 == 8) {
            this.f17165d = 0;
            int i4 = this.f17164c;
            if (d(i4 + 1)) {
                i2 = 2;
            }
            this.f17164c = i4 + i2;
        }
        g();
    }

    public void a(int i2) {
        int i3 = this.f17164c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f17164c = i5;
        int i6 = this.f17165d + (i2 - (i4 * 8));
        this.f17165d = i6;
        if (i6 > 7) {
            this.f17164c = i5 + 1;
            this.f17165d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f17164c) {
                g();
                return;
            } else if (d(i3)) {
                this.f17164c++;
                i3 += 2;
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f17162a = bArr;
        this.f17164c = i2;
        this.f17163b = i3;
        this.f17165d = 0;
        g();
    }

    public boolean b() {
        boolean z2 = (this.f17162a[this.f17164c] & (128 >> this.f17165d)) != 0;
        a();
        return z2;
    }

    public boolean b(int i2) {
        int i3 = this.f17164c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f17165d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f17163b) {
                int i7 = this.f17163b;
            } else if (d(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f17163b;
        if (i5 >= i72) {
            return i5 == i72 && i6 == 0;
        }
        return true;
    }

    public int c(int i2) {
        int i3;
        int i4;
        this.f17165d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f17165d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.f17165d = i6;
            byte[] bArr = this.f17162a;
            int i7 = this.f17164c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!d(i7 + 1)) {
                i4 = 1;
            }
            this.f17164c = i7 + i4;
        }
        byte[] bArr2 = this.f17162a;
        int i8 = this.f17164c;
        int i9 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i8] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f17165d = 0;
            if (!d(i8 + 1)) {
                i4 = 1;
            }
            this.f17164c = i8 + i4;
        }
        g();
        return i9;
    }

    public boolean c() {
        int i2 = this.f17164c;
        int i3 = this.f17165d;
        int i4 = 0;
        while (this.f17164c < this.f17163b && !b()) {
            i4++;
        }
        boolean z2 = this.f17164c == this.f17163b;
        this.f17164c = i2;
        this.f17165d = i3;
        return !z2 && b((i4 * 2) + 1);
    }

    public int d() {
        return f();
    }

    public int e() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }
}
