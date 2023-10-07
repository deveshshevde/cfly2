package el;

import ej.a;
import ej.c;
import fg.i;
import java.util.Locale;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f26912a = new a(50.0d);

    /* renamed from: b  reason: collision with root package name */
    private Double f26913b = Double.valueOf(i.f27244a);

    /* renamed from: c  reason: collision with root package name */
    private Double f26914c = Double.valueOf(50.0d);

    /* renamed from: d  reason: collision with root package name */
    private Double f26915d = Double.valueOf(60.0d);

    /* renamed from: e  reason: collision with root package name */
    private eo.a f26916e = new eo.a();

    private void k() {
        if (this.f26916e.f26936f != null) {
            this.f26914c = this.f26916e.f26936f;
        }
        if (this.f26916e.f26937g != null) {
            this.f26915d = this.f26916e.f26937g;
        }
    }

    public c a() {
        return new c((this.f26912a.a() * this.f26916e.a().doubleValue()) / this.f26916e.f26935e.doubleValue());
    }

    public void a(double d2, a aVar, double d3, double d4) {
        this.f26913b = Double.valueOf(d2);
        this.f26912a = aVar;
        this.f26914c = Double.valueOf(d3);
        this.f26915d = Double.valueOf(d4);
    }

    public void a(a aVar) {
        this.f26912a = aVar;
    }

    public void a(eo.a aVar) {
        this.f26916e = aVar;
        k();
    }

    public c b() {
        return new c((this.f26912a.a() * this.f26916e.b().doubleValue()) / this.f26916e.f26935e.doubleValue());
    }

    public ej.b c() {
        return new ej.b(((((this.f26912a.a() * this.f26916e.a().doubleValue()) / this.f26916e.f26935e.doubleValue()) * ((this.f26912a.a() * this.f26916e.b().doubleValue()) / this.f26916e.f26935e.doubleValue())) / (this.f26916e.f26934d.doubleValue() * 1000.0d)) / 10000.0d);
    }

    public c d() {
        return new c(b().a() * (1.0d - (this.f26914c.doubleValue() * 0.01d)));
    }

    public c e() {
        return new c(a().a() * (1.0d - (this.f26915d.doubleValue() * 0.01d)));
    }

    public a f() {
        return this.f26912a;
    }

    public Double g() {
        return this.f26913b;
    }

    public double h() {
        return this.f26915d.doubleValue();
    }

    public double i() {
        return this.f26914c.doubleValue();
    }

    public String j() {
        return this.f26916e.f26931a;
    }

    public String toString() {
        return String.format(Locale.US, "Altitude: %f Angle %f Overlap: %f Sidelap: %f", new Object[]{this.f26912a, this.f26913b, this.f26914c, this.f26915d});
    }
}
