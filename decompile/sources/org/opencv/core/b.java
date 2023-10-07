package org.opencv.core;

import fg.i;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public double f34088a;

    /* renamed from: b  reason: collision with root package name */
    public double f34089b;

    public b() {
        this(i.f27244a, i.f27244a);
    }

    public b(double d2, double d3) {
        this.f34088a = d2;
        this.f34089b = d3;
    }

    /* renamed from: a */
    public b clone() {
        return new b(this.f34088a, this.f34089b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f34088a == bVar.f34088a && this.f34089b == bVar.f34089b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f34089b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f34088a);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return ((int) this.f34088a) + "x" + ((int) this.f34089b);
    }
}
