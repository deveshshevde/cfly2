package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;

final class zzfg {
    static void zza(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }
}
