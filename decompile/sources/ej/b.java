package ej;

import java.util.Locale;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private double f26896a;

    public b(double d2) {
        this.f26896a = d2;
    }

    public String toString() {
        double d2 = this.f26896a;
        if (d2 >= 100000.0d) {
            return String.format(Locale.US, "%2.1f km²", new Object[]{Double.valueOf(this.f26896a / 1000000.0d)});
        } else if (d2 >= 1.0d) {
            return String.format(Locale.US, "%2.1f m²", new Object[]{Double.valueOf(this.f26896a)});
        } else if (d2 >= 1.0E-5d) {
            return String.format(Locale.US, "%2.2f cm²", new Object[]{Double.valueOf(this.f26896a * 10000.0d)});
        } else {
            return this.f26896a + " m" + "²";
        }
    }
}
