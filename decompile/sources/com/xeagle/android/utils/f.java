package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import ef.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static double f24396a = 52.35987755982988d;

    public static int a(double d2, Resources resources) {
        double d3 = (double) resources.getDisplayMetrics().density;
        Double.isNaN(d3);
        return (int) Math.round(d2 * d3);
    }

    public static LatLng a(Context context, Location location) {
        CoordinateConverter coordinateConverter = new CoordinateConverter(context);
        coordinateConverter.from(CoordinateConverter.CoordType.GPS);
        coordinateConverter.coord(new LatLng(location.getLatitude(), location.getLongitude()));
        return coordinateConverter.convert();
    }

    public static LatLng a(Context context, a aVar) {
        CoordinateConverter coordinateConverter = new CoordinateConverter(context);
        coordinateConverter.from(CoordinateConverter.CoordType.GPS);
        coordinateConverter.coord(new LatLng(aVar.d(), aVar.c()));
        return coordinateConverter.convert();
    }

    public static com.google.android.gms.maps.model.LatLng a(a aVar) {
        return new com.google.android.gms.maps.model.LatLng(aVar.d(), aVar.c());
    }

    public static a a(Context context, LatLng latLng) {
        CoordinateConverter coordinateConverter = new CoordinateConverter(context);
        coordinateConverter.from(CoordinateConverter.CoordType.GPS);
        coordinateConverter.coord(new LatLng(latLng.latitude, latLng.longitude));
        LatLng convert = coordinateConverter.convert();
        return new a((latLng.latitude * 2.0d) - convert.latitude, (latLng.longitude * 2.0d) - convert.longitude);
    }

    public static a a(Location location) {
        return new a(location.getLatitude(), location.getLongitude());
    }

    public static a a(com.google.android.gms.maps.model.LatLng latLng) {
        return new a(latLng.f18225a, latLng.f18226b);
    }

    public static com.google.android.gms.maps.model.LatLng b(a aVar) {
        return new com.google.android.gms.maps.model.LatLng(aVar.d(), aVar.c());
    }
}
