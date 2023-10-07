package s;

public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f34394a;

    /* renamed from: b  reason: collision with root package name */
    public final S f34395b;

    public d(F f2, S s2) {
        this.f34394a = f2;
        this.f34395b = s2;
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a((Object) dVar.f34394a, (Object) this.f34394a) && c.a((Object) dVar.f34395b, (Object) this.f34395b);
    }

    public int hashCode() {
        F f2 = this.f34394a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s2 = this.f34395b;
        if (s2 != null) {
            i2 = s2.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "Pair{" + this.f34394a + " " + this.f34395b + "}";
    }
}
