package kotlinx.coroutines;

import kotlin.coroutines.f;
import mm.m;

public interface bx<S> extends f.b {

    public static final class a {
        public static <S, R> R a(bx<S> bxVar, R r2, m<? super R, ? super f.b, ? extends R> mVar) {
            return f.b.a.a(bxVar, r2, mVar);
        }

        public static <S, E extends f.b> E a(bx<S> bxVar, f.c<E> cVar) {
            return f.b.a.a((f.b) bxVar, cVar);
        }

        public static <S> f a(bx<S> bxVar, f fVar) {
            return f.b.a.a((f.b) bxVar, fVar);
        }

        public static <S> f b(bx<S> bxVar, f.c<?> cVar) {
            return f.b.a.b(bxVar, cVar);
        }
    }

    void a(f fVar, S s2);

    S b(f fVar);
}
