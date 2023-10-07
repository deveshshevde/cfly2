package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzw extends zzuz<zzw, zzv> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzw zza;
    private zzvh<zzak> zze = zzag();
    private zzvh<zzak> zzf = zzag();
    private zzvh<zzu> zzg = zzag();
    private byte zzh = 2;

    static {
        zzw zzw = new zzw();
        zza = zzw;
        zzuz.zzak(zzw.class, zzw);
    }

    private zzw() {
    }

    public static zzw zzc() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0002\u0001Л\u0002Л\u0003\u001b", new Object[]{"zze", zzak.class, "zzf", zzak.class, "zzg", zzu.class});
        } else if (i3 == 3) {
            return new zzw();
        } else {
            if (i3 == 4) {
                return new zzv((zzn) null);
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

    public final List<zzu> zzd() {
        return this.zzg;
    }

    public final List<zzak> zze() {
        return this.zzf;
    }

    public final List<zzak> zzf() {
        return this.zze;
    }
}
