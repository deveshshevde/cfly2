package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPManager {
    private WifiInfo wifiInfo;

    public IPManager(Context context) {
        this.wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
    }

    private String getDottedDecimalIP(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                sb.append(".");
            }
            sb.append(bArr[i2] & 255);
        }
        return sb.toString();
    }

    private byte[] getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e2) {
            Log.e("IPMANAGER", "get ip SocketException", e2);
            return null;
        }
    }

    private String intToIp(int i2) {
        return String.valueOf(i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public String getIPAddress() {
        String intToIp = intToIp(this.wifiInfo.getIpAddress());
        return intToIp.matches("0.0.0.0") ? getDottedDecimalIP(getLocalIPAddress()) : intToIp;
    }

    public String getMacAddress() {
        return this.wifiInfo.getMacAddress();
    }
}
