package io.reactivex.internal.disposables;

import lx.b;

public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public int a(int i2) {
        return i2 & 2;
    }

    public boolean a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean b() {
        return true;
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public void v_() {
    }

    public Object w_() throws Exception {
        return null;
    }
}
