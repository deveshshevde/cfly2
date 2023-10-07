package op;

import java.util.Objects;

public final class r<E> extends w<E> {
    public r(int i2) {
        super(i2);
    }

    private long a() {
        return y.f32512a.getLongVolatile(this, f32511f);
    }

    private long b() {
        return y.f32512a.getLongVolatile(this, f32510e);
    }

    private void d(long j2) {
        y.f32512a.putOrderedLong(this, f32511f, j2);
    }

    private void e(long j2) {
        y.f32512a.putOrderedLong(this, f32510e, j2);
    }

    public boolean isEmpty() {
        return a() == b();
    }

    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "null elements not allowed");
        Object[] objArr = this.f32499c;
        long j2 = this.producerIndex;
        long a2 = a(j2);
        if (b(objArr, a2) != null) {
            return false;
        }
        d(j2 + 1);
        b(objArr, a2, e2);
        return true;
    }

    public E peek() {
        return c(a(this.consumerIndex));
    }

    public E poll() {
        long j2 = this.consumerIndex;
        long a2 = a(j2);
        Object[] objArr = this.f32499c;
        E b2 = b(objArr, a2);
        if (b2 == null) {
            return null;
        }
        e(j2 + 1);
        b(objArr, a2, null);
        return b2;
    }

    public int size() {
        long b2 = b();
        while (true) {
            long a2 = a();
            long b3 = b();
            if (b2 == b3) {
                return (int) (a2 - b3);
            }
            b2 = b3;
        }
    }
}
