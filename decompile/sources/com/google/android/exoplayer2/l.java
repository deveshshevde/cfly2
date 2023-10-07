package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.b;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.x;
import com.google.android.exoplayer2.y;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class l extends c implements k {

    /* renamed from: b  reason: collision with root package name */
    final h f15694b;

    /* renamed from: c  reason: collision with root package name */
    private final z[] f15695c;

    /* renamed from: d  reason: collision with root package name */
    private final g f15696d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f15697e;

    /* renamed from: f  reason: collision with root package name */
    private final m f15698f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f15699g;

    /* renamed from: h  reason: collision with root package name */
    private final CopyOnWriteArrayList<c.a> f15700h;

    /* renamed from: i  reason: collision with root package name */
    private final af.a f15701i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<Runnable> f15702j;

    /* renamed from: k  reason: collision with root package name */
    private i f15703k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15704l;

    /* renamed from: m  reason: collision with root package name */
    private int f15705m;

    /* renamed from: n  reason: collision with root package name */
    private int f15706n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15707o;

    /* renamed from: p  reason: collision with root package name */
    private int f15708p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f15709q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15710r;

    /* renamed from: s  reason: collision with root package name */
    private int f15711s;

    /* renamed from: t  reason: collision with root package name */
    private v f15712t;

    /* renamed from: u  reason: collision with root package name */
    private ad f15713u;

    /* renamed from: v  reason: collision with root package name */
    private u f15714v;

    /* renamed from: w  reason: collision with root package name */
    private int f15715w;

    /* renamed from: x  reason: collision with root package name */
    private int f15716x;

    /* renamed from: y  reason: collision with root package name */
    private long f15717y;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final u f15719a;

        /* renamed from: b  reason: collision with root package name */
        private final CopyOnWriteArrayList<c.a> f15720b;

        /* renamed from: c  reason: collision with root package name */
        private final g f15721c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15722d;

        /* renamed from: e  reason: collision with root package name */
        private final int f15723e;

        /* renamed from: f  reason: collision with root package name */
        private final int f15724f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f15725g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f15726h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f15727i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f15728j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f15729k;

        /* renamed from: l  reason: collision with root package name */
        private final boolean f15730l;

        /* renamed from: m  reason: collision with root package name */
        private final boolean f15731m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f15732n;

        public a(u uVar, u uVar2, CopyOnWriteArrayList<c.a> copyOnWriteArrayList, g gVar, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5) {
            this.f15719a = uVar;
            this.f15720b = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.f15721c = gVar;
            this.f15722d = z2;
            this.f15723e = i2;
            this.f15724f = i3;
            this.f15725g = z3;
            this.f15731m = z4;
            this.f15732n = z5;
            boolean z6 = true;
            this.f15726h = uVar2.f16758e != uVar.f16758e;
            this.f15727i = (uVar2.f16759f == uVar.f16759f || uVar.f16759f == null) ? false : true;
            this.f15728j = uVar2.f16754a != uVar.f16754a;
            this.f15729k = uVar2.f16760g != uVar.f16760g;
            this.f15730l = uVar2.f16762i == uVar.f16762i ? false : z6;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(x.a aVar) {
            aVar.b(this.f15719a.f16758e == 3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(x.a aVar) {
            aVar.a(this.f15731m, this.f15719a.f16758e);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(x.a aVar) {
            aVar.a(this.f15719a.f16760g);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(x.a aVar) {
            aVar.a(this.f15719a.f16761h, this.f15719a.f16762i.f16751c);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(x.a aVar) {
            aVar.a(this.f15719a.f16759f);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(x.a aVar) {
            aVar.d(this.f15723e);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(x.a aVar) {
            aVar.a(this.f15719a.f16754a, this.f15724f);
        }

        public void run() {
            if (this.f15728j || this.f15724f == 0) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.g(aVar);
                    }
                });
            }
            if (this.f15722d) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.f(aVar);
                    }
                });
            }
            if (this.f15727i) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.e(aVar);
                    }
                });
            }
            if (this.f15730l) {
                this.f15721c.a(this.f15719a.f16762i.f16752d);
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.d(aVar);
                    }
                });
            }
            if (this.f15729k) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.c(aVar);
                    }
                });
            }
            if (this.f15726h) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.b(aVar);
                    }
                });
            }
            if (this.f15732n) {
                l.b(this.f15720b, new c.b() {
                    public final void invokeListener(x.a aVar) {
                        l.a.this.a(aVar);
                    }
                });
            }
            if (this.f15725g) {
                l.b(this.f15720b, $$Lambda$6ExWItExnQUKTxWQSUl_hWYMMOs.INSTANCE);
            }
        }
    }

    public l(z[] zVarArr, g gVar, p pVar, com.google.android.exoplayer2.upstream.c cVar, b bVar, Looper looper) {
        z[] zVarArr2 = zVarArr;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = ad.f11759e;
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.11.7");
        sb.append("] [");
        sb.append(str);
        sb.append("]");
        k.b("ExoPlayerImpl", sb.toString());
        com.google.android.exoplayer2.util.a.b(zVarArr2.length > 0);
        this.f15695c = (z[]) com.google.android.exoplayer2.util.a.b(zVarArr);
        this.f15696d = (g) com.google.android.exoplayer2.util.a.b(gVar);
        this.f15704l = false;
        this.f15706n = 0;
        this.f15707o = false;
        this.f15700h = new CopyOnWriteArrayList<>();
        h hVar = new h(new ab[zVarArr2.length], new e[zVarArr2.length], (Object) null);
        this.f15694b = hVar;
        this.f15701i = new af.a();
        this.f15712t = v.f17191a;
        this.f15713u = ad.f15126e;
        this.f15705m = 0;
        AnonymousClass1 r10 = new Handler(looper) {
            public void handleMessage(Message message) {
                l.this.a(message);
            }
        };
        this.f15697e = r10;
        this.f15714v = u.a(0, hVar);
        this.f15702j = new ArrayDeque<>();
        m mVar = new m(zVarArr, gVar, hVar, pVar, cVar, this.f15704l, this.f15706n, this.f15707o, r10, bVar);
        this.f15698f = mVar;
        this.f15699g = new Handler(mVar.b());
    }

    private boolean F() {
        return this.f15714v.f16754a.a() || this.f15708p > 0;
    }

    private long a(i.a aVar, long j2) {
        long a2 = e.a(j2);
        this.f15714v.f16754a.a(aVar.f16367a, this.f15701i);
        return a2 + this.f15701i.b();
    }

    private u a(boolean z2, boolean z3, boolean z4, int i2) {
        long j2 = 0;
        boolean z5 = false;
        if (z2) {
            this.f15715w = 0;
            this.f15716x = 0;
            this.f15717y = 0;
        } else {
            this.f15715w = t();
            this.f15716x = s();
            this.f15717y = v();
        }
        if (z2 || z3) {
            z5 = true;
        }
        u uVar = this.f15714v;
        i.a a2 = z5 ? uVar.a(this.f15707o, this.f15418a, this.f15701i) : uVar.f16755b;
        if (!z5) {
            j2 = this.f15714v.f16766m;
        }
        long j3 = j2;
        return new u(z3 ? af.f15165a : this.f15714v.f16754a, a2, j3, z5 ? -9223372036854775807L : this.f15714v.f16757d, i2, z4 ? null : this.f15714v.f16759f, false, z3 ? TrackGroupArray.f16008a : this.f15714v.f16761h, z3 ? this.f15694b : this.f15714v.f16762i, a2, j3, 0, j3);
    }

    private void a(c.b bVar) {
        a((Runnable) new Runnable(new CopyOnWriteArrayList(this.f15700h), bVar) {
            public final /* synthetic */ CopyOnWriteArrayList f$0;
            public final /* synthetic */ c.b f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                l.b(this.f$0, this.f$1);
            }
        });
    }

    private void a(u uVar, int i2, boolean z2, int i3) {
        int i4 = this.f15708p - i2;
        this.f15708p = i4;
        if (i4 == 0) {
            if (uVar.f16756c == -9223372036854775807L) {
                uVar = uVar.a(uVar.f16755b, 0, uVar.f16757d, uVar.f16765l);
            }
            u uVar2 = uVar;
            if (!this.f15714v.f16754a.a() && uVar2.f16754a.a()) {
                this.f15716x = 0;
                this.f15715w = 0;
                this.f15717y = 0;
            }
            int i5 = this.f15709q ? 0 : 2;
            boolean z3 = this.f15710r;
            this.f15709q = false;
            this.f15710r = false;
            a(uVar2, z2, i3, i5, z3);
        }
    }

    private void a(u uVar, boolean z2, int i2, int i3, boolean z3) {
        boolean a2 = a();
        u uVar2 = this.f15714v;
        this.f15714v = uVar;
        a((Runnable) new a(uVar, uVar2, this.f15700h, this.f15696d, z2, i2, i3, z3, this.f15704l, a2 != a()));
    }

    private void a(v vVar, boolean z2) {
        if (z2) {
            this.f15711s--;
        }
        if (this.f15711s == 0 && !this.f15712t.equals(vVar)) {
            this.f15712t = vVar;
            a((c.b) new c.b() {
                public final void invokeListener(x.a aVar) {
                    aVar.a(v.this);
                }
            });
        }
    }

    private void a(Runnable runnable) {
        boolean z2 = !this.f15702j.isEmpty();
        this.f15702j.addLast(runnable);
        if (!z2) {
            while (!this.f15702j.isEmpty()) {
                this.f15702j.peekFirst().run();
                this.f15702j.removeFirst();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, boolean z3, int i2, boolean z4, int i3, boolean z5, boolean z6, x.a aVar) {
        if (z2) {
            aVar.a(z3, i2);
        }
        if (z4) {
            aVar.b(i3);
        }
        if (z5) {
            aVar.b(z6);
        }
    }

    /* access modifiers changed from: private */
    public static void b(CopyOnWriteArrayList<c.a> copyOnWriteArrayList, c.b bVar) {
        Iterator<c.a> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            it2.next().a(bVar);
        }
    }

    public long A() {
        if (!x()) {
            return v();
        }
        this.f15714v.f16754a.a(this.f15714v.f16755b.f16367a, this.f15701i);
        return this.f15714v.f16757d == -9223372036854775807L ? this.f15714v.f16754a.a(t(), this.f15418a).a() : this.f15701i.b() + e.a(this.f15714v.f16757d);
    }

    public long B() {
        if (F()) {
            return this.f15717y;
        }
        int i2 = (this.f15714v.f16763j.f16370d > this.f15714v.f16755b.f16370d ? 1 : (this.f15714v.f16763j.f16370d == this.f15714v.f16755b.f16370d ? 0 : -1));
        u uVar = this.f15714v;
        if (i2 != 0) {
            return uVar.f16754a.a(t(), this.f15418a).c();
        }
        long j2 = uVar.f16764k;
        if (this.f15714v.f16763j.a()) {
            af.a a2 = this.f15714v.f16754a.a(this.f15714v.f16763j.f16367a, this.f15701i);
            long a3 = a2.a(this.f15714v.f16763j.f16368b);
            j2 = a3 == Long.MIN_VALUE ? a2.f15169d : a3;
        }
        return a(this.f15714v.f16763j, j2);
    }

    public TrackGroupArray C() {
        return this.f15714v.f16761h;
    }

    public f D() {
        return this.f15714v.f16762i.f16751c;
    }

    public af E() {
        return this.f15714v.f16754a;
    }

    public y a(y.b bVar) {
        return new y(this.f15698f, bVar, this.f15714v.f16754a, t(), this.f15699g);
    }

    public void a(int i2) {
        if (this.f15706n != i2) {
            this.f15706n = i2;
            this.f15698f.a(i2);
            a((c.b) new c.b(i2) {
                public final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(x.a aVar) {
                    aVar.c(this.f$0);
                }
            });
        }
    }

    public void a(int i2, long j2) {
        af afVar = this.f15714v.f16754a;
        if (i2 < 0 || (!afVar.a() && i2 >= afVar.b())) {
            throw new IllegalSeekPositionException(afVar, i2, j2);
        }
        this.f15710r = true;
        this.f15708p++;
        if (x()) {
            k.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.f15697e.obtainMessage(0, 1, -1, this.f15714v).sendToTarget();
            return;
        }
        this.f15715w = i2;
        if (afVar.a()) {
            this.f15717y = j2 == -9223372036854775807L ? 0 : j2;
            this.f15716x = 0;
        } else {
            long b2 = j2 == -9223372036854775807L ? afVar.a(i2, this.f15418a).b() : e.b(j2);
            Pair<Object, Long> a2 = afVar.a(this.f15418a, this.f15701i, i2, b2);
            this.f15717y = e.a(b2);
            this.f15716x = afVar.a(a2.first);
        }
        this.f15698f.a(afVar, i2, e.b(j2));
        a((c.b) $$Lambda$l$6kElAadK6_8MsshZyrRSjDQJR68.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public void a(Message message) {
        int i2 = message.what;
        boolean z2 = false;
        if (i2 == 0) {
            u uVar = (u) message.obj;
            int i3 = message.arg1;
            if (message.arg2 != -1) {
                z2 = true;
            }
            a(uVar, i3, z2, message.arg2);
        } else if (i2 == 1) {
            v vVar = (v) message.obj;
            if (message.arg1 != 0) {
                z2 = true;
            }
            a(vVar, z2);
        } else {
            throw new IllegalStateException();
        }
    }

    public void a(i iVar, boolean z2, boolean z3) {
        this.f15703k = iVar;
        u a2 = a(z2, z3, true, 2);
        this.f15709q = true;
        this.f15708p++;
        this.f15698f.a(iVar, z2, z3);
        a(a2, false, 4, 1, false);
    }

    public void a(x.a aVar) {
        this.f15700h.addIfAbsent(new c.a(aVar));
    }

    public void a(boolean z2) {
        a(z2, 0);
    }

    public void a(boolean z2, int i2) {
        boolean a2 = a();
        boolean z3 = this.f15704l && this.f15705m == 0;
        boolean z4 = z2 && i2 == 0;
        if (z3 != z4) {
            this.f15698f.a(z4);
        }
        boolean z5 = this.f15704l != z2;
        boolean z6 = this.f15705m != i2;
        this.f15704l = z2;
        this.f15705m = i2;
        boolean a3 = a();
        boolean z7 = a2 != a3;
        if (z5 || z6 || z7) {
            a((c.b) new c.b(z5, z2, this.f15714v.f16758e, z6, i2, z7, a3) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ int f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ boolean f$6;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void invokeListener(x.a aVar) {
                    l.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, aVar);
                }
            });
        }
    }

    public int b(int i2) {
        return this.f15695c[i2].a();
    }

    public void b(x.a aVar) {
        Iterator<c.a> it2 = this.f15700h.iterator();
        while (it2.hasNext()) {
            c.a next = it2.next();
            if (next.f15419a.equals(aVar)) {
                next.a();
                this.f15700h.remove(next);
            }
        }
    }

    public void b(boolean z2) {
        if (this.f15707o != z2) {
            this.f15707o = z2;
            this.f15698f.b(z2);
            a((c.b) new c.b(z2) {
                public final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(x.a aVar) {
                    aVar.c(this.f$0);
                }
            });
        }
    }

    public x.c h() {
        return null;
    }

    public x.b i() {
        return null;
    }

    public Looper j() {
        return this.f15697e.getLooper();
    }

    public int k() {
        return this.f15714v.f16758e;
    }

    public int l() {
        return this.f15705m;
    }

    public ExoPlaybackException m() {
        return this.f15714v.f16759f;
    }

    public boolean n() {
        return this.f15704l;
    }

    public int o() {
        return this.f15706n;
    }

    public boolean p() {
        return this.f15707o;
    }

    public v q() {
        return this.f15712t;
    }

    public void r() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = ad.f11759e;
        String a2 = n.a();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(a2).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.11.7");
        sb.append("] [");
        sb.append(str);
        sb.append("] [");
        sb.append(a2);
        sb.append("]");
        k.b("ExoPlayerImpl", sb.toString());
        this.f15703k = null;
        this.f15698f.a();
        this.f15697e.removeCallbacksAndMessages((Object) null);
        this.f15714v = a(false, false, false, 1);
    }

    public int s() {
        return F() ? this.f15716x : this.f15714v.f16754a.a(this.f15714v.f16755b.f16367a);
    }

    public int t() {
        return F() ? this.f15715w : this.f15714v.f16754a.a(this.f15714v.f16755b.f16367a, this.f15701i).f15168c;
    }

    public long u() {
        if (!x()) {
            return g();
        }
        i.a aVar = this.f15714v.f16755b;
        this.f15714v.f16754a.a(aVar.f16367a, this.f15701i);
        return e.a(this.f15701i.c(aVar.f16368b, aVar.f16369c));
    }

    public long v() {
        return F() ? this.f15717y : this.f15714v.f16755b.a() ? e.a(this.f15714v.f16766m) : a(this.f15714v.f16755b, this.f15714v.f16766m);
    }

    public long w() {
        return e.a(this.f15714v.f16765l);
    }

    public boolean x() {
        return !F() && this.f15714v.f16755b.a();
    }

    public int y() {
        if (x()) {
            return this.f15714v.f16755b.f16368b;
        }
        return -1;
    }

    public int z() {
        if (x()) {
            return this.f15714v.f16755b.f16369c;
        }
        return -1;
    }
}
