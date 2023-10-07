package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import kotlin.l;
import kotlinx.coroutines.CoroutineExceptionHandler;
import mm.m;

public interface bg extends f.b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f30343b = b.f30344a;

    public static final class a {
        public static <R> R a(bg bgVar, R r2, m<? super R, ? super f.b, ? extends R> mVar) {
            return f.b.a.a(bgVar, r2, mVar);
        }

        public static <E extends f.b> E a(bg bgVar, f.c<E> cVar) {
            return f.b.a.a((f.b) bgVar, cVar);
        }

        public static f a(bg bgVar, f fVar) {
            return f.b.a.a((f.b) bgVar, fVar);
        }

        public static /* synthetic */ aq a(bg bgVar, boolean z2, boolean z3, mm.b bVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z2 = false;
                }
                if ((i2 & 2) != 0) {
                    z3 = true;
                }
                return bgVar.a(z2, z3, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static /* synthetic */ void a(bg bgVar, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                bgVar.a(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static f b(bg bgVar, f.c<?> cVar) {
            return f.b.a.b(bgVar, cVar);
        }
    }

    public static final class b implements f.c<bg> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f30344a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f30279a;
        }

        private b() {
        }
    }

    aq a(boolean z2, boolean z3, mm.b<? super Throwable, l> bVar);

    o a(q qVar);

    void a(CancellationException cancellationException);

    boolean a();

    CancellationException i();

    boolean j();
}
