package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.r;
import fj.s;
import fj.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class k implements h, n.b, Loader.a<a>, Loader.e, i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f16391a = t();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Format f16392b = Format.a("icy", "application/x-icy", Long.MAX_VALUE);
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private long F;
    private long G;
    private boolean H;
    private long I;
    private long J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f16393c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.f f16394d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16395e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16396f;

    /* renamed from: g  reason: collision with root package name */
    private final j.a f16397g;

    /* renamed from: h  reason: collision with root package name */
    private final c f16398h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f16399i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f16400j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final long f16401k;

    /* renamed from: l  reason: collision with root package name */
    private final Loader f16402l = new Loader("Loader:ProgressiveMediaPeriod");

    /* renamed from: m  reason: collision with root package name */
    private final b f16403m;

    /* renamed from: n  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f16404n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f16405o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Runnable f16406p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Handler f16407q;

    /* renamed from: r  reason: collision with root package name */
    private h.a f16408r;

    /* renamed from: s  reason: collision with root package name */
    private s f16409s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public IcyHeaders f16410t;

    /* renamed from: u  reason: collision with root package name */
    private n[] f16411u;

    /* renamed from: v  reason: collision with root package name */
    private f[] f16412v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f16413w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f16414x;

    /* renamed from: y  reason: collision with root package name */
    private d f16415y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f16416z;

    final class a implements g.a, Loader.d {

        /* renamed from: b  reason: collision with root package name */
        private final Uri f16418b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.s f16419c;

        /* renamed from: d  reason: collision with root package name */
        private final b f16420d;

        /* renamed from: e  reason: collision with root package name */
        private final i f16421e;

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.e f16422f;

        /* renamed from: g  reason: collision with root package name */
        private final r f16423g = new r();

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f16424h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f16425i = true;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public long f16426j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f16427k = a(0);
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public long f16428l = -1;

        /* renamed from: m  reason: collision with root package name */
        private u f16429m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f16430n;

        public a(Uri uri, com.google.android.exoplayer2.upstream.f fVar, b bVar, i iVar, com.google.android.exoplayer2.util.e eVar) {
            this.f16418b = uri;
            this.f16419c = new com.google.android.exoplayer2.upstream.s(fVar);
            this.f16420d = bVar;
            this.f16421e = iVar;
            this.f16422f = eVar;
        }

        private com.google.android.exoplayer2.upstream.h a(long j2) {
            return new com.google.android.exoplayer2.upstream.h(this.f16418b, j2, -1, k.this.f16400j, 6, (Map<String, String>) k.f16391a);
        }

        /* access modifiers changed from: private */
        public void a(long j2, long j3) {
            this.f16423g.f27401a = j2;
            this.f16426j = j3;
            this.f16425i = true;
            this.f16430n = false;
        }

        public void a() {
            this.f16424h = true;
        }

        public void a(q qVar) {
            long max = !this.f16430n ? this.f16426j : Math.max(k.this.r(), this.f16426j);
            int b2 = qVar.b();
            u uVar = (u) com.google.android.exoplayer2.util.a.b(this.f16429m);
            uVar.a(qVar, b2);
            uVar.a(max, 1, b2, 0, (u.a) null);
            this.f16430n = true;
        }

        public void b() throws IOException, InterruptedException {
            int i2 = 0;
            while (i2 == 0 && !this.f16424h) {
                fj.d dVar = null;
                try {
                    long j2 = this.f16423g.f27401a;
                    com.google.android.exoplayer2.upstream.h a2 = a(j2);
                    this.f16427k = a2;
                    long a3 = this.f16419c.a(a2);
                    this.f16428l = a3;
                    if (a3 != -1) {
                        this.f16428l = a3 + j2;
                    }
                    Uri uri = (Uri) com.google.android.exoplayer2.util.a.b(this.f16419c.a());
                    IcyHeaders unused = k.this.f16410t = IcyHeaders.a(this.f16419c.b());
                    com.google.android.exoplayer2.upstream.f fVar = this.f16419c;
                    if (!(k.this.f16410t == null || k.this.f16410t.f15880f == -1)) {
                        fVar = new g(this.f16419c, k.this.f16410t.f15880f, this);
                        u j3 = k.this.j();
                        this.f16429m = j3;
                        j3.a(k.f16392b);
                    }
                    fj.d dVar2 = new fj.d(fVar, j2, this.f16428l);
                    try {
                        fj.g a4 = this.f16420d.a(dVar2, this.f16421e, uri);
                        if (k.this.f16410t != null && (a4 instanceof fn.c)) {
                            ((fn.c) a4).a();
                        }
                        if (this.f16425i) {
                            a4.a(j2, this.f16426j);
                            this.f16425i = false;
                        }
                        while (i2 == 0 && !this.f16424h) {
                            this.f16422f.c();
                            i2 = a4.a((fj.h) dVar2, this.f16423g);
                            if (dVar2.c() > k.this.f16401k + j2) {
                                j2 = dVar2.c();
                                this.f16422f.b();
                                k.this.f16407q.post(k.this.f16406p);
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.f16423g.f27401a = dVar2.c();
                        }
                        ad.a((com.google.android.exoplayer2.upstream.f) this.f16419c);
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        this.f16423g.f27401a = dVar.c();
                        ad.a((com.google.android.exoplayer2.upstream.f) this.f16419c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!(i2 == 1 || dVar == null)) {
                        this.f16423g.f27401a = dVar.c();
                    }
                    ad.a((com.google.android.exoplayer2.upstream.f) this.f16419c);
                    throw th;
                }
            }
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final fj.g[] f16431a;

        /* renamed from: b  reason: collision with root package name */
        private fj.g f16432b;

        public b(fj.g[] gVarArr) {
            this.f16431a = gVarArr;
        }

        public fj.g a(fj.h hVar, i iVar, Uri uri) throws IOException, InterruptedException {
            fj.g gVar = this.f16432b;
            if (gVar != null) {
                return gVar;
            }
            fj.g[] gVarArr = this.f16431a;
            int i2 = 0;
            if (gVarArr.length == 1) {
                this.f16432b = gVarArr[0];
            } else {
                int length = gVarArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    fj.g gVar2 = gVarArr[i2];
                    try {
                        if (gVar2.a(hVar)) {
                            this.f16432b = gVar2;
                            hVar.a();
                            break;
                        }
                        hVar.a();
                        i2++;
                    } catch (EOFException unused) {
                    } catch (Throwable th) {
                        hVar.a();
                        throw th;
                    }
                }
                if (this.f16432b == null) {
                    String b2 = ad.b((Object[]) this.f16431a);
                    StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 58);
                    sb.append("None of the available extractors (");
                    sb.append(b2);
                    sb.append(") could read the stream.");
                    throw new UnrecognizedInputFormatException(sb.toString(), uri);
                }
            }
            this.f16432b.a(iVar);
            return this.f16432b;
        }

        public void a() {
            fj.g gVar = this.f16432b;
            if (gVar != null) {
                gVar.c();
                this.f16432b = null;
            }
        }
    }

    interface c {
        void a(long j2, boolean z2, boolean z3);
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final s f16433a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackGroupArray f16434b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f16435c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f16436d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f16437e;

        public d(s sVar, TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f16433a = sVar;
            this.f16434b = trackGroupArray;
            this.f16435c = zArr;
            this.f16436d = new boolean[trackGroupArray.f16009b];
            this.f16437e = new boolean[trackGroupArray.f16009b];
        }
    }

    private final class e implements o {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f16439b;

        public e(int i2) {
            this.f16439b = i2;
        }

        public int a(o oVar, fi.e eVar, boolean z2) {
            return k.this.a(this.f16439b, oVar, eVar, z2);
        }

        public int a_(long j2) {
            return k.this.a(this.f16439b, j2);
        }

        public boolean b() {
            return k.this.a(this.f16439b);
        }

        public void c() throws IOException {
            k.this.b(this.f16439b);
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f16440a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16441b;

        public f(int i2, boolean z2) {
            this.f16440a = i2;
            this.f16441b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f16440a == fVar.f16440a && this.f16441b == fVar.f16441b;
        }

        public int hashCode() {
            return (this.f16440a * 31) + (this.f16441b ? 1 : 0);
        }
    }

    public k(Uri uri, com.google.android.exoplayer2.upstream.f fVar, fj.g[] gVarArr, com.google.android.exoplayer2.drm.b<?> bVar, p pVar, j.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar2, String str, int i2) {
        this.f16393c = uri;
        this.f16394d = fVar;
        this.f16395e = bVar;
        this.f16396f = pVar;
        this.f16397g = aVar;
        this.f16398h = cVar;
        this.f16399i = bVar2;
        this.f16400j = str;
        this.f16401k = (long) i2;
        this.f16403m = new b(gVarArr);
        this.f16404n = new com.google.android.exoplayer2.util.e();
        this.f16405o = new Runnable() {
            public final void run() {
                k.this.n();
            }
        };
        this.f16406p = new Runnable() {
            public final void run() {
                k.this.u();
            }
        };
        this.f16407q = new Handler();
        this.f16412v = new f[0];
        this.f16411u = new n[0];
        this.J = -9223372036854775807L;
        this.G = -1;
        this.F = -9223372036854775807L;
        this.A = 1;
        aVar.a();
    }

    private u a(f fVar) {
        int length = this.f16411u.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (fVar.equals(this.f16412v[i2])) {
                return this.f16411u[i2];
            }
        }
        n nVar = new n(this.f16399i, this.f16407q.getLooper(), this.f16395e);
        nVar.a((n.b) this);
        int i3 = length + 1;
        f[] fVarArr = (f[]) Arrays.copyOf(this.f16412v, i3);
        fVarArr[length] = fVar;
        this.f16412v = (f[]) ad.a((T[]) fVarArr);
        n[] nVarArr = (n[]) Arrays.copyOf(this.f16411u, i3);
        nVarArr[length] = nVar;
        this.f16411u = (n[]) ad.a((T[]) nVarArr);
        return nVar;
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f16428l;
        }
    }

    private boolean a(a aVar, int i2) {
        s sVar;
        if (this.G == -1 && ((sVar = this.f16409s) == null || sVar.b() == -9223372036854775807L)) {
            if (!this.f16414x || m()) {
                this.C = this.f16414x;
                this.I = 0;
                this.L = 0;
                for (n b2 : this.f16411u) {
                    b2.b();
                }
                aVar.a(0, 0);
                return true;
            }
            this.K = true;
            return false;
        }
        this.L = i2;
        return true;
    }

    private boolean a(boolean[] zArr, long j2) {
        int length = this.f16411u.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.f16411u[i2].a(j2, false) && (zArr[i2] || !this.f16416z)) {
                return false;
            }
        }
        return true;
    }

    private void c(int i2) {
        d o2 = o();
        boolean[] zArr = o2.f16437e;
        if (!zArr[i2]) {
            Format a2 = o2.f16434b.a(i2).a(0);
            this.f16397g.a(com.google.android.exoplayer2.util.n.h(a2.f15092i), a2, 0, (Object) null, this.I);
            zArr[i2] = true;
        }
    }

    private void d(int i2) {
        boolean[] zArr = o().f16435c;
        if (this.K && zArr[i2]) {
            if (!this.f16411u[i2].b(false)) {
                this.J = 0;
                this.K = false;
                this.C = true;
                this.I = 0;
                this.L = 0;
                for (n b2 : this.f16411u) {
                    b2.b();
                }
                ((h.a) com.google.android.exoplayer2.util.a.b(this.f16408r)).a(this);
            }
        }
    }

    private boolean m() {
        return this.C || s();
    }

    /* access modifiers changed from: private */
    public void n() {
        s sVar = this.f16409s;
        if (!this.N && !this.f16414x && this.f16413w && sVar != null) {
            n[] nVarArr = this.f16411u;
            int length = nVarArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (i2 < length) {
                if (nVarArr[i2].j() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f16404n.b();
            int length2 = this.f16411u.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            this.F = sVar.b();
            for (int i3 = 0; i3 < length2; i3++) {
                Format j2 = this.f16411u[i3].j();
                String str = j2.f15092i;
                boolean a2 = com.google.android.exoplayer2.util.n.a(str);
                boolean z3 = a2 || com.google.android.exoplayer2.util.n.b(str);
                zArr[i3] = z3;
                this.f16416z = z3 | this.f16416z;
                IcyHeaders icyHeaders = this.f16410t;
                if (icyHeaders != null) {
                    if (a2 || this.f16412v[i3].f16441b) {
                        Metadata metadata = j2.f15090g;
                        j2 = j2.a(metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders));
                    }
                    if (a2 && j2.f15088e == -1 && icyHeaders.f15875a != -1) {
                        j2 = j2.b(icyHeaders.f15875a);
                    }
                }
                if (j2.f15095l != null) {
                    j2 = j2.a(this.f16395e.b(j2.f15095l));
                }
                trackGroupArr[i3] = new TrackGroup(j2);
            }
            if (this.G == -1 && sVar.b() == -9223372036854775807L) {
                z2 = true;
            }
            this.H = z2;
            this.A = z2 ? 7 : 1;
            this.f16415y = new d(sVar, new TrackGroupArray(trackGroupArr), zArr);
            this.f16414x = true;
            this.f16398h.a(this.F, sVar.a(), this.H);
            ((h.a) com.google.android.exoplayer2.util.a.b(this.f16408r)).a(this);
        }
    }

    private d o() {
        return (d) com.google.android.exoplayer2.util.a.b(this.f16415y);
    }

    private void p() {
        a aVar = new a(this.f16393c, this.f16394d, this.f16403m, this, this.f16404n);
        if (this.f16414x) {
            s sVar = o().f16433a;
            com.google.android.exoplayer2.util.a.b(s());
            long j2 = this.F;
            if (j2 == -9223372036854775807L || this.J <= j2) {
                aVar.a(sVar.a(this.J).f27402a.f27408c, this.J);
                this.J = -9223372036854775807L;
            } else {
                this.M = true;
                this.J = -9223372036854775807L;
                return;
            }
        }
        this.L = q();
        this.f16397g.a(aVar.f16427k, 1, -1, (Format) null, 0, (Object) null, aVar.f16426j, this.F, this.f16402l.a(aVar, this, this.f16396f.a(this.A)));
    }

    private int q() {
        int i2 = 0;
        for (n d2 : this.f16411u) {
            i2 += d2.d();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public long r() {
        long j2 = Long.MIN_VALUE;
        for (n k2 : this.f16411u) {
            j2 = Math.max(j2, k2.k());
        }
        return j2;
    }

    private boolean s() {
        return this.J != -9223372036854775807L;
    }

    private static Map<String, String> t() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        if (!this.N) {
            ((h.a) com.google.android.exoplayer2.util.a.b(this.f16408r)).a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, long j2) {
        if (m()) {
            return 0;
        }
        c(i2);
        n nVar = this.f16411u[i2];
        int a2 = (!this.M || j2 <= nVar.k()) ? nVar.a(j2) : nVar.n();
        if (a2 == 0) {
            d(i2);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, o oVar, fi.e eVar, boolean z2) {
        if (m()) {
            return -3;
        }
        c(i2);
        int a2 = this.f16411u[i2].a(oVar, eVar, z2, this.M, this.I);
        if (a2 == -3) {
            d(i2);
        }
        return a2;
    }

    public long a(long j2, com.google.android.exoplayer2.ad adVar) {
        s sVar = o().f16433a;
        if (!sVar.a()) {
            return 0;
        }
        s.a a2 = sVar.a(j2);
        return ad.a(j2, adVar, a2.f27402a.f27407b, a2.f27403b.f27407b);
    }

    public long a(com.google.android.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        d o2 = o();
        TrackGroupArray trackGroupArray = o2.f16434b;
        boolean[] zArr3 = o2.f16436d;
        int i2 = this.E;
        int i3 = 0;
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            if (oVarArr[i4] != null && (eVarArr[i4] == null || !zArr[i4])) {
                int a2 = oVarArr[i4].f16439b;
                com.google.android.exoplayer2.util.a.b(zArr3[a2]);
                this.E--;
                zArr3[a2] = false;
                oVarArr[i4] = null;
            }
        }
        boolean z2 = !this.B ? j2 != 0 : i2 == 0;
        for (int i5 = 0; i5 < eVarArr.length; i5++) {
            if (oVarArr[i5] == null && eVarArr[i5] != null) {
                com.google.android.exoplayer2.trackselection.e eVar = eVarArr[i5];
                com.google.android.exoplayer2.util.a.b(eVar.h() == 1);
                com.google.android.exoplayer2.util.a.b(eVar.b(0) == 0);
                int a3 = trackGroupArray.a(eVar.g());
                com.google.android.exoplayer2.util.a.b(!zArr3[a3]);
                this.E++;
                zArr3[a3] = true;
                oVarArr[i5] = new e(a3);
                zArr2[i5] = true;
                if (!z2) {
                    n nVar = this.f16411u[a3];
                    z2 = !nVar.a(j2, true) && nVar.h() != 0;
                }
            }
        }
        if (this.E == 0) {
            this.K = false;
            this.C = false;
            if (this.f16402l.c()) {
                n[] nVarArr = this.f16411u;
                int length = nVarArr.length;
                while (i3 < length) {
                    nVarArr[i3].p();
                    i3++;
                }
                this.f16402l.d();
            } else {
                n[] nVarArr2 = this.f16411u;
                int length2 = nVarArr2.length;
                while (i3 < length2) {
                    nVarArr2[i3].b();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = b(j2);
            while (i3 < oVarArr.length) {
                if (oVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.B = true;
        return j2;
    }

    public Loader.b a(a aVar, long j2, long j3, IOException iOException, int i2) {
        Loader.b bVar;
        a aVar2;
        boolean z2;
        a(aVar);
        long b2 = this.f16396f.b(this.A, j3, iOException, i2);
        if (b2 == -9223372036854775807L) {
            bVar = Loader.f16946d;
            a aVar3 = aVar;
        } else {
            int q2 = q();
            if (q2 > this.L) {
                aVar2 = aVar;
                z2 = true;
            } else {
                z2 = false;
                aVar2 = aVar;
            }
            bVar = a(aVar2, q2) ? Loader.a(z2, b2) : Loader.f16945c;
        }
        this.f16397g.a(aVar.f16427k, aVar.f16419c.f(), aVar.f16419c.g(), 1, -1, (Format) null, 0, (Object) null, aVar.f16426j, this.F, j2, j3, aVar.f16419c.e(), iOException, !bVar.a());
        return bVar;
    }

    public u a(int i2, int i3) {
        return a(new f(i2, false));
    }

    public void a() {
        this.f16413w = true;
        this.f16407q.post(this.f16405o);
    }

    public void a(long j2) {
    }

    public void a(long j2, boolean z2) {
        if (!s()) {
            boolean[] zArr = o().f16436d;
            int length = this.f16411u.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f16411u[i2].a(j2, z2, zArr[i2]);
            }
        }
    }

    public void a(Format format) {
        this.f16407q.post(this.f16405o);
    }

    public void a(h.a aVar, long j2) {
        this.f16408r = aVar;
        this.f16404n.a();
        p();
    }

    public void a(a aVar, long j2, long j3) {
        s sVar;
        if (this.F == -9223372036854775807L && (sVar = this.f16409s) != null) {
            boolean a2 = sVar.a();
            long r2 = r();
            long j4 = r2 == Long.MIN_VALUE ? 0 : r2 + 10000;
            this.F = j4;
            this.f16398h.a(j4, a2, this.H);
        }
        this.f16397g.a(aVar.f16427k, aVar.f16419c.f(), aVar.f16419c.g(), 1, -1, (Format) null, 0, (Object) null, aVar.f16426j, this.F, j2, j3, aVar.f16419c.e());
        a(aVar);
        this.M = true;
        ((h.a) com.google.android.exoplayer2.util.a.b(this.f16408r)).a(this);
    }

    public void a(a aVar, long j2, long j3, boolean z2) {
        this.f16397g.b(aVar.f16427k, aVar.f16419c.f(), aVar.f16419c.g(), 1, -1, (Format) null, 0, (Object) null, aVar.f16426j, this.F, j2, j3, aVar.f16419c.e());
        if (!z2) {
            a(aVar);
            for (n b2 : this.f16411u) {
                b2.b();
            }
            if (this.E > 0) {
                ((h.a) com.google.android.exoplayer2.util.a.b(this.f16408r)).a(this);
            }
        }
    }

    public void a(s sVar) {
        if (this.f16410t != null) {
            sVar = new s.b(-9223372036854775807L);
        }
        this.f16409s = sVar;
        this.f16407q.post(this.f16405o);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return !m() && this.f16411u[i2].b(this.M);
    }

    public long b(long j2) {
        d o2 = o();
        s sVar = o2.f16433a;
        boolean[] zArr = o2.f16435c;
        if (!sVar.a()) {
            j2 = 0;
        }
        this.C = false;
        this.I = j2;
        if (s()) {
            this.J = j2;
            return j2;
        } else if (this.A != 7 && a(zArr, j2)) {
            return j2;
        } else {
            this.K = false;
            this.J = j2;
            this.M = false;
            if (this.f16402l.c()) {
                this.f16402l.d();
            } else {
                this.f16402l.b();
                for (n b2 : this.f16411u) {
                    b2.b();
                }
            }
            return j2;
        }
    }

    public TrackGroupArray b() {
        return o().f16434b;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) throws IOException {
        this.f16411u[i2].f();
        i();
    }

    public long c() {
        if (!this.D) {
            this.f16397g.c();
            this.D = true;
        }
        if (!this.C) {
            return -9223372036854775807L;
        }
        if (!this.M && q() <= this.L) {
            return -9223372036854775807L;
        }
        this.C = false;
        return this.I;
    }

    public boolean c(long j2) {
        if (this.M || this.f16402l.a() || this.K) {
            return false;
        }
        if (this.f16414x && this.E == 0) {
            return false;
        }
        boolean a2 = this.f16404n.a();
        if (this.f16402l.c()) {
            return a2;
        }
        p();
        return true;
    }

    public long d() {
        long j2;
        boolean[] zArr = o().f16435c;
        if (this.M) {
            return Long.MIN_VALUE;
        }
        if (s()) {
            return this.J;
        }
        if (this.f16416z) {
            int length = this.f16411u.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i2] && !this.f16411u[i2].l()) {
                    j2 = Math.min(j2, this.f16411u[i2].k());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = r();
        }
        return j2 == Long.MIN_VALUE ? this.I : j2;
    }

    public long e() {
        if (this.E == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public boolean f() {
        return this.f16402l.c() && this.f16404n.d();
    }

    public void g() {
        if (this.f16414x) {
            for (n e2 : this.f16411u) {
                e2.e();
            }
        }
        this.f16402l.a((Loader.e) this);
        this.f16407q.removeCallbacksAndMessages((Object) null);
        this.f16408r = null;
        this.N = true;
        this.f16397g.b();
    }

    public void h() {
        for (n a2 : this.f16411u) {
            a2.a();
        }
        this.f16403m.a();
    }

    /* access modifiers changed from: package-private */
    public void i() throws IOException {
        this.f16402l.a(this.f16396f.a(this.A));
    }

    /* access modifiers changed from: package-private */
    public u j() {
        return a(new f(0, true));
    }

    public void n_() throws IOException {
        i();
        if (this.M && !this.f16414x) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }
}
