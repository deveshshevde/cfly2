package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import oj.c;

public final class FlowableInterval extends b<Long> {

    /* renamed from: b  reason: collision with root package name */
    final i f28723b;

    /* renamed from: c  reason: collision with root package name */
    final long f28724c;

    /* renamed from: d  reason: collision with root package name */
    final long f28725d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f28726e;

    static final class IntervalSubscriber extends AtomicLong implements Runnable, c {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: a  reason: collision with root package name */
        final oj.b<? super Long> f28727a;

        /* renamed from: b  reason: collision with root package name */
        long f28728b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f28729c = new AtomicReference<>();

        IntervalSubscriber(oj.b<? super Long> bVar) {
            this.f28727a = bVar;
        }

        public void a(long j2) {
            if (SubscriptionHelper.b(j2)) {
                a.a((AtomicLong) this, j2);
            }
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.a(this.f28729c, bVar);
        }

        public void c() {
            DisposableHelper.a(this.f28729c);
        }

        public void run() {
            if (this.f28729c.get() != DisposableHelper.DISPOSED) {
                int i2 = (get() > 0 ? 1 : (get() == 0 ? 0 : -1));
                oj.b<? super Long> bVar = this.f28727a;
                if (i2 != 0) {
                    long j2 = this.f28728b;
                    this.f28728b = j2 + 1;
                    bVar.onNext(Long.valueOf(j2));
                    a.b(this, 1);
                    return;
                }
                bVar.onError(new MissingBackpressureException("Can't deliver value " + this.f28728b + " due to lack of requests"));
                DisposableHelper.a(this.f28729c);
            }
        }
    }

    public FlowableInterval(long j2, long j3, TimeUnit timeUnit, i iVar) {
        this.f28724c = j2;
        this.f28725d = j3;
        this.f28726e = timeUnit;
        this.f28723b = iVar;
    }

    public void b(oj.b<? super Long> bVar) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(bVar);
        bVar.onSubscribe(intervalSubscriber);
        i iVar = this.f28723b;
        if (iVar instanceof h) {
            i.c a2 = iVar.a();
            intervalSubscriber.a((io.reactivex.disposables.b) a2);
            a2.a(intervalSubscriber, this.f28724c, this.f28725d, this.f28726e);
            return;
        }
        intervalSubscriber.a(iVar.a(intervalSubscriber, this.f28724c, this.f28725d, this.f28726e));
    }
}
