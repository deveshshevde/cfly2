package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xeagle.android.login.common.TimeUtil;
import fg.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gz {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f8993a = new ConcurrentHashMap<>(8);

    /* renamed from: b  reason: collision with root package name */
    public static volatile List<String> f8994b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f8995c = new ConcurrentHashMap<>(8);

    /* renamed from: d  reason: collision with root package name */
    private static Random f8996d = new Random();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f8997e = new ConcurrentHashMap<>(8);

    /* renamed from: f  reason: collision with root package name */
    private static List<hl> f8998f = Collections.synchronizedList(new ArrayList(16));

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        String f8999a;

        /* renamed from: b  reason: collision with root package name */
        int f9000b;

        /* renamed from: c  reason: collision with root package name */
        double f9001c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        he f9002a;

        /* renamed from: b  reason: collision with root package name */
        long f9003b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        Map<String, List<a>> f9004a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f9005b;

        private c() {
            this.f9004a = new HashMap(8);
            this.f9005b = new HashMap(8);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                return this.f9004a.equals(cVar.f9004a) && this.f9005b.equals(cVar.f9005b);
            }
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f9004a;
            int i2 = 0;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f9005b;
            if (map2 != null) {
                i2 = map2.hashCode();
            }
            return hashCode + i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0090, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(java.lang.String r4, java.lang.String r5) throws com.amap.api.mapcore.util.eu {
        /*
            java.lang.Class<com.amap.api.mapcore.util.gz> r0 = com.amap.api.mapcore.util.gz.class
            monitor-enter(r0)
            java.lang.System.currentTimeMillis()     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 != 0) goto L_0x008f
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 == 0) goto L_0x0014
            goto L_0x008f
        L_0x0014:
            android.content.Context r1 = com.amap.api.mapcore.util.ew.f8613c     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            java.util.List<java.lang.String> r2 = f8994b     // Catch:{ all -> 0x004e }
            if (r2 != 0) goto L_0x0027
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004e }
            r3 = 8
            r2.<init>(r3)     // Catch:{ all -> 0x004e }
            java.util.List r2 = java.util.Collections.synchronizedList(r2)     // Catch:{ all -> 0x004e }
            f8994b = r2     // Catch:{ all -> 0x004e }
        L_0x0027:
            if (r1 != 0) goto L_0x002a
            goto L_0x0056
        L_0x002a:
            java.util.List<java.lang.String> r2 = f8994b     // Catch:{ all -> 0x004e }
            boolean r2 = r2.contains(r5)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0033
            goto L_0x0056
        L_0x0033:
            java.util.List<java.lang.String> r2 = f8994b     // Catch:{ all -> 0x004e }
            r2.add(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "Yb3Blbl9odHRwX2NvbnRyb2w"
            java.lang.String r1 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r5)     // Catch:{ all -> 0x004e }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0045
            goto L_0x0056
        L_0x0045:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x004e }
            r2.<init>(r1)     // Catch:{ all -> 0x004e }
            a((java.lang.String) r5, (org.json.JSONObject) r2)     // Catch:{ all -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r1 = move-exception
            java.lang.String r2 = "hlUtil"
            java.lang.String r3 = "llhl"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
        L_0x0056:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.gz$c> r1 = f8993a     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 == 0) goto L_0x008d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.gz$c> r1 = f8993a     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            int r1 = r1.size()     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 > 0) goto L_0x0063
            goto L_0x008d
        L_0x0063:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.gz$c> r1 = f8993a     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 != 0) goto L_0x006d
            monitor-exit(r0)
            return r4
        L_0x006d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.gz$c> r1 = f8993a     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            com.amap.api.mapcore.util.gz$c r1 = (com.amap.api.mapcore.util.gz.c) r1     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r1 != 0) goto L_0x0079
            monitor-exit(r0)
            return r4
        L_0x0079:
            boolean r2 = a((java.lang.String) r4, (com.amap.api.mapcore.util.gz.c) r1, (java.lang.String) r5)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            if (r2 != 0) goto L_0x0085
            java.lang.String r4 = b(r4, r1, r5)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            monitor-exit(r0)
            return r4
        L_0x0085:
            com.amap.api.mapcore.util.eu r5 = new com.amap.api.mapcore.util.eu     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            java.lang.String r1 = "服务QPS超限"
            r5.<init>(r1)     // Catch:{ eu -> 0x009b, all -> 0x0091 }
            throw r5     // Catch:{ eu -> 0x009b, all -> 0x0091 }
        L_0x008d:
            monitor-exit(r0)
            return r4
        L_0x008f:
            monitor-exit(r0)
            return r4
        L_0x0091:
            r5 = move-exception
            java.lang.String r1 = "hlUtil"
            java.lang.String r2 = "pcr"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x009d }
            monitor-exit(r0)
            return r4
        L_0x009b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x009d }
        L_0x009d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x009f }
        L_0x009f:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gz.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a() {
        try {
            Context context = ew.f8613c;
            if (context != null) {
                hm.a(b(), context);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(ff ffVar, JSONObject jSONObject) {
        synchronized (gz.class) {
            if (ffVar != null) {
                try {
                    String a2 = ffVar.a();
                    if (!TextUtils.isEmpty(a2)) {
                        if (jSONObject == null) {
                            a(a2);
                        }
                        if (!ew.a(jSONObject.optString("able", (String) null), false)) {
                            a(a2);
                            return;
                        }
                        gb.a(ew.f8613c, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                        a(a2, jSONObject);
                    }
                } catch (Throwable th) {
                    fw.a(th, "hlUtil", "par");
                }
            }
        }
    }

    private static void a(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray != null) {
                HashMap hashMap = new HashMap(8);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("api");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!optString.startsWith("/")) {
                                optString = "/".concat(String.valueOf(optString));
                            }
                            if (optString.endsWith("/")) {
                                optString = optString.substring(0, optString.length() - 1);
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                            if (optJSONArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                                    if (optJSONObject2 != null) {
                                        a aVar = new a((byte) 0);
                                        aVar.f8999a = optJSONObject2.optString("begin");
                                        aVar.f9000b = optJSONObject2.optInt("duration");
                                        aVar.f9001c = optJSONObject2.optDouble("percent");
                                        arrayList.add(aVar);
                                    }
                                }
                                hashMap.put(optString, arrayList);
                            }
                        }
                    }
                }
                cVar.f9004a = hashMap;
            }
        } catch (Throwable th) {
            fw.a(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (gz.class) {
            try {
                if (f8993a.containsKey(str)) {
                    f8993a.remove(str);
                }
                SharedPreferences.Editor a2 = gb.a(ew.f8613c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                gb.a(a2, str);
                gb.a(a2);
            } catch (Throwable th) {
                fw.a(th, "hlUtil", "rc");
            }
        }
    }

    private static void a(String str, c cVar) {
        try {
            if (f8993a == null) {
                f8993a = new ConcurrentHashMap<>(8);
            }
            f8993a.put(str, cVar);
        } catch (Throwable th) {
            fw.a(th, "hlUtil", "ucr");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = new org.json.JSONObject();
        r1.put("timestamp", java.lang.System.currentTimeMillis());
        r1.put("type", com.amap.api.mapcore.util.fv.f8854j);
        r1.put("name", r5);
        r1.put("version", com.amap.api.mapcore.util.fv.a(r5));
        r1.put("hostname", r6 + "#" + r7);
        r5 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r6 = new com.amap.api.mapcore.util.hl(r0, "core", "2.0", "O005");
        r6.a(r5);
        com.amap.api.mapcore.util.hm.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            android.content.Context r0 = com.amap.api.mapcore.util.ew.f8613c     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0088
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0088
        L_0x000c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = f8997e     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0019
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0088 }
            r2 = 8
            r1.<init>(r2)     // Catch:{ all -> 0x0088 }
            f8997e = r1     // Catch:{ all -> 0x0088 }
        L_0x0019:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = f8997e     // Catch:{ all -> 0x0088 }
            monitor-enter(r1)     // Catch:{ all -> 0x0088 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = f8997e     // Catch:{ all -> 0x0085 }
            boolean r2 = r2.containsKey(r6)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0026
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            return
        L_0x0026:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = f8997e     // Catch:{ all -> 0x0085 }
            r2.put(r6, r7)     // Catch:{ all -> 0x0085 }
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "timestamp"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0088 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "type"
            java.lang.Integer r3 = com.amap.api.mapcore.util.fv.f8854j     // Catch:{ all -> 0x0088 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "name"
            r1.put(r2, r5)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "version"
            java.lang.String r5 = com.amap.api.mapcore.util.fv.a((java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            r1.put(r2, r5)     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = "hostname"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r2.<init>()     // Catch:{ all -> 0x0088 }
            r2.append(r6)     // Catch:{ all -> 0x0088 }
            java.lang.String r6 = "#"
            r2.append(r6)     // Catch:{ all -> 0x0088 }
            r2.append(r7)     // Catch:{ all -> 0x0088 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0088 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0088 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0073
            return
        L_0x0073:
            com.amap.api.mapcore.util.hl r6 = new com.amap.api.mapcore.util.hl     // Catch:{ all -> 0x0088 }
            java.lang.String r7 = "core"
            java.lang.String r1 = "2.0"
            java.lang.String r2 = "O005"
            r6.<init>(r0, r7, r1, r2)     // Catch:{ all -> 0x0088 }
            r6.a((java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            com.amap.api.mapcore.util.hm.a((com.amap.api.mapcore.util.hl) r6, (android.content.Context) r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0085:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            throw r5     // Catch:{ all -> 0x0088 }
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gz.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            a(cVar, jSONObject);
            b(cVar, jSONObject);
            if (cVar.f9005b == null && cVar.f9004a == null) {
                a(str);
            } else {
                a(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(URL url, he heVar) {
        List list;
        try {
            if (f8995c == null) {
                f8995c = new ConcurrentHashMap<>(8);
            }
            if (heVar.f9118b != null && heVar.f9118b.containsKey("nb") && (list = heVar.f9118b.get("nb")) != null) {
                if (list.size() > 0) {
                    String[] split = ((String) list.get(0)).split("#");
                    if (split.length >= 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        long parseInt2 = (long) Integer.parseInt(split[1]);
                        b bVar = new b((byte) 0);
                        bVar.f9002a = heVar;
                        if (parseInt2 <= 0) {
                            parseInt2 = 30;
                        }
                        bVar.f9003b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                        if (parseInt == 1) {
                            f8995c.put("app", bVar);
                        } else if (parseInt == 2 && url != null) {
                            f8995c.put(url.getPath(), bVar);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z2, String str) {
        try {
            Context context = ew.f8613c;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                jSONObject.put("type", z2 ? fv.f8851g : fv.f8850f);
                jSONObject.put("name", str);
                jSONObject.put("version", fv.a(str));
                String jSONObject2 = jSONObject.toString();
                hl hlVar = new hl(context, "core", "2.0", "O005");
                hlVar.a(jSONObject2);
                hm.a(hlVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z2, String str, String str2, int i2) {
        String str3;
        Integer num;
        try {
            Context context = ew.f8613c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    String a2 = fv.a(str);
                    if (z2) {
                        str3 = "type";
                        num = fv.f8853i;
                    } else {
                        str3 = "type";
                        num = fv.f8852h;
                    }
                    jSONObject.put(str3, num);
                    jSONObject.put("name", str);
                    jSONObject.put("version", a2);
                    jSONObject.put("uri", Uri.parse(str2).getPath());
                    jSONObject.put("blockLevel", i2);
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        hl hlVar = new hl(context, "core", "2.0", "O005");
                        hlVar.a(jSONObject2);
                        if (f8998f == null) {
                            f8998f = Collections.synchronizedList(new ArrayList(16));
                        }
                        synchronized (f8998f) {
                            f8998f.add(hlVar);
                            if (f8998f.size() >= 15) {
                                a();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(a aVar) {
        if (aVar == null || aVar.f9001c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f8999a) && aVar.f9000b > 0) {
            long timeInMillis = currentTimeMillis - fg.a(aVar.f8999a, TimeUtil.DEF_HH_MM_SS).getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < ((long) (aVar.f9000b * 1000))) {
                if (aVar.f9001c == i.f27244a) {
                    return true;
                }
                if (f8996d == null) {
                    f8996d = new Random();
                }
                f8996d.setSeed(((long) UUID.randomUUID().hashCode()) + currentTimeMillis);
                if (f8996d.nextDouble() > aVar.f9001c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, c cVar, String str2) {
        try {
            Map<String, List<a>> map = cVar.f9004a;
            if (map != null) {
                if (map.size() > 0) {
                    if (map.containsKey("*")) {
                        for (Map.Entry<String, List<a>> value : map.entrySet()) {
                            if (a((List<a>) (List) value.getValue())) {
                                a(false, str2, str, 1);
                                return true;
                            }
                        }
                    } else {
                        String path = Uri.parse(str).getPath();
                        if (map.containsKey(path) && a(map.get(path))) {
                            a(false, str2, str, 2);
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            fw.a(th, "hlUtil", "inb");
        }
    }

    private static boolean a(List<a> list) {
        if (list != null && list.size() > 0) {
            for (a a2 : list) {
                if (a(a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static he b(String str, String str2) {
        Uri parse;
        String str3 = "app";
        try {
            if (f8995c == null) {
                return null;
            }
            if (f8995c.containsKey(str3)) {
                b bVar = f8995c.get(str3);
                if (SystemClock.elapsedRealtime() <= bVar.f9003b) {
                    he heVar = bVar.f9002a;
                    if (heVar != null) {
                        heVar.f9121e = false;
                    }
                    a(true, str2, str, 1);
                    return heVar;
                }
            } else {
                if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                    str3 = parse.getPath();
                    if (f8995c.containsKey(str3)) {
                        b bVar2 = f8995c.get(str3);
                        if (SystemClock.elapsedRealtime() <= bVar2.f9003b) {
                            he heVar2 = bVar2.f9002a;
                            if (heVar2 != null) {
                                heVar2.f9121e = false;
                            }
                            a(true, str2, str, 2);
                            return heVar2;
                        }
                    }
                }
                return null;
            }
            f8995c.remove(str3);
            return null;
        } catch (Throwable unused) {
        }
    }

    private static String b(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f9005b;
            if (map != null) {
                if (map.size() > 0) {
                    Uri parse = Uri.parse(str);
                    String authority = parse.getAuthority();
                    if (!map.containsKey(authority)) {
                        return str;
                    }
                    String str3 = map.get(authority);
                    String builder = parse.buildUpon().authority(str3).toString();
                    a(str2, authority, str3);
                    return builder;
                }
            }
            return str;
        } catch (Throwable th) {
            fw.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    private static List<hl> b() {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        try {
            synchronized (f8998f) {
                try {
                    List<hl> list = f8998f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f8998f);
                            f8998f.clear();
                            arrayList2 = arrayList;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable unused) {
                                return arrayList;
                            }
                        }
                    }
                    return arrayList2;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    arrayList = arrayList2;
                    th = th3;
                }
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static void b(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject != null && (names = optJSONObject.names()) != null) {
                HashMap hashMap = new HashMap(8);
                int length = names.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = names.optString(i2);
                    hashMap.put(optString, optJSONObject.optString(optString));
                }
                cVar.f9005b = hashMap;
            }
        } catch (Throwable th) {
            fw.a(th, "hlUtil", "pdr");
        }
    }
}
