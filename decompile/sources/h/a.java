package h;

import h.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f13285b = new HashMap<>();

    /* access modifiers changed from: protected */
    public b.c<K, V> a(K k2) {
        return this.f13285b.get(k2);
    }

    public V a(K k2, V v2) {
        b.c a2 = a(k2);
        if (a2 != null) {
            return a2.f13291b;
        }
        this.f13285b.put(k2, b(k2, v2));
        return null;
    }

    public V b(K k2) {
        V b2 = super.b(k2);
        this.f13285b.remove(k2);
        return b2;
    }

    public boolean c(K k2) {
        return this.f13285b.containsKey(k2);
    }

    public Map.Entry<K, V> d(K k2) {
        if (c(k2)) {
            return this.f13285b.get(k2).f13293d;
        }
        return null;
    }
}
