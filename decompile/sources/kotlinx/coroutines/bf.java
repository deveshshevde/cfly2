package kotlinx.coroutines;

import kotlin.l;
import mm.b;

final class bf extends bl<bg> {

    /* renamed from: a  reason: collision with root package name */
    private final b<Throwable, l> f30342a;

    public bf(bg bgVar, b<? super Throwable, l> bVar) {
        super(bgVar);
        this.f30342a = bVar;
    }

    public void a(Throwable th) {
        this.f30342a.invoke(th);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }
}
