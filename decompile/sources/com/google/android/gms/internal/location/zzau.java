package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.f;

final class zzau implements j.b<f> {
    private final /* synthetic */ LocationAvailability zza;

    zzau(zzas zzas, LocationAvailability locationAvailability) {
        this.zza = locationAvailability;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((f) obj).a(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
