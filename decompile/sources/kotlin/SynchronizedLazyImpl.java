package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.h;
import mm.a;

final class SynchronizedLazyImpl<T> implements Serializable, d<T> {

    /* renamed from: a  reason: collision with root package name */
    private a<? extends T> f30179a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f30180b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f30181c;

    public SynchronizedLazyImpl(a<? extends T> aVar, Object obj) {
        h.d(aVar, "initializer");
        this.f30179a = aVar;
        this.f30180b = k.f30253a;
        this.f30181c = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(a aVar, Object obj, int i2, f fVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }

    public T a() {
        T t2;
        T t3 = this.f30180b;
        if (t3 != k.f30253a) {
            return t3;
        }
        synchronized (this.f30181c) {
            t2 = this.f30180b;
            if (t2 == k.f30253a) {
                a aVar = this.f30179a;
                h.a((Object) aVar);
                t2 = aVar.e_();
                this.f30180b = t2;
                this.f30179a = null;
            }
        }
        return t2;
    }

    public boolean b() {
        return this.f30180b != k.f30253a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
