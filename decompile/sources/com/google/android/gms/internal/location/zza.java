package com.google.android.gms.internal.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza extends Binder implements IInterface {
    private static zzc zza;

    protected zza(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        boolean z2;
        if (i2 > 16777215) {
            z2 = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return zza(i2, parcel, parcel2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        return false;
    }
}
