package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzd;

public abstract class p extends zza implements q {
    public p() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static q zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof q ? (q) queryLocalInterface : new s(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza((LocationResult) zzd.zza(parcel, LocationResult.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            zza((LocationAvailability) zzd.zza(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
