package mt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class h extends g {

    public static final class a implements Iterable<T>, mn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f31288a;

        public a(b bVar) {
            this.f31288a = bVar;
        }

        public Iterator<T> iterator() {
            return this.f31288a.a();
        }
    }

    public static final <T, C extends Collection<? super T>> C a(b<? extends T> bVar, C c2) {
        kotlin.jvm.internal.h.d(bVar, "$this$toCollection");
        kotlin.jvm.internal.h.d(c2, "destination");
        Iterator<? extends T> a2 = bVar.a();
        while (a2.hasNext()) {
            c2.add(a2.next());
        }
        return c2;
    }

    public static final <T> List<T> b(b<? extends T> bVar) {
        kotlin.jvm.internal.h.d(bVar, "$this$toList");
        return kotlin.collections.h.b(c.c(bVar));
    }

    public static final <T> List<T> c(b<? extends T> bVar) {
        kotlin.jvm.internal.h.d(bVar, "$this$toMutableList");
        return (List) c.a(bVar, new ArrayList());
    }

    public static final <T> Iterable<T> d(b<? extends T> bVar) {
        kotlin.jvm.internal.h.d(bVar, "$this$asIterable");
        return new a(bVar);
    }
}
