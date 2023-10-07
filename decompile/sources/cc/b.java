package cc;

import j.a;
import j.g;

public final class b<K, V> extends a<K, V> {

    /* renamed from: i  reason: collision with root package name */
    private int f6173i;

    public V a(int i2, V v2) {
        this.f6173i = 0;
        return super.a(i2, v2);
    }

    public void a(g<? extends K, ? extends V> gVar) {
        this.f6173i = 0;
        super.a(gVar);
    }

    public void clear() {
        this.f6173i = 0;
        super.clear();
    }

    public V d(int i2) {
        this.f6173i = 0;
        return super.d(i2);
    }

    public int hashCode() {
        if (this.f6173i == 0) {
            this.f6173i = super.hashCode();
        }
        return this.f6173i;
    }

    public V put(K k2, V v2) {
        this.f6173i = 0;
        return super.put(k2, v2);
    }
}
