package bg;

import bf.a;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f5637a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f5638b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    private final ThreadGroup f5639c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5640d;

    public b() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f5639c = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f5640d = "ARouter task pool No." + f5637a.getAndIncrement() + ", thread No.";
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f5640d + this.f5638b.getAndIncrement();
        a.f5606a.b("ARouter::", "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f5639c, runnable, str, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                be.a aVar = a.f5606a;
                aVar.b("ARouter::", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
            }
        });
        return thread;
    }
}
