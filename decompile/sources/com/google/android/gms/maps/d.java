package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.b;
import gj.af;
import gj.ag;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f18170a = false;

    public static synchronized int a(Context context) {
        synchronized (d.class) {
            m.a(context, (Object) "Context is null");
            if (f18170a) {
                return 0;
            }
            try {
                ag a2 = af.a(context);
                try {
                    b.a(a2.a());
                    b.a(a2.b());
                    f18170a = true;
                    return 0;
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (GooglePlayServicesNotAvailableException e3) {
                return e3.f17362a;
            }
        }
    }
}
