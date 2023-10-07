package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.h;

final class zzbk extends h.a<LocationSettingsResult> {
    private final /* synthetic */ LocationSettingsRequest zza;
    private final /* synthetic */ String zzb = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzbh zzbh, d dVar, LocationSettingsRequest locationSettingsRequest, String str) {
        super(dVar);
        this.zza = locationSettingsRequest;
    }

    public final /* synthetic */ g createFailedResult(Status status) {
        return new LocationSettingsResult(status);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzay) bVar).zza(this.zza, (d.b<LocationSettingsResult>) this, (String) null);
    }
}
