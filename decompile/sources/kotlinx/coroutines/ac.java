package kotlinx.coroutines;

import kotlin.a;
import kotlin.coroutines.f;

public final class ac {
    public static final Throwable a(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        Throwable runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        a.a(runtimeException, th);
        return runtimeException;
    }

    public static final void a(f fVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.f30279a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(fVar, th);
            } else {
                ab.a(fVar, th);
            }
        } catch (Throwable th2) {
            ab.a(fVar, a(th, th2));
        }
    }
}
