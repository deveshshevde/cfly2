package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T>, mn.a {

    /* renamed from: a  reason: collision with root package name */
    private int f30238a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f30239b;

    public a(T[] tArr) {
        h.d(tArr, "array");
        this.f30239b = tArr;
    }

    public boolean hasNext() {
        return this.f30238a < this.f30239b.length;
    }

    public T next() {
        try {
            T[] tArr = this.f30239b;
            int i2 = this.f30238a;
            this.f30238a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f30238a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
