package bn;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final long f5828a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f5829b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f5830c;

    /* renamed from: bn.a$a  reason: collision with other inner class name */
    public static final class C0052a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5831a;

        /* renamed from: b  reason: collision with root package name */
        private int f5832b;

        /* renamed from: c  reason: collision with root package name */
        private int f5833c;

        /* renamed from: d  reason: collision with root package name */
        private final ThreadFactory f5834d = new b();

        /* renamed from: e  reason: collision with root package name */
        private d f5835e = d.f5849d;

        /* renamed from: f  reason: collision with root package name */
        private String f5836f;

        /* renamed from: g  reason: collision with root package name */
        private long f5837g;

        C0052a(boolean z2) {
            this.f5831a = z2;
        }

        public C0052a a(int i2) {
            this.f5832b = i2;
            this.f5833c = i2;
            return this;
        }

        public C0052a a(String str) {
            this.f5836f = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f5836f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f5832b, this.f5833c, this.f5837g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c(this.f5834d, this.f5836f, this.f5835e, this.f5831a));
                if (this.f5837g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f5836f);
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable) {
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    private static final class c implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final d f5839a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f5840b;

        /* renamed from: c  reason: collision with root package name */
        private final ThreadFactory f5841c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5842d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicInteger f5843e = new AtomicInteger();

        c(ThreadFactory threadFactory, String str, d dVar, boolean z2) {
            this.f5841c = threadFactory;
            this.f5842d = str;
            this.f5839a = dVar;
            this.f5840b = z2;
        }

        public Thread newThread(final Runnable runnable) {
            Thread newThread = this.f5841c.newThread(new Runnable() {
                public void run() {
                    if (c.this.f5840b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        c.this.f5839a.a(th);
                    }
                }
            });
            newThread.setName("glide-" + this.f5842d + "-thread-" + this.f5843e.getAndIncrement());
            return newThread;
        }
    }

    public interface d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f5846a = new d() {
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final d f5847b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f5848c = new d() {
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final d f5849d;

        static {
            AnonymousClass2 r0 = new d() {
                public void a(Throwable th) {
                    if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            f5847b = r0;
            f5849d = r0;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f5830c = executorService;
    }

    public static C0052a a() {
        return new C0052a(true).a(1).a("disk-cache");
    }

    public static a b() {
        return a().a();
    }

    public static C0052a c() {
        return new C0052a(false).a(h()).a("source");
    }

    public static a d() {
        return c().a();
    }

    public static a e() {
        return new a(new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, f5828a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new c(new b(), "source-unlimited", d.f5849d, false)));
    }

    public static C0052a f() {
        return new C0052a(true).a(h() >= 4 ? 2 : 1).a("animation");
    }

    public static a g() {
        return f().a();
    }

    public static int h() {
        if (f5829b == 0) {
            f5829b = Math.min(4, b.a());
        }
        return f5829b;
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f5830c.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f5830c.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f5830c.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f5830c.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f5830c.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f5830c.invokeAny(collection, j2, timeUnit);
    }

    public boolean isShutdown() {
        return this.f5830c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f5830c.isTerminated();
    }

    public void shutdown() {
        this.f5830c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f5830c.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f5830c.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.f5830c.submit(runnable, t2);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f5830c.submit(callable);
    }

    public String toString() {
        return this.f5830c.toString();
    }
}
