package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.internal.m;
import java.util.Set;

public final class ad implements aw {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final az f17417a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17418b = false;

    public ad(az azVar) {
        this.f17417a = azVar;
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        b(t2);
        return t2;
    }

    public final void a() {
    }

    public final void a(int i2) {
        this.f17417a.a((ConnectionResult) null);
        this.f17417a.f11789h.a(i2, this.f17418b);
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        try {
            this.f17417a.f11788g.f17467i.a(t2);
            av avVar = this.f17417a.f11788g;
            a.f fVar = avVar.f17461c.get(t2.getClientKey());
            m.a(fVar, (Object) "Appropriate Api was not requested.");
            if (fVar.isConnected() || !this.f17417a.f11783b.containsKey(t2.getClientKey())) {
                t2.run(fVar);
            } else {
                t2.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f17417a.a((ax) new ab(this, this));
        }
        return t2;
    }

    public final void b() {
        if (this.f17418b) {
            this.f17418b = false;
            this.f17417a.a((ax) new ac(this, this));
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.f17418b) {
            this.f17418b = false;
            this.f17417a.f11788g.f17467i.a();
            d();
        }
    }

    public final boolean d() {
        if (this.f17418b) {
            return false;
        }
        Set<cj> set = this.f17417a.f11788g.f17466h;
        if (set == null || set.isEmpty()) {
            this.f17417a.a((ConnectionResult) null);
            return true;
        }
        this.f17418b = true;
        for (cj a2 : set) {
            a2.a();
        }
        return false;
    }
}
