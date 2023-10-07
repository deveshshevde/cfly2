package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import oj.c;

public final class FlowableTimer extends b<Long> {

    /* renamed from: b  reason: collision with root package name */
    final i f28759b;

    /* renamed from: c  reason: collision with root package name */
    final long f28760c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28761d;

    static final class TimerSubscriber extends AtomicReference<io.reactivex.disposables.b> implements Runnable, c {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: a  reason: collision with root package name */
        final oj.b<? super Long> f28762a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f28763b;

        TimerSubscriber(oj.b<? super Long> bVar) {
            this.f28762a = bVar;
        }

        public void a(long j2) {
            if (SubscriptionHelper.b(j2)) {
                this.f28763b = true;
            }
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.c(this, bVar);
        }

        public void c() {
            DisposableHelper.a((AtomicReference<io.reactivex.disposables.b>) this);
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.f28763b) {
                this.f28762a.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f28762a.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.f28762a.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public FlowableTimer(long j2, TimeUnit timeUnit, i iVar) {
        this.f28760c = j2;
        this.f28761d = timeUnit;
        this.f28759b = iVar;
    }

    public void b(oj.b<? super Long> bVar) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(bVar);
        bVar.onSubscribe(timerSubscriber);
        timerSubscriber.a(this.f28759b.a(timerSubscriber, this.f28760c, this.f28761d));
    }
}
