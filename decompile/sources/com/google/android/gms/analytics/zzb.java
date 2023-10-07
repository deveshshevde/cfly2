package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzbe;
import com.google.android.gms.internal.gtm.zzbr;
import com.google.android.gms.internal.gtm.zzbt;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzex;
import com.google.android.gms.internal.gtm.zzfs;
import fg.i;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public final class zzb extends zzbr implements zzt {
    private static DecimalFormat zza;
    private final zzbv zzb;
    private final String zzc;
    private final Uri zzd;

    public zzb(zzbv zzbv, String str) {
        super(zzbv);
        m.a(str);
        this.zzb = zzbv;
        this.zzc = str;
        this.zzd = zza(str);
    }

    static Uri zza(String str) {
        m.a(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzc(double d2) {
        if (zza == null) {
            zza = new DecimalFormat("0.######");
        }
        return zza.format(d2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x001e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> zzd(com.google.android.gms.analytics.zzh r12) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Class<com.google.android.gms.internal.gtm.zzaz> r1 = com.google.android.gms.internal.gtm.zzaz.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzaz r1 = (com.google.android.gms.internal.gtm.zzaz) r1
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0071
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0071
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            if (r6 != 0) goto L_0x0032
        L_0x0030:
            r6 = r4
            goto L_0x0065
        L_0x0032:
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x003f
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0065
            goto L_0x0030
        L_0x003f:
            boolean r7 = r6 instanceof java.lang.Double
            if (r7 == 0) goto L_0x0056
            java.lang.Double r6 = (java.lang.Double) r6
            double r7 = r6.doubleValue()
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0030
            double r6 = r6.doubleValue()
            java.lang.String r6 = zzc(r6)
            goto L_0x0065
        L_0x0056:
            boolean r7 = r6 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x0061
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            if (r6 == r7) goto L_0x0030
            java.lang.String r6 = "1"
            goto L_0x0065
        L_0x0061:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x0065:
            if (r6 == 0) goto L_0x001e
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            r0.put(r5, r6)
            goto L_0x001e
        L_0x0071:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbe> r1 = com.google.android.gms.internal.gtm.zzbe.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbe r1 = (com.google.android.gms.internal.gtm.zzbe) r1
            if (r1 == 0) goto L_0x00b6
            java.lang.String r5 = r1.zzf()
            java.lang.String r6 = "t"
            zzf(r0, r6, r5)
            java.lang.String r5 = r1.zze()
            java.lang.String r6 = "cid"
            zzf(r0, r6, r5)
            java.lang.String r5 = r1.zzg()
            java.lang.String r6 = "uid"
            zzf(r0, r6, r5)
            java.lang.String r5 = "sc"
            zzf(r0, r5, r4)
            boolean r5 = r1.zzo()
            java.lang.String r6 = "ni"
            zzg(r0, r6, r5)
            java.lang.String r5 = r1.zzd()
            java.lang.String r6 = "adid"
            zzf(r0, r6, r5)
            boolean r1 = r1.zzn()
            java.lang.String r5 = "ate"
            zzg(r0, r5, r1)
        L_0x00b6:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbf> r1 = com.google.android.gms.internal.gtm.zzbf.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbf r1 = (com.google.android.gms.internal.gtm.zzbf) r1
            if (r1 == 0) goto L_0x00dc
            java.lang.String r5 = "cd"
            zzf(r0, r5, r4)
            int r1 = r1.zzd()
            double r5 = (double) r1
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x00d7
            java.lang.String r1 = zzc(r5)
            java.lang.String r2 = "a"
            r0.put(r2, r1)
        L_0x00d7:
            java.lang.String r1 = "dr"
            zzf(r0, r1, r4)
        L_0x00dc:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbc> r1 = com.google.android.gms.internal.gtm.zzbc.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbc r1 = (com.google.android.gms.internal.gtm.zzbc) r1
            if (r1 == 0) goto L_0x00f5
            java.lang.String r1 = "ec"
            zzf(r0, r1, r4)
            java.lang.String r1 = "ea"
            zzf(r0, r1, r4)
            java.lang.String r1 = "el"
            zzf(r0, r1, r4)
        L_0x00f5:
            java.lang.Class<com.google.android.gms.internal.gtm.zzaw> r1 = com.google.android.gms.internal.gtm.zzaw.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzaw r1 = (com.google.android.gms.internal.gtm.zzaw) r1
            if (r1 == 0) goto L_0x0159
            java.lang.String r2 = r1.zzl()
            java.lang.String r3 = "cn"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzm()
            java.lang.String r3 = "cs"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzk()
            java.lang.String r3 = "cm"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzj()
            java.lang.String r3 = "ck"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzf()
            java.lang.String r3 = "cc"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzi()
            java.lang.String r3 = "ci"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zze()
            java.lang.String r3 = "anid"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzh()
            java.lang.String r3 = "gclid"
            zzf(r0, r3, r2)
            java.lang.String r2 = r1.zzg()
            java.lang.String r3 = "dclid"
            zzf(r0, r3, r2)
            java.lang.String r1 = r1.zzd()
            java.lang.String r2 = "aclid"
            zzf(r0, r2, r1)
        L_0x0159:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbd> r1 = com.google.android.gms.internal.gtm.zzbd.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbd r1 = (com.google.android.gms.internal.gtm.zzbd) r1
            if (r1 == 0) goto L_0x0168
            java.lang.String r1 = "exd"
            zzf(r0, r1, r4)
        L_0x0168:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbg> r1 = com.google.android.gms.internal.gtm.zzbg.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbg r1 = (com.google.android.gms.internal.gtm.zzbg) r1
            if (r1 == 0) goto L_0x0181
            java.lang.String r1 = "sn"
            zzf(r0, r1, r4)
            java.lang.String r1 = "sa"
            zzf(r0, r1, r4)
            java.lang.String r1 = "st"
            zzf(r0, r1, r4)
        L_0x0181:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbh> r1 = com.google.android.gms.internal.gtm.zzbh.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbh r1 = (com.google.android.gms.internal.gtm.zzbh) r1
            if (r1 == 0) goto L_0x019a
            java.lang.String r1 = "utv"
            zzf(r0, r1, r4)
            java.lang.String r1 = "utc"
            zzf(r0, r1, r4)
            java.lang.String r1 = "utl"
            zzf(r0, r1, r4)
        L_0x019a:
            java.lang.Class<com.google.android.gms.internal.gtm.zzax> r1 = com.google.android.gms.internal.gtm.zzax.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzax r1 = (com.google.android.gms.internal.gtm.zzax) r1
            if (r1 == 0) goto L_0x01da
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01b0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01da
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r3 = com.google.android.gms.analytics.zzd.zzb(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x01b0
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r0.put(r3, r2)
            goto L_0x01b0
        L_0x01da:
            java.lang.Class<com.google.android.gms.internal.gtm.zzay> r1 = com.google.android.gms.internal.gtm.zzay.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzay r1 = (com.google.android.gms.internal.gtm.zzay) r1
            if (r1 == 0) goto L_0x0222
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01f0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0222
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r3 = com.google.android.gms.analytics.zzd.zze(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x01f0
            java.lang.Object r2 = r2.getValue()
            java.lang.Double r2 = (java.lang.Double) r2
            double r4 = r2.doubleValue()
            java.lang.String r2 = zzc(r4)
            r0.put(r3, r2)
            goto L_0x01f0
        L_0x0222:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbb> r1 = com.google.android.gms.internal.gtm.zzbb.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzbb r1 = (com.google.android.gms.internal.gtm.zzbb) r1
            if (r1 == 0) goto L_0x02ee
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
            r3 = 1
            r4 = 1
        L_0x0236:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x024f
            java.lang.Object r5 = r2.next()
            com.google.android.gms.analytics.ecommerce.Promotion r5 = (com.google.android.gms.analytics.ecommerce.Promotion) r5
            java.lang.String r6 = com.google.android.gms.analytics.zzd.zzm(r4)
            java.util.Map r5 = r5.zza(r6)
            r0.putAll(r5)
            int r4 = r4 + r3
            goto L_0x0236
        L_0x024f:
            java.util.List r2 = r1.zzd()
            java.util.Iterator r2 = r2.iterator()
            r4 = 1
        L_0x0258:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0271
            java.lang.Object r5 = r2.next()
            com.google.android.gms.analytics.ecommerce.Product r5 = (com.google.android.gms.analytics.ecommerce.Product) r5
            java.lang.String r6 = com.google.android.gms.analytics.zzd.zzk(r4)
            java.util.Map r5 = r5.zza(r6)
            r0.putAll(r5)
            int r4 = r4 + r3
            goto L_0x0258
        L_0x0271:
            java.util.Map r1 = r1.zzf()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r2 = 1
        L_0x027e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x02ee
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            java.util.List r5 = (java.util.List) r5
            java.lang.String r6 = com.google.android.gms.analytics.zzd.zzh(r2)
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x0299:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x02cc
            java.lang.Object r8 = r5.next()
            com.google.android.gms.analytics.ecommerce.Product r8 = (com.google.android.gms.analytics.ecommerce.Product) r8
            java.lang.String r9 = java.lang.String.valueOf(r6)
            java.lang.String r10 = com.google.android.gms.analytics.zzd.zzi(r7)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r11 = r10.length()
            if (r11 == 0) goto L_0x02bc
            java.lang.String r9 = r9.concat(r10)
            goto L_0x02c2
        L_0x02bc:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            r9 = r10
        L_0x02c2:
            java.util.Map r8 = r8.zza(r9)
            r0.putAll(r8)
            int r7 = r7 + 1
            goto L_0x0299
        L_0x02cc:
            java.lang.Object r5 = r4.getKey()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x02eb
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "nm"
            java.lang.String r5 = r5.concat(r6)
            java.lang.Object r4 = r4.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r0.put(r5, r4)
        L_0x02eb:
            int r2 = r2 + 1
            goto L_0x027e
        L_0x02ee:
            java.lang.Class<com.google.android.gms.internal.gtm.zzba> r1 = com.google.android.gms.internal.gtm.zzba.class
            com.google.android.gms.analytics.zzj r1 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzba r1 = (com.google.android.gms.internal.gtm.zzba) r1
            if (r1 == 0) goto L_0x0324
            java.lang.String r2 = r1.zzd()
            java.lang.String r3 = "ul"
            zzf(r0, r3, r2)
            int r2 = r1.zza
            int r1 = r1.zzb
            if (r2 <= 0) goto L_0x0324
            if (r1 <= 0) goto L_0x0324
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 23
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "x"
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "sr"
            r0.put(r2, r1)
        L_0x0324:
            java.lang.Class<com.google.android.gms.internal.gtm.zzav> r1 = com.google.android.gms.internal.gtm.zzav.class
            com.google.android.gms.analytics.zzj r12 = r12.zzc(r1)
            com.google.android.gms.internal.gtm.zzav r12 = (com.google.android.gms.internal.gtm.zzav) r12
            if (r12 == 0) goto L_0x0352
            java.lang.String r1 = r12.zzf()
            java.lang.String r2 = "an"
            zzf(r0, r2, r1)
            java.lang.String r1 = r12.zzd()
            java.lang.String r2 = "aid"
            zzf(r0, r2, r1)
            java.lang.String r1 = r12.zze()
            java.lang.String r2 = "aiid"
            zzf(r0, r2, r1)
            java.lang.String r12 = r12.zzg()
            java.lang.String r1 = "av"
            zzf(r0, r1, r12)
        L_0x0352:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzb.zzd(com.google.android.gms.analytics.zzh):java.util.Map");
    }

    private static void zzf(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void zzg(Map<String, String> map, String str, boolean z2) {
        if (z2) {
            map.put(str, "1");
        }
    }

    public final Uri zzb() {
        return this.zzd;
    }

    public final void zze(zzh zzh) {
        m.a(zzh);
        m.a(zzh.zzm(), (Object) "Can't deliver not submitted measurement");
        m.c("deliver should be called on worker thread");
        zzh zzh2 = new zzh(zzh);
        zzbe zzbe = (zzbe) zzh2.zzb(zzbe.class);
        if (TextUtils.isEmpty(zzbe.zzf())) {
            zzz().zzc(zzd(zzh2), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzbe.zze())) {
            zzz().zzc(zzd(zzh2), "Ignoring measurement without client id");
        } else if (this.zzb.zzc().getAppOptOut()) {
        } else {
            if (zzfs.zzj(i.f27244a, zzbe.zze())) {
                zzG("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(i.f27244a));
                return;
            }
            Map<String, String> zzd2 = zzd(zzh2);
            zzd2.put("v", "1");
            zzd2.put("_v", zzbt.zzb);
            zzd2.put("tid", this.zzc);
            if (this.zzb.zzc().isDryRunEnabled()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry next : zzd2.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append((String) next.getKey());
                    sb.append("=");
                    sb.append((String) next.getValue());
                }
                zzN("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
                return;
            }
            HashMap hashMap = new HashMap();
            zzfs.zzg(hashMap, "uid", zzbe.zzg());
            zzav zzav = (zzav) zzh.zzc(zzav.class);
            if (zzav != null) {
                zzfs.zzg(hashMap, "an", zzav.zzf());
                zzfs.zzg(hashMap, "aid", zzav.zzd());
                zzfs.zzg(hashMap, "av", zzav.zzg());
                zzfs.zzg(hashMap, "aiid", zzav.zze());
            }
            zzd2.put("_s", String.valueOf(zzs().zza(new zzbx(0, zzbe.zze(), this.zzc, !TextUtils.isEmpty(zzbe.zzd()), 0, hashMap))));
            zzs().zzh(new zzex(zzz(), zzd2, zzh.zza(), true));
        }
    }
}
