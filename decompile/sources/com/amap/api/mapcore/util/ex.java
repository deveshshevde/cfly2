package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class ex {

    /* renamed from: a  reason: collision with root package name */
    public static int f8670a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f8671b = "";

    /* renamed from: c  reason: collision with root package name */
    private static ff f8672c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f8673d = "http://apiinit.amap.com/v3/log/init";

    /* renamed from: e  reason: collision with root package name */
    private static String f8674e;

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String a2 = ey.a();
            hashMap.put("ts", a2);
            hashMap.put("key", ev.f(context));
            hashMap.put("scode", ey.a(context, a2, fg.d("resType=json&encode=UTF-8&key=" + ev.f(context))));
        } catch (Throwable th) {
            fw.a(th, "Auth", "gParams");
        }
        return hashMap;
    }

    @Deprecated
    public static synchronized boolean a(Context context, ff ffVar) {
        boolean b2;
        synchronized (ex.class) {
            b2 = b(context, ffVar);
        }
        return b2;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(fg.a(bArr));
            if (jSONObject.has("status")) {
                int i2 = jSONObject.getInt("status");
                if (i2 == 1) {
                    f8670a = 1;
                } else if (i2 == 0) {
                    f8670a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f8671b = jSONObject.getString("info");
            }
            if (f8670a == 0) {
                Log.i("AuthFailure", f8671b);
            }
            return f8670a == 1;
        } catch (JSONException e2) {
            fw.a((Throwable) e2, "Auth", "lData");
            return false;
        }
    }

    private static boolean b(Context context, ff ffVar) {
        f8672c = ffVar;
        try {
            String str = f8673d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", f8672c.d());
            hashMap.put("X-INFO", ey.b(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{f8672c.b(), f8672c.a()}));
            gw a2 = gw.a();
            fh fhVar = new fh();
            fhVar.setProxy(fe.a(context));
            fhVar.a((Map<String, String>) hashMap);
            fhVar.b(a(context));
            fhVar.a(str);
            return a(a2.a(fhVar));
        } catch (Throwable th) {
            fw.a(th, "Auth", "getAuth");
            return true;
        }
    }
}
