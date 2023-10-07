package com.blankj.utilcode.util;

import android.graphics.Color;
import androidx.core.content.b;
import com.amap.api.mapcore.util.fx;
import java.util.Objects;

public final class ColorUtils {
    private ColorUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getColor(int i2) {
        return b.c(Utils.getApp(), i2);
    }

    public static int getRandomColor() {
        return getRandomColor(true);
    }

    public static int getRandomColor(boolean z2) {
        return (z2 ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }

    public static String int2ArgbString(int i2) {
        String hexString = Integer.toHexString(i2);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        while (hexString.length() < 8) {
            hexString = fx.f8868i + hexString;
        }
        return "#" + hexString;
    }

    public static String int2RgbString(int i2) {
        String hexString = Integer.toHexString(i2 & 16777215);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        return "#" + hexString;
    }

    public static boolean isLightColor(int i2) {
        double red = (double) Color.red(i2);
        Double.isNaN(red);
        double green = (double) Color.green(i2);
        Double.isNaN(green);
        double d2 = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i2);
        Double.isNaN(blue);
        return d2 + (blue * 0.114d) >= 127.5d;
    }

    public static int setAlphaComponent(int i2, float f2) {
        return (i2 & 16777215) | (((int) ((f2 * 255.0f) + 0.5f)) << 24);
    }

    public static int setAlphaComponent(int i2, int i3) {
        return (i2 & 16777215) | (i3 << 24);
    }

    public static int setBlueComponent(int i2, float f2) {
        return (i2 & -256) | ((int) ((f2 * 255.0f) + 0.5f));
    }

    public static int setBlueComponent(int i2, int i3) {
        return (i2 & -256) | i3;
    }

    public static int setGreenComponent(int i2, float f2) {
        return (i2 & -65281) | (((int) ((f2 * 255.0f) + 0.5f)) << 8);
    }

    public static int setGreenComponent(int i2, int i3) {
        return (i2 & -65281) | (i3 << 8);
    }

    public static int setRedComponent(int i2, float f2) {
        return (i2 & -16711681) | (((int) ((f2 * 255.0f) + 0.5f)) << 16);
    }

    public static int setRedComponent(int i2, int i3) {
        return (i2 & -16711681) | (i3 << 16);
    }

    public static int string2Int(String str) {
        Objects.requireNonNull(str, "Argument 'colorString' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Color.parseColor(str);
    }
}
