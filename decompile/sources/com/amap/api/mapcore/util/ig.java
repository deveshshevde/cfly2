package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.ff;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ig {

    /* renamed from: a  reason: collision with root package name */
    private ff f9227a = null;

    public ig(String str) {
        try {
            this.f9227a = new ff.a(str, "1.0", "1.0.0").a(new String[]{"info"}).a();
        } catch (eu unused) {
        }
    }

    private static ff a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(optJSONArray.getString(i2));
            }
            return new ff.a(optString, optString2, optString).a(optString3).a((String[]) arrayList.toArray(new String[0])).a();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static List<ff> a(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            ff ffVar = null;
            try {
                ffVar = a(jSONArray.getJSONObject(i2));
            } catch (JSONException unused) {
            }
            if (ffVar != null) {
                arrayList.add(ffVar);
            }
        }
        return arrayList;
    }

    private static JSONArray a(List<ff> list) {
        if (list.size() == 0) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (ff a2 : list) {
            jSONArray.put(a(a2));
        }
        return jSONArray;
    }

    private static JSONObject a(ff ffVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", ffVar.a());
            jSONObject.put("b", ffVar.b());
            jSONObject.put("c", ffVar.c());
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (ffVar.g() != null && i2 < ffVar.g().length) {
                jSONArray.put(ffVar.g()[i2]);
                i2++;
            }
            jSONObject.put("d", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final List<ff> a(Context context) {
        try {
            return a(new JSONArray(gl.a(context, this.f9227a, "rbck")));
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public final void a(Context context, ff ffVar) {
        if (ffVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ffVar);
            String jSONArray = a((List<ff>) arrayList).toString();
            if (!TextUtils.isEmpty(jSONArray)) {
                gl.a(context, this.f9227a, "rbck", jSONArray);
            }
        }
    }
}
