package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import lx.d;

public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean a(T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
