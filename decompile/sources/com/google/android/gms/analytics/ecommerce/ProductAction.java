package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.m;
import java.util.HashMap;
import java.util.Map;

public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    Map<String, String> zza = new HashMap();

    public ProductAction(String str) {
        zzb("&pa", str);
    }

    public ProductAction setCheckoutOptions(String str) {
        zzb("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i2) {
        zzb("&cos", Integer.toString(i2));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        zzb("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        zzb("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        zzb("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        zzb("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        zzb("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d2) {
        zzb("&tr", Double.toString(d2));
        return this;
    }

    public ProductAction setTransactionShipping(double d2) {
        zzb("&ts", Double.toString(d2));
        return this;
    }

    public ProductAction setTransactionTax(double d2) {
        zzb("&tt", Double.toString(d2));
        return this;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zza.entrySet()) {
            hashMap.put(((String) next.getKey()).startsWith("&") ? ((String) next.getKey()).substring(1) : (String) next.getKey(), (String) next.getValue());
        }
        return zzj.zzb(hashMap);
    }

    public final Map<String, String> zza() {
        return new HashMap(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2) {
        m.a(str, (Object) "Name should be non-null");
        this.zza.put(str, str2);
    }
}
