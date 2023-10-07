package mt;

import java.util.Iterator;
import kotlin.jvm.internal.h;

class f extends e {

    public static final class a implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f31287a;

        public a(Iterator it2) {
            this.f31287a = it2;
        }

        public Iterator<T> a() {
            return this.f31287a;
        }
    }

    public static final <T> b<T> a(Iterator<? extends T> it2) {
        h.d(it2, "$this$asSequence");
        return c.a(new a(it2));
    }

    public static final <T> b<T> a(b<? extends T> bVar) {
        h.d(bVar, "$this$constrainOnce");
        return bVar instanceof a ? (a) bVar : new a(bVar);
    }
}
