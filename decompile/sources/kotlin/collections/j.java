package kotlin.collections;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;

class j extends i {
    public static final <T> int a(List<? extends T> list) {
        h.d(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> Collection<T> a(T[] tArr) {
        h.d(tArr, "$this$asCollection");
        return new a<>(tArr, false);
    }

    public static final <T> List<T> a() {
        return EmptyList.f30184a;
    }

    public static final <T> List<T> b(List<? extends T> list) {
        h.d(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : h.a(list.get(0)) : h.a();
    }

    public static final <T> List<T> b(T... tArr) {
        h.d(tArr, "elements");
        return tArr.length > 0 ? b.a(tArr) : h.a();
    }

    public static final void b() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
