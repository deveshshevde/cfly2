package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.m;
import java.util.HashMap;
import java.util.Map;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zza = new HashMap();

    public Promotion setCreative(String str) {
        zzb("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        zzb("id", str);
        return this;
    }

    public Promotion setName(String str) {
        zzb("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        zzb("ps", str);
        return this;
    }

    public String toString() {
        return zzj.zzb(this.zza);
    }

    public final Map<String, String> zza(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zza.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) next.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) next.getValue());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2) {
        m.a(str, (Object) "Name should be non-null");
        this.zza.put(str, str2);
    }
}
