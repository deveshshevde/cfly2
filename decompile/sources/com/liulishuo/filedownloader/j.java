package com.liulishuo.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class j {

    /* renamed from: a  reason: collision with root package name */
    static int f21352a = 10;

    /* renamed from: b  reason: collision with root package name */
    static int f21353b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f21354c = iq.b.a(5, "BlockCompleted");

    /* renamed from: d  reason: collision with root package name */
    private final Handler f21355d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedBlockingQueue<t> f21356e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f21357f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<t> f21358g;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final j f21360a = new j();
    }

    private static class b implements Handler.Callback {
        private b() {
        }

        private void a(ArrayList<t> arrayList) {
            Iterator<t> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                t next = it2.next();
                if (!j.d(next)) {
                    next.b();
                }
            }
            arrayList.clear();
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((t) message.obj).b();
            } else if (message.what == 2) {
                a((ArrayList) message.obj);
                j.a().c();
            }
            return true;
        }
    }

    private j() {
        this.f21357f = new Object();
        this.f21358g = new ArrayList<>();
        this.f21355d = new Handler(Looper.getMainLooper(), new b());
        this.f21356e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f21360a;
    }

    public static boolean b() {
        return f21352a > 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r0 = r6.f21355d;
        r0.sendMessageDelayed(r0.obtainMessage(2, r6.f21358g), (long) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f21357f
            monitor-enter(r0)
            java.util.ArrayList<com.liulishuo.filedownloader.t> r1 = r6.f21358g     // Catch:{ all -> 0x0054 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x000d:
            java.util.concurrent.LinkedBlockingQueue<com.liulishuo.filedownloader.t> r1 = r6.f21356e     // Catch:{ all -> 0x0054 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x0017:
            boolean r1 = b()     // Catch:{ all -> 0x0054 }
            r2 = 0
            if (r1 != 0) goto L_0x0026
            java.util.concurrent.LinkedBlockingQueue<com.liulishuo.filedownloader.t> r1 = r6.f21356e     // Catch:{ all -> 0x0054 }
            java.util.ArrayList<com.liulishuo.filedownloader.t> r3 = r6.f21358g     // Catch:{ all -> 0x0054 }
            r1.drainTo(r3)     // Catch:{ all -> 0x0054 }
            goto L_0x0045
        L_0x0026:
            int r1 = f21352a     // Catch:{ all -> 0x0054 }
            java.util.concurrent.LinkedBlockingQueue<com.liulishuo.filedownloader.t> r3 = r6.f21356e     // Catch:{ all -> 0x0054 }
            int r3 = r3.size()     // Catch:{ all -> 0x0054 }
            int r4 = f21353b     // Catch:{ all -> 0x0054 }
            int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x0054 }
        L_0x0034:
            if (r2 >= r3) goto L_0x0044
            java.util.ArrayList<com.liulishuo.filedownloader.t> r4 = r6.f21358g     // Catch:{ all -> 0x0054 }
            java.util.concurrent.LinkedBlockingQueue<com.liulishuo.filedownloader.t> r5 = r6.f21356e     // Catch:{ all -> 0x0054 }
            java.lang.Object r5 = r5.remove()     // Catch:{ all -> 0x0054 }
            r4.add(r5)     // Catch:{ all -> 0x0054 }
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0044:
            r2 = r1
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            android.os.Handler r0 = r6.f21355d
            r1 = 2
            java.util.ArrayList<com.liulishuo.filedownloader.t> r3 = r6.f21358g
            android.os.Message r1 = r0.obtainMessage(r1, r3)
            long r2 = (long) r2
            r0.sendMessageDelayed(r1, r2)
            return
        L_0x0054:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0057:
            throw r1
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.j.c():void");
    }

    private void c(t tVar) {
        Handler handler = this.f21355d;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    /* access modifiers changed from: private */
    public static boolean d(final t tVar) {
        if (!tVar.d()) {
            return false;
        }
        f21354c.execute(new Runnable() {
            public void run() {
                tVar.b();
            }
        });
        return true;
    }

    private void e(t tVar) {
        synchronized (this.f21357f) {
            this.f21356e.offer(tVar);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(t tVar) {
        a(tVar, false);
    }

    /* access modifiers changed from: package-private */
    public void a(t tVar, boolean z2) {
        if (tVar.c()) {
            tVar.b();
        } else if (!d(tVar)) {
            if (!b() && !this.f21356e.isEmpty()) {
                synchronized (this.f21357f) {
                    if (!this.f21356e.isEmpty()) {
                        Iterator<t> it2 = this.f21356e.iterator();
                        while (it2.hasNext()) {
                            c(it2.next());
                        }
                    }
                    this.f21356e.clear();
                }
            }
            if (!b() || z2) {
                c(tVar);
            } else {
                e(tVar);
            }
        }
    }
}
