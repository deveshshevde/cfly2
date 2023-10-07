package io.reactivex.internal.util;

public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f28906a;

    /* renamed from: b  reason: collision with root package name */
    int f28907b;

    /* renamed from: c  reason: collision with root package name */
    int f28908c;

    /* renamed from: d  reason: collision with root package name */
    int f28909d;

    /* renamed from: e  reason: collision with root package name */
    T[] f28910e;

    public d() {
        this(16, 0.75f);
    }

    public d(int i2, float f2) {
        this.f28906a = f2;
        int a2 = e.a(i2);
        this.f28907b = a2 - 1;
        this.f28909d = (int) (f2 * ((float) a2));
        this.f28910e = (Object[]) new Object[a2];
    }

    static int a(int i2) {
        int i3 = i2 * -1640531527;
        return i3 ^ (i3 >>> 16);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        T[] tArr = this.f28910e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (Object[]) new Object[i2];
        int i4 = this.f28908c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a2 = a(tArr[length].hashCode()) & i3;
                if (tArr2[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i3;
                    } while (tArr2[a2] != null);
                }
                tArr2[a2] = tArr[length];
                i4 = i5;
            } else {
                this.f28907b = i3;
                this.f28909d = (int) (((float) i2) * this.f28906a);
                this.f28910e = tArr2;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, T[] tArr, int i3) {
        int i4;
        T t2;
        this.f28908c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t2 = tArr[i4];
                if (t2 == null) {
                    tArr[i2] = null;
                    return true;
                }
                int a2 = a(t2.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= a2 || a2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 >= a2 && a2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t2;
            i2 = i4;
        }
    }

    public boolean a(T t2) {
        T t3;
        T[] tArr = this.f28910e;
        int i2 = this.f28907b;
        int a2 = a(t2.hashCode()) & i2;
        T t4 = tArr[a2];
        if (t4 != null) {
            if (t4.equals(t2)) {
                return false;
            }
            do {
                a2 = (a2 + 1) & i2;
                t3 = tArr[a2];
                if (t3 == null) {
                }
            } while (!t3.equals(t2));
            return false;
        }
        tArr[a2] = t2;
        int i3 = this.f28908c + 1;
        this.f28908c = i3;
        if (i3 >= this.f28909d) {
            a();
        }
        return true;
    }

    public boolean b(T t2) {
        T t3;
        T[] tArr = this.f28910e;
        int i2 = this.f28907b;
        int a2 = a(t2.hashCode()) & i2;
        T t4 = tArr[a2];
        if (t4 == null) {
            return false;
        }
        if (t4.equals(t2)) {
            return a(a2, tArr, i2);
        }
        do {
            a2 = (a2 + 1) & i2;
            t3 = tArr[a2];
            if (t3 == null) {
                return false;
            }
        } while (!t3.equals(t2));
        return a(a2, tArr, i2);
    }

    public Object[] b() {
        return this.f28910e;
    }
}
