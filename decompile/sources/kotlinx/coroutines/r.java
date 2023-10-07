package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.f;
import mr.d;

public final class r extends ay {

    /* renamed from: b  reason: collision with root package name */
    public static final r f30447b = new r();

    /* renamed from: e  reason: collision with root package name */
    private static final int f30448e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f30449f;
    private static volatile Executor pool;

    static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f30450a;

        a(AtomicInteger atomicInteger) {
            this.f30450a = atomicInteger;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f30450a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final b f30451a = new b();

        b() {
        }

        public final void run() {
        }
    }

    static {
        String str;
        int i2;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            Integer a2 = f.a(str);
            if (a2 == null || a2.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
            i2 = a2.intValue();
        } else {
            i2 = -1;
        }
        f30448e = i2;
    }

    private r() {
    }

    private final int a() {
        Integer valueOf = Integer.valueOf(f30448e);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : d.c(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    private final ExecutorService b() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return c();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return c();
        }
        if (!f30449f && f30448e < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke((Object) null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!f30447b.a(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(f30447b.a())});
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : c();
    }

    private final ExecutorService c() {
        return Executors.newFixedThreadPool(a(), new a(new AtomicInteger()));
    }

    private final synchronized Executor d() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            ExecutorService b2 = b();
            pool = b2;
            executor = b2;
        }
        return executor;
    }

    public void a(kotlin.coroutines.f fVar, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = d();
            }
            bz a2 = ca.a();
            if (a2 == null || (runnable2 = a2.a(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            bz a3 = ca.a();
            if (a3 != null) {
                a3.c();
            }
            ai.f30301b.a(runnable);
        }
    }

    public final boolean a(Class<?> cls, ExecutorService executorService) {
        executorService.submit(b.f30451a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public String toString() {
        return "CommonPool";
    }
}
