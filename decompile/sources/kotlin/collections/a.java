package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

final class a<T> implements Collection<T>, mn.a {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f30187a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30188b;

    public a(T[] tArr, boolean z2) {
        h.d(tArr, "values");
        this.f30187a = tArr;
        this.f30188b = z2;
    }

    public int a() {
        return this.f30187a.length;
    }

    public boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return b.a(this.f30187a, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        h.d(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f30187a.length == 0;
    }

    public Iterator<T> iterator() {
        return b.a(this.f30187a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return a();
    }

    public final Object[] toArray() {
        return h.a(this.f30187a, this.f30188b);
    }

    public <T> T[] toArray(T[] tArr) {
        return e.a(this, tArr);
    }
}
