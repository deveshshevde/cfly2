package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class i implements Executor {
    i() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
