package com.google.android.gms.internal.gtm;

public final class zzyo extends zzuz<zzyo, zzyn> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzyo zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private byte zzh = 2;

    static {
        zzyo zzyo = new zzyo();
        zza = zzyo;
        zzuz.zzak(zzyo.class, zzyo);
    }

    private zzyo() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzyo();
        } else {
            if (i3 == 4) {
                return new zzyn((zzyj) null);
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
