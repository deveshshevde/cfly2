package mk;

import kotlin.jvm.internal.h;

public class a extends mj.a {
    public void a(Throwable th, Throwable th2) {
        h.d(th, "cause");
        h.d(th2, "exception");
        th.addSuppressed(th2);
    }
}
