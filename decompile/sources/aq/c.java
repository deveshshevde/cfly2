package aq;

import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private double f5555a;

    public c(double d2) {
        a(d2);
    }

    public double a() {
        return this.f5555a;
    }

    public void a(double d2) {
        this.f5555a = d2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f5555a == ((c) obj).f5555a;
    }

    public String toString() {
        double d2 = this.f5555a;
        if (d2 >= 1000.0d) {
            return String.format(Locale.US, "%2.1f km", new Object[]{Double.valueOf(this.f5555a / 1000.0d)});
        } else if (d2 >= 1.0d) {
            return String.format(Locale.US, "%2.1f m", new Object[]{Double.valueOf(this.f5555a)});
        } else if (d2 >= 0.001d) {
            return String.format(Locale.US, "%2.1f mm", new Object[]{Double.valueOf(this.f5555a * 1000.0d)});
        } else {
            return this.f5555a + " m";
        }
    }
}
