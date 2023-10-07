package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.mapcore.util.dl;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (LatLng next : list) {
                        arrayList.add(DPoint.obtain(next.latitude, next.longitude));
                        if (next.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i2), latLng);
                        }
                        i2++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint((List<DPoint>) arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).f10009x, ((DPoint) calShortestDistancePoint.second).f10010y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f2, double d2) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (LatLng next : list) {
                        arrayList.add(DPoint.obtain(next.latitude, next.longitude));
                        if (next.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i2), latLng);
                        }
                        i2++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f2);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (((double) AMapUtils.calculateLineDistance(new LatLng(dPoint.f10009x, dPoint.f10010y), latLng)) < d2) {
                            return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).f10009x, ((DPoint) calShortestDistancePoint.second).f10010y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f2) {
        int i2;
        int i3;
        double d2;
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list.size() != 0) {
            if (list.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                double d3 = i.f27244a;
                int size = list.size();
                int i4 = 1;
                int i5 = 1;
                while (true) {
                    int i6 = size - 1;
                    if (i5 > i6) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i5);
                    if (i5 == i6 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i5), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f2)) {
                        d2 = d3;
                        i2 = size;
                        i3 = i5;
                    } else if (dPoint3.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i5 - i4), dPoint2);
                    } else {
                        i3 = i5;
                        d2 = d3;
                        i2 = size;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.f10009x, dPoint2.f10010y, dPoint3.f10009x, dPoint3.f10010y, dPoint4.f10009x, dPoint4.f10010y);
                        Double d4 = (Double) pointToSegDist.first;
                        if (pair2 == null) {
                            doubleValue = d4.doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        } else if (d2 > d4.doubleValue()) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        }
                        d3 = doubleValue;
                        pair2 = pair;
                        i5 = i3 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        size = i2;
                        i4 = 1;
                    }
                    d3 = d2;
                    i5 = i3 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    size = i2;
                    i4 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f2) {
        if (f2 == -1.0f) {
            return true;
        }
        if (!(dPoint == null || dPoint2 == null)) {
            float abs = Math.abs((dl.a(dPoint, dPoint2) + 360.0f) - f2) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d5;
        double d10 = d6;
        double d11 = d7;
        double d12 = d10 - d8;
        double d13 = d2 - d8;
        double d14 = d11 - d9;
        double d15 = d3 - d9;
        double d16 = (d12 * d13) + (d14 * d15);
        if (d16 <= i.f27244a) {
            return new Pair<>(Double.valueOf(Math.sqrt((d13 * d13) + (d15 * d15))), new DPoint(d8, d9));
        }
        double d17 = (d12 * d12) + (d14 * d14);
        if (d16 >= d17) {
            double d18 = d2 - d10;
            double d19 = d3 - d11;
            return new Pair<>(Double.valueOf(Math.sqrt((d18 * d18) + (d19 * d19))), new DPoint(d10, d11));
        }
        double d20 = d16 / d17;
        double d21 = d8 + (d12 * d20);
        double d22 = d9 + (d14 * d20);
        double d23 = d2 - d21;
        double d24 = d22 - d3;
        return new Pair<>(Double.valueOf(Math.sqrt((d23 * d23) + (d24 * d24))), new DPoint(d21, d22));
    }
}
