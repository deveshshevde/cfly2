package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class ae implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<d.b> f11832a = new ArrayList<>();
    @NotOnlyInitialized

    /* renamed from: b  reason: collision with root package name */
    private final ad f11833b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<d.b> f11834c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<d.c> f11835d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f11836e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f11837f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private boolean f11838g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f11839h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f11840i = new Object();

    public ae(Looper looper, ad adVar) {
        this.f11833b = adVar;
        this.f11839h = new zaq(looper, this);
    }

    public final void a() {
        this.f11836e = false;
        this.f11837f.incrementAndGet();
    }

    public final void a(int i2) {
        m.a(this.f11839h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f11839h.removeMessages(1);
        synchronized (this.f11840i) {
            this.f11838g = true;
            ArrayList arrayList = new ArrayList(this.f11834c);
            int i3 = this.f11837f.get();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                d.b bVar = (d.b) it2.next();
                if (!this.f11836e) {
                    break;
                } else if (this.f11837f.get() != i3) {
                    break;
                } else if (this.f11834c.contains(bVar)) {
                    bVar.a(i2);
                }
            }
            this.f11832a.clear();
            this.f11838g = false;
        }
    }

    public final void a(Bundle bundle) {
        m.a(this.f11839h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f11840i) {
            m.b(!this.f11838g);
            this.f11839h.removeMessages(1);
            this.f11838g = true;
            m.b(this.f11832a.isEmpty());
            ArrayList arrayList = new ArrayList(this.f11834c);
            int i2 = this.f11837f.get();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                d.b bVar = (d.b) it2.next();
                if (!this.f11836e || !this.f11833b.isConnected()) {
                    break;
                } else if (this.f11837f.get() != i2) {
                    break;
                } else if (!this.f11832a.contains(bVar)) {
                    bVar.a(bundle);
                }
            }
            this.f11832a.clear();
            this.f11838g = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            android.os.Handler r0 = r5.f11839h
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.m.a((android.os.Handler) r0, (java.lang.String) r1)
            android.os.Handler r0 = r5.f11839h
            r1 = 1
            r0.removeMessages(r1)
            java.lang.Object r0 = r5.f11840i
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x004a }
            java.util.ArrayList<com.google.android.gms.common.api.d$c> r2 = r5.f11835d     // Catch:{ all -> 0x004a }
            r1.<init>(r2)     // Catch:{ all -> 0x004a }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f11837f     // Catch:{ all -> 0x004a }
            int r2 = r2.get()     // Catch:{ all -> 0x004a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004a }
        L_0x0021:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x004a }
            com.google.android.gms.common.api.d$c r3 = (com.google.android.gms.common.api.d.c) r3     // Catch:{ all -> 0x004a }
            boolean r4 = r5.f11836e     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0046
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f11837f     // Catch:{ all -> 0x004a }
            int r4 = r4.get()     // Catch:{ all -> 0x004a }
            if (r4 == r2) goto L_0x003a
            goto L_0x0046
        L_0x003a:
            java.util.ArrayList<com.google.android.gms.common.api.d$c> r4 = r5.f11835d     // Catch:{ all -> 0x004a }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0021
            r3.a(r6)     // Catch:{ all -> 0x004a }
            goto L_0x0021
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            goto L_0x004e
        L_0x004d:
            throw r6
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.ae.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void a(d.b bVar) {
        m.a(bVar);
        synchronized (this.f11840i) {
            if (this.f11834c.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11834c.add(bVar);
            }
        }
        if (this.f11833b.isConnected()) {
            Handler handler = this.f11839h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void a(d.c cVar) {
        m.a(cVar);
        synchronized (this.f11840i) {
            if (this.f11835d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11835d.add(cVar);
            }
        }
    }

    public final void b() {
        this.f11836e = true;
    }

    public final void b(d.c cVar) {
        m.a(cVar);
        synchronized (this.f11840i) {
            if (!this.f11835d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            d.b bVar = (d.b) message.obj;
            synchronized (this.f11840i) {
                if (this.f11836e && this.f11833b.isConnected() && this.f11834c.contains(bVar)) {
                    bVar.a((Bundle) null);
                }
            }
            return true;
        }
        int i2 = message.what;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i2);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }
}
