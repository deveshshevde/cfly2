package og;

import org.jcodec.common.model.b;

public class j implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31743a;

    /* renamed from: b  reason: collision with root package name */
    private int f31744b;

    public j(int i2, int i3) {
        this.f31743a = i2;
        this.f31744b = i3;
    }

    private static void a(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, int i6) {
        int length = iArr.length / i2;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = 0;
            while (i10 < i2) {
                iArr2[i7] = (iArr[i8] & 255) << 2;
                i10++;
                i7++;
                i8++;
            }
            int i11 = i2;
            while (i11 < i3) {
                iArr2[i7] = iArr2[i2 - 1];
                i11++;
                i7++;
            }
        }
        int i12 = (length - 1) * i3;
        while (length < i4) {
            int i13 = 0;
            while (i13 < i3) {
                iArr2[i7] = iArr2[i12 + i13];
                i13++;
                i7++;
            }
            length++;
        }
    }

    private static final void a(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = i2 + (i3 * i7);
        int i13 = 0;
        for (int i14 = 0; i14 < i8; i14++) {
            int i15 = 0;
            while (i15 < i6) {
                iArr2[i12] = (iArr[i13] & 255) << 2;
                i12 += i4;
                i15++;
                i13++;
            }
            int i16 = i12 - i4;
            int i17 = i6 * i4;
            while (i17 < i7) {
                iArr2[i12] = iArr2[i16];
                i12 += i4;
                i17 += i4;
            }
            i12 += (i5 - 1) * i7;
        }
        int i18 = i12 - (i5 * i7);
        int i19 = i8 * i5;
        while (i19 < i9) {
            int i20 = 0;
            while (i20 < i7) {
                iArr2[i12] = iArr2[i18 + i20];
                i12 += i4;
                i20 += i4;
            }
            i12 += (i5 - 1) * i7;
            i19 += i5;
        }
    }

    public void a(b bVar, b bVar2) {
        b bVar3 = bVar;
        b bVar4 = bVar2;
        a(bVar3.a(0), bVar4.a(0), bVar.a(), bVar2.a(), bVar2.b(), this.f31743a, this.f31744b);
        a(bVar3.a(1), bVar4.a(1), 0, 0, 1, 2, bVar.a() >> 1, bVar2.a() >> 1, bVar.b() >> 1, bVar2.b(), this.f31743a, this.f31744b);
        a(bVar3.a(1), bVar4.a(1), 0, 1, 1, 2, bVar.a() >> 1, bVar2.a() >> 1, bVar.b() >> 1, bVar2.b(), this.f31743a, this.f31744b);
        a(bVar3.a(2), bVar4.a(2), 0, 0, 1, 2, bVar.a() >> 1, bVar2.a() >> 1, bVar.b() >> 1, bVar2.b(), this.f31743a, this.f31744b);
        a(bVar3.a(2), bVar4.a(2), 0, 1, 1, 2, bVar.a() >> 1, bVar2.a() >> 1, bVar.b() >> 1, bVar2.b(), this.f31743a, this.f31744b);
    }
}
