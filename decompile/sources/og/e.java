package og;

import org.jcodec.common.model.b;

public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31733a;

    /* renamed from: b  reason: collision with root package name */
    private int f31734b;

    /* renamed from: c  reason: collision with root package name */
    private int f31735c;

    public e(int i2, int i3) {
        this.f31733a = i2;
        this.f31734b = i3;
        this.f31735c = i3 + 1;
    }

    public void a(b bVar, b bVar2) {
        int[] iArr = bVar.d()[0];
        int[][] d2 = bVar2.d();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bVar.b(); i4++) {
            int i5 = 0;
            while (i5 < (bVar.a() >> 1)) {
                d2[1][i2] = 0;
                d2[2][i2] = 0;
                int i6 = i2 << 1;
                int i7 = i3 + 1;
                int i8 = iArr[i3];
                int i9 = i7 + 1;
                int i10 = iArr[i7];
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                int i13 = i2;
                int i14 = i2;
                d.a(i8, i10, i12, d2[0], i6, d2[1], i13, d2[2], i14);
                d2[0][i6] = (d2[0][i6] << this.f31733a) >> this.f31734b;
                int i15 = i11 + 1;
                int i16 = iArr[i11];
                int i17 = i15 + 1;
                int i18 = i17 + 1;
                int i19 = i6 + 1;
                d.a(i16, iArr[i15], iArr[i17], d2[0], i19, d2[1], i13, d2[2], i14);
                int[] iArr2 = d2[0];
                int i20 = d2[0][i19];
                int i21 = this.f31733a;
                iArr2[i19] = (i20 << i21) >> this.f31734b;
                int[] iArr3 = d2[1];
                int i22 = this.f31735c;
                iArr3[i2] = (d2[1][i2] << i21) >> i22;
                d2[2][i2] = (d2[2][i2] << i21) >> i22;
                i2++;
                i5++;
                i3 = i18;
            }
        }
    }
}
