package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.h;

class n extends m {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        h.d(list, "$this$sortWith");
        h.d(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
