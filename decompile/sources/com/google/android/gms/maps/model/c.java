package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zzh;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final zzh f18313a;

    public c(zzh zzh) {
        this.f18313a = (zzh) m.a(zzh);
    }

    public final void a(LatLng latLng) {
        try {
            this.f18313a.setCenter(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        try {
            return this.f18313a.zzb(((c) obj).f18313a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f18313a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
