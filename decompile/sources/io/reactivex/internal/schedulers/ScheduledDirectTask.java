package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f28814b = Thread.currentThread();
        try {
            this.f28813a.run();
            return null;
        } finally {
            lazySet(f28811c);
            this.f28814b = null;
        }
    }
}
