package rx.internal.operators;

import ok.b;
import ok.h;
import or.d;
import rx.exceptions.a;

public final class c<T, R> implements b.a<R> {

    /* renamed from: a  reason: collision with root package name */
    static final or.b f34226a = d.a().c();

    /* renamed from: b  reason: collision with root package name */
    final b.a<T> f34227b;

    /* renamed from: c  reason: collision with root package name */
    final b.C0235b<? extends R, ? super T> f34228c;

    public c(b.a<T> aVar, b.C0235b<? extends R, ? super T> bVar) {
        this.f34227b = aVar;
        this.f34228c = bVar;
    }

    /* renamed from: a */
    public void call(h<? super R> hVar) {
        h hVar2;
        try {
            hVar2 = (h) f34226a.a(this.f34228c).call(hVar);
            hVar2.onStart();
            this.f34227b.call(hVar2);
        } catch (Throwable th) {
            a.a(th);
            hVar.onError(th);
        }
    }
}
