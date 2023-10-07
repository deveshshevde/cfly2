package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import gj.e;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final e f18171a;

    g(e eVar) {
        this.f18171a = eVar;
    }

    public final LatLng a(Point point) {
        try {
            return this.f18171a.a(d.a(point));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
