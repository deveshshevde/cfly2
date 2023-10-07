package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import ok.d;
import ok.h;
import rx.exceptions.a;

public final class SingleDelayedProducer<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = -2873467947112093874L;

    /* renamed from: a  reason: collision with root package name */
    final h<? super T> f34274a;

    /* renamed from: b  reason: collision with root package name */
    T f34275b;

    public SingleDelayedProducer(h<? super T> hVar) {
        this.f34274a = hVar;
    }

    private static <T> void a(h<? super T> hVar, T t2) {
        if (!hVar.isUnsubscribed()) {
            try {
                hVar.onNext(t2);
                if (!hVar.isUnsubscribed()) {
                    hVar.onCompleted();
                }
            } catch (Throwable th) {
                a.a(th, hVar, t2);
            }
        }
    }

    public void a(T t2) {
        do {
            int i2 = get();
            if (i2 == 0) {
                this.f34275b = t2;
            } else if (i2 == 2 && compareAndSet(2, 3)) {
                a(this.f34274a, t2);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }

    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j2 != 0) {
            do {
                int i2 = get();
                if (i2 != 0) {
                    if (i2 == 1 && compareAndSet(1, 3)) {
                        a(this.f34274a, this.f34275b);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
