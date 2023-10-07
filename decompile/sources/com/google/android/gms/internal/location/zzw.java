package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.f;

final class zzw extends zzaa {
    private final /* synthetic */ LocationRequest zza;
    private final /* synthetic */ f zzb;
    private final /* synthetic */ Looper zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzw(zzn zzn, d dVar, LocationRequest locationRequest, f fVar, Looper looper) {
        super(dVar);
        this.zza = locationRequest;
        this.zzb = fVar;
        this.zzc = looper;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(zzbc.zza(this.zza), (j<f>) k.a(this.zzb, zzbj.zza(this.zzc), f.class.getSimpleName()), (zzai) new zzz(this));
    }
}
