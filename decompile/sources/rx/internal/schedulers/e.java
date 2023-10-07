package rx.internal.schedulers;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ok.e;
import ok.i;
import or.d;
import rx.exceptions.a;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.b;

public class e extends e.a implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final int f34335b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f34336e;

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f34337f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f34338g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    private static volatile Object f34339h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f34340i = new Object();

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f34341a;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f34342c;

    /* renamed from: d  reason: collision with root package name */
    private final or.e f34343d;

    static {
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int b2 = b.b();
        f34336e = !z2 && (b2 == 0 || b2 >= 21);
    }

    public e(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!b(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            a((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f34343d = d.a().e();
        this.f34342c = newScheduledThreadPool;
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        f34337f.remove(scheduledExecutorService);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f34338g;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet((Object) null, newScheduledThreadPool)) {
                AnonymousClass1 r5 = new Runnable() {
                    public void run() {
                        e.c();
                    }
                };
                int i2 = f34335b;
                newScheduledThreadPool.scheduleAtFixedRate(r5, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f34337f.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        if (f34336e) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f34339h;
                Object obj2 = f34340i;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    method = c(scheduledExecutorService);
                    if (method != null) {
                        obj2 = method;
                    }
                    f34339h = obj2;
                } else {
                    method = (Method) obj;
                }
            } else {
                method = c(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, new Object[]{true});
                    return true;
                } catch (Exception e2) {
                    d.a().b().a((Throwable) e2);
                }
            }
        }
        return false;
    }

    static Method c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    static void c() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it2 = f34337f.keySet().iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor next = it2.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            a.a(th);
            d.a().b().a(th);
        }
    }

    public i a(on.a aVar) {
        return a(aVar, 0, (TimeUnit) null);
    }

    public i a(on.a aVar, long j2, TimeUnit timeUnit) {
        return this.f34341a ? ot.e.b() : b(aVar, j2, timeUnit);
    }

    public ScheduledAction a(on.a aVar, long j2, TimeUnit timeUnit, ot.b bVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f34343d.a(aVar), bVar);
        bVar.a((i) scheduledAction);
        scheduledAction.a((Future<?>) j2 <= 0 ? this.f34342c.submit(scheduledAction) : this.f34342c.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction a(on.a aVar, long j2, TimeUnit timeUnit, rx.internal.util.e eVar) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f34343d.a(aVar), eVar);
        eVar.a((i) scheduledAction);
        scheduledAction.a((Future<?>) j2 <= 0 ? this.f34342c.submit(scheduledAction) : this.f34342c.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    public ScheduledAction b(on.a aVar, long j2, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(this.f34343d.a(aVar));
        scheduledAction.a((Future<?>) j2 <= 0 ? this.f34342c.submit(scheduledAction) : this.f34342c.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
    }

    public boolean isUnsubscribed() {
        return this.f34341a;
    }

    public void unsubscribe() {
        this.f34341a = true;
        this.f34342c.shutdownNow();
        a(this.f34342c);
    }
}
