package com.flypro.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f11626a = true;

    /* renamed from: c  reason: collision with root package name */
    private static WifiManager f11627c = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f11628i = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f11629b;

    /* renamed from: d  reason: collision with root package name */
    private WifiInfo f11630d;

    /* renamed from: e  reason: collision with root package name */
    private List<ScanResult> f11631e;

    /* renamed from: f  reason: collision with root package name */
    private List<WifiConfiguration> f11632f;

    /* renamed from: g  reason: collision with root package name */
    private ConnectivityManager f11633g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11634h = false;

    public e(Context context) {
        this.f11629b = context;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        f11627c = wifiManager;
        this.f11630d = wifiManager.getConnectionInfo();
        this.f11633g = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public void a() {
        if (!f11627c.isWifiEnabled()) {
            f11627c.setWifiEnabled(true);
        }
    }

    public void a(String str, String str2, String str3) {
        BitSet bitSet;
        String str4 = "\"" + str + "\"";
        String str5 = "\"" + str2 + "\"";
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = str4;
        str3.hashCode();
        char c2 = 65535;
        switch (str3.hashCode()) {
            case 85826:
                if (str3.equals("WEP")) {
                    c2 = 0;
                    break;
                }
                break;
            case 86152:
                if (str3.equals("WPA")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2432586:
                if (str3.equals("OPEN")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                wifiConfiguration.wepKeys[0] = str5;
                wifiConfiguration.wepTxKeyIndex = 0;
                wifiConfiguration.allowedKeyManagement.set(0);
                bitSet = wifiConfiguration.allowedGroupCiphers;
                break;
            case 1:
                wifiConfiguration.preSharedKey = str5;
                break;
            case 2:
                bitSet = wifiConfiguration.allowedKeyManagement;
                break;
        }
        bitSet.set(0);
        WifiManager wifiManager = (WifiManager) this.f11629b.getApplicationContext().getSystemService("wifi");
        if (f11626a || wifiManager != null) {
            wifiManager.addNetwork(wifiConfiguration);
            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            if (configuredNetworks != null && !configuredNetworks.isEmpty()) {
                for (WifiConfiguration next : configuredNetworks) {
                    if (next.SSID != null && next.SSID.equals(str4)) {
                        wifiManager.disconnect();
                        if (next.networkId >= 0) {
                            wifiManager.enableNetwork(next.networkId, true);
                            wifiManager.reconnect();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23) {
            return j();
        }
        if (f11626a || connectivityManager != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        }
        throw new AssertionError();
    }

    public boolean b() {
        return f11627c.isWifiEnabled();
    }

    public boolean c() {
        return i().contains("Drone") || i().contains("Controller") || i().contains("Ground") || i().contains("MT") || i().contains("BRG");
    }

    public void d() {
        f11627c.startScan();
        this.f11631e = f11627c.getScanResults();
        this.f11632f = f11627c.getConfiguredNetworks();
    }

    public List<ScanResult> e() {
        return this.f11631e;
    }

    public int f() {
        WifiInfo wifiInfo = this.f11630d;
        if (wifiInfo == null) {
            return 0;
        }
        return wifiInfo.getIpAddress();
    }

    public String g() {
        int f2 = f();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(f2 & 255), Integer.valueOf((f2 >> 8) & 255), Integer.valueOf((f2 >> 16) & 255), Integer.valueOf((f2 >> 24) & 255)});
    }

    public int h() {
        WifiInfo connectionInfo = f11627c.getConnectionInfo();
        this.f11630d = connectionInfo;
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getRssi();
    }

    public String i() {
        WifiInfo connectionInfo = f11627c.getConnectionInfo();
        this.f11630d = connectionInfo;
        return connectionInfo == null ? "-" : connectionInfo.getSSID();
    }

    public boolean j() {
        try {
            return Runtime.getRuntime().exec("ping -c 1 -w 3 8.8.8.8").waitFor() == 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
