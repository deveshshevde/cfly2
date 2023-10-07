package com.google.android.gms.internal.gtm;

final class zzfl implements zzcz {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzfn zzb;

    zzfl(zzfn zzfn, Runnable runnable) {
        this.zzb = zzfn;
        this.zza = runnable;
    }

    public final void zza(Throwable th) {
        this.zzb.zzb.post(this.zza);
    }
}
