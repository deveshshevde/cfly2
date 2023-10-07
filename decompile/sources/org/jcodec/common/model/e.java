package org.jcodec.common.model;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f33236a;

    /* renamed from: b  reason: collision with root package name */
    private int f33237b;

    public e(int i2, int i3) {
        this.f33236a = i2;
        this.f33237b = i3;
    }

    public int a() {
        return this.f33236a;
    }

    public int b() {
        return this.f33237b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f33237b == eVar.f33237b && this.f33236a == eVar.f33236a;
    }

    public int hashCode() {
        return ((this.f33237b + 31) * 31) + this.f33236a;
    }
}
