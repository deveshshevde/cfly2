package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;

public final class is {

    /* renamed from: a  reason: collision with root package name */
    static WifiManager f9344a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f9345b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f9346c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9347d = false;

    public static double a(double d2) {
        return c(d2);
    }

    public static float a(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        double d3 = (double) ((long) (d2 * 100.0d));
        Double.isNaN(d3);
        return (float) (d3 / 100.0d);
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i2) {
        return (i2 * 2) - 113;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            io.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? b(context, "android.provider.Settings$System") : b(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return fg.a(jSONObject, str);
    }

    public static byte[] a(int i2, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i2 & 255);
        bArr[1] = (byte) ((i2 & 65280) >> 8);
        return bArr;
    }

    public static byte[] a(long j2) {
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((int) ((j2 >> (i2 * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return fg.b(bArr);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i2;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i3 = 0;
            while (i3 < charArray.length && Character.isDigit(charArray[i3])) {
                i3++;
            }
            strArr2[1] = networkOperator.substring(3, i3 + 3);
        }
        try {
            i2 = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            io.a(th, "Utils", "getMccMnc");
            i2 = 0;
        }
        if (i2 == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return (!"0".equals(strArr2[0]) || !"0".equals(strArr2[1]) || (strArr = f9346c) == null) ? strArr2 : strArr;
        }
        f9346c = strArr2;
        return strArr2;
    }

    public static double b(double d2) {
        double d3 = (double) ((long) (d2 * 100.0d));
        Double.isNaN(d3);
        return d3 / 100.0d;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(int i2) {
        if (i2 == 18) {
            return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
        }
        if (i2 == 19) {
            return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
        if (i2 == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i2) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            default:
                return "其他错误";
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(io.f9336j)) {
            return io.f9336j;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(ev.c(context), 64);
        } catch (Throwable th) {
            io.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(io.f9337k)) {
                io.f9337k = null;
            }
        } catch (Throwable th2) {
            io.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c2 = ev.c(context);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!TextUtils.isEmpty(io.f9337k)) {
            sb.append(",");
            sb.append(io.f9337k);
        }
        String sb2 = sb.toString();
        io.f9336j = sb2;
        return sb2;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i2 = 0;
        if (telephonyManager != null) {
            try {
                i2 = telephonyManager.getNetworkType();
            } catch (Throwable unused) {
            }
        }
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
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    private static boolean b(Context context, String str) throws Throwable {
        return ((Integer) iq.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) iq.a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] b(int i2, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] b(String str) {
        return a(d(str), (byte[]) null);
    }

    private static double c(double d2) {
        double d3 = (double) ((long) (d2 * 1000000.0d));
        Double.isNaN(d3);
        return d3 / 1000000.0d;
    }

    public static int c() {
        int i2 = f9345b;
        if (i2 > 0) {
            return i2;
        }
        try {
            return iq.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean c(Context context) {
        boolean z2;
        if (context == null) {
            return true;
        }
        if (f9344a == null) {
            f9344a = (WifiManager) a(context, "wifi");
        }
        try {
            z2 = f9344a.isWifiEnabled();
        } catch (Throwable unused) {
            z2 = false;
        }
        if (z2 || c() <= 17) {
            return z2;
        }
        try {
            return "true".equals(String.valueOf(iq.a(f9344a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return z2;
        }
    }

    public static byte[] c(String str) {
        return b(d(str), (byte[]) null);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static int d(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String d(Context context) {
        String m2 = ez.m(context);
        String str = "00:00:00:00:00:00";
        if (TextUtils.isEmpty(m2) || m2.equals(str)) {
            m2 = ir.a(context);
        }
        if (!TextUtils.isEmpty(m2)) {
            str = m2;
        }
        if (!f9347d) {
            ir.a(context, str);
            f9347d = true;
        }
        return str;
    }

    public static byte e(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }
}
