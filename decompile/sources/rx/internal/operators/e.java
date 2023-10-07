package rx.internal.operators;

import ok.b;
import ok.d;
import ok.h;
import on.c;
import rx.exceptions.OnErrorThrowable;

public final class e<T, R> implements b.C0235b<R, T> {

    /* renamed from: a  reason: collision with root package name */
    final c<? super T, ? extends R> f34235a;

    static final class a<T, R> extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super R> f34236a;

        /* renamed from: b  reason: collision with root package name */
        final c<? super T, ? extends R> f34237b;

        /* renamed from: c  reason: collision with root package name */
        boolean f34238c;

        public a(h<? super R> hVar, c<? super T, ? extends R> cVar) {
            this.f34236a = hVar;
            this.f34237b = cVar;
        }

        public void onCompleted() {
            if (!this.f34238c) {
                this.f34236a.onCompleted();
            }
        }

        public void onError(Throwable th) {
            if (this.f34238c) {
                rx.internal.util.c.a(th);
                return;
            }
            this.f34238c = true;
            this.f34236a.onError(th);
        }

        public void onNext(T t2) {
            try {
                this.f34236a.onNext(this.f34237b.call(t2));
            } catch (Throwable th) {
                rx.exceptions.a.a(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t2));
            }
        }

        public void setProducer(d dVar) {
            this.f34236a.setProducer(dVar);
        }
    }

    public e(c<? super T, ? extends R> cVar) {
        this.f34235a = cVar;
    }

    /* renamed from: a */
    public h<? super T> call(h<? super R> hVar) {
        a aVar = new a(hVar, this.f34235a);
        hVar.add(aVar);
        return aVar;
    }
}
