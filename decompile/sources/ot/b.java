package ot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ok.i;
import rx.exceptions.a;

public final class b implements i {

    /* renamed from: a  reason: collision with root package name */
    private Set<i> f34096a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f34097b;

    private static void a(Collection<i> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (i unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            a.a((List<? extends Throwable>) arrayList);
        }
    }

    public void a(i iVar) {
        if (!iVar.isUnsubscribed()) {
            if (!this.f34097b) {
                synchronized (this) {
                    if (!this.f34097b) {
                        if (this.f34096a == null) {
                            this.f34096a = new HashSet(4);
                        }
                        this.f34096a.add(iVar);
                        return;
                    }
                }
            }
            iVar.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(ok.i r2) {
        /*
            r1 = this;
            boolean r0 = r1.f34097b
            if (r0 != 0) goto L_0x001e
            monitor-enter(r1)
            boolean r0 = r1.f34097b     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            java.util.Set<ok.i> r0 = r1.f34096a     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            r2.unsubscribe()
            goto L_0x001e
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ot.b.b(ok.i):void");
    }

    public boolean isUnsubscribed() {
        return this.f34097b;
    }

    public void unsubscribe() {
        if (!this.f34097b) {
            synchronized (this) {
                if (!this.f34097b) {
                    this.f34097b = true;
                    Set<i> set = this.f34096a;
                    this.f34096a = null;
                    a((Collection<i>) set);
                }
            }
        }
    }
}
