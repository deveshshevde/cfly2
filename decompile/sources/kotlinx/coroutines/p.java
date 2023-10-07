package kotlinx.coroutines;

import kotlin.l;

public final class p extends bh<bm> implements o {

    /* renamed from: a  reason: collision with root package name */
    public final q f30446a;

    public p(bm bmVar, q qVar) {
        super(bmVar);
        this.f30446a = qVar;
    }

    public void a(Throwable th) {
        this.f30446a.a((bt) this.f30346b);
    }

    public boolean b(Throwable th) {
        return ((bm) this.f30346b).c(th);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }
}
