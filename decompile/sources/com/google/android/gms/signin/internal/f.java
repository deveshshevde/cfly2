package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class f extends zaa implements IInterface {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(int i2) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i2);
        zac(7, zaa);
    }

    public final void a(h hVar, int i2, boolean z2) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, hVar);
        zaa.writeInt(i2);
        zac.zab(zaa, z2);
        zac(9, zaa);
    }

    public final void a(zai zai, e eVar) throws RemoteException {
        Parcel zaa = zaa();
        zac.zac(zaa, zai);
        zac.zad(zaa, eVar);
        zac(12, zaa);
    }
}
