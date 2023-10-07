package j;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {

    /* renamed from: b  reason: collision with root package name */
    static Object[] f13800b;

    /* renamed from: c  reason: collision with root package name */
    static int f13801c;

    /* renamed from: d  reason: collision with root package name */
    static Object[] f13802d;

    /* renamed from: e  reason: collision with root package name */
    static int f13803e;

    /* renamed from: f  reason: collision with root package name */
    int[] f13804f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f13805g;

    /* renamed from: h  reason: collision with root package name */
    int f13806h;

    public g() {
        this.f13804f = c.f29443a;
        this.f13805g = c.f29445c;
        this.f13806h = 0;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f13804f = c.f29443a;
            this.f13805g = c.f29445c;
        } else {
            e(i2);
        }
        this.f13806h = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            a(gVar);
        }
    }

    private static int a(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        Class<g> cls = g.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f13803e < 10) {
                    objArr[0] = f13802d;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f13802d = objArr;
                    f13803e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f13801c < 10) {
                    objArr[0] = f13800b;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f13800b = objArr;
                    f13801c++;
                }
            }
        }
    }

    private void e(int i2) {
        Class<g> cls = g.class;
        if (i2 == 8) {
            synchronized (cls) {
                Object[] objArr = f13802d;
                if (objArr != null) {
                    this.f13805g = objArr;
                    f13802d = (Object[]) objArr[0];
                    this.f13804f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f13803e--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (cls) {
                Object[] objArr2 = f13800b;
                if (objArr2 != null) {
                    this.f13805g = objArr2;
                    f13800b = (Object[]) objArr2[0];
                    this.f13804f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f13801c--;
                    return;
                }
            }
        }
        this.f13804f = new int[i2];
        this.f13805g = new Object[(i2 << 1)];
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int i2 = this.f13806h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f13804f, i2, 0);
        if (a2 < 0 || this.f13805g[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f13804f[i3] == 0) {
            if (this.f13805g[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f13804f[i4] == 0) {
            if (this.f13805g[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int a(Object obj, int i2) {
        int i3 = this.f13806h;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f13804f, i3, i2);
        if (a2 < 0 || obj.equals(this.f13805g[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f13804f[i4] == i2) {
            if (obj.equals(this.f13805g[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f13804f[i5] == i2) {
            if (obj.equals(this.f13805g[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    public V a(int i2, V v2) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f13805g;
        V v3 = vArr[i3];
        vArr[i3] = v2;
        return v3;
    }

    public void a(int i2) {
        int i3 = this.f13806h;
        int[] iArr = this.f13804f;
        if (iArr.length < i2) {
            Object[] objArr = this.f13805g;
            e(i2);
            if (this.f13806h > 0) {
                System.arraycopy(iArr, 0, this.f13804f, 0, i3);
                System.arraycopy(objArr, 0, this.f13805g, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f13806h != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void a(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.f13806h;
        a(this.f13806h + i2);
        if (this.f13806h != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.b(i3), gVar.c(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f13804f, 0, this.f13804f, 0, i2);
            System.arraycopy(gVar.f13805g, 0, this.f13805g, 0, i2 << 1);
            this.f13806h = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int b(Object obj) {
        int i2 = this.f13806h * 2;
        Object[] objArr = this.f13805g;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public K b(int i2) {
        return this.f13805g[i2 << 1];
    }

    public V c(int i2) {
        return this.f13805g[(i2 << 1) + 1];
    }

    public void clear() {
        int i2 = this.f13806h;
        if (i2 > 0) {
            int[] iArr = this.f13804f;
            Object[] objArr = this.f13805g;
            this.f13804f = c.f29443a;
            this.f13805g = c.f29445c;
            this.f13806h = 0;
            a(iArr, objArr, i2);
        }
        if (this.f13806h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        V[] vArr = this.f13805g;
        int i3 = i2 << 1;
        V v2 = vArr[i3 + 1];
        int i4 = this.f13806h;
        int i5 = 0;
        if (i4 <= 1) {
            a(this.f13804f, (Object[]) vArr, i4);
            this.f13804f = c.f29443a;
            this.f13805g = c.f29445c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f13804f;
            int i7 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i8 = i2 + 1;
                    int i9 = i6 - i2;
                    System.arraycopy(iArr, i8, iArr, i2, i9);
                    Object[] objArr = this.f13805g;
                    System.arraycopy(objArr, i8 << 1, objArr, i3, i9 << 1);
                }
                Object[] objArr2 = this.f13805g;
                int i10 = i6 << 1;
                objArr2[i10] = null;
                objArr2[i10 + 1] = null;
            } else {
                if (i4 > 8) {
                    i7 = i4 + (i4 >> 1);
                }
                e(i7);
                if (i4 == this.f13806h) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.f13804f, 0, i2);
                        System.arraycopy(vArr, 0, this.f13805g, 0, i3);
                    }
                    if (i2 < i6) {
                        int i11 = i2 + 1;
                        int i12 = i6 - i2;
                        System.arraycopy(iArr, i11, this.f13804f, i2, i12);
                        System.arraycopy(vArr, i11 << 1, this.f13805g, i3, i12 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i5 = i6;
        }
        if (i4 == this.f13806h) {
            this.f13806h = i5;
            return v2;
        }
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f13806h) {
                try {
                    Object b2 = b(i2);
                    Object c2 = c(i2);
                    Object obj2 = gVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.f13806h) {
                try {
                    Object b3 = b(i3);
                    Object c3 = c(i3);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
                        return false;
                    }
                    i3++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v2) {
        int a2 = a(obj);
        return a2 >= 0 ? this.f13805g[(a2 << 1) + 1] : v2;
    }

    public int hashCode() {
        int[] iArr = this.f13804f;
        Object[] objArr = this.f13805g;
        int i2 = this.f13806h;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public boolean isEmpty() {
        return this.f13806h <= 0;
    }

    public V put(K k2, V v2) {
        int i2;
        int i3;
        int i4 = this.f13806h;
        if (k2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = a((Object) k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.f13805g;
            V v3 = vArr[i5];
            vArr[i5] = v2;
            return v3;
        }
        int i6 = i3 ^ -1;
        int[] iArr = this.f13804f;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr = this.f13805g;
            e(i7);
            if (i4 == this.f13806h) {
                int[] iArr2 = this.f13804f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f13805g, 0, objArr.length);
                }
                a(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f13804f;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.f13805g;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.f13806h - i6) << 1);
        }
        int i9 = this.f13806h;
        if (i4 == i9) {
            int[] iArr4 = this.f13804f;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.f13805g;
                int i10 = i6 << 1;
                objArr3[i10] = k2;
                objArr3[i10 + 1] = v2;
                this.f13806h = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v2) {
        V v3 = get(k2);
        return v3 == null ? put(k2, v2) : v3;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        Object c2 = c(a2);
        if (obj2 != c2 && (obj2 == null || !obj2.equals(c2))) {
            return false;
        }
        d(a2);
        return true;
    }

    public V replace(K k2, V v2) {
        int a2 = a((Object) k2);
        if (a2 >= 0) {
            return a(a2, v2);
        }
        return null;
    }

    public boolean replace(K k2, V v2, V v3) {
        int a2 = a((Object) k2);
        if (a2 < 0) {
            return false;
        }
        V c2 = c(a2);
        if (c2 != v2 && (v2 == null || !v2.equals(c2))) {
            return false;
        }
        a(a2, v3);
        return true;
    }

    public int size() {
        return this.f13806h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13806h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f13806h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
