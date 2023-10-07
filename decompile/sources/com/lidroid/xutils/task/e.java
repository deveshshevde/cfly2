package com.lidroid.xutils.task;

public class e extends d<Runnable> implements Runnable {
    public e(Priority priority, Runnable runnable) {
        super(priority, runnable);
    }

    public void run() {
        ((Runnable) this.f21159b).run();
    }
}
