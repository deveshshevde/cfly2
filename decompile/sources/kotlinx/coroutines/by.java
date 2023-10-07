package kotlinx.coroutines;

public final class by {

    /* renamed from: a  reason: collision with root package name */
    public static final by f30365a = new by();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<at> f30366b = new ThreadLocal<>();

    private by() {
    }

    public final at a() {
        ThreadLocal<at> threadLocal = f30366b;
        at atVar = threadLocal.get();
        if (atVar != null) {
            return atVar;
        }
        at a2 = aw.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void a(at atVar) {
        f30366b.set(atVar);
    }

    public final void b() {
        f30366b.set((Object) null);
    }
}
