package com.google.android.gms.internal.gtm;

public final class zzyp extends zzuz<zzyp, zzym> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzyp zza;
    private zzvh<zzyo> zze = zzag();
    private byte zzf = 2;

    static {
        zzyp zzyp = new zzyp();
        zza = zzyp;
        zzuz.zzak(zzyp.class, zzyp);
    }

    private zzyp() {
    }

    public static zzyp zze() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzf);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zze", zzyo.class});
        } else if (i3 == 3) {
            return new zzyp();
        } else {
            if (i3 == 4) {
                return new zzym((zzyj) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzf = b2;
            return null;
        }
    }
}
