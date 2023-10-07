package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.h;

class x extends w {
    public static final <K, V> Map<K, V> a() {
        EmptyMap emptyMap = EmptyMap.f30185a;
        Objects.requireNonNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return emptyMap;
    }

    public static final <K, V> Map<K, V> a(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        h.d(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return u.b(u.a(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return u.a();
        }
        if (size != 1) {
            return u.a(iterable, new LinkedHashMap(u.a(collection.size())));
        }
        return u.a((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m2) {
        h.d(iterable, "$this$toMap");
        h.d(m2, "destination");
        u.a(m2, iterable);
        return m2;
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V>... pairArr) {
        h.d(pairArr, "pairs");
        return pairArr.length > 0 ? u.a(pairArr, new LinkedHashMap(u.a(pairArr.length))) : u.a();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Pair<? extends K, ? extends V>[] pairArr, M m2) {
        h.d(pairArr, "$this$toMap");
        h.d(m2, "destination");
        u.a(m2, pairArr);
        return m2;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        h.d(map, "$this$putAll");
        h.d(iterable, "pairs");
        for (Pair pair : iterable) {
            map.put(pair.c(), pair.d());
        }
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        h.d(map, "$this$putAll");
        h.d(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.c(), pair.d());
        }
    }

    public static final <K, V> Map<K, V> b(Map<K, ? extends V> map) {
        h.d(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        return size != 0 ? size != 1 ? map : u.a(map) : u.a();
    }
}
