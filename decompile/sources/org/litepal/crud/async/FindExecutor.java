package org.litepal.crud.async;

import org.litepal.crud.callback.FindCallback;

public class FindExecutor<T> extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private FindCallback<T> f33926cb;

    public FindCallback<T> getListener() {
        return this.f33926cb;
    }

    public void listen(FindCallback<T> findCallback) {
        this.f33926cb = findCallback;
        execute();
    }
}
