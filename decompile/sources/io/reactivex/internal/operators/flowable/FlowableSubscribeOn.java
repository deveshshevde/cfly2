package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.i;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import oj.b;
import oj.c;

public final class FlowableSubscribeOn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final i f28749c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28750d;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements e<T>, Runnable, c {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f28751a;

        /* renamed from: b  reason: collision with root package name */
        final i.c f28752b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<c> f28753c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f28754d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final boolean f28755e;

        /* renamed from: f  reason: collision with root package name */
        oj.a<T> f28756f;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final c f28757a;

            /* renamed from: b  reason: collision with root package name */
            final long f28758b;

            a(c cVar, long j2) {
                this.f28757a = cVar;
                this.f28758b = j2;
            }

            public void run() {
                this.f28757a.a(this.f28758b);
            }
        }

        SubscribeOnSubscriber(b<? super T> bVar, i.c cVar, oj.a<T> aVar, boolean z2) {
            this.f28751a = bVar;
            this.f28752b = cVar;
            this.f28756f = aVar;
            this.f28755e = !z2;
        }

        public void a(long j2) {
            if (SubscriptionHelper.b(j2)) {
                c cVar = this.f28753c.get();
                if (cVar != null) {
                    a(j2, cVar);
                    return;
                }
                io.reactivex.internal.util.a.a(this.f28754d, j2);
                c cVar2 = this.f28753c.get();
                if (cVar2 != null) {
                    long andSet = this.f28754d.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, cVar2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, c cVar) {
            if (this.f28755e || Thread.currentThread() == get()) {
                cVar.a(j2);
            } else {
                this.f28752b.a((Runnable) new a(cVar, j2));
            }
        }

        public void c() {
            SubscriptionHelper.a(this.f28753c);
            this.f28752b.dispose();
        }

        public void onComplete() {
            this.f28751a.onComplete();
            this.f28752b.dispose();
        }

        public void onError(Throwable th) {
            this.f28751a.onError(th);
            this.f28752b.dispose();
        }

        public void onNext(T t2) {
            this.f28751a.onNext(t2);
        }

        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.a(this.f28753c, cVar)) {
                long andSet = this.f28754d.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, cVar);
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            oj.a<T> aVar = this.f28756f;
            this.f28756f = null;
            aVar.a(this);
        }
    }

    public FlowableSubscribeOn(io.reactivex.b<T> bVar, i iVar, boolean z2) {
        super(bVar);
        this.f28749c = iVar;
        this.f28750d = z2;
    }

    public void b(b<? super T> bVar) {
        i.c a2 = this.f28749c.a();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(bVar, a2, this.f28764b, this.f28750d);
        bVar.onSubscribe(subscribeOnSubscriber);
        a2.a((Runnable) subscribeOnSubscriber);
    }
}
