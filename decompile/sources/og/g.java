package og;

import org.jcodec.common.tools.b;

public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31736a = a(0.71414d);

    /* renamed from: b  reason: collision with root package name */
    private static final int f31737b = a(1.772d);

    /* renamed from: c  reason: collision with root package name */
    private static final int f31738c = (-a(0.34414d));

    /* renamed from: d  reason: collision with root package name */
    private static final int f31739d = a(1.402d);

    private static final int a(double d2) {
        return (int) ((d2 * 1024.0d) + 0.5d);
    }

    public static final void a(int i2, int i3, int i4, int[] iArr, int i5) {
        int i6 = i2 << 10;
        int i7 = i3 - 128;
        int i8 = i4 - 128;
        int i9 = (((f31739d * i8) + 512) + i6) >> 10;
        iArr[i5] = b.a((i6 + ((f31737b * i7) + 512)) >> 10, 0, 255);
        iArr[i5 + 1] = b.a(((((f31738c * i7) - (f31736a * i8)) + 512) + i6) >> 10, 0, 255);
        iArr[i5 + 2] = b.a(i9, 0, 255);
    }

    public final void a(org.jcodec.common.model.b bVar, org.jcodec.common.model.b bVar2) {
        org.jcodec.common.model.b bVar3 = bVar;
        int[] a2 = bVar3.a(0);
        int[] a3 = bVar3.a(1);
        int[] a4 = bVar3.a(2);
        int[] a5 = bVar2.a(0);
        int a6 = bVar2.a();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < (bVar2.b() >> 1); i4++) {
            for (int i5 = 0; i5 < (bVar2.a() >> 1); i5++) {
                int i6 = (i5 << 1) + i2;
                a(a2[i6], a3[i3], a4[i3], a5, i6 * 3);
                int i7 = i6 + 1;
                a(a2[i7], a3[i3], a4[i3], a5, i7 * 3);
                int i8 = i6 + a6;
                a(a2[i8], a3[i3], a4[i3], a5, i8 * 3);
                int i9 = i8 + 1;
                a(a2[i9], a3[i3], a4[i3], a5, i9 * 3);
                i3++;
            }
            if ((bVar2.a() & 1) != 0) {
                int a7 = (bVar2.a() - 1) + i2;
                a(a2[a7], a3[i3], a4[i3], a5, a7 * 3);
                int i10 = a7 + a6;
                a(a2[i10], a3[i3], a4[i3], a5, i10 * 3);
                i3++;
            }
            i2 += a6 * 2;
        }
        if ((bVar2.b() & 1) != 0) {
            for (int i11 = 0; i11 < (bVar2.a() >> 1); i11++) {
                int i12 = (i11 << 1) + i2;
                a(a2[i12], a3[i3], a4[i3], a5, i12 * 3);
                int i13 = i12 + 1;
                a(a2[i13], a3[i3], a4[i3], a5, i13 * 3);
                i3++;
            }
            if ((bVar2.a() & 1) != 0) {
                int a8 = i2 + (bVar2.a() - 1);
                a(a2[a8], a3[i3], a4[i3], a5, a8 * 3);
            }
        }
    }
}
