package fr;

import com.google.android.exoplayer2.util.ad;
import fj.s;
import fj.t;

final class d implements s {

    /* renamed from: a  reason: collision with root package name */
    private final b f28026a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28027b;

    /* renamed from: c  reason: collision with root package name */
    private final long f28028c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28029d;

    /* renamed from: e  reason: collision with root package name */
    private final long f28030e;

    public d(b bVar, int i2, long j2, long j3) {
        this.f28026a = bVar;
        this.f28027b = i2;
        this.f28028c = j2;
        long j4 = (j3 - j2) / ((long) bVar.f28021e);
        this.f28029d = j4;
        this.f28030e = b(j4);
    }

    private long b(long j2) {
        return ad.d(j2 * ((long) this.f28027b), 1000000, (long) this.f28026a.f28019c);
    }

    public s.a a(long j2) {
        long a2 = ad.a((((long) this.f28026a.f28019c) * j2) / (((long) this.f28027b) * 1000000), 0, this.f28029d - 1);
        long j3 = this.f28028c + (((long) this.f28026a.f28021e) * a2);
        long b2 = b(a2);
        t tVar = new t(b2, j3);
        if (b2 >= j2 || a2 == this.f28029d - 1) {
            return new s.a(tVar);
        }
        long j4 = a2 + 1;
        return new s.a(tVar, new t(b(j4), this.f28028c + (((long) this.f28026a.f28021e) * j4)));
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return this.f28030e;
    }
}
