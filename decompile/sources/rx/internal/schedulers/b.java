package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ok.e;
import ok.i;
import rx.internal.util.RxThreadFactory;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    static final int f34315b;

    /* renamed from: c  reason: collision with root package name */
    static final c f34316c;

    /* renamed from: d  reason: collision with root package name */
    static final C0255b f34317d = new C0255b((ThreadFactory) null, 0);

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f34318e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<C0255b> f34319f = new AtomicReference<>(f34317d);

    private static class a extends e.a {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.util.e f34320a;

        /* renamed from: b  reason: collision with root package name */
        private final ot.b f34321b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.internal.util.e f34322c;

        /* renamed from: d  reason: collision with root package name */
        private final c f34323d;

        a(c cVar) {
            rx.internal.util.e eVar = new rx.internal.util.e();
            this.f34320a = eVar;
            ot.b bVar = new ot.b();
            this.f34321b = bVar;
            this.f34322c = new rx.internal.util.e(eVar, bVar);
            this.f34323d = cVar;
        }

        public i a(final on.a aVar) {
            return isUnsubscribed() ? ot.e.b() : this.f34323d.a((on.a) new on.a() {
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0, (TimeUnit) null, this.f34320a);
        }

        public i a(final on.a aVar, long j2, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return ot.e.b();
            }
            return this.f34323d.a((on.a) new on.a() {
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j2, timeUnit, this.f34321b);
        }

        public boolean isUnsubscribed() {
            return this.f34322c.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f34322c.unsubscribe();
        }
    }

    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    static final class C0255b {

        /* renamed from: a  reason: collision with root package name */
        final int f34328a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f34329b;

        /* renamed from: c  reason: collision with root package name */
        long f34330c;

        C0255b(ThreadFactory threadFactory, int i2) {
            this.f34328a = i2;
            this.f34329b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f34329b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f34328a;
            if (i2 == 0) {
                return b.f34316c;
            }
            c[] cVarArr = this.f34329b;
            long j2 = this.f34330c;
            this.f34330c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c unsubscribe : this.f34329b) {
                unsubscribe.unsubscribe();
            }
        }
    }

    static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f34315b = intValue;
        c cVar = new c(RxThreadFactory.f34357a);
        f34316c = cVar;
        cVar.unsubscribe();
    }

    public b(ThreadFactory threadFactory) {
        this.f34318e = threadFactory;
        c();
    }

    public e.a a() {
        return new a(this.f34319f.get().a());
    }

    public i a(on.a aVar) {
        return this.f34319f.get().a().b(aVar, -1, TimeUnit.NANOSECONDS);
    }

    public void c() {
        C0255b bVar = new C0255b(this.f34318e, f34315b);
        if (!this.f34319f.compareAndSet(f34317d, bVar)) {
            bVar.b();
        }
    }
}
