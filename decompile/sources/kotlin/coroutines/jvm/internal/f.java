package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.h;

public final class f {
    public static final <T> c<T> a(c<? super T> cVar) {
        h.d(cVar, "completion");
        return cVar;
    }

    public static final void b(c<?> cVar) {
        h.d(cVar, "frame");
    }

    public static final void c(c<?> cVar) {
        h.d(cVar, "frame");
    }
}
