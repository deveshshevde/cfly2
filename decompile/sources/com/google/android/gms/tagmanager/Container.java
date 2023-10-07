package com.google.android.gms.tagmanager;

public class Container {
    private final String zzb;
    private zzeu zzd;

    private final synchronized zzeu zzf() {
        return this.zzd;
    }

    public String getContainerId() {
        return this.zzb;
    }

    public final void zzd(String str) {
        zzeu zzf = zzf();
        if (zzf == null) {
            zzdh.zza("evaluateTags called for closed container.");
        } else {
            zzf.zzc(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        this.zzd = null;
    }
}
