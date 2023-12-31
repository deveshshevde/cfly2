package com.google.android.gms.internal.gtm;

final class zzwc implements zzwy {
    private static final zzwi zza = new zzwa();
    private final zzwi zzb;

    public zzwc() {
        zzwi zzwi;
        zzwi[] zzwiArr = new zzwi[2];
        zzwiArr[0] = zzus.zza();
        try {
            zzwi = (zzwi) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzwi = zza;
        }
        zzwiArr[1] = zzwi;
        zzwb zzwb = new zzwb(zzwiArr);
        zzvi.zzf(zzwb, "messageInfoFactory");
        this.zzb = zzwb;
    }

    private static boolean zzb(zzwh zzwh) {
        return zzwh.zzc() == 1;
    }

    public final <T> zzwx<T> zza(Class<T> cls) {
        zzwf zzwf;
        zzuk<?> zzuk;
        zzxo<?, ?> zzxo;
        zzvy zzvy;
        zzwq zzwq;
        zzuk<?> zzuk2;
        zzxo<?, ?> zzz;
        zzuk<?> zza2;
        zzwz.zzG(cls);
        zzwh zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzuz.class.isAssignableFrom(cls)) {
                zzz = zzwz.zzB();
                zza2 = zzum.zzb();
            } else {
                zzz = zzwz.zzz();
                zza2 = zzum.zza();
            }
            return zzwo.zzc(zzz, zza2, zzb2.zza());
        }
        if (zzuz.class.isAssignableFrom(cls)) {
            boolean zzb3 = zzb(zzb2);
            zzwq = zzwr.zzb();
            zzvy = zzvy.zze();
            zzxo = zzwz.zzB();
            zzuk = zzb3 ? zzum.zzb() : null;
            zzwf = zzwg.zzb();
        } else {
            boolean zzb4 = zzb(zzb2);
            zzwq = zzwr.zza();
            zzvy = zzvy.zzd();
            if (zzb4) {
                zzxo = zzwz.zzz();
                zzuk2 = zzum.zza();
            } else {
                zzxo = zzwz.zzA();
                zzuk2 = null;
            }
            zzwf = zzwg.zza();
        }
        return zzwn.zzl(cls, zzb2, zzwq, zzvy, zzxo, zzuk, zzwf);
    }
}
