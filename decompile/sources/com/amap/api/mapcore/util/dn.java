package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class dn {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Cdo> f8274a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static String f8275b = "";

    public static void a() {
        try {
            if (dm.f8267a) {
                for (Map.Entry<String, Cdo> value : f8274a.entrySet()) {
                    ((Cdo) value.getValue()).a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(int i2, String str, String str2) {
        if (i2 == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    private static void a(int i2, String str, String str2, String str3, String str4) {
        Map<String, Cdo> map;
        Cdo doVar;
        try {
            String str5 = str3 + str4;
            if (dm.f8268b) {
                a(i2, str2, str5);
            }
            if (dm.f8267a && (map = f8274a) != null && (doVar = map.get(str)) != null) {
                doVar.a(i2, str2, str5);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                b();
                fr.a(dl.a()).a(context.getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) {
        a(0, "normal", f8275b, str, str2);
    }

    public static void a(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions != null) {
            c(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
            return;
        }
        c(str, str2);
    }

    public static void a(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions != null) {
            StringBuilder sb = new StringBuilder();
            List<LatLng> points = polygonOptions.getPoints();
            if (points != null) {
                sb.append("points size =");
                sb.append(points.size());
            }
            sb.append(";width=");
            sb.append(polygonOptions.getStrokeWidth());
            sb.append(";fillColor=");
            sb.append(polygonOptions.getFillColor());
            sb.append(";strokeColor=");
            sb.append(polygonOptions.getStrokeColor());
            sb.append(";visible=");
            sb.append(polygonOptions.isVisible());
            c(str, str2 + " " + sb.toString());
            return;
        }
        c(str, str2);
    }

    public static void a(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            StringBuilder sb = new StringBuilder();
            List<LatLng> points = polylineOptions.getPoints();
            if (points != null) {
                sb.append("points size =");
                sb.append(points.size());
            }
            sb.append(";width=");
            sb.append(polylineOptions.getWidth());
            sb.append(";color=");
            sb.append(polylineOptions.getColor());
            sb.append(";visible=");
            sb.append(polylineOptions.isVisible());
            c(str, str2 + " " + sb.toString());
            return;
        }
        c(str, str2);
    }

    public static void a(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            for (MarkerOptions a2 : list) {
                a(str, str2, a2);
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = ew.a(jSONObject.optString("able", ""), false);
                boolean a3 = ew.a(jSONObject.optString("mobile", ""), false);
                boolean a4 = ew.a(jSONObject.optString("debugupload", ""), false);
                boolean a5 = ew.a(jSONObject.optString("debugwrite", ""), false);
                boolean a6 = ew.a(jSONObject.optString("forcedUpload", ""), false);
                dm.f8267a = a2;
                boolean a7 = ew.a(jSONObject.optString("di", ""), false);
                String optString = jSONObject.optString("dis", "");
                if (!a7 || fg.f(optString)) {
                    fr.a(dl.a()).a(a2, a3, a5, a4, Arrays.asList(jSONObject.optString("filter", "").split("&")));
                    if (a6) {
                        fr.a(dl.a()).a(a6);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b() {
        try {
            f8274a.put("overlay", new dq());
            f8274a.put("normal", new dp());
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2) {
        a(1, "normal", f8275b, str, str2);
    }

    private static void c(String str, String str2) {
        a(1, "overlay", f8275b, str, str2);
    }
}
