package com.xeagle.android.camera.widgets.ablum;

import android.content.Context;
import android.content.SharedPreferences;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f22436a;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences.Editor f22437b;

    public static SharedPreferences a(Context context) {
        if (f22436a == null) {
            f22436a = context.getSharedPreferences("XEagleApp", 0);
        }
        return f22436a;
    }

    public static void a(String str, float f2) {
        SharedPreferences.Editor edit = f22436a.edit();
        f22437b = edit;
        edit.putFloat(str, f2);
        f22437b.apply();
    }

    public static void a(String str, int i2) {
        SharedPreferences.Editor edit = f22436a.edit();
        f22437b = edit;
        edit.putInt(str, i2);
        f22437b.apply();
    }

    public static void a(String str, long j2) {
        SharedPreferences.Editor edit = f22436a.edit();
        f22437b = edit;
        edit.putLong(str, j2);
        f22437b.apply();
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor edit = f22436a.edit();
        f22437b = edit;
        edit.putString(str, str2);
        f22437b.apply();
    }

    public static void a(String str, boolean z2) {
        SharedPreferences.Editor edit = f22436a.edit();
        f22437b = edit;
        edit.putBoolean(str, z2);
        f22437b.apply();
    }

    public static int b(String str, int i2) {
        return f22436a.getInt(str, i2);
    }

    public static long b(String str, long j2) {
        return f22436a.getLong(str, j2);
    }

    public static String b(String str, String str2) {
        return f22436a.getString(str, str2);
    }

    public static void b(Context context) {
        if (f22436a == null) {
            f22436a = context.getSharedPreferences("XEagleApp", 0);
        }
    }

    public static boolean b(String str, boolean z2) {
        return f22436a.getBoolean(str, z2);
    }
}
