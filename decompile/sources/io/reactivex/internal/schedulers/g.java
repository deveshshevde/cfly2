package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class g extends i {

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f28872d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f28873e;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f28874b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f28875c;

    static final class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f28876a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.disposables.a f28877b = new io.reactivex.disposables.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28878c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f28876a = scheduledExecutorService;
        }

        public b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            Future future;
            if (this.f28878c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(ly.a.a(runnable), this.f28877b);
            this.f28877b.a((b) scheduledRunnable);
            if (j2 <= 0) {
                try {
                    future = this.f28876a.submit(scheduledRunnable);
                } catch (RejectedExecutionException e2) {
                    dispose();
                    ly.a.a((Throwable) e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f28876a.schedule(scheduledRunnable, j2, timeUnit);
            }
            scheduledRunnable.a(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f28878c) {
                this.f28878c = true;
                this.f28877b.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f28878c;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f28873e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public g() {
        this(f28872d);
    }

    public g(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f28875c = atomicReference;
        this.f28874b = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return f.a(threadFactory);
    }

    public b a(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable a2 = ly.a.a(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f28875c.get();
            b bVar = new b(a2, scheduledExecutorService);
            if (j2 <= 0) {
                try {
                    future = scheduledExecutorService.submit(bVar);
                } catch (RejectedExecutionException e2) {
                    ly.a.a((Throwable) e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(bVar, j2, timeUnit);
            }
            bVar.a(future);
            return bVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(a2);
        scheduledDirectPeriodicTask.a(this.f28875c.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
        return scheduledDirectPeriodicTask;
    }

    public b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(ly.a.a(runnable));
        if (j2 <= 0) {
            try {
                future = this.f28875c.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                ly.a.a((Throwable) e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f28875c.get().schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public i.c a() {
        return new a(this.f28875c.get());
    }

    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f28875c.get();
            if (scheduledExecutorService != f28873e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.f28874b);
            }
        } while (!this.f28875c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }
}
