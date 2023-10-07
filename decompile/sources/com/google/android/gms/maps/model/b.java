package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zze;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static zze f18312a;

    private static zze a() {
        return (zze) m.a(f18312a, (Object) "IBitmapDescriptorFactory is not initialized");
    }

    public static a a(int i2) {
        try {
            return new a(a().zza(i2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static a a(Bitmap bitmap) {
        try {
            return new a(a().zza(bitmap));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static void a(zze zze) {
        if (f18312a == null) {
            f18312a = (zze) m.a(zze);
        }
    }
}
