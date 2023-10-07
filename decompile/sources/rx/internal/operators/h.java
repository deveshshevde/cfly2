package rx.internal.operators;

import ok.b;
import ok.d;
import ok.e;
import on.a;

public final class h<T> implements b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final e f34263a;

    /* renamed from: b  reason: collision with root package name */
    final b<T> f34264b;

    public h(b<T> bVar, e eVar) {
        this.f34263a = eVar;
        this.f34264b = bVar;
    }

    /* renamed from: a */
    public void call(final ok.h<? super T> hVar) {
        final e.a a2 = this.f34263a.a();
        hVar.add(a2);
        a2.a(new a() {
            public void call() {
                final Thread currentThread = Thread.currentThread();
                h.this.f34264b.a(new ok.h<T>(hVar) {
                    public void onCompleted() {
                        try {
                            hVar.onCompleted();
                        } finally {
                            a2.unsubscribe();
                        }
                    }

                    public void onError(Throwable th) {
                        try {
                            hVar.onError(th);
                        } finally {
                            a2.unsubscribe();
                        }
                    }

                    public void onNext(T t2) {
                        hVar.onNext(t2);
                    }

                    public void setProducer(final d dVar) {
                        hVar.setProducer(new d() {
                            public void request(final long j2) {
                                if (currentThread == Thread.currentThread()) {
                                    dVar.request(j2);
                                } else {
                                    a2.a(new a() {
                                        public void call() {
                                            dVar.request(j2);
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}
