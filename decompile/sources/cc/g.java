package cc;

import android.os.Build;
import android.os.SystemClock;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final double f6183a;

    static {
        double d2 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f6183a = d2;
    }

    public static double a(long j2) {
        double a2 = (double) (a() - j2);
        double d2 = f6183a;
        Double.isNaN(a2);
        return a2 * d2;
    }

    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
