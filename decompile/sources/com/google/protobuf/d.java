package com.google.protobuf;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f20112a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20113b;

    /* renamed from: c  reason: collision with root package name */
    private int f20114c;

    /* renamed from: d  reason: collision with root package name */
    private int f20115d;

    /* renamed from: e  reason: collision with root package name */
    private int f20116e;

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f20117f;

    /* renamed from: g  reason: collision with root package name */
    private int f20118g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20119h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f20120i;

    /* renamed from: j  reason: collision with root package name */
    private int f20121j = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: k  reason: collision with root package name */
    private int f20122k;

    /* renamed from: l  reason: collision with root package name */
    private int f20123l = 100;

    /* renamed from: m  reason: collision with root package name */
    private int f20124m = 67108864;

    /* renamed from: n  reason: collision with root package name */
    private a f20125n = null;

    private interface a {
        void a();
    }

    private d(byte[] bArr, int i2, int i3, boolean z2) {
        this.f20112a = bArr;
        this.f20114c = i3 + i2;
        this.f20116e = i2;
        this.f20120i = -i2;
        this.f20117f = null;
        this.f20113b = z2;
    }

    public static d a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static d a(byte[] bArr, int i2, int i3) {
        return a(bArr, i2, i3, false);
    }

    static d a(byte[] bArr, int i2, int i3, boolean z2) {
        d dVar = new d(bArr, i2, i3, z2);
        try {
            dVar.c(i3);
            return dVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private void f(int i2) throws IOException {
        if (!g(i2)) {
            throw InvalidProtocolBufferException.a();
        }
    }

    private boolean g(int i2) throws IOException {
        int i3 = this.f20116e;
        if (i3 + i2 <= this.f20114c) {
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        } else if (this.f20120i + i3 + i2 > this.f20121j) {
            return false;
        } else {
            a aVar = this.f20125n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f20117f != null) {
                int i4 = this.f20116e;
                if (i4 > 0) {
                    int i5 = this.f20114c;
                    if (i5 > i4) {
                        byte[] bArr = this.f20112a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.f20120i += i4;
                    this.f20114c -= i4;
                    this.f20116e = 0;
                }
                InputStream inputStream = this.f20117f;
                byte[] bArr2 = this.f20112a;
                int i6 = this.f20114c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.f20112a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.f20114c += read;
                    if ((this.f20120i + i2) - this.f20124m <= 0) {
                        m();
                        if (this.f20114c >= i2) {
                            return true;
                        }
                        return g(i2);
                    }
                    throw InvalidProtocolBufferException.h();
                }
            }
            return false;
        }
    }

    private byte[] h(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.f20120i;
            int i4 = this.f20116e;
            int i5 = i3 + i4 + i2;
            if (i5 <= this.f20124m) {
                int i6 = this.f20121j;
                if (i5 <= i6) {
                    InputStream inputStream = this.f20117f;
                    if (inputStream != null) {
                        int i7 = this.f20114c;
                        int i8 = i7 - i4;
                        this.f20120i = i3 + i7;
                        this.f20116e = 0;
                        this.f20114c = 0;
                        int i9 = i2 - i8;
                        if (i9 < 4096 || i9 <= inputStream.available()) {
                            byte[] bArr = new byte[i2];
                            System.arraycopy(this.f20112a, i4, bArr, 0, i8);
                            while (i8 < i2) {
                                int read = this.f20117f.read(bArr, i8, i2 - i8);
                                if (read != -1) {
                                    this.f20120i += read;
                                    i8 += read;
                                } else {
                                    throw InvalidProtocolBufferException.a();
                                }
                            }
                            return bArr;
                        }
                        ArrayList<byte[]> arrayList = new ArrayList<>();
                        while (i9 > 0) {
                            int min = Math.min(i9, 4096);
                            byte[] bArr2 = new byte[min];
                            int i10 = 0;
                            while (i10 < min) {
                                int read2 = this.f20117f.read(bArr2, i10, min - i10);
                                if (read2 != -1) {
                                    this.f20120i += read2;
                                    i10 += read2;
                                } else {
                                    throw InvalidProtocolBufferException.a();
                                }
                            }
                            i9 -= min;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(this.f20112a, i4, bArr3, 0, i8);
                        for (byte[] bArr4 : arrayList) {
                            System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                            i8 += bArr4.length;
                        }
                        return bArr3;
                    }
                    throw InvalidProtocolBufferException.a();
                }
                e((i6 - i3) - i4);
                throw InvalidProtocolBufferException.a();
            }
            throw InvalidProtocolBufferException.h();
        } else if (i2 == 0) {
            return h.f20139c;
        } else {
            throw InvalidProtocolBufferException.b();
        }
    }

    private void i(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f20120i;
            int i4 = this.f20116e;
            int i5 = i3 + i4 + i2;
            int i6 = this.f20121j;
            if (i5 <= i6) {
                int i7 = this.f20114c;
                int i8 = i7 - i4;
                this.f20116e = i7;
                while (true) {
                    f(1);
                    int i9 = i2 - i8;
                    int i10 = this.f20114c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.f20116e = i10;
                    } else {
                        this.f20116e = i9;
                        return;
                    }
                }
            } else {
                e((i6 - i3) - i4);
                throw InvalidProtocolBufferException.a();
            }
        } else {
            throw InvalidProtocolBufferException.b();
        }
    }

    private void k() throws IOException {
        int i2 = this.f20114c;
        int i3 = this.f20116e;
        if (i2 - i3 >= 10) {
            byte[] bArr = this.f20112a;
            int i4 = 0;
            while (i4 < 10) {
                int i5 = i3 + 1;
                if (bArr[i3] >= 0) {
                    this.f20116e = i5;
                    return;
                } else {
                    i4++;
                    i3 = i5;
                }
            }
        }
        l();
    }

    private void l() throws IOException {
        int i2 = 0;
        while (i2 < 10) {
            if (j() < 0) {
                i2++;
            } else {
                return;
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    private void m() {
        int i2 = this.f20114c + this.f20115d;
        this.f20114c = i2;
        int i3 = this.f20120i + i2;
        int i4 = this.f20121j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f20115d = i5;
            this.f20114c = i2 - i5;
            return;
        }
        this.f20115d = 0;
    }

    public int a() throws IOException {
        if (i()) {
            this.f20118g = 0;
            return 0;
        }
        int g2 = g();
        this.f20118g = g2;
        if (WireFormat.b(g2) != 0) {
            return this.f20118g;
        }
        throw InvalidProtocolBufferException.d();
    }

    public <T extends k> T a(n<T> nVar, f fVar) throws IOException {
        int g2 = g();
        if (this.f20122k < this.f20123l) {
            int c2 = c(g2);
            this.f20122k++;
            T t2 = (k) nVar.b(this, fVar);
            a(0);
            this.f20122k--;
            d(c2);
            return t2;
        }
        throw InvalidProtocolBufferException.g();
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.f20118g != i2) {
            throw InvalidProtocolBufferException.e();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void b() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.a()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.b(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.d.b():void");
    }

    public boolean b(int i2) throws IOException {
        int a2 = WireFormat.a(i2);
        if (a2 == 0) {
            k();
            return true;
        } else if (a2 == 1) {
            e(8);
            return true;
        } else if (a2 == 2) {
            e(g());
            return true;
        } else if (a2 == 3) {
            b();
            a(WireFormat.a(WireFormat.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                e(4);
                return true;
            }
            throw InvalidProtocolBufferException.f();
        }
    }

    public int c() throws IOException {
        return g();
    }

    public int c(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.f20120i + this.f20116e;
            int i4 = this.f20121j;
            if (i3 <= i4) {
                this.f20121j = i3;
                m();
                return i4;
            }
            throw InvalidProtocolBufferException.a();
        }
        throw InvalidProtocolBufferException.b();
    }

    public String d() throws IOException {
        byte[] bArr;
        int g2 = g();
        int i2 = this.f20116e;
        int i3 = this.f20114c;
        if (g2 <= i3 - i2 && g2 > 0) {
            bArr = this.f20112a;
            this.f20116e = i2 + g2;
        } else if (g2 == 0) {
            return "";
        } else {
            if (g2 <= i3) {
                f(g2);
                bArr = this.f20112a;
                this.f20116e = g2 + 0;
            } else {
                bArr = h(g2);
            }
            i2 = 0;
        }
        if (Utf8.a(bArr, i2, i2 + g2)) {
            return new String(bArr, i2, g2, h.f20137a);
        }
        throw InvalidProtocolBufferException.i();
    }

    public void d(int i2) {
        this.f20121j = i2;
        m();
    }

    public ByteString e() throws IOException {
        int g2 = g();
        int i2 = this.f20114c;
        int i3 = this.f20116e;
        if (g2 > i2 - i3 || g2 <= 0) {
            return g2 == 0 ? ByteString.f20030a : ByteString.b(h(g2));
        }
        ByteString a2 = (!this.f20113b || !this.f20119h) ? ByteString.a(this.f20112a, i3, g2) : ByteString.b(this.f20112a, i3, g2);
        this.f20116e += g2;
        return a2;
    }

    public void e(int i2) throws IOException {
        int i3 = this.f20114c;
        int i4 = this.f20116e;
        if (i2 > i3 - i4 || i2 < 0) {
            i(i2);
        } else {
            this.f20116e = i4 + i2;
        }
    }

    public int f() throws IOException {
        return g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2[r3] < 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f20116e
            int r1 = r5.f20114c
            if (r1 != r0) goto L_0x0007
            goto L_0x006a
        L_0x0007:
            byte[] r2 = r5.f20112a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.f20116e = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0018
            goto L_0x006a
        L_0x0018:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0070
        L_0x0024:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r1 = r3
            goto L_0x0070
        L_0x0031:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0070
        L_0x003f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0070
        L_0x006a:
            long r0 = r5.h()
            int r1 = (int) r0
            return r1
        L_0x0070:
            r5.f20116e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.d.g():int");
    }

    /* access modifiers changed from: package-private */
    public long h() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte j3 = j();
            j2 |= ((long) (j3 & Byte.MAX_VALUE)) << i2;
            if ((j3 & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    public boolean i() throws IOException {
        return this.f20116e == this.f20114c && !g(1);
    }

    public byte j() throws IOException {
        if (this.f20116e == this.f20114c) {
            f(1);
        }
        byte[] bArr = this.f20112a;
        int i2 = this.f20116e;
        this.f20116e = i2 + 1;
        return bArr[i2];
    }
}
