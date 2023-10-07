package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ag;

public abstract class c<T> extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30397a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile Object _consensus = b.f30395a;

    public long a() {
        return 0;
    }

    public abstract Object a(T t2);

    public abstract void a(T t2, Object obj);

    public final Object b(Object obj) {
        if (ag.a()) {
            if (!(obj != b.f30395a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        return obj2 != b.f30395a ? obj2 : f30397a.compareAndSet(this, b.f30395a, obj) ? obj : this._consensus;
    }

    public c<?> b() {
        return this;
    }

    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == b.f30395a) {
            obj2 = b(a(obj));
        }
        a(obj, obj2);
        return obj2;
    }
}
