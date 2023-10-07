package com.amap.api.mapcore.util;

import java.util.Calendar;
import java.util.Date;

public final class ip {
    private static long a(long j2) {
        return j2 - b(j2);
    }

    public static long a(long j2, long j3) {
        try {
            return Math.abs(j2 - j3) > 31536000000L ? b(j2, j3) : j2;
        } catch (Throwable unused) {
            return j2;
        }
    }

    private static long b(long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j2));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    private static long b(long j2, long j3) {
        long b2 = b(j3) + a(j2);
        long abs = Math.abs(b2 - j3);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(b2));
        int i2 = instance.get(11);
        if (i2 == 23 && abs >= 82800000) {
            b2 -= 86400000;
        }
        return (i2 != 0 || abs < 82800000) ? b2 : b2 + 86400000;
    }
}
