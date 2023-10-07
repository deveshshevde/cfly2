package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bb f8047a;

    /* renamed from: b  reason: collision with root package name */
    private static gd f8048b;

    /* renamed from: c  reason: collision with root package name */
    private Context f8049c;

    private bb(Context context) {
        this.f8049c = context;
        f8048b = b(context);
    }

    public static bb a(Context context) {
        if (f8047a == null) {
            synchronized (bb.class) {
                if (f8047a == null) {
                    f8047a = new bb(context);
                }
            }
        }
        return f8047a;
    }

    private static List<String> a(List<ay> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (ay a2 : list) {
                arrayList.add(a2.a());
            }
        }
        return arrayList;
    }

    private synchronized void a(String str, int i2, long j2, long[] jArr, long[] jArr2) {
        if (b()) {
            f8048b.a((Object) new ax(str, j2, i2, jArr[0], jArr2[0]), ax.a(str));
        }
    }

    private static void a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            String a2 = ay.a(str);
            if (f8048b.b(a2, ay.class).size() > 0) {
                f8048b.a(a2, ay.class);
            }
            String[] split = str2.split(";");
            ArrayList arrayList = new ArrayList();
            for (String ayVar : split) {
                arrayList.add(new ay(str, ayVar));
            }
            f8048b.a(arrayList);
        }
    }

    private static gd b(Context context) {
        try {
            return new gd(context, ba.a());
        } catch (Throwable th) {
            fz.c(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean b() {
        if (f8048b == null) {
            f8048b = b(this.f8049c);
        }
        return f8048b != null;
    }

    public final synchronized aw a(String str) {
        if (!b()) {
            return null;
        }
        List<aw> b2 = f8048b.b(aw.e(str), aw.class);
        if (b2.size() <= 0) {
            return null;
        }
        return b2.get(0);
    }

    public final ArrayList<aw> a() {
        ArrayList<aw> arrayList = new ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        for (aw add : f8048b.b("", aw.class)) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final synchronized void a(aw awVar) {
        if (b()) {
            f8048b.a((Object) awVar, aw.f(awVar.h()));
            a(awVar.e(), awVar.a());
        }
    }

    public final void a(String str, int i2, long j2, long j3, long j4) {
        if (b()) {
            a(str, i2, j2, new long[]{j3, 0, 0, 0, 0}, new long[]{j4, 0, 0, 0, 0});
        }
    }

    public final synchronized List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a(f8048b.b(ay.a(str), ay.class)));
        return arrayList;
    }

    public final synchronized void b(aw awVar) {
        if (b()) {
            f8048b.a(az.f(awVar.h()), az.class);
            f8048b.a(ay.a(awVar.e()), ay.class);
            f8048b.a(ax.a(awVar.e()), ax.class);
        }
    }

    public final synchronized void c(String str) {
        if (b()) {
            f8048b.a(az.e(str), az.class);
            f8048b.a(ay.a(str), ay.class);
            f8048b.a(ax.a(str), ax.class);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String d(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.b()     // Catch:{ all -> 0x0029 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            java.lang.String r4 = com.amap.api.mapcore.util.az.f(r4)     // Catch:{ all -> 0x0029 }
            com.amap.api.mapcore.util.gd r0 = f8048b     // Catch:{ all -> 0x0029 }
            java.lang.Class<com.amap.api.mapcore.util.az> r2 = com.amap.api.mapcore.util.az.class
            java.util.List r4 = r0.b((java.lang.String) r4, r2)     // Catch:{ all -> 0x0029 }
            int r0 = r4.size()     // Catch:{ all -> 0x0029 }
            if (r0 <= 0) goto L_0x0027
            r0 = 0
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0029 }
            com.amap.api.mapcore.util.az r4 = (com.amap.api.mapcore.util.az) r4     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r4.d()     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r3)
            return r1
        L_0x0029:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bb.d(java.lang.String):java.lang.String");
    }
}
