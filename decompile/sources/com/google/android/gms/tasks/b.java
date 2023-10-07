package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public abstract class b<TResult> {
    public b<TResult> a(a<TResult> aVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public b<TResult> a(Executor executor, a<TResult> aVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Exception a();

    public abstract TResult b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();
}
