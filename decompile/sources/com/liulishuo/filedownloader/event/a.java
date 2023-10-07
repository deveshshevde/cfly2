package com.liulishuo.filedownloader.event;

import iq.b;
import iq.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f21334a = b.a(10, "EventPool");

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, LinkedList<c>> f21335b = new HashMap<>();

    private void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((c) obj).a(bVar)) {
                break;
            }
        }
        if (bVar.f21338a != null) {
            bVar.f21338a.run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.liulishuo.filedownloader.event.b r6) {
        /*
            r5 = this;
            boolean r0 = iq.d.f29057a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = "publish %s"
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r6.b()
            r3[r1] = r4
            iq.d.e(r5, r0, r3)
        L_0x0013:
            if (r6 == 0) goto L_0x004a
            java.lang.String r0 = r6.b()
            java.util.HashMap<java.lang.String, java.util.LinkedList<com.liulishuo.filedownloader.event.c>> r3 = r5.f21335b
            java.lang.Object r3 = r3.get(r0)
            java.util.LinkedList r3 = (java.util.LinkedList) r3
            if (r3 != 0) goto L_0x0046
            java.lang.String r4 = r0.intern()
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.util.LinkedList<com.liulishuo.filedownloader.event.c>> r3 = r5.f21335b     // Catch:{ all -> 0x0043 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0043 }
            java.util.LinkedList r3 = (java.util.LinkedList) r3     // Catch:{ all -> 0x0043 }
            if (r3 != 0) goto L_0x0041
            boolean r6 = iq.d.f29057a     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x003f
            java.lang.String r6 = "No listener for this event %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0043 }
            r2[r1] = r0     // Catch:{ all -> 0x0043 }
            iq.d.c(r5, r6, r2)     // Catch:{ all -> 0x0043 }
        L_0x003f:
            monitor-exit(r4)     // Catch:{ all -> 0x0043 }
            return r1
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r6 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0043 }
            throw r6
        L_0x0046:
            r5.a((java.util.LinkedList<com.liulishuo.filedownloader.event.c>) r3, (com.liulishuo.filedownloader.event.b) r6)
            return r2
        L_0x004a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "event must not be null!"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.event.a.a(com.liulishuo.filedownloader.event.b):boolean");
    }

    public boolean a(String str, c cVar) {
        boolean add;
        if (d.f29057a) {
            d.e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList linkedList = this.f21335b.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.f21335b.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.f21335b;
                        LinkedList linkedList2 = new LinkedList();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public void b(final b bVar) {
        if (d.f29057a) {
            d.e(this, "asyncPublishInNewThread %s", bVar.b());
        }
        if (bVar != null) {
            this.f21334a.execute(new Runnable() {
                public void run() {
                    a.this.a(bVar);
                }
            });
            return;
        }
        throw new IllegalArgumentException("event must not be null!");
    }
}
