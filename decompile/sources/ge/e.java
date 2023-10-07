package ge;

import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import ge.d;
import java.util.ArrayList;
import java.util.zip.Inflater;

public final class e {
    private static int a(int i2) {
        return (-(i2 & 1)) ^ (i2 >> 1);
    }

    public static d a(byte[] bArr, int i2) {
        ArrayList<d.a> arrayList;
        q qVar = new q(bArr);
        try {
            arrayList = a(qVar) ? b(qVar) : c(qVar);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new d(arrayList.get(0), i2);
        }
        if (size != 2) {
            return null;
        }
        return new d(arrayList.get(0), arrayList.get(1), i2);
    }

    private static boolean a(q qVar) {
        qVar.d(4);
        int p2 = qVar.p();
        qVar.c(0);
        return p2 == 1886547818;
    }

    private static ArrayList<d.a> b(q qVar) {
        int p2;
        qVar.d(8);
        int d2 = qVar.d();
        int c2 = qVar.c();
        while (d2 < c2 && (p2 = qVar.p() + d2) > d2 && p2 <= c2) {
            int p3 = qVar.p();
            if (p3 == 2037673328 || p3 == 1836279920) {
                qVar.b(p2);
                return c(qVar);
            }
            qVar.c(p2);
            d2 = p2;
        }
        return null;
    }

    private static ArrayList<d.a> c(q qVar) {
        if (qVar.h() != 0) {
            return null;
        }
        qVar.d(7);
        int p2 = qVar.p();
        if (p2 == 1684433976) {
            q qVar2 = new q();
            Inflater inflater = new Inflater(true);
            try {
                if (!ad.a(qVar, qVar2, inflater)) {
                    return null;
                }
                qVar = qVar2;
            } finally {
                inflater.end();
            }
        } else if (p2 != 1918990112) {
            return null;
        }
        return d(qVar);
    }

    private static ArrayList<d.a> d(q qVar) {
        ArrayList<d.a> arrayList = new ArrayList<>();
        int d2 = qVar.d();
        int c2 = qVar.c();
        while (d2 < c2) {
            int p2 = qVar.p() + d2;
            if (p2 <= d2 || p2 > c2) {
                return null;
            }
            if (qVar.p() == 1835365224) {
                d.a e2 = e(qVar);
                if (e2 == null) {
                    return null;
                }
                arrayList.add(e2);
            }
            qVar.c(p2);
            d2 = p2;
        }
        return arrayList;
    }

    private static d.a e(q qVar) {
        int p2 = qVar.p();
        if (p2 > 10000) {
            return null;
        }
        float[] fArr = new float[p2];
        for (int i2 = 0; i2 < p2; i2++) {
            fArr[i2] = qVar.y();
        }
        int p3 = qVar.p();
        if (p3 > 32000) {
            return null;
        }
        double d2 = 2.0d;
        double log = Math.log(2.0d);
        double d3 = (double) p2;
        Double.isNaN(d3);
        int ceil = (int) Math.ceil(Math.log(d3 * 2.0d) / log);
        p pVar = new p(qVar.f17159a);
        int i3 = 8;
        pVar.a(qVar.d() * 8);
        float[] fArr2 = new float[(p3 * 5)];
        int i4 = 5;
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < p3) {
            int i7 = 0;
            while (i7 < i4) {
                int a2 = iArr[i7] + a(pVar.c(ceil));
                if (a2 >= p2 || a2 < 0) {
                    return null;
                }
                fArr2[i6] = fArr[a2];
                iArr[i7] = a2;
                i7++;
                i6++;
                i4 = 5;
            }
            i5++;
            i4 = 5;
        }
        pVar.a((pVar.b() + 7) & -8);
        int i8 = 32;
        int c2 = pVar.c(32);
        d.b[] bVarArr = new d.b[c2];
        int i9 = 0;
        while (i9 < c2) {
            int c3 = pVar.c(i3);
            int c4 = pVar.c(i3);
            int c5 = pVar.c(i8);
            if (c5 > 128000) {
                return null;
            }
            int i10 = c3;
            double d4 = (double) p3;
            Double.isNaN(d4);
            int ceil2 = (int) Math.ceil(Math.log(d4 * d2) / log);
            float[] fArr3 = new float[(c5 * 3)];
            float[] fArr4 = new float[(c5 * 2)];
            int i11 = 0;
            for (int i12 = 0; i12 < c5; i12++) {
                i11 += a(pVar.c(ceil2));
                if (i11 < 0 || i11 >= p3) {
                    return null;
                }
                int i13 = i12 * 3;
                int i14 = i11 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i12 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
            }
            bVarArr[i9] = new d.b(i10, fArr3, fArr4, c4);
            i9++;
            i8 = 32;
            d2 = 2.0d;
            i3 = 8;
        }
        return new d.a(bVarArr);
    }
}
