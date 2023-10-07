package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzbx {
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private long zzd;
    private final Map<String, String> zze;

    public zzbx(long j2, String str, String str2, boolean z2, long j3, Map<String, String> map) {
        m.a(str);
        m.a(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z2;
        this.zzd = j3;
        this.zze = map != null ? new HashMap<>(map) : Collections.emptyMap();
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final Map<String, String> zzd() {
        return this.zze;
    }

    public final void zze(long j2) {
        this.zzd = j2;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
