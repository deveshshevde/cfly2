package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import mm.m;

public final class EmptyCoroutineContext implements Serializable, f {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyCoroutineContext f30194a = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    public <R> R fold(R r2, m<? super R, ? super f.b, ? extends R> mVar) {
        h.d(mVar, "operation");
        return r2;
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        h.d(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public f minusKey(f.c<?> cVar) {
        h.d(cVar, "key");
        return this;
    }

    public f plus(f fVar) {
        h.d(fVar, "context");
        return fVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
