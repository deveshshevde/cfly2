package k;

import fg.i;

public abstract class b {

    static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        double f29907a;

        /* renamed from: b  reason: collision with root package name */
        double[] f29908b;

        a(double d2, double[] dArr) {
            this.f29907a = d2;
            this.f29908b = dArr;
        }

        public double a(double d2, int i2) {
            return this.f29908b[i2];
        }

        public void a(double d2, double[] dArr) {
            double[] dArr2 = this.f29908b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public void a(double d2, float[] fArr) {
            int i2 = 0;
            while (true) {
                double[] dArr = this.f29908b;
                if (i2 < dArr.length) {
                    fArr[i2] = (float) dArr[i2];
                    i2++;
                } else {
                    return;
                }
            }
        }

        public double[] a() {
            return new double[]{this.f29907a};
        }

        public double b(double d2, int i2) {
            return i.f27244a;
        }

        public void b(double d2, double[] dArr) {
            for (int i2 = 0; i2 < this.f29908b.length; i2++) {
                dArr[i2] = 0.0d;
            }
        }
    }

    public static b a(int i2, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i2 = 2;
        }
        return i2 != 0 ? i2 != 2 ? new d(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new e(dArr, dArr2);
    }

    public static b a(int[] iArr, double[] dArr, double[][] dArr2) {
        return new a(iArr, dArr, dArr2);
    }

    public abstract double a(double d2, int i2);

    public abstract void a(double d2, double[] dArr);

    public abstract void a(double d2, float[] fArr);

    public abstract double[] a();

    public abstract double b(double d2, int i2);

    public abstract void b(double d2, double[] dArr);
}
