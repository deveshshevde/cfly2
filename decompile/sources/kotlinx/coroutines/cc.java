package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.l;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.t;

final class cc<T> extends t<T> {
    public cc(f fVar, c<? super T> cVar) {
        super(fVar, cVar);
    }

    /* access modifiers changed from: protected */
    public void c(Object obj) {
        Object a2 = x.a(obj, this.f30435c);
        f context = this.f30435c.getContext();
        Object a3 = aa.a(context, (Object) null);
        try {
            this.f30435c.resumeWith(a2);
            l lVar = l.f30254a;
        } finally {
            aa.b(context, a3);
        }
    }
}
