package fq;

import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.a;
import fj.h;
import java.io.IOException;

final class z extends fj.a {

    private static final class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final aa f27992a;

        /* renamed from: b  reason: collision with root package name */
        private final q f27993b = new q();

        /* renamed from: c  reason: collision with root package name */
        private final int f27994c;

        public a(int i2, aa aaVar) {
            this.f27994c = i2;
            this.f27992a = aaVar;
        }

        private a.e a(q qVar, long j2, long j3) {
            int a2;
            int i2;
            q qVar2 = qVar;
            long j4 = j3;
            int c2 = qVar.c();
            long j5 = -1;
            long j6 = -1;
            long j7 = -9223372036854775807L;
            while (qVar.b() >= 188 && (i2 = a2 + 188) <= c2) {
                long a3 = ad.a(qVar2, (a2 = ad.a(qVar2.f17159a, qVar.d(), c2)), this.f27994c);
                if (a3 != -9223372036854775807L) {
                    long b2 = this.f27992a.b(a3);
                    if (b2 > j2) {
                        return j7 == -9223372036854775807L ? a.e.a(b2, j4) : a.e.a(j4 + j6);
                    }
                    if (100000 + b2 > j2) {
                        return a.e.a(j4 + ((long) a2));
                    }
                    j6 = (long) a2;
                    j7 = b2;
                }
                qVar2.c(i2);
                j5 = (long) i2;
            }
            return j7 != -9223372036854775807L ? a.e.b(j7, j4 + j5) : a.e.f27346a;
        }

        public a.e a(h hVar, long j2) throws IOException, InterruptedException {
            long c2 = hVar.c();
            int min = (int) Math.min(112800, hVar.d() - c2);
            this.f27993b.a(min);
            hVar.d(this.f27993b.f17159a, 0, min);
            return a(this.f27993b, j2, c2);
        }

        public void a() {
            this.f27993b.a(ad.f11760f);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z(com.google.android.exoplayer2.util.aa r17, long r18, long r20, int r22) {
        /*
            r16 = this;
            fj.a$b r1 = new fj.a$b
            r1.<init>()
            fq.z$a r2 = new fq.z$a
            r0 = r17
            r3 = r22
            r2.<init>(r3, r0)
            r3 = 1
            long r7 = r18 + r3
            r5 = 0
            r9 = 0
            r13 = 188(0xbc, double:9.3E-322)
            r15 = 940(0x3ac, float:1.317E-42)
            r0 = r16
            r3 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.z.<init>(com.google.android.exoplayer2.util.aa, long, long, int):void");
    }
}
