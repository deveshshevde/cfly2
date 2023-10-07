package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import gj.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f18167a;

    public static a a(CameraPosition cameraPosition) {
        try {
            return new a(a().a(cameraPosition));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static a a(LatLng latLng, float f2) {
        try {
            return new a(a().a(latLng, f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static a a(LatLngBounds latLngBounds, int i2, int i3, int i4) {
        try {
            return new a(a().a(latLngBounds, i2, i3, i4));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    private static a a() {
        return (a) m.a(f18167a, (Object) "CameraUpdateFactory is not initialized");
    }

    public static void a(a aVar) {
        f18167a = (a) m.a(aVar);
    }
}
