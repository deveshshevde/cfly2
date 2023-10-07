package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.h;

public final class i {
    public static final Object a(Throwable th) {
        h.d(th, "exception");
        return new Result.Failure(th);
    }

    public static final void a(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).f30173a;
        }
    }
}
