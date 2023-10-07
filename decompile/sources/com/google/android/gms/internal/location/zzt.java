package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.g;

final class zzt extends zzaa {
    private final /* synthetic */ LocationRequest zza;
    private final /* synthetic */ g zzb;
    private final /* synthetic */ Looper zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzn zzn, d dVar, LocationRequest locationRequest, g gVar, Looper looper) {
        super(dVar);
        this.zza = locationRequest;
        this.zzb = gVar;
        this.zzc = looper;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, (j<g>) k.a(this.zzb, zzbj.zza(this.zzc), g.class.getSimpleName()), (zzai) new zzz(this));
    }
}
