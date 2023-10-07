package q;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class g {

    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f34150a;

        /* renamed from: b  reason: collision with root package name */
        private int f34151b;

        /* renamed from: q.g$a$a  reason: collision with other inner class name */
        private static class C0250a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f34152a;

            C0250a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f34152a = i2;
            }

            public void run() {
                Process.setThreadPriority(this.f34152a);
                super.run();
            }
        }

        a(String str, int i2) {
            this.f34150a = str;
            this.f34151b = i2;
        }

        public Thread newThread(Runnable runnable) {
            return new C0250a(runnable, this.f34150a, this.f34151b);
        }
    }

    private static class b<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Callable<T> f34153a;

        /* renamed from: b  reason: collision with root package name */
        private s.a<T> f34154b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f34155c;

        b(Handler handler, Callable<T> callable, s.a<T> aVar) {
            this.f34153a = callable;
            this.f34154b = aVar;
            this.f34155c = handler;
        }

        public void run() {
            final T t2;
            try {
                t2 = this.f34153a.call();
            } catch (Exception unused) {
                t2 = null;
            }
            final s.a<T> aVar = this.f34154b;
            this.f34155c.post(new Runnable() {
                public void run() {
                    aVar.a(t2);
                }
            });
        }
    }

    static <T> T a(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i2, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }

    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void a(Executor executor, Callable<T> callable, s.a<T> aVar) {
        executor.execute(new b(b.a(), callable, aVar));
    }
}
