package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.f;

final class zzar implements j.b<f> {
    private final /* synthetic */ LocationResult zza;

    zzar(zzas zzas, LocationResult locationResult) {
        this.zza = locationResult;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((f) obj).a(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
