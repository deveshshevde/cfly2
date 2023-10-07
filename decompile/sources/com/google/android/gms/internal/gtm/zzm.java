package com.google.android.gms.internal.gtm;

public final class zzm extends zzuz<zzm, zzl> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzm zza;
    private zzvh<zzk> zze = zzag();
    private zzvh<zzg> zzf = zzag();
    private byte zzg = 2;

    static {
        zzm zzm = new zzm();
        zza = zzm;
        zzuz.zzak(zzm.class, zzm);
    }

    private zzm() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001Л\u0002Л", new Object[]{"zze", zzk.class, "zzf", zzg.class});
        } else if (i3 == 3) {
            return new zzm();
        } else {
            if (i3 == 4) {
                return new zzl((zzc) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzg = b2;
            return null;
        }
    }
}
