package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.internal.ac;

public class ab<T extends ac & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f30391a;

    private final void a(int i2, int i3) {
        T[] tArr = this.f30391a;
        h.a((Object) tArr);
        T t2 = tArr[i3];
        h.a((Object) t2);
        T t3 = tArr[i2];
        h.a((Object) t3);
        tArr[i2] = t2;
        tArr[i3] = t3;
        t2.a(i2);
        t3.a(i3);
    }

    private final void b(int i2) {
        this._size = i2;
    }

    private final void c(int i2) {
        while (i2 > 0) {
            T[] tArr = this.f30391a;
            h.a((Object) tArr);
            int i3 = (i2 - 1) / 2;
            T t2 = tArr[i3];
            h.a((Object) t2);
            T t3 = tArr[i2];
            h.a((Object) t3);
            if (((Comparable) t2).compareTo(t3) > 0) {
                a(i2, i3);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private final void d(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 < a()) {
                T[] tArr = this.f30391a;
                h.a((Object) tArr);
                int i4 = i3 + 1;
                if (i4 < a()) {
                    T t2 = tArr[i4];
                    h.a((Object) t2);
                    T t3 = tArr[i3];
                    h.a((Object) t3);
                    if (((Comparable) t2).compareTo(t3) < 0) {
                        i3 = i4;
                    }
                }
                T t4 = tArr[i2];
                h.a((Object) t4);
                T t5 = tArr[i3];
                h.a((Object) t5);
                if (((Comparable) t4).compareTo(t5) > 0) {
                    a(i2, i3);
                    i2 = i3;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final T[] f() {
        T[] tArr = this.f30391a;
        if (tArr == null) {
            T[] tArr2 = new ac[4];
            this.f30391a = tArr2;
            return tArr2;
        } else if (a() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, a() * 2);
            h.b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (ac[]) copyOf;
            this.f30391a = tArr3;
            return tArr3;
        }
    }

    public final int a() {
        return this._size;
    }

    public final T a(int i2) {
        boolean z2 = false;
        if (ag.a()) {
            if (!(a() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f30391a;
        h.a((Object) tArr);
        b(a() - 1);
        if (i2 < a()) {
            a(i2, a());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t2 = tArr[i2];
                h.a((Object) t2);
                T t3 = tArr[i3];
                h.a((Object) t3);
                if (((Comparable) t2).compareTo(t3) < 0) {
                    a(i2, i3);
                    c(i3);
                }
            }
            d(i2);
        }
        T t4 = tArr[a()];
        h.a((Object) t4);
        if (ag.a()) {
            if (t4.b() == this) {
                z2 = true;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        t4.a((ab<?>) null);
        t4.a(-1);
        tArr[a()] = (ac) null;
        return t4;
    }

    public final boolean a(T t2) {
        boolean z2;
        synchronized (this) {
            z2 = true;
            boolean z3 = false;
            if (t2.b() == null) {
                z2 = false;
            } else {
                int c2 = t2.c();
                if (ag.a()) {
                    if (c2 >= 0) {
                        z3 = true;
                    }
                    if (!z3) {
                        throw new AssertionError();
                    }
                }
                a(c2);
            }
        }
        return z2;
    }

    public final void b(T t2) {
        if (ag.a()) {
            if (!(t2.b() == null)) {
                throw new AssertionError();
            }
        }
        t2.a((ab<?>) this);
        ac[] f2 = f();
        int a2 = a();
        b(a2 + 1);
        f2[a2] = t2;
        t2.a(a2);
        c(a2);
    }

    public final boolean b() {
        return a() == 0;
    }

    public final T c() {
        T e2;
        synchronized (this) {
            e2 = e();
        }
        return e2;
    }

    public final T d() {
        T a2;
        synchronized (this) {
            a2 = a() > 0 ? a(0) : null;
        }
        return a2;
    }

    public final T e() {
        T[] tArr = this.f30391a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }
}
