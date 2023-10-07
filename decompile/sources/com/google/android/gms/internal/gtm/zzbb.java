package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzbb extends zzj<zzbb> {
    private final List<Product> zza = new ArrayList();
    private final List<Promotion> zzb = new ArrayList();
    private final Map<String, List<Product>> zzc = new HashMap();

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zza.isEmpty()) {
            hashMap.put("products", this.zza);
        }
        if (!this.zzb.isEmpty()) {
            hashMap.put("promotions", this.zzb);
        }
        if (!this.zzc.isEmpty()) {
            hashMap.put("impressions", this.zzc);
        }
        hashMap.put("productAction", (Object) null);
        return zza(hashMap);
    }

    public final /* synthetic */ void zzc(zzj zzj) {
        zzbb zzbb = (zzbb) zzj;
        zzbb.zza.addAll(this.zza);
        zzbb.zzb.addAll(this.zzb);
        for (Map.Entry next : this.zzc.entrySet()) {
            String str = (String) next.getKey();
            for (Product product : (List) next.getValue()) {
                if (product != null) {
                    String str2 = str == null ? "" : str;
                    if (!zzbb.zzc.containsKey(str2)) {
                        zzbb.zzc.put(str2, new ArrayList());
                    }
                    zzbb.zzc.get(str2).add(product);
                }
            }
        }
    }

    public final List<Product> zzd() {
        return Collections.unmodifiableList(this.zza);
    }

    public final List<Promotion> zze() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final Map<String, List<Product>> zzf() {
        return this.zzc;
    }
}
