package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* renamed from: a  reason: collision with root package name */
    IAMapDelegate f9658a;

    /* renamed from: b  reason: collision with root package name */
    boolean f9659b = false;

    /* renamed from: c  reason: collision with root package name */
    List<String> f9660c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Context f9661d;

    /* renamed from: e  reason: collision with root package name */
    private int f9662e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final Object f9663f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private AMapNativeGlOverlayLayer f9664g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, BaseOverlay> f9665h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Pair<BaseOverlay, BaseOptions>> f9666i;

    /* renamed from: j  reason: collision with root package name */
    private ca f9667j;

    /* renamed from: k  reason: collision with root package name */
    private BitmapDescriptor f9668k = null;

    /* renamed from: l  reason: collision with root package name */
    private BitmapDescriptor f9669l = null;

    /* renamed from: m  reason: collision with root package name */
    private BitmapDescriptor f9670m = null;

    /* renamed from: n  reason: collision with root package name */
    private BitmapDescriptor f9671n = null;

    /* renamed from: o  reason: collision with root package name */
    private BitmapDescriptor f9672o = null;

    /* renamed from: p  reason: collision with root package name */
    private BitmapDescriptor f9673p = null;

    /* renamed from: q  reason: collision with root package name */
    private BitmapDescriptor f9674q = null;

    /* renamed from: r  reason: collision with root package name */
    private BitmapDescriptor f9675r = null;

    public o(IAMapDelegate iAMapDelegate, Context context) {
        this.f9658a = iAMapDelegate;
        this.f9661d = context;
        this.f9665h = new HashMap();
        this.f9666i = new ArrayList<>();
        this.f9664g = new AMapNativeGlOverlayLayer();
        this.f9667j = new ca(iAMapDelegate);
    }

    private BitmapDescriptor a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f9661d != null) {
            LinearLayout linearLayout = new LinearLayout(this.f9661d);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(dl.a(view));
    }

    private void a(String str, BaseOptions baseOptions) {
        try {
            this.f9664g.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            fz.c(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            Log.d("amapApi", "GlOverlayLayer addOverlay error:" + th.getMessage());
        }
    }

    private void a(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        a(str, baseOptions);
        synchronized (this.f9665h) {
            this.f9665h.put(str, baseOverlay);
        }
    }

    public final boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        if (!(latLng == null || circleOptions == null)) {
            try {
                synchronized (circleOptions) {
                    List<BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                    if (holeOptions != null && holeOptions.size() > 0) {
                        for (BaseHoleOptions a2 : holeOptions) {
                            if (dl.a(a2, latLng)) {
                                return false;
                            }
                        }
                    }
                    return circleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                for (BaseHoleOptions a2 : holeOptions) {
                    if (dl.a(a2, latLng)) {
                        return false;
                    }
                }
            }
            return dl.a(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        a(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    public final void changeOverlayIndex() {
    }

    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new Object[]{str});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    public final synchronized void clear(String... strArr) {
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
            if (!(aMapNativeGlOverlayLayer == null || strArr == null)) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f9665h) {
                if (strArr != null) {
                    Iterator<Map.Entry<String, BaseOverlay>> it2 = this.f9665h.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        int length = strArr.length;
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                String str = strArr[i2];
                                if (str != null && str.equals(next.getKey())) {
                                    z2 = true;
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        if (!z2) {
                            it2.remove();
                        }
                    }
                } else {
                    this.f9665h.clear();
                }
            }
            synchronized (this.f9666i) {
                this.f9666i.clear();
            }
        } catch (Throwable th) {
            fz.c(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    public final void clearTileCache() {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", (Object[]) null);
        }
    }

    public final String createId(String str) {
        String str2;
        synchronized (this.f9663f) {
            this.f9662e++;
            str2 = str + this.f9662e;
        }
        return str2;
    }

    public final synchronized void destroy() {
        try {
            if (this.f9664g != null) {
                synchronized (this.f9665h) {
                    this.f9665h.clear();
                }
                synchronized (this.f9666i) {
                    this.f9666i.clear();
                }
                this.f9664g.clear("");
                this.f9664g.destroy();
                this.f9664g = null;
            }
        } catch (Throwable th) {
            fz.c(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    public final synchronized boolean draw(int i2, int i3, boolean z2) {
        boolean z3;
        z3 = false;
        try {
            ca caVar = this.f9667j;
            if (caVar != null) {
                caVar.a();
            }
            MapConfig mapConfig = this.f9658a.getMapConfig();
            if (mapConfig == null) {
                return false;
            }
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
            if (aMapNativeGlOverlayLayer != null) {
                aMapNativeGlOverlayLayer.setConfig(mapConfig, Float.valueOf(this.f9658a.getZoomLevel()));
                this.f9664g.render(i2, i3, z2);
            }
            z3 = true;
        } catch (Throwable th) {
            fz.c(th, "GlOverlayLayer", "draw");
        }
        return z3;
    }

    public final BitmapDescriptor getBuildInImageData(int i2) {
        switch (i2) {
            case 0:
                BitmapDescriptor bitmapDescriptor = this.f9668k;
                if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                    this.f9668k = BitmapDescriptorFactory.fromBitmap(dl.a(this.f9661d, "amap_sdk_lineTexture.png"));
                }
                return this.f9668k;
            case 1:
                BitmapDescriptor bitmapDescriptor2 = this.f9671n;
                if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                    this.f9671n = BitmapDescriptorFactory.fromBitmap(dl.a(this.f9661d, "amap_sdk_lineTexture.png"));
                }
                return this.f9671n;
            case 2:
                BitmapDescriptor bitmapDescriptor3 = this.f9670m;
                if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                    this.f9670m = BitmapDescriptorFactory.fromBitmap(dl.a(this.f9661d, "amap_sdk_lineDashTexture_circle.png"));
                }
                return this.f9670m;
            case 3:
                BitmapDescriptor bitmapDescriptor4 = this.f9669l;
                if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                    this.f9669l = BitmapDescriptorFactory.fromBitmap(dl.a(this.f9661d, "amap_sdk_lineDashTexture_square.png"));
                }
                return this.f9669l;
            case 4:
                BitmapDescriptor bitmapDescriptor5 = this.f9672o;
                if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                    this.f9672o = BitmapDescriptorFactory.defaultMarker();
                }
                return this.f9672o;
            case 5:
                BitmapDescriptor bitmapDescriptor6 = this.f9673p;
                if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                    this.f9673p = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                }
                return this.f9673p;
            case 6:
                BitmapDescriptor bitmapDescriptor7 = this.f9674q;
                if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                    this.f9674q = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                }
                return this.f9674q;
            case 7:
                try {
                    BitmapDescriptor bitmapDescriptor8 = this.f9675r;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.f9675r = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.f9675r;
                } catch (Throwable unused) {
                    return null;
                }
            default:
                return null;
        }
    }

    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i2) {
        if (this.f9658a == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f9658a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f10010y, obtain.f10009x);
        obtain.recycle();
        return getHitBaseOverlay(latLng, i2);
    }

    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i2) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer == null) {
            return null;
        }
        String contain = aMapNativeGlOverlayLayer.contain(latLng, i2);
        if (TextUtils.isEmpty(contain)) {
            return null;
        }
        synchronized (this.f9665h) {
            baseOverlay = this.f9665h.get(contain);
        }
        return baseOverlay;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.amap.api.maps.model.Polyline getHitOverlay(com.amap.api.maps.model.LatLng r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer r0 = r2.f9664g     // Catch:{ all -> 0x002b }
            r1 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.String r3 = r0.contain(r3, r4)     // Catch:{ all -> 0x002b }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002b }
            if (r4 == 0) goto L_0x0012
            monitor-exit(r2)
            return r1
        L_0x0012:
            java.util.Map<java.lang.String, com.amap.api.maps.model.BaseOverlay> r4 = r2.f9665h     // Catch:{ all -> 0x002b }
            monitor-enter(r4)     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, com.amap.api.maps.model.BaseOverlay> r0 = r2.f9665h     // Catch:{ all -> 0x0026 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0026 }
            com.amap.api.maps.model.BaseOverlay r3 = (com.amap.api.maps.model.BaseOverlay) r3     // Catch:{ all -> 0x0026 }
            boolean r0 = r3 instanceof com.amap.api.maps.model.Polyline     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            com.amap.api.maps.model.Polyline r3 = (com.amap.api.maps.model.Polyline) r3     // Catch:{ all -> 0x0026 }
            r1 = r3
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
            throw r3     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r2)
            return r1
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o.getHitOverlay(com.amap.api.maps.model.LatLng, int):com.amap.api.maps.model.Polyline");
    }

    public final BitmapDescriptor getInfoContents(String str) {
        aj infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f9658a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f9665h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.b((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    public final BitmapDescriptor getInfoWindow(String str) {
        aj infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f9658a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f9665h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.a((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    public final long getInfoWindowUpdateOffsetTime(String str) {
        aj infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f9658a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0;
        }
        BaseOverlay baseOverlay = this.f9665h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.c((BasePointOverlay) baseOverlay);
        }
        return 0;
    }

    public final IAMapDelegate getMap() {
        return this.f9658a;
    }

    public final List<Marker> getMapScreenMarkers() {
        if (this.f9664g == null) {
            return null;
        }
        this.f9660c.clear();
        this.f9664g.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f9660c});
        if (this.f9660c.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : this.f9660c) {
            if (next != null && next.contains("MARKER")) {
                arrayList.add((Marker) this.f9665h.get(next));
            }
        }
        return arrayList;
    }

    public final void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", (Object[]) null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                fPoint.x = (float) point.x;
                fPoint.y = (float) point.y;
            }
        }
    }

    public final MultiPointItem getMultiPointItem(LatLng latLng) {
        List<MultiPointItem> items;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
            if (aMapNativeGlOverlayLayer == null) {
                return null;
            }
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
            if (!(nativeProperties instanceof MultiPointItemHitTest)) {
                return null;
            }
            MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
            if (multiPointItemHitTest.index == -1) {
                return null;
            }
            BaseOverlay baseOverlay = this.f9665h.get(multiPointItemHitTest.overlayName);
            if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null || items.size() <= multiPointItemHitTest.index) {
                return null;
            }
            return items.get(multiPointItemHitTest.index);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Object getNativeProperties(String str, String str2, Object[] objArr) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (!(latLng == null || polylineOptions == null || (points = polylineOptions.getPoints()) == null || points.size() == 0)) {
            float f2 = 0.0f;
            int i2 = 0;
            int i3 = 0;
            while (i2 < points.size()) {
                try {
                    if (i2 == 0) {
                        f2 = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i2));
                        if (f2 > calculateLineDistance) {
                            i3 = i2;
                            f2 = calculateLineDistance;
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    fz.c(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i3);
        }
        return null;
    }

    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f9665h.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f9664g.getNativeProperties(str, "getMarkerScreenPos", (Object[]) null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                fPoint.x = (float) point.x;
                fPoint.y = (float) point.y;
            }
        }
    }

    public final BitmapDescriptor getOverturnInfoWindow(String str) {
        return null;
    }

    public final BitmapDescriptor getOverturnInfoWindowClick(String str) {
        return null;
    }

    public final void hideInfoWindow(String str) {
        if (this.f9664g != null) {
            this.f9658a.hideInfoWindow();
            this.f9664g.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    public final void onCreateAMapInstance() {
        if (this.f9664g == null) {
            this.f9664g = new AMapNativeGlOverlayLayer();
        }
        this.f9664g.createNative(this.f9658a.getGLMapEngine().getNativeInstance());
        this.f9664g.setNativeFunCallListener(this);
    }

    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f9658a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    public final void onSetRunLowFrame(boolean z2) {
        setRunLowFrame(z2);
    }

    public final boolean removeOverlay(String str) {
        boolean z2;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z2 = true;
        } else {
            z2 = false;
        }
        synchronized (this.f9665h) {
            this.f9665h.remove(str);
        }
        return z2;
    }

    public final boolean removeOverlay(String str, boolean z2) {
        return false;
    }

    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", (Object[]) null);
        }
    }

    public final void setFlingState(boolean z2) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f9664g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z2)});
        }
    }

    public final void setRunLowFrame(boolean z2) {
        IAMapDelegate iAMapDelegate = this.f9658a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z2);
        }
    }

    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f9664g != null && (map = this.f9665h) != null) {
            try {
                this.f9658a.showInfoWindow(map.get(str));
                setRunLowFrame(false);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f9664g != null) {
                setRunLowFrame(false);
                this.f9664g.updateOptions(str, baseOptions);
            }
        } catch (Throwable th) {
            fz.c(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }
}
