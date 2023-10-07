package com.xeagle.android.vjoystick;

public class e {
    public static double a(double d2, double d3, double d4, double d5) {
        return Math.sqrt(Math.pow(d4 - d2, 2.0d) + Math.pow(d5 - d3, 2.0d));
    }

    public static double b(double d2, double d3, double d4, double d5) {
        double asin = (Math.asin(Math.abs(d5 - d3) / a(d2, d3, d4, d5)) * 180.0d) / 3.141592653589793d;
        return (d4 >= d2 || d5 >= d3) ? (d4 >= d2 || d5 < d3) ? (d4 < d2 || d5 < d3) ? asin : 360.0d - asin : asin + 180.0d : 180.0d - asin;
    }
}
