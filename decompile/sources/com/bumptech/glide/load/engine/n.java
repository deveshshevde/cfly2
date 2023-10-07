package com.bumptech.glide.load.engine;

import cc.k;
import com.bumptech.glide.load.c;

class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10374a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10375b;

    /* renamed from: c  reason: collision with root package name */
    private final s<Z> f10376c;

    /* renamed from: d  reason: collision with root package name */
    private final a f10377d;

    /* renamed from: e  reason: collision with root package name */
    private final c f10378e;

    /* renamed from: f  reason: collision with root package name */
    private int f10379f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10380g;

    interface a {
        void a(c cVar, n<?> nVar);
    }

    n(s<Z> sVar, boolean z2, boolean z3, c cVar, a aVar) {
        this.f10376c = (s) k.a(sVar);
        this.f10374a = z2;
        this.f10375b = z3;
        this.f10378e = cVar;
        this.f10377d = (a) k.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public s<Z> a() {
        return this.f10376c;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f10374a;
    }

    public Class<Z> c() {
        return this.f10376c.c();
    }

    public Z d() {
        return this.f10376c.d();
    }

    public int e() {
        return this.f10376c.e();
    }

    public synchronized void f() {
        if (this.f10379f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f10380g) {
            this.f10380g = true;
            if (this.f10375b) {
                this.f10376c.f();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        if (!this.f10380g) {
            this.f10379f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        boolean z2;
        synchronized (this) {
            int i2 = this.f10379f;
            if (i2 > 0) {
                z2 = true;
                int i3 = i2 - 1;
                this.f10379f = i3;
                if (i3 != 0) {
                    z2 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z2) {
            this.f10377d.a(this.f10378e, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f10374a + ", listener=" + this.f10377d + ", key=" + this.f10378e + ", acquired=" + this.f10379f + ", isRecycled=" + this.f10380g + ", resource=" + this.f10376c + '}';
    }
}
