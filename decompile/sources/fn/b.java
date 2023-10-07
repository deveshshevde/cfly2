package fn;

import android.util.Pair;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.ad;
import fg.i;
import fj.s;
import fj.t;

final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f27559a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f27560b;

    /* renamed from: c  reason: collision with root package name */
    private final long f27561c;

    private b(long[] jArr, long[] jArr2) {
        this.f27559a = jArr;
        this.f27560b = jArr2;
        this.f27561c = e.b(jArr2[jArr2.length - 1]);
    }

    private static Pair<Long, Long> a(long j2, long[] jArr, long[] jArr2) {
        double d2;
        Long valueOf;
        Long valueOf2;
        int a2 = ad.a(jArr, j2, true, true);
        long j3 = jArr[a2];
        long j4 = jArr2[a2];
        int i2 = a2 + 1;
        if (i2 == jArr.length) {
            valueOf = Long.valueOf(j3);
            valueOf2 = Long.valueOf(j4);
        } else {
            long j5 = jArr[i2];
            long j6 = jArr2[i2];
            if (j5 == j3) {
                d2 = i.f27244a;
            } else {
                double d3 = (double) j2;
                double d4 = (double) j3;
                Double.isNaN(d3);
                Double.isNaN(d4);
                double d5 = (double) (j5 - j3);
                Double.isNaN(d5);
                d2 = (d3 - d4) / d5;
            }
            double d6 = (double) (j6 - j4);
            Double.isNaN(d6);
            valueOf = Long.valueOf(j2);
            valueOf2 = Long.valueOf(((long) (d2 * d6)) + j4);
        }
        return Pair.create(valueOf, valueOf2);
    }

    public static b a(long j2, MlltFrame mlltFrame) {
        int length = mlltFrame.f15917d.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (mlltFrame.f15915b + mlltFrame.f15917d[i4]);
            j3 += (long) (mlltFrame.f15916c + mlltFrame.f15918e[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j3;
        }
        return new b(jArr, jArr2);
    }

    public s.a a(long j2) {
        Pair<Long, Long> a2 = a(e.a(ad.a(j2, 0, this.f27561c)), this.f27560b, this.f27559a);
        return new s.a(new t(e.b(((Long) a2.first).longValue()), ((Long) a2.second).longValue()));
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return this.f27561c;
    }

    public long c() {
        return -1;
    }

    public long c(long j2) {
        return e.b(((Long) a(j2, this.f27559a, this.f27560b).second).longValue());
    }
}
