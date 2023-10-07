package kv;

import java.util.HashMap;
import java.util.Set;

public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<K, V> f30581a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<V, K> f30582b = new HashMap<>();

    public Set<K> a() {
        return this.f30581a.keySet();
    }

    public void a(K k2) {
        V v2 = this.f30581a.get(k2);
        if (v2 != null) {
            this.f30581a.remove(k2);
            this.f30582b.remove(v2);
        }
    }

    public void a(K k2, V v2) {
        this.f30581a.put(k2, v2);
        this.f30582b.put(v2, k2);
    }

    public V b(K k2) {
        return this.f30581a.get(k2);
    }

    public K c(V v2) {
        return this.f30582b.get(v2);
    }
}
