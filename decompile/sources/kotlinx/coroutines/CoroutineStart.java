package kotlinx.coroutines;

public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final boolean a() {
        return this == LAZY;
    }
}
