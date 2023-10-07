package og;

import org.jcodec.common.model.b;

public class r implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31755a;

    /* renamed from: b  reason: collision with root package name */
    private int f31756b;

    public r(int i2, int i3) {
        this.f31755a = i2;
        this.f31756b = i3;
    }

    private static int a(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    public static final void a(int i2, int i3, int i4, int[] iArr, int i5) {
        int i6 = i3 - 128;
        int i7 = i4 - 128;
        int i8 = (i2 - 16) * 298;
        iArr[i5] = a(((i8 + (i6 * 516)) + 128) >> 8);
        iArr[i5 + 1] = a((((i8 - (i6 * 100)) - (i7 * 208)) + 128) >> 8);
        iArr[i5 + 2] = a((((i7 * 409) + i8) + 128) >> 8);
    }

    public void a(b bVar, b bVar2) {
        int[] a2 = bVar.a(0);
        int[] a3 = bVar.a(1);
        int[] a4 = bVar.a(2);
        int[] a5 = bVar2.a(0);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bVar2.b(); i4++) {
            int i5 = 0;
            while (i5 < bVar2.a()) {
                int i6 = a2[i2];
                int i7 = this.f31756b;
                int i8 = this.f31755a;
                a((i6 << i7) >> i8, (a3[i2] << i7) >> i8, (a4[i2] << i7) >> i8, a5, i3);
                i5++;
                i2++;
                i3 += 3;
            }
        }
    }
}
