package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f28866a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f28867b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f28868c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f28869d = new ConcurrentHashMap();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f28870a;

        /* renamed from: b  reason: collision with root package name */
        int f28871b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f28870a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f28870a = true;
            }
            if (this.f28870a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.f28871b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                }
            }
            this.f28871b = 1;
        }
    }

    static final class b implements Runnable {
        b() {
        }

        public void run() {
            Iterator it2 = new ArrayList(f.f28869d.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    f.f28869d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f28866a = aVar.f28870a;
        f28867b = aVar.f28871b;
        a();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(f28866a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void a() {
        a(f28866a);
    }

    static void a(boolean z2) {
        if (z2) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f28868c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        b bVar = new b();
                        int i2 = f28867b;
                        newScheduledThreadPool.scheduleAtFixedRate(bVar, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    static void a(boolean z2, ScheduledExecutorService scheduledExecutorService) {
        if (z2 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f28869d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
