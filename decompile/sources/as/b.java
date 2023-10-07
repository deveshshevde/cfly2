package as;

import android.graphics.Color;

public final class b {
    public static final int a(int i2, float f2) {
        return Color.argb((int) (((float) 255) * f2), Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public static final boolean a(int i2, double d2) {
        if (i2 == 0) {
            return false;
        }
        double d3 = (double) 1;
        double red = (double) Color.red(i2);
        Double.isNaN(red);
        double green = (double) Color.green(i2);
        Double.isNaN(green);
        double d4 = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i2);
        Double.isNaN(blue);
        double d5 = (double) 255;
        Double.isNaN(d5);
        Double.isNaN(d3);
        return d3 - ((d4 + (blue * 0.114d)) / d5) >= d2;
    }

    public static /* synthetic */ boolean a(int i2, double d2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            d2 = 0.5d;
        }
        return a(i2, d2);
    }
}
