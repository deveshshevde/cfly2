package com.amap.api.mapcore.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import org.json.JSONObject;

public final class jb {

    /* renamed from: a  reason: collision with root package name */
    Context f9417a = null;

    /* renamed from: b  reason: collision with root package name */
    boolean f9418b = false;

    /* renamed from: c  reason: collision with root package name */
    String f9419c = null;

    /* renamed from: d  reason: collision with root package name */
    long f9420d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ii f9421e = null;

    /* renamed from: f  reason: collision with root package name */
    private jr f9422f = null;

    /* renamed from: g  reason: collision with root package name */
    private a f9423g = null;

    /* renamed from: h  reason: collision with root package name */
    private ik f9424h = null;

    /* renamed from: i  reason: collision with root package name */
    private ConnectivityManager f9425i = null;

    /* renamed from: j  reason: collision with root package name */
    private im f9426j = null;

    /* renamed from: k  reason: collision with root package name */
    private StringBuilder f9427k = new StringBuilder();

    /* renamed from: l  reason: collision with root package name */
    private Inner_3dMap_locationOption f9428l = null;

    /* renamed from: m  reason: collision with root package name */
    private iz f9429m = null;

    /* renamed from: n  reason: collision with root package name */
    private final String f9430n = "\"status\":\"0\"";

    /* renamed from: o  reason: collision with root package name */
    private final String f9431o = "</body></html>";

    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(jb jbVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (jb.this.f9421e != null) {
                                jb.this.f9421e.c();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && jb.this.f9421e != null) {
                            jb.this.f9421e.d();
                        }
                    }
                } catch (Throwable th) {
                    io.a(th, "MapNetLocation", "onReceive");
                }
            }
        }
    }

    public jb(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.f9417a = applicationContext;
            is.b(applicationContext);
            a(this.f9417a);
            this.f9428l = new Inner_3dMap_locationOption();
            if (this.f9421e == null) {
                ii iiVar = new ii(this.f9417a, (WifiManager) is.a(this.f9417a, "wifi"));
                this.f9421e = iiVar;
                iiVar.a(this.f9418b);
            }
            if (this.f9422f == null) {
                this.f9422f = new jr(this.f9417a);
            }
            if (this.f9424h == null) {
                ew.a(this.f9417a);
                this.f9424h = ik.a(this.f9417a);
            }
            if (this.f9425i == null) {
                this.f9425i = (ConnectivityManager) is.a(this.f9417a, "connectivity");
            }
            this.f9426j = new im();
            c();
        } catch (Throwable th) {
            io.a(th, "MapNetLocation", "<init>");
        }
    }

    private static iz a(iz izVar) {
        return iv.a().a(izVar);
    }

    private void a(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(fg.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f9418b = true;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(long j2) {
        if (is.b() - j2 < 800) {
            long j3 = 0;
            if (jd.a(this.f9429m)) {
                j3 = is.a() - this.f9429m.getTime();
            }
            if (j3 <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        try {
            if (this.f9423g == null) {
                this.f9423g = new a(this, (byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.f9417a.registerReceiver(this.f9423g, intentFilter);
            this.f9421e.b(false);
            this.f9422f.b();
        } catch (Throwable th) {
            io.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private iz d() throws Exception {
        String str;
        StringBuilder sb;
        String str2 = "";
        iz izVar = new iz(str2);
        ii iiVar = this.f9421e;
        if (iiVar == null || !iiVar.g()) {
            try {
                if (this.f9426j == null) {
                    this.f9426j = new im();
                }
                this.f9426j.a(this.f9417a, this.f9428l.isNeedAddress(), this.f9428l.isOffset(), this.f9422f, this.f9421e, this.f9425i, this.f9419c);
                jc jcVar = new jc();
                byte[] bArr = null;
                try {
                    try {
                        he a2 = this.f9424h.a(this.f9424h.a(this.f9417a, this.f9426j.a(), io.a(), io.b()));
                        if (a2 != null) {
                            bArr = a2.f9117a;
                            str2 = a2.f9119c;
                        }
                        if (bArr == null || bArr.length == 0) {
                            izVar.setErrorCode(4);
                            this.f9427k.append("please check the network");
                            if (!TextUtils.isEmpty(str2)) {
                                this.f9427k.append(" #csid:".concat(String.valueOf(str2)));
                            }
                            izVar.setLocationDetail(this.f9427k.toString());
                            return izVar;
                        }
                        String str3 = new String(bArr, "UTF-8");
                        if (str3.contains("\"status\":\"0\"")) {
                            return jcVar.a(str3, this.f9417a, a2);
                        }
                        if (str3.contains("</body></html>")) {
                            izVar.setErrorCode(5);
                            ii iiVar2 = this.f9421e;
                            if (iiVar2 == null || !iiVar2.a(this.f9425i)) {
                                sb = this.f9427k;
                                str = "request may be intercepted";
                            } else {
                                sb = this.f9427k;
                                str = "make sure you are logged in to the network";
                            }
                            sb.append(str);
                            if (!TextUtils.isEmpty(str2)) {
                                this.f9427k.append(" #csid:".concat(String.valueOf(str2)));
                            }
                            izVar.setLocationDetail(this.f9427k.toString());
                            return izVar;
                        }
                        byte[] a3 = ij.a(bArr);
                        if (a3 == null) {
                            izVar.setErrorCode(5);
                            this.f9427k.append("decrypt response data error");
                            if (!TextUtils.isEmpty(str2)) {
                                this.f9427k.append(" #csid:".concat(String.valueOf(str2)));
                            }
                            izVar.setLocationDetail(this.f9427k.toString());
                            return izVar;
                        }
                        iz a4 = jcVar.a(a3);
                        this.f9419c = a4.a();
                        if (a4.getErrorCode() != 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str2);
                            }
                            return a4;
                        } else if (jd.a(a4)) {
                            JSONObject e2 = a4.e();
                            if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                                if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || "14".equals(a4.d()) || "24".equals(a4.d()) || "-1".equals(a4.d())) {
                                    a4.setLocationType(5);
                                } else {
                                    a4.setLocationType(6);
                                }
                                this.f9427k.append(a4.d());
                                if (!TextUtils.isEmpty(str2)) {
                                    this.f9427k.append(" #csid:".concat(String.valueOf(str2)));
                                }
                                a4.setLocationDetail(this.f9427k.toString());
                            }
                            return a4;
                        } else {
                            String b2 = a4.b();
                            a4.setErrorCode(6);
                            StringBuilder sb2 = this.f9427k;
                            StringBuilder sb3 = new StringBuilder("location faile retype:");
                            sb3.append(a4.d());
                            sb3.append(" rdesc:");
                            if (b2 == null) {
                                b2 = "null";
                            }
                            sb3.append(b2);
                            sb2.append(sb3.toString());
                            if (!TextUtils.isEmpty(str2)) {
                                this.f9427k.append(" #csid:".concat(String.valueOf(str2)));
                            }
                            a4.setLocationDetail(this.f9427k.toString());
                            return a4;
                        }
                    } catch (Throwable th) {
                        io.a(th, "MapNetLocation", "getApsLoc req");
                        izVar.setErrorCode(4);
                        this.f9427k.append("please check the network");
                        izVar.setLocationDetail(this.f9427k.toString());
                        return izVar;
                    }
                } catch (Throwable th2) {
                    io.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                    izVar.setErrorCode(3);
                    StringBuilder sb4 = this.f9427k;
                    sb4.append("buildV4Dot2 error " + th2.getMessage());
                    izVar.setLocationDetail(this.f9427k.toString());
                    return izVar;
                }
            } catch (Throwable th3) {
                io.a(th3, "MapNetLocation", "getApsLoc");
                StringBuilder sb5 = this.f9427k;
                sb5.append("get parames error:" + th3.getMessage());
                izVar.setErrorCode(3);
                izVar.setLocationDetail(this.f9427k.toString());
                return izVar;
            }
        } else {
            izVar.setErrorCode(15);
            return izVar;
        }
    }

    public final Inner_3dMap_location a() {
        if (this.f9427k.length() > 0) {
            StringBuilder sb = this.f9427k;
            sb.delete(0, sb.length());
        }
        if (a(this.f9420d) && jd.a(this.f9429m)) {
            return this.f9429m;
        }
        this.f9420d = is.b();
        if (this.f9417a == null) {
            this.f9427k.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.f9427k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f9422f.b();
        } catch (Throwable th) {
            io.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.f9421e.b(true);
        } catch (Throwable th2) {
            io.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            iz d2 = d();
            this.f9429m = d2;
            this.f9429m = a(d2);
        } catch (Throwable th3) {
            io.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.f9429m;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(1:2)|3|4|5|6|(1:8)(1:9)|10|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033 A[Catch:{ all -> 0x0037 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5) {
        /*
            r4 = this;
            r4.f9428l = r5
            if (r5 != 0) goto L_0x000b
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5 = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption
            r5.<init>()
            r4.f9428l = r5
        L_0x000b:
            com.amap.api.mapcore.util.ii r5 = r4.f9421e     // Catch:{ all -> 0x001b }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.f9428l     // Catch:{ all -> 0x001b }
            r0.isWifiActiveScan()     // Catch:{ all -> 0x001b }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.f9428l     // Catch:{ all -> 0x001b }
            boolean r0 = r0.isWifiScan()     // Catch:{ all -> 0x001b }
            r5.c(r0)     // Catch:{ all -> 0x001b }
        L_0x001b:
            com.amap.api.mapcore.util.ik r5 = r4.f9424h     // Catch:{ all -> 0x0037 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r0 = r4.f9428l     // Catch:{ all -> 0x0037 }
            long r0 = r0.getHttpTimeOut()     // Catch:{ all -> 0x0037 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption r2 = r4.f9428l     // Catch:{ all -> 0x0037 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationProtocol r2 = r2.getLocationProtocol()     // Catch:{ all -> 0x0037 }
            com.autonavi.amap.mapcore.Inner_3dMap_locationOption$Inner_3dMap_Enum_LocationProtocol r3 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS     // Catch:{ all -> 0x0037 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0033
            r2 = 1
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            r5.a(r0, r2)     // Catch:{ all -> 0x0037 }
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jb.a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption):void");
    }

    public final void b() {
        a aVar;
        this.f9418b = false;
        this.f9419c = null;
        try {
            Context context = this.f9417a;
            if (!(context == null || (aVar = this.f9423g) == null)) {
                context.unregisterReceiver(aVar);
            }
            jr jrVar = this.f9422f;
            if (jrVar != null) {
                jrVar.h();
            }
            ii iiVar = this.f9421e;
            if (iiVar != null) {
                iiVar.h();
            }
            this.f9423g = null;
        } catch (Throwable unused) {
            this.f9423g = null;
        }
    }
}
