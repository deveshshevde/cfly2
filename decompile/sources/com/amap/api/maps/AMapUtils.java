package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amap.api.mapcore.util.eu;
import com.amap.api.mapcore.util.ev;
import com.amap.api.mapcore.util.ex;
import com.amap.api.mapcore.util.ff;
import com.amap.api.mapcore.util.l;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import fg.i;
import java.util.List;
import java.util.Locale;

public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        String f9717a = "";

        /* renamed from: b  reason: collision with root package name */
        Context f9718b;

        public a(String str, Context context) {
            this.f9717a = str;
            if (context != null) {
                this.f9718b = context.getApplicationContext();
            }
        }

        public final void run() {
            if (this.f9718b != null) {
                try {
                    ex.a(this.f9718b, new ff.a(this.f9717a, "8.0.0", l.f9556c).a(new String[]{"com.amap.api.maps"}).a());
                    interrupt();
                } catch (eu e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, AMAPNAVIURL, new Object[]{ev.b(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle())});
    }

    private static String a(PoiPara poiPara, Context context) {
        String format = String.format(Locale.US, AMAPPOISEARCHURL, new Object[]{ev.b(context), poiPara.getKeywords()});
        if (poiPara.getCenter() == null) {
            return format;
        }
        return format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
    }

    private static void a(RoutePara routePara, Context context, int i2) throws AMapException {
        if (!a(context)) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        } else if (a(routePara)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(b(routePara, context, i2)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        } else {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
    }

    private static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.autonavi.minimap", 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static boolean a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    private static String b(RoutePara routePara, Context context, int i2) {
        StringBuilder sb;
        int drivingRouteStyle;
        String format = String.format(Locale.US, AMAPROUTEURL, new Object[]{ev.b(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i2)});
        if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(format);
            sb.append("&m=");
            drivingRouteStyle = routePara.getTransitRouteStyle();
        } else if (i2 != 2) {
            return format;
        } else {
            sb = new StringBuilder();
            sb.append(format);
            sb.append("&m=");
            drivingRouteStyle = routePara.getDrivingRouteStyle();
        }
        sb.append(drivingRouteStyle);
        return sb.toString();
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e2) {
                e2.printStackTrace();
                return 0.0f;
            }
        } else {
            try {
                double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
                double d2 = (latLng2.longitude - latLng.longitude) / 360.0d;
                if (d2 < i.f27244a) {
                    d2 += 1.0d;
                }
                return (float) (sin * 2.5560394669790553E14d * d2);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0.0f;
            }
        }
    }

    public static float calculateArea(List<LatLng> list) {
        List<LatLng> list2 = list;
        if (list2 == null || list.size() < 3) {
            return 0.0f;
        }
        double d2 = i.f27244a;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            LatLng latLng = list2.get(i2);
            i2++;
            LatLng latLng2 = list2.get(i2 % size);
            d2 += (((latLng.longitude * 111319.49079327357d) * Math.cos(latLng.latitude * DEG_TO_RAD)) * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * DEG_TO_RAD)) * (latLng.latitude * 111319.49079327357d));
        }
        return Math.abs((float) (d2 / 2.0d));
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        if (latLng3 == null || latLng4 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e2) {
                e2.printStackTrace();
                return 0.0f;
            }
        } else {
            try {
                double d2 = latLng3.longitude;
                double d3 = latLng3.latitude;
                double d4 = latLng4.longitude;
                double d5 = latLng4.latitude;
                double d6 = d2 * NF_PI;
                double d7 = d3 * NF_PI;
                double d8 = d4 * NF_PI;
                double d9 = d5 * NF_PI;
                double sin = Math.sin(d6);
                double sin2 = Math.sin(d7);
                double cos = Math.cos(d6);
                double cos2 = Math.cos(d7);
                double sin3 = Math.sin(d8);
                double sin4 = Math.sin(d9);
                double cos3 = Math.cos(d8);
                double cos4 = Math.cos(d9);
                double d10 = sin4;
                double[] dArr = {cos * cos2, cos2 * sin, sin2};
                double[] dArr2 = {cos3 * cos4, cos4 * sin3, d10};
                return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0.0f;
            }
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (!a(context)) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        } else if (naviPara.getTargetPoint() != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(a(naviPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        } else {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (!a(context)) {
            throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
        } else if (poiPara.getKeywords() == null || poiPara.getKeywords().trim().length() <= 0) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(a(poiPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
            }
        }
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 4);
    }
}
