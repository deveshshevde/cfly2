package fw;

import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fj.u;

public final class g {
    private static int a(q qVar) {
        int i2 = 0;
        while (qVar.b() != 0) {
            int h2 = qVar.h();
            i2 += h2;
            if (h2 != 255) {
                return i2;
            }
        }
        return -1;
    }

    public static void a(long j2, q qVar, u[] uVarArr) {
        while (true) {
            boolean z2 = true;
            if (qVar.b() > 1) {
                int a2 = a(qVar);
                int a3 = a(qVar);
                int d2 = qVar.d() + a3;
                if (a3 == -1 || a3 > qVar.b()) {
                    k.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    d2 = qVar.c();
                } else if (a2 == 4 && a3 >= 8) {
                    int h2 = qVar.h();
                    int i2 = qVar.i();
                    int p2 = i2 == 49 ? qVar.p() : 0;
                    int h3 = qVar.h();
                    if (i2 == 47) {
                        qVar.d(1);
                    }
                    boolean z3 = h2 == 181 && (i2 == 49 || i2 == 47) && h3 == 3;
                    if (i2 == 49) {
                        if (p2 != 1195456820) {
                            z2 = false;
                        }
                        z3 &= z2;
                    }
                    if (z3) {
                        b(j2, qVar, uVarArr);
                    }
                }
                qVar.c(d2);
            } else {
                return;
            }
        }
    }

    public static void b(long j2, q qVar, u[] uVarArr) {
        int h2 = qVar.h();
        if ((h2 & 64) != 0) {
            qVar.d(1);
            int i2 = (h2 & 31) * 3;
            int d2 = qVar.d();
            for (u uVar : uVarArr) {
                qVar.c(d2);
                uVar.a(qVar, i2);
                uVar.a(j2, 1, i2, 0, (u.a) null);
            }
        }
    }
}
