package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import lw.b;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T t2) {
        super(b.a(t2, "value is null"));
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t2);

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
