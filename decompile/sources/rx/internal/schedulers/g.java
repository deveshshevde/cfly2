package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ok.e;
import ok.i;

public final class g extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final g f34347b = new g();

    private static class a extends e.a implements i {

        /* renamed from: a  reason: collision with root package name */
        final AtomicInteger f34348a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<b> f34349b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final ot.a f34350c = new ot.a();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f34351d = new AtomicInteger();

        a() {
        }

        private i a(on.a aVar, long j2) {
            if (this.f34350c.isUnsubscribed()) {
                return ot.e.b();
            }
            final b bVar = new b(aVar, Long.valueOf(j2), this.f34348a.incrementAndGet());
            this.f34349b.add(bVar);
            if (this.f34351d.getAndIncrement() != 0) {
                return ot.e.a((on.a) new on.a() {
                    public void call() {
                        a.this.f34349b.remove(bVar);
                    }
                });
            }
            do {
                b poll = this.f34349b.poll();
                if (poll != null) {
                    poll.f34354a.call();
                }
            } while (this.f34351d.decrementAndGet() > 0);
            return ot.e.b();
        }

        public i a(on.a aVar) {
            return a(aVar, a());
        }

        public i a(on.a aVar, long j2, TimeUnit timeUnit) {
            long a2 = a() + timeUnit.toMillis(j2);
            return a(new f(aVar, this, a2), a2);
        }

        public boolean isUnsubscribed() {
            return this.f34350c.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f34350c.unsubscribe();
        }
    }

    private static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final on.a f34354a;

        /* renamed from: b  reason: collision with root package name */
        final Long f34355b;

        /* renamed from: c  reason: collision with root package name */
        final int f34356c;

        b(on.a aVar, Long l2, int i2) {
            this.f34354a = aVar;
            this.f34355b = l2;
            this.f34356c = i2;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f34355b.compareTo(bVar.f34355b);
            return compareTo == 0 ? g.a(this.f34356c, bVar.f34356c) : compareTo;
        }
    }

    private g() {
    }

    static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public e.a a() {
        return new a();
    }
}
