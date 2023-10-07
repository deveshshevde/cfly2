package ms;

import mm.b;
import ms.g;

public interface h<T, V> extends b<T, V>, g<V> {

    public interface a<T, V> extends b<T, V>, g.a<V> {
    }

    V a(T t2);

    a<T, V> d();
}
