package com.amap.api.mapcore.util;

public final class jg {

    public static class a implements je {

        /* renamed from: a  reason: collision with root package name */
        private int f9449a;

        /* renamed from: b  reason: collision with root package name */
        private int f9450b;

        /* renamed from: c  reason: collision with root package name */
        private int f9451c;

        a(int i2, int i3, int i4) {
            this.f9449a = i2;
            this.f9450b = i3;
            this.f9451c = i4;
        }

        public final long a() {
            return jg.a(this.f9449a, this.f9450b);
        }

        public final int b() {
            return this.f9451c;
        }
    }

    public static long a(int i2, int i3) {
        return (((long) i3) & 4294967295L) | ((((long) i2) & 4294967295L) << 32);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.util.List<com.amap.api.mapcore.util.ji> r6) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.jg> r0 = com.amap.api.mapcore.util.jg.class
            monitor-enter(r0)
            if (r6 == 0) goto L_0x007d
            boolean r1 = r6.isEmpty()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x000d
            goto L_0x007d
        L_0x000d:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007a }
            int r2 = r6.size()     // Catch:{ all -> 0x007a }
            r1.<init>(r2)     // Catch:{ all -> 0x007a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x007a }
        L_0x001a:
            boolean r2 = r6.hasNext()     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0071
            java.lang.Object r2 = r6.next()     // Catch:{ all -> 0x007a }
            com.amap.api.mapcore.util.ji r2 = (com.amap.api.mapcore.util.ji) r2     // Catch:{ all -> 0x007a }
            boolean r3 = r2 instanceof com.amap.api.mapcore.util.jk     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x003b
            com.amap.api.mapcore.util.jk r2 = (com.amap.api.mapcore.util.jk) r2     // Catch:{ all -> 0x007a }
            com.amap.api.mapcore.util.jg$a r3 = new com.amap.api.mapcore.util.jg$a     // Catch:{ all -> 0x007a }
            int r4 = r2.f9466j     // Catch:{ all -> 0x007a }
            int r5 = r2.f9467k     // Catch:{ all -> 0x007a }
            int r2 = r2.f9454c     // Catch:{ all -> 0x007a }
            r3.<init>(r4, r5, r2)     // Catch:{ all -> 0x007a }
        L_0x0037:
            r1.add(r3)     // Catch:{ all -> 0x007a }
            goto L_0x001a
        L_0x003b:
            boolean r3 = r2 instanceof com.amap.api.mapcore.util.jl     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x004d
            com.amap.api.mapcore.util.jl r2 = (com.amap.api.mapcore.util.jl) r2     // Catch:{ all -> 0x007a }
            com.amap.api.mapcore.util.jg$a r3 = new com.amap.api.mapcore.util.jg$a     // Catch:{ all -> 0x007a }
            int r4 = r2.f9472j     // Catch:{ all -> 0x007a }
            int r5 = r2.f9473k     // Catch:{ all -> 0x007a }
            int r2 = r2.f9454c     // Catch:{ all -> 0x007a }
            r3.<init>(r4, r5, r2)     // Catch:{ all -> 0x007a }
            goto L_0x0037
        L_0x004d:
            boolean r3 = r2 instanceof com.amap.api.mapcore.util.jm     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x005f
            com.amap.api.mapcore.util.jm r2 = (com.amap.api.mapcore.util.jm) r2     // Catch:{ all -> 0x007a }
            com.amap.api.mapcore.util.jg$a r3 = new com.amap.api.mapcore.util.jg$a     // Catch:{ all -> 0x007a }
            int r4 = r2.f9477j     // Catch:{ all -> 0x007a }
            int r5 = r2.f9478k     // Catch:{ all -> 0x007a }
            int r2 = r2.f9454c     // Catch:{ all -> 0x007a }
            r3.<init>(r4, r5, r2)     // Catch:{ all -> 0x007a }
            goto L_0x0037
        L_0x005f:
            boolean r3 = r2 instanceof com.amap.api.mapcore.util.jj     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x001a
            com.amap.api.mapcore.util.jj r2 = (com.amap.api.mapcore.util.jj) r2     // Catch:{ all -> 0x007a }
            com.amap.api.mapcore.util.jg$a r3 = new com.amap.api.mapcore.util.jg$a     // Catch:{ all -> 0x007a }
            int r4 = r2.f9462k     // Catch:{ all -> 0x007a }
            int r5 = r2.f9463l     // Catch:{ all -> 0x007a }
            int r2 = r2.f9454c     // Catch:{ all -> 0x007a }
            r3.<init>(r4, r5, r2)     // Catch:{ all -> 0x007a }
            goto L_0x0037
        L_0x0071:
            com.amap.api.mapcore.util.jf r6 = com.amap.api.mapcore.util.jf.a()     // Catch:{ all -> 0x007a }
            r6.a(r1)     // Catch:{ all -> 0x007a }
            monitor-exit(r0)
            return
        L_0x007a:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        L_0x007d:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jg.a(java.util.List):void");
    }
}
