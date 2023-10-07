package com.google.android.exoplayer2.audio;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f15320a;

    /* renamed from: b  reason: collision with root package name */
    public final float f15321b;

    public i(int i2, float f2) {
        this.f15320a = i2;
        this.f15321b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f15320a == iVar.f15320a && Float.compare(iVar.f15321b, this.f15321b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f15320a) * 31) + Float.floatToIntBits(this.f15321b);
    }
}
