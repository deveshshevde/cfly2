package org.litepal.crud.async;

import org.litepal.crud.callback.AverageCallback;

public class AverageExecutor extends AsyncExecutor {

    /* renamed from: cb  reason: collision with root package name */
    private AverageCallback f33924cb;

    public AverageCallback getListener() {
        return this.f33924cb;
    }

    public void listen(AverageCallback averageCallback) {
        this.f33924cb = averageCallback;
        execute();
    }
}
