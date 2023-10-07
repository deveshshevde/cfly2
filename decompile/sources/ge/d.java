package ge;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final a f28475a;

    /* renamed from: b  reason: collision with root package name */
    public final a f28476b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28477c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28478d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b[] f28479a;

        public a(b... bVarArr) {
            this.f28479a = bVarArr;
        }

        public int a() {
            return this.f28479a.length;
        }

        public b a(int i2) {
            return this.f28479a[i2];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28480a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28481b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f28482c;

        /* renamed from: d  reason: collision with root package name */
        public final float[] f28483d;

        public b(int i2, float[] fArr, float[] fArr2, int i3) {
            this.f28480a = i2;
            com.google.android.exoplayer2.util.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f28482c = fArr;
            this.f28483d = fArr2;
            this.f28481b = i3;
        }

        public int a() {
            return this.f28482c.length / 3;
        }
    }

    public d(a aVar, int i2) {
        this(aVar, aVar, i2);
    }

    public d(a aVar, a aVar2, int i2) {
        this.f28475a = aVar;
        this.f28476b = aVar2;
        this.f28477c = i2;
        this.f28478d = aVar == aVar2;
    }

    public static d a(float f2, int i2, int i3, float f3, float f4, int i4) {
        int i5;
        float f5;
        float[] fArr;
        int i6;
        int i7;
        int i8;
        float f6 = f2;
        int i9 = i2;
        int i10 = i3;
        float f7 = f3;
        float f8 = f4;
        com.google.android.exoplayer2.util.a.a(f6 > 0.0f);
        com.google.android.exoplayer2.util.a.a(i9 >= 1);
        com.google.android.exoplayer2.util.a.a(i10 >= 1);
        com.google.android.exoplayer2.util.a.a(f7 > 0.0f && f7 <= 180.0f);
        com.google.android.exoplayer2.util.a.a(f8 > 0.0f && f8 <= 360.0f);
        float radians = (float) Math.toRadians((double) f7);
        float radians2 = (float) Math.toRadians((double) f8);
        float f9 = radians / ((float) i9);
        float f10 = radians2 / ((float) i10);
        int i11 = i10 + 1;
        int i12 = ((i11 * 2) + 2) * i9;
        float[] fArr2 = new float[(i12 * 3)];
        float[] fArr3 = new float[(i12 * 2)];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i9) {
            float f11 = radians / 2.0f;
            float f12 = (((float) i13) * f9) - f11;
            int i16 = i13 + 1;
            float f13 = (((float) i16) * f9) - f11;
            int i17 = 0;
            while (i17 < i11) {
                float f14 = f12;
                int i18 = i16;
                int i19 = 0;
                while (i19 < 2) {
                    if (i19 == 0) {
                        f5 = f14;
                        i5 = i11;
                    } else {
                        i5 = i11;
                        f5 = f13;
                    }
                    float f15 = ((float) i17) * f10;
                    float f16 = f10;
                    int i20 = i14 + 1;
                    int i21 = i17;
                    double d2 = (double) f6;
                    float f17 = f9;
                    int i22 = i19;
                    double d3 = (double) ((f15 + 3.1415927f) - (radians2 / 2.0f));
                    double sin = Math.sin(d3);
                    Double.isNaN(d2);
                    double d4 = (double) f5;
                    float[] fArr4 = fArr3;
                    float f18 = f13;
                    fArr2[i14] = -((float) (sin * d2 * Math.cos(d4)));
                    int i23 = i20 + 1;
                    double sin2 = Math.sin(d4);
                    Double.isNaN(d2);
                    int i24 = i13;
                    fArr2[i20] = (float) (d2 * sin2);
                    int i25 = i23 + 1;
                    double cos = Math.cos(d3);
                    Double.isNaN(d2);
                    fArr2[i23] = (float) (d2 * cos * Math.cos(d4));
                    int i26 = i15 + 1;
                    fArr4[i15] = f15 / radians2;
                    int i27 = i26 + 1;
                    fArr4[i26] = (((float) (i24 + i22)) * f17) / radians;
                    if (i21 == 0 && i22 == 0) {
                        i8 = i3;
                        i7 = i21;
                        i6 = i22;
                    } else {
                        i8 = i3;
                        i7 = i21;
                        i6 = i22;
                        if (!(i7 == i8 && i6 == 1)) {
                            fArr = fArr4;
                            i15 = i27;
                            i14 = i25;
                            i19 = i6 + 1;
                            i10 = i8;
                            i17 = i7;
                            fArr3 = fArr;
                            i13 = i24;
                            i11 = i5;
                            f10 = f16;
                            f9 = f17;
                            f13 = f18;
                        }
                    }
                    System.arraycopy(fArr2, i25 - 3, fArr2, i25, 3);
                    i25 += 3;
                    fArr = fArr4;
                    System.arraycopy(fArr, i27 - 2, fArr, i27, 2);
                    i27 += 2;
                    i15 = i27;
                    i14 = i25;
                    i19 = i6 + 1;
                    i10 = i8;
                    i17 = i7;
                    fArr3 = fArr;
                    i13 = i24;
                    i11 = i5;
                    f10 = f16;
                    f9 = f17;
                    f13 = f18;
                }
                float f19 = f9;
                float f20 = f10;
                float[] fArr5 = fArr3;
                float f21 = f13;
                int i28 = i13;
                int i29 = i17;
                int i30 = i10;
                int i31 = i29 + 1;
                f12 = f14;
                i16 = i18;
                i11 = i11;
                f10 = f20;
                f9 = f19;
                f13 = f21;
                int i32 = i31;
                i10 = i30;
                i17 = i32;
            }
            i9 = i2;
            i13 = i16;
        }
        return new d(new a(new b(0, fArr2, fArr3, 1)), i4);
    }

    public static d a(int i2) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i2);
    }
}
