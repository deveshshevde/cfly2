package j;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    f<K, V> f29440a;

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> b() {
        if (this.f29440a == null) {
            this.f29440a = new f<K, V>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return a.this.f13806h;
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return a.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Object a(int i2, int i3) {
                    return a.this.f13805g[(i2 << 1) + i3];
                }

                /* access modifiers changed from: protected */
                public V a(int i2, V v2) {
                    return a.this.a(i2, v2);
                }

                /* access modifiers changed from: protected */
                public void a(int i2) {
                    a.this.d(i2);
                }

                /* access modifiers changed from: protected */
                public void a(K k2, V v2) {
                    a.this.put(k2, v2);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return a.this.b(obj);
                }

                /* access modifiers changed from: protected */
                public Map<K, V> b() {
                    return a.this;
                }

                /* access modifiers changed from: protected */
                public void c() {
                    a.this.clear();
                }
            };
        }
        return this.f29440a;
    }

    public boolean a(Collection<?> collection) {
        return f.c(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.f13806h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }
}
