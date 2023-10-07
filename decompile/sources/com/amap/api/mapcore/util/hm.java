package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class hm {

    /* renamed from: a  reason: collision with root package name */
    static boolean f9152a = false;

    /* renamed from: b  reason: collision with root package name */
    static int f9153b = 20;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static int f9154c = 20;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference<hg> f9155d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f9156e;

    static class a extends ie {

        /* renamed from: a  reason: collision with root package name */
        static int f9157a = 1;

        /* renamed from: b  reason: collision with root package name */
        static int f9158b = 2;

        /* renamed from: c  reason: collision with root package name */
        static int f9159c = 3;

        /* renamed from: d  reason: collision with root package name */
        private Context f9160d;

        /* renamed from: e  reason: collision with root package name */
        private hl f9161e;

        /* renamed from: g  reason: collision with root package name */
        private int f9162g;

        /* renamed from: h  reason: collision with root package name */
        private List<hl> f9163h;

        a(Context context, int i2) {
            this.f9160d = context;
            this.f9162g = i2;
        }

        a(Context context, int i2, hl hlVar) {
            this(context, i2);
            this.f9161e = hlVar;
        }

        a(Context context, int i2, List<hl> list) {
            this(context, i2);
            this.f9163h = list;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0083 A[SYNTHETIC, Splitter:B:64:0x0083] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void runTask() {
            /*
                r16 = this;
                r1 = r16
                int r0 = r1.f9162g
                r2 = 1
                if (r0 != r2) goto L_0x0034
                android.content.Context r0 = r1.f9160d     // Catch:{ all -> 0x002b }
                if (r0 == 0) goto L_0x002a
                com.amap.api.mapcore.util.hl r0 = r1.f9161e     // Catch:{ all -> 0x002b }
                if (r0 != 0) goto L_0x0010
                goto L_0x002a
            L_0x0010:
                java.lang.Class<com.amap.api.mapcore.util.hm> r2 = com.amap.api.mapcore.util.hm.class
                monitor-enter(r2)     // Catch:{ all -> 0x002b }
                android.content.Context r0 = r1.f9160d     // Catch:{ all -> 0x0027 }
                if (r0 == 0) goto L_0x0025
                com.amap.api.mapcore.util.hl r3 = r1.f9161e     // Catch:{ all -> 0x0027 }
                if (r3 != 0) goto L_0x001c
                goto L_0x0025
            L_0x001c:
                byte[] r3 = r3.a()     // Catch:{ all -> 0x0027 }
                com.amap.api.mapcore.util.hm.a((android.content.Context) r0, (byte[]) r3)     // Catch:{ all -> 0x0027 }
                monitor-exit(r2)     // Catch:{ all -> 0x0027 }
                return
            L_0x0025:
                monitor-exit(r2)     // Catch:{ all -> 0x0027 }
                return
            L_0x0027:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0027 }
                throw r0     // Catch:{ all -> 0x002b }
            L_0x002a:
                return
            L_0x002b:
                r0 = move-exception
                java.lang.String r2 = "stm"
                java.lang.String r3 = "as"
            L_0x0030:
                com.amap.api.mapcore.util.fz.c(r0, r2, r3)
                return
            L_0x0034:
                r2 = 2
                if (r0 != r2) goto L_0x00aa
                java.lang.Class<com.amap.api.mapcore.util.hm> r2 = com.amap.api.mapcore.util.hm.class
                monitor-enter(r2)     // Catch:{ all -> 0x00a4 }
                java.util.List<com.amap.api.mapcore.util.hl> r0 = r1.f9163h     // Catch:{ all -> 0x00a1 }
                if (r0 == 0) goto L_0x009f
                android.content.Context r0 = r1.f9160d     // Catch:{ all -> 0x00a1 }
                if (r0 != 0) goto L_0x0043
                goto L_0x009f
            L_0x0043:
                r3 = 0
                r0 = 0
                byte[] r4 = new byte[r0]     // Catch:{ all -> 0x00a1 }
                java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0079 }
                r5.<init>()     // Catch:{ all -> 0x0079 }
                java.util.List<com.amap.api.mapcore.util.hl> r0 = r1.f9163h     // Catch:{ all -> 0x0076 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0076 }
            L_0x0052:
                boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0076 }
                if (r3 == 0) goto L_0x0068
                java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0076 }
                com.amap.api.mapcore.util.hl r3 = (com.amap.api.mapcore.util.hl) r3     // Catch:{ all -> 0x0076 }
                if (r3 == 0) goto L_0x0052
                byte[] r3 = r3.a()     // Catch:{ all -> 0x0076 }
                r5.write(r3)     // Catch:{ all -> 0x0076 }
                goto L_0x0052
            L_0x0068:
                byte[] r4 = r5.toByteArray()     // Catch:{ all -> 0x0076 }
                r5.close()     // Catch:{ all -> 0x0070 }
                goto L_0x008a
            L_0x0070:
                r0 = move-exception
                r3 = r0
            L_0x0072:
                r3.printStackTrace()     // Catch:{ all -> 0x00a1 }
                goto L_0x008a
            L_0x0076:
                r0 = move-exception
                r3 = r5
                goto L_0x007a
            L_0x0079:
                r0 = move-exception
            L_0x007a:
                java.lang.String r5 = "stm"
                java.lang.String r6 = "aStB"
                com.amap.api.mapcore.util.fz.c(r0, r5, r6)     // Catch:{ all -> 0x0091 }
                if (r3 == 0) goto L_0x008a
                r3.close()     // Catch:{ all -> 0x0087 }
                goto L_0x008a
            L_0x0087:
                r0 = move-exception
                r3 = r0
                goto L_0x0072
            L_0x008a:
                android.content.Context r0 = r1.f9160d     // Catch:{ all -> 0x00a1 }
                com.amap.api.mapcore.util.hm.a((android.content.Context) r0, (byte[]) r4)     // Catch:{ all -> 0x00a1 }
                monitor-exit(r2)     // Catch:{ all -> 0x00a1 }
                return
            L_0x0091:
                r0 = move-exception
                r4 = r0
                if (r3 == 0) goto L_0x009e
                r3.close()     // Catch:{ all -> 0x0099 }
                goto L_0x009e
            L_0x0099:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()     // Catch:{ all -> 0x00a1 }
            L_0x009e:
                throw r4     // Catch:{ all -> 0x00a1 }
            L_0x009f:
                monitor-exit(r2)     // Catch:{ all -> 0x00a1 }
                return
            L_0x00a1:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00a1 }
                throw r0     // Catch:{ all -> 0x00a4 }
            L_0x00a4:
                r0 = move-exception
                java.lang.String r2 = "stm"
                java.lang.String r3 = "apb"
                goto L_0x0030
            L_0x00aa:
                r2 = 3
                if (r0 != r2) goto L_0x013b
                android.content.Context r0 = r1.f9160d     // Catch:{ all -> 0x0133 }
                if (r0 != 0) goto L_0x00b2
                return
            L_0x00b2:
                java.lang.ref.WeakReference r0 = com.amap.api.mapcore.util.hm.f9155d     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hg r0 = com.amap.api.mapcore.util.hn.a(r0)     // Catch:{ all -> 0x0133 }
                android.content.Context r2 = r1.f9160d     // Catch:{ all -> 0x0133 }
                java.lang.String r4 = com.amap.api.mapcore.util.fx.f8867h     // Catch:{ all -> 0x0133 }
                r5 = 1000(0x3e8, float:1.401E-42)
                r6 = 307200(0x4b000, float:4.30479E-40)
                java.lang.String r7 = "2"
                r3 = r0
                com.amap.api.mapcore.util.hn.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hu r2 = r0.f9129g     // Catch:{ all -> 0x0133 }
                if (r2 != 0) goto L_0x00ea
                com.amap.api.mapcore.util.ho r2 = new com.amap.api.mapcore.util.ho     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hs r3 = new com.amap.api.mapcore.util.hs     // Catch:{ all -> 0x0133 }
                android.content.Context r4 = r1.f9160d     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hp r5 = new com.amap.api.mapcore.util.hp     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.ht r6 = new com.amap.api.mapcore.util.ht     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hv r7 = new com.amap.api.mapcore.util.hv     // Catch:{ all -> 0x0133 }
                r7.<init>()     // Catch:{ all -> 0x0133 }
                r6.<init>(r7)     // Catch:{ all -> 0x0133 }
                r5.<init>(r6)     // Catch:{ all -> 0x0133 }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x0133 }
                r2.<init>(r3)     // Catch:{ all -> 0x0133 }
                r0.f9129g = r2     // Catch:{ all -> 0x0133 }
            L_0x00ea:
                r2 = 3600000(0x36ee80, float:5.044674E-39)
                r0.f9130h = r2     // Catch:{ all -> 0x0133 }
                java.lang.String r2 = r0.f9131i     // Catch:{ all -> 0x0133 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0133 }
                if (r2 == 0) goto L_0x00fb
                java.lang.String r2 = "cKey"
                r0.f9131i = r2     // Catch:{ all -> 0x0133 }
            L_0x00fb:
                com.amap.api.mapcore.util.ia r2 = r0.f9128f     // Catch:{ all -> 0x0133 }
                if (r2 != 0) goto L_0x012f
                com.amap.api.mapcore.util.hz r2 = new com.amap.api.mapcore.util.hz     // Catch:{ all -> 0x0133 }
                android.content.Context r3 = r1.f9160d     // Catch:{ all -> 0x0133 }
                int r4 = r0.f9130h     // Catch:{ all -> 0x0133 }
                java.lang.String r5 = r0.f9131i     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hw r6 = new com.amap.api.mapcore.util.hw     // Catch:{ all -> 0x0133 }
                java.lang.String r7 = r0.f9123a     // Catch:{ all -> 0x0133 }
                com.amap.api.mapcore.util.hx r15 = new com.amap.api.mapcore.util.hx     // Catch:{ all -> 0x0133 }
                android.content.Context r9 = r1.f9160d     // Catch:{ all -> 0x0133 }
                boolean r10 = com.amap.api.mapcore.util.hm.f9152a     // Catch:{ all -> 0x0133 }
                int r8 = com.amap.api.mapcore.util.hm.f9154c     // Catch:{ all -> 0x0133 }
                int r11 = r8 * 1024
                int r8 = com.amap.api.mapcore.util.hm.f9153b     // Catch:{ all -> 0x0133 }
                int r12 = r8 * 1024
                java.lang.String r13 = "staticUpdate"
                int r8 = com.amap.api.mapcore.util.hm.f9156e     // Catch:{ all -> 0x0133 }
                int r14 = r8 * 1024
                r8 = r15
                r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0133 }
                r6.<init>(r7, r15)     // Catch:{ all -> 0x0133 }
                r2.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x0133 }
                r0.f9128f = r2     // Catch:{ all -> 0x0133 }
            L_0x012f:
                com.amap.api.mapcore.util.hh.a(r0)     // Catch:{ all -> 0x0133 }
                return
            L_0x0133:
                r0 = move-exception
                java.lang.String r2 = "stm"
                java.lang.String r3 = "usd"
                com.amap.api.mapcore.util.fz.c(r0, r2, r3)
            L_0x013b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hm.a.runTask():void");
        }
    }

    public static void a(Context context) {
        id.a().a(new a(context, a.f9159c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        hg a2 = hn.a(f9155d);
        hn.a(context, a2, fx.f8867h, 1000, 307200, "2");
        if (a2.f9127e == null) {
            a2.f9127e = new gn();
        }
        Random random = new Random();
        try {
            hh.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            fz.c(th, "stm", "wts");
        }
    }

    public static synchronized void a(hl hlVar, Context context) {
        synchronized (hm.class) {
            id.a().a(new a(context, a.f9157a, hlVar));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.util.List<com.amap.api.mapcore.util.hl> r4, android.content.Context r5) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.hm> r0 = com.amap.api.mapcore.util.hm.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x001e
            int r1 = r4.size()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x000c
            goto L_0x001e
        L_0x000c:
            com.amap.api.mapcore.util.id r1 = com.amap.api.mapcore.util.id.a()     // Catch:{ all -> 0x001c }
            com.amap.api.mapcore.util.hm$a r2 = new com.amap.api.mapcore.util.hm$a     // Catch:{ all -> 0x001c }
            int r3 = com.amap.api.mapcore.util.hm.a.f9158b     // Catch:{ all -> 0x001c }
            r2.<init>((android.content.Context) r5, (int) r3, (java.util.List<com.amap.api.mapcore.util.hl>) r4)     // Catch:{ all -> 0x001c }
            r1.a(r2)     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return
        L_0x001c:
            monitor-exit(r0)
            return
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hm.a(java.util.List, android.content.Context):void");
    }
}
