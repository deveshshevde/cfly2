package androidx.work.impl.utils;

import androidx.work.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class n {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5427d = j.a("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    final Map<String, b> f5428a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<String, a> f5429b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Object f5430c = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final ThreadFactory f5431e;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f5432f;

    public interface a {
        void a(String str);
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final n f5435a;

        /* renamed from: b  reason: collision with root package name */
        private final String f5436b;

        b(n nVar, String str) {
            this.f5435a = nVar;
            this.f5436b = str;
        }

        public void run() {
            synchronized (this.f5435a.f5430c) {
                if (this.f5435a.f5428a.remove(this.f5436b) != null) {
                    a remove = this.f5435a.f5429b.remove(this.f5436b);
                    if (remove != null) {
                        remove.a(this.f5436b);
                    }
                } else {
                    j.a().b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f5436b}), new Throwable[0]);
                }
            }
        }
    }

    public n() {
        AnonymousClass1 r0 = new ThreadFactory() {

            /* renamed from: b  reason: collision with root package name */
            private int f5434b = 0;

            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.f5434b);
                this.f5434b = this.f5434b + 1;
                return newThread;
            }
        };
        this.f5431e = r0;
        this.f5432f = Executors.newSingleThreadScheduledExecutor(r0);
    }

    public void a() {
        if (!this.f5432f.isShutdown()) {
            this.f5432f.shutdownNow();
        }
    }

    public void a(String str) {
        synchronized (this.f5430c) {
            if (this.f5428a.remove(str) != null) {
                j.a().b(f5427d, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f5429b.remove(str);
            }
        }
    }

    public void a(String str, long j2, a aVar) {
        synchronized (this.f5430c) {
            j.a().b(f5427d, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            a(str);
            b bVar = new b(this, str);
            this.f5428a.put(str, bVar);
            this.f5429b.put(str, aVar);
            this.f5432f.schedule(bVar, j2, TimeUnit.MILLISECONDS);
        }
    }
}
