package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zzz;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final zzz f18316a;

    public f(zzz zzz) {
        this.f18316a = (zzz) m.a(zzz);
    }

    public final List<LatLng> a() {
        try {
            return this.f18316a.getPoints();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(List<LatLng> list) {
        try {
            this.f18316a.setPoints(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        try {
            return this.f18316a.zzb(((f) obj).f18316a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f18316a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
