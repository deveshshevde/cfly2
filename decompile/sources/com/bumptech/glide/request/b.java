package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public final class b implements RequestCoordinator, e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f10593a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f10594b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f10595c;

    /* renamed from: d  reason: collision with root package name */
    private volatile e f10596d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f10597e = RequestCoordinator.RequestState.CLEARED;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f10598f = RequestCoordinator.RequestState.CLEARED;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        this.f10593a = obj;
        this.f10594b = requestCoordinator;
    }

    private boolean g(e eVar) {
        return eVar.equals(this.f10595c) || (this.f10597e == RequestCoordinator.RequestState.FAILED && eVar.equals(this.f10596d));
    }

    private boolean i() {
        RequestCoordinator requestCoordinator = this.f10594b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.f10594b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f10594b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public void a() {
        synchronized (this.f10593a) {
            if (this.f10597e != RequestCoordinator.RequestState.RUNNING) {
                this.f10597e = RequestCoordinator.RequestState.RUNNING;
                this.f10595c.a();
            }
        }
    }

    public void a(e eVar, e eVar2) {
        this.f10595c = eVar;
        this.f10596d = eVar2;
    }

    public boolean a(e eVar) {
        if (!(eVar instanceof b)) {
            return false;
        }
        b bVar = (b) eVar;
        return this.f10595c.a(bVar.f10595c) && this.f10596d.a(bVar.f10596d);
    }

    public void b() {
        synchronized (this.f10593a) {
            this.f10597e = RequestCoordinator.RequestState.CLEARED;
            this.f10595c.b();
            if (this.f10598f != RequestCoordinator.RequestState.CLEARED) {
                this.f10598f = RequestCoordinator.RequestState.CLEARED;
                this.f10596d.b();
            }
        }
    }

    public boolean b(e eVar) {
        boolean z2;
        synchronized (this.f10593a) {
            z2 = i() && g(eVar);
        }
        return z2;
    }

    public void c() {
        synchronized (this.f10593a) {
            if (this.f10597e == RequestCoordinator.RequestState.RUNNING) {
                this.f10597e = RequestCoordinator.RequestState.PAUSED;
                this.f10595c.c();
            }
            if (this.f10598f == RequestCoordinator.RequestState.RUNNING) {
                this.f10598f = RequestCoordinator.RequestState.PAUSED;
                this.f10596d.c();
            }
        }
    }

    public boolean c(e eVar) {
        boolean z2;
        synchronized (this.f10593a) {
            z2 = k() && g(eVar);
        }
        return z2;
    }

    public boolean d() {
        boolean z2;
        synchronized (this.f10593a) {
            if (this.f10597e != RequestCoordinator.RequestState.RUNNING) {
                if (this.f10598f != RequestCoordinator.RequestState.RUNNING) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean d(e eVar) {
        boolean z2;
        synchronized (this.f10593a) {
            z2 = j() && g(eVar);
        }
        return z2;
    }

    public void e(e eVar) {
        synchronized (this.f10593a) {
            if (eVar.equals(this.f10595c)) {
                this.f10597e = RequestCoordinator.RequestState.SUCCESS;
            } else if (eVar.equals(this.f10596d)) {
                this.f10598f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f10594b;
            if (requestCoordinator != null) {
                requestCoordinator.e(this);
            }
        }
    }

    public boolean e() {
        boolean z2;
        synchronized (this.f10593a) {
            if (this.f10597e != RequestCoordinator.RequestState.SUCCESS) {
                if (this.f10598f != RequestCoordinator.RequestState.SUCCESS) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(com.bumptech.glide.request.e r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f10593a
            monitor-enter(r0)
            com.bumptech.glide.request.e r1 = r2.f10596d     // Catch:{ all -> 0x002d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x0020
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002d }
            r2.f10597e = r3     // Catch:{ all -> 0x002d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f10598f     // Catch:{ all -> 0x002d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002d }
            if (r3 == r1) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002d }
            r2.f10598f = r3     // Catch:{ all -> 0x002d }
            com.bumptech.glide.request.e r3 = r2.f10596d     // Catch:{ all -> 0x002d }
            r3.a()     // Catch:{ all -> 0x002d }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0020:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002d }
            r2.f10598f = r3     // Catch:{ all -> 0x002d }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f10594b     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x002b
            r3.f(r2)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.b.f(com.bumptech.glide.request.e):void");
    }

    public boolean f() {
        boolean z2;
        synchronized (this.f10593a) {
            z2 = this.f10597e == RequestCoordinator.RequestState.CLEARED && this.f10598f == RequestCoordinator.RequestState.CLEARED;
        }
        return z2;
    }

    public boolean g() {
        boolean z2;
        synchronized (this.f10593a) {
            if (!this.f10595c.g()) {
                if (!this.f10596d.g()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public RequestCoordinator h() {
        RequestCoordinator h2;
        synchronized (this.f10593a) {
            RequestCoordinator requestCoordinator = this.f10594b;
            h2 = requestCoordinator != null ? requestCoordinator.h() : this;
        }
        return h2;
    }
}
