package op;

import java.util.Objects;

public final class j<E> extends n<E> {
    public j(int i2) {
        super(i2);
    }

    public boolean isEmpty() {
        return a() == b();
    }

    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        Object[] objArr = this.f32499c;
        long j2 = this.f32498b;
        long b2 = b();
        long a2 = a(b2);
        if (b(objArr, a2) == null) {
            a(objArr, a2, e2);
            d(b2 + 1);
        } else if (b2 - a() > j2) {
            return false;
        } else {
            do {
            } while (b(objArr, a2) != null);
        }
        a(objArr, a2, e2);
        d(b2 + 1);
        return true;
    }

    public E peek() {
        E c2;
        long c3 = c();
        do {
            long a2 = a();
            if (a2 >= c3) {
                long b2 = b();
                if (a2 >= b2) {
                    return null;
                }
                e(b2);
            }
            c2 = c(a(a2));
        } while (c2 == null);
        return c2;
    }

    public E poll() {
        long a2;
        long c2 = c();
        do {
            a2 = a();
            if (a2 >= c2) {
                long b2 = b();
                if (a2 >= b2) {
                    return null;
                }
                e(b2);
            }
        } while (!b(a2, 1 + a2));
        long a3 = a(a2);
        Object[] objArr = this.f32499c;
        E a4 = a((E[]) objArr, a3);
        b(objArr, a3, null);
        return a4;
    }

    public int size() {
        long a2 = a();
        while (true) {
            long b2 = b();
            long a3 = a();
            if (a2 == a3) {
                return (int) (b2 - a3);
            }
            a2 = a3;
        }
    }
}
