package kotlinx.coroutines;

import kotlin.coroutines.f;

public interface CoroutineExceptionHandler extends f.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30279a = a.f30280a;

    public static final class a implements f.c<CoroutineExceptionHandler> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f30280a = new a();

        private a() {
        }
    }

    void handleException(f fVar, Throwable th);
}
