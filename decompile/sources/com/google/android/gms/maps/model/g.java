package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zzac;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final zzac f18317a;

    public g(zzac zzac) {
        this.f18317a = (zzac) m.a(zzac);
    }

    public final void a() {
        try {
            this.f18317a.clearTileCache();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(float f2) {
        try {
            this.f18317a.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        try {
            return this.f18317a.zza(((g) obj).f18317a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f18317a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
