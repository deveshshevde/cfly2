package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.h;

class k extends j {
    public static final <T> int a(Iterable<? extends T> iterable, int i2) {
        h.d(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
