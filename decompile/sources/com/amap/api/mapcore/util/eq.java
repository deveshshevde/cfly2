package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.autonavi.base.amap.mapcore.AeUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class eq extends eo<List<TraceLocation>, List<LatLng>> implements Runnable {

    /* renamed from: j  reason: collision with root package name */
    private List<TraceLocation> f8545j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f8546k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f8547l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f8548m = 0;

    /* renamed from: n  reason: collision with root package name */
    private String f8549n;

    public eq(Context context, Handler handler, List<TraceLocation> list, String str, int i2, int i3) {
        super(context, list);
        this.f8545j = list;
        this.f8546k = handler;
        this.f8548m = i2;
        this.f8547l = i3;
        this.f8549n = str;
    }

    private static List<LatLng> b(String str) throws em {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(AeUtil.ROOT_DATA_PATH_OLD_NAME) && (optJSONArray = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME).optJSONArray("points")) != null) {
                if (optJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(String str) throws em {
        return b(str);
    }

    /* access modifiers changed from: protected */
    public final String c() {
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        for (int i2 = 0; i2 < this.f8545j.size(); i2++) {
            TraceLocation traceLocation = this.f8545j.get(i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                int i3 = (time > 0 ? 1 : (time == 0 ? 0 : -1));
                if (i2 == 0) {
                    if (i3 == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (i3 != 0) {
                        long j3 = time - j2;
                        if (j3 >= 1000) {
                            jSONObject.put("tm", j3 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j2 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.f8542h = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    public final String getIPV6URL() {
        return dl.a(getURL());
    }

    public final String getURL() {
        String str = "key=" + ev.f(this.f8541g);
        String a2 = ey.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(a2)) + "&scode=".concat(String.valueOf(ey.a(this.f8541g, a2, str)));
    }

    public final boolean isSupportIPV6() {
        return true;
    }

    public final void run() {
        new ArrayList();
        try {
            es.a().a(this.f8549n, this.f8547l, (List<LatLng>) (List) d());
            es.a().a(this.f8549n).a(this.f8546k);
        } catch (em e2) {
            es.a();
            es.a(this.f8546k, this.f8548m, e2.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
