package ch;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class a {
    public static String a() {
        return a("wlan0");
    }

    private static String a(byte b2) {
        String str = "00" + Integer.toHexString(b2) + ":";
        return str.substring(str.length() - 3);
    }

    private static String a(String str) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (str.equals(nextElement.getName())) {
                    return a(a(nextElement));
                }
            }
            return null;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a2 : bArr) {
            stringBuffer.append(a(a2));
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    private static byte[] a(NetworkInterface networkInterface) {
        byte[] bArr = null;
        try {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if (!nextElement.isAnyLocalAddress() && (nextElement instanceof Inet4Address)) {
                    if (!nextElement.isLoopbackAddress()) {
                        if (nextElement.isSiteLocalAddress()) {
                            bArr = networkInterface.getHardwareAddress();
                        } else if (!nextElement.isLinkLocalAddress()) {
                            return networkInterface.getHardwareAddress();
                        }
                    }
                }
            }
            return bArr;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
