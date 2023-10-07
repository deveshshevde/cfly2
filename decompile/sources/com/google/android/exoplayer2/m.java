package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

final class m implements Handler.Callback, i.a, h.a, i.b, g.a, y.a {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private d E;
    private long F;
    private int G;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    private final z[] f15733a;

    /* renamed from: b  reason: collision with root package name */
    private final aa[] f15734b;

    /* renamed from: c  reason: collision with root package name */
    private final g f15735c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.trackselection.h f15736d;

    /* renamed from: e  reason: collision with root package name */
    private final p f15737e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.c f15738f;

    /* renamed from: g  reason: collision with root package name */
    private final j f15739g;

    /* renamed from: h  reason: collision with root package name */
    private final HandlerThread f15740h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f15741i;

    /* renamed from: j  reason: collision with root package name */
    private final af.b f15742j;

    /* renamed from: k  reason: collision with root package name */
    private final af.a f15743k;

    /* renamed from: l  reason: collision with root package name */
    private final long f15744l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f15745m;

    /* renamed from: n  reason: collision with root package name */
    private final i f15746n;

    /* renamed from: o  reason: collision with root package name */
    private final c f15747o;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<b> f15748p;

    /* renamed from: q  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.b f15749q;

    /* renamed from: r  reason: collision with root package name */
    private final t f15750r = new t();

    /* renamed from: s  reason: collision with root package name */
    private ad f15751s;

    /* renamed from: t  reason: collision with root package name */
    private u f15752t;

    /* renamed from: u  reason: collision with root package name */
    private com.google.android.exoplayer2.source.i f15753u;

    /* renamed from: v  reason: collision with root package name */
    private z[] f15754v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f15755w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f15756x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f15757y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f15758z;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.google.android.exoplayer2.source.i f15759a;

        /* renamed from: b  reason: collision with root package name */
        public final af f15760b;

        public a(com.google.android.exoplayer2.source.i iVar, af afVar) {
            this.f15759a = iVar;
            this.f15760b = afVar;
        }
    }

    private static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final y f15761a;

        /* renamed from: b  reason: collision with root package name */
        public int f15762b;

        /* renamed from: c  reason: collision with root package name */
        public long f15763c;

        /* renamed from: d  reason: collision with root package name */
        public Object f15764d;

        public b(y yVar) {
            this.f15761a = yVar;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            Object obj = this.f15764d;
            if ((obj == null) != (bVar.f15764d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i2 = this.f15762b - bVar.f15762b;
            return i2 != 0 ? i2 : ad.a(this.f15763c, bVar.f15763c);
        }

        public void a(int i2, long j2, Object obj) {
            this.f15762b = i2;
            this.f15763c = j2;
            this.f15764d = obj;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private u f15765a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f15766b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f15767c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f15768d;

        private c() {
        }

        public void a(int i2) {
            this.f15766b += i2;
        }

        public boolean a(u uVar) {
            return uVar != this.f15765a || this.f15766b > 0 || this.f15767c;
        }

        public void b(int i2) {
            boolean z2 = true;
            if (!this.f15767c || this.f15768d == 4) {
                this.f15767c = true;
                this.f15768d = i2;
                return;
            }
            if (i2 != 4) {
                z2 = false;
            }
            com.google.android.exoplayer2.util.a.a(z2);
        }

        public void b(u uVar) {
            this.f15765a = uVar;
            this.f15766b = 0;
            this.f15767c = false;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final af f15769a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15770b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15771c;

        public d(af afVar, int i2, long j2) {
            this.f15769a = afVar;
            this.f15770b = i2;
            this.f15771c = j2;
        }
    }

    public m(z[] zVarArr, g gVar, com.google.android.exoplayer2.trackselection.h hVar, p pVar, com.google.android.exoplayer2.upstream.c cVar, boolean z2, int i2, boolean z3, Handler handler, com.google.android.exoplayer2.util.b bVar) {
        this.f15733a = zVarArr;
        this.f15735c = gVar;
        this.f15736d = hVar;
        this.f15737e = pVar;
        this.f15738f = cVar;
        this.f15756x = z2;
        this.A = i2;
        this.B = z3;
        this.f15741i = handler;
        this.f15749q = bVar;
        this.f15744l = pVar.e();
        this.f15745m = pVar.f();
        this.f15751s = ad.f15126e;
        this.f15752t = u.a(-9223372036854775807L, hVar);
        this.f15747o = new c();
        this.f15734b = new aa[zVarArr.length];
        for (int i3 = 0; i3 < zVarArr.length; i3++) {
            zVarArr[i3].a(i3);
            this.f15734b[i3] = zVarArr[i3].b();
        }
        this.f15746n = new i(this, bVar);
        this.f15748p = new ArrayList<>();
        this.f15754v = new z[0];
        this.f15742j = new af.b();
        this.f15743k = new af.a();
        gVar.a(this, cVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f15740h = handlerThread;
        handlerThread.start();
        this.f15739g = bVar.a(handlerThread.getLooper(), this);
        this.H = true;
    }

    private long A() {
        return b(this.f15752t.f16764k);
    }

    private long a(i.a aVar, long j2) throws ExoPlaybackException {
        return a(aVar, j2, this.f15750r.c() != this.f15750r.d());
    }

    private long a(i.a aVar, long j2, boolean z2) throws ExoPlaybackException {
        e();
        this.f15757y = false;
        if (this.f15752t.f16758e != 1 && !this.f15752t.f16754a.a()) {
            b(2);
        }
        q c2 = this.f15750r.c();
        q qVar = c2;
        while (true) {
            if (qVar != null) {
                if (aVar.equals(qVar.f15988f.f15997a) && qVar.f15986d) {
                    this.f15750r.a(qVar);
                    break;
                }
                qVar = this.f15750r.f();
            } else {
                break;
            }
        }
        if (z2 || c2 != qVar || (qVar != null && qVar.a(j2) < 0)) {
            for (z b2 : this.f15754v) {
                b(b2);
            }
            this.f15754v = new z[0];
            c2 = null;
            if (qVar != null) {
                qVar.c(0);
            }
        }
        if (qVar != null) {
            a(c2);
            if (qVar.f15987e) {
                long b3 = qVar.f15983a.b(j2);
                qVar.f15983a.a(b3 - this.f15744l, this.f15745m);
                j2 = b3;
            }
            a(j2);
            w();
        } else {
            this.f15750r.b(true);
            this.f15752t = this.f15752t.a(TrackGroupArray.f16008a, this.f15736d);
            a(j2);
        }
        g(false);
        this.f15739g.a(2);
        return j2;
    }

    private Pair<Object, Long> a(d dVar, boolean z2) {
        Object a2;
        af afVar = this.f15752t.f16754a;
        af afVar2 = dVar.f15769a;
        if (afVar.a()) {
            return null;
        }
        if (afVar2.a()) {
            afVar2 = afVar;
        }
        try {
            Pair<Object, Long> a3 = afVar2.a(this.f15742j, this.f15743k, dVar.f15770b, dVar.f15771c);
            if (afVar == afVar2 || afVar.a(a3.first) != -1) {
                return a3;
            }
            if (z2 && (a2 = a(a3.first, afVar2, afVar)) != null) {
                return b(afVar, afVar.a(a2, this.f15743k).f15168c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private u a(i.a aVar, long j2, long j3) {
        this.H = true;
        return this.f15752t.a(aVar, j2, j3, A());
    }

    private Object a(Object obj, af afVar, af afVar2) {
        int a2 = afVar.a(obj);
        int c2 = afVar.c();
        int i2 = a2;
        int i3 = -1;
        for (int i4 = 0; i4 < c2 && i3 == -1; i4++) {
            i2 = afVar.a(i2, this.f15743k, this.f15742j, this.A, this.B);
            if (i2 == -1) {
                break;
            }
            i3 = afVar2.a(afVar.a(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return afVar2.a(i3);
    }

    private String a(ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException.f15078a != 1) {
            return "Playback error.";
        }
        int i2 = exoPlaybackException.f15079b;
        String h2 = ad.h(this.f15733a[exoPlaybackException.f15079b].a());
        String valueOf = String.valueOf(exoPlaybackException.f15080c);
        String f2 = aa.CC.f(exoPlaybackException.f15081d);
        StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 67 + String.valueOf(valueOf).length() + String.valueOf(f2).length());
        sb.append("Renderer error: index=");
        sb.append(i2);
        sb.append(", type=");
        sb.append(h2);
        sb.append(", format=");
        sb.append(valueOf);
        sb.append(", rendererSupport=");
        sb.append(f2);
        return sb.toString();
    }

    private void a(float f2) {
        for (q c2 = this.f15750r.c(); c2 != null; c2 = c2.g()) {
            for (e eVar : c2.i().f16751c.a()) {
                if (eVar != null) {
                    eVar.a(f2);
                }
            }
        }
    }

    private void a(int i2, boolean z2, int i3) throws ExoPlaybackException {
        q c2 = this.f15750r.c();
        z zVar = this.f15733a[i2];
        this.f15754v[i3] = zVar;
        if (zVar.m_() == 0) {
            com.google.android.exoplayer2.trackselection.h i4 = c2.i();
            ab abVar = i4.f16750b[i2];
            Format[] a2 = a(i4.f16751c.a(i2));
            boolean z3 = this.f15756x && this.f15752t.f16758e == 3;
            zVar.a(abVar, a2, c2.f15985c[i2], this.F, !z2 && z3, c2.a());
            this.f15746n.a(zVar);
            if (z3) {
                zVar.e();
            }
        }
    }

    private void a(long j2) throws ExoPlaybackException {
        q c2 = this.f15750r.c();
        if (c2 != null) {
            j2 = c2.a(j2);
        }
        this.F = j2;
        this.f15746n.a(j2);
        for (z a2 : this.f15754v) {
            a2.a(this.F);
        }
        k();
    }

    private void a(long j2, long j3) {
        this.f15739g.b(2);
        this.f15739g.a(2, j2 + j3);
    }

    private void a(ad adVar) {
        this.f15751s = adVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.m.a r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r11 = this;
            com.google.android.exoplayer2.source.i r0 = r12.f15759a
            com.google.android.exoplayer2.source.i r1 = r11.f15753u
            if (r0 == r1) goto L_0x0007
            return
        L_0x0007:
            com.google.android.exoplayer2.m$c r0 = r11.f15747o
            int r1 = r11.D
            r0.a((int) r1)
            r0 = 0
            r11.D = r0
            com.google.android.exoplayer2.u r1 = r11.f15752t
            com.google.android.exoplayer2.af r1 = r1.f16754a
            com.google.android.exoplayer2.af r12 = r12.f15760b
            com.google.android.exoplayer2.t r2 = r11.f15750r
            r2.a((com.google.android.exoplayer2.af) r12)
            com.google.android.exoplayer2.u r2 = r11.f15752t
            com.google.android.exoplayer2.u r2 = r2.a((com.google.android.exoplayer2.af) r12)
            r11.f15752t = r2
            r11.i()
            com.google.android.exoplayer2.u r2 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r2 = r2.f16755b
            com.google.android.exoplayer2.u r3 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r3 = r3.f16755b
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x003a
            com.google.android.exoplayer2.u r3 = r11.f15752t
            long r3 = r3.f16757d
            goto L_0x003e
        L_0x003a:
            com.google.android.exoplayer2.u r3 = r11.f15752t
            long r3 = r3.f16766m
        L_0x003e:
            com.google.android.exoplayer2.m$d r5 = r11.E
            if (r5 == 0) goto L_0x0064
            r12 = 1
            android.util.Pair r12 = r11.a((com.google.android.exoplayer2.m.d) r5, (boolean) r12)
            r1 = 0
            r11.E = r1
            if (r12 != 0) goto L_0x0050
            r11.o()
            return
        L_0x0050:
            java.lang.Object r1 = r12.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            com.google.android.exoplayer2.t r5 = r11.f15750r
            java.lang.Object r12 = r12.first
            com.google.android.exoplayer2.source.i$a r12 = r5.a((java.lang.Object) r12, (long) r1)
            r6 = r12
            r9 = r1
            goto L_0x00e4
        L_0x0064:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00a0
            boolean r7 = r12.a()
            if (r7 != 0) goto L_0x00a0
            boolean r1 = r11.B
            int r1 = r12.b(r1)
            android.util.Pair r12 = r11.b((com.google.android.exoplayer2.af) r12, (int) r1, (long) r5)
            com.google.android.exoplayer2.t r1 = r11.f15750r
            java.lang.Object r2 = r12.first
            java.lang.Object r5 = r12.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            com.google.android.exoplayer2.source.i$a r1 = r1.a((java.lang.Object) r2, (long) r5)
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x009c
            java.lang.Object r12 = r12.second
            java.lang.Long r12 = (java.lang.Long) r12
            long r5 = r12.longValue()
            goto L_0x009d
        L_0x009c:
            r5 = r3
        L_0x009d:
            r9 = r5
            r6 = r1
            goto L_0x00e4
        L_0x00a0:
            java.lang.Object r7 = r2.f16367a
            int r7 = r12.a((java.lang.Object) r7)
            r8 = -1
            if (r7 != r8) goto L_0x00c2
            java.lang.Object r2 = r2.f16367a
            java.lang.Object r1 = r11.a((java.lang.Object) r2, (com.google.android.exoplayer2.af) r1, (com.google.android.exoplayer2.af) r12)
            if (r1 != 0) goto L_0x00b5
            r11.o()
            return
        L_0x00b5:
            com.google.android.exoplayer2.af$a r2 = r11.f15743k
            com.google.android.exoplayer2.af$a r1 = r12.a((java.lang.Object) r1, (com.google.android.exoplayer2.af.a) r2)
            int r1 = r1.f15168c
            android.util.Pair r12 = r11.b((com.google.android.exoplayer2.af) r12, (int) r1, (long) r5)
            goto L_0x0050
        L_0x00c2:
            com.google.android.exoplayer2.t r12 = r11.f15750r
            com.google.android.exoplayer2.u r1 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r1 = r1.f16755b
            java.lang.Object r1 = r1.f16367a
            com.google.android.exoplayer2.source.i$a r12 = r12.a((java.lang.Object) r1, (long) r3)
            com.google.android.exoplayer2.u r1 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r1 = r1.f16755b
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x00e2
            boolean r1 = r12.a()
            if (r1 != 0) goto L_0x00e2
            com.google.android.exoplayer2.u r12 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r12 = r12.f16755b
        L_0x00e2:
            r6 = r12
            r9 = r3
        L_0x00e4:
            com.google.android.exoplayer2.u r12 = r11.f15752t
            com.google.android.exoplayer2.source.i$a r12 = r12.f16755b
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0104
            int r12 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x0104
            com.google.android.exoplayer2.t r12 = r11.f15750r
            long r1 = r11.F
            long r3 = r11.n()
            boolean r12 = r12.a((long) r1, (long) r3)
            if (r12 != 0) goto L_0x0140
            r11.e((boolean) r0)
            goto L_0x0140
        L_0x0104:
            com.google.android.exoplayer2.t r12 = r11.f15750r
            com.google.android.exoplayer2.q r12 = r12.c()
            if (r12 == 0) goto L_0x012b
        L_0x010c:
            com.google.android.exoplayer2.q r1 = r12.g()
            if (r1 == 0) goto L_0x012b
            com.google.android.exoplayer2.q r12 = r12.g()
            com.google.android.exoplayer2.s r1 = r12.f15988f
            com.google.android.exoplayer2.source.i$a r1 = r1.f15997a
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x010c
            com.google.android.exoplayer2.t r1 = r11.f15750r
            com.google.android.exoplayer2.s r2 = r12.f15988f
            com.google.android.exoplayer2.s r1 = r1.a((com.google.android.exoplayer2.s) r2)
            r12.f15988f = r1
            goto L_0x010c
        L_0x012b:
            boolean r12 = r6.a()
            if (r12 == 0) goto L_0x0134
            r1 = 0
            goto L_0x0135
        L_0x0134:
            r1 = r9
        L_0x0135:
            long r7 = r11.a((com.google.android.exoplayer2.source.i.a) r6, (long) r1)
            r5 = r11
            com.google.android.exoplayer2.u r12 = r5.a((com.google.android.exoplayer2.source.i.a) r6, (long) r7, (long) r9)
            r11.f15752t = r12
        L_0x0140:
            r11.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a(com.google.android.exoplayer2.m$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.m.d r17) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            com.google.android.exoplayer2.m$c r1 = r7.f15747o
            r2 = 1
            r1.a((int) r2)
            android.util.Pair r1 = r7.a((com.google.android.exoplayer2.m.d) r0, (boolean) r2)
            r4 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0028
            com.google.android.exoplayer2.u r1 = r7.f15752t
            boolean r6 = r7.B
            com.google.android.exoplayer2.af$b r10 = r7.f15742j
            com.google.android.exoplayer2.af$a r11 = r7.f15743k
            com.google.android.exoplayer2.source.i$a r1 = r1.a(r6, r10, r11)
            r11 = r1
            r12 = r8
            r14 = r12
            r10 = 1
            goto L_0x0057
        L_0x0028:
            java.lang.Object r6 = r1.first
            java.lang.Object r10 = r1.second
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            com.google.android.exoplayer2.t r12 = r7.f15750r
            com.google.android.exoplayer2.source.i$a r6 = r12.a((java.lang.Object) r6, (long) r10)
            boolean r12 = r6.a()
            if (r12 == 0) goto L_0x0043
            r12 = r4
            r14 = r10
            r10 = 1
        L_0x0041:
            r11 = r6
            goto L_0x0057
        L_0x0043:
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r12 = r1.longValue()
            long r14 = r0.f15771c
            int r1 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0053
            r1 = 1
            goto L_0x0054
        L_0x0053:
            r1 = 0
        L_0x0054:
            r14 = r10
            r10 = r1
            goto L_0x0041
        L_0x0057:
            r6 = 2
            com.google.android.exoplayer2.source.i r1 = r7.f15753u     // Catch:{ all -> 0x00e9 }
            if (r1 == 0) goto L_0x00d1
            int r1 = r7.D     // Catch:{ all -> 0x00e9 }
            if (r1 <= 0) goto L_0x0062
            goto L_0x00d1
        L_0x0062:
            int r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0077
            r0 = 4
            r7.b((int) r0)     // Catch:{ all -> 0x00e9 }
            r2 = 0
            r3 = 0
            r4 = 1
            r5 = 0
            r0 = 1
            r1 = r16
            r8 = 2
            r6 = r0
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e7 }
            goto L_0x00d4
        L_0x0077:
            r8 = 2
            com.google.android.exoplayer2.u r0 = r7.f15752t     // Catch:{ all -> 0x00e7 }
            com.google.android.exoplayer2.source.i$a r0 = r0.f16755b     // Catch:{ all -> 0x00e7 }
            boolean r0 = r11.equals(r0)     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x00c2
            com.google.android.exoplayer2.t r0 = r7.f15750r     // Catch:{ all -> 0x00e7 }
            com.google.android.exoplayer2.q r0 = r0.c()     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x009b
            boolean r1 = r0.f15986d     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x009b
            int r1 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x009b
            com.google.android.exoplayer2.source.h r0 = r0.f15983a     // Catch:{ all -> 0x00e7 }
            com.google.android.exoplayer2.ad r1 = r7.f15751s     // Catch:{ all -> 0x00e7 }
            long r0 = r0.a((long) r12, (com.google.android.exoplayer2.ad) r1)     // Catch:{ all -> 0x00e7 }
            goto L_0x009c
        L_0x009b:
            r0 = r12
        L_0x009c:
            long r4 = com.google.android.exoplayer2.e.a(r0)     // Catch:{ all -> 0x00e7 }
            com.google.android.exoplayer2.u r6 = r7.f15752t     // Catch:{ all -> 0x00e7 }
            long r2 = r6.f16766m     // Catch:{ all -> 0x00e7 }
            long r2 = com.google.android.exoplayer2.e.a(r2)     // Catch:{ all -> 0x00e7 }
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x00c3
            com.google.android.exoplayer2.u r0 = r7.f15752t     // Catch:{ all -> 0x00e7 }
            long r3 = r0.f16766m     // Catch:{ all -> 0x00e7 }
            r1 = r16
            r2 = r11
            r5 = r14
            com.google.android.exoplayer2.u r0 = r1.a((com.google.android.exoplayer2.source.i.a) r2, (long) r3, (long) r5)
            r7.f15752t = r0
            if (r10 == 0) goto L_0x00c1
            com.google.android.exoplayer2.m$c r0 = r7.f15747o
            r0.b((int) r8)
        L_0x00c1:
            return
        L_0x00c2:
            r0 = r12
        L_0x00c3:
            long r0 = r7.a((com.google.android.exoplayer2.source.i.a) r11, (long) r0)     // Catch:{ all -> 0x00e7 }
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00cd
            r2 = 1
            goto L_0x00ce
        L_0x00cd:
            r2 = 0
        L_0x00ce:
            r10 = r10 | r2
            r3 = r0
            goto L_0x00d5
        L_0x00d1:
            r8 = 2
            r7.E = r0     // Catch:{ all -> 0x00e7 }
        L_0x00d4:
            r3 = r12
        L_0x00d5:
            r1 = r16
            r2 = r11
            r5 = r14
            com.google.android.exoplayer2.u r0 = r1.a((com.google.android.exoplayer2.source.i.a) r2, (long) r3, (long) r5)
            r7.f15752t = r0
            if (r10 == 0) goto L_0x00e6
            com.google.android.exoplayer2.m$c r0 = r7.f15747o
            r0.b((int) r8)
        L_0x00e6:
            return
        L_0x00e7:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e9:
            r0 = move-exception
            r8 = 2
        L_0x00eb:
            r1 = r16
            r2 = r11
            r3 = r12
            r5 = r14
            com.google.android.exoplayer2.u r1 = r1.a((com.google.android.exoplayer2.source.i.a) r2, (long) r3, (long) r5)
            r7.f15752t = r1
            if (r10 == 0) goto L_0x00fd
            com.google.android.exoplayer2.m$c r1 = r7.f15747o
            r1.b((int) r8)
        L_0x00fd:
            goto L_0x00ff
        L_0x00fe:
            throw r0
        L_0x00ff:
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a(com.google.android.exoplayer2.m$d):void");
    }

    private void a(q qVar) throws ExoPlaybackException {
        q c2 = this.f15750r.c();
        if (c2 != null && qVar != c2) {
            boolean[] zArr = new boolean[this.f15733a.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                z[] zVarArr = this.f15733a;
                if (i2 < zVarArr.length) {
                    z zVar = zVarArr[i2];
                    zArr[i2] = zVar.m_() != 0;
                    if (c2.i().a(i2)) {
                        i3++;
                    }
                    if (zArr[i2] && (!c2.i().a(i2) || (zVar.j() && zVar.f() == qVar.f15985c[i2]))) {
                        b(zVar);
                    }
                    i2++;
                } else {
                    this.f15752t = this.f15752t.a(c2.h(), c2.i());
                    a(zArr, i3);
                    return;
                }
            }
        }
    }

    private void a(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.h hVar) {
        this.f15737e.a(this.f15733a, trackGroupArray, hVar.f16751c);
    }

    private void a(v vVar, boolean z2) throws ExoPlaybackException {
        this.f15741i.obtainMessage(1, z2 ? 1 : 0, 0, vVar).sendToTarget();
        a(vVar.f17192b);
        for (z zVar : this.f15733a) {
            if (zVar != null) {
                zVar.a(vVar.f17192b);
            }
        }
    }

    private void a(z zVar) throws ExoPlaybackException {
        if (zVar.m_() == 2) {
            zVar.l();
        }
    }

    private void a(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.C != z2) {
            this.C = z2;
            if (!z2) {
                for (z zVar : this.f15733a) {
                    if (zVar.m_() == 0) {
                        zVar.n();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        a(z2 || !this.C, true, z3, z3, z3);
        this.f15747o.a(this.D + (z4 ? 1 : 0));
        this.D = 0;
        this.f15737e.b();
        b(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0129 A[SYNTHETIC, Splitter:B:66:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r27, boolean r28, boolean r29, boolean r30, boolean r31) {
        /*
            r26 = this;
            r1 = r26
            com.google.android.exoplayer2.util.j r0 = r1.f15739g
            r2 = 2
            r0.b(r2)
            r2 = 0
            r1.f15757y = r2
            com.google.android.exoplayer2.i r0 = r1.f15746n
            r0.b()
            r3 = 0
            r1.F = r3
            com.google.android.exoplayer2.z[] r3 = r1.f15754v
            int r4 = r3.length
            r5 = 0
        L_0x0018:
            java.lang.String r6 = "ExoPlayerImplInternal"
            if (r5 >= r4) goto L_0x002d
            r0 = r3[r5]
            r1.b((com.google.android.exoplayer2.z) r0)     // Catch:{ ExoPlaybackException -> 0x0024, RuntimeException -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r0 = move-exception
            goto L_0x0025
        L_0x0024:
            r0 = move-exception
        L_0x0025:
            java.lang.String r7 = "Disable failed."
            com.google.android.exoplayer2.util.k.b(r6, r7, r0)
        L_0x002a:
            int r5 = r5 + 1
            goto L_0x0018
        L_0x002d:
            if (r27 == 0) goto L_0x0045
            com.google.android.exoplayer2.z[] r3 = r1.f15733a
            int r4 = r3.length
            r5 = 0
        L_0x0033:
            if (r5 >= r4) goto L_0x0045
            r0 = r3[r5]
            r0.n()     // Catch:{ RuntimeException -> 0x003b }
            goto L_0x0042
        L_0x003b:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.util.k.b(r6, r0, r7)
        L_0x0042:
            int r5 = r5 + 1
            goto L_0x0033
        L_0x0045:
            com.google.android.exoplayer2.z[] r0 = new com.google.android.exoplayer2.z[r2]
            r1.f15754v = r0
            r3 = 0
            if (r29 == 0) goto L_0x004f
            r1.E = r3
            goto L_0x0088
        L_0x004f:
            if (r30 == 0) goto L_0x0088
            com.google.android.exoplayer2.m$d r0 = r1.E
            if (r0 != 0) goto L_0x0086
            com.google.android.exoplayer2.u r0 = r1.f15752t
            com.google.android.exoplayer2.af r0 = r0.f16754a
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0086
            com.google.android.exoplayer2.u r0 = r1.f15752t
            com.google.android.exoplayer2.af r0 = r0.f16754a
            com.google.android.exoplayer2.u r4 = r1.f15752t
            com.google.android.exoplayer2.source.i$a r4 = r4.f16755b
            java.lang.Object r4 = r4.f16367a
            com.google.android.exoplayer2.af$a r5 = r1.f15743k
            r0.a((java.lang.Object) r4, (com.google.android.exoplayer2.af.a) r5)
            com.google.android.exoplayer2.u r0 = r1.f15752t
            long r4 = r0.f16766m
            com.google.android.exoplayer2.af$a r0 = r1.f15743k
            long r7 = r0.c()
            long r4 = r4 + r7
            com.google.android.exoplayer2.m$d r0 = new com.google.android.exoplayer2.m$d
            com.google.android.exoplayer2.af r7 = com.google.android.exoplayer2.af.f15165a
            com.google.android.exoplayer2.af$a r8 = r1.f15743k
            int r8 = r8.f15168c
            r0.<init>(r7, r8, r4)
            r1.E = r0
        L_0x0086:
            r0 = 1
            goto L_0x008a
        L_0x0088:
            r0 = r29
        L_0x008a:
            com.google.android.exoplayer2.t r4 = r1.f15750r
            r5 = r30 ^ 1
            r4.b(r5)
            r1.f15758z = r2
            if (r30 == 0) goto L_0x00b9
            com.google.android.exoplayer2.t r4 = r1.f15750r
            com.google.android.exoplayer2.af r5 = com.google.android.exoplayer2.af.f15165a
            r4.a((com.google.android.exoplayer2.af) r5)
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r4 = r1.f15748p
            java.util.Iterator r4 = r4.iterator()
        L_0x00a2:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00b4
            java.lang.Object r5 = r4.next()
            com.google.android.exoplayer2.m$b r5 = (com.google.android.exoplayer2.m.b) r5
            com.google.android.exoplayer2.y r5 = r5.f15761a
            r5.a((boolean) r2)
            goto L_0x00a2
        L_0x00b4:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r1.f15748p
            r2.clear()
        L_0x00b9:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            if (r0 == 0) goto L_0x00c8
            boolean r4 = r1.B
            com.google.android.exoplayer2.af$b r5 = r1.f15742j
            com.google.android.exoplayer2.af$a r7 = r1.f15743k
            com.google.android.exoplayer2.source.i$a r2 = r2.a(r4, r5, r7)
            goto L_0x00ca
        L_0x00c8:
            com.google.android.exoplayer2.source.i$a r2 = r2.f16755b
        L_0x00ca:
            r19 = r2
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x00d6
            r24 = r4
            goto L_0x00dc
        L_0x00d6:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            long r7 = r2.f16766m
            r24 = r7
        L_0x00dc:
            if (r0 == 0) goto L_0x00df
            goto L_0x00e3
        L_0x00df:
            com.google.android.exoplayer2.u r0 = r1.f15752t
            long r4 = r0.f16757d
        L_0x00e3:
            r12 = r4
            com.google.android.exoplayer2.u r0 = new com.google.android.exoplayer2.u
            if (r30 == 0) goto L_0x00eb
            com.google.android.exoplayer2.af r2 = com.google.android.exoplayer2.af.f15165a
            goto L_0x00ef
        L_0x00eb:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            com.google.android.exoplayer2.af r2 = r2.f16754a
        L_0x00ef:
            r8 = r2
            com.google.android.exoplayer2.u r2 = r1.f15752t
            int r14 = r2.f16758e
            if (r31 == 0) goto L_0x00f8
            r15 = r3
            goto L_0x00fd
        L_0x00f8:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            com.google.android.exoplayer2.ExoPlaybackException r2 = r2.f16759f
            r15 = r2
        L_0x00fd:
            r16 = 0
            if (r30 == 0) goto L_0x0104
            com.google.android.exoplayer2.source.TrackGroupArray r2 = com.google.android.exoplayer2.source.TrackGroupArray.f16008a
            goto L_0x0108
        L_0x0104:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r2.f16761h
        L_0x0108:
            r17 = r2
            if (r30 == 0) goto L_0x010f
            com.google.android.exoplayer2.trackselection.h r2 = r1.f15736d
            goto L_0x0113
        L_0x010f:
            com.google.android.exoplayer2.u r2 = r1.f15752t
            com.google.android.exoplayer2.trackselection.h r2 = r2.f16762i
        L_0x0113:
            r18 = r2
            r22 = 0
            r7 = r0
            r9 = r19
            r10 = r24
            r20 = r24
            r7.<init>(r8, r9, r10, r12, r14, r15, r16, r17, r18, r19, r20, r22, r24)
            r1.f15752t = r0
            if (r28 == 0) goto L_0x0136
            com.google.android.exoplayer2.source.i r0 = r1.f15753u
            if (r0 == 0) goto L_0x0136
            r0.c(r1)     // Catch:{ RuntimeException -> 0x012d }
            goto L_0x0134
        L_0x012d:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "Failed to release child source."
            com.google.android.exoplayer2.util.k.b(r6, r0, r2)
        L_0x0134:
            r1.f15753u = r3
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a(boolean, boolean, boolean, boolean, boolean):void");
    }

    private void a(boolean[] zArr, int i2) throws ExoPlaybackException {
        this.f15754v = new z[i2];
        com.google.android.exoplayer2.trackselection.h i3 = this.f15750r.c().i();
        for (int i4 = 0; i4 < this.f15733a.length; i4++) {
            if (!i3.a(i4)) {
                this.f15733a[i4].n();
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f15733a.length; i6++) {
            if (i3.a(i6)) {
                a(i6, zArr[i6], i5);
                i5++;
            }
        }
    }

    private boolean a(b bVar) {
        if (bVar.f15764d == null) {
            Pair<Object, Long> a2 = a(new d(bVar.f15761a.a(), bVar.f15761a.g(), e.b(bVar.f15761a.f())), false);
            if (a2 == null) {
                return false;
            }
            bVar.a(this.f15752t.f16754a.a(a2.first), ((Long) a2.second).longValue(), a2.first);
            return true;
        }
        int a3 = this.f15752t.f16754a.a(bVar.f15764d);
        if (a3 == -1) {
            return false;
        }
        bVar.f15762b = a3;
        return true;
    }

    private static Format[] a(e eVar) {
        int h2 = eVar != null ? eVar.h() : 0;
        Format[] formatArr = new Format[h2];
        for (int i2 = 0; i2 < h2; i2++) {
            formatArr[i2] = eVar.a(i2);
        }
        return formatArr;
    }

    private long b(long j2) {
        q b2 = this.f15750r.b();
        if (b2 == null) {
            return 0;
        }
        return Math.max(0, j2 - b2.b(this.F));
    }

    private Pair<Object, Long> b(af afVar, int i2, long j2) {
        return afVar.a(this.f15742j, this.f15743k, i2, j2);
    }

    private void b(int i2) {
        if (this.f15752t.f16758e != i2) {
            this.f15752t = this.f15752t.a(i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (r1 > 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r3 = r7.f15748p.get(r1 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r3 == null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r3.f15762b > r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r3.f15762b != r0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r3.f15763c <= r8) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r1 <= 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r1 >= r7.f15748p.size()) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        r3 = r7.f15748p.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        if (r3 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        if (r3.f15764d == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (r3.f15762b < r0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        if (r3.f15762b != r0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r3.f15763c > r8) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
        if (r1 >= r7.f15748p.size()) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
        if (r3 == null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r3.f15764d == null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
        if (r3.f15762b != r0) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a3, code lost:
        if (r3.f15763c <= r8) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        if (r3.f15763c > r10) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        c(r3.f15761a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b6, code lost:
        if (r3.f15761a.h() != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00be, code lost:
        if (r3.f15761a.j() == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c1, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c4, code lost:
        r7.f15748p.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cf, code lost:
        if (r1 >= r7.f15748p.size()) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d1, code lost:
        r3 = r7.f15748p.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00da, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00dc, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ed, code lost:
        r7.f15748p.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f2, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f3, code lost:
        r7.G = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r7 = this;
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r0 = r7.f15748p
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f5
            com.google.android.exoplayer2.u r0 = r7.f15752t
            com.google.android.exoplayer2.source.i$a r0 = r0.f16755b
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0014
            goto L_0x00f5
        L_0x0014:
            com.google.android.exoplayer2.u r0 = r7.f15752t
            long r0 = r0.f16756c
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0023
            boolean r0 = r7.H
            if (r0 == 0) goto L_0x0023
            r0 = 1
            long r8 = r8 - r0
        L_0x0023:
            r0 = 0
            r7.H = r0
            com.google.android.exoplayer2.u r0 = r7.f15752t
            com.google.android.exoplayer2.af r0 = r0.f16754a
            com.google.android.exoplayer2.u r1 = r7.f15752t
            com.google.android.exoplayer2.source.i$a r1 = r1.f16755b
            java.lang.Object r1 = r1.f16367a
            int r0 = r0.a((java.lang.Object) r1)
            int r1 = r7.G
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r2 = r7.f15748p
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x004e
        L_0x0043:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.m$b r3 = (com.google.android.exoplayer2.m.b) r3
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            if (r3 == 0) goto L_0x0064
            int r4 = r3.f15762b
            if (r4 > r0) goto L_0x005f
            int r4 = r3.f15762b
            if (r4 != r0) goto L_0x0064
            long r3 = r3.f15763c
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0064
        L_0x005f:
            int r1 = r1 + -1
            if (r1 <= 0) goto L_0x004e
            goto L_0x0043
        L_0x0064:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0075
        L_0x006c:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.m$b r3 = (com.google.android.exoplayer2.m.b) r3
            goto L_0x0076
        L_0x0075:
            r3 = r2
        L_0x0076:
            if (r3 == 0) goto L_0x0095
            java.lang.Object r4 = r3.f15764d
            if (r4 == 0) goto L_0x0095
            int r4 = r3.f15762b
            if (r4 < r0) goto L_0x008a
            int r4 = r3.f15762b
            if (r4 != r0) goto L_0x0095
            long r4 = r3.f15763c
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0095
        L_0x008a:
            int r1 = r1 + 1
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0075
            goto L_0x006c
        L_0x0095:
            if (r3 == 0) goto L_0x00f3
            java.lang.Object r4 = r3.f15764d
            if (r4 == 0) goto L_0x00f3
            int r4 = r3.f15762b
            if (r4 != r0) goto L_0x00f3
            long r4 = r3.f15763c
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f3
            long r4 = r3.f15763c
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x00f3
            com.google.android.exoplayer2.y r4 = r3.f15761a     // Catch:{ all -> 0x00dc }
            r7.c((com.google.android.exoplayer2.y) r4)     // Catch:{ all -> 0x00dc }
            com.google.android.exoplayer2.y r4 = r3.f15761a
            boolean r4 = r4.h()
            if (r4 != 0) goto L_0x00c4
            com.google.android.exoplayer2.y r3 = r3.f15761a
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c4
        L_0x00c1:
            int r1 = r1 + 1
            goto L_0x00c9
        L_0x00c4:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            r3.remove(r1)
        L_0x00c9:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00da
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r3 = r7.f15748p
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.m$b r3 = (com.google.android.exoplayer2.m.b) r3
            goto L_0x0095
        L_0x00da:
            r3 = r2
            goto L_0x0095
        L_0x00dc:
            r8 = move-exception
            com.google.android.exoplayer2.y r9 = r3.f15761a
            boolean r9 = r9.h()
            if (r9 != 0) goto L_0x00ed
            com.google.android.exoplayer2.y r9 = r3.f15761a
            boolean r9 = r9.j()
            if (r9 == 0) goto L_0x00f2
        L_0x00ed:
            java.util.ArrayList<com.google.android.exoplayer2.m$b> r9 = r7.f15748p
            r9.remove(r1)
        L_0x00f2:
            throw r8
        L_0x00f3:
            r7.G = r1
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.b(long, long):void");
    }

    private void b(com.google.android.exoplayer2.source.i iVar, boolean z2, boolean z3) {
        this.D++;
        a(false, true, z2, z3, true);
        this.f15737e.a();
        this.f15753u = iVar;
        b(2);
        iVar.a((i.b) this, this.f15738f.b());
        this.f15739g.a(2);
    }

    private void b(v vVar) {
        this.f15746n.a(vVar);
        b(this.f15746n.d(), true);
    }

    private void b(v vVar, boolean z2) {
        this.f15739g.a(17, z2 ? 1 : 0, 0, vVar).sendToTarget();
    }

    private void b(y yVar) throws ExoPlaybackException {
        if (yVar.f() == -9223372036854775807L) {
            c(yVar);
        } else if (this.f15753u == null || this.D > 0) {
            this.f15748p.add(new b(yVar));
        } else {
            b bVar = new b(yVar);
            if (a(bVar)) {
                this.f15748p.add(bVar);
                Collections.sort(this.f15748p);
                return;
            }
            yVar.a(false);
        }
    }

    private void b(z zVar) throws ExoPlaybackException {
        this.f15746n.b(zVar);
        a(zVar);
        zVar.m();
    }

    private void c() {
        if (this.f15747o.a(this.f15752t)) {
            this.f15741i.obtainMessage(0, this.f15747o.f15766b, this.f15747o.f15767c ? this.f15747o.f15768d : -1, this.f15752t).sendToTarget();
            this.f15747o.b(this.f15752t);
        }
    }

    private void c(int i2) throws ExoPlaybackException {
        this.A = i2;
        if (!this.f15750r.a(i2)) {
            e(true);
        }
        g(false);
    }

    private void c(h hVar) throws ExoPlaybackException {
        if (this.f15750r.a(hVar)) {
            q b2 = this.f15750r.b();
            b2.a(this.f15746n.d().f17192b, this.f15752t.f16754a);
            a(b2.h(), b2.i());
            if (b2 == this.f15750r.c()) {
                a(b2.f15988f.f15998b);
                a((q) null);
            }
            w();
        }
    }

    private void c(y yVar) throws ExoPlaybackException {
        if (yVar.e().getLooper() == this.f15739g.a()) {
            e(yVar);
            if (this.f15752t.f16758e == 3 || this.f15752t.f16758e == 2) {
                this.f15739g.a(2);
                return;
            }
            return;
        }
        this.f15739g.a(16, (Object) yVar).sendToTarget();
    }

    private void c(boolean z2) throws ExoPlaybackException {
        this.f15757y = false;
        this.f15756x = z2;
        if (!z2) {
            e();
            f();
            return;
        }
        if (this.f15752t.f16758e == 3) {
            d();
        } else if (this.f15752t.f16758e != 2) {
            return;
        }
        this.f15739g.a(2);
    }

    private void d() throws ExoPlaybackException {
        this.f15757y = false;
        this.f15746n.a();
        for (z e2 : this.f15754v) {
            e2.e();
        }
    }

    private void d(h hVar) {
        if (this.f15750r.a(hVar)) {
            this.f15750r.a(this.F);
            w();
        }
    }

    private void d(y yVar) {
        Handler e2 = yVar.e();
        if (!e2.getLooper().getThread().isAlive()) {
            k.c("TAG", "Trying to send message on a dead thread.");
            yVar.a(false);
            return;
        }
        e2.post(new Runnable(yVar) {
            public final /* synthetic */ y f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                m.this.f(this.f$1);
            }
        });
    }

    private void d(boolean z2) throws ExoPlaybackException {
        this.B = z2;
        if (!this.f15750r.a(z2)) {
            e(true);
        }
        g(false);
    }

    private void e() throws ExoPlaybackException {
        this.f15746n.b();
        for (z a2 : this.f15754v) {
            a(a2);
        }
    }

    private void e(y yVar) throws ExoPlaybackException {
        if (!yVar.j()) {
            try {
                yVar.b().a(yVar.c(), yVar.d());
            } finally {
                yVar.a(true);
            }
        }
    }

    private void e(boolean z2) throws ExoPlaybackException {
        i.a aVar = this.f15750r.c().f15988f.f15997a;
        long a2 = a(aVar, this.f15752t.f16766m, true);
        if (a2 != this.f15752t.f16766m) {
            this.f15752t = a(aVar, a2, this.f15752t.f16757d);
            if (z2) {
                this.f15747o.b(4);
            }
        }
    }

    private void f() throws ExoPlaybackException {
        q c2 = this.f15750r.c();
        if (c2 != null) {
            long c3 = c2.f15986d ? c2.f15983a.c() : -9223372036854775807L;
            if (c3 != -9223372036854775807L) {
                a(c3);
                if (c3 != this.f15752t.f16766m) {
                    this.f15752t = a(this.f15752t.f16755b, c3, this.f15752t.f16757d);
                    this.f15747o.b(4);
                }
            } else {
                long a2 = this.f15746n.a(c2 != this.f15750r.d());
                this.F = a2;
                long b2 = c2.b(a2);
                b(this.f15752t.f16766m, b2);
                this.f15752t.f16766m = b2;
            }
            this.f15752t.f16764k = this.f15750r.b().d();
            this.f15752t.f16765l = A();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(y yVar) {
        try {
            e(yVar);
        } catch (ExoPlaybackException e2) {
            k.b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private boolean f(boolean z2) {
        if (this.f15754v.length == 0) {
            return l();
        }
        if (!z2) {
            return false;
        }
        if (!this.f15752t.f16760g) {
            return true;
        }
        q b2 = this.f15750r.b();
        return (b2.c() && b2.f15988f.f16003g) || this.f15737e.a(A(), this.f15746n.d().f17192b, this.f15757y);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            com.google.android.exoplayer2.util.b r1 = r0.f15749q
            long r1 = r1.b()
            r16.p()
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            r5 = 1
            if (r3 == r5) goto L_0x015d
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            r6 = 4
            if (r3 != r6) goto L_0x001b
            goto L_0x015d
        L_0x001b:
            com.google.android.exoplayer2.t r3 = r0.f15750r
            com.google.android.exoplayer2.q r3 = r3.c()
            r7 = 10
            if (r3 != 0) goto L_0x0029
            r0.a((long) r1, (long) r7)
            return
        L_0x0029:
            java.lang.String r9 = "doSomeWork"
            com.google.android.exoplayer2.util.ab.a(r9)
            r16.f()
            boolean r9 = r3.f15986d
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            if (r9 == 0) goto L_0x00b2
            long r13 = android.os.SystemClock.elapsedRealtime()
            long r13 = r13 * r10
            com.google.android.exoplayer2.source.h r9 = r3.f15983a
            com.google.android.exoplayer2.u r15 = r0.f15752t
            long r10 = r15.f16766m
            long r7 = r0.f15744l
            long r10 = r10 - r7
            boolean r7 = r0.f15745m
            r9.a((long) r10, (boolean) r7)
            r7 = 0
            r8 = 1
            r9 = 1
        L_0x004f:
            com.google.android.exoplayer2.z[] r10 = r0.f15733a
            int r11 = r10.length
            if (r7 >= r11) goto L_0x00af
            r10 = r10[r7]
            int r11 = r10.m_()
            if (r11 != 0) goto L_0x005d
            goto L_0x00ab
        L_0x005d:
            long r4 = r0.F
            r10.a(r4, r13)
            if (r8 == 0) goto L_0x006c
            boolean r4 = r10.z()
            if (r4 == 0) goto L_0x006c
            r8 = 1
            goto L_0x006d
        L_0x006c:
            r8 = 0
        L_0x006d:
            com.google.android.exoplayer2.source.o[] r4 = r3.f15985c
            r4 = r4[r7]
            com.google.android.exoplayer2.source.o r5 = r10.f()
            if (r4 == r5) goto L_0x0079
            r4 = 1
            goto L_0x007a
        L_0x0079:
            r4 = 0
        L_0x007a:
            if (r4 != 0) goto L_0x008a
            com.google.android.exoplayer2.q r5 = r3.g()
            if (r5 == 0) goto L_0x008a
            boolean r5 = r10.g()
            if (r5 == 0) goto L_0x008a
            r5 = 1
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            if (r4 != 0) goto L_0x009e
            if (r5 != 0) goto L_0x009e
            boolean r4 = r10.y()
            if (r4 != 0) goto L_0x009e
            boolean r4 = r10.z()
            if (r4 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r4 = 0
            goto L_0x009f
        L_0x009e:
            r4 = 1
        L_0x009f:
            if (r9 == 0) goto L_0x00a5
            if (r4 == 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r4 != 0) goto L_0x00ab
            r10.k()
        L_0x00ab:
            int r7 = r7 + 1
            r5 = 1
            goto L_0x004f
        L_0x00af:
            r5 = r8
            r15 = r9
            goto L_0x00b9
        L_0x00b2:
            com.google.android.exoplayer2.source.h r4 = r3.f15983a
            r4.n_()
            r5 = 1
            r15 = 1
        L_0x00b9:
            com.google.android.exoplayer2.s r4 = r3.f15988f
            long r7 = r4.f16001e
            r4 = 3
            if (r5 == 0) goto L_0x00e2
            boolean r5 = r3.f15986d
            if (r5 == 0) goto L_0x00e2
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x00d5
            com.google.android.exoplayer2.u r5 = r0.f15752t
            long r9 = r5.f16766m
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x00e2
        L_0x00d5:
            com.google.android.exoplayer2.s r3 = r3.f15988f
            boolean r3 = r3.f16003g
            if (r3 == 0) goto L_0x00e2
            r0.b((int) r6)
            r16.e()
            goto L_0x011a
        L_0x00e2:
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            r5 = 2
            if (r3 != r5) goto L_0x00fa
            boolean r3 = r0.f((boolean) r15)
            if (r3 == 0) goto L_0x00fa
            r0.b((int) r4)
            boolean r3 = r0.f15756x
            if (r3 == 0) goto L_0x011a
            r16.d()
            goto L_0x011a
        L_0x00fa:
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            if (r3 != r4) goto L_0x011a
            com.google.android.exoplayer2.z[] r3 = r0.f15754v
            int r3 = r3.length
            if (r3 != 0) goto L_0x010c
            boolean r3 = r16.l()
            if (r3 == 0) goto L_0x010e
            goto L_0x011a
        L_0x010c:
            if (r15 != 0) goto L_0x011a
        L_0x010e:
            boolean r3 = r0.f15756x
            r0.f15757y = r3
            r3 = 2
            r0.b((int) r3)
            r16.e()
            goto L_0x011b
        L_0x011a:
            r3 = 2
        L_0x011b:
            com.google.android.exoplayer2.u r5 = r0.f15752t
            int r5 = r5.f16758e
            if (r5 != r3) goto L_0x012e
            com.google.android.exoplayer2.z[] r3 = r0.f15754v
            int r5 = r3.length
        L_0x0124:
            if (r12 >= r5) goto L_0x012e
            r7 = r3[r12]
            r7.k()
            int r12 = r12 + 1
            goto L_0x0124
        L_0x012e:
            boolean r3 = r0.f15756x
            if (r3 == 0) goto L_0x0138
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            if (r3 == r4) goto L_0x013f
        L_0x0138:
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            r4 = 2
            if (r3 != r4) goto L_0x0145
        L_0x013f:
            r3 = 10
        L_0x0141:
            r0.a((long) r1, (long) r3)
            goto L_0x0159
        L_0x0145:
            com.google.android.exoplayer2.z[] r3 = r0.f15754v
            int r3 = r3.length
            if (r3 == 0) goto L_0x0153
            com.google.android.exoplayer2.u r3 = r0.f15752t
            int r3 = r3.f16758e
            if (r3 == r6) goto L_0x0153
            r3 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0141
        L_0x0153:
            com.google.android.exoplayer2.util.j r1 = r0.f15739g
            r2 = 2
            r1.b(r2)
        L_0x0159:
            com.google.android.exoplayer2.util.ab.a()
            return
        L_0x015d:
            r2 = 2
            com.google.android.exoplayer2.util.j r1 = r0.f15739g
            r1.b(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.g():void");
    }

    private void g(boolean z2) {
        q b2 = this.f15750r.b();
        i.a aVar = b2 == null ? this.f15752t.f16755b : b2.f15988f.f15997a;
        boolean z3 = !this.f15752t.f16763j.equals(aVar);
        if (z3) {
            this.f15752t = this.f15752t.a(aVar);
        }
        u uVar = this.f15752t;
        uVar.f16764k = b2 == null ? uVar.f16766m : b2.d();
        this.f15752t.f16765l = A();
        if ((z3 || z2) && b2 != null && b2.f15986d) {
            a(b2.h(), b2.i());
        }
    }

    private void h() {
        a(true, true, true, true, false);
        this.f15737e.c();
        b(1);
        this.f15740h.quit();
        synchronized (this) {
            this.f15755w = true;
            notifyAll();
        }
    }

    private void i() {
        for (int size = this.f15748p.size() - 1; size >= 0; size--) {
            if (!a(this.f15748p.get(size))) {
                this.f15748p.get(size).f15761a.a(false);
                this.f15748p.remove(size);
            }
        }
        Collections.sort(this.f15748p);
    }

    private void j() throws ExoPlaybackException {
        boolean[] zArr;
        q qVar;
        float f2 = this.f15746n.d().f17192b;
        q c2 = this.f15750r.c();
        q d2 = this.f15750r.d();
        boolean z2 = true;
        while (c2 != null && c2.f15986d) {
            com.google.android.exoplayer2.trackselection.h b2 = c2.b(f2, this.f15752t.f16754a);
            if (!b2.a(c2.i())) {
                t tVar = this.f15750r;
                if (z2) {
                    q c3 = tVar.c();
                    boolean a2 = this.f15750r.a(c3);
                    boolean[] zArr2 = new boolean[this.f15733a.length];
                    long a3 = c3.a(b2, this.f15752t.f16766m, a2, zArr2);
                    if (this.f15752t.f16758e == 4 || a3 == this.f15752t.f16766m) {
                        qVar = c3;
                        zArr = zArr2;
                    } else {
                        qVar = c3;
                        zArr = zArr2;
                        this.f15752t = a(this.f15752t.f16755b, a3, this.f15752t.f16757d);
                        this.f15747o.b(4);
                        a(a3);
                    }
                    boolean[] zArr3 = new boolean[this.f15733a.length];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        z[] zVarArr = this.f15733a;
                        if (i2 >= zVarArr.length) {
                            break;
                        }
                        z zVar = zVarArr[i2];
                        zArr3[i2] = zVar.m_() != 0;
                        o oVar = qVar.f15985c[i2];
                        if (oVar != null) {
                            i3++;
                        }
                        if (zArr3[i2]) {
                            if (oVar != zVar.f()) {
                                b(zVar);
                            } else if (zArr[i2]) {
                                zVar.a(this.F);
                            }
                        }
                        i2++;
                    }
                    this.f15752t = this.f15752t.a(qVar.h(), qVar.i());
                    a(zArr3, i3);
                } else {
                    tVar.a(c2);
                    if (c2.f15986d) {
                        c2.a(b2, Math.max(c2.f15988f.f15998b, c2.b(this.F)), false);
                    }
                }
                g(true);
                if (this.f15752t.f16758e != 4) {
                    w();
                    f();
                    this.f15739g.a(2);
                    return;
                }
                return;
            }
            if (c2 == d2) {
                z2 = false;
            }
            c2 = c2.g();
        }
    }

    private void k() {
        for (q c2 = this.f15750r.c(); c2 != null; c2 = c2.g()) {
            for (e eVar : c2.i().f16751c.a()) {
                if (eVar != null) {
                    eVar.k();
                }
            }
        }
    }

    private boolean l() {
        q c2 = this.f15750r.c();
        long j2 = c2.f15988f.f16001e;
        return c2.f15986d && (j2 == -9223372036854775807L || this.f15752t.f16766m < j2);
    }

    private void m() throws IOException {
        if (this.f15750r.b() != null) {
            z[] zVarArr = this.f15754v;
            int length = zVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (zVarArr[i2].g()) {
                    i2++;
                } else {
                    return;
                }
            }
        }
        this.f15753u.d();
    }

    private long n() {
        q d2 = this.f15750r.d();
        if (d2 == null) {
            return 0;
        }
        long a2 = d2.a();
        if (!d2.f15986d) {
            return a2;
        }
        int i2 = 0;
        while (true) {
            z[] zVarArr = this.f15733a;
            if (i2 >= zVarArr.length) {
                return a2;
            }
            if (zVarArr[i2].m_() != 0 && this.f15733a[i2].f() == d2.f15985c[i2]) {
                long h2 = this.f15733a[i2].h();
                if (h2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                a2 = Math.max(h2, a2);
            }
            i2++;
        }
    }

    private void o() {
        if (this.f15752t.f16758e != 1) {
            b(4);
        }
        a(false, false, true, false, true);
    }

    private void p() throws ExoPlaybackException, IOException {
        com.google.android.exoplayer2.source.i iVar = this.f15753u;
        if (iVar != null) {
            if (this.D > 0) {
                iVar.d();
                return;
            }
            q();
            r();
            s();
        }
    }

    private void q() throws ExoPlaybackException, IOException {
        this.f15750r.a(this.F);
        if (this.f15750r.a()) {
            s a2 = this.f15750r.a(this.F, this.f15752t);
            if (a2 == null) {
                m();
            } else {
                q a3 = this.f15750r.a(this.f15734b, this.f15735c, this.f15737e.d(), this.f15753u, a2, this.f15736d);
                a3.f15983a.a((h.a) this, a2.f15998b);
                if (this.f15750r.c() == a3) {
                    a(a3.b());
                }
                g(false);
            }
        }
        if (this.f15758z) {
            this.f15758z = y();
            z();
            return;
        }
        w();
    }

    private void r() throws ExoPlaybackException {
        q d2 = this.f15750r.d();
        if (d2 != null) {
            int i2 = 0;
            if (d2.g() == null) {
                if (d2.f15988f.f16003g) {
                    while (true) {
                        z[] zVarArr = this.f15733a;
                        if (i2 < zVarArr.length) {
                            z zVar = zVarArr[i2];
                            o oVar = d2.f15985c[i2];
                            if (oVar != null && zVar.f() == oVar && zVar.g()) {
                                zVar.i();
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (u() && d2.g().f15986d) {
                com.google.android.exoplayer2.trackselection.h i3 = d2.i();
                q e2 = this.f15750r.e();
                com.google.android.exoplayer2.trackselection.h i4 = e2.i();
                if (e2.f15983a.c() != -9223372036854775807L) {
                    v();
                    return;
                }
                int i5 = 0;
                while (true) {
                    z[] zVarArr2 = this.f15733a;
                    if (i5 < zVarArr2.length) {
                        z zVar2 = zVarArr2[i5];
                        if (i3.a(i5) && !zVar2.j()) {
                            e a2 = i4.f16751c.a(i5);
                            boolean a3 = i4.a(i5);
                            boolean z2 = this.f15734b[i5].a() == 6;
                            ab abVar = i3.f16750b[i5];
                            ab abVar2 = i4.f16750b[i5];
                            if (!a3 || !abVar2.equals(abVar) || z2) {
                                zVar2.i();
                            } else {
                                zVar2.a(a(a2), e2.f15985c[i5], e2.a());
                            }
                        }
                        i5++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void s() throws ExoPlaybackException {
        boolean z2 = false;
        while (t()) {
            if (z2) {
                c();
            }
            q c2 = this.f15750r.c();
            if (c2 == this.f15750r.d()) {
                v();
            }
            q f2 = this.f15750r.f();
            a(c2);
            this.f15752t = a(f2.f15988f.f15997a, f2.f15988f.f15998b, f2.f15988f.f15999c);
            this.f15747o.b(c2.f15988f.f16002f ? 0 : 3);
            f();
            z2 = true;
        }
    }

    private boolean t() {
        q c2;
        q g2;
        if (!this.f15756x || (c2 = this.f15750r.c()) == null || (g2 = c2.g()) == null) {
            return false;
        }
        return (c2 != this.f15750r.d() || u()) && this.F >= g2.b();
    }

    private boolean u() {
        q d2 = this.f15750r.d();
        if (!d2.f15986d) {
            return false;
        }
        int i2 = 0;
        while (true) {
            z[] zVarArr = this.f15733a;
            if (i2 >= zVarArr.length) {
                return true;
            }
            z zVar = zVarArr[i2];
            o oVar = d2.f15985c[i2];
            if (zVar.f() != oVar || (oVar != null && !zVar.g())) {
                return false;
            }
            i2++;
        }
        return false;
    }

    private void v() {
        for (z zVar : this.f15733a) {
            if (zVar.f() != null) {
                zVar.i();
            }
        }
    }

    private void w() {
        boolean x2 = x();
        this.f15758z = x2;
        if (x2) {
            this.f15750r.b().e(this.F);
        }
        z();
    }

    private boolean x() {
        if (!y()) {
            return false;
        }
        return this.f15737e.a(b(this.f15750r.b().e()), this.f15746n.d().f17192b);
    }

    private boolean y() {
        q b2 = this.f15750r.b();
        return (b2 == null || b2.e() == Long.MIN_VALUE) ? false : true;
    }

    private void z() {
        q b2 = this.f15750r.b();
        boolean z2 = this.f15758z || (b2 != null && b2.f15983a.f());
        if (z2 != this.f15752t.f16760g) {
            this.f15752t = this.f15752t.a(z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f15755w     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x002a
            android.os.HandlerThread r0 = r2.f15740h     // Catch:{ all -> 0x002c }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000e
            goto L_0x002a
        L_0x000e:
            com.google.android.exoplayer2.util.j r0 = r2.f15739g     // Catch:{ all -> 0x002c }
            r1 = 7
            r0.a(r1)     // Catch:{ all -> 0x002c }
            r0 = 0
        L_0x0015:
            boolean r1 = r2.f15755w     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x001f
            r2.wait()     // Catch:{ InterruptedException -> 0x001d }
            goto L_0x0015
        L_0x001d:
            r0 = 1
            goto L_0x0015
        L_0x001f:
            if (r0 == 0) goto L_0x0028
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002c }
            r0.interrupt()     // Catch:{ all -> 0x002c }
        L_0x0028:
            monitor-exit(r2)
            return
        L_0x002a:
            monitor-exit(r2)
            return
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0030
        L_0x002f:
            throw r0
        L_0x0030:
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.a():void");
    }

    public void a(int i2) {
        this.f15739g.a(12, i2, 0).sendToTarget();
    }

    public void a(af afVar, int i2, long j2) {
        this.f15739g.a(3, (Object) new d(afVar, i2, j2)).sendToTarget();
    }

    public void a(h hVar) {
        this.f15739g.a(9, (Object) hVar).sendToTarget();
    }

    public void a(com.google.android.exoplayer2.source.i iVar, af afVar) {
        this.f15739g.a(8, (Object) new a(iVar, afVar)).sendToTarget();
    }

    public void a(com.google.android.exoplayer2.source.i iVar, boolean z2, boolean z3) {
        this.f15739g.a(0, z2 ? 1 : 0, z3 ? 1 : 0, iVar).sendToTarget();
    }

    public void a(v vVar) {
        b(vVar, false);
    }

    public synchronized void a(y yVar) {
        if (!this.f15755w) {
            if (this.f15740h.isAlive()) {
                this.f15739g.a(15, (Object) yVar).sendToTarget();
                return;
            }
        }
        k.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        yVar.a(false);
    }

    public void a(boolean z2) {
        this.f15739g.a(1, z2 ? 1 : 0, 0).sendToTarget();
    }

    public Looper b() {
        return this.f15740h.getLooper();
    }

    /* renamed from: b */
    public void a(h hVar) {
        this.f15739g.a(10, (Object) hVar).sendToTarget();
    }

    public void b(boolean z2) {
        this.f15739g.a(13, z2 ? 1 : 0, 0).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        u uVar;
        try {
            switch (message.what) {
                case 0:
                    b((com.google.android.exoplayer2.source.i) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    a((d) message.obj);
                    break;
                case 4:
                    b((v) message.obj);
                    break;
                case 5:
                    a((ad) message.obj);
                    break;
                case 6:
                    a(false, message.arg1 != 0, true);
                    break;
                case 7:
                    h();
                    return true;
                case 8:
                    a((a) message.obj);
                    break;
                case 9:
                    c((h) message.obj);
                    break;
                case 10:
                    d((h) message.obj);
                    break;
                case 11:
                    j();
                    break;
                case 12:
                    c(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 15:
                    b((y) message.obj);
                    break;
                case 16:
                    d((y) message.obj);
                    break;
                case 17:
                    a((v) message.obj, message.arg1 != 0);
                    break;
                default:
                    return false;
            }
            c();
        } catch (ExoPlaybackException e2) {
            e = e2;
            k.b("ExoPlayerImplInternal", a(e), e);
            a(true, false, false);
            uVar = this.f15752t;
            this.f15752t = uVar.a(e);
            c();
            return true;
        } catch (IOException e3) {
            k.b("ExoPlayerImplInternal", "Source error", e3);
            a(false, false, false);
            uVar = this.f15752t;
            e = ExoPlaybackException.a(e3);
            this.f15752t = uVar.a(e);
            c();
            return true;
        } catch (OutOfMemoryError | RuntimeException e4) {
            k.b("ExoPlayerImplInternal", "Internal runtime error", e4);
            e = e4 instanceof OutOfMemoryError ? ExoPlaybackException.a((OutOfMemoryError) e4) : ExoPlaybackException.a((RuntimeException) e4);
            a(true, false, false);
            uVar = this.f15752t;
            this.f15752t = uVar.a(e);
            c();
            return true;
        }
        return true;
    }
}
