package op;

abstract class p<E> extends l<E> {

    /* renamed from: e  reason: collision with root package name */
    protected static final long f32506e = y.a(p.class, "producerIndex");
    private volatile long producerIndex;

    public p(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long b() {
        return this.producerIndex;
    }

    /* access modifiers changed from: protected */
    public final void d(long j2) {
        y.f32512a.putOrderedLong(this, f32506e, j2);
    }
}
