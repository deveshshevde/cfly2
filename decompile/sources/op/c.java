package op;

public abstract class c<E> extends a<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final long f32500e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f32501f;

    /* renamed from: d  reason: collision with root package name */
    protected final long[] f32502d;

    static {
        Class<long[]> cls = long[].class;
        if (8 == y.f32512a.arrayIndexScale(cls)) {
            int i2 = f32495a + 3;
            f32501f = i2;
            f32500e = (long) (y.f32512a.arrayBaseOffset(cls) + (32 << (i2 - f32495a)));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public c(int i2) {
        super(i2);
        int i3 = (int) (this.f32498b + 1);
        this.f32502d = new long[((i3 << f32495a) + 64)];
        for (long j2 = 0; j2 < ((long) i3); j2++) {
            a(this.f32502d, d(j2), j2);
        }
    }

    /* access modifiers changed from: protected */
    public final long a(long[] jArr, long j2) {
        return y.f32512a.getLongVolatile(jArr, j2);
    }

    /* access modifiers changed from: protected */
    public final void a(long[] jArr, long j2, long j3) {
        y.f32512a.putOrderedLong(jArr, j2, j3);
    }

    /* access modifiers changed from: protected */
    public final long d(long j2) {
        return f32500e + ((j2 & this.f32498b) << f32501f);
    }
}
