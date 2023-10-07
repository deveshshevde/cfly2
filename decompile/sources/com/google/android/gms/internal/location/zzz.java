package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;

final class zzz extends zzah {
    private final d.b<Status> zza;

    public zzz(d.b<Status> bVar) {
        this.zza = bVar;
    }

    public final void a_() {
    }

    public final void zza(zzac zzac) {
        this.zza.setResult(zzac.getStatus());
    }
}
