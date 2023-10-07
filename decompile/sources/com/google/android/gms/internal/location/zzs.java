package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;

final class zzs extends zzaa {
    private final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzn zzn, d dVar, boolean z2) {
        super(dVar);
        this.zza = z2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza);
        setResult(Status.f17374a);
    }
}
