package m;

import android.graphics.Color;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f31043a = new ThreadLocal<>();

    public static double a(int i2) {
        double[] a2 = a();
        a(i2, a2);
        return a2[1] / 100.0d;
    }

    public static int a(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int c2 = c(alpha2, alpha);
        return Color.argb(c2, a(Color.red(i2), alpha2, Color.red(i3), alpha, c2), a(Color.green(i2), alpha2, Color.green(i3), alpha, c2), a(Color.blue(i2), alpha2, Color.blue(i3), alpha, c2));
    }

    private static int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    public static void a(int i2, int i3, int i4, double[] dArr) {
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d2 = (double) i2;
            Double.isNaN(d2);
            double d3 = d2 / 255.0d;
            double pow = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = (double) i3;
            Double.isNaN(d4);
            double d5 = d4 / 255.0d;
            double pow2 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            double d6 = (double) i4;
            Double.isNaN(d6);
            double d7 = d6 / 255.0d;
            double pow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            dArr2[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr2[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr2[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static void a(int i2, double[] dArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    private static double[] a() {
        ThreadLocal<double[]> threadLocal = f31043a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int b(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i2 & 16777215) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int c(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }
}
