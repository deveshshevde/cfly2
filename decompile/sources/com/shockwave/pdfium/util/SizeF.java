package com.shockwave.pdfium.util;

public class SizeF {

    /* renamed from: a  reason: collision with root package name */
    private final float f21607a;

    /* renamed from: b  reason: collision with root package name */
    private final float f21608b;

    public SizeF(float f2, float f3) {
        this.f21607a = f2;
        this.f21608b = f3;
    }

    public float a() {
        return this.f21607a;
    }

    public float b() {
        return this.f21608b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeF)) {
            return false;
        }
        SizeF sizeF = (SizeF) obj;
        return this.f21607a == sizeF.f21607a && this.f21608b == sizeF.f21608b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f21607a) ^ Float.floatToIntBits(this.f21608b);
    }

    public String toString() {
        return this.f21607a + "x" + this.f21608b;
    }
}
