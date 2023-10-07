package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class bo extends zzb implements bp {
    public bo() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static bp a(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof bp ? (bp) queryLocalInterface : new bn(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            b b2 = b();
            parcel2.writeNoException();
            zzc.zze(parcel2, b2);
        } else if (i2 != 2) {
            return false;
        } else {
            int a2 = a();
            parcel2.writeNoException();
            parcel2.writeInt(a2);
        }
        return true;
    }
}
