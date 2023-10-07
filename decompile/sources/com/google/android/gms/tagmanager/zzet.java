package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzro;
import com.google.android.gms.internal.gtm.zzrw;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzet {
    private final Set<zzrw> zza = new HashSet();
    private final Map<zzrw, List<zzro>> zzb = new HashMap();
    private final Map<zzrw, List<zzro>> zzc = new HashMap();
    private final Map<zzrw, List<String>> zzd = new HashMap();
    private final Map<zzrw, List<String>> zze = new HashMap();
    private zzro zzf;

    public final zzro zza() {
        return this.zzf;
    }

    public final Map<zzrw, List<String>> zzb() {
        return this.zzd;
    }

    public final Map<zzrw, List<zzro>> zzc() {
        return this.zzb;
    }

    public final Map<zzrw, List<String>> zzd() {
        return this.zze;
    }

    public final Map<zzrw, List<zzro>> zze() {
        return this.zzc;
    }

    public final Set<zzrw> zzf() {
        return this.zza;
    }
}
