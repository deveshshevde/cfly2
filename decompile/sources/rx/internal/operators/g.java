package rx.internal.operators;

import ok.b;
import ok.h;
import on.c;
import ot.d;
import rx.internal.producers.a;

public final class g<T> implements b.C0235b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final c<Throwable, ? extends b<? extends T>> f34254a;

    public g(c<Throwable, ? extends b<? extends T>> cVar) {
        this.f34254a = cVar;
    }

    public static <T> g<T> a(final c<Throwable, ? extends T> cVar) {
        return new g<>(new c<Throwable, b<? extends T>>() {
            /* renamed from: a */
            public b<? extends T> call(Throwable th) {
                return b.a(cVar.call(th));
            }
        });
    }

    /* renamed from: a */
    public h<? super T> call(final h<? super T> hVar) {
        final a aVar = new a();
        final d dVar = new d();
        AnonymousClass2 r2 = new h<T>() {

            /* renamed from: a  reason: collision with root package name */
            long f34256a;

            /* renamed from: f  reason: collision with root package name */
            private boolean f34261f;

            public void onCompleted() {
                if (!this.f34261f) {
                    this.f34261f = true;
                    hVar.onCompleted();
                }
            }

            public void onError(Throwable th) {
                if (this.f34261f) {
                    rx.exceptions.a.a(th);
                    or.d.a().b().a(th);
                    return;
                }
                this.f34261f = true;
                try {
                    unsubscribe();
                    AnonymousClass1 r0 = new h<T>() {
                        public void onCompleted() {
                            hVar.onCompleted();
                        }

                        public void onError(Throwable th) {
                            hVar.onError(th);
                        }

                        public void onNext(T t2) {
                            hVar.onNext(t2);
                        }

                        public void setProducer(ok.d dVar) {
                            aVar.a(dVar);
                        }
                    };
                    dVar.a(r0);
                    long j2 = this.f34256a;
                    if (j2 != 0) {
                        aVar.a(j2);
                    }
                    ((b) g.this.f34254a.call(th)).a(r0);
                } catch (Throwable th2) {
                    rx.exceptions.a.a(th2, (ok.c<?>) hVar);
                }
            }

            public void onNext(T t2) {
                if (!this.f34261f) {
                    this.f34256a++;
                    hVar.onNext(t2);
                }
            }

            public void setProducer(ok.d dVar) {
                aVar.a(dVar);
            }
        };
        dVar.a(r2);
        hVar.add(dVar);
        hVar.setProducer(aVar);
        return r2;
    }
}
