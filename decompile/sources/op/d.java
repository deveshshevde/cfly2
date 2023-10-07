package op;

import java.util.Objects;

public class d<E> extends e<E> {
    public d(int i2) {
        super(Math.max(2, i2));
    }

    public boolean isEmpty() {
        return a() == b();
    }

    public boolean offer(E e2) {
        E e3 = e2;
        Objects.requireNonNull(e3, "Null is not a valid element");
        long j2 = this.f32498b + 1;
        long[] jArr = this.f32502d;
        long j3 = Long.MAX_VALUE;
        while (true) {
            long b2 = b();
            long d2 = d(b2);
            long a2 = a(jArr, d2) - b2;
            if (a2 == 0) {
                long j4 = b2 + 1;
                if (c(b2, j4)) {
                    a(a(b2), e3);
                    a(jArr, d2, j4);
                    return true;
                }
            } else if (a2 < 0) {
                long j5 = b2 - j2;
                if (j5 <= j3) {
                    j3 = a();
                    if (j5 <= j3) {
                        return false;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E peek() {
        /*
            r6 = this;
        L_0x0000:
            long r0 = r6.a()
            long r2 = r6.a(r0)
            java.lang.Object r2 = r6.b(r2)
            if (r2 != 0) goto L_0x0016
            long r3 = r6.b()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0000
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: op.d.peek():java.lang.Object");
    }

    public E poll() {
        long[] jArr = this.f32502d;
        long j2 = -1;
        while (true) {
            long a2 = a();
            long d2 = d(a2);
            long j3 = a2 + 1;
            long a3 = a(jArr, d2) - j3;
            if (a3 == 0) {
                if (b(a2, j3)) {
                    long a4 = a(a2);
                    E b2 = b(a4);
                    a(a4, null);
                    a(jArr, d2, a2 + this.f32498b + 1);
                    return b2;
                }
            } else if (a3 < 0 && a2 >= j2) {
                j2 = b();
                if (a2 == j2) {
                    return null;
                }
            }
        }
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
