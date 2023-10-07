package cc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class h<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, a<Y>> f6184a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f6185b;

    /* renamed from: c  reason: collision with root package name */
    private long f6186c;

    /* renamed from: d  reason: collision with root package name */
    private long f6187d;

    static final class a<Y> {

        /* renamed from: a  reason: collision with root package name */
        final Y f6188a;

        /* renamed from: b  reason: collision with root package name */
        final int f6189b;

        a(Y y2, int i2) {
            this.f6188a = y2;
            this.f6189b = i2;
        }
    }

    public h(long j2) {
        this.f6185b = j2;
        this.f6186c = j2;
    }

    private void c() {
        a(this.f6186c);
    }

    /* access modifiers changed from: protected */
    public int a(Y y2) {
        return 1;
    }

    public void a() {
        a(0);
    }

    /* access modifiers changed from: protected */
    public synchronized void a(long j2) {
        while (this.f6187d > j2) {
            Iterator<Map.Entry<T, a<Y>>> it2 = this.f6184a.entrySet().iterator();
            Map.Entry next = it2.next();
            a aVar = (a) next.getValue();
            this.f6187d -= (long) aVar.f6189b;
            Object key = next.getKey();
            it2.remove();
            a(key, aVar.f6188a);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t2, Y y2) {
    }

    public synchronized long b() {
        return this.f6186c;
    }

    public synchronized Y b(T t2) {
        a aVar;
        aVar = this.f6184a.get(t2);
        return aVar != null ? aVar.f6188a : null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized Y b(T r8, Y r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.a(r9)     // Catch:{ all -> 0x004a }
            long r1 = (long) r0     // Catch:{ all -> 0x004a }
            long r3 = r7.f6186c     // Catch:{ all -> 0x004a }
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x0012
            r7.a(r8, r9)     // Catch:{ all -> 0x004a }
            monitor-exit(r7)
            return r5
        L_0x0012:
            if (r9 == 0) goto L_0x0019
            long r3 = r7.f6187d     // Catch:{ all -> 0x004a }
            long r3 = r3 + r1
            r7.f6187d = r3     // Catch:{ all -> 0x004a }
        L_0x0019:
            java.util.Map<T, cc.h$a<Y>> r1 = r7.f6184a     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x001f
            r2 = r5
            goto L_0x0024
        L_0x001f:
            cc.h$a r2 = new cc.h$a     // Catch:{ all -> 0x004a }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x004a }
        L_0x0024:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x004a }
            cc.h$a r0 = (cc.h.a) r0     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0041
            long r1 = r7.f6187d     // Catch:{ all -> 0x004a }
            int r3 = r0.f6189b     // Catch:{ all -> 0x004a }
            long r3 = (long) r3     // Catch:{ all -> 0x004a }
            long r1 = r1 - r3
            r7.f6187d = r1     // Catch:{ all -> 0x004a }
            Y r1 = r0.f6188a     // Catch:{ all -> 0x004a }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x0041
            Y r9 = r0.f6188a     // Catch:{ all -> 0x004a }
            r7.a(r8, r9)     // Catch:{ all -> 0x004a }
        L_0x0041:
            r7.c()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            Y r5 = r0.f6188a     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r7)
            return r5
        L_0x004a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.h.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public synchronized Y c(T t2) {
        a remove = this.f6184a.remove(t2);
        if (remove == null) {
            return null;
        }
        this.f6187d -= (long) remove.f6189b;
        return remove.f6188a;
    }
}
