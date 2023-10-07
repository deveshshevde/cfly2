package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.location.LocationSettingsResult;

final class zzaz extends zzaq {
    private d.b<LocationSettingsResult> zza;

    public zzaz(d.b<LocationSettingsResult> bVar) {
        m.a(bVar != null, (Object) "listener can't be null.");
        this.zza = bVar;
    }

    public final void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.zza.setResult(locationSettingsResult);
        this.zza = null;
    }
}
