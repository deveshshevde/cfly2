package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.GeofencingRequest;

final class zzad extends zzaf {
    private final /* synthetic */ GeofencingRequest zza;
    private final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzad(zzae zzae, d dVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(dVar);
        this.zza = geofencingRequest;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, this.zzb, (d.b<Status>) this);
    }
}
