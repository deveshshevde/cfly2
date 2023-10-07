package io.reactivex.internal.schedulers;

import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class c extends i {

    /* renamed from: b  reason: collision with root package name */
    static final RxThreadFactory f28843b;

    /* renamed from: c  reason: collision with root package name */
    static final RxThreadFactory f28844c;

    /* renamed from: d  reason: collision with root package name */
    static final C0194c f28845d;

    /* renamed from: g  reason: collision with root package name */
    static final a f28846g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f28847h = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: i  reason: collision with root package name */
    private static final TimeUnit f28848i = TimeUnit.SECONDS;

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f28849e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a> f28850f;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.disposables.a f28851a;

        /* renamed from: b  reason: collision with root package name */
        private final long f28852b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0194c> f28853c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f28854d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f28855e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f28856f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0;
            this.f28852b = nanos;
            this.f28853c = new ConcurrentLinkedQueue<>();
            this.f28851a = new io.reactivex.disposables.a();
            this.f28856f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, c.f28844c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f28854d = scheduledExecutorService;
            this.f28855e = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        public C0194c a() {
            if (this.f28851a.isDisposed()) {
                return c.f28845d;
            }
            while (!this.f28853c.isEmpty()) {
                C0194c poll = this.f28853c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0194c cVar = new C0194c(this.f28856f);
            this.f28851a.a((io.reactivex.disposables.b) cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(C0194c cVar) {
            cVar.a(c() + this.f28852b);
            this.f28853c.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.f28853c.isEmpty()) {
                long c2 = c();
                Iterator<C0194c> it2 = this.f28853c.iterator();
                while (it2.hasNext()) {
                    C0194c next = it2.next();
                    if (next.a() > c2) {
                        return;
                    }
                    if (this.f28853c.remove(next)) {
                        this.f28851a.b(next);
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
            this.f28851a.dispose();
            Future<?> future = this.f28855e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f28854d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            b();
        }
    }

    static final class b extends i.c {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f28857a = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.disposables.a f28858b;

        /* renamed from: c  reason: collision with root package name */
        private final a f28859c;

        /* renamed from: d  reason: collision with root package name */
        private final C0194c f28860d;

        b(a aVar) {
            this.f28859c = aVar;
            this.f28858b = new io.reactivex.disposables.a();
            this.f28860d = aVar.a();
        }

        public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f28858b.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28860d.a(runnable, j2, timeUnit, this.f28858b);
        }

        public void dispose() {
            if (this.f28857a.compareAndSet(false, true)) {
                this.f28858b.dispose();
                this.f28859c.a(this.f28860d);
            }
        }

        public boolean isDisposed() {
            return this.f28857a.get();
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.c$c  reason: collision with other inner class name */
    static final class C0194c extends e {

        /* renamed from: b  reason: collision with root package name */
        private long f28861b = 0;

        C0194c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long a() {
            return this.f28861b;
        }

        public void a(long j2) {
            this.f28861b = j2;
        }
    }

    static {
        C0194c cVar = new C0194c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f28845d = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f28843b = rxThreadFactory;
        f28844c = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, (TimeUnit) null, rxThreadFactory);
        f28846g = aVar;
        aVar.d();
    }

    public c() {
        this(f28843b);
    }

    public c(ThreadFactory threadFactory) {
        this.f28849e = threadFactory;
        this.f28850f = new AtomicReference<>(f28846g);
        b();
    }

    public i.c a() {
        return new b(this.f28850f.get());
    }

    public void b() {
        a aVar = new a(f28847h, f28848i, this.f28849e);
        if (!this.f28850f.compareAndSet(f28846g, aVar)) {
            aVar.d();
        }
    }
}
