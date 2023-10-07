package io.reactivex.internal.schedulers;

import ly.a;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.f28814b = Thread.currentThread();
        try {
            this.f28813a.run();
            this.f28814b = null;
        } catch (Throwable th) {
            this.f28814b = null;
            lazySet(f28811c);
            a.a(th);
        }
    }
}
