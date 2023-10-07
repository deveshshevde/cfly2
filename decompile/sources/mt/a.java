package mt;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.h;

public final class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b<T>> f31286a;

    public a(b<? extends T> bVar) {
        h.d(bVar, "sequence");
        this.f31286a = new AtomicReference<>(bVar);
    }

    public Iterator<T> a() {
        b andSet = this.f31286a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.a();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
