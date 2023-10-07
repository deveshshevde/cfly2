package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.gtm.zzfa;
import com.google.android.gms.internal.gtm.zzfs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HitBuilders {

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }

        public EventBuilder setValue(long j2) {
            set("&ev", Long.toString(j2));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z2) {
            set("&exf", zzfs.zzc(z2));
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }
    }

    protected static class HitBuilder<T extends HitBuilder> {
        ProductAction zza;
        Map<String, List<Product>> zzb = new HashMap();
        List<Promotion> zzc = new ArrayList();
        List<Product> zzd = new ArrayList();
        private Map<String, String> zze = new HashMap();

        protected HitBuilder() {
        }

        private final T zza(String str, String str2) {
            if (str2 != null) {
                this.zze.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzfa.zze("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, new ArrayList());
            }
            this.zzb.get(str).add(product);
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzfa.zze("product should be non-null");
                return this;
            }
            this.zzd.add(product);
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzfa.zze("promotion should be non-null");
                return this;
            }
            this.zzc.add(promotion);
            return this;
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap(this.zze);
            ProductAction productAction = this.zza;
            if (productAction != null) {
                hashMap.putAll(productAction.zza());
            }
            int i2 = 1;
            for (Promotion zza2 : this.zzc) {
                hashMap.putAll(zza2.zza(zzd.zzl(i2)));
                i2++;
            }
            int i3 = 1;
            for (Product zza3 : this.zzd) {
                hashMap.putAll(zza3.zza(zzd.zzj(i3)));
                i3++;
            }
            int i4 = 1;
            for (Map.Entry next : this.zzb.entrySet()) {
                String zzg = zzd.zzg(i4);
                int i5 = 1;
                for (Product product : (List) next.getValue()) {
                    String valueOf = String.valueOf(zzg);
                    String valueOf2 = String.valueOf(zzd.zzi(i5));
                    hashMap.putAll(product.zza(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i5++;
                }
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    hashMap.put(String.valueOf(zzg).concat("nm"), (String) next.getKey());
                }
                i4++;
            }
            return hashMap;
        }

        /* access modifiers changed from: protected */
        public String get(String str) {
            return this.zze.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zze.put(str, str2);
            } else {
                zzfa.zze("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.zze.putAll(new HashMap(map));
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            if (r15.contains("=") == false) goto L_0x0092;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T setCampaignParamsFromUrl(java.lang.String r15) {
            /*
                r14 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r15)
                r1 = 0
                if (r0 == 0) goto L_0x0009
                goto L_0x0092
            L_0x0009:
                java.lang.String r0 = "?"
                boolean r0 = r15.contains(r0)
                if (r0 == 0) goto L_0x001d
                java.lang.String r0 = "[\\?]"
                java.lang.String[] r0 = r15.split(r0)
                int r2 = r0.length
                r3 = 1
                if (r2 <= r3) goto L_0x001d
                r15 = r0[r3]
            L_0x001d:
                java.lang.String r0 = "%3D"
                boolean r0 = r15.contains(r0)
                java.lang.String r2 = "="
                if (r0 == 0) goto L_0x0030
                java.lang.String r0 = "UTF-8"
                java.lang.String r15 = java.net.URLDecoder.decode(r15, r0)     // Catch:{ UnsupportedEncodingException -> 0x002e }
                goto L_0x0037
            L_0x002e:
                goto L_0x0092
            L_0x0030:
                boolean r0 = r15.contains(r2)
                if (r0 != 0) goto L_0x0037
                goto L_0x0092
            L_0x0037:
                java.util.Map r15 = com.google.android.gms.internal.gtm.zzfs.zzf(r15)
                java.lang.String r3 = "dclid"
                java.lang.String r4 = "utm_source"
                java.lang.String r5 = "gclid"
                java.lang.String r6 = "aclid"
                java.lang.String r7 = "utm_campaign"
                java.lang.String r8 = "utm_medium"
                java.lang.String r9 = "utm_term"
                java.lang.String r10 = "utm_content"
                java.lang.String r11 = "utm_id"
                java.lang.String r12 = "anid"
                java.lang.String r13 = "gmob_t"
                java.lang.String[] r0 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r3 = 0
            L_0x005b:
                r4 = 11
                if (r3 >= r4) goto L_0x008e
                r4 = r0[r3]
                java.lang.Object r4 = r15.get(r4)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x008b
                int r4 = r1.length()
                if (r4 <= 0) goto L_0x0078
                java.lang.String r4 = "&"
                r1.append(r4)
            L_0x0078:
                r4 = r0[r3]
                r1.append(r4)
                r1.append(r2)
                r4 = r0[r3]
                java.lang.Object r4 = r15.get(r4)
                java.lang.String r4 = (java.lang.String) r4
                r1.append(r4)
            L_0x008b:
                int r3 = r3 + 1
                goto L_0x005b
            L_0x008e:
                java.lang.String r1 = r1.toString()
            L_0x0092:
                boolean r15 = android.text.TextUtils.isEmpty(r1)
                if (r15 == 0) goto L_0x0099
                return r14
            L_0x0099:
                java.util.Map r15 = com.google.android.gms.internal.gtm.zzfs.zzf(r1)
                java.lang.String r0 = "utm_content"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&cc"
                r14.zza(r1, r0)
                java.lang.String r0 = "utm_medium"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&cm"
                r14.zza(r1, r0)
                java.lang.String r0 = "utm_campaign"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&cn"
                r14.zza(r1, r0)
                java.lang.String r0 = "utm_source"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&cs"
                r14.zza(r1, r0)
                java.lang.String r0 = "utm_term"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&ck"
                r14.zza(r1, r0)
                java.lang.String r0 = "utm_id"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&ci"
                r14.zza(r1, r0)
                java.lang.String r0 = "anid"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&anid"
                r14.zza(r1, r0)
                java.lang.String r0 = "gclid"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&gclid"
                r14.zza(r1, r0)
                java.lang.String r0 = "dclid"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&dclid"
                r14.zza(r1, r0)
                java.lang.String r0 = "aclid"
                java.lang.Object r0 = r15.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "&aclid"
                r14.zza(r1, r0)
                java.lang.String r0 = "gmob_t"
                java.lang.Object r15 = r15.get(r0)
                java.lang.String r15 = (java.lang.String) r15
                java.lang.String r0 = "&gmob_t"
                r14.zza(r0, r15)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.HitBuilders.HitBuilder.setCampaignParamsFromUrl(java.lang.String):com.google.android.gms.analytics.HitBuilders$HitBuilder");
        }

        public T setCustomDimension(int i2, String str) {
            set(zzd.zza(i2), str);
            return this;
        }

        public T setCustomMetric(int i2, float f2) {
            set(zzd.zzd(i2), Float.toString(f2));
            return this;
        }

        /* access modifiers changed from: protected */
        public T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z2) {
            set("&ni", zzfs.zzc(z2));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zza = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zze.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public ItemBuilder setPrice(double d2) {
            set("&ip", Double.toString(d2));
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }

        public ItemBuilder setQuantity(long j2) {
            set("&iq", Long.toString(j2));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", "social");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j2) {
            this();
            setVariable(str2);
            setValue(j2);
            setCategory(str);
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }

        public TimingBuilder setValue(long j2) {
            set("&utt", Long.toString(j2));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public final /* bridge */ /* synthetic */ HitBuilder addImpression(Product product, String str) {
            super.addImpression(product, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addProduct(Product product) {
            super.addProduct(product);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder addPromotion(Promotion promotion) {
            super.addPromotion(promotion);
            return this;
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCampaignParamsFromUrl(String str) {
            super.setCampaignParamsFromUrl(str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomDimension(int i2, String str) {
            super.setCustomDimension(i2, str);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setCustomMetric(int i2, float f2) {
            super.setCustomMetric(i2, f2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNewSession() {
            super.setNewSession();
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setNonInteraction(boolean z2) {
            super.setNonInteraction(z2);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setProductAction(ProductAction productAction) {
            super.setProductAction(productAction);
            return this;
        }

        public final /* bridge */ /* synthetic */ HitBuilder setPromotionAction(String str) {
            super.setPromotionAction(str);
            return this;
        }

        public TransactionBuilder setRevenue(double d2) {
            set("&tr", Double.toString(d2));
            return this;
        }

        public TransactionBuilder setShipping(double d2) {
            set("&ts", Double.toString(d2));
            return this;
        }

        public TransactionBuilder setTax(double d2) {
            set("&tt", Double.toString(d2));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
