package com.shockwave.pdfium.util;

public class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f21605a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21606b;

    public Size(int i2, int i3) {
        this.f21605a = i2;
        this.f21606b = i3;
    }

    public int a() {
        return this.f21605a;
    }

    public int b() {
        return this.f21606b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f21605a == size.f21605a && this.f21606b == size.f21606b;
    }

    public int hashCode() {
        int i2 = this.f21606b;
        int i3 = this.f21605a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.f21605a + "x" + this.f21606b;
    }
}
