package kotlin.coroutines;

import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;

public interface d extends f.b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30197a = b.f30198a;

    public static final class a {
        public static <E extends f.b> E a(d dVar, f.c<E> cVar) {
            h.d(cVar, "key");
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                E a2 = bVar.a((f.b) dVar);
                if (!(a2 instanceof f.b)) {
                    return null;
                }
                return a2;
            } else if (d.f30197a != cVar) {
                return null;
            } else {
                Objects.requireNonNull(dVar, "null cannot be cast to non-null type E");
                return dVar;
            }
        }

        public static f b(d dVar, f.c<?> cVar) {
            h.d(cVar, "key");
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                boolean a2 = bVar.a(dVar.getKey());
                f fVar = dVar;
                if (a2) {
                    f.b a3 = bVar.a((f.b) dVar);
                    fVar = dVar;
                    if (a3 != null) {
                        fVar = EmptyCoroutineContext.f30194a;
                    }
                }
                return fVar;
            }
            f fVar2 = dVar;
            if (d.f30197a == cVar) {
                fVar2 = EmptyCoroutineContext.f30194a;
            }
            return fVar2;
        }
    }

    public static final class b implements f.c<d> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f30198a = new b();

        private b() {
        }
    }

    <T> c<T> a(c<? super T> cVar);

    void b(c<?> cVar);
}
