package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.f;
import kotlin.l;

public final class al {
    public static final Object a(long j2, c<? super l> cVar) {
        if (j2 <= 0) {
            return l.f30254a;
        }
        k kVar = new k(a.a(cVar), 1);
        kVar.e();
        j jVar = kVar;
        if (j2 < Long.MAX_VALUE) {
            a(jVar.getContext()).a(j2, jVar);
        }
        Object g2 = kVar.g();
        if (g2 == a.a()) {
            f.c(cVar);
        }
        return g2;
    }

    public static final ak a(kotlin.coroutines.f fVar) {
        f.b bVar = fVar.get(d.f30197a);
        if (!(bVar instanceof ak)) {
            bVar = null;
        }
        ak akVar = (ak) bVar;
        return akVar != null ? akVar : aj.a();
    }
}
