package org.jcodec.common.model;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f33232a;

    /* renamed from: b  reason: collision with root package name */
    private int f33233b;

    /* renamed from: c  reason: collision with root package name */
    private int f33234c;

    /* renamed from: d  reason: collision with root package name */
    private int f33235d;

    public d(int i2, int i3, int i4, int i5) {
        this.f33232a = i2;
        this.f33233b = i3;
        this.f33234c = i4;
        this.f33235d = i5;
    }

    public int a() {
        return this.f33234c;
    }

    public int b() {
        return this.f33235d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f33235d == dVar.f33235d && this.f33234c == dVar.f33234c && this.f33232a == dVar.f33232a && this.f33233b == dVar.f33233b;
    }

    public int hashCode() {
        return ((((((this.f33235d + 31) * 31) + this.f33234c) * 31) + this.f33232a) * 31) + this.f33233b;
    }

    public String toString() {
        return "Rect [x=" + this.f33232a + ", y=" + this.f33233b + ", width=" + this.f33234c + ", height=" + this.f33235d + "]";
    }
}
