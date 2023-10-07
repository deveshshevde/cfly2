package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.m;
import j.b;

public final class y extends cw {

    /* renamed from: e  reason: collision with root package name */
    private final b<b<?>> f17659e = new b<>();

    /* renamed from: f  reason: collision with root package name */
    private final f f17660f;

    y(i iVar, f fVar, c cVar) {
        super(iVar, cVar);
        this.f17660f = fVar;
        this.f17414a.a("ConnectionlessLifecycleHelper", (LifecycleCallback) this);
    }

    public static void a(Activity activity, f fVar, b<?> bVar) {
        i a2 = a(activity);
        y yVar = (y) a2.a("ConnectionlessLifecycleHelper", y.class);
        if (yVar == null) {
            yVar = new y(a2, fVar, c.a());
        }
        m.a(bVar, (Object) "ApiKey cannot be null");
        yVar.f17659e.add(bVar);
        fVar.a(yVar);
    }

    private final void h() {
        if (!this.f17659e.isEmpty()) {
            this.f17660f.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult, int i2) {
        this.f17660f.a(connectionResult, i2);
    }

    public final void c() {
        super.c();
        h();
    }

    public final void d() {
        super.d();
        h();
    }

    public final void e() {
        super.e();
        this.f17660f.b(this);
    }

    /* access modifiers changed from: package-private */
    public final b<b<?>> f() {
        return this.f17659e;
    }

    /* access modifiers changed from: protected */
    public final void g() {
        this.f17660f.d();
    }
}
