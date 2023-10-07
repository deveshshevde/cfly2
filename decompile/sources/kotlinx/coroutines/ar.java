package kotlinx.coroutines;

import kotlin.l;

final class ar extends h {

    /* renamed from: a  reason: collision with root package name */
    private final aq f30319a;

    public ar(aq aqVar) {
        this.f30319a = aqVar;
    }

    public void a(Throwable th) {
        this.f30319a.a();
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f30319a + ']';
    }
}
