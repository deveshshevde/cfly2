package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.au;

public abstract class av extends at {
    /* access modifiers changed from: protected */
    public abstract Thread a();

    /* access modifiers changed from: protected */
    public final void b(long j2, au.b bVar) {
        if (ag.a()) {
            if (!(this != ai.f30301b)) {
                throw new AssertionError();
            }
        }
        ai.f30301b.a(j2, bVar);
    }

    /* access modifiers changed from: protected */
    public final void j() {
        Thread a2 = a();
        if (Thread.currentThread() != a2) {
            bz a3 = ca.a();
            if (a3 != null) {
                a3.a(a2);
            } else {
                LockSupport.unpark(a2);
            }
        }
    }
}
