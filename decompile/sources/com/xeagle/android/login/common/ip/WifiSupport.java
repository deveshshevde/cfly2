package com.xeagle.android.login.common.ip;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.beans.WifiBean;
import java.util.ArrayList;
import java.util.List;

public class WifiSupport {
    private static final String TAG = "WifiSupport";

    public enum WifiCipherType {
        WIFICIPHER_WEP,
        WIFICIPHER_WPA,
        WIFICIPHER_NOPASS,
        WIFICIPHER_INVALID
    }

    public static boolean addNetWork(WifiConfiguration wifiConfiguration, Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            Log.i("device", "addNetWork: ----wifi info");
            wifiManager.disableNetwork(connectionInfo.getNetworkId());
        }
        Log.i("device", "addNetWork:---net id-- " + wifiConfiguration.networkId);
        if (wifiConfiguration.networkId > 0) {
            boolean enableNetwork = wifiManager.enableNetwork(wifiConfiguration.networkId, true);
            wifiManager.updateNetwork(wifiConfiguration);
            return enableNetwork;
        }
        int addNetwork = wifiManager.addNetwork(wifiConfiguration);
        if (addNetwork <= 0) {
            return false;
        }
        wifiManager.saveConfiguration();
        return wifiManager.enableNetwork(addNetwork, true);
    }

    public static void closeWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }

    public static boolean containName(List<ScanResult> list, String str) {
        for (ScanResult next : list) {
            if (!TextUtils.isEmpty(next.SSID) && next.SSID.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static WifiConfiguration createWifiConfig(String str, String str2, WifiCipherType wifiCipherType) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + str + "\"";
        if (wifiCipherType == WifiCipherType.WIFICIPHER_NOPASS) {
            wifiConfiguration.allowedKeyManagement.set(0);
        }
        if (wifiCipherType == WifiCipherType.WIFICIPHER_WEP) {
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (wifiCipherType == WifiCipherType.WIFICIPHER_WPA) {
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    public static String getCapabilitiesString(String str) {
        return str.contains("WEP") ? "WEP" : (str.contains("WPA") || str.contains("WPA2") || str.contains("WPS")) ? "WPA/WPA2" : "OPEN";
    }

    public static List getConfigurations(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConfiguredNetworks();
    }

    public static WifiInfo getConnectedWifiInfo(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
    }

    public static boolean getIsWifiEnabled(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static int getLevel(int i2) {
        if (Math.abs(i2) < 50) {
            return 1;
        }
        if (Math.abs(i2) < 75) {
            return 2;
        }
        return Math.abs(i2) < 90 ? 3 : 4;
    }

    public static void getReplace(Context context, List<WifiBean> list) {
        WifiInfo connectedWifiInfo = getConnectedWifiInfo(context);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (("\"" + list.get(i2).getWifiName() + "\"").equals(connectedWifiInfo.getSSID())) {
                arrayList.add(0, list.get(i2));
                arrayList.remove(i2 + 1);
                ((WifiBean) arrayList.get(0)).setState(context.getString(R.string.connected));
            }
        }
        list.clear();
        list.addAll(arrayList);
    }

    public static String getStringId(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(((i2 >> 0) & 255) + ".");
        stringBuffer.append(((i2 >> 8) & 255) + ".");
        stringBuffer.append(((i2 >> 16) & 255) + ".");
        stringBuffer.append((i2 >> 24) & 255);
        return stringBuffer.toString();
    }

    public static WifiCipherType getWifiCipher(String str) {
        return str.isEmpty() ? WifiCipherType.WIFICIPHER_INVALID : str.contains("WEP") ? WifiCipherType.WIFICIPHER_WEP : (str.contains("WPA") || str.contains("WPA2") || str.contains("WPS")) ? WifiCipherType.WIFICIPHER_WPA : WifiCipherType.WIFICIPHER_NOPASS;
    }

    public static List<ScanResult> getWifiScanResult(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getScanResults();
    }

    public static WifiConfiguration isExsits(String str, Context context) {
        for (WifiConfiguration next : ((WifiManager) context.getSystemService("wifi")).getConfiguredNetworks()) {
            String str2 = next.SSID;
            if (str2.equals("\"" + str + "\"")) {
                return next;
            }
        }
        return null;
    }

    public static boolean isOpenWifi(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static boolean isWifiEnable(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static List<ScanResult> noSameName(List<ScanResult> list) {
        ArrayList arrayList = new ArrayList();
        for (ScanResult next : list) {
            if (!TextUtils.isEmpty(next.SSID) && !containName(arrayList, next.SSID)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void openWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
    }
}
