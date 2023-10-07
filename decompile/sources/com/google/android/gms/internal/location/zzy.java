package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.g;

final class zzy extends zzaa {
    private final /* synthetic */ g zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzy(zzn zzn, d dVar, g gVar) {
        super(dVar);
        this.zza = gVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza((j.a<g>) k.a(this.zza, g.class.getSimpleName()), (zzai) new zzz(this));
    }
}
