package og;

import org.jcodec.common.model.b;

public class n implements f {

    /* renamed from: a  reason: collision with root package name */
    public static int f31748a = 9362;

    /* renamed from: b  reason: collision with root package name */
    private int f31749b;

    /* renamed from: c  reason: collision with root package name */
    private int f31750c;

    /* renamed from: d  reason: collision with root package name */
    private int f31751d;

    public n(int i2, int i3) {
        int i4 = i3 + 13;
        int i5 = i4 - i2;
        this.f31749b = i5;
        if (i5 >= 0) {
            this.f31750c = 128 << Math.max(i3 - i2, 0);
            this.f31751d = 128 << Math.max(i2 - i3, 0);
            return;
        }
        throw new IllegalArgumentException("Maximum upshift allowed: " + i4);
    }

    private void a(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3 / 2; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                int i8 = iArr[i4];
                int i9 = this.f31750c;
                int i10 = f31748a;
                int i11 = this.f31749b;
                int i12 = this.f31751d;
                iArr2[i5] = ((((((i8 - i9) * i10) >> i11) + i12) + ((((iArr[i4 + i2] - i9) * i10) >> i11) + i12)) + 1) >> 1;
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
            a3[i2] = ((a2[i2] - 16) * f31748a) >> this.f31749b;
        }
        a(bVar.a(1), bVar2.a(1), bVar.b(1), bVar.c(1));
        a(bVar.a(2), bVar2.a(2), bVar.b(2), bVar.c(2));
    }
}
