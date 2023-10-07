package op;

abstract class k<E> extends m<E> {

    /* renamed from: d  reason: collision with root package name */
    protected static final long f32505d = y.a(k.class, "consumerIndex");
    private volatile long consumerIndex;

    public k(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long a() {
        return this.consumerIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean b(long j2, long j3) {
        return y.f32512a.compareAndSwapLong(this, f32505d, j2, j3);
    }
}
