package io.reactivex.internal.schedulers;

import io.reactivex.disposables.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import lw.a;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements b {

    /* renamed from: c  reason: collision with root package name */
    protected static final FutureTask<Void> f28811c = new FutureTask<>(a.f31010b, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    protected static final FutureTask<Void> f28812d = new FutureTask<>(a.f31010b, (Object) null);
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: a  reason: collision with root package name */
    protected final Runnable f28813a;

    /* renamed from: b  reason: collision with root package name */
    protected Thread f28814b;

    AbstractDirectTask(Runnable runnable) {
        this.f28813a = runnable;
    }

    public final void a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f28811c) {
                if (future2 == f28812d) {
                    future.cancel(this.f28814b != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != f28811c && future != (futureTask = f28812d) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.f28814b != Thread.currentThread());
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        return future == f28811c || future == f28812d;
    }
}
