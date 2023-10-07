package fg;

import fg.f.a;

public class f<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    private static int f27224a;

    /* renamed from: b  reason: collision with root package name */
    private int f27225b;

    /* renamed from: c  reason: collision with root package name */
    private int f27226c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f27227d;

    /* renamed from: e  reason: collision with root package name */
    private int f27228e;

    /* renamed from: f  reason: collision with root package name */
    private T f27229f;

    /* renamed from: g  reason: collision with root package name */
    private float f27230g;

    public static abstract class a {

        /* renamed from: d  reason: collision with root package name */
        public static int f27231d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f27232e = f27231d;

        /* access modifiers changed from: protected */
        public abstract a a();
    }

    private f(int i2, T t2) {
        if (i2 > 0) {
            this.f27226c = i2;
            this.f27227d = new Object[i2];
            this.f27228e = 0;
            this.f27229f = t2;
            this.f27230g = 1.0f;
            b();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized f a(int i2, a aVar) {
        f fVar;
        synchronized (f.class) {
            fVar = new f(i2, aVar);
            int i3 = f27224a;
            fVar.f27225b = i3;
            f27224a = i3 + 1;
        }
        return fVar;
    }

    private void b() {
        b(this.f27230g);
    }

    private void b(float f2) {
        int i2 = this.f27226c;
        int i3 = (int) (((float) i2) * f2);
        if (i3 < 1) {
            i2 = 1;
        } else if (i3 <= i2) {
            i2 = i3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f27227d[i4] = this.f27229f.a();
        }
        this.f27228e = i2 - 1;
    }

    private void c() {
        int i2 = this.f27226c;
        int i3 = i2 * 2;
        this.f27226c = i3;
        Object[] objArr = new Object[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            objArr[i4] = this.f27227d[i4];
        }
        this.f27227d = objArr;
    }

    public synchronized T a() {
        T t2;
        if (this.f27228e == -1 && this.f27230g > 0.0f) {
            b();
        }
        t2 = (a) this.f27227d[this.f27228e];
        t2.f27232e = a.f27231d;
        this.f27228e--;
        return t2;
    }

    public void a(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f27230g = f2;
    }

    public synchronized void a(T t2) {
        if (t2.f27232e == a.f27231d) {
            int i2 = this.f27228e + 1;
            this.f27228e = i2;
            if (i2 >= this.f27227d.length) {
                c();
            }
            t2.f27232e = this.f27225b;
            this.f27227d[this.f27228e] = t2;
        } else if (t2.f27232e == this.f27225b) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t2.f27232e + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }
}
