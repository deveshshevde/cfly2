package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import lv.a;
import lv.d;

public final class LambdaObserver<T> extends AtomicReference<b> implements b, h<T> {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a  reason: collision with root package name */
    final d<? super T> f28704a;

    /* renamed from: b  reason: collision with root package name */
    final d<? super Throwable> f28705b;

    /* renamed from: c  reason: collision with root package name */
    final a f28706c;

    /* renamed from: d  reason: collision with root package name */
    final d<? super b> f28707d;

    public LambdaObserver(d<? super T> dVar, d<? super Throwable> dVar2, a aVar, d<? super b> dVar3) {
        this.f28704a = dVar;
        this.f28705b = dVar2;
        this.f28706c = aVar;
        this.f28707d = dVar3;
    }

    public void a() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f28706c.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ly.a.a(th);
            }
        }
    }

    public void a(b bVar) {
        if (DisposableHelper.a((AtomicReference<b>) this, bVar)) {
            try {
                this.f28707d.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                a(th);
            }
        }
    }

    public void a(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f28705b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                ly.a.a((Throwable) new CompositeException(th, th2));
            }
        } else {
            ly.a.a(th);
        }
    }

    public void a_(T t2) {
        if (!isDisposed()) {
            try {
                this.f28704a.accept(t2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ((b) get()).dispose();
                a(th);
            }
        }
    }

    public void dispose() {
        DisposableHelper.a((AtomicReference<b>) this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
