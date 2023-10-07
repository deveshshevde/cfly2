package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class ir {
    public static int a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (Throwable th) {
            io.a(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : a(context, "pref", "smac", "00:00:00:00:00:00");
    }

    private static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            io.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor b2 = b(context, "pref");
            a(b2, "smac", str);
            a(b2);
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            editor.apply();
        }
    }

    private static void a(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            io.a(th, "SpUtil", "setPrefsStr");
        }
    }

    private static SharedPreferences.Editor b(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            io.a(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }
}
