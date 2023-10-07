package ok;

import on.c;
import or.d;
import rx.exceptions.OnErrorFailedException;
import rx.internal.operators.e;
import rx.internal.operators.f;
import rx.internal.operators.g;
import rx.internal.operators.h;
import rx.internal.util.ScalarSynchronousObservable;

public class b<T> {

    /* renamed from: b  reason: collision with root package name */
    static final or.b f31778b = d.a().c();

    /* renamed from: a  reason: collision with root package name */
    final a<T> f31779a;

    public interface a<T> extends on.b<h<? super T>> {
    }

    /* renamed from: ok.b$b  reason: collision with other inner class name */
    public interface C0235b<R, T> extends c<h<? super R>, h<? super T>> {
    }

    protected b(a<T> aVar) {
        this.f31779a = aVar;
    }

    public static <T> b<T> a(T t2) {
        return ScalarSynchronousObservable.b(t2);
    }

    public static <T> b<T> a(a<T> aVar) {
        return new b<>(f31778b.a(aVar));
    }

    static <T> i a(h<? super T> hVar, b<T> bVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        } else if (bVar.f31779a != null) {
            hVar.onStart();
            if (!(hVar instanceof oq.a)) {
                hVar = new oq.a<>(hVar);
            }
            try {
                or.b bVar2 = f31778b;
                bVar2.a(bVar, bVar.f31779a).call(hVar);
                return bVar2.a((i) hVar);
            } catch (Throwable th) {
                rx.exceptions.a.a(th);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
                f31778b.a((Throwable) onErrorFailedException);
                throw onErrorFailedException;
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    public final <R> b<R> a(C0235b<? extends R, ? super T> bVar) {
        return new b<>(new rx.internal.operators.c(this.f31779a, bVar));
    }

    public final b<T> a(e eVar) {
        return a(eVar, rx.internal.util.d.f34386b);
    }

    public final b<T> a(e eVar, int i2) {
        return a(eVar, false, i2);
    }

    public final b<T> a(e eVar, boolean z2, int i2) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).c(eVar) : a(new f(eVar, z2, i2));
    }

    public final <R> b<R> a(c<? super T, ? extends R> cVar) {
        return a(new e(cVar));
    }

    public f<T> a() {
        return new f<>(rx.internal.operators.d.a(this));
    }

    public final i a(h<? super T> hVar) {
        try {
            hVar.onStart();
            or.b bVar = f31778b;
            bVar.a(this, this.f31779a).call(hVar);
            return bVar.a((i) hVar);
        } catch (Throwable th) {
            rx.exceptions.a.a(th);
            RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
            f31778b.a((Throwable) runtimeException);
            throw runtimeException;
        }
    }

    public final b<T> b(e eVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).c(eVar) : a(new h(this, eVar));
    }

    public final b<T> b(c<Throwable, ? extends T> cVar) {
        return a(g.a(cVar));
    }

    public final i b(h<? super T> hVar) {
        return a(hVar, this);
    }
}
