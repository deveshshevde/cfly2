package com.amap.api.mapcore.util;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.ArrayList;

public final class im {
    protected static String J;
    protected static String L;
    protected String A = null;
    protected String B = null;
    protected ArrayList<jq> C = new ArrayList<>();
    protected String D = null;
    protected String E = null;
    protected ArrayList<ScanResult> F = new ArrayList<>();
    protected String G = null;
    protected String H = null;
    protected byte[] I = null;
    protected String K = null;
    protected String M = null;
    protected String N = null;
    protected String O = null;
    private byte[] P = null;
    private int Q = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f9275a = "1";

    /* renamed from: b  reason: collision with root package name */
    protected short f9276b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected String f9277c = null;

    /* renamed from: d  reason: collision with root package name */
    protected String f9278d = null;

    /* renamed from: e  reason: collision with root package name */
    protected String f9279e = null;

    /* renamed from: f  reason: collision with root package name */
    protected String f9280f = null;

    /* renamed from: g  reason: collision with root package name */
    protected String f9281g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f9282h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f9283i = null;

    /* renamed from: j  reason: collision with root package name */
    protected String f9284j = null;

    /* renamed from: k  reason: collision with root package name */
    protected String f9285k = null;

    /* renamed from: l  reason: collision with root package name */
    protected String f9286l = null;

    /* renamed from: m  reason: collision with root package name */
    protected String f9287m = null;

    /* renamed from: n  reason: collision with root package name */
    protected String f9288n = null;

    /* renamed from: o  reason: collision with root package name */
    protected String f9289o = null;

    /* renamed from: p  reason: collision with root package name */
    protected String f9290p = null;

    /* renamed from: q  reason: collision with root package name */
    protected String f9291q = null;

    /* renamed from: r  reason: collision with root package name */
    protected String f9292r = null;

    /* renamed from: s  reason: collision with root package name */
    protected String f9293s = null;

    /* renamed from: t  reason: collision with root package name */
    protected String f9294t = null;

    /* renamed from: u  reason: collision with root package name */
    protected String f9295u = null;

    /* renamed from: v  reason: collision with root package name */
    protected String f9296v = null;

    /* renamed from: w  reason: collision with root package name */
    protected String f9297w = null;

    /* renamed from: x  reason: collision with root package name */
    protected String f9298x = null;

    /* renamed from: y  reason: collision with root package name */
    protected String f9299y = null;

    /* renamed from: z  reason: collision with root package name */
    protected int f9300z = 0;

    private static int a(String str, byte[] bArr, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i2] = 0;
                return i2 + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i2] = (byte) length;
            int i3 = i2 + 1;
            System.arraycopy(bytes, 0, bArr, i3, length);
            return i3 + length;
        } catch (Throwable th) {
            io.a(th, "Req", "copyContentWithByteLen");
            bArr[i2] = 0;
        }
    }

    private String a(String str, int i2) {
        String[] split = this.B.split("\\*")[i2].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L_0x000f
            int r4 = r0.length     // Catch:{ all -> 0x003e }
            if (r4 == r1) goto L_0x001b
        L_0x000f:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x003e }
            r4 = 0
        L_0x0012:
            if (r4 >= r1) goto L_0x001b
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch:{ all -> 0x003e }
            int r4 = r4 + 1
            goto L_0x0012
        L_0x001b:
            r1 = 0
        L_0x001c:
            int r4 = r0.length     // Catch:{ all -> 0x003e }
            if (r1 >= r4) goto L_0x0054
            r4 = r0[r1]     // Catch:{ all -> 0x003e }
            int r4 = r4.length()     // Catch:{ all -> 0x003e }
            r5 = 2
            if (r4 <= r5) goto L_0x0030
            r4 = r0[r1]     // Catch:{ all -> 0x003e }
            java.lang.String r4 = r4.substring(r3, r5)     // Catch:{ all -> 0x003e }
            r0[r1] = r4     // Catch:{ all -> 0x003e }
        L_0x0030:
            r4 = r0[r1]     // Catch:{ all -> 0x003e }
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch:{ all -> 0x003e }
            byte r4 = (byte) r4     // Catch:{ all -> 0x003e }
            r2[r1] = r4     // Catch:{ all -> 0x003e }
            int r1 = r1 + 1
            goto L_0x001c
        L_0x003e:
            r0 = move-exception
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.amap.api.mapcore.util.io.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.im.a(java.lang.String):byte[]");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(this.A)) {
            return "0";
        }
        String str2 = this.A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + ">");
        return this.A.substring(indexOf + str.length() + 1, this.A.indexOf("</".concat(String.valueOf(str))));
    }

    private void b() {
        String[] strArr = {this.f9275a, this.f9277c, this.f9278d, this.f9279e, this.f9280f, this.f9281g, this.f9282h, this.f9283i, this.f9286l, this.f9287m, this.f9288n, this.f9289o, this.f9290p, this.f9291q, this.f9292r, this.f9293s, this.f9294t, this.f9295u, this.f9296v, this.f9297w, this.f9298x, this.A, this.B, this.E, this.G, this.H, J, this.N, this.O};
        for (int i2 = 0; i2 < 29; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                strArr[i2] = "";
            }
        }
        if (TextUtils.isEmpty(this.f9284j) || (!"0".equals(this.f9284j) && !"2".equals(this.f9284j))) {
            this.f9284j = "0";
        }
        if (TextUtils.isEmpty(this.f9285k) || (!"0".equals(this.f9285k) && !"1".equals(this.f9285k))) {
            this.f9285k = "0";
        }
        if (TextUtils.isEmpty(this.f9299y) || (!"1".equals(this.f9299y) && !"2".equals(this.f9299y))) {
            this.f9299y = "0";
        }
        if (!jr.a(this.f9300z)) {
            this.f9300z = 0;
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(9:10|(2:12|13)|16|17|(1:21)|22|(2:24|25)|29|(1:33))(1:34)|(2:35|36)|39|(2:41|(1:43)(1:44))(1:45)|46|(3:48|(2:50|(1:52)(3:53|(1:57)|58))(3:59|(4:62|(2:64|123)(1:124)|65|60)|122)|66)(1:67)|68|(1:73)(1:72)|74|(2:(2:77|(7:79|(1:81)|84|85|86|(1:90)|91))|(1:95))(2:96|(1:98))|99|(1:101)|102|103|104|(1:106)|107|108|(1:110)|111|112|(1:114)|115|116|(1:118)|119|121) */
    /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(9:10|(2:12|13)|16|17|(1:21)|22|(2:24|25)|29|(1:33))(1:34)|35|36|39|(2:41|(1:43)(1:44))(1:45)|46|(3:48|(2:50|(1:52)(3:53|(1:57)|58))(3:59|(4:62|(2:64|123)(1:124)|65|60)|122)|66)(1:67)|68|(1:73)(1:72)|74|(2:(2:77|(7:79|(1:81)|84|85|86|(1:90)|91))|(1:95))(2:96|(1:98))|99|(1:101)|102|103|104|(1:106)|107|108|(1:110)|111|112|(1:114)|115|116|(1:118)|119|121) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0336 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x0344 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0352 */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x033e A[Catch:{ all -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x034c A[Catch:{ all -> 0x0352 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x035a A[Catch:{ all -> 0x0360 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r25, boolean r26, boolean r27, com.amap.api.mapcore.util.jr r28, com.amap.api.mapcore.util.ii r29, android.net.ConnectivityManager r30, java.lang.String r31) {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = com.amap.api.mapcore.util.ev.f(r25)
            int r3 = com.amap.api.mapcore.util.is.d()
            r0 = r31
            r1.K = r0
            if (r27 != 0) goto L_0x0015
            java.lang.String r0 = "UC_nlp_20131029"
            java.lang.String r4 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U"
            goto L_0x0019
        L_0x0015:
            java.lang.String r0 = "api_serverSDK_130905"
            java.lang.String r4 = "S128DF1572465B890OE3F7A13167KLEI"
        L_0x0019:
            r5 = r4
            r4 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r28.e()
            int r8 = r28.f()
            android.telephony.TelephonyManager r9 = r28.g()
            java.util.ArrayList r10 = r28.c()
            java.util.ArrayList r11 = r28.d()
            java.util.ArrayList r12 = r29.a()
            java.lang.String r13 = "1"
            r14 = 2
            java.lang.String r15 = "0"
            if (r8 != r14) goto L_0x0042
            r16 = r13
            goto L_0x0044
        L_0x0042:
            r16 = r15
        L_0x0044:
            java.lang.String r14 = "Aps"
            if (r9 == 0) goto L_0x009e
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9333g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = com.amap.api.mapcore.util.ez.u(r25)     // Catch:{ all -> 0x0057 }
            com.amap.api.mapcore.util.io.f9333g = r0     // Catch:{ all -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r0 = move-exception
            r31 = r13
            java.lang.String r13 = "getApsReq part4"
            com.amap.api.mapcore.util.io.a(r0, r14, r13)
            goto L_0x0062
        L_0x0060:
            r31 = r13
        L_0x0062:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9333g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r13 = "888888888888888"
            r17 = r3
            r3 = 29
            if (r0 == 0) goto L_0x0076
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x0076
            com.amap.api.mapcore.util.io.f9333g = r13
        L_0x0076:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9334h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x008d
            java.lang.String r0 = com.amap.api.mapcore.util.ez.x(r25)     // Catch:{ SecurityException -> 0x008c, all -> 0x0085 }
            com.amap.api.mapcore.util.io.f9334h = r0     // Catch:{ SecurityException -> 0x008c, all -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            r0 = move-exception
            java.lang.String r3 = "getApsReq part2"
            com.amap.api.mapcore.util.io.a(r0, r14, r3)
            goto L_0x008d
        L_0x008c:
        L_0x008d:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9334h
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a2
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r0 >= r3) goto L_0x00a2
            com.amap.api.mapcore.util.io.f9334h = r13
            goto L_0x00a2
        L_0x009e:
            r17 = r3
            r31 = r13
        L_0x00a2:
            android.net.NetworkInfo r0 = r30.getActiveNetworkInfo()     // Catch:{ all -> 0x00a7 }
            goto L_0x00af
        L_0x00a7:
            r0 = move-exception
            r13 = r0
            java.lang.String r0 = "getApsReq part"
            com.amap.api.mapcore.util.io.a(r13, r14, r0)
            r0 = 0
        L_0x00af:
            boolean r13 = r29.a((android.net.ConnectivityManager) r30)
            int r0 = com.amap.api.mapcore.util.is.a((android.net.NetworkInfo) r0)
            r14 = -1
            java.lang.String r3 = ""
            if (r0 == r14) goto L_0x00c8
            java.lang.String r0 = com.amap.api.mapcore.util.is.b((android.telephony.TelephonyManager) r9)
            if (r13 == 0) goto L_0x00c5
            java.lang.String r9 = "2"
            goto L_0x00ca
        L_0x00c5:
            r9 = r31
            goto L_0x00ca
        L_0x00c8:
            r0 = r3
            r9 = r0
        L_0x00ca:
            boolean r14 = r10.isEmpty()
            r30 = r9
            java.lang.String r9 = "*"
            r31 = r0
            java.lang.String r0 = ","
            r18 = r3
            if (r14 != 0) goto L_0x020a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r3 = "</signal>"
            r19 = r2
            java.lang.String r2 = "<signal>"
            r20 = r15
            java.lang.String r15 = "</mcc>"
            r21 = r5
            java.lang.String r5 = "<mcc>"
            r22 = r4
            r4 = 1
            if (r8 == r4) goto L_0x017a
            r4 = 2
            if (r8 == r4) goto L_0x00fb
            r23 = r12
            r2 = r18
            goto L_0x0201
        L_0x00fb:
            r4 = 0
            java.lang.Object r8 = r10.get(r4)
            com.amap.api.mapcore.util.jq r8 = (com.amap.api.mapcore.util.jq) r8
            int r10 = r14.length()
            r14.delete(r4, r10)
            r14.append(r5)
            int r4 = r8.f9494a
            r14.append(r4)
            r14.append(r15)
            java.lang.String r4 = "<sid>"
            r14.append(r4)
            int r4 = r8.f9501h
            r14.append(r4)
            java.lang.String r4 = "</sid>"
            r14.append(r4)
            java.lang.String r4 = "<nid>"
            r14.append(r4)
            int r4 = r8.f9502i
            r14.append(r4)
            java.lang.String r4 = "</nid>"
            r14.append(r4)
            java.lang.String r4 = "<bid>"
            r14.append(r4)
            int r4 = r8.f9503j
            r14.append(r4)
            java.lang.String r4 = "</bid>"
            r14.append(r4)
            int r4 = r8.f9500g
            if (r4 <= 0) goto L_0x0167
            int r4 = r8.f9499f
            if (r4 <= 0) goto L_0x0167
            java.lang.String r4 = "<lon>"
            r14.append(r4)
            int r4 = r8.f9500g
            r14.append(r4)
            java.lang.String r4 = "</lon>"
            r14.append(r4)
            java.lang.String r4 = "<lat>"
            r14.append(r4)
            int r4 = r8.f9499f
            r14.append(r4)
            java.lang.String r4 = "</lat>"
            r14.append(r4)
        L_0x0167:
            r14.append(r2)
            int r2 = r8.f9504k
            r14.append(r2)
            r14.append(r3)
            java.lang.String r2 = r14.toString()
            r23 = r12
            goto L_0x0201
        L_0x017a:
            r4 = 0
            java.lang.Object r8 = r10.get(r4)
            com.amap.api.mapcore.util.jq r8 = (com.amap.api.mapcore.util.jq) r8
            r23 = r12
            int r12 = r14.length()
            r14.delete(r4, r12)
            r14.append(r5)
            int r4 = r8.f9494a
            r14.append(r4)
            r14.append(r15)
            java.lang.String r4 = "<mnc>"
            r14.append(r4)
            int r4 = r8.f9495b
            r14.append(r4)
            java.lang.String r4 = "</mnc>"
            r14.append(r4)
            java.lang.String r4 = "<lac>"
            r14.append(r4)
            int r4 = r8.f9496c
            r14.append(r4)
            java.lang.String r4 = "</lac>"
            r14.append(r4)
            java.lang.String r4 = "<cellid>"
            r14.append(r4)
            int r4 = r8.f9497d
            r14.append(r4)
            java.lang.String r4 = "</cellid>"
            r14.append(r4)
            r14.append(r2)
            int r2 = r8.f9504k
            r14.append(r2)
            r14.append(r3)
            java.lang.String r2 = r14.toString()
            r3 = 1
        L_0x01d2:
            int r4 = r10.size()
            if (r3 >= r4) goto L_0x0201
            java.lang.Object r4 = r10.get(r3)
            com.amap.api.mapcore.util.jq r4 = (com.amap.api.mapcore.util.jq) r4
            int r5 = r4.f9496c
            r6.append(r5)
            r6.append(r0)
            int r5 = r4.f9497d
            r6.append(r5)
            r6.append(r0)
            int r4 = r4.f9504k
            r6.append(r4)
            int r4 = r10.size()
            r5 = 1
            int r4 = r4 - r5
            if (r3 >= r4) goto L_0x01fe
            r6.append(r9)
        L_0x01fe:
            int r3 = r3 + 1
            goto L_0x01d2
        L_0x0201:
            int r3 = r14.length()
            r4 = 0
            r14.delete(r4, r3)
            goto L_0x0216
        L_0x020a:
            r19 = r2
            r22 = r4
            r21 = r5
            r23 = r12
            r20 = r15
            r2 = r18
        L_0x0216:
            r3 = r7 & 4
            r4 = 4
            if (r3 != r4) goto L_0x022c
            boolean r3 = r11.isEmpty()
            if (r3 != 0) goto L_0x022c
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r3 = r1.C
            r3.clear()
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r3 = r1.C
            r3.addAll(r11)
            goto L_0x0231
        L_0x022c:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r3 = r1.C
            r3.clear()
        L_0x0231:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            boolean r4 = r29.e()
            if (r4 == 0) goto L_0x0299
            if (r13 == 0) goto L_0x0288
            android.net.wifi.WifiInfo r4 = r29.f()
            boolean r5 = com.amap.api.mapcore.util.ii.a((android.net.wifi.WifiInfo) r4)
            if (r5 == 0) goto L_0x0288
            java.lang.String r5 = r4.getBSSID()
            r3.append(r5)
            r3.append(r0)
            int r5 = r4.getRssi()
            r8 = -128(0xffffffffffffff80, float:NaN)
            if (r5 >= r8) goto L_0x025c
        L_0x025a:
            r5 = 0
            goto L_0x0261
        L_0x025c:
            r8 = 127(0x7f, float:1.78E-43)
            if (r5 <= r8) goto L_0x0261
            goto L_0x025a
        L_0x0261:
            r3.append(r5)
            r3.append(r0)
            java.lang.String r0 = r4.getSSID()
            r5 = 32
            java.lang.String r4 = r4.getSSID()     // Catch:{ Exception -> 0x0279 }
            java.lang.String r8 = "UTF-8"
            byte[] r4 = r4.getBytes(r8)     // Catch:{ Exception -> 0x0279 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0279 }
            goto L_0x027b
        L_0x0279:
            r4 = 32
        L_0x027b:
            if (r4 < r5) goto L_0x027f
            java.lang.String r0 = "unkwn"
        L_0x027f:
            java.lang.String r4 = "."
            java.lang.String r0 = r0.replace(r9, r4)
            r3.append(r0)
        L_0x0288:
            if (r23 == 0) goto L_0x02a3
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.F
            if (r0 == 0) goto L_0x02a3
            r0.clear()
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.F
            r4 = r23
            r0.addAll(r4)
            goto L_0x02a3
        L_0x0299:
            r29.b()
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.F
            if (r0 == 0) goto L_0x02a3
            r0.clear()
        L_0x02a3:
            r0 = 0
            r1.f9276b = r0
            if (r26 != 0) goto L_0x02ad
            r4 = 2
            r4 = r4 | r0
            short r0 = (short) r4
            r1.f9276b = r0
        L_0x02ad:
            r4 = r22
            r1.f9277c = r4
            r4 = r21
            r1.f9278d = r4
            java.lang.String r0 = android.os.Build.MODEL
            r1.f9280f = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "android"
            r0.<init>(r4)
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r1.f9281g = r0
            java.lang.String r0 = com.amap.api.mapcore.util.is.b((android.content.Context) r25)
            r1.f9282h = r0
            r13 = r16
            r1.f9283i = r13
            r4 = r20
            r1.f9284j = r4
            r1.f9285k = r4
            r1.f9286l = r4
            r1.f9287m = r4
            r1.f9288n = r4
            r4 = r19
            r1.f9289o = r4
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9333g
            r1.f9290p = r0
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9334h
            r1.f9291q = r0
            java.lang.String r0 = java.lang.String.valueOf(r17)
            r1.f9293s = r0
            java.lang.String r0 = com.amap.api.mapcore.util.is.d((android.content.Context) r25)
            r1.f9294t = r0
            java.lang.String r0 = "5.3.1"
            r1.f9296v = r0
            r4 = 0
            r1.f9297w = r4
            r0 = r18
            r1.f9295u = r0
            r0 = r31
            r1.f9298x = r0
            r9 = r30
            r1.f9299y = r9
            r1.f9300z = r7
            r1.A = r2
            java.lang.String r0 = r6.toString()
            r1.B = r0
            java.lang.String r0 = r28.j()
            r1.D = r0
            java.lang.String r0 = com.amap.api.mapcore.util.ii.i()
            r1.G = r0
            java.lang.String r0 = r3.toString()
            r1.E = r0
            java.lang.String r0 = J     // Catch:{ all -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0336 }
            if (r0 == 0) goto L_0x0336
            java.lang.String r0 = com.amap.api.mapcore.util.ez.h(r25)     // Catch:{ all -> 0x0336 }
            J = r0     // Catch:{ all -> 0x0336 }
        L_0x0336:
            java.lang.String r0 = L     // Catch:{ all -> 0x0344 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0344 }
            if (r0 == 0) goto L_0x0344
            java.lang.String r0 = com.amap.api.mapcore.util.ez.a((android.content.Context) r25)     // Catch:{ all -> 0x0344 }
            L = r0     // Catch:{ all -> 0x0344 }
        L_0x0344:
            java.lang.String r0 = r1.N     // Catch:{ all -> 0x0352 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0352 }
            if (r0 == 0) goto L_0x0352
            java.lang.String r0 = com.amap.api.mapcore.util.ez.i(r25)     // Catch:{ all -> 0x0352 }
            r1.N = r0     // Catch:{ all -> 0x0352 }
        L_0x0352:
            java.lang.String r0 = r1.O     // Catch:{ all -> 0x0360 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0360 }
            if (r0 == 0) goto L_0x0360
            java.lang.String r0 = com.amap.api.mapcore.util.ez.g(r25)     // Catch:{ all -> 0x0360 }
            r1.O = r0     // Catch:{ all -> 0x0360 }
        L_0x0360:
            int r0 = r6.length()
            r2 = 0
            r6.delete(r2, r0)
            int r0 = r3.length()
            r3.delete(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.im.a(android.content.Context, boolean, boolean, com.amap.api.mapcore.util.jr, com.amap.api.mapcore.util.ii, android.net.ConnectivityManager, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x048a A[Catch:{ all -> 0x044f, all -> 0x0497 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0586 A[Catch:{ all -> 0x059b }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0589 A[Catch:{ all -> 0x059b }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x058d A[Catch:{ all -> 0x059b }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x05ad A[Catch:{ all -> 0x05cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05bf A[SYNTHETIC, Splitter:B:208:0x05bf] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x05e5  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x05f6  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0643  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x03fd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x023b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "Req"
            r26.b()
            r3 = 2
            byte[] r4 = new byte[r3]
            r5 = 4
            byte[] r6 = new byte[r5]
            byte[] r0 = r1.I
            r7 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            if (r0 == 0) goto L_0x0017
            int r0 = r0.length
            int r0 = r0 + r8
            int r7 = r7 + r0
        L_0x0017:
            byte[] r0 = r1.P
            if (r0 == 0) goto L_0x001f
            int r9 = r1.Q
            if (r7 <= r9) goto L_0x0025
        L_0x001f:
            byte[] r0 = new byte[r7]
            r1.P = r0
            r1.Q = r7
        L_0x0025:
            r7 = r0
            java.lang.String r0 = r1.f9275a
            byte r0 = com.amap.api.mapcore.util.is.e(r0)
            r9 = 0
            r7[r9] = r0
            short r0 = r1.f9276b
            r10 = 0
            byte[] r0 = com.amap.api.mapcore.util.is.a((int) r0, (byte[]) r10)
            int r11 = r0.length
            java.lang.System.arraycopy(r0, r9, r7, r8, r11)
            int r0 = r0.length
            int r0 = r0 + r8
            java.lang.String r11 = r1.f9277c
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9278d
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9289o
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9279e
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9280f
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9281g
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9295u
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9282h
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9290p
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9291q
            int r11 = a(r11, r7, r0)
            java.lang.String r0 = r1.f9294t     // Catch:{ all -> 0x0096 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0083
            r7[r11] = r9     // Catch:{ all -> 0x0096 }
            goto L_0x009e
        L_0x0083:
            java.lang.String r0 = r1.f9294t     // Catch:{ all -> 0x0096 }
            byte[] r0 = r1.a(r0)     // Catch:{ all -> 0x0096 }
            int r12 = r0.length     // Catch:{ all -> 0x0096 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0096 }
            r7[r11] = r12     // Catch:{ all -> 0x0096 }
            int r11 = r11 + 1
            int r12 = r0.length     // Catch:{ all -> 0x0096 }
            java.lang.System.arraycopy(r0, r9, r7, r11, r12)     // Catch:{ all -> 0x0096 }
            int r0 = r0.length     // Catch:{ all -> 0x0096 }
            int r11 = r11 + r0
            goto L_0x009f
        L_0x0096:
            r0 = move-exception
            java.lang.String r12 = "buildV4Dot219"
            com.amap.api.mapcore.util.io.a(r0, r2, r12)
            r7[r11] = r9
        L_0x009e:
            int r11 = r11 + r8
        L_0x009f:
            java.lang.String r0 = r1.f9296v
            int r0 = a(r0, r7, r11)
            java.lang.String r11 = r1.f9297w
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = J
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = L
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9298x
            int r0 = a(r11, r7, r0)
            java.lang.String r11 = r1.f9299y
            byte r11 = java.lang.Byte.parseByte(r11)
            r7[r0] = r11
            int r0 = r0 + r8
            java.lang.String r11 = r1.f9284j
            byte r11 = java.lang.Byte.parseByte(r11)
            r7[r0] = r11
            int r0 = r0 + r8
            int r11 = r1.f9300z
            r12 = r11 & 3
            byte r11 = (byte) r11
            r7[r0] = r11
            int r0 = r0 + r8
            r11 = -128(0xffffffffffffff80, float:NaN)
            r15 = 127(0x7f, float:1.78E-43)
            if (r12 == r8) goto L_0x00df
            if (r12 != r3) goto L_0x0208
        L_0x00df:
            java.lang.String r10 = "mcc"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.mapcore.util.is.b((java.lang.String) r10)
            int r5 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r5)
            int r5 = r10.length
            int r0 = r0 + r5
            java.lang.String r5 = "cellid"
            java.lang.String r10 = "lac"
            if (r12 != r8) goto L_0x0122
            java.lang.String r13 = "mnc"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.b((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = r1.b(r10)
            byte[] r13 = com.amap.api.mapcore.util.is.b((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = r1.b(r5)
            byte[] r13 = com.amap.api.mapcore.util.is.c((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
        L_0x0120:
            int r0 = r0 + r13
            goto L_0x0174
        L_0x0122:
            if (r12 != r3) goto L_0x0174
            java.lang.String r13 = "sid"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.b((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = "nid"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.b((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = "bid"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.b((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = "lon"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.c((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            int r0 = r0 + r13
            java.lang.String r13 = "lat"
            java.lang.String r13 = r1.b(r13)
            byte[] r13 = com.amap.api.mapcore.util.is.c((java.lang.String) r13)
            int r14 = r13.length
            java.lang.System.arraycopy(r13, r9, r7, r0, r14)
            int r13 = r13.length
            goto L_0x0120
        L_0x0174:
            java.lang.String r13 = "signal"
            java.lang.String r14 = r1.b(r13)
            int r14 = java.lang.Integer.parseInt(r14)
            if (r14 <= r15) goto L_0x0182
        L_0x0180:
            r14 = 0
            goto L_0x0185
        L_0x0182:
            if (r14 >= r11) goto L_0x0185
            goto L_0x0180
        L_0x0185:
            byte r14 = (byte) r14
            r7[r0] = r14
            int r0 = r0 + r8
            byte[] r14 = com.amap.api.mapcore.util.is.a((int) r9, (byte[]) r4)
            int r11 = r14.length
            java.lang.System.arraycopy(r14, r9, r7, r0, r11)
            int r0 = r0 + r3
            if (r12 != r8) goto L_0x0202
            java.lang.String r11 = r1.B
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x019f
            r7[r0] = r9
            goto L_0x0206
        L_0x019f:
            java.lang.String r11 = r1.B
            java.lang.String r12 = "\\*"
            java.lang.String[] r11 = r11.split(r12)
            int r11 = r11.length
            byte r12 = (byte) r11
            r7[r0] = r12
            int r0 = r0 + 1
            r12 = 0
        L_0x01ae:
            if (r12 >= r11) goto L_0x0208
            java.lang.String r14 = r1.a(r10, r12)
            byte[] r14 = com.amap.api.mapcore.util.is.b((java.lang.String) r14)
            int r3 = r14.length
            java.lang.System.arraycopy(r14, r9, r7, r0, r3)
            int r3 = r14.length
            int r0 = r0 + r3
            java.lang.String r3 = r1.a(r5, r12)
            byte[] r3 = com.amap.api.mapcore.util.is.c((java.lang.String) r3)
            int r14 = r3.length
            java.lang.System.arraycopy(r3, r9, r7, r0, r14)
            int r3 = r3.length
            int r0 = r0 + r3
            java.lang.String r3 = r1.a(r13, r12)
            int r3 = java.lang.Integer.parseInt(r3)
            if (r3 <= r15) goto L_0x01d8
        L_0x01d6:
            r3 = 0
            goto L_0x01dd
        L_0x01d8:
            r14 = -128(0xffffffffffffff80, float:NaN)
            if (r3 >= r14) goto L_0x01dd
            goto L_0x01d6
        L_0x01dd:
            byte r3 = (byte) r3
            r7[r0] = r3
            int r0 = r0 + r8
            java.lang.String r3 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r18 = r3.doubleValue()
            r16 = 4617540697942969549(0x4014cccccccccccd, double:5.2)
            int r3 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r3 < 0) goto L_0x01fe
            byte[] r3 = com.amap.api.mapcore.util.is.a((int) r9, (byte[]) r4)
            int r14 = r3.length
            java.lang.System.arraycopy(r3, r9, r7, r0, r14)
            int r3 = r3.length
            int r0 = r0 + r3
        L_0x01fe:
            int r12 = r12 + 1
            r3 = 2
            goto L_0x01ae
        L_0x0202:
            if (r12 != r3) goto L_0x0208
            r7[r0] = r9
        L_0x0206:
            int r0 = r0 + 1
        L_0x0208:
            java.lang.String r3 = r1.D
            java.lang.String r5 = "GBK"
            r10 = 8
            if (r3 == 0) goto L_0x022a
            int r11 = r1.f9300z
            r11 = r11 & r10
            if (r11 != r10) goto L_0x022a
            byte[] r3 = r3.getBytes(r5)     // Catch:{ Exception -> 0x022a }
            int r11 = r3.length     // Catch:{ Exception -> 0x022a }
            r12 = 60
            int r11 = java.lang.Math.min(r11, r12)     // Catch:{ Exception -> 0x022a }
            byte r12 = (byte) r11     // Catch:{ Exception -> 0x022a }
            r7[r0] = r12     // Catch:{ Exception -> 0x022a }
            int r0 = r0 + 1
            java.lang.System.arraycopy(r3, r9, r7, r0, r11)     // Catch:{ Exception -> 0x022a }
            int r0 = r0 + r11
            goto L_0x022d
        L_0x022a:
            r7[r0] = r9
            int r0 = r0 + r8
        L_0x022d:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r3 = r1.C
            int r11 = r3.size()
            int r12 = r1.f9300z
            r13 = 4
            r12 = r12 & r13
            r18 = 4617315517961601024(0x4014000000000000, double:5.0)
            if (r12 != r13) goto L_0x0407
            if (r11 <= 0) goto L_0x0407
            r3.get(r9)
            byte r12 = (byte) r11
            r7[r0] = r12
            int r0 = r0 + r8
            r12 = 0
        L_0x0245:
            if (r12 >= r11) goto L_0x040b
            java.lang.Object r13 = r3.get(r12)
            com.amap.api.mapcore.util.jq r13 = (com.amap.api.mapcore.util.jq) r13
            int r14 = r13.f9505l
            r15 = 5
            r10 = 3
            if (r14 == r8) goto L_0x0300
            int r14 = r13.f9505l
            if (r14 == r10) goto L_0x0300
            int r14 = r13.f9505l
            r10 = 4
            if (r14 != r10) goto L_0x025e
            goto L_0x0300
        L_0x025e:
            int r10 = r13.f9505l
            r14 = 2
            if (r10 != r14) goto L_0x02ba
            int r10 = r13.f9505l
            byte r10 = (byte) r10
            boolean r14 = r13.f9508o
            if (r14 == 0) goto L_0x026d
            r10 = r10 | 8
            byte r10 = (byte) r10
        L_0x026d:
            r7[r0] = r10
            int r0 = r0 + 1
            int r10 = r13.f9494a
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9501h
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9502i
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9503j
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9500g
            byte[] r10 = com.amap.api.mapcore.util.is.b((int) r10, (byte[]) r6)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9499f
            byte[] r10 = com.amap.api.mapcore.util.is.b((int) r10, (byte[]) r6)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            goto L_0x02fe
        L_0x02ba:
            int r10 = r13.f9505l
            if (r10 != r15) goto L_0x02fe
            int r10 = r13.f9505l
            byte r10 = (byte) r10
            boolean r14 = r13.f9508o
            if (r14 == 0) goto L_0x02c8
            r10 = r10 | 8
            byte r10 = (byte) r10
        L_0x02c8:
            r7[r0] = r10
            int r0 = r0 + 1
            int r10 = r13.f9494a
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9495b
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9496c
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r14)
            int r10 = r10.length
            int r0 = r0 + r10
            r14 = r11
            long r10 = r13.f9498e
            byte[] r10 = com.amap.api.mapcore.util.is.a((long) r10)
            r11 = 8
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r0 = r0 + r11
            goto L_0x033f
        L_0x02fe:
            r14 = r11
            goto L_0x033f
        L_0x0300:
            r14 = r11
            int r10 = r13.f9505l
            byte r10 = (byte) r10
            boolean r11 = r13.f9508o
            if (r11 == 0) goto L_0x030b
            r10 = r10 | 8
            byte r10 = (byte) r10
        L_0x030b:
            r7[r0] = r10
            int r0 = r0 + 1
            int r10 = r13.f9494a
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9495b
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9496c
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9497d
            byte[] r10 = com.amap.api.mapcore.util.is.b((int) r10, (byte[]) r6)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r10 = r10.length
            int r0 = r0 + r10
        L_0x033f:
            int r10 = r13.f9504k
            r11 = 127(0x7f, float:1.78E-43)
            if (r10 <= r11) goto L_0x0348
        L_0x0345:
            r10 = 99
            goto L_0x034d
        L_0x0348:
            r11 = -128(0xffffffffffffff80, float:NaN)
            if (r10 >= r11) goto L_0x034d
            goto L_0x0345
        L_0x034d:
            byte r10 = (byte) r10
            r7[r0] = r10
            int r0 = r0 + r8
            short r10 = r13.f9506m
            byte[] r10 = com.amap.api.mapcore.util.is.a((int) r10, (byte[]) r4)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r9, r7, r0, r11)
            int r10 = r10.length
            int r0 = r0 + r10
            int r10 = r13.f9505l
            r21 = 4617653287933653811(0x4015333333333333, double:5.3)
            r11 = 32767(0x7fff, float:4.5916E-41)
            r9 = 3
            if (r10 == r9) goto L_0x03b3
            int r9 = r13.f9505l
            r10 = 4
            if (r9 == r10) goto L_0x03b4
            int r9 = r13.f9505l
            if (r9 != r15) goto L_0x0373
            goto L_0x03b4
        L_0x0373:
            int r9 = r13.f9505l
            if (r9 != r8) goto L_0x03fd
            java.lang.String r9 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            double r24 = r9.doubleValue()
            int r9 = (r24 > r21 ? 1 : (r24 == r21 ? 0 : -1))
            if (r9 < 0) goto L_0x03fd
            int r9 = r13.f9509p
            if (r9 <= r11) goto L_0x038b
            r9 = 32767(0x7fff, float:4.5916E-41)
        L_0x038b:
            if (r9 >= 0) goto L_0x038e
            goto L_0x038f
        L_0x038e:
            r11 = r9
        L_0x038f:
            byte[] r9 = com.amap.api.mapcore.util.is.a((int) r11, (byte[]) r4)
            int r11 = r9.length
            r15 = 0
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
            int r0 = r0 + r9
            int r9 = r13.f9510q
            byte[] r9 = com.amap.api.mapcore.util.is.b((int) r9, (byte[]) r6)
            int r11 = r9.length
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
            int r0 = r0 + r9
            int r9 = r13.f9511r
            byte[] r9 = com.amap.api.mapcore.util.is.b((int) r9, (byte[]) r6)
            int r11 = r9.length
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
        L_0x03b1:
            int r0 = r0 + r9
            goto L_0x03fd
        L_0x03b3:
            r10 = 4
        L_0x03b4:
            java.lang.String r9 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            double r24 = r9.doubleValue()
            int r9 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r9 < 0) goto L_0x03fd
            int r9 = r13.f9509p
            if (r9 <= r11) goto L_0x03c8
            r9 = 32767(0x7fff, float:4.5916E-41)
        L_0x03c8:
            if (r9 >= 0) goto L_0x03cb
            goto L_0x03cc
        L_0x03cb:
            r11 = r9
        L_0x03cc:
            byte[] r9 = com.amap.api.mapcore.util.is.a((int) r11, (byte[]) r4)
            int r11 = r9.length
            r15 = 0
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
            int r0 = r0 + r9
            java.lang.String r9 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            double r23 = r9.doubleValue()
            int r9 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r9 < 0) goto L_0x03fd
            int r9 = r13.f9510q
            byte[] r9 = com.amap.api.mapcore.util.is.b((int) r9, (byte[]) r6)
            int r11 = r9.length
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
            int r0 = r0 + r9
            int r9 = r13.f9511r
            byte[] r9 = com.amap.api.mapcore.util.is.b((int) r9, (byte[]) r6)
            int r11 = r9.length
            java.lang.System.arraycopy(r9, r15, r7, r0, r11)
            int r9 = r9.length
            goto L_0x03b1
        L_0x03fd:
            int r12 = r12 + 1
            r11 = r14
            r9 = 0
            r10 = 8
            r15 = 127(0x7f, float:1.78E-43)
            goto L_0x0245
        L_0x0407:
            r3 = 0
            r7[r0] = r3
            int r0 = r0 + r8
        L_0x040b:
            java.lang.String r3 = r1.E
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x04b7
            java.lang.String r3 = r1.E
            int r3 = r3.length()
            if (r3 != 0) goto L_0x041d
            goto L_0x04b7
        L_0x041d:
            r7[r0] = r8
            int r3 = r0 + 1
            java.lang.String r0 = r1.E     // Catch:{ all -> 0x0497 }
            java.lang.String r6 = ","
            java.lang.String[] r6 = r0.split(r6)     // Catch:{ all -> 0x0497 }
            r9 = 0
            r0 = r6[r9]     // Catch:{ all -> 0x0497 }
            byte[] r0 = r1.a(r0)     // Catch:{ all -> 0x0497 }
            int r10 = r0.length     // Catch:{ all -> 0x0497 }
            java.lang.System.arraycopy(r0, r9, r7, r3, r10)     // Catch:{ all -> 0x0497 }
            int r0 = r0.length     // Catch:{ all -> 0x0497 }
            int r3 = r3 + r0
            r9 = 2
            r0 = r6[r9]     // Catch:{ all -> 0x044f }
            byte[] r0 = r0.getBytes(r5)     // Catch:{ all -> 0x044f }
            int r9 = r0.length     // Catch:{ all -> 0x044f }
            r10 = 127(0x7f, float:1.78E-43)
            if (r9 <= r10) goto L_0x0444
            r9 = 127(0x7f, float:1.78E-43)
        L_0x0444:
            byte r10 = (byte) r9     // Catch:{ all -> 0x044f }
            r7[r3] = r10     // Catch:{ all -> 0x044f }
            int r3 = r3 + 1
            r10 = 0
            java.lang.System.arraycopy(r0, r10, r7, r3, r9)     // Catch:{ all -> 0x044f }
            int r3 = r3 + r9
            goto L_0x045a
        L_0x044f:
            r0 = move-exception
            java.lang.String r9 = "buildV4Dot214"
            com.amap.api.mapcore.util.io.a(r0, r2, r9)     // Catch:{ all -> 0x0497 }
            r9 = 0
            r7[r3] = r9     // Catch:{ all -> 0x0497 }
            int r3 = r3 + 1
        L_0x045a:
            r0 = r6[r8]     // Catch:{ all -> 0x0497 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0497 }
            r6 = 127(0x7f, float:1.78E-43)
            if (r0 <= r6) goto L_0x0466
        L_0x0464:
            r0 = 0
            goto L_0x046b
        L_0x0466:
            r6 = -128(0xffffffffffffff80, float:NaN)
            if (r0 >= r6) goto L_0x046b
            goto L_0x0464
        L_0x046b:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0497 }
            byte r0 = java.lang.Byte.parseByte(r0)     // Catch:{ all -> 0x0497 }
            r7[r3] = r0     // Catch:{ all -> 0x0497 }
            int r3 = r3 + 1
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9327a     // Catch:{ all -> 0x0497 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ all -> 0x0497 }
            double r9 = r0.doubleValue()     // Catch:{ all -> 0x0497 }
            r11 = 4617540697942969549(0x4014cccccccccccd, double:5.2)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0495
            r6 = 0
            byte[] r0 = com.amap.api.mapcore.util.is.a((int) r6, (byte[]) r4)     // Catch:{ all -> 0x0497 }
            int r9 = r0.length     // Catch:{ all -> 0x0497 }
            java.lang.System.arraycopy(r0, r6, r7, r3, r9)     // Catch:{ all -> 0x0497 }
            int r0 = r0.length     // Catch:{ all -> 0x0497 }
            int r3 = r3 + r0
        L_0x0495:
            r6 = 0
            goto L_0x04bc
        L_0x0497:
            r0 = move-exception
            java.lang.String r6 = "buildV4Dot216"
            com.amap.api.mapcore.util.io.a(r0, r2, r6)
            java.lang.String r0 = "00:00:00:00:00:00"
            byte[] r0 = r1.a(r0)
            int r2 = r0.length
            r6 = 0
            java.lang.System.arraycopy(r0, r6, r7, r3, r2)
            int r0 = r0.length
            int r3 = r3 + r0
            r7[r3] = r6
            int r3 = r3 + r8
            java.lang.String r0 = "0"
            byte r0 = java.lang.Byte.parseByte(r0)
            r7[r3] = r0
            int r3 = r3 + r8
            goto L_0x04bc
        L_0x04b7:
            r6 = 0
            r7[r0] = r6
            int r3 = r0 + 1
        L_0x04bc:
            java.util.ArrayList<android.net.wifi.ScanResult> r0 = r1.F
            int r2 = r0.size()
            r9 = 25
            int r2 = java.lang.Math.min(r2, r9)
            if (r2 != 0) goto L_0x04d0
            r7[r3] = r6
            int r3 = r3 + r8
            r15 = 0
            goto L_0x0578
        L_0x04d0:
            byte r6 = (byte) r2
            r7[r3] = r6
            int r3 = r3 + r8
            int r6 = com.amap.api.mapcore.util.is.c()
            r9 = 17
            if (r6 < r9) goto L_0x04de
            r6 = 1
            goto L_0x04df
        L_0x04de:
            r6 = 0
        L_0x04df:
            r9 = 0
            if (r6 == 0) goto L_0x04ea
            long r9 = com.amap.api.mapcore.util.is.b()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r11
        L_0x04ea:
            r11 = 0
        L_0x04eb:
            if (r11 >= r2) goto L_0x0567
            java.lang.Object r12 = r0.get(r11)
            android.net.wifi.ScanResult r12 = (android.net.wifi.ScanResult) r12
            java.lang.String r13 = r12.BSSID
            byte[] r13 = r1.a(r13)
            int r14 = r13.length
            r15 = 0
            java.lang.System.arraycopy(r13, r15, r7, r3, r14)
            int r13 = r13.length
            int r3 = r3 + r13
            java.lang.String r13 = r12.SSID     // Catch:{ Exception -> 0x0514 }
            byte[] r13 = r13.getBytes(r5)     // Catch:{ Exception -> 0x0514 }
            int r14 = r13.length     // Catch:{ Exception -> 0x0514 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0514 }
            r7[r3] = r14     // Catch:{ Exception -> 0x0514 }
            int r3 = r3 + 1
            int r14 = r13.length     // Catch:{ Exception -> 0x0514 }
            r15 = 0
            java.lang.System.arraycopy(r13, r15, r7, r3, r14)     // Catch:{ Exception -> 0x0514 }
            int r13 = r13.length     // Catch:{ Exception -> 0x0514 }
            int r3 = r3 + r13
            goto L_0x0518
        L_0x0514:
            r13 = 0
            r7[r3] = r13
            int r3 = r3 + r8
        L_0x0518:
            int r13 = r12.level
            r14 = 127(0x7f, float:1.78E-43)
            if (r13 <= r14) goto L_0x0522
            r13 = 0
            r14 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x0527
        L_0x0522:
            r14 = -128(0xffffffffffffff80, float:NaN)
            if (r13 >= r14) goto L_0x0527
            r13 = 0
        L_0x0527:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            byte r13 = java.lang.Byte.parseByte(r13)
            r7[r3] = r13
            int r3 = r3 + r8
            if (r6 == 0) goto L_0x0544
            long r14 = r12.timestamp
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r14 = r14 / r20
            r20 = 1
            long r14 = r14 + r20
            long r14 = r9 - r14
            int r13 = (int) r14
            if (r13 >= 0) goto L_0x0545
        L_0x0544:
            r13 = 0
        L_0x0545:
            r14 = 65535(0xffff, float:9.1834E-41)
            if (r13 <= r14) goto L_0x054d
            r13 = 65535(0xffff, float:9.1834E-41)
        L_0x054d:
            byte[] r13 = com.amap.api.mapcore.util.is.a((int) r13, (byte[]) r4)
            int r14 = r13.length
            r15 = 0
            java.lang.System.arraycopy(r13, r15, r7, r3, r14)
            int r13 = r13.length
            int r3 = r3 + r13
            int r12 = r12.frequency
            byte[] r12 = com.amap.api.mapcore.util.is.a((int) r12, (byte[]) r4)
            int r13 = r12.length
            java.lang.System.arraycopy(r12, r15, r7, r3, r13)
            int r12 = r12.length
            int r3 = r3 + r12
            int r11 = r11 + 1
            goto L_0x04eb
        L_0x0567:
            r15 = 0
            java.lang.String r0 = r1.G
            int r0 = java.lang.Integer.parseInt(r0)
            byte[] r0 = com.amap.api.mapcore.util.is.a((int) r0, (byte[]) r4)
            int r2 = r0.length
            java.lang.System.arraycopy(r0, r15, r7, r3, r2)
            int r0 = r0.length
            int r3 = r3 + r0
        L_0x0578:
            r7[r3] = r15
            int r3 = r3 + r8
            java.lang.String r0 = r1.H     // Catch:{ all -> 0x059b }
            byte[] r0 = r0.getBytes(r5)     // Catch:{ all -> 0x059b }
            int r2 = r0.length     // Catch:{ all -> 0x059b }
            r6 = 127(0x7f, float:1.78E-43)
            if (r2 <= r6) goto L_0x0587
            r0 = 0
        L_0x0587:
            if (r0 != 0) goto L_0x058d
            r2 = 0
            r7[r3] = r2     // Catch:{ all -> 0x059b }
            goto L_0x059e
        L_0x058d:
            int r2 = r0.length     // Catch:{ all -> 0x059b }
            byte r2 = (byte) r2     // Catch:{ all -> 0x059b }
            r7[r3] = r2     // Catch:{ all -> 0x059b }
            int r3 = r3 + 1
            int r2 = r0.length     // Catch:{ all -> 0x059b }
            r6 = 0
            java.lang.System.arraycopy(r0, r6, r7, r3, r2)     // Catch:{ all -> 0x059b }
            int r0 = r0.length     // Catch:{ all -> 0x059b }
            int r3 = r3 + r0
            goto L_0x059f
        L_0x059b:
            r2 = 0
            r7[r3] = r2
        L_0x059e:
            int r3 = r3 + r8
        L_0x059f:
            r2 = 2
            byte[] r0 = new byte[r2]
            r0 = {0, 0} // fill-array
            java.lang.String r2 = r1.K     // Catch:{ all -> 0x05cd }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x05cd }
            if (r2 != 0) goto L_0x05b7
            java.lang.String r0 = r1.K     // Catch:{ all -> 0x05cd }
            int r0 = r0.length()     // Catch:{ all -> 0x05cd }
            byte[] r0 = com.amap.api.mapcore.util.is.a((int) r0, (byte[]) r4)     // Catch:{ all -> 0x05cd }
        L_0x05b7:
            r6 = 2
            r8 = 0
            java.lang.System.arraycopy(r0, r8, r7, r3, r6)     // Catch:{ all -> 0x05cd }
            int r3 = r3 + r6
            if (r2 != 0) goto L_0x05cb
            java.lang.String r0 = r1.K     // Catch:{ all -> 0x05cb }
            byte[] r0 = r0.getBytes(r5)     // Catch:{ all -> 0x05cb }
            int r2 = r0.length     // Catch:{ all -> 0x05cb }
            java.lang.System.arraycopy(r0, r8, r7, r3, r2)     // Catch:{ all -> 0x05cb }
            int r0 = r0.length     // Catch:{ all -> 0x05cb }
            int r3 = r3 + r0
        L_0x05cb:
            r2 = 2
            goto L_0x05cf
        L_0x05cd:
            r2 = 2
            int r3 = r3 + r2
        L_0x05cf:
            r5 = 0
            byte[] r0 = com.amap.api.mapcore.util.is.a((int) r5, (byte[]) r4)     // Catch:{ all -> 0x05d7 }
            java.lang.System.arraycopy(r0, r5, r7, r3, r2)     // Catch:{ all -> 0x05d7 }
        L_0x05d7:
            int r3 = r3 + r2
            byte[] r0 = new byte[r2]
            r0 = {0, 0} // fill-array
            java.lang.System.arraycopy(r0, r5, r7, r3, r2)     // Catch:{ all -> 0x05e0 }
        L_0x05e0:
            int r3 = r3 + r2
            byte[] r0 = r1.I
            if (r0 == 0) goto L_0x05e7
            int r0 = r0.length
            goto L_0x05e8
        L_0x05e7:
            r0 = 0
        L_0x05e8:
            r2 = 0
            byte[] r2 = com.amap.api.mapcore.util.is.a((int) r0, (byte[]) r2)
            int r4 = r2.length
            r5 = 0
            java.lang.System.arraycopy(r2, r5, r7, r3, r4)
            int r2 = r2.length
            int r3 = r3 + r2
            if (r0 <= 0) goto L_0x0600
            byte[] r0 = r1.I
            int r2 = r0.length
            java.lang.System.arraycopy(r0, r5, r7, r3, r2)
            byte[] r0 = r1.I
            int r0 = r0.length
            int r3 = r3 + r0
        L_0x0600:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r8 = r0.doubleValue()
            int r0 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r0 < 0) goto L_0x0618
            r7[r3] = r5
            int r3 = r3 + 1
            java.lang.String r0 = r1.N
            int r3 = a(r0, r7, r3)
        L_0x0618:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r4 = r0.doubleValue()
            r8 = 4617428107952285286(0x4014666666666666, double:5.1)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0630
            r2 = 0
            r7[r3] = r2
            int r3 = r3 + 1
        L_0x0630:
            java.lang.String r0 = com.amap.api.mapcore.util.io.f9327a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r4 = r0.doubleValue()
            r8 = 4617540697942969549(0x4014cccccccccccd, double:5.2)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0649
            java.lang.String r0 = r1.O
            int r3 = a(r0, r7, r3)
        L_0x0649:
            byte[] r0 = new byte[r3]
            r2 = 0
            java.lang.System.arraycopy(r7, r2, r0, r2, r3)
            java.util.zip.CRC32 r4 = new java.util.zip.CRC32
            r4.<init>()
            r4.update(r0)
            long r4 = r4.getValue()
            byte[] r4 = com.amap.api.mapcore.util.is.a((long) r4)
            int r5 = r3 + 8
            byte[] r5 = new byte[r5]
            java.lang.System.arraycopy(r0, r2, r5, r2, r3)
            r6 = 8
            java.lang.System.arraycopy(r4, r2, r5, r3, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.im.a():byte[]");
    }
}
