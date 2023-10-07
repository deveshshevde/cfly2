package j;

public class d<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f29446a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f29447b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f29448c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f29449d;

    /* renamed from: e  reason: collision with root package name */
    private int f29450e;

    public d() {
        this(10);
    }

    public d(int i2) {
        this.f29447b = false;
        if (i2 == 0) {
            this.f29448c = c.f29444b;
            this.f29449d = c.f29445c;
            return;
        }
        int b2 = c.b(i2);
        this.f29448c = new long[b2];
        this.f29449d = new Object[b2];
    }

    private void e() {
        int i2 = this.f29450e;
        long[] jArr = this.f29448c;
        Object[] objArr = this.f29449d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f29446a) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f29447b = false;
        this.f29450e = i3;
    }

    /* renamed from: a */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f29448c = (long[]) this.f29448c.clone();
            dVar.f29449d = (Object[]) this.f29449d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(long j2) {
        return a(j2, (Object) null);
    }

    public E a(long j2, E e2) {
        int a2 = c.a(this.f29448c, this.f29450e, j2);
        if (a2 >= 0) {
            E[] eArr = this.f29449d;
            if (eArr[a2] != f29446a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public void a(int i2) {
        Object[] objArr = this.f29449d;
        Object obj = objArr[i2];
        Object obj2 = f29446a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f29447b = true;
        }
    }

    public void a(int i2, E e2) {
        if (this.f29447b) {
            e();
        }
        this.f29449d[i2] = e2;
    }

    public int b() {
        if (this.f29447b) {
            e();
        }
        return this.f29450e;
    }

    public long b(int i2) {
        if (this.f29447b) {
            e();
        }
        return this.f29448c[i2];
    }

    @Deprecated
    public void b(long j2) {
        c(j2);
    }

    public void b(long j2, E e2) {
        int a2 = c.a(this.f29448c, this.f29450e, j2);
        if (a2 >= 0) {
            this.f29449d[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        int i3 = this.f29450e;
        if (i2 < i3) {
            Object[] objArr = this.f29449d;
            if (objArr[i2] == f29446a) {
                this.f29448c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f29447b && i3 >= this.f29448c.length) {
            e();
            i2 = c.a(this.f29448c, this.f29450e, j2) ^ -1;
        }
        int i4 = this.f29450e;
        if (i4 >= this.f29448c.length) {
            int b2 = c.b(i4 + 1);
            long[] jArr = new long[b2];
            Object[] objArr2 = new Object[b2];
            long[] jArr2 = this.f29448c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f29449d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f29448c = jArr;
            this.f29449d = objArr2;
        }
        int i5 = this.f29450e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f29448c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f29449d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f29450e - i2);
        }
        this.f29448c[i2] = j2;
        this.f29449d[i2] = e2;
        this.f29450e++;
    }

    public E c(int i2) {
        if (this.f29447b) {
            e();
        }
        return this.f29449d[i2];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f29449d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f29448c
            int r1 = r2.f29450e
            int r3 = j.c.a((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f29449d
            r0 = r4[r3]
            java.lang.Object r1 = f29446a
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f29447b = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.d.c(long):void");
    }

    public void c(long j2, E e2) {
        int i2 = this.f29450e;
        if (i2 == 0 || j2 > this.f29448c[i2 - 1]) {
            if (this.f29447b && i2 >= this.f29448c.length) {
                e();
            }
            int i3 = this.f29450e;
            if (i3 >= this.f29448c.length) {
                int b2 = c.b(i3 + 1);
                long[] jArr = new long[b2];
                Object[] objArr = new Object[b2];
                long[] jArr2 = this.f29448c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f29449d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f29448c = jArr;
                this.f29449d = objArr;
            }
            this.f29448c[i3] = j2;
            this.f29449d[i3] = e2;
            this.f29450e = i3 + 1;
            return;
        }
        b(j2, e2);
    }

    public boolean c() {
        return b() == 0;
    }

    public int d(long j2) {
        if (this.f29447b) {
            e();
        }
        return c.a(this.f29448c, this.f29450e, j2);
    }

    public void d() {
        int i2 = this.f29450e;
        Object[] objArr = this.f29449d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f29450e = 0;
        this.f29447b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f29450e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f29450e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(b(i2));
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
