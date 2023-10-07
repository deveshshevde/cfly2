package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.k;

final class q {

    /* renamed from: a  reason: collision with root package name */
    public final h f15983a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f15984b;

    /* renamed from: c  reason: collision with root package name */
    public final o[] f15985c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15986d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15987e;

    /* renamed from: f  reason: collision with root package name */
    public s f15988f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean[] f15989g;

    /* renamed from: h  reason: collision with root package name */
    private final aa[] f15990h;

    /* renamed from: i  reason: collision with root package name */
    private final g f15991i;

    /* renamed from: j  reason: collision with root package name */
    private final i f15992j;

    /* renamed from: k  reason: collision with root package name */
    private q f15993k;

    /* renamed from: l  reason: collision with root package name */
    private TrackGroupArray f15994l = TrackGroupArray.f16008a;

    /* renamed from: m  reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.h f15995m;

    /* renamed from: n  reason: collision with root package name */
    private long f15996n;

    public q(aa[] aaVarArr, long j2, g gVar, b bVar, i iVar, s sVar, com.google.android.exoplayer2.trackselection.h hVar) {
        this.f15990h = aaVarArr;
        this.f15996n = j2;
        this.f15991i = gVar;
        this.f15992j = iVar;
        this.f15984b = sVar.f15997a.f16367a;
        this.f15988f = sVar;
        this.f15995m = hVar;
        this.f15985c = new o[aaVarArr.length];
        this.f15989g = new boolean[aaVarArr.length];
        this.f15983a = a(sVar.f15997a, iVar, bVar, sVar.f15998b, sVar.f16000d);
    }

    private static h a(i.a aVar, i iVar, b bVar, long j2, long j3) {
        h a2 = iVar.a(aVar, bVar, j2);
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? a2 : new com.google.android.exoplayer2.source.b(a2, true, 0, j3);
    }

    private static void a(long j2, i iVar, h hVar) {
        if (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) {
            iVar.a(hVar);
            return;
        }
        try {
            iVar.a(((com.google.android.exoplayer2.source.b) hVar).f16018a);
        } catch (RuntimeException e2) {
            k.b("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    private void a(o[] oVarArr) {
        int i2 = 0;
        while (true) {
            aa[] aaVarArr = this.f15990h;
            if (i2 < aaVarArr.length) {
                if (aaVarArr[i2].a() == 6) {
                    oVarArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void b(o[] oVarArr) {
        int i2 = 0;
        while (true) {
            aa[] aaVarArr = this.f15990h;
            if (i2 < aaVarArr.length) {
                if (aaVarArr[i2].a() == 6 && this.f15995m.a(i2)) {
                    oVarArr[i2] = new f();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void j() {
        if (l()) {
            for (int i2 = 0; i2 < this.f15995m.f16749a; i2++) {
                boolean a2 = this.f15995m.a(i2);
                e a3 = this.f15995m.f16751c.a(i2);
                if (a2 && a3 != null) {
                    a3.d();
                }
            }
        }
    }

    private void k() {
        if (l()) {
            for (int i2 = 0; i2 < this.f15995m.f16749a; i2++) {
                boolean a2 = this.f15995m.a(i2);
                e a3 = this.f15995m.f16751c.a(i2);
                if (a2 && a3 != null) {
                    a3.f();
                }
            }
        }
    }

    private boolean l() {
        return this.f15993k == null;
    }

    public long a() {
        return this.f15996n;
    }

    public long a(long j2) {
        return j2 + a();
    }

    public long a(com.google.android.exoplayer2.trackselection.h hVar, long j2, boolean z2) {
        return a(hVar, j2, z2, new boolean[this.f15990h.length]);
    }

    public long a(com.google.android.exoplayer2.trackselection.h hVar, long j2, boolean z2, boolean[] zArr) {
        com.google.android.exoplayer2.trackselection.h hVar2 = hVar;
        int i2 = 0;
        while (true) {
            boolean z3 = true;
            if (i2 >= hVar2.f16749a) {
                break;
            }
            boolean[] zArr2 = this.f15989g;
            if (z2 || !hVar.a(this.f15995m, i2)) {
                z3 = false;
            }
            zArr2[i2] = z3;
            i2++;
        }
        a(this.f15985c);
        k();
        this.f15995m = hVar2;
        j();
        com.google.android.exoplayer2.trackselection.f fVar = hVar2.f16751c;
        long a2 = this.f15983a.a(fVar.a(), this.f15989g, this.f15985c, zArr, j2);
        b(this.f15985c);
        this.f15987e = false;
        int i3 = 0;
        while (true) {
            o[] oVarArr = this.f15985c;
            if (i3 >= oVarArr.length) {
                return a2;
            }
            if (oVarArr[i3] != null) {
                a.b(hVar.a(i3));
                if (this.f15990h[i3].a() != 6) {
                    this.f15987e = true;
                }
            } else {
                a.b(fVar.a(i3) == null);
            }
            i3++;
        }
    }

    public void a(float f2, af afVar) throws ExoPlaybackException {
        this.f15986d = true;
        this.f15994l = this.f15983a.b();
        long a2 = a(b(f2, afVar), this.f15988f.f15998b, false);
        this.f15996n += this.f15988f.f15998b - a2;
        this.f15988f = this.f15988f.a(a2);
    }

    public void a(q qVar) {
        if (qVar != this.f15993k) {
            k();
            this.f15993k = qVar;
            j();
        }
    }

    public long b() {
        return this.f15988f.f15998b + this.f15996n;
    }

    public long b(long j2) {
        return j2 - a();
    }

    public com.google.android.exoplayer2.trackselection.h b(float f2, af afVar) throws ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.h a2 = this.f15991i.a(this.f15990h, h(), this.f15988f.f15997a, afVar);
        for (e eVar : a2.f16751c.a()) {
            if (eVar != null) {
                eVar.a(f2);
            }
        }
        return a2;
    }

    public void c(long j2) {
        this.f15996n = j2;
    }

    public boolean c() {
        return this.f15986d && (!this.f15987e || this.f15983a.d() == Long.MIN_VALUE);
    }

    public long d() {
        if (!this.f15986d) {
            return this.f15988f.f15998b;
        }
        long d2 = this.f15987e ? this.f15983a.d() : Long.MIN_VALUE;
        return d2 == Long.MIN_VALUE ? this.f15988f.f16001e : d2;
    }

    public void d(long j2) {
        a.b(l());
        if (this.f15986d) {
            this.f15983a.a(b(j2));
        }
    }

    public long e() {
        if (!this.f15986d) {
            return 0;
        }
        return this.f15983a.e();
    }

    public void e(long j2) {
        a.b(l());
        this.f15983a.c(b(j2));
    }

    public void f() {
        k();
        a(this.f15988f.f16000d, this.f15992j, this.f15983a);
    }

    public q g() {
        return this.f15993k;
    }

    public TrackGroupArray h() {
        return this.f15994l;
    }

    public com.google.android.exoplayer2.trackselection.h i() {
        return this.f15995m;
    }
}
