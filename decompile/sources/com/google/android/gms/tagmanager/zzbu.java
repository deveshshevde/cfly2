package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzak;
import java.util.Map;
import java.util.Set;

abstract class zzbu {
    private final Set<String> zzs;

    public abstract zzak zza(Map<String, zzak> map);

    public abstract boolean zzb();

    public final Set<String> zzf() {
        return this.zzs;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(Set<String> set) {
        return set.containsAll(this.zzs);
    }
}
