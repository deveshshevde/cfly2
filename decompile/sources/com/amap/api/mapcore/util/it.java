package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.util.a;

public final class it {

    /* renamed from: a  reason: collision with root package name */
    Context f9348a;

    /* renamed from: b  reason: collision with root package name */
    LocationManager f9349b;

    /* renamed from: c  reason: collision with root package name */
    volatile long f9350c = 0;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f9351d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f9352e = false;

    /* renamed from: f  reason: collision with root package name */
    volatile Inner_3dMap_location f9353f = null;

    /* renamed from: g  reason: collision with root package name */
    Object f9354g = null;

    /* renamed from: h  reason: collision with root package name */
    boolean f9355h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f9356i = false;

    /* renamed from: j  reason: collision with root package name */
    LocationListener f9357j = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setProvider("gps");
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i2 = 0;
                    if (extras != null) {
                        i2 = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i2);
                    inner_3dMap_location.setTime(ip.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                    it.this.f9353f = inner_3dMap_location;
                    it.this.f9350c = is.b();
                    it.this.f9351d = true;
                } catch (Throwable th) {
                    io.a(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equals(str)) {
                    it.this.f9351d = false;
                }
            } catch (Throwable th) {
                io.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    };

    public it(Context context) {
        Object newInstance;
        if (context != null) {
            this.f9348a = context;
            e();
            try {
                if (this.f9354g == null && !this.f9356i) {
                    if (this.f9355h) {
                        newInstance = Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    } else {
                        newInstance = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    this.f9354g = newInstance;
                    if (context == null) {
                        this.f9356i = true;
                    }
                }
            } catch (Throwable unused) {
            }
            if (this.f9349b == null) {
                this.f9349b = (LocationManager) this.f9348a.getSystemService("location");
            }
        }
    }

    private void e() {
        try {
            if (Class.forName("com.amap.api.maps.CoordinateConverter") != null) {
                this.f9355h = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r8 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            if (r0 != 0) goto L_0x000c
            android.content.Context r0 = r8.f9348a     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            android.os.Looper r0 = r0.getMainLooper()     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
        L_0x000c:
            r7 = r0
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            android.location.LocationManager r1 = r8.f9349b     // Catch:{ all -> 0x001b }
            java.lang.String r2 = "gps"
            java.lang.String r3 = "force_xtra_injection"
            r1.sendExtraCommand(r2, r3, r0)     // Catch:{ all -> 0x001b }
        L_0x001b:
            android.location.LocationManager r1 = r8.f9349b     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            java.lang.String r2 = "gps"
            r3 = 800(0x320, double:3.953E-321)
            r5 = 0
            android.location.LocationListener r6 = r8.f9357j     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            r1.requestLocationUpdates(r2, r3, r5, r6, r7)     // Catch:{ SecurityException -> 0x0030, all -> 0x0028 }
            return
        L_0x0028:
            r0 = move-exception
            java.lang.String r1 = "MAPGPSLocation"
            java.lang.String r2 = "requestLocationUpdates"
            com.amap.api.mapcore.util.io.a(r0, r1, r2)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.it.f():void");
    }

    private void g() {
        this.f9351d = false;
        this.f9350c = 0;
        this.f9353f = null;
    }

    public final void a() {
        if (!this.f9352e) {
            f();
            this.f9352e = true;
        }
    }

    public final void b() {
        LocationListener locationListener;
        this.f9352e = false;
        g();
        LocationManager locationManager = this.f9349b;
        if (locationManager != null && (locationListener = this.f9357j) != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    public final boolean c() {
        if (!this.f9351d) {
            return false;
        }
        if (is.b() - this.f9350c <= 10000) {
            return true;
        }
        this.f9353f = null;
        return false;
    }

    public final Inner_3dMap_location d() {
        Object obj;
        Object obj2;
        if (this.f9353f == null) {
            return null;
        }
        Inner_3dMap_location clone = this.f9353f.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.f9354g != null) {
                    if (io.a(clone.getLatitude(), clone.getLongitude())) {
                        Object[] objArr = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.f9355h) {
                            obj2 = iq.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, (Class<?>[]) clsArr);
                            obj = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE}).newInstance(new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())});
                        } else {
                            obj2 = iq.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, (Class<?>[]) clsArr);
                            obj = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE}).newInstance(new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())});
                        }
                        iq.a(this.f9354g, "coord", obj);
                        iq.a(this.f9354g, "from", obj2);
                        Object a2 = iq.a(this.f9354g, "convert", new Object[0]);
                        double doubleValue = ((Double) a2.getClass().getDeclaredField("latitude").get(a2)).doubleValue();
                        double doubleValue2 = ((Double) a2.getClass().getDeclaredField("longitude").get(a2)).doubleValue();
                        clone.setLatitude(doubleValue);
                        clone.setLongitude(doubleValue2);
                    }
                } else if (this.f9356i && io.a(clone.getLatitude(), clone.getLongitude())) {
                    double[] a3 = a.a(clone.getLongitude(), clone.getLatitude());
                    clone.setLatitude(a3[1]);
                    clone.setLongitude(a3[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return clone;
    }
}
