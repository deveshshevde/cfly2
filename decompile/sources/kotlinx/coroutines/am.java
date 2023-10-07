package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.internal.t;
import mm.b;

public final class am<T> extends t<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30304d = AtomicIntegerFieldUpdater.newUpdater(am.class, "_decision");
    private volatile int _decision = 0;

    public am(f fVar, c<? super T> cVar) {
        super(fVar, cVar);
    }

    private final boolean q() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f30304d.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean r() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f30304d.compareAndSet(this, 0, 2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(Object obj) {
        if (!r()) {
            c cVar = this.f30435c;
            kotlinx.coroutines.internal.f.a(a.a(cVar), x.a(obj, this.f30435c), (b) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void d(Object obj) {
        c(obj);
    }

    public final Object h() {
        if (q()) {
            return a.a();
        }
        Object b2 = bn.b(l());
        if (!(b2 instanceof u)) {
            return b2;
        }
        throw ((u) b2).f30513a;
    }
}
