package ey;

import com.github.mikephil.charting.data.BarEntry;
import fc.a;

public class b extends a<a> {

    /* renamed from: g  reason: collision with root package name */
    protected int f27000g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f27001h = 1;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f27002i = false;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f27003j = false;

    /* renamed from: k  reason: collision with root package name */
    protected float f27004k = 1.0f;

    public b(int i2, int i3, boolean z2) {
        super(i2);
        this.f27001h = i3;
        this.f27002i = z2;
    }

    public void a(float f2) {
        this.f27004k = f2;
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f26995b;
        int i2 = this.f26994a;
        this.f26994a = i2 + 1;
        fArr[i2] = f2;
        float[] fArr2 = this.f26995b;
        int i3 = this.f26994a;
        this.f26994a = i3 + 1;
        fArr2[i3] = f3;
        float[] fArr3 = this.f26995b;
        int i4 = this.f26994a;
        this.f26994a = i4 + 1;
        fArr3[i4] = f4;
        float[] fArr4 = this.f26995b;
        int i5 = this.f26994a;
        this.f26994a = i5 + 1;
        fArr4[i5] = f5;
    }

    public void a(int i2) {
        this.f27000g = i2;
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
                    a(f7, b2, f8, f2);
                } else {
                    float f11 = -barEntry.f();
                    int i4 = 0;
                    float f12 = 0.0f;
                    while (i4 < a2.length) {
                        float f13 = a2[i4];
                        if (f13 == 0.0f && (f12 == 0.0f || f11 == 0.0f)) {
                            f3 = f13;
                            f4 = f11;
                            f11 = f3;
                        } else if (f13 >= 0.0f) {
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
                        a(f14, f11 * this.f26997d, f15, f5 * this.f26997d);
                        i4++;
                        f11 = f4;
                    }
                }
            }
        }
        a();
    }

    public void a(boolean z2) {
        this.f27003j = z2;
    }
}
