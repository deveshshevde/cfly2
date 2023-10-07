package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;

final class zzv extends zzaa {
    private final /* synthetic */ LocationRequest zza;
    private final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzn zzn, d dVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        super(dVar);
        this.zza = locationRequest;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, this.zzb, (zzai) new zzz(this));
    }
}
