package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17004a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17005b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f17006c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f17007d;

    /* renamed from: e  reason: collision with root package name */
    private int f17008e;

    /* renamed from: f  reason: collision with root package name */
    private int f17009f;

    /* renamed from: g  reason: collision with root package name */
    private int f17010g;

    /* renamed from: h  reason: collision with root package name */
    private a[] f17011h;

    public i(boolean z2, int i2) {
        this(z2, i2, 0);
    }

    public i(boolean z2, int i2, int i3) {
        a.a(i2 > 0);
        a.a(i3 >= 0);
        this.f17004a = z2;
        this.f17005b = i2;
        this.f17010g = i3;
        this.f17011h = new a[(i3 + 100)];
        if (i3 > 0) {
            this.f17006c = new byte[(i3 * i2)];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f17011h[i4] = new a(this.f17006c, i4 * i2);
            }
        } else {
            this.f17006c = null;
        }
        this.f17007d = new a[1];
    }

    public synchronized a a() {
        a aVar;
        this.f17009f++;
        int i2 = this.f17010g;
        if (i2 > 0) {
            a[] aVarArr = this.f17011h;
            int i3 = i2 - 1;
            this.f17010g = i3;
            aVar = aVarArr[i3];
            aVarArr[i3] = null;
        } else {
            aVar = new a(new byte[this.f17005b], 0);
        }
        return aVar;
    }

    public synchronized void a(int i2) {
        boolean z2 = i2 < this.f17008e;
        this.f17008e = i2;
        if (z2) {
            b();
        }
    }

    public synchronized void a(a aVar) {
        a[] aVarArr = this.f17007d;
        aVarArr[0] = aVar;
        a(aVarArr);
    }

    public synchronized void a(a[] aVarArr) {
        int i2 = this.f17010g;
        int length = aVarArr.length + i2;
        a[] aVarArr2 = this.f17011h;
        if (length >= aVarArr2.length) {
            this.f17011h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i2 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a[] aVarArr3 = this.f17011h;
            int i3 = this.f17010g;
            this.f17010g = i3 + 1;
            aVarArr3[i3] = aVar;
        }
        this.f17009f -= aVarArr.length;
        notifyAll();
    }

    public synchronized void b() {
        int i2 = 0;
        int max = Math.max(0, ad.a(this.f17008e, this.f17005b) - this.f17009f);
        int i3 = this.f17010g;
        if (max < i3) {
            if (this.f17006c != null) {
                int i4 = i3 - 1;
                while (i2 <= i4) {
                    a aVar = this.f17011h[i2];
                    if (aVar.f16979a == this.f17006c) {
                        i2++;
                    } else {
                        a aVar2 = this.f17011h[i4];
                        if (aVar2.f16979a != this.f17006c) {
                            i4--;
                        } else {
                            a[] aVarArr = this.f17011h;
                            aVarArr[i2] = aVar2;
                            aVarArr[i4] = aVar;
                            i4--;
                            i2++;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.f17010g) {
                    return;
                }
            }
            Arrays.fill(this.f17011h, max, this.f17010g, (Object) null);
            this.f17010g = max;
        }
    }

    public int c() {
        return this.f17005b;
    }

    public synchronized void d() {
        if (this.f17004a) {
            a(0);
        }
    }

    public synchronized int e() {
        return this.f17009f * this.f17005b;
    }
}
