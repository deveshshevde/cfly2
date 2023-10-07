package kotlinx.coroutines;

import kotlin.l;
import mm.b;

final class bd extends h {

    /* renamed from: a  reason: collision with root package name */
    private final b<Throwable, l> f30339a;

    public bd(b<? super Throwable, l> bVar) {
        this.f30339a = bVar;
    }

    public void a(Throwable th) {
        this.f30339a.invoke(th);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }

    public String toString() {
        return "InvokeOnCancel[" + ah.b(this.f30339a) + '@' + ah.a((Object) this) + ']';
    }
}
