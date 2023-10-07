package ej;

import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private double f26897a;

    public c(double d2) {
        a(d2);
    }

    public double a() {
        return this.f26897a;
    }

    public void a(double d2) {
        this.f26897a = d2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f26897a == ((c) obj).f26897a;
    }

    public String toString() {
        return String.format(Locale.US, "%2.1f", new Object[]{Double.valueOf(this.f26897a)});
    }
}
