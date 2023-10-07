package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.d;

final class zzfo {
    private final d zza;
    private long zzb;

    public zzfo(d dVar) {
        m.a(dVar);
        this.zza = dVar;
    }

    public zzfo(d dVar, long j2) {
        m.a(dVar);
        this.zza = dVar;
        this.zzb = j2;
    }

    public final void zza() {
        this.zzb = 0;
    }

    public final void zzb() {
        this.zzb = this.zza.b();
    }

    public final boolean zzc(long j2) {
        return this.zzb == 0 || this.zza.b() - this.zzb > j2;
    }
}
