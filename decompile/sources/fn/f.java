package fn;

import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import fg.i;
import fj.q;
import fj.s;
import fj.t;

final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final long f27584a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27585b;

    /* renamed from: c  reason: collision with root package name */
    private final long f27586c;

    /* renamed from: d  reason: collision with root package name */
    private final long f27587d;

    /* renamed from: e  reason: collision with root package name */
    private final long f27588e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f27589f;

    private f(long j2, int i2, long j3) {
        this(j2, i2, j3, -1, (long[]) null);
    }

    private f(long j2, int i2, long j3, long j4, long[] jArr) {
        this.f27584a = j2;
        this.f27585b = i2;
        this.f27586c = j3;
        this.f27589f = jArr;
        this.f27587d = j4;
        this.f27588e = j4 != -1 ? j2 + j4 : -1;
    }

    private long a(int i2) {
        return (this.f27586c * ((long) i2)) / 100;
    }

    public static f a(long j2, long j3, q qVar, com.google.android.exoplayer2.util.q qVar2) {
        int v2;
        long j4 = j2;
        q qVar3 = qVar;
        int i2 = qVar3.f27400g;
        int i3 = qVar3.f27397d;
        int p2 = qVar2.p();
        if ((p2 & 1) != 1 || (v2 = qVar2.v()) == 0) {
            return null;
        }
        long d2 = ad.d((long) v2, ((long) i2) * 1000000, (long) i3);
        if ((p2 & 6) != 6) {
            return new f(j3, qVar3.f27396c, d2);
        }
        long n2 = qVar2.n();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = (long) qVar2.h();
        }
        if (j4 != -1) {
            long j5 = j3 + n2;
            if (j4 != j5) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j4);
                sb.append(", ");
                sb.append(j5);
                k.c("XingSeeker", sb.toString());
            }
        }
        return new f(j3, qVar3.f27396c, d2, n2, jArr);
    }

    public s.a a(long j2) {
        if (!a()) {
            return new s.a(new t(0, this.f27584a + ((long) this.f27585b)));
        }
        long a2 = ad.a(j2, 0, this.f27586c);
        double d2 = (double) a2;
        Double.isNaN(d2);
        double d3 = (double) this.f27586c;
        Double.isNaN(d3);
        double d4 = (d2 * 100.0d) / d3;
        double d5 = i.f27244a;
        if (d4 > i.f27244a) {
            if (d4 >= 100.0d) {
                d5 = 256.0d;
            } else {
                int i2 = (int) d4;
                long[] jArr = (long[]) a.b(this.f27589f);
                double d6 = (double) jArr[i2];
                double d7 = i2 == 99 ? 256.0d : (double) jArr[i2 + 1];
                double d8 = (double) i2;
                Double.isNaN(d8);
                Double.isNaN(d6);
                Double.isNaN(d6);
                d5 = d6 + ((d4 - d8) * (d7 - d6));
            }
        }
        double d9 = (double) this.f27587d;
        Double.isNaN(d9);
        return new s.a(new t(a2, this.f27584a + ad.a(Math.round((d5 / 256.0d) * d9), (long) this.f27585b, this.f27587d - 1)));
    }

    public boolean a() {
        return this.f27589f != null;
    }

    public long b() {
        return this.f27586c;
    }

    public long c() {
        return this.f27588e;
    }

    public long c(long j2) {
        double d2;
        long j3 = j2 - this.f27584a;
        if (!a() || j3 <= ((long) this.f27585b)) {
            return 0;
        }
        long[] jArr = (long[]) a.b(this.f27589f);
        double d3 = (double) j3;
        Double.isNaN(d3);
        double d4 = (double) this.f27587d;
        Double.isNaN(d4);
        double d5 = (d3 * 256.0d) / d4;
        int a2 = ad.a(jArr, (long) d5, true, true);
        long a3 = a(a2);
        long j4 = jArr[a2];
        int i2 = a2 + 1;
        long a4 = a(i2);
        long j5 = a2 == 99 ? 256 : jArr[i2];
        if (j4 == j5) {
            d2 = i.f27244a;
        } else {
            double d6 = (double) j4;
            Double.isNaN(d6);
            double d7 = (double) (j5 - j4);
            Double.isNaN(d7);
            d2 = (d5 - d6) / d7;
        }
        double d8 = (double) (a4 - a3);
        Double.isNaN(d8);
        return a3 + Math.round(d2 * d8);
    }
}
