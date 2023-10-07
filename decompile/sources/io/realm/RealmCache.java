package io.realm;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class RealmCache {

    /* renamed from: c  reason: collision with root package name */
    private static final List<WeakReference<RealmCache>> f28911c = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    private static final Collection<RealmCache> f28912e = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap<RealmCacheType, a> f28913a;

    /* renamed from: b  reason: collision with root package name */
    private h f28914b;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f28915d;

    private enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType a(Class<? extends a> cls) {
            if (cls == f.class) {
                return TYPED_REALM;
            }
            if (cls == b.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ThreadLocal<a> f28919a = new ThreadLocal<>();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ThreadLocal<Integer> f28920b = new ThreadLocal<>();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f28921c = 0;

        private a() {
        }

        static /* synthetic */ int c(a aVar) {
            int i2 = aVar.f28921c;
            aVar.f28921c = i2 - 1;
            return i2;
        }
    }

    private int b() {
        int i2 = 0;
        for (a d2 : this.f28913a.values()) {
            i2 += d2.f28921c;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f28915d.getAndSet(true)) {
            f28912e.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(io.realm.a r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r7.a()     // Catch:{ all -> 0x00a6 }
            java.util.EnumMap<io.realm.RealmCache$RealmCacheType, io.realm.RealmCache$a> r1 = r6.f28913a     // Catch:{ all -> 0x00a6 }
            java.lang.Class r2 = r7.getClass()     // Catch:{ all -> 0x00a6 }
            io.realm.RealmCache$RealmCacheType r2 = io.realm.RealmCache.RealmCacheType.a(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00a6 }
            io.realm.RealmCache$a r1 = (io.realm.RealmCache.a) r1     // Catch:{ all -> 0x00a6 }
            java.lang.ThreadLocal r2 = r1.f28920b     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00a6 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00a6 }
            r3 = 0
            if (r2 != 0) goto L_0x0026
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00a6 }
        L_0x0026:
            int r4 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            r5 = 1
            if (r4 > 0) goto L_0x003b
            java.lang.String r7 = "%s has been closed already. refCount is %s"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a6 }
            r1[r3] = r0     // Catch:{ all -> 0x00a6 }
            r1[r5] = r2     // Catch:{ all -> 0x00a6 }
            io.realm.log.RealmLog.a(r7, r1)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r6)
            return
        L_0x003b:
            int r2 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            int r2 = r2 - r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a6 }
            int r3 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            if (r3 != 0) goto L_0x009d
            java.lang.ThreadLocal r2 = r1.f28920b     // Catch:{ all -> 0x00a6 }
            r3 = 0
            r2.set(r3)     // Catch:{ all -> 0x00a6 }
            java.lang.ThreadLocal r2 = r1.f28919a     // Catch:{ all -> 0x00a6 }
            r2.set(r3)     // Catch:{ all -> 0x00a6 }
            io.realm.RealmCache.a.c(r1)     // Catch:{ all -> 0x00a6 }
            int r1 = r1.f28921c     // Catch:{ all -> 0x00a6 }
            if (r1 < 0) goto L_0x0081
            r7.c()     // Catch:{ all -> 0x00a6 }
            int r0 = r6.b()     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x00a4
            r6.f28914b = r3     // Catch:{ all -> 0x00a6 }
            io.realm.h r0 = r7.b()     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.i()     // Catch:{ all -> 0x00a6 }
            io.realm.internal.f r0 = io.realm.internal.f.a((boolean) r0)     // Catch:{ all -> 0x00a6 }
            io.realm.h r7 = r7.b()     // Catch:{ all -> 0x00a6 }
            r0.a((io.realm.h) r7)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a4
        L_0x0081:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "Global reference counter of Realm"
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            r1.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = " got corrupted."
            r1.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00a6 }
            r7.<init>(r0)     // Catch:{ all -> 0x00a6 }
            throw r7     // Catch:{ all -> 0x00a6 }
        L_0x009d:
            java.lang.ThreadLocal r7 = r1.f28920b     // Catch:{ all -> 0x00a6 }
            r7.set(r2)     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r6)
            return
        L_0x00a6:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmCache.a(io.realm.a):void");
    }
}
