package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzai extends zzuz<zzai, zzah> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzai zza;
    private int zze;
    /* access modifiers changed from: private */
    public zzvh<zzag> zzf = zzag();
    private zzaa zzg;
    private String zzh = "";
    private byte zzi = 2;

    static {
        zzai zzai = new zzai();
        zza = zzai;
        zzuz.zzak(zzai.class, zzai);
    }

    private zzai() {
    }

    public static zzah zzd() {
        return (zzah) zza.zzY();
    }

    public static zzai zzf() {
        return zza;
    }

    public static zzai zzg(byte[] bArr, zzuj zzuj) throws zzvk {
        return (zzai) zzuz.zzad(zza, bArr, zzuj);
    }

    static /* synthetic */ void zzk(zzai zzai, zzaa zzaa) {
        zzaa.getClass();
        zzai.zzg = zzaa;
        zzai.zze |= 1;
    }

    static /* synthetic */ void zzl(zzai zzai, String str) {
        str.getClass();
        zzai.zze |= 2;
        zzai.zzh = str;
    }

    public final int zza() {
        return this.zzf.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zze", "zzf", zzag.class, "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzai();
        } else {
            if (i3 == 4) {
                return new zzah((zzn) null);
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

    public final zzaa zzc() {
        zzaa zzaa = this.zzg;
        return zzaa == null ? zzaa.zzl() : zzaa;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final List<zzag> zzi() {
        return this.zzf;
    }

    public final boolean zzm() {
        return (this.zze & 1) != 0;
    }
}
