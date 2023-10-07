package org.litepal.crud.async;

import org.litepal.crud.callback.CountCallback;

public class CountExecutor extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private CountCallback f33925cb;

    public CountCallback getListener() {
        return this.f33925cb;
    }

    public void listen(CountCallback countCallback) {
        this.f33925cb = countCallback;
        execute();
    }
}
