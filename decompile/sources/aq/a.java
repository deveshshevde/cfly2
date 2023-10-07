package aq;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private double f5553a;

    /* renamed from: b  reason: collision with root package name */
    private double f5554b;

    public a() {
    }

    public a(double d2, double d3) {
        a(d2, d3);
    }

    public double a() {
        return this.f5554b;
    }

    public void a(double d2, double d3) {
        this.f5553a = d2;
        this.f5554b = d3;
    }

    public boolean a(a aVar) {
        return b.b(this, aVar).a() < 1.0E-6d;
    }

    public double b() {
        return this.f5553a;
    }

    public boolean equals(Object obj) {
        return obj instanceof a ? a((a) obj) : super.equals(obj);
    }

    public String toString() {
        return "lat/lon: " + b() + "/" + a();
    }
}
