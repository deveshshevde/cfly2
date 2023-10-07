package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ja {

    /* renamed from: m  reason: collision with root package name */
    private static int f9401m = 200;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f9402n = true;

    /* renamed from: a  reason: collision with root package name */
    Context f9403a = null;

    /* renamed from: b  reason: collision with root package name */
    it f9404b = null;

    /* renamed from: c  reason: collision with root package name */
    jb f9405c = null;

    /* renamed from: d  reason: collision with root package name */
    b f9406d = null;

    /* renamed from: e  reason: collision with root package name */
    Handler f9407e = null;

    /* renamed from: f  reason: collision with root package name */
    Handler f9408f = null;

    /* renamed from: g  reason: collision with root package name */
    boolean f9409g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f9410h = false;

    /* renamed from: i  reason: collision with root package name */
    Inner_3dMap_locationOption f9411i = null;

    /* renamed from: j  reason: collision with root package name */
    final int f9412j = 500;

    /* renamed from: k  reason: collision with root package name */
    final int f9413k = 30;

    /* renamed from: l  reason: collision with root package name */
    Object f9414l = new Object();

    /* renamed from: o  reason: collision with root package name */
    private JSONArray f9415o = null;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                ja.this.b();
            }
        }
    }

    static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public ja(Context context, Handler handler) {
        if (context != null) {
            try {
                this.f9403a = context.getApplicationContext();
                this.f9408f = handler;
                this.f9411i = new Inner_3dMap_locationOption();
                f();
                e();
            } catch (Throwable th) {
                io.a(th, "LocationService", "<init>");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private void a(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (!f9402n || inner_3dMap_location == null || inner_3dMap_location.getErrorCode() != 0) {
                return;
            }
            if (inner_3dMap_location.getLocationType() == 1) {
                if (this.f9415o == null) {
                    this.f9415o = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lon", inner_3dMap_location.getLongitude());
                jSONObject.put("lat", inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", is.a());
                JSONArray put = this.f9415o.put(jSONObject);
                this.f9415o = put;
                if (put.length() >= f9401m) {
                    h();
                }
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "recordOfflineLocLog");
        }
    }

    private void e() {
        b bVar = new b("locServiceAction");
        this.f9406d = bVar;
        bVar.setPriority(5);
        this.f9406d.start();
        this.f9407e = new a(this.f9406d.getLooper());
    }

    private void f() {
        try {
            if (this.f9411i == null) {
                this.f9411i = new Inner_3dMap_locationOption();
            }
            if (!this.f9410h) {
                this.f9404b = new it(this.f9403a);
                jb jbVar = new jb(this.f9403a);
                this.f9405c = jbVar;
                jbVar.a(this.f9411i);
                g();
                this.f9410h = true;
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "init");
        }
    }

    private void g() {
        try {
            f9402n = ir.b(this.f9403a, "maploc", "ue");
            int a2 = ir.a(this.f9403a, "maploc", "opn");
            f9401m = a2;
            if (a2 > 500) {
                f9401m = 500;
            }
            if (f9401m < 30) {
                f9401m = 30;
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void h() {
        try {
            JSONArray jSONArray = this.f9415o;
            if (jSONArray != null && jSONArray.length() > 0) {
                hk.a(new hj(this.f9403a, io.c(), this.f9415o.toString()), this.f9403a);
                this.f9415o = null;
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "writeOfflineLog");
        }
    }

    private void i() {
        synchronized (this.f9414l) {
            Handler handler = this.f9407e;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f9407e = null;
        }
    }

    private void j() {
        synchronized (this.f9414l) {
            Handler handler = this.f9407e;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public final void a() {
        try {
            f();
            if (!this.f9411i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && !this.f9409g) {
                this.f9409g = true;
                this.f9404b.a();
            }
            Handler handler = this.f9407e;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "getLocation");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.f9411i = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.f9411i = new Inner_3dMap_locationOption();
        }
        jb jbVar = this.f9405c;
        if (jbVar != null) {
            jbVar.a(inner_3dMap_locationOption);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Inner_3dMap_location inner_3dMap_location = null;
        try {
            if (this.f9411i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.f9409g) {
                this.f9404b.b();
                this.f9409g = false;
            }
            if (this.f9404b.c()) {
                inner_3dMap_location = this.f9404b.d();
            } else if (!this.f9411i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
                inner_3dMap_location = this.f9405c.a();
            }
            if (!(this.f9408f == null || inner_3dMap_location == null)) {
                Message obtain = Message.obtain();
                obtain.obj = inner_3dMap_location;
                obtain.what = 1;
                this.f9408f.sendMessage(obtain);
            }
            a(inner_3dMap_location);
        } catch (Throwable th) {
            io.a(th, "LocationService", "doGetLocation");
        }
    }

    public final void c() {
        this.f9409g = false;
        try {
            j();
            it itVar = this.f9404b;
            if (itVar != null) {
                itVar.b();
            }
        } catch (Throwable th) {
            io.a(th, "LocationService", "stopLocation");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r5 = this;
            r5.c()     // Catch:{ all -> 0x0036 }
            r5.i()     // Catch:{ all -> 0x0036 }
            com.amap.api.mapcore.util.ja$b r0 = r5.f9406d     // Catch:{ all -> 0x0036 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0036 }
            r2 = 18
            if (r0 < r2) goto L_0x0023
            com.amap.api.mapcore.util.ja$b r0 = r5.f9406d     // Catch:{ all -> 0x001d }
            java.lang.Class<android.os.HandlerThread> r2 = android.os.HandlerThread.class
            java.lang.String r3 = "quitSafely"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x001d }
            com.amap.api.mapcore.util.iq.a((java.lang.Object) r0, (java.lang.Class<?>) r2, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x001d }
            goto L_0x0026
        L_0x001d:
            com.amap.api.mapcore.util.ja$b r0 = r5.f9406d     // Catch:{ all -> 0x0036 }
        L_0x001f:
            r0.quit()     // Catch:{ all -> 0x0036 }
            goto L_0x0026
        L_0x0023:
            com.amap.api.mapcore.util.ja$b r0 = r5.f9406d     // Catch:{ all -> 0x0036 }
            goto L_0x001f
        L_0x0026:
            r0 = 0
            r5.f9406d = r0     // Catch:{ all -> 0x0036 }
            com.amap.api.mapcore.util.jb r0 = r5.f9405c     // Catch:{ all -> 0x0036 }
            r0.b()     // Catch:{ all -> 0x0036 }
            r5.f9409g = r1     // Catch:{ all -> 0x0036 }
            r5.f9410h = r1     // Catch:{ all -> 0x0036 }
            r5.h()     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r0 = move-exception
            java.lang.String r1 = "LocationService"
            java.lang.String r2 = "destroy"
            com.amap.api.mapcore.util.io.a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ja.d():void");
    }
}
