package rx.internal.operators;

import java.util.NoSuchElementException;
import ok.b;
import ok.f;
import ok.g;
import ok.h;
import ok.i;

public class d<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f34229a;

    public d(b<T> bVar) {
        this.f34229a = bVar;
    }

    public static <T> d<T> a(b<T> bVar) {
        return new d<>(bVar);
    }

    /* renamed from: a */
    public void call(final g<? super T> gVar) {
        AnonymousClass1 r0 = new h<T>() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f34232c = false;

            /* renamed from: d  reason: collision with root package name */
            private boolean f34233d = false;

            /* renamed from: e  reason: collision with root package name */
            private T f34234e = null;

            public void onCompleted() {
                if (!this.f34232c) {
                    if (this.f34233d) {
                        gVar.a(this.f34234e);
                    } else {
                        gVar.a((Throwable) new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            public void onError(Throwable th) {
                gVar.a(th);
                unsubscribe();
            }

            public void onNext(T t2) {
                if (this.f34233d) {
                    this.f34232c = true;
                    gVar.a((Throwable) new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                    return;
                }
                this.f34233d = true;
                this.f34234e = t2;
            }

            public void onStart() {
                request(2);
            }
        };
        gVar.a((i) r0);
        this.f34229a.a(r0);
    }
}
