package k;

import android.util.Log;
import fg.i;
import java.util.Arrays;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static c f29909a = new c();

    /* renamed from: c  reason: collision with root package name */
    public static String[] f29910c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: b  reason: collision with root package name */
    String f29911b = "identity";

    static class a extends c {

        /* renamed from: h  reason: collision with root package name */
        private static double f29912h = 0.01d;

        /* renamed from: i  reason: collision with root package name */
        private static double f29913i = 1.0E-4d;

        /* renamed from: d  reason: collision with root package name */
        double f29914d;

        /* renamed from: e  reason: collision with root package name */
        double f29915e;

        /* renamed from: f  reason: collision with root package name */
        double f29916f;

        /* renamed from: g  reason: collision with root package name */
        double f29917g;

        a(String str) {
            this.f29911b = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f29914d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.f29915e = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.f29916f = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.f29917g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double c(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f29914d * d3 * d4 * d2) + (this.f29916f * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        private double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f29915e * d3 * d4 * d2) + (this.f29917g * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        public double a(double d2) {
            if (d2 <= i.f27244a) {
                return i.f27244a;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f29912h) {
                d3 *= 0.5d;
                d4 = c(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double c2 = c(d5);
            double d6 = d4 + d3;
            double c3 = c(d6);
            double d7 = d(d5);
            return (((d(d6) - d7) * (d2 - c2)) / (c3 - c2)) + d7;
        }

        public double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f29913i) {
                d3 *= 0.5d;
                d4 = c(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (d(d6) - d(d5)) / (c(d6) - c(d5));
        }
    }

    public static c a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(1, 1, 0, 0)");
            case 3:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f29910c));
                return f29909a;
        }
    }

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.f29911b;
    }
}
