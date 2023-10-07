package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.zzbe;

final class zzag extends zzaf {
    private final /* synthetic */ zzbe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzae zzae, d dVar, zzbe zzbe) {
        super(dVar);
        this.zza = zzbe;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, (d.b<Status>) this);
    }
}
