package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import java.util.HashMap;
import java.util.Map;

public final class zzrm {
    final Map<String, Object> zza = new HashMap();
    private final Context zzb;
    private final zzsb zzc;
    private final d zzd;
    private final Map<String, Object> zze;

    public zzrm(Context context) {
        HashMap hashMap = new HashMap();
        zzsb zzsb = new zzsb(context);
        d c2 = f.c();
        this.zzb = context;
        this.zzd = c2;
        this.zzc = zzsb;
        this.zze = hashMap;
    }
}
