package k;

import fg.i;
import java.util.Arrays;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f29924a = "Oscillator";

    /* renamed from: b  reason: collision with root package name */
    float[] f29925b = new float[0];

    /* renamed from: c  reason: collision with root package name */
    double[] f29926c = new double[0];

    /* renamed from: d  reason: collision with root package name */
    double[] f29927d;

    /* renamed from: e  reason: collision with root package name */
    int f29928e;

    /* renamed from: f  reason: collision with root package name */
    double f29929f = 6.283185307179586d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29930g = false;

    /* access modifiers changed from: package-private */
    public double a(double d2) {
        if (d2 < i.f27244a) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f29926c, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return i.f27244a;
        }
        int i2 = (-binarySearch) - 1;
        float[] fArr = this.f29925b;
        int i3 = i2 - 1;
        double d3 = (double) (fArr[i2] - fArr[i3]);
        double[] dArr = this.f29926c;
        Double.isNaN(d3);
        double d4 = d3 / (dArr[i2] - dArr[i3]);
        double d5 = this.f29927d[i3];
        double d6 = (double) fArr[i3];
        Double.isNaN(d6);
        return d5 + ((d6 - (dArr[i3] * d4)) * (d2 - dArr[i3])) + ((d4 * ((d2 * d2) - (dArr[i3] * dArr[i3]))) / 2.0d);
    }

    public void a() {
        double d2 = 0.0d;
        int i2 = 0;
        while (true) {
            float[] fArr = this.f29925b;
            if (i2 >= fArr.length) {
                break;
            }
            double d3 = (double) fArr[i2];
            Double.isNaN(d3);
            d2 += d3;
            i2++;
        }
        double d4 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr2 = this.f29925b;
            if (i3 >= fArr2.length) {
                break;
            }
            int i4 = i3 - 1;
            double[] dArr = this.f29926c;
            double d5 = (double) ((fArr2[i4] + fArr2[i3]) / 2.0f);
            Double.isNaN(d5);
            d4 += (dArr[i3] - dArr[i4]) * d5;
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr3 = this.f29925b;
            if (i5 >= fArr3.length) {
                break;
            }
            double d6 = (double) fArr3[i5];
            Double.isNaN(d6);
            fArr3[i5] = (float) (d6 * (d2 / d4));
            i5++;
        }
        this.f29927d[0] = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr4 = this.f29925b;
            if (i6 < fArr4.length) {
                int i7 = i6 - 1;
                double[] dArr2 = this.f29926c;
                double d7 = dArr2[i6] - dArr2[i7];
                double[] dArr3 = this.f29927d;
                double d8 = dArr3[i7];
                double d9 = (double) ((fArr4[i7] + fArr4[i6]) / 2.0f);
                Double.isNaN(d9);
                dArr3[i6] = d8 + (d7 * d9);
                i6++;
            } else {
                this.f29930g = true;
                return;
            }
        }
    }

    public void a(double d2, float f2) {
        int length = this.f29925b.length + 1;
        int binarySearch = Arrays.binarySearch(this.f29926c, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f29926c = Arrays.copyOf(this.f29926c, length);
        this.f29925b = Arrays.copyOf(this.f29925b, length);
        this.f29927d = new double[length];
        double[] dArr = this.f29926c;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f29926c[binarySearch] = d2;
        this.f29925b[binarySearch] = f2;
        this.f29930g = false;
    }

    public void a(int i2) {
        this.f29928e = i2;
    }

    public double b(double d2) {
        double abs;
        switch (this.f29928e) {
            case 1:
                return Math.signum(0.5d - (a(d2) % 1.0d));
            case 2:
                abs = Math.abs((((a(d2) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((a(d2) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((a(d2) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f29929f * a(d2));
            case 6:
                double abs2 = 1.0d - Math.abs(((a(d2) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.f29929f * a(d2));
        }
        return 1.0d - abs;
    }

    /* access modifiers changed from: package-private */
    public double c(double d2) {
        if (d2 <= i.f27244a) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f29926c, d2);
        if (binarySearch > 0 || binarySearch == 0) {
            return i.f27244a;
        }
        int i2 = (-binarySearch) - 1;
        float[] fArr = this.f29925b;
        int i3 = i2 - 1;
        double d3 = (double) (fArr[i2] - fArr[i3]);
        double[] dArr = this.f29926c;
        Double.isNaN(d3);
        double d4 = d3 / (dArr[i2] - dArr[i3]);
        double d5 = d2 * d4;
        double d6 = (double) fArr[i3];
        Double.isNaN(d6);
        return (d6 - (d4 * dArr[i3])) + d5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        return r10 * 2.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        return r0 * r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        return r5 * r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double d(double r10) {
        /*
            r9 = this;
            int r0 = r9.f29928e
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            r3 = 4616189618054758400(0x4010000000000000, double:4.0)
            switch(r0) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0055;
                case 3: goto L_0x0050;
                case 4: goto L_0x0048;
                case 5: goto L_0x0032;
                case 6: goto L_0x0020;
                default: goto L_0x0009;
            }
        L_0x0009:
            double r0 = r9.f29929f
            double r2 = r9.c(r10)
            double r0 = r0 * r2
            double r2 = r9.f29929f
            double r10 = r9.a((double) r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.cos(r2)
        L_0x001d:
            double r0 = r0 * r10
            return r0
        L_0x0020:
            double r5 = r9.c(r10)
            double r5 = r5 * r3
            double r10 = r9.a((double) r10)
            double r10 = r10 * r3
            double r10 = r10 + r1
            double r10 = r10 % r3
            double r10 = r10 - r1
        L_0x002f:
            double r5 = r5 * r10
            return r5
        L_0x0032:
            double r0 = r9.f29929f
            double r0 = -r0
            double r2 = r9.c(r10)
            double r0 = r0 * r2
            double r2 = r9.f29929f
            double r10 = r9.a((double) r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.sin(r2)
            goto L_0x001d
        L_0x0048:
            double r10 = r9.c(r10)
            double r10 = -r10
        L_0x004d:
            double r10 = r10 * r1
            return r10
        L_0x0050:
            double r10 = r9.c(r10)
            goto L_0x004d
        L_0x0055:
            double r5 = r9.c(r10)
            double r5 = r5 * r3
            double r10 = r9.a((double) r10)
            double r10 = r10 * r3
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r10 = r10 + r7
            double r10 = r10 % r3
            double r10 = r10 - r1
            double r10 = java.lang.Math.signum(r10)
            goto L_0x002f
        L_0x006b:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k.f.d(double):double");
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f29926c) + " period=" + Arrays.toString(this.f29925b);
    }
}
