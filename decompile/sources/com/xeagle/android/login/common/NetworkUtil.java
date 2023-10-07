package com.xeagle.android.login.common;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NetworkUtil {
    private static final String CONNECT_TYPE_CMNET = "cmnet";
    private static final String CONNECT_TYPE_CMWAP = "cmwap";
    private static final String CONNECT_TYPE_CTNET = "ctnet";
    private static final String CONNECT_TYPE_CTWAP = "ctwap";
    private static final String CONNECT_TYPE_UNI3GNET = "3gnet";
    private static final String CONNECT_TYPE_UNI3GWAP = "3gwap";
    private static final String CONNECT_TYPE_UNINET = "uninet";
    private static final String CONNECT_TYPE_UNIWAP = "uniwap";
    private static final String CONNECT_TYPE_WIFI = "wifi";
    public static final byte CURRENT_NETWORK_TYPE_CM = 12;
    public static final byte CURRENT_NETWORK_TYPE_CMNET = 6;
    public static final byte CURRENT_NETWORK_TYPE_CMWAP = 4;
    public static final byte CURRENT_NETWORK_TYPE_CTC = 10;
    public static final byte CURRENT_NETWORK_TYPE_CTNET = 2;
    public static final byte CURRENT_NETWORK_TYPE_CTWAP = 3;
    public static final byte CURRENT_NETWORK_TYPE_CUC = 11;
    public static final byte CURRENT_NETWORK_TYPE_NONE = 0;
    public static final byte CURRENT_NETWORK_TYPE_UNIET = 7;
    public static final byte CURRENT_NETWORK_TYPE_UNIWAP = 5;
    public static final byte CURRENT_NETWORK_TYPE_WIFI = 1;
    public static final int ISP_CMCC = 2;
    public static final int ISP_CTCC = 0;
    public static final int ISP_CTT = 3;
    public static final int ISP_CUCC = 1;
    public static final int ISP_OTHERS = -1;
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = 10;
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static final String TAG = "NetworkUtil";
    public static byte curNetworkType = 0;

    public interface LinkNetWorkType {
        public static final int UNKNOWN = 0;
        public static final int WIFI = 1;
        public static final int WWAN = 2;
        public static final int _2G = 3;
        public static final int _3G = 4;
        public static final int _4G = 5;
    }

    public enum NetworkSpeedMode {
        LOW,
        NORMAL,
        HIGH,
        UNKNOWN
    }

    public static String getActiveMacAddress(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService(CONNECT_TYPE_WIFI)).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : "";
    }

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getApnType(Context context) {
        Cursor query = context.getContentResolver().query(PREFERRED_APN_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        String str = "nomatch";
        if (query != null) {
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("user"));
                if (string != null && string.startsWith(CONNECT_TYPE_CTNET)) {
                    str = CONNECT_TYPE_CTNET;
                } else if (string != null && string.startsWith(CONNECT_TYPE_CTWAP)) {
                    str = CONNECT_TYPE_CTWAP;
                } else if (string != null && string.startsWith(CONNECT_TYPE_CMWAP)) {
                    str = CONNECT_TYPE_CMWAP;
                } else if (string != null && string.startsWith(CONNECT_TYPE_CMNET)) {
                    str = CONNECT_TYPE_CMNET;
                } else if (string != null && string.startsWith(CONNECT_TYPE_UNIWAP)) {
                    str = CONNECT_TYPE_UNIWAP;
                } else if (string != null && string.startsWith(CONNECT_TYPE_UNINET)) {
                    str = CONNECT_TYPE_UNINET;
                } else if (string != null && string.startsWith(CONNECT_TYPE_UNI3GWAP)) {
                    str = CONNECT_TYPE_UNI3GWAP;
                } else if (string != null && string.startsWith(CONNECT_TYPE_UNI3GNET)) {
                    str = CONNECT_TYPE_UNI3GNET;
                }
            }
            query.close();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte getCurrentNetType(android.content.Context r17) {
        /*
            android.net.NetworkInfo r0 = getActiveNetworkInfo(r17)
            java.lang.String r1 = "3gnet"
            java.lang.String r2 = "uninet"
            java.lang.String r3 = "3gwap"
            java.lang.String r5 = "uniwap"
            r6 = 4
            java.lang.String r7 = "cmnet"
            r8 = 3
            java.lang.String r9 = "cmwap"
            r10 = 2
            java.lang.String r11 = "ctwap"
            java.lang.String r12 = "ctnet"
            r13 = 7
            r14 = 5
            if (r0 == 0) goto L_0x007c
            java.lang.String r15 = r0.getExtraInfo()
            boolean r16 = android.text.TextUtils.isEmpty(r15)
            if (r16 == 0) goto L_0x0029
            java.lang.String r15 = r0.getTypeName()
        L_0x0029:
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x007c
            java.lang.String r0 = r15.toLowerCase()
            java.lang.String r15 = "wifi"
            int r15 = r0.indexOf(r15)
            r4 = -1
            if (r15 <= r4) goto L_0x003e
            r0 = 1
            goto L_0x007d
        L_0x003e:
            int r15 = r0.indexOf(r12)
            if (r15 <= r4) goto L_0x0046
            r0 = 2
            goto L_0x007d
        L_0x0046:
            int r15 = r0.indexOf(r11)
            if (r15 <= r4) goto L_0x004e
            r0 = 3
            goto L_0x007d
        L_0x004e:
            int r15 = r0.indexOf(r7)
            if (r15 <= r4) goto L_0x0056
            r0 = 6
            goto L_0x007d
        L_0x0056:
            int r15 = r0.indexOf(r9)
            if (r15 <= r4) goto L_0x005e
            r0 = 4
            goto L_0x007d
        L_0x005e:
            int r15 = r0.indexOf(r5)
            if (r15 <= r4) goto L_0x0066
        L_0x0064:
            r0 = 5
            goto L_0x007d
        L_0x0066:
            int r15 = r0.indexOf(r3)
            if (r15 <= r4) goto L_0x006d
            goto L_0x0064
        L_0x006d:
            int r15 = r0.indexOf(r2)
            if (r15 <= r4) goto L_0x0075
        L_0x0073:
            r0 = 7
            goto L_0x007d
        L_0x0075:
            int r0 = r0.indexOf(r1)
            if (r0 <= r4) goto L_0x007c
            goto L_0x0073
        L_0x007c:
            r0 = 0
        L_0x007d:
            if (r0 != 0) goto L_0x00d1
            java.lang.String r4 = getApnType(r17)
            if (r4 == 0) goto L_0x008d
            boolean r12 = r4.equals(r12)
            if (r12 == 0) goto L_0x008d
            r4 = 2
            goto L_0x00d2
        L_0x008d:
            if (r4 == 0) goto L_0x0097
            boolean r10 = r4.equals(r11)
            if (r10 == 0) goto L_0x0097
            r4 = 3
            goto L_0x00d2
        L_0x0097:
            if (r4 == 0) goto L_0x00a1
            boolean r8 = r4.equals(r9)
            if (r8 == 0) goto L_0x00a1
            r4 = 4
            goto L_0x00d2
        L_0x00a1:
            if (r4 == 0) goto L_0x00ab
            boolean r6 = r4.equals(r7)
            if (r6 == 0) goto L_0x00ab
            r4 = 6
            goto L_0x00d2
        L_0x00ab:
            if (r4 == 0) goto L_0x00b5
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b5
        L_0x00b3:
            r4 = 5
            goto L_0x00d2
        L_0x00b5:
            if (r4 == 0) goto L_0x00be
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00be
            goto L_0x00b3
        L_0x00be:
            if (r4 == 0) goto L_0x00c8
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00c8
        L_0x00c6:
            r4 = 7
            goto L_0x00d2
        L_0x00c8:
            if (r4 == 0) goto L_0x00d1
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00d1
            goto L_0x00c6
        L_0x00d1:
            r4 = r0
        L_0x00d2:
            curNetworkType = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.NetworkUtil.getCurrentNetType(android.content.Context):byte");
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static int getNetworkClass(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                return 10;
            }
        }
        return 0;
    }

    public static boolean getNetworkConnectionStatus(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return false;
        }
        return (telephonyManager.getDataState() == 2 || telephonyManager.getDataState() == 0) && activeNetworkInfo.isAvailable();
    }

    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return activeNetworkInfo.getTypeName();
        }
        StringBuilder sb = new StringBuilder();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        sb.append(activeNetworkInfo.getTypeName());
        sb.append(" [");
        if (telephonyManager != null) {
            sb.append(telephonyManager.getNetworkOperatorName());
            sb.append("#");
        }
        sb.append(activeNetworkInfo.getSubtypeName());
        sb.append("]");
        return sb.toString();
    }

    public static String getNetworkOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperator();
        }
        return null;
    }

    public static byte getNetworkOperators(byte b2) {
        if (b2 == 0) {
            return 0;
        }
        if (b2 == 1) {
            return 1;
        }
        if (b2 == 2 || b2 == 3) {
            return 10;
        }
        if (b2 == 4 || b2 == 6) {
            return CURRENT_NETWORK_TYPE_CM;
        }
        if (b2 == 5 || b2 == 7) {
            return CURRENT_NETWORK_TYPE_CUC;
        }
        return 0;
    }

    public static byte getNetworkOperators(Context context) {
        if (isWifi(context)) {
            return 1;
        }
        if (isCtcNetwork(context)) {
            return 10;
        }
        if (isCmbNetwork(context)) {
            return CURRENT_NETWORK_TYPE_CM;
        }
        if (isCucNetwork(context)) {
            return CURRENT_NETWORK_TYPE_CUC;
        }
        return 0;
    }

    public static String getNetworkProxyInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        String valueOf = String.valueOf(defaultPort);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (((lowerCase = activeNetworkInfo.getTypeName().toLowerCase()) != null && lowerCase.equals(CONNECT_TYPE_WIFI)) || defaultHost == null || defaultPort <= 0 || defaultPort >= 65535)) {
            return null;
        }
        return defaultHost + ":" + valueOf;
    }

    public static int getNetworkProxyPort() {
        return Proxy.getDefaultPort();
    }

    public static String getNetworkProxyUrl() {
        if (curNetworkType == 1) {
            return null;
        }
        String defaultHost = Proxy.getDefaultHost();
        Log.e(TAG, "proxyHost:" + defaultHost);
        return defaultHost;
    }

    public static String getNetworkProxyUrl(Context context) {
        if (isWifi(context)) {
            return null;
        }
        String defaultHost = Proxy.getDefaultHost();
        Log.e(TAG, "proxyHost:" + defaultHost);
        return defaultHost;
    }

    public static NetworkSpeedMode getNetworkSpeedModeInMobile(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0)) {
            switch (activeNetworkInfo.getSubtype()) {
                case 0:
                    return NetworkSpeedMode.NORMAL;
                case 1:
                    return NetworkSpeedMode.LOW;
                case 2:
                    return NetworkSpeedMode.LOW;
                case 3:
                    return NetworkSpeedMode.NORMAL;
                case 4:
                    return NetworkSpeedMode.LOW;
                case 5:
                    return NetworkSpeedMode.NORMAL;
                case 6:
                    return NetworkSpeedMode.NORMAL;
                case 7:
                    return NetworkSpeedMode.LOW;
                case 8:
                    return NetworkSpeedMode.HIGH;
                case 9:
                    return NetworkSpeedMode.HIGH;
                case 10:
                    return NetworkSpeedMode.NORMAL;
                case 11:
                    return NetworkSpeedMode.LOW;
                case 12:
                    return NetworkSpeedMode.NORMAL;
                case 13:
                    return NetworkSpeedMode.HIGH;
                case 14:
                    return NetworkSpeedMode.NORMAL;
                case 15:
                    return NetworkSpeedMode.HIGH;
            }
        }
        return NetworkSpeedMode.UNKNOWN;
    }

    public static int getNetworkTypeForLink(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return 1;
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 4;
                        case 13:
                            return 5;
                        default:
                            return 3;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static String getNetworkTypeName(int i2) {
        switch (i2) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE_MMS";
            case 3:
                return "MOBILE_SUPL";
            case 4:
                return "MOBILE_DUN";
            case 5:
                return "MOBILE_HIPRI";
            case 6:
                return "WIMAX";
            case 7:
                return "BLUETOOTH";
            case 8:
                return "DUMMY";
            case 9:
                return "ETHERNET";
            case 10:
                return "MOBILE_FOTA";
            case 11:
                return "MOBILE_IMS";
            case 12:
                return "MOBILE_CBS";
            case 13:
                return "WIFI_P2P";
            default:
                return Integer.toString(i2);
        }
    }

    public static String getNetworkTypeName(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "UNKNOWN";
        }
        String networkTypeName = getNetworkTypeName(activeNetworkInfo.getType());
        if (activeNetworkInfo.getType() != 0) {
            return networkTypeName;
        }
        return networkTypeName + "#" + getNetworkTypeNameInMobile(activeNetworkInfo.getSubtype());
    }

    private static String getNetworkTypeNameInMobile(int i2) {
        switch (i2) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMA - EvDo rev. 0";
            case 6:
                return "CDMA - EvDo rev. A";
            case 7:
                return "CDMA - 1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDEN";
            case 12:
                return "CDMA - EvDo rev. B";
            case 13:
                return "LTE";
            case 14:
                return "CDMA - eHRPD";
            case 15:
                return "HSPA+";
            default:
                return "UNKNOWN";
        }
    }

    public static String getSimOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getSimOperator();
        }
        return null;
    }

    public static boolean is2G(Context context) {
        return !isWifiOr3G(context);
    }

    public static boolean is3G(Context context) {
        int networkClass = getNetworkClass(context);
        return networkClass == 2 || networkClass == 3;
    }

    public static boolean isCmbNetwork(byte b2) {
        return b2 == 4 || b2 == 6;
    }

    public static boolean isCmbNetwork(Context context) {
        return isCmbNetwork(getCurrentNetType(context));
    }

    public static boolean isCmbNetwork(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(CONNECT_TYPE_CMWAP) || str.equals(CONNECT_TYPE_CMNET);
    }

    public static boolean isCmwap(Context context) {
        return getApnType(context).equals(CONNECT_TYPE_CMWAP);
    }

    public static boolean isCtcNetwork(byte b2) {
        return b2 == 3 || b2 == 2;
    }

    public static boolean isCtcNetwork(Context context) {
        return isCtcNetwork(getCurrentNetType(context));
    }

    public static boolean isCtcNetwork(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(CONNECT_TYPE_CTWAP) || str.equals(CONNECT_TYPE_CTNET);
    }

    public static boolean isCtwap(Context context) {
        return getApnType(context).equals(CONNECT_TYPE_CTWAP);
    }

    public static boolean isCucNetwork(byte b2) {
        return b2 == 5 || b2 == 7;
    }

    public static boolean isCucNetwork(Context context) {
        return isCucNetwork(getCurrentNetType(context));
    }

    public static boolean isCucNetwork(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(CONNECT_TYPE_UNIWAP) || str.equals(CONNECT_TYPE_UNINET) || str.equals(CONNECT_TYPE_UNI3GWAP) || str.equals(CONNECT_TYPE_UNI3GNET);
    }

    public static boolean isNeedSetProxyForNetRequest() {
        return !Build.MODEL.equals("SCH-N719") && !Build.MODEL.equals("SCH-I939D");
    }

    public static boolean isNetAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static boolean isUniwap(Context context) {
        return getApnType(context).equals(CONNECT_TYPE_UNIWAP);
    }

    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
        }
    }

    public static boolean isWifiOr3G(Context context) {
        if (isWifi(context)) {
            return true;
        }
        return is3G(context);
    }
}
