package j;

public class h<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f29466a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f29467b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f29468c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f29469d;

    /* renamed from: e  reason: collision with root package name */
    private int f29470e;

    public h() {
        this(10);
    }

    public h(int i2) {
        this.f29467b = false;
        if (i2 == 0) {
            this.f29468c = c.f29443a;
            this.f29469d = c.f29445c;
            return;
        }
        int a2 = c.a(i2);
        this.f29468c = new int[a2];
        this.f29469d = new Object[a2];
    }

    private void d() {
        int i2 = this.f29470e;
        int[] iArr = this.f29468c;
        Object[] objArr = this.f29469d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f29466a) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f29467b = false;
        this.f29470e = i3;
    }

    public int a(E e2) {
        if (this.f29467b) {
            d();
        }
        for (int i2 = 0; i2 < this.f29470e; i2++) {
            if (this.f29469d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f29468c = (int[]) this.f29468c.clone();
            hVar.f29469d = (Object[]) this.f29469d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(int i2) {
        return a(i2, (Object) null);
    }

    public E a(int i2, E e2) {
        int a2 = c.a(this.f29468c, this.f29470e, i2);
        if (a2 >= 0) {
            E[] eArr = this.f29469d;
            if (eArr[a2] != f29466a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public int b() {
        if (this.f29467b) {
            d();
        }
        return this.f29470e;
    }

    public void b(int i2) {
        Object[] objArr = this.f29469d;
        Object obj = objArr[i2];
        Object obj2 = f29466a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f29467b = true;
        }
    }

    public void b(int i2, E e2) {
        int a2 = c.a(this.f29468c, this.f29470e, i2);
        if (a2 >= 0) {
            this.f29469d[a2] = e2;
            return;
        }
        int i3 = a2 ^ -1;
        int i4 = this.f29470e;
        if (i3 < i4) {
            Object[] objArr = this.f29469d;
            if (objArr[i3] == f29466a) {
                this.f29468c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f29467b && i4 >= this.f29468c.length) {
            d();
            i3 = c.a(this.f29468c, this.f29470e, i2) ^ -1;
        }
        int i5 = this.f29470e;
        if (i5 >= this.f29468c.length) {
            int a3 = c.a(i5 + 1);
            int[] iArr = new int[a3];
            Object[] objArr2 = new Object[a3];
            int[] iArr2 = this.f29468c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f29469d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f29468c = iArr;
            this.f29469d = objArr2;
        }
        int i6 = this.f29470e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f29468c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f29469d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f29470e - i3);
        }
        this.f29468c[i3] = i2;
        this.f29469d[i3] = e2;
        this.f29470e++;
    }

    public int c(int i2) {
        if (this.f29467b) {
            d();
        }
        return this.f29468c[i2];
    }

    public void c() {
        int i2 = this.f29470e;
        Object[] objArr = this.f29469d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f29470e = 0;
        this.f29467b = false;
    }

    public void c(int i2, E e2) {
        int i3 = this.f29470e;
        if (i3 == 0 || i2 > this.f29468c[i3 - 1]) {
            if (this.f29467b && i3 >= this.f29468c.length) {
                d();
            }
            int i4 = this.f29470e;
            if (i4 >= this.f29468c.length) {
                int a2 = c.a(i4 + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                int[] iArr2 = this.f29468c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f29469d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f29468c = iArr;
                this.f29469d = objArr;
            }
            this.f29468c[i4] = i2;
            this.f29469d[i4] = e2;
            this.f29470e = i4 + 1;
            return;
        }
        b(i2, e2);
    }

    public E d(int i2) {
        if (this.f29467b) {
            d();
        }
        return this.f29469d[i2];
    }

    public int e(int i2) {
        if (this.f29467b) {
            d();
        }
        return c.a(this.f29468c, this.f29470e, i2);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f29470e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f29470e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(c(i2));
            sb.append('=');
            Object d2 = d(i2);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
