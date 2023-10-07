package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.t;
import java.io.IOException;
import java.util.List;

public final class HlsMediaSource extends a implements HlsPlaylistTracker.c {

    /* renamed from: a  reason: collision with root package name */
    private final g f16159a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f16160b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16161c;

    /* renamed from: d  reason: collision with root package name */
    private final d f16162d;

    /* renamed from: e  reason: collision with root package name */
    private final b<?> f16163e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16164f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f16165g;

    /* renamed from: h  reason: collision with root package name */
    private final int f16166h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f16167i;

    /* renamed from: j  reason: collision with root package name */
    private final HlsPlaylistTracker f16168j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f16169k;

    /* renamed from: l  reason: collision with root package name */
    private t f16170l;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final f f16171a;

        /* renamed from: b  reason: collision with root package name */
        private g f16172b;

        /* renamed from: c  reason: collision with root package name */
        private g f16173c;

        /* renamed from: d  reason: collision with root package name */
        private HlsPlaylistTracker.a f16174d;

        /* renamed from: e  reason: collision with root package name */
        private d f16175e;

        /* renamed from: f  reason: collision with root package name */
        private b<?> f16176f;

        /* renamed from: g  reason: collision with root package name */
        private p f16177g;

        /* renamed from: h  reason: collision with root package name */
        private int f16178h;

        public Factory(f fVar) {
            this.f16171a = (f) com.google.android.exoplayer2.util.a.b(fVar);
            this.f16173c = new com.google.android.exoplayer2.source.hls.playlist.a();
            this.f16174d = com.google.android.exoplayer2.source.hls.playlist.b.f16264a;
            this.f16172b = g.f16220a;
            this.f16176f = b.CC.c();
            this.f16177g = new o();
            this.f16175e = new e();
            this.f16178h = 1;
        }

        public Factory(f.a aVar) {
            this((f) new b(aVar));
        }
    }

    static {
        n.a("goog.exo.hls");
    }

    public h a(i.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j2) {
        return new j(this.f16159a, this.f16168j, this.f16161c, this.f16170l, this.f16163e, this.f16164f, a(aVar), bVar, this.f16162d, this.f16165g, this.f16166h, this.f16167i);
    }

    public void a(h hVar) {
        ((j) hVar).g();
    }

    public void a(com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        q qVar;
        long j2;
        com.google.android.exoplayer2.source.hls.playlist.d dVar2 = dVar;
        long a2 = dVar2.f16322j ? com.google.android.exoplayer2.e.a(dVar2.f16315c) : -9223372036854775807L;
        long j3 = (dVar2.f16313a == 2 || dVar2.f16313a == 1) ? a2 : -9223372036854775807L;
        long j4 = dVar2.f16314b;
        h hVar = new h((c) com.google.android.exoplayer2.util.a.b(this.f16168j.b()), dVar2);
        if (this.f16168j.e()) {
            long c2 = dVar2.f16315c - this.f16168j.c();
            long j5 = dVar2.f16321i ? c2 + dVar2.f16325m : -9223372036854775807L;
            List<d.a> list = dVar2.f16324l;
            if (j4 != -9223372036854775807L) {
                j2 = j4;
            } else if (!list.isEmpty()) {
                int max = Math.max(0, list.size() - 3);
                long j6 = dVar2.f16325m - (dVar2.f16320h * 2);
                while (max > 0 && list.get(max).f16331f > j6) {
                    max--;
                }
                j2 = list.get(max).f16331f;
            } else {
                j2 = 0;
            }
            qVar = new q(j3, a2, j5, dVar2.f16325m, c2, j2, true, !dVar2.f16321i, true, hVar, this.f16169k);
        } else {
            qVar = new q(j3, a2, dVar2.f16325m, dVar2.f16325m, 0, j4 == -9223372036854775807L ? 0 : j4, true, false, false, hVar, this.f16169k);
        }
        a((af) qVar);
    }

    /* access modifiers changed from: protected */
    public void a(t tVar) {
        this.f16170l = tVar;
        this.f16163e.a();
        this.f16168j.a(this.f16160b, a((i.a) null), this);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f16168j.a();
        this.f16163e.b();
    }

    public void d() throws IOException {
        this.f16168j.d();
    }
}
