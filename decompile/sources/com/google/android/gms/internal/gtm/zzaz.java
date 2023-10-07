package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzaz extends zzj<zzaz> {
    private final Map<String, Object> zza = new HashMap();

    public final String toString() {
        return zza(this.zza);
    }

    public final /* synthetic */ void zzc(zzj zzj) {
        zzaz zzaz = (zzaz) zzj;
        m.a(zzaz);
        zzaz.zza.putAll(this.zza);
    }

    public final Map<String, Object> zzd() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zze(String str, String str2) {
        m.a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        m.a(str, (Object) "Name can not be empty or \"&\"");
        this.zza.put(str, str2);
    }
}
