package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.h;

class ab extends aa {
    public static final <T> Set<T> a() {
        return EmptySet.f30186a;
    }

    public static final <T> Set<T> a(Set<? extends T> set) {
        h.d(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        return size != 0 ? size != 1 ? set : z.a(set.iterator().next()) : z.a();
    }
}
