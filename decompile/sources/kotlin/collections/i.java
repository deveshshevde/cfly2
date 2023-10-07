package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.h;

class i {
    public static final <T> List<T> a(T t2) {
        List<T> singletonList = Collections.singletonList(t2);
        h.b(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z2) {
        h.d(tArr, "$this$copyToArrayOfAny");
        if (!z2 || !h.a((Object) tArr.getClass(), (Object) Object[].class)) {
            tArr = Arrays.copyOf(tArr, tArr.length, Object[].class);
        }
        h.b(tArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return tArr;
    }
}
