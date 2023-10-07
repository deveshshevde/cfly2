package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zztj {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zztk zzc;

    /* synthetic */ zztj(zzti zzti) {
    }

    public static int zzs(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long zzt(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public abstract int zza();

    public abstract int zzb(int i2) throws zzvk;

    public abstract int zzc() throws IOException;

    public abstract zztd zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract void zzg(int i2) throws zzvk;

    public abstract void zzh(int i2);

    public abstract boolean zzi() throws IOException;

    public abstract boolean zzj() throws IOException;

    public abstract boolean zzk(int i2) throws IOException;
}
