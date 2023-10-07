package com.google.android.gms.tagmanager;

final class zzff extends zzey {
    private static final Object zza = new Object();
    private static zzff zzb;
    /* access modifiers changed from: private */
    public zzcd zzd;
    private boolean zze = true;
    private boolean zzf = false;
    private boolean zzg = true;
    private boolean zzj = false;
    private volatile zzcc zzk;
    private final zzez zzl = new zzez(this);

    private zzff() {
    }

    public static zzff zzg() {
        if (zzb == null) {
            zzb = new zzff();
        }
        return zzb;
    }

    public final synchronized void zza() {
        if (!this.zzf) {
            zzdh.zzb.zzd("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zze = true;
            return;
        }
        this.zzk.zze(new zzfa(this));
    }
}
