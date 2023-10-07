package aq;

import android.content.Context;
import android.content.SharedPreferences;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f5556a;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences.Editor f5557b;

    public static int a(String str, int i2) {
        return f5556a.getInt(str, i2);
    }

    public static void a(Context context) {
        if (f5556a == null) {
            f5556a = context.getSharedPreferences("XEagle", 0);
        }
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor edit = f5556a.edit();
        f5557b = edit;
        edit.putString(str, str2);
        f5557b.apply();
    }

    public static void a(String str, boolean z2) {
        SharedPreferences.Editor edit = f5556a.edit();
        f5557b = edit;
        edit.putBoolean(str, z2);
        f5557b.apply();
    }

    public static String b(String str, String str2) {
        return f5556a.getString(str, str2);
    }

    public static boolean b(String str, boolean z2) {
        return f5556a.getBoolean(str, z2);
    }
}
