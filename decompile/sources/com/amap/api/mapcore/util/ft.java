package com.amap.api.mapcore.util;

import java.util.Vector;

public final class ft {

    /* renamed from: b  reason: collision with root package name */
    private static int f8835b = 100;

    /* renamed from: d  reason: collision with root package name */
    private static int f8836d = 10000;

    /* renamed from: a  reason: collision with root package name */
    private Vector<fq> f8837a;

    /* renamed from: c  reason: collision with root package name */
    private int f8838c;

    /* renamed from: e  reason: collision with root package name */
    private int f8839e;

    public ft() {
        this.f8838c = f8835b;
        this.f8839e = 0;
        this.f8838c = 10;
        this.f8837a = new Vector<>();
    }

    public ft(byte b2) {
        this.f8838c = f8835b;
        this.f8839e = 0;
        this.f8837a = new Vector<>();
    }

    public final Vector<fq> a() {
        return this.f8837a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.amap.api.mapcore.util.fq r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0026
            java.lang.String r0 = r2.b()     // Catch:{ all -> 0x0023 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            java.util.Vector<com.amap.api.mapcore.util.fq> r0 = r1.f8837a     // Catch:{ all -> 0x0023 }
            r0.add(r2)     // Catch:{ all -> 0x0023 }
            int r0 = r1.f8839e     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.b()     // Catch:{ all -> 0x0023 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0023 }
            int r2 = r2.length     // Catch:{ all -> 0x0023 }
            int r0 = r0 + r2
            r1.f8839e = r0     // Catch:{ all -> 0x0023 }
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0026:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.fq):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        if ((r4.f8839e + r5.getBytes().length) <= f8836d) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x0006
            monitor-exit(r4)
            return r0
        L_0x0006:
            java.util.Vector<com.amap.api.mapcore.util.fq> r1 = r4.f8837a     // Catch:{ all -> 0x0022 }
            int r1 = r1.size()     // Catch:{ all -> 0x0022 }
            int r2 = r4.f8838c     // Catch:{ all -> 0x0022 }
            r3 = 1
            if (r1 < r2) goto L_0x0013
            monitor-exit(r4)
            return r3
        L_0x0013:
            int r1 = r4.f8839e     // Catch:{ all -> 0x0022 }
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x0022 }
            int r5 = r5.length     // Catch:{ all -> 0x0022 }
            int r1 = r1 + r5
            int r5 = f8836d     // Catch:{ all -> 0x0022 }
            monitor-exit(r4)
            if (r1 <= r5) goto L_0x0021
            return r3
        L_0x0021:
            return r0
        L_0x0022:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ft.a(java.lang.String):boolean");
    }

    public final synchronized void b() {
        this.f8837a.clear();
        this.f8839e = 0;
    }
}
