package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import ok.i;
import rx.exceptions.a;

public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<i> f34392a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f34393b;

    public e() {
    }

    public e(i iVar) {
        LinkedList<i> linkedList = new LinkedList<>();
        this.f34392a = linkedList;
        linkedList.add(iVar);
    }

    public e(i... iVarArr) {
        this.f34392a = new LinkedList<>(Arrays.asList(iVarArr));
    }

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
            if (!this.f34393b) {
                synchronized (this) {
                    if (!this.f34393b) {
                        LinkedList<i> linkedList = this.f34392a;
                        if (linkedList == null) {
                            linkedList = new LinkedList<>();
                            this.f34392a = linkedList;
                        }
                        linkedList.add(iVar);
                        return;
                    }
                }
            }
            iVar.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r3.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(ok.i r3) {
        /*
            r2 = this;
            boolean r0 = r2.f34393b
            if (r0 != 0) goto L_0x001e
            monitor-enter(r2)
            java.util.LinkedList<ok.i> r0 = r2.f34392a     // Catch:{ all -> 0x001b }
            boolean r1 = r2.f34393b     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0019
            if (r0 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r0 = r0.remove(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            r3.unsubscribe()
            goto L_0x001e
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.e.b(ok.i):void");
    }

    public boolean isUnsubscribed() {
        return this.f34393b;
    }

    public void unsubscribe() {
        if (!this.f34393b) {
            synchronized (this) {
                if (!this.f34393b) {
                    this.f34393b = true;
                    LinkedList<i> linkedList = this.f34392a;
                    this.f34392a = null;
                    a((Collection<i>) linkedList);
                }
            }
        }
    }
}
