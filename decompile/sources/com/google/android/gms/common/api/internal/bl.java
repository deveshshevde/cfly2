package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import java.util.Set;

final class bl implements cc, d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f17501a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a.f f17502b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b<?> f17503c;

    /* renamed from: d  reason: collision with root package name */
    private h f17504d = null;

    /* renamed from: e  reason: collision with root package name */
    private Set<Scope> f17505e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f17506f = false;

    public bl(f fVar, a.f fVar2, b<?> bVar) {
        this.f17501a = fVar;
        this.f17502b = fVar2;
        this.f17503c = bVar;
    }

    /* access modifiers changed from: private */
    public final void a() {
        h hVar;
        if (this.f17506f && (hVar = this.f17504d) != null) {
            this.f17502b.getRemoteService(hVar, this.f17505e);
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.f17501a.f11830t.post(new bk(this, connectionResult));
    }

    public final void a(h hVar, Set<Scope> set) {
        if (hVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
            return;
        }
        this.f17504d = hVar;
        this.f17505e = set;
        a();
    }

    public final void b(ConnectionResult connectionResult) {
        bh bhVar = (bh) this.f17501a.f11826p.get(this.f17503c);
        if (bhVar != null) {
            bhVar.b(connectionResult);
        }
    }
}
