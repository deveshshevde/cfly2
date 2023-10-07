package kotlin.collections;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.h;

class w extends v {
    public static final int a(int i2) {
        return i2 < 0 ? i2 : i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((((float) i2) / 0.75f) + 1.0f) : SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> map) {
        h.d(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        h.b(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> a(Pair<? extends K, ? extends V> pair) {
        h.d(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.a(), pair.b());
        h.b(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }
}
