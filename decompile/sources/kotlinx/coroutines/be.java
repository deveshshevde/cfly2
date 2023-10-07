package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;
import mm.b;

final class be extends bh<bg> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30340a = AtomicIntegerFieldUpdater.newUpdater(be.class, "_invoked");
    private volatile int _invoked = 0;

    /* renamed from: e  reason: collision with root package name */
    private final b<Throwable, l> f30341e;

    public be(bg bgVar, b<? super Throwable, l> bVar) {
        super(bgVar);
        this.f30341e = bVar;
    }

    public void a(Throwable th) {
        if (f30340a.compareAndSet(this, 0, 1)) {
            this.f30341e.invoke(th);
        }
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }
}
