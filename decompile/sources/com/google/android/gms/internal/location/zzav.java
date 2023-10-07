package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.g;

final class zzav implements j.b<g> {
    private final /* synthetic */ Location zza;

    zzav(zzaw zzaw, Location location) {
        this.zza = location;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((g) obj).a(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
