package fj;

import com.google.android.exoplayer2.util.ad;
import fj.s;

public class c implements s {

    /* renamed from: a  reason: collision with root package name */
    private final long f27356a;

    /* renamed from: b  reason: collision with root package name */
    private final long f27357b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27358c;

    /* renamed from: d  reason: collision with root package name */
    private final long f27359d;

    /* renamed from: e  reason: collision with root package name */
    private final int f27360e;

    /* renamed from: f  reason: collision with root package name */
    private final long f27361f;

    public c(long j2, long j3, int i2, int i3) {
        long j4;
        this.f27356a = j2;
        this.f27357b = j3;
        this.f27358c = i3 == -1 ? 1 : i3;
        this.f27360e = i2;
        if (j2 == -1) {
            this.f27359d = -1;
            j4 = -9223372036854775807L;
        } else {
            this.f27359d = j2 - j3;
            j4 = a(j2, j3, i2);
        }
        this.f27361f = j4;
    }

    private static long a(long j2, long j3, int i2) {
        return ((Math.max(0, j2 - j3) * 8) * 1000000) / ((long) i2);
    }

    private long c(long j2) {
        int i2 = this.f27358c;
        return this.f27357b + ad.a((((j2 * ((long) this.f27360e)) / 8000000) / ((long) i2)) * ((long) i2), 0, this.f27359d - ((long) i2));
    }

    public s.a a(long j2) {
        if (this.f27359d == -1) {
            return new s.a(new t(0, this.f27357b));
        }
        long c2 = c(j2);
        long b2 = b(c2);
        t tVar = new t(b2, c2);
        if (b2 < j2) {
            int i2 = this.f27358c;
            if (((long) i2) + c2 < this.f27356a) {
                long j3 = c2 + ((long) i2);
                return new s.a(tVar, new t(b(j3), j3));
            }
        }
        return new s.a(tVar);
    }

    public boolean a() {
        return this.f27359d != -1;
    }

    public long b() {
        return this.f27361f;
    }

    public long b(long j2) {
        return a(j2, this.f27357b, this.f27360e);
    }
}
