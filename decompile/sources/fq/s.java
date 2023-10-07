package fq;

import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.a;
import fj.h;
import java.io.IOException;

final class s extends fj.a {

    private static final class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final aa f27951a;

        /* renamed from: b  reason: collision with root package name */
        private final q f27952b;

        private a(aa aaVar) {
            this.f27951a = aaVar;
            this.f27952b = new q();
        }

        private a.e a(q qVar, long j2, long j3) {
            int i2 = -1;
            long j4 = -9223372036854775807L;
            int i3 = -1;
            while (qVar.b() >= 4) {
                if (s.b(qVar.f17159a, qVar.d()) != 442) {
                    qVar.d(1);
                } else {
                    qVar.d(4);
                    long a2 = t.a(qVar);
                    if (a2 != -9223372036854775807L) {
                        long b2 = this.f27951a.b(a2);
                        if (b2 > j2) {
                            return j4 == -9223372036854775807L ? a.e.a(b2, j3) : a.e.a(j3 + ((long) i3));
                        }
                        if (100000 + b2 > j2) {
                            return a.e.a(j3 + ((long) qVar.d()));
                        }
                        i3 = qVar.d();
                        j4 = b2;
                    }
                    a(qVar);
                    i2 = qVar.d();
                }
            }
            return j4 != -9223372036854775807L ? a.e.b(j4, j3 + ((long) i2)) : a.e.f27346a;
        }

        private static void a(q qVar) {
            int c2 = qVar.c();
            if (qVar.b() < 10) {
                qVar.c(c2);
                return;
            }
            qVar.d(9);
            int h2 = qVar.h() & 7;
            if (qVar.b() < h2) {
                qVar.c(c2);
                return;
            }
            qVar.d(h2);
            if (qVar.b() < 4) {
                qVar.c(c2);
                return;
            }
            if (s.b(qVar.f17159a, qVar.d()) == 443) {
                qVar.d(4);
                int i2 = qVar.i();
                if (qVar.b() < i2) {
                    qVar.c(c2);
                    return;
                }
                qVar.d(i2);
            }
            while (qVar.b() >= 4 && (r1 = s.b(qVar.f17159a, qVar.d())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                qVar.d(4);
                if (qVar.b() < 2) {
                    qVar.c(c2);
                    return;
                } else {
                    qVar.c(Math.min(qVar.c(), qVar.d() + qVar.i()));
                }
            }
        }

        public a.e a(h hVar, long j2) throws IOException, InterruptedException {
            long c2 = hVar.c();
            int min = (int) Math.min(20000, hVar.d() - c2);
            this.f27952b.a(min);
            hVar.d(this.f27952b.f17159a, 0, min);
            return a(this.f27952b, j2, c2);
        }

        public void a() {
            this.f27952b.a(ad.f11760f);
        }
    }

    public s(aa aaVar, long j2, long j3) {
        super(new a.b(), new a(aaVar), j2, 0, j2 + 1, 0, j3, 188, 1000);
    }

    /* access modifiers changed from: private */
    public static int b(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
