package com.google.android.gms.internal.gtm;

public final class zzag extends zzuz<zzag, zzaf> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzag zza;
    private int zze;
    private String zzf = "";
    private zzak zzg;
    private zzw zzh;
    private byte zzi = 2;

    static {
        zzag zzag = new zzag();
        zza = zzag;
        zzuz.zzak(zzag.class, zzag);
    }

    private zzag() {
    }

    public final zzw zza() {
        zzw zzw = this.zzh;
        return zzw == null ? zzw.zzc() : zzw;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzag();
        } else {
            if (i3 == 4) {
                return new zzaf((zzn) null);
            }
            if (i3 == 5) {
                return zza;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzi = b2;
            return null;
        }
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }
}
