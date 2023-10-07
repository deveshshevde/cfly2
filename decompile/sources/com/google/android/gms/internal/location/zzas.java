package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.f;
import com.google.android.gms.location.p;

final class zzas extends p {
    private final j<f> zza;

    zzas(j<f> jVar) {
        this.zza = jVar;
    }

    public final synchronized void zza() {
        this.zza.b();
    }

    public final void zza(LocationAvailability locationAvailability) {
        this.zza.a(new zzau(this, locationAvailability));
    }

    public final void zza(LocationResult locationResult) {
        this.zza.a(new zzar(this, locationResult));
    }
}
