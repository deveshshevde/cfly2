package io.reactivex.internal.subscribers;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import lv.a;
import lv.d;
import oj.c;

public final class LambdaSubscriber<T> extends AtomicReference<c> implements b, e<T>, c {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a  reason: collision with root package name */
    final d<? super T> f28893a;

    /* renamed from: b  reason: collision with root package name */
    final d<? super Throwable> f28894b;

    /* renamed from: c  reason: collision with root package name */
    final a f28895c;

    /* renamed from: d  reason: collision with root package name */
    final d<? super c> f28896d;

    public LambdaSubscriber(d<? super T> dVar, d<? super Throwable> dVar2, a aVar, d<? super c> dVar3) {
        this.f28893a = dVar;
        this.f28894b = dVar2;
        this.f28895c = aVar;
        this.f28896d = dVar3;
    }

    public void a(long j2) {
        ((c) get()).a(j2);
    }

    public void c() {
        SubscriptionHelper.a((AtomicReference<c>) this);
    }

    public void dispose() {
        c();
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.f28895c.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ly.a.a(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.f28894b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                ly.a.a((Throwable) new CompositeException(th, th2));
            }
        } else {
            ly.a.a(th);
        }
    }

    public void onNext(T t2) {
        if (!isDisposed()) {
            try {
                this.f28893a.accept(t2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ((c) get()).c();
                onError(th);
            }
        }
    }

    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.a((AtomicReference<c>) this, cVar)) {
            try {
                this.f28896d.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cVar.c();
                onError(th);
            }
        }
    }
}
