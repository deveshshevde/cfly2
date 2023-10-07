package or;

import ok.b;
import ok.i;

public abstract class b {
    public <T> Throwable a(Throwable th) {
        return th;
    }

    public <T> b.a<T> a(b.a<T> aVar) {
        return aVar;
    }

    public <T> b.a<T> a(ok.b<? extends T> bVar, b.a<T> aVar) {
        return aVar;
    }

    public <T, R> b.C0235b<? extends R, ? super T> a(b.C0235b<? extends R, ? super T> bVar) {
        return bVar;
    }

    public <T> i a(i iVar) {
        return iVar;
    }
}
