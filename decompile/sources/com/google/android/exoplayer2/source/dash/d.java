package com.google.android.exoplayer2.source.dash;

import fj.b;
import fu.f;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f16104a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16105b;

    public d(b bVar, long j2) {
        this.f16104a = bVar;
        this.f16105b = j2;
    }

    public long a() {
        return 0;
    }

    public long a(long j2) {
        return this.f16104a.f27354e[(int) j2] - this.f16105b;
    }

    public long a(long j2, long j3) {
        return (long) this.f16104a.b(j2 + this.f16105b);
    }

    public long b(long j2, long j3) {
        return this.f16104a.f27353d[(int) j2];
    }

    public f b(long j2) {
        int i2 = (int) j2;
        return new f((String) null, this.f16104a.f27352c[i2], (long) this.f16104a.f27351b[i2]);
    }

    public boolean b() {
        return true;
    }

    public int c(long j2) {
        return this.f16104a.f27350a;
    }
}
