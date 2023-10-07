package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class ag extends zaa implements IInterface {
    ag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final b a(b bVar, zax zax) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, bVar);
        zac.zac(zaa, zax);
        Parcel zab = zab(2, zaa);
        b a2 = b.a.a(zab.readStrongBinder());
        zab.recycle();
        return a2;
    }
}
