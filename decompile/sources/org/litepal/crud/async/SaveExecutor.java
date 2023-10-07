package org.litepal.crud.async;

import org.litepal.crud.callback.SaveCallback;

public class SaveExecutor extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private SaveCallback f33928cb;

    public SaveCallback getListener() {
        return this.f33928cb;
    }

    public void listen(SaveCallback saveCallback) {
        this.f33928cb = saveCallback;
        execute();
    }
}
