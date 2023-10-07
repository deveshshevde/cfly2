package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.a;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class e extends i.c implements b {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f28864a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f28865b;

    public e(ThreadFactory threadFactory) {
        this.f28865b = f.a(threadFactory);
    }

    public b a(Runnable runnable) {
        return a(runnable, 0, (TimeUnit) null);
    }

    public b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f28864a ? EmptyDisposable.INSTANCE : a(runnable, j2, timeUnit, (a) null);
    }

    public ScheduledRunnable a(Runnable runnable, long j2, TimeUnit timeUnit, a aVar) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(ly.a.a(runnable), aVar);
        if (aVar != null && !aVar.a(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j2 <= 0) {
            try {
                future = this.f28865b.submit(scheduledRunnable);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.b(scheduledRunnable);
                }
                ly.a.a((Throwable) e2);
            }
        } else {
            future = this.f28865b.schedule(scheduledRunnable, j2, timeUnit);
        }
        scheduledRunnable.a(future);
        return scheduledRunnable;
    }

    public b b(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable a2 = ly.a.a(runnable);
        if (j3 <= 0) {
            b bVar = new b(a2, this.f28865b);
            if (j2 <= 0) {
                try {
                    future = this.f28865b.submit(bVar);
                } catch (RejectedExecutionException e2) {
                    ly.a.a((Throwable) e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f28865b.schedule(bVar, j2, timeUnit);
            }
            bVar.a(future);
            return bVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(a2);
        scheduledDirectPeriodicTask.a(this.f28865b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
        return scheduledDirectPeriodicTask;
    }

    public b b(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(ly.a.a(runnable));
        if (j2 <= 0) {
            try {
                future = this.f28865b.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                ly.a.a((Throwable) e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f28865b.schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public void b() {
        if (!this.f28864a) {
            this.f28864a = true;
            this.f28865b.shutdown();
        }
    }

    public void dispose() {
        if (!this.f28864a) {
            this.f28864a = true;
            this.f28865b.shutdownNow();
        }
    }

    public boolean isDisposed() {
        return this.f28864a;
    }
}
