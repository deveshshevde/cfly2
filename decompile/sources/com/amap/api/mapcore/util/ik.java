package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.hd;

public final class ik {

    /* renamed from: b  reason: collision with root package name */
    private static ik f9259b;

    /* renamed from: a  reason: collision with root package name */
    gw f9260a = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f9261c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f9262d = io.f9335i;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9263e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f9264f = 0;

    private ik(Context context) {
        try {
            fb.a().a(context);
        } catch (Throwable unused) {
        }
        this.f9261c = context;
        this.f9260a = gw.a();
    }

    public static ik a(Context context) {
        if (f9259b == null) {
            f9259b = new ik(context);
        }
        return f9259b;
    }

    public final he a(il ilVar) throws Throwable {
        if (this.f9263e) {
            ilVar.setHttpProtocol(hd.c.HTTPS);
        }
        return gw.b(ilVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fd A[Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.mapcore.util.il a(android.content.Context r10, byte[] r11, java.lang.String r12, java.lang.String r13) {
        /*
            r9 = this;
            java.lang.String r0 = "1"
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0103 }
            r2 = 16
            r1.<init>(r2)     // Catch:{ all -> 0x0103 }
            com.amap.api.mapcore.util.il r3 = new com.amap.api.mapcore.util.il     // Catch:{ all -> 0x0103 }
            com.amap.api.mapcore.util.ff r4 = com.amap.api.mapcore.util.io.c()     // Catch:{ all -> 0x0103 }
            r3.<init>(r10, r4)     // Catch:{ all -> 0x0103 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/octet-stream"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "gzip"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "gzipped"
            r1.put(r4, r0)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "Connection"
            java.lang.String r5 = "Keep-Alive"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "AMAP_Location_SDK_Android 5.3.1"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "KEY"
            java.lang.String r5 = com.amap.api.mapcore.util.ev.f(r10)     // Catch:{ all -> 0x0104 }
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "enginever"
            java.lang.String r5 = com.amap.api.mapcore.util.io.f9327a     // Catch:{ all -> 0x0104 }
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = com.amap.api.mapcore.util.ey.a()     // Catch:{ all -> 0x0104 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = "key="
            r5.<init>(r6)     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = com.amap.api.mapcore.util.ev.f(r10)     // Catch:{ all -> 0x0104 }
            r5.append(r6)     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = com.amap.api.mapcore.util.ey.a((android.content.Context) r10, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = "ts"
            r1.put(r6, r4)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "scode"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = com.amap.api.mapcore.util.io.f9327a     // Catch:{ all -> 0x0104 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x0104 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0104 }
            r6 = 4617653287933653811(0x4015333333333333, double:5.3)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0081
            java.lang.String r4 = "aps_s_src"
            java.lang.String r5 = "openapi"
            r1.put(r4, r5)     // Catch:{ all -> 0x0104 }
        L_0x0081:
            java.lang.String r4 = "encr"
            r1.put(r4, r0)     // Catch:{ all -> 0x0104 }
            r3.b((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = "loc"
            r3.j()     // Catch:{ all -> 0x0104 }
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s"
            r5 = 3
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0104 }
            r7 = 0
            java.lang.String r8 = "5.3.1"
            r6[r7] = r8     // Catch:{ all -> 0x0104 }
            r7 = 1
            r6[r7] = r0     // Catch:{ all -> 0x0104 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0104 }
            r5 = 2
            r6[r5] = r0     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = java.lang.String.format(r1, r4, r6)     // Catch:{ all -> 0x0104 }
            r3.a((java.lang.String) r0)     // Catch:{ all -> 0x0104 }
            r3.i()     // Catch:{ all -> 0x0104 }
            r3.b((java.lang.String) r12)     // Catch:{ all -> 0x0104 }
            r3.c(r13)     // Catch:{ all -> 0x0104 }
            byte[] r11 = com.amap.api.mapcore.util.is.a((byte[]) r11)     // Catch:{ all -> 0x0104 }
            r3.a((byte[]) r11)     // Catch:{ all -> 0x0104 }
            java.net.Proxy r10 = com.amap.api.mapcore.util.fe.a((android.content.Context) r10)     // Catch:{ all -> 0x0104 }
            r3.setProxy(r10)     // Catch:{ all -> 0x0104 }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x0104 }
            r10.<init>(r2)     // Catch:{ all -> 0x0104 }
            java.lang.String r11 = "output"
            java.lang.String r12 = "bin"
            r10.put(r11, r12)     // Catch:{ all -> 0x0104 }
            java.lang.String r11 = "policy"
            java.lang.String r12 = "3103"
            r10.put(r11, r12)     // Catch:{ all -> 0x0104 }
            int r11 = r9.f9264f     // Catch:{ all -> 0x0104 }
            java.lang.String r12 = "custom"
            if (r11 == 0) goto L_0x00df
            if (r11 == r7) goto L_0x00e9
            if (r11 == r5) goto L_0x00e3
        L_0x00df:
            r10.remove(r12)     // Catch:{ all -> 0x0104 }
            goto L_0x00ec
        L_0x00e3:
            java.lang.String r11 = "language:en"
        L_0x00e5:
            r10.put(r12, r11)     // Catch:{ all -> 0x0104 }
            goto L_0x00ec
        L_0x00e9:
            java.lang.String r11 = "language:cn"
            goto L_0x00e5
        L_0x00ec:
            r3.a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ all -> 0x0104 }
            int r10 = r9.f9262d     // Catch:{ all -> 0x0104 }
            r3.setConnectionTimeout(r10)     // Catch:{ all -> 0x0104 }
            int r10 = r9.f9262d     // Catch:{ all -> 0x0104 }
            r3.setSoTimeout(r10)     // Catch:{ all -> 0x0104 }
            boolean r10 = r9.f9263e     // Catch:{ all -> 0x0104 }
            if (r10 == 0) goto L_0x0104
            com.amap.api.mapcore.util.hd$c r10 = com.amap.api.mapcore.util.hd.c.HTTPS     // Catch:{ all -> 0x0104 }
            r3.setHttpProtocol(r10)     // Catch:{ all -> 0x0104 }
            goto L_0x0104
        L_0x0103:
            r3 = 0
        L_0x0104:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ik.a(android.content.Context, byte[], java.lang.String, java.lang.String):com.amap.api.mapcore.util.il");
    }

    public final void a(long j2, boolean z2) {
        try {
            this.f9263e = z2;
            this.f9262d = Long.valueOf(j2).intValue();
            this.f9264f = 0;
        } catch (Throwable th) {
            io.a(th, "LocNetManager", "setOption");
        }
    }
}
