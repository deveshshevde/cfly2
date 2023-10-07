package j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f<K, V> {

    /* renamed from: b  reason: collision with root package name */
    f<K, V>.b f29451b;

    /* renamed from: c  reason: collision with root package name */
    f<K, V>.c f29452c;

    /* renamed from: d  reason: collision with root package name */
    f<K, V>.e f29453d;

    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f29454a;

        /* renamed from: b  reason: collision with root package name */
        int f29455b;

        /* renamed from: c  reason: collision with root package name */
        int f29456c;

        /* renamed from: d  reason: collision with root package name */
        boolean f29457d = false;

        a(int i2) {
            this.f29454a = i2;
            this.f29455b = f.this.a();
        }

        public boolean hasNext() {
            return this.f29456c < this.f29455b;
        }

        public T next() {
            if (hasNext()) {
                T a2 = f.this.a(this.f29456c, this.f29454a);
                this.f29456c++;
                this.f29457d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f29457d) {
                int i2 = this.f29456c - 1;
                this.f29456c = i2;
                this.f29455b--;
                this.f29457d = false;
                f.this.a(i2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = f.this.a();
            for (Map.Entry entry : collection) {
                f.this.a(entry.getKey(), entry.getValue());
            }
            return a2 != f.this.a();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = f.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return c.a(f.this.a(a2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public int hashCode() {
            int i2 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                Object a4 = f.this.a(a2, 1);
                i2 += (a3 == null ? 0 : a3.hashCode()) ^ (a4 == null ? 0 : a4.hashCode());
            }
            return i2;
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            return f.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return f.a(f.this.b(), collection);
        }

        public boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public int hashCode() {
            int i2 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                i2 += a3 == null ? 0 : a3.hashCode();
            }
            return i2;
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a2 = f.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            f.this.a(a2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return f.b(f.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return f.c(f.this.b(), collection);
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            return f.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f29461a;

        /* renamed from: b  reason: collision with root package name */
        int f29462b;

        /* renamed from: c  reason: collision with root package name */
        boolean f29463c = false;

        d() {
            this.f29461a = f.this.a() - 1;
            this.f29462b = -1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f29462b++;
                this.f29463c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f29463c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return c.a(entry.getKey(), f.this.a(this.f29462b, 0)) && c.a(entry.getValue(), f.this.a(this.f29462b, 1));
            }
        }

        public K getKey() {
            if (this.f29463c) {
                return f.this.a(this.f29462b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f29463c) {
                return f.this.a(this.f29462b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f29462b < this.f29461a;
        }

        public int hashCode() {
            if (this.f29463c) {
                int i2 = 0;
                Object a2 = f.this.a(this.f29462b, 0);
                Object a3 = f.this.a(this.f29462b, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 != null) {
                    i2 = a3.hashCode();
                }
                return hashCode ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f29463c) {
                f.this.a(this.f29462b);
                this.f29462b--;
                this.f29461a--;
                this.f29463c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v2) {
            if (this.f29463c) {
                return f.this.a(this.f29462b, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            return f.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b2 = f.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            f.this.a(b2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < a2) {
                if (collection.contains(f.this.a(i2, 1))) {
                    f.this.a(i2);
                    i2--;
                    a2--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        public boolean retainAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < a2) {
                if (!collection.contains(f.this.a(i2, 1))) {
                    f.this.a(i2);
                    i2--;
                    a2--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            return f.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 1);
        }
    }

    f() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object a(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract V a(int i2, V v2);

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    /* access modifiers changed from: protected */
    public abstract void a(K k2, V v2);

    public <T> T[] a(T[] tArr, int i2) {
        int a2 = a();
        if (tArr.length < a2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2);
        }
        for (int i3 = 0; i3 < a2; i3++) {
            tArr[i3] = a(i3, i2);
        }
        if (tArr.length > a2) {
            tArr[a2] = null;
        }
        return tArr;
    }

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> b();

    public Object[] b(int i2) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            objArr[i3] = a(i3, i2);
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.f29451b == null) {
            this.f29451b = new b();
        }
        return this.f29451b;
    }

    public Set<K> e() {
        if (this.f29452c == null) {
            this.f29452c = new c();
        }
        return this.f29452c;
    }

    public Collection<V> f() {
        if (this.f29453d == null) {
            this.f29453d = new e();
        }
        return this.f29453d;
    }
}
