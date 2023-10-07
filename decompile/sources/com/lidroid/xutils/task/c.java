package com.lidroid.xutils.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f21154a = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f21157a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "PriorityExecutor #" + this.f21157a.getAndIncrement());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<Runnable> f21155b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadPoolExecutor f21156c;

    public c() {
        this(5);
    }

    public c(int i2) {
        PriorityObjectBlockingQueue priorityObjectBlockingQueue = new PriorityObjectBlockingQueue();
        this.f21155b = priorityObjectBlockingQueue;
        this.f21156c = new ThreadPoolExecutor(i2, 256, 1, TimeUnit.SECONDS, priorityObjectBlockingQueue, f21154a);
    }

    public void execute(Runnable runnable) {
        this.f21156c.execute(runnable);
    }
}
