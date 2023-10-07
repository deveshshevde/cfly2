package fn;

import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import fj.q;
import fj.s;
import fj.t;

final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f27580a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f27581b;

    /* renamed from: c  reason: collision with root package name */
    private final long f27582c;

    /* renamed from: d  reason: collision with root package name */
    private final long f27583d;

    private e(long[] jArr, long[] jArr2, long j2, long j3) {
        this.f27580a = jArr;
        this.f27581b = jArr2;
        this.f27582c = j2;
        this.f27583d = j3;
    }

    public static e a(long j2, long j3, q qVar, com.google.android.exoplayer2.util.q qVar2) {
        int i2;
        long j4 = j2;
        q qVar3 = qVar;
        com.google.android.exoplayer2.util.q qVar4 = qVar2;
        qVar4.d(10);
        int p2 = qVar2.p();
        if (p2 <= 0) {
            return null;
        }
        int i3 = qVar3.f27397d;
        long d2 = ad.d((long) p2, 1000000 * ((long) (i3 >= 32000 ? 1152 : 576)), (long) i3);
        int i4 = qVar2.i();
        int i5 = qVar2.i();
        int i6 = qVar2.i();
        qVar4.d(2);
        long j5 = j3 + ((long) qVar3.f27396c);
        long[] jArr = new long[i4];
        long[] jArr2 = new long[i4];
        int i7 = 0;
        long j6 = j3;
        while (i7 < i4) {
            int i8 = i5;
            jArr[i7] = (((long) i7) * d2) / ((long) i4);
            long j7 = j5;
            jArr2[i7] = Math.max(j6, j7);
            if (i6 == 1) {
                i2 = qVar2.h();
            } else if (i6 == 2) {
                i2 = qVar2.i();
            } else if (i6 == 3) {
                i2 = qVar2.l();
            } else if (i6 != 4) {
                return null;
            } else {
                i2 = qVar2.v();
            }
            j6 += (long) (i2 * i8);
            i7++;
            j5 = j7;
            i5 = i8;
        }
        if (!(j4 == -1 || j4 == j6)) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j4);
            sb.append(", ");
            sb.append(j6);
            k.c("VbriSeeker", sb.toString());
        }
        return new e(jArr, jArr2, d2, j6);
    }

    public s.a a(long j2) {
        int a2 = ad.a(this.f27580a, j2, true, true);
        t tVar = new t(this.f27580a[a2], this.f27581b[a2]);
        if (tVar.f27407b >= j2 || a2 == this.f27580a.length - 1) {
            return new s.a(tVar);
        }
        int i2 = a2 + 1;
        return new s.a(tVar, new t(this.f27580a[i2], this.f27581b[i2]));
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return this.f27582c;
    }

    public long c() {
        return this.f27583d;
    }

    public long c(long j2) {
        return this.f27580a[ad.a(this.f27581b, j2, true, true)];
    }
}
