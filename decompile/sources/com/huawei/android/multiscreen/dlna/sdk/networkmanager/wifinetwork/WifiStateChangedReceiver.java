package com.huawei.android.multiscreen.dlna.sdk.networkmanager.wifinetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.e;
import com.huawei.android.multiscreen.dlna.sdk.networkmanager.ENetworkType;
import com.huawei.android.multiscreen.dlna.sdk.networkmanager.c;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class WifiStateChangedReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static String f20903a = "WifiStateChangedReceiver";

    /* renamed from: b  reason: collision with root package name */
    private e f20904b = b.a();

    /* renamed from: c  reason: collision with root package name */
    private c f20905c = c.a();

    /* renamed from: d  reason: collision with root package name */
    private WifiP2pManager.GroupInfoListener f20906d = new a();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Integer> f20907e = new HashMap(4);

    /* renamed from: f  reason: collision with root package name */
    private Context f20908f;

    class a implements WifiP2pManager.GroupInfoListener {
        a() {
        }

        public void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
            if (wifiP2pGroup != null) {
                WifiStateChangedReceiver.this.a(wifiP2pGroup);
            }
        }
    }

    public WifiStateChangedReceiver() {
        this.f20907e.put("android.net.wifi.STATE_CHANGE", 1);
        this.f20907e.put("android.net.wifi.p2p.CONNECTION_STATE_CHANGE", 3);
        this.f20908f = this.f20904b.d();
    }

    private String a(int i2) {
        return a(new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)});
    }

    private String a(byte[] bArr) {
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

    private List<String> a() {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            arrayList.add(a(nextElement.getAddress()));
                        }
                    }
                }
            }
        } catch (SocketException e2) {
            e = e2;
            str = "get ip SocketException";
            Log.e("IPMANAGER", str, e);
        } catch (NoSuchElementException e3) {
            e = e3;
            str = "get ip NoSuchElementException";
            Log.e("IPMANAGER", str, e);
        } catch (Exception unused) {
            Log.e("IPMANAGER", "get ip error");
        }
        return arrayList;
    }

    private void a(Context context) {
        WifiP2pManager wifiP2pManager = (WifiP2pManager) context.getSystemService("wifip2p");
        wifiP2pManager.requestGroupInfo(wifiP2pManager.initialize(context, context.getMainLooper(), (WifiP2pManager.ChannelListener) null), this.f20906d);
    }

    private void a(Context context, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo == null) {
            e();
            return;
        }
        if (!networkInfo.isConnected() || TextUtils.isEmpty(this.f20905c.c())) {
            if (networkInfo.getState().toString().equals("DISCONNECTED") && this.f20904b.h()) {
                com.huawei.android.multiscreen.dlna.sdk.networkmanager.a b2 = c.a().b();
                List<String> a2 = a();
                if (a2.contains(b2.c())) {
                    return;
                }
                if (a2.isEmpty()) {
                    e();
                    return;
                }
            } else {
                return;
            }
        } else if (!this.f20904b.h()) {
            int size = a().size();
            if (size == 1) {
                d();
                return;
            } else if (size != 2) {
                return;
            }
        } else {
            return;
        }
        a(context);
    }

    /* access modifiers changed from: private */
    public void a(WifiP2pGroup wifiP2pGroup) {
        com.huawei.android.multiscreen.dlna.sdk.networkmanager.a aVar = new com.huawei.android.multiscreen.dlna.sdk.networkmanager.a();
        aVar.b(c());
        aVar.c(this.f20905c.b());
        aVar.a(wifiP2pGroup.getNetworkName());
        aVar.a(ENetworkType.WIFI_DIRECT);
        this.f20904b.a(aVar);
    }

    private String b() {
        return a(((WifiManager) this.f20908f.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    }

    private void b(Context context, Intent intent) {
        if (((NetworkInfo) intent.getParcelableExtra("networkInfo")).isConnected()) {
            if (!this.f20904b.h()) {
                a(context);
            }
        } else if (this.f20904b.h()) {
            com.huawei.android.multiscreen.dlna.sdk.networkmanager.a b2 = c.a().b();
            List<String> a2 = a();
            if (a2.contains(b2.c())) {
                return;
            }
            if (a2.isEmpty()) {
                e();
            } else {
                d();
            }
        }
    }

    private String c() {
        List<String> a2 = a();
        int size = a2.size();
        if (size != 1) {
            if (size != 2) {
                return "0.0.0.0";
            }
        } else if (!a2.contains(b())) {
            return a2.get(0);
        }
        String b2 = b();
        for (String next : a2) {
            if (!next.equals(b2)) {
                return next;
            }
        }
        return "0.0.0.0";
    }

    private void d() {
        com.huawei.android.multiscreen.dlna.sdk.networkmanager.a aVar = new com.huawei.android.multiscreen.dlna.sdk.networkmanager.a();
        aVar.b(b());
        aVar.c(this.f20905c.b());
        aVar.a(this.f20905c.c());
        aVar.a(ENetworkType.WIFI);
        this.f20904b.a(aVar);
    }

    private void e() {
        com.huawei.android.multiscreen.dlna.sdk.networkmanager.a aVar = new com.huawei.android.multiscreen.dlna.sdk.networkmanager.a();
        aVar.a(ENetworkType.NO_NETWORK);
        this.f20904b.a(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        Integer num = this.f20907e.get(intent.getAction());
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 1) {
                a(context, intent);
            } else if (intValue == 3) {
                b(context, intent);
            }
        }
    }
}
