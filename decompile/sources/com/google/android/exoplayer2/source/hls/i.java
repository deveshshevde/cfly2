package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ac;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.r;
import ft.l;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class i extends l {

    /* renamed from: m  reason: collision with root package name */
    private static final r f11660m = new r();

    /* renamed from: n  reason: collision with root package name */
    private static final AtomicInteger f11661n = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private g C;
    private boolean D;
    private l E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;

    /* renamed from: a  reason: collision with root package name */
    public final int f11662a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11663b;

    /* renamed from: l  reason: collision with root package name */
    public final Uri f11664l;

    /* renamed from: o  reason: collision with root package name */
    private final f f11665o;

    /* renamed from: p  reason: collision with root package name */
    private final h f11666p;

    /* renamed from: q  reason: collision with root package name */
    private final g f11667q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f11668r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f11669s;

    /* renamed from: t  reason: collision with root package name */
    private final aa f11670t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f11671u;

    /* renamed from: v  reason: collision with root package name */
    private final g f11672v;

    /* renamed from: w  reason: collision with root package name */
    private final List<Format> f11673w;

    /* renamed from: x  reason: collision with root package name */
    private final DrmInitData f11674x;

    /* renamed from: y  reason: collision with root package name */
    private final a f11675y;

    /* renamed from: z  reason: collision with root package name */
    private final q f11676z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private i(g gVar, f fVar, h hVar, Format format, boolean z2, f fVar2, h hVar2, boolean z3, Uri uri, List<Format> list, int i2, Object obj, long j2, long j3, long j4, int i3, boolean z4, boolean z5, aa aaVar, DrmInitData drmInitData, g gVar2, a aVar, q qVar, boolean z6) {
        super(fVar, hVar, format, i2, obj, j2, j3, j4);
        h hVar3 = hVar2;
        this.A = z2;
        this.f11663b = i3;
        this.f11666p = hVar3;
        this.f11665o = fVar2;
        this.G = hVar3 != null;
        this.B = z3;
        this.f11664l = uri;
        this.f11668r = z5;
        this.f11670t = aaVar;
        this.f11669s = z4;
        this.f11672v = gVar;
        this.f11673w = list;
        this.f11674x = drmInitData;
        this.f11667q = gVar2;
        this.f11675y = aVar;
        this.f11676z = qVar;
        this.f11671u = z6;
        this.f11662a = f11661n.getAndIncrement();
    }

    private long a(fj.h hVar) throws IOException, InterruptedException {
        hVar.a();
        try {
            hVar.d(this.f11676z.f17159a, 0, 10);
            this.f11676z.a(10);
            if (this.f11676z.l() != 4801587) {
                return -9223372036854775807L;
            }
            this.f11676z.d(3);
            int u2 = this.f11676z.u();
            int i2 = u2 + 10;
            if (i2 > this.f11676z.e()) {
                byte[] bArr = this.f11676z.f17159a;
                this.f11676z.a(i2);
                System.arraycopy(bArr, 0, this.f11676z.f17159a, 0, 10);
            }
            hVar.d(this.f11676z.f17159a, 10, u2);
            Metadata a2 = this.f11675y.a(this.f11676z.f17159a, u2);
            if (a2 == null) {
                return -9223372036854775807L;
            }
            int a3 = a2.a();
            for (int i3 = 0; i3 < a3; i3++) {
                Metadata.Entry a4 = a2.a(i3);
                if (a4 instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) a4;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f15919a)) {
                        System.arraycopy(privFrame.f15920b, 0, this.f11676z.f17159a, 0, 8);
                        this.f11676z.a(8);
                        return this.f11676z.r() & 8589934591L;
                    }
                }
            }
            return -9223372036854775807L;
        } catch (EOFException unused) {
        }
    }

    public static i a(g gVar, f fVar, Format format, long j2, d dVar, int i2, Uri uri, List<Format> list, int i3, Object obj, boolean z2, m mVar, i iVar, byte[] bArr, byte[] bArr2) {
        f fVar2;
        boolean z3;
        h hVar;
        boolean z4;
        q qVar;
        a aVar;
        g gVar2;
        f fVar3 = fVar;
        d dVar2 = dVar;
        int i4 = i2;
        i iVar2 = iVar;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        d.a aVar2 = dVar2.f16324l.get(i4);
        h hVar2 = new h(ac.a(dVar2.f16338n, aVar2.f16326a), aVar2.f16335j, aVar2.f16336k, (String) null);
        boolean z5 = bArr3 != null;
        f a2 = a(fVar3, bArr3, z5 ? a((String) com.google.android.exoplayer2.util.a.b(aVar2.f16334i)) : null);
        d.a aVar3 = aVar2.f16327b;
        if (aVar3 != null) {
            boolean z6 = bArr4 != null;
            byte[] a3 = z6 ? a((String) com.google.android.exoplayer2.util.a.b(aVar3.f16334i)) : null;
            h hVar3 = new h(ac.a(dVar2.f16338n, aVar3.f16326a), aVar3.f16335j, aVar3.f16336k, (String) null);
            f a4 = a(fVar3, bArr4, a3);
            z3 = z6;
            fVar2 = a4;
            hVar = hVar3;
        } else {
            hVar = null;
            z3 = false;
            fVar2 = null;
        }
        long j3 = j2 + aVar2.f16331f;
        long j4 = j3 + aVar2.f16328c;
        int i5 = dVar2.f16317e + aVar2.f16330e;
        if (iVar2 != null) {
            a aVar4 = iVar2.f11675y;
            q qVar2 = iVar2.f11676z;
            boolean z7 = !uri.equals(iVar2.f11664l) || !iVar2.I;
            aVar = aVar4;
            qVar = qVar2;
            gVar2 = (!iVar2.D || iVar2.f11663b != i5 || z7) ? null : iVar2.C;
            z4 = z7;
        } else {
            Uri uri2 = uri;
            aVar = new a();
            qVar = new q(10);
            gVar2 = null;
            z4 = false;
        }
        return new i(gVar, a2, hVar2, format, z5, fVar2, hVar, z3, uri, list, i3, obj, j3, j4, dVar2.f16318f + ((long) i4), i5, aVar2.f16337l, z2, mVar.a(i5), aVar2.f16332g, gVar2, aVar, qVar, z4);
    }

    private static f a(f fVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return fVar;
        }
        com.google.android.exoplayer2.util.a.b(bArr2);
        return new a(fVar, bArr, bArr2);
    }

    @RequiresNonNull({"output"})
    @EnsuresNonNull({"extractor"})
    private fj.d a(f fVar, h hVar) throws IOException, InterruptedException {
        fj.d dVar;
        h hVar2 = hVar;
        fj.d dVar2 = new fj.d(fVar, hVar2.f16999e, fVar.a(hVar));
        if (this.C == null) {
            long a2 = a((fj.h) dVar2);
            dVar2.a();
            dVar = dVar2;
            g.a a3 = this.f11672v.a(this.f11667q, hVar2.f16995a, this.f13112e, this.f11673w, this.f11670t, fVar.b(), dVar2);
            this.C = a3.f16221a;
            this.D = a3.f16223c;
            if (a3.f16222b) {
                this.E.b(a2 != -9223372036854775807L ? this.f11670t.b(a2) : this.f13115h);
            } else {
                this.E.b(0);
            }
            this.E.k();
            this.C.a((fj.i) this.E);
        } else {
            dVar = dVar2;
        }
        this.E.a(this.f11674x);
        return dVar;
    }

    @RequiresNonNull({"output"})
    private void a(f fVar, h hVar, boolean z2) throws IOException, InterruptedException {
        h hVar2;
        boolean z3;
        fj.d a2;
        int i2 = 0;
        if (z2) {
            z3 = this.F != 0;
            hVar2 = hVar;
        } else {
            hVar2 = hVar.a((long) this.F);
            z3 = false;
        }
        try {
            a2 = a(fVar, hVar2);
            if (z3) {
                a2.b(this.F);
            }
            while (i2 == 0) {
                if (this.H) {
                    break;
                }
                i2 = this.C.a((fj.h) a2, f11660m);
            }
            this.F = (int) (a2.c() - hVar.f16999e);
            ad.a(fVar);
        } catch (Throwable th) {
            ad.a(fVar);
            throw th;
        }
    }

    private static byte[] a(String str) {
        if (ad.d(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @RequiresNonNull({"output"})
    private void c() throws IOException, InterruptedException {
        if (this.G) {
            com.google.android.exoplayer2.util.a.b(this.f11665o);
            com.google.android.exoplayer2.util.a.b(this.f11666p);
            a(this.f11665o, this.f11666p, this.B);
            this.F = 0;
            this.G = false;
        }
    }

    @RequiresNonNull({"output"})
    private void j() throws IOException, InterruptedException {
        if (!this.f11668r) {
            this.f11670t.e();
        } else if (this.f11670t.a() == Long.MAX_VALUE) {
            this.f11670t.a(this.f13115h);
        }
        a((f) this.f13117j, this.f13110c, this.A);
    }

    public void a() {
        this.H = true;
    }

    public void a(l lVar) {
        this.E = lVar;
        lVar.a(this.f11662a, this.f11671u);
    }

    public void b() throws IOException, InterruptedException {
        fj.g gVar;
        com.google.android.exoplayer2.util.a.b(this.E);
        if (this.C == null && (gVar = this.f11667q) != null) {
            this.C = gVar;
            this.D = true;
            this.G = false;
        }
        c();
        if (!this.H) {
            if (!this.f11669s) {
                j();
            }
            this.I = true;
        }
    }

    public boolean i() {
        return this.I;
    }
}
