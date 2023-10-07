package com.huawei.android.multiscreen.dlna.sdk.networkmanager.wifinetwork;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import ie.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f20912a;

    /* renamed from: b  reason: collision with root package name */
    private static WifiManager f20913b;

    /* renamed from: c  reason: collision with root package name */
    private static ConnectivityManager f20914c;

    /* renamed from: d  reason: collision with root package name */
    private String f20915d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f20916e;

    private c() {
        Context d2 = b.a().d();
        if (d2 != null) {
            f20913b = (WifiManager) d2.getSystemService("wifi");
            f20914c = (ConnectivityManager) d2.getSystemService("connectivity");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(d2);
            this.f20916e = defaultSharedPreferences;
            this.f20915d = defaultSharedPreferences.getString("LastWifiConnectedName", "");
        }
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f20912a == null) {
                f20912a = new c();
            }
            cVar = f20912a;
        }
        return cVar;
    }

    public String b() {
        if (f20913b.getConnectionInfo() == null) {
            return null;
        }
        WifiInfo connectionInfo = f20913b.getConnectionInfo();
        if (connectionInfo == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (macAddress != null && 17 == macAddress.length()) {
            char[] charArray = macAddress.toCharArray();
            StringBuffer stringBuffer = new StringBuffer(12);
            stringBuffer.append(charArray[0]);
            stringBuffer.append(charArray[1]);
            stringBuffer.append(charArray[3]);
            stringBuffer.append(charArray[4]);
            stringBuffer.append(charArray[6]);
            stringBuffer.append(charArray[7]);
            stringBuffer.append(charArray[9]);
            stringBuffer.append(charArray[10]);
            stringBuffer.append(charArray[12]);
            stringBuffer.append(charArray[13]);
            stringBuffer.append(charArray[15]);
            stringBuffer.append(charArray[16]);
            macAddress = stringBuffer.toString();
        }
        a.b("WifiStateManager", "getMacAddress:" + macAddress);
        return macAddress;
    }

    public String c() {
        if (f20913b.getConnectionInfo() != null) {
            return f20913b.getConnectionInfo().getBSSID();
        }
        return null;
    }
}
