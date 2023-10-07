package com.google.android.gms.internal.gtm;

public final class zzk extends zzuz<zzk, zzj> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzk zza;
    private int zze;
    private zzvh<zzg> zzf = zzag();
    private zzvh<zzg> zzg = zzag();
    private zzvh<zzg> zzh = zzag();
    private zzvh<zzg> zzi = zzag();
    private zzvh<zzg> zzj = zzag();
    private zzvh<zzg> zzk = zzag();
    private zzak zzl;
    private byte zzm = 2;

    static {
        zzk zzk2 = new zzk();
        zza = zzk2;
        zzuz.zzak(zzk.class, zzk2);
    }

    private zzk() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzm);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0006\u0007\u0001Л\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0000", new Object[]{"zze", "zzf", zzg.class, "zzg", zzg.class, "zzh", zzg.class, "zzi", zzg.class, "zzj", zzg.class, "zzk", zzg.class, "zzl"});
        } else if (i3 == 3) {
            return new zzk();
        } else {
            if (i3 == 4) {
                return new zzj((zzc) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzm = b2;
            return null;
        }
    }
}
