package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f17159a;

    /* renamed from: b  reason: collision with root package name */
    private int f17160b;

    /* renamed from: c  reason: collision with root package name */
    private int f17161c;

    public q() {
        this.f17159a = ad.f11760f;
    }

    public q(int i2) {
        this.f17159a = new byte[i2];
        this.f17161c = i2;
    }

    public q(byte[] bArr) {
        this.f17159a = bArr;
        this.f17161c = bArr.length;
    }

    public q(byte[] bArr, int i2) {
        this.f17159a = bArr;
        this.f17161c = i2;
    }

    public String A() {
        if (b() == 0) {
            return null;
        }
        int i2 = this.f17160b;
        while (i2 < this.f17161c && this.f17159a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f17159a;
        int i3 = this.f17160b;
        String a2 = ad.a(bArr, i3, i2 - i3);
        this.f17160b = i2;
        if (i2 < this.f17161c) {
            this.f17160b = i2 + 1;
        }
        return a2;
    }

    public String B() {
        if (b() == 0) {
            return null;
        }
        int i2 = this.f17160b;
        while (i2 < this.f17161c && !ad.a((int) this.f17159a[i2])) {
            i2++;
        }
        int i3 = this.f17160b;
        if (i2 - i3 >= 3) {
            byte[] bArr = this.f17159a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f17160b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f17159a;
        int i4 = this.f17160b;
        String a2 = ad.a(bArr2, i4, i2 - i4);
        this.f17160b = i2;
        int i5 = this.f17161c;
        if (i2 == i5) {
            return a2;
        }
        byte[] bArr3 = this.f17159a;
        if (bArr3[i2] == 13) {
            int i6 = i2 + 1;
            this.f17160b = i6;
            if (i6 == i5) {
                return a2;
            }
        }
        int i7 = this.f17160b;
        if (bArr3[i7] == 10) {
            this.f17160b = i7 + 1;
        }
        return a2;
    }

    public long C() {
        int i2;
        int i3;
        long j2 = (long) this.f17159a[this.f17160b];
        int i4 = 7;
        while (true) {
            i2 = 1;
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 != 0) {
            while (i2 < i3) {
                byte b2 = this.f17159a[this.f17160b + i2];
                if ((b2 & 192) == 128) {
                    j2 = (j2 << 6) | ((long) (b2 & 63));
                    i2++;
                } else {
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Invalid UTF-8 sequence continuation byte: ");
                    sb.append(j2);
                    throw new NumberFormatException(sb.toString());
                }
            }
            this.f17160b += i3;
            return j2;
        }
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Invalid UTF-8 sequence first byte: ");
        sb2.append(j2);
        throw new NumberFormatException(sb2.toString());
    }

    public String a(int i2, Charset charset) {
        String str = new String(this.f17159a, this.f17160b, i2, charset);
        this.f17160b += i2;
        return str;
    }

    public void a() {
        this.f17160b = 0;
        this.f17161c = 0;
    }

    public void a(int i2) {
        a(e() < i2 ? new byte[i2] : this.f17159a, i2);
    }

    public void a(p pVar, int i2) {
        a(pVar.f17155a, 0, i2);
        pVar.a(0);
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i2) {
        this.f17159a = bArr;
        this.f17161c = i2;
        this.f17160b = 0;
    }

    public void a(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f17159a, this.f17160b, bArr, i2, i3);
        this.f17160b += i3;
    }

    public int b() {
        return this.f17161c - this.f17160b;
    }

    public void b(int i2) {
        a.a(i2 >= 0 && i2 <= this.f17159a.length);
        this.f17161c = i2;
    }

    public int c() {
        return this.f17161c;
    }

    public void c(int i2) {
        a.a(i2 >= 0 && i2 <= this.f17161c);
        this.f17160b = i2;
    }

    public int d() {
        return this.f17160b;
    }

    public void d(int i2) {
        c(this.f17160b + i2);
    }

    public int e() {
        return this.f17159a.length;
    }

    public String e(int i2) {
        return a(i2, Charset.forName("UTF-8"));
    }

    public int f() {
        return this.f17159a[this.f17160b] & 255;
    }

    public String f(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = this.f17160b;
        int i4 = (i3 + i2) - 1;
        String a2 = ad.a(this.f17159a, i3, (i4 >= this.f17161c || this.f17159a[i4] != 0) ? i2 : i2 - 1);
        this.f17160b += i2;
        return a2;
    }

    public char g() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public int h() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        this.f17160b = i2 + 1;
        return bArr[i2] & 255;
    }

    public int i() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        this.f17160b = i3 + 1;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public int j() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        this.f17160b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public short k() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        this.f17160b = i3 + 1;
        return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
    }

    public int l() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        byte b2 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        this.f17160b = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public int m() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        byte b2 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
        this.f17160b = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public long n() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        int i5 = i4 + 1;
        this.f17160b = i5;
        this.f17160b = i5 + 1;
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 8);
    }

    public long o() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        int i5 = i4 + 1;
        this.f17160b = i5;
        this.f17160b = i5 + 1;
        return ((((long) bArr[i5]) & 255) << 24) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16);
    }

    public int p() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i5 = i4 + 1;
        this.f17160b = i5;
        byte b3 = b2 | ((bArr[i4] & 255) << 8);
        this.f17160b = i5 + 1;
        return (bArr[i5] & 255) | b3;
    }

    public int q() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        byte b2 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i5 = i4 + 1;
        this.f17160b = i5;
        byte b3 = b2 | ((bArr[i4] & 255) << 16);
        this.f17160b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | b3;
    }

    public long r() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        int i5 = i4 + 1;
        this.f17160b = i5;
        int i6 = i5 + 1;
        this.f17160b = i6;
        int i7 = i6 + 1;
        this.f17160b = i7;
        int i8 = i7 + 1;
        this.f17160b = i8;
        int i9 = i8 + 1;
        this.f17160b = i9;
        this.f17160b = i9 + 1;
        return (((long) bArr[i9]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8);
    }

    public long s() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        int i5 = i4 + 1;
        this.f17160b = i5;
        int i6 = i5 + 1;
        this.f17160b = i6;
        int i7 = i6 + 1;
        this.f17160b = i7;
        int i8 = i7 + 1;
        this.f17160b = i8;
        int i9 = i8 + 1;
        this.f17160b = i9;
        this.f17160b = i9 + 1;
        return ((((long) bArr[i9]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 40) | ((((long) bArr[i8]) & 255) << 48);
    }

    public int t() {
        byte[] bArr = this.f17159a;
        int i2 = this.f17160b;
        int i3 = i2 + 1;
        this.f17160b = i3;
        int i4 = i3 + 1;
        this.f17160b = i4;
        byte b2 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        this.f17160b = i4 + 2;
        return b2;
    }

    public int u() {
        return (h() << 21) | (h() << 14) | (h() << 7) | h();
    }

    public int v() {
        int p2 = p();
        if (p2 >= 0) {
            return p2;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(p2);
        throw new IllegalStateException(sb.toString());
    }

    public int w() {
        int q2 = q();
        if (q2 >= 0) {
            return q2;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(q2);
        throw new IllegalStateException(sb.toString());
    }

    public long x() {
        long r2 = r();
        if (r2 >= 0) {
            return r2;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(r2);
        throw new IllegalStateException(sb.toString());
    }

    public float y() {
        return Float.intBitsToFloat(p());
    }

    public double z() {
        return Double.longBitsToDouble(r());
    }
}
