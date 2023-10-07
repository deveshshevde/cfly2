package ok;

import ok.b;
import or.d;
import rx.internal.producers.SingleDelayedProducer;

public class f<T> {

    /* renamed from: b  reason: collision with root package name */
    static or.f f31790b = d.a().d();

    /* renamed from: a  reason: collision with root package name */
    final b.a<T> f31791a;

    public interface a<T> extends on.b<g<? super T>> {
    }

    protected f(final a<T> aVar) {
        this.f31791a = new b.a<T>() {
            /* renamed from: a */
            public void call(final h<? super T> hVar) {
                final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(hVar);
                hVar.setProducer(singleDelayedProducer);
                AnonymousClass1 r1 = new g<T>() {
                    public void a(T t2) {
                        singleDelayedProducer.a(t2);
                    }

                    public void a(Throwable th) {
                        hVar.onError(th);
                    }
                };
                hVar.add(r1);
                aVar.call(r1);
            }
        };
    }
}
