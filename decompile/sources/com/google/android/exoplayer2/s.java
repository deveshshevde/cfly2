package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.ad;

final class s {

    /* renamed from: a  reason: collision with root package name */
    public final i.a f15997a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15998b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15999c;

    /* renamed from: d  reason: collision with root package name */
    public final long f16000d;

    /* renamed from: e  reason: collision with root package name */
    public final long f16001e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f16002f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f16003g;

    s(i.a aVar, long j2, long j3, long j4, long j5, boolean z2, boolean z3) {
        this.f15997a = aVar;
        this.f15998b = j2;
        this.f15999c = j3;
        this.f16000d = j4;
        this.f16001e = j5;
        this.f16002f = z2;
        this.f16003g = z3;
    }

    public s a(long j2) {
        if (j2 == this.f15998b) {
            return this;
        }
        return new s(this.f15997a, j2, this.f15999c, this.f16000d, this.f16001e, this.f16002f, this.f16003g);
    }

    public s b(long j2) {
        if (j2 == this.f15999c) {
            return this;
        }
        return new s(this.f15997a, this.f15998b, j2, this.f16000d, this.f16001e, this.f16002f, this.f16003g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.f15998b == sVar.f15998b && this.f15999c == sVar.f15999c && this.f16000d == sVar.f16000d && this.f16001e == sVar.f16001e && this.f16002f == sVar.f16002f && this.f16003g == sVar.f16003g && ad.a((Object) this.f15997a, (Object) sVar.f15997a);
    }

    public int hashCode() {
        return ((((((((((((527 + this.f15997a.hashCode()) * 31) + ((int) this.f15998b)) * 31) + ((int) this.f15999c)) * 31) + ((int) this.f16000d)) * 31) + ((int) this.f16001e)) * 31) + (this.f16002f ? 1 : 0)) * 31) + (this.f16003g ? 1 : 0);
    }
}
