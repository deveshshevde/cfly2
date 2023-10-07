package com.google.android.gms.common.api;

import com.google.android.gms.common.api.g;
import java.util.concurrent.TimeUnit;

public abstract class e<R extends g> {

    public interface a {
        void a(Status status);
    }

    public void addStatusListener(a aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract R await();

    public abstract R await(long j2, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(h<? super R> hVar);

    public abstract void setResultCallback(h<? super R> hVar, long j2, TimeUnit timeUnit);

    public <S extends g> k<S> then(j<? super R, ? extends S> jVar) {
        throw new UnsupportedOperationException();
    }
}
