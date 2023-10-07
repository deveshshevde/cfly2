package org.opencv.core;

public class Range {

    /* renamed from: a  reason: collision with root package name */
    public int f34060a;

    /* renamed from: b  reason: collision with root package name */
    public int f34061b;

    public Range() {
        this(0, 0);
    }

    public Range(int i2, int i3) {
        this.f34060a = i2;
        this.f34061b = i3;
    }

    /* renamed from: a */
    public Range clone() {
        return new Range(this.f34060a, this.f34061b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.f34060a == range.f34060a && this.f34061b == range.f34061b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.f34060a);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.f34061b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "[" + this.f34060a + ", " + this.f34061b + ")";
    }
}
