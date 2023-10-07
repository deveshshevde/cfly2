package eg;

import ef.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f26887a;

    /* renamed from: b  reason: collision with root package name */
    private final a f26888b;

    public b(a aVar, a aVar2) {
        this.f26887a = aVar;
        this.f26888b = aVar2;
    }

    private Double c(a aVar) {
        return a.a(this.f26888b, aVar);
    }

    private Double d(a aVar) {
        return a.a(this.f26887a, aVar);
    }

    public a a() {
        return this.f26887a;
    }

    public a a(a aVar) {
        return b(aVar).c(this.f26887a) ? this.f26888b : this.f26887a;
    }

    public a b() {
        return this.f26888b;
    }

    public a b(a aVar) {
        return d(aVar).doubleValue() < c(aVar).doubleValue() ? this.f26887a : this.f26888b;
    }

    public String toString() {
        return "from:" + this.f26887a.toString() + "to:" + this.f26888b.toString();
    }
}
