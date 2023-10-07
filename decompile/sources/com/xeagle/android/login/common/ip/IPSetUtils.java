package com.xeagle.android.login.common.ip;

import android.net.wifi.WifiConfiguration;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.ArrayList;

public class IPSetUtils {
    private static Object getDeclaredField(Object obj, String str) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object getField(Object obj, String str) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        return obj.getClass().getField(str).get(obj);
    }

    public static void setDNS(InetAddress inetAddress, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        Object field = getField(wifiConfiguration, "linkProperties");
        if (field != null) {
            ArrayList arrayList = (ArrayList) getDeclaredField(field, "mDnses");
            arrayList.clear();
            arrayList.add(inetAddress);
        }
    }

    public static void setEnumField(Object obj, String str, String str2) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getField(str2);
        field.set(obj, Enum.valueOf(field.getType(), str));
    }

    public static void setGateway(InetAddress inetAddress, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        ArrayList arrayList;
        Object obj;
        Object field = getField(wifiConfiguration, "linkProperties");
        if (field != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                Object newInstance = Class.forName("android.net.RouteInfo").getConstructor(new Class[]{InetAddress.class}).newInstance(new Object[]{inetAddress});
                arrayList = (ArrayList) getDeclaredField(field, "mRoutes");
                arrayList.clear();
                obj = newInstance;
            } else {
                arrayList = (ArrayList) getDeclaredField(field, "mGateways");
                obj = inetAddress;
            }
            arrayList.add(obj);
        }
    }

    public static void setIpAddress(InetAddress inetAddress, int i2, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException, InvocationTargetException {
        Object field = getField(wifiConfiguration, "linkProperties");
        if (field != null) {
            Object newInstance = Class.forName("android.net.LinkAddress").getConstructor(new Class[]{InetAddress.class, Integer.TYPE}).newInstance(new Object[]{inetAddress, Integer.valueOf(i2)});
            ArrayList arrayList = (ArrayList) getDeclaredField(field, "mLinkAddresses");
            arrayList.clear();
            arrayList.add(newInstance);
        }
    }

    public static void setIpAssignment(String str, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        setEnumField(wifiConfiguration, str, "ipAssignment");
    }
}
