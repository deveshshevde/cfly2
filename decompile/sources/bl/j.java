package bl;

import android.util.Log;
import cc.k;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f5761a;

    /* renamed from: b  reason: collision with root package name */
    private final b f5762b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f5763c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f5764d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5765e;

    /* renamed from: f  reason: collision with root package name */
    private int f5766f;

    private static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f5767a;

        /* renamed from: b  reason: collision with root package name */
        private final b f5768b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f5769c;

        a(b bVar) {
            this.f5768b = bVar;
        }

        public void a() {
            this.f5768b.a(this);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, Class<?> cls) {
            this.f5767a = i2;
            this.f5769c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5767a == aVar.f5767a && this.f5769c == aVar.f5769c;
        }

        public int hashCode() {
            int i2 = this.f5767a * 31;
            Class<?> cls = this.f5769c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f5767a + "array=" + this.f5769c + '}';
        }
    }

    private static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a a(int i2, Class<?> cls) {
            a aVar = (a) c();
            aVar.a(i2, cls);
            return aVar;
        }
    }

    public j() {
        this.f5761a = new h<>();
        this.f5762b = new b();
        this.f5763c = new HashMap();
        this.f5764d = new HashMap();
        this.f5765e = 4194304;
    }

    public j(int i2) {
        this.f5761a = new h<>();
        this.f5762b = new b();
        this.f5763c = new HashMap();
        this.f5764d = new HashMap();
        this.f5765e = i2;
    }

    private <T> T a(a aVar) {
        return this.f5761a.a(aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        a<T> b2 = b(cls);
        T a2 = a(aVar);
        if (a2 != null) {
            this.f5766f -= b2.a(a2) * b2.b();
            c(b2.a(a2), cls);
        }
        if (a2 != null) {
            return a2;
        }
        if (Log.isLoggable(b2.a(), 2)) {
            Log.v(b2.a(), "Allocated " + aVar.f5767a + " bytes");
        }
        return b2.a(aVar.f5767a);
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f5763c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5763c.put(cls, treeMap);
        return treeMap;
    }

    private boolean a(int i2, Integer num) {
        return num != null && (b() || num.intValue() <= i2 * 8);
    }

    private <T> a<T> b(Class<T> cls) {
        a<T> aVar = this.f5764d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f5764d.put(cls, aVar);
        }
        return aVar;
    }

    private <T> a<T> b(T t2) {
        return b(t2.getClass());
    }

    private boolean b() {
        int i2 = this.f5766f;
        return i2 == 0 || this.f5765e / i2 >= 2;
    }

    private boolean b(int i2) {
        return i2 <= this.f5765e / 2;
    }

    private void c() {
        c(this.f5765e);
    }

    private void c(int i2) {
        while (this.f5766f > i2) {
            Object a2 = this.f5761a.a();
            k.a(a2);
            a b2 = b(a2);
            this.f5766f -= b2.a(a2) * b2.b();
            c(b2.a(a2), a2.getClass());
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "evicted: " + b2.a(a2));
            }
        }
    }

    private void c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = (Integer) a2.get(Integer.valueOf(i2));
        if (num != null) {
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i2);
            if (intValue == 1) {
                a2.remove(valueOf);
            } else {
                a2.put(valueOf, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        }
    }

    public synchronized <T> T a(int i2, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return a(a(i2, ceilingKey) ? this.f5762b.a(ceilingKey.intValue(), cls) : this.f5762b.a(i2, cls), cls);
    }

    public synchronized void a() {
        c(0);
    }

    public synchronized void a(int i2) {
        if (i2 >= 40) {
            try {
                a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 >= 20 || i2 == 15) {
            c(this.f5765e / 2);
        }
    }

    public synchronized <T> void a(T t2) {
        Class<?> cls = t2.getClass();
        a<?> b2 = b(cls);
        int a2 = b2.a(t2);
        int b3 = b2.b() * a2;
        if (b(b3)) {
            a a3 = this.f5762b.a(a2, cls);
            this.f5761a.a(a3, t2);
            NavigableMap<Integer, Integer> a4 = a(cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f5767a));
            Integer valueOf = Integer.valueOf(a3.f5767a);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            a4.put(valueOf, Integer.valueOf(i2));
            this.f5766f += b3;
            c();
        }
    }

    public synchronized <T> T b(int i2, Class<T> cls) {
        return a(this.f5762b.a(i2, cls), cls);
    }
}
