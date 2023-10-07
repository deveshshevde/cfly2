package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fj.u;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f15555a = $$Lambda$e$hoPVGqQOqoIgJHL1KCCcClOQ.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f15556b = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: c  reason: collision with root package name */
    private static final Format f15557c = Format.a((String) null, "application/x-emsg", Long.MAX_VALUE);
    private long A;
    private long B;
    private b C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private i H;
    private u[] I;
    private u[] J;
    private boolean K;

    /* renamed from: d  reason: collision with root package name */
    private final int f15558d;

    /* renamed from: e  reason: collision with root package name */
    private final j f15559e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Format> f15560f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray<b> f15561g;

    /* renamed from: h  reason: collision with root package name */
    private final q f15562h;

    /* renamed from: i  reason: collision with root package name */
    private final q f15563i;

    /* renamed from: j  reason: collision with root package name */
    private final q f15564j;

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f15565k;

    /* renamed from: l  reason: collision with root package name */
    private final q f15566l;

    /* renamed from: m  reason: collision with root package name */
    private final aa f15567m;

    /* renamed from: n  reason: collision with root package name */
    private final com.google.android.exoplayer2.metadata.emsg.b f15568n;

    /* renamed from: o  reason: collision with root package name */
    private final q f15569o;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayDeque<a.C0110a> f15570p;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayDeque<a> f15571q;

    /* renamed from: r  reason: collision with root package name */
    private final u f15572r;

    /* renamed from: s  reason: collision with root package name */
    private int f15573s;

    /* renamed from: t  reason: collision with root package name */
    private int f15574t;

    /* renamed from: u  reason: collision with root package name */
    private long f15575u;

    /* renamed from: v  reason: collision with root package name */
    private int f15576v;

    /* renamed from: w  reason: collision with root package name */
    private q f15577w;

    /* renamed from: x  reason: collision with root package name */
    private long f15578x;

    /* renamed from: y  reason: collision with root package name */
    private int f15579y;

    /* renamed from: z  reason: collision with root package name */
    private long f15580z;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f15581a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15582b;

        public a(long j2, int i2) {
            this.f15581a = j2;
            this.f15582b = i2;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final u f15583a;

        /* renamed from: b  reason: collision with root package name */
        public final l f15584b = new l();

        /* renamed from: c  reason: collision with root package name */
        public final q f15585c = new q();

        /* renamed from: d  reason: collision with root package name */
        public j f15586d;

        /* renamed from: e  reason: collision with root package name */
        public c f15587e;

        /* renamed from: f  reason: collision with root package name */
        public int f15588f;

        /* renamed from: g  reason: collision with root package name */
        public int f15589g;

        /* renamed from: h  reason: collision with root package name */
        public int f15590h;

        /* renamed from: i  reason: collision with root package name */
        public int f15591i;

        /* renamed from: j  reason: collision with root package name */
        private final q f15592j = new q(1);

        /* renamed from: k  reason: collision with root package name */
        private final q f15593k = new q();

        public b(u uVar) {
            this.f15583a = uVar;
        }

        /* access modifiers changed from: private */
        public void c() {
            k d2 = d();
            if (d2 != null) {
                q qVar = this.f15584b.f15657q;
                if (d2.f15639d != 0) {
                    qVar.d(d2.f15639d);
                }
                if (this.f15584b.c(this.f15588f)) {
                    qVar.d(qVar.i() * 6);
                }
            }
        }

        /* access modifiers changed from: private */
        public k d() {
            k a2 = this.f15584b.f15655o != null ? this.f15584b.f15655o : this.f15586d.a(this.f15584b.f15641a.f15545a);
            if (a2 == null || !a2.f15636a) {
                return null;
            }
            return a2;
        }

        public int a(int i2, int i3) {
            q qVar;
            int i4;
            k d2 = d();
            if (d2 == null) {
                return 0;
            }
            if (d2.f15639d != 0) {
                qVar = this.f15584b.f15657q;
                i4 = d2.f15639d;
            } else {
                byte[] bArr = d2.f15640e;
                this.f15593k.a(bArr, bArr.length);
                qVar = this.f15593k;
                i4 = bArr.length;
            }
            boolean c2 = this.f15584b.c(this.f15588f);
            boolean z2 = c2 || i3 != 0;
            this.f15592j.f17159a[0] = (byte) ((z2 ? 128 : 0) | i4);
            this.f15592j.c(0);
            this.f15583a.a(this.f15592j, 1);
            this.f15583a.a(qVar, i4);
            if (!z2) {
                return i4 + 1;
            }
            if (!c2) {
                this.f15585c.a(8);
                this.f15585c.f17159a[0] = 0;
                this.f15585c.f17159a[1] = 1;
                this.f15585c.f17159a[2] = (byte) ((i3 >> 8) & 255);
                this.f15585c.f17159a[3] = (byte) (i3 & 255);
                this.f15585c.f17159a[4] = (byte) ((i2 >> 24) & 255);
                this.f15585c.f17159a[5] = (byte) ((i2 >> 16) & 255);
                this.f15585c.f17159a[6] = (byte) ((i2 >> 8) & 255);
                this.f15585c.f17159a[7] = (byte) (i2 & 255);
                this.f15583a.a(this.f15585c, 8);
                return i4 + 1 + 8;
            }
            q qVar2 = this.f15584b.f15657q;
            int i5 = qVar2.i();
            qVar2.d(-2);
            int i6 = (i5 * 6) + 2;
            if (i3 != 0) {
                this.f15585c.a(i6);
                this.f15585c.a(qVar2.f17159a, 0, i6);
                qVar2.d(i6);
                int i7 = (((this.f15585c.f17159a[2] & 255) << 8) | (this.f15585c.f17159a[3] & 255)) + i3;
                this.f15585c.f17159a[2] = (byte) ((i7 >> 8) & 255);
                this.f15585c.f17159a[3] = (byte) (i7 & 255);
                qVar2 = this.f15585c;
            }
            this.f15583a.a(qVar2, i6);
            return i4 + 1 + i6;
        }

        public void a() {
            this.f15584b.a();
            this.f15588f = 0;
            this.f15590h = 0;
            this.f15589g = 0;
            this.f15591i = 0;
        }

        public void a(long j2) {
            int i2 = this.f15588f;
            while (i2 < this.f15584b.f15646f && this.f15584b.b(i2) < j2) {
                if (this.f15584b.f15652l[i2]) {
                    this.f15591i = i2;
                }
                i2++;
            }
        }

        public void a(DrmInitData drmInitData) {
            k a2 = this.f15586d.a(this.f15584b.f15641a.f15545a);
            this.f15583a.a(this.f15586d.f15630f.a(drmInitData.a(a2 != null ? a2.f15637b : null)));
        }

        public void a(j jVar, c cVar) {
            this.f15586d = (j) com.google.android.exoplayer2.util.a.b(jVar);
            this.f15587e = (c) com.google.android.exoplayer2.util.a.b(cVar);
            this.f15583a.a(jVar.f15630f);
            a();
        }

        public boolean b() {
            this.f15588f++;
            int i2 = this.f15589g + 1;
            this.f15589g = i2;
            int[] iArr = this.f15584b.f15648h;
            int i3 = this.f15590h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f15590h = i3 + 1;
            this.f15589g = 0;
            return false;
        }
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, (aa) null);
    }

    public e(int i2, aa aaVar) {
        this(i2, aaVar, (j) null, Collections.emptyList());
    }

    public e(int i2, aa aaVar, j jVar) {
        this(i2, aaVar, jVar, Collections.emptyList());
    }

    public e(int i2, aa aaVar, j jVar, List<Format> list) {
        this(i2, aaVar, jVar, list, (u) null);
    }

    public e(int i2, aa aaVar, j jVar, List<Format> list, u uVar) {
        this.f15558d = i2 | (jVar != null ? 8 : 0);
        this.f15567m = aaVar;
        this.f15559e = jVar;
        this.f15560f = Collections.unmodifiableList(list);
        this.f15572r = uVar;
        this.f15568n = new com.google.android.exoplayer2.metadata.emsg.b();
        this.f15569o = new q(16);
        this.f15562h = new q(o.f17135a);
        this.f15563i = new q(5);
        this.f15564j = new q();
        byte[] bArr = new byte[16];
        this.f15565k = bArr;
        this.f15566l = new q(bArr);
        this.f15570p = new ArrayDeque<>();
        this.f15571q = new ArrayDeque<>();
        this.f15561g = new SparseArray<>();
        this.A = -9223372036854775807L;
        this.f15580z = -9223372036854775807L;
        this.B = -9223372036854775807L;
        a();
    }

    private static int a(int i2) throws ParserException {
        if (i2 >= 0) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected negtive value: ");
        sb.append(i2);
        throw new ParserException(sb.toString());
    }

    private static int a(b bVar, int i2, long j2, int i3, q qVar, int i4) throws ParserException {
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        b bVar2 = bVar;
        qVar.c(8);
        int b2 = a.b(qVar.p());
        j jVar = bVar2.f15586d;
        l lVar = bVar2.f15584b;
        c cVar = lVar.f15641a;
        lVar.f15648h[i2] = qVar.v();
        lVar.f15647g[i2] = lVar.f15643c;
        if ((b2 & 1) != 0) {
            long[] jArr = lVar.f15647g;
            jArr[i2] = jArr[i2] + ((long) qVar.p());
        }
        boolean z6 = (b2 & 4) != 0;
        int i7 = cVar.f15548d;
        if (z6) {
            i7 = qVar.p();
        }
        boolean z7 = (b2 & 256) != 0;
        boolean z8 = (b2 & 512) != 0;
        boolean z9 = (b2 & 1024) != 0;
        boolean z10 = (b2 & 2048) != 0;
        long j3 = 0;
        if (jVar.f15632h != null && jVar.f15632h.length == 1 && jVar.f15632h[0] == 0) {
            j3 = ad.d(jVar.f15633i[0], 1000000, jVar.f15627c);
        }
        int[] iArr = lVar.f15649i;
        int[] iArr2 = lVar.f15650j;
        long[] jArr2 = lVar.f15651k;
        boolean[] zArr = lVar.f15652l;
        int i8 = i7;
        boolean z11 = jVar.f15626b == 2 && (i3 & 1) != 0;
        int i9 = i4 + lVar.f15648h[i2];
        long j4 = jVar.f15627c;
        long j5 = j3;
        boolean[] zArr2 = zArr;
        long j6 = i2 > 0 ? lVar.f15659s : j2;
        int i10 = i4;
        while (i10 < i9) {
            int a2 = a(z7 ? qVar.p() : cVar.f15546b);
            if (z8) {
                i5 = qVar.p();
                z2 = z7;
            } else {
                z2 = z7;
                i5 = cVar.f15547c;
            }
            int a3 = a(i5);
            if (i10 == 0 && z6) {
                z3 = z6;
                i6 = i8;
            } else if (z9) {
                z3 = z6;
                i6 = qVar.p();
            } else {
                z3 = z6;
                i6 = cVar.f15548d;
            }
            boolean z12 = z10;
            if (z10) {
                z5 = z8;
                z4 = z9;
                iArr2[i10] = (int) ((((long) qVar.p()) * 1000000) / j4);
            } else {
                z5 = z8;
                z4 = z9;
                iArr2[i10] = 0;
            }
            jArr2[i10] = ad.d(j6, 1000000, j4) - j5;
            iArr[i10] = a3;
            zArr2[i10] = ((i6 >> 16) & 1) == 0 && (!z11 || i10 == 0);
            i10++;
            j6 += (long) a2;
            j4 = j4;
            z7 = z2;
            z6 = z3;
            z10 = z12;
            z8 = z5;
            z9 = z4;
        }
        lVar.f15659s = j6;
        return i9;
    }

    private static Pair<Long, fj.b> a(q qVar, long j2) throws ParserException {
        long j3;
        long j4;
        q qVar2 = qVar;
        qVar2.c(8);
        int a2 = a.a(qVar.p());
        qVar2.d(4);
        long n2 = qVar.n();
        if (a2 == 0) {
            j4 = qVar.n();
            j3 = qVar.n();
        } else {
            j4 = qVar.x();
            j3 = qVar.x();
        }
        long j5 = j4;
        long j6 = j2 + j3;
        long d2 = ad.d(j5, 1000000, n2);
        qVar2.d(2);
        int i2 = qVar.i();
        int[] iArr = new int[i2];
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        long[] jArr3 = new long[i2];
        long j7 = j5;
        long j8 = d2;
        int i3 = 0;
        while (i3 < i2) {
            int p2 = qVar.p();
            if ((p2 & Integer.MIN_VALUE) == 0) {
                long n3 = qVar.n();
                iArr[i3] = p2 & SubsamplingScaleImageView.TILE_SIZE_AUTO;
                jArr[i3] = j6;
                jArr3[i3] = j8;
                long j9 = j7 + n3;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i4 = i2;
                int[] iArr2 = iArr;
                long d3 = ad.d(j9, 1000000, n2);
                jArr4[i3] = d3 - jArr5[i3];
                qVar2.d(4);
                j6 += (long) iArr2[i3];
                i3++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                i2 = i4;
                long j10 = d3;
                j7 = j9;
                j8 = j10;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(d2), new fj.b(iArr, jArr, jArr2, jArr3));
    }

    private static DrmInitData a(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.f15515a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f15519b.f17159a;
                UUID a2 = h.a(bArr);
                if (a2 == null) {
                    com.google.android.exoplayer2.util.k.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.c>, android.util.SparseArray] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.extractor.mp4.c a(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.c> r3, int r4) {
        /*
            r2 = this;
            int r0 = r3.size()
            r1 = 1
            if (r0 != r1) goto L_0x000f
            r4 = 0
            java.lang.Object r3 = r3.valueAt(r4)
        L_0x000c:
            com.google.android.exoplayer2.extractor.mp4.c r3 = (com.google.android.exoplayer2.extractor.mp4.c) r3
            return r3
        L_0x000f:
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.extractor.mp4.c r3 = (com.google.android.exoplayer2.extractor.mp4.c) r3
            java.lang.Object r3 = com.google.android.exoplayer2.util.a.b(r3)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.e.a(android.util.SparseArray, int):com.google.android.exoplayer2.extractor.mp4.c");
    }

    private static b a(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = sparseArray.valueAt(i2);
            if (valueAt.f15590h != valueAt.f15584b.f15645e) {
                long j3 = valueAt.f15584b.f15647g[valueAt.f15590h];
                if (j3 < j2) {
                    bVar = valueAt;
                    j2 = j3;
                }
            }
        }
        return bVar;
    }

    private static b a(q qVar, SparseArray<b> sparseArray) {
        qVar.c(8);
        int b2 = a.b(qVar.p());
        b b3 = b(sparseArray, qVar.p());
        if (b3 == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long x2 = qVar.x();
            b3.f15584b.f15643c = x2;
            b3.f15584b.f15644d = x2;
        }
        c cVar = b3.f15587e;
        b3.f15584b.f15641a = new c((b2 & 2) != 0 ? qVar.p() - 1 : cVar.f15545a, (b2 & 8) != 0 ? qVar.p() : cVar.f15546b, (b2 & 16) != 0 ? qVar.p() : cVar.f15547c, (b2 & 32) != 0 ? qVar.p() : cVar.f15548d);
        return b3;
    }

    private void a() {
        this.f15573s = 0;
        this.f15576v = 0;
    }

    private void a(long j2) throws ParserException {
        while (!this.f15570p.isEmpty() && this.f15570p.peek().f15516b == j2) {
            a(this.f15570p.pop());
        }
        a();
    }

    private void a(a.C0110a aVar) throws ParserException {
        if (aVar.f15515a == 1836019574) {
            b(aVar);
        } else if (aVar.f15515a == 1836019558) {
            c(aVar);
        } else if (!this.f15570p.isEmpty()) {
            this.f15570p.peek().a(aVar);
        }
    }

    private static void a(a.C0110a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ParserException {
        int size = aVar.f15518d.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0110a aVar2 = aVar.f15518d.get(i3);
            if (aVar2.f15515a == 1953653094) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void a(a.C0110a aVar, b bVar, long j2, int i2) throws ParserException {
        b bVar2 = bVar;
        List<a.b> list = aVar.f15517c;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar3 = list.get(i5);
            if (bVar3.f15515a == 1953658222) {
                q qVar = bVar3.f15519b;
                qVar.c(12);
                int v2 = qVar.v();
                if (v2 > 0) {
                    i4 += v2;
                    i3++;
                }
            }
        }
        bVar2.f15590h = 0;
        bVar2.f15589g = 0;
        bVar2.f15588f = 0;
        bVar2.f15584b.a(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            a.b bVar4 = list.get(i8);
            if (bVar4.f15515a == 1953658222) {
                i7 = a(bVar, i6, j2, i2, bVar4.f15519b, i7);
                i6++;
            }
        }
    }

    private void a(a.b bVar, long j2) throws ParserException {
        if (!this.f15570p.isEmpty()) {
            this.f15570p.peek().a(bVar);
        } else if (bVar.f15515a == 1936286840) {
            Pair<Long, fj.b> a2 = a(bVar.f15519b, j2);
            this.B = ((Long) a2.first).longValue();
            this.H.a((s) a2.second);
            this.K = true;
        } else if (bVar.f15515a == 1701671783) {
            a(bVar.f15519b);
        }
    }

    private static void a(k kVar, q qVar, l lVar) throws ParserException {
        int i2;
        int i3 = kVar.f15639d;
        qVar.c(8);
        boolean z2 = true;
        if ((a.b(qVar.p()) & 1) == 1) {
            qVar.d(8);
        }
        int h2 = qVar.h();
        int v2 = qVar.v();
        if (v2 == lVar.f15646f) {
            if (h2 == 0) {
                boolean[] zArr = lVar.f15654n;
                i2 = 0;
                for (int i4 = 0; i4 < v2; i4++) {
                    int h3 = qVar.h();
                    i2 += h3;
                    zArr[i4] = h3 > i3;
                }
            } else {
                if (h2 <= i3) {
                    z2 = false;
                }
                i2 = (h2 * v2) + 0;
                Arrays.fill(lVar.f15654n, 0, v2, z2);
            }
            lVar.a(i2);
            return;
        }
        int i5 = lVar.f15646f;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Length mismatch: ");
        sb.append(v2);
        sb.append(", ");
        sb.append(i5);
        throw new ParserException(sb.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.util.q r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            fj.u[] r2 = r0.I
            if (r2 == 0) goto L_0x012d
            int r2 = r2.length
            if (r2 != 0) goto L_0x000d
            goto L_0x012d
        L_0x000d:
            r2 = 8
            r1.c(r2)
            int r2 = r27.p()
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.a(r2)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0079
            r5 = 1
            if (r2 == r5) goto L_0x003d
            r1 = 46
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Skipping unsupported emsg version: "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            com.google.android.exoplayer2.util.k.c(r2, r1)
            return
        L_0x003d:
            long r11 = r27.n()
            long r5 = r27.x()
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r11
            long r13 = com.google.android.exoplayer2.util.ad.d(r5, r7, r9)
            long r5 = r27.n()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = com.google.android.exoplayer2.util.ad.d(r5, r7, r9)
            long r7 = r27.n()
            java.lang.String r2 = r27.A()
            java.lang.Object r2 = com.google.android.exoplayer2.util.a.b(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r9 = r27.A()
            java.lang.Object r9 = com.google.android.exoplayer2.util.a.b(r9)
            java.lang.String r9 = (java.lang.String) r9
            r19 = r2
            r21 = r5
            r23 = r7
            r20 = r9
            r7 = r3
            goto L_0x00c3
        L_0x0079:
            java.lang.String r2 = r27.A()
            java.lang.Object r2 = com.google.android.exoplayer2.util.a.b(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r5 = r27.A()
            java.lang.Object r5 = com.google.android.exoplayer2.util.a.b(r5)
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            long r5 = r27.n()
            long r10 = r27.n()
            r12 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r5
            long r7 = com.google.android.exoplayer2.util.ad.d(r10, r12, r14)
            long r10 = r0.B
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x00a8
            long r10 = r10 + r7
            r16 = r10
            goto L_0x00aa
        L_0x00a8:
            r16 = r3
        L_0x00aa:
            long r10 = r27.n()
            r12 = 1000(0x3e8, double:4.94E-321)
            r14 = r5
            long r5 = com.google.android.exoplayer2.util.ad.d(r10, r12, r14)
            long r10 = r27.n()
            r19 = r2
            r21 = r5
            r20 = r9
            r23 = r10
            r13 = r16
        L_0x00c3:
            int r2 = r27.b()
            byte[] r2 = new byte[r2]
            int r5 = r27.b()
            r6 = 0
            r1.a(r2, r6, r5)
            com.google.android.exoplayer2.metadata.emsg.EventMessage r1 = new com.google.android.exoplayer2.metadata.emsg.EventMessage
            r18 = r1
            r25 = r2
            r18.<init>(r19, r20, r21, r23, r25)
            com.google.android.exoplayer2.util.q r2 = new com.google.android.exoplayer2.util.q
            com.google.android.exoplayer2.metadata.emsg.b r5 = r0.f15568n
            byte[] r1 = r5.a(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.b()
            fj.u[] r5 = r0.I
            int r9 = r5.length
            r10 = 0
        L_0x00ed:
            if (r10 >= r9) goto L_0x00fa
            r11 = r5[r10]
            r2.c(r6)
            r11.a(r2, r1)
            int r10 = r10 + 1
            goto L_0x00ed
        L_0x00fa:
            int r2 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.e$a> r2 = r0.f15571q
            com.google.android.exoplayer2.extractor.mp4.e$a r3 = new com.google.android.exoplayer2.extractor.mp4.e$a
            r3.<init>(r7, r1)
            r2.addLast(r3)
            int r2 = r0.f15579y
            int r2 = r2 + r1
            r0.f15579y = r2
            goto L_0x012d
        L_0x010e:
            com.google.android.exoplayer2.util.aa r2 = r0.f15567m
            if (r2 == 0) goto L_0x0116
            long r13 = r2.c(r13)
        L_0x0116:
            fj.u[] r2 = r0.I
            int r3 = r2.length
        L_0x0119:
            if (r6 >= r3) goto L_0x012d
            r15 = r2[r6]
            r18 = 1
            r20 = 0
            r21 = 0
            r16 = r13
            r19 = r1
            r15.a(r16, r18, r19, r20, r21)
            int r6 = r6 + 1
            goto L_0x0119
        L_0x012d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.e.a(com.google.android.exoplayer2.util.q):void");
    }

    private static void a(q qVar, int i2, l lVar) throws ParserException {
        qVar.c(i2 + 8);
        int b2 = a.b(qVar.p());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int v2 = qVar.v();
            if (v2 == lVar.f15646f) {
                Arrays.fill(lVar.f15654n, 0, v2, z2);
                lVar.a(qVar.b());
                lVar.a(qVar);
                return;
            }
            int i3 = lVar.f15646f;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(v2);
            sb.append(", ");
            sb.append(i3);
            throw new ParserException(sb.toString());
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void a(q qVar, l lVar) throws ParserException {
        qVar.c(8);
        int p2 = qVar.p();
        if ((a.b(p2) & 1) == 1) {
            qVar.d(8);
        }
        int v2 = qVar.v();
        if (v2 == 1) {
            lVar.f15644d += a.a(p2) == 0 ? qVar.n() : qVar.x();
            return;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Unexpected saio entry count: ");
        sb.append(v2);
        throw new ParserException(sb.toString());
    }

    private static void a(q qVar, l lVar, byte[] bArr) throws ParserException {
        qVar.c(8);
        qVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f15556b)) {
            a(qVar, 16, lVar);
        }
    }

    private static void a(q qVar, q qVar2, String str, l lVar) throws ParserException {
        byte[] bArr;
        q qVar3 = qVar;
        q qVar4 = qVar2;
        l lVar2 = lVar;
        qVar3.c(8);
        int p2 = qVar.p();
        if (qVar.p() == 1936025959) {
            if (a.a(p2) == 1) {
                qVar3.d(4);
            }
            if (qVar.p() == 1) {
                qVar4.c(8);
                int p3 = qVar2.p();
                if (qVar2.p() == 1936025959) {
                    int a2 = a.a(p3);
                    if (a2 == 1) {
                        if (qVar2.n() == 0) {
                            throw new ParserException("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (a2 >= 2) {
                        qVar4.d(4);
                    }
                    if (qVar2.n() == 1) {
                        qVar4.d(1);
                        int h2 = qVar2.h();
                        int i2 = (h2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
                        int i3 = h2 & 15;
                        boolean z2 = qVar2.h() == 1;
                        if (z2) {
                            int h3 = qVar2.h();
                            byte[] bArr2 = new byte[16];
                            qVar4.a(bArr2, 0, 16);
                            if (h3 == 0) {
                                int h4 = qVar2.h();
                                byte[] bArr3 = new byte[h4];
                                qVar4.a(bArr3, 0, h4);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            lVar2.f15653m = true;
                            lVar2.f15655o = new k(z2, str, h3, bArr2, i2, i3, bArr);
                            return;
                        }
                        return;
                    }
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Integer, c> b(q qVar) {
        qVar.c(12);
        return Pair.create(Integer.valueOf(qVar.p()), new c(qVar.p() - 1, qVar.p(), qVar.p(), qVar.p()));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.e.b b(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e.b> r2, int r3) {
        /*
            int r0 = r2.size()
            r1 = 1
            if (r0 != r1) goto L_0x000f
            r3 = 0
            java.lang.Object r2 = r2.valueAt(r3)
        L_0x000c:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = (com.google.android.exoplayer2.extractor.mp4.e.b) r2
            return r2
        L_0x000f:
            java.lang.Object r2 = r2.get(r3)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.e.b(android.util.SparseArray, int):com.google.android.exoplayer2.extractor.mp4.e$b");
    }

    private void b() {
        int i2;
        if (this.I == null) {
            u[] uVarArr = new u[2];
            this.I = uVarArr;
            u uVar = this.f15572r;
            if (uVar != null) {
                uVarArr[0] = uVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f15558d & 4) != 0) {
                uVarArr[i2] = this.H.a(this.f15561g.size(), 4);
                i2++;
            }
            u[] uVarArr2 = (u[]) Arrays.copyOf(this.I, i2);
            this.I = uVarArr2;
            for (u a2 : uVarArr2) {
                a2.a(f15557c);
            }
        }
        if (this.J == null) {
            this.J = new u[this.f15560f.size()];
            for (int i3 = 0; i3 < this.J.length; i3++) {
                u a3 = this.H.a(this.f15561g.size() + 1 + i3, 3);
                a3.a(this.f15560f.get(i3));
                this.J[i3] = a3;
            }
        }
    }

    private void b(long j2) {
        while (!this.f15571q.isEmpty()) {
            a removeFirst = this.f15571q.removeFirst();
            this.f15579y -= removeFirst.f15582b;
            long j3 = removeFirst.f15581a + j2;
            aa aaVar = this.f15567m;
            if (aaVar != null) {
                j3 = aaVar.c(j3);
            }
            for (u a2 : this.I) {
                a2.a(j3, 1, removeFirst.f15582b, this.f15579y, (u.a) null);
            }
        }
    }

    private void b(a.C0110a aVar) throws ParserException {
        int i2;
        int i3;
        a.C0110a aVar2 = aVar;
        boolean z2 = true;
        int i4 = 0;
        com.google.android.exoplayer2.util.a.b(this.f15559e == null, "Unexpected moov box.");
        DrmInitData a2 = a(aVar2.f15517c);
        a.C0110a e2 = aVar2.e(1836475768);
        SparseArray sparseArray = new SparseArray();
        int size = e2.f15517c.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar = e2.f15517c.get(i5);
            if (bVar.f15515a == 1953654136) {
                Pair<Integer, c> b2 = b(bVar.f15519b);
                sparseArray.put(((Integer) b2.first).intValue(), (c) b2.second);
            } else if (bVar.f15515a == 1835362404) {
                j2 = c(bVar.f15519b);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar2.f15518d.size();
        int i6 = 0;
        while (i6 < size2) {
            a.C0110a aVar3 = aVar2.f15518d.get(i6);
            if (aVar3.f15515a == 1953653099) {
                i2 = i6;
                i3 = size2;
                j a3 = a(b.a(aVar3, aVar2.d(1836476516), j2, a2, (this.f15558d & 16) != 0, false));
                if (a3 != null) {
                    sparseArray2.put(a3.f15625a, a3);
                }
            } else {
                i2 = i6;
                i3 = size2;
            }
            i6 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.f15561g.size() == 0) {
            while (i4 < size3) {
                j jVar = (j) sparseArray2.valueAt(i4);
                b bVar2 = new b(this.H.a(i4, jVar.f15626b));
                bVar2.a(jVar, a((SparseArray<c>) sparseArray, jVar.f15625a));
                this.f15561g.put(jVar.f15625a, bVar2);
                this.A = Math.max(this.A, jVar.f15629e);
                i4++;
            }
            b();
            this.H.a();
            return;
        }
        if (this.f15561g.size() != size3) {
            z2 = false;
        }
        com.google.android.exoplayer2.util.a.b(z2);
        while (i4 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i4);
            this.f15561g.get(jVar2.f15625a).a(jVar2, a((SparseArray<c>) sparseArray, jVar2.f15625a));
            i4++;
        }
    }

    private static void b(a.C0110a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ParserException {
        b a2 = a(aVar.d(1952868452).f15519b, sparseArray);
        if (a2 != null) {
            l lVar = a2.f15584b;
            long j2 = lVar.f15659s;
            a2.a();
            if (aVar.d(1952867444) != null && (i2 & 2) == 0) {
                j2 = d(aVar.d(1952867444).f15519b);
            }
            a(aVar, a2, j2, i2);
            k a3 = a2.f15586d.a(lVar.f15641a.f15545a);
            a.b d2 = aVar.d(1935763834);
            if (d2 != null) {
                a(a3, d2.f15519b, lVar);
            }
            a.b d3 = aVar.d(1935763823);
            if (d3 != null) {
                a(d3.f15519b, lVar);
            }
            a.b d4 = aVar.d(1936027235);
            if (d4 != null) {
                b(d4.f15519b, lVar);
            }
            a.b d5 = aVar.d(1935828848);
            a.b d6 = aVar.d(1936158820);
            if (!(d5 == null || d6 == null)) {
                a(d5.f15519b, d6.f15519b, a3 != null ? a3.f15637b : null, lVar);
            }
            int size = aVar.f15517c.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.f15517c.get(i3);
                if (bVar.f15515a == 1970628964) {
                    a(bVar.f15519b, lVar, bArr);
                }
            }
        }
    }

    private static void b(q qVar, l lVar) throws ParserException {
        a(qVar, 0, lVar);
    }

    private static boolean b(int i2) {
        return i2 == 1751411826 || i2 == 1835296868 || i2 == 1836476516 || i2 == 1936286840 || i2 == 1937011556 || i2 == 1952867444 || i2 == 1952868452 || i2 == 1953196132 || i2 == 1953654136 || i2 == 1953658222 || i2 == 1886614376 || i2 == 1935763834 || i2 == 1935763823 || i2 == 1936027235 || i2 == 1970628964 || i2 == 1935828848 || i2 == 1936158820 || i2 == 1701606260 || i2 == 1835362404 || i2 == 1701671783;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(fj.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            int r0 = r8.f15576v
            r1 = 8
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x002a
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            byte[] r0 = r0.f17159a
            boolean r0 = r9.a(r0, r2, r1, r3)
            if (r0 != 0) goto L_0x0013
            return r2
        L_0x0013:
            r8.f15576v = r1
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            r0.c(r2)
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            long r4 = r0.n()
            r8.f15575u = r4
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            int r0 = r0.p()
            r8.f15574t = r0
        L_0x002a:
            long r4 = r8.f15575u
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0047
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            byte[] r0 = r0.f17159a
            r9.b(r0, r1, r1)
            int r0 = r8.f15576v
            int r0 = r0 + r1
            r8.f15576v = r0
            com.google.android.exoplayer2.util.q r0 = r8.f15569o
            long r4 = r0.x()
        L_0x0044:
            r8.f15575u = r4
            goto L_0x0077
        L_0x0047:
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0077
            long r4 = r9.d()
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0069
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r0 = r8.f15570p
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0069
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r0 = r8.f15570p
            java.lang.Object r0 = r0.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r0 = (com.google.android.exoplayer2.extractor.mp4.a.C0110a) r0
            long r4 = r0.f15516b
        L_0x0069:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0077
            long r6 = r9.c()
            long r4 = r4 - r6
            int r0 = r8.f15576v
            long r6 = (long) r0
            long r4 = r4 + r6
            goto L_0x0044
        L_0x0077:
            long r4 = r8.f15575u
            int r0 = r8.f15576v
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0149
            long r4 = r9.c()
            int r0 = r8.f15576v
            long r6 = (long) r0
            long r4 = r4 - r6
            int r0 = r8.f15574t
            r6 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r0 != r6) goto L_0x00ab
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r0 = r8.f15561g
            int r0 = r0.size()
            r6 = 0
        L_0x0096:
            if (r6 >= r0) goto L_0x00ab
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r7 = r8.f15561g
            java.lang.Object r7 = r7.valueAt(r6)
            com.google.android.exoplayer2.extractor.mp4.e$b r7 = (com.google.android.exoplayer2.extractor.mp4.e.b) r7
            com.google.android.exoplayer2.extractor.mp4.l r7 = r7.f15584b
            r7.f15642b = r4
            r7.f15644d = r4
            r7.f15643c = r4
            int r6 = r6 + 1
            goto L_0x0096
        L_0x00ab:
            int r0 = r8.f15574t
            r6 = 1835295092(0x6d646174, float:4.4175247E27)
            r7 = 0
            if (r0 != r6) goto L_0x00d0
            r8.C = r7
            long r0 = r8.f15575u
            long r0 = r0 + r4
            r8.f15578x = r0
            boolean r9 = r8.K
            if (r9 != 0) goto L_0x00cc
            fj.i r9 = r8.H
            fj.s$b r0 = new fj.s$b
            long r1 = r8.A
            r0.<init>(r1, r4)
            r9.a(r0)
            r8.K = r3
        L_0x00cc:
            r9 = 2
            r8.f15573s = r9
            return r3
        L_0x00d0:
            boolean r0 = c((int) r0)
            if (r0 == 0) goto L_0x00fd
            long r0 = r9.c()
            long r4 = r8.f15575u
            long r0 = r0 + r4
            r4 = 8
            long r0 = r0 - r4
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r9 = r8.f15570p
            com.google.android.exoplayer2.extractor.mp4.a$a r2 = new com.google.android.exoplayer2.extractor.mp4.a$a
            int r4 = r8.f15574t
            r2.<init>(r4, r0)
            r9.push(r2)
            long r4 = r8.f15575u
            int r9 = r8.f15576v
            long r6 = (long) r9
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x00f9
            r8.a((long) r0)
            goto L_0x0140
        L_0x00f9:
            r8.a()
            goto L_0x0140
        L_0x00fd:
            int r9 = r8.f15574t
            boolean r9 = b((int) r9)
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r9 == 0) goto L_0x0136
            int r9 = r8.f15576v
            if (r9 != r1) goto L_0x012e
            long r6 = r8.f15575u
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x0126
            com.google.android.exoplayer2.util.q r9 = new com.google.android.exoplayer2.util.q
            int r0 = (int) r6
            r9.<init>((int) r0)
            r8.f15577w = r9
            com.google.android.exoplayer2.util.q r9 = r8.f15569o
            byte[] r9 = r9.f17159a
            com.google.android.exoplayer2.util.q r0 = r8.f15577w
            byte[] r0 = r0.f17159a
            java.lang.System.arraycopy(r9, r2, r0, r2, r1)
            goto L_0x013e
        L_0x0126:
            com.google.android.exoplayer2.ParserException r9 = new com.google.android.exoplayer2.ParserException
            java.lang.String r0 = "Leaf atom with length > 2147483647 (unsupported)."
            r9.<init>((java.lang.String) r0)
            throw r9
        L_0x012e:
            com.google.android.exoplayer2.ParserException r9 = new com.google.android.exoplayer2.ParserException
            java.lang.String r0 = "Leaf atom defines extended atom size (unsupported)."
            r9.<init>((java.lang.String) r0)
            throw r9
        L_0x0136:
            long r0 = r8.f15575u
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x0141
            r8.f15577w = r7
        L_0x013e:
            r8.f15573s = r3
        L_0x0140:
            return r3
        L_0x0141:
            com.google.android.exoplayer2.ParserException r9 = new com.google.android.exoplayer2.ParserException
            java.lang.String r0 = "Skipping atom with length > 2147483647 (unsupported)."
            r9.<init>((java.lang.String) r0)
            throw r9
        L_0x0149:
            com.google.android.exoplayer2.ParserException r9 = new com.google.android.exoplayer2.ParserException
            java.lang.String r0 = "Atom size less than header length (unsupported)."
            r9.<init>((java.lang.String) r0)
            goto L_0x0152
        L_0x0151:
            throw r9
        L_0x0152:
            goto L_0x0151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.e.b(fj.h):boolean");
    }

    private static long c(q qVar) {
        qVar.c(8);
        return a.a(qVar.p()) == 0 ? qVar.n() : qVar.x();
    }

    private void c(a.C0110a aVar) throws ParserException {
        a(aVar, this.f15561g, this.f15558d, this.f15565k);
        DrmInitData a2 = a(aVar.f15517c);
        if (a2 != null) {
            int size = this.f15561g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15561g.valueAt(i2).a(a2);
            }
        }
        if (this.f15580z != -9223372036854775807L) {
            int size2 = this.f15561g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f15561g.valueAt(i3).a(this.f15580z);
            }
            this.f15580z = -9223372036854775807L;
        }
    }

    private void c(h hVar) throws IOException, InterruptedException {
        int i2 = ((int) this.f15575u) - this.f15576v;
        q qVar = this.f15577w;
        if (qVar != null) {
            hVar.b(qVar.f17159a, 8, i2);
            a(new a.b(this.f15574t, this.f15577w), hVar.c());
        } else {
            hVar.b(i2);
        }
        a(hVar.c());
    }

    private static boolean c(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1836019558 || i2 == 1953653094 || i2 == 1836475768 || i2 == 1701082227;
    }

    private static long d(q qVar) {
        qVar.c(8);
        return a.a(qVar.p()) == 1 ? qVar.x() : qVar.n();
    }

    private void d(h hVar) throws IOException, InterruptedException {
        int size = this.f15561g.size();
        b bVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.f15561g.valueAt(i2).f15584b;
            if (lVar.f15658r && lVar.f15644d < j2) {
                long j3 = lVar.f15644d;
                bVar = this.f15561g.valueAt(i2);
                j2 = j3;
            }
        }
        if (bVar == null) {
            this.f15573s = 3;
            return;
        }
        int c2 = (int) (j2 - hVar.c());
        if (c2 >= 0) {
            hVar.b(c2);
            bVar.f15584b.a(hVar);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] d() {
        return new g[]{new e()};
    }

    private boolean e(h hVar) throws IOException, InterruptedException {
        u.a aVar;
        boolean z2;
        int i2;
        int i3;
        h hVar2 = hVar;
        int i4 = 4;
        int i5 = 1;
        int i6 = 0;
        if (this.f15573s == 3) {
            if (this.C == null) {
                b a2 = a(this.f15561g);
                if (a2 == null) {
                    int c2 = (int) (this.f15578x - hVar.c());
                    if (c2 >= 0) {
                        hVar2.b(c2);
                        a();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int c3 = (int) (a2.f15584b.f15647g[a2.f15590h] - hVar.c());
                if (c3 < 0) {
                    com.google.android.exoplayer2.util.k.c("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    c3 = 0;
                }
                hVar2.b(c3);
                this.C = a2;
            }
            this.D = this.C.f15584b.f15649i[this.C.f15588f];
            if (this.C.f15588f < this.C.f15591i) {
                hVar2.b(this.D);
                this.C.c();
                if (!this.C.b()) {
                    this.C = null;
                }
                this.f15573s = 3;
                return true;
            }
            if (this.C.f15586d.f15631g == 1) {
                this.D -= 8;
                hVar2.b(8);
            }
            if ("audio/ac4".equals(this.C.f15586d.f15630f.f15092i)) {
                this.E = this.C.a(this.D, 7);
                com.google.android.exoplayer2.audio.b.a(this.D, this.f15566l);
                this.C.f15583a.a(this.f15566l, 7);
                i3 = this.E + 7;
            } else {
                i3 = this.C.a(this.D, 0);
            }
            this.E = i3;
            this.D += this.E;
            this.f15573s = 4;
            this.F = 0;
        }
        l lVar = this.C.f15584b;
        j jVar = this.C.f15586d;
        u uVar = this.C.f15583a;
        int i7 = this.C.f15588f;
        long b2 = lVar.b(i7);
        aa aaVar = this.f15567m;
        if (aaVar != null) {
            b2 = aaVar.c(b2);
        }
        long j2 = b2;
        if (jVar.f15634j == 0) {
            while (true) {
                int i8 = this.E;
                int i9 = this.D;
                if (i8 >= i9) {
                    break;
                }
                this.E += uVar.a(hVar2, i9 - i8, false);
            }
        } else {
            byte[] bArr = this.f15563i.f17159a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i10 = jVar.f15634j + 1;
            int i11 = 4 - jVar.f15634j;
            while (this.E < this.D) {
                int i12 = this.F;
                if (i12 == 0) {
                    hVar2.b(bArr, i11, i10);
                    this.f15563i.c(i6);
                    int p2 = this.f15563i.p();
                    if (p2 >= i5) {
                        this.F = p2 - 1;
                        this.f15562h.c(i6);
                        uVar.a(this.f15562h, i4);
                        uVar.a(this.f15563i, i5);
                        this.G = this.J.length > 0 && o.a(jVar.f15630f.f15092i, bArr[i4]);
                        this.E += 5;
                        this.D += i11;
                    } else {
                        throw new ParserException("Invalid NAL length");
                    }
                } else {
                    if (this.G) {
                        this.f15564j.a(i12);
                        hVar2.b(this.f15564j.f17159a, i6, this.F);
                        uVar.a(this.f15564j, this.F);
                        i2 = this.F;
                        int a3 = o.a(this.f15564j.f17159a, this.f15564j.c());
                        this.f15564j.c("video/hevc".equals(jVar.f15630f.f15092i) ? 1 : 0);
                        this.f15564j.b(a3);
                        fw.g.a(j2, this.f15564j, this.J);
                    } else {
                        i2 = uVar.a(hVar2, i12, false);
                    }
                    this.E += i2;
                    this.F -= i2;
                    i4 = 4;
                    i5 = 1;
                    i6 = 0;
                }
            }
        }
        boolean z3 = lVar.f15652l[i7];
        k b3 = this.C.d();
        if (b3 != null) {
            z2 = z3 | true;
            aVar = b3.f15638c;
        } else {
            z2 = z3;
            aVar = null;
        }
        uVar.a(j2, z2 ? 1 : 0, this.D, 0, aVar);
        b(j2);
        if (!this.C.b()) {
            this.C = null;
        }
        this.f15573s = 3;
        return true;
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f15573s;
            if (i2 != 0) {
                if (i2 == 1) {
                    c(hVar);
                } else if (i2 == 2) {
                    d(hVar);
                } else if (e(hVar)) {
                    return 0;
                }
            } else if (!b(hVar)) {
                return -1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public j a(j jVar) {
        return jVar;
    }

    public void a(long j2, long j3) {
        int size = this.f15561g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15561g.valueAt(i2).a();
        }
        this.f15571q.clear();
        this.f15579y = 0;
        this.f15580z = j3;
        this.f15570p.clear();
        a();
    }

    public void a(i iVar) {
        this.H = iVar;
        j jVar = this.f15559e;
        if (jVar != null) {
            b bVar = new b(iVar.a(0, jVar.f15626b));
            bVar.a(this.f15559e, new c(0, 0, 0, 0));
            this.f15561g.put(0, bVar);
            b();
            this.H.a();
        }
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        return i.a(hVar);
    }

    public void c() {
    }
}
