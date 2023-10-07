package op;

abstract class s<E> extends a<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final Integer f32508e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: d  reason: collision with root package name */
    protected final int f32509d;

    public s(int i2) {
        super(i2);
        this.f32509d = Math.min(i2 / 4, f32508e.intValue());
    }
}
