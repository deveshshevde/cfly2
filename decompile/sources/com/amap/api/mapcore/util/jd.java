package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ff;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import fg.i;

public final class jd {

    /* renamed from: a  reason: collision with root package name */
    static ff f9434a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f9435b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f9436c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f9437d = {"com.amap.trace"};

    public static ff a() throws eu {
        Class<?> cls;
        Class<?> cls2;
        ff a2;
        ff ffVar = f9434a;
        if (ffVar != null) {
            return ffVar;
        }
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                String str = (String) iq.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                a2 = new ff.a("3dmap", str, "AMAP_SDK_Android_Map_".concat(String.valueOf(str))).a(f9435b).a();
            } catch (Throwable unused2) {
            }
        } else {
            cls = Class.forName("com.amap.api.maps2d.MapsInitializer");
            String str2 = (String) iq.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
            a2 = new ff.a("2dmap", str2, "AMAP_SDK_Android_2DMap_".concat(String.valueOf(str2))).a(f9436c).a();
        }
        f9434a = a2;
        if (cls == null) {
            try {
                cls2 = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable unused3) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    String str3 = (String) iq.a(cls2, "getVersion", (Object[]) null, (Class<?>[]) null);
                    f9434a = new ff.a("trace", str3, "AMAP_TRACE_Android_".concat(String.valueOf(str3))).a(f9437d).a();
                } catch (Throwable unused4) {
                }
            }
        }
        return f9434a;
    }

    public static boolean a(iz izVar) {
        if (izVar != null && !izVar.d().equals("8") && !izVar.d().equals("5") && !izVar.d().equals("6")) {
            return a((Inner_3dMap_location) izVar);
        }
        return false;
    }

    public static boolean a(Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        return !(longitude == i.f27244a && latitude == i.f27244a) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
