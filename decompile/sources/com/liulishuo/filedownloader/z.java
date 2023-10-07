package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import iq.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z extends e implements v {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.b> f21480a = new ArrayList<>();

    public void a() {
        w g2 = q.a().g();
        if (d.f29057a) {
            d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f21480a) {
            this.f21480a.clear();
            ArrayList arrayList = new ArrayList(g2.b());
            for (a.b bVar : (List) this.f21480a.clone()) {
                int D = bVar.D();
                if (g2.a(D)) {
                    bVar.A().a().a();
                    if (!arrayList.contains(Integer.valueOf(D))) {
                        arrayList.add(Integer.valueOf(D));
                    }
                } else {
                    bVar.I();
                }
            }
            g2.a((List<Integer>) arrayList);
        }
    }

    public boolean a(a.b bVar) {
        return !this.f21480a.isEmpty() && this.f21480a.contains(bVar);
    }

    public void b() {
        if (c() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w g2 = q.a().g();
            if (d.f29057a) {
                d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().c()));
            }
            if (h.a().c() > 0) {
                synchronized (this.f21480a) {
                    h.a().a((List<a.b>) this.f21480a);
                    Iterator<a.b> it2 = this.f21480a.iterator();
                    while (it2.hasNext()) {
                        it2.next().H();
                    }
                    g2.a();
                }
                try {
                    q.a().d();
                } catch (IllegalStateException unused) {
                    d.d(this, "restart service failed, you may need to restart downloading manually when the app comes back to foreground", new Object[0]);
                }
            }
        } else if (h.a().c() > 0) {
            d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.a().c()));
        }
    }

    public void b(a.b bVar) {
        if (!this.f21480a.isEmpty()) {
            synchronized (this.f21480a) {
                this.f21480a.remove(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(com.liulishuo.filedownloader.a.b r7) {
        /*
            r6 = this;
            com.liulishuo.filedownloader.q r0 = com.liulishuo.filedownloader.q.a()
            boolean r0 = r0.f()
            r1 = 0
            if (r0 != 0) goto L_0x0054
            java.util.ArrayList<com.liulishuo.filedownloader.a$b> r0 = r6.f21480a
            monitor-enter(r0)
            com.liulishuo.filedownloader.q r2 = com.liulishuo.filedownloader.q.a()     // Catch:{ all -> 0x0051 }
            boolean r2 = r2.f()     // Catch:{ all -> 0x0051 }
            if (r2 != 0) goto L_0x004f
            boolean r2 = iq.d.f29057a     // Catch:{ all -> 0x0051 }
            r3 = 1
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = "Waiting for connecting with the downloader service... %d"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0051 }
            com.liulishuo.filedownloader.a r5 = r7.A()     // Catch:{ all -> 0x0051 }
            int r5 = r5.e()     // Catch:{ all -> 0x0051 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0051 }
            r4[r1] = r5     // Catch:{ all -> 0x0051 }
            iq.d.c(r6, r2, r4)     // Catch:{ all -> 0x0051 }
        L_0x0032:
            com.liulishuo.filedownloader.m r1 = com.liulishuo.filedownloader.m.a()     // Catch:{ all -> 0x0051 }
            android.content.Context r2 = iq.c.a()     // Catch:{ all -> 0x0051 }
            r1.a((android.content.Context) r2)     // Catch:{ all -> 0x0051 }
            java.util.ArrayList<com.liulishuo.filedownloader.a$b> r1 = r6.f21480a     // Catch:{ all -> 0x0051 }
            boolean r1 = r1.contains(r7)     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x004d
            r7.H()     // Catch:{ all -> 0x0051 }
            java.util.ArrayList<com.liulishuo.filedownloader.a$b> r1 = r6.f21480a     // Catch:{ all -> 0x0051 }
            r1.add(r7)     // Catch:{ all -> 0x0051 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return r3
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0054
        L_0x0051:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r7
        L_0x0054:
            r6.b(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.z.c(com.liulishuo.filedownloader.a$b):boolean");
    }
}
