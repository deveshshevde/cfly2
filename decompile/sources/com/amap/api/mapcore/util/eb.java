package com.amap.api.mapcore.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

public final class eb {

    /* renamed from: a  reason: collision with root package name */
    Context f8423a;

    /* renamed from: b  reason: collision with root package name */
    Inner_3dMap_locationManagerBase f8424b = null;

    /* renamed from: c  reason: collision with root package name */
    Object f8425c = null;

    /* renamed from: d  reason: collision with root package name */
    boolean f8426d = false;

    /* renamed from: e  reason: collision with root package name */
    iu f8427e = null;

    /* renamed from: f  reason: collision with root package name */
    ff f8428f = null;

    public eb(Context context) {
        try {
            this.f8428f = jd.a();
        } catch (Throwable unused) {
        }
        this.f8427e = new iu();
        a(context);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                this.f8423a = context.getApplicationContext();
                Class<?> cls = Class.forName("com.amap.api.location.AMapLocationClient");
                ServiceInfo serviceInfo = null;
                try {
                    serviceInfo = this.f8423a.getPackageManager().getServiceInfo(new ComponentName(this.f8423a, "com.amap.api.location.APSService"), 128);
                } catch (Throwable unused) {
                }
                if (!(cls == null || serviceInfo == null)) {
                    this.f8426d = true;
                }
            } catch (Throwable th) {
                io.a(th, "AMapLocationClient", "AMapLocationClient 1");
                return;
            }
            if (this.f8426d) {
                this.f8425c = new AMapLocationClient(this.f8423a);
            } else {
                this.f8424b = b(this.f8423a);
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private static Inner_3dMap_locationManagerBase b(Context context) {
        return new iw(context);
    }

    public final void a() {
        try {
            if (this.f8426d) {
                ((AMapLocationClient) this.f8425c).startLocation();
            } else {
                this.f8424b.startLocation();
            }
        } catch (Throwable th) {
            io.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            if (this.f8426d) {
                this.f8427e.a(this.f8425c, inner_3dMap_locationListener);
            } else {
                this.f8424b.setLocationListener(inner_3dMap_locationListener);
            }
        } catch (Throwable th) {
            io.a(th, "AMapLocationClient", "setLocationListener");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption != null) {
            try {
                if (this.f8426d) {
                    iu.a(this.f8425c, inner_3dMap_locationOption);
                } else {
                    this.f8424b.setLocationOption(inner_3dMap_locationOption);
                }
            } catch (Throwable th) {
                io.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public final void b() {
        try {
            if (this.f8426d) {
                ((AMapLocationClient) this.f8425c).stopLocation();
            } else {
                this.f8424b.stopLocation();
            }
        } catch (Throwable th) {
            io.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public final void c() {
        try {
            if (this.f8426d) {
                ((AMapLocationClient) this.f8425c).onDestroy();
            } else {
                this.f8424b.destroy();
            }
            if (this.f8427e != null) {
                this.f8427e = null;
            }
        } catch (Throwable th) {
            io.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
