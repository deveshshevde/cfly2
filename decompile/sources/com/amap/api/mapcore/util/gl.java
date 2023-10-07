package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

public final class gl {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f8930a = new HashMap<>();

    public static String a(Context context, ff ffVar, String str) {
        if (ffVar == null || TextUtils.isEmpty(ffVar.a())) {
            return null;
        }
        String str2 = f8930a.get(ffVar.a() + str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = str + ffVar.a();
        return (context == null || TextUtils.isEmpty(str3)) ? "" : fg.a(et.b(fg.e(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
    }

    public static void a(Context context, ff ffVar, String str, String str2) {
        if (ffVar != null && !TextUtils.isEmpty(ffVar.a())) {
            String str3 = str + ffVar.a();
            f8930a.put(ffVar.a() + str, str2);
            if (context != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") && !TextUtils.isEmpty(str2)) {
                String g2 = fg.g(et.a(fg.a(str2)));
                SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
                edit.putString(str3, g2);
                edit.commit();
            }
        }
    }
}
