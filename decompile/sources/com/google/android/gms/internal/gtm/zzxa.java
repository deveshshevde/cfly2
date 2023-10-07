package com.google.android.gms.internal.gtm;

import java.util.Map;

final class zzxa extends zzxk {
    zzxa(int i2) {
        super(i2, (zzxj) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i2 = 0; i2 < zzb(); i2++) {
                ((zzun) zzg(i2).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzun) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
