package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public final class ii {

    /* renamed from: d  reason: collision with root package name */
    static long f9229d;

    /* renamed from: e  reason: collision with root package name */
    static long f9230e;

    /* renamed from: f  reason: collision with root package name */
    static long f9231f;

    /* renamed from: g  reason: collision with root package name */
    public static long f9232g;

    /* renamed from: h  reason: collision with root package name */
    static long f9233h;

    /* renamed from: s  reason: collision with root package name */
    public static HashMap<String, Long> f9234s = new HashMap<>(36);

    /* renamed from: t  reason: collision with root package name */
    public static long f9235t = 0;

    /* renamed from: u  reason: collision with root package name */
    static int f9236u = 0;

    /* renamed from: w  reason: collision with root package name */
    public static long f9237w = 0;

    /* renamed from: a  reason: collision with root package name */
    WifiManager f9238a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ScanResult> f9239b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<jn> f9240c = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    Context f9241i;

    /* renamed from: j  reason: collision with root package name */
    boolean f9242j = false;

    /* renamed from: k  reason: collision with root package name */
    StringBuilder f9243k = null;

    /* renamed from: l  reason: collision with root package name */
    boolean f9244l = true;

    /* renamed from: m  reason: collision with root package name */
    boolean f9245m = true;

    /* renamed from: n  reason: collision with root package name */
    boolean f9246n = true;

    /* renamed from: o  reason: collision with root package name */
    String f9247o = null;

    /* renamed from: p  reason: collision with root package name */
    TreeMap<Integer, ScanResult> f9248p = null;

    /* renamed from: q  reason: collision with root package name */
    public boolean f9249q = true;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9250r = false;

    /* renamed from: v  reason: collision with root package name */
    ConnectivityManager f9251v = null;

    /* renamed from: x  reason: collision with root package name */
    volatile boolean f9252x = false;

    /* renamed from: y  reason: collision with root package name */
    private volatile WifiInfo f9253y = null;

    /* renamed from: z  reason: collision with root package name */
    private long f9254z = 30000;

    public ii(Context context, WifiManager wifiManager) {
        this.f9238a = wifiManager;
        this.f9241i = context;
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            io.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && is.a(wifiInfo.getBSSID());
    }

    private void d(boolean z2) {
        String str;
        ArrayList<ScanResult> arrayList = this.f9239b;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (is.b() - f9232g > 3600000) {
                b();
            }
            if (this.f9248p == null) {
                this.f9248p = new TreeMap<>(Collections.reverseOrder());
            }
            this.f9248p.clear();
            if (this.f9250r && z2) {
                try {
                    this.f9240c.clear();
                } catch (Throwable unused) {
                }
            }
            int size = this.f9239b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.f9239b.get(i2);
                if (is.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (this.f9250r && z2) {
                        try {
                            jn jnVar = new jn(false);
                            jnVar.f9482b = scanResult.SSID;
                            jnVar.f9484d = scanResult.frequency;
                            jnVar.f9485e = scanResult.timestamp;
                            jnVar.f9481a = jn.a(scanResult.BSSID);
                            jnVar.f9483c = (short) scanResult.level;
                            if (Build.VERSION.SDK_INT >= 17) {
                                jnVar.f9487g = (short) ((int) ((SystemClock.elapsedRealtime() - (scanResult.timestamp / 1000)) / 1000));
                                if (jnVar.f9487g < 0) {
                                    jnVar.f9487g = 0;
                                }
                            }
                            jnVar.f9486f = System.currentTimeMillis();
                            this.f9240c.add(jnVar);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.f9248p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.f9248p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.f9239b.clear();
            for (ScanResult add : this.f9248p.values()) {
                this.f9239b.add(add);
            }
            this.f9248p.clear();
        }
    }

    private void e(boolean z2) {
        this.f9244l = z2;
        this.f9245m = true;
        this.f9246n = true;
        this.f9254z = 30000;
    }

    public static String i() {
        return String.valueOf(is.b() - f9232g);
    }

    private List<ScanResult> j() {
        long b2;
        WifiManager wifiManager = this.f9238a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    if (scanResults != null) {
                        for (ScanResult next : scanResults) {
                            hashMap.put(next.BSSID, Long.valueOf(next.timestamp));
                        }
                    }
                    if (f9234s.isEmpty() || !f9234s.equals(hashMap)) {
                        f9234s = hashMap;
                        b2 = is.b();
                    }
                    this.f9247o = null;
                    return scanResults;
                }
                b2 = is.b();
                f9235t = b2;
                this.f9247o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.f9247o = e2.getMessage();
            } catch (Throwable th) {
                this.f9247o = null;
                io.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            WifiManager wifiManager = this.f9238a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            io.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        WifiManager wifiManager = this.f9238a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long b2 = is.b() - f9229d;
        if (b2 < 4900) {
            return false;
        }
        if (n() && b2 < 9900) {
            return false;
        }
        if (f9236u > 1) {
            long j2 = this.f9254z;
            if (j2 == 30000) {
                j2 = in.b() != -1 ? in.b() : 30000;
            }
            if (Build.VERSION.SDK_INT >= 28 && b2 < j2) {
                return false;
            }
        }
        if (this.f9238a == null) {
            return false;
        }
        f9229d = is.b();
        int i2 = f9236u;
        if (i2 < 2) {
            f9236u = i2 + 1;
        }
        return this.f9238a.startScan();
    }

    private boolean n() {
        if (this.f9251v == null) {
            this.f9251v = (ConnectivityManager) is.a(this.f9241i, "connectivity");
        }
        return a(this.f9251v);
    }

    private boolean o() {
        if (this.f9238a == null) {
            return false;
        }
        return is.c(this.f9241i);
    }

    private void p() {
        if (t()) {
            long b2 = is.b();
            if (b2 - f9230e >= 10000) {
                this.f9239b.clear();
                f9233h = f9232g;
            }
            q();
            if (b2 - f9230e >= 10000) {
                for (int i2 = 20; i2 > 0 && f9232g == f9233h; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void q() {
        if (t()) {
            try {
                if (m()) {
                    f9231f = is.b();
                }
            } catch (Throwable th) {
                io.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void r() {
        if (f9233h != f9232g) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th) {
                io.a(th, "WifiManager", "updateScanResult");
            }
            f9233h = f9232g;
            if (list != null) {
                this.f9239b.clear();
                this.f9239b.addAll(list);
                return;
            }
            this.f9239b.clear();
        }
    }

    private void s() {
        int i2;
        try {
            if (this.f9238a != null) {
                i2 = l();
                if (this.f9239b == null) {
                    this.f9239b = new ArrayList<>();
                }
                if (i2 == 0 || i2 == 1 || i2 == 4) {
                    b();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean t() {
        boolean o2 = o();
        this.f9249q = o2;
        if (o2 && this.f9244l) {
            if (f9231f == 0) {
                return true;
            }
            if (is.b() - f9231f >= 4900 && is.b() - f9232g >= 1500) {
                int i2 = ((is.b() - f9232g) > 4900 ? 1 : ((is.b() - f9232g) == 4900 ? 0 : -1));
                return true;
            }
        }
        return false;
    }

    public final ArrayList<ScanResult> a() {
        if (this.f9239b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.f9239b.isEmpty()) {
            arrayList.addAll(this.f9239b);
        }
        return arrayList;
    }

    public final void a(boolean z2) {
        Context context = this.f9241i;
        if (in.a() && this.f9246n && this.f9238a != null && context != null && z2 && is.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) iq.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    iq.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                io.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.f9238a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return is.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            io.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.f9253y = null;
        this.f9239b.clear();
    }

    public final void b(boolean z2) {
        if (z2) {
            p();
        } else {
            q();
        }
        boolean z3 = false;
        if (this.f9252x) {
            this.f9252x = false;
            s();
        }
        r();
        if (is.b() - f9232g > 20000) {
            this.f9239b.clear();
        }
        f9230e = is.b();
        if (this.f9239b.isEmpty()) {
            f9232g = is.b();
            List<ScanResult> j2 = j();
            if (j2 != null) {
                this.f9239b.addAll(j2);
                z3 = true;
            }
        }
        d(z3);
    }

    public final void c() {
        if (this.f9238a != null && is.b() - f9232g > 4900) {
            f9232g = is.b();
        }
    }

    public final void c(boolean z2) {
        e(z2);
    }

    public final void d() {
        if (this.f9238a != null) {
            this.f9252x = true;
        }
    }

    public final boolean e() {
        return this.f9249q;
    }

    public final WifiInfo f() {
        this.f9253y = k();
        return this.f9253y;
    }

    public final boolean g() {
        return this.f9242j;
    }

    public final void h() {
        b();
        this.f9239b.clear();
    }
}
