package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.a;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private final af.a f16565a = new af.a();

    /* renamed from: b  reason: collision with root package name */
    private final af.b f16566b = new af.b();

    /* renamed from: c  reason: collision with root package name */
    private long f16567c;

    /* renamed from: d  reason: collision with root package name */
    private af f16568d = af.f15165a;

    /* renamed from: e  reason: collision with root package name */
    private int f16569e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16570f;

    /* renamed from: g  reason: collision with root package name */
    private q f16571g;

    /* renamed from: h  reason: collision with root package name */
    private q f16572h;

    /* renamed from: i  reason: collision with root package name */
    private q f16573i;

    /* renamed from: j  reason: collision with root package name */
    private int f16574j;

    /* renamed from: k  reason: collision with root package name */
    private Object f16575k;

    /* renamed from: l  reason: collision with root package name */
    private long f16576l;

    private long a(Object obj) {
        q qVar;
        int a2;
        int i2 = this.f16568d.a(obj, this.f16565a).f15168c;
        Object obj2 = this.f16575k;
        if (obj2 != null && (a2 = this.f16568d.a(obj2)) != -1 && this.f16568d.a(a2, this.f16565a).f15168c == i2) {
            return this.f16576l;
        }
        q qVar2 = this.f16571g;
        while (true) {
            if (qVar == null) {
                qVar = this.f16571g;
                while (qVar != null) {
                    int a3 = this.f16568d.a(qVar.f15984b);
                    if (a3 == -1 || this.f16568d.a(a3, this.f16565a).f15168c != i2) {
                        qVar = qVar.g();
                    }
                }
                long j2 = this.f16567c;
                this.f16567c = 1 + j2;
                if (this.f16571g == null) {
                    this.f16575k = obj;
                    this.f16576l = j2;
                }
                return j2;
            } else if (qVar.f15984b.equals(obj)) {
                break;
            } else {
                qVar2 = qVar.g();
            }
        }
        return qVar.f15988f.f15997a.f16370d;
    }

    private s a(q qVar, long j2) {
        long j3;
        long j4;
        long j5;
        Object obj;
        long j6;
        s sVar = qVar.f15988f;
        long a2 = (qVar.a() + sVar.f16001e) - j2;
        long j7 = 0;
        if (sVar.f16002f) {
            int a3 = this.f16568d.a(this.f16568d.a(sVar.f15997a.f16367a), this.f16565a, this.f16566b, this.f16569e, this.f16570f);
            if (a3 == -1) {
                return null;
            }
            int i2 = this.f16568d.a(a3, this.f16565a, true).f15168c;
            Object obj2 = this.f16565a.f15167b;
            long j8 = sVar.f15997a.f16370d;
            if (this.f16568d.a(i2, this.f16566b).f15181j == a3) {
                Pair<Object, Long> a4 = this.f16568d.a(this.f16566b, this.f16565a, i2, -9223372036854775807L, Math.max(0, a2));
                if (a4 == null) {
                    return null;
                }
                Object obj3 = a4.first;
                long longValue = ((Long) a4.second).longValue();
                q g2 = qVar.g();
                if (g2 == null || !g2.f15984b.equals(obj3)) {
                    j6 = this.f16567c;
                    this.f16567c = 1 + j6;
                } else {
                    j6 = g2.f15988f.f15997a.f16370d;
                }
                j4 = longValue;
                j7 = -9223372036854775807L;
                j5 = j6;
                obj = obj3;
            } else {
                obj = obj2;
                j5 = j8;
                j4 = 0;
            }
            return a(a(obj, j4, j5), j7, j4);
        }
        i.a aVar = sVar.f15997a;
        this.f16568d.a(aVar.f16367a, this.f16565a);
        if (aVar.a()) {
            int i3 = aVar.f16368b;
            int d2 = this.f16565a.d(i3);
            if (d2 == -1) {
                return null;
            }
            int a5 = this.f16565a.a(i3, aVar.f16369c);
            if (a5 >= d2) {
                long j9 = sVar.f15999c;
                if (j9 == -9223372036854775807L) {
                    af afVar = this.f16568d;
                    af.b bVar = this.f16566b;
                    af.a aVar2 = this.f16565a;
                    Pair<Object, Long> a6 = afVar.a(bVar, aVar2, aVar2.f15168c, -9223372036854775807L, Math.max(0, a2));
                    if (a6 == null) {
                        return null;
                    }
                    j3 = ((Long) a6.second).longValue();
                } else {
                    j3 = j9;
                }
                return b(aVar.f16367a, j3, aVar.f16370d);
            } else if (!this.f16565a.b(i3, a5)) {
                return null;
            } else {
                return a(aVar.f16367a, i3, a5, sVar.f15999c, aVar.f16370d);
            }
        } else {
            int a7 = this.f16565a.a(sVar.f16000d);
            if (a7 == -1) {
                return b(aVar.f16367a, sVar.f16001e, aVar.f16370d);
            }
            int b2 = this.f16565a.b(a7);
            if (!this.f16565a.b(a7, b2)) {
                return null;
            }
            return a(aVar.f16367a, a7, b2, sVar.f16001e, aVar.f16370d);
        }
    }

    private s a(i.a aVar, long j2, long j3) {
        this.f16568d.a(aVar.f16367a, this.f16565a);
        if (!aVar.a()) {
            return b(aVar.f16367a, j3, aVar.f16370d);
        } else if (!this.f16565a.b(aVar.f16368b, aVar.f16369c)) {
            return null;
        } else {
            return a(aVar.f16367a, aVar.f16368b, aVar.f16369c, j2, aVar.f16370d);
        }
    }

    private s a(u uVar) {
        return a(uVar.f16755b, uVar.f16757d, uVar.f16756c);
    }

    private s a(Object obj, int i2, int i3, long j2, long j3) {
        i.a aVar = new i.a(obj, i2, i3, j3);
        return new s(aVar, i3 == this.f16565a.b(i2) ? this.f16565a.e() : 0, j2, -9223372036854775807L, this.f16568d.a(aVar.f16367a, this.f16565a).c(aVar.f16368b, aVar.f16369c), false, false);
    }

    private i.a a(Object obj, long j2, long j3) {
        this.f16568d.a(obj, this.f16565a);
        int a2 = this.f16565a.a(j2);
        if (a2 == -1) {
            return new i.a(obj, j3, this.f16565a.b(j2));
        }
        return new i.a(obj, a2, this.f16565a.b(a2), j3);
    }

    private boolean a(s sVar, s sVar2) {
        return sVar.f15998b == sVar2.f15998b && sVar.f15997a.equals(sVar2.f15997a);
    }

    private boolean a(i.a aVar) {
        return !aVar.a() && aVar.f16371e == -1;
    }

    private boolean a(i.a aVar, boolean z2) {
        int a2 = this.f16568d.a(aVar.f16367a);
        return !this.f16568d.a(this.f16568d.a(a2, this.f16565a).f15168c, this.f16566b).f15179h && this.f16568d.b(a2, this.f16565a, this.f16566b, this.f16569e, this.f16570f) && z2;
    }

    private s b(Object obj, long j2, long j3) {
        int b2 = this.f16565a.b(j2);
        Object obj2 = obj;
        i.a aVar = new i.a(obj, j3, b2);
        boolean a2 = a(aVar);
        boolean a3 = a(aVar, a2);
        long a4 = b2 != -1 ? this.f16565a.a(b2) : -9223372036854775807L;
        return new s(aVar, j2, -9223372036854775807L, a4, (a4 == -9223372036854775807L || a4 == Long.MIN_VALUE) ? this.f16565a.f15169d : a4, a2, a3);
    }

    private boolean b(long j2, long j3) {
        return j2 == -9223372036854775807L || j2 == j3;
    }

    private boolean g() {
        q qVar = this.f16571g;
        if (qVar == null) {
            return true;
        }
        int a2 = this.f16568d.a(qVar.f15984b);
        while (true) {
            a2 = this.f16568d.a(a2, this.f16565a, this.f16566b, this.f16569e, this.f16570f);
            while (qVar.g() != null && !qVar.f15988f.f16002f) {
                qVar = qVar.g();
            }
            q g2 = qVar.g();
            if (a2 == -1 || g2 == null || this.f16568d.a(g2.f15984b) != a2) {
                boolean a3 = a(qVar);
                qVar.f15988f = a(qVar.f15988f);
            } else {
                qVar = g2;
            }
        }
        boolean a32 = a(qVar);
        qVar.f15988f = a(qVar.f15988f);
        return !a32;
    }

    public q a(aa[] aaVarArr, g gVar, b bVar, i iVar, s sVar, h hVar) {
        s sVar2 = sVar;
        q qVar = this.f16573i;
        q qVar2 = new q(aaVarArr, qVar == null ? (!sVar2.f15997a.a() || sVar2.f15999c == -9223372036854775807L) ? 0 : sVar2.f15999c : (qVar.a() + this.f16573i.f15988f.f16001e) - sVar2.f15998b, gVar, bVar, iVar, sVar, hVar);
        q qVar3 = this.f16573i;
        if (qVar3 != null) {
            qVar3.a(qVar2);
        } else {
            this.f16571g = qVar2;
            this.f16572h = qVar2;
        }
        this.f16575k = null;
        this.f16573i = qVar2;
        this.f16574j++;
        return qVar2;
    }

    public s a(long j2, u uVar) {
        q qVar = this.f16573i;
        return qVar == null ? a(uVar) : a(qVar, j2);
    }

    public s a(s sVar) {
        i.a aVar = sVar.f15997a;
        boolean a2 = a(aVar);
        boolean a3 = a(aVar, a2);
        this.f16568d.a(sVar.f15997a.f16367a, this.f16565a);
        return new s(aVar, sVar.f15998b, sVar.f15999c, sVar.f16000d, aVar.a() ? this.f16565a.c(aVar.f16368b, aVar.f16369c) : (sVar.f16000d == -9223372036854775807L || sVar.f16000d == Long.MIN_VALUE) ? this.f16565a.a() : sVar.f16000d, a2, a3);
    }

    public i.a a(Object obj, long j2) {
        return a(obj, j2, a(obj));
    }

    public void a(long j2) {
        q qVar = this.f16573i;
        if (qVar != null) {
            qVar.d(j2);
        }
    }

    public void a(af afVar) {
        this.f16568d = afVar;
    }

    public boolean a() {
        q qVar = this.f16573i;
        return qVar == null || (!qVar.f15988f.f16003g && this.f16573i.c() && this.f16573i.f15988f.f16001e != -9223372036854775807L && this.f16574j < 100);
    }

    public boolean a(int i2) {
        this.f16569e = i2;
        return g();
    }

    public boolean a(long j2, long j3) {
        s sVar;
        q qVar = this.f16571g;
        q qVar2 = null;
        while (qVar != null) {
            s sVar2 = qVar.f15988f;
            if (qVar2 == null) {
                sVar = a(sVar2);
            } else {
                s a2 = a(qVar2, j2);
                if (a2 == null) {
                    return !a(qVar2);
                }
                if (!a(sVar2, a2)) {
                    return !a(qVar2);
                }
                sVar = a2;
            }
            qVar.f15988f = sVar.b(sVar2.f15999c);
            if (!b(sVar2.f16001e, sVar.f16001e)) {
                return !a(qVar) && !(qVar == this.f16572h && ((j3 > Long.MIN_VALUE ? 1 : (j3 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j3 > ((sVar.f16001e > -9223372036854775807L ? 1 : (sVar.f16001e == -9223372036854775807L ? 0 : -1)) == 0 ? Long.MAX_VALUE : qVar.a(sVar.f16001e)) ? 1 : (j3 == ((sVar.f16001e > -9223372036854775807L ? 1 : (sVar.f16001e == -9223372036854775807L ? 0 : -1)) == 0 ? Long.MAX_VALUE : qVar.a(sVar.f16001e)) ? 0 : -1)) >= 0));
            }
            qVar2 = qVar;
            qVar = qVar.g();
        }
        return true;
    }

    public boolean a(q qVar) {
        boolean z2 = false;
        a.b(qVar != null);
        this.f16573i = qVar;
        while (qVar.g() != null) {
            qVar = qVar.g();
            if (qVar == this.f16572h) {
                this.f16572h = this.f16571g;
                z2 = true;
            }
            qVar.f();
            this.f16574j--;
        }
        this.f16573i.a((q) null);
        return z2;
    }

    public boolean a(com.google.android.exoplayer2.source.h hVar) {
        q qVar = this.f16573i;
        return qVar != null && qVar.f15983a == hVar;
    }

    public boolean a(boolean z2) {
        this.f16570f = z2;
        return g();
    }

    public q b() {
        return this.f16573i;
    }

    public void b(boolean z2) {
        q qVar = this.f16571g;
        if (qVar != null) {
            this.f16575k = z2 ? qVar.f15984b : null;
            this.f16576l = qVar.f15988f.f15997a.f16370d;
            a(qVar);
            qVar.f();
        } else if (!z2) {
            this.f16575k = null;
        }
        this.f16571g = null;
        this.f16573i = null;
        this.f16572h = null;
        this.f16574j = 0;
    }

    public q c() {
        return this.f16571g;
    }

    public q d() {
        return this.f16572h;
    }

    public q e() {
        q qVar = this.f16572h;
        a.b((qVar == null || qVar.g() == null) ? false : true);
        q g2 = this.f16572h.g();
        this.f16572h = g2;
        return g2;
    }

    public q f() {
        q qVar = this.f16571g;
        if (qVar == null) {
            return null;
        }
        if (qVar == this.f16572h) {
            this.f16572h = qVar.g();
        }
        this.f16571g.f();
        int i2 = this.f16574j - 1;
        this.f16574j = i2;
        if (i2 == 0) {
            this.f16573i = null;
            this.f16575k = this.f16571g.f15984b;
            this.f16576l = this.f16571g.f15988f.f15997a.f16370d;
        }
        q g2 = this.f16571g.g();
        this.f16571g = g2;
        return g2;
    }
}
