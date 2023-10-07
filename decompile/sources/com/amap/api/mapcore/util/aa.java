package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import fg.i;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    static double f7703a = 3.141592653589793d;

    /* renamed from: b  reason: collision with root package name */
    public static double f7704b = 6378245.0d;

    /* renamed from: c  reason: collision with root package name */
    public static double f7705c = 0.006693421622965943d;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f7706d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final double[] f7707e = {25.575374d, 120.391111d};

    /* renamed from: f  reason: collision with root package name */
    private static final double[] f7708f = {21.405235d, 121.649046d};

    /* renamed from: g  reason: collision with root package name */
    private static final List<LatLng> f7709g = new ArrayList(Arrays.asList(new LatLng[]{new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)}));

    private static double a(double d2) {
        return Math.sin(d2 * 3000.0d * (f7703a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d2, double d3) {
        return (Math.cos(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.sin(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static LatLng a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!de.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint a2 = a(DPoint.obtain(latLng.longitude, latLng.latitude), f7706d);
        LatLng latLng2 = new LatLng(a2.f10010y, a2.f10009x, false);
        a2.recycle();
        return latLng2;
    }

    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            try {
                if (de.a(latLng.latitude, latLng.longitude)) {
                    DPoint e2 = e(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(e2.f10010y, e2.f10009x, false);
                    e2.recycle();
                    return latLng2;
                } else if (!f(latLng.latitude, latLng.longitude)) {
                    return latLng;
                } else {
                    DPoint e3 = e(latLng.longitude, latLng.latitude);
                    return g(e3.f10010y, e3.f10009x);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static DPoint a(double d2, double d3, double d4, double d5) {
        DPoint obtain = DPoint.obtain();
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        DPoint d8 = d(d6, d7);
        obtain.f10009x = c((d2 + d6) - d8.f10009x);
        obtain.f10010y = c((d3 + d7) - d8.f10010y);
        return obtain;
    }

    private static DPoint a(DPoint dPoint, boolean z2) {
        try {
            if (!de.a(dPoint.f10010y, dPoint.f10009x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (!z2) {
                dArr = a.a(dPoint.f10009x, dPoint.f10010y);
            }
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    private static double b(double d2) {
        return Math.cos(d2 * 3000.0d * (f7703a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d2, double d3) {
        return (Math.sin(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.cos(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static LatLng b(Context context, LatLng latLng) {
        try {
            if (!de.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            DPoint c2 = c(latLng.longitude, latLng.latitude);
            LatLng a2 = a(context, new LatLng(c2.f10010y, c2.f10009x, false));
            c2.recycle();
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double c(double d2) {
        return new BigDecimal(d2).setScale(8, 4).doubleValue();
    }

    private static DPoint c(double d2, double d3) {
        double d4 = (double) (((long) (d2 * 100000.0d)) % 36000000);
        double d5 = (double) (((long) (d3 * 100000.0d)) % 36000000);
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = (double) ((int) ((-a(d4, d5)) + d4));
        double d7 = (double) ((int) ((-b(d4, d5)) + d5));
        Double.isNaN(d4);
        double d8 = (-a(d6, d7)) + d4;
        int i2 = 1;
        double d9 = (double) (d4 > i.f27244a ? 1 : -1);
        Double.isNaN(d9);
        double d10 = (double) ((int) (d8 + d9));
        Double.isNaN(d5);
        double d11 = (-b(d10, d7)) + d5;
        if (d5 <= i.f27244a) {
            i2 = -1;
        }
        double d12 = (double) i2;
        Double.isNaN(d12);
        Double.isNaN(d10);
        double d13 = (double) ((int) (d11 + d12));
        Double.isNaN(d13);
        return DPoint.obtain(d10 / 100000.0d, d13 / 100000.0d);
    }

    private static DPoint d(double d2, double d3) {
        DPoint obtain = DPoint.obtain();
        double d4 = (d2 * d2) + (d3 * d3);
        obtain.f10009x = c((Math.cos(b(d2) + Math.atan2(d3, d2)) * (a(d3) + Math.sqrt(d4))) + 0.0065d);
        obtain.f10010y = c((Math.sin(b(d2) + Math.atan2(d3, d2)) * (a(d3) + Math.sqrt(d4))) + 0.006d);
        return obtain;
    }

    private static DPoint e(double d2, double d3) {
        DPoint dPoint = null;
        double d4 = 0.006401062d;
        double d5 = 0.0060424805d;
        for (int i2 = 0; i2 < 2; i2++) {
            dPoint = a(d2, d3, d4, d5);
            d4 = d2 - dPoint.f10009x;
            d5 = d3 - dPoint.f10010y;
        }
        return dPoint;
    }

    private static boolean f(double d2, double d3) {
        return dl.a(new LatLng(d2, d3), f7709g);
    }

    private static LatLng g(double d2, double d3) {
        LatLng h2 = h(d2, d3);
        return new LatLng((d2 * 2.0d) - h2.latitude, (d3 * 2.0d) - h2.longitude);
    }

    private static LatLng h(double d2, double d3) {
        double d4 = d3 - 105.0d;
        double d5 = d2 - 35.0d;
        double i2 = i(d4, d5);
        double j2 = j(d4, d5);
        double d6 = (d2 / 180.0d) * f7703a;
        double sin = Math.sin(d6);
        double d7 = 1.0d - ((f7705c * sin) * sin);
        double sqrt = Math.sqrt(d7);
        double d8 = f7704b;
        return new LatLng(d2 + ((i2 * 180.0d) / ((((1.0d - f7705c) * d8) / (d7 * sqrt)) * f7703a)), d3 + ((j2 * 180.0d) / (((d8 / sqrt) * Math.cos(d6)) * f7703a)));
    }

    private static double i(double d2, double d3) {
        double d4 = d2 * 2.0d;
        return -100.0d + d4 + (d3 * 3.0d) + (d3 * 0.2d * d3) + (0.1d * d2 * d3) + (Math.sqrt(Math.abs(d2)) * 0.2d) + ((((Math.sin((d2 * 6.0d) * f7703a) * 20.0d) + (Math.sin(d4 * f7703a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f7703a * d3) * 20.0d) + (Math.sin((d3 / 3.0d) * f7703a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d3 / 12.0d) * f7703a) * 160.0d) + (Math.sin((d3 * f7703a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double j(double d2, double d3) {
        double d4 = d2 * 0.1d;
        return d2 + 300.0d + (d3 * 2.0d) + (d4 * d2) + (d4 * d3) + (Math.sqrt(Math.abs(d2)) * 0.1d) + ((((Math.sin((6.0d * d2) * f7703a) * 20.0d) + (Math.sin((d2 * 2.0d) * f7703a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f7703a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f7703a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f7703a) * 150.0d) + (Math.sin((d2 / 30.0d) * f7703a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
