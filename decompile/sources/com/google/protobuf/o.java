package com.google.protobuf;

import com.google.protobuf.g;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class o<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f20150a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<o<K, V>.b> f20151b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<K, V> f20152c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20153d;

    /* renamed from: e  reason: collision with root package name */
    private volatile o<K, V>.d f20154e;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f20155a = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f20156b = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return a.f20155a;
            }
        };

        static <T> Iterable<T> a() {
            return f20156b;
        }
    }

    private class b implements Comparable<o<K, V>.b>, Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private final K f20158b;

        /* renamed from: c  reason: collision with root package name */
        private V f20159c;

        b(K k2, V v2) {
            this.f20158b = k2;
            this.f20159c = v2;
        }

        b(o oVar, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean a(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(o<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        /* renamed from: a */
        public K getKey() {
            return this.f20158b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a(this.f20158b, entry.getKey()) && a(this.f20159c, entry.getValue());
        }

        public V getValue() {
            return this.f20159c;
        }

        public int hashCode() {
            K k2 = this.f20158b;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v2 = this.f20159c;
            if (v2 != null) {
                i2 = v2.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v2) {
            o.this.f();
            V v3 = this.f20159c;
            this.f20159c = v2;
            return v3;
        }

        public String toString() {
            return this.f20158b + "=" + this.f20159c;
        }
    }

    private class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private int f20161b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20162c;

        /* renamed from: d  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f20163d;

        private c() {
            this.f20161b = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f20163d == null) {
                this.f20163d = o.this.f20152c.entrySet().iterator();
            }
            return this.f20163d;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            this.f20162c = true;
            int i2 = this.f20161b + 1;
            this.f20161b = i2;
            return (Map.Entry) (i2 < o.this.f20151b.size() ? o.this.f20151b.get(this.f20161b) : b().next());
        }

        public boolean hasNext() {
            return this.f20161b + 1 < o.this.f20151b.size() || b().hasNext();
        }

        public void remove() {
            if (this.f20162c) {
                this.f20162c = false;
                o.this.f();
                if (this.f20161b < o.this.f20151b.size()) {
                    o oVar = o.this;
                    int i2 = this.f20161b;
                    this.f20161b = i2 - 1;
                    Object unused = oVar.c(i2);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            o.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            o.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = o.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            o.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return o.this.size();
        }
    }

    private o(int i2) {
        this.f20150a = i2;
        this.f20151b = Collections.emptyList();
        this.f20152c = Collections.emptyMap();
    }

    private int a(K k2) {
        int size = this.f20151b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.f20151b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.f20151b.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    static <FieldDescriptorType extends g.a<FieldDescriptorType>> o<FieldDescriptorType, Object> a(int i2) {
        return new o<FieldDescriptorType, Object>(i2) {
            public void a() {
                if (!b()) {
                    for (int i2 = 0; i2 < c(); i2++) {
                        Map.Entry b2 = b(i2);
                        if (((g.a) b2.getKey()).b()) {
                            b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                        }
                    }
                    for (Map.Entry entry : e()) {
                        if (((g.a) entry.getKey()).b()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                o.super.a();
            }

            public /* synthetic */ Object put(Object obj, Object obj2) {
                return o.super.put((g.a) obj, obj2);
            }
        };
    }

    /* access modifiers changed from: private */
    public V c(int i2) {
        f();
        V value = this.f20151b.remove(i2).getValue();
        if (!this.f20152c.isEmpty()) {
            Iterator it2 = g().entrySet().iterator();
            this.f20151b.add(new b(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f20153d) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> g() {
        f();
        if (this.f20152c.isEmpty() && !(this.f20152c instanceof TreeMap)) {
            this.f20152c = new TreeMap();
        }
        return (SortedMap) this.f20152c;
    }

    private void h() {
        f();
        if (this.f20151b.isEmpty() && !(this.f20151b instanceof ArrayList)) {
            this.f20151b = new ArrayList(this.f20150a);
        }
    }

    /* renamed from: a */
    public V put(K k2, V v2) {
        f();
        int a2 = a(k2);
        if (a2 >= 0) {
            return this.f20151b.get(a2).setValue(v2);
        }
        h();
        int i2 = -(a2 + 1);
        if (i2 >= this.f20150a) {
            return g().put(k2, v2);
        }
        int size = this.f20151b.size();
        int i3 = this.f20150a;
        if (size == i3) {
            b remove = this.f20151b.remove(i3 - 1);
            g().put(remove.getKey(), remove.getValue());
        }
        this.f20151b.add(i2, new b(k2, v2));
        return null;
    }

    public void a() {
        if (!this.f20153d) {
            this.f20152c = this.f20152c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f20152c);
            this.f20153d = true;
        }
    }

    public Map.Entry<K, V> b(int i2) {
        return this.f20151b.get(i2);
    }

    public boolean b() {
        return this.f20153d;
    }

    public int c() {
        return this.f20151b.size();
    }

    public void clear() {
        f();
        if (!this.f20151b.isEmpty()) {
            this.f20151b.clear();
        }
        if (!this.f20152c.isEmpty()) {
            this.f20152c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f20152c.containsKey(comparable);
    }

    public int d() {
        return this.f20152c.size();
    }

    public Iterable<Map.Entry<K, V>> e() {
        return this.f20152c.isEmpty() ? a.a() : this.f20152c.entrySet();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f20154e == null) {
            this.f20154e = new d();
        }
        return this.f20154e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        int size = size();
        if (size != oVar.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != oVar.c()) {
            return entrySet().equals(oVar.entrySet());
        }
        for (int i2 = 0; i2 < c2; i2++) {
            if (!b(i2).equals(oVar.b(i2))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f20152c.equals(oVar.f20152c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? this.f20151b.get(a2).getValue() : this.f20152c.get(comparable);
    }

    public int hashCode() {
        int c2 = c();
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            i2 += this.f20151b.get(i3).hashCode();
        }
        return d() > 0 ? i2 + this.f20152c.hashCode() : i2;
    }

    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f20152c.isEmpty()) {
            return null;
        }
        return this.f20152c.remove(comparable);
    }

    public int size() {
        return this.f20151b.size() + this.f20152c.size();
    }
}
