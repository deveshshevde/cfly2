package com.autonavi.amap.mapcore;

import android.graphics.Point;

public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d2, double d3, double d4) {
        return Math.min(Math.max(d2, d3), d4);
    }

    private static double degToRad(double d2) {
        return d2 * 0.017453292519943295d;
    }

    public static Point latLongToPixels(double d2, double d3, int i2) {
        Point point = new Point();
        latLongToPixels(d2, d3, i2, point);
        return point;
    }

    public static Point latLongToPixels(int i2, int i3, int i4) {
        double d2 = (double) i3;
        Double.isNaN(d2);
        double d3 = (double) i2;
        Double.isNaN(d3);
        return latLongToPixels(d2 / 3600000.0d, d3 / 3600000.0d, i4);
    }

    public static void latLongToPixels(double d2, double d3, int i2, Point point) {
        double sin = Math.sin(degToRad(clip(d2, -85.0511287798d, 85.0511287798d)));
        point.x = (int) (((degToRad(clip(d3, -360.0d, 360.0d)) * 6378137.0d) + K_EARTH_CIRCLE_2) / 0.14929106831550598d);
        point.y = (int) ((K_EARTH_CIRCLE_2 - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d)) / 0.14929106831550598d);
    }

    public static DPoint latLongToPixelsDouble(double d2, double d3, int i2) {
        DPoint dPoint = new DPoint();
        double sin = Math.sin(degToRad(clip(d2, -85.0511287798d, 85.0511287798d)));
        dPoint.f10009x = ((degToRad(clip(d3, -360.0d, 360.0d)) * 6378137.0d) + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        dPoint.f10010y = (K_EARTH_CIRCLE_2 - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d)) / 0.14929106831550598d;
        return dPoint;
    }

    public static DPoint pixelsToLatLong(double d2, double d3, int i2) {
        DPoint obtain = DPoint.obtain();
        double d4 = (d2 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d5 = K_EARTH_CIRCLE_2 - (d3 * 0.14929106831550598d);
        obtain.f10009x = radToDeg(d4 / 6378137.0d);
        double exp = Math.exp((d5 / 6378137.0d) * 2.0d);
        obtain.f10010y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static DPoint pixelsToLatLong(long j2, long j3, int i2) {
        DPoint obtain = DPoint.obtain();
        double d2 = (double) j2;
        Double.isNaN(d2);
        double d3 = (d2 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d4 = (double) j3;
        Double.isNaN(d4);
        double d5 = K_EARTH_CIRCLE_2 - (d4 * 0.14929106831550598d);
        obtain.f10009x = radToDeg(d3 / 6378137.0d);
        double exp = Math.exp((d5 / 6378137.0d) * 2.0d);
        obtain.f10010y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d2) {
        return d2 * 57.29577951308232d;
    }
}
