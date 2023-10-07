package com.xeagle.android.login.common;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.ArrayList;

public class StaticIpConfigurationFor5 {
    private static void callMethod(Object obj, String str, String[] strArr, Object[] objArr) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Class[] clsArr = new Class[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            clsArr[i2] = Class.forName(strArr[i2]);
            obj.getClass().getDeclaredMethod(str, clsArr).invoke(obj, objArr);
        }
    }

    private static Object getEnumValue(String str, String str2) throws ClassNotFoundException {
        return Enum.valueOf(Class.forName(str), str2);
    }

    public static <T> T getField(Object obj, String str, Class<T> cls) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        return cls.cast(obj.getClass().getDeclaredField(str).get(obj));
    }

    private static Object newInstance(String str) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return newInstance(str, new Class[0], new Object[0]);
    }

    private static Object newInstance(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
    }

    private static void setField(Object obj, String str, Object obj2) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        obj.getClass().getDeclaredField(str).set(obj, obj2);
    }

    private static void setStaticIpConfiguration(WifiManager wifiManager, WifiConfiguration wifiConfiguration, InetAddress inetAddress, int i2, InetAddress inetAddress2, InetAddress[] inetAddressArr) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException {
        callMethod(wifiConfiguration, "setIpAssignment", new String[]{"android.net.IpConfiguration$IpAssignment"}, new Object[]{getEnumValue("android.net.IpConfiguration$IpAssignment", "STATIC")});
        Object newInstance = newInstance("android.net.StaticIpConfiguration");
        setField(newInstance, "ipAddress", newInstance("android.net.LinkAddress", new Class[]{InetAddress.class, Integer.TYPE}, new Object[]{inetAddress, Integer.valueOf(i2)}));
        setField(newInstance, "gateway", inetAddress2);
        ((ArrayList) getField(newInstance, "dnsServers", ArrayList.class)).clear();
        for (InetAddress add : inetAddressArr) {
            ((ArrayList) getField(newInstance, "dnsServers", ArrayList.class)).add(add);
        }
        callMethod(wifiConfiguration, "setStaticIpConfiguration", new String[]{"android.net.StaticIpConfiguration"}, new Object[]{newInstance});
        wifiManager.updateNetwork(wifiConfiguration);
        wifiManager.saveConfiguration();
    }
}
