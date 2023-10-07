package og;

import org.jcodec.common.model.b;

public class i implements f {

    /* renamed from: a  reason: collision with root package name */
    private final int f31741a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31742b;

    public i(int i2, int i3) {
        this.f31742b = i2;
        this.f31741a = i3;
    }

    public final void a(b bVar, b bVar2) {
        b bVar3 = bVar;
        int[] a2 = bVar3.a(0);
        int i2 = 1;
        int[] a3 = bVar3.a(1);
        int[] a4 = bVar3.a(2);
        int[] a5 = bVar2.a(0);
        int a6 = bVar2.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < (bVar2.b() >> i2)) {
            int i6 = 0;
            while (i6 < (bVar2.a() >> i2)) {
                int i7 = (i6 << 1) + i4;
                int i8 = a2[i7];
                int i9 = this.f31742b;
                int i10 = this.f31741a;
                m.a((i8 << i9) >> i10, (a3[i5] << i9) >> i10, (a4[i5] << i9) >> i10, a5, i7 * 3);
                int i11 = i7 + 1;
                int i12 = a2[i11];
                int i13 = this.f31742b;
                int i14 = this.f31741a;
                m.a((i12 << i13) >> i14, (a3[i5] << i13) >> i14, (a4[i5] << i13) >> i14, a5, i11 * 3);
                int i15 = i7 + a6;
                int i16 = a2[i15];
                int i17 = this.f31742b;
                int i18 = this.f31741a;
                m.a((i16 << i17) >> i18, (a3[i5] << i17) >> i18, (a4[i5] << i17) >> i18, a5, i15 * 3);
                int i19 = i15 + 1;
                int i20 = a2[i19];
                int i21 = this.f31742b;
                int i22 = this.f31741a;
                m.a((i20 << i21) >> i22, (a3[i5] << i21) >> i22, (a4[i5] << i21) >> i22, a5, i19 * 3);
                i5++;
                i6++;
                b bVar4 = bVar2;
                i2 = 1;
            }
            if ((bVar2.a() & 1) != 0) {
                int a7 = (bVar2.a() - 1) + i4;
                int i23 = a2[a7];
                int i24 = this.f31742b;
                int i25 = this.f31741a;
                m.a((i23 << i24) >> i25, (a3[i5] << i24) >> i25, (a4[i5] << i24) >> i25, a5, a7 * 3);
                int i26 = a7 + a6;
                int i27 = a2[i26];
                int i28 = this.f31742b;
                int i29 = this.f31741a;
                m.a((i27 << i28) >> i29, (a3[i5] << i28) >> i29, (a4[i5] << i28) >> i29, a5, i26 * 3);
                i5++;
            }
            i4 += a6 * 2;
            i3++;
            b bVar5 = bVar2;
            i2 = 1;
        }
        if ((bVar2.b() & 1) != 0) {
            int i30 = 0;
            for (int i31 = 1; i30 < (bVar2.a() >> i31); i31 = 1) {
                int i32 = (i30 << 1) + i4;
                int i33 = a2[i32];
                int i34 = this.f31742b;
                int i35 = this.f31741a;
                m.a((i33 << i34) >> i35, (a3[i5] << i34) >> i35, (a4[i5] << i34) >> i35, a5, i32 * 3);
                int i36 = i32 + 1;
                int i37 = a2[i36];
                int i38 = this.f31742b;
                int i39 = this.f31741a;
                m.a((i37 << i38) >> i39, (a3[i5] << i38) >> i39, (a4[i5] << i38) >> i39, a5, i36 * 3);
                i5++;
                i30++;
            }
            if ((bVar2.a() & 1) != 0) {
                int a8 = i4 + (bVar2.a() - 1);
                int i40 = a2[a8];
                int i41 = this.f31742b;
                int i42 = this.f31741a;
                m.a((i40 << i41) >> i42, (a3[i5] << i41) >> i42, (a4[i5] << i41) >> i42, a5, a8 * 3);
            }
        }
    }
}
