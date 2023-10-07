package h;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f13286a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f13287b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f13288c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f13289d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.f13292c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f13293d;
        }
    }

    /* renamed from: h.b$b  reason: collision with other inner class name */
    private static class C0092b<K, V> extends e<K, V> {
        C0092b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.f13293d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f13292c;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f13290a;

        /* renamed from: b  reason: collision with root package name */
        final V f13291b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f13292c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f13293d;

        c(K k2, V v2) {
            this.f13290a = k2;
            this.f13291b = v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f13290a.equals(cVar.f13290a) && this.f13291b.equals(cVar.f13291b);
        }

        public K getKey() {
            return this.f13290a;
        }

        public V getValue() {
            return this.f13291b;
        }

        public int hashCode() {
            return this.f13290a.hashCode() ^ this.f13291b.hashCode();
        }

        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f13290a + "=" + this.f13291b;
        }
    }

    private class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f13295b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13296c = true;

        d() {
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f13296c) {
                this.f13296c = false;
                cVar = b.this.f13286a;
            } else {
                c<K, V> cVar2 = this.f13295b;
                cVar = cVar2 != null ? cVar2.f13292c : null;
            }
            this.f13295b = cVar;
            return this.f13295b;
        }

        public void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.f13295b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f13293d;
                this.f13295b = cVar3;
                this.f13296c = cVar3 == null;
            }
        }

        public boolean hasNext() {
            if (this.f13296c) {
                return b.this.f13286a != null;
            }
            c<K, V> cVar = this.f13295b;
            return (cVar == null || cVar.f13292c == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f13297a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f13298b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f13297a = cVar2;
            this.f13298b = cVar;
        }

        private c<K, V> b() {
            c<K, V> cVar = this.f13298b;
            c<K, V> cVar2 = this.f13297a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f13298b;
            this.f13298b = b();
            return cVar;
        }

        public void a_(c<K, V> cVar) {
            if (this.f13297a == cVar && cVar == this.f13298b) {
                this.f13298b = null;
                this.f13297a = null;
            }
            c<K, V> cVar2 = this.f13297a;
            if (cVar2 == cVar) {
                this.f13297a = b(cVar2);
            }
            if (this.f13298b == cVar) {
                this.f13298b = b();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        public boolean hasNext() {
            return this.f13298b != null;
        }
    }

    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    public int a() {
        return this.f13289d;
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k2) {
        c<K, V> cVar = this.f13286a;
        while (cVar != null && !cVar.f13290a.equals(k2)) {
            cVar = cVar.f13292c;
        }
        return cVar;
    }

    public V a(K k2, V v2) {
        c a2 = a(k2);
        if (a2 != null) {
            return a2.f13291b;
        }
        b(k2, v2);
        return null;
    }

    /* access modifiers changed from: protected */
    public c<K, V> b(K k2, V v2) {
        c<K, V> cVar = new c<>(k2, v2);
        this.f13289d++;
        c<K, V> cVar2 = this.f13287b;
        if (cVar2 == null) {
            this.f13286a = cVar;
        } else {
            cVar2.f13292c = cVar;
            cVar.f13293d = this.f13287b;
        }
        this.f13287b = cVar;
        return cVar;
    }

    public V b(K k2) {
        c a2 = a(k2);
        if (a2 == null) {
            return null;
        }
        this.f13289d--;
        if (!this.f13288c.isEmpty()) {
            for (f<K, V> a_ : this.f13288c.keySet()) {
                a_.a_(a2);
            }
        }
        if (a2.f13293d != null) {
            a2.f13293d.f13292c = a2.f13292c;
        } else {
            this.f13286a = a2.f13292c;
        }
        if (a2.f13292c != null) {
            a2.f13292c.f13293d = a2.f13293d;
        } else {
            this.f13287b = a2.f13293d;
        }
        a2.f13292c = null;
        a2.f13293d = null;
        return a2.f13291b;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0092b bVar = new C0092b(this.f13287b, this.f13286a);
        this.f13288c.put(bVar, false);
        return bVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f13288c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f13286a;
    }

    public Map.Entry<K, V> e() {
        return this.f13287b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = bVar.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it2.hasNext() && !it3.hasNext();
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += ((Map.Entry) it2.next()).hashCode();
        }
        return i2;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f13286a, this.f13287b);
        this.f13288c.put(aVar, false);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
