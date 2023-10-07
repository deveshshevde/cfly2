package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.jvm.internal.h;

public abstract class b<B extends f.b, E extends B> implements f.c<E> {

    /* renamed from: a  reason: collision with root package name */
    private final f.c<?> f30195a;

    /* renamed from: b  reason: collision with root package name */
    private final mm.b<f.b, E> f30196b;

    public b(f.c<B> cVar, mm.b<? super f.b, ? extends E> bVar) {
        h.d(cVar, "baseKey");
        h.d(bVar, "safeCast");
        this.f30196b = bVar;
        this.f30195a = cVar instanceof b ? ((b) cVar).f30195a : cVar;
    }

    public final E a(f.b bVar) {
        h.d(bVar, "element");
        return (f.b) this.f30196b.invoke(bVar);
    }

    public final boolean a(f.c<?> cVar) {
        h.d(cVar, "key");
        return cVar == this || this.f30195a == cVar;
    }
}
