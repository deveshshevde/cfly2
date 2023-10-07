package my;

import android.content.Context;

public final class b {
    public static int a(Context context, double d2) {
        double d3 = (double) context.getResources().getDisplayMetrics().density;
        Double.isNaN(d3);
        return (int) ((d2 * d3) + 0.5d);
    }
}
