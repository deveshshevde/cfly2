package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ew;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class at extends bk<String, List<OfflineMapProvince>> {

    /* renamed from: d  reason: collision with root package name */
    private Context f7870d;

    public at(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f7870d != null) {
                bj.c(jSONObject.toString(), this.f7870d);
            }
        } catch (Throwable th) {
            fz.c(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.f7870d;
            if (context != null) {
                return bj.a(jSONObject, context);
            }
            return null;
        } catch (JSONException e2) {
            fz.c(e2, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String a() {
        return "015";
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(ew.a aVar) {
        if (aVar == null || aVar.f8646f == null) {
            return null;
        }
        JSONObject optJSONObject = aVar.f8646f.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return optJSONObject;
    }

    public final void a(Context context) {
        this.f7870d = context;
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f8079a);
        return hashtable;
    }
}
