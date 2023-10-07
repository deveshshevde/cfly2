package com.google.android.gms.internal.gtm;

import sun.misc.Unsafe;

final class zzxw extends zzxx {
    zzxw(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(zzk(obj, j2));
    }

    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(zzj(obj, j2));
    }

    public final void zzc(Object obj, long j2, boolean z2) {
        if (zzxy.zzb) {
            zzxy.zzD(obj, j2, r3 ? (byte) 1 : 0);
        } else {
            zzxy.zzE(obj, j2, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j2, byte b2) {
        if (zzxy.zzb) {
            zzxy.zzD(obj, j2, b2);
        } else {
            zzxy.zzE(obj, j2, b2);
        }
    }

    public final void zze(Object obj, long j2, double d2) {
        zzo(obj, j2, Double.doubleToLongBits(d2));
    }

    public final void zzf(Object obj, long j2, float f2) {
        zzn(obj, j2, Float.floatToIntBits(f2));
    }

    public final boolean zzg(Object obj, long j2) {
        return zzxy.zzb ? zzxy.zzt(obj, j2) : zzxy.zzu(obj, j2);
    }
}
