package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zak;
import gk.e;
import gk.f;
import java.util.Set;

public final class cd extends c implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    private static final a.C0118a<? extends f, gk.a> f17537a = e.f28529c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17538b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f17539c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0118a<? extends f, gk.a> f17540d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Scope> f17541e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.gms.common.internal.e f17542f;

    /* renamed from: g  reason: collision with root package name */
    private f f17543g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public cc f17544h;

    public cd(Context context, Handler handler, com.google.android.gms.common.internal.e eVar) {
        a.C0118a<? extends f, gk.a> aVar = f17537a;
        this.f17538b = context;
        this.f17539c = handler;
        this.f17542f = (com.google.android.gms.common.internal.e) m.a(eVar, (Object) "ClientSettings must not be null");
        this.f17541e = eVar.e();
        this.f17540d = aVar;
    }

    static /* synthetic */ void a(cd cdVar, zak zak) {
        ConnectionResult a2 = zak.a();
        if (a2.e()) {
            zav zav = (zav) m.a(zak.b());
            a2 = zav.a();
            if (!a2.e()) {
                String valueOf = String.valueOf(a2);
                String.valueOf(valueOf).length();
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(valueOf)), new Exception());
            } else {
                cdVar.f17544h.a(zav.b(), cdVar.f17541e);
                cdVar.f17543g.disconnect();
            }
        }
        cdVar.f17544h.b(a2);
        cdVar.f17543g.disconnect();
    }

    public final void a() {
        f fVar = this.f17543g;
        if (fVar != null) {
            fVar.disconnect();
        }
    }

    public final void a(int i2) {
        this.f17543g.disconnect();
    }

    public final void a(Bundle bundle) {
        this.f17543g.a(this);
    }

    public final void a(ConnectionResult connectionResult) {
        this.f17544h.b(connectionResult);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, gk.f] */
    public final void a(cc ccVar) {
        f fVar = this.f17543g;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.f17542f.a(Integer.valueOf(System.identityHashCode(this)));
        a.C0118a aVar = this.f17540d;
        Context context = this.f17538b;
        Looper looper = this.f17539c.getLooper();
        com.google.android.gms.common.internal.e eVar = this.f17542f;
        this.f17543g = aVar.a(context, looper, eVar, eVar.f(), (d.b) this, (d.c) this);
        this.f17544h = ccVar;
        Set<Scope> set = this.f17541e;
        if (set == null || set.isEmpty()) {
            this.f17539c.post(new ca(this));
        } else {
            this.f17543g.b();
        }
    }

    public final void a(zak zak) {
        this.f17539c.post(new cb(this, zak));
    }
}
