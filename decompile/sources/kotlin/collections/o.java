package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.h;

class o extends n {
    public static final <T> boolean a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        h.d(collection, "$this$addAll");
        h.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z2 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z2 = true;
            }
        }
        return z2;
    }
}
