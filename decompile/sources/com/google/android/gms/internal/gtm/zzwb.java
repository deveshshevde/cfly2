package com.google.android.gms.internal.gtm;

final class zzwb implements zzwi {
    private final zzwi[] zza;

    zzwb(zzwi... zzwiArr) {
        this.zza = zzwiArr;
    }

    public final zzwh zzb(Class<?> cls) {
        zzwi[] zzwiArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zzwi zzwi = zzwiArr[i2];
            if (zzwi.zzc(cls)) {
                return zzwi.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }

    public final boolean zzc(Class<?> cls) {
        zzwi[] zzwiArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzwiArr[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
