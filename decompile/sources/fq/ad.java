package fq;

import com.google.android.exoplayer2.util.q;

public final class ad {
    public static int a(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static long a(q qVar, int i2, int i3) {
        qVar.c(i2);
        if (qVar.b() < 5) {
            return -9223372036854775807L;
        }
        int p2 = qVar.p();
        if ((8388608 & p2) != 0 || ((2096896 & p2) >> 8) != i3) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        if (((p2 & 32) != 0) && qVar.h() >= 7 && qVar.b() >= 7) {
            if ((qVar.h() & 16) != 16) {
                z2 = false;
            }
            if (z2) {
                byte[] bArr = new byte[6];
                qVar.a(bArr, 0, 6);
                return a(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long a(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
