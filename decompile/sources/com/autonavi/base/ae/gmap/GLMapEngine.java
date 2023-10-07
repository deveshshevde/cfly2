package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.amap.api.mapcore.util.dj;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.fz;
import com.amap.api.mapcore.util.ie;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback, NetworkState.NetworkChangeListener {
    Hashtable<Long, AMapLoader> aMapLoaderHashtable;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle;
    private Context context;
    private GLMapState copyGLMapState;
    private boolean isEngineRenderComplete;
    boolean isGestureStep;
    boolean isMoveCameraStep;
    boolean isNetworkConnected;
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList;
    private List<AbstractGestureMapMessage> mGestureEndMessageList;
    private final List<AbstractGestureMapMessage> mGestureMessageList;
    private IAMapDelegate mGlMapView;
    private Lock mLock;
    private IAMapListener mMapListener;
    /* access modifiers changed from: private */
    public long mNativeMapengineInstance;
    private NetworkState mNetworkState;
    boolean mRequestDestroy;
    private AtomicInteger mRequestID;
    private final List<AbstractCameraUpdateMessage> mStateMessageList;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    private int mapGestureCount;
    private Object mutLock;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private String userAgent;

    public static class InitParam {
        public String mConfigContent = "";
        public String mConfigPath = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mRootPath = "";
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;

        /* renamed from: x  reason: collision with root package name */
        public int f10013x;

        /* renamed from: y  reason: collision with root package name */
        public int f10014y;
    }

    public GLMapEngine(Context context2, IAMapDelegate iAMapDelegate) {
        this.mNativeMapengineInstance = 0;
        this.mGlMapView = null;
        this.mStateMessageList = new Vector();
        this.mGestureMessageList = new Vector();
        this.mGestureEndMessageList = new Vector();
        this.mAnimateStateMessageList = new Vector();
        this.isMoveCameraStep = false;
        this.isGestureStep = false;
        this.mapGestureCount = 0;
        this.mapAnimationMgr = null;
        this.copyGLMapState = null;
        this.mLock = new ReentrantLock();
        this.mutLock = new Object();
        this.mNetworkState = null;
        this.bundle = null;
        this.isEngineRenderComplete = false;
        this.aMapLoaderHashtable = new Hashtable<>();
        this.mRequestDestroy = false;
        this.isNetworkConnected = false;
        this.terrainTileProvider = null;
        this.mRequestID = new AtomicInteger(1);
        this.mRequestDestroy = false;
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.mGlMapView = iAMapDelegate;
            this.mTextTextureGenerator = new TextTextureGenerator();
            AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
            this.mapAnimationMgr = adglMapAnimationMgr;
            adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() {
                public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                    GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
                }
            });
            this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(context2);
            this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float adapterDpiScale(android.util.DisplayMetrics r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = getEMUI()
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0087
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = "EmotionUI_8"
            int r2 = r0.indexOf(r2)
            r3 = -1
            if (r2 != r3) goto L_0x001f
            java.lang.String r2 = "EmotionUI_9"
            int r0 = r0.indexOf(r2)
            if (r0 == r3) goto L_0x0087
        L_0x001f:
            if (r11 <= 0) goto L_0x0087
            r0 = 1
            r2 = 0
            java.lang.Class<android.util.DisplayMetrics> r3 = android.util.DisplayMetrics.class
            java.lang.String r4 = "noncompatWidthPixels"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x0038, IllegalAccessException -> 0x0033 }
            r3.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0038, IllegalAccessException -> 0x0033 }
            int r3 = r3.getInt(r8)     // Catch:{ NoSuchFieldException -> 0x0038, IllegalAccessException -> 0x0033 }
            goto L_0x003d
        L_0x0033:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x003c
        L_0x0038:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003c:
            r3 = 0
        L_0x003d:
            java.lang.Class<android.util.DisplayMetrics> r4 = android.util.DisplayMetrics.class
            java.lang.String r5 = "noncompatHeightPixels"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ NoSuchFieldException -> 0x0052, IllegalAccessException -> 0x004d }
            r4.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0052, IllegalAccessException -> 0x004d }
            int r4 = r4.getInt(r8)     // Catch:{ NoSuchFieldException -> 0x0052, IllegalAccessException -> 0x004d }
            goto L_0x0057
        L_0x004d:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0056
        L_0x0052:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0056:
            r4 = 0
        L_0x0057:
            java.lang.Class<android.util.DisplayMetrics> r5 = android.util.DisplayMetrics.class
            java.lang.String r6 = "noncompatDensityDpi"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x006c, IllegalAccessException -> 0x0067 }
            r5.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x006c, IllegalAccessException -> 0x0067 }
            int r2 = r5.getInt(r8)     // Catch:{ NoSuchFieldException -> 0x006c, IllegalAccessException -> 0x0067 }
            goto L_0x0070
        L_0x0067:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0070
        L_0x006c:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0070:
            if (r2 > r11) goto L_0x0076
            if (r3 > r9) goto L_0x0076
            if (r4 <= r10) goto L_0x0087
        L_0x0076:
            float r8 = (float) r2
            float r9 = (float) r11
            float r8 = r8 / r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0081
            r8 = 1073741824(0x40000000, float:2.0)
        L_0x0081:
            int r9 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r9 >= 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r1 = r8
        L_0x0087:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.adapterDpiScale(android.util.DisplayMetrics, int, int, int):float");
    }

    public static void destroyOverlay(int i2, long j2) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i2, j2);
        }
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback != null && (iAMapDelegate = this.mGlMapView) != null) {
            iAMapDelegate.getMainHandler().post(new Runnable() {
                public void run() {
                    try {
                        cancelableCallback.onCancel();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback != null && (iAMapDelegate = this.mGlMapView) != null) {
            iAMapDelegate.getMainHandler().post(new Runnable() {
                public void run() {
                    try {
                        cancelableCallback.onFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i2 = this.mapGestureCount - 1;
        this.mapGestureCount = i2;
        if (i2 == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.version.emui"});
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        if (this.mStateMessageList.size() <= 0) {
            AbstractCameraUpdateMessage abstractCameraUpdateMessage = null;
            synchronized (this.mAnimateStateMessageList) {
                if (this.mAnimateStateMessageList.size() > 0) {
                    abstractCameraUpdateMessage = this.mAnimateStateMessageList.remove(0);
                }
            }
            if (abstractCameraUpdateMessage != null) {
                abstractCameraUpdateMessage.generateMapAnimation(this);
            }
        }
    }

    private void initNetworkState() {
        NetworkState networkState = new NetworkState();
        this.mNetworkState = networkState;
        networkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected2 = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        this.isNetworkConnected = isNetworkConnected2;
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetNetStatus(j2, isNetworkConnected2 ? 1 : 0);
        }
    }

    protected static native String nativeAddNativeOverlay(int i2, long j2, int i3, int i4);

    private static native boolean nativeAddOverlayTexture(int i2, long j2, int i3, int i4, float f2, float f3, Bitmap bitmap, boolean z2, boolean z3);

    private static native void nativeCancelDownLoad(int i2, long j2, long j3);

    private static native void nativeCreateAMapEngineWithFrame(long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2, float f3, float f4, int i9);

    private static native long nativeCreateAMapInstance(String str, String str2, String str3, float f2, float f3, float f4, int i2);

    protected static native long nativeCreateOverlay(int i2, long j2, int i3);

    private static native void nativeDestroy(long j2);

    private static native void nativeDestroyCurrentState(long j2, long j3);

    protected static native void nativeDestroyOverlay(int i2, long j2);

    private static native void nativeFailedDownLoad(int i2, long j2, long j3, int i3);

    private static native void nativeFinishDownLoad(int i2, long j2, long j3);

    private static native void nativeGetCurTileIDs(int i2, long j2, int[] iArr, int i3);

    private static native long nativeGetCurrentMapState(int i2, long j2);

    private static native long nativeGetGlOverlayMgrPtr(int i2, long j2);

    public static native String nativeGetMapEngineVersion(int i2);

    private static native int[] nativeGetMapModeState(int i2, long j2, boolean z2);

    public static native long nativeGetNativeMapController(int i2, long j2);

    public static native int[] nativeGetScreenShot(int i2, long j2, int i3, int i4, int i5, int i6);

    private static native boolean nativeGetSrvViewStateBoolValue(int i2, long j2, int i3);

    private static native void nativeInitAMapEngineCallback(long j2, Object obj);

    private static native void nativeInitOpenLayer(int i2, long j2, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4);

    private static native boolean nativeIsEngineCreated(long j2, int i2);

    private static native void nativePopRenderState(int i2, long j2);

    private static native void nativePostRenderAMap(long j2, int i2);

    private static native void nativePushRendererState(int i2, long j2);

    private static native void nativeReceiveNetData(int i2, long j2, byte[] bArr, long j3, int i3);

    protected static native void nativeRemoveNativeAllOverlay(int i2, long j2);

    protected static native void nativeRemoveNativeOverlay(int i2, long j2, String str);

    private static native void nativeRenderAMap(long j2, int i2);

    private static native void nativeSelectMapPois(int i2, long j2, int i3, int i4, int i5, byte[] bArr);

    private static native void nativeSetAllContentEnable(int i2, long j2, boolean z2);

    private static native void nativeSetBuildingEnable(int i2, long j2, boolean z2);

    private static native void nativeSetBuildingTextureEnable(int i2, long j2, boolean z2);

    private static native void nativeSetCustomStyleData(int i2, long j2, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i2, long j2, byte[] bArr);

    private static native void nativeSetHighlightSubwayEnable(int i2, long j2, boolean z2);

    private static native void nativeSetIndoorBuildingToBeActive(int i2, long j2, String str, int i3, String str2);

    private static native void nativeSetIndoorEnable(int i2, long j2, boolean z2);

    private static native void nativeSetLabelEnable(int i2, long j2, boolean z2);

    private static native boolean nativeSetMapModeAndStyle(int i2, long j2, int[] iArr, boolean z2, boolean z3, StyleItem[] styleItemArr);

    private static native void nativeSetNaviLabelEnable(int i2, long j2, boolean z2, int i3, int i4);

    /* access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j2, int i2);

    private static native void nativeSetOfflineDataEnable(int i2, long j2, boolean z2);

    private static native void nativeSetOpenLayerEnable(int i2, long j2, boolean z2);

    private static native void nativeSetParameter(int i2, long j2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetProjectionCenter(int i2, long j2, float f2, float f3);

    private static native void nativeSetRenderListenerStatus(int i2, long j2);

    private static native void nativeSetRoadArrowEnable(int i2, long j2, boolean z2);

    private static native void nativeSetServiceViewRect(int i2, long j2, int i3, int i4, int i5, int i6, int i7, int i8);

    private static native void nativeSetSetBackgroundTexture(int i2, long j2, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i2, long j2, boolean z2);

    private static native void nativeSetSkyTexture(int i2, long j2, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i2, long j2, int i3, boolean z2);

    private static native void nativeSetStyleChangeGradualEnable(int i2, long j2, boolean z2);

    private static native void nativeSetTrafficEnable(int i2, long j2, boolean z2);

    private static native void nativeSetTrafficTexture(int i2, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static native void nativeSetTrafficTextureAllInOne(int i2, long j2, byte[] bArr);

    protected static native void nativeUpdateNativeArrowOverlay(int i2, long j2, String str, int[] iArr, int[] iArr2, int i3, int i4, int i5, float f2, boolean z2, int i6, int i7, int i8);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r5.mGestureEndMessageList.size() <= 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        recycleMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r2.width != 0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r2.height != 0) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        r2.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        r3 = r2.getMapGestureState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        if (r3 != 100) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
        gestureBegin();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (r3 != 101) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
        r2.runCameraUpdate(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        if (r3 != 102) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        gestureEnd();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r0 = r5.mGestureMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L_0x0010
            boolean r6 = r5.isGestureStep
            if (r6 == 0) goto L_0x000f
            r5.isGestureStep = r1
        L_0x000f:
            return r1
        L_0x0010:
            r0 = 1
            r5.isGestureStep = r0
            if (r6 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r2 = 0
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList
            monitor-enter(r3)
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r4 = r5.mGestureMessageList     // Catch:{ all -> 0x0073 }
            int r4 = r4.size()     // Catch:{ all -> 0x0073 }
            if (r4 <= 0) goto L_0x002a
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureMessageList     // Catch:{ all -> 0x0073 }
            java.lang.Object r2 = r2.remove(r1)     // Catch:{ all -> 0x0073 }
            com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage r2 = (com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage) r2     // Catch:{ all -> 0x0073 }
        L_0x002a:
            if (r2 != 0) goto L_0x0039
            monitor-exit(r3)     // Catch:{ all -> 0x0073 }
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r6 = r5.mGestureEndMessageList
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0038
            r5.recycleMessage()
        L_0x0038:
            return r0
        L_0x0039:
            monitor-exit(r3)     // Catch:{ all -> 0x0073 }
            int r3 = r2.width
            if (r3 != 0) goto L_0x0046
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapWidth()
            r2.width = r3
        L_0x0046:
            int r3 = r2.height
            if (r3 != 0) goto L_0x0052
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapHeight()
            r2.height = r3
        L_0x0052:
            int r3 = r2.getMapGestureState()
            r4 = 100
            if (r3 != r4) goto L_0x005e
            r5.gestureBegin()
            goto L_0x006d
        L_0x005e:
            r4 = 101(0x65, float:1.42E-43)
            if (r3 != r4) goto L_0x0066
            r2.runCameraUpdate(r6)
            goto L_0x006d
        L_0x0066:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x006d
            r5.gestureEnd()
        L_0x006d:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureEndMessageList
            r3.add(r2)
            goto L_0x0016
        L_0x0073:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0073 }
            goto L_0x0077
        L_0x0076:
            throw r6
        L_0x0077:
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processGestureMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040 A[Catch:{ Exception -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean processMessage() {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            com.autonavi.amap.api.mapcore.IGLMapState r2 = r7.getNewMapState(r1)     // Catch:{ Exception -> 0x005f }
            com.autonavi.base.ae.gmap.GLMapState r2 = (com.autonavi.base.ae.gmap.GLMapState) r2     // Catch:{ Exception -> 0x005f }
            boolean r3 = r7.processGestureMessage(r2)     // Catch:{ Exception -> 0x005f }
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r4 = r7.mGestureMessageList     // Catch:{ Exception -> 0x005f }
            int r4 = r4.size()     // Catch:{ Exception -> 0x005f }
            if (r4 > 0) goto L_0x0021
            if (r3 != 0) goto L_0x001f
            boolean r3 = r7.processStateMapMessage(r2)     // Catch:{ Exception -> 0x005f }
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            goto L_0x0032
        L_0x001f:
            r3 = 1
            goto L_0x0032
        L_0x0021:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r4 = r7.mStateMessageList     // Catch:{ Exception -> 0x005f }
            monitor-enter(r4)     // Catch:{ Exception -> 0x005f }
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r7.mStateMessageList     // Catch:{ all -> 0x005c }
            int r5 = r5.size()     // Catch:{ all -> 0x005c }
            if (r5 <= 0) goto L_0x0031
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r7.mStateMessageList     // Catch:{ all -> 0x005c }
            r5.clear()     // Catch:{ all -> 0x005c }
        L_0x0031:
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
        L_0x0032:
            if (r3 != 0) goto L_0x003d
            boolean r3 = r7.processAnimations(r2)     // Catch:{ Exception -> 0x005f }
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            goto L_0x003e
        L_0x003d:
            r3 = 1
        L_0x003e:
            if (r3 == 0) goto L_0x0058
            float r4 = r2.getCameraDegree()     // Catch:{ Exception -> 0x005f }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r5 = r7.mGlMapView     // Catch:{ Exception -> 0x005f }
            com.autonavi.base.amap.mapcore.MapConfig r5 = r5.getMapConfig()     // Catch:{ Exception -> 0x005f }
            float r6 = r2.getMapZoomer()     // Catch:{ Exception -> 0x005f }
            float r4 = com.amap.api.mapcore.util.dl.a((com.autonavi.amap.mapcore.interfaces.IMapConfig) r5, (float) r4, (float) r6)     // Catch:{ Exception -> 0x005f }
            r2.setCameraDegree(r4)     // Catch:{ Exception -> 0x005f }
            r7.setMapState(r1, r2)     // Catch:{ Exception -> 0x005f }
        L_0x0058:
            r2.recycle()     // Catch:{ Exception -> 0x005f }
            return r3
        L_0x005c:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            throw r1     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        if (r2.width != 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        r2.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        if (r2.height != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        r2.height = r5.mGlMapView.getMapHeight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean processStateMapMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r0 = r5.mStateMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L_0x0010
            boolean r6 = r5.isMoveCameraStep
            if (r6 == 0) goto L_0x000f
            r5.isMoveCameraStep = r1
        L_0x000f:
            return r1
        L_0x0010:
            r0 = 1
            r5.isMoveCameraStep = r0
            if (r6 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r2 = 0
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r3 = r5.mStateMessageList
            monitor-enter(r3)
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r4 = r5.mStateMessageList     // Catch:{ all -> 0x004e }
            int r4 = r4.size()     // Catch:{ all -> 0x004e }
            if (r4 <= 0) goto L_0x002a
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r2 = r5.mStateMessageList     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r2.remove(r1)     // Catch:{ all -> 0x004e }
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r2 = (com.autonavi.amap.mapcore.AbstractCameraUpdateMessage) r2     // Catch:{ all -> 0x004e }
        L_0x002a:
            if (r2 != 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            return r0
        L_0x002e:
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            int r3 = r2.width
            if (r3 != 0) goto L_0x003b
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapWidth()
            r2.width = r3
        L_0x003b:
            int r3 = r2.height
            if (r3 != 0) goto L_0x0047
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapHeight()
            r2.height = r3
        L_0x0047:
            r6.recalculate()
            r2.runCameraUpdate(r6)
            goto L_0x0016
        L_0x004e:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x0051:
            throw r6
        L_0x0052:
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processStateMapMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    public void OnIndoorBuildingActivity(int i2, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i2, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i2, AbstractGestureMapMessage abstractGestureMapMessage, boolean z2, int i3, int i4) {
        if (abstractGestureMapMessage != null) {
            abstractGestureMapMessage.isGestureScaleByMapCenter = z2;
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.add(abstractGestureMapMessage);
            }
        }
    }

    public void addGroupAnimation(int i2, int i3, float f2, int i4, int i5, int i6, int i7, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i3);
        adglMapAnimGroup.setToCameraDegree((float) i5, 0);
        adglMapAnimGroup.setToMapAngle((float) i4, 0);
        adglMapAnimGroup.setToMapLevel(f2, 0);
        adglMapAnimGroup.setToMapCenterGeo(i6, i7, 0);
        if (this.mapAnimationMgr != null && adglMapAnimGroup.isValid()) {
            this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
        }
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z2) {
        if (z2) {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
            return;
        }
        synchronized (this.mStateMessageList) {
            this.mStateMessageList.add(abstractCameraUpdateMessage);
        }
    }

    public String addNativeOverlay(int i2, int i3, int i4) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i2, j2, i3, i4);
        if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i2, Bitmap bitmap, int i3, int i4) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i3;
        gLTextureProperty.mAnchor = i4;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i2, gLTextureProperty);
    }

    public void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        if (this.mNativeMapengineInstance != 0 && gLTextureProperty != null && gLTextureProperty.mBitmap != null && !gLTextureProperty.mBitmap.isRecycled()) {
            nativeAddOverlayTexture(i2, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
        }
    }

    public boolean canStopMapRender(int i2) {
        return this.isEngineRenderComplete;
    }

    public void cancelAllAMapDownload() {
        try {
            synchronized (this.aMapLoaderHashtable) {
                for (Map.Entry<Long, AMapLoader> value : this.aMapLoaderHashtable.entrySet()) {
                    ((AMapLoader) value.getValue()).doCancel();
                }
                this.aMapLoaderHashtable.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancelRequireMapData(Object obj) {
        if (obj != null && (obj instanceof AMapLoader)) {
            ((AMapLoader) obj).doCancel();
        }
    }

    public void changeSurface(int i2, int i3) {
    }

    public void clearAllMessages(int i2) {
    }

    public void clearAnimations(int i2, boolean z2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void clearAnimations(int i2, boolean z2, int i3) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.f10013x, mapViewInitParam.f10014y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
        }
    }

    public boolean createAMapInstance(InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath);
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i2 = displayMetrics.densityDpi;
            float f2 = displayMetrics.density;
            float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.densityDpi);
            this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
            long nativeCreateAMapInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/", (float) i2, f2, adapterDpiScale, MapsInitializer.isTerrainEnable() ? 1 : 0);
            this.mNativeMapengineInstance = nativeCreateAMapInstance;
            if (nativeCreateAMapInstance == 0) {
                return false;
            }
            nativeInitAMapEngineCallback(nativeCreateAMapInstance, this);
            initNetworkState();
            return true;
        }
    }

    public long createOverlay(int i2, int i3) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return nativeCreateOverlay(i2, j2, i3);
        }
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    this.mLock.lock();
                    try {
                        GLMapState gLMapState = this.copyGLMapState;
                        if (gLMapState != null) {
                            gLMapState.recycle();
                        }
                        this.mLock.unlock();
                        nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                        nativeDestroy(this.mNativeMapengineInstance);
                    } catch (Throwable th) {
                        this.mLock.unlock();
                        throw th;
                    }
                }
                this.mNativeMapengineInstance = 0;
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            dj.b();
        } catch (Throwable th2) {
            th2.printStackTrace();
            dl.a(th2);
        }
    }

    public synchronized void finishDownLoad(int i2, long j2) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j2))) {
            long j3 = this.mNativeMapengineInstance;
            if (j3 != 0) {
                nativeFinishDownLoad(i2, j3, j2);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j2));
        }
    }

    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(1, j2);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i2, int[] iArr) {
        if (iArr != null) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = 0;
            }
            nativeGetCurTileIDs(i2, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return 1;
    }

    public int getEngineIDWithType(int i2) {
        return 1;
    }

    public long getGlOverlayMgrPtr(int i2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return nativeGetGlOverlayMgrPtr(i2, j2);
        }
        return 0;
    }

    public boolean getIsProcessBuildingMark(int i2) {
        return false;
    }

    public byte[] getLabelBuffer(int i2, int i3, int i4, int i5) {
        this.mLock.lock();
        try {
            byte[] bArr = new byte[3072];
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSelectMapPois(i2, j2, i3, i4, i5, bArr);
            }
            return bArr;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean getMapDataTaskIsCancel(int i2, long j2) {
        return !this.aMapLoaderHashtable.containsKey(Long.valueOf(j2));
    }

    public int[] getMapModeState(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 == 0) {
            return null;
        }
        nativeGetMapModeState(i2, j2, z2);
        return null;
    }

    /* JADX INFO: finally extract failed */
    public GLMapState getMapState(int i2) {
        this.mLock.lock();
        try {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i2, j2);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i2) {
        return 0;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return nativeGetNativeMapController(i2, j2);
        }
        return 0;
    }

    public IGLMapState getNewMapState(int i2) {
        this.mLock.lock();
        try {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                return new GLMapState(i2, j2);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i2) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i2, int i3, int i4, int i5, int i6) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return dl.a(nativeGetScreenShot(i2, j2, i3, i4, i5, i6), i5 - i3, i6 - i4, true);
        }
        return null;
    }

    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i2, int i3) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return nativeGetSrvViewStateBoolValue(i2, j2, i3);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            if (this.mStateMessageList.size() == 0) {
                return null;
            }
            AbstractCameraUpdateMessage remove = this.mStateMessageList.remove(0);
            return remove;
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initMapOpenLayer(String str) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0 && str != null) {
            nativeInitOpenLayer(1, j2, str.getBytes());
        }
    }

    public void initNativeTexture(int i2) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = null;
            Bitmap bitmap2 = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap3 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            if (fromAsset3 != null) {
                bitmap = fromAsset3.getBitmap();
            }
            addOverlayTexture(i2, bitmap2, 111, 4);
            addOverlayTexture(i2, bitmap3, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 4);
            addOverlayTexture(i2, bitmap, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(1)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(1, false);
            } catch (Throwable th) {
                fz.c(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            return nativeIsEngineCreated(j2, i2);
        }
        return false;
    }

    public boolean isInMapAction(int i2) {
        return false;
    }

    public boolean isInMapAnimation(int i2) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void netError(int r8, long r9, int r11, int r12) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Hashtable<java.lang.Long, com.autonavi.base.amap.mapcore.maploader.AMapLoader> r0 = r7.aMapLoaderHashtable     // Catch:{ all -> 0x0037 }
            java.lang.Long r1 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0037 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r7)
            return
        L_0x000f:
            long r2 = r7.mNativeMapengineInstance     // Catch:{ all -> 0x0037 }
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x001d
            r1 = r8
            r4 = r9
            r6 = r12
            nativeFailedDownLoad(r1, r2, r4, r6)     // Catch:{ all -> 0x0037 }
        L_0x001d:
            java.util.Hashtable<java.lang.Long, com.autonavi.base.amap.mapcore.maploader.AMapLoader> r8 = r7.aMapLoaderHashtable     // Catch:{ all -> 0x0037 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0037 }
            r8.remove(r9)     // Catch:{ all -> 0x0037 }
            com.amap.api.maps.ExceptionLogger r8 = com.amap.api.maps.MapsInitializer.getExceptionLogger()     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x0033
            com.amap.api.maps.ExceptionLogger r8 = com.amap.api.maps.MapsInitializer.getExceptionLogger()     // Catch:{ all -> 0x0035 }
            r8.onDownloaderException(r11, r12)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r7)
            return
        L_0x0035:
            monitor-exit(r7)
            return
        L_0x0037:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.netError(int, long, int, int):void");
    }

    public synchronized void netStop(int i2, long j2, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j2))) {
            long j3 = this.mNativeMapengineInstance;
            if (j3 != 0) {
                nativeCancelDownLoad(i2, j3, j2);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j2));
        }
    }

    public void networkStateChanged(Context context2) {
        if (!this.mRequestDestroy && this.mNativeMapengineInstance != 0 && this.mGlMapView != null) {
            this.isNetworkConnected = NetworkState.isNetworkConnected(context2);
            this.mGlMapView.queueEvent(new Runnable() {
                public void run() {
                    GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, GLMapEngine.this.isNetworkConnected ? 1 : 0);
                }
            });
        }
    }

    public void onClearCache(int i2) {
    }

    public void onMapRender(int i2, int i3) {
        if (i3 == 5) {
            IAMapListener iAMapListener = this.mMapListener;
            if (iAMapListener != null) {
                iAMapListener.beforeDrawLabel(i2, getMapState(i2));
            }
        } else if (i3 == 6) {
            IAMapListener iAMapListener2 = this.mMapListener;
            if (iAMapListener2 != null) {
                iAMapListener2.afterDrawLabel(i2, getMapState(i2));
            }
        } else if (i3 == 7) {
            IAMapListener iAMapListener3 = this.mMapListener;
            if (iAMapListener3 != null) {
                iAMapListener3.afterRendererOver(i2, getMapState(i2));
            }
        } else if (i3 == 13) {
            try {
                this.isEngineRenderComplete = true;
            } catch (Throwable unused) {
            }
        }
    }

    public void popRendererState() {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativePopRenderState(1, j2);
        }
    }

    public void pushRendererState() {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativePushRendererState(1, j2);
        }
    }

    public void putResourceData(int i2, byte[] bArr) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void receiveNetData(int r9, long r10, byte[] r12, int r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mRequestDestroy     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r8)
            return
        L_0x0007:
            java.util.Hashtable<java.lang.Long, com.autonavi.base.amap.mapcore.maploader.AMapLoader> r0 = r8.aMapLoaderHashtable     // Catch:{ all -> 0x0026 }
            java.lang.Long r1 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r8)
            return
        L_0x0015:
            long r2 = r8.mNativeMapengineInstance     // Catch:{ all -> 0x0026 }
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x0024
            r1 = r9
            r4 = r12
            r5 = r10
            r7 = r13
            nativeReceiveNetData(r1, r2, r4, r5, r7)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r8)
            return
        L_0x0026:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.receiveNetData(int, long, byte[], int):void");
    }

    public void releaseNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener((NetworkState.NetworkChangeListener) null);
            this.mNetworkState = null;
        }
    }

    public void reloadMapResource(int i2, String str, int i3) {
    }

    public void removeNativeAllOverlay(int i2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeRemoveNativeAllOverlay(i2, j2);
        }
    }

    public void removeNativeOverlay(int i2, String str) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0 && str != null) {
            nativeRemoveNativeOverlay(i2, j2, str);
        }
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, 1);
                nativePostRenderAMap(this.mNativeMapengineInstance, 1);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (!this.isEngineRenderComplete) {
                nativeSetRenderListenerStatus(1, this.mNativeMapengineInstance);
            }
        }
    }

    public byte[] requireCharBitmap(int i2, int i3, int i4) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i3, i4);
    }

    public byte[] requireCharsWidths(int i2, int[] iArr, int i3, int i4) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    public void requireMapData(int i2, byte[] bArr) {
    }

    public int requireMapDataAsyn(int i2, byte[] bArr) {
        if (!this.mRequestDestroy && bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i3 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i3);
            int i4 = i3 + 4;
            int i5 = GLConvertUtil.getInt(bArr, i4);
            int i6 = i4 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i6, i5);
            int i7 = i6 + i5;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i7);
            int i8 = i7 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i8);
            int i9 = i8 + 4;
            int i10 = GLConvertUtil.getInt(bArr, i9);
            int i11 = i9 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i11, i10);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i11 + i10);
            final AMapLoader aMapLoader = new AMapLoader(i2, this, aDataRequestParam);
            synchronized (this) {
                this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            }
            try {
                dj.a().a(new ie() {
                    public void runTask() {
                        AMapLoader aMapLoader;
                        try {
                            if (!GLMapEngine.this.mRequestDestroy && (aMapLoader = aMapLoader) != null) {
                                aMapLoader.doRequest();
                            }
                        } catch (Throwable th) {
                            fz.c(th, "download Thread", "AMapLoader doRequest");
                            dl.a(th);
                        }
                    }
                });
            } catch (Throwable th) {
                fz.c(th, "download Thread", "requireMapData");
                dl.a(th);
            }
        }
        return 0;
    }

    public void requireMapRender(int i2, int i3, int i4) {
    }

    public byte[] requireMapResource(int i2, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String concat = "map_assets/".concat(String.valueOf(str));
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    bArr = this.mGlMapView.getCustomStyleManager().a(str);
                    if (bArr != null) {
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, concat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = dl.a(bArr, customBackgroundColor);
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, concat);
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public void setAllContentEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            if (z2) {
                nativeSetAllContentEnable(i2, j2, true);
            } else {
                nativeSetAllContentEnable(i2, j2, false);
            }
            setSimple3DEnable(i2, false);
        }
    }

    public void setBackgroundTexture(int i2, byte[] bArr) {
        if (bArr != null) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetSetBackgroundTexture(i2, j2, bArr);
            }
        }
    }

    public void setBuildingEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetBuildingEnable(i2, j2, z2);
        }
    }

    public void setBuildingTextureEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetBuildingTextureEnable(i2, j2, z2);
        }
    }

    public void setCustomStyleData(int i2, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetCustomStyleData(i2, j2, bArr, bArr2);
            }
        }
    }

    public void setCustomStyleTexture(int i2, byte[] bArr) {
        if (bArr != null) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetCustomStyleTexture(i2, j2, bArr);
            }
        }
    }

    public void setHighlightSubwayEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetHighlightSubwayEnable(i2, j2, z2);
        }
    }

    public void setIndoorBuildingToBeActive(int i2, String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetIndoorBuildingToBeActive(i2, j2, str, i3, str2);
            }
        }
    }

    public void setIndoorEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetIndoorEnable(i2, j2, z2);
        }
    }

    public void setInternaltexture(int i2, byte[] bArr, int i3) {
    }

    public void setLabelEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetLabelEnable(i2, j2, z2);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i2, long j2, AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i2, int i3, int i4, int i5, boolean z2, boolean z3, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i2, i3, i4, i5, z2, z3, styleItemArr);
        if (styleItemArr != null && z3) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                Context context2 = this.context;
                setBackgroundTexture(i2, dl.a(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i2, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i3 == 0 && i4 == 0 && i5 == 0) {
            Context context3 = this.context;
            setBackgroundTexture(i2, FileUtil.readFileContentsFromAssets(context3, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME));
            Context context4 = this.context;
            setCustomStyleTexture(i2, FileUtil.readFileContentsFromAssets(context4, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetOpenLayerEnable(1, j2, z2);
        }
    }

    public void setMapState(int i2, GLMapState gLMapState) {
        setMapState(i2, gLMapState, true);
    }

    public void setMapState(int i2, GLMapState gLMapState, boolean z2) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (!(!z2 || (iAMapDelegate = this.mGlMapView) == null || iAMapDelegate.getMapConfig() == null)) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i2, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public boolean setNativeMapModeAndStyle(int i2, int i3, int i4, int i5, boolean z2, boolean z3, StyleItem[] styleItemArr) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i2, j2, new int[]{i3, i4, i5, 0, 0}, z2, z3, styleItemArr);
    }

    public void setNaviLabelEnable(int i2, boolean z2, int i3, int i4) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetNaviLabelEnable(i2, j2, z2, i3, i4);
        }
    }

    public void setOfflineDataEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetOfflineDataEnable(i2, j2, z2);
        }
    }

    public void setOvelayBundle(int i2, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mLock.lock();
        try {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetParameter(i2, j2, i3, i4, i5, i6, i7);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i2, int i3, int i4) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetProjectionCenter(i2, j2, (float) i3, (float) i4);
        }
    }

    public void setRoadArrowEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetRoadArrowEnable(i2, j2, z2);
        }
    }

    public void setServiceViewRect(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        nativeSetServiceViewRect(i2, this.mNativeMapengineInstance, i3, i4, i5, i6, i7, i8);
    }

    public void setSimple3DEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetSimple3DEnable(i2, j2, z2);
        }
    }

    public void setSkyTexture(int i2, byte[] bArr) {
        if (bArr != null) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeSetSkyTexture(i2, j2, bArr);
            }
        }
    }

    public void setSrvViewStateBoolValue(int i2, int i3, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetSrvViewStateBoolValue(i2, j2, i3, z2);
        }
    }

    public void setStyleChangeGradualEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetStyleChangeGradualEnable(i2, j2, z2);
        }
    }

    public void setTrafficEnable(int i2, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeSetTrafficEnable(i2, j2, z2);
        }
    }

    public void setTrafficStyleWithTextureData(int i2, byte[] bArr) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0 && bArr != null) {
            nativeSetTrafficTextureAllInOne(i2, j2, bArr);
        }
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i2, Point point, float f2, float f3) {
        if (point != null) {
            try {
                clearAnimations(i2, true);
                GLMapState cloneMapState = getCloneMapState();
                cloneMapState.reset();
                cloneMapState.recalculate();
                float abs = Math.abs(f2);
                float abs2 = Math.abs(f3);
                if ((abs > abs2 ? abs : abs2) > 12000.0f) {
                    float f4 = -12000.0f;
                    if (abs > abs2) {
                        if (f2 > 0.0f) {
                            f4 = 12000.0f;
                        }
                        f2 = f4;
                        f3 = (12000.0f / abs) * f3;
                    } else {
                        float f5 = (12000.0f / abs2) * f2;
                        if (f3 > 0.0f) {
                            f2 = f5;
                            f3 = 12000.0f;
                        } else {
                            f2 = f5;
                            f3 = -12000.0f;
                        }
                    }
                }
                int mapWidth = this.mGlMapView.getMapWidth() >> 1;
                int mapHeight = this.mGlMapView.getMapHeight() >> 1;
                if (this.mGlMapView.isUseAnchor()) {
                    mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                    mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
                }
                AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
                adglMapAnimFling.setPositionAndVelocity(f2, f3);
                adglMapAnimFling.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFling, (AMap.CancelableCallback) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void startPivotZoomRotateAnim(int i2, Point point, float f2, int i3, int i4) {
        if (f2 != -9999.0f || i3 == -9999) {
        }
    }

    public void updateNativeArrowOverlay(int i2, String str, int[] iArr, int[] iArr2, int i3, int i4, int i5, float f2, int i6, int i7, int i8, boolean z2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0 && str != null) {
            nativeUpdateNativeArrowOverlay(i2, j2, str, iArr, iArr2, i3, i4, i5, f2, z2, i6, i7, i8);
        }
    }
}
