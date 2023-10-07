package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.amap.api.mapcore.util.a;
import com.amap.api.mapcore.util.ci;
import com.amap.api.mapcore.util.dt;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glinterface.MapLabelItem;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import fg.i;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements a.C0072a, ci.a, IAMapDelegate, IAMapListener {
    /* access modifiers changed from: private */
    public final u A;
    private boolean B;
    private final IGLSurfaceView C;
    /* access modifiers changed from: private */
    public dw D;
    /* access modifiers changed from: private */
    public final IGlOverlayLayer E;
    private boolean F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public boolean H;
    /* access modifiers changed from: private */
    public boolean I;
    private boolean J;
    private boolean K;
    private bz L;
    private LocationSource M;
    private boolean N;
    private Marker O;
    private BaseOverlayImp P;
    private Marker Q;
    private boolean R;
    private boolean S;
    private boolean T;
    /* access modifiers changed from: private */
    public boolean U;
    private boolean V;
    private boolean W;
    private Rect X;
    private int Y;
    private MyTrafficStyle Z;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f7897a;
    private Lock aA;
    private int aB;
    /* access modifiers changed from: private */
    public int aC;
    /* access modifiers changed from: private */
    public int aD;
    /* access modifiers changed from: private */
    public C0073b aE;
    private ce aF;
    private AMap.OnMultiPointClickListener aG;
    private a aH;
    private long aI;
    private a aJ;
    private a aK;
    private a aL;
    private a aM;
    private a aN;
    private a aO;
    private a aP;
    private a aQ;
    private a aR;
    private a aS;
    private a aT;
    private a aU;
    private Runnable aV;
    private a aW;
    private com.autonavi.extra.b aX;
    private String aY;
    private String aZ;

    /* renamed from: aa  reason: collision with root package name */
    private Thread f7898aa;

    /* renamed from: ab  reason: collision with root package name */
    private Thread f7899ab;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f7900ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f7901ad;
    /* access modifiers changed from: private */

    /* renamed from: ae  reason: collision with root package name */
    public boolean f7902ae;

    /* renamed from: af  reason: collision with root package name */
    private int f7903af;

    /* renamed from: ag  reason: collision with root package name */
    private CustomRenderer f7904ag;

    /* renamed from: ah  reason: collision with root package name */
    private int f7905ah;

    /* renamed from: ai  reason: collision with root package name */
    private int f7906ai;

    /* renamed from: aj  reason: collision with root package name */
    private List<q> f7907aj;

    /* renamed from: ak  reason: collision with root package name */
    private cg f7908ak;

    /* renamed from: al  reason: collision with root package name */
    private ci f7909al;

    /* renamed from: am  reason: collision with root package name */
    private long f7910am;
    /* access modifiers changed from: private */

    /* renamed from: an  reason: collision with root package name */
    public GLMapRender f7911an;

    /* renamed from: ao  reason: collision with root package name */
    private n f7912ao;

    /* renamed from: ap  reason: collision with root package name */
    private boolean f7913ap;

    /* renamed from: aq  reason: collision with root package name */
    private float f7914aq;

    /* renamed from: ar  reason: collision with root package name */
    private float f7915ar;

    /* renamed from: as  reason: collision with root package name */
    private float f7916as;

    /* renamed from: at  reason: collision with root package name */
    private boolean f7917at;

    /* renamed from: au  reason: collision with root package name */
    private boolean f7918au;
    /* access modifiers changed from: private */

    /* renamed from: av  reason: collision with root package name */
    public boolean f7919av;
    /* access modifiers changed from: private */

    /* renamed from: aw  reason: collision with root package name */
    public volatile boolean f7920aw;

    /* renamed from: ax  reason: collision with root package name */
    private volatile boolean f7921ax;

    /* renamed from: ay  reason: collision with root package name */
    private boolean f7922ay;

    /* renamed from: az  reason: collision with root package name */
    private boolean f7923az;

    /* renamed from: b  reason: collision with root package name */
    protected MapConfig f7924b;

    /* renamed from: ba  reason: collision with root package name */
    private boolean f7925ba;

    /* renamed from: bb  reason: collision with root package name */
    private boolean f7926bb;

    /* renamed from: bc  reason: collision with root package name */
    private int f7927bc;

    /* renamed from: bd  reason: collision with root package name */
    private EAMapPlatformGestureInfo f7928bd;

    /* renamed from: be  reason: collision with root package name */
    private long f7929be;
    /* access modifiers changed from: private */

    /* renamed from: bf  reason: collision with root package name */
    public ai f7930bf;

    /* renamed from: bg  reason: collision with root package name */
    private IPoint[] f7931bg;

    /* renamed from: c  reason: collision with root package name */
    protected ai f7932c;

    /* renamed from: d  reason: collision with root package name */
    dc f7933d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f7934e;

    /* renamed from: f  reason: collision with root package name */
    protected GLMapEngine f7935f;

    /* renamed from: g  reason: collision with root package name */
    public int f7936g;

    /* renamed from: h  reason: collision with root package name */
    public int f7937h;

    /* renamed from: i  reason: collision with root package name */
    boolean f7938i;

    /* renamed from: j  reason: collision with root package name */
    protected final Handler f7939j;

    /* renamed from: k  reason: collision with root package name */
    Point f7940k;

    /* renamed from: l  reason: collision with root package name */
    Rect f7941l;

    /* renamed from: m  reason: collision with root package name */
    protected String f7942m;

    /* renamed from: n  reason: collision with root package name */
    float[] f7943n;

    /* renamed from: o  reason: collision with root package name */
    float[] f7944o;

    /* renamed from: p  reason: collision with root package name */
    float[] f7945p;

    /* renamed from: q  reason: collision with root package name */
    float[] f7946q;

    /* renamed from: r  reason: collision with root package name */
    String f7947r;

    /* renamed from: s  reason: collision with root package name */
    String f7948s;

    /* renamed from: t  reason: collision with root package name */
    int f7949t;

    /* renamed from: u  reason: collision with root package name */
    private f f7950u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public g f7951v;

    /* renamed from: w  reason: collision with root package name */
    private AMapGestureListener f7952w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public aj f7953x;

    /* renamed from: y  reason: collision with root package name */
    private UiSettings f7954y;

    /* renamed from: z  reason: collision with root package name */
    private IProjectionDelegate f7955z;

    private static abstract class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        boolean f8028b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8029c;

        /* renamed from: d  reason: collision with root package name */
        int f8030d;

        /* renamed from: e  reason: collision with root package name */
        int f8031e;

        /* renamed from: f  reason: collision with root package name */
        int f8032f;

        /* renamed from: g  reason: collision with root package name */
        int f8033g;

        /* renamed from: h  reason: collision with root package name */
        int f8034h;

        /* renamed from: i  reason: collision with root package name */
        int f8035i;

        /* renamed from: j  reason: collision with root package name */
        byte[] f8036j;

        private a() {
            this.f8028b = false;
            this.f8029c = false;
            this.f8034h = 0;
            this.f8035i = 0;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public void run() {
            this.f8028b = false;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$b  reason: collision with other inner class name */
    class C0073b {
        C0073b() {
        }

        public final void a(ai aiVar) {
            List a2;
            List a3;
            if (b.this.f7924b != null && b.this.f7924b.isIndoorEnable()) {
                final dt e2 = b.this.D.e();
                float f2 = 20.0f;
                if (aiVar == null) {
                    try {
                        List a4 = b.this.f7951v.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                        if (a4 != null && a4.size() > 0) {
                            synchronized (a4) {
                                for (int i2 = 0; i2 < a4.size(); i2++) {
                                    ((AMap.OnIndoorBuildingActiveListener) a4.get(i2)).OnIndoorBuilding(aiVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (b.this.f7932c != null) {
                        b.this.f7932c.f7784g = null;
                    }
                    if (e2.b()) {
                        b.this.f7939j.post(new Runnable() {
                            public final void run() {
                                e2.a(false);
                            }
                        });
                    }
                    b.this.f7924b.maxZoomLevel = b.this.f7924b.isSetLimitZoomLevel() ? b.this.f7924b.getMaxZoomLevel() : 20.0f;
                    try {
                        if (b.this.A.isZoomControlsEnabled() && (a3 = b.this.f7951v.a(AMapWidgetListener.class.hashCode())) != null && a3.size() > 0) {
                            synchronized (a3) {
                                for (int i3 = 0; i3 < a3.size(); i3++) {
                                    ((AMapWidgetListener) a3.get(i3)).invalidateZoomController(b.this.f7924b.getSZ());
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (aiVar != null && aiVar.floor_indexs != null && aiVar.floor_names != null && aiVar.floor_indexs.length == aiVar.floor_names.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= aiVar.floor_indexs.length) {
                            break;
                        } else if (aiVar.activeFloorIndex == aiVar.floor_indexs[i4]) {
                            aiVar.activeFloorName = aiVar.floor_names[i4];
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                if (aiVar == null || b.this.f7932c == null || b.this.f7932c.activeFloorIndex == aiVar.activeFloorIndex || !e2.b()) {
                    if (aiVar != null && (b.this.f7932c == null || !b.this.f7932c.poiid.equals(aiVar.poiid) || b.this.f7932c.f7784g == null)) {
                        b.this.f7932c = aiVar;
                        if (b.this.f7924b != null) {
                            if (b.this.f7932c.f7784g == null) {
                                b.this.f7932c.f7784g = new Point();
                            }
                            DPoint mapGeoCenter = b.this.f7924b.getMapGeoCenter();
                            if (mapGeoCenter != null) {
                                b.this.f7932c.f7784g.x = (int) mapGeoCenter.f10009x;
                                b.this.f7932c.f7784g.y = (int) mapGeoCenter.f10010y;
                            }
                        }
                    }
                    try {
                        List a5 = b.this.f7951v.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                        if (a5 != null && a5.size() > 0) {
                            synchronized (a5) {
                                for (int i5 = 0; i5 < a5.size(); i5++) {
                                    ((AMap.OnIndoorBuildingActiveListener) a5.get(i5)).OnIndoorBuilding(aiVar);
                                }
                            }
                        }
                        MapConfig mapConfig = b.this.f7924b;
                        if (b.this.f7924b.isSetLimitZoomLevel()) {
                            f2 = b.this.f7924b.getMaxZoomLevel();
                        }
                        mapConfig.maxZoomLevel = f2;
                        if (b.this.A.isZoomControlsEnabled() && (a2 = b.this.f7951v.a(AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                            synchronized (a2) {
                                for (int i6 = 0; i6 < a2.size(); i6++) {
                                    ((AMapWidgetListener) a2.get(i6)).invalidateZoomController(b.this.f7924b.getSZ());
                                }
                            }
                        }
                        if (b.this.A.isIndoorSwitchEnabled()) {
                            if (!e2.b()) {
                                b.this.A.setIndoorSwitchEnabled(true);
                            }
                            b.this.f7939j.post(new Runnable() {
                                public final void run() {
                                    try {
                                        e2.a(b.this.f7932c.floor_names);
                                        e2.a(b.this.f7932c.activeFloorName);
                                        if (!e2.b()) {
                                            e2.a(true);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        } else if (!b.this.A.isIndoorSwitchEnabled() && e2.b()) {
                            b.this.A.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    private class c implements dt.a {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        public final void a(int i2) {
            if (b.this.f7932c != null) {
                b.this.f7932c.activeFloorIndex = b.this.f7932c.floor_indexs[i2];
                b.this.f7932c.activeFloorName = b.this.f7932c.floor_names[i2];
                try {
                    b bVar = b.this;
                    bVar.setIndoorBuildingInfo(bVar.f7932c);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f8044b;

        /* renamed from: c  reason: collision with root package name */
        private AMap.OnCacheRemoveListener f8045c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f8044b = context;
            this.f8045c = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof d;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ all -> 0x0062 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A[Catch:{ all -> 0x005d }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0077 A[Catch:{ all -> 0x007b }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.f8044b     // Catch:{ all -> 0x0062 }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0062 }
                java.lang.String r3 = com.amap.api.mapcore.util.dl.c((android.content.Context) r2)     // Catch:{ all -> 0x0062 }
                java.lang.String r4 = com.amap.api.mapcore.util.dl.a((android.content.Context) r2)     // Catch:{ all -> 0x0062 }
                java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0062 }
                r5.<init>(r3)     // Catch:{ all -> 0x0062 }
                boolean r3 = r5.exists()     // Catch:{ all -> 0x0062 }
                if (r3 == 0) goto L_0x0020
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch:{ all -> 0x0062 }
                goto L_0x0021
            L_0x0020:
                r3 = 1
            L_0x0021:
                if (r3 == 0) goto L_0x0033
                java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0030 }
                r5.<init>(r4)     // Catch:{ all -> 0x0030 }
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch:{ all -> 0x0030 }
                if (r3 == 0) goto L_0x0033
                r3 = 1
                goto L_0x0034
            L_0x0030:
                r2 = move-exception
                r1 = r3
                goto L_0x0063
            L_0x0033:
                r3 = 0
            L_0x0034:
                if (r3 == 0) goto L_0x003d
                boolean r2 = com.amap.api.mapcore.util.dl.e(r2)     // Catch:{ all -> 0x0030 }
                if (r2 == 0) goto L_0x003d
                goto L_0x003e
            L_0x003d:
                r1 = 0
            L_0x003e:
                com.amap.api.mapcore.util.b r2 = com.amap.api.mapcore.util.b.this     // Catch:{ all -> 0x0062 }
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = r2.E     // Catch:{ all -> 0x0062 }
                if (r2 == 0) goto L_0x004f
                com.amap.api.mapcore.util.b r2 = com.amap.api.mapcore.util.b.this     // Catch:{ all -> 0x0062 }
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = r2.E     // Catch:{ all -> 0x0062 }
                r2.clearTileCache()     // Catch:{ all -> 0x0062 }
            L_0x004f:
                com.amap.api.mapcore.util.b r0 = com.amap.api.mapcore.util.b.this     // Catch:{ all -> 0x005d }
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.f7935f     // Catch:{ all -> 0x005d }
                if (r0 == 0) goto L_0x0061
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f8045c     // Catch:{ all -> 0x005d }
                if (r0 == 0) goto L_0x0061
                r0.onRemoveCacheFinish(r1)     // Catch:{ all -> 0x005d }
                goto L_0x0061
            L_0x005d:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0061:
                return
            L_0x0062:
                r2 = move-exception
            L_0x0063:
                com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0080 }
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.mapcore.util.fz.c(r2, r3, r4)     // Catch:{ all -> 0x0080 }
                com.amap.api.mapcore.util.b r1 = com.amap.api.mapcore.util.b.this     // Catch:{ all -> 0x007b }
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.f7935f     // Catch:{ all -> 0x007b }
                if (r1 == 0) goto L_0x007f
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f8045c     // Catch:{ all -> 0x007b }
                if (r1 == 0) goto L_0x007f
                r1.onRemoveCacheFinish(r0)     // Catch:{ all -> 0x007b }
                goto L_0x007f
            L_0x007b:
                r0 = move-exception
                r0.printStackTrace()
            L_0x007f:
                return
            L_0x0080:
                r0 = move-exception
                com.amap.api.mapcore.util.b r2 = com.amap.api.mapcore.util.b.this     // Catch:{ all -> 0x008f }
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.f7935f     // Catch:{ all -> 0x008f }
                if (r2 == 0) goto L_0x0093
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f8045c     // Catch:{ all -> 0x008f }
                if (r2 == 0) goto L_0x0093
                r2.onRemoveCacheFinish(r1)     // Catch:{ all -> 0x008f }
                goto L_0x0093
            L_0x008f:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0093:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b.d.run():void");
        }
    }

    public b(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    public b(IGLSurfaceView iGLSurfaceView, Context context, boolean z2) {
        this.f7950u = null;
        this.f7951v = new g();
        boolean z3 = false;
        this.f7897a = false;
        this.B = false;
        this.F = false;
        this.H = false;
        this.I = false;
        this.f7924b = new MapConfig(true);
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = true;
        this.X = new Rect();
        this.Y = 1;
        this.Z = null;
        this.f7900ac = false;
        this.f7901ad = false;
        this.f7902ae = false;
        this.f7903af = 0;
        this.f7905ah = -1;
        this.f7906ai = -1;
        this.f7907aj = new ArrayList();
        this.f7933d = null;
        this.f7910am = -1;
        this.f7913ap = false;
        this.f7914aq = 0.0f;
        this.f7915ar = 1.0f;
        this.f7916as = 1.0f;
        this.f7917at = true;
        this.f7918au = false;
        this.f7919av = false;
        this.f7920aw = false;
        this.f7921ax = false;
        this.f7922ay = false;
        this.f7923az = false;
        this.aA = new ReentrantLock();
        this.aB = 0;
        this.f7938i = true;
        this.f7939j = new Handler(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message != null && !b.this.H) {
                    try {
                        int i2 = message.what;
                        if (i2 != 2) {
                            int i3 = 0;
                            switch (i2) {
                                case 10:
                                    CameraPosition cameraPosition = (CameraPosition) message.obj;
                                    try {
                                        List<AMap.OnCameraChangeListener> a2 = b.this.f7951v.a(AMap.OnCameraChangeListener.class.hashCode());
                                        if (!(cameraPosition == null || a2 == null || a2.size() <= 0)) {
                                            synchronized (a2) {
                                                for (AMap.OnCameraChangeListener onCameraChange : a2) {
                                                    onCameraChange.onCameraChange(cameraPosition);
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        dl.a(th);
                                    }
                                    b.this.f7924b.addChangedCounter();
                                    return;
                                case 11:
                                    CameraPosition cameraPosition2 = b.this.getCameraPosition();
                                    if (!(cameraPosition2 == null || b.this.D == null)) {
                                        b.this.D.a(cameraPosition2);
                                    }
                                    b.this.b(cameraPosition2);
                                    if (b.this.f7919av) {
                                        boolean unused = b.this.f7919av = false;
                                        if (b.this.E != null) {
                                            b.this.E.setFlingState(false);
                                        }
                                        b.this.b();
                                    }
                                    if (b.this.U) {
                                        b.this.redrawInfoWindow();
                                        boolean unused2 = b.this.U = false;
                                    }
                                    b.this.a(cameraPosition2);
                                    return;
                                case 12:
                                    if (b.this.D != null) {
                                        b.this.D.a(Float.valueOf(b.this.getZoomLevel()));
                                        return;
                                    }
                                    return;
                                case 13:
                                    if (b.this.D != null) {
                                        b.this.D.h();
                                        return;
                                    }
                                    return;
                                case 14:
                                    try {
                                        List<AMap.OnMapTouchListener> a3 = b.this.f7951v.a(AMap.OnMapTouchListener.class.hashCode());
                                        if (a3 != null && a3.size() > 0) {
                                            synchronized (a3) {
                                                for (AMap.OnMapTouchListener onTouch : a3) {
                                                    onTouch.onTouch((MotionEvent) message.obj);
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        fz.c(th2, "AMapDelegateImp", "onTouchHandler");
                                        th2.printStackTrace();
                                        return;
                                    }
                                case 15:
                                    Bitmap bitmap = (Bitmap) message.obj;
                                    int i4 = message.arg1;
                                    ArrayList arrayList = null;
                                    if (bitmap == null || b.this.D == null) {
                                        try {
                                            List a4 = b.this.f7951v.a(AMap.onMapPrintScreenListener.class.hashCode());
                                            ArrayList arrayList2 = a4 != null ? new ArrayList(a4) : null;
                                            List a5 = b.this.f7951v.a(AMap.OnMapScreenShotListener.class.hashCode());
                                            ArrayList arrayList3 = a5 != null ? new ArrayList(a5) : null;
                                            b.this.f7951v.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                            b.this.f7951v.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                            if (arrayList2 != null && arrayList2.size() > 0) {
                                                synchronized (arrayList2) {
                                                    for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                                                        ((AMap.onMapPrintScreenListener) arrayList2.get(i5)).onMapPrint((Drawable) null);
                                                    }
                                                }
                                            }
                                            if (arrayList3 != null && arrayList3.size() > 0) {
                                                synchronized (arrayList3) {
                                                    while (i3 < arrayList3.size()) {
                                                        ((AMap.OnMapScreenShotListener) arrayList3.get(i3)).onMapScreenShot((Bitmap) null);
                                                        ((AMap.OnMapScreenShotListener) arrayList3.get(i3)).onMapScreenShot((Bitmap) null, i4);
                                                        i3++;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th3) {
                                            th3.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        Canvas canvas = new Canvas(bitmap);
                                        dz f2 = b.this.D.f();
                                        if (f2 != null) {
                                            f2.onDraw(canvas);
                                        }
                                        b.this.D.a(canvas);
                                        try {
                                            List a6 = b.this.f7951v.a(AMap.onMapPrintScreenListener.class.hashCode());
                                            ArrayList arrayList4 = a6 != null ? new ArrayList(a6) : null;
                                            List a7 = b.this.f7951v.a(AMap.OnMapScreenShotListener.class.hashCode());
                                            if (a7 != null) {
                                                arrayList = new ArrayList(a7);
                                            }
                                            b.this.f7951v.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                            b.this.f7951v.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                            if (arrayList4 != null && arrayList4.size() > 0) {
                                                synchronized (arrayList4) {
                                                    for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                                                        ((AMap.onMapPrintScreenListener) arrayList4.get(i6)).onMapPrint(new BitmapDrawable(b.this.f7934e.getResources(), bitmap));
                                                    }
                                                }
                                            }
                                            if (arrayList != null && arrayList.size() > 0) {
                                                synchronized (arrayList) {
                                                    while (i3 < arrayList.size()) {
                                                        ((AMap.OnMapScreenShotListener) arrayList.get(i3)).onMapScreenShot(bitmap);
                                                        ((AMap.OnMapScreenShotListener) arrayList.get(i3)).onMapScreenShot(bitmap, i4);
                                                        i3++;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th4) {
                                            th4.printStackTrace();
                                            return;
                                        }
                                    }
                                case 16:
                                    try {
                                        List a8 = b.this.f7951v.a(AMap.OnMapLoadedListener.class.hashCode());
                                        if (a8 != null) {
                                            synchronized (a8) {
                                                while (i3 < a8.size()) {
                                                    ((AMap.OnMapLoadedListener) a8.get(i3)).onMapLoaded();
                                                    i3++;
                                                }
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        fz.c(th5, "AMapDelegateImp", "onMapLoaded");
                                        th5.printStackTrace();
                                        dl.a(th5);
                                    }
                                    if (b.this.D != null) {
                                        b.this.D.i();
                                        return;
                                    }
                                    return;
                                case 17:
                                    if (b.this.f7935f.isInMapAnimation(1) && b.this.E != null) {
                                        b.this.E.setFlingState(false);
                                        return;
                                    }
                                    return;
                                case 18:
                                    if (b.this.f7953x != null) {
                                        b.this.f7953x.b();
                                        return;
                                    }
                                    return;
                                case 19:
                                    List<AMap.OnMapClickListener> a9 = b.this.f7951v.a(AMap.OnMapClickListener.class.hashCode());
                                    if (a9 != null) {
                                        DPoint obtain = DPoint.obtain();
                                        b.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                        try {
                                            synchronized (a9) {
                                                for (AMap.OnMapClickListener onMapClick : a9) {
                                                    onMapClick.onMapClick(new LatLng(obtain.f10010y, obtain.f10009x));
                                                }
                                            }
                                            obtain.recycle();
                                            return;
                                        } catch (Throwable th6) {
                                            fz.c(th6, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                            th6.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                case 20:
                                    try {
                                        List a10 = b.this.f7951v.a(AMap.OnPOIClickListener.class.hashCode());
                                        if (a10 != null && a10.size() > 0) {
                                            synchronized (a10) {
                                                while (i3 < a10.size()) {
                                                    ((AMap.OnPOIClickListener) a10.get(i3)).onPOIClick((Poi) message.obj);
                                                    i3++;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th7) {
                                        fz.c(th7, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                                        th7.printStackTrace();
                                        return;
                                    }
                                default:
                                    return;
                            }
                            fz.c(th, "AMapDelegateImp", "handleMessage");
                            th.printStackTrace();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(ew.f8612b);
                        }
                        sb.append("]");
                        Log.w("amapsdk", sb.toString());
                    } catch (Throwable th8) {
                        fz.c(th8, "AMapDelegateImp", "handleMessage");
                        th8.printStackTrace();
                    }
                }
            }
        };
        this.aJ = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setTrafficEnabled(this.f8029c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aK = new a() {
            public final void run() {
                super.run();
                try {
                    b bVar = b.this;
                    bVar.setCenterToPixel(bVar.aC, b.this.aD);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aL = new a() {
            public final void run() {
                super.run();
                b.this.a(this.f8033g, this.f8030d, this.f8031e, this.f8032f);
            }
        };
        this.aM = new a() {
            public final void run() {
                super.run();
                b.this.setMapCustomEnable(this.f8029c);
            }
        };
        this.aN = new a() {
            public final void run() {
                super.run();
                b.this.a(this.f8033g, this.f8029c);
            }
        };
        this.aO = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setMapTextEnable(this.f8029c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aP = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setRoadArrowEnable(this.f8029c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aQ = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setNaviLabelEnable(this.f8029c, this.f8034h, this.f8035i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aR = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setConstructingRoadEnable(this.f8029c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aS = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setTrafficStyleWithTextureData(this.f8036j);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aT = new a() {
            public final void run() {
                super.run();
                b.this.b(this.f8033g, this.f8029c);
            }
        };
        this.aU = new a() {
            public final void run() {
                super.run();
                try {
                    b.this.setIndoorEnabled(this.f8029c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aV = new Runnable() {
            public final void run() {
                dz f2;
                if (b.this.D != null && (f2 = b.this.D.f()) != null) {
                    f2.c();
                }
            }
        };
        this.aW = new a() {
            public final void run() {
                super.run();
                b.this.c(this.f8033g, this.f8029c);
            }
        };
        this.aY = "";
        this.aZ = "";
        this.f7925ba = false;
        this.f7926bb = false;
        this.f7927bc = 0;
        this.f7928bd = new EAMapPlatformGestureInfo();
        this.f7940k = new Point();
        this.f7941l = new Rect();
        this.f7929be = 0;
        this.f7942m = null;
        this.f7930bf = null;
        this.f7943n = new float[16];
        this.f7944o = new float[16];
        this.f7945p = new float[16];
        this.f7931bg = null;
        this.f7946q = new float[12];
        this.f7947r = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f7948s = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f7949t = -1;
        this.f7934e = context;
        dn.a(context);
        dn.a(dm.f8269c, "init map delegate");
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.aX = bVar;
        bVar.a();
        this.aX.b();
        fz.a(this.f7934e);
        cz.a().a(this.f7934e);
        l.f9555b = ev.c(context);
        cq.a(this.f7934e);
        this.f7912ao = new n(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f7911an = gLMapRender;
        this.C = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        o oVar = new o(this, this.f7934e);
        this.E = oVar;
        this.f7935f = new GLMapEngine(this.f7934e, this);
        this.D = new dv(this.f7934e, this, oVar);
        this.A = new u(this);
        this.D.a((dt.a) new c(this, (byte) 0));
        this.aE = new C0073b();
        iGLSurfaceView.setRenderMode(0);
        this.f7911an.setRenderFps(15.0f);
        this.f7935f.setMapListener(this);
        this.f7955z = new r(this);
        this.f7950u = new f(this);
        aj ajVar = new aj(this.f7934e);
        this.f7953x = ajVar;
        ajVar.a((IInfoWindowAction) this.D);
        this.f7953x.b((IInfoWindowAction) new cb(oVar, context));
        this.f7898aa = new j(this.f7934e, this);
        this.M = new ak(this.f7934e);
        this.f7908ak = new cg(this.f7934e, this);
        ci ciVar = new ci(this.f7934e);
        this.f7909al = ciVar;
        ciVar.a((ci.a) this);
        a(z2);
        MapConfig mapConfig = this.f7924b;
        a aVar = new a(this, this.f7934e, mapConfig != null ? mapConfig.isAbroadEnable() : z3);
        this.aH = aVar;
        aVar.a((a.C0072a) this);
    }

    private int a(int i2, Rect rect, int i3, int i4) {
        GLMapEngine gLMapEngine = this.f7935f;
        int i5 = 0;
        if (gLMapEngine == null || i2 < 0) {
            return 0;
        }
        int engineIDWithType = gLMapEngine.getEngineIDWithType(i2);
        if (!this.f7935f.isEngineCreated(engineIDWithType)) {
            if (Build.VERSION.SDK_INT >= 4) {
                i5 = this.f7934e.getResources().getDisplayMetrics().densityDpi;
            }
            float f2 = this.f7934e.getResources().getDisplayMetrics().density;
            this.f7915ar = GLMapState.calMapZoomScalefactor(i3, i4, i5);
            NativeTextGenerate.getInstance().setDensity(f2);
            GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
            mapViewInitParam.engineId = engineIDWithType;
            mapViewInitParam.f10013x = rect.left;
            mapViewInitParam.f10014y = rect.top;
            mapViewInitParam.width = rect.width();
            mapViewInitParam.height = rect.height();
            mapViewInitParam.screenWidth = i3;
            mapViewInitParam.screenHeight = i4;
            mapViewInitParam.screenScale = f2;
            mapViewInitParam.textScale = this.f7916as * f2;
            mapViewInitParam.mapZoomScale = this.f7915ar;
            mapViewInitParam.taskThreadCount = 3;
            this.f7935f.createAMapEngineWithFrame(mapViewInitParam);
            GLMapState mapState = this.f7935f.getMapState(engineIDWithType);
            mapState.setMapZoomer(this.f7924b.getSZ());
            mapState.setCameraDegree(this.f7924b.getSC());
            mapState.setMapAngle(this.f7924b.getSR());
            mapState.setMapGeoCenter(this.f7924b.getSX(), this.f7924b.getSY());
            this.f7935f.setMapState(engineIDWithType, mapState);
            this.f7935f.setOvelayBundle(engineIDWithType, new GLOverlayBundle(engineIDWithType, this));
        } else {
            a(engineIDWithType, rect.left, rect.top, rect.width(), rect.height(), i3, i4);
        }
        return engineIDWithType;
    }

    private void a(final int i2) {
        queueEvent(new Runnable() {
            public final void run() {
                if (b.this.f7920aw && b.this.f7935f != null) {
                    b.this.f7935f.setHighlightSubwayEnable(i2, false);
                }
            }
        });
    }

    private void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i2, i3, i4, i5, i6, i7, i8);
        }
    }

    private synchronized void a(int i2, int i3, int i4, int i5, boolean z2, boolean z3, StyleItem[] styleItemArr) {
        int i6 = i4;
        synchronized (this) {
            if (!this.f7921ax || !this.f7920aw || !this.f7897a) {
                this.aL.f8033g = i2;
                this.aL.f8030d = i3;
                this.aL.f8031e = i6;
                this.aL.f8032f = i5;
                this.aL.f8028b = true;
                return;
            }
            d(i4);
            final int i7 = i2;
            final int i8 = i3;
            final int i9 = i4;
            final int i10 = i5;
            final boolean z4 = z2;
            final boolean z5 = z3;
            final StyleItem[] styleItemArr2 = styleItemArr;
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        b.this.f7935f.setMapModeAndStyle(i7, i8, i9, i10, z4, z5, styleItemArr2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void a(int i2, int i3, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7920aw && (gLMapEngine = this.f7935f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.p20ToScreenPoint(i2, i3, fPoint);
        }
    }

    private void a(MotionEvent motionEvent) throws RemoteException {
        if (this.N && this.Q != null) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) (motionEvent.getY() - 60.0f);
            if (this.Q.getPosition() != null) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng(x2, y2, obtain);
                LatLng latLng = new LatLng(obtain.f10010y, obtain.f10009x);
                obtain.recycle();
                this.Q.setPosition(latLng);
                try {
                    List a2 = this.f7951v.a(AMap.OnMarkerDragListener.class.hashCode());
                    if (a2 != null && a2.size() > 0) {
                        synchronized (a2) {
                            for (int i2 = 0; i2 < a2.size(); i2++) {
                                ((AMap.OnMarkerDragListener) a2.get(i2)).onMarkerDrag(this.Q);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.isUseAnchor = this.J;
        if (this.J) {
            abstractCameraUpdateMessage.anchorX = this.f7924b.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f7924b.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f7924b;
    }

    private void a(GLMapState gLMapState, int i2, int i3, DPoint dPoint) {
        if (this.f7920aw && this.f7935f != null) {
            Point point = new Point();
            gLMapState.screenToP20Point(i2, i3, point);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) point.x, (long) point.y, 20);
            dPoint.f10009x = pixelsToLatLong.f10009x;
            dPoint.f10010y = pixelsToLatLong.f10010y;
            pixelsToLatLong.recycle();
        }
    }

    private void a(boolean z2) {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            Object j2 = bVar.j();
            if (j2 != null && (j2 instanceof Boolean)) {
                MapConfig mapConfig = this.f7924b;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z2 && ((Boolean) j2).booleanValue());
                }
                if (z2 && ((Boolean) j2).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object j3 = this.aX.j();
            if (j3 != null && (j3 instanceof Boolean)) {
                this.D.a(((Boolean) j3).booleanValue());
            }
            Object j4 = this.aX.j();
            if (j3 != null && (j3 instanceof Integer)) {
                this.f7903af = ((Integer) j4).intValue();
            }
        }
    }

    private void a(boolean z2, byte[] bArr, boolean z3) {
        co coVar;
        try {
            this.f7924b.setCustomStyleEnable(z2);
            boolean z4 = false;
            if (this.f7924b.isHideLogoEnable()) {
                this.A.setLogoEnable(!z2);
            }
            if (z2) {
                c(1, true);
                cn cnVar = new cn();
                MyTrafficStyle myTrafficStyle = this.Z;
                if (!(myTrafficStyle == null || myTrafficStyle.getTrafficRoadBackgroundColor() == -1)) {
                    cnVar.a(this.Z.getTrafficRoadBackgroundColor());
                }
                if (this.f7924b.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f7924b.getCustomTextureResourcePath())) {
                    z4 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    coVar = cnVar.a(bArr, z4);
                    if (!(coVar == null || (styleItemArr = coVar.c()) == null)) {
                        this.f7924b.setUseProFunction(true);
                    }
                } else {
                    coVar = null;
                }
                if (styleItemArr == null && (coVar = cnVar.a(this.f7924b.getCustomStylePath(), z4)) != null) {
                    styleItemArr = coVar.c();
                }
                if (cnVar.a() != 0) {
                    this.f7924b.setCustomBackgroundColor(cnVar.a());
                }
                if (coVar == null || coVar.d() == null) {
                    a(styleItemArr, z3);
                } else if (this.f7909al != null) {
                    this.f7909al.a((String) coVar.d());
                    this.f7909al.a(coVar);
                    this.f7909al.b();
                }
            } else {
                c(1, false);
                a(1, this.f7924b.getMapStyleMode(), this.f7924b.getMapStyleTime(), this.f7924b.getMapStyleState(), true, false, (StyleItem[]) null);
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    private void a(StyleItem[] styleItemArr, boolean z2) {
        if (z2 || (styleItemArr != null && styleItemArr.length > 0)) {
            a(1, 0, 0, 0, true, true, styleItemArr);
            di.a(this.f7934e, true);
            return;
        }
        di.a(this.f7934e, false);
    }

    private boolean a(int i2, int i3) {
        AbstractCameraUpdateMessage abstractCameraUpdateMessage;
        if (!this.f7920aw || ((float) ((int) c())) >= this.f7924b.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (this.J || this.A.isZoomInByScreenCenter()) {
                abstractCameraUpdateMessage = z.a(1.0f, (Point) null);
            } else {
                this.f7940k.x = i2;
                this.f7940k.y = i3;
                abstractCameraUpdateMessage = z.a(1.0f, this.f7940k);
            }
            animateCamera(abstractCameraUpdateMessage);
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    private static boolean a(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private boolean a(boolean z2, boolean z3) {
        String str;
        if (z2) {
            if (this.f7926bb) {
                str = "setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效";
                cr.a(str);
                return true;
            }
            this.f7925ba = true;
        }
        if (!z3) {
            return false;
        }
        if (this.f7925ba) {
            str = "setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效";
            cr.a(str);
            return true;
        }
        this.f7926bb = true;
        return false;
    }

    /* access modifiers changed from: private */
    public Poi b(int i2, int i3) {
        if (!this.f7920aw) {
            return null;
        }
        try {
            ArrayList<MapLabelItem> c2 = c(i2, i3);
            MapLabelItem mapLabelItem = (c2 == null || c2.size() <= 0) ? null : c2.get(0);
            if (mapLabelItem != null) {
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) mapLabelItem.pixel20X, (long) mapLabelItem.pixel20Y, 20);
                Poi poi = new Poi(mapLabelItem.name, new LatLng(pixelsToLatLong.f10010y, pixelsToLatLong.f10009x, false), mapLabelItem.poiid);
                pixelsToLatLong.recycle();
                return poi;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void b(int i2) {
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        e(i2);
    }

    private void b(final MotionEvent motionEvent) {
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    Message obtain = Message.obtain();
                    Poi poi = null;
                    if (b.this.f7924b != null && b.this.f7924b.isTouchPoiEnable()) {
                        poi = b.this.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    }
                    List a2 = b.this.f7951v.a(AMap.OnPOIClickListener.class.hashCode());
                    if (a2 == null || a2.size() <= 0 || poi == null) {
                        b.this.c(motionEvent);
                        return;
                    }
                    obtain.what = 20;
                    obtain.obj = poi;
                    b.this.f7939j.sendMessage(obtain);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(CameraPosition cameraPosition) {
        if (this.f7924b.getMapLanguage().equals(AMap.ENGLISH)) {
            boolean c2 = c(cameraPosition);
            if (c2 != this.W) {
                this.W = c2;
                b(1, c2);
            }
        } else if (!this.W) {
            this.W = true;
            b(1, true);
        }
    }

    private float c() {
        if (this.f7924b != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private ArrayList<MapLabelItem> c(int i2, int i3) {
        if (!this.f7920aw) {
            return null;
        }
        ArrayList<MapLabelItem> arrayList = new ArrayList<>();
        byte[] labelBuffer = this.f7935f.getLabelBuffer(1, i2, i3, 25);
        if (labelBuffer == null) {
            return null;
        }
        int i4 = GLConvertUtil.getInt(labelBuffer, 0) > 0 ? 1 : 0;
        int i5 = 0;
        int i6 = 4;
        while (i5 < i4) {
            MapLabelItem mapLabelItem = new MapLabelItem();
            int i7 = GLConvertUtil.getInt(labelBuffer, i6);
            int i8 = i6 + 4;
            int i9 = GLConvertUtil.getInt(labelBuffer, i8);
            int i10 = i8 + 4;
            mapLabelItem.f10017x = i7;
            mapLabelItem.f10018y = this.C.getHeight() - i9;
            mapLabelItem.pixel20X = GLConvertUtil.getInt(labelBuffer, i10);
            int i11 = i10 + 4;
            mapLabelItem.pixel20Y = GLConvertUtil.getInt(labelBuffer, i11);
            int i12 = i11 + 4;
            mapLabelItem.pixel20Z = GLConvertUtil.getInt(labelBuffer, i12);
            int i13 = i12 + 4;
            mapLabelItem.type = GLConvertUtil.getInt(labelBuffer, i13);
            int i14 = i13 + 4;
            mapLabelItem.mSublayerId = GLConvertUtil.getInt(labelBuffer, i14);
            int i15 = i14 + 4;
            mapLabelItem.timeStamp = GLConvertUtil.getInt(labelBuffer, i15);
            int i16 = i15 + 4;
            mapLabelItem.mIsFouces = labelBuffer[i16] != 0;
            int i17 = i16 + 1;
            if (labelBuffer[i17] == 0) {
                mapLabelItem.poiid = null;
            } else {
                String str = "";
                for (int i18 = 0; i18 < 20; i18++) {
                    int i19 = i18 + i17;
                    if (labelBuffer[i19] == 0) {
                        break;
                    }
                    str = str + ((char) labelBuffer[i19]);
                }
                mapLabelItem.poiid = str;
            }
            int i20 = i17 + 20;
            int i21 = i20 + 1;
            byte b2 = labelBuffer[i20];
            StringBuffer stringBuffer = new StringBuffer();
            for (int i22 = 0; i22 < b2; i22++) {
                stringBuffer.append((char) GLConvertUtil.getShort(labelBuffer, i21));
                i21 += 2;
            }
            mapLabelItem.name = stringBuffer.toString();
            arrayList.add(mapLabelItem);
            i5++;
            i6 = i21;
        }
        return arrayList;
    }

    private void c(int i2) {
        e(i2);
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    /* access modifiers changed from: private */
    public void c(final MotionEvent motionEvent) {
        this.f7939j.post(new Runnable() {
            public final void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) motionEvent.getX();
                obtain.arg2 = (int) motionEvent.getY();
                b.this.f7939j.sendMessage(obtain);
            }
        });
    }

    private boolean c(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.f7924b;
        if (mapConfig == null) {
            return false;
        }
        try {
            return !de.a(mapConfig.getGeoRectangle().getClipRect());
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
            return false;
        }
    }

    private void d() {
        if (this.f7920aw) {
            this.f7912ao.a();
            this.f7913ap = true;
            this.f7918au = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    private void d(int i2) {
        dw dwVar = this.D;
        if (dwVar == null) {
            return;
        }
        if (i2 == 0) {
            if (dwVar.b()) {
                this.D.g(Boolean.FALSE);
                this.D.c();
            }
        } else if (!dwVar.b()) {
            this.D.g(Boolean.TRUE);
            this.D.c();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> a2 = this.f7951v.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a2 != null && a2.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f10010y, obtain.f10009x);
                obtain.recycle();
                Polyline hitOverlay = this.E.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a2) {
                        for (AMap.OnPolylineClickListener onPolylineClick : a2) {
                            onPolylineClick.onPolylineClick(hitOverlay);
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void e() {
        this.f7913ap = true;
        this.f7918au = false;
        if (this.S) {
            this.S = false;
        }
        if (this.R) {
            this.R = false;
        }
        if (this.T) {
            this.T = false;
        }
        try {
            if (this.N) {
                List a2 = this.f7951v.a(AMap.OnMarkerDragListener.class.hashCode());
                if (!(a2 == null || a2.size() <= 0 || (this.O == null && this.Q == null))) {
                    synchronized (a2) {
                        for (int i2 = 0; i2 < a2.size(); i2++) {
                            ((AMap.OnMarkerDragListener) a2.get(i2)).onMarkerDragEnd(this.Q);
                        }
                    }
                    this.O = null;
                    this.Q = null;
                }
                this.N = false;
            }
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
    }

    private void e(final int i2) {
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    b.this.f7935f.clearAllMessages(i2);
                    b.this.f7935f.clearAnimations(i2, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private boolean e(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f10010y, obtain.f10009x);
        obtain.recycle();
        boolean z2 = true;
        BaseOverlay hitBaseOverlay = this.E.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.E.set2Top(marker.getId());
                List<AMap.OnMarkerClickListener> a2 = this.f7951v.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    synchronized (a2) {
                        if (a2.size() == 1) {
                            boolean onMarkerClick = ((AMap.OnMarkerClickListener) a2.get(0)).onMarkerClick(marker);
                            if (onMarkerClick) {
                                return true;
                            }
                            z2 = onMarkerClick;
                        } else {
                            boolean z3 = false;
                            for (AMap.OnMarkerClickListener onMarkerClick2 : a2) {
                                z3 |= onMarkerClick2.onMarkerClick(marker);
                            }
                            if (z3) {
                                return true;
                            }
                            z2 = z3;
                        }
                    }
                }
                this.E.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(z.a((Point) obtain2));
                }
                return z2;
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    private void f() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null && (gLMapState = (GLMapState) gLMapEngine.getNewMapState(1)) != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.recalculate();
            gLMapState.getMapGeoCenter(obtain);
            this.f7924b.setSX((double) obtain.x);
            this.f7924b.setSY((double) obtain.y);
            this.f7924b.setSZ(gLMapState.getMapZoomer());
            this.f7924b.setSC(gLMapState.getCameraDegree());
            this.f7924b.setSR(gLMapState.getMapAngle());
            gLMapState.recycle();
            obtain.recycle();
        }
    }

    private boolean f(int i2) {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i2, 7);
        }
        return false;
    }

    private boolean f(MotionEvent motionEvent) {
        if (!(this.E == null || this.aG == null)) {
            DPoint obtain = DPoint.obtain();
            if (this.f7935f != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.E.getMultiPointItem(new LatLng(obtain.f10010y, obtain.f10009x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.aG.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private LatLng g() {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig == null) {
            return null;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f7924b.getSY(), 20);
        LatLng latLng = new LatLng(pixelsToLatLong.f10010y, pixelsToLatLong.f10009x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[Catch:{ all -> 0x0078 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(int r13) {
        /*
            r12 = this;
            r12.Y = r13
            r0 = 2
            r1 = 4
            r2 = 1
            r3 = 0
            if (r13 != r2) goto L_0x000c
        L_0x0008:
            r6 = 0
        L_0x0009:
            r7 = 0
            r8 = 0
            goto L_0x0024
        L_0x000c:
            if (r13 != r0) goto L_0x0010
            r6 = 1
            goto L_0x0009
        L_0x0010:
            r4 = 3
            if (r13 != r4) goto L_0x0017
            r6 = 0
            r7 = 1
        L_0x0015:
            r8 = 4
            goto L_0x0024
        L_0x0017:
            if (r13 != r1) goto L_0x001c
            r6 = 0
            r7 = 0
            goto L_0x0015
        L_0x001c:
            r1 = 5
            if (r13 != r1) goto L_0x0021
            r6 = 2
            goto L_0x0009
        L_0x0021:
            r12.Y = r2     // Catch:{ all -> 0x0078 }
            goto L_0x0008
        L_0x0024:
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            r13.setMapStyleMode(r6)     // Catch:{ all -> 0x0078 }
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            r13.setMapStyleTime(r7)     // Catch:{ all -> 0x0078 }
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            r13.setMapStyleState(r8)     // Catch:{ all -> 0x0078 }
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            boolean r13 = r13.isCustomStyleEnable()     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x005e
            com.amap.api.mapcore.util.a r13 = r12.aH     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x004b
            boolean r13 = r13.d()     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x004b
            com.amap.api.mapcore.util.a r13 = r12.aH     // Catch:{ all -> 0x0078 }
            r13.e()     // Catch:{ all -> 0x0078 }
            goto L_0x0058
        L_0x004b:
            r5 = 1
            r9 = 1
            r10 = 0
            r11 = 0
            r4 = r12
            r4.a((int) r5, (int) r6, (int) r7, (int) r8, (boolean) r9, (boolean) r10, (com.autonavi.base.ae.gmap.style.StyleItem[]) r11)     // Catch:{ all -> 0x0078 }
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            r13.setCustomStyleEnable(r3)     // Catch:{ all -> 0x0078 }
        L_0x0058:
            com.amap.api.mapcore.util.u r13 = r12.A     // Catch:{ all -> 0x0078 }
            r13.setLogoEnable(r2)     // Catch:{ all -> 0x0078 }
            goto L_0x0074
        L_0x005e:
            com.autonavi.base.amap.mapcore.MapConfig r13 = r12.f7924b     // Catch:{ all -> 0x0078 }
            java.lang.String r13 = r13.getMapLanguage()     // Catch:{ all -> 0x0078 }
            java.lang.String r0 = "en"
            boolean r13 = r13.equals(r0)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0071
            java.lang.String r13 = "zh_cn"
            r12.setMapLanguage(r13)     // Catch:{ all -> 0x0078 }
        L_0x0071:
            r12.a((int) r2, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x0078 }
        L_0x0074:
            r12.resetRenderTime()     // Catch:{ all -> 0x0078 }
            return
        L_0x0078:
            r13 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.mapcore.util.fz.c(r13, r0, r1)
            r13.printStackTrace()
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b.g(int):void");
    }

    private boolean g(MotionEvent motionEvent) throws RemoteException {
        try {
            List a2 = this.f7951v.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay a3 = this.f7953x.a(motionEvent);
            if (a3 != null && (a3 instanceof Marker)) {
                synchronized (a2) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ((AMap.OnInfoWindowClickListener) a2.get(i2)).onInfoWindowClick((Marker) a3);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private synchronized void h() {
        synchronized (this.f7907aj) {
            int size = this.f7907aj.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f7907aj.get(i2).a().recycle();
            }
            this.f7907aj.clear();
        }
    }

    private void i() {
        float f2;
        GLMapRender gLMapRender;
        int i2 = this.f7906ai;
        if (i2 != -1) {
            this.f7911an.setRenderFps((float) i2);
            resetRenderTime();
        } else {
            if (this.f7935f.isInMapAction(1) || this.f7918au) {
                gLMapRender = this.f7911an;
                f2 = 40.0f;
            } else if (this.f7935f.isInMapAnimation(1)) {
                this.f7911an.setRenderFps(30.0f);
                this.f7911an.resetTickCount(15);
            } else {
                gLMapRender = this.f7911an;
                f2 = 15.0f;
            }
            gLMapRender.setRenderFps(f2);
        }
        if (this.f7924b.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            b();
            this.f7924b.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void j() {
        if (this.V) {
            boolean canStopMapRender = this.f7935f.canStopMapRender(1);
            Message obtainMessage = this.f7939j.obtainMessage(15, this.f7935f.getScreenShot(this.G, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
            this.V = false;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void k() {
        /*
            r11 = this;
            com.autonavi.base.amap.mapcore.MapConfig r0 = r11.f7924b
            com.autonavi.base.amap.mapcore.FPoint[] r0 = r0.getMapRect()
            r1 = 0
            if (r0 == 0) goto L_0x000d
            boolean r0 = r11.f7902ae
            if (r0 == 0) goto L_0x0012
        L_0x000d:
            r11.l()
            r11.f7902ae = r1
        L_0x0012:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r11.f7935f
            com.autonavi.base.amap.mapcore.MapConfig r2 = r11.f7924b
            int[] r2 = r2.getCurTileIds()
            r3 = 1
            r0.getCurTileIDs(r3, r2)
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r11.f7935f
            com.autonavi.base.ae.gmap.GLMapState r0 = r0.getMapState(r3)
            if (r0 == 0) goto L_0x01af
            com.autonavi.base.amap.mapcore.MapConfig r2 = r11.f7924b
            float[] r2 = r2.getViewMatrix()
            r0.getViewMatrix(r2)
            com.autonavi.base.amap.mapcore.MapConfig r2 = r11.f7924b
            float[] r2 = r2.getProjectionMatrix()
            r0.getProjectionMatrix(r2)
            com.autonavi.base.amap.mapcore.MapConfig r2 = r11.f7924b
            r2.updateFinalMatrix()
            com.autonavi.amap.mapcore.DPoint r2 = r0.getMapGeoCenter()
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            double r5 = r2.f10009x
            r4.setSX(r5)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            double r5 = r2.f10010y
            r4.setSY(r5)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            float r5 = r0.getMapZoomer()
            r4.setSZ(r5)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            float r5 = r0.getCameraDegree()
            r4.setSC(r5)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            float r5 = r0.getMapAngle()
            r4.setSR(r5)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            boolean r4 = r4.isMapStateChange()
            if (r4 == 0) goto L_0x0198
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            float r0 = r0.getSkyHeight()
            r4.setSkyHeight(r0)
            double r4 = r2.f10009x
            double r6 = r2.f10010y
            r0 = 20
            com.autonavi.amap.mapcore.DPoint r0 = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong((double) r4, (double) r6, (int) r0)
            com.amap.api.maps.model.CameraPosition r2 = new com.amap.api.maps.model.CameraPosition
            com.amap.api.maps.model.LatLng r10 = new com.amap.api.maps.model.LatLng
            double r5 = r0.f10010y
            double r7 = r0.f10009x
            r9 = 0
            r4 = r10
            r4.<init>(r5, r7, r9)
            com.autonavi.base.amap.mapcore.MapConfig r4 = r11.f7924b
            float r4 = r4.getSZ()
            com.autonavi.base.amap.mapcore.MapConfig r5 = r11.f7924b
            float r5 = r5.getSC()
            com.autonavi.base.amap.mapcore.MapConfig r6 = r11.f7924b
            float r6 = r6.getSR()
            r2.<init>(r10, r4, r5, r6)
            r0.recycle()
            android.os.Handler r0 = r11.f7939j
            android.os.Message r0 = r0.obtainMessage()
            r4 = 10
            r0.what = r4
            r0.obj = r2
            android.os.Handler r2 = r11.f7939j
            r2.sendMessage(r0)
            r11.f7919av = r3
            r11.redrawInfoWindow()
            r11.l()
            com.amap.api.mapcore.util.u r0 = r11.A     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isZoomControlsEnabled()     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x0106
            com.autonavi.base.amap.mapcore.MapConfig r0 = r11.f7924b     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isNeedUpdateZoomControllerState()     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x0106
            com.amap.api.mapcore.util.g r0 = r11.f7951v     // Catch:{ all -> 0x0193 }
            java.lang.Class<com.autonavi.base.ae.gmap.listener.AMapWidgetListener> r2 = com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class
            int r2 = r2.hashCode()     // Catch:{ all -> 0x0193 }
            java.util.List r0 = r0.a((int) r2)     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x0106
            int r2 = r0.size()     // Catch:{ all -> 0x0193 }
            if (r2 <= 0) goto L_0x0106
            monitor-enter(r0)     // Catch:{ all -> 0x0193 }
            r2 = 0
        L_0x00e9:
            int r4 = r0.size()     // Catch:{ all -> 0x0103 }
            if (r2 >= r4) goto L_0x0101
            java.lang.Object r4 = r0.get(r2)     // Catch:{ all -> 0x0103 }
            com.autonavi.base.ae.gmap.listener.AMapWidgetListener r4 = (com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r4     // Catch:{ all -> 0x0103 }
            com.autonavi.base.amap.mapcore.MapConfig r5 = r11.f7924b     // Catch:{ all -> 0x0103 }
            float r5 = r5.getSZ()     // Catch:{ all -> 0x0103 }
            r4.invalidateZoomController(r5)     // Catch:{ all -> 0x0103 }
            int r2 = r2 + 1
            goto L_0x00e9
        L_0x0101:
            monitor-exit(r0)     // Catch:{ all -> 0x0103 }
            goto L_0x0106
        L_0x0103:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0103 }
            throw r1     // Catch:{ all -> 0x0193 }
        L_0x0106:
            com.autonavi.base.amap.mapcore.MapConfig r0 = r11.f7924b     // Catch:{ all -> 0x0193 }
            double r4 = r0.getChangeGridRatio()     // Catch:{ all -> 0x0193 }
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0115
            r11.b()     // Catch:{ all -> 0x0193 }
        L_0x0115:
            com.amap.api.mapcore.util.u r0 = r11.A     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isCompassEnabled()     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x012e
            com.autonavi.base.amap.mapcore.MapConfig r0 = r11.f7924b     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isTiltChanged()     // Catch:{ all -> 0x0193 }
            if (r0 != 0) goto L_0x012f
            com.autonavi.base.amap.mapcore.MapConfig r0 = r11.f7924b     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isBearingChanged()     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r3 = 0
        L_0x012f:
            if (r3 == 0) goto L_0x015e
            com.amap.api.mapcore.util.g r0 = r11.f7951v     // Catch:{ all -> 0x0193 }
            java.lang.Class<com.autonavi.base.ae.gmap.listener.AMapWidgetListener> r2 = com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class
            int r2 = r2.hashCode()     // Catch:{ all -> 0x0193 }
            java.util.List r0 = r0.a((int) r2)     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x015e
            int r2 = r0.size()     // Catch:{ all -> 0x0193 }
            if (r2 <= 0) goto L_0x015e
            monitor-enter(r0)     // Catch:{ all -> 0x0193 }
            r2 = 0
        L_0x0147:
            int r3 = r0.size()     // Catch:{ all -> 0x015b }
            if (r2 >= r3) goto L_0x0159
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x015b }
            com.autonavi.base.ae.gmap.listener.AMapWidgetListener r3 = (com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r3     // Catch:{ all -> 0x015b }
            r3.invalidateCompassView()     // Catch:{ all -> 0x015b }
            int r2 = r2 + 1
            goto L_0x0147
        L_0x0159:
            monitor-exit(r0)     // Catch:{ all -> 0x015b }
            goto L_0x015e
        L_0x015b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x015b }
            throw r1     // Catch:{ all -> 0x0193 }
        L_0x015e:
            com.amap.api.mapcore.util.u r0 = r11.A     // Catch:{ all -> 0x0193 }
            boolean r0 = r0.isScaleControlsEnabled()     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x0192
            com.amap.api.mapcore.util.g r0 = r11.f7951v     // Catch:{ all -> 0x0193 }
            java.lang.Class<com.autonavi.base.ae.gmap.listener.AMapWidgetListener> r2 = com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class
            int r2 = r2.hashCode()     // Catch:{ all -> 0x0193 }
            java.util.List r0 = r0.a((int) r2)     // Catch:{ all -> 0x0193 }
            if (r0 == 0) goto L_0x0192
            int r2 = r0.size()     // Catch:{ all -> 0x0193 }
            if (r2 <= 0) goto L_0x0192
            monitor-enter(r0)     // Catch:{ all -> 0x0193 }
        L_0x017b:
            int r2 = r0.size()     // Catch:{ all -> 0x018f }
            if (r1 >= r2) goto L_0x018d
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x018f }
            com.autonavi.base.ae.gmap.listener.AMapWidgetListener r2 = (com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r2     // Catch:{ all -> 0x018f }
            r2.invalidateScaleView()     // Catch:{ all -> 0x018f }
            int r1 = r1 + 1
            goto L_0x017b
        L_0x018d:
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return
        L_0x018f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            throw r1     // Catch:{ all -> 0x0193 }
        L_0x0192:
            return
        L_0x0193:
            r0 = move-exception
            r0.printStackTrace()
            return
        L_0x0198:
            boolean r0 = r11.f7918au
            if (r0 != 0) goto L_0x01af
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r11.f7935f
            int r0 = r0.getAnimateionsCount()
            if (r0 != 0) goto L_0x01af
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r11.f7935f
            int r0 = r0.getStateMessageCount()
            if (r0 != 0) goto L_0x01af
            r11.onChangeFinish()
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b.k():void");
    }

    private void l() {
        try {
            this.f7924b.setMapRect(dl.a((IAMapDelegate) this));
            GLMapState gLMapState = (GLMapState) this.f7935f.getNewMapState(1);
            if (gLMapState != null) {
                gLMapState.recalculate();
                gLMapState.getPixel20Bound(this.f7941l, getMapWidth(), getMapHeight());
                this.f7924b.getGeoRectangle().updateRect(this.f7941l, (int) this.f7924b.getSX(), (int) this.f7924b.getSY());
                this.f7924b.setMapPerPixelUnitLength(gLMapState.getGLUnitWithWin(1));
                gLMapState.recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m() {
        if (!this.K) {
            this.f7939j.sendEmptyMessage(16);
            this.K = true;
            b();
        }
        long j2 = this.f7929be;
        if (j2 < 2) {
            this.f7929be = j2 + 1;
            return;
        }
        final dr d2 = this.D.d();
        if (d2 != null && d2.getVisibility() != 8) {
            di.a(this.f7934e, System.currentTimeMillis() - this.aI);
            this.f7939j.post(new Runnable() {
                public final void run() {
                    if (!b.this.I) {
                        try {
                            if (b.this.f7932c != null) {
                                b bVar = b.this;
                                bVar.setIndoorBuildingInfo(bVar.f7932c);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        d2.a();
                    }
                }
            });
            this.f7935f.setStyleChangeGradualEnable(this.G, true);
        }
    }

    private void n() {
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void o() {
        GLMapRender gLMapRender;
        if (this.f7920aw && (gLMapRender = this.f7911an) != null && !gLMapRender.isRenderPause()) {
            requestRender();
        }
    }

    private void p() {
        if (!this.f7900ac) {
            try {
                this.f7898aa.setName("AuthThread");
                this.f7898aa.start();
                this.f7900ac = true;
            } catch (Throwable th) {
                th.printStackTrace();
                dl.a(th);
            }
        }
    }

    private void q() {
        if (!this.f7901ad) {
            try {
                if (this.f7899ab == null) {
                    this.f7899ab = new h(this.f7934e, this);
                }
                this.f7899ab.setName("AuthProThread");
                this.f7899ab.start();
                this.f7901ad = true;
            } catch (Throwable th) {
                th.printStackTrace();
                dl.a(th);
            }
        }
    }

    private void r() {
        try {
            LatLngBounds limitLatLngBounds = this.f7924b.getLimitLatLngBounds();
            if (this.f7935f != null && a(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(1, this.f7935f.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                this.f7924b.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f7924b.setLimitIPoints((IPoint[]) null);
    }

    private void s() {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a();
        }
    }

    private void t() {
        ce ceVar = this.aF;
        if (ceVar != null) {
            ceVar.a();
            this.aF = null;
        }
    }

    public final void a() {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.i();
        }
    }

    public final synchronized void a(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, false, false, (StyleItem[]) null);
    }

    public final void a(final int i2, final boolean z2) {
        if (!this.f7920aw || !this.f7921ax) {
            this.aN.f8029c = z2;
            this.aN.f8028b = true;
            this.aN.f8033g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    b.this.f7935f.setBuildingEnable(i2, z2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.maps.model.CameraPosition r5) {
        /*
            r4 = this;
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.f7924b
            if (r0 == 0) goto L_0x007d
            int r0 = r0.getChangedCounter()
            if (r0 != 0) goto L_0x000c
            goto L_0x007d
        L_0x000c:
            boolean r0 = r4.f7918au     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0075
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r4.f7935f     // Catch:{ all -> 0x0076 }
            int r0 = r0.getAnimateionsCount()     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0075
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r4.f7935f     // Catch:{ all -> 0x0076 }
            int r0 = r0.getStateMessageCount()     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0075
            com.amap.api.maps.model.AMapGestureListener r0 = r4.f7952w     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0027
            r0.onMapStable()     // Catch:{ all -> 0x0076 }
        L_0x0027:
            com.autonavi.base.amap.api.mapcore.IGLSurfaceView r0 = r4.C     // Catch:{ all -> 0x0076 }
            boolean r0 = r0.isEnabled()     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0030
            return
        L_0x0030:
            com.amap.api.mapcore.util.g r0 = r4.f7951v     // Catch:{ all -> 0x0070 }
            java.lang.Class<com.amap.api.maps.AMap$OnCameraChangeListener> r1 = com.amap.api.maps.AMap.OnCameraChangeListener.class
            int r1 = r1.hashCode()     // Catch:{ all -> 0x0070 }
            java.util.List r0 = r0.a((int) r1)     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0070
            int r1 = r0.size()     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0070
            if (r5 != 0) goto L_0x0056
            com.amap.api.maps.model.CameraPosition r5 = r4.getCameraPosition()     // Catch:{ all -> 0x004b }
            goto L_0x0056
        L_0x004b:
            r1 = move-exception
            java.lang.String r2 = "AMapDelegateImp"
            java.lang.String r3 = "cameraChangeFinish"
            com.amap.api.mapcore.util.fz.c(r1, r2, r3)     // Catch:{ all -> 0x0070 }
            r1.printStackTrace()     // Catch:{ all -> 0x0070 }
        L_0x0056:
            monitor-enter(r0)     // Catch:{ all -> 0x0070 }
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x006d }
        L_0x005b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x006d }
            com.amap.api.maps.AMap$OnCameraChangeListener r2 = (com.amap.api.maps.AMap.OnCameraChangeListener) r2     // Catch:{ all -> 0x006d }
            r2.onCameraChangeFinish(r5)     // Catch:{ all -> 0x006d }
            goto L_0x005b
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            goto L_0x0070
        L_0x006d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            com.autonavi.base.amap.mapcore.MapConfig r5 = r4.f7924b     // Catch:{ all -> 0x0076 }
            r5.resetChangedCounter()     // Catch:{ all -> 0x0076 }
        L_0x0075:
            return
        L_0x0076:
            r5 = move-exception
            r5.printStackTrace()
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r5)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b.a(com.amap.api.maps.model.CameraPosition):void");
    }

    public final void a(String str, co coVar) {
        setCustomTextureResourcePath(str);
        if (this.f7924b.isCustomStyleEnable() && coVar != null) {
            a(coVar.c(), false);
        }
    }

    public final void accelerateNetworkInChinese(boolean z2) {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            Boolean.valueOf(z2);
            bVar.i();
        }
    }

    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions clone = arcOptions.clone();
            String createId = this.E.createId("ARC");
            Arc arc = new Arc(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, clone) : arc;
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final BuildingOverlay addBuildingOverlay() {
        try {
            di.g(this.f7934e);
            String createId = this.E.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.E, createId);
            Field declaredField = buildingOverlay.getClass().getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            dl.a((Throwable) e2);
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions clone = circleOptions.clone();
            String createId = this.E.createId("CIRCLE");
            Circle circle = new Circle(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, clone) : circle;
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        final CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, getContext(), this);
        if (crossOverlayOptions != null) {
            crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        }
        if (this.f7935f != null) {
            queueEvent(new Runnable() {
                public final void run() {
                    b.this.f7935f.getOverlayBundle(1).addOverlay(crossVectorOverlay);
                }
            });
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.E.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.E, gL3DModelOptions, createId);
        this.E.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    public final void addGestureMapMessage(int i2, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (this.f7920aw && this.f7935f != null) {
            try {
                abstractGestureMapMessage.isUseAnchor = this.J;
                abstractGestureMapMessage.anchorX = this.f7924b.getAnchorX();
                abstractGestureMapMessage.anchorY = this.f7924b.getAnchorY();
                this.f7935f.addGestureMessage(i2, abstractGestureMapMessage, this.A.isGestureScaleByMapCenter(), this.f7924b.getAnchorX(), this.f7924b.getAnchorY());
            } catch (RemoteException unused) {
            }
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions clone = groundOverlayOptions.clone();
            String createId = this.E.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, clone) : groundOverlay;
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.E.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.E.addOverlayObject(createId, new HeatMapLayer(this.E, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions clone = markerOptions.clone();
            String createId = this.E.createId("MARKER");
            Marker marker = new Marker(this.E, clone, createId);
            this.E.addOverlayObject(createId, marker, clone);
            return marker;
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8270d;
            dn.a(str, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z2) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            final LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MarkerOptions markerOptions = arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z2 && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            b.this.moveCamera(z.a(builder.build(), 50));
                        } catch (Throwable unused) {
                        }
                    }
                }, 50);
            }
            return arrayList2;
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8270d;
            dn.a(str, "addMarkers failed " + th.getMessage(), (List<MarkerOptions>) arrayList);
            return null;
        }
    }

    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions clone = multiPointOverlayOptions.clone();
            String createId = this.E.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions clone = navigateArrowOptions.clone();
            String createId = this.E.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, clone) : navigateArrow;
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    public final void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.f7935f;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i2)) != null && gLTextureProperty != null) {
                if (gLTextureProperty.mBitmap != null) {
                    this.f7935f.addOverlayTexture(i2, gLTextureProperty);
                    overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
                }
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            di.c(this.f7934e);
            String createId = this.E.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.E.addOverlayObject(createId, new ParticleOverlay(this.E, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            dl.a(th);
            th.printStackTrace();
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions clone = polygonOptions.clone();
            String createId = this.E.createId("POLYGON");
            Polygon polygon = new Polygon(this.E, clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, clone) : polygon;
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8270d;
            dn.a(str, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.E.createId("POLYLINE");
            return (Polyline) this.E.addOverlayObject(createId, new Polyline(this.E, polylineOptions, createId), polylineOptions);
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8270d;
            dn.a(str, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.E.createId("TEXT");
            TextOptions clone = textOptions.clone();
            MarkerOptions a2 = cc.a(clone);
            Marker marker = new Marker(this.E, a2, createId);
            marker.setObject(clone.getObject());
            this.E.addOverlayObject(createId, marker, a2);
            return new Text(marker, clone);
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                di.a(this.f7934e);
            }
            String createId = this.E.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.E, tileOverlayOptions, createId);
            this.E.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public final void afterAnimation() {
        redrawInfoWindow();
    }

    public final void afterDrawFrame(int i2, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f7935f;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i2) || this.f7935f.isInMapAnimation(i2)))) {
            int i3 = this.f7906ai;
            if (i3 != -1) {
                this.f7911an.setRenderFps((float) i3);
            } else {
                this.f7911an.setRenderFps(15.0f);
            }
            if (this.f7914aq != mapZoomer) {
                this.f7914aq = mapZoomer;
            }
        }
        if (!this.f7923az) {
            this.f7923az = true;
        }
    }

    public final void afterDrawLabel(int i2, GLMapState gLMapState) {
        k();
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f7927bc = this.E.draw(1, this.f7903af, this.f7938i) ? this.f7927bc : this.f7927bc + 1;
        GLMapEngine gLMapEngine2 = this.f7935f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final void afterRendererOver(int i2, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.E.draw(2, this.f7903af, this.f7938i);
        GLMapEngine gLMapEngine2 = this.f7935f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.f7904ag;
        if (customRenderer != null) {
            customRenderer.onDrawFrame((GL10) null);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250, (AMap.CancelableCallback) null);
    }

    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
        }
    }

    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j2, cancelableCallback);
        }
    }

    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j2, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage != null && !this.H && this.f7935f != null) {
            abstractCameraUpdateMessage.mCallback = cancelableCallback;
            abstractCameraUpdateMessage.mDuration = j2;
            if (this.I || getMapHeight() == 0 || getMapWidth() == 0) {
                try {
                    moveCamera(abstractCameraUpdateMessage);
                    if (abstractCameraUpdateMessage.mCallback != null) {
                        abstractCameraUpdateMessage.mCallback.onFinish();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    dl.a(th);
                }
            } else {
                try {
                    this.f7935f.interruptAnimation();
                    resetRenderTime();
                    a(abstractCameraUpdateMessage);
                    this.f7935f.addMessage(abstractCameraUpdateMessage, true);
                } catch (Throwable th2) {
                    dl.a(th2);
                    th2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f7939j.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void b(final int i2, final boolean z2) {
        if (!this.f7920aw || !this.f7921ax) {
            this.aT.f8029c = z2;
            this.aT.f8028b = true;
            this.aT.f8033g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            public final void run() {
                if (b.this.f7935f != null) {
                    if (z2) {
                        b.this.f7935f.setAllContentEnable(i2, true);
                    } else {
                        b.this.f7935f.setAllContentEnable(i2, false);
                    }
                    b.this.f7935f.setSimple3DEnable(i2, false);
                }
            }
        });
    }

    public final void beforeDrawLabel(int i2, GLMapState gLMapState) {
        k();
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f7927bc = this.E.draw(0, this.f7903af, this.f7938i) ? this.f7927bc : this.f7927bc + 1;
        GLMapEngine gLMapEngine2 = this.f7935f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final void c(final int i2, final boolean z2) {
        if (!this.f7920aw || !this.f7921ax) {
            this.aW.f8029c = z2;
            this.aW.f8028b = true;
            this.aW.f8033g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        b.this.f7935f.setBuildingTextureEnable(i2, true);
                    } else {
                        b.this.f7935f.setBuildingTextureEnable(i2, false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i2, int i3, int i4, int i5, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i2 == i3 && i3 == i4 && i4 == i5 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.f7920aw || this.H) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.f10010y, obtain.f10009x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.f7935f.getNativeInstance());
        Pair<Float, IPoint> a2 = dl.a((IMapConfig) mapConfig, i2, i3, i4, i5, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat(((IPoint) a2.second).x, ((IPoint) a2.second).y, obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(a2.first, new LatLng(obtain2.f10010y, obtain2.f10009x));
        obtain2.recycle();
        return pair2;
    }

    public final boolean canShowIndoorSwitch() {
        ai aiVar;
        if (getZoomLevel() < 17.0f || (aiVar = this.f7932c) == null || aiVar.f7784g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        a(this.f7932c.f7784g.x, this.f7932c.f7784g.y, obtain);
        return this.X.contains((int) obtain.x, (int) obtain.y);
    }

    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(1);
        }
        return true;
    }

    public final void changeGLOverlayIndex() {
        this.E.changeOverlayIndex();
    }

    public final void changeLogoIconStyle(String str, boolean z2, int i2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.a(str, Boolean.valueOf(z2), Integer.valueOf(i2));
        }
        u uVar = this.A;
        if (uVar != null) {
            uVar.requestRefreshLogo();
        }
    }

    public final void changeMapLogo(int i2, boolean z2) {
        if (!this.H) {
            try {
                List a2 = this.f7951v.a(AMapWidgetListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    this.D.g(Boolean.valueOf(!z2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void changeSize(int i2, int i3) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            this.f7936g = i2;
            this.f7937h = i3;
            mapConfig.setMapWidth(i2);
            this.f7924b.setMapHeight(i3);
        }
    }

    public final void changeSurface(int i2, GL10 gl10, int i3, int i4) {
        MapConfig mapConfig;
        int i5;
        WindowManager windowManager;
        String str = dm.f8269c;
        dn.a(str, "changeSurface " + i3 + " " + i4);
        this.f7923az = false;
        if (!this.f7920aw) {
            createSurface(i2, gl10, (EGLConfig) null);
        }
        n nVar = this.f7912ao;
        if (!(nVar == null || this.f7934e == null || ((this.f7936g == nVar.b() && this.f7937h == this.f7912ao.c()) || (windowManager = (WindowManager) this.f7934e.getSystemService("window")) == null))) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f7912ao.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.f7936g = i3;
        this.f7937h = i4;
        this.f7902ae = true;
        this.X = new Rect(0, 0, i3, i4);
        this.G = a(i2, new Rect(0, 0, this.f7936g, this.f7937h), this.f7936g, this.f7937h);
        dn.a(dm.f8269c, "create engine with frame complete");
        if (!this.f7921ax) {
            MapConfig mapConfig2 = this.f7924b;
            if (mapConfig2 != null) {
                mapConfig2.setMapZoomScale(this.f7915ar);
                this.f7924b.setMapWidth(i3);
                this.f7924b.setMapHeight(i4);
            }
            this.f7935f.setIndoorEnable(this.G, false);
            this.f7935f.setSimple3DEnable(this.G, false);
            this.f7935f.setStyleChangeGradualEnable(this.G, false);
            this.f7935f.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
        }
        synchronized (this) {
            this.f7921ax = true;
        }
        if (!this.J) {
            this.f7924b.setAnchorX(i3 >> 1);
            mapConfig = this.f7924b;
            i5 = i4 >> 1;
        } else {
            this.f7924b.setAnchorX(Math.max(1, Math.min(this.aC, i3 - 1)));
            mapConfig = this.f7924b;
            i5 = Math.max(1, Math.min(this.aD, i4 - 1));
        }
        mapConfig.setAnchorY(i5);
        this.f7935f.setProjectionCenter(this.G, this.f7924b.getAnchorX(), this.f7924b.getAnchorY());
        this.f7897a = true;
        if (this.aT.f8028b) {
            this.aT.run();
        }
        if (this.aL.f8028b) {
            this.aL.run();
        }
        if (this.aM.f8028b) {
            this.aM.run();
        }
        if (this.aJ.f8028b) {
            this.aJ.run();
        }
        if (this.aN.f8028b) {
            this.aN.run();
        }
        if (this.aW.f8028b) {
            this.aW.run();
        }
        if (this.aO.f8028b) {
            this.aO.run();
        }
        if (this.aP.f8028b) {
            this.aP.run();
        }
        if (this.aQ.f8028b) {
            this.aQ.run();
        }
        if (this.aU.f8028b) {
            this.aU.run();
        }
        if (this.aK.f8028b) {
            this.aK.run();
        }
        if (this.aR.f8028b) {
            this.aR.run();
        }
        a aVar = this.aS;
        if (aVar != null) {
            aVar.run();
        }
        CustomRenderer customRenderer = this.f7904ag;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i3, i4);
        }
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.f7939j;
        if (handler != null) {
            handler.post(this.aV);
        }
        redrawInfoWindow();
    }

    public final void changeSurface(GL10 gl10, int i2, int i3) {
        try {
            changeSurface(1, gl10, i2, i3);
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
    }

    public final void checkMapState(IGLMapState iGLMapState) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null && !this.H) {
            LatLngBounds limitLatLngBounds = mapConfig.getLimitLatLngBounds();
            if (limitLatLngBounds != null) {
                try {
                    IPoint[] limitIPoints = this.f7924b.getLimitIPoints();
                    if (limitIPoints == null) {
                        IPoint obtain = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                        IPoint obtain2 = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                        IPoint[] iPointArr = {obtain, obtain2};
                        this.f7924b.setLimitIPoints(iPointArr);
                        limitIPoints = iPointArr;
                    }
                    float a2 = dl.a((IMapConfig) this.f7924b, limitIPoints[0].x, limitIPoints[0].y, limitIPoints[1].x, limitIPoints[1].y, getMapWidth(), getMapHeight());
                    float mapZoomer = iGLMapState.getMapZoomer();
                    if (this.f7924b.isSetLimitZoomLevel()) {
                        float maxZoomLevel = this.f7924b.getMaxZoomLevel();
                        float minZoomLevel = this.f7924b.getMinZoomLevel();
                        float max = Math.max(a2, Math.min(mapZoomer, maxZoomLevel));
                        if (a2 <= maxZoomLevel) {
                            maxZoomLevel = max;
                        }
                        a2 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                    } else if (a2 <= 0.0f || mapZoomer >= a2) {
                        a2 = mapZoomer;
                    }
                    iGLMapState.setMapZoomer(a2);
                    IPoint obtain3 = IPoint.obtain();
                    iGLMapState.getMapGeoCenter(obtain3);
                    int[] a3 = dl.a(limitIPoints[0].x, limitIPoints[0].y, limitIPoints[1].x, limitIPoints[1].y, (IMapConfig) this.f7924b, iGLMapState, obtain3.x, obtain3.y);
                    iGLMapState.setMapGeoCenter((double) a3[0], (double) a3[1]);
                    obtain3.recycle();
                } catch (Throwable th) {
                    dl.a(th);
                }
            } else if (this.f7924b.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.f7924b.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f7924b.getMaxZoomLevel())));
            }
        }
    }

    public final float checkZoomLevel(float f2) throws RemoteException {
        return dl.a((IMapConfig) this.f7924b, f2);
    }

    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "clear");
            dl.a(th);
            th.printStackTrace();
        }
    }

    public final void clear(boolean z2) throws RemoteException {
        try {
            hideInfoWindow();
            String str = null;
            String str2 = "";
            bz bzVar = this.L;
            if (bzVar != null) {
                if (z2) {
                    str = bzVar.d();
                    str2 = this.L.e();
                } else {
                    bzVar.f();
                }
            }
            this.E.clear(str, str2);
            queueEvent(new Runnable() {
                public final void run() {
                    if (b.this.f7935f != null && !b.this.H) {
                        b.this.f7935f.removeNativeAllOverlay(b.this.G);
                    }
                }
            });
            resetRenderTime();
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "clear");
            dl.a(th);
            th.printStackTrace();
        }
    }

    public final void clearTileCache() {
        this.E.clearTileCache();
    }

    public final long createGLOverlay(int i2) {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(1, i2);
        }
        return 0;
    }

    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.E;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    public final synchronized void createSurface(int i2, GL10 gl10, EGLConfig eGLConfig) {
        dr d2;
        int i3;
        dn.a(dm.f8269c, "createSurface");
        this.aI = System.currentTimeMillis();
        if (this.Y == 3) {
            d2 = this.D.d();
            i3 = dr.f8283b;
        } else {
            d2 = this.D.d();
            i3 = dr.f8282a;
        }
        d2.a(i3);
        this.f7921ax = false;
        this.f7936g = this.C.getWidth();
        this.f7937h = this.C.getHeight();
        this.f7923az = false;
        try {
            AeUtil.loadLib(this.f7934e);
            dn.a(dm.f8269c, "load lib complete");
            AeUtil.initCrashHandle(this.f7934e);
            GLMapEngine.InitParam initResource = AeUtil.initResource(this.f7934e);
            dn.a(dm.f8269c, "load res complete");
            this.f7935f.createAMapInstance(initResource);
            dn.a(dm.f8269c, "create engine complete");
            this.aF = new ce();
            dn.a(dm.f8269c, "init shader complete");
            com.autonavi.extra.b bVar = this.aX;
            if (bVar != null) {
                bVar.i();
            }
            this.f7920aw = true;
            this.f7942m = gl10.glGetString(7937);
        } catch (Throwable th) {
            dl.a(th);
            fz.c(th, "AMapDElegateImp", "createSurface");
            String str = dm.f8269c;
            dn.b(str, "createSurface failed " + th.getMessage());
            Context context = this.f7934e;
            di.b(context, "init failed:" + th.getMessage());
        }
        GLMapState mapState = this.f7935f.getMapState(1);
        if (!(mapState == null || mapState.getNativeInstance() == 0)) {
            mapState.setMapGeoCenter((double) ((int) this.f7924b.getSX()), (double) ((int) this.f7924b.getSY()));
            mapState.setMapAngle(this.f7924b.getSR());
            mapState.setMapZoomer(this.f7924b.getSZ());
            mapState.setCameraDegree(this.f7924b.getSC());
        }
        p();
        CustomRenderer customRenderer = this.f7904ag;
        if (customRenderer != null) {
            customRenderer.onSurfaceCreated(gl10, eGLConfig);
        }
        com.autonavi.extra.b bVar2 = this.aX;
        if (bVar2 != null) {
            bVar2.c();
        }
        this.E.onCreateAMapInstance();
    }

    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.f7910am = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            dl.a(th2);
        }
    }

    public final void destroy() {
        this.H = true;
        dn.a(dm.f8269c, "destroy map");
        try {
            LocationSource locationSource = this.M;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.M = null;
            this.aE = null;
            GLMapRender gLMapRender = this.f7911an;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            IGlOverlayLayer iGlOverlayLayer = this.E;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.destroy();
            }
            h();
            Thread thread = this.f7898aa;
            if (thread != null) {
                thread.interrupt();
                this.f7898aa = null;
            }
            Thread thread2 = this.f7899ab;
            if (thread2 != null) {
                thread2.interrupt();
                this.f7899ab = null;
            }
            cg cgVar = this.f7908ak;
            if (cgVar != null) {
                cgVar.a();
                this.f7908ak = null;
            }
            ci ciVar = this.f7909al;
            if (ciVar != null) {
                ciVar.a((ci.a) null);
                this.f7909al.a();
                this.f7909al = null;
            }
            cz.b();
            GLMapEngine gLMapEngine = this.f7935f;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener((IAMapListener) null);
                this.f7935f.releaseNetworkState();
                queueEvent(new Runnable() {
                    public final void run() {
                        try {
                            b bVar = b.this;
                            bVar.destroySurface(bVar.G);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dl.a(th);
                        }
                    }
                });
                int i2 = 0;
                while (this.f7935f != null) {
                    int i3 = i2 + 1;
                    if (i2 >= 50) {
                        break;
                    }
                    Thread.sleep(20);
                    i2 = i3;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.C;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    dl.a((Throwable) e2);
                }
            }
            dw dwVar = this.D;
            if (dwVar != null) {
                dwVar.g();
                this.D = null;
            }
            bz bzVar = this.L;
            if (bzVar != null) {
                bzVar.c();
                this.L = null;
            }
            this.M = null;
            this.f7950u = null;
            s();
            this.Z = null;
            dn.a();
            fz.b();
        } catch (InterruptedException e3) {
            dl.a((Throwable) e3);
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "destroy");
            dl.a(th);
            th.printStackTrace();
        }
    }

    public final void destroySurface(int i2) {
        this.aA.lock();
        try {
            if (this.f7920aw) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                t();
                GLMapEngine gLMapEngine = this.f7935f;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.G) != null) {
                        this.f7935f.getOverlayBundle(this.G).removeAll(true);
                    }
                    this.f7935f.destroyAMapEngine();
                    this.f7935f = null;
                    int i3 = this.f7927bc;
                    if (i3 > 0) {
                        di.a(this.f7934e, i3);
                    }
                    dn.a(dm.f8269c, "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.aX;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.f7920aw = false;
            this.f7921ax = false;
            this.f7923az = false;
        } catch (Throwable th) {
            dl.a(th);
        } finally {
            this.aA.unlock();
        }
    }

    public final void drawFrame(GL10 gl10) {
        if (!this.H && this.f7935f != null && EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
            MapConfig mapConfig = this.f7924b;
            if (mapConfig == null || mapConfig.isMapEnable()) {
                i();
                this.f7935f.renderAMap();
                this.f7935f.pushRendererState();
                CustomRenderer customRenderer = this.f7904ag;
                if (customRenderer != null) {
                    customRenderer.onDrawFrame(gl10);
                }
                a aVar = this.aH;
                if (aVar != null) {
                    aVar.a();
                }
                j();
                m();
                if (!this.f7922ay) {
                    this.f7922ay = true;
                }
                this.f7935f.popRendererState();
                if (dc.a()) {
                    try {
                        if (this.C instanceof e) {
                            if (this.f7933d == null) {
                                this.f7933d = new dc();
                            }
                            this.f7933d.e();
                            if (this.f7933d.f() && !this.f7933d.d()) {
                                if (this.f7933d.a(((e) this.C).getBitmap())) {
                                    if (dc.b()) {
                                        removecache();
                                    }
                                    if (dc.c()) {
                                        dc.g();
                                    }
                                    dn.b(dm.f8273g, "pure screen: found pure check");
                                }
                            }
                        }
                    } catch (Throwable th) {
                        fz.c(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
                    }
                }
            } else {
                GLES20.glClear(16640);
            }
        }
    }

    public final void geo2Latlng(int i2, int i3, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) i2, (long) i3, 20);
        dPoint.f10009x = pixelsToLatLong.f10009x;
        dPoint.f10010y = pixelsToLatLong.f10010y;
        pixelsToLatLong.recycle();
    }

    public final void geo2Map(int i2, int i3, FPoint fPoint) {
        double d2 = (double) i2;
        double sx = this.f7924b.getSX();
        Double.isNaN(d2);
        fPoint.x = (float) ((int) (d2 - sx));
        double d3 = (double) i3;
        double sy = this.f7924b.getSY();
        Double.isNaN(d3);
        fPoint.y = (float) ((int) (d3 - sy));
    }

    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.aX;
    }

    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f7955z);
    }

    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f7954y == null) {
            this.f7954y = new UiSettings(this.A);
        }
        return this.f7954y;
    }

    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    public final float getCameraAngle() {
        return getCameraDegree(this.G);
    }

    public final float getCameraDegree(int i2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.J);
    }

    public final CameraPosition getCameraPositionPrj(boolean z2) {
        LatLng latLng;
        try {
            if (this.f7924b == null) {
                return null;
            }
            if (!this.f7920aw || this.I || this.f7935f == null) {
                DPoint obtain = DPoint.obtain();
                geo2Latlng((int) this.f7924b.getSX(), (int) this.f7924b.getSY(), obtain);
                LatLng latLng2 = new LatLng(obtain.f10010y, obtain.f10009x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng2).bearing(this.f7924b.getSR()).tilt(this.f7924b.getSC()).zoom(this.f7924b.getSZ()).build();
            }
            if (z2) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.f7924b.getAnchorX(), this.f7924b.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.f10010y, obtain2.f10009x, false);
                obtain2.recycle();
            } else {
                latLng = g();
            }
            return CameraPosition.builder().target(latLng).bearing(this.f7924b.getSR()).tilt(this.f7924b.getSC()).zoom(this.f7924b.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Context getContext() {
        return this.f7934e;
    }

    public final String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.aX;
            if (bVar == null) {
                return "";
            }
            Object j2 = bVar.j();
            return j2 instanceof String ? (String) j2 : "";
        } catch (Throwable th) {
            dl.a(th);
            return "";
        }
    }

    public final a getCustomStyleManager() {
        return this.aH;
    }

    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return 1;
    }

    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f7924b;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.f7943n;
    }

    public final GLMapEngine getGLMapEngine() {
        return this.f7935f;
    }

    public final View getGLMapView() {
        IGLSurfaceView iGLSurfaceView = this.C;
        if (iGLSurfaceView instanceof View) {
            return (View) iGLSurfaceView;
        }
        return null;
    }

    public final void getGeoCenter(int i2, IPoint iPoint) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            iPoint.x = (int) mapConfig.getSX();
            iPoint.y = (int) this.f7924b.getSY();
        }
    }

    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.E;
    }

    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(1);
        }
        return 0;
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    public final aj getInfoWindowDelegate() {
        return this.f7953x;
    }

    public final void getLatLng2Map(double d2, double d3, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d2, d3, obtain);
        geo2Map(obtain.x, obtain.y, fPoint);
        obtain.recycle();
    }

    public final void getLatLng2Pixel(double d2, double d3, IPoint iPoint) {
        if (this.f7920aw && this.f7935f != null) {
            try {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
                FPoint obtain = FPoint.obtain();
                a(latLongToPixels.x, latLongToPixels.y, obtain);
                if (obtain.x == -10000.0f && obtain.y == -10000.0f) {
                    GLMapState gLMapState = (GLMapState) this.f7935f.getNewMapState(1);
                    gLMapState.setCameraDegree(0.0f);
                    gLMapState.recalculate();
                    gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                    gLMapState.recycle();
                }
                iPoint.x = (int) obtain.x;
                iPoint.y = (int) obtain.y;
                obtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.f7924b.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i2 = 0; i2 < 4; i2++) {
                    GLMapState.geo2LonLat(clipRect[i2].x, clipRect[i2].y, dPointArr[i2]);
                }
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final float getLogoMarginRate(int i2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            return dwVar.a(i2);
        }
        return 0.0f;
    }

    public final int getLogoPosition() {
        try {
            return this.A.getLogoPosition();
        } catch (RemoteException e2) {
            fz.c(e2, "AMapDelegateImp", "getLogoPosition");
            e2.printStackTrace();
            return 0;
        }
    }

    public final Handler getMainHandler() {
        return this.f7939j;
    }

    public final float getMapAngle(int i2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    public final LatLngBounds getMapBounds(LatLng latLng, float f2, float f3, float f4) {
        LatLng latLng2 = latLng;
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.H) {
            return null;
        }
        float a2 = dl.a((IMapConfig) this.f7924b, f2);
        GLMapState gLMapState = new GLMapState(1, this.f7935f.getNativeInstance());
        if (latLng2 != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
            gLMapState.setCameraDegree(f4);
            gLMapState.setMapAngle(f3);
            gLMapState.setMapGeoCenter((double) obtain.x, (double) obtain.y);
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f10010y, obtain2.f10009x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng4 = new LatLng(obtain2.f10010y, obtain2.f10009x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng4).include(latLng3).build();
    }

    public final MapConfig getMapConfig() {
        return this.f7924b;
    }

    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        di.d(this.f7934e);
        String a2 = db.a(this.f7934e, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS(2019)6378号 | GS(2020)2189号";
    }

    public final int getMapHeight() {
        return this.f7937h;
    }

    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f7951v.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), onmapprintscreenlistener);
            this.V = true;
            resetRenderTime();
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(1);
        }
        return null;
    }

    public final FPoint[] getMapRect() {
        if (this.f7924b.getMapRect() == null) {
            this.f7924b.setMapRect(dl.a((IAMapDelegate) this));
        }
        return this.f7924b.getMapRect();
    }

    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        return !dl.a(getMapWidth(), getMapHeight()) ? new ArrayList() : this.E.getMapScreenMarkers();
    }

    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        try {
            this.f7951v.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), onMapScreenShotListener);
            this.V = true;
            resetRenderTime();
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final int getMapTextZIndex() throws RemoteException {
        return this.f7903af;
    }

    public final int getMapType() throws RemoteException {
        return this.Y;
    }

    public final int getMapWidth() {
        return this.f7936g;
    }

    public final float getMapZoomScale() {
        return this.f7915ar;
    }

    public final int getMaskLayerType() {
        return this.f7905ah;
    }

    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f7924b;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            dl.a(th);
            return 20.0f;
        }
    }

    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f7924b;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            dl.a(th);
            return 3.0f;
        }
    }

    public final Location getMyLocation() throws RemoteException {
        if (this.M != null) {
            return this.f7950u.f8731a;
        }
        return null;
    }

    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        bz bzVar = this.L;
        if (bzVar != null) {
            return bzVar.a();
        }
        return null;
    }

    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(1);
        }
        return 0;
    }

    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a2 = this.f7951v.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a2 == null) {
                if (a2.size() != 0) {
                    return (AMap.OnCameraChangeListener) a2.get(0);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void getPixel2Geo(int i2, int i3, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7920aw && (gLMapEngine = this.f7935f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.screenToP20Point(i2, i3, iPoint);
        }
    }

    public final void getPixel2LatLng(int i2, int i3, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7920aw && (gLMapEngine = this.f7935f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            IPoint obtain = IPoint.obtain();
            mapState.screenToP20Point(i2, i3, obtain);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) obtain.x, (long) obtain.y, 20);
            dPoint.f10009x = pixelsToLatLong.f10009x;
            dPoint.f10010y = pixelsToLatLong.f10010y;
            obtain.recycle();
            pixelsToLatLong.recycle();
        }
    }

    public final float getPreciseLevel(int i2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f7955z;
    }

    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f7924b;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.f7945p;
    }

    public final Rect getRect() {
        return this.X;
    }

    public final int getRenderMode() {
        return this.C.getRenderMode();
    }

    public final int getSX() {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    public final int getSY() {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    public final String getSatelliteImageApprovalNumber() {
        di.e(this.f7934e);
        String a2 = db.a(this.f7934e, "approval_number", "si", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS(2021)1328号";
    }

    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "getScalePerPixel");
            dl.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getSkyHeight() {
        return this.f7924b.getSkyHeight();
    }

    public final IUiSettingsDelegate getUiSettings() {
        return this.A;
    }

    public final float getUnitLengthByZoom(int i2) {
        GLMapState gLMapState = new GLMapState(1, this.f7935f.getNativeInstance());
        gLMapState.setMapZoomer((float) i2);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    public final View getView() throws RemoteException {
        dw dwVar = this.D;
        if (dwVar != null) {
            return dwVar.j();
        }
        return null;
    }

    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f7924b;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.f7944o;
    }

    public final Point getWaterMarkerPositon() {
        dw dwVar = this.D;
        return dwVar != null ? dwVar.a() : new Point();
    }

    public final String getWorldVectorMapLanguage() {
        return this.aY;
    }

    public final String getWorldVectorMapStyle() {
        return this.aZ;
    }

    public final float getZoomLevel() {
        return c();
    }

    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng == null || latLng2 == null || !this.f7920aw || this.H) {
                return mapConfig.getSZ();
            }
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(1, this.f7935f.getNativeInstance());
            Pair<Float, IPoint> a2 = dl.a((IMapConfig) mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            return a2 != null ? ((Float) a2.first).floatValue() : gLMapState.getMapZoomer();
        } catch (Throwable th) {
            dl.a(th);
            return 0.0f;
        }
    }

    public final void hideInfoWindow() {
        aj ajVar = this.f7953x;
        if (ajVar != null) {
            ajVar.c();
        }
    }

    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f7924b.isIndoorEnable();
    }

    public final boolean isLockMapAngle(int i2) {
        return f(i2);
    }

    public final boolean isLockMapCameraDegree(int i2) {
        return false;
    }

    public final boolean isMaploaded() {
        return this.K;
    }

    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.F;
    }

    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f7924b.isTrafficEnabled();
    }

    public final boolean isUseAnchor() {
        return this.J;
    }

    public final void latlon2Geo(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        iPoint.x = latLongToPixels.x;
        iPoint.y = latLongToPixels.y;
    }

    public final void loadWorldVectorMap(boolean z2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z2);
        }
    }

    public final void map2Geo(float f2, float f3, IPoint iPoint) {
        double d2 = (double) f2;
        double sx = this.f7924b.getSX();
        Double.isNaN(d2);
        iPoint.x = (int) (d2 + sx);
        double d3 = (double) f3;
        double sy = this.f7924b.getSY();
        Double.isNaN(d3);
        iPoint.y = (int) (d3 + sy);
    }

    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            try {
                moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
            } catch (Throwable th) {
                dl.a(th);
            }
        }
    }

    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        GLMapEngine gLMapEngine = this.f7935f;
        if (gLMapEngine != null && !this.H) {
            try {
                if (this.I && gLMapEngine.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage c2 = z.c();
                    c2.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                    c2.geoPoint = new DPoint(this.f7924b.getSX(), this.f7924b.getSY());
                    c2.zoom = this.f7924b.getSZ();
                    c2.bearing = this.f7924b.getSR();
                    c2.tilt = this.f7924b.getSC();
                    this.f7935f.addMessage(abstractCameraUpdateMessage, false);
                    while (this.f7935f.getStateMessageCount() > 0) {
                        AbstractCameraUpdateMessage stateMessage = this.f7935f.getStateMessage();
                        if (stateMessage != null) {
                            stateMessage.mergeCameraUpdateDelegate(c2);
                        }
                    }
                    abstractCameraUpdateMessage = c2;
                }
            } catch (Throwable th) {
                dl.a(th);
            }
            resetRenderTime();
            this.f7935f.clearAnimations(1, false);
            abstractCameraUpdateMessage.isChangeFinished = true;
            a(abstractCameraUpdateMessage);
            this.f7935f.addMessage(abstractCameraUpdateMessage, false);
        }
    }

    public final void onActivityPause() {
        this.I = true;
        b(this.G);
    }

    public final void onActivityResume() {
        this.I = false;
        int i2 = this.G;
        if (i2 == 0) {
            i2 = this.f7935f.getEngineIDWithType(0);
        }
        c(i2);
    }

    public final void onChangeFinish() {
        Message obtainMessage = this.f7939j.obtainMessage();
        obtainMessage.what = 11;
        this.f7939j.sendMessage(obtainMessage);
    }

    public final boolean onDoubleTap(int i2, MotionEvent motionEvent) {
        if (!this.f7920aw) {
            return false;
        }
        a((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.E;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.U = true;
    }

    public final void onIndoorBuildingActivity(int i2, byte[] bArr) {
        ai aiVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    aiVar = new ai();
                    byte b2 = bArr[0];
                    aiVar.f7778a = new String(bArr, 1, b2, "utf-8");
                    int i3 = b2 + 1;
                    int i4 = i3 + 1;
                    byte b3 = bArr[i3];
                    aiVar.f7779b = new String(bArr, i4, b3, "utf-8");
                    int i5 = i4 + b3;
                    int i6 = i5 + 1;
                    byte b4 = bArr[i5];
                    aiVar.activeFloorName = new String(bArr, i6, b4, "utf-8");
                    int i7 = i6 + b4;
                    aiVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i7);
                    int i8 = i7 + 4;
                    int i9 = i8 + 1;
                    byte b5 = bArr[i8];
                    aiVar.poiid = new String(bArr, i9, b5, "utf-8");
                    int i10 = i9 + b5;
                    int i11 = i10 + 1;
                    byte b6 = bArr[i10];
                    aiVar.f7785h = new String(bArr, i11, b6, "utf-8");
                    int i12 = i11 + b6;
                    aiVar.f7780c = GLConvertUtil.getInt(bArr, i12);
                    int i13 = i12 + 4;
                    aiVar.floor_indexs = new int[aiVar.f7780c];
                    aiVar.floor_names = new String[aiVar.f7780c];
                    aiVar.f7781d = new String[aiVar.f7780c];
                    for (int i14 = 0; i14 < aiVar.f7780c; i14++) {
                        aiVar.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i13);
                        int i15 = i13 + 4;
                        int i16 = i15 + 1;
                        byte b7 = bArr[i15];
                        if (b7 > 0) {
                            aiVar.floor_names[i14] = new String(bArr, i16, b7, "utf-8");
                            i16 += b7;
                        }
                        i13 = i16 + 1;
                        byte b8 = bArr[i16];
                        if (b8 > 0) {
                            aiVar.f7781d[i14] = new String(bArr, i13, b8, "utf-8");
                            i13 += b8;
                        }
                    }
                    aiVar.f7782e = GLConvertUtil.getInt(bArr, i13);
                    int i17 = i13 + 4;
                    if (aiVar.f7782e > 0) {
                        aiVar.f7783f = new int[aiVar.f7782e];
                        for (int i18 = 0; i18 < aiVar.f7782e; i18++) {
                            aiVar.f7783f[i18] = GLConvertUtil.getInt(bArr, i17);
                            i17 += 4;
                        }
                    }
                    this.f7930bf = aiVar;
                    post(new Runnable() {
                        public final void run() {
                            if (b.this.aE != null) {
                                b.this.aE.a(b.this.f7930bf);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                dl.a(th);
                th.printStackTrace();
                return;
            }
        }
        aiVar = null;
        this.f7930bf = aiVar;
        post(new Runnable() {
            public final void run() {
                if (b.this.aE != null) {
                    b.this.aE.a(b.this.f7930bf);
                }
            }
        });
    }

    public final void onLongPress(int i2, MotionEvent motionEvent) {
        int i3 = 0;
        try {
            this.R = false;
            a(i2);
            BaseOverlay hitBaseOverlay = this.E.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.Q = (Marker) hitBaseOverlay;
            }
            Marker marker = this.Q;
            if (marker == null || !marker.isDraggable()) {
                List a2 = this.f7951v.a(AMap.OnMapLongClickListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                    synchronized (a2) {
                        while (i3 < a2.size()) {
                            ((AMap.OnMapLongClickListener) a2.get(i3)).onMapLongClick(new LatLng(obtain.f10010y, obtain.f10009x));
                            i3++;
                        }
                    }
                    this.S = true;
                    obtain.recycle();
                }
            } else {
                LatLng position = this.Q.getPosition();
                if (position != null) {
                    IPoint obtain2 = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain2);
                    obtain2.y -= 60;
                    DPoint obtain3 = DPoint.obtain();
                    getPixel2LatLng(obtain2.x, obtain2.y, obtain3);
                    this.Q.setPosition(new LatLng(obtain3.f10010y, obtain3.f10009x));
                    this.E.set2Top(this.Q.getId());
                    try {
                        List a3 = this.f7951v.a(AMap.OnMarkerDragListener.class.hashCode());
                        if (a3 != null && a3.size() > 0) {
                            synchronized (a3) {
                                while (i3 < a3.size()) {
                                    ((AMap.OnMarkerDragListener) a3.get(i3)).onMarkerDragStart(this.Q);
                                    i3++;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        fz.c(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.N = true;
                    obtain2.recycle();
                    obtain3.recycle();
                }
            }
            this.f7911an.resetTickCount(30);
        } catch (Throwable th2) {
            fz.c(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    public final void onPause() {
        f();
        IGlOverlayLayer iGlOverlayLayer = this.E;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    public final void onResume() {
        try {
            this.f7911an.setRenderFps(15.0f);
            this.C.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.E;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            bz bzVar = this.L;
            if (bzVar != null) {
                bzVar.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean onSingleTapConfirmed(int i2, MotionEvent motionEvent) {
        if (!this.f7920aw) {
            return false;
        }
        try {
            a(i2);
            g(motionEvent);
            if (e(motionEvent) || f(motionEvent)) {
                return true;
            }
            d(motionEvent);
            b(motionEvent);
            return true;
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.I || !this.f7920aw || !this.f7917at) {
            return false;
        }
        this.f7928bd.mGestureState = 3;
        this.f7928bd.mGestureType = 8;
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7928bd;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.f7928bd);
        n();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            o();
            d();
        } else if (action == 1) {
            e();
        }
        if (motionEvent.getAction() != 2 || !this.N) {
            if (this.f7913ap) {
                try {
                    this.f7912ao.a(motionEvent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            try {
                List a2 = this.f7951v.a(AMap.OnMapTouchListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    this.f7939j.removeMessages(14);
                    Message obtainMessage = this.f7939j.obtainMessage();
                    obtainMessage.what = 14;
                    obtainMessage.obj = MotionEvent.obtain(motionEvent);
                    obtainMessage.sendToTarget();
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        try {
            a(motionEvent);
        } catch (Throwable th2) {
            fz.c(th2, "AMapDelegateImp", "onDragMarker");
            th2.printStackTrace();
        }
        return true;
    }

    public final void pixel2Map(int i2, int i3, PointF pointF) {
        if (this.f7920aw && !this.I && this.f7935f != null) {
            IPoint obtain = IPoint.obtain();
            getPixel2Geo(i2, i3, obtain);
            pointF.x = ((float) obtain.x) - ((float) this.f7924b.getSX());
            pointF.y = ((float) obtain.y) - ((float) this.f7924b.getSY());
            obtain.recycle();
        }
    }

    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.C;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    public final void queueEvent(Runnable runnable) {
        long j2;
        try {
            j2 = Thread.currentThread().getId();
        } catch (Throwable th) {
            dl.a(th);
            fz.c(th, "AMapdelegateImp", "queueEvent");
            return;
        }
        if (j2 != -1 && j2 == this.f7910am) {
            runnable.run();
        } else if (this.f7935f != null) {
            this.C.queueEvent(runnable);
        }
    }

    public final void redrawInfoWindow() {
        if (this.f7920aw) {
            this.f7939j.sendEmptyMessage(18);
        }
    }

    public final void refreshLogo() {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.c();
        }
    }

    public final void reloadMap() {
    }

    public final void reloadMapCustomStyle() {
        a aVar = this.aH;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void removeEngineGLOverlay(final BaseMapOverlay baseMapOverlay) {
        if (this.f7935f != null) {
            queueEvent(new Runnable() {
                public final void run() {
                    b.this.f7935f.getOverlayBundle(1).removeOverlay(baseMapOverlay);
                }
            });
        }
    }

    public final boolean removeGLModel(String str) {
        try {
            this.E.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.E.removeOverlay(str);
    }

    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.b(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    public final void removecache() throws RemoteException {
        removecache((AMap.OnCacheRemoveListener) null);
    }

    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f7939j != null && this.f7935f != null) {
            try {
                d dVar = new d(this.f7934e, onCacheRemoveListener);
                this.f7939j.removeCallbacks(dVar);
                this.f7939j.post(dVar);
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
                dl.a(th);
            }
        }
    }

    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    public final void requestRender() {
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null && !gLMapRender.isRenderPause()) {
            this.C.requestRender();
        }
    }

    public final void resetMinMaxZoomPreference() {
        List a2;
        this.f7924b.resetMinMaxZoomPreference();
        try {
            if (this.A.isZoomControlsEnabled() && this.f7924b.isNeedUpdateZoomControllerState() && (a2 = this.f7951v.a(AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                synchronized (a2) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ((AMapWidgetListener) a2.get(i2)).invalidateZoomController(this.f7924b.getSZ());
                    }
                }
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f7911an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    public final void set3DBuildingEnabled(boolean z2) throws RemoteException {
        try {
            b(1);
            a(1, z2);
            c(1);
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        n nVar = this.f7912ao;
        if (nVar != null) {
            this.f7952w = aMapGestureListener;
            nVar.a(aMapGestureListener);
        }
    }

    public final void setCenterToPixel(int i2, int i3) throws RemoteException {
        this.J = true;
        this.aC = i2;
        this.aD = i3;
        if (this.f7921ax && this.f7920aw) {
            if (this.f7924b.getAnchorX() != this.aC || this.f7924b.getAnchorY() != this.aD) {
                this.f7924b.setAnchorX(this.aC);
                this.f7924b.setAnchorY(this.aD);
                queueEvent(new Runnable() {
                    public final void run() {
                        try {
                            b.this.f7924b.setAnchorX(Math.max(0, Math.min(b.this.aC, b.this.f7936g)));
                            b.this.f7924b.setAnchorY(Math.max(0, Math.min(b.this.aD, b.this.f7937h)));
                            b.this.f7935f.setProjectionCenter(1, b.this.f7924b.getAnchorX(), b.this.f7924b.getAnchorY());
                            boolean unused = b.this.f7902ae = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public final void setConstructingRoadEnable(final boolean z2) {
        try {
            if (!this.f7920aw || !this.f7921ax) {
                this.aR.f8029c = z2;
                this.aR.f8028b = true;
                this.aR.f8033g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        b.this.f7935f.setMapOpenLayerEnable(z2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (!a(true, false)) {
                    if (customMapStyleOptions.isEnable() && !(customMapStyleOptions.getStyleId() == null && customMapStyleOptions.getStyleTexturePath() == null && customMapStyleOptions.getStyleTextureData() == null && customMapStyleOptions.getStyleResDataPath() == null && customMapStyleOptions.getStyleResData() == null)) {
                        q();
                    }
                    this.aH.c();
                    this.aH.a(customMapStyleOptions);
                    com.autonavi.extra.b bVar = this.aX;
                    if (bVar != null) {
                        bVar.i();
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                dl.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    public final void setCustomMapStyle(boolean z2, byte[] bArr) {
        a(z2, bArr, false);
    }

    public final void setCustomMapStyleID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f7924b.getCustomStyleID())) {
            this.f7924b.setCustomStyleID(str);
            this.B = true;
        }
    }

    public final void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f7924b.getCustomStylePath())) {
            this.f7924b.setCustomStylePath(str);
            this.B = true;
        }
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.f7904ag = customRenderer;
    }

    public final void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7924b.setCustomTextureResourcePath(str);
        }
    }

    public final void setGestureStatus(int i2, int i3) {
        if (this.aB == 0 || i3 != 5) {
            this.aB = i3;
        }
    }

    public final void setHideLogoEnble(boolean z2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z2);
            if (this.f7924b.isCustomStyleEnable()) {
                this.A.setLogoEnable(!z2);
            }
        }
    }

    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (!this.H && indoorBuildingInfo != null && indoorBuildingInfo.activeFloorName != null && indoorBuildingInfo.poiid != null) {
            this.f7932c = (ai) indoorBuildingInfo;
            resetRenderTime();
            queueEvent(new Runnable() {
                public final void run() {
                    if (b.this.f7935f != null) {
                        b.this.f7935f.setIndoorBuildingToBeActive(1, b.this.f7932c.activeFloorName, b.this.f7932c.activeFloorIndex, b.this.f7932c.poiid);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setIndoorEnabled(final boolean r5) throws android.os.RemoteException {
        /*
            r4 = this;
            boolean r0 = r4.f7920aw     // Catch:{ all -> 0x0095 }
            r1 = 1
            if (r0 == 0) goto L_0x0088
            boolean r0 = r4.H     // Catch:{ all -> 0x0095 }
            if (r0 != 0) goto L_0x0088
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.f7924b     // Catch:{ all -> 0x0095 }
            r0.setIndoorEnable(r5)     // Catch:{ all -> 0x0095 }
            r4.resetRenderTime()     // Catch:{ all -> 0x0095 }
            if (r5 == 0) goto L_0x001b
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r4.f7935f     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0070
            r0.setIndoorEnable(r1, r1)     // Catch:{ all -> 0x0095 }
            goto L_0x0070
        L_0x001b:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r4.f7935f     // Catch:{ all -> 0x0095 }
            r2 = 0
            if (r0 == 0) goto L_0x0023
            r0.setIndoorEnable(r1, r2)     // Catch:{ all -> 0x0095 }
        L_0x0023:
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.f7924b     // Catch:{ all -> 0x0095 }
            boolean r1 = r0.isSetLimitZoomLevel()     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0032
            com.autonavi.base.amap.mapcore.MapConfig r1 = r4.f7924b     // Catch:{ all -> 0x0095 }
            float r1 = r1.getMaxZoomLevel()     // Catch:{ all -> 0x0095 }
            goto L_0x0034
        L_0x0032:
            r1 = 1101004800(0x41a00000, float:20.0)
        L_0x0034:
            r0.maxZoomLevel = r1     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.u r0 = r4.A     // Catch:{ all -> 0x0070 }
            boolean r0 = r0.isZoomControlsEnabled()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0070
            com.amap.api.mapcore.util.g r0 = r4.f7951v     // Catch:{ all -> 0x0070 }
            java.lang.Class<com.autonavi.base.ae.gmap.listener.AMapWidgetListener> r1 = com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class
            int r1 = r1.hashCode()     // Catch:{ all -> 0x0070 }
            java.util.List r0 = r0.a((int) r1)     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0070
            int r1 = r0.size()     // Catch:{ all -> 0x0070 }
            if (r1 <= 0) goto L_0x0070
            monitor-enter(r0)     // Catch:{ all -> 0x0070 }
        L_0x0053:
            int r1 = r0.size()     // Catch:{ all -> 0x006d }
            if (r2 >= r1) goto L_0x006b
            java.lang.Object r1 = r0.get(r2)     // Catch:{ all -> 0x006d }
            com.autonavi.base.ae.gmap.listener.AMapWidgetListener r1 = (com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r1     // Catch:{ all -> 0x006d }
            com.autonavi.base.amap.mapcore.MapConfig r3 = r4.f7924b     // Catch:{ all -> 0x006d }
            float r3 = r3.getSZ()     // Catch:{ all -> 0x006d }
            r1.invalidateZoomController(r3)     // Catch:{ all -> 0x006d }
            int r2 = r2 + 1
            goto L_0x0053
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            goto L_0x0070
        L_0x006d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r1     // Catch:{ all -> 0x0070 }
        L_0x0070:
            android.content.Context r0 = r4.f7934e     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.di.c((android.content.Context) r0, (boolean) r5)     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.u r0 = r4.A     // Catch:{ all -> 0x0095 }
            boolean r0 = r0.isIndoorSwitchEnabled()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0094
            android.os.Handler r0 = r4.f7939j     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.b$22 r1 = new com.amap.api.mapcore.util.b$22     // Catch:{ all -> 0x0095 }
            r1.<init>(r5)     // Catch:{ all -> 0x0095 }
            r0.post(r1)     // Catch:{ all -> 0x0095 }
            return
        L_0x0088:
            com.amap.api.mapcore.util.b$a r0 = r4.aU     // Catch:{ all -> 0x0095 }
            r0.f8029c = r5     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.b$a r5 = r4.aU     // Catch:{ all -> 0x0095 }
            r5.f8028b = r1     // Catch:{ all -> 0x0095 }
            com.amap.api.mapcore.util.b$a r5 = r4.aU     // Catch:{ all -> 0x0095 }
            r5.f8033g = r1     // Catch:{ all -> 0x0095 }
        L_0x0094:
            return
        L_0x0095:
            r5 = move-exception
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b.setIndoorEnabled(boolean):void");
    }

    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        aj ajVar;
        if (!this.H && (ajVar = this.f7953x) != null) {
            ajVar.a(commonInfoWindowAdapter);
        }
    }

    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        aj ajVar;
        if (!this.H && (ajVar = this.f7953x) != null) {
            ajVar.a(infoWindowAdapter);
        }
    }

    public final void setLoadOfflineData(final boolean z2) throws RemoteException {
        queueEvent(new Runnable() {
            public final void run() {
                if (b.this.f7935f != null) {
                    b.this.f7935f.setOfflineDataEnable(1, z2);
                }
            }
        });
    }

    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (!this.H) {
                LocationSource locationSource2 = this.M;
                if (locationSource2 != null && (locationSource2 instanceof ak)) {
                    locationSource2.deactivate();
                }
                this.M = locationSource;
                if (locationSource != null) {
                    this.D.h(Boolean.TRUE);
                } else {
                    this.D.h(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            dl.a(th);
        }
    }

    public final void setLogoBottomMargin(int i2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.c(Integer.valueOf(i2));
        }
    }

    public final void setLogoLeftMargin(int i2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.d(Integer.valueOf(i2));
        }
    }

    public final void setLogoMarginRate(int i2, float f2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.a(Integer.valueOf(i2), Float.valueOf(f2));
        }
    }

    public final void setLogoPosition(int i2) {
        dw dwVar = this.D;
        if (dwVar != null) {
            dwVar.b(Integer.valueOf(i2));
        }
    }

    public final void setMapCustomEnable(boolean z2) {
        if (z2) {
            q();
        }
        setMapCustomEnable(z2, false);
    }

    public final void setMapCustomEnable(boolean z2, boolean z3) {
        cg cgVar;
        if (!this.f7920aw || this.H) {
            this.aM.f8028b = true;
            this.aM.f8029c = z2;
            return;
        }
        boolean z4 = z3 ? z3 : false;
        if (!TextUtils.isEmpty(this.f7924b.getCustomStylePath()) || !TextUtils.isEmpty(this.f7924b.getCustomStyleID())) {
            if (z2) {
                try {
                    if (this.f7924b.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f7924b.getCustomStyleID()) && (cgVar = this.f7908ak) != null) {
                        cgVar.a(this.f7924b.getCustomStyleID());
                        this.f7908ak.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    dl.a(th);
                    return;
                }
            }
            if (z3 || this.B || (this.f7924b.isCustomStyleEnable() ^ z2)) {
                a(z2, (byte[]) null, z4);
            }
            this.B = false;
        }
    }

    public final void setMapEnable(boolean z2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z2);
        }
    }

    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        int i2;
        if (!TextUtils.isEmpty(str) && (mapConfig = this.f7924b) != null && !mapConfig.isCustomStyleEnable() && !this.f7924b.getMapLanguage().equals(str)) {
            if (!str.equals(AMap.ENGLISH)) {
                this.f7924b.setMapLanguage("zh_cn");
                i2 = 0;
            } else {
                if (this.Y != 1) {
                    try {
                        setMapType(1);
                    } catch (Throwable th) {
                        dl.a(th);
                        th.printStackTrace();
                    }
                }
                this.f7924b.setMapLanguage(AMap.ENGLISH);
                i2 = -10000;
            }
            this.f7903af = i2;
            try {
                b(getCameraPosition());
            } catch (Throwable th2) {
                dl.a(th2);
                th2.printStackTrace();
            }
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f7924b.setLimitLatLngBounds(latLngBounds);
            r();
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
    }

    public final void setMapTextEnable(final boolean z2) throws RemoteException {
        try {
            if (!this.f7920aw || !this.f7921ax) {
                this.aO.f8029c = z2;
                this.aO.f8028b = true;
                this.aO.f8033g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        b.this.f7935f.setLabelEnable(1, z2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setMapTextZIndex(int i2) throws RemoteException {
        this.f7903af = i2;
        this.f7938i = false;
    }

    public final void setMapType(int i2) throws RemoteException {
        MapConfig mapConfig;
        if (i2 != this.Y || ((mapConfig = this.f7924b) != null && mapConfig.isCustomStyleEnable())) {
            this.Y = i2;
            g(i2);
        }
    }

    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            g gVar = this.f7951v;
            if (gVar != null) {
                gVar.a(AMapWidgetListener.class.hashCode(), aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    public final void setMaskLayerParams(int i2, int i3, int i4, int i5, int i6, long j2) {
    }

    public final void setMaxZoomLevel(float f2) {
        this.f7924b.setMaxZoomLevel(f2);
    }

    public final void setMinZoomLevel(float f2) {
        this.f7924b.setMinZoomLevel(f2);
    }

    public final void setMyLocationEnabled(boolean z2) throws RemoteException {
        if (!this.H) {
            try {
                dw dwVar = this.D;
                if (dwVar != null) {
                    LocationSource locationSource = this.M;
                    if (locationSource == null) {
                        dwVar.h(Boolean.FALSE);
                    } else if (z2) {
                        locationSource.activate(this.f7950u);
                        this.D.h(Boolean.TRUE);
                        if (this.L == null) {
                            this.L = new bz(this, this.f7934e);
                        }
                    } else {
                        bz bzVar = this.L;
                        if (bzVar != null) {
                            bzVar.c();
                            this.L = null;
                        }
                        this.M.deactivate();
                    }
                }
                if (!z2) {
                    this.A.setMyLocationButtonEnabled(z2);
                }
                this.F = z2;
                resetRenderTime();
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImp", "setMyLocationEnabled");
                th.printStackTrace();
                dl.a(th);
            }
        }
    }

    public final void setMyLocationRotateAngle(float f2) throws RemoteException {
        try {
            bz bzVar = this.L;
            if (bzVar != null) {
                bzVar.a(f2);
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (!this.H) {
            try {
                if (this.L == null) {
                    this.L = new bz(this, this.f7934e);
                }
                if (this.L != null) {
                    if (myLocationStyle.getInterval() < 1000) {
                        myLocationStyle.interval(1000);
                    }
                    LocationSource locationSource = this.M;
                    if (locationSource != null && (locationSource instanceof ak)) {
                        ((ak) locationSource).a(myLocationStyle.getInterval());
                        ((ak) this.M).a(myLocationStyle.getMyLocationType());
                    }
                    this.L.a(myLocationStyle);
                }
            } catch (Throwable th) {
                dl.a(th);
            }
        }
    }

    public final void setMyLocationType(int i2) throws RemoteException {
        try {
            bz bzVar = this.L;
            if (bzVar != null && bzVar.a() != null) {
                this.L.a().myLocationType(i2);
                setMyLocationStyle(this.L.a());
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setNaviLabelEnable(final boolean z2, final int i2, final int i3) throws RemoteException {
        try {
            if (!this.f7920aw || !this.f7921ax) {
                this.aQ.f8029c = z2;
                this.aQ.f8034h = i2;
                this.aQ.f8035i = i3;
                this.aQ.f8028b = true;
                this.aQ.f8033g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        b.this.f7935f.setNaviLabelEnable(1, z2, i2, i3);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnIndoorBuildingActiveListener.class.hashCode(), onIndoorBuildingActiveListener);
        }
    }

    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMapLoadedListener.class.hashCode(), onMapLoadedListener);
        }
    }

    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.aG = onMultiPointClickListener;
    }

    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnPOIClickListener.class.hashCode(), onPOIClickListener);
        }
    }

    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        g gVar = this.f7951v;
        if (gVar != null) {
            gVar.a(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    public final void setRenderFps(int i2) {
        if (i2 != -1) {
            i2 = Math.max(10, Math.min(i2, 40));
        }
        try {
            this.f7906ai = i2;
            di.f(this.f7934e);
        } catch (Throwable th) {
            dl.a(th);
            th.printStackTrace();
        }
    }

    public final void setRenderMode(int i2) {
        try {
            IGLSurfaceView iGLSurfaceView = this.C;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void setRoadArrowEnable(final boolean z2) throws RemoteException {
        try {
            if (!this.f7920aw || !this.f7921ax) {
                this.aP.f8029c = z2;
                this.aP.f8028b = true;
                this.aP.f8033g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        b.this.f7935f.setRoadArrowEnable(1, z2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setRunLowFrame(boolean z2) {
        if (!z2) {
            try {
                if (this.f7906ai == -1) {
                    o();
                }
            } catch (Throwable th) {
                dl.a(th);
            }
        }
    }

    public final void setTouchPoiEnable(boolean z2) {
        MapConfig mapConfig = this.f7924b;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z2);
        }
    }

    public final void setTrafficEnabled(final boolean z2) throws RemoteException {
        try {
            if (!this.f7920aw || this.H) {
                this.aJ.f8029c = z2;
                this.aJ.f8028b = true;
                this.aJ.f8033g = 1;
                return;
            }
            queueEvent(new Runnable(z2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f7985a;

                {
                    this.f7985a = r2;
                }

                public final void run() {
                    try {
                        if (b.this.f7924b.isTrafficEnabled() != this.f7985a) {
                            b.this.f7924b.setTrafficEnabled(z2);
                            b.this.f7911an.setTrafficMode(this.f7985a);
                            b.this.f7935f.setTrafficEnable(1, this.f7985a);
                            b.this.resetRenderTime();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        dl.a(th);
                    }
                }
            });
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void setTrafficStyleWithTextureData(final byte[] bArr) {
        if (!this.H) {
            try {
                if (!this.f7920aw || !this.f7921ax || bArr == null) {
                    this.aS.f8036j = bArr;
                    this.aS.f8028b = true;
                    this.aS.f8033g = 1;
                    return;
                }
                resetRenderTime();
                queueEvent(new Runnable() {
                    public final void run() {
                        try {
                            b.this.f7935f.setTrafficStyleWithTextureData(1, bArr);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                dl.a(th);
            }
        }
    }

    public final void setVisibilityEx(int i2) {
        IGLSurfaceView iGLSurfaceView = this.C;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setWorldVectorMapStyle(String str) {
        if (!a(false, true) && !TextUtils.isEmpty(str) && this.f7924b != null && !this.aZ.equals(str)) {
            this.aZ = str;
            com.autonavi.extra.b bVar = this.aX;
            if (bVar != null) {
                bVar.i();
            }
            resetRenderTime();
        }
    }

    public final void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    public final void setZoomPosition(int i2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.a(Integer.valueOf(i2));
        }
    }

    public final void setZoomScaleParam(float f2) {
        this.f7915ar = f2;
    }

    public final void showCompassEnabled(boolean z2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.d(Boolean.valueOf(z2));
        }
    }

    public final void showIndoorSwitchControlsEnabled(boolean z2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.a(Boolean.valueOf(z2));
        }
    }

    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        aj ajVar;
        if (baseOverlay != null && (ajVar = this.f7953x) != null) {
            try {
                ajVar.a(baseOverlay);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        aj ajVar;
        if (baseOverlayImp != null && (ajVar = this.f7953x) != null) {
            try {
                ajVar.a(baseOverlayImp);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void showLogoEnabled(boolean z2) {
        if (!this.H) {
            this.D.f(Boolean.valueOf(z2));
        }
    }

    public final void showMyLocationButtonEnabled(boolean z2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.c(Boolean.valueOf(z2));
        }
    }

    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location != null) {
            try {
                if (this.F) {
                    if (this.M != null) {
                        if (this.L == null) {
                            this.L = new bz(this, this.f7934e);
                        }
                        if (!(location.getLongitude() == i.f27244a || location.getLatitude() == i.f27244a)) {
                            this.L.a(location);
                        }
                        List a2 = this.f7951v.a(AMap.OnMyLocationChangeListener.class.hashCode());
                        if (a2 != null && a2.size() > 0) {
                            synchronized (a2) {
                                for (int i2 = 0; i2 < a2.size(); i2++) {
                                    ((AMap.OnMyLocationChangeListener) a2.get(i2)).onMyLocationChange(location);
                                }
                            }
                        }
                        resetRenderTime();
                        return;
                    }
                }
                bz bzVar = this.L;
                if (bzVar != null) {
                    bzVar.c();
                }
                this.L = null;
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImp", "showMyLocationOverlay");
                th.printStackTrace();
            }
        }
    }

    public final void showScaleEnabled(boolean z2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.e(Boolean.valueOf(z2));
        }
    }

    public final void showZoomControlsEnabled(boolean z2) {
        dw dwVar;
        if (!this.H && (dwVar = this.D) != null) {
            dwVar.b(Boolean.valueOf(z2));
        }
    }

    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.f7935f;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final float toMapLenWithWin(int i2) {
        GLMapEngine gLMapEngine;
        if (!this.f7920aw || this.I || (gLMapEngine = this.f7935f) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(1).getGLUnitWithWin(i2);
    }

    public final void zoomOut(int i2) {
        if (this.f7920aw && ((float) ((int) c())) > this.f7924b.getMinZoomLevel()) {
            try {
                animateCamera(z.b());
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }
}
