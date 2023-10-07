package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.t;
import fv.a;
import java.io.IOException;
import java.util.ArrayList;

public final class SsMediaSource extends a implements Loader.a<r<fv.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16515a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f16516b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f16517c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f16518d;

    /* renamed from: e  reason: collision with root package name */
    private final d f16519e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16520f;

    /* renamed from: g  reason: collision with root package name */
    private final p f16521g;

    /* renamed from: h  reason: collision with root package name */
    private final long f16522h;

    /* renamed from: i  reason: collision with root package name */
    private final j.a f16523i;

    /* renamed from: j  reason: collision with root package name */
    private final r.a<? extends fv.a> f16524j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<c> f16525k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f16526l;

    /* renamed from: m  reason: collision with root package name */
    private f f16527m;

    /* renamed from: n  reason: collision with root package name */
    private Loader f16528n;

    /* renamed from: o  reason: collision with root package name */
    private q f16529o;

    /* renamed from: p  reason: collision with root package name */
    private t f16530p;

    /* renamed from: q  reason: collision with root package name */
    private long f16531q;

    /* renamed from: r  reason: collision with root package name */
    private fv.a f16532r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f16533s;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final b.a f16534a;

        /* renamed from: b  reason: collision with root package name */
        private final f.a f16535b;

        /* renamed from: c  reason: collision with root package name */
        private d f16536c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.drm.b<?> f16537d;

        /* renamed from: e  reason: collision with root package name */
        private p f16538e;

        /* renamed from: f  reason: collision with root package name */
        private long f16539f;

        public Factory(b.a aVar, f.a aVar2) {
            this.f16534a = (b.a) com.google.android.exoplayer2.util.a.b(aVar);
            this.f16535b = aVar2;
            this.f16537d = b.CC.c();
            this.f16538e = new o();
            this.f16539f = 30000;
            this.f16536c = new e();
        }

        public Factory(f.a aVar) {
            this(new a.C0115a(aVar), aVar);
        }
    }

    static {
        n.a("goog.exo.smoothstreaming");
    }

    private void e() {
        com.google.android.exoplayer2.source.q qVar;
        for (int i2 = 0; i2 < this.f16525k.size(); i2++) {
            this.f16525k.get(i2).a(this.f16532r);
        }
        long j2 = Long.MIN_VALUE;
        long j3 = Long.MAX_VALUE;
        for (a.b bVar : this.f16532r.f28154c) {
            if (bVar.f28161d > 0) {
                j3 = Math.min(j3, bVar.a(0));
                j2 = Math.max(j2, bVar.a(bVar.f28161d - 1) + bVar.b(bVar.f28161d - 1));
            }
        }
        if (j3 == Long.MAX_VALUE) {
            qVar = new com.google.android.exoplayer2.source.q(this.f16532r.f28152a ? -9223372036854775807L : 0, 0, 0, 0, true, this.f16532r.f28152a, this.f16532r.f28152a, this.f16532r, this.f16526l);
        } else if (this.f16532r.f28152a) {
            if (this.f16532r.f28156e != -9223372036854775807L && this.f16532r.f28156e > 0) {
                j3 = Math.max(j3, j2 - this.f16532r.f28156e);
            }
            long j4 = j3;
            long j5 = j2 - j4;
            long b2 = j5 - com.google.android.exoplayer2.e.b(this.f16522h);
            if (b2 < 5000000) {
                b2 = Math.min(5000000, j5 / 2);
            }
            qVar = new com.google.android.exoplayer2.source.q(-9223372036854775807L, j5, j4, b2, true, true, true, this.f16532r, this.f16526l);
        } else {
            long j6 = this.f16532r.f28155d != -9223372036854775807L ? this.f16532r.f28155d : j2 - j3;
            qVar = new com.google.android.exoplayer2.source.q(j3 + j6, j6, j3, 0, true, false, false, this.f16532r, this.f16526l);
        }
        a((af) qVar);
    }

    private void f() {
        if (this.f16532r.f28152a) {
            this.f16533s.postDelayed(new Runnable() {
                public final void run() {
                    SsMediaSource.this.g();
                }
            }, Math.max(0, (this.f16531q + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (!this.f16528n.a()) {
            r rVar = new r(this.f16527m, this.f16516b, 4, this.f16524j);
            this.f16523i.a(rVar.f17079a, rVar.f17080b, this.f16528n.a(rVar, this, this.f16521g.a(rVar.f17080b)));
        }
    }

    public h a(i.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j2) {
        c cVar = new c(this.f16532r, this.f16518d, this.f16530p, this.f16519e, this.f16520f, this.f16521g, a(aVar), this.f16529o, bVar);
        this.f16525k.add(cVar);
        return cVar;
    }

    public Loader.b a(r<fv.a> rVar, long j2, long j3, IOException iOException, int i2) {
        r<fv.a> rVar2 = rVar;
        long b2 = this.f16521g.b(4, j3, iOException, i2);
        Loader.b a2 = b2 == -9223372036854775807L ? Loader.f16946d : Loader.a(false, b2);
        this.f16523i.a(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d(), iOException, !a2.a());
        return a2;
    }

    public void a(h hVar) {
        ((c) hVar).g();
        this.f16525k.remove(hVar);
    }

    public void a(r<fv.a> rVar, long j2, long j3) {
        r<fv.a> rVar2 = rVar;
        this.f16523i.a(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d());
        this.f16532r = rVar.c();
        this.f16531q = j2 - j3;
        e();
        f();
    }

    public void a(r<fv.a> rVar, long j2, long j3, boolean z2) {
        r<fv.a> rVar2 = rVar;
        this.f16523i.b(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d());
    }

    /* access modifiers changed from: protected */
    public void a(t tVar) {
        this.f16530p = tVar;
        this.f16520f.a();
        if (this.f16515a) {
            this.f16529o = new q.a();
            e();
            return;
        }
        this.f16527m = this.f16517c.a();
        Loader loader = new Loader("Loader:Manifest");
        this.f16528n = loader;
        this.f16529o = loader;
        this.f16533s = new Handler();
        g();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f16532r = this.f16515a ? this.f16532r : null;
        this.f16527m = null;
        this.f16531q = 0;
        Loader loader = this.f16528n;
        if (loader != null) {
            loader.e();
            this.f16528n = null;
        }
        Handler handler = this.f16533s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f16533s = null;
        }
        this.f16520f.b();
    }

    public void d() throws IOException {
        this.f16529o.f();
    }
}
