package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;

final class zzg extends zzi {
    private final /* synthetic */ long zza;
    private final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(zze zze, d dVar, long j2, PendingIntent pendingIntent) {
        super(dVar);
        this.zza = j2;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, this.zzb);
        setResult(Status.f17374a);
    }
}
