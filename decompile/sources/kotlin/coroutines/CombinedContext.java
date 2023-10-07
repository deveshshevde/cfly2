package kotlin.coroutines;

import java.io.Serializable;
import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import mm.m;

public final class CombinedContext implements Serializable, f {

    /* renamed from: a  reason: collision with root package name */
    private final f f30190a;

    /* renamed from: b  reason: collision with root package name */
    private final f.b f30191b;

    public CombinedContext(f fVar, f.b bVar) {
        h.d(fVar, "left");
        h.d(bVar, "element");
        this.f30190a = fVar;
        this.f30191b = bVar;
    }

    private final int a() {
        CombinedContext combinedContext = this;
        int i2 = 2;
        while (true) {
            f fVar = combinedContext.f30190a;
            if (!(fVar instanceof CombinedContext)) {
                fVar = null;
            }
            combinedContext = (CombinedContext) fVar;
            if (combinedContext == null) {
                return i2;
            }
            i2++;
        }
    }

    private final boolean a(CombinedContext combinedContext) {
        while (a(combinedContext.f30191b)) {
            f fVar = combinedContext.f30190a;
            if (fVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) fVar;
            } else {
                Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((f.b) fVar);
            }
        }
        return false;
    }

    private final boolean a(f.b bVar) {
        return h.a((Object) get(bVar.getKey()), (Object) bVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.a() != a() || !combinedContext.a(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public <R> R fold(R r2, m<? super R, ? super f.b, ? extends R> mVar) {
        h.d(mVar, "operation");
        return mVar.a(this.f30190a.fold(r2, mVar), this.f30191b);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        h.d(cVar, "key");
        f fVar = this;
        while (true) {
            CombinedContext combinedContext = (CombinedContext) fVar;
            E e2 = combinedContext.f30191b.get(cVar);
            if (e2 != null) {
                return e2;
            }
            fVar = combinedContext.f30190a;
            if (!(fVar instanceof CombinedContext)) {
                return fVar.get(cVar);
            }
        }
    }

    public int hashCode() {
        return this.f30190a.hashCode() + this.f30191b.hashCode();
    }

    public f minusKey(f.c<?> cVar) {
        h.d(cVar, "key");
        if (this.f30191b.get(cVar) != null) {
            return this.f30190a;
        }
        f minusKey = this.f30190a.minusKey(cVar);
        return minusKey == this.f30190a ? this : minusKey == EmptyCoroutineContext.f30194a ? this.f30191b : new CombinedContext(minusKey, this.f30191b);
    }

    public f plus(f fVar) {
        h.d(fVar, "context");
        return f.a.a(this, fVar);
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.f30192a)) + "]";
    }
}
