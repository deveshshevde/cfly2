package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
import lx.b;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean a(T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
