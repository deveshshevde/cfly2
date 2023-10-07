package com.xeagle.android.login.common.ip;

import android.content.ContentResolver;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.LinkAddress;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

public class SetIpManager {
    private Context mContext;
    private int netmaskIpL;

    public SetIpManager(Context context) {
        this.mContext = context;
    }

    public String getIpStr() {
        return intToIp(((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    }

    public String getWifiSetting() {
        DhcpInfo dhcpInfo = ((WifiManager) this.mContext.getSystemService("wifi")).getDhcpInfo();
        this.netmaskIpL = dhcpInfo.netmask;
        return dhcpInfo.leaseDuration == 0 ? "StaticIP" : "DHCP";
    }

    public String intToIp(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public boolean setIpWithTfiStaticIp(boolean z2, String str, int i2, String str2, String str3) {
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            return false;
        }
        WifiConfiguration wifiConfiguration = null;
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            Iterator<WifiConfiguration> it2 = configuredNetworks.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WifiConfiguration next = it2.next();
                Log.i("Info", "setIpWithTfiStaticIp:----config--- " + next.networkId + "----" + connectionInfo.getNetworkId());
                if (next.networkId == connectionInfo.getNetworkId()) {
                    wifiConfiguration = next;
                    break;
                }
            }
        }
        if (wifiConfiguration == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 11) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            Settings.System.putInt(contentResolver, "wifi_use_static_ip", 1);
            Settings.System.putString(contentResolver, "wifi_static_ip", str);
            return true;
        } else if (Build.VERSION.SDK_INT < 21) {
            try {
                IPSetUtils.setIpAssignment("STATIC", wifiConfiguration);
                IPSetUtils.setIpAddress(InetAddress.getByName(str), i2, wifiConfiguration);
                IPSetUtils.setGateway(InetAddress.getByName(str3), wifiConfiguration);
                IPSetUtils.setDNS(InetAddress.getByName(str2), wifiConfiguration);
                if (wifiManager.updateNetwork(wifiConfiguration) != -1) {
                    wifiManager.disconnect();
                    wifiManager.saveConfiguration();
                    wifiManager.enableNetwork(wifiConfiguration.networkId, true);
                    wifiManager.reconnect();
                }
                System.out.println("静态ip设置成功！");
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("静态ip设置失败！");
                return false;
            }
        } else {
            try {
                Class<?> cls = wifiConfiguration.getClass().getMethod("getIpAssignment", new Class[0]).invoke(wifiConfiguration, new Object[0]).getClass();
                Object invoke = wifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(wifiConfiguration, new Object[0]);
                if (z2) {
                    wifiConfiguration.getClass().getMethod("setIpAssignment", new Class[]{cls}).invoke(wifiConfiguration, new Object[]{Enum.valueOf(cls, "DHCP")});
                    if (invoke != null) {
                        invoke.getClass().getMethod("clear", new Class[0]).invoke(invoke, new Object[0]);
                    }
                } else {
                    wifiConfiguration.getClass().getMethod("setIpAssignment", new Class[]{cls}).invoke(wifiConfiguration, new Object[]{Enum.valueOf(cls, "STATIC")});
                    if (invoke == null) {
                        invoke = Class.forName("android.net.StaticIpConfiguration").newInstance();
                    }
                    invoke.getClass().getField("ipAddress").set(invoke, LinkAddress.class.getConstructor(new Class[]{InetAddress.class, Integer.TYPE}).newInstance(new Object[]{InetAddress.getByName(str), Integer.valueOf(i2)}));
                    invoke.getClass().getField("gateway").set(invoke, InetAddress.getByName(str3));
                    List list = (List) invoke.getClass().getField("dnsServers").get(invoke);
                    list.clear();
                    list.add(InetAddress.getByName(str2));
                    wifiConfiguration.getClass().getMethod("setStaticIpConfiguration", new Class[]{invoke.getClass()}).invoke(wifiConfiguration, new Object[]{invoke});
                }
                boolean z3 = wifiManager.updateNetwork(wifiConfiguration) != -1;
                if (z3) {
                    z3 = wifiManager.saveConfiguration();
                }
                if (z3) {
                    wifiManager.reassociate();
                }
                return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), true);
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }
}
