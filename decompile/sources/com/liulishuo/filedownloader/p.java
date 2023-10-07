package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.message.c;
import com.liulishuo.filedownloader.x;
import iq.d;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f21430a = new b();

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final p f21431a = new p();

        static {
            com.liulishuo.filedownloader.message.c.a().a((c.b) new aa());
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f21432a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f21433b;

        b() {
            b();
        }

        private void b() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f21433b = linkedBlockingQueue;
            this.f21432a = iq.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a() {
            if (d.f29057a) {
                d.c(this, "expire %d tasks", Integer.valueOf(this.f21433b.size()));
            }
            this.f21432a.shutdownNow();
            b();
        }

        public void a(x.b bVar) {
            this.f21432a.execute(new c(bVar));
        }

        public void b(x.b bVar) {
            this.f21433b.remove(bVar);
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final x.b f21434a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f21435b = false;

        c(x.b bVar) {
            this.f21434a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f21434a;
        }

        public void run() {
            if (!this.f21435b) {
                this.f21434a.n();
            }
        }
    }

    p() {
    }

    public static p a() {
        return a.f21431a;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(x.b bVar) {
        this.f21430a.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.f21430a.a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b(x.b bVar) {
        this.f21430a.b(bVar);
    }
}
