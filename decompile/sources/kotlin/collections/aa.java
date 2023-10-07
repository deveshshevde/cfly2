package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.h;

class aa {
    public static final <T> Set<T> a(T t2) {
        Set<T> singleton = Collections.singleton(t2);
        h.b(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
