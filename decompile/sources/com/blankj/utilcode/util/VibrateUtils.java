package com.blankj.utilcode.util;

import android.os.Vibrator;

public final class VibrateUtils {
    private static Vibrator vibrator;

    private VibrateUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void cancel() {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 != null) {
            vibrator2.cancel();
        }
    }

    private static Vibrator getVibrator() {
        if (vibrator == null) {
            vibrator = (Vibrator) Utils.getApp().getSystemService("vibrator");
        }
        return vibrator;
    }

    public static void vibrate(long j2) {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 != null) {
            vibrator2.vibrate(j2);
        }
    }

    public static void vibrate(long[] jArr, int i2) {
        Vibrator vibrator2 = getVibrator();
        if (vibrator2 != null) {
            vibrator2.vibrate(jArr, i2);
        }
    }
}
