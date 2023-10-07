package com.danikula.videocache;

import android.text.TextUtils;
import android.util.Log;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static boolean f11040a = true;

    public static void a(String str) {
        a("HttpProxyCacheDebuger", str);
    }

    public static void a(String str, Exception exc) {
        if (f11040a) {
            if (!TextUtils.isEmpty(str)) {
                Log.e("HttpProxyCacheDebuger", str);
            }
            exc.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        if (f11040a && str2 != null && !TextUtils.isEmpty(str2)) {
            Log.i(str, str2);
        }
    }

    public static void b(String str) {
        b("HttpProxyCacheDebuger", str);
    }

    public static void b(String str, String str2) {
        if (f11040a && str2 != null && !TextUtils.isEmpty(str2)) {
            Log.w(str, str2);
        }
    }

    public static void c(String str) {
        if (f11040a && !TextUtils.isEmpty(str)) {
            Log.e("HttpProxyCacheDebuger", str);
        }
    }

    public static void c(String str, String str2) {
        if (f11040a && !TextUtils.isEmpty(str2)) {
            Log.e(str, str2);
        }
    }
}
