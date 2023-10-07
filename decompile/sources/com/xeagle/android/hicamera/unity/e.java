package com.xeagle.android.hicamera.unity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import kf.b;

public class e {
    public static boolean a(Context context) {
        String simpleName;
        String str;
        if (!((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            simpleName = context.getClass().getSimpleName();
            str = "isDeviceAvailable() WIFI Disabled";
        } else if (b.f30003b.k() != null) {
            return true;
        } else {
            simpleName = context.getClass().getSimpleName();
            str = "isDeviceAvailable() CGI test failed";
        }
        Log.e(simpleName, str);
        return false;
    }
}
