package io.reactivex.internal.schedulers;

import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class h extends i {

    /* renamed from: b  reason: collision with root package name */
    private static final h f28879b = new h();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f28880a;

        /* renamed from: b  reason: collision with root package name */
        private final c f28881b;

        /* renamed from: c  reason: collision with root package name */
        private final long f28882c;

        a(Runnable runnable, c cVar, long j2) {
            this.f28880a = runnable;
            this.f28881b = cVar;
            this.f28882c = j2;
        }

        public void run() {
            if (!this.f28881b.f28889c) {
                long a2 = this.f28881b.a(TimeUnit.MILLISECONDS);
                long j2 = this.f28882c;
                if (j2 > a2) {
                    try {
                        Thread.sleep(j2 - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        ly.a.a((Throwable) e2);
                        return;
                    }
                }
                if (!this.f28881b.f28889c) {
                    this.f28880a.run();
                }
            }
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f28883a;

        /* renamed from: b  reason: collision with root package name */
        final long f28884b;

        /* renamed from: c  reason: collision with root package name */
        final int f28885c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f28886d;

        b(Runnable runnable, Long l2, int i2) {
            this.f28883a = runnable;
            this.f28884b = l2.longValue();
            this.f28885c = i2;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = lw.b.a(this.f28884b, bVar.f28884b);
            return a2 == 0 ? lw.b.a(this.f28885c, bVar.f28885c) : a2;
        }
    }

    static final class c extends i.c implements io.reactivex.disposables.b {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f28887a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f28888b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28889c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f28890d = new AtomicInteger();

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f28891a;

            a(b bVar) {
                this.f28891a = bVar;
            }

            public void run() {
                this.f28891a.f28886d = true;
                c.this.f28887a.remove(this.f28891a);
            }
        }

        c() {
        }

        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        /* access modifiers changed from: package-private */
        public io.reactivex.disposables.b a(Runnable runnable, long j2) {
            if (this.f28889c) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f28888b.incrementAndGet());
            this.f28887a.add(bVar);
            if (this.f28890d.getAndIncrement() != 0) {
                return io.reactivex.disposables.c.a(new a(bVar));
            }
            int i2 = 1;
            while (!this.f28889c) {
                b poll = this.f28887a.poll();
                if (poll == null) {
                    i2 = this.f28890d.addAndGet(-i2);
                    if (i2 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f28886d) {
                    poll.f28883a.run();
                }
            }
            this.f28887a.clear();
            return EmptyDisposable.INSTANCE;
        }

        public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return a(new a(runnable, this, a2), a2);
        }

        public void dispose() {
            this.f28889c = true;
        }

        public boolean isDisposed() {
            return this.f28889c;
        }
    }

    h() {
    }

    public static h c() {
        return f28879b;
    }

    public io.reactivex.disposables.b a(Runnable runnable) {
        ly.a.a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            ly.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            ly.a.a((Throwable) e2);
        }
        return EmptyDisposable.INSTANCE;
    }

    public i.c a() {
        return new c();
    }
}
