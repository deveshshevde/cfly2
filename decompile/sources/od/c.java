package od;

import org.jcodec.common.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private int[] f31676a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f31677b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f31678c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f31679d;

    public c(int[] iArr, int[] iArr2) {
        this.f31676a = iArr;
        this.f31677b = iArr2;
        a();
    }

    private int a(int i2, int i3, int i4, d dVar, d dVar2) {
        int i5 = i2 + 256;
        dVar.a(i2, i5, -1);
        dVar2.a(i2, i5, 0);
        int i6 = i3 << 3;
        int i7 = i5;
        int i8 = 0;
        while (true) {
            int[] iArr = this.f31677b;
            if (i8 >= iArr.length) {
                return i7;
            }
            if (iArr[i8] > i6 && (i3 <= 0 || (this.f31676a[i8] >>> (32 - i6)) == i4)) {
                int i9 = this.f31676a[i8] >>> ((32 - i6) - 8);
                int i10 = i9 & 255;
                int i11 = iArr[i8] - i6;
                if (i11 <= 8) {
                    for (int i12 = 0; i12 < (1 << (8 - i11)); i12++) {
                        int i13 = i2 + i10 + i12;
                        dVar.a(i13, i8);
                        dVar2.a(i13, i11);
                    }
                } else {
                    int i14 = i10 + i2;
                    if (dVar.c(i14) == -1) {
                        dVar.a(i14, i7);
                        i7 = a(i7, i3 + 1, i9, dVar, dVar2);
                    }
                }
            }
            i8++;
        }
    }

    private void a() {
        d dVar = new d();
        d dVar2 = new d();
        a(0, 0, 0, dVar, dVar2);
        this.f31678c = dVar.a();
        this.f31679d = dVar2.a();
    }

    public void a(b bVar, int i2) {
        int i3 = this.f31676a[i2];
        int[] iArr = this.f31677b;
        bVar.a(i3 >>> (32 - iArr[i2]), iArr[i2]);
    }
}
