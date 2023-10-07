package fg;

import fg.f;

public class d extends f.a {

    /* renamed from: c  reason: collision with root package name */
    private static f<d> f27217c;

    /* renamed from: a  reason: collision with root package name */
    public double f27218a;

    /* renamed from: b  reason: collision with root package name */
    public double f27219b;

    static {
        f<d> a2 = f.a(64, new d(i.f27244a, i.f27244a));
        f27217c = a2;
        a2.a(0.5f);
    }

    private d(double d2, double d3) {
        this.f27218a = d2;
        this.f27219b = d3;
    }

    public static d a(double d2, double d3) {
        d a2 = f27217c.a();
        a2.f27218a = d2;
        a2.f27219b = d3;
        return a2;
    }

    public static void a(d dVar) {
        f27217c.a(dVar);
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new d(i.f27244a, i.f27244a);
    }

    public String toString() {
        return "MPPointD, x: " + this.f27218a + ", y: " + this.f27219b;
    }
}
