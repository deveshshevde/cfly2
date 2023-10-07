package io.reactivex.internal.schedulers;

import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a extends i {

    /* renamed from: b  reason: collision with root package name */
    static final b f28823b;

    /* renamed from: c  reason: collision with root package name */
    static final RxThreadFactory f28824c;

    /* renamed from: d  reason: collision with root package name */
    static final int f28825d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e  reason: collision with root package name */
    static final c f28826e;

    /* renamed from: f  reason: collision with root package name */
    final ThreadFactory f28827f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<b> f28828g;

    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    static final class C0193a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f28829a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f28830b;

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.disposables.a f28831c;

        /* renamed from: d  reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f28832d;

        /* renamed from: e  reason: collision with root package name */
        private final c f28833e;

        C0193a(c cVar) {
            this.f28833e = cVar;
            io.reactivex.internal.disposables.b bVar = new io.reactivex.internal.disposables.b();
            this.f28830b = bVar;
            io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
            this.f28831c = aVar;
            io.reactivex.internal.disposables.b bVar2 = new io.reactivex.internal.disposables.b();
            this.f28832d = bVar2;
            bVar2.a((io.reactivex.disposables.b) bVar);
            bVar2.a((io.reactivex.disposables.b) aVar);
        }

        public io.reactivex.disposables.b a(Runnable runnable) {
            if (this.f28829a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28833e.a(runnable, 0, TimeUnit.MILLISECONDS, this.f28830b);
        }

        public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f28829a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f28833e.a(runnable, j2, timeUnit, this.f28831c);
        }

        public void dispose() {
            if (!this.f28829a) {
                this.f28829a = true;
                this.f28832d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f28829a;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f28834a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f28835b;

        /* renamed from: c  reason: collision with root package name */
        long f28836c;

        b(int i2, ThreadFactory threadFactory) {
            this.f28834a = i2;
            this.f28835b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f28835b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f28834a;
            if (i2 == 0) {
                return a.f28826e;
            }
            c[] cVarArr = this.f28835b;
            long j2 = this.f28836c;
            this.f28836c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c dispose : this.f28835b) {
                dispose.dispose();
            }
        }
    }

    static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f28826e = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f28824c = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f28823b = bVar;
        bVar.b();
    }

    public a() {
        this(f28824c);
    }

    public a(ThreadFactory threadFactory) {
        this.f28827f = threadFactory;
        this.f28828g = new AtomicReference<>(f28823b);
        b();
    }

    static int a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f28828g.get().a().b(runnable, j2, j3, timeUnit);
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f28828g.get().a().b(runnable, j2, timeUnit);
    }

    public i.c a() {
        return new C0193a(this.f28828g.get().a());
    }

    public void b() {
        b bVar = new b(f28825d, this.f28827f);
        if (!this.f28828g.compareAndSet(f28823b, bVar)) {
            bVar.b();
        }
    }
}
