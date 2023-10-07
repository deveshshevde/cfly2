package og;

import org.jcodec.common.model.b;

public class m implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31746a;

    /* renamed from: b  reason: collision with root package name */
    private int f31747b;

    public m(int i2, int i3) {
        this.f31746a = i2;
        this.f31747b = i3;
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
        b bVar3 = bVar;
        int[] a2 = bVar3.a(0);
        int[] a3 = bVar3.a(1);
        int[] a4 = bVar3.a(2);
        int[] a5 = bVar2.a(0);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bVar2.b(); i4++) {
            for (int i5 = 0; i5 < bVar2.a(); i5 += 2) {
                int i6 = a2[i2];
                int i7 = this.f31747b;
                int i8 = this.f31746a;
                a((i6 << i7) >> i8, (a3[i3] << i7) >> i8, (a4[i3] << i7) >> i8, a5, i2 * 3);
                int i9 = i2 + 1;
                int i10 = a2[i9];
                int i11 = this.f31747b;
                int i12 = this.f31746a;
                a((i10 << i11) >> i12, (a3[i3] << i11) >> i12, (a4[i3] << i11) >> i12, a5, i9 * 3);
                i2 += 2;
                i3++;
            }
        }
    }
}
