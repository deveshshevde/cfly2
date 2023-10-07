package org.apache.commons.math3.linear;

import fg.i;
import java.lang.reflect.Array;
import java.util.Arrays;
import nl.b;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final double[][] f32746a;

    /* renamed from: b  reason: collision with root package name */
    private final double[] f32747b;

    /* renamed from: c  reason: collision with root package name */
    private final double[] f32748c;

    /* renamed from: d  reason: collision with root package name */
    private h f32749d;

    /* renamed from: e  reason: collision with root package name */
    private h f32750e;

    /* renamed from: f  reason: collision with root package name */
    private h f32751f;

    public m(h hVar) {
        if (hVar.c()) {
            int d2 = hVar.d();
            this.f32746a = hVar.a();
            this.f32747b = new double[d2];
            this.f32748c = new double[(d2 - 1)];
            this.f32749d = null;
            this.f32750e = null;
            this.f32751f = null;
            e();
            return;
        }
        throw new NonSquareMatrixException(hVar.d(), hVar.e());
    }

    private void e() {
        int length = this.f32746a.length;
        double[] dArr = new double[length];
        int i2 = 0;
        while (true) {
            int i3 = length - 1;
            if (i2 < i3) {
                double[] dArr2 = this.f32746a[i2];
                this.f32747b[i2] = dArr2[i2];
                int i4 = i2 + 1;
                double d2 = 0.0d;
                for (int i5 = i4; i5 < length; i5++) {
                    double d3 = dArr2[i5];
                    d2 += d3 * d3;
                }
                double a2 = dArr2[i4] > i.f27244a ? -b.a(d2) : b.a(d2);
                this.f32748c[i2] = a2;
                if (a2 != i.f27244a) {
                    dArr2[i4] = dArr2[i4] - a2;
                    double d4 = -1.0d / (a2 * dArr2[i4]);
                    Arrays.fill(dArr, i4, length, i.f27244a);
                    int i6 = i4;
                    while (i6 < length) {
                        double[] dArr3 = this.f32746a[i6];
                        double d5 = dArr2[i6];
                        double d6 = dArr3[i6] * d5;
                        int i7 = i6 + 1;
                        for (int i8 = i7; i8 < length; i8++) {
                            double d7 = dArr3[i8];
                            d6 += dArr2[i8] * d7;
                            dArr[i8] = dArr[i8] + (d7 * d5);
                        }
                        dArr[i6] = (dArr[i6] + d6) * d4;
                        i6 = i7;
                    }
                    double d8 = i.f27244a;
                    for (int i9 = i4; i9 < length; i9++) {
                        d8 += dArr[i9] * dArr2[i9];
                    }
                    double d9 = d8 * (d4 / 2.0d);
                    for (int i10 = i4; i10 < length; i10++) {
                        dArr[i10] = dArr[i10] - (dArr2[i10] * d9);
                    }
                    for (int i11 = i4; i11 < length; i11++) {
                        double[] dArr4 = this.f32746a[i11];
                        for (int i12 = i11; i12 < length; i12++) {
                            dArr4[i12] = dArr4[i12] - ((dArr2[i11] * dArr[i12]) + (dArr[i11] * dArr2[i12]));
                        }
                    }
                }
                i2 = i4;
            } else {
                this.f32747b[i3] = this.f32746a[i3][i3];
                return;
            }
        }
    }

    public h a() {
        if (this.f32749d == null) {
            this.f32749d = b().b();
        }
        return this.f32749d;
    }

    public h b() {
        if (this.f32750e == null) {
            int length = this.f32746a.length;
            int[] iArr = new int[2];
            iArr[1] = length;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
            for (int i2 = length - 1; i2 >= 1; i2--) {
                int i3 = i2 - 1;
                double[] dArr2 = this.f32746a[i3];
                dArr[i2][i2] = 1.0d;
                if (dArr2[i2] != i.f27244a) {
                    double[] dArr3 = this.f32748c;
                    double d2 = 1.0d / (dArr3[i3] * dArr2[i2]);
                    double d3 = 1.0d / dArr3[i3];
                    dArr[i2][i2] = (dArr2[i2] * d3) + 1.0d;
                    int i4 = i2 + 1;
                    for (int i5 = i4; i5 < length; i5++) {
                        dArr[i2][i5] = dArr2[i5] * d3;
                    }
                    for (int i6 = i4; i6 < length; i6++) {
                        double d4 = 0.0d;
                        for (int i7 = i4; i7 < length; i7++) {
                            d4 += dArr[i6][i7] * dArr2[i7];
                        }
                        double d5 = d4 * d2;
                        dArr[i6][i2] = dArr2[i2] * d5;
                        for (int i8 = i4; i8 < length; i8++) {
                            double[] dArr4 = dArr[i6];
                            dArr4[i8] = dArr4[i8] + (dArr2[i8] * d5);
                        }
                    }
                }
            }
            dArr[0][0] = 1.0d;
            this.f32750e = f.a(dArr);
        }
        return this.f32750e;
    }

    /* access modifiers changed from: package-private */
    public double[] c() {
        return this.f32747b;
    }

    /* access modifiers changed from: package-private */
    public double[] d() {
        return this.f32748c;
    }
}
