package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;

public final class a {
    public static long a(long j2, long j3) {
        long j4 = j2 + j3;
        if (j4 < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
        return j3;
    }

    public static long b(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                throw new IllegalStateException("More produced than requested: " + j4);
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }
}
