package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import bs.b;
import bz.i;
import bz.j;
import cc.g;
import cc.l;
import cd.c;
import com.bumptech.glide.Priority;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements i, e, i {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f10534a = Log.isLoggable("GlideRequest", 2);
    private Drawable A;
    private int B;
    private int C;
    private boolean D;
    private RuntimeException E;

    /* renamed from: b  reason: collision with root package name */
    private int f10535b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10536c;

    /* renamed from: d  reason: collision with root package name */
    private final c f10537d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f10538e;

    /* renamed from: f  reason: collision with root package name */
    private final g<R> f10539f;

    /* renamed from: g  reason: collision with root package name */
    private final RequestCoordinator f10540g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f10541h;

    /* renamed from: i  reason: collision with root package name */
    private final e f10542i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f10543j;

    /* renamed from: k  reason: collision with root package name */
    private final Class<R> f10544k;

    /* renamed from: l  reason: collision with root package name */
    private final a<?> f10545l;

    /* renamed from: m  reason: collision with root package name */
    private final int f10546m;

    /* renamed from: n  reason: collision with root package name */
    private final int f10547n;

    /* renamed from: o  reason: collision with root package name */
    private final Priority f10548o;

    /* renamed from: p  reason: collision with root package name */
    private final j<R> f10549p;

    /* renamed from: q  reason: collision with root package name */
    private final List<g<R>> f10550q;

    /* renamed from: r  reason: collision with root package name */
    private final ca.c<? super R> f10551r;

    /* renamed from: s  reason: collision with root package name */
    private final Executor f10552s;

    /* renamed from: t  reason: collision with root package name */
    private s<R> f10553t;

    /* renamed from: u  reason: collision with root package name */
    private i.d f10554u;

    /* renamed from: v  reason: collision with root package name */
    private long f10555v;

    /* renamed from: w  reason: collision with root package name */
    private volatile com.bumptech.glide.load.engine.i f10556w;

    /* renamed from: x  reason: collision with root package name */
    private Status f10557x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f10558y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f10559z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, e eVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, j<R> jVar, g<R> gVar, List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, ca.c<? super R> cVar, Executor executor) {
        this.f10536c = f10534a ? String.valueOf(super.hashCode()) : null;
        this.f10537d = c.a();
        this.f10538e = obj;
        this.f10541h = context;
        this.f10542i = eVar;
        this.f10543j = obj2;
        this.f10544k = cls;
        this.f10545l = aVar;
        this.f10546m = i2;
        this.f10547n = i3;
        this.f10548o = priority;
        this.f10549p = jVar;
        this.f10539f = gVar;
        this.f10550q = list;
        this.f10540g = requestCoordinator;
        this.f10556w = iVar;
        this.f10551r = cVar;
        this.f10552s = executor;
        this.f10557x = Status.PENDING;
        if (this.E == null && eVar.g().a(d.c.class)) {
            this.E = new RuntimeException("Glide request origin trace");
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private Drawable a(int i2) {
        return b.a((Context) this.f10542i, i2, this.f10545l.B() != null ? this.f10545l.B() : this.f10541h.getTheme());
    }

    public static <R> SingleRequest<R> a(Context context, e eVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, j<R> jVar, g<R> gVar, List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, ca.c<? super R> cVar, Executor executor) {
        return new SingleRequest(context, eVar, obj, obj2, cls, aVar, i2, i3, priority, jVar, gVar, list, requestCoordinator, iVar, cVar, executor);
    }

    /* JADX INFO: finally extract failed */
    private void a(GlideException glideException, int i2) {
        boolean z2;
        this.f10537d.b();
        synchronized (this.f10538e) {
            glideException.a((Exception) this.E);
            int e2 = this.f10542i.e();
            if (e2 <= i2) {
                Log.w("Glide", "Load failed for " + this.f10543j + " with size [" + this.B + "x" + this.C + "]", glideException);
                if (e2 <= 4) {
                    glideException.a("Glide");
                }
            }
            this.f10554u = null;
            this.f10557x = Status.FAILED;
            boolean z3 = true;
            this.D = true;
            try {
                List<g<R>> list = this.f10550q;
                if (list != null) {
                    z2 = false;
                    for (g<R> onLoadFailed : list) {
                        z2 |= onLoadFailed.onLoadFailed(glideException, this.f10543j, this.f10549p, r());
                    }
                } else {
                    z2 = false;
                }
                g<R> gVar = this.f10539f;
                if (gVar == null || !gVar.onLoadFailed(glideException, this.f10543j, this.f10549p, r())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    n();
                }
                this.D = false;
                t();
                cd.b.a("GlideRequest", this.f10535b);
            } catch (Throwable th) {
                this.D = false;
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7 A[Catch:{ all -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bumptech.glide.load.engine.s<R> r10, R r11, com.bumptech.glide.load.DataSource r12, boolean r13) {
        /*
            r9 = this;
            boolean r13 = r9.r()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r9.f10557x = r0
            r9.f10553t = r10
            com.bumptech.glide.e r10 = r9.f10542i
            int r10 = r10.e()
            r0 = 3
            if (r10 > r0) goto L_0x006a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Finished loading "
            r10.append(r0)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            java.lang.String r0 = " from "
            r10.append(r0)
            r10.append(r12)
            java.lang.String r0 = " for "
            r10.append(r0)
            java.lang.Object r0 = r9.f10543j
            r10.append(r0)
            java.lang.String r0 = " with size ["
            r10.append(r0)
            int r0 = r9.B
            r10.append(r0)
            java.lang.String r0 = "x"
            r10.append(r0)
            int r0 = r9.C
            r10.append(r0)
            java.lang.String r0 = "] in "
            r10.append(r0)
            long r0 = r9.f10555v
            double r0 = cc.g.a(r0)
            r10.append(r0)
            java.lang.String r0 = " ms"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r10)
        L_0x006a:
            r10 = 1
            r9.D = r10
            r6 = 0
            java.util.List<com.bumptech.glide.request.g<R>> r0 = r9.f10550q     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x0090
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x00bf }
            r8 = 0
        L_0x0077:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x0091
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00bf }
            com.bumptech.glide.request.g r0 = (com.bumptech.glide.request.g) r0     // Catch:{ all -> 0x00bf }
            java.lang.Object r2 = r9.f10543j     // Catch:{ all -> 0x00bf }
            bz.j<R> r3 = r9.f10549p     // Catch:{ all -> 0x00bf }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bf }
            r8 = r8 | r0
            goto L_0x0077
        L_0x0090:
            r8 = 0
        L_0x0091:
            com.bumptech.glide.request.g<R> r0 = r9.f10539f     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r2 = r9.f10543j     // Catch:{ all -> 0x00bf }
            bz.j<R> r3 = r9.f10549p     // Catch:{ all -> 0x00bf }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r10 = 0
        L_0x00a4:
            r10 = r10 | r8
            if (r10 != 0) goto L_0x00b2
            ca.c<? super R> r10 = r9.f10551r     // Catch:{ all -> 0x00bf }
            ca.b r10 = r10.a(r12, r13)     // Catch:{ all -> 0x00bf }
            bz.j<R> r12 = r9.f10549p     // Catch:{ all -> 0x00bf }
            r12.a(r11, r10)     // Catch:{ all -> 0x00bf }
        L_0x00b2:
            r9.D = r6
            r9.s()
            int r10 = r9.f10535b
            java.lang.String r11 = "GlideRequest"
            cd.b.a(r11, r10)
            return
        L_0x00bf:
            r10 = move-exception
            r9.D = r6
            goto L_0x00c4
        L_0x00c3:
            throw r10
        L_0x00c4:
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.s, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }

    private void a(Object obj) {
        List<g<R>> list = this.f10550q;
        if (list != null) {
            for (g next : list) {
                if (next instanceof c) {
                    ((c) next).a(obj);
                }
            }
        }
    }

    private void a(String str) {
        Log.v("GlideRequest", str + " this: " + this.f10536c);
    }

    private void i() {
        j();
        this.f10537d.b();
        this.f10549p.b((bz.i) this);
        i.d dVar = this.f10554u;
        if (dVar != null) {
            dVar.a();
            this.f10554u = null;
        }
    }

    private void j() {
        if (this.D) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        if (this.f10558y == null) {
            Drawable v2 = this.f10545l.v();
            this.f10558y = v2;
            if (v2 == null && this.f10545l.w() > 0) {
                this.f10558y = a(this.f10545l.w());
            }
        }
        return this.f10558y;
    }

    private Drawable l() {
        if (this.f10559z == null) {
            Drawable y2 = this.f10545l.y();
            this.f10559z = y2;
            if (y2 == null && this.f10545l.x() > 0) {
                this.f10559z = a(this.f10545l.x());
            }
        }
        return this.f10559z;
    }

    private Drawable m() {
        if (this.A == null) {
            Drawable A2 = this.f10545l.A();
            this.A = A2;
            if (A2 == null && this.f10545l.z() > 0) {
                this.A = a(this.f10545l.z());
            }
        }
        return this.A;
    }

    private void n() {
        if (q()) {
            Drawable drawable = null;
            if (this.f10543j == null) {
                drawable = m();
            }
            if (drawable == null) {
                drawable = k();
            }
            if (drawable == null) {
                drawable = l();
            }
            this.f10549p.b(drawable);
        }
    }

    private boolean o() {
        RequestCoordinator requestCoordinator = this.f10540g;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean p() {
        RequestCoordinator requestCoordinator = this.f10540g;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean q() {
        RequestCoordinator requestCoordinator = this.f10540g;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private boolean r() {
        RequestCoordinator requestCoordinator = this.f10540g;
        return requestCoordinator == null || !requestCoordinator.h().g();
    }

    private void s() {
        RequestCoordinator requestCoordinator = this.f10540g;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    private void t() {
        RequestCoordinator requestCoordinator = this.f10540g;
        if (requestCoordinator != null) {
            requestCoordinator.f(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f10538e
            monitor-enter(r0)
            r4.j()     // Catch:{ all -> 0x00bd }
            cd.c r1 = r4.f10537d     // Catch:{ all -> 0x00bd }
            r1.b()     // Catch:{ all -> 0x00bd }
            long r1 = cc.g.a()     // Catch:{ all -> 0x00bd }
            r4.f10555v = r1     // Catch:{ all -> 0x00bd }
            java.lang.Object r1 = r4.f10543j     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x003c
            int r1 = r4.f10546m     // Catch:{ all -> 0x00bd }
            int r2 = r4.f10547n     // Catch:{ all -> 0x00bd }
            boolean r1 = cc.l.a((int) r1, (int) r2)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0027
            int r1 = r4.f10546m     // Catch:{ all -> 0x00bd }
            r4.B = r1     // Catch:{ all -> 0x00bd }
            int r1 = r4.f10547n     // Catch:{ all -> 0x00bd }
            r4.C = r1     // Catch:{ all -> 0x00bd }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r4.m()     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00bd }
            r4.a((com.bumptech.glide.load.engine.GlideException) r2, (int) r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.f10557x     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00bd }
            if (r1 == r2) goto L_0x00b5
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.f10557x     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00bd }
            if (r1 != r2) goto L_0x0052
            com.bumptech.glide.load.engine.s<R> r1 = r4.f10553t     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00bd }
            r3 = 0
            r4.a(r1, r2, r3)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0052:
            java.lang.Object r1 = r4.f10543j     // Catch:{ all -> 0x00bd }
            r4.a((java.lang.Object) r1)     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "GlideRequest"
            int r1 = cd.b.b(r1)     // Catch:{ all -> 0x00bd }
            r4.f10535b = r1     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00bd }
            r4.f10557x = r1     // Catch:{ all -> 0x00bd }
            int r1 = r4.f10546m     // Catch:{ all -> 0x00bd }
            int r2 = r4.f10547n     // Catch:{ all -> 0x00bd }
            boolean r1 = cc.l.a((int) r1, (int) r2)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0075
            int r1 = r4.f10546m     // Catch:{ all -> 0x00bd }
            int r2 = r4.f10547n     // Catch:{ all -> 0x00bd }
            r4.a((int) r1, (int) r2)     // Catch:{ all -> 0x00bd }
            goto L_0x007a
        L_0x0075:
            bz.j<R> r1 = r4.f10549p     // Catch:{ all -> 0x00bd }
            r1.a((bz.i) r4)     // Catch:{ all -> 0x00bd }
        L_0x007a:
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.f10557x     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00bd }
            if (r1 == r2) goto L_0x0086
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.f10557x     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00bd }
            if (r1 != r2) goto L_0x0095
        L_0x0086:
            boolean r1 = r4.q()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0095
            bz.j<R> r1 = r4.f10549p     // Catch:{ all -> 0x00bd }
            android.graphics.drawable.Drawable r2 = r4.l()     // Catch:{ all -> 0x00bd }
            r1.c(r2)     // Catch:{ all -> 0x00bd }
        L_0x0095:
            boolean r1 = f10534a     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00b3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r1.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            long r2 = r4.f10555v     // Catch:{ all -> 0x00bd }
            double r2 = cc.g.a(r2)     // Catch:{ all -> 0x00bd }
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00bd }
            r4.a((java.lang.String) r1)     // Catch:{ all -> 0x00bd }
        L_0x00b3:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00b5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00bd }
            throw r1     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a():void");
    }

    public void a(int i2, int i3) {
        Object obj;
        this.f10537d.b();
        Object obj2 = this.f10538e;
        synchronized (obj2) {
            try {
                boolean z2 = f10534a;
                if (z2) {
                    a("Got onSizeReady in " + g.a(this.f10555v));
                }
                if (this.f10557x == Status.WAITING_FOR_SIZE) {
                    this.f10557x = Status.RUNNING;
                    float J = this.f10545l.J();
                    this.B = a(i2, J);
                    this.C = a(i3, J);
                    if (z2) {
                        a("finished setup for calling load in " + g.a(this.f10555v));
                    }
                    boolean z3 = z2;
                    obj = obj2;
                    try {
                        this.f10554u = this.f10556w.a(this.f10542i, this.f10543j, this.f10545l.D(), this.B, this.C, this.f10545l.t(), this.f10544k, this.f10548o, this.f10545l.u(), this.f10545l.q(), this.f10545l.r(), this.f10545l.K(), this.f10545l.s(), this.f10545l.C(), this.f10545l.L(), this.f10545l.M(), this.f10545l.N(), this, this.f10552s);
                        if (this.f10557x != Status.RUNNING) {
                            this.f10554u = null;
                        }
                        if (z3) {
                            a("finished onSizeReady in " + g.a(this.f10555v));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.bumptech.glide.load.engine.i$d, com.bumptech.glide.load.engine.s<R>] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.bumptech.glide.load.engine.s] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        r5.f10556w.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bumptech.glide.load.engine.s<?> r6, com.bumptech.glide.load.DataSource r7, boolean r8) {
        /*
            r5 = this;
            cd.c r0 = r5.f10537d
            r0.b()
            r0 = 0
            java.lang.Object r1 = r5.f10538e     // Catch:{ all -> 0x00c0 }
            monitor-enter(r1)     // Catch:{ all -> 0x00c0 }
            r5.f10554u = r0     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x002f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r7.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r8 = "Expected to receive a Resource<R> with an object of "
            r7.append(r8)     // Catch:{ all -> 0x00bd }
            java.lang.Class<R> r8 = r5.f10544k     // Catch:{ all -> 0x00bd }
            r7.append(r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r8 = " inside, but instead got null."
            r7.append(r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00bd }
            r6.<init>(r7)     // Catch:{ all -> 0x00bd }
            r5.a((com.bumptech.glide.load.engine.GlideException) r6)     // Catch:{ all -> 0x00bd }
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            return
        L_0x002f:
            java.lang.Object r2 = r6.d()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0063
            java.lang.Class<R> r3 = r5.f10544k     // Catch:{ all -> 0x00bd }
            java.lang.Class r4 = r2.getClass()     // Catch:{ all -> 0x00bd }
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ all -> 0x00bd }
            if (r3 != 0) goto L_0x0042
            goto L_0x0063
        L_0x0042:
            boolean r3 = r5.o()     // Catch:{ all -> 0x00bd }
            if (r3 != 0) goto L_0x005e
            r5.f10553t = r0     // Catch:{ all -> 0x00b9 }
            com.bumptech.glide.request.SingleRequest$Status r7 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00b9 }
            r5.f10557x = r7     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = "GlideRequest"
            int r8 = r5.f10535b     // Catch:{ all -> 0x00b9 }
            cd.b.a(r7, r8)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x005d
            com.bumptech.glide.load.engine.i r7 = r5.f10556w
            r7.a((com.bumptech.glide.load.engine.s<?>) r6)
        L_0x005d:
            return
        L_0x005e:
            r5.a(r6, r2, r7, r8)     // Catch:{ all -> 0x00bd }
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            return
        L_0x0063:
            r5.f10553t = r0     // Catch:{ all -> 0x00b9 }
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r8.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = "Expected to receive an object of "
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.Class<R> r0 = r5.f10544k     // Catch:{ all -> 0x00b9 }
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = " but instead got "
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x0082
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x00b9 }
            goto L_0x0084
        L_0x0082:
            java.lang.String r0 = ""
        L_0x0084:
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = "{"
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            r8.append(r2)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = "} inside Resource{"
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            r8.append(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = "}."
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x00a1
            java.lang.String r0 = ""
            goto L_0x00a3
        L_0x00a1:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x00a3:
            r8.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b9 }
            r7.<init>(r8)     // Catch:{ all -> 0x00b9 }
            r5.a((com.bumptech.glide.load.engine.GlideException) r7)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x00b8
            com.bumptech.glide.load.engine.i r7 = r5.f10556w
            r7.a((com.bumptech.glide.load.engine.s<?>) r6)
        L_0x00b8:
            return
        L_0x00b9:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L_0x00be
        L_0x00bd:
            r6 = move-exception
        L_0x00be:
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            throw r6     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r6 = move-exception
            if (r0 == 0) goto L_0x00c8
            com.bumptech.glide.load.engine.i r7 = r5.f10556w
            r7.a((com.bumptech.glide.load.engine.s<?>) r0)
        L_0x00c8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.s, com.bumptech.glide.load.DataSource, boolean):void");
    }

    public boolean a(e eVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int size2;
        e eVar2 = eVar;
        if (!(eVar2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f10538e) {
            i2 = this.f10546m;
            i3 = this.f10547n;
            obj = this.f10543j;
            cls = this.f10544k;
            aVar = this.f10545l;
            priority = this.f10548o;
            List<g<R>> list = this.f10550q;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) eVar2;
        synchronized (singleRequest.f10538e) {
            i4 = singleRequest.f10546m;
            i5 = singleRequest.f10547n;
            obj2 = singleRequest.f10543j;
            cls2 = singleRequest.f10544k;
            aVar2 = singleRequest.f10545l;
            priority2 = singleRequest.f10548o;
            List<g<R>> list2 = singleRequest.f10550q;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i2 == i4 && i3 == i5 && l.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r4.f10556w.a((com.bumptech.glide.load.engine.s<?>) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f10538e
            monitor-enter(r0)
            r4.j()     // Catch:{ all -> 0x0042 }
            cd.c r1 = r4.f10537d     // Catch:{ all -> 0x0042 }
            r1.b()     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.f10557x     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0042 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0013:
            r4.i()     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.load.engine.s<R> r1 = r4.f10553t     // Catch:{ all -> 0x0042 }
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r4.f10553t = r2     // Catch:{ all -> 0x0042 }
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            boolean r2 = r4.p()     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x002e
            bz.j<R> r2 = r4.f10549p     // Catch:{ all -> 0x0042 }
            android.graphics.drawable.Drawable r3 = r4.l()     // Catch:{ all -> 0x0042 }
            r2.a((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0042 }
        L_0x002e:
            java.lang.String r2 = "GlideRequest"
            int r3 = r4.f10535b     // Catch:{ all -> 0x0042 }
            cd.b.a(r2, r3)     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0042 }
            r4.f10557x = r2     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.i r0 = r4.f10556w
            r0.a((com.bumptech.glide.load.engine.s<?>) r1)
        L_0x0041:
            return
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.b():void");
    }

    public void c() {
        synchronized (this.f10538e) {
            if (d()) {
                b();
            }
        }
    }

    public boolean d() {
        boolean z2;
        synchronized (this.f10538e) {
            if (this.f10557x != Status.RUNNING) {
                if (this.f10557x != Status.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean e() {
        boolean z2;
        synchronized (this.f10538e) {
            z2 = this.f10557x == Status.COMPLETE;
        }
        return z2;
    }

    public boolean f() {
        boolean z2;
        synchronized (this.f10538e) {
            z2 = this.f10557x == Status.CLEARED;
        }
        return z2;
    }

    public boolean g() {
        boolean z2;
        synchronized (this.f10538e) {
            z2 = this.f10557x == Status.COMPLETE;
        }
        return z2;
    }

    public Object h() {
        this.f10537d.b();
        return this.f10538e;
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f10538e) {
            obj = this.f10543j;
            cls = this.f10544k;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
