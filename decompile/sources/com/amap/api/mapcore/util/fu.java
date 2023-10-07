package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fu {

    /* renamed from: a  reason: collision with root package name */
    private ff f8840a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, fu> f8841a = new HashMap();
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f8842a;

        /* renamed from: b  reason: collision with root package name */
        private String f8843b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f8844c;

        public b(String str, String str2, String str3) {
            this.f8842a = str;
            this.f8843b = str2;
            this.f8844c = str3;
        }

        private static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public static List<b> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it2 = list.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (next != null) {
                    if (next != null && !TextUtils.isEmpty(next.f8844c)) {
                        jSONArray.put(next.a());
                    }
                }
            }
            return jSONArray;
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f8842a);
                jSONObject.put("cpuType", this.f8843b);
                jSONObject.put("content", this.f8844c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public final boolean a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f8842a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f8843b;
            }
            return this.f8842a.equals(str) && this.f8843b.equals(str2);
        }
    }

    private fu(ff ffVar) {
        this.f8840a = ffVar;
    }

    public static fu a(ff ffVar) {
        if (ffVar == null || TextUtils.isEmpty(ffVar.a())) {
            return null;
        }
        if (a.f8841a.get(ffVar.a()) == null) {
            a.f8841a.put(ffVar.a(), new fu(ffVar));
        }
        return a.f8841a.get(ffVar.a());
    }

    private static String a(Context context, String str, String str2) {
        return b(context, "C7ADB20F22F238708BA5EE26D0401DB9" + fd.b(str), "ik".concat(String.valueOf(str2)));
    }

    private static String b(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : fg.a(et.b(fg.e(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    private static void b(Context context, String str, String str2, String str3) {
        if (str3 != null && !TextUtils.isEmpty(str)) {
            c(context, "C7ADB20F22F238708BA5EE26D0401DB9" + fd.b(str), "ik".concat(String.valueOf(str2)), str3);
        }
    }

    private static void c(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            String g2 = fg.g(et.a(fg.a(str3)));
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, g2);
            edit.commit();
        }
    }

    public final String a(Context context, String str, String str2, String str3) {
        ff ffVar;
        if (!(context == null || (ffVar = this.f8840a) == null || TextUtils.isEmpty(ffVar.a()))) {
            List<b> a2 = b.a(a(context, this.f8840a.a(), str3));
            if (a2.size() == 0) {
                return "";
            }
            for (int i2 = 0; i2 < a2.size(); i2++) {
                b bVar = a2.get(i2);
                if (bVar.a(str, str2)) {
                    return bVar.f8844c;
                }
            }
        }
        return null;
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        ff ffVar;
        if (context != null && (ffVar = this.f8840a) != null && !TextUtils.isEmpty(ffVar.a())) {
            List<b> a2 = b.a(a(context, this.f8840a.a(), str3));
            int i2 = 0;
            while (true) {
                if (i2 >= a2.size()) {
                    a2.add(new b(str, str2, str4));
                    break;
                }
                b bVar = a2.get(i2);
                if (bVar.a(str, str2)) {
                    String unused = bVar.f8844c = str4;
                    break;
                }
                i2++;
            }
            b(context, this.f8840a.a(), str3, b.a(a2).toString());
        }
    }
}
