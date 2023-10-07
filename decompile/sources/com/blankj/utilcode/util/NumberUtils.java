package com.blankj.utilcode.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class NumberUtils {
    private static final ThreadLocal<DecimalFormat> DF_THREAD_LOCAL = new ThreadLocal<DecimalFormat>() {
        /* access modifiers changed from: protected */
        public DecimalFormat initialValue() {
            return (DecimalFormat) NumberFormat.getInstance();
        }
    };

    private NumberUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static double float2Double(float f2) {
        return new BigDecimal(String.valueOf(f2)).doubleValue();
    }

    public static String format(double d2, int i2) {
        return format(d2, false, 1, i2, true);
    }

    public static String format(double d2, int i2, int i3, boolean z2) {
        return format(d2, false, i2, i3, z2);
    }

    public static String format(double d2, int i2, boolean z2) {
        return format(d2, false, 1, i2, z2);
    }

    public static String format(double d2, boolean z2, int i2) {
        return format(d2, z2, 1, i2, true);
    }

    public static String format(double d2, boolean z2, int i2, int i3, boolean z3) {
        DecimalFormat safeDecimalFormat = getSafeDecimalFormat();
        safeDecimalFormat.setGroupingUsed(z2);
        safeDecimalFormat.setRoundingMode(z3 ? RoundingMode.HALF_UP : RoundingMode.DOWN);
        safeDecimalFormat.setMinimumIntegerDigits(i2);
        safeDecimalFormat.setMinimumFractionDigits(i3);
        safeDecimalFormat.setMaximumFractionDigits(i3);
        return safeDecimalFormat.format(d2);
    }

    public static String format(double d2, boolean z2, int i2, boolean z3) {
        return format(d2, z2, 1, i2, z3);
    }

    public static String format(float f2, int i2) {
        return format(f2, false, 1, i2, true);
    }

    public static String format(float f2, int i2, int i3, boolean z2) {
        return format(f2, false, i2, i3, z2);
    }

    public static String format(float f2, int i2, boolean z2) {
        return format(f2, false, 1, i2, z2);
    }

    public static String format(float f2, boolean z2, int i2) {
        return format(f2, z2, 1, i2, true);
    }

    public static String format(float f2, boolean z2, int i2, int i3, boolean z3) {
        return format(float2Double(f2), z2, i2, i3, z3);
    }

    public static String format(float f2, boolean z2, int i2, boolean z3) {
        return format(f2, z2, 1, i2, z3);
    }

    public static DecimalFormat getSafeDecimalFormat() {
        return DF_THREAD_LOCAL.get();
    }
}
