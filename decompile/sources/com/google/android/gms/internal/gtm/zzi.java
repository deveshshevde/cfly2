package com.google.android.gms.internal.gtm;

public final class zzi extends zzuz<zzi, zzh> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzi zza;
    private int zze;
    private String zzf = "";
    private zzak zzg;
    private byte zzh = 2;

    static {
        zzi zzi = new zzi();
        zza = zzi;
        zzuz.zzak(zzi.class, zzi);
    }

    private zzi() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzi();
        } else {
            if (i3 == 4) {
                return new zzh((zzc) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzh = b2;
            return null;
        }
    }
}
