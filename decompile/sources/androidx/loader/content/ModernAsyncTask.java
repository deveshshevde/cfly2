package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f3667a;

    /* renamed from: b  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3668b;

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f3669c;

    /* renamed from: f  reason: collision with root package name */
    private static b f3670f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Executor f3671g;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f3672d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f3673e = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private final c<Params, Result> f3674h;

    /* renamed from: i  reason: collision with root package name */
    private final FutureTask<Result> f3675i;

    /* renamed from: j  reason: collision with root package name */
    private volatile Status f3676j = Status.PENDING;

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3680a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3680a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3680a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.AnonymousClass4.<clinit>():void");
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f3685a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f3686b;

        a(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f3685a = modernAsyncTask;
            this.f3686b = dataArr;
        }
    }

    private static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f3685a.e(aVar.f3686b[0]);
            } else if (i2 == 2) {
                aVar.f3685a.b((Progress[]) aVar.f3686b);
            }
        }
    }

    private static abstract class c<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f3687b;

        c() {
        }
    }

    static {
        AnonymousClass1 r7 = new ThreadFactory() {

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f3677a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f3677a.getAndIncrement());
            }
        };
        f3667a = r7;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3668b = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r7);
        f3669c = threadPoolExecutor;
        f3671g = threadPoolExecutor;
    }

    ModernAsyncTask() {
        AnonymousClass2 r0 = new c<Params, Result>() {
            public Result call() throws Exception {
                ModernAsyncTask.this.f3673e.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = ModernAsyncTask.this.a((Params[]) this.f3687b);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.d(result);
                    return result;
                } catch (Throwable th) {
                    ModernAsyncTask.this.d(result);
                    throw th;
                }
            }
        };
        this.f3674h = r0;
        this.f3675i = new FutureTask<Result>(r0) {
            /* access modifiers changed from: protected */
            public void done() {
                try {
                    ModernAsyncTask.this.c(get());
                } catch (InterruptedException e2) {
                    Log.w("AsyncTask", e2);
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.c(null);
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler d() {
        b bVar;
        synchronized (ModernAsyncTask.class) {
            if (f3670f == null) {
                f3670f = new b();
            }
            bVar = f3670f;
        }
        return bVar;
    }

    public final ModernAsyncTask<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.f3676j != Status.PENDING) {
            int i2 = AnonymousClass4.f3680a[this.f3676j.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f3676j = Status.RUNNING;
            a();
            this.f3674h.f3687b = paramsArr;
            executor.execute(this.f3675i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    public final boolean a(boolean z2) {
        this.f3672d.set(true);
        return this.f3675i.cancel(z2);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        b();
    }

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    /* access modifiers changed from: package-private */
    public void c(Result result) {
        if (!this.f3673e.get()) {
            d(result);
        }
    }

    public final boolean c() {
        return this.f3672d.get();
    }

    /* access modifiers changed from: package-private */
    public Result d(Result result) {
        d().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: package-private */
    public void e(Result result) {
        if (c()) {
            b(result);
        } else {
            a(result);
        }
        this.f3676j = Status.FINISHED;
    }
}
