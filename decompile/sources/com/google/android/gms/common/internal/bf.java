package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class bf implements ServiceConnection, bj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f17805a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<ServiceConnection, ServiceConnection> f17806b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private int f17807c = 2;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17808d;

    /* renamed from: e  reason: collision with root package name */
    private IBinder f17809e;

    /* renamed from: f  reason: collision with root package name */
    private final be f17810f;

    /* renamed from: g  reason: collision with root package name */
    private ComponentName f17811g;

    public bf(bi biVar, be beVar) {
        this.f17805a = biVar;
        this.f17810f = beVar;
    }

    public final int a() {
        return this.f17807c;
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f17806b.put(serviceConnection, serviceConnection2);
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        this.f17806b.remove(serviceConnection);
    }

    public final void a(String str) {
        this.f17805a.f17815d.removeMessages(1, this.f17810f);
        bi biVar = this.f17805a;
        biVar.f17817f.a(biVar.f17814c, this);
        this.f17808d = false;
        this.f17807c = 2;
    }

    public final void a(String str, Executor executor) {
        this.f17807c = 3;
        bi biVar = this.f17805a;
        boolean a2 = biVar.f17817f.a(biVar.f17814c, str, this.f17810f.a(biVar.f17814c), this, this.f17810f.a(), executor);
        this.f17808d = a2;
        if (a2) {
            this.f17805a.f17815d.sendMessageDelayed(this.f17805a.f17815d.obtainMessage(1, this.f17810f), this.f17805a.f17819h);
            return;
        }
        this.f17807c = 2;
        try {
            bi biVar2 = this.f17805a;
            biVar2.f17817f.a(biVar2.f17814c, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f17806b.containsKey(serviceConnection);
    }

    public final ComponentName b() {
        return this.f17811g;
    }

    public final IBinder c() {
        return this.f17809e;
    }

    public final boolean d() {
        return this.f17806b.isEmpty();
    }

    public final boolean e() {
        return this.f17808d;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f17805a.f17813b) {
            this.f17805a.f17815d.removeMessages(1, this.f17810f);
            this.f17809e = iBinder;
            this.f17811g = componentName;
            for (ServiceConnection onServiceConnected : this.f17806b.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f17807c = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f17805a.f17813b) {
            this.f17805a.f17815d.removeMessages(1, this.f17810f);
            this.f17809e = null;
            this.f17811g = componentName;
            for (ServiceConnection onServiceDisconnected : this.f17806b.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f17807c = 2;
        }
    }
}
