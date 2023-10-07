package j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13790c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f13791d = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    private static Object[] f13792e;

    /* renamed from: f  reason: collision with root package name */
    private static int f13793f;

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f13794g;

    /* renamed from: h  reason: collision with root package name */
    private static int f13795h;

    /* renamed from: a  reason: collision with root package name */
    Object[] f13796a;

    /* renamed from: b  reason: collision with root package name */
    int f13797b;

    /* renamed from: i  reason: collision with root package name */
    private int[] f13798i;

    /* renamed from: j  reason: collision with root package name */
    private f<E, E> f13799j;

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f13798i = f13790c;
            this.f13796a = f13791d;
        } else {
            d(i2);
        }
        this.f13797b = 0;
    }

    private int a() {
        int i2 = this.f13797b;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f13798i, i2, 0);
        if (a2 < 0 || this.f13796a[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f13798i[i3] == 0) {
            if (this.f13796a[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f13798i[i4] == 0) {
            if (this.f13796a[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int a(Object obj, int i2) {
        int i3 = this.f13797b;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f13798i, i3, i2);
        if (a2 < 0 || obj.equals(this.f13796a[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f13798i[i4] == i2) {
            if (obj.equals(this.f13796a[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f13798i[i5] == i2) {
            if (obj.equals(this.f13796a[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        Class<b> cls = b.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f13795h < 10) {
                    objArr[0] = f13794g;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f13794g = objArr;
                    f13795h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f13793f < 10) {
                    objArr[0] = f13792e;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f13792e = objArr;
                    f13793f++;
                }
            }
        }
    }

    private f<E, E> b() {
        if (this.f13799j == null) {
            this.f13799j = new f<E, E>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return b.this.f13797b;
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Object a(int i2, int i3) {
                    return b.this.f13796a[i2];
                }

                /* access modifiers changed from: protected */
                public E a(int i2, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void a(int i2) {
                    b.this.c(i2);
                }

                /* access modifiers changed from: protected */
                public void a(E e2, E e3) {
                    b.this.add(e2);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void c() {
                    b.this.clear();
                }
            };
        }
        return this.f13799j;
    }

    private void d(int i2) {
        Class<b> cls = b.class;
        if (i2 == 8) {
            synchronized (cls) {
                Object[] objArr = f13794g;
                if (objArr != null) {
                    this.f13796a = objArr;
                    f13794g = (Object[]) objArr[0];
                    this.f13798i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f13795h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (cls) {
                Object[] objArr2 = f13792e;
                if (objArr2 != null) {
                    this.f13796a = objArr2;
                    f13792e = (Object[]) objArr2[0];
                    this.f13798i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f13793f--;
                    return;
                }
            }
        }
        this.f13798i = new int[i2];
        this.f13796a = new Object[i2];
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public void a(int i2) {
        int[] iArr = this.f13798i;
        if (iArr.length < i2) {
            Object[] objArr = this.f13796a;
            d(i2);
            int i3 = this.f13797b;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f13798i, 0, i3);
                System.arraycopy(objArr, 0, this.f13796a, 0, this.f13797b);
            }
            a(iArr, objArr, this.f13797b);
        }
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ -1;
        int i5 = this.f13797b;
        int[] iArr = this.f13798i;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f13796a;
            d(i6);
            int[] iArr2 = this.f13798i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f13796a, 0, objArr.length);
            }
            a(iArr, objArr, this.f13797b);
        }
        int i7 = this.f13797b;
        if (i4 < i7) {
            int[] iArr3 = this.f13798i;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f13796a;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f13797b - i4);
        }
        this.f13798i[i4] = i2;
        this.f13796a[i4] = e2;
        this.f13797b++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.f13797b + collection.size());
        boolean z2 = false;
        for (Object add : collection) {
            z2 |= add(add);
        }
        return z2;
    }

    public E b(int i2) {
        return this.f13796a[i2];
    }

    public E c(int i2) {
        E[] eArr = this.f13796a;
        E e2 = eArr[i2];
        int i3 = this.f13797b;
        if (i3 <= 1) {
            a(this.f13798i, eArr, i3);
            this.f13798i = f13790c;
            this.f13796a = f13791d;
            this.f13797b = 0;
        } else {
            int[] iArr = this.f13798i;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.f13797b = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr = this.f13796a;
                    System.arraycopy(objArr, i6, objArr, i2, this.f13797b - i2);
                }
                this.f13796a[this.f13797b] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                d(i4);
                this.f13797b--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f13798i, 0, i2);
                    System.arraycopy(eArr, 0, this.f13796a, 0, i2);
                }
                int i7 = this.f13797b;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.f13798i, i2, i7 - i2);
                    System.arraycopy(eArr, i8, this.f13796a, i2, this.f13797b - i2);
                }
            }
        }
        return e2;
    }

    public void clear() {
        int i2 = this.f13797b;
        if (i2 != 0) {
            a(this.f13798i, this.f13796a, i2);
            this.f13798i = f13790c;
            this.f13796a = f13791d;
            this.f13797b = 0;
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
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
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f13797b) {
                try {
                    if (!set.contains(b(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f13798i;
        int i2 = this.f13797b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.f13797b <= 0;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean remove(Object obj) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        c(a2);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z2 = false;
        for (Object remove : collection) {
            z2 |= remove(remove);
        }
        return z2;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z2 = false;
        for (int i2 = this.f13797b - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f13796a[i2])) {
                c(i2);
                z2 = true;
            }
        }
        return z2;
    }

    public int size() {
        return this.f13797b;
    }

    public Object[] toArray() {
        int i2 = this.f13797b;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f13796a, 0, objArr, 0, i2);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f13797b) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f13797b);
        }
        System.arraycopy(this.f13796a, 0, tArr, 0, this.f13797b);
        int length = tArr.length;
        int i2 = this.f13797b;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13797b * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f13797b; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
