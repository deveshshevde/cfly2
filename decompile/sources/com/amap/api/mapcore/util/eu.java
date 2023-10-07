package com.amap.api.mapcore.util;

import java.util.List;
import java.util.Map;

public final class eu extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f8593a;

    /* renamed from: b  reason: collision with root package name */
    private String f8594b;

    /* renamed from: c  reason: collision with root package name */
    private String f8595c;

    /* renamed from: d  reason: collision with root package name */
    private String f8596d;

    /* renamed from: e  reason: collision with root package name */
    private String f8597e;

    /* renamed from: f  reason: collision with root package name */
    private int f8598f;

    /* renamed from: g  reason: collision with root package name */
    private int f8599g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f8600h;

    /* renamed from: i  reason: collision with root package name */
    private String f8601i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, List<String>> f8602j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public eu(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r16.<init>(r17)
            java.lang.String r2 = "未知的错误"
            r0.f8593a = r2
            java.lang.String r3 = ""
            r0.f8594b = r3
            r0.f8595c = r3
            java.lang.String r3 = "1900"
            r0.f8596d = r3
            java.lang.String r3 = "UnknownError"
            r0.f8597e = r3
            r3 = -1
            r0.f8598f = r3
            r0.f8599g = r3
            r4 = 0
            r0.f8600h = r4
            r0.f8593a = r1
            java.lang.String r4 = "IO 操作异常 - IOException"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "DNS解析失败"
            java.lang.String r7 = "http连接失败 - ConnectionException"
            r8 = 2
            java.lang.String r9 = "未知主机 - UnKnowHostException"
            r10 = 7
            java.lang.String r11 = "socket 连接超时 - SocketTimeoutException"
            java.lang.String r12 = "socket 连接异常 - SocketException"
            r13 = 3
            r14 = 6
            if (r5 == 0) goto L_0x0047
            r3 = 21
            r0.f8598f = r3
            java.lang.String r3 = "1902"
            r0.f8596d = r3
            java.lang.String r3 = "IOException"
        L_0x0043:
            r0.f8597e = r3
            goto L_0x017b
        L_0x0047:
            boolean r5 = r12.equals(r1)
            if (r5 == 0) goto L_0x0053
            r3 = 22
        L_0x004f:
            r0.f8598f = r3
            goto L_0x017b
        L_0x0053:
            boolean r5 = r11.equals(r1)
            if (r5 == 0) goto L_0x0064
            r3 = 23
            r0.f8598f = r3
            java.lang.String r3 = "1802"
            r0.f8596d = r3
            java.lang.String r3 = "SocketTimeoutException"
            goto L_0x0043
        L_0x0064:
            java.lang.String r5 = "无效的参数 - IllegalArgumentException"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0077
            r3 = 24
            r0.f8598f = r3
            java.lang.String r3 = "1901"
            r0.f8596d = r3
            java.lang.String r3 = "IllegalArgumentException"
            goto L_0x0043
        L_0x0077:
            java.lang.String r5 = "空指针异常 - NullPointException"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x008a
            r3 = 25
            r0.f8598f = r3
            java.lang.String r3 = "1903"
            r0.f8596d = r3
            java.lang.String r3 = "NullPointException"
            goto L_0x0043
        L_0x008a:
            java.lang.String r5 = "url异常 - MalformedURLException"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x009d
            r3 = 26
            r0.f8598f = r3
            java.lang.String r3 = "1803"
            r0.f8596d = r3
            java.lang.String r3 = "MalformedURLException"
            goto L_0x0043
        L_0x009d:
            boolean r5 = r9.equals(r1)
            if (r5 == 0) goto L_0x00ae
            r3 = 27
            r0.f8598f = r3
            java.lang.String r3 = "1804"
            r0.f8596d = r3
            java.lang.String r3 = "UnknownHostException"
            goto L_0x0043
        L_0x00ae:
            java.lang.String r5 = "服务器连接失败 - UnknownServiceException"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00c1
            r3 = 28
            r0.f8598f = r3
            java.lang.String r3 = "1805"
            r0.f8596d = r3
            java.lang.String r3 = "CannotConnectToHostException"
            goto L_0x0043
        L_0x00c1:
            java.lang.String r5 = "协议解析错误 - ProtocolException"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00d5
            r3 = 29
            r0.f8598f = r3
            java.lang.String r3 = "1801"
            r0.f8596d = r3
            java.lang.String r3 = "ProtocolException"
            goto L_0x0043
        L_0x00d5:
            boolean r5 = r7.equals(r1)
            java.lang.String r15 = "ConnectionException"
            r3 = 30
            if (r5 == 0) goto L_0x00e9
            r0.f8598f = r3
            java.lang.String r3 = "1806"
        L_0x00e3:
            r0.f8596d = r3
            r0.f8597e = r15
            goto L_0x017b
        L_0x00e9:
            java.lang.String r5 = "服务QPS超限"
            boolean r5 = r5.equalsIgnoreCase(r1)
            if (r5 == 0) goto L_0x00f6
            r0.f8598f = r3
            java.lang.String r3 = "2001"
            goto L_0x00e3
        L_0x00f6:
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L_0x0100
            r3 = 31
            goto L_0x004f
        L_0x0100:
            java.lang.String r3 = "key鉴权失败"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x010c
            r3 = 32
            goto L_0x004f
        L_0x010c:
            java.lang.String r3 = "requeust is null"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0117
            r3 = 1
            goto L_0x004f
        L_0x0117:
            java.lang.String r3 = "request url is empty"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0122
            r0.f8598f = r8
            goto L_0x017b
        L_0x0122:
            java.lang.String r3 = "response is null"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x012d
        L_0x012a:
            r0.f8598f = r13
            goto L_0x017b
        L_0x012d:
            java.lang.String r3 = "thread pool has exception"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0138
            r3 = 4
            goto L_0x004f
        L_0x0138:
            java.lang.String r3 = "sdk name is invalid"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0143
            r3 = 5
            goto L_0x004f
        L_0x0143:
            java.lang.String r3 = "sdk info is null"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x014e
            r0.f8598f = r14
            goto L_0x017b
        L_0x014e:
            java.lang.String r3 = "sdk packages is null"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0159
            r0.f8598f = r10
            goto L_0x017b
        L_0x0159:
            java.lang.String r3 = "线程池为空"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0165
            r3 = 8
            goto L_0x004f
        L_0x0165:
            java.lang.String r3 = "获取对象错误"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0171
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x004f
        L_0x0171:
            boolean r3 = r6.equals(r1)
            if (r3 == 0) goto L_0x0178
            goto L_0x012a
        L_0x0178:
            r3 = -1
            goto L_0x004f
        L_0x017b:
            boolean r3 = r4.equals(r1)
            if (r3 == 0) goto L_0x0184
            r0.f8599g = r10
            return
        L_0x0184:
            boolean r3 = r12.equals(r1)
            if (r3 == 0) goto L_0x018d
            r0.f8599g = r14
            return
        L_0x018d:
            boolean r3 = r11.equals(r1)
            if (r3 == 0) goto L_0x0196
            r0.f8599g = r8
            return
        L_0x0196:
            boolean r3 = r9.equals(r1)
            if (r3 != 0) goto L_0x01b4
            boolean r3 = r7.equals(r1)
            if (r3 == 0) goto L_0x01a5
            r0.f8599g = r14
            return
        L_0x01a5:
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x01b4
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x01b4
            r0.f8599g = r13
            return
        L_0x01b4:
            r1 = 9
            r0.f8599g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.eu.<init>(java.lang.String):void");
    }

    public eu(String str, String str2, String str3) {
        this(str);
        this.f8594b = str2;
        this.f8595c = str3;
    }

    public final String a() {
        return this.f8593a;
    }

    public final void a(int i2) {
        this.f8598f = i2;
    }

    public final void a(String str) {
        this.f8601i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f8602j = map;
    }

    public final String b() {
        return this.f8596d;
    }

    public final String c() {
        return this.f8597e;
    }

    public final String d() {
        return this.f8594b;
    }

    public final String e() {
        return this.f8595c;
    }

    public final int f() {
        return this.f8598f;
    }

    public final int g() {
        return this.f8599g;
    }

    public final int h() {
        this.f8599g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f8600h;
    }

    public final void j() {
        this.f8600h = true;
    }
}
