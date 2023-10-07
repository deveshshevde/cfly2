package kotlinx.coroutines;

import java.util.Objects;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlinx.coroutines.internal.e;

public abstract class aa extends kotlin.coroutines.a implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f30291c = new a((f) null);

    public static final class a extends b<d, aa> {
        private a() {
            super(d.f30197a, CoroutineDispatcher$Key$1.f30278a);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public aa() {
        super(d.f30197a);
    }

    public <T> c<T> a(c<? super T> cVar) {
        return new e<>(this, cVar);
    }

    public abstract void a(f fVar, Runnable runnable);

    public boolean a(f fVar) {
        return true;
    }

    public void b(c<?> cVar) {
        Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        k<?> a2 = ((e) cVar).a();
        if (a2 != null) {
            a2.h();
        }
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        return d.a.a(this, cVar);
    }

    public f minusKey(f.c<?> cVar) {
        return d.a.b(this, cVar);
    }

    public String toString() {
        return ah.b(this) + '@' + ah.a((Object) this);
    }
}
