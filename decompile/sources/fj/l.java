package fj;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.q;
import java.io.IOException;

public final class l {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public long f27379a;
    }

    public static int a(q qVar, int i2) {
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return qVar.h() + 1;
            case 7:
                return qVar.i() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }

    public static long a(h hVar, h hVar2) throws IOException, InterruptedException {
        hVar.a();
        boolean z2 = true;
        hVar.c(1);
        byte[] bArr = new byte[1];
        hVar.d(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z2 = false;
        }
        hVar.c(2);
        int i2 = z2 ? 7 : 6;
        q qVar = new q(i2);
        qVar.b(j.a(hVar, qVar.f17159a, 0, i2));
        hVar.a();
        a aVar = new a();
        if (a(qVar, hVar2, z2, aVar)) {
            return aVar.f27379a;
        }
        throw new ParserException();
    }

    private static boolean a(int i2, h hVar) {
        return i2 <= 7 ? i2 == hVar.f17119g - 1 : i2 <= 10 && hVar.f17119g == 2;
    }

    private static boolean a(q qVar, h hVar, int i2) {
        int a2 = a(qVar, i2);
        return a2 != -1 && a2 <= hVar.f17114b;
    }

    public static boolean a(q qVar, h hVar, int i2, a aVar) {
        q qVar2 = qVar;
        h hVar2 = hVar;
        int d2 = qVar.d();
        long n2 = qVar.n();
        long j2 = n2 >>> 16;
        if (j2 != ((long) i2)) {
            return false;
        }
        return a((int) (15 & (n2 >> 4)), hVar2) && b((int) ((n2 >> 1) & 7), hVar2) && !(((n2 & 1) > 1 ? 1 : ((n2 & 1) == 1 ? 0 : -1)) == 0) && a(qVar2, hVar2, ((j2 & 1) > 1 ? 1 : ((j2 & 1) == 1 ? 0 : -1)) == 0, aVar) && a(qVar2, hVar2, (int) ((n2 >> 12) & 15)) && b(qVar2, hVar2, (int) ((n2 >> 8) & 15)) && b(qVar2, d2);
    }

    private static boolean a(q qVar, h hVar, boolean z2, a aVar) {
        try {
            long C = qVar.C();
            if (!z2) {
                C *= (long) hVar.f17114b;
            }
            aVar.f27379a = C;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean a(h hVar, h hVar2, int i2, a aVar) throws IOException, InterruptedException {
        long b2 = hVar.b();
        byte[] bArr = new byte[2];
        hVar.d(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i2) {
            hVar.a();
            hVar.c((int) (b2 - hVar.c()));
            return false;
        }
        q qVar = new q(16);
        System.arraycopy(bArr, 0, qVar.f17159a, 0, 2);
        qVar.b(j.a(hVar, qVar.f17159a, 2, 14));
        hVar.a();
        hVar.c((int) (b2 - hVar.c()));
        return a(qVar, hVar2, i2, aVar);
    }

    private static boolean b(int i2, h hVar) {
        return i2 == 0 || i2 == hVar.f17121i;
    }

    private static boolean b(q qVar, int i2) {
        return qVar.h() == ad.b(qVar.f17159a, i2, qVar.d() - 1, 0);
    }

    private static boolean b(q qVar, h hVar, int i2) {
        int i3 = hVar.f17117e;
        if (i2 == 0) {
            return true;
        }
        if (i2 <= 11) {
            return i2 == hVar.f17118f;
        }
        if (i2 == 12) {
            return qVar.h() * 1000 == i3;
        }
        if (i2 > 14) {
            return false;
        }
        int i4 = qVar.i();
        if (i2 == 14) {
            i4 *= 10;
        }
        return i4 == i3;
    }
}
