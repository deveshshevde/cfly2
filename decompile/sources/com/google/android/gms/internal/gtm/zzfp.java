package com.google.android.gms.internal.gtm;

final class zzfp extends zzbr implements zzcr<zzfr> {
    private final zzfr zza = new zzfr();

    public zzfp(zzbv zzbv) {
        super(zzbv);
    }

    public final /* bridge */ /* synthetic */ zzcq zza() {
        return this.zza;
    }

    public final void zzb(String str, String str2) {
        this.zza.zzg.put(str, str2);
    }

    public final void zzc(String str, boolean z2) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zza.zzd = z2;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zza.zze = z2;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.zza.zzf = z2 ? 1 : 0;
        } else {
            zzS("bool configuration name not recognized", str);
        }
    }

    public final void zzd(String str, int i2) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zza.zzc = i2;
        } else {
            zzS("int configuration name not recognized", str);
        }
    }

    public final void zze(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zza.zza = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zza.zzb = Double.parseDouble(str2);
            } catch (NumberFormatException e2) {
                zzT("Error parsing ga_sampleFrequency value", str2, e2);
            }
        } else {
            zzS("string configuration name not recognized", str);
        }
    }
}
