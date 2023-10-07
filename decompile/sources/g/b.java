package g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f28352a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f28353b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f28356b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f28356b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f28354c;

    private static Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, true});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    public void a(Runnable runnable) {
        this.f28353b.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.f28354c == null) {
            synchronized (this.f28352a) {
                if (this.f28354c == null) {
                    this.f28354c = a(Looper.getMainLooper());
                }
            }
        }
        this.f28354c.post(runnable);
    }

    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
