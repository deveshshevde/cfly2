package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

public final class p implements IMapFragmentDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f9676a;

    /* renamed from: f  reason: collision with root package name */
    private static String f9677f;

    /* renamed from: b  reason: collision with root package name */
    public int f9678b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f9679c = true;

    /* renamed from: d  reason: collision with root package name */
    private IAMap f9680d;

    /* renamed from: e  reason: collision with root package name */
    private int f9681e = 0;

    /* renamed from: g  reason: collision with root package name */
    private AMapOptions f9682g;

    public p(int i2) {
        this.f9681e = i2 % 3;
        b();
    }

    private static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                if (stackTrace[i2].getClassName() != null && stackTrace[i2].getClassName().endsWith("TextureMapView")) {
                    z3 = true;
                }
                if (stackTrace[i2].getClassName() != null && stackTrace[i2].getClassName().endsWith("Fragment")) {
                    z2 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i2].getMethodName())) {
                    z4 = true;
                }
            }
            if (z2 && z3 && !z4) {
                c();
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context) {
        if (context != null) {
            f9676a = context.getApplicationContext();
        }
    }

    private void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.f9680d != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.f9680d.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
            }
            UiSettings aMapUiSettings = this.f9680d.getAMapUiSettings();
            aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
            aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
            aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
            aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
            aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
            aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
            aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
            aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
            this.f9680d.setMapType(aMapOptions.getMapType());
            this.f9680d.setZOrderOnTop(aMapOptions.getZOrderOnTop());
        }
    }

    private static void b() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 80; i2++) {
                sb.append("=");
            }
            f9677f = sb.toString();
        } catch (Throwable unused) {
        }
    }

    private static void c() {
        Log.i("errorLog", f9677f);
        Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
        Log.i("errorLog", f9677f);
    }

    public final IAMap getMap() throws RemoteException {
        if (this.f9680d == null) {
            if (f9676a == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i2 = f9676a.getResources().getDisplayMetrics().densityDpi;
            l.f9554a = i2 <= 120 ? 0.5f : i2 <= 160 ? 0.8f : i2 <= 240 ? 0.87f : i2 <= 320 ? 1.0f : i2 <= 480 ? 1.5f : i2 <= 640 ? 1.8f : 0.9f;
            int i3 = this.f9681e;
            this.f9680d = i3 == 0 ? new d(f9676a, this.f9679c).a() : i3 == 1 ? new e(f9676a, this.f9679c).a() : new c(f9676a).a();
        }
        return this.f9680d;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void loadWorldVectorMap(boolean z2) {
        this.f9679c = z2;
        IAMap iAMap = this.f9680d;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z2);
        }
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f9676a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            IAMap map = getMap();
            this.f9680d = map;
            map.setVisibilityEx(this.f9678b);
            if (!(this.f9682g != null || bundle == null || (byteArray = bundle.getByteArray("MAP_OPTIONS")) == null)) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f9682g = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.f9682g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f9680d.getView();
    }

    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.f9680d;
        if (iAMap != null) {
            iAMap.clear();
            this.f9680d.destroy();
            this.f9680d = null;
        }
    }

    public final void onDestroyView() throws RemoteException {
    }

    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.f9682g = aMapOptions;
    }

    public final void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f9680d;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f9680d;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f9680d != null) {
            if (this.f9682g == null) {
                this.f9682g = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f9682g.camera(getMap().getCameraPosition());
                this.f9682g = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    public final void setContext(Context context) {
        a(context);
    }

    public final void setOptions(AMapOptions aMapOptions) {
        this.f9682g = aMapOptions;
    }

    public final void setVisibility(int i2) {
        this.f9678b = i2;
        IAMap iAMap = this.f9680d;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i2);
        }
    }
}
