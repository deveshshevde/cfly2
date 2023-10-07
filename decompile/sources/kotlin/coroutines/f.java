package kotlin.coroutines;

import java.util.Objects;
import kotlin.jvm.internal.h;
import mm.m;

public interface f {

    public static final class a {
        public static f a(f fVar, f fVar2) {
            h.d(fVar2, "context");
            return fVar2 == EmptyCoroutineContext.f30194a ? fVar : (f) fVar2.fold(fVar, CoroutineContext$plus$1.f30193a);
        }
    }

    public interface b extends f {

        public static final class a {
            public static <R> R a(b bVar, R r2, m<? super R, ? super b, ? extends R> mVar) {
                h.d(mVar, "operation");
                return mVar.a(r2, bVar);
            }

            public static <E extends b> E a(b bVar, c<E> cVar) {
                h.d(cVar, "key");
                if (!h.a((Object) bVar.getKey(), (Object) cVar)) {
                    return null;
                }
                Objects.requireNonNull(bVar, "null cannot be cast to non-null type E");
                return bVar;
            }

            public static f a(b bVar, f fVar) {
                h.d(fVar, "context");
                return a.a(bVar, fVar);
            }

            public static f b(b bVar, c<?> cVar) {
                h.d(cVar, "key");
                boolean a2 = h.a((Object) bVar.getKey(), (Object) cVar);
                f fVar = bVar;
                if (a2) {
                    fVar = EmptyCoroutineContext.f30194a;
                }
                return fVar;
            }
        }

        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r2, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);

    f plus(f fVar);
}
