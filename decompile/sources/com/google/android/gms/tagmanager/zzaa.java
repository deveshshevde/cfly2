package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

final class zzaa implements ContainerHolder {
    private Container zzb;
    private Container zzc;
    private final Status zzd;
    private zzz zze;
    private zzy zzf;
    private boolean zzg;
    private TagManager zzh;

    public final Status getStatus() {
        return this.zzd;
    }

    public final synchronized void refresh() {
        if (this.zzg) {
            zzdh.zza("Refreshing a released ContainerHolder.");
        } else {
            this.zzf.zzb();
        }
    }

    public final synchronized void release() {
        if (this.zzg) {
            zzdh.zza("Releasing a released ContainerHolder.");
            return;
        }
        this.zzg = true;
        this.zzh.zzc(this);
        this.zzb.zze();
        this.zzb = null;
        this.zzc = null;
        this.zzf = null;
        this.zze = null;
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        if (!this.zzg) {
            return this.zzb.getContainerId();
        }
        zzdh.zza("getContainerId called on a released ContainerHolder.");
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        if (!this.zzg) {
            return this.zzf.zza();
        }
        zzdh.zza("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public final synchronized void zzd(String str) {
        if (!this.zzg) {
            this.zzb.zzd(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str) {
        if (this.zzg) {
            zzdh.zza("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzf.zzc(str);
        }
    }
}
