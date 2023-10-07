package org.jcodec.common.model;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33227a = new c(1, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final c f33228b = new c(1, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final c f33229c = new c(0, 1);

    /* renamed from: d  reason: collision with root package name */
    final int f33230d;

    /* renamed from: e  reason: collision with root package name */
    final int f33231e;

    public c(int i2, int i3) {
        this.f33230d = i2;
        this.f33231e = i3;
    }

    public int a() {
        return this.f33230d;
    }

    public int a(int i2) {
        return (int) ((((long) this.f33230d) * ((long) i2)) / ((long) this.f33231e));
    }

    public long a(long j2) {
        return (((long) this.f33230d) * j2) / ((long) this.f33231e);
    }

    public int b() {
        return this.f33231e;
    }

    public c c() {
        return new c(this.f33231e, this.f33230d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f33231e == cVar.f33231e && this.f33230d == cVar.f33230d;
    }

    public int hashCode() {
        return ((this.f33231e + 31) * 31) + this.f33230d;
    }
}
