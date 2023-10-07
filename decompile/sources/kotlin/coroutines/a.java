package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import mm.m;

public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> cVar) {
        h.d(cVar, "key");
        this.key = cVar;
    }

    public <R> R fold(R r2, m<? super R, ? super f.b, ? extends R> mVar) {
        h.d(mVar, "operation");
        return f.b.a.a(this, r2, mVar);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        h.d(cVar, "key");
        return f.b.a.a((f.b) this, cVar);
    }

    public f.c<?> getKey() {
        return this.key;
    }

    public f minusKey(f.c<?> cVar) {
        h.d(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    public f plus(f fVar) {
        h.d(fVar, "context");
        return f.b.a.a((f.b) this, fVar);
    }
}
