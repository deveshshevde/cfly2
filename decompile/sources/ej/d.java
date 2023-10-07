package ej;

import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private double f26898a;

    public d(double d2) {
        a(d2);
    }

    public double a() {
        return this.f26898a;
    }

    public void a(double d2) {
        this.f26898a = d2;
    }

    public String b() {
        return String.format(Locale.US, "%2.1f m/s", new Object[]{Double.valueOf(this.f26898a)});
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && this.f26898a == ((d) obj).f26898a;
    }

    public String toString() {
        double d2 = this.f26898a;
        if (d2 >= 1000.0d) {
            return String.format(Locale.US, "%2.1f km/s", new Object[]{Double.valueOf(this.f26898a / 1000.0d)});
        } else if (d2 >= 1.0d) {
            return b();
        } else {
            return this.f26898a + " m/s";
        }
    }
}
