package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b implements HlsPlaylistTracker, Loader.a<r<e>> {

    /* renamed from: a  reason: collision with root package name */
    public static final HlsPlaylistTracker.a f16264a = $$Lambda$oL5j3BCf9oWapng9dNwdGmw6Iu4.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f16265b;

    /* renamed from: c  reason: collision with root package name */
    private final g f16266c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final p f16267d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<Uri, a> f16268e;

    /* renamed from: f  reason: collision with root package name */
    private final List<HlsPlaylistTracker.b> f16269f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final double f16270g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public r.a<e> f16271h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public j.a f16272i;

    /* renamed from: j  reason: collision with root package name */
    private Loader f16273j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Handler f16274k;

    /* renamed from: l  reason: collision with root package name */
    private HlsPlaylistTracker.c f16275l;

    /* renamed from: m  reason: collision with root package name */
    private c f16276m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Uri f16277n;

    /* renamed from: o  reason: collision with root package name */
    private d f16278o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16279p;

    /* renamed from: q  reason: collision with root package name */
    private long f16280q;

    private final class a implements Loader.a<r<e>>, Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Uri f16282b;

        /* renamed from: c  reason: collision with root package name */
        private final Loader f16283c = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final r<e> f16284d;

        /* renamed from: e  reason: collision with root package name */
        private d f16285e;

        /* renamed from: f  reason: collision with root package name */
        private long f16286f;

        /* renamed from: g  reason: collision with root package name */
        private long f16287g;

        /* renamed from: h  reason: collision with root package name */
        private long f16288h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public long f16289i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f16290j;

        /* renamed from: k  reason: collision with root package name */
        private IOException f16291k;

        public a(Uri uri) {
            this.f16282b = uri;
            this.f16284d = new r<>(b.this.f16265b.a(4), uri, 4, b.this.f16271h);
        }

        /* access modifiers changed from: private */
        public void a(d dVar, long j2) {
            d dVar2 = dVar;
            d dVar3 = this.f16285e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f16286f = elapsedRealtime;
            d a2 = b.this.a(dVar3, dVar2);
            this.f16285e = a2;
            if (a2 != dVar3) {
                this.f16291k = null;
                this.f16287g = elapsedRealtime;
                b.this.a(this.f16282b, a2);
            } else if (!a2.f16321i) {
                if (dVar2.f16318f + ((long) dVar2.f16324l.size()) < this.f16285e.f16318f) {
                    this.f16291k = new HlsPlaylistTracker.PlaylistResetException(this.f16282b);
                    boolean unused = b.this.a(this.f16282b, -9223372036854775807L);
                } else {
                    double a3 = (double) e.a(this.f16285e.f16320h);
                    double f2 = b.this.f16270g;
                    Double.isNaN(a3);
                    if (((double) (elapsedRealtime - this.f16287g)) > a3 * f2) {
                        this.f16291k = new HlsPlaylistTracker.PlaylistStuckException(this.f16282b);
                        long a4 = b.this.f16267d.a(4, j2, this.f16291k, 1);
                        boolean unused2 = b.this.a(this.f16282b, a4);
                        if (a4 != -9223372036854775807L) {
                            a(a4);
                        }
                    }
                }
            }
            d dVar4 = this.f16285e;
            this.f16288h = elapsedRealtime + e.a(dVar4 != dVar3 ? dVar4.f16320h : dVar4.f16320h / 2);
            if (this.f16282b.equals(b.this.f16277n) && !this.f16285e.f16321i) {
                d();
            }
        }

        private boolean a(long j2) {
            this.f16289i = SystemClock.elapsedRealtime() + j2;
            return this.f16282b.equals(b.this.f16277n) && !b.this.f();
        }

        private void f() {
            b.this.f16272i.a(this.f16284d.f17079a, this.f16284d.f17080b, this.f16283c.a(this.f16284d, this, b.this.f16267d.a(this.f16284d.f17080b)));
        }

        public d a() {
            return this.f16285e;
        }

        public Loader.b a(r<e> rVar, long j2, long j3, IOException iOException, int i2) {
            Loader.b bVar;
            r<e> rVar2 = rVar;
            long a2 = b.this.f16267d.a(rVar2.f17080b, j3, iOException, i2);
            boolean z2 = a2 != -9223372036854775807L;
            boolean z3 = b.this.a(this.f16282b, a2) || !z2;
            if (z2) {
                z3 |= a(a2);
            }
            if (z3) {
                long b2 = b.this.f16267d.b(rVar2.f17080b, j3, iOException, i2);
                bVar = b2 != -9223372036854775807L ? Loader.a(false, b2) : Loader.f16946d;
            } else {
                bVar = Loader.f16945c;
            }
            b.this.f16272i.a(rVar2.f17079a, rVar.e(), rVar.f(), 4, j2, j3, rVar.d(), iOException, !bVar.a());
            return bVar;
        }

        public void a(r<e> rVar, long j2, long j3) {
            e c2 = rVar.c();
            if (c2 instanceof d) {
                long j4 = j3;
                a((d) c2, j4);
                b.this.f16272i.a(rVar.f17079a, rVar.e(), rVar.f(), 4, j2, j4, rVar.d());
                return;
            }
            this.f16291k = new ParserException("Loaded playlist has unexpected type.");
        }

        public void a(r<e> rVar, long j2, long j3, boolean z2) {
            b.this.f16272i.b(rVar.f17079a, rVar.e(), rVar.f(), 4, j2, j3, rVar.d());
        }

        public boolean b() {
            if (this.f16285e == null) {
                return false;
            }
            return this.f16285e.f16321i || this.f16285e.f16313a == 2 || this.f16285e.f16313a == 1 || this.f16286f + Math.max(30000, e.a(this.f16285e.f16325m)) > SystemClock.elapsedRealtime();
        }

        public void c() {
            this.f16283c.e();
        }

        public void d() {
            this.f16289i = 0;
            if (!this.f16290j && !this.f16283c.c() && !this.f16283c.a()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f16288h) {
                    this.f16290j = true;
                    b.this.f16274k.postDelayed(this, this.f16288h - elapsedRealtime);
                    return;
                }
                f();
            }
        }

        public void e() throws IOException {
            this.f16283c.f();
            IOException iOException = this.f16291k;
            if (iOException != null) {
                throw iOException;
            }
        }

        public void run() {
            this.f16290j = false;
            f();
        }
    }

    public b(f fVar, p pVar, g gVar) {
        this(fVar, pVar, gVar, 3.5d);
    }

    public b(f fVar, p pVar, g gVar, double d2) {
        this.f16265b = fVar;
        this.f16266c = gVar;
        this.f16267d = pVar;
        this.f16270g = d2;
        this.f16269f = new ArrayList();
        this.f16268e = new HashMap<>();
        this.f16280q = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public d a(d dVar, d dVar2) {
        return !dVar2.a(dVar) ? dVar2.f16321i ? dVar.b() : dVar : dVar2.a(b(dVar, dVar2), c(dVar, dVar2));
    }

    /* access modifiers changed from: private */
    public void a(Uri uri, d dVar) {
        if (uri.equals(this.f16277n)) {
            if (this.f16278o == null) {
                this.f16279p = !dVar.f16321i;
                this.f16280q = dVar.f16315c;
            }
            this.f16278o = dVar;
            this.f16275l.a(dVar);
        }
        int size = this.f16269f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f16269f.get(i2).i();
        }
    }

    private void a(List<Uri> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.f16268e.put(uri, new a(uri));
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Uri uri, long j2) {
        int size = this.f16269f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            z2 |= !this.f16269f.get(i2).a(uri, j2);
        }
        return z2;
    }

    private long b(d dVar, d dVar2) {
        if (dVar2.f16322j) {
            return dVar2.f16315c;
        }
        d dVar3 = this.f16278o;
        long j2 = dVar3 != null ? dVar3.f16315c : 0;
        if (dVar == null) {
            return j2;
        }
        int size = dVar.f16324l.size();
        d.a d2 = d(dVar, dVar2);
        return d2 != null ? dVar.f16315c + d2.f16331f : ((long) size) == dVar2.f16318f - dVar.f16318f ? dVar.a() : j2;
    }

    private int c(d dVar, d dVar2) {
        d.a d2;
        if (dVar2.f16316d) {
            return dVar2.f16317e;
        }
        d dVar3 = this.f16278o;
        int i2 = dVar3 != null ? dVar3.f16317e : 0;
        return (dVar == null || (d2 = d(dVar, dVar2)) == null) ? i2 : (dVar.f16317e + d2.f16330e) - dVar2.f16324l.get(0).f16330e;
    }

    private static d.a d(d dVar, d dVar2) {
        int i2 = (int) (dVar2.f16318f - dVar.f16318f);
        List<d.a> list = dVar.f16324l;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    private void d(Uri uri) {
        if (!uri.equals(this.f16277n) && e(uri)) {
            d dVar = this.f16278o;
            if (dVar == null || !dVar.f16321i) {
                this.f16277n = uri;
                this.f16268e.get(uri).d();
            }
        }
    }

    private boolean e(Uri uri) {
        List<c.b> list = this.f16276m.f16294c;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (uri.equals(list.get(i2).f16307a)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        List<c.b> list = this.f16276m.f16294c;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f16268e.get(list.get(i2).f16307a);
            if (elapsedRealtime > aVar.f16289i) {
                this.f16277n = aVar.f16282b;
                aVar.d();
                return true;
            }
        }
        return false;
    }

    public d a(Uri uri, boolean z2) {
        d a2 = this.f16268e.get(uri).a();
        if (a2 != null && z2) {
            d(uri);
        }
        return a2;
    }

    public Loader.b a(r<e> rVar, long j2, long j3, IOException iOException, int i2) {
        r<e> rVar2 = rVar;
        long b2 = this.f16267d.b(rVar2.f17080b, j3, iOException, i2);
        boolean z2 = b2 == -9223372036854775807L;
        this.f16272i.a(rVar2.f17079a, rVar.e(), rVar.f(), 4, j2, j3, rVar.d(), iOException, z2);
        return z2 ? Loader.f16946d : Loader.a(false, b2);
    }

    public void a() {
        this.f16277n = null;
        this.f16278o = null;
        this.f16276m = null;
        this.f16280q = -9223372036854775807L;
        this.f16273j.e();
        this.f16273j = null;
        for (a c2 : this.f16268e.values()) {
            c2.c();
        }
        this.f16274k.removeCallbacksAndMessages((Object) null);
        this.f16274k = null;
        this.f16268e.clear();
    }

    public void a(Uri uri, j.a aVar, HlsPlaylistTracker.c cVar) {
        this.f16274k = new Handler();
        this.f16272i = aVar;
        this.f16275l = cVar;
        r rVar = new r(this.f16265b.a(4), uri, 4, this.f16266c.a());
        com.google.android.exoplayer2.util.a.b(this.f16273j == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f16273j = loader;
        aVar.a(rVar.f17079a, rVar.f17080b, loader.a(rVar, this, this.f16267d.a(rVar.f17080b)));
    }

    public void a(HlsPlaylistTracker.b bVar) {
        this.f16269f.add(bVar);
    }

    public void a(r<e> rVar, long j2, long j3) {
        e c2 = rVar.c();
        boolean z2 = c2 instanceof d;
        c a2 = z2 ? c.a(c2.f16338n) : (c) c2;
        this.f16276m = a2;
        this.f16271h = this.f16266c.a(a2);
        this.f16277n = a2.f16294c.get(0).f16307a;
        a(a2.f16293b);
        a aVar = this.f16268e.get(this.f16277n);
        if (z2) {
            aVar.a((d) c2, j3);
        } else {
            long j4 = j3;
            aVar.d();
        }
        this.f16272i.a(rVar.f17079a, rVar.e(), rVar.f(), 4, j2, j3, rVar.d());
    }

    public void a(r<e> rVar, long j2, long j3, boolean z2) {
        j.a aVar = this.f16272i;
        h hVar = rVar.f17079a;
        Uri e2 = rVar.e();
        aVar.b(hVar, e2, rVar.f(), 4, j2, j3, rVar.d());
    }

    public boolean a(Uri uri) {
        return this.f16268e.get(uri).b();
    }

    public c b() {
        return this.f16276m;
    }

    public void b(Uri uri) throws IOException {
        this.f16268e.get(uri).e();
    }

    public void b(HlsPlaylistTracker.b bVar) {
        this.f16269f.remove(bVar);
    }

    public long c() {
        return this.f16280q;
    }

    public void c(Uri uri) {
        this.f16268e.get(uri).d();
    }

    public void d() throws IOException {
        Loader loader = this.f16273j;
        if (loader != null) {
            loader.f();
        }
        Uri uri = this.f16277n;
        if (uri != null) {
            b(uri);
        }
    }

    public boolean e() {
        return this.f16279p;
    }
}
