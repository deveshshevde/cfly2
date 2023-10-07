package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import gk.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class aq implements aw {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final az f17435a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Lock f17436b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f17437c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d f17438d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f17439e;

    /* renamed from: f  reason: collision with root package name */
    private int f17440f;

    /* renamed from: g  reason: collision with root package name */
    private int f17441g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f17442h;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f17443i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set<a.c> f17444j = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public f f17445k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17446l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f17447m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f17448n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public h f17449o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f17450p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17451q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final e f17452r;

    /* renamed from: s  reason: collision with root package name */
    private final Map<a<?>, Boolean> f17453s;

    /* renamed from: t  reason: collision with root package name */
    private final a.C0118a<? extends f, gk.a> f17454t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList<Future<?>> f17455u = new ArrayList<>();

    public aq(az azVar, e eVar, Map<a<?>, Boolean> map, d dVar, a.C0118a<? extends f, gk.a> aVar, Lock lock, Context context) {
        this.f17435a = azVar;
        this.f17452r = eVar;
        this.f17453s = map;
        this.f17438d = dVar;
        this.f17454t = aVar;
        this.f17436b = lock;
        this.f17437c = context;
    }

    /* access modifiers changed from: private */
    public final void a(ConnectionResult connectionResult) {
        c();
        a(!connectionResult.d());
        this.f17435a.a(connectionResult);
        this.f17435a.f11789h.a(connectionResult);
    }

    static /* synthetic */ void a(aq aqVar, zak zak) {
        if (aqVar.b(0)) {
            ConnectionResult a2 = zak.a();
            if (a2.e()) {
                zav zav = (zav) m.a(zak.b());
                ConnectionResult a3 = zav.a();
                if (!a3.e()) {
                    String valueOf = String.valueOf(a3);
                    String.valueOf(valueOf).length();
                    Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(valueOf)), new Exception());
                    aqVar.a(a3);
                    return;
                }
                aqVar.f17448n = true;
                aqVar.f17449o = (h) m.a(zav.b());
                aqVar.f17450p = zav.c();
                aqVar.f17451q = zav.d();
                aqVar.g();
            } else if (aqVar.b(a2)) {
                aqVar.e();
                aqVar.g();
            } else {
                aqVar.a(a2);
            }
        }
    }

    private final void a(boolean z2) {
        f fVar = this.f17445k;
        if (fVar != null) {
            if (fVar.isConnected() && z2) {
                fVar.a();
            }
            fVar.disconnect();
            e eVar = (e) m.a(this.f17452r);
            this.f17449o = null;
        }
    }

    /* access modifiers changed from: private */
    public final void b(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
        int a2 = aVar.c().a();
        if ((!z2 || connectionResult.d() || this.f17438d.c(connectionResult.a()) != null) && (this.f17439e == null || a2 < this.f17440f)) {
            this.f17439e = connectionResult;
            this.f17440f = a2;
        }
        this.f17435a.f11783b.put(aVar.b(), connectionResult);
    }

    /* access modifiers changed from: private */
    public final boolean b(int i2) {
        if (this.f17441g == i2) {
            return true;
        }
        Log.w("GACConnecting", this.f17435a.f11788g.g());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        int i3 = this.f17442h;
        StringBuilder sb = new StringBuilder(33);
        sb.append("mRemainingConnections=");
        sb.append(i3);
        Log.w("GACConnecting", sb.toString());
        String c2 = c(this.f17441g);
        String c3 = c(i2);
        StringBuilder sb2 = new StringBuilder(c2.length() + 70 + c3.length());
        sb2.append("GoogleApiClient connecting is in step ");
        sb2.append(c2);
        sb2.append(" but received callback for step ");
        sb2.append(c3);
        Log.e("GACConnecting", sb2.toString(), new Exception());
        a(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean b(ConnectionResult connectionResult) {
        return this.f17446l && !connectionResult.d();
    }

    private static final String c(int i2) {
        return i2 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    private final void c() {
        ArrayList<Future<?>> arrayList = this.f17455u;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).cancel(true);
        }
        this.f17455u.clear();
    }

    /* access modifiers changed from: private */
    public final void e() {
        this.f17447m = false;
        this.f17435a.f11788g.f17462d = Collections.emptySet();
        for (a.c next : this.f17444j) {
            if (!this.f17435a.f11783b.containsKey(next)) {
                this.f17435a.f11783b.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void f() {
        this.f17435a.f();
        ba.a().execute(new ae(this));
        f fVar = this.f17445k;
        if (fVar != null) {
            if (this.f17450p) {
                fVar.a((h) m.a(this.f17449o), this.f17451q);
            }
            a(false);
        }
        for (a.c<?> cVar : this.f17435a.f11783b.keySet()) {
            ((a.f) m.a(this.f17435a.f11782a.get(cVar))).disconnect();
        }
        this.f17435a.f11789h.a(this.f17443i.isEmpty() ? null : this.f17443i);
    }

    static /* synthetic */ Set g(aq aqVar) {
        e eVar = aqVar.f17452r;
        if (eVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(eVar.e());
        Map<a<?>, v> i2 = aqVar.f17452r.i();
        for (a next : i2.keySet()) {
            if (!aqVar.f17435a.f11783b.containsKey(next.b())) {
                hashSet.addAll(i2.get(next).f17855a);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public final void g() {
        if (this.f17442h == 0) {
            if (!this.f17447m || this.f17448n) {
                ArrayList arrayList = new ArrayList();
                this.f17441g = 1;
                this.f17442h = this.f17435a.f11782a.size();
                for (a.c next : this.f17435a.f11782a.keySet()) {
                    if (!this.f17435a.f11783b.containsKey(next)) {
                        arrayList.add(this.f17435a.f11782a.get(next));
                    } else if (h()) {
                        f();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f17455u.add(ba.a().submit(new aj(this, arrayList)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean h() {
        ConnectionResult connectionResult;
        int i2 = this.f17442h - 1;
        this.f17442h = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            Log.w("GACConnecting", this.f17435a.f11788g.g());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, (PendingIntent) null);
        } else {
            connectionResult = this.f17439e;
            if (connectionResult == null) {
                return true;
            }
            this.f17435a.f11787f = this.f17440f;
        }
        a(connectionResult);
        return false;
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        this.f17435a.f11788g.f17459a.add(t2);
        return t2;
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.api.a$f, gk.f] */
    public final void a() {
        this.f17435a.f11783b.clear();
        this.f17447m = false;
        this.f17439e = null;
        this.f17441g = 0;
        this.f17446l = true;
        this.f17448n = false;
        this.f17450p = false;
        HashMap hashMap = new HashMap();
        boolean z2 = false;
        for (a next : this.f17453s.keySet()) {
            a.f fVar = (a.f) m.a(this.f17435a.f11782a.get(next.b()));
            z2 |= next.c().a() == 1;
            boolean booleanValue = this.f17453s.get(next).booleanValue();
            if (fVar.requiresSignIn()) {
                this.f17447m = true;
                if (booleanValue) {
                    this.f17444j.add(next.b());
                } else {
                    this.f17446l = false;
                }
            }
            hashMap.put(fVar, new af(this, next, booleanValue));
        }
        if (z2) {
            this.f17447m = false;
        }
        if (this.f17447m) {
            m.a(this.f17452r);
            m.a(this.f17454t);
            this.f17452r.a(Integer.valueOf(System.identityHashCode(this.f17435a.f11788g)));
            an anVar = new an(this, (am) null);
            a.C0118a aVar = this.f17454t;
            Context context = this.f17437c;
            Looper a2 = this.f17435a.f11788g.a();
            e eVar = this.f17452r;
            this.f17445k = aVar.a(context, a2, eVar, eVar.f(), (d.b) anVar, (d.c) anVar);
        }
        this.f17442h = this.f17435a.f11782a.size();
        this.f17455u.add(ba.a().submit(new ai(this, hashMap)));
    }

    public final void a(int i2) {
        a(new ConnectionResult(8, (PendingIntent) null));
    }

    public final void a(Bundle bundle) {
        if (b(1)) {
            if (bundle != null) {
                this.f17443i.putAll(bundle);
            }
            if (h()) {
                f();
            }
        }
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
        if (b(1)) {
            b(connectionResult, aVar, z2);
            if (h()) {
                f();
            }
        }
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void b() {
    }

    public final boolean d() {
        c();
        a(true);
        this.f17435a.a((ConnectionResult) null);
        return true;
    }
}
