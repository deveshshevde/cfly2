package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.h;
import mm.a;

public final class UnsafeLazyImpl<T> implements Serializable, d<T> {

    /* renamed from: a  reason: collision with root package name */
    private a<? extends T> f30182a;

    /* renamed from: b  reason: collision with root package name */
    private Object f30183b = k.f30253a;

    public UnsafeLazyImpl(a<? extends T> aVar) {
        h.d(aVar, "initializer");
        this.f30182a = aVar;
    }

    public T a() {
        if (this.f30183b == k.f30253a) {
            a<? extends T> aVar = this.f30182a;
            h.a((Object) aVar);
            this.f30183b = aVar.e_();
            this.f30182a = null;
        }
        return this.f30183b;
    }

    public boolean b() {
        return this.f30183b != k.f30253a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
