package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.f;

final class zzp extends zzaa {
    private final /* synthetic */ f zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(zzn zzn, d dVar, f fVar) {
        super(dVar);
        this.zza = fVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zzb((j.a<f>) k.a(this.zza, f.class.getSimpleName()), (zzai) new zzz(this));
    }
}
