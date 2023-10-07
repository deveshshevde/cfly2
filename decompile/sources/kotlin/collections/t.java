package kotlin.collections;

import java.util.Iterator;
import mn.a;

public abstract class t implements Iterator<Integer>, a {
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
