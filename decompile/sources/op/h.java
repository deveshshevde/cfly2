package op;

abstract class h<E> extends f<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final long f32504e = y.a(h.class, "producerIndex");
    private volatile long producerIndex;

    public h(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long b() {
        return this.producerIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean c(long j2, long j3) {
        return y.f32512a.compareAndSwapLong(this, f32504e, j2, j3);
    }
}
