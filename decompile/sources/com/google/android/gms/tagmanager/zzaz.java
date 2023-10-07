package com.google.android.gms.tagmanager;

import java.util.List;

final class zzaz implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzbe zzc;

    zzaz(zzbe zzbe, List list, long j2) {
        this.zzc = zzbe;
        this.zza = list;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zzl(this.zza, this.zzb);
    }
}
