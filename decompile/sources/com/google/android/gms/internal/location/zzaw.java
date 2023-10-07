package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.g;
import com.google.android.gms.location.u;

final class zzaw extends u {
    private final j<g> zza;

    zzaw(j<g> jVar) {
        this.zza = jVar;
    }

    public final synchronized void zza() {
        this.zza.b();
    }

    public final synchronized void zza(Location location) {
        this.zza.a(new zzav(this, location));
    }
}
