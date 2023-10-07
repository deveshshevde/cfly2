package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import mm.m;

final class CoroutineContext$plus$1 extends Lambda implements m<f, f.b, f> {

    /* renamed from: a  reason: collision with root package name */
    public static final CoroutineContext$plus$1 f30193a = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    public final f a(f fVar, f.b bVar) {
        CombinedContext combinedContext;
        h.d(fVar, "acc");
        h.d(bVar, "element");
        f minusKey = fVar.minusKey(bVar.getKey());
        if (minusKey == EmptyCoroutineContext.f30194a) {
            return bVar;
        }
        d dVar = (d) minusKey.get(d.f30197a);
        if (dVar == null) {
            combinedContext = new CombinedContext(minusKey, bVar);
        } else {
            f minusKey2 = minusKey.minusKey(d.f30197a);
            combinedContext = minusKey2 == EmptyCoroutineContext.f30194a ? new CombinedContext(bVar, dVar) : new CombinedContext(new CombinedContext(minusKey2, bVar), dVar);
        }
        return combinedContext;
    }
}
