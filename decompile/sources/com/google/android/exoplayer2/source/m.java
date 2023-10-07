package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.q;
import fi.e;
import fj.h;
import fj.u;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final b f16462a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16463b;

    /* renamed from: c  reason: collision with root package name */
    private final q f16464c = new q(32);

    /* renamed from: d  reason: collision with root package name */
    private a f16465d;

    /* renamed from: e  reason: collision with root package name */
    private a f16466e;

    /* renamed from: f  reason: collision with root package name */
    private a f16467f;

    /* renamed from: g  reason: collision with root package name */
    private long f16468g;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f16469a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16470b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16471c;

        /* renamed from: d  reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.a f16472d;

        /* renamed from: e  reason: collision with root package name */
        public a f16473e;

        public a(long j2, int i2) {
            this.f16469a = j2;
            this.f16470b = j2 + ((long) i2);
        }

        public int a(long j2) {
            return ((int) (j2 - this.f16469a)) + this.f16472d.f16980b;
        }

        public a a() {
            this.f16472d = null;
            a aVar = this.f16473e;
            this.f16473e = null;
            return aVar;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.f16472d = aVar;
            this.f16473e = aVar2;
            this.f16471c = true;
        }
    }

    public m(b bVar) {
        this.f16462a = bVar;
        int c2 = bVar.c();
        this.f16463b = c2;
        a aVar = new a(0, c2);
        this.f16465d = aVar;
        this.f16466e = aVar;
        this.f16467f = aVar;
    }

    private int a(int i2) {
        if (!this.f16467f.f16471c) {
            this.f16467f.a(this.f16462a.a(), new a(this.f16467f.f16470b, this.f16463b));
        }
        return Math.min(i2, (int) (this.f16467f.f16470b - this.f16468g));
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        c(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.f16466e.f16470b - j2));
            byteBuffer.put(this.f16466e.f16472d.f16979a, this.f16466e.a(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.f16466e.f16470b) {
                this.f16466e = this.f16466e.f16473e;
            }
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        c(j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f16466e.f16470b - j2));
            System.arraycopy(this.f16466e.f16472d.f16979a, this.f16466e.a(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == this.f16466e.f16470b) {
                this.f16466e = this.f16466e.f16473e;
            }
        }
    }

    private void a(a aVar) {
        if (aVar.f16471c) {
            int i2 = (this.f16467f.f16471c ? 1 : 0) + (((int) (this.f16467f.f16469a - aVar.f16469a)) / this.f16463b);
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f16472d;
                aVar = aVar.a();
            }
            this.f16462a.a(aVarArr);
        }
    }

    private void b(int i2) {
        long j2 = this.f16468g + ((long) i2);
        this.f16468g = j2;
        if (j2 == this.f16467f.f16470b) {
            this.f16467f = this.f16467f.f16473e;
        }
    }

    private void b(e eVar, n.a aVar) {
        int i2;
        n.a aVar2 = aVar;
        long j2 = aVar2.f16501b;
        this.f16464c.a(1);
        a(j2, this.f16464c.f17159a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f16464c.f17159a[0];
        boolean z2 = (b2 & 128) != 0;
        byte b3 = b2 & Byte.MAX_VALUE;
        fi.b bVar = eVar.f13098a;
        if (bVar.f27292a == null) {
            bVar.f27292a = new byte[16];
        } else {
            Arrays.fill(bVar.f27292a, (byte) 0);
        }
        a(j3, bVar.f27292a, (int) b3);
        long j4 = j3 + ((long) b3);
        if (z2) {
            this.f16464c.a(2);
            a(j4, this.f16464c.f17159a, 2);
            j4 += 2;
            i2 = this.f16464c.i();
        } else {
            i2 = 1;
        }
        int[] iArr = bVar.f27295d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar.f27296e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i3 = i2 * 6;
            this.f16464c.a(i3);
            a(j4, this.f16464c.f17159a, i3);
            j4 += (long) i3;
            this.f16464c.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.f16464c.i();
                iArr4[i4] = this.f16464c.v();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar2.f16500a - ((int) (j4 - aVar2.f16501b));
        }
        u.a aVar3 = aVar2.f16502c;
        bVar.a(i2, iArr2, iArr4, aVar3.f27410b, bVar.f27292a, aVar3.f27409a, aVar3.f27411c, aVar3.f27412d);
        int i5 = (int) (j4 - aVar2.f16501b);
        aVar2.f16501b += (long) i5;
        aVar2.f16500a -= i5;
    }

    private void c(long j2) {
        while (j2 >= this.f16466e.f16470b) {
            this.f16466e = this.f16466e.f16473e;
        }
    }

    public int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
        int a2 = hVar.a(this.f16467f.f16472d.f16979a, this.f16467f.a(this.f16468g), a(i2));
        if (a2 != -1) {
            b(a2);
            return a2;
        } else if (z2) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void a() {
        a(this.f16465d);
        a aVar = new a(0, this.f16463b);
        this.f16465d = aVar;
        this.f16466e = aVar;
        this.f16467f = aVar;
        this.f16468g = 0;
        this.f16462a.b();
    }

    public void a(long j2) {
        this.f16468g = j2;
        if (j2 == 0 || j2 == this.f16465d.f16469a) {
            a(this.f16465d);
            a aVar = new a(this.f16468g, this.f16463b);
            this.f16465d = aVar;
            this.f16466e = aVar;
            this.f16467f = aVar;
            return;
        }
        a aVar2 = this.f16465d;
        while (this.f16468g > aVar2.f16470b) {
            aVar2 = aVar2.f16473e;
        }
        a aVar3 = aVar2.f16473e;
        a(aVar3);
        aVar2.f16473e = new a(aVar2.f16470b, this.f16463b);
        this.f16467f = this.f16468g == aVar2.f16470b ? aVar2.f16473e : aVar2;
        if (this.f16466e == aVar3) {
            this.f16466e = aVar2.f16473e;
        }
    }

    public void a(q qVar, int i2) {
        while (i2 > 0) {
            int a2 = a(i2);
            qVar.a(this.f16467f.f16472d.f16979a, this.f16467f.a(this.f16468g), a2);
            i2 -= a2;
            b(a2);
        }
    }

    public void a(e eVar, n.a aVar) {
        ByteBuffer byteBuffer;
        long j2;
        if (eVar.c()) {
            b(eVar, aVar);
        }
        if (eVar.hasSupplementalData()) {
            this.f16464c.a(4);
            a(aVar.f16501b, this.f16464c.f17159a, 4);
            int v2 = this.f16464c.v();
            aVar.f16501b += 4;
            aVar.f16500a -= 4;
            eVar.b(v2);
            a(aVar.f16501b, eVar.f13099b, v2);
            aVar.f16501b += (long) v2;
            aVar.f16500a -= v2;
            eVar.a(aVar.f16500a);
            j2 = aVar.f16501b;
            byteBuffer = eVar.f13102e;
        } else {
            eVar.b(aVar.f16500a);
            j2 = aVar.f16501b;
            byteBuffer = eVar.f13099b;
        }
        a(j2, byteBuffer, aVar.f16500a);
    }

    public void b() {
        this.f16466e = this.f16465d;
    }

    public void b(long j2) {
        if (j2 != -1) {
            while (j2 >= this.f16465d.f16470b) {
                this.f16462a.a(this.f16465d.f16472d);
                this.f16465d = this.f16465d.a();
            }
            if (this.f16466e.f16469a < this.f16465d.f16469a) {
                this.f16466e = this.f16465d;
            }
        }
    }

    public long c() {
        return this.f16468g;
    }
}
