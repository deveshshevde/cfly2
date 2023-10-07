package mr;

class f extends e {
    public static final int a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static final long a(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static final a a(int i2, int i3) {
        return a.f31276a.a(i2, i3, -1);
    }

    public static final long b(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static final c b(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? c.f31284b.a() : new c(i2, i3 - 1);
    }

    public static final int c(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static final int d(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }
}
