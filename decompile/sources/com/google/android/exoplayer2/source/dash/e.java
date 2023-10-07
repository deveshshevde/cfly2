package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.g;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.n;
import fj.s;
import fj.u;
import ft.d;
import ft.i;
import ft.k;
import ft.l;
import ft.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    protected final b[] f16106a;

    /* renamed from: b  reason: collision with root package name */
    private final q f16107b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f16108c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16109d;

    /* renamed from: e  reason: collision with root package name */
    private final f f16110e;

    /* renamed from: f  reason: collision with root package name */
    private final long f16111f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16112g;

    /* renamed from: h  reason: collision with root package name */
    private final g.c f16113h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.e f16114i;

    /* renamed from: j  reason: collision with root package name */
    private fu.b f16115j;

    /* renamed from: k  reason: collision with root package name */
    private int f16116k;

    /* renamed from: l  reason: collision with root package name */
    private IOException f16117l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16118m;

    /* renamed from: n  reason: collision with root package name */
    private long f16119n = -9223372036854775807L;

    public static final class a implements a.C0113a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f16120a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16121b;

        public a(f.a aVar) {
            this(aVar, 1);
        }

        public a(f.a aVar, int i2) {
            this.f16120a = aVar;
            this.f16121b = i2;
        }

        public a a(q qVar, fu.b bVar, int i2, int[] iArr, com.google.android.exoplayer2.trackselection.e eVar, int i3, long j2, boolean z2, List<Format> list, g.c cVar, t tVar) {
            t tVar2 = tVar;
            f a2 = this.f16120a.a();
            if (tVar2 != null) {
                a2.a(tVar2);
            }
            return new e(qVar, bVar, i2, iArr, eVar, i3, a2, j2, this.f16121b, z2, list, cVar);
        }
    }

    protected static final class b {

        /* renamed from: a  reason: collision with root package name */
        final ft.e f16122a;

        /* renamed from: b  reason: collision with root package name */
        public final fu.g f16123b;

        /* renamed from: c  reason: collision with root package name */
        public final c f16124c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f16125d;

        /* renamed from: e  reason: collision with root package name */
        private final long f16126e;

        b(long j2, int i2, fu.g gVar, boolean z2, List<Format> list, u uVar) {
            this(j2, gVar, a(i2, gVar, z2, list, uVar), 0, gVar.c());
        }

        private b(long j2, fu.g gVar, ft.e eVar, long j3, c cVar) {
            this.f16125d = j2;
            this.f16123b = gVar;
            this.f16126e = j3;
            this.f16122a = eVar;
            this.f16124c = cVar;
        }

        /* JADX WARNING: type inference failed for: r9v3, types: [fm.d] */
        /* JADX WARNING: type inference failed for: r9v4, types: [fp.a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static ft.e a(int r7, fu.g r8, boolean r9, java.util.List<com.google.android.exoplayer2.Format> r10, fj.u r11) {
            /*
                com.google.android.exoplayer2.Format r0 = r8.f28145a
                java.lang.String r0 = r0.f15091h
                boolean r1 = b((java.lang.String) r0)
                if (r1 == 0) goto L_0x000c
                r7 = 0
                return r7
            L_0x000c:
                java.lang.String r1 = "application/x-rawcc"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L_0x001c
                fp.a r9 = new fp.a
                com.google.android.exoplayer2.Format r10 = r8.f28145a
                r9.<init>(r10)
                goto L_0x003a
            L_0x001c:
                boolean r0 = a((java.lang.String) r0)
                if (r0 == 0) goto L_0x0029
                fm.d r9 = new fm.d
                r10 = 1
                r9.<init>(r10)
                goto L_0x003a
            L_0x0029:
                r0 = 0
                if (r9 == 0) goto L_0x002f
                r0 = 4
                r2 = 4
                goto L_0x0030
            L_0x002f:
                r2 = 0
            L_0x0030:
                com.google.android.exoplayer2.extractor.mp4.e r9 = new com.google.android.exoplayer2.extractor.mp4.e
                r3 = 0
                r4 = 0
                r1 = r9
                r5 = r10
                r6 = r11
                r1.<init>(r2, r3, r4, r5, r6)
            L_0x003a:
                ft.e r10 = new ft.e
                com.google.android.exoplayer2.Format r8 = r8.f28145a
                r10.<init>(r9, r7, r8)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.e.b.a(int, fu.g, boolean, java.util.List, fj.u):ft.e");
        }

        private static boolean a(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean b(String str) {
            return n.c(str) || "application/ttml+xml".equals(str);
        }

        public long a() {
            return this.f16124c.a() + this.f16126e;
        }

        public long a(long j2) {
            return this.f16124c.a(j2 - this.f16126e);
        }

        public long a(fu.b bVar, int i2, long j2) {
            if (b() != -1 || bVar.f28124e == -9223372036854775807L) {
                return a();
            }
            return Math.max(a(), c(((j2 - com.google.android.exoplayer2.e.b(bVar.f28120a)) - com.google.android.exoplayer2.e.b(bVar.a(i2).f28138b)) - com.google.android.exoplayer2.e.b(bVar.f28124e)));
        }

        /* access modifiers changed from: package-private */
        public b a(long j2, fu.g gVar) throws BehindLiveWindowException {
            long j3;
            long j4 = j2;
            c c2 = this.f16123b.c();
            c c3 = gVar.c();
            if (c2 == null) {
                return new b(j2, gVar, this.f16122a, this.f16126e, c2);
            } else if (!c2.b()) {
                return new b(j2, gVar, this.f16122a, this.f16126e, c3);
            } else {
                int c4 = c2.c(j4);
                if (c4 == 0) {
                    return new b(j2, gVar, this.f16122a, this.f16126e, c3);
                }
                long a2 = c2.a();
                long a3 = c2.a(a2);
                long j5 = (((long) c4) + a2) - 1;
                long a4 = c2.a(j5) + c2.b(j5, j4);
                long a5 = c3.a();
                long j6 = a2;
                long a6 = c3.a(a5);
                long j7 = this.f16126e;
                if (a4 == a6) {
                    j3 = j7 + ((j5 + 1) - a5);
                    long j8 = j2;
                } else if (a4 >= a6) {
                    long j9 = j7;
                    j3 = a6 < a3 ? j9 - (c3.a(a3, j2) - j6) : (c2.a(a6, j2) - a5) + j9;
                } else {
                    throw new BehindLiveWindowException();
                }
                return new b(j2, gVar, this.f16122a, j3, c3);
            }
        }

        /* access modifiers changed from: package-private */
        public b a(c cVar) {
            return new b(this.f16125d, this.f16123b, this.f16122a, this.f16126e, cVar);
        }

        public int b() {
            return this.f16124c.c(this.f16125d);
        }

        public long b(long j2) {
            return a(j2) + this.f16124c.b(j2 - this.f16126e, this.f16125d);
        }

        public long b(fu.b bVar, int i2, long j2) {
            int b2 = b();
            return (b2 == -1 ? c((j2 - com.google.android.exoplayer2.e.b(bVar.f28120a)) - com.google.android.exoplayer2.e.b(bVar.a(i2).f28138b)) : a() + ((long) b2)) - 1;
        }

        public long c(long j2) {
            return this.f16124c.a(j2, this.f16125d) + this.f16126e;
        }

        public fu.f d(long j2) {
            return this.f16124c.b(j2 - this.f16126e);
        }
    }

    protected static final class c extends ft.b {

        /* renamed from: b  reason: collision with root package name */
        private final b f16127b;

        public c(b bVar, long j2, long j3) {
            super(j2, j3);
            this.f16127b = bVar;
        }
    }

    public e(q qVar, fu.b bVar, int i2, int[] iArr, com.google.android.exoplayer2.trackselection.e eVar, int i3, f fVar, long j2, int i4, boolean z2, List<Format> list, g.c cVar) {
        com.google.android.exoplayer2.trackselection.e eVar2 = eVar;
        this.f16107b = qVar;
        this.f16115j = bVar;
        this.f16108c = iArr;
        this.f16114i = eVar2;
        this.f16109d = i3;
        this.f16110e = fVar;
        this.f16116k = i2;
        this.f16111f = j2;
        this.f16112g = i4;
        this.f16113h = cVar;
        long c2 = bVar.c(i2);
        ArrayList<fu.g> b2 = b();
        this.f16106a = new b[eVar.h()];
        for (int i5 = 0; i5 < this.f16106a.length; i5++) {
            this.f16106a[i5] = new b(c2, i3, b2.get(eVar2.b(i5)), z2, list, cVar);
        }
    }

    private long a(long j2) {
        if (this.f16115j.f28122c && this.f16119n != -9223372036854775807L) {
            return this.f16119n - j2;
        }
        return -9223372036854775807L;
    }

    private long a(b bVar, l lVar, long j2, long j3, long j4) {
        return lVar != null ? lVar.h() : ad.a(bVar.c(j2), j3, j4);
    }

    private void a(b bVar, long j2) {
        this.f16119n = this.f16115j.f28122c ? bVar.b(j2) : -9223372036854775807L;
    }

    private ArrayList<fu.g> b() {
        List<fu.a> list = this.f16115j.a(this.f16116k).f28139c;
        ArrayList<fu.g> arrayList = new ArrayList<>();
        for (int i2 : this.f16108c) {
            arrayList.addAll(list.get(i2).f28116c);
        }
        return arrayList;
    }

    private long c() {
        return (this.f16111f != 0 ? SystemClock.elapsedRealtime() + this.f16111f : System.currentTimeMillis()) * 1000;
    }

    public int a(long j2, List<? extends l> list) {
        return (this.f16117l != null || this.f16114i.h() < 2) ? list.size() : this.f16114i.a(j2, list);
    }

    public long a(long j2, com.google.android.exoplayer2.ad adVar) {
        for (b bVar : this.f16106a) {
            if (bVar.f16124c != null) {
                long c2 = bVar.c(j2);
                long a2 = bVar.a(c2);
                return ad.a(j2, adVar, a2, (a2 >= j2 || c2 >= ((long) (bVar.b() + -1))) ? a2 : bVar.a(c2 + 1));
            }
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public d a(b bVar, f fVar, int i2, Format format, int i3, Object obj, long j2, int i4, long j3) {
        b bVar2 = bVar;
        long j4 = j2;
        fu.g gVar = bVar2.f16123b;
        long a2 = bVar2.a(j4);
        fu.f d2 = bVar2.d(j4);
        String str = gVar.f28146b;
        if (bVar2.f16122a == null) {
            return new ft.n(fVar, new h(d2.a(str), d2.f28141a, d2.f28142b, gVar.d()), format, i3, obj, a2, bVar2.b(j4), j2, i2, format);
        }
        int i5 = 1;
        int i6 = i4;
        int i7 = 1;
        while (i5 < i6) {
            fu.f a3 = d2.a(bVar2.d(((long) i5) + j4), str);
            if (a3 == null) {
                break;
            }
            i7++;
            i5++;
            d2 = a3;
        }
        long b2 = bVar2.b((((long) i7) + j4) - 1);
        long a4 = bVar.f16125d;
        long j5 = (a4 == -9223372036854775807L || a4 > b2) ? -9223372036854775807L : a4;
        h hVar = r18;
        h hVar2 = new h(d2.a(str), d2.f28141a, d2.f28142b, gVar.d());
        ft.e eVar = bVar2.f16122a;
        return new i(fVar, hVar, format, i3, obj, a2, b2, j3, j5, j2, i7, -gVar.f28147c, eVar);
    }

    /* access modifiers changed from: protected */
    public d a(b bVar, f fVar, Format format, int i2, Object obj, fu.f fVar2, fu.f fVar3) {
        String str = bVar.f16123b.f28146b;
        if (fVar2 == null || (fVar3 = fVar2.a(fVar3, str)) != null) {
            fVar2 = fVar3;
        }
        return new k(fVar, new h(fVar2.a(str), fVar2.f28141a, fVar2.f28142b, bVar.f16123b.d()), format, i2, obj, bVar.f16122a);
    }

    public void a() throws IOException {
        IOException iOException = this.f16117l;
        if (iOException == null) {
            this.f16107b.f();
            return;
        }
        throw iOException;
    }

    public void a(long j2, long j3, List<? extends l> list, ft.f fVar) {
        l lVar;
        long j4;
        m[] mVarArr;
        int i2;
        int i3;
        ft.f fVar2 = fVar;
        if (this.f16117l == null) {
            long j5 = j3 - j2;
            long a2 = a(j2);
            long b2 = com.google.android.exoplayer2.e.b(this.f16115j.f28120a) + com.google.android.exoplayer2.e.b(this.f16115j.a(this.f16116k).f28138b) + j3;
            g.c cVar = this.f16113h;
            if (cVar == null || !cVar.a(b2)) {
                long c2 = c();
                if (list.isEmpty()) {
                    List<? extends l> list2 = list;
                    lVar = null;
                } else {
                    lVar = (l) list.get(list.size() - 1);
                }
                int h2 = this.f16114i.h();
                m[] mVarArr2 = new m[h2];
                int i4 = 0;
                while (i4 < h2) {
                    b bVar = this.f16106a[i4];
                    if (bVar.f16124c == null) {
                        mVarArr2[i4] = m.f28109a;
                        i3 = i4;
                        i2 = h2;
                        mVarArr = mVarArr2;
                        j4 = c2;
                    } else {
                        long a3 = bVar.a(this.f16115j, this.f16116k, c2);
                        long b3 = bVar.b(this.f16115j, this.f16116k, c2);
                        b bVar2 = bVar;
                        i3 = i4;
                        i2 = h2;
                        mVarArr = mVarArr2;
                        j4 = c2;
                        long a4 = a(bVar, lVar, j3, a3, b3);
                        if (a4 < a3) {
                            mVarArr[i3] = m.f28109a;
                        } else {
                            mVarArr[i3] = new c(bVar2, a4, b3);
                        }
                    }
                    i4 = i3 + 1;
                    List<? extends l> list3 = list;
                    h2 = i2;
                    mVarArr2 = mVarArr;
                    c2 = j4;
                }
                long j6 = c2;
                this.f16114i.a(j2, j5, a2, list, mVarArr2);
                b bVar3 = this.f16106a[this.f16114i.a()];
                if (bVar3.f16122a != null) {
                    fu.g gVar = bVar3.f16123b;
                    fu.f a5 = bVar3.f16122a.c() == null ? gVar.a() : null;
                    fu.f b4 = bVar3.f16124c == null ? gVar.b() : null;
                    if (!(a5 == null && b4 == null)) {
                        fVar2.f28066a = a(bVar3, this.f16110e, this.f16114i.i(), this.f16114i.b(), this.f16114i.c(), a5, b4);
                        return;
                    }
                }
                long a6 = bVar3.f16125d;
                long j7 = -9223372036854775807L;
                boolean z2 = a6 != -9223372036854775807L;
                if (bVar3.b() == 0) {
                    fVar2.f28067b = z2;
                    return;
                }
                long j8 = j6;
                long a7 = bVar3.a(this.f16115j, this.f16116k, j8);
                long b5 = bVar3.b(this.f16115j, this.f16116k, j8);
                a(bVar3, b5);
                long j9 = b5;
                long a8 = a(bVar3, lVar, j3, a7, b5);
                if (a8 < a7) {
                    this.f16117l = new BehindLiveWindowException();
                } else if (a8 > j9 || (this.f16118m && a8 >= j9)) {
                    fVar2.f28067b = z2;
                } else if (!z2 || bVar3.a(a8) < a6) {
                    int min = (int) Math.min((long) this.f16112g, (j9 - a8) + 1);
                    if (a6 != -9223372036854775807L) {
                        while (min > 1 && bVar3.a((((long) min) + a8) - 1) >= a6) {
                            min--;
                        }
                    }
                    int i5 = min;
                    if (list.isEmpty()) {
                        j7 = j3;
                    }
                    fVar2.f28066a = a(bVar3, this.f16110e, this.f16109d, this.f16114i.i(), this.f16114i.b(), this.f16114i.c(), a8, i5, j7);
                } else {
                    fVar2.f28067b = true;
                }
            }
        }
    }

    public void a(com.google.android.exoplayer2.trackselection.e eVar) {
        this.f16114i = eVar;
    }

    public void a(d dVar) {
        s b2;
        if (dVar instanceof k) {
            int a2 = this.f16114i.a(((k) dVar).f13112e);
            b bVar = this.f16106a[a2];
            if (bVar.f16124c == null && (b2 = bVar.f16122a.b()) != null) {
                this.f16106a[a2] = bVar.a((c) new d((fj.b) b2, bVar.f16123b.f28147c));
            }
        }
        g.c cVar = this.f16113h;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public void a(fu.b bVar, int i2) {
        try {
            this.f16115j = bVar;
            this.f16116k = i2;
            long c2 = bVar.c(i2);
            ArrayList<fu.g> b2 = b();
            for (int i3 = 0; i3 < this.f16106a.length; i3++) {
                b[] bVarArr = this.f16106a;
                bVarArr[i3] = bVarArr[i3].a(c2, b2.get(this.f16114i.b(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.f16117l = e2;
        }
    }

    public boolean a(d dVar, boolean z2, Exception exc, long j2) {
        b bVar;
        int b2;
        if (!z2) {
            return false;
        }
        g.c cVar = this.f16113h;
        if (cVar != null && cVar.b(dVar)) {
            return true;
        }
        if (!this.f16115j.f28122c && (dVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).f16937c == 404 && (b2 = bVar.b()) != -1 && b2 != 0) {
            if (((l) dVar).h() > ((bVar = this.f16106a[this.f16114i.a(dVar.f13112e)]).a() + ((long) b2)) - 1) {
                this.f16118m = true;
                return true;
            }
        }
        if (j2 == -9223372036854775807L) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.e eVar = this.f16114i;
        return eVar.a(eVar.a(dVar.f13112e), j2);
    }
}
