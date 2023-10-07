package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import gg.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class bh<O extends a.d> implements d.b, d.c, db {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f11797a;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<cp> f11798b = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: c  reason: collision with root package name */
    public final a.f f11799c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b<O> f11800d;

    /* renamed from: e  reason: collision with root package name */
    private final x f11801e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<cs> f11802f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Map<j.a<?>, bx> f11803g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final int f11804h;

    /* renamed from: i  reason: collision with root package name */
    private final cd f11805i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11806j;

    /* renamed from: k  reason: collision with root package name */
    private final List<bj> f11807k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private ConnectionResult f11808l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f11809m = 0;

    public bh(f fVar, c<O> cVar) {
        this.f11797a = fVar;
        a.f a2 = cVar.a(fVar.f11830t.getLooper(), (bh<O>) this);
        this.f11799c = a2;
        this.f11800d = cVar.b();
        this.f11801e = new x();
        this.f11804h = cVar.e();
        if (a2.requiresSignIn()) {
            this.f11805i = cVar.a(fVar.f11821k, fVar.f11830t);
        } else {
            this.f11805i = null;
        }
    }

    private final Feature a(Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] availableFeatures = this.f11799c.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            j.a aVar = new j.a(r3);
            for (Feature feature : availableFeatures) {
                aVar.put(feature.b(), Long.valueOf(feature.a()));
            }
            for (Feature feature2 : featureArr) {
                Long l2 = (Long) aVar.get(feature2.b());
                if (l2 == null || l2.longValue() < feature2.a()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void a(Status status) {
        m.a(this.f11797a.f11830t);
        a(status, (Exception) null, false);
    }

    private final void a(Status status, Exception exc, boolean z2) {
        m.a(this.f11797a.f11830t);
        boolean z3 = false;
        boolean z4 = status == null;
        if (exc == null) {
            z3 = true;
        }
        if (z4 != z3) {
            Iterator it2 = this.f11798b.iterator();
            while (it2.hasNext()) {
                cp cpVar = (cp) it2.next();
                if (!z2 || cpVar.f17568c == 2) {
                    if (status != null) {
                        cpVar.a(status);
                    } else {
                        cpVar.a(exc);
                    }
                    it2.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    static /* synthetic */ void a(bh bhVar, bj bjVar) {
        if (!bhVar.f11807k.contains(bjVar) || bhVar.f11806j) {
            return;
        }
        if (!bhVar.f11799c.isConnected()) {
            bhVar.g();
        } else {
            bhVar.o();
        }
    }

    /* access modifiers changed from: private */
    public final boolean a(boolean z2) {
        m.a(this.f11797a.f11830t);
        if (!this.f11799c.isConnected() || this.f11803g.size() != 0) {
            return false;
        }
        if (this.f11801e.b()) {
            if (z2) {
                q();
            }
            return false;
        }
        this.f11799c.disconnect("Timing out service connection.");
        return true;
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        f();
        this.f11806j = true;
        this.f11801e.a(i2, this.f11799c.getLastDisconnectMessage());
        f fVar = this.f11797a;
        fVar.f11830t.sendMessageDelayed(Message.obtain(fVar.f11830t, 9, this.f11800d), this.f11797a.f11815e);
        f fVar2 = this.f11797a;
        fVar2.f11830t.sendMessageDelayed(Message.obtain(fVar2.f11830t, 11, this.f11800d), this.f11797a.f11816f);
        this.f11797a.f11823m.a();
        for (bx bxVar : this.f11803g.values()) {
            bxVar.f17526c.run();
        }
    }

    static /* synthetic */ void b(bh bhVar, bj bjVar) {
        Feature[] b2;
        if (bhVar.f11807k.remove(bjVar)) {
            bhVar.f11797a.f11830t.removeMessages(15, bjVar);
            bhVar.f11797a.f11830t.removeMessages(16, bjVar);
            Feature a2 = bjVar.f17498b;
            ArrayList arrayList = new ArrayList(bhVar.f11798b.size());
            for (cp cpVar : bhVar.f11798b) {
                if ((cpVar instanceof bp) && (b2 = ((bp) cpVar).b(bhVar)) != null && com.google.android.gms.common.util.a.a((T[]) b2, a2)) {
                    arrayList.add(cpVar);
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                cp cpVar2 = (cp) arrayList.get(i2);
                bhVar.f11798b.remove(cpVar2);
                cpVar2.a((Exception) new UnsupportedApiCallException(a2));
            }
        }
    }

    private final void b(cp cpVar) {
        cpVar.a(this.f11801e, m());
        try {
            cpVar.d(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.f11799c.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void c(ConnectionResult connectionResult) {
        for (cs a2 : this.f11802f) {
            a2.a(this.f11800d, connectionResult, l.a(connectionResult, ConnectionResult.f17353a) ? this.f11799c.getEndpointPackageName() : null);
        }
        this.f11802f.clear();
    }

    private final boolean c(cp cpVar) {
        if (!(cpVar instanceof bp)) {
            b(cpVar);
            return true;
        }
        bp bpVar = (bp) cpVar;
        Feature a2 = a(bpVar.b(this));
        if (a2 == null) {
            b(cpVar);
            return true;
        }
        String name = this.f11799c.getClass().getName();
        String b2 = a2.b();
        long a3 = a2.a();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(b2).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(b2);
        sb.append(", ");
        sb.append(a3);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        if (!this.f11797a.f11831u || !bpVar.a(this)) {
            bpVar.a((Exception) new UnsupportedApiCallException(a2));
            return true;
        }
        bj bjVar = new bj(this.f11800d, a2, (bi) null);
        int indexOf = this.f11807k.indexOf(bjVar);
        if (indexOf >= 0) {
            bj bjVar2 = this.f11807k.get(indexOf);
            this.f11797a.f11830t.removeMessages(15, bjVar2);
            f fVar = this.f11797a;
            fVar.f11830t.sendMessageDelayed(Message.obtain(fVar.f11830t, 15, bjVar2), this.f11797a.f11815e);
            return false;
        }
        this.f11807k.add(bjVar);
        f fVar2 = this.f11797a;
        fVar2.f11830t.sendMessageDelayed(Message.obtain(fVar2.f11830t, 15, bjVar), this.f11797a.f11815e);
        f fVar3 = this.f11797a;
        fVar3.f11830t.sendMessageDelayed(Message.obtain(fVar3.f11830t, 16, bjVar), this.f11797a.f11816f);
        ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
        if (d(connectionResult)) {
            return false;
        }
        this.f11797a.b(connectionResult, this.f11804h);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean d(com.google.android.gms.common.ConnectionResult r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.f.f11813c
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.f r1 = r3.f11797a     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.y r2 = r1.f11827q     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0027
            java.util.Set r1 = r1.f11828r     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.b<O> r2 = r3.f11800d     // Catch:{ all -> 0x002a }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0027
            com.google.android.gms.common.api.internal.f r1 = r3.f11797a     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.y r1 = r1.f11827q     // Catch:{ all -> 0x002a }
            int r2 = r3.f11804h     // Catch:{ all -> 0x002a }
            r1.b(r4, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 1
            return r4
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 0
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.bh.d(com.google.android.gms.common.ConnectionResult):boolean");
    }

    private final void o() {
        ArrayList arrayList = new ArrayList(this.f11798b);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            cp cpVar = (cp) arrayList.get(i2);
            if (this.f11799c.isConnected()) {
                if (c(cpVar)) {
                    this.f11798b.remove(cpVar);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void p() {
        f();
        c(ConnectionResult.f17353a);
        r();
        Iterator<bx> it2 = this.f11803g.values().iterator();
        while (it2.hasNext()) {
            bx next = it2.next();
            if (a(next.f17524a.b()) == null) {
                try {
                    next.f17524a.a(this.f11799c, new com.google.android.gms.tasks.c());
                } catch (DeadObjectException unused) {
                    a(3);
                    this.f11799c.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it2.remove();
        }
        o();
        q();
    }

    private final void q() {
        this.f11797a.f11830t.removeMessages(12, this.f11800d);
        f fVar = this.f11797a;
        fVar.f11830t.sendMessageDelayed(fVar.f11830t.obtainMessage(12, this.f11800d), this.f11797a.f11817g);
    }

    private final void r() {
        if (this.f11806j) {
            this.f11797a.f11830t.removeMessages(11, this.f11800d);
            this.f11797a.f11830t.removeMessages(9, this.f11800d);
            this.f11806j = false;
        }
    }

    public final int a() {
        return this.f11804h;
    }

    public final void a(int i2) {
        if (Looper.myLooper() == this.f11797a.f11830t.getLooper()) {
            b(i2);
        } else {
            this.f11797a.f11830t.post(new be(this, i2));
        }
    }

    public final void a(Bundle bundle) {
        if (Looper.myLooper() == this.f11797a.f11830t.getLooper()) {
            p();
        } else {
            this.f11797a.f11830t.post(new bd(this));
        }
    }

    public final void a(ConnectionResult connectionResult) {
        a(connectionResult, (Exception) null);
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
        throw null;
    }

    public final void a(ConnectionResult connectionResult, Exception exc) {
        m.a(this.f11797a.f11830t);
        cd cdVar = this.f11805i;
        if (cdVar != null) {
            cdVar.a();
        }
        f();
        this.f11797a.f11823m.a();
        c(connectionResult);
        if ((this.f11799c instanceof e) && connectionResult.a() != 24) {
            this.f11797a.f11818h = true;
            f fVar = this.f11797a;
            fVar.f11830t.sendMessageDelayed(fVar.f11830t.obtainMessage(19), 300000);
        }
        if (connectionResult.a() == 4) {
            a(f.f11812b);
        } else if (this.f11798b.isEmpty()) {
            this.f11808l = connectionResult;
        } else if (exc != null) {
            m.a(this.f11797a.f11830t);
            a((Status) null, exc, false);
        } else if (this.f11797a.f11831u) {
            a(f.b((b<?>) this.f11800d, connectionResult), (Exception) null, true);
            if (!this.f11798b.isEmpty() && !d(connectionResult) && !this.f11797a.b(connectionResult, this.f11804h)) {
                if (connectionResult.a() == 18) {
                    this.f11806j = true;
                }
                if (this.f11806j) {
                    f fVar2 = this.f11797a;
                    fVar2.f11830t.sendMessageDelayed(Message.obtain(fVar2.f11830t, 9, this.f11800d), this.f11797a.f11815e);
                    return;
                }
                a(f.b((b<?>) this.f11800d, connectionResult));
            }
        } else {
            a(f.b((b<?>) this.f11800d, connectionResult));
        }
    }

    public final void a(cp cpVar) {
        m.a(this.f11797a.f11830t);
        if (!this.f11799c.isConnected()) {
            this.f11798b.add(cpVar);
            ConnectionResult connectionResult = this.f11808l;
            if (connectionResult == null || !connectionResult.d()) {
                g();
            } else {
                a(this.f11808l, (Exception) null);
            }
        } else if (c(cpVar)) {
            q();
        } else {
            this.f11798b.add(cpVar);
        }
    }

    public final void a(cs csVar) {
        m.a(this.f11797a.f11830t);
        this.f11802f.add(csVar);
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f11809m;
    }

    public final void b(ConnectionResult connectionResult) {
        m.a(this.f11797a.f11830t);
        a.f fVar = this.f11799c;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(valueOf).length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        fVar.disconnect(sb.toString());
        a(connectionResult, (Exception) null);
    }

    public final ConnectionResult c() {
        m.a(this.f11797a.f11830t);
        return this.f11808l;
    }

    public final a.f d() {
        return this.f11799c;
    }

    public final Map<j.a<?>, bx> e() {
        return this.f11803g;
    }

    public final void f() {
        m.a(this.f11797a.f11830t);
        this.f11808l = null;
    }

    public final void g() {
        ConnectionResult connectionResult;
        m.a(this.f11797a.f11830t);
        if (!this.f11799c.isConnected() && !this.f11799c.isConnecting()) {
            try {
                f fVar = this.f11797a;
                int a2 = fVar.f11823m.a(fVar.f11821k, this.f11799c);
                if (a2 != 0) {
                    ConnectionResult connectionResult2 = new ConnectionResult(a2, (PendingIntent) null);
                    String name = this.f11799c.getClass().getName();
                    String obj = connectionResult2.toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 35 + obj.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(obj);
                    Log.w("GoogleApiManager", sb.toString());
                    a(connectionResult2, (Exception) null);
                    return;
                }
                f fVar2 = this.f11797a;
                a.f fVar3 = this.f11799c;
                bl blVar = new bl(fVar2, fVar3, this.f11800d);
                if (fVar3.requiresSignIn()) {
                    ((cd) m.a(this.f11805i)).a((cc) blVar);
                }
                try {
                    this.f11799c.connect(blVar);
                } catch (SecurityException e2) {
                    e = e2;
                    connectionResult = new ConnectionResult(10);
                    a(connectionResult, e);
                }
            } catch (IllegalStateException e3) {
                e = e3;
                connectionResult = new ConnectionResult(10);
                a(connectionResult, e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        this.f11809m++;
    }

    public final void i() {
        m.a(this.f11797a.f11830t);
        if (this.f11806j) {
            g();
        }
    }

    public final void j() {
        m.a(this.f11797a.f11830t);
        a(f.f11811a);
        this.f11801e.a();
        for (j.a coVar : (j.a[]) this.f11803g.keySet().toArray(new j.a[0])) {
            a((cp) new co(coVar, new com.google.android.gms.tasks.c()));
        }
        c(new ConnectionResult(4));
        if (this.f11799c.isConnected()) {
            this.f11799c.onUserSignOut(new bg(this));
        }
    }

    public final void k() {
        m.a(this.f11797a.f11830t);
        if (this.f11806j) {
            r();
            f fVar = this.f11797a;
            a(fVar.f11822l.a(fVar.f11821k) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f11799c.disconnect("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean l() {
        return this.f11799c.isConnected();
    }

    public final boolean m() {
        return this.f11799c.requiresSignIn();
    }

    public final boolean n() {
        return a(true);
    }
}
