package kotlinx.coroutines;

public final /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f30372a;

    static {
        int[] iArr = new int[CoroutineStart.values().length];
        f30372a = iArr;
        iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
        iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
        iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
        iArr[CoroutineStart.LAZY.ordinal()] = 4;
    }
}
