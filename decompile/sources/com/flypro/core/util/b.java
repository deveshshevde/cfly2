package com.flypro.core.util;

public class b<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f14468a;

    /* renamed from: b  reason: collision with root package name */
    public final S f14469b;

    public b(F f2, S s2) {
        this.f14468a = f2;
        this.f14469b = s2;
    }

    public static <A, B> b<A, B> a(A a2, B b2) {
        return new b<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        F f2 = bVar.f14468a;
        if (f2 == null) {
            if (this.f14468a == null) {
                return true;
            }
        } else if (!f2.equals(this.f14468a) || bVar.f14469b != null) {
            return bVar.f14469b.equals(this.f14469b);
        } else {
            if (this.f14469b == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        F f2 = this.f14468a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s2 = this.f14469b;
        if (s2 != null) {
            i2 = s2.hashCode();
        }
        return hashCode ^ i2;
    }
}
