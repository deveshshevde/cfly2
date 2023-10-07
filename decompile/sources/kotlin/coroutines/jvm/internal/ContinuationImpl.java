package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;

public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final f _context;
    private transient c<Object> intercepted;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }

    public ContinuationImpl(c<Object> cVar, f fVar) {
        super(cVar);
        this._context = fVar;
    }

    public f getContext() {
        f fVar = this._context;
        h.a((Object) fVar);
        return fVar;
    }

    public final c<Object> intercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar == null) {
            d dVar = (d) getContext().get(d.f30197a);
            if (dVar == null || (cVar = dVar.a(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        c<Object> cVar = this.intercepted;
        if (!(cVar == null || cVar == this)) {
            f.b bVar = getContext().get(d.f30197a);
            h.a((Object) bVar);
            ((d) bVar).b(cVar);
        }
        this.intercepted = b.f30213a;
    }
}
