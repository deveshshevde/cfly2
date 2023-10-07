package com.google.android.gms.internal.common;

import java.util.ListIterator;

public abstract class zzak<E> extends zzaj<E> implements ListIterator<E> {
    protected zzak() {
    }

    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
