package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadUtils {
    /* access modifiers changed from: private */
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static final Map<Task, ExecutorService> TASK_POOL_MAP = new ConcurrentHashMap();
    private static final Timer TIMER = new Timer();
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;

    private static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        /* access modifiers changed from: private */
        public volatile ThreadPoolExecutor4Util mPool;

        LinkedBlockingQueue4Util() {
        }

        LinkedBlockingQueue4Util(int i2) {
            this.mCapacity = i2;
        }

        LinkedBlockingQueue4Util(boolean z2) {
            if (z2) {
                this.mCapacity = 0;
            }
        }

        public boolean offer(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'runnable' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        public void onFail(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    public static class SyncValue<T> {
        private AtomicBoolean mFlag = new AtomicBoolean();
        private CountDownLatch mLatch = new CountDownLatch(1);
        private T mValue;

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return this.mValue;
        }

        public T getValue(long j2, TimeUnit timeUnit, T t2) {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await(j2, timeUnit);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return t2;
                }
            }
            return this.mValue;
        }

        public void setValue(T t2) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = t2;
                this.mLatch.countDown();
            }
        }
    }

    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        /* access modifiers changed from: private */
        public OnTimeoutListener mTimeoutListener;
        private long mTimeoutMillis;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        public interface OnTimeoutListener {
            void onTimeout();
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            return executor == null ? ThreadUtils.getGlobalDeliver() : executor;
        }

        /* access modifiers changed from: private */
        public void setSchedule(boolean z2) {
            this.isSchedule = z2;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.runner == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.runner.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void timeout() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.state
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x001f }
                int r1 = r1.get()     // Catch:{ all -> 0x001f }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x001f }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x001f }
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                java.lang.Thread r0 = r3.runner
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.runner
                r0.interrupt()
            L_0x001e:
                return
            L_0x001f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.Task.timeout():void");
        }

        public void cancel() {
            cancel(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r3.runner == null) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            r3.runner.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            getDeliver().execute(new com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass5(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
            if (r4 == false) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cancel(boolean r4) {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.state
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x002d }
                int r1 = r1.get()     // Catch:{ all -> 0x002d }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x002d }
                r2 = 4
                r1.set(r2)     // Catch:{ all -> 0x002d }
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                if (r4 == 0) goto L_0x0020
                java.lang.Thread r4 = r3.runner
                if (r4 == 0) goto L_0x0020
                java.lang.Thread r4 = r3.runner
                r4.interrupt()
            L_0x0020:
                java.util.concurrent.Executor r4 = r3.getDeliver()
                com.blankj.utilcode.util.ThreadUtils$Task$5 r0 = new com.blankj.utilcode.util.ThreadUtils$Task$5
                r0.<init>()
                r4.execute(r0)
                return
            L_0x002d:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.Task.cancel(boolean):void");
        }

        public abstract T doInBackground() throws Throwable;

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public abstract void onCancel();

        /* access modifiers changed from: protected */
        public void onDone() {
            ThreadUtils.TASK_POOL_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t2);

        public void run() {
            Executor deliver2;
            Runnable r3;
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (this.state.compareAndSet(0, 1)) {
                        this.runner = Thread.currentThread();
                        if (this.mTimeoutListener != null) {
                            Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                        }
                    } else {
                        return;
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else if (this.state.compareAndSet(0, 1)) {
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    timer.schedule(new TimerTask() {
                        public void run() {
                            if (!Task.this.isDone() && Task.this.mTimeoutListener != null) {
                                Task.this.timeout();
                                Task.this.mTimeoutListener.onTimeout();
                                Task.this.onDone();
                            }
                        }
                    }, this.mTimeoutMillis);
                }
            } else {
                return;
            }
            try {
                final Object doInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() == 1) {
                        deliver2 = getDeliver();
                        r3 = new Runnable() {
                            public void run() {
                                Task.this.onSuccess(doInBackground);
                            }
                        };
                    } else {
                        return;
                    }
                } else if (this.state.compareAndSet(1, 3)) {
                    deliver2 = getDeliver();
                    r3 = new Runnable() {
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                            Task.this.onDone();
                        }
                    };
                } else {
                    return;
                }
                deliver2.execute(r3);
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() {
                        public void run() {
                            Task.this.onFail(th);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public Task<T> setTimeout(long j2, OnTimeoutListener onTimeoutListener) {
            this.mTimeoutMillis = j2;
            this.mTimeoutListener = onTimeoutListener;
            return this;
        }
    }

    static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount = new AtomicInteger();
        private LinkedBlockingQueue4Util mWorkQueue;

        ThreadPoolExecutor4Util(int i2, int i3, long j2, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, linkedBlockingQueue4Util, threadFactory);
            ThreadPoolExecutor4Util unused = linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        /* access modifiers changed from: private */
        public static ExecutorService createPool(int i2, int i3) {
            int i4 = i2;
            int i5 = i3;
            if (i4 == -8) {
                return new ThreadPoolExecutor4Util(ThreadUtils.CPU_COUNT + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i5));
            } else if (i4 == -4) {
                return new ThreadPoolExecutor4Util((ThreadUtils.CPU_COUNT * 2) + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i5));
            } else {
                if (i4 == -2) {
                    return new ThreadPoolExecutor4Util(0, 128, 60, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i5));
                } else if (i4 == -1) {
                    return new ThreadPoolExecutor4Util(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i5));
                } else {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    LinkedBlockingQueue4Util linkedBlockingQueue4Util = new LinkedBlockingQueue4Util();
                    return new ThreadPoolExecutor4Util(i2, i2, 0, timeUnit, linkedBlockingQueue4Util, new UtilsThreadFactory("fixed(" + i4 + ")", i5));
                }
            }
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public void execute(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            if (!isShutdown()) {
                this.mSubmittedCount.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.mWorkQueue.offer(runnable);
                } catch (Throwable unused2) {
                    this.mSubmittedCount.decrementAndGet();
                }
            }
        }
    }

    static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i2) {
            this(str, i2, false);
        }

        UtilsThreadFactory(String str, int i2, boolean z2) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i2;
            this.isDaemon = z2;
        }

        public Thread newThread(Runnable runnable) {
            Objects.requireNonNull(runnable, "Argument 'r' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            AnonymousClass1 r0 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            r0.setDaemon(this.isDaemon);
            r0.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    System.out.println(th);
                }
            });
            r0.setPriority(this.priority);
            return r0;
        }
    }

    public static void cancel(Task task) {
        if (task != null) {
            task.cancel();
        }
    }

    public static void cancel(List<Task> list) {
        if (list != null && list.size() != 0) {
            for (Task next : list) {
                if (next != null) {
                    next.cancel();
                }
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry next : TASK_POOL_MAP.entrySet()) {
                if (next.getValue() == executorService) {
                    cancel((Task) next.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }

    public static void cancel(Task... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            for (Task task : taskArr) {
                if (task != null) {
                    task.cancel();
                }
            }
        }
    }

    private static <T> void execute(ExecutorService executorService, Task<T> task) {
        execute(executorService, task, 0, 0, (TimeUnit) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r7 != 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r5 != 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r3.execute(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        TIMER.schedule(new com.blankj.utilcode.util.ThreadUtils.AnonymousClass1(), r9.toMillis(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        com.blankj.utilcode.util.ThreadUtils.Task.access$000(r4, true);
        TIMER.scheduleAtFixedRate(new com.blankj.utilcode.util.ThreadUtils.AnonymousClass2(), r9.toMillis(r5), r9.toMillis(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> void execute(final java.util.concurrent.ExecutorService r3, final com.blankj.utilcode.util.ThreadUtils.Task<T> r4, long r5, long r7, java.util.concurrent.TimeUnit r9) {
        /*
            java.util.Map<com.blankj.utilcode.util.ThreadUtils$Task, java.util.concurrent.ExecutorService> r0 = TASK_POOL_MAP
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r4)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0012
            java.lang.String r3 = "ThreadUtils"
            java.lang.String r4 = "Task can only be executed once."
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0012:
            r0.put(r4, r3)     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0033
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x0024
            r3.execute(r4)
            goto L_0x004a
        L_0x0024:
            com.blankj.utilcode.util.ThreadUtils$1 r7 = new com.blankj.utilcode.util.ThreadUtils$1
            r7.<init>(r3, r4)
            java.util.Timer r3 = TIMER
            long r4 = r9.toMillis(r5)
            r3.schedule(r7, r4)
            goto L_0x004a
        L_0x0033:
            r0 = 1
            r4.setSchedule(r0)
            com.blankj.utilcode.util.ThreadUtils$2 r0 = new com.blankj.utilcode.util.ThreadUtils$2
            r0.<init>(r3, r4)
            java.util.Timer r3 = TIMER
            long r5 = r9.toMillis(r5)
            long r7 = r9.toMillis(r7)
            r4 = r0
            r3.scheduleAtFixedRate(r4, r5, r7)
        L_0x004a:
            return
        L_0x004b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.execute(java.util.concurrent.ExecutorService, com.blankj.utilcode.util.ThreadUtils$Task, long, long, java.util.concurrent.TimeUnit):void");
    }

    private static <T> void executeAtFixedRate(ExecutorService executorService, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        execute(executorService, task, j2, j3, timeUnit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCached(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-2, i2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0, j2, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, 0, j2, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j2, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i2), task, j2, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpu(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-8, i2), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, 0, j2, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j2, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i2), task, j2, timeUnit);
    }

    public static <T> void executeByCustom(ExecutorService executorService, Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j2, j3, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0, j2, timeUnit);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j2, timeUnit);
    }

    public static <T> void executeByFixed(int i2, Task<T> task) {
        execute(getPoolByTypeAndPriority(i2), task);
    }

    public static <T> void executeByFixed(int i2, Task<T> task, int i3) {
        execute(getPoolByTypeAndPriority(i2, i3), task);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j2, long j3, TimeUnit timeUnit, int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, j2, j3, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, 0, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j2, TimeUnit timeUnit, int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, 0, j2, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i2, Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i2), task, j2, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i2, Task<T> task, long j2, TimeUnit timeUnit, int i3) {
        executeWithDelay(getPoolByTypeAndPriority(i2, i3), task, j2, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIo(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-4, i2), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j2, j3, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, 0, j2, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j2, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i2), task, j2, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingle(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-1, i2), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j2, j3, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, long j3, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, j2, j3, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, 0, j2, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j2, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j2, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j2, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i2), task, j2, timeUnit);
    }

    private static <T> void executeWithDelay(ExecutorService executorService, Task<T> task, long j2, TimeUnit timeUnit) {
        execute(executorService, task, j2, 0, timeUnit);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCachedPool(int i2) {
        return getPoolByTypeAndPriority(-2, i2);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getCpuPool(int i2) {
        return getPoolByTypeAndPriority(-8, i2);
    }

    public static ExecutorService getFixedPool(int i2) {
        return getPoolByTypeAndPriority(i2);
    }

    public static ExecutorService getFixedPool(int i2, int i3) {
        return getPoolByTypeAndPriority(i2, i3);
    }

    /* access modifiers changed from: private */
    public static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() {
                public void execute(Runnable runnable) {
                    Objects.requireNonNull(runnable, "Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                    ThreadUtils.runOnUiThread(runnable);
                }
            };
        }
        return sDeliver;
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static ExecutorService getIoPool(int i2) {
        return getPoolByTypeAndPriority(-4, i2);
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    private static ExecutorService getPoolByTypeAndPriority(int i2) {
        return getPoolByTypeAndPriority(i2, 5);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i2, int i3) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            Map map2 = map.get(Integer.valueOf(i2));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = ThreadPoolExecutor4Util.createPool(i2, i3);
                concurrentHashMap.put(Integer.valueOf(i3), executorService);
                map.put(Integer.valueOf(i2), concurrentHashMap);
            } else {
                executorService = (ExecutorService) map2.get(Integer.valueOf(i3));
                if (executorService == null) {
                    executorService = ThreadPoolExecutor4Util.createPool(i2, i3);
                    map2.put(Integer.valueOf(i3), executorService);
                }
            }
        }
        return executorService;
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static ExecutorService getSinglePool(int i2) {
        return getPoolByTypeAndPriority(-1, i2);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j2) {
        HANDLER.postDelayed(runnable, j2);
    }

    public static void setDeliver(Executor executor) {
        sDeliver = executor;
    }
}
