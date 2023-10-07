package ef;

import fg.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private double f26882a;

    /* renamed from: b  reason: collision with root package name */
    private double f26883b;

    public a() {
    }

    public a(double d2, double d3) {
        a(d2, d3);
    }

    public a(a aVar) {
        a(aVar);
    }

    public static a a(a... aVarArr) {
        double d2 = i.f27244a;
        double d3 = 0.0d;
        for (a aVar : aVarArr) {
            d2 += aVar.f26882a;
            d3 += aVar.f26883b;
        }
        return new a(d2, d3);
    }

    public double a() {
        return this.f26882a;
    }

    public a a(double d2) {
        return new a(this.f26882a * d2, this.f26883b * d2);
    }

    public void a(double d2, double d3) {
        this.f26882a = d2;
        this.f26883b = d3;
    }

    public void a(a aVar) {
        a(aVar.f26882a, aVar.f26883b);
    }

    public double b() {
        return this.f26883b;
    }

    public a b(a aVar) {
        return new a(this.f26882a - aVar.f26882a, this.f26883b - aVar.f26883b);
    }

    public double c() {
        return this.f26883b;
    }

    public boolean c(a aVar) {
        return eg.a.c(this, aVar).a() < 1.0E-6d;
    }

    public double d() {
        return this.f26882a;
    }

    public boolean e() {
        return this.f26882a == i.f27244a || this.f26883b == i.f27244a;
    }

    public boolean equals(Object obj) {
        return obj instanceof a ? c((a) obj) : super.equals(obj);
    }

    public a f() {
        return new a(this.f26882a * -1.0d, this.f26883b * -1.0d);
    }

    public String toString() {
        return "lat/lon: " + d() + "/" + c();
    }
}
