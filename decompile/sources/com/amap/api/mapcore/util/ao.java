package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ew;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

public final class ao extends bk<String, an> {
    public ao(Context context, String str) {
        super(context, str);
    }

    private static an b(JSONObject jSONObject) throws AMapException {
        an anVar = new an();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                anVar.a(false);
            } else if (optString.equals("1")) {
                anVar.a(true);
            }
            anVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            fz.c(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return anVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(JSONObject jSONObject) throws AMapException {
        return b(jSONObject);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        return "016";
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(ew.a aVar) {
        if (aVar == null || aVar.f8646f == null) {
            return null;
        }
        return aVar.f8646f.optJSONObject("016");
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f8079a);
        return hashtable;
    }
}
