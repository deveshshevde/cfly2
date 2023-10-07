package com.xeagle.android.login.common;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

public class StaticIpConfigurationFor2 {
    public static void setStaticIpX(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Settings.System.putInt(contentResolver, "wifi_use_static_ip", 1);
        Settings.System.putString(contentResolver, "wifi_static_ip", str);
    }
}
