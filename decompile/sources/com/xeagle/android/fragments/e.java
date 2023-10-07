package com.xeagle.android.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.f;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.o;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.Utils;
import com.xeagle.android.utils.prefs.AutoPanMode;
import dy.ai;
import dy.ak;
import dy.al;
import dy.am;
import dy.ar;
import dy.m;
import dy.p;
import dy.t;
import eo.a;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import ke.b;
import ke.c;
import ke.d;
import kh.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public abstract class e extends Fragment implements DroneInterfaces.c {
    private static final String TAG = "Map";
    float[] R2 = new float[9];
    float[] accelerometerValues = new float[3];
    private a camera = new a();
    protected Context context;
    /* access modifiers changed from: private */
    public float currentDegree;
    public en.a drone;
    float floats;
    public ke.a graphicDrone;
    public b guided;
    /* access modifiers changed from: private */
    public c home;
    /* access modifiers changed from: private */
    public o imageDialog;
    /* access modifiers changed from: private */
    public float lastDegree;
    public d launcher;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler();
    protected kh.a mMapFragment;
    private final Runnable mUpdateMap = new Runnable() {
        public void run() {
            List<kh.b> c2 = e.this.missionProxy.c();
            boolean z2 = !c2.isEmpty();
            boolean a2 = e.this.home.a();
            boolean isVisible = e.this.guided.isVisible();
            boolean a3 = e.this.launcher.a();
            Set<kh.b> b2 = e.this.mMapFragment.b();
            if (!b2.isEmpty()) {
                if (a2) {
                    b2.remove(e.this.home);
                }
                if (a3) {
                    if (((XEagleApp) e.this.requireActivity().getApplicationContext()).j().aF()) {
                        b2.remove(e.this.launcher);
                    } else {
                        return;
                    }
                }
                if (isVisible) {
                    b2.remove(e.this.guided);
                }
                if (z2) {
                    b2.removeAll(c2);
                }
                e.this.mMapFragment.a((Collection<kh.b>) b2);
            }
            if (a2) {
                if (((XEagleApp) e.this.requireActivity().getApplicationContext()).j().aF()) {
                    e.this.mMapFragment.a((kh.b) e.this.home);
                } else {
                    return;
                }
            }
            if (a3) {
                e.this.mMapFragment.a((kh.b) e.this.launcher);
            }
            if (isVisible) {
                e.this.mMapFragment.a((kh.b) e.this.guided);
            }
            if (z2) {
                e.this.mMapFragment.a(c2, e.this.isMissionDraggable());
            }
            e.this.mMapFragment.b((a.e) e.this.missionProxy);
            e.this.mMapFragment.b(e.this.missionProxy.i());
            e.this.mHandler.removeCallbacks(this);
        }
    };
    float[] magneticFieldValues = new float[3];
    protected kn.a missionProxy;
    double[] nums = new double[15];
    /* access modifiers changed from: private */
    public float phoneRotate;
    SensorEventListener sensorListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i2) {
            if (i2 < 1) {
                if (e.this.imageDialog == null) {
                    e eVar = e.this;
                    o unused = eVar.imageDialog = o.a(eVar.getString(R.string.warning), e.this.getString(R.string.phone_calibrate_warn), new o.a() {
                        public void a() {
                        }
                    });
                }
                if (!e.this.imageDialog.isAdded()) {
                    e.this.imageDialog.show(e.this.getChildFragmentManager(), "phoneCalibrate");
                }
            } else if (e.this.imageDialog != null && e.this.imageDialog.isAdded()) {
                e.this.imageDialog.dismiss();
                ToastUtils.showLong((CharSequence) e.this.getString(R.string.cal_success));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSensorChanged(android.hardware.SensorEvent r6) {
            /*
                r5 = this;
                long r0 = java.lang.System.currentTimeMillis()
                com.xeagle.android.fragments.e r2 = com.xeagle.android.fragments.e.this
                long r2 = r2.updateTime
                long r0 = r0 - r2
                r2 = 120(0x78, double:5.93E-322)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x0012
                return
            L_0x0012:
                com.xeagle.android.fragments.e r0 = com.xeagle.android.fragments.e.this
                long r1 = java.lang.System.currentTimeMillis()
                long unused = r0.updateTime = r1
                com.xeagle.android.fragments.e r0 = com.xeagle.android.fragments.e.this
                float[] r6 = r6.values
                java.lang.Object r6 = r6.clone()
                float[] r6 = (float[]) r6
                r0.magneticFieldValues = r6
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float[] r0 = r6.magneticFieldValues
                r1 = 0
                r0 = r0[r1]
                double r0 = (double) r0
                com.xeagle.android.fragments.e r2 = com.xeagle.android.fragments.e.this
                double[] r2 = r2.nums
                double r0 = com.xeagle.android.utils.c.a((double) r0, (double[]) r2)
                float r0 = (float) r0
                float unused = r6.currentDegree = r0
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r6 = r6.currentDegree
                com.xeagle.android.fragments.e r0 = com.xeagle.android.fragments.e.this
                float r0 = r0.lastDegree
                float r6 = r6 - r0
                float r6 = java.lang.Math.abs(r6)
                r0 = 1065353216(0x3f800000, float:1.0)
                int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r6 < 0) goto L_0x00e1
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                androidx.fragment.app.FragmentActivity r6 = r6.requireActivity()
                android.view.WindowManager r6 = r6.getWindowManager()
                android.view.Display r6 = r6.getDefaultDisplay()
                int r6 = r6.getRotation()
                r0 = 1
                if (r6 != r0) goto L_0x0071
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r0 = r6.currentDegree
            L_0x006d:
                float unused = r6.phoneRotate = r0
                goto L_0x0090
            L_0x0071:
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                androidx.fragment.app.FragmentActivity r6 = r6.requireActivity()
                android.view.WindowManager r6 = r6.getWindowManager()
                android.view.Display r6 = r6.getDefaultDisplay()
                int r6 = r6.getRotation()
                r0 = 3
                if (r6 != r0) goto L_0x0090
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r0 = r6.currentDegree
                r1 = 1127481344(0x43340000, float:180.0)
                float r0 = r0 - r1
                goto L_0x006d
            L_0x0090:
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r6 = r6.currentDegree
                com.xeagle.android.fragments.e r0 = com.xeagle.android.fragments.e.this
                float r0 = r0.lastDegree
                float r6 = r6 - r0
                float r6 = java.lang.Math.abs(r6)
                r0 = 1097859072(0x41700000, float:15.0)
                int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r0 <= 0) goto L_0x00b7
                r0 = 1135542272(0x43af0000, float:350.0)
                int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x00b7
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r0 = r6.currentDegree
                float unused = r6.lastDegree = r0
                return
            L_0x00b7:
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                android.os.Handler r6 = r6.mHandler
                com.xeagle.android.fragments.e$2$1 r0 = new com.xeagle.android.fragments.e$2$1
                r0.<init>()
                r6.post(r0)
                org.greenrobot.eventbus.c r6 = org.greenrobot.eventbus.c.a()
                jo.ag r0 = new jo.ag
                r1 = 0
                com.xeagle.android.fragments.e r2 = com.xeagle.android.fragments.e.this
                float r2 = r2.phoneRotate
                r0.<init>(r1, r2)
                r6.d(r0)
                com.xeagle.android.fragments.e r6 = com.xeagle.android.fragments.e.this
                float r0 = r6.phoneRotate
                float unused = r6.lastDegree = r0
            L_0x00e1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.e.AnonymousClass2.onSensorChanged(android.hardware.SensorEvent):void");
        }
    };
    private SensorManager sensorManager;
    /* access modifiers changed from: private */
    public long updateTime = 0;
    float[] values = new float[3];

    /* renamed from: com.xeagle.android.fragments.e$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23270a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23270a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPDATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f23270a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOOTPRINT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.e.AnonymousClass3.<clinit>():void");
        }
    }

    private void updateMapFragment() {
        DPMapProvider a2 = Utils.a(requireActivity().getApplicationContext());
        FragmentManager childFragmentManager = getChildFragmentManager();
        kh.a aVar = (kh.a) childFragmentManager.d((int) R.id.map_fragment_container);
        this.mMapFragment = aVar;
        if (aVar == null || aVar.c() != a2) {
            Bundle bundle = new Bundle();
            bundle.putInt(kh.a.f13860b, getMaxFlightPathSize());
            kh.a a3 = a2.a();
            this.mMapFragment = a3;
            ((Fragment) a3).setArguments(bundle);
            childFragmentManager.a().b(R.id.map_fragment_container, (Fragment) this.mMapFragment).c();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void GuidedPointEvent(ai aiVar) {
        if (aiVar.a() == 13) {
            this.mMapFragment.a((a.e) this.guided);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void OrientationStateEvent(t tVar) {
        if (tVar.a() == 15 && ((XEagleApp) requireActivity().getApplication()).j().U() && this.drone.b().a()) {
            this.mMapFragment.b(this.drone.K().b());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            Log.i(TAG, "disConnectedEvent: ");
            if (((XEagleApp) requireActivity().getApplicationContext()).j().aF()) {
                this.mMapFragment.a((kh.b) this.graphicDrone);
            }
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void droneFootprintEvent(m mVar) {
        if (mVar.a() == 43) {
            this.mMapFragment.a(this.drone.K().a());
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxFlightPathSize() {
        return 300;
    }

    public void goToDroneLocation() {
        this.mMapFragment.d();
    }

    public void goToMyLocation() {
        this.mMapFragment.e();
    }

    @l(a = ThreadMode.MAIN)
    public void gpsEvent(p pVar) {
        if (pVar.a() == 23 && ((XEagleApp) requireActivity().getApplicationContext()).j().aF()) {
            this.mMapFragment.a((kh.b) this.graphicDrone);
            this.mMapFragment.a((a.e) this.guided);
            if (this.drone.b().a()) {
                this.mMapFragment.a(this.drone.b().b());
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void heartbeatFirst(ak akVar) {
        if (akVar.a() == 6) {
            Log.i(TAG, "heartbeatFirst: ");
            this.mMapFragment.a((kh.b) this.graphicDrone);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void heartbeatRestored(al alVar) {
        if (alVar.a() == 7) {
            Log.i(TAG, "heartbeatRestored: ");
            if (((XEagleApp) requireActivity().getApplicationContext()).j().aF()) {
                this.mMapFragment.a((kh.b) this.graphicDrone);
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void heartbeatTimeoutEvent(am amVar) {
        if (amVar.a() == 5 && ((XEagleApp) requireActivity().getApplicationContext()).j().aF()) {
            this.mMapFragment.a((kh.b) this.graphicDrone);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean isMissionDraggable();

    @l(a = ThreadMode.MAIN)
    public void missionUpdateEvent(ar arVar) {
        if (arVar.a() == 20) {
            postUpdate();
        }
    }

    public void onAttach(Context context2) {
        super.onAttach(context2);
        this.context = context2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_drone_map, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) requireActivity().getApplication();
        this.drone = xEagleApp.k();
        this.missionProxy = xEagleApp.o();
        this.home = new c(this.drone);
        this.launcher = new d(this.drone);
        this.graphicDrone = new ke.a(this.drone);
        this.guided = new b(this.drone, this.context);
        this.sensorManager = (SensorManager) this.context.getSystemService("sensor");
        updateMapFragment();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        switch (AnonymousClass3.f23270a[droneEventsType.ordinal()]) {
            case 1:
                postUpdate();
                return;
            case 2:
                Log.i(TAG, "onDroneEvent: gps");
                this.mMapFragment.a((kh.b) this.graphicDrone);
                this.mMapFragment.a((a.e) this.guided);
                if (aVar.b().a()) {
                    this.mMapFragment.a(aVar.b().b());
                    return;
                }
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.mMapFragment.a((kh.b) this.graphicDrone);
                return;
            case 7:
                this.mMapFragment.a(aVar.K().a());
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(this.sensorListener);
        }
        this.drone.b((DroneInterfaces.c) this);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mMapFragment.g();
    }

    public void onResume() {
        super.onResume();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(3);
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.registerListener(this.sensorListener, defaultSensor, 1);
        }
        this.drone.a((DroneInterfaces.c) this);
        this.mMapFragment.f();
        postUpdate();
    }

    public void onStart() {
        super.onStart();
        updateMapFragment();
    }

    public final void postUpdate() {
        this.mHandler.post(this.mUpdateMap);
    }

    public List<ef.a> projectPathIntoMap(List<ef.a> list) {
        return this.mMapFragment.a(list);
    }

    public void saveCameraPosition() {
        this.mMapFragment.g();
    }

    public abstract boolean setAutoPanMode(AutoPanMode autoPanMode);

    public void setMapPadding(int i2, int i3, int i4, int i5) {
        this.mMapFragment.a(i2, i3, i4, i5);
    }

    public void skipMarkerClickEvents(boolean z2) {
        this.mMapFragment.a(z2);
    }

    @l(a = ThreadMode.MAIN)
    public void updateLauncher(f fVar) {
        if (fVar.a().equalsIgnoreCase("home")) {
            postUpdate();
        }
    }

    public void updateMapBearing(float f2) {
        this.mMapFragment.a(f2);
    }
}
