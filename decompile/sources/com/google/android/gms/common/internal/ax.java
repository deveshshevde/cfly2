package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class ax extends am {

    /* renamed from: e  reason: collision with root package name */
    public final IBinder f17796e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f17797f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ax(d dVar, int i2, IBinder iBinder, Bundle bundle) {
        super(dVar, i2, bundle);
        this.f17797f = dVar;
        this.f17796e = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult) {
        if (this.f17797f.zzx != null) {
            this.f17797f.zzx.a(connectionResult);
        }
        this.f17797f.onConnectionFailed(connectionResult);
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        String str;
        try {
            IBinder iBinder = this.f17796e;
            m.a(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f17797f.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = this.f17797f.getServiceDescriptor();
                StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(serviceDescriptor);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                str = sb.toString();
                Log.w("GmsClient", str);
                return false;
            }
            IInterface createServiceInterface = this.f17797f.createServiceInterface(this.f17796e);
            if (createServiceInterface == null || (!d.zzn(this.f17797f, 2, 4, createServiceInterface) && !d.zzn(this.f17797f, 3, 4, createServiceInterface))) {
                return false;
            }
            this.f17797f.zzB = null;
            Bundle connectionHint = this.f17797f.getConnectionHint();
            d dVar = this.f17797f;
            if (dVar.zzw == null) {
                return true;
            }
            dVar.zzw.a(connectionHint);
            return true;
        } catch (RemoteException unused) {
            str = "service probably died";
        }
    }
}
