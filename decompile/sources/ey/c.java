package ey;

import com.github.mikephil.charting.data.BarEntry;
import fc.a;

public class c extends b {
    public c(int i2, int i3, boolean z2) {
        super(i2, i3, z2);
    }

    public void a(a aVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float u2 = ((float) aVar.u()) * this.f26996c;
        float f6 = this.f27004k / 2.0f;
        for (int i2 = 0; ((float) i2) < u2; i2++) {
            BarEntry barEntry = (BarEntry) aVar.d(i2);
            if (barEntry != null) {
                float i3 = barEntry.i();
                float b2 = barEntry.b();
                float[] a2 = barEntry.a();
                if (!this.f27002i || a2 == null) {
                    float f7 = i3 - f6;
                    float f8 = i3 + f6;
                    if (this.f27003j) {
                        f2 = b2 >= 0.0f ? b2 : 0.0f;
                        if (b2 > 0.0f) {
                            b2 = 0.0f;
                        }
                    } else {
                        float f9 = b2 >= 0.0f ? b2 : 0.0f;
                        if (b2 > 0.0f) {
                            b2 = 0.0f;
                        }
                        float f10 = b2;
                        b2 = f9;
                        f2 = f10;
                    }
                    if (b2 > 0.0f) {
                        b2 *= this.f26997d;
                    } else {
                        f2 *= this.f26997d;
                    }
                    a(f2, f8, b2, f7);
                } else {
                    float f11 = -barEntry.f();
                    int i4 = 0;
                    float f12 = 0.0f;
                    while (i4 < a2.length) {
                        float f13 = a2[i4];
                        if (f13 >= 0.0f) {
                            f3 = f13 + f12;
                            f4 = f11;
                            f11 = f12;
                            f12 = f3;
                        } else {
                            f3 = Math.abs(f13) + f11;
                            f4 = Math.abs(f13) + f11;
                        }
                        float f14 = i3 - f6;
                        float f15 = i3 + f6;
                        if (this.f27003j) {
                            f5 = f11 >= f3 ? f11 : f3;
                            if (f11 > f3) {
                                f11 = f3;
                            }
                        } else {
                            float f16 = f11 >= f3 ? f11 : f3;
                            if (f11 > f3) {
                                f11 = f3;
                            }
                            float f17 = f11;
                            f11 = f16;
                            f5 = f17;
                        }
                        a(f5 * this.f26997d, f15, f11 * this.f26997d, f14);
                        i4++;
                        f11 = f4;
                    }
                }
            }
        }
        a();
    }
}
