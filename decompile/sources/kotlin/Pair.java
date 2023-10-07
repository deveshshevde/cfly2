package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.h;

public final class Pair<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f30169a;

    /* renamed from: b  reason: collision with root package name */
    private final B f30170b;

    public Pair(A a2, B b2) {
        this.f30169a = a2;
        this.f30170b = b2;
    }

    public final A a() {
        return this.f30169a;
    }

    public final B b() {
        return this.f30170b;
    }

    public final A c() {
        return this.f30169a;
    }

    public final B d() {
        return this.f30170b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return h.a((Object) this.f30169a, (Object) pair.f30169a) && h.a((Object) this.f30170b, (Object) pair.f30170b);
    }

    public int hashCode() {
        A a2 = this.f30169a;
        int i2 = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.f30170b;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return '(' + this.f30169a + ", " + this.f30170b + ')';
    }
}
