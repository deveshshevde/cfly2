package rx.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import ok.e;
import ok.i;
import rx.internal.util.RxThreadFactory;

public final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    static final c f34293b;

    /* renamed from: e  reason: collision with root package name */
    static final C0254a f34294e;

    /* renamed from: f  reason: collision with root package name */
    private static final TimeUnit f34295f = TimeUnit.SECONDS;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f34296c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<C0254a> f34297d = new AtomicReference<>(f34294e);

    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    private static final class C0254a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadFactory f34298a;

        /* renamed from: b  reason: collision with root package name */
        private final long f34299b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f34300c;

        /* renamed from: d  reason: collision with root package name */
        private final ot.b f34301d;

        /* renamed from: e  reason: collision with root package name */
        private final ScheduledExecutorService f34302e;

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f34303f;

        C0254a(final ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f34298a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0;
            this.f34299b = nanos;
            this.f34300c = new ConcurrentLinkedQueue<>();
            this.f34301d = new ot.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() {
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                e.b(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                    public void run() {
                        C0254a.this.b();
                    }
                }, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f34302e = scheduledExecutorService;
            this.f34303f = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        public c a() {
            if (this.f34301d.isUnsubscribed()) {
                return a.f34293b;
            }
            while (!this.f34300c.isEmpty()) {
                c poll = this.f34300c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f34298a);
            this.f34301d.a((i) cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(c cVar) {
            cVar.a(c() + this.f34299b);
            this.f34300c.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.f34300c.isEmpty()) {
                long c2 = c();
                Iterator<c> it2 = this.f34300c.iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (next.b() > c2) {
                        return;
                    }
                    if (this.f34300c.remove(next)) {
                        this.f34301d.b(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            try {
                Future<?> future = this.f34303f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f34302e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f34301d.unsubscribe();
            }
        }
    }

    private static final class b extends e.a {

        /* renamed from: b  reason: collision with root package name */
        static final AtomicIntegerFieldUpdater<b> f34307b = AtomicIntegerFieldUpdater.newUpdater(b.class, "a");

        /* renamed from: a  reason: collision with root package name */
        volatile int f34308a;

        /* renamed from: c  reason: collision with root package name */
        private final ot.b f34309c = new ot.b();

        /* renamed from: d  reason: collision with root package name */
        private final C0254a f34310d;

        /* renamed from: e  reason: collision with root package name */
        private final c f34311e;

        b(C0254a aVar) {
            this.f34310d = aVar;
            this.f34311e = aVar.a();
        }

        public i a(on.a aVar) {
            return a(aVar, 0, (TimeUnit) null);
        }

        public i a(final on.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f34309c.isUnsubscribed()) {
                return ot.e.b();
            }
            ScheduledAction b2 = this.f34311e.b(new on.a() {
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j2, timeUnit);
            this.f34309c.a((i) b2);
            b2.a(this.f34309c);
            return b2;
        }

        public boolean isUnsubscribed() {
            return this.f34309c.isUnsubscribed();
        }

        public void unsubscribe() {
            if (f34307b.compareAndSet(this, 0, 1)) {
                this.f34310d.a(this.f34311e);
            }
            this.f34309c.unsubscribe();
        }
    }

    private static final class c extends e {

        /* renamed from: c  reason: collision with root package name */
        private long f34314c = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public void a(long j2) {
            this.f34314c = j2;
        }

        public long b() {
            return this.f34314c;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.f34357a);
        f34293b = cVar;
        cVar.unsubscribe();
        C0254a aVar = new C0254a((ThreadFactory) null, 0, (TimeUnit) null);
        f34294e = aVar;
        aVar.d();
    }

    public a(ThreadFactory threadFactory) {
        this.f34296c = threadFactory;
        c();
    }

    public e.a a() {
        return new b(this.f34297d.get());
    }

    public void c() {
        C0254a aVar = new C0254a(this.f34296c, 60, f34295f);
        if (!this.f34297d.compareAndSet(f34294e, aVar)) {
            aVar.d();
        }
    }
}
