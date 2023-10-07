package rx.internal.schedulers;

import ok.e;
import on.a;

class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f34344a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f34345b;

    /* renamed from: c  reason: collision with root package name */
    private final long f34346c;

    public f(a aVar, e.a aVar2, long j2) {
        this.f34344a = aVar;
        this.f34345b = aVar2;
        this.f34346c = j2;
    }

    public void call() {
        if (!this.f34345b.isUnsubscribed()) {
            long a2 = this.f34346c - this.f34345b.a();
            if (a2 > 0) {
                try {
                    Thread.sleep(a2);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e2);
                }
            }
            if (!this.f34345b.isUnsubscribed()) {
                this.f34344a.call();
            }
        }
    }
}
