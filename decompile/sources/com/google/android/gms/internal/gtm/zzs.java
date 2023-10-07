package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzs extends zzuz<zzs, zzr> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzs zza;
    private int zze;
    private zzve zzf = zzaf();
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private byte zzk = 2;

    static {
        zzs zzs = new zzs();
        zza = zzs;
        zzuz.zzak(zzs.class, zzs);
    }

    private zzs() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001ဇ\u0003\u0002ᔄ\u0000\u0003\u0016\u0004င\u0001\u0006ဇ\u0002", new Object[]{"zze", "zzj", "zzg", "zzf", "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzs();
        } else {
            if (i3 == 4) {
                return new zzr((zzn) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzk = b2;
            return null;
        }
    }

    public final List<Integer> zzc() {
        return this.zzf;
    }
}
