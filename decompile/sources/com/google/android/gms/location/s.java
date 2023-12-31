package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzd;

public final class s extends zzb implements q {
    s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void zza(LocationAvailability locationAvailability) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, (Parcelable) locationAvailability);
        zzc(2, b_);
    }

    public final void zza(LocationResult locationResult) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, (Parcelable) locationResult);
        zzc(1, b_);
    }
}
