package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gk {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static gk f8929a = new gk();
    }

    private static ff a(String str, List<ff> list) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        while (list != null && i2 < list.size()) {
            ff ffVar = list.get(i2);
            if (ffVar != null) {
                String[] g2 = ffVar.g();
                for (int i3 = 0; i3 < g2.length; i3++) {
                    if (!TextUtils.isEmpty(g2[i2]) && str.contains(g2[i3])) {
                        return ffVar;
                    }
                }
                continue;
            }
            i2++;
        }
        return null;
    }

    private static JSONArray a(String str) {
        if (str == null) {
            str = "";
        }
        String[] strArr = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", "main"};
        JSONArray jSONArray = new JSONArray();
        for (Thread next : Thread.getAllStackTraces().keySet()) {
            if (next != null && !str.equals(next.getName())) {
                for (int i2 = 0; i2 < 6; i2++) {
                    String str2 = strArr[i2];
                    String name = next.getName();
                    if ((!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(name) && (str2.contains(name) || name.contains(str2))) && a(next) != null) {
                        jSONArray.put(a(next));
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement append : stackTrace) {
                stringBuffer.append(append);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean a(Context context, String str, String str2, List<ff> list, boolean z2, ff ffVar) {
        Thread next;
        String str3 = "";
        if (str2 != null) {
            Iterator<Thread> it2 = Thread.getAllStackTraces().keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str3 = null;
                    break;
                }
                next = it2.next();
                if (next != null && !TextUtils.isEmpty(next.getName())) {
                    if (str2.contains(next.getName()) || next.getName().contains(str2)) {
                        StackTraceElement[] stackTrace = next.getStackTrace();
                    }
                }
            }
            StackTraceElement[] stackTrace2 = next.getStackTrace();
            if (stackTrace2 != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (StackTraceElement append : stackTrace2) {
                    stringBuffer.append("at ");
                    stringBuffer.append(append);
                    stringBuffer.append("<br />");
                }
                str3 = stringBuffer.toString();
            }
        }
        ff a2 = a(str3, list);
        if (z2 && a2 == null) {
            return false;
        }
        String str4 = str + "<br />" + str3;
        JSONArray a3 = a(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", a3);
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        if (z2 || a2 != null) {
            fz.a(context, a2, jSONObject2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
        } else {
            try {
                fz.b(context, ffVar, jSONObject2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
                return true;
            } catch (Throwable unused2) {
            }
        }
        return true;
    }
}
