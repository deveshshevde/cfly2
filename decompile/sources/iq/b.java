package iq;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b {

    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicInteger f29052a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        private final String f29053b;

        /* renamed from: c  reason: collision with root package name */
        private final ThreadGroup f29054c = Thread.currentThread().getThreadGroup();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f29055d = new AtomicInteger(1);

        a(String str) {
            this.f29053b = f.j(str);
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f29054c;
            Thread thread = new Thread(threadGroup, runnable, this.f29053b + this.f29055d.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ThreadPoolExecutor a(int i2, String str) {
        return a(i2, new LinkedBlockingQueue(), str);
    }

    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor a(String str) {
        return new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 15, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
    }
}
