package com.bumptech.glide.load.engine;

import android.util.Log;
import bm.a;
import bm.h;
import cc.g;
import cc.k;
import cd.a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.f;
import java.util.Map;
import java.util.concurrent.Executor;
import s.e;

public class i implements h.a, k, n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f10306a = Log.isLoggable("Engine", 2);

    /* renamed from: b  reason: collision with root package name */
    private final p f10307b;

    /* renamed from: c  reason: collision with root package name */
    private final m f10308c;

    /* renamed from: d  reason: collision with root package name */
    private final h f10309d;

    /* renamed from: e  reason: collision with root package name */
    private final b f10310e;

    /* renamed from: f  reason: collision with root package name */
    private final v f10311f;

    /* renamed from: g  reason: collision with root package name */
    private final c f10312g;

    /* renamed from: h  reason: collision with root package name */
    private final a f10313h;

    /* renamed from: i  reason: collision with root package name */
    private final a f10314i;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.d f10315a;

        /* renamed from: b  reason: collision with root package name */
        final e.a<DecodeJob<?>> f10316b = cd.a.a(150, new a.C0067a<DecodeJob<?>>() {
            /* renamed from: a */
            public DecodeJob<?> b() {
                return new DecodeJob<>(a.this.f10315a, a.this.f10316b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f10317c;

        a(DecodeJob.d dVar) {
            this.f10315a = dVar;
        }

        /* access modifiers changed from: package-private */
        public <R> DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, l lVar, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, boolean z4, f fVar, DecodeJob.a<R> aVar) {
            DecodeJob decodeJob = (DecodeJob) k.a(this.f10316b.a());
            int i4 = this.f10317c;
            int i5 = i4;
            this.f10317c = i4 + 1;
            return decodeJob.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, z4, fVar, aVar, i5);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final bn.a f10319a;

        /* renamed from: b  reason: collision with root package name */
        final bn.a f10320b;

        /* renamed from: c  reason: collision with root package name */
        final bn.a f10321c;

        /* renamed from: d  reason: collision with root package name */
        final bn.a f10322d;

        /* renamed from: e  reason: collision with root package name */
        final k f10323e;

        /* renamed from: f  reason: collision with root package name */
        final n.a f10324f;

        /* renamed from: g  reason: collision with root package name */
        final e.a<j<?>> f10325g = cd.a.a(150, new a.C0067a<j<?>>() {
            /* renamed from: a */
            public j<?> b() {
                return new j(b.this.f10319a, b.this.f10320b, b.this.f10321c, b.this.f10322d, b.this.f10323e, b.this.f10324f, b.this.f10325g);
            }
        });

        b(bn.a aVar, bn.a aVar2, bn.a aVar3, bn.a aVar4, k kVar, n.a aVar5) {
            this.f10319a = aVar;
            this.f10320b = aVar2;
            this.f10321c = aVar3;
            this.f10322d = aVar4;
            this.f10323e = kVar;
            this.f10324f = aVar5;
        }

        /* access modifiers changed from: package-private */
        public <R> j<R> a(com.bumptech.glide.load.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
            return ((j) k.a(this.f10325g.a())).a(cVar, z2, z3, z4, z5);
        }
    }

    private static class c implements DecodeJob.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0051a f10327a;

        /* renamed from: b  reason: collision with root package name */
        private volatile bm.a f10328b;

        c(a.C0051a aVar) {
            this.f10327a = aVar;
        }

        public bm.a a() {
            if (this.f10328b == null) {
                synchronized (this) {
                    if (this.f10328b == null) {
                        this.f10328b = this.f10327a.a();
                    }
                    if (this.f10328b == null) {
                        this.f10328b = new bm.b();
                    }
                }
            }
            return this.f10328b;
        }
    }

    public class d {

        /* renamed from: b  reason: collision with root package name */
        private final j<?> f10330b;

        /* renamed from: c  reason: collision with root package name */
        private final com.bumptech.glide.request.i f10331c;

        d(com.bumptech.glide.request.i iVar, j<?> jVar) {
            this.f10331c = iVar;
            this.f10330b = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.f10330b.c(this.f10331c);
            }
        }
    }

    i(h hVar, a.C0051a aVar, bn.a aVar2, bn.a aVar3, bn.a aVar4, bn.a aVar5, p pVar, m mVar, a aVar6, b bVar, a aVar7, v vVar, boolean z2) {
        this.f10309d = hVar;
        a.C0051a aVar8 = aVar;
        c cVar = new c(aVar);
        this.f10312g = cVar;
        a aVar9 = aVar6 == null ? new a(z2) : aVar6;
        this.f10314i = aVar9;
        aVar9.a((n.a) this);
        this.f10308c = mVar == null ? new m() : mVar;
        this.f10307b = pVar == null ? new p() : pVar;
        this.f10310e = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.f10313h = aVar7 == null ? new a(cVar) : aVar7;
        this.f10311f = vVar == null ? new v() : vVar;
        hVar.a((h.a) this);
    }

    public i(h hVar, a.C0051a aVar, bn.a aVar2, bn.a aVar3, bn.a aVar4, bn.a aVar5, boolean z2) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, (p) null, (m) null, (a) null, (b) null, (a) null, (v) null, z2);
    }

    private <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, f fVar, boolean z4, boolean z5, boolean z6, boolean z7, com.bumptech.glide.request.i iVar, Executor executor, l lVar, long j2) {
        com.bumptech.glide.request.i iVar2 = iVar;
        Executor executor2 = executor;
        l lVar2 = lVar;
        long j3 = j2;
        j<?> a2 = this.f10307b.a((com.bumptech.glide.load.c) lVar2, z7);
        if (a2 != null) {
            a2.a(iVar2, executor2);
            if (f10306a) {
                a("Added to existing load", j3, (com.bumptech.glide.load.c) lVar2);
            }
            return new d(iVar2, a2);
        }
        j a3 = this.f10310e.a(lVar, z4, z5, z6, z7);
        j jVar = a3;
        l lVar3 = lVar2;
        DecodeJob<R> a4 = this.f10313h.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, z7, fVar, a3);
        this.f10307b.a((com.bumptech.glide.load.c) lVar3, (j<?>) jVar);
        j jVar2 = jVar;
        l lVar4 = lVar3;
        com.bumptech.glide.request.i iVar3 = iVar;
        jVar2.a(iVar3, executor);
        jVar2.b(a4);
        if (f10306a) {
            a("Started new load", j2, (com.bumptech.glide.load.c) lVar4);
        }
        return new d(iVar3, jVar2);
    }

    private n<?> a(com.bumptech.glide.load.c cVar) {
        n<?> b2 = this.f10314i.b(cVar);
        if (b2 != null) {
            b2.g();
        }
        return b2;
    }

    private n<?> a(l lVar, boolean z2, long j2) {
        if (!z2) {
            return null;
        }
        n<?> a2 = a((com.bumptech.glide.load.c) lVar);
        if (a2 != null) {
            if (f10306a) {
                a("Loaded resource from active resources", j2, (com.bumptech.glide.load.c) lVar);
            }
            return a2;
        }
        n<?> b2 = b((com.bumptech.glide.load.c) lVar);
        if (b2 == null) {
            return null;
        }
        if (f10306a) {
            a("Loaded resource from cache", j2, (com.bumptech.glide.load.c) lVar);
        }
        return b2;
    }

    private static void a(String str, long j2, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + g.a(j2) + "ms, key: " + cVar);
    }

    private n<?> b(com.bumptech.glide.load.c cVar) {
        n<?> c2 = c(cVar);
        if (c2 != null) {
            c2.g();
            this.f10314i.a(cVar, c2);
        }
        return c2;
    }

    private n<?> c(com.bumptech.glide.load.c cVar) {
        s<?> a2 = this.f10309d.a(cVar);
        if (a2 == null) {
            return null;
        }
        return a2 instanceof n ? (n) a2 : new n<>(a2, true, true, cVar, this);
    }

    public <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, f fVar, boolean z4, boolean z5, boolean z6, boolean z7, com.bumptech.glide.request.i iVar, Executor executor) {
        long a2 = f10306a ? g.a() : 0;
        l a3 = this.f10308c.a(obj, cVar, i2, i3, map, cls, cls2, fVar);
        synchronized (this) {
            n<?> a4 = a(a3, z4, a2);
            if (a4 == null) {
                d a5 = a(eVar, obj, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, fVar, z4, z5, z6, z7, iVar, executor, a3, a2);
                return a5;
            }
            iVar.a(a4, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public void a(com.bumptech.glide.load.c cVar, n<?> nVar) {
        this.f10314i.a(cVar);
        if (nVar.b()) {
            this.f10309d.b(cVar, nVar);
        } else {
            this.f10311f.a(nVar, false);
        }
    }

    public synchronized void a(j<?> jVar, com.bumptech.glide.load.c cVar) {
        this.f10307b.b(cVar, jVar);
    }

    public synchronized void a(j<?> jVar, com.bumptech.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            if (nVar.b()) {
                this.f10314i.a(cVar, nVar);
            }
        }
        this.f10307b.b(cVar, jVar);
    }

    public void a(s<?> sVar) {
        if (sVar instanceof n) {
            ((n) sVar).h();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void b(s<?> sVar) {
        this.f10311f.a(sVar, true);
    }
}
