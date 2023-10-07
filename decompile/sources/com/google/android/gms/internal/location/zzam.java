package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzam extends zza implements zzaj {
    public zzam() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza(parcel.readInt(), parcel.createStringArray());
        } else if (i2 == 2) {
            zzb(parcel.readInt(), parcel.createStringArray());
        } else if (i2 != 3) {
            return false;
        } else {
            zza(parcel.readInt(), (PendingIntent) zzd.zza(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
