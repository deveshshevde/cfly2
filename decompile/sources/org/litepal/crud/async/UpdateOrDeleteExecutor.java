package org.litepal.crud.async;

import org.litepal.crud.callback.UpdateOrDeleteCallback;

public class UpdateOrDeleteExecutor extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private UpdateOrDeleteCallback f33929cb;

    public UpdateOrDeleteCallback getListener() {
        return this.f33929cb;
    }

    public void listen(UpdateOrDeleteCallback updateOrDeleteCallback) {
        this.f33929cb = updateOrDeleteCallback;
        execute();
    }
}
