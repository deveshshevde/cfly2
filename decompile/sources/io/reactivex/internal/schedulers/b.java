package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import lw.a;

final class b implements io.reactivex.disposables.b, Callable<Void> {

    /* renamed from: f  reason: collision with root package name */
    static final FutureTask<Void> f28837f = new FutureTask<>(a.f31010b, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Runnable f28838a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Future<?>> f28839b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f28840c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final ExecutorService f28841d;

    /* renamed from: e  reason: collision with root package name */
    Thread f28842e;

    b(Runnable runnable, ExecutorService executorService) {
        this.f28838a = runnable;
        this.f28841d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f28842e = Thread.currentThread();
        try {
            this.f28838a.run();
            b(this.f28841d.submit(this));
            this.f28842e = null;
        } catch (Throwable th) {
            this.f28842e = null;
            ly.a.a(th);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future future2;
        do {
            future2 = this.f28840c.get();
            if (future2 == f28837f) {
                future.cancel(this.f28842e != Thread.currentThread());
                return;
            }
        } while (!this.f28840c.compareAndSet(future2, future));
    }

    /* access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future future2;
        do {
            future2 = this.f28839b.get();
            if (future2 == f28837f) {
                future.cancel(this.f28842e != Thread.currentThread());
                return;
            }
        } while (!this.f28839b.compareAndSet(future2, future));
    }

    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f28840c;
        Future future = f28837f;
        Future andSet = atomicReference.getAndSet(future);
        boolean z2 = true;
        if (!(andSet == null || andSet == future)) {
            andSet.cancel(this.f28842e != Thread.currentThread());
        }
        Future andSet2 = this.f28839b.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f28842e == Thread.currentThread()) {
                z2 = false;
            }
            andSet2.cancel(z2);
        }
    }

    public boolean isDisposed() {
        return this.f28840c.get() == f28837f;
    }
}
