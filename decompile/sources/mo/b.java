package mo;

import kotlin.jvm.internal.h;
import ms.g;

final class b<T> implements c<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    private T f31212a;

    public T a(Object obj, g<?> gVar) {
        h.d(gVar, "property");
        T t2 = this.f31212a;
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException("Property " + gVar.b() + " should be initialized before get.");
    }

    public void a(Object obj, g<?> gVar, T t2) {
        h.d(gVar, "property");
        h.d(t2, "value");
        this.f31212a = t2;
    }
}
