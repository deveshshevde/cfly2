package io.reactivex.internal.subscribers;

import io.reactivex.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import oj.b;
import oj.c;

public class StrictSubscriber<T> extends AtomicInteger implements e<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: a  reason: collision with root package name */
    final b<? super T> f28897a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicThrowable f28898b = new AtomicThrowable();

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f28899c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<c> f28900d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f28901e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f28902f;

    public StrictSubscriber(b<? super T> bVar) {
        this.f28897a = bVar;
    }

    public void a(long j2) {
        if (j2 <= 0) {
            c();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
            return;
        }
        SubscriptionHelper.a(this.f28900d, this.f28899c, j2);
    }

    public void c() {
        if (!this.f28902f) {
            SubscriptionHelper.a(this.f28900d);
        }
    }

    public void onComplete() {
        this.f28902f = true;
        io.reactivex.internal.util.c.a(this.f28897a, this, this.f28898b);
    }

    public void onError(Throwable th) {
        this.f28902f = true;
        io.reactivex.internal.util.c.a((b<?>) this.f28897a, th, (AtomicInteger) this, this.f28898b);
    }

    public void onNext(T t2) {
        io.reactivex.internal.util.c.a(this.f28897a, t2, (AtomicInteger) this, this.f28898b);
    }

    public void onSubscribe(c cVar) {
        if (this.f28901e.compareAndSet(false, true)) {
            this.f28897a.onSubscribe(this);
            SubscriptionHelper.a(this.f28900d, this.f28899c, cVar);
            return;
        }
        cVar.c();
        c();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }
}
