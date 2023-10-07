package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.mapcore.util.ha;
import com.amap.api.mapcore.util.hd;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class ew {
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<ha.a> B = new ArrayList<>();
    private static volatile boolean C = false;
    private static Queue<ha.c> D = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public static int f8611a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f8612b = "";

    /* renamed from: c  reason: collision with root package name */
    public static Context f8613c = null;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f8614d = false;

    /* renamed from: e  reason: collision with root package name */
    public static int f8615e = 5000;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f8616f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f8617g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f8618h = true;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f8619i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f8620j = false;

    /* renamed from: k  reason: collision with root package name */
    private static String f8621k = "6";

    /* renamed from: l  reason: collision with root package name */
    private static String f8622l = "4";

    /* renamed from: m  reason: collision with root package name */
    private static String f8623m = "9";

    /* renamed from: n  reason: collision with root package name */
    private static String f8624n = "8";

    /* renamed from: o  reason: collision with root package name */
    private static volatile boolean f8625o = true;

    /* renamed from: p  reason: collision with root package name */
    private static Vector<d> f8626p = new Vector<>();

    /* renamed from: q  reason: collision with root package name */
    private static Map<String, Integer> f8627q = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private static String f8628r = null;

    /* renamed from: s  reason: collision with root package name */
    private static long f8629s = 0;

    /* renamed from: t  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f8630t = new ConcurrentHashMap<>(8);

    /* renamed from: u  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f8631u = new ConcurrentHashMap<>(8);
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f8632v = new ConcurrentHashMap<>(8);

    /* renamed from: w  reason: collision with root package name */
    private static boolean f8633w = false;

    /* renamed from: x  reason: collision with root package name */
    private static int f8634x = 3;

    /* renamed from: y  reason: collision with root package name */
    private static int f8635y = 3;

    /* renamed from: z  reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f8636z = new ConcurrentHashMap<>();

    public static class a {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f8641a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8642b;

        /* renamed from: c  reason: collision with root package name */
        public String f8643c;

        /* renamed from: d  reason: collision with root package name */
        public int f8644d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f8645e = 0;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f8646f;

        /* renamed from: g  reason: collision with root package name */
        public C0074a f8647g;

        /* renamed from: h  reason: collision with root package name */
        public b f8648h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f8649i;

        /* renamed from: com.amap.api.mapcore.util.ew$a$a  reason: collision with other inner class name */
        public static class C0074a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f8650a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f8651b;

            /* renamed from: c  reason: collision with root package name */
            public JSONObject f8652c;
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f8653a;
        }
    }

    static class b extends gx {

        /* renamed from: g  reason: collision with root package name */
        private String f8654g;

        /* renamed from: h  reason: collision with root package name */
        private Map<String, String> f8655h;

        /* renamed from: i  reason: collision with root package name */
        private String f8656i;

        /* renamed from: j  reason: collision with root package name */
        private String f8657j;

        /* renamed from: k  reason: collision with root package name */
        private String f8658k;

        b(Context context, ff ffVar, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, ffVar);
            this.f8654g = str;
            this.f8655h = map;
            this.f8656i = str2;
            this.f8657j = str3;
            this.f8658k = str4;
            setHttpProtocol(hd.c.HTTPS);
            setDegradeAbility(hd.a.FIX);
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        public final byte[] c() {
            return null;
        }

        public final byte[] d() {
            String t2 = ez.t(this.f8987e);
            if (!TextUtils.isEmpty(t2)) {
                t2 = fd.b(new StringBuilder(t2).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f8654g) ? "" : this.f8654g);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.f8988f.a());
            hashMap.put("version", this.f8988f.b());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", t2);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f8655h;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f8655h);
            }
            hashMap.put("abitype", fg.a(this.f8987e));
            hashMap.put("ext", this.f8988f.e());
            return fg.a(fg.a((Map<String, String>) hashMap));
        }

        /* access modifiers changed from: protected */
        public final String e() {
            return "3.0";
        }

        /* access modifiers changed from: protected */
        public final String getIPDNSName() {
            return !TextUtils.isEmpty(this.f8658k) ? this.f8658k : super.getIPDNSName();
        }

        public final String getIPV6URL() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f8657j);
        }

        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f8658k)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f8658k);
            return hashMap;
        }

        public final String getURL() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f8656i);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        ff f8659a;

        /* renamed from: b  reason: collision with root package name */
        String f8660b;

        private c() {
        }
    }

    public static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f8661a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f8662b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public AtomicInteger f8663c;

        public d(String str, String str2, int i2) {
            this.f8661a = str;
            this.f8662b = str2;
            this.f8663c = new AtomicInteger(i2);
        }

        public static d b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new d(jSONObject.optString("a"), jSONObject.optString(fx.f8868i), jSONObject.optInt(fx.f8866g));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f8663c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void a(String str) {
            this.f8662b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f8661a);
                jSONObject.put(fx.f8868i, this.f8662b);
                jSONObject.put(fx.f8866g, this.f8663c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f8664a = true;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f8665b = false;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f8666c = true;

        /* renamed from: d  reason: collision with root package name */
        public static int f8667d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static boolean f8668e = false;

        /* renamed from: f  reason: collision with root package name */
        public static int f8669f;
    }

    public static a a(Context context, ff ffVar, String str, String str2, String str3, String str4) {
        return a(context, ffVar, str, (Map<String, String>) null, str2, str3, str4);
    }

    public static a a(Context context, ff ffVar, String str, Map<String, String> map) {
        return b(context, ffVar, str, map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: android.content.Context} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x014f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.amap.api.mapcore.util.ew.a a(android.content.Context r23, com.amap.api.mapcore.util.ff r24, java.lang.String r25, java.util.Map<java.lang.String, java.lang.String> r26, java.lang.String r27, java.lang.String r28, java.lang.String r29) {
        /*
            r9 = r23
            r10 = r24
            java.lang.String r11 = "infocode"
            java.lang.String r12 = "info"
            java.lang.String r13 = "result"
            java.lang.String r14 = "ver"
            java.lang.String r15 = "status"
            java.lang.String r8 = "lct"
            java.lang.String r7 = "lc"
            java.lang.String r6 = "at"
            com.amap.api.mapcore.util.ew$a r5 = new com.amap.api.mapcore.util.ew$a
            r5.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r5.f8646f = r0
            if (r9 == 0) goto L_0x0028
            android.content.Context r0 = r23.getApplicationContext()
            f8613c = r0
        L_0x0028:
            d()
            r16 = 0
            r4 = 0
            a((com.amap.api.mapcore.util.ff) r24)     // Catch:{ eu -> 0x01a1, IllegalBlockSizeException -> 0x018a, all -> 0x0173 }
            com.amap.api.mapcore.util.gw r0 = new com.amap.api.mapcore.util.gw     // Catch:{ eu -> 0x01a1, IllegalBlockSizeException -> 0x018a, all -> 0x0173 }
            r0.<init>()     // Catch:{ eu -> 0x01a1, IllegalBlockSizeException -> 0x018a, all -> 0x0173 }
            boolean r0 = android.text.TextUtils.isEmpty(r25)     // Catch:{ eu -> 0x01a1, IllegalBlockSizeException -> 0x018a, all -> 0x0173 }
            if (r0 != 0) goto L_0x0075
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ eu -> 0x0065, all -> 0x0054 }
            r1.<init>()     // Catch:{ eu -> 0x0065, all -> 0x0054 }
            r2 = r25
            r1.append(r2)     // Catch:{ eu -> 0x0052, all -> 0x0056 }
            java.lang.String r3 = ";15K;16H;17I;17S;183"
            r1.append(r3)     // Catch:{ eu -> 0x0052, all -> 0x0056 }
            java.lang.String r1 = r1.toString()     // Catch:{ eu -> 0x0052, all -> 0x0056 }
            r17 = r1
            goto L_0x0079
        L_0x0052:
            r0 = move-exception
            goto L_0x0068
        L_0x0054:
            r2 = r25
        L_0x0056:
            r17 = r2
        L_0x0058:
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
            goto L_0x014f
        L_0x0065:
            r0 = move-exception
            r2 = r25
        L_0x0068:
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
            goto L_0x016c
        L_0x0075:
            r2 = r25
            r17 = r2
        L_0x0079:
            d((android.content.Context) r23)     // Catch:{ eu -> 0x015e, all -> 0x0058 }
            com.amap.api.mapcore.util.ew$b r18 = new com.amap.api.mapcore.util.ew$b     // Catch:{ eu -> 0x015e, all -> 0x0058 }
            r1 = r18
            r2 = r23
            r3 = r24
            r19 = r13
            r13 = 0
            r4 = r17
            r13 = r5
            r5 = r26
            r20 = r14
            r14 = r6
            r6 = r27
            r21 = r11
            r11 = r7
            r7 = r28
            r22 = r12
            r12 = r8
            r8 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ eu -> 0x014d, all -> 0x014f }
            com.amap.api.mapcore.util.he r1 = com.amap.api.mapcore.util.gw.b(r18)     // Catch:{ eu -> 0x014d, all -> 0x014f }
            if (r0 == 0) goto L_0x00a5
            return r13
        L_0x00a5:
            if (r1 == 0) goto L_0x0106
            byte[] r2 = r1.f9117a     // Catch:{ eu -> 0x0101, IllegalBlockSizeException -> 0x00fc, all -> 0x00f7 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = r1.f9118b     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0108
            boolean r3 = r0.containsKey(r12)     // Catch:{ all -> 0x00f2 }
            if (r3 == 0) goto L_0x0108
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x00f2 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0108
            int r3 = r0.size()     // Catch:{ all -> 0x00f2 }
            if (r3 <= 0) goto L_0x0108
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00f2 }
            if (r3 != 0) goto L_0x0108
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00f2 }
            long r3 = r0.longValue()     // Catch:{ all -> 0x00f2 }
            r13.f8645e = r3     // Catch:{ all -> 0x00f2 }
            if (r10 == 0) goto L_0x0108
            long r3 = r13.f8645e     // Catch:{ all -> 0x00f2 }
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0108
            java.lang.String r0 = r24.a()     // Catch:{ all -> 0x00f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00f2 }
            if (r3 != 0) goto L_0x0108
            long r3 = r13.f8645e     // Catch:{ all -> 0x00f2 }
            b((java.lang.String) r0, (long) r3)     // Catch:{ all -> 0x00f2 }
            goto L_0x0108
        L_0x00f2:
            r0 = move-exception
            com.amap.api.mapcore.util.fz.c(r0, r14, r12)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            goto L_0x0108
        L_0x00f7:
            r0 = move-exception
            r2 = r16
            goto L_0x0186
        L_0x00fc:
            r0 = move-exception
            r2 = r16
            goto L_0x019d
        L_0x0101:
            r0 = move-exception
            r2 = r16
            goto L_0x01b4
        L_0x0106:
            r2 = r16
        L_0x0108:
            r0 = 16
            byte[] r3 = new byte[r0]     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            int r4 = r2.length     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            int r4 = r4 - r0
            byte[] r4 = new byte[r4]     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            r5 = 0
            java.lang.System.arraycopy(r2, r5, r3, r5, r0)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            int r6 = r2.length     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            int r6 = r6 - r0
            java.lang.System.arraycopy(r2, r0, r4, r5, r6)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            java.lang.String r5 = "EQUVT"
            java.lang.String r5 = com.amap.api.mapcore.util.fg.c((java.lang.String) r5)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            r0.<init>(r3, r5)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            java.lang.String r3 = "CQUVTL0NCQy9QS0NTNVBhZGRpbmc"
            java.lang.String r3 = com.amap.api.mapcore.util.fg.c((java.lang.String) r3)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            javax.crypto.Cipher r3 = javax.crypto.Cipher.getInstance(r3)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            javax.crypto.spec.IvParameterSpec r5 = new javax.crypto.spec.IvParameterSpec     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            byte[] r6 = com.amap.api.mapcore.util.fg.c()     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            r5.<init>(r6)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            r6 = 2
            r3.init(r6, r0, r5)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            byte[] r0 = r3.doFinal(r4)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            java.lang.String r16 = com.amap.api.mapcore.util.fg.a((byte[]) r0)     // Catch:{ eu -> 0x014a, IllegalBlockSizeException -> 0x0147, all -> 0x0145 }
            goto L_0x01c6
        L_0x0145:
            r0 = move-exception
            goto L_0x0186
        L_0x0147:
            r0 = move-exception
            goto L_0x019d
        L_0x014a:
            r0 = move-exception
            goto L_0x01b4
        L_0x014d:
            r0 = move-exception
            goto L_0x016a
        L_0x014f:
            com.amap.api.mapcore.util.eu r0 = new com.amap.api.mapcore.util.eu     // Catch:{ eu -> 0x015b, IllegalBlockSizeException -> 0x0159, all -> 0x0157 }
            java.lang.String r1 = "未知的错误"
            r0.<init>(r1)     // Catch:{ eu -> 0x015b, IllegalBlockSizeException -> 0x0159, all -> 0x0157 }
            throw r0     // Catch:{ eu -> 0x015b, IllegalBlockSizeException -> 0x0159, all -> 0x0157 }
        L_0x0157:
            r0 = move-exception
            goto L_0x0183
        L_0x0159:
            r0 = move-exception
            goto L_0x019a
        L_0x015b:
            r0 = move-exception
            goto L_0x01b1
        L_0x015e:
            r0 = move-exception
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
        L_0x016a:
            r2 = r17
        L_0x016c:
            throw r0     // Catch:{ eu -> 0x0171, IllegalBlockSizeException -> 0x016f, all -> 0x016d }
        L_0x016d:
            r0 = move-exception
            goto L_0x0181
        L_0x016f:
            r0 = move-exception
            goto L_0x0198
        L_0x0171:
            r0 = move-exception
            goto L_0x01af
        L_0x0173:
            r0 = move-exception
            r2 = r25
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
        L_0x0181:
            r17 = r2
        L_0x0183:
            r1 = r16
            r2 = r1
        L_0x0186:
            com.amap.api.mapcore.util.fz.c(r0, r14, r11)
            goto L_0x019d
        L_0x018a:
            r0 = move-exception
            r2 = r25
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
        L_0x0198:
            r17 = r2
        L_0x019a:
            r1 = r16
            r2 = r1
        L_0x019d:
            a((android.content.Context) r9, (com.amap.api.mapcore.util.ff) r10, (java.lang.Throwable) r0)
            goto L_0x01c6
        L_0x01a1:
            r0 = move-exception
            r2 = r25
            r21 = r11
            r22 = r12
            r19 = r13
            r20 = r14
            r13 = r5
            r14 = r6
            r11 = r7
        L_0x01af:
            r17 = r2
        L_0x01b1:
            r1 = r16
            r2 = r1
        L_0x01b4:
            java.lang.String r3 = r0.a()
            r13.f8643c = r3
            java.lang.String r3 = r0.a()
            a((android.content.Context) r9, (com.amap.api.mapcore.util.ff) r10, (java.lang.String) r3)
            java.lang.String r3 = "/v3/iasdkauth"
            com.amap.api.mapcore.util.fz.a((com.amap.api.mapcore.util.ff) r10, (java.lang.String) r3, (com.amap.api.mapcore.util.eu) r0)
        L_0x01c6:
            r7 = r17
            if (r2 != 0) goto L_0x01cb
            return r13
        L_0x01cb:
            boolean r0 = android.text.TextUtils.isEmpty(r16)
            if (r0 == 0) goto L_0x01d5
            java.lang.String r16 = com.amap.api.mapcore.util.fg.a((byte[]) r2)
        L_0x01d5:
            r0 = r16
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x01e2
            java.lang.String r2 = "result is null"
            a((android.content.Context) r9, (com.amap.api.mapcore.util.ff) r10, (java.lang.String) r2)
        L_0x01e2:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x028b }
            r8.<init>(r0)     // Catch:{ all -> 0x028b }
            boolean r0 = r8.has(r15)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x028f
            int r0 = r8.getInt(r15)     // Catch:{ all -> 0x028b }
            r2 = 1
            if (r0 != r2) goto L_0x01f7
            f8611a = r2     // Catch:{ all -> 0x028b }
            goto L_0x023d
        L_0x01f7:
            if (r0 != 0) goto L_0x023d
            java.lang.String r0 = "authcsid"
            java.lang.String r2 = "authgsid"
            if (r1 == 0) goto L_0x0206
            java.lang.String r0 = r1.f9119c     // Catch:{ all -> 0x028b }
            java.lang.String r1 = r1.f9120d     // Catch:{ all -> 0x028b }
            r5 = r0
            r4 = r1
            goto L_0x0208
        L_0x0206:
            r5 = r0
            r4 = r2
        L_0x0208:
            com.amap.api.mapcore.util.fg.a(r9, r5, r4, r8)     // Catch:{ all -> 0x028b }
            r1 = 0
            f8611a = r1     // Catch:{ all -> 0x028b }
            r1 = r22
            boolean r0 = r8.has(r1)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x021c
            java.lang.String r0 = r8.getString(r1)     // Catch:{ all -> 0x028b }
            f8612b = r0     // Catch:{ all -> 0x028b }
        L_0x021c:
            java.lang.String r0 = ""
            r1 = r21
            boolean r2 = r8.has(r1)     // Catch:{ all -> 0x028b }
            if (r2 == 0) goto L_0x022a
            java.lang.String r0 = r8.getString(r1)     // Catch:{ all -> 0x028b }
        L_0x022a:
            r6 = r0
            java.lang.String r2 = "/v3/iasdkauth"
            java.lang.String r3 = f8612b     // Catch:{ all -> 0x028b }
            r1 = r24
            com.amap.api.mapcore.util.fz.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x028b }
            int r0 = f8611a     // Catch:{ all -> 0x028b }
            if (r0 != 0) goto L_0x023d
            java.lang.String r0 = f8612b     // Catch:{ all -> 0x028b }
            r13.f8643c = r0     // Catch:{ all -> 0x028b }
            return r13
        L_0x023d:
            r1 = r20
            boolean r0 = r8.has(r1)     // Catch:{ all -> 0x024c }
            if (r0 == 0) goto L_0x0250
            int r0 = r8.getInt(r1)     // Catch:{ all -> 0x024c }
            r13.f8644d = r0     // Catch:{ all -> 0x024c }
            goto L_0x0250
        L_0x024c:
            r0 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r11)     // Catch:{ all -> 0x028b }
        L_0x0250:
            r1 = r19
            boolean r0 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r8, (java.lang.String) r1)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x028f
            org.json.JSONObject r0 = r8.getJSONObject(r1)     // Catch:{ all -> 0x028b }
            a((android.content.Context) r9, (com.amap.api.mapcore.util.ff) r10, (java.lang.String) r7, (com.amap.api.mapcore.util.ew.a) r13, (org.json.JSONObject) r0)     // Catch:{ all -> 0x028b }
            java.lang.String r1 = "15K"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ all -> 0x028f }
            java.lang.String r1 = "isTargetAble"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ all -> 0x028f }
            r2 = 0
            boolean r1 = a((java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x028f }
            java.lang.String r3 = "able"
            java.lang.String r0 = r0.optString(r3)     // Catch:{ all -> 0x028f }
            boolean r0 = a((java.lang.String) r0, (boolean) r2)     // Catch:{ all -> 0x028f }
            if (r0 != 0) goto L_0x0283
            com.amap.api.mapcore.util.fb.a()     // Catch:{ all -> 0x028f }
            com.amap.api.mapcore.util.fb.b(r23)     // Catch:{ all -> 0x028f }
            goto L_0x028f
        L_0x0283:
            com.amap.api.mapcore.util.fb r0 = com.amap.api.mapcore.util.fb.a()     // Catch:{ all -> 0x028f }
            r0.a(r9, r1)     // Catch:{ all -> 0x028f }
            goto L_0x028f
        L_0x028b:
            r0 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r11)
        L_0x028f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.a(android.content.Context, com.amap.api.mapcore.util.ff, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.mapcore.util.ew$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized com.amap.api.mapcore.util.ew.d a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.ew> r0 = com.amap.api.mapcore.util.ew.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006b }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x002c
            r1 = 0
        L_0x000c:
            java.util.Vector<com.amap.api.mapcore.util.ew$d> r4 = f8626p     // Catch:{ all -> 0x006b }
            int r4 = r4.size()     // Catch:{ all -> 0x006b }
            if (r1 >= r4) goto L_0x002c
            java.util.Vector<com.amap.api.mapcore.util.ew$d> r4 = f8626p     // Catch:{ all -> 0x006b }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x006b }
            com.amap.api.mapcore.util.ew$d r4 = (com.amap.api.mapcore.util.ew.d) r4     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x0029
            java.lang.String r5 = r4.f8661a     // Catch:{ all -> 0x006b }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x006b }
            if (r5 == 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x002c:
            r4 = r2
        L_0x002d:
            if (r4 == 0) goto L_0x0031
            monitor-exit(r0)
            return r4
        L_0x0031:
            if (r6 != 0) goto L_0x0035
            monitor-exit(r0)
            return r2
        L_0x0035:
            java.lang.String r1 = ""
            java.lang.String r6 = com.amap.api.mapcore.util.gb.b(r6, r8, r7, r1)     // Catch:{ all -> 0x006b }
            com.amap.api.mapcore.util.ew$d r6 = com.amap.api.mapcore.util.ew.d.b((java.lang.String) r6)     // Catch:{ all -> 0x006b }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006b }
            java.lang.String r8 = "yyyyMMdd"
            java.lang.String r8 = com.amap.api.mapcore.util.fg.a((long) r1, (java.lang.String) r8)     // Catch:{ all -> 0x006b }
            if (r6 != 0) goto L_0x0050
            com.amap.api.mapcore.util.ew$d r6 = new com.amap.api.mapcore.util.ew$d     // Catch:{ all -> 0x006b }
            r6.<init>(r7, r8, r3)     // Catch:{ all -> 0x006b }
        L_0x0050:
            java.lang.String r7 = r6.f8662b     // Catch:{ all -> 0x006b }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x006b }
            if (r7 != 0) goto L_0x0064
            r6.a((java.lang.String) r8)     // Catch:{ all -> 0x006b }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f8663c     // Catch:{ all -> 0x006b }
            r7.set(r3)     // Catch:{ all -> 0x006b }
        L_0x0064:
            java.util.Vector<com.amap.api.mapcore.util.ew$d> r7 = f8626p     // Catch:{ all -> 0x006b }
            r7.add(r6)     // Catch:{ all -> 0x006b }
            monitor-exit(r0)
            return r6
        L_0x006b:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x006f
        L_0x006e:
            throw r6
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.a(android.content.Context, java.lang.String, java.lang.String):com.amap.api.mapcore.util.ew$d");
    }

    public static void a(Context context) {
        if (context != null) {
            f8613c = context.getApplicationContext();
        }
    }

    private static void a(Context context, ff ffVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", ffVar.a());
        hashMap.put("amap_sdk_version", ffVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                hl hlVar = new hl(context, "core", "2.0", "O001");
                hlVar.a(jSONObject);
                hm.a(hlVar, context);
            } catch (eu unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0244 A[SYNTHETIC, Splitter:B:101:0x0244] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02e5 A[SYNTHETIC, Splitter:B:126:0x02e5] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02fd A[SYNTHETIC, Splitter:B:132:0x02fd] */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r20, com.amap.api.mapcore.util.ff r21, java.lang.String r22, com.amap.api.mapcore.util.ew.a r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            r1 = r20
            r2 = r23
            r3 = r24
            java.lang.String r4 = "ustv"
            java.lang.String r5 = "ust"
            java.lang.String r6 = "umv"
            java.lang.String r7 = "usc"
            java.lang.String r8 = "fsv2"
            java.lang.String r9 = "ucf"
            java.lang.String r10 = "off"
            com.amap.api.mapcore.util.ew$a$a r11 = new com.amap.api.mapcore.util.ew$a$a
            r11.<init>()
            r12 = 0
            r11.f8650a = r12
            r11.f8651b = r12
            r2.f8647g = r11
            java.lang.String r0 = ";"
            r13 = r22
            java.lang.String[] r0 = r13.split(r0)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0055
            int r13 = r0.length     // Catch:{ all -> 0x004d }
            if (r13 <= 0) goto L_0x0055
            int r13 = r0.length     // Catch:{ all -> 0x004d }
            r14 = 0
        L_0x002f:
            if (r14 >= r13) goto L_0x0055
            r15 = r0[r14]     // Catch:{ all -> 0x004d }
            boolean r16 = r3.has(r15)     // Catch:{ all -> 0x004d }
            if (r16 == 0) goto L_0x0045
            org.json.JSONObject r12 = r2.f8646f     // Catch:{ all -> 0x004d }
            r22 = r0
            java.lang.Object r0 = r3.get(r15)     // Catch:{ all -> 0x004d }
            r12.putOpt(r15, r0)     // Catch:{ all -> 0x004d }
            goto L_0x0047
        L_0x0045:
            r22 = r0
        L_0x0047:
            int r14 = r14 + 1
            r0 = r22
            r12 = 0
            goto L_0x002f
        L_0x004d:
            r0 = move-exception
            java.lang.String r12 = "at"
            java.lang.String r13 = "co"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r12, (java.lang.String) r13)
        L_0x0055:
            java.lang.String r0 = "16H"
            boolean r12 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            java.lang.String r13 = "able"
            java.lang.String r14 = "AuthConfigManager"
            if (r12 == 0) goto L_0x0078
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r0.optString(r13)     // Catch:{ all -> 0x0072 }
            r12 = 0
            boolean r0 = a((java.lang.String) r0, (boolean) r12)     // Catch:{ all -> 0x0072 }
            boolean unused = r2.f8649i = r0     // Catch:{ all -> 0x0072 }
            goto L_0x0078
        L_0x0072:
            r0 = move-exception
            java.lang.String r12 = "load 16H"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r12)
        L_0x0078:
            java.lang.String r0 = "11K"
            boolean r12 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r12 == 0) goto L_0x00a2
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r12 = r0.getString(r13)     // Catch:{ all -> 0x009c }
            r15 = 0
            boolean r12 = a((java.lang.String) r12, (boolean) r15)     // Catch:{ all -> 0x009c }
            r11.f8650a = r12     // Catch:{ all -> 0x009c }
            boolean r12 = r0.has(r10)     // Catch:{ all -> 0x009c }
            if (r12 == 0) goto L_0x00a2
            org.json.JSONObject r0 = r0.getJSONObject(r10)     // Catch:{ all -> 0x009c }
            r11.f8652c = r0     // Catch:{ all -> 0x009c }
            goto L_0x00a2
        L_0x009c:
            r0 = move-exception
            java.lang.String r10 = "load 11K"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r10)
        L_0x00a2:
            java.lang.String r0 = "145"
            boolean r10 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r10 == 0) goto L_0x00b7
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x00b1 }
            r2.f8641a = r0     // Catch:{ all -> 0x00b1 }
            goto L_0x00b7
        L_0x00b1:
            r0 = move-exception
            java.lang.String r10 = "load 145"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r10)
        L_0x00b7:
            java.lang.String r0 = "14D"
            boolean r10 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r10 == 0) goto L_0x00cc
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x00c6 }
            r2.f8642b = r0     // Catch:{ all -> 0x00c6 }
            goto L_0x00cc
        L_0x00c6:
            r0 = move-exception
            java.lang.String r10 = "load 14D"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r10)
        L_0x00cc:
            java.lang.String r0 = "151"
            boolean r10 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r10 == 0) goto L_0x00f3
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x00ed }
            com.amap.api.mapcore.util.ew$a$b r10 = new com.amap.api.mapcore.util.ew$a$b     // Catch:{ all -> 0x00ed }
            r10.<init>()     // Catch:{ all -> 0x00ed }
            if (r0 == 0) goto L_0x00ea
            java.lang.String r0 = r0.optString(r13)     // Catch:{ all -> 0x00ed }
            r11 = 0
            boolean r0 = a((java.lang.String) r0, (boolean) r11)     // Catch:{ all -> 0x00ed }
            r10.f8653a = r0     // Catch:{ all -> 0x00ed }
        L_0x00ea:
            r2.f8648h = r10     // Catch:{ all -> 0x00ed }
            goto L_0x00f3
        L_0x00ed:
            r0 = move-exception
            java.lang.String r2 = "load 151"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r2)
        L_0x00f3:
            java.lang.String r0 = "17S"
            boolean r2 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            java.lang.String r10 = "open_common"
            if (r2 == 0) goto L_0x0236
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0120
            java.lang.String r2 = r0.optString(r13)     // Catch:{ all -> 0x0229 }
            r11 = 0
            boolean r2 = a((java.lang.String) r2, (boolean) r11)     // Catch:{ all -> 0x0229 }
            boolean r11 = f8625o     // Catch:{ all -> 0x0229 }
            if (r2 == r11) goto L_0x0120
            f8625o = r2     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x0120
            android.content.SharedPreferences$Editor r11 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r10)     // Catch:{ all -> 0x0229 }
            java.lang.String r12 = "a2"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r11, (java.lang.String) r12, (boolean) r2)     // Catch:{ all -> 0x0229 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r11)     // Catch:{ all -> 0x0229 }
        L_0x0120:
            if (r0 == 0) goto L_0x0236
            java.lang.String r2 = "static_enable"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0229 }
            r11 = 1
            boolean r2 = a((java.lang.String) r2, (boolean) r11)     // Catch:{ all -> 0x0229 }
            java.lang.String r12 = "static_ip_direct_enable"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ all -> 0x0229 }
            r13 = 0
            boolean r12 = a((java.lang.String) r12, (boolean) r13)     // Catch:{ all -> 0x0229 }
            java.lang.String r13 = "static_timeout"
            r15 = 5
            int r13 = r0.optInt(r13, r15)     // Catch:{ all -> 0x0229 }
            int r13 = r13 * 1000
            java.lang.String r15 = "static_retry"
            r11 = 3
            int r15 = r0.optInt(r15, r11)     // Catch:{ all -> 0x0229 }
            java.lang.String r11 = "bgp_enable"
            java.lang.String r11 = r0.optString(r11)     // Catch:{ all -> 0x0229 }
            r17 = r4
            r4 = 1
            boolean r4 = a((java.lang.String) r11, (boolean) r4)     // Catch:{ all -> 0x0227 }
            java.lang.String r11 = "bgp_ip_direct_enable"
            java.lang.String r11 = r0.optString(r11)     // Catch:{ all -> 0x0227 }
            r18 = r5
            r5 = 0
            boolean r11 = a((java.lang.String) r11, (boolean) r5)     // Catch:{ all -> 0x0225 }
            java.lang.String r5 = "bgp_retry"
            r19 = r6
            r6 = 3
            int r5 = r0.optInt(r5, r6)     // Catch:{ all -> 0x0223 }
            java.lang.String r6 = "perf_data_upload_enable"
            java.lang.String r0 = r0.optString(r6)     // Catch:{ all -> 0x0223 }
            r6 = 0
            boolean r0 = a((java.lang.String) r0, (boolean) r6)     // Catch:{ all -> 0x0223 }
            boolean r6 = f8616f     // Catch:{ all -> 0x0223 }
            if (r2 != r6) goto L_0x0196
            boolean r6 = f8617g     // Catch:{ all -> 0x0223 }
            if (r12 != r6) goto L_0x0196
            int r6 = f8615e     // Catch:{ all -> 0x0223 }
            if (r13 != r6) goto L_0x0196
            int r6 = f8634x     // Catch:{ all -> 0x0223 }
            if (r15 != r6) goto L_0x0196
            boolean r6 = f8618h     // Catch:{ all -> 0x0223 }
            if (r4 != r6) goto L_0x0196
            boolean r6 = f8619i     // Catch:{ all -> 0x0223 }
            if (r11 != r6) goto L_0x0196
            int r6 = f8635y     // Catch:{ all -> 0x0223 }
            if (r5 != r6) goto L_0x0196
            boolean r6 = f8620j     // Catch:{ all -> 0x0223 }
            if (r0 == r6) goto L_0x01d7
        L_0x0196:
            f8616f = r2     // Catch:{ all -> 0x0223 }
            f8617g = r12     // Catch:{ all -> 0x0223 }
            f8615e = r13     // Catch:{ all -> 0x0223 }
            f8634x = r15     // Catch:{ all -> 0x0223 }
            f8618h = r4     // Catch:{ all -> 0x0223 }
            f8619i = r11     // Catch:{ all -> 0x0223 }
            f8635y = r5     // Catch:{ all -> 0x0223 }
            f8620j = r0     // Catch:{ all -> 0x0223 }
            if (r1 == 0) goto L_0x01d7
            android.content.SharedPreferences$Editor r6 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r10)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a13"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a6"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (boolean) r4)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a7"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (boolean) r12)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a8"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (int) r13)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a9"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (int) r15)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a10"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (boolean) r11)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a11"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (int) r5)     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "a12"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6, (java.lang.String) r1, (boolean) r0)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r6)     // Catch:{ all -> 0x0223 }
        L_0x01d7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "static_enable="
            r0.<init>(r1)     // Catch:{ all -> 0x0223 }
            boolean r1 = f8616f     // Catch:{ all -> 0x0223 }
            r0.append(r1)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.ha.b()     // Catch:{ all -> 0x0223 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "bgp_enable="
            r0.<init>(r1)     // Catch:{ all -> 0x0223 }
            boolean r1 = f8618h     // Catch:{ all -> 0x0223 }
            r0.append(r1)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.ha.b()     // Catch:{ all -> 0x0223 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "static_ip_direct_enable="
            r0.<init>(r1)     // Catch:{ all -> 0x0223 }
            boolean r1 = f8617g     // Catch:{ all -> 0x0223 }
            r0.append(r1)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.ha.b()     // Catch:{ all -> 0x0223 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "bgp_ip_direct_enable="
            r0.<init>(r1)     // Catch:{ all -> 0x0223 }
            boolean r1 = f8619i     // Catch:{ all -> 0x0223 }
            r0.append(r1)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.ha.b()     // Catch:{ all -> 0x0223 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
            java.lang.String r1 = "perf_data_upload_enable="
            r0.<init>(r1)     // Catch:{ all -> 0x0223 }
            boolean r1 = f8620j     // Catch:{ all -> 0x0223 }
            r0.append(r1)     // Catch:{ all -> 0x0223 }
            com.amap.api.mapcore.util.ha.b()     // Catch:{ all -> 0x0223 }
            goto L_0x023c
        L_0x0223:
            r0 = move-exception
            goto L_0x0230
        L_0x0225:
            r0 = move-exception
            goto L_0x022e
        L_0x0227:
            r0 = move-exception
            goto L_0x022c
        L_0x0229:
            r0 = move-exception
            r17 = r4
        L_0x022c:
            r18 = r5
        L_0x022e:
            r19 = r6
        L_0x0230:
            java.lang.String r1 = "load 17S"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r1)
            goto L_0x023c
        L_0x0236:
            r17 = r4
            r18 = r5
            r19 = r6
        L_0x023c:
            java.lang.String r0 = "15K"
            boolean r1 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r1 == 0) goto L_0x02db
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x02d2 }
            if (r0 == 0) goto L_0x02db
            java.lang.String r1 = r0.optString(r9)     // Catch:{ all -> 0x02d2 }
            boolean r2 = com.amap.api.mapcore.util.ew.e.f8664a     // Catch:{ all -> 0x02d2 }
            boolean r1 = a((java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x02d2 }
            java.lang.String r2 = r0.optString(r8)     // Catch:{ all -> 0x02d2 }
            boolean r4 = com.amap.api.mapcore.util.ew.e.f8665b     // Catch:{ all -> 0x02d2 }
            boolean r2 = a((java.lang.String) r2, (boolean) r4)     // Catch:{ all -> 0x02d2 }
            java.lang.String r4 = r0.optString(r7)     // Catch:{ all -> 0x02d2 }
            boolean r5 = com.amap.api.mapcore.util.ew.e.f8666c     // Catch:{ all -> 0x02d2 }
            boolean r4 = a((java.lang.String) r4, (boolean) r5)     // Catch:{ all -> 0x02d2 }
            int r5 = com.amap.api.mapcore.util.ew.e.f8667d     // Catch:{ all -> 0x02d2 }
            r6 = r19
            int r5 = r0.optInt(r6, r5)     // Catch:{ all -> 0x02d2 }
            r11 = r18
            java.lang.String r12 = r0.optString(r11)     // Catch:{ all -> 0x02d2 }
            boolean r13 = com.amap.api.mapcore.util.ew.e.f8668e     // Catch:{ all -> 0x02d2 }
            boolean r12 = a((java.lang.String) r12, (boolean) r13)     // Catch:{ all -> 0x02d2 }
            int r13 = com.amap.api.mapcore.util.ew.e.f8669f     // Catch:{ all -> 0x02d2 }
            r15 = r17
            int r0 = r0.optInt(r15, r13)     // Catch:{ all -> 0x02d2 }
            boolean r13 = com.amap.api.mapcore.util.ew.e.f8664a     // Catch:{ all -> 0x02d2 }
            if (r1 != r13) goto L_0x029c
            boolean r13 = com.amap.api.mapcore.util.ew.e.f8665b     // Catch:{ all -> 0x02d2 }
            if (r2 != r13) goto L_0x029c
            boolean r13 = com.amap.api.mapcore.util.ew.e.f8666c     // Catch:{ all -> 0x02d2 }
            if (r4 != r13) goto L_0x029c
            int r13 = com.amap.api.mapcore.util.ew.e.f8667d     // Catch:{ all -> 0x02d2 }
            if (r5 != r13) goto L_0x029c
            boolean r13 = com.amap.api.mapcore.util.ew.e.f8668e     // Catch:{ all -> 0x02d2 }
            if (r12 != r13) goto L_0x029c
            int r13 = com.amap.api.mapcore.util.ew.e.f8667d     // Catch:{ all -> 0x02d2 }
            if (r0 == r13) goto L_0x02db
        L_0x029c:
            com.amap.api.mapcore.util.ew.e.f8664a = r1     // Catch:{ all -> 0x02d2 }
            com.amap.api.mapcore.util.ew.e.f8665b = r2     // Catch:{ all -> 0x02d2 }
            com.amap.api.mapcore.util.ew.e.f8666c = r4     // Catch:{ all -> 0x02d2 }
            com.amap.api.mapcore.util.ew.e.f8667d = r5     // Catch:{ all -> 0x02d2 }
            com.amap.api.mapcore.util.ew.e.f8668e = r12     // Catch:{ all -> 0x02d2 }
            com.amap.api.mapcore.util.ew.e.f8669f = r0     // Catch:{ all -> 0x02d2 }
            r1 = r20
            android.content.SharedPreferences$Editor r0 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r10)     // Catch:{ all -> 0x02d0 }
            boolean r2 = com.amap.api.mapcore.util.ew.e.f8664a     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r9, (boolean) r2)     // Catch:{ all -> 0x02d0 }
            boolean r2 = com.amap.api.mapcore.util.ew.e.f8665b     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r8, (boolean) r2)     // Catch:{ all -> 0x02d0 }
            boolean r2 = com.amap.api.mapcore.util.ew.e.f8666c     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r7, (boolean) r2)     // Catch:{ all -> 0x02d0 }
            int r2 = com.amap.api.mapcore.util.ew.e.f8667d     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r6, (int) r2)     // Catch:{ all -> 0x02d0 }
            boolean r2 = com.amap.api.mapcore.util.ew.e.f8668e     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r11, (boolean) r2)     // Catch:{ all -> 0x02d0 }
            int r2 = com.amap.api.mapcore.util.ew.e.f8669f     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0, (java.lang.String) r15, (int) r2)     // Catch:{ all -> 0x02d0 }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r0)     // Catch:{ all -> 0x02d0 }
            goto L_0x02dd
        L_0x02d0:
            goto L_0x02dd
        L_0x02d2:
            r0 = move-exception
            r1 = r20
            java.lang.String r2 = "load 15K"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r2)
            goto L_0x02dd
        L_0x02db:
            r1 = r20
        L_0x02dd:
            java.lang.String r0 = "183"
            boolean r2 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r2 == 0) goto L_0x02f5
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x02ef }
            r2 = r21
            com.amap.api.mapcore.util.gz.a((com.amap.api.mapcore.util.ff) r2, (org.json.JSONObject) r0)     // Catch:{ all -> 0x02ef }
            goto L_0x02f5
        L_0x02ef:
            r0 = move-exception
            java.lang.String r2 = "load 183"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r2)
        L_0x02f5:
            java.lang.String r0 = "17I"
            boolean r2 = com.amap.api.mapcore.util.fg.a((org.json.JSONObject) r3, (java.lang.String) r0)
            if (r2 == 0) goto L_0x0332
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ all -> 0x032c }
            java.lang.String r2 = "na"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x032c }
            r3 = 0
            boolean r2 = a((java.lang.String) r2, (boolean) r3)     // Catch:{ all -> 0x032c }
            java.lang.String r4 = "aa"
            java.lang.String r0 = r0.optString(r4)     // Catch:{ all -> 0x032c }
            boolean r0 = a((java.lang.String) r0, (boolean) r3)     // Catch:{ all -> 0x032c }
            com.amap.api.mapcore.util.fv.f8848d = r2     // Catch:{ all -> 0x032c }
            com.amap.api.mapcore.util.fv.f8849e = r0     // Catch:{ all -> 0x032c }
            android.content.SharedPreferences$Editor r1 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r10)     // Catch:{ all -> 0x032c }
            java.lang.String r3 = "a4"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r1, (java.lang.String) r3, (boolean) r2)     // Catch:{ all -> 0x032c }
            java.lang.String r2 = "a5"
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r1, (java.lang.String) r2, (boolean) r0)     // Catch:{ all -> 0x032c }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r1)     // Catch:{ all -> 0x032c }
            return
        L_0x032c:
            r0 = move-exception
            java.lang.String r1 = "load 17I"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r14, (java.lang.String) r1)
        L_0x0332:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.a(android.content.Context, com.amap.api.mapcore.util.ff, java.lang.String, com.amap.api.mapcore.util.ew$a, org.json.JSONObject):void");
    }

    private static void a(Context context, ff ffVar, Throwable th) {
        a(context, ffVar, th.getMessage());
    }

    public static void a(Context context, String str) {
        ev.a(context, str);
    }

    private static void a(Context context, String str, String str2, d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.f8661a)) {
            String b2 = dVar.b();
            if (!TextUtils.isEmpty(b2) && context != null) {
                SharedPreferences.Editor a2 = gb.a(context, str2);
                a2.putString(str, b2);
                gb.a(a2);
            }
        }
    }

    private static void a(ff ffVar) {
        if (ffVar != null) {
            try {
                if (!TextUtils.isEmpty(ffVar.a())) {
                    String c2 = ffVar.c();
                    if (TextUtils.isEmpty(c2)) {
                        c2 = ffVar.b();
                    }
                    if (!TextUtils.isEmpty(c2)) {
                        fv.a(ffVar.a(), c2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(ha.c cVar) {
        if (cVar != null && f8613c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("serverip", cVar.f9055c);
            hashMap.put("hostname", cVar.f9057e);
            hashMap.put(GLImage.KEY_PATH, cVar.f9056d);
            hashMap.put("csid", cVar.f9053a);
            hashMap.put("degrade", String.valueOf(cVar.f9054b.a()));
            hashMap.put("errorcode", String.valueOf(cVar.f9065m));
            hashMap.put("errorsubcode", String.valueOf(cVar.f9066n));
            hashMap.put("connecttime", String.valueOf(cVar.f9060h));
            hashMap.put("writetime", String.valueOf(cVar.f9061i));
            hashMap.put("readtime", String.valueOf(cVar.f9062j));
            hashMap.put("datasize", String.valueOf(cVar.f9064l));
            hashMap.put("totaltime", String.valueOf(cVar.f9058f));
            String jSONObject = new JSONObject(hashMap).toString();
            "--埋点--".concat(String.valueOf(jSONObject));
            ha.b();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    hl hlVar = new hl(f8613c, "core", "2.0", "O008");
                    hlVar.a(jSONObject);
                    hm.a(hlVar, f8613c);
                } catch (eu unused) {
                }
            }
        }
    }

    private static void a(String str, String str2) {
        d a2 = a(f8613c, str, str2);
        String a3 = fg.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.f8662b)) {
            a2.a(a3);
            a2.f8663c.set(0);
        }
        a2.f8663c.incrementAndGet();
        a(f8613c, str, str2, a2);
    }

    public static synchronized void a(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (ew.class) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (f8631u == null) {
                        f8631u = new ConcurrentHashMap<>(8);
                    }
                    f8631u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    if (f8632v != null) {
                        if (f8632v.containsKey(str)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (z2) {
                                    gz.a(true, str);
                                }
                                id.a().a(new ie() {
                                    public final void runTask() {
                                        c cVar = (c) ew.f8632v.get(str);
                                        if (cVar != null) {
                                            ew.a(ew.f8613c, cVar.f8659a, cVar.f8660b, str2, str3, str4);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                fw.a(th, "at", "lca");
            }
        }
    }

    public static void a(String str, boolean z2, boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && f8613c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", ez.p(f8613c) == 0 ? str2 : "1");
            hashMap.put("type", z4 ? z2 ? f8623m : f8624n : z2 ? f8621k : f8622l);
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    hl hlVar = new hl(f8613c, "core", "2.0", "O002");
                    hlVar.a(jSONObject);
                    hm.a(hlVar, f8613c);
                } catch (eu unused) {
                }
            }
        }
    }

    public static void a(boolean z2, ha.a aVar) {
        if (C && aVar != null) {
            synchronized (B) {
                if (z2) {
                    Iterator<ha.a> it2 = B.iterator();
                    while (it2.hasNext()) {
                        ha.a next = it2.next();
                        if (next.f9042b.equals(aVar.f9042b) && next.f9045e.equals(aVar.f9045e) && next.f9046f == aVar.f9046f) {
                            if (next.f9050j == aVar.f9050j) {
                                it2.remove();
                            } else {
                                next.f9050j.set(next.f9050j.get() - aVar.f9050j.get());
                            }
                            ha.b();
                        }
                    }
                }
                C = false;
                Iterator<ha.a> it3 = B.iterator();
                while (true) {
                    ha.b();
                    if (it3.hasNext()) {
                        ha.a next2 = it3.next();
                        StringBuilder sb = new StringBuilder("----path=");
                        sb.append(next2.f9045e);
                        sb.append("-counts=");
                        sb.append(next2.f9050j);
                        sb.append("-code=");
                        sb.append(next2.f9046f);
                        sb.append("----");
                    } else {
                        ha.b();
                    }
                }
            }
        }
    }

    public static void a(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            ha.b();
            if (!f8616f && !z2) {
                return;
            }
            if ((!f8619i && z2) || TextUtils.isEmpty(str)) {
                return;
            }
            if (!z2) {
                if (f8636z.get(str) == null) {
                    f8636z.put(str, Boolean.TRUE);
                    a(b(str, "a14"), "open_common");
                }
            } else if (A.get(str) == null) {
                A.put(str, Boolean.TRUE);
                a(b(str, "a15"), "open_common");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r0 = a(f8613c, "IPV6_CONFIG_NAME", "open_common");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            android.content.Context r0 = f8613c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            h()
            boolean r0 = b()
            if (r0 != 0) goto L_0x0010
            return r2
        L_0x0010:
            boolean r0 = i()
            if (r0 == 0) goto L_0x0017
            return r1
        L_0x0017:
            boolean r0 = f8625o
            if (r0 != 0) goto L_0x001c
            return r2
        L_0x001c:
            android.content.Context r0 = f8613c
            java.lang.String r3 = "IPV6_CONFIG_NAME"
            java.lang.String r4 = "open_common"
            com.amap.api.mapcore.util.ew$d r0 = a((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r4)
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r0.a()
            r3 = 5
            if (r0 >= r3) goto L_0x0031
            return r1
        L_0x0031:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.a():boolean");
    }

    public static synchronized boolean a(String str) {
        synchronized (ew.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (f8632v == null) {
                    return false;
                }
                if (f8631u == null) {
                    f8631u = new ConcurrentHashMap<>(8);
                }
                if (f8632v.containsKey(str) && !f8631u.containsKey(str)) {
                    f8631u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    return true;
                }
            } catch (Throwable th) {
                fw.a(th, "at", "cslct");
            }
        }
        return false;
    }

    public static synchronized boolean a(String str, long j2) {
        boolean z2;
        synchronized (ew.class) {
            z2 = false;
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (j2 > c(str)) {
                    long j3 = 0;
                    if (f8631u != null && f8631u.containsKey(str)) {
                        j3 = f8631u.get(str).longValue();
                    }
                    if (SystemClock.elapsedRealtime() - j3 > 30000) {
                        z2 = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z2;
    }

    public static boolean a(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z2;
        }
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static a b(Context context, ff ffVar, String str, Map<String, String> map) {
        return a(context, ffVar, str, map, (String) null, (String) null, (String) null);
    }

    private static String b(String str, String str2) {
        String a2 = fd.a(str.getBytes());
        return str2 + "_" + a2;
    }

    private static void b(Context context) {
        if (context != null) {
            f8625o = gb.a(context, "open_common", "a2", true);
        }
    }

    public static void b(ha.c cVar) {
        synchronized (B) {
            boolean z2 = false;
            for (int i2 = 0; i2 < B.size(); i2++) {
                ha.a aVar = B.get(i2);
                if (cVar.f9055c.equals(aVar.f9042b) && cVar.f9056d.equals(aVar.f9045e) && cVar.f9065m == aVar.f9046f) {
                    if (aVar.f9046f == 1) {
                        aVar.f9049i = ((((long) aVar.f9050j.get()) * aVar.f9049i) + cVar.f9058f) / ((long) (aVar.f9050j.get() + 1));
                    }
                    aVar.f9050j.getAndIncrement();
                    z2 = true;
                }
            }
            if (!z2) {
                B.add(new ha.a(cVar));
            }
            ha.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(java.lang.String r2) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.ew> r0 = com.amap.api.mapcore.util.ew.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = f8631u     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = f8631u     // Catch:{ all -> 0x0018 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0016
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = f8631u     // Catch:{ all -> 0x0018 }
            r1.remove(r2)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.b(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void b(java.lang.String r3, long r4) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.ew> r0 = com.amap.api.mapcore.util.ew.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.ew$c> r1 = f8632v     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0038
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.ew$c> r1 = f8632v     // Catch:{ all -> 0x003a }
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0010
            goto L_0x0038
        L_0x0010:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = f8630t     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x001d
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x003a }
            r2 = 8
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            f8630t = r1     // Catch:{ all -> 0x003a }
        L_0x001d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r1 = f8630t     // Catch:{ all -> 0x003a }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x003a }
            r1.put(r3, r2)     // Catch:{ all -> 0x003a }
            android.content.Context r1 = f8613c     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0036
            java.lang.String r2 = "open_common"
            android.content.SharedPreferences$Editor r1 = com.amap.api.mapcore.util.gb.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x003a }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r1, (java.lang.String) r3, (long) r4)     // Catch:{ all -> 0x003a }
            com.amap.api.mapcore.util.gb.a((android.content.SharedPreferences.Editor) r1)     // Catch:{ all -> 0x003a }
        L_0x0036:
            monitor-exit(r0)
            return
        L_0x0038:
            monitor-exit(r0)
            return
        L_0x003a:
            r3 = move-exception
            java.lang.String r4 = "at"
            java.lang.String r5 = "ucut"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.b(java.lang.String, long):void");
    }

    public static synchronized void b(String str, boolean z2) {
        synchronized (ew.class) {
            a(str, z2, (String) null, (String) null, (String) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = f8627q.get(r0.toUpperCase());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            android.content.Context r0 = f8613c
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = com.amap.api.mapcore.util.ez.s(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0011
            return r1
        L_0x0011:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = f8627q
            java.lang.String r0 = r0.toUpperCase()
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x0020
            return r1
        L_0x0020:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 < r2) goto L_0x0029
            r0 = 1
            return r0
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.b():boolean");
    }

    public static synchronized long c(String str) {
        synchronized (ew.class) {
            try {
                if (f8630t == null) {
                    f8630t = new ConcurrentHashMap<>(8);
                }
                if (f8630t.containsKey(str)) {
                    long longValue = f8630t.get(str).longValue();
                    return longValue;
                }
            } catch (Throwable th) {
                fw.a(th, "at", "glcut");
            }
            return 0;
        }
    }

    public static void c() {
        try {
            d a2 = a(f8613c, "IPV6_CONFIG_NAME", "open_common");
            String a3 = fg.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.f8662b)) {
                a2.a(a3);
                a2.f8663c.set(0);
            }
            a2.f8663c.incrementAndGet();
            a(f8613c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        if (context != null) {
            f8616f = gb.a(context, "open_common", "a13", true);
            f8618h = gb.a(context, "open_common", "a6", true);
            f8617g = gb.a(context, "open_common", "a7", false);
            f8615e = gb.a(context, "open_common", "a8", 5000);
            f8634x = gb.a(context, "open_common", "a9", 3);
            f8619i = gb.a(context, "open_common", "a10", false);
            f8635y = gb.a(context, "open_common", "a11", 3);
            f8620j = gb.a(context, "open_common", "a12", false);
        }
    }

    public static void c(ha.c cVar) {
        if (cVar != null && f8620j) {
            synchronized (D) {
                D.offer(cVar);
                ha.b();
            }
        }
    }

    public static void d() {
        if (!f8614d) {
            try {
                Context context = f8613c;
                if (context != null) {
                    f8614d = true;
                    fb.a().a(context);
                    b(context);
                    c(context);
                    e.f8664a = gb.a(context, "open_common", "ucf", e.f8664a);
                    e.f8665b = gb.a(context, "open_common", "fsv2", e.f8665b);
                    e.f8666c = gb.a(context, "open_common", "usc", e.f8666c);
                    e.f8667d = gb.a(context, "open_common", "umv", e.f8667d);
                    e.f8668e = gb.a(context, "open_common", "ust", e.f8668e);
                    e.f8669f = gb.a(context, "open_common", "ustv", e.f8669f);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void d(Context context) {
        try {
            if (!f8633w) {
                fv.f8848d = gb.a(context, "open_common", "a4", true);
                fv.f8849e = gb.a(context, "open_common", "a5", true);
                f8633w = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean d(String str) {
        d a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f8616f) {
                return false;
            }
            if (!(f8636z.get(str) == null)) {
                return false;
            }
            Context context = f8613c;
            return context == null || (a2 = a(context, b(str, "a14"), "open_common")) == null || a2.a() < f8634x;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static ha.a e() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            Collections.sort(B);
            if (B.size() <= 0) {
                return null;
            }
            ha.a a2 = B.get(0).clone();
            C = true;
            return a2;
        }
    }

    public static boolean e(String str) {
        d a2;
        try {
            if (TextUtils.isEmpty(str) || !f8619i) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = f8613c;
            return context == null || (a2 = a(context, b(str, "a15"), "open_common")) == null || a2.a() < f8635y;
        } catch (Throwable unused) {
        }
    }

    public static ha.c f() {
        synchronized (D) {
            ha.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void h() {
        Map<String, Integer> map;
        String str;
        Integer valueOf;
        try {
            Context context = f8613c;
            if (context != null) {
                String s2 = ez.s(context);
                if (!TextUtils.isEmpty(f8628r) && !TextUtils.isEmpty(s2) && f8628r.equals(s2) && System.currentTimeMillis() - f8629s < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(s2)) {
                    f8628r = s2;
                }
            } else if (System.currentTimeMillis() - f8629s < 10000) {
                return;
            }
            f8629s = System.currentTimeMillis();
            f8627q.clear();
            Iterator<T> it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it2.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it2.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                        InetAddress address2 = address.getAddress();
                        if (address2 instanceof Inet6Address) {
                            if (!a((InetAddress) (Inet6Address) address2)) {
                                i2 |= 2;
                            }
                        } else if (address2 instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address2;
                            if (!a((InetAddress) inet4Address) && !inet4Address.getHostAddress().startsWith(fg.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            map = f8627q;
                            str = "WIFI";
                            valueOf = Integer.valueOf(i2);
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            map = f8627q;
                            str = "MOBILE";
                            valueOf = Integer.valueOf(i2);
                        }
                        map.put(str, valueOf);
                    }
                }
            }
        } catch (Throwable th) {
            fw.a(th, "at", "ipstack");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = f8627q.get(r0.toUpperCase());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean i() {
        /*
            android.content.Context r0 = f8613c
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = com.amap.api.mapcore.util.ez.s(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0011
            return r1
        L_0x0011:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = f8627q
            java.lang.String r0 = r0.toUpperCase()
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x0020
            return r1
        L_0x0020:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x0029
            r0 = 1
            return r0
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ew.i():boolean");
    }
}
