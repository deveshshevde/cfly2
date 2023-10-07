package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class m<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f30418a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_cur");
    private volatile Object _cur;

    public m(boolean z2) {
        this._cur = new n(8, z2);
    }

    public final int a() {
        return ((n) this._cur).b();
    }

    public final boolean a(E e2) {
        while (true) {
            n nVar = (n) this._cur;
            int a2 = nVar.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                f30418a.compareAndSet(this, nVar, nVar.e());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            n nVar = (n) this._cur;
            if (!nVar.c()) {
                f30418a.compareAndSet(this, nVar, nVar.e());
            } else {
                return;
            }
        }
    }

    public final E c() {
        while (true) {
            n nVar = (n) this._cur;
            E d2 = nVar.d();
            if (d2 != n.f30419a) {
                return d2;
            }
            f30418a.compareAndSet(this, nVar, nVar.e());
        }
    }
}
