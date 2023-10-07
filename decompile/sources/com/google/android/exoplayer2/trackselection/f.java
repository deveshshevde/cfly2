package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f16744a;

    /* renamed from: b  reason: collision with root package name */
    private final e[] f16745b;

    /* renamed from: c  reason: collision with root package name */
    private int f16746c;

    public f(e... eVarArr) {
        this.f16745b = eVarArr;
        this.f16744a = eVarArr.length;
    }

    public e a(int i2) {
        return this.f16745b[i2];
    }

    public e[] a() {
        return (e[]) this.f16745b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16745b, ((f) obj).f16745b);
    }

    public int hashCode() {
        if (this.f16746c == 0) {
            this.f16746c = 527 + Arrays.hashCode(this.f16745b);
        }
        return this.f16746c;
    }
}
