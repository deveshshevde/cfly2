package og;

import org.jcodec.common.model.b;

public class l implements f {

    /* renamed from: a  reason: collision with root package name */
    public static int f31745a = 7168;

    private void a(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3 / 2; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                int i8 = f31745a;
                iArr2[i5] = ((((((iArr[i4] - 128) * i8) >> 13) + 128) + ((((iArr[i4 + i2] - 128) * i8) >> 13) + 128)) + 1) >> 1;
                i7++;
                i5++;
                i4++;
            }
            i4 += i2;
        }
    }

    public void a(b bVar, b bVar2) {
        int[] a2 = bVar.a(0);
        int[] a3 = bVar2.a(0);
        for (int i2 = 0; i2 < bVar.b(0) * bVar.c(0); i2++) {
            a3[i2] = ((a2[i2] * f31745a) >> 13) + 16;
        }
        a(bVar.a(1), bVar2.a(1), bVar.b(1), bVar.c(1));
        a(bVar.a(2), bVar2.a(2), bVar.b(2), bVar.c(2));
    }
}
