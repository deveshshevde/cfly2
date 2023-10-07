package com.xeagle.android.hicamera.unity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private WifiManager f23748a;

    /* renamed from: b  reason: collision with root package name */
    private List<ScanResult> f23749b;

    /* renamed from: c  reason: collision with root package name */
    private Context f23750c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23751d = false;

    public b(Context context, boolean z2) {
        this.f23748a = (WifiManager) context.getSystemService("wifi");
        this.f23750c = context;
        if (z2) {
            Log.d("HiWifiManager", "bOpenWifi mBEnable = " + this.f23751d);
            this.f23751d = c();
        }
    }

    private void a(WifiConfiguration wifiConfiguration) {
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.hiddenSSID = true;
        wifiConfiguration.allowedAuthAlgorithms.set(0);
        wifiConfiguration.allowedGroupCiphers.set(2);
        wifiConfiguration.allowedKeyManagement.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(1);
        wifiConfiguration.allowedGroupCiphers.set(3);
        wifiConfiguration.allowedPairwiseCiphers.set(2);
        wifiConfiguration.status = 2;
    }

    private void a(boolean z2) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f23750c);
        if (defaultSharedPreferences.getString("dv_device_wifi_enable", (String) null) == null) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putString("dv_device_wifi_enable", "" + z2);
            if (true == z2) {
                String b2 = b();
                Log.d("HiWifiManager", "strSSID:" + b2);
                if (b2 != null) {
                    edit.putString("start_wifi_ssid", b2);
                }
            }
            edit.commit();
        }
    }

    private WifiConfiguration c(String str) {
        String str2;
        List<WifiConfiguration> configuredNetworks = this.f23748a.getConfiguredNetworks();
        if (configuredNetworks == null) {
            str2 = "findConfigration:null";
        } else {
            Log.d("HiWifiManager", "wifiConfig.size = " + configuredNetworks.size());
            for (int i2 = 0; i2 < configuredNetworks.size(); i2++) {
                if (str.equals(configuredNetworks.get(i2).SSID)) {
                    return configuredNetworks.get(i2);
                }
            }
            str2 = "find device configuration failed! " + str;
        }
        Log.d("HiWifiManager", str2);
        return null;
    }

    private boolean c() {
        if (this.f23748a.isWifiEnabled()) {
            a(true);
            return true;
        }
        a(false);
        return this.f23748a.setWifiEnabled(true);
    }

    public int a(String str, String str2) {
        int i2;
        List<WifiConfiguration> configuredNetworks = this.f23748a.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return -1;
        }
        if (configuredNetworks.size() > 0) {
            Log.d("HiWifiManager", str);
        }
        if (!str.startsWith("\"")) {
            str = "\"" + str + "\"";
        }
        if (!str2.startsWith("\"")) {
            str2 = "\"" + str2 + "\"";
        }
        int b2 = b(str);
        if (b2 < 0) {
            return b2;
        }
        WifiConfiguration c2 = c(str);
        if (c2 == null) {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = str;
            if (str2.equals("\"\"")) {
                wifiConfiguration.allowedKeyManagement.clear();
                wifiConfiguration.allowedKeyManagement.set(0);
            } else {
                wifiConfiguration.preSharedKey = str2;
                a(wifiConfiguration);
            }
            i2 = this.f23748a.addNetwork(wifiConfiguration);
            if (i2 != -1) {
                this.f23748a.enableNetwork(i2, true);
            }
            Log.d("HiWifiManager", "netID = " + i2 + ":wifiConfig.networkId" + wifiConfiguration.networkId);
        } else {
            if (str2.equals("\"\"")) {
                c2.wepKeys[0] = "";
                c2.allowedKeyManagement.clear();
                c2.allowedKeyManagement.set(0);
            } else {
                c2.preSharedKey = str2;
                a(c2);
            }
            this.f23748a.updateNetwork(c2);
            i2 = c2.networkId;
            if (i2 >= 0) {
                this.f23748a.enableNetwork(i2, true);
            }
        }
        Log.d("HiWifiManager", "connectNetwork:" + i2);
        return i2;
    }

    public String a() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.f23750c).getString("wifi_last_Connected_SSID", "");
        Log.d("HiWifiManager", "getLastConnectDeviceInfo ssid:" + string);
        return string;
    }

    public String a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Log.d("HiWifiManager", "getDevicePassword SSID:" + str);
        String string = PreferenceManager.getDefaultSharedPreferences(this.f23750c).getString(str, (String) null);
        Log.d("HiWifiManager", "getDevicePassword strPassWord:" + string);
        return string;
    }

    public int b(String str) {
        if (str != null && !str.equals("")) {
            Log.d("HiWifiManager", str);
            this.f23748a.startScan();
            List<ScanResult> scanResults = this.f23748a.getScanResults();
            this.f23749b = scanResults;
            if (!(scanResults == null || scanResults.size() == 0)) {
                if (str.startsWith("\"")) {
                    str = str.substring(1);
                }
                if (str.endsWith("\"")) {
                    str = str.substring(0, str.length() - 1);
                }
                for (int i2 = 0; i2 < this.f23749b.size(); i2++) {
                    if (str.equals(this.f23749b.get(i2).SSID)) {
                        return i2;
                    }
                }
                return -3;
            }
        }
        return -2;
    }

    public String b() {
        WifiInfo connectionInfo = this.f23748a.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        Log.d("HiWifiManager", "getConnectWifiName:" + connectionInfo.getSSID());
        String ssid = connectionInfo.getSSID();
        if (ssid == null) {
            return null;
        }
        return (!ssid.endsWith("\"") || !ssid.startsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }
}
