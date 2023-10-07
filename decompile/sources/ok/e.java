package ok;

import java.util.concurrent.TimeUnit;
import ot.c;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final long f31780a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public static abstract class a implements i {
        public long a() {
            return System.currentTimeMillis();
        }

        public abstract i a(on.a aVar);

        public i a(on.a aVar, long j2, long j3, TimeUnit timeUnit) {
            long j4 = j2;
            TimeUnit timeUnit2 = timeUnit;
            long nanos = timeUnit2.toNanos(j3);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(a());
            long nanos3 = nanos2 + timeUnit2.toNanos(j4);
            c cVar = new c();
            AnonymousClass1 r5 = new on.a(nanos2, nanos3, cVar, aVar, nanos) {

                /* renamed from: a  reason: collision with root package name */
                long f31781a;

                /* renamed from: b  reason: collision with root package name */
                long f31782b;

                /* renamed from: c  reason: collision with root package name */
                long f31783c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ long f31784d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ long f31785e;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ c f31786f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ on.a f31787g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ long f31788h;

                {
                    this.f31784d = r2;
                    this.f31785e = r4;
                    this.f31786f = r6;
                    this.f31787g = r7;
                    this.f31788h = r8;
                    this.f31782b = r2;
                    this.f31783c = r4;
                }

                public void call() {
                    long j2;
                    if (!this.f31786f.isUnsubscribed()) {
                        this.f31787g.call();
                        long nanos = TimeUnit.MILLISECONDS.toNanos(a.this.a());
                        long j3 = this.f31782b;
                        if (e.f31780a + nanos < j3 || nanos >= j3 + this.f31788h + e.f31780a) {
                            long j4 = this.f31788h;
                            long j5 = nanos + j4;
                            long j6 = this.f31781a + 1;
                            this.f31781a = j6;
                            this.f31783c = j5 - (j4 * j6);
                            j2 = j5;
                        } else {
                            long j7 = this.f31783c;
                            long j8 = this.f31781a + 1;
                            this.f31781a = j8;
                            j2 = j7 + (j8 * this.f31788h);
                        }
                        this.f31782b = nanos;
                        this.f31786f.a(a.this.a(this, j2 - nanos, TimeUnit.NANOSECONDS));
                    }
                }
            };
            c cVar2 = new c();
            cVar.a(cVar2);
            cVar2.a(a(r5, j4, timeUnit2));
            return cVar;
        }

        public abstract i a(on.a aVar, long j2, TimeUnit timeUnit);
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }
}
