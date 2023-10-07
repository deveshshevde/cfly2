package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

public final class DeviceUtils {
    private static final String KEY_UDID = "KEY_UDID";
    private static volatile String udid;

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String[] getABIs() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }

    public static String getAndroidID() {
        String string = Settings.Secure.getString(Utils.getApp().getContentResolver(), "android_id");
        return "9774d56d682e549c".equals(string) ? "" : string == null ? "" : string;
    }

    private static InetAddress getInetAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress().indexOf(58) < 0) {
                            return nextElement2;
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMacAddress() {
        String[] strArr = null;
        String macAddress = getMacAddress(strArr);
        if (!TextUtils.isEmpty(macAddress) || getWifiEnabled()) {
            return macAddress;
        }
        setWifiEnabled(true);
        setWifiEnabled(false);
        return getMacAddress(strArr);
    }

    public static String getMacAddress(String... strArr) {
        String macAddressByNetworkInterface = getMacAddressByNetworkInterface();
        if (isAddressNotInExcepts(macAddressByNetworkInterface, strArr)) {
            return macAddressByNetworkInterface;
        }
        String macAddressByInetAddress = getMacAddressByInetAddress();
        if (isAddressNotInExcepts(macAddressByInetAddress, strArr)) {
            return macAddressByInetAddress;
        }
        String macAddressByWifiInfo = getMacAddressByWifiInfo();
        if (isAddressNotInExcepts(macAddressByWifiInfo, strArr)) {
            return macAddressByWifiInfo;
        }
        String macAddressByFile = getMacAddressByFile();
        return isAddressNotInExcepts(macAddressByFile, strArr) ? macAddressByFile : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r0 = r0.successMsg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getMacAddressByFile() {
        /*
            java.lang.String r0 = "getprop wifi.interface"
            r1 = 0
            com.blankj.utilcode.util.ShellUtils$CommandResult r0 = com.blankj.utilcode.util.UtilsBridge.execCmd(r0, r1)
            int r2 = r0.result
            if (r2 != 0) goto L_0x0038
            java.lang.String r0 = r0.successMsg
            if (r0 == 0) goto L_0x0038
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cat /sys/class/net/"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "/address"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.blankj.utilcode.util.ShellUtils$CommandResult r0 = com.blankj.utilcode.util.UtilsBridge.execCmd(r0, r1)
            int r1 = r0.result
            if (r1 != 0) goto L_0x0038
            java.lang.String r0 = r0.successMsg
            if (r0 == 0) goto L_0x0038
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0038
            return r0
        L_0x0038:
            java.lang.String r0 = "02:00:00:00:00:00"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.DeviceUtils.getMacAddressByFile():java.lang.String");
    }

    private static String getMacAddressByInetAddress() {
        NetworkInterface byInetAddress;
        byte[] hardwareAddress;
        try {
            InetAddress inetAddress = getInetAddress();
            if (inetAddress == null || (byInetAddress = NetworkInterface.getByInetAddress(inetAddress)) == null || (hardwareAddress = byInetAddress.getHardwareAddress()) == null || hardwareAddress.length <= 0) {
                return "02:00:00:00:00:00";
            }
            StringBuilder sb = new StringBuilder();
            int length = hardwareAddress.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i2])}));
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    private static String getMacAddressByNetworkInterface() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    if (nextElement.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        if (hardwareAddress != null && hardwareAddress.length > 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                sb.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i2])}));
                            }
                            return sb.substring(0, sb.length() - 1);
                        }
                    }
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    private static String getMacAddressByWifiInfo() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "02:00:00:00:00:00";
            }
            String macAddress = connectionInfo.getMacAddress();
            return !TextUtils.isEmpty(macAddress) ? macAddress : "02:00:00:00:00:00";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", "") : "";
    }

    public static int getSDKVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static String getSDKVersionName() {
        return Build.VERSION.RELEASE;
    }

    private static String getUdid(String str, String str2) {
        if (str2.equals("")) {
            return str + UUID.randomUUID().toString().replace("-", "");
        }
        return str + UUID.nameUUIDFromBytes(str2.getBytes()).toString().replace("-", "");
    }

    public static String getUniqueDeviceId() {
        return getUniqueDeviceId("", true);
    }

    public static String getUniqueDeviceId(String str) {
        return getUniqueDeviceId(str, true);
    }

    public static String getUniqueDeviceId(String str, boolean z2) {
        if (!z2) {
            return getUniqueDeviceIdReal(str);
        }
        if (udid == null) {
            synchronized (DeviceUtils.class) {
                if (udid == null) {
                    String string = UtilsBridge.getSpUtils4Utils().getString(KEY_UDID, (String) null);
                    if (string != null) {
                        udid = string;
                        String str2 = udid;
                        return str2;
                    }
                    String uniqueDeviceIdReal = getUniqueDeviceIdReal(str);
                    return uniqueDeviceIdReal;
                }
            }
        }
        return udid;
    }

    public static String getUniqueDeviceId(boolean z2) {
        return getUniqueDeviceId("", z2);
    }

    private static String getUniqueDeviceIdReal(String str) {
        try {
            String androidID = getAndroidID();
            if (!TextUtils.isEmpty(androidID)) {
                return saveUdid(str + 2, androidID);
            }
        } catch (Exception unused) {
        }
        return saveUdid(str + 9, "");
    }

    private static boolean getWifiEnabled() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    public static boolean isAdbEnabled() {
        return Settings.Secure.getInt(Utils.getApp().getContentResolver(), "adb_enabled", 0) > 0;
    }

    private static boolean isAddressNotInExcepts(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || "02:00:00:00:00:00".equals(str)) {
            return false;
        }
        if (!(strArr == null || strArr.length == 0)) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDevelopmentSettingsEnabled() {
        return Settings.Global.getInt(Utils.getApp().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public static boolean isDeviceRooted() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 11; i2++) {
            String str = strArr[i2];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmulator() {
        String str;
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.toLowerCase().contains("vbox") || Build.FINGERPRINT.toLowerCase().contains("test-keys") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT)) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService("phone");
        if (telephonyManager == null || (str = telephonyManager.getNetworkOperatorName()) == null) {
            str = "";
        }
        if (str.toLowerCase().equals("android")) {
            return true;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        return intent.resolveActivity(Utils.getApp().getPackageManager()) == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSameDevice(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 33
            r2 = 0
            if (r0 == 0) goto L_0x0010
            int r0 = r6.length()
            if (r0 >= r1) goto L_0x0010
            return r2
        L_0x0010:
            java.lang.String r0 = udid
            boolean r0 = r6.equals(r0)
            r3 = 1
            if (r0 == 0) goto L_0x001a
            return r3
        L_0x001a:
            com.blankj.utilcode.util.SPUtils r0 = com.blankj.utilcode.util.UtilsBridge.getSpUtils4Utils()
            r4 = 0
            java.lang.String r5 = "KEY_UDID"
            java.lang.String r0 = r0.getString(r5, r4)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x002c
            return r3
        L_0x002c:
            int r0 = r6.length()
            int r0 = r0 - r1
            int r1 = r0 + 1
            java.lang.String r0 = r6.substring(r0, r1)
            java.lang.String r3 = "1"
            boolean r3 = r0.startsWith(r3)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0059
            java.lang.String r0 = getMacAddress()
            boolean r3 = r0.equals(r4)
            if (r3 == 0) goto L_0x004c
            return r2
        L_0x004c:
            java.lang.String r6 = r6.substring(r1)
            java.lang.String r0 = getUdid(r4, r0)
            boolean r6 = r6.equals(r0)
            return r6
        L_0x0059:
            java.lang.String r3 = "2"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = getAndroidID()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x004c
        L_0x006b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.DeviceUtils.isSameDevice(java.lang.String):boolean");
    }

    public static boolean isTablet() {
        return (Resources.getSystem().getConfiguration().screenLayout & 15) >= 3;
    }

    private static String saveUdid(String str, String str2) {
        udid = getUdid(str, str2);
        UtilsBridge.getSpUtils4Utils().put(KEY_UDID, udid);
        return udid;
    }

    private static void setWifiEnabled(boolean z2) {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager != null && z2 != wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(z2);
        }
    }
}
