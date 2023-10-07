package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.a;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f17191a = new v(1.0f);

    /* renamed from: b  reason: collision with root package name */
    public final float f17192b;

    /* renamed from: c  reason: collision with root package name */
    public final float f17193c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17194d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17195e;

    public v(float f2) {
        this(f2, 1.0f, false);
    }

    public v(float f2, float f3, boolean z2) {
        boolean z3 = true;
        a.a(f2 > 0.0f);
        a.a(f3 <= 0.0f ? false : z3);
        this.f17192b = f2;
        this.f17193c = f3;
        this.f17194d = z2;
        this.f17195e = Math.round(f2 * 1000.0f);
    }

    public long a(long j2) {
        return j2 * ((long) this.f17195e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.f17192b == vVar.f17192b && this.f17193c == vVar.f17193c && this.f17194d == vVar.f17194d;
    }

    public int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.f17192b)) * 31) + Float.floatToRawIntBits(this.f17193c)) * 31) + (this.f17194d ? 1 : 0);
    }
}
