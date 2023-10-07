package com.xeagle.android.login.common;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class StaticIpConfigurationFor34 {
    public static Object getDeclaredFiled(Object obj, String str) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object getField(Object obj, String str) throws SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        return obj.getClass().getField(str).get(obj);
    }

    public static void setEnumField(Object obj, String str, String str2) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getField(str2);
        field.set(obj, Enum.valueOf(field.getType(), str));
    }

    public static void setIpAddress(InetAddress inetAddress, int i2, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InstantiationException, InvocationTargetException {
        Object field = getField(wifiConfiguration, "linkProperties");
        if (field != null) {
            Object newInstance = Class.forName("android.net.LinkAddress").getConstructor(new Class[]{InetAddress.class, Integer.TYPE}).newInstance(new Object[]{inetAddress, Integer.valueOf(i2)});
            ArrayList arrayList = (ArrayList) getDeclaredFiled(field, "mLinkAddresses");
            arrayList.clear();
            arrayList.add(newInstance);
        }
    }

    public WifiConfiguration getConnectConfig(WifiManager wifiManager) {
        WifiInfo connectionInfo = getConnectionInfo(wifiManager);
        List<WifiConfiguration> startScan2 = startScan2(wifiManager);
        if (startScan2 != null) {
            for (WifiConfiguration next : startScan2) {
                if (next.networkId == connectionInfo.getNetworkId()) {
                    return next;
                }
            }
        }
        return null;
    }

    public WifiInfo getConnectionInfo(WifiManager wifiManager) {
        return wifiManager.getConnectionInfo();
    }

    public void setIpAssignment(String str, WifiConfiguration wifiConfiguration) throws SecurityException, IllegalArgumentException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        setEnumField(wifiConfiguration.getClass().getMethod("getIpConfiguration", new Class[0]).invoke(wifiConfiguration, new Object[0]), str, "ipAssignment");
    }

    public boolean setStaticIp(WifiManager wifiManager, String str) {
        WifiConfiguration connectConfig = getConnectConfig(wifiManager);
        if (connectConfig == null) {
            return false;
        }
        try {
            setIpAssignment("STATIC", connectConfig);
            setIpAddress(InetAddress.getByName(str), 24, connectConfig);
            if (wifiManager.updateNetwork(connectConfig) != -1) {
                wifiManager.disconnect();
                wifiManager.saveConfiguration();
                wifiManager.enableNetwork(connectConfig.networkId, true);
                wifiManager.reconnect();
            }
            Log.i("Connect", "setStaticIp: ---静态IP设置成功");
            return true;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return false;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return false;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return false;
        } catch (UnknownHostException e6) {
            e6.printStackTrace();
            return false;
        } catch (InstantiationException e7) {
            e7.printStackTrace();
            return false;
        } catch (ClassNotFoundException e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public List<WifiConfiguration> startScan2(WifiManager wifiManager) {
        wifiManager.startScan();
        return wifiManager.getConfiguredNetworks();
    }
}
