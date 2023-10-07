package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.a;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f15122a;

    /* renamed from: b  reason: collision with root package name */
    public static final ad f15123b = new ad(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final ad f15124c = new ad(Long.MAX_VALUE, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final ad f15125d = new ad(0, Long.MAX_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final ad f15126e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15127f;

    /* renamed from: g  reason: collision with root package name */
    public final long f15128g;

    static {
        ad adVar = new ad(0, 0);
        f15122a = adVar;
        f15126e = adVar;
    }

    public ad(long j2, long j3) {
        boolean z2 = true;
        a.a(j2 >= 0);
        a.a(j3 < 0 ? false : z2);
        this.f15127f = j2;
        this.f15128g = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.f15127f == adVar.f15127f && this.f15128g == adVar.f15128g;
    }

    public int hashCode() {
        return (((int) this.f15127f) * 31) + ((int) this.f15128g);
    }
}
