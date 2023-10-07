package androidx.work.impl.utils.futures;

import gz.a;

public final class b<V> extends a<V> {
    private b() {
    }

    public static <V> b<V> d() {
        return new b<>();
    }

    public boolean a(a<? extends V> aVar) {
        return super.a(aVar);
    }

    public boolean a(V v2) {
        return super.a(v2);
    }

    public boolean a(Throwable th) {
        return super.a(th);
    }
}
