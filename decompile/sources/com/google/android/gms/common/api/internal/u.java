package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.base.zal;
import gk.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class u implements bq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17639a;

    /* renamed from: b  reason: collision with root package name */
    private final av f17640b;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f17641c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final az f17642d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final az f17643e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a.c<?>, az> f17644f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<p> f17645g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: h  reason: collision with root package name */
    private final a.f f17646h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f17647i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ConnectionResult f17648j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ConnectionResult f17649k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f17650l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Lock f17651m;

    /* renamed from: n  reason: collision with root package name */
    private int f17652n = 0;

    private u(Context context, av avVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, Map<a.c<?>, a.f> map2, e eVar, a.C0118a<? extends f, gk.a> aVar, a.f fVar, ArrayList<da> arrayList, ArrayList<da> arrayList2, Map<a<?>, Boolean> map3, Map<a<?>, Boolean> map4) {
        this.f17639a = context;
        this.f17640b = avVar;
        this.f17651m = lock;
        this.f17641c = looper;
        this.f17646h = fVar;
        Context context2 = context;
        av avVar2 = avVar;
        Lock lock2 = lock;
        Looper looper2 = looper;
        d dVar2 = dVar;
        az azVar = r3;
        az azVar2 = new az(context2, avVar2, lock2, looper2, dVar2, map2, (e) null, map4, (a.C0118a<? extends f, gk.a>) null, arrayList2, new dd(this, (dc) null));
        this.f17642d = azVar;
        this.f17643e = new az(context2, avVar2, lock2, looper2, dVar2, map, eVar, map3, aVar, arrayList, new df(this, (de) null));
        j.a aVar2 = new j.a();
        for (a.c<?> put : map2.keySet()) {
            aVar2.put(put, this.f17642d);
        }
        for (a.c<?> put2 : map.keySet()) {
            aVar2.put(put2, this.f17643e);
        }
        this.f17644f = Collections.unmodifiableMap(aVar2);
    }

    public static u a(Context context, av avVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, e eVar, Map<a<?>, Boolean> map2, a.C0118a<? extends f, gk.a> aVar, ArrayList<da> arrayList) {
        Map<a<?>, Boolean> map3 = map2;
        j.a aVar2 = new j.a();
        j.a aVar3 = new j.a();
        a.f fVar = null;
        for (Map.Entry next : map.entrySet()) {
            a.f fVar2 = (a.f) next.getValue();
            if (true == fVar2.providesSignIn()) {
                fVar = fVar2;
            }
            boolean requiresSignIn = fVar2.requiresSignIn();
            a.c cVar = (a.c) next.getKey();
            if (requiresSignIn) {
                aVar2.put(cVar, fVar2);
            } else {
                aVar3.put(cVar, fVar2);
            }
        }
        m.b(!aVar2.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        j.a aVar4 = new j.a();
        j.a aVar5 = new j.a();
        for (a next2 : map2.keySet()) {
            a.c<?> b2 = next2.b();
            if (aVar2.containsKey(b2)) {
                aVar4.put(next2, map3.get(next2));
            } else if (aVar3.containsKey(b2)) {
                aVar5.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            da daVar = arrayList.get(i2);
            if (aVar4.containsKey(daVar.f17590a)) {
                arrayList2.add(daVar);
            } else if (aVar5.containsKey(daVar.f17590a)) {
                arrayList3.add(daVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new u(context, avVar, lock, looper, dVar, aVar2, aVar3, eVar, aVar, fVar, arrayList2, arrayList3, aVar4, aVar5);
    }

    private final void a(ConnectionResult connectionResult) {
        int i2 = this.f17652n;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f17652n = 0;
            }
            this.f17640b.a(connectionResult);
        }
        g();
        this.f17652n = 0;
    }

    static /* bridge */ /* synthetic */ void a(u uVar, int i2, boolean z2) {
        uVar.f17640b.a(i2, z2);
        uVar.f17649k = null;
        uVar.f17648j = null;
    }

    static /* synthetic */ void a(u uVar, Bundle bundle) {
        Bundle bundle2 = uVar.f17647i;
        if (bundle2 == null) {
            uVar.f17647i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.e();
    }

    private final boolean c(d.a<? extends g, ? extends a.b> aVar) {
        az azVar = this.f17644f.get(aVar.getClientKey());
        m.a(azVar, (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return azVar.equals(this.f17643e);
    }

    static /* synthetic */ void e(u uVar) {
        ConnectionResult connectionResult;
        if (b(uVar.f17648j)) {
            if (b(uVar.f17649k) || uVar.h()) {
                int i2 = uVar.f17652n;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        uVar.f17652n = 0;
                        return;
                    }
                    ((av) m.a(uVar.f17640b)).a(uVar.f17647i);
                }
                uVar.g();
                uVar.f17652n = 0;
                return;
            }
            ConnectionResult connectionResult2 = uVar.f17649k;
            if (connectionResult2 == null) {
                return;
            }
            if (uVar.f17652n == 1) {
                uVar.g();
                return;
            }
            uVar.a(connectionResult2);
            uVar.f17642d.b();
        } else if (uVar.f17648j == null || !b(uVar.f17649k)) {
            ConnectionResult connectionResult3 = uVar.f17648j;
            if (connectionResult3 != null && (connectionResult = uVar.f17649k) != null) {
                if (uVar.f17643e.f11787f < uVar.f17642d.f11787f) {
                    connectionResult3 = connectionResult;
                }
                uVar.a(connectionResult3);
            }
        } else {
            uVar.f17643e.b();
            uVar.a((ConnectionResult) m.a(uVar.f17648j));
        }
    }

    private final PendingIntent f() {
        if (this.f17646h == null) {
            return null;
        }
        return zal.zaa(this.f17639a, System.identityHashCode(this.f17640b), this.f17646h.getSignInIntent(), zal.zaa | AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    private final void g() {
        for (p a2 : this.f17645g) {
            a2.a();
        }
        this.f17645g.clear();
    }

    private final boolean h() {
        ConnectionResult connectionResult = this.f17649k;
        return connectionResult != null && connectionResult.a() == 4;
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        if (!c((d.a<? extends g, ? extends a.b>) t2)) {
            this.f17642d.a(t2);
            return t2;
        } else if (h()) {
            t2.setFailedResult(new Status(4, (String) null, f()));
            return t2;
        } else {
            this.f17643e.a(t2);
            return t2;
        }
    }

    public final void a() {
        this.f17652n = 2;
        this.f17650l = false;
        this.f17649k = null;
        this.f17648j = null;
        this.f17642d.a();
        this.f17643e.a();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f17643e.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f17642d.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        if (!c((d.a<? extends g, ? extends a.b>) t2)) {
            return this.f17642d.b(t2);
        }
        if (!h()) {
            return this.f17643e.b(t2);
        }
        t2.setFailedResult(new Status(4, (String) null, f()));
        return t2;
    }

    public final void b() {
        this.f17649k = null;
        this.f17648j = null;
        this.f17652n = 0;
        this.f17642d.b();
        this.f17643e.b();
        g();
    }

    public final void c() {
        this.f17642d.c();
        this.f17643e.c();
    }

    public final boolean d() {
        this.f17651m.lock();
        try {
            boolean z2 = false;
            if (this.f17642d.d() && (this.f17643e.d() || h() || this.f17652n == 1)) {
                z2 = true;
            }
            return z2;
        } finally {
            this.f17651m.unlock();
        }
    }

    public final boolean e() {
        this.f17651m.lock();
        try {
            return this.f17652n == 2;
        } finally {
            this.f17651m.unlock();
        }
    }
}
