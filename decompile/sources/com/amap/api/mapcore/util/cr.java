package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;

public final class cr {

    /* renamed from: a  reason: collision with root package name */
    static String f8196a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 80; i2++) {
            sb.append("=");
        }
        f8196a = sb.toString();
    }

    public static void a() {
        c(f8196a);
        c("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        c(f8196a);
    }

    public static void a(Context context, String str) {
        c(f8196a);
        if (context != null) {
            b("key:" + ev.f(context));
        }
        c(str);
        c(f8196a);
    }

    public static void a(String str) {
        c(f8196a);
        c(str);
        c(f8196a);
    }

    private static void b(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            sb.append(str);
            for (int i2 = 0; i2 < 78 - str.length(); i2++) {
                sb.append(" ");
            }
            sb.append("|");
            c(sb.toString());
            return;
        }
        String substring = str.substring(0, 78);
        c("|" + substring + "|");
        b(str.substring(78));
    }

    private static void c(String str) {
        Log.i("authErrLog", str);
    }
}
