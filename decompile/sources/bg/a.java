package bg;

import bh.c;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5633a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5634b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f5635c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f5636d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f5633a = availableProcessors;
        int i2 = availableProcessors + 1;
        f5634b = i2;
        f5635c = i2;
    }

    private a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                bf.a.f5606a.d("ARouter::", "Task rejected, too many task!");
            }
        });
    }

    public static a a() {
        if (f5636d == null) {
            synchronized (a.class) {
                if (f5636d == null) {
                    f5636d = new a(f5634b, f5635c, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new b());
                }
            }
        }
        return f5636d;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e2) {
                th = e2;
            } catch (ExecutionException e3) {
                th = e3.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            be.a aVar = bf.a.f5606a;
            aVar.c("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + c.a(th.getStackTrace()));
        }
    }
}
