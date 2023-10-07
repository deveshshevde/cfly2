package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class aw implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f17794a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17795b;

    public aw(d dVar, int i2) {
        this.f17794a = dVar;
        this.f17795b = i2;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d dVar = this.f17794a;
        if (iBinder == null) {
            d.zzk(dVar, 16);
            return;
        }
        synchronized (dVar.zzq) {
            d dVar2 = this.f17794a;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            dVar2.zzr = (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new ao(iBinder) : (k) queryLocalInterface;
        }
        this.f17794a.zzl(0, (Bundle) null, this.f17795b);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f17794a.zzq) {
            this.f17794a.zzr = null;
        }
        Handler handler = this.f17794a.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.f17795b, 1));
    }
}
