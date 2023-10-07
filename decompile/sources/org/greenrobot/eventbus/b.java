package org.greenrobot.eventbus;

import java.util.logging.Level;

final class b implements Runnable, k {

    /* renamed from: a  reason: collision with root package name */
    private final j f13995a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final c f13996b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f13997c;

    b(c cVar) {
        this.f13996b = cVar;
    }

    public void a(p pVar, Object obj) {
        i a2 = i.a(pVar, obj);
        synchronized (this) {
            this.f13995a.a(a2);
            if (!this.f13997c) {
                this.f13997c = true;
                this.f13996b.c().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                i a2 = this.f13995a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f13995a.a();
                        if (a2 == null) {
                            this.f13997c = false;
                            this.f13997c = false;
                            return;
                        }
                    }
                }
                this.f13996b.a(a2);
            } catch (InterruptedException e2) {
                try {
                    f d2 = this.f13996b.d();
                    Level level = Level.WARNING;
                    d2.a(level, Thread.currentThread().getName() + " was interruppted", e2);
                    return;
                } finally {
                    this.f13997c = false;
                }
            }
        }
    }
}
