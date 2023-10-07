package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.util.g;
import com.google.android.gms.internal.base.zaq;
import j.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static final Status f11811a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Status f11812b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Object f11813c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static f f11814d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f11815e = 5000;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f11816f = 120000;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f11817g = 10000;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f11818h = false;

    /* renamed from: i  reason: collision with root package name */
    private TelemetryData f11819i;

    /* renamed from: j  reason: collision with root package name */
    private p f11820j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Context f11821k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final c f11822l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final af f11823m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f11824n = new AtomicInteger(1);

    /* renamed from: o  reason: collision with root package name */
    private final AtomicInteger f11825o = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Map<b<?>, bh<?>> f11826p = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public y f11827q = null;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Set<b<?>> f11828r = new b();

    /* renamed from: s  reason: collision with root package name */
    private final Set<b<?>> f11829s = new b();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: t  reason: collision with root package name */
    public final Handler f11830t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public volatile boolean f11831u = true;

    private f(Context context, Looper looper, c cVar) {
        this.f11821k = context;
        zaq zaq = new zaq(looper, this);
        this.f11830t = zaq;
        this.f11822l = cVar;
        this.f11823m = new af(cVar);
        if (g.a(context)) {
            this.f11831u = false;
        }
        zaq.sendMessage(zaq.obtainMessage(6));
    }

    public static f a(Context context) {
        f fVar;
        synchronized (f11813c) {
            if (f11814d == null) {
                f11814d = new f(context.getApplicationContext(), com.google.android.gms.common.internal.g.b().getLooper(), c.a());
            }
            fVar = f11814d;
        }
        return fVar;
    }

    private final <T> void a(com.google.android.gms.tasks.c<T> cVar, int i2, com.google.android.gms.common.api.c cVar2) {
        bs a2;
        if (i2 != 0 && (a2 = bs.a(this, i2, (b<?>) cVar2.b())) != null) {
            com.google.android.gms.tasks.b<T> a3 = cVar.a();
            Handler handler = this.f11830t;
            handler.getClass();
            a3.a(new bb(handler), a2);
        }
    }

    /* access modifiers changed from: private */
    public static Status b(b<?> bVar, ConnectionResult connectionResult) {
        String a2 = bVar.a();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 63 + String.valueOf(valueOf).length());
        sb.append("API: ");
        sb.append(a2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    private final bh<?> b(com.google.android.gms.common.api.c<?> cVar) {
        b<?> b2 = cVar.b();
        bh<?> bhVar = this.f11826p.get(b2);
        if (bhVar == null) {
            bhVar = new bh<>(this, cVar);
            this.f11826p.put(b2, bhVar);
        }
        if (bhVar.m()) {
            this.f11829s.add(b2);
        }
        bhVar.g();
        return bhVar;
    }

    private final p f() {
        if (this.f11820j == null) {
            this.f11820j = o.a(this.f11821k);
        }
        return this.f11820j;
    }

    private final void g() {
        TelemetryData telemetryData = this.f11819i;
        if (telemetryData != null) {
            if (telemetryData.a() > 0 || e()) {
                f().a(telemetryData);
            }
            this.f11819i = null;
        }
    }

    public final int a() {
        return this.f11824n.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final bh a(b<?> bVar) {
        return this.f11826p.get(bVar);
    }

    public final void a(ConnectionResult connectionResult, int i2) {
        if (!b(connectionResult, i2)) {
            Handler handler = this.f11830t;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }

    public final void a(com.google.android.gms.common.api.c<?> cVar) {
        Handler handler = this.f11830t;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.d> void a(com.google.android.gms.common.api.c<O> cVar, int i2, d.a<? extends com.google.android.gms.common.api.g, a.b> aVar) {
        cm cmVar = new cm(i2, aVar);
        Handler handler = this.f11830t;
        handler.sendMessage(handler.obtainMessage(4, new bw(cmVar, this.f11825o.get(), cVar)));
    }

    public final <O extends a.d, ResultT> void a(com.google.android.gms.common.api.c<O> cVar, int i2, s<a.b, ResultT> sVar, com.google.android.gms.tasks.c<ResultT> cVar2, r rVar) {
        a(cVar2, sVar.c(), (com.google.android.gms.common.api.c) cVar);
        cn cnVar = new cn(i2, sVar, cVar2, rVar);
        Handler handler = this.f11830t;
        handler.sendMessage(handler.obtainMessage(4, new bw(cnVar, this.f11825o.get(), cVar)));
    }

    public final void a(y yVar) {
        synchronized (f11813c) {
            if (this.f11827q != yVar) {
                this.f11827q = yVar;
                this.f11828r.clear();
            }
            this.f11828r.addAll(yVar.f());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(MethodInvocation methodInvocation, int i2, long j2, int i3) {
        Handler handler = this.f11830t;
        handler.sendMessage(handler.obtainMessage(18, new bt(methodInvocation, i2, j2, i3)));
    }

    /* access modifiers changed from: package-private */
    public final void b(y yVar) {
        synchronized (f11813c) {
            if (this.f11827q == yVar) {
                this.f11827q = null;
                this.f11828r.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(ConnectionResult connectionResult, int i2) {
        return this.f11822l.a(this.f11821k, connectionResult, i2);
    }

    public final void d() {
        Handler handler = this.f11830t;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        if (this.f11818h) {
            return false;
        }
        RootTelemetryConfiguration b2 = n.a().b();
        if (b2 != null && !b2.d()) {
            return false;
        }
        int a2 = this.f11823m.a(this.f11821k, 203400000);
        return a2 == -1 || a2 == 0;
    }

    public final boolean handleMessage(Message message) {
        com.google.android.gms.tasks.c<Boolean> cVar;
        boolean z2;
        long j2 = 300000;
        bh bhVar = null;
        switch (message.what) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f11817g = j2;
                this.f11830t.removeMessages(12);
                for (b<?> obtainMessage : this.f11826p.keySet()) {
                    Handler handler = this.f11830t;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f11817g);
                }
                break;
            case 2:
                cs csVar = (cs) message.obj;
                Iterator<b<?>> it2 = csVar.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else {
                        b next = it2.next();
                        bh bhVar2 = this.f11826p.get(next);
                        if (bhVar2 == null) {
                            csVar.a(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (bhVar2.l()) {
                            csVar.a(next, ConnectionResult.f17353a, bhVar2.d().getEndpointPackageName());
                        } else {
                            ConnectionResult c2 = bhVar2.c();
                            if (c2 != null) {
                                csVar.a(next, c2, (String) null);
                            } else {
                                bhVar2.a(csVar);
                                bhVar2.g();
                            }
                        }
                    }
                }
            case 3:
                for (bh next2 : this.f11826p.values()) {
                    next2.f();
                    next2.g();
                }
                break;
            case 4:
            case 8:
            case 13:
                bw bwVar = (bw) message.obj;
                bh<?> bhVar3 = this.f11826p.get(bwVar.f17523c.b());
                if (bhVar3 == null) {
                    bhVar3 = b(bwVar.f17523c);
                }
                if (bhVar3.m() && this.f11825o.get() != bwVar.f17522b) {
                    bwVar.f17521a.a(f11811a);
                    bhVar3.j();
                    break;
                } else {
                    bhVar3.a(bwVar.f17521a);
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<bh<?>> it3 = this.f11826p.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        bh next3 = it3.next();
                        if (next3.a() == i2) {
                            bhVar = next3;
                        }
                    }
                }
                if (bhVar != null) {
                    if (connectionResult.a() != 13) {
                        bhVar.a(b((b<?>) bhVar.f11800d, connectionResult));
                        break;
                    } else {
                        String a2 = this.f11822l.a(connectionResult.a());
                        String c3 = connectionResult.c();
                        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 69 + String.valueOf(c3).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(a2);
                        sb.append(": ");
                        sb.append(c3);
                        bhVar.a(new Status(17, sb.toString()));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f11821k.getApplicationContext() instanceof Application) {
                    c.a((Application) this.f11821k.getApplicationContext());
                    c.a().a((c.a) new bc(this));
                    if (!c.a().a(true)) {
                        this.f11817g = 300000;
                        break;
                    }
                }
                break;
            case 7:
                b((com.google.android.gms.common.api.c<?>) (com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.f11826p.containsKey(message.obj)) {
                    this.f11826p.get(message.obj).i();
                    break;
                }
                break;
            case 10:
                for (b<?> remove : this.f11829s) {
                    bh remove2 = this.f11826p.remove(remove);
                    if (remove2 != null) {
                        remove2.j();
                    }
                }
                this.f11829s.clear();
                break;
            case 11:
                if (this.f11826p.containsKey(message.obj)) {
                    this.f11826p.get(message.obj).k();
                    break;
                }
                break;
            case 12:
                if (this.f11826p.containsKey(message.obj)) {
                    this.f11826p.get(message.obj).n();
                    break;
                }
                break;
            case 14:
                z zVar = (z) message.obj;
                b<?> a3 = zVar.a();
                if (!this.f11826p.containsKey(a3)) {
                    cVar = zVar.b();
                    z2 = false;
                } else {
                    boolean a4 = this.f11826p.get(a3).a(false);
                    cVar = zVar.b();
                    z2 = Boolean.valueOf(a4);
                }
                cVar.a(z2);
                break;
            case 15:
                bj bjVar = (bj) message.obj;
                if (this.f11826p.containsKey(bjVar.f17497a)) {
                    bh.a((bh) this.f11826p.get(bjVar.f17497a), bjVar);
                    break;
                }
                break;
            case 16:
                bj bjVar2 = (bj) message.obj;
                if (this.f11826p.containsKey(bjVar2.f17497a)) {
                    bh.b(this.f11826p.get(bjVar2.f17497a), bjVar2);
                    break;
                }
                break;
            case 17:
                g();
                break;
            case 18:
                bt btVar = (bt) message.obj;
                if (btVar.f17516c != 0) {
                    TelemetryData telemetryData = this.f11819i;
                    if (telemetryData != null) {
                        List<MethodInvocation> b2 = telemetryData.b();
                        if (telemetryData.a() != btVar.f17515b || (b2 != null && b2.size() >= btVar.f17517d)) {
                            this.f11830t.removeMessages(17);
                            g();
                        } else {
                            this.f11819i.a(btVar.f17514a);
                        }
                    }
                    if (this.f11819i == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(btVar.f17514a);
                        this.f11819i = new TelemetryData(btVar.f17515b, arrayList);
                        Handler handler2 = this.f11830t;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), btVar.f17516c);
                        break;
                    }
                } else {
                    f().a(new TelemetryData(btVar.f17515b, Arrays.asList(new MethodInvocation[]{btVar.f17514a})));
                    break;
                }
                break;
            case 19:
                this.f11818h = false;
                break;
            default:
                int i3 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i3);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
