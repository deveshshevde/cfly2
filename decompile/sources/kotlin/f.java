package kotlin;

public final /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f30220a;

    static {
        int[] iArr = new int[LazyThreadSafetyMode.values().length];
        f30220a = iArr;
        iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
    }
}
