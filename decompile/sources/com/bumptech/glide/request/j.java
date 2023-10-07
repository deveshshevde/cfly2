package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

public class j implements RequestCoordinator, e {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f10612a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10613b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f10614c;

    /* renamed from: d  reason: collision with root package name */
    private volatile e f10615d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f10616e = RequestCoordinator.RequestState.CLEARED;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f10617f = RequestCoordinator.RequestState.CLEARED;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10618g;

    public j(Object obj, RequestCoordinator requestCoordinator) {
        this.f10613b = obj;
        this.f10612a = requestCoordinator;
    }

    private boolean i() {
        RequestCoordinator requestCoordinator = this.f10612a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.f10612a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f10612a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public void a() {
        synchronized (this.f10613b) {
            this.f10618g = true;
            try {
                if (!(this.f10616e == RequestCoordinator.RequestState.SUCCESS || this.f10617f == RequestCoordinator.RequestState.RUNNING)) {
                    this.f10617f = RequestCoordinator.RequestState.RUNNING;
                    this.f10615d.a();
                }
                if (this.f10618g && this.f10616e != RequestCoordinator.RequestState.RUNNING) {
                    this.f10616e = RequestCoordinator.RequestState.RUNNING;
                    this.f10614c.a();
                }
            } finally {
                this.f10618g = false;
            }
        }
    }

    public void a(e eVar, e eVar2) {
        this.f10614c = eVar;
        this.f10615d = eVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.bumptech.glide.request.e r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.j
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.j r4 = (com.bumptech.glide.request.j) r4
            com.bumptech.glide.request.e r0 = r3.f10614c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.e r0 = r4.f10614c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.e r0 = r3.f10614c
            com.bumptech.glide.request.e r2 = r4.f10614c
            boolean r0 = r0.a(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.e r0 = r3.f10615d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.e r4 = r4.f10615d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.e r0 = r3.f10615d
            com.bumptech.glide.request.e r4 = r4.f10615d
            boolean r4 = r0.a(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.j.a(com.bumptech.glide.request.e):boolean");
    }

    public void b() {
        synchronized (this.f10613b) {
            this.f10618g = false;
            this.f10616e = RequestCoordinator.RequestState.CLEARED;
            this.f10617f = RequestCoordinator.RequestState.CLEARED;
            this.f10615d.b();
            this.f10614c.b();
        }
    }

    public boolean b(e eVar) {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = i() && (eVar.equals(this.f10614c) || this.f10616e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z2;
    }

    public void c() {
        synchronized (this.f10613b) {
            if (!this.f10617f.a()) {
                this.f10617f = RequestCoordinator.RequestState.PAUSED;
                this.f10615d.c();
            }
            if (!this.f10616e.a()) {
                this.f10616e = RequestCoordinator.RequestState.PAUSED;
                this.f10614c.c();
            }
        }
    }

    public boolean c(e eVar) {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = k() && eVar.equals(this.f10614c) && !g();
        }
        return z2;
    }

    public boolean d() {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = this.f10616e == RequestCoordinator.RequestState.RUNNING;
        }
        return z2;
    }

    public boolean d(e eVar) {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = j() && eVar.equals(this.f10614c) && this.f10616e != RequestCoordinator.RequestState.PAUSED;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.bumptech.glide.request.e r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f10613b
            monitor-enter(r0)
            com.bumptech.glide.request.e r1 = r2.f10615d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f10617f = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f10616e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f10612a     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r3.e(r2)     // Catch:{ all -> 0x002b }
        L_0x001c:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f10617f     // Catch:{ all -> 0x002b }
            boolean r3 = r3.a()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0029
            com.bumptech.glide.request.e r3 = r2.f10615d     // Catch:{ all -> 0x002b }
            r3.b()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.j.e(com.bumptech.glide.request.e):void");
    }

    public boolean e() {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = this.f10616e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(com.bumptech.glide.request.e r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f10613b
            monitor-enter(r0)
            com.bumptech.glide.request.e r1 = r2.f10614c     // Catch:{ all -> 0x001e }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f10617f = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f10616e = r3     // Catch:{ all -> 0x001e }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f10612a     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.f(r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.j.f(com.bumptech.glide.request.e):void");
    }

    public boolean f() {
        boolean z2;
        synchronized (this.f10613b) {
            z2 = this.f10616e == RequestCoordinator.RequestState.CLEARED;
        }
        return z2;
    }

    public boolean g() {
        boolean z2;
        synchronized (this.f10613b) {
            if (!this.f10615d.g()) {
                if (!this.f10614c.g()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public RequestCoordinator h() {
        RequestCoordinator h2;
        synchronized (this.f10613b) {
            RequestCoordinator requestCoordinator = this.f10612a;
            h2 = requestCoordinator != null ? requestCoordinator.h() : this;
        }
        return h2;
    }
}
