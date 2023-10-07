package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import ok.d;
import ok.h;
import rx.exceptions.a;

public final class SingleProducer<T> extends AtomicBoolean implements d {
    private static final long serialVersionUID = -3353584923995471404L;

    /* renamed from: a  reason: collision with root package name */
    final h<? super T> f34276a;

    /* renamed from: b  reason: collision with root package name */
    final T f34277b;

    public SingleProducer(h<? super T> hVar, T t2) {
        this.f34276a = hVar;
        this.f34277b = t2;
    }

    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j2 != 0 && compareAndSet(false, true)) {
            h<? super T> hVar = this.f34276a;
            T t2 = this.f34277b;
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
    }
}
