package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzrs {
    private final List<zzrw> zza;
    private final Map<String, List<zzro>> zzb;
    private final String zzc;

    /* synthetic */ zzrs(List list, Map map, String str, int i2, zzrr zzrr) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableMap(map);
        this.zzc = str;
    }

    public static zzru zza() {
        return new zzru((zzrt) null);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17 + String.valueOf(valueOf2).length());
        sb.append("Rules: ");
        sb.append(valueOf);
        sb.append("  Macros: ");
        sb.append(valueOf2);
        return sb.toString();
    }

    public final String zzb() {
        return this.zzc;
    }

    public final List<zzrw> zzc() {
        return this.zza;
    }

    public final Map<String, List<zzro>> zzd() {
        return this.zzb;
    }
}
