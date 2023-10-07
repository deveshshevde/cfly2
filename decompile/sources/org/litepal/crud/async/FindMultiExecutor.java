package org.litepal.crud.async;

import org.litepal.crud.callback.FindMultiCallback;

public class FindMultiExecutor<T> extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private FindMultiCallback<T> f33927cb;

    public FindMultiCallback<T> getListener() {
        return this.f33927cb;
    }

    public void listen(FindMultiCallback<T> findMultiCallback) {
        this.f33927cb = findMultiCallback;
        execute();
    }
}
