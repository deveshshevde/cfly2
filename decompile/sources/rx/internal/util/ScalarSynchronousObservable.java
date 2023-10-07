package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import ok.b;
import ok.d;
import ok.e;
import ok.h;
import ok.i;
import on.c;
import rx.internal.producers.SingleProducer;

public final class ScalarSynchronousObservable<T> extends ok.b<T> {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f34359c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: d  reason: collision with root package name */
    final T f34360d;

    static final class ScalarAsyncProducer<T> extends AtomicBoolean implements d, on.a {
        private static final long serialVersionUID = -2466317989629281651L;

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f34369a;

        /* renamed from: b  reason: collision with root package name */
        final T f34370b;

        /* renamed from: c  reason: collision with root package name */
        final c<on.a, i> f34371c;

        public ScalarAsyncProducer(h<? super T> hVar, T t2, c<on.a, i> cVar) {
            this.f34369a = hVar;
            this.f34370b = t2;
            this.f34371c = cVar;
        }

        public void call() {
            h<? super T> hVar = this.f34369a;
            if (!hVar.isUnsubscribed()) {
                T t2 = this.f34370b;
                try {
                    hVar.onNext(t2);
                    if (!hVar.isUnsubscribed()) {
                        hVar.onCompleted();
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, hVar, t2);
                }
            }
        }

        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j2);
            } else if (j2 != 0 && compareAndSet(false, true)) {
                this.f34369a.add(this.f34371c.call(this));
            }
        }

        public String toString() {
            return "ScalarAsyncProducer[" + this.f34370b + ", " + get() + "]";
        }
    }

    static final class a<T> implements b.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f34372a;

        /* renamed from: b  reason: collision with root package name */
        final c<on.a, i> f34373b;

        a(T t2, c<on.a, i> cVar) {
            this.f34372a = t2;
            this.f34373b = cVar;
        }

        /* renamed from: a */
        public void call(h<? super T> hVar) {
            hVar.setProducer(new ScalarAsyncProducer(hVar, this.f34372a, this.f34373b));
        }
    }

    static final class b<T> implements d {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f34374a;

        /* renamed from: b  reason: collision with root package name */
        final T f34375b;

        /* renamed from: c  reason: collision with root package name */
        boolean f34376c;

        public b(h<? super T> hVar, T t2) {
            this.f34374a = hVar;
            this.f34375b = t2;
        }

        public void request(long j2) {
            if (!this.f34376c) {
                if (j2 < 0) {
                    throw new IllegalStateException("n >= required but it was " + j2);
                } else if (j2 != 0) {
                    this.f34376c = true;
                    h<? super T> hVar = this.f34374a;
                    if (!hVar.isUnsubscribed()) {
                        T t2 = this.f34375b;
                        try {
                            hVar.onNext(t2);
                            if (!hVar.isUnsubscribed()) {
                                hVar.onCompleted();
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, hVar, t2);
                        }
                    }
                }
            }
        }
    }

    protected ScalarSynchronousObservable(final T t2) {
        super(new b.a<T>() {
            /* renamed from: a */
            public void call(h<? super T> hVar) {
                hVar.setProducer(ScalarSynchronousObservable.a(hVar, t2));
            }
        });
        this.f34360d = t2;
    }

    static <T> d a(h<? super T> hVar, T t2) {
        return f34359c ? new SingleProducer(hVar, t2) : new b(hVar, t2);
    }

    public static <T> ScalarSynchronousObservable<T> b(T t2) {
        return new ScalarSynchronousObservable<>(t2);
    }

    public ok.b<T> c(final e eVar) {
        c cVar;
        if (eVar instanceof rx.internal.schedulers.b) {
            final rx.internal.schedulers.b bVar = (rx.internal.schedulers.b) eVar;
            cVar = new c<on.a, i>() {
                /* renamed from: a */
                public i call(on.a aVar) {
                    return bVar.a(aVar);
                }
            };
        } else {
            cVar = new c<on.a, i>() {
                /* renamed from: a */
                public i call(final on.a aVar) {
                    final e.a a2 = eVar.a();
                    a2.a(new on.a() {
                        public void call() {
                            try {
                                aVar.call();
                            } finally {
                                a2.unsubscribe();
                            }
                        }
                    });
                    return a2;
                }
            };
        }
        return a(new a(this.f34360d, cVar));
    }
}
