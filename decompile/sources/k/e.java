package k;

import fg.i;
import java.lang.reflect.Array;

public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private double[] f29921a;

    /* renamed from: b  reason: collision with root package name */
    private double[][] f29922b;

    /* renamed from: c  reason: collision with root package name */
    private double[][] f29923c;

    public e(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        Class<double> cls = double.class;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        int i2 = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i2;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr2);
        for (int i3 = 0; i3 < length2; i3++) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 1;
                dArr5[i4][i3] = (dArr4[i5][i3] - dArr4[i4][i3]) / (dArr3[i5] - dArr3[i4]);
                if (i4 == 0) {
                    dArr6[i4][i3] = dArr5[i4][i3];
                } else {
                    dArr6[i4][i3] = (dArr5[i4 - 1][i3] + dArr5[i4][i3]) * 0.5d;
                }
                i4 = i5;
            }
            dArr6[i2][i3] = dArr5[length - 2][i3];
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < length2; i7++) {
                if (dArr5[i6][i7] == i.f27244a) {
                    dArr6[i6][i7] = 0.0d;
                    dArr6[i6 + 1][i7] = 0.0d;
                } else {
                    double d2 = dArr6[i6][i7] / dArr5[i6][i7];
                    int i8 = i6 + 1;
                    double d3 = dArr6[i8][i7] / dArr5[i6][i7];
                    double hypot = Math.hypot(d2, d3);
                    if (hypot > 9.0d) {
                        double d4 = 3.0d / hypot;
                        dArr6[i6][i7] = d2 * d4 * dArr5[i6][i7];
                        dArr6[i8][i7] = d4 * d3 * dArr5[i6][i7];
                    }
                }
            }
        }
        this.f29921a = dArr3;
        this.f29922b = dArr4;
        this.f29923c = dArr6;
    }

    private static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d8 * d3;
        double d10 = 3.0d * d8;
        double d11 = d2 * d7;
        double d12 = d2 * d6;
        return ((((((((((-2.0d * d9) * d5) + (d10 * d5)) + ((d9 * 2.0d) * d4)) - (d10 * d4)) + d4) + (d11 * d9)) + (d9 * d12)) - (d11 * d8)) - (((d2 * 2.0d) * d6) * d8)) + (d12 * d3);
    }

    private static double b(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d3 * 6.0d;
        double d10 = 3.0d * d2;
        return (((((((((-6.0d * d8) * d5) + (d9 * d5)) + ((6.0d * d8) * d4)) - (d9 * d4)) + ((d10 * d7) * d8)) + ((d10 * d6) * d8)) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3)) + (d2 * d6);
    }

    public double a(double d2, int i2) {
        double[] dArr = this.f29921a;
        int length = dArr.length;
        int i3 = 0;
        if (d2 <= dArr[0]) {
            return this.f29922b[0][i2];
        }
        int i4 = length - 1;
        if (d2 >= dArr[i4]) {
            return this.f29922b[i4][i2];
        }
        while (i3 < i4) {
            double[] dArr2 = this.f29921a;
            if (d2 == dArr2[i3]) {
                return this.f29922b[i3][i2];
            }
            int i5 = i3 + 1;
            if (d2 < dArr2[i5]) {
                double d3 = dArr2[i5] - dArr2[i3];
                double d4 = (d2 - dArr2[i3]) / d3;
                double[][] dArr3 = this.f29922b;
                double d5 = dArr3[i3][i2];
                double d6 = dArr3[i5][i2];
                double[][] dArr4 = this.f29923c;
                return a(d3, d4, d5, d6, dArr4[i3][i2], dArr4[i5][i2]);
            }
            i3 = i5;
        }
        return i.f27244a;
    }

    public void a(double d2, double[] dArr) {
        double[] dArr2 = this.f29921a;
        int length = dArr2.length;
        int i2 = 0;
        int length2 = this.f29922b[0].length;
        if (d2 <= dArr2[0]) {
            for (int i3 = 0; i3 < length2; i3++) {
                dArr[i3] = this.f29922b[0][i3];
            }
            return;
        }
        int i4 = length - 1;
        if (d2 >= dArr2[i4]) {
            while (i2 < length2) {
                dArr[i2] = this.f29922b[i4][i2];
                i2++;
            }
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            if (d2 == this.f29921a[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.f29922b[i5][i6];
                }
            }
            double[] dArr3 = this.f29921a;
            int i7 = i5 + 1;
            if (d2 < dArr3[i7]) {
                double d3 = dArr3[i7] - dArr3[i5];
                double d4 = (d2 - dArr3[i5]) / d3;
                while (i2 < length2) {
                    double[][] dArr4 = this.f29922b;
                    double d5 = dArr4[i5][i2];
                    double d6 = dArr4[i7][i2];
                    double[][] dArr5 = this.f29923c;
                    dArr[i2] = a(d3, d4, d5, d6, dArr5[i5][i2], dArr5[i7][i2]);
                    i2++;
                }
                return;
            }
            i5 = i7;
        }
    }

    public void a(double d2, float[] fArr) {
        double[] dArr = this.f29921a;
        int length = dArr.length;
        int i2 = 0;
        int length2 = this.f29922b[0].length;
        if (d2 <= dArr[0]) {
            for (int i3 = 0; i3 < length2; i3++) {
                fArr[i3] = (float) this.f29922b[0][i3];
            }
            return;
        }
        int i4 = length - 1;
        if (d2 >= dArr[i4]) {
            while (i2 < length2) {
                fArr[i2] = (float) this.f29922b[i4][i2];
                i2++;
            }
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            if (d2 == this.f29921a[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) this.f29922b[i5][i6];
                }
            }
            double[] dArr2 = this.f29921a;
            int i7 = i5 + 1;
            if (d2 < dArr2[i7]) {
                double d3 = dArr2[i7] - dArr2[i5];
                double d4 = (d2 - dArr2[i5]) / d3;
                while (i2 < length2) {
                    double[][] dArr3 = this.f29922b;
                    double d5 = dArr3[i5][i2];
                    double d6 = dArr3[i7][i2];
                    double[][] dArr4 = this.f29923c;
                    fArr[i2] = (float) a(d3, d4, d5, d6, dArr4[i5][i2], dArr4[i7][i2]);
                    i2++;
                }
                return;
            }
            i5 = i7;
        }
    }

    public double[] a() {
        return this.f29921a;
    }

    public double b(double d2, int i2) {
        double d3;
        double[] dArr = this.f29921a;
        int length = dArr.length;
        int i3 = 0;
        if (d2 < dArr[0]) {
            d3 = dArr[0];
        } else {
            int i4 = length - 1;
            d3 = d2 >= dArr[i4] ? dArr[i4] : d2;
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.f29921a;
            int i5 = i3 + 1;
            if (d3 <= dArr2[i5]) {
                double d4 = dArr2[i5] - dArr2[i3];
                double[][] dArr3 = this.f29922b;
                double d5 = dArr3[i3][i2];
                double d6 = dArr3[i5][i2];
                double[][] dArr4 = this.f29923c;
                return b(d4, (d3 - dArr2[i3]) / d4, d5, d6, dArr4[i3][i2], dArr4[i5][i2]) / d4;
            }
            i3 = i5;
        }
        return i.f27244a;
    }

    public void b(double d2, double[] dArr) {
        double d3;
        double[] dArr2 = this.f29921a;
        int length = dArr2.length;
        int length2 = this.f29922b[0].length;
        if (d2 <= dArr2[0]) {
            d3 = dArr2[0];
        } else {
            int i2 = length - 1;
            d3 = d2 >= dArr2[i2] ? dArr2[i2] : d2;
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.f29921a;
            int i4 = i3 + 1;
            if (d3 <= dArr3[i4]) {
                double d4 = dArr3[i4] - dArr3[i3];
                double d5 = (d3 - dArr3[i3]) / d4;
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.f29922b;
                    double d6 = dArr4[i3][i5];
                    double d7 = dArr4[i4][i5];
                    double[][] dArr5 = this.f29923c;
                    dArr[i5] = b(d4, d5, d6, d7, dArr5[i3][i5], dArr5[i4][i5]) / d4;
                }
                return;
            }
            i3 = i4;
        }
    }
}
