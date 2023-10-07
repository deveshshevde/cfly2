package com.google.android.gms.internal.common;

import java.util.Iterator;

public abstract class zzaj<E> implements Iterator<E> {
    protected zzaj() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
