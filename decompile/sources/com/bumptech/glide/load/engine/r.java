package com.bumptech.glide.load.engine;

import cc.k;
import cd.a;
import cd.c;
import s.e;

final class r<Z> implements a.c, s<Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final e.a<r<?>> f10387a = a.a(20, new a.C0067a<r<?>>() {
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final c f10388b = c.a();

    /* renamed from: c  reason: collision with root package name */
    private s<Z> f10389c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10390d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10391e;

    r() {
    }

    static <Z> r<Z> a(s<Z> sVar) {
        r<Z> rVar = (r) k.a(f10387a.a());
        rVar.b(sVar);
        return rVar;
    }

    private void b() {
        this.f10389c = null;
        f10387a.a(this);
    }

    private void b(s<Z> sVar) {
        this.f10391e = false;
        this.f10390d = true;
        this.f10389c = sVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        this.f10388b.b();
        if (this.f10390d) {
            this.f10390d = false;
            if (this.f10391e) {
                f();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Class<Z> c() {
        return this.f10389c.c();
    }

    public Z d() {
        return this.f10389c.d();
    }

    public int e() {
        return this.f10389c.e();
    }

    public synchronized void f() {
        this.f10388b.b();
        this.f10391e = true;
        if (!this.f10390d) {
            this.f10389c.f();
            b();
        }
    }

    public c f_() {
        return this.f10388b;
    }
}
