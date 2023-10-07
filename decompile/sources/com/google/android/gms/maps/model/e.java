package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zzw;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final zzw f18315a;

    public e(zzw zzw) {
        this.f18315a = (zzw) m.a(zzw);
    }

    public final void a() {
        try {
            this.f18315a.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(List<LatLng> list) {
        try {
            this.f18315a.setPoints(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        try {
            return this.f18315a.zzb(((e) obj).f18315a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f18315a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
