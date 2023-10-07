package op;

abstract class e<E> extends g<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final long f32503e = y.a(e.class, "consumerIndex");
    private volatile long consumerIndex;

    public e(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long a() {
        return this.consumerIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean b(long j2, long j3) {
        return y.f32512a.compareAndSwapLong(this, f32503e, j2, j3);
    }
}
