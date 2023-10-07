package og;

import org.jcodec.common.model.b;

public class o implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31752a;

    /* renamed from: b  reason: collision with root package name */
    private int f31753b;

    public o(int i2, int i3) {
        this.f31752a = i2;
        this.f31753b = i3;
    }

    private void a(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = iArr[i3] >> i2;
        }
    }

    private void a(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3 / 2; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                iArr2[i5] = ((iArr[i4] + iArr[i4 + i2]) + 1) >> 1;
                i7++;
                i5++;
                i4++;
            }
            i4 += i2;
        }
    }

    private void b(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = iArr[i3] << i2;
        }
    }

    public void a(b bVar, b bVar2) {
        System.arraycopy(bVar.a(0), 0, bVar2.a(0), 0, bVar.a() * bVar.b());
        a(bVar.a(1), bVar2.a(1), bVar.b(1), bVar.c(1));
        a(bVar.a(2), bVar2.a(2), bVar.b(2), bVar.c(2));
        int i2 = this.f31752a;
        int i3 = this.f31753b;
        if (i2 > i3) {
            b(bVar2.a(0), this.f31752a - this.f31753b);
            b(bVar2.a(1), this.f31752a - this.f31753b);
            b(bVar2.a(2), this.f31752a - this.f31753b);
        } else if (i3 > i2) {
            a(bVar2.a(0), this.f31753b - this.f31752a);
            a(bVar2.a(1), this.f31753b - this.f31752a);
            a(bVar2.a(2), this.f31753b - this.f31752a);
        }
    }
}
