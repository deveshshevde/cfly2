package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzd;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.m;
import java.util.HashMap;
import java.util.Map;

public class Product {
    Map<String, String> zza = new HashMap();

    public Product setBrand(String str) {
        zzb("br", str);
        return this;
    }

    public Product setCategory(String str) {
        zzb("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        zzb("cc", str);
        return this;
    }

    public Product setCustomDimension(int i2, String str) {
        zzb(zzd.zzc(i2), str);
        return this;
    }

    public Product setCustomMetric(int i2, int i3) {
        zzb(zzd.zzf(i2), Integer.toString(i3));
        return this;
    }

    public Product setId(String str) {
        zzb("id", str);
        return this;
    }

    public Product setName(String str) {
        zzb("nm", str);
        return this;
    }

    public Product setPosition(int i2) {
        zzb("ps", Integer.toString(i2));
        return this;
    }

    public Product setPrice(double d2) {
        zzb("pr", Double.toString(d2));
        return this;
    }

    public Product setQuantity(int i2) {
        zzb("qt", Integer.toString(i2));
        return this;
    }

    public Product setVariant(String str) {
        zzb("va", str);
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
