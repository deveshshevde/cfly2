package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f5389a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f5390b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5391c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private volatile Runnable f5392d;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final g f5393a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f5394b;

        a(g gVar, Runnable runnable) {
            this.f5393a = gVar;
            this.f5394b = runnable;
        }

        public void run() {
            try {
                this.f5394b.run();
            } finally {
                this.f5393a.a();
            }
        }
    }

    public g(Executor executor) {
        this.f5390b = executor;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f5391c) {
            Runnable poll = this.f5389a.poll();
            this.f5392d = poll;
            if (poll != null) {
                this.f5390b.execute(this.f5392d);
            }
        }
    }

    public boolean b() {
        boolean z2;
        synchronized (this.f5391c) {
            z2 = !this.f5389a.isEmpty();
        }
        return z2;
    }

    public void execute(Runnable runnable) {
        synchronized (this.f5391c) {
            this.f5389a.add(new a(this, runnable));
            if (this.f5392d == null) {
                a();
            }
        }
    }
}
