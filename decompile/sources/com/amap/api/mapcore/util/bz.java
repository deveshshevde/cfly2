package com.amap.api.mapcore.util;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import fg.i;

public final class bz {

    /* renamed from: a  reason: collision with root package name */
    a f8092a = null;

    /* renamed from: b  reason: collision with root package name */
    ValueAnimator f8093b;

    /* renamed from: c  reason: collision with root package name */
    Animator.AnimatorListener f8094c = new Animator.AnimatorListener() {
        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            bz.this.k();
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    };

    /* renamed from: d  reason: collision with root package name */
    ValueAnimator.AnimatorUpdateListener f8095d = new ValueAnimator.AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (bz.this.f8098g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    bz.this.f8098g.setCenter(latLng);
                    bz.this.f8097f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private IAMapDelegate f8096e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Marker f8097f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Circle f8098g;

    /* renamed from: h  reason: collision with root package name */
    private MyLocationStyle f8099h = new MyLocationStyle();

    /* renamed from: i  reason: collision with root package name */
    private LatLng f8100i;

    /* renamed from: j  reason: collision with root package name */
    private double f8101j;

    /* renamed from: k  reason: collision with root package name */
    private Context f8102k;

    /* renamed from: l  reason: collision with root package name */
    private s f8103l;

    /* renamed from: m  reason: collision with root package name */
    private int f8104m = 4;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8105n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8106o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8107p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8108q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f8109r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8110s = false;

    public static class a implements TypeEvaluator {
        public final Object evaluate(float f2, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d2 = latLng.latitude;
            double d3 = (double) f2;
            Double.isNaN(d3);
            double d4 = d2 + ((latLng2.latitude - latLng.latitude) * d3);
            double d5 = latLng.longitude;
            Double.isNaN(d3);
            return new LatLng(d4, d5 + (d3 * (latLng2.longitude - latLng.longitude)));
        }
    }

    public bz(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f8102k = applicationContext;
        this.f8096e = iAMapDelegate;
        this.f8103l = new s(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void a(int i2) {
        a(i2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r4 != 7) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4, boolean r5) {
        /*
            r3 = this;
            r3.f8104m = r4
            r0 = 0
            r3.f8105n = r0
            r3.f8107p = r0
            r3.f8106o = r0
            r3.f8109r = r0
            r3.f8110s = r0
            r1 = 1
            if (r4 == r1) goto L_0x002f
            r2 = 2
            if (r4 == r2) goto L_0x002c
            r2 = 3
            if (r4 == r2) goto L_0x0027
            r2 = 4
            if (r4 == r2) goto L_0x0020
            r2 = 5
            if (r4 == r2) goto L_0x0022
            r2 = 7
            if (r4 == r2) goto L_0x0029
            goto L_0x0035
        L_0x0020:
            r3.f8106o = r1
        L_0x0022:
            r3.f8109r = r1
            r3.f8108q = r0
            goto L_0x0035
        L_0x0027:
            r3.f8106o = r1
        L_0x0029:
            r3.f8110s = r1
            goto L_0x0035
        L_0x002c:
            r3.f8106o = r1
            goto L_0x0033
        L_0x002f:
            r3.f8106o = r1
            r3.f8107p = r1
        L_0x0033:
            r3.f8108q = r1
        L_0x0035:
            boolean r4 = r3.f8109r
            if (r4 != 0) goto L_0x004f
            boolean r4 = r3.f8110s
            if (r4 == 0) goto L_0x003e
            goto L_0x004f
        L_0x003e:
            com.amap.api.maps.model.Marker r4 = r3.f8097f
            if (r4 == 0) goto L_0x0045
            r4.setFlat(r0)
        L_0x0045:
            r3.i()
            r3.h()
            r3.g()
            goto L_0x0081
        L_0x004f:
            boolean r4 = r3.f8110s
            if (r4 == 0) goto L_0x0070
            com.amap.api.mapcore.util.s r4 = r3.f8103l
            r4.a((boolean) r1)
            if (r5 != 0) goto L_0x006a
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r3.f8096e     // Catch:{ all -> 0x0066 }
            r5 = 1099431936(0x41880000, float:17.0)
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r5 = com.amap.api.mapcore.util.z.a((float) r5)     // Catch:{ all -> 0x0066 }
            r4.moveCamera(r5)     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006a:
            r4 = 1110704128(0x42340000, float:45.0)
            r3.b((float) r4)
            goto L_0x0075
        L_0x0070:
            com.amap.api.mapcore.util.s r4 = r3.f8103l
            r4.a((boolean) r0)
        L_0x0075:
            com.amap.api.mapcore.util.s r4 = r3.f8103l
            r4.a()
            com.amap.api.maps.model.Marker r4 = r3.f8097f
            if (r4 == 0) goto L_0x0081
            r4.setFlat(r1)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bz.a(int, boolean):void");
    }

    private void a(LatLng latLng) {
        ValueAnimator valueAnimator;
        long j2;
        LatLng position = this.f8097f.getPosition();
        if (position == null) {
            position = new LatLng(i.f27244a, i.f27244a);
        }
        if (this.f8092a == null) {
            this.f8092a = new a();
        }
        ValueAnimator valueAnimator2 = this.f8093b;
        if (valueAnimator2 == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), new Object[]{position, latLng});
            this.f8093b = ofObject;
            ofObject.addListener(this.f8094c);
            this.f8093b.addUpdateListener(this.f8095d);
        } else {
            valueAnimator2.setObjectValues(new Object[]{position, latLng});
            this.f8093b.setEvaluator(this.f8092a);
        }
        if (position.latitude == i.f27244a && position.longitude == i.f27244a) {
            valueAnimator = this.f8093b;
            j2 = 1;
        } else {
            valueAnimator = this.f8093b;
            j2 = 1000;
        }
        valueAnimator.setDuration(j2);
        this.f8093b.start();
    }

    private void a(boolean z2) {
        Circle circle = this.f8098g;
        if (!(circle == null || circle.isVisible() == z2)) {
            this.f8098g.setVisible(z2);
        }
        Marker marker = this.f8097f;
        if (marker != null && marker.isVisible() != z2) {
            this.f8097f.setVisible(z2);
        }
    }

    private void b(float f2) {
        IAMapDelegate iAMapDelegate = this.f8096e;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.moveCamera(z.c(f2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void c(float f2) {
        if (this.f8108q) {
            float f3 = f2 % 360.0f;
            if (f3 > 180.0f) {
                f3 -= 360.0f;
            } else if (f3 < -180.0f) {
                f3 += 360.0f;
            }
            Marker marker = this.f8097f;
            if (marker != null) {
                marker.setRotateAngle(-f3);
            }
        }
    }

    private void g() {
        this.f8103l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        j();
    }

    private void j() {
        IAMapDelegate iAMapDelegate = this.f8096e;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.moveCamera(z.d(0.0f));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.f8100i == null || !this.f8106o) {
            return;
        }
        if (!this.f8107p || !this.f8105n) {
            this.f8105n = true;
            try {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.f8100i.longitude, this.f8100i.latitude, obtain);
                this.f8096e.animateCamera(z.a((Point) obtain));
            } catch (Throwable th) {
                fz.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void l() {
        MyLocationStyle myLocationStyle;
        MyLocationStyle myLocationStyle2 = this.f8099h;
        if (myLocationStyle2 == null) {
            myLocationStyle = new MyLocationStyle();
            this.f8099h = myLocationStyle;
        } else {
            if (myLocationStyle2.getMyLocationIcon() == null || this.f8099h.getMyLocationIcon().getBitmap() == null) {
                myLocationStyle = this.f8099h;
            }
            n();
        }
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        n();
    }

    private void m() {
        Circle circle = this.f8098g;
        if (circle != null) {
            try {
                this.f8096e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                fz.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f8098g = null;
        }
        Marker marker = this.f8097f;
        if (marker != null) {
            marker.remove();
            this.f8097f = null;
            this.f8103l.a((Marker) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0113 A[Catch:{ all -> 0x0128 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n() {
        /*
            r5 = this;
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            if (r0 != 0) goto L_0x0017
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r5.f8096e     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.CircleOptions r1 = new com.amap.api.maps.model.CircleOptions     // Catch:{ all -> 0x0128 }
            r1.<init>()     // Catch:{ all -> 0x0128 }
            r2 = 1065353216(0x3f800000, float:1.0)
            com.amap.api.maps.model.CircleOptions r1 = r1.zIndex(r2)     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.Circle r0 = r0.addCircle(r1)     // Catch:{ all -> 0x0128 }
            r5.f8098g = r0     // Catch:{ all -> 0x0128 }
        L_0x0017:
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            r1 = 1
            if (r0 == 0) goto L_0x007c
            float r0 = r0.getStrokeWidth()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r2 = r2.getStrokeWidth()     // Catch:{ all -> 0x0128 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0035
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r2 = r2.getStrokeWidth()     // Catch:{ all -> 0x0128 }
            r0.setStrokeWidth(r2)     // Catch:{ all -> 0x0128 }
        L_0x0035:
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            int r0 = r0.getFillColor()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            int r2 = r2.getRadiusFillColor()     // Catch:{ all -> 0x0128 }
            if (r0 == r2) goto L_0x004e
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            int r2 = r2.getRadiusFillColor()     // Catch:{ all -> 0x0128 }
            r0.setFillColor(r2)     // Catch:{ all -> 0x0128 }
        L_0x004e:
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            int r0 = r0.getStrokeColor()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            int r2 = r2.getStrokeColor()     // Catch:{ all -> 0x0128 }
            if (r0 == r2) goto L_0x0067
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            int r2 = r2.getStrokeColor()     // Catch:{ all -> 0x0128 }
            r0.setStrokeColor(r2)     // Catch:{ all -> 0x0128 }
        L_0x0067:
            com.amap.api.maps.model.LatLng r0 = r5.f8100i     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0070
            com.amap.api.maps.model.Circle r2 = r5.f8098g     // Catch:{ all -> 0x0128 }
            r2.setCenter(r0)     // Catch:{ all -> 0x0128 }
        L_0x0070:
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            double r2 = r5.f8101j     // Catch:{ all -> 0x0128 }
            r0.setRadius(r2)     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.Circle r0 = r5.f8098g     // Catch:{ all -> 0x0128 }
            r0.setVisible(r1)     // Catch:{ all -> 0x0128 }
        L_0x007c:
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            r2 = 0
            if (r0 != 0) goto L_0x0092
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r5.f8096e     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MarkerOptions r3 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ all -> 0x0128 }
            r3.<init>()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MarkerOptions r3 = r3.visible(r2)     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.Marker r0 = r0.addMarker(r3)     // Catch:{ all -> 0x0128 }
            r5.f8097f = r0     // Catch:{ all -> 0x0128 }
        L_0x0092:
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x011d
            float r0 = r0.getAnchorU()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r3 = r3.getAnchorU()     // Catch:{ all -> 0x0128 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00b4
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            float r0 = r0.getAnchorV()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r3 = r3.getAnchorV()     // Catch:{ all -> 0x0128 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x00c5
        L_0x00b4:
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r3 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r3 = r3.getAnchorU()     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r4 = r5.f8099h     // Catch:{ all -> 0x0128 }
            float r4 = r4.getAnchorV()     // Catch:{ all -> 0x0128 }
            r0.setAnchor(r3, r4)     // Catch:{ all -> 0x0128 }
        L_0x00c5:
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0106
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ all -> 0x0128 }
            int r0 = r0.size()     // Catch:{ all -> 0x0128 }
            if (r0 != 0) goto L_0x00da
            goto L_0x0106
        L_0x00da:
            com.amap.api.maps.model.MyLocationStyle r0 = r5.f8099h     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.BitmapDescriptor r0 = r0.getMyLocationIcon()     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x010f
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            java.util.ArrayList r0 = r0.getIcons()     // Catch:{ all -> 0x0128 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.BitmapDescriptor r0 = (com.amap.api.maps.model.BitmapDescriptor) r0     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ all -> 0x0128 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0128 }
            if (r0 != 0) goto L_0x010f
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ all -> 0x0128 }
        L_0x0102:
            r0.setIcon(r2)     // Catch:{ all -> 0x0128 }
            goto L_0x010f
        L_0x0106:
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.MyLocationStyle r2 = r5.f8099h     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r2.getMyLocationIcon()     // Catch:{ all -> 0x0128 }
            goto L_0x0102
        L_0x010f:
            com.amap.api.maps.model.LatLng r0 = r5.f8100i     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x011d
            com.amap.api.maps.model.Marker r2 = r5.f8097f     // Catch:{ all -> 0x0128 }
            r2.setPosition(r0)     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.Marker r0 = r5.f8097f     // Catch:{ all -> 0x0128 }
            r0.setVisible(r1)     // Catch:{ all -> 0x0128 }
        L_0x011d:
            r5.k()     // Catch:{ all -> 0x0128 }
            com.amap.api.mapcore.util.s r0 = r5.f8103l     // Catch:{ all -> 0x0128 }
            com.amap.api.maps.model.Marker r1 = r5.f8097f     // Catch:{ all -> 0x0128 }
            r0.a((com.amap.api.maps.model.Marker) r1)     // Catch:{ all -> 0x0128 }
            return
        L_0x0128:
            r0 = move-exception
            java.lang.String r1 = "MyLocationOverlay"
            java.lang.String r2 = "myLocStyle"
            com.amap.api.mapcore.util.fz.c(r0, r1, r2)
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bz.n():void");
    }

    public final MyLocationStyle a() {
        return this.f8099h;
    }

    public final void a(float f2) {
        Marker marker = this.f8097f;
        if (marker != null) {
            marker.setRotateAngle(f2);
        }
    }

    public final void a(Location location) {
        if (location != null) {
            a(this.f8099h.isMyLocationShowing());
            if (this.f8099h.isMyLocationShowing()) {
                this.f8100i = new LatLng(location.getLatitude(), location.getLongitude());
                this.f8101j = (double) location.getAccuracy();
                if (this.f8097f == null && this.f8098g == null) {
                    l();
                }
                Circle circle = this.f8098g;
                if (circle != null) {
                    try {
                        double d2 = this.f8101j;
                        if (d2 != -1.0d) {
                            circle.setRadius(d2);
                        }
                    } catch (Throwable th) {
                        fz.c(th, "MyLocationOverlay", "setCentAndRadius");
                        th.printStackTrace();
                    }
                }
                c(location.getBearing());
                if (!this.f8100i.equals(this.f8097f.getPosition())) {
                    a(this.f8100i);
                } else {
                    k();
                }
            }
        }
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.f8099h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.f8099h.isMyLocationShowing()) {
                this.f8103l.a(false);
                this.f8104m = this.f8099h.getMyLocationType();
                return;
            }
            l();
            Marker marker = this.f8097f;
            if (marker != null || this.f8098g != null) {
                this.f8103l.a(marker);
                a(this.f8099h.getMyLocationType());
            }
        } catch (Throwable th) {
            fz.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        s sVar;
        if (this.f8104m == 3 && (sVar = this.f8103l) != null) {
            sVar.a();
        }
    }

    public final void c() throws RemoteException {
        m();
        if (this.f8103l != null) {
            g();
            this.f8103l = null;
        }
    }

    public final String d() {
        Marker marker = this.f8097f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String e() throws RemoteException {
        Circle circle = this.f8098g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void f() {
        this.f8098g = null;
        this.f8097f = null;
    }
}
