package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.f;
import mt.c;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f30292a = c.b(c.a(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));

    public static final void a(f fVar, Throwable th) {
        for (CoroutineExceptionHandler handleException : f30292a) {
            try {
                handleException.handleException(fVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, ac.a(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
