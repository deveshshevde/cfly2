package com.github.barteksc.pdfviewer.util;

public class b {
    public static float a(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static float a(float f2, float f3, float f4) {
        return f2 <= f3 ? f3 : f2 >= f4 ? f4 : f2;
    }

    public static int a(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return ((int) (d2 + 16384.0d)) - 16384;
    }

    public static float b(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static int b(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return ((int) (d2 + 16384.999999999996d)) - 16384;
    }
}
