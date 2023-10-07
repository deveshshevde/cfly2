package com.xeagle.android.login.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.flypro.core.MAVLink.a;
import com.flypro.core.MAVLink.m;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.e;
import com.flypro.core.drone.variables.aa;
import com.flypro.core.drone.variables.v;
import com.flypro.core.util.e;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.ParamTestActivity;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.common.ip.TipsDialog;
import com.xeagle.android.login.common.service.RcUdpReceiver;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.activity.GuideSelectActivity;
import com.xeagle.android.utils.w;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import dy.ab;
import dy.ak;
import dy.al;
import dy.ax;
import dy.k;
import en.a;
import io.reactivex.disposables.b;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jo.an;
import jo.ao;
import jo.aw;
import jo.ay;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public final class DeviceFragment extends Fragment implements View.OnClickListener, DroneInterfaces.e {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final String TAG;
    /* access modifiers changed from: private */
    public static volatile boolean isStartSession;
    private HashMap _$_findViewCache;
    private int ckickCount;
    private long clickTime;
    private ServiceConnection connection = new DeviceFragment$connection$1(this);
    private b disposable;
    /* access modifiers changed from: private */
    public a drone;
    private c firmwareWarnDlg;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    private boolean isBind;
    private boolean isRecHeartbeat;
    /* access modifiers changed from: private */
    public boolean isReceiveVersion;
    private boolean isRegisteBroadcast;
    private Runnable keep = new DeviceFragment$keep$1(this);
    private Runnable linkWatcher = new DeviceFragment$linkWatcher$1(this);
    /* access modifiers changed from: private */
    public View mLayoutView;
    private final BroadcastReceiver mReceiver = new DeviceFragment$mReceiver$1(this);
    private final int maxRetry = 5;
    /* access modifiers changed from: private */
    public HostManagerActivity parent;
    /* access modifiers changed from: private */
    public com.xeagle.android.utils.prefs.a prefs;
    private final Runnable runTimeOut = new DeviceFragment$runTimeOut$1(this);
    private w timeOut;
    /* access modifiers changed from: private */
    public UdpDataService udpService;
    private TipsDialog updateWarnDlg;
    private d wifiSelectDlg;
    /* access modifiers changed from: private */
    public XEagleApp xEagleApp;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final boolean isStartSession() {
            return DeviceFragment.isStartSession;
        }

        public final void setStartSession(boolean z2) {
            DeviceFragment.isStartSession = z2;
        }
    }

    static {
        Companion companion = new Companion((f) null);
        Companion = companion;
        TAG = companion.getClass().getName();
    }

    public static final /* synthetic */ com.xeagle.android.utils.prefs.a access$getPrefs$p(DeviceFragment deviceFragment) {
        com.xeagle.android.utils.prefs.a aVar = deviceFragment.prefs;
        if (aVar == null) {
            h.b("prefs");
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public final void connectToMav(int i2) {
        boolean z2;
        String str = TAG;
        hf.d.b(str, "setStatus:connectToMav: " + i2);
        if (isUsbDevice()) {
            a aVar = this.drone;
            h.a((Object) aVar);
            a.C0089a j2 = aVar.j();
            h.b(j2, "drone!!.mavClient");
            z2 = j2.a();
        } else {
            en.a aVar2 = this.drone;
            h.a((Object) aVar2);
            a.C0089a j3 = aVar2.j();
            h.b(j3, "drone!!.mavClient");
            z2 = j3.c();
        }
        if (!z2) {
            if (!isUsbDevice()) {
                XEagleApp xEagleApp2 = this.xEagleApp;
                h.a((Object) xEagleApp2);
                if (xEagleApp2.a() != null) {
                    XEagleApp xEagleApp3 = this.xEagleApp;
                    h.a((Object) xEagleApp3);
                    e a2 = xEagleApp3.a();
                    h.b(a2, "xEagleApp!!.function");
                    if (!a2.c()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            hf.d.b(str, "setStatus:connectToMav: 连接中" + i2);
            setStatus(2, 4);
            toggleDroneConnection();
            Handler handler2 = this.handler;
            h.a((Object) handler2);
            handler2.removeCallbacks(this.linkWatcher);
            Handler handler3 = this.handler;
            h.a((Object) handler3);
            handler3.postDelayed(this.linkWatcher, 1500);
            return;
        }
        Handler handler4 = this.handler;
        h.a((Object) handler4);
        handler4.removeCallbacks(this.linkWatcher);
        Handler handler5 = this.handler;
        h.a((Object) handler5);
        handler5.removeCallbacksAndMessages((Object) null);
    }

    private final void createService() {
        Intent intent = new Intent(this.parent, UdpDataService.class);
        HostManagerActivity hostManagerActivity = this.parent;
        h.a((Object) hostManagerActivity);
        this.isBind = hostManagerActivity.bindService(intent, this.connection, 1);
    }

    /* access modifiers changed from: private */
    public final l getRcVersion() {
        UdpDataService udpDataService = this.udpService;
        h.a((Object) udpDataService);
        udpDataService.send("cfly_msg c_version", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, new DeviceFragment$rcVersion$1(this));
        return l.f30254a;
    }

    private final void initView() {
        TextView textView;
        TextView textView2;
        IButton iButton;
        HostManagerActivity hostManagerActivity = this.parent;
        h.a((Object) hostManagerActivity);
        Application application = hostManagerActivity.getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        XEagleApp xEagleApp2 = (XEagleApp) application;
        this.xEagleApp = xEagleApp2;
        h.a((Object) xEagleApp2);
        this.drone = xEagleApp2.k();
        XEagleApp xEagleApp3 = this.xEagleApp;
        h.a((Object) xEagleApp3);
        com.xeagle.android.utils.prefs.a j2 = xEagleApp3.j();
        h.b(j2, "xEagleApp!!.preferences");
        this.prefs = j2;
        if (j2 == null) {
            h.b("prefs");
        }
        j2.l(true);
        View view = this.mLayoutView;
        if (!(view == null || (iButton = (IButton) view.findViewById(R.id.tv_bottom_name)) == null)) {
            iButton.setOnClickListener(this);
        }
        View view2 = this.mLayoutView;
        if (!(view2 == null || (textView2 = (TextView) view2.findViewById(R.id.tv_device_name)) == null)) {
            textView2.setOnClickListener(this);
        }
        View view3 = this.mLayoutView;
        if (!(view3 == null || (textView = (TextView) view3.findViewById(R.id.tv_device_status)) == null)) {
            textView.setOnClickListener(this);
        }
        this.timeOut = new w(this);
        com.xeagle.android.utils.prefs.a aVar = this.prefs;
        if (aVar == null) {
            h.b("prefs");
        }
        String aN = aVar.aN();
        HostManagerActivity hostManagerActivity2 = this.parent;
        h.a((Object) hostManagerActivity2);
        if (!f.a(aN, com.xeagle.android.utils.c.c(hostManagerActivity2.getApplicationContext()), true)) {
            com.xeagle.android.utils.prefs.a aVar2 = this.prefs;
            if (aVar2 == null) {
                h.b("prefs");
            }
            HostManagerActivity hostManagerActivity3 = this.parent;
            h.a((Object) hostManagerActivity3);
            aVar2.L(com.xeagle.android.utils.c.c(hostManagerActivity3.getApplicationContext()));
            com.xeagle.android.utils.prefs.a aVar3 = this.prefs;
            if (aVar3 == null) {
                h.b("prefs");
            }
            aVar3.p(false);
        }
        this.disposable = io.reactivex.f.a(2, 2, TimeUnit.SECONDS).b(lz.a.b()).a(lu.a.a()).a(new DeviceFragment$initView$1(this));
    }

    /* access modifiers changed from: private */
    public final boolean isUsbDevice() {
        XEagleApp xEagleApp2 = this.xEagleApp;
        return xEagleApp2 != null && xEagleApp2.c();
    }

    /* access modifiers changed from: private */
    public final void setStatus(int i2, int i3) {
        HostManagerActivity hostManagerActivity = this.parent;
        h.a((Object) hostManagerActivity);
        hostManagerActivity.runOnUiThread(new DeviceFragment$setStatus$1(this, i2));
    }

    /* access modifiers changed from: private */
    public final void setTv_bottom_name() {
        View view = this.mLayoutView;
        IButton iButton = view != null ? (IButton) view.findViewById(R.id.tv_bottom_name) : null;
        h.a((Object) iButton);
        iButton.setText(com.cfly.uav_pro.R.string.tv_guide_connect);
    }

    /* access modifiers changed from: private */
    public final void showConnectWifiList() {
        if (this.wifiSelectDlg == null) {
            HostManagerActivity hostManagerActivity = this.parent;
            h.a((Object) hostManagerActivity);
            String string = hostManagerActivity.getString(com.cfly.uav_pro.R.string.warning);
            HostManagerActivity hostManagerActivity2 = this.parent;
            h.a((Object) hostManagerActivity2);
            this.wifiSelectDlg = d.a(string, hostManagerActivity2.getString(com.cfly.uav_pro.R.string.warn_connect_wifi), new DeviceFragment$showConnectWifiList$1(this));
        }
        d dVar = this.wifiSelectDlg;
        h.a((Object) dVar);
        if (!dVar.isAdded()) {
            XEagleApp xEagleApp2 = this.xEagleApp;
            h.a((Object) xEagleApp2);
            com.xeagle.android.a m2 = xEagleApp2.m();
            h.b(m2, "xEagleApp!!.appState");
            if (!m2.h()) {
                XEagleApp xEagleApp3 = this.xEagleApp;
                h.a((Object) xEagleApp3);
                com.xeagle.android.a m3 = xEagleApp3.m();
                h.b(m3, "xEagleApp!!.appState");
                m3.i(true);
                d dVar2 = this.wifiSelectDlg;
                h.a((Object) dVar2);
                dVar2.show(getChildFragmentManager(), "wifi select");
            }
        }
    }

    private final void startDefaultFlightView() {
        com.xeagle.android.utils.prefs.a aVar = this.prefs;
        if (aVar == null) {
            h.b("prefs");
        }
        h.a((Object) aVar);
        aVar.d(UserGlobal.DRONE_NAME_DF808_D);
        startFlightView();
    }

    private final void startFlightView() {
        View view = this.mLayoutView;
        IButton iButton = view != null ? (IButton) view.findViewById(R.id.tv_bottom_name) : null;
        h.a((Object) iButton);
        String obj = iButton.getText().toString();
        HostManagerActivity hostManagerActivity = this.parent;
        h.a((Object) hostManagerActivity);
        Intent intent = f.a(obj, hostManagerActivity.getString(com.cfly.uav_pro.R.string.tv_guide_connect), true) ? new Intent(this.parent, GuideSelectActivity.class) : new Intent(this.parent, FlightActionActivity.class);
        intent.putExtra("isFirst", true);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void timeoutReset(int i2) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runTimeOut);
            handler2.postDelayed(this.runTimeOut, 5000);
        }
    }

    private final void unBindService() {
        if (this.isBind) {
            UdpDataService udpDataService = this.udpService;
            if (udpDataService != null) {
                h.a((Object) udpDataService);
                udpDataService.stop();
            }
            HostManagerActivity hostManagerActivity = this.parent;
            h.a((Object) hostManagerActivity);
            hostManagerActivity.unbindService(this.connection);
            this.isBind = false;
        }
    }

    /* access modifiers changed from: private */
    public final void wifiConnect() {
        StringBuilder sb = new StringBuilder();
        sb.append("wifiConnect: ---");
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.a((Object) xEagleApp2);
        e a2 = xEagleApp2.a();
        h.b(a2, "xEagleApp!!.function");
        sb.append(a2.i());
        hf.d.b("WIFI", sb.toString());
        XEagleApp xEagleApp3 = this.xEagleApp;
        h.a((Object) xEagleApp3);
        e a3 = xEagleApp3.a();
        h.b(a3, "xEagleApp!!.function");
        if (a3.c()) {
            XEagleApp xEagleApp4 = this.xEagleApp;
            h.a((Object) xEagleApp4);
            com.xeagle.android.a m2 = xEagleApp4.m();
            h.b(m2, "xEagleApp!!.appState");
            if (m2.a() == 1) {
                connectToMav(1);
            } else {
                XEagleApp xEagleApp5 = this.xEagleApp;
                h.a((Object) xEagleApp5);
                com.xeagle.android.a m3 = xEagleApp5.m();
                h.b(m3, "xEagleApp!!.appState");
                m3.a();
            }
            w wVar = this.timeOut;
            h.a((Object) wVar);
            wVar.a(2000);
            w wVar2 = this.timeOut;
            h.a((Object) wVar2);
            wVar2.a(this.maxRetry);
            w wVar3 = this.timeOut;
            h.a((Object) wVar3);
            wVar3.c();
        } else {
            XEagleApp xEagleApp6 = this.xEagleApp;
            h.a((Object) xEagleApp6);
            if (!xEagleApp6.c()) {
                com.xeagle.android.utils.prefs.a aVar = this.prefs;
                if (aVar == null) {
                    h.b("prefs");
                }
                h.a((Object) aVar);
                if (com.xeagle.android.utils.c.i(aVar.q()) < 130) {
                    com.xeagle.android.utils.prefs.a aVar2 = this.prefs;
                    if (aVar2 == null) {
                        h.b("prefs");
                    }
                    h.a((Object) aVar2);
                    if (!f.a(aVar2.q(), "N/A", true)) {
                        Log.i("FTP", "run:-======TEST WIFI2222222222 ");
                        showConnectWifiList();
                    }
                }
                Handler handler2 = this.handler;
                h.a((Object) handler2);
                handler2.post(new DeviceFragment$wifiConnect$1(this));
            }
        }
        XEagleApp xEagleApp7 = this.xEagleApp;
        h.a((Object) xEagleApp7);
        e a4 = xEagleApp7.a();
        h.b(a4, "xEagleApp!!.function");
        String i2 = a4.i();
        h.b(i2, "xEagleApp!!.function.currSSID");
        if (!f.a((CharSequence) i2, (CharSequence) "Controller", false, 2, (Object) null)) {
            XEagleApp xEagleApp8 = this.xEagleApp;
            h.a((Object) xEagleApp8);
            e a5 = xEagleApp8.a();
            h.b(a5, "xEagleApp!!.function");
            String i3 = a5.i();
            h.b(i3, "xEagleApp!!.function.currSSID");
            if (!f.a((CharSequence) i3, (CharSequence) "Ground", false, 2, (Object) null)) {
                return;
            }
        }
        Intent intent = new Intent(this.parent, RcUdpReceiver.class);
        HostManagerActivity hostManagerActivity = this.parent;
        h.a((Object) hostManagerActivity);
        hostManagerActivity.startService(intent);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void droneRcControlEvent(dy.w wVar) {
        h.d(wVar, "event");
        if (wVar.a() == 46) {
            hf.d.b("setStatus", "droneRcControlEvent: 1");
            XEagleApp xEagleApp2 = this.xEagleApp;
            h.a((Object) xEagleApp2);
            com.xeagle.android.a m2 = xEagleApp2.m();
            h.b(m2, "xEagleApp!!.appState");
            m2.d(true);
            setupStreamRatesFromPref();
            org.greenrobot.eventbus.c.a().d(new ab(65));
            en.a aVar = this.drone;
            h.a((Object) aVar);
            v E = aVar.E();
            h.b(E, "drone!!.rcControl");
            if (E.a() == 1) {
                en.a aVar2 = this.drone;
                h.a((Object) aVar2);
                aVar2.D().a();
                XEagleApp xEagleApp3 = this.xEagleApp;
                h.a((Object) xEagleApp3);
                e a2 = xEagleApp3.a();
                h.b(a2, "xEagleApp!!.function");
                String i2 = a2.i();
                h.b(i2, "xEagleApp!!.function.currSSID");
                if (!f.a((CharSequence) i2, (CharSequence) "Controller", false, 2, (Object) null)) {
                    XEagleApp xEagleApp4 = this.xEagleApp;
                    h.a((Object) xEagleApp4);
                    e a3 = xEagleApp4.a();
                    h.b(a3, "xEagleApp!!.function");
                    String i3 = a3.i();
                    h.b(i3, "xEagleApp!!.function.currSSID");
                    if (!f.a((CharSequence) i3, (CharSequence) "Ground", false, 2, (Object) null)) {
                        return;
                    }
                }
                UdpDataService udpDataService = this.udpService;
                h.a((Object) udpDataService);
                udpDataService.send("cfly_msg version", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, new DeviceFragment$droneRcControlEvent$1(this));
                return;
            }
            en.a aVar3 = this.drone;
            h.a((Object) aVar3);
            aa d2 = aVar3.d();
            h.b(d2, "drone!!.state");
            if (!f.a(d2.e().b(), "RTL", true)) {
                en.a aVar4 = this.drone;
                h.a((Object) aVar4);
                aa d3 = aVar4.d();
                h.b(d3, "drone!!.state");
                if (!f.a(d3.e().b(), "Land", true)) {
                    en.a aVar5 = this.drone;
                    h.a((Object) aVar5);
                    aVar5.D().a(4, 1410.0d);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02b4  */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void droneUpdateFirmwareEvent(dy.ab r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = "event"
            r2 = r22
            kotlin.jvm.internal.h.d(r2, r1)
            int r1 = r22.a()
            r2 = 65
            if (r1 != r2) goto L_0x02d0
            java.lang.String r1 = "setStatus"
            java.lang.String r2 = "droneUpdateFirmwareEvent: 2"
            hf.d.b(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "droneUpdateFirmwareEvent: --- receive version---"
            r1.append(r2)
            en.a r2 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r2)
            java.lang.String r2 = r2.y()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RTSP"
            hf.d.b(r2, r1)
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            java.lang.String r2 = "808"
            java.lang.String r3 = "prefs"
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = "HEART"
            java.lang.String r4 = "onDroneConnectEvent:-------- 800"
            android.util.Log.i(r1, r4)
            com.xeagle.android.utils.prefs.a r1 = r0.prefs
            if (r1 != 0) goto L_0x0054
            kotlin.jvm.internal.h.b(r3)
        L_0x0054:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            r1.d((java.lang.String) r2)
            android.os.Handler r1 = r0.handler
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$1 r2 = new com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$1
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.post(r2)
            return
        L_0x006a:
            android.content.Context r1 = r21.getContext()
            java.lang.String r1 = com.xeagle.android.utils.c.c((android.content.Context) r1)
            en.a r4 = r0.drone
            com.flypro.core.MAVLink.d.a((en.a) r4, (java.lang.String) r1)
            com.xeagle.android.login.HostManagerActivity r1 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            en.a r4 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            java.lang.String r4 = r4.y()
            r1.updateDroneFwVersionToDatabase(r4)
            com.xeagle.android.login.HostManagerActivity r1 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            en.a r4 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            java.lang.String r4 = r4.y()
            java.lang.String r5 = "drone!!.firmwareVersion"
            kotlin.jvm.internal.h.b(r4, r5)
            r6 = 6
            r7 = 7
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r4, r8)
            java.lang.String r4 = r4.substring(r6, r7)
            java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.h.b(r4, r6)
            r1.updateDroneChipTypeToDatabase(r4)
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            kotlin.jvm.internal.h.b(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r4 = "DF808"
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r9 = 0
            r10 = 2
            r11 = 0
            boolean r1 = kotlin.text.f.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r7, (boolean) r9, (int) r10, (java.lang.Object) r11)
            r7 = 2131821362(0x7f110332, float:1.9275465E38)
            java.lang.String r12 = "DF808-D"
            java.lang.String r13 = "xEagleApp!!.appState"
            r14 = 1
            if (r1 == 0) goto L_0x0161
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            kotlin.jvm.internal.h.b(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r15 = r12
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r1 = kotlin.text.f.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r15, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r1 != 0) goto L_0x0161
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            double r15 = r1.z()
            r17 = 4616302208045442662(0x4010666666666666, double:4.1)
            int r1 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r1 != 0) goto L_0x0161
            com.xeagle.android.XEagleApp r1 = r0.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.a r1 = r1.m()
            kotlin.jvm.internal.h.b(r1, r13)
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0215
            com.xeagle.android.dialogs.c r1 = r0.firmwareWarnDlg
            if (r1 != 0) goto L_0x0137
            com.xeagle.android.dialogs.r r1 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.login.HostManagerActivity r4 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            r12 = 2131821035(0x7f1101eb, float:1.9274802E38)
            java.lang.String r4 = r4.getString(r12)
            com.xeagle.android.login.HostManagerActivity r12 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r12)
            java.lang.String r7 = r12.getString(r7)
            com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$2 r12 = new com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$2
            r12.<init>(r0)
            com.xeagle.android.dialogs.c$a r12 = (com.xeagle.android.dialogs.c.a) r12
            com.xeagle.android.dialogs.c r1 = r1.a((java.lang.String) r4, (java.lang.String) r7, (com.xeagle.android.dialogs.c.a) r12)
            r0.firmwareWarnDlg = r1
        L_0x0137:
            com.xeagle.android.dialogs.c r1 = r0.firmwareWarnDlg
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0215
            com.xeagle.android.XEagleApp r1 = r0.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.a r1 = r1.m()
            kotlin.jvm.internal.h.b(r1, r13)
            r1.g(r14)
            com.xeagle.android.dialogs.c r1 = r0.firmwareWarnDlg
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            androidx.fragment.app.FragmentManager r4 = r21.getChildFragmentManager()
            java.lang.String r7 = "firmwareWarn"
            r1.show(r4, r7)
            goto L_0x0215
        L_0x0161:
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            kotlin.jvm.internal.h.b(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r1 = kotlin.text.f.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r4, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r1 == 0) goto L_0x0215
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            kotlin.jvm.internal.h.b(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r1 = kotlin.text.f.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r12, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r1 != 0) goto L_0x0215
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            double r15 = r1.z()
            r17 = 4616527388026811187(0x4011333333333333, double:4.3)
            int r1 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r1 >= 0) goto L_0x0215
            com.xeagle.android.XEagleApp r1 = r0.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.a r1 = r1.m()
            kotlin.jvm.internal.h.b(r1, r13)
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0215
            com.xeagle.android.utils.prefs.a r1 = r0.prefs
            if (r1 != 0) goto L_0x01b8
            kotlin.jvm.internal.h.b(r3)
        L_0x01b8:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            boolean r1 = r1.aM()
            if (r1 != 0) goto L_0x0215
            com.xeagle.android.login.common.ip.TipsDialog r1 = r0.updateWarnDlg
            if (r1 != 0) goto L_0x01ed
            com.xeagle.android.dialogs.r r1 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.utils.prefs.a r4 = r0.prefs
            if (r4 != 0) goto L_0x01d0
            kotlin.jvm.internal.h.b(r3)
        L_0x01d0:
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            boolean r4 = r4.aM()
            com.xeagle.android.login.HostManagerActivity r12 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r12)
            java.lang.String r7 = r12.getString(r7)
            com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$3 r12 = new com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$3
            r12.<init>(r0)
            com.xeagle.android.login.common.ip.TipsDialog$Listener r12 = (com.xeagle.android.login.common.ip.TipsDialog.Listener) r12
            com.xeagle.android.login.common.ip.TipsDialog r1 = r1.a((boolean) r4, (java.lang.String) r7, (com.xeagle.android.login.common.ip.TipsDialog.Listener) r12)
            r0.updateWarnDlg = r1
        L_0x01ed:
            com.xeagle.android.login.common.ip.TipsDialog r1 = r0.updateWarnDlg
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0215
            com.xeagle.android.XEagleApp r1 = r0.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.a r1 = r1.m()
            kotlin.jvm.internal.h.b(r1, r13)
            r1.g(r14)
            com.xeagle.android.login.common.ip.TipsDialog r1 = r0.updateWarnDlg
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            androidx.fragment.app.FragmentManager r4 = r21.getChildFragmentManager()
            java.lang.String r7 = "updateWarn"
            r1.show((androidx.fragment.app.FragmentManager) r4, (java.lang.String) r7)
        L_0x0215:
            com.xeagle.android.utils.w r1 = r0.timeOut
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            r1.b()
            r0.isReceiveVersion = r14
            en.a r1 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.y()
            kotlin.jvm.internal.h.b(r1, r5)
            r15 = r1
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r17 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            java.lang.String r16 = "DF"
            int r1 = kotlin.text.f.a((java.lang.CharSequence) r15, (java.lang.String) r16, (int) r17, (boolean) r18, (int) r19, (java.lang.Object) r20)
            en.a r4 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            java.lang.String r4 = r4.y()
            kotlin.jvm.internal.h.b(r4, r5)
            int r1 = r1 + r10
            en.a r7 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r7)
            java.lang.String r7 = r7.y()
            kotlin.jvm.internal.h.b(r7, r5)
            r15 = r7
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            java.lang.String r16 = "-v"
            int r5 = kotlin.text.f.a((java.lang.CharSequence) r15, (java.lang.String) r16, (int) r17, (boolean) r18, (int) r19, (java.lang.Object) r20)
            java.util.Objects.requireNonNull(r4, r8)
            java.lang.String r1 = r4.substring(r1, r5)
            kotlin.jvm.internal.h.b(r1, r6)
            com.xeagle.android.XEagleApp r4 = r0.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r4)
            com.flypro.core.util.e r4 = r4.a()
            java.lang.String r5 = "xEagleApp!!.function"
            kotlin.jvm.internal.h.b(r4, r5)
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0289
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = kotlin.text.f.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r4 == 0) goto L_0x0289
            goto L_0x028a
        L_0x0289:
            r2 = r1
        L_0x028a:
            com.xeagle.android.utils.prefs.a r1 = r0.prefs
            if (r1 != 0) goto L_0x0291
            kotlin.jvm.internal.h.b(r3)
        L_0x0291:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r1 = r1.j()
            boolean r1 = kotlin.text.f.a(r2, r1, r14)
            if (r1 != 0) goto L_0x02ab
            com.xeagle.android.utils.prefs.a r1 = r0.prefs
            if (r1 != 0) goto L_0x02a5
            kotlin.jvm.internal.h.b(r3)
        L_0x02a5:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            r1.d((java.lang.String) r2)
        L_0x02ab:
            com.xeagle.android.login.HostManagerActivity r1 = r0.parent
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.utils.prefs.a r2 = r0.prefs
            if (r2 != 0) goto L_0x02b7
            kotlin.jvm.internal.h.b(r3)
        L_0x02b7:
            kotlin.jvm.internal.h.a((java.lang.Object) r2)
            java.lang.String r2 = r2.j()
            r1.updateDroneTypeToDatabase(r2)
            android.os.Handler r1 = r0.handler
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$4 r2 = new com.xeagle.android.login.fragment.DeviceFragment$droneUpdateFirmwareEvent$4
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.post(r2)
        L_0x02d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.DeviceFragment.droneUpdateFirmwareEvent(dy.ab):void");
    }

    public final ServiceConnection getConnection() {
        return this.connection;
    }

    public final Runnable getKeep() {
        return this.keep;
    }

    public final Runnable getLinkWatcher() {
        return this.linkWatcher;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void heartBeat(ha.a aVar) {
        h.d(aVar, "event");
        if (aVar.a()) {
            kz.a e2 = kz.a.e();
            h.b(e2, "UsbCheckFirmwareUtils.getInstance()");
            if (e2.a()) {
                kz.a.e().f();
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public final void heartbeatFirst(ak akVar) {
        h.d(akVar, "event");
        Log.i("HEART", "onDroneConnectEvent:-------- 678: " + akVar.a());
        if (akVar.a() == 6) {
            hf.d.b("HEART", "heartbeatFirst:--- " + this.isReceiveVersion);
            ka.a.a().b().execute(new DeviceFragment$heartbeatFirst$1(this));
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public final void heartbeatRestored(al alVar) {
        h.d(alVar, "event");
        Log.i("HEART", "onDroneConnectEvent:-------- 728: " + alVar.a());
        if (alVar.a() == 7) {
            Log.i("HEART", "onDroneConnectEvent:-------- 730");
            com.flypro.core.MAVLink.b.a(this.drone, (byte) 99);
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void networkChange(ha.d dVar) {
        com.hoho.android.usb.rtsp.a f2;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runTimeOut);
        }
        if (dVar == null || !dVar.a()) {
            Handler handler3 = this.handler;
            if (handler3 != null) {
                handler3.post(this.runTimeOut);
                return;
            }
            return;
        }
        XEagleApp xEagleApp2 = this.xEagleApp;
        if (xEagleApp2 != null && (f2 = xEagleApp2.f()) != null) {
            f2.c();
        }
    }

    public void notifyTimeOut(int i2) {
        Handler handler2;
        Runnable deviceFragment$notifyTimeOut$2;
        w wVar = this.timeOut;
        if (wVar != null) {
            h.a((Object) wVar);
            if (i2 >= wVar.a()) {
                if (this.isRecHeartbeat) {
                    com.xeagle.android.utils.prefs.a aVar = this.prefs;
                    if (aVar == null) {
                        h.b("prefs");
                    }
                    h.a((Object) aVar);
                    aVar.d(UserGlobal.DRONE_NAME_DF808);
                    handler2 = this.handler;
                    h.a((Object) handler2);
                    deviceFragment$notifyTimeOut$2 = new DeviceFragment$notifyTimeOut$1(this);
                } else {
                    XEagleApp xEagleApp2 = this.xEagleApp;
                    h.a((Object) xEagleApp2);
                    e a2 = xEagleApp2.a();
                    h.b(a2, "xEagleApp!!.function");
                    String i3 = a2.i();
                    h.b(i3, "xEagleApp!!.function.currSSID");
                    if (!f.a((CharSequence) i3, (CharSequence) "Drone", false, 2, (Object) null)) {
                        XEagleApp xEagleApp3 = this.xEagleApp;
                        h.a((Object) xEagleApp3);
                        e a3 = xEagleApp3.a();
                        h.b(a3, "xEagleApp!!.function");
                        String i4 = a3.i();
                        h.b(i4, "xEagleApp!!.function.currSSID");
                        if (!f.a((CharSequence) i4, (CharSequence) "Controller", false, 2, (Object) null)) {
                            XEagleApp xEagleApp4 = this.xEagleApp;
                            h.a((Object) xEagleApp4);
                            e a4 = xEagleApp4.a();
                            h.b(a4, "xEagleApp!!.function");
                            String i5 = a4.i();
                            h.b(i5, "xEagleApp!!.function.currSSID");
                            if (!f.a((CharSequence) i5, (CharSequence) "Ground", false, 2, (Object) null)) {
                                XEagleApp xEagleApp5 = this.xEagleApp;
                                h.a((Object) xEagleApp5);
                                e a5 = xEagleApp5.a();
                                h.b(a5, "xEagleApp!!.function");
                                String i6 = a5.i();
                                h.b(i6, "xEagleApp!!.function.currSSID");
                                if (!f.a((CharSequence) i6, (CharSequence) "BRG", false, 2, (Object) null)) {
                                    handler2 = this.handler;
                                    h.a((Object) handler2);
                                    deviceFragment$notifyTimeOut$2 = new DeviceFragment$notifyTimeOut$2(this);
                                }
                            }
                        }
                    }
                    hf.d.b("CmdChannel", "notifyTimeOut:------- ");
                    return;
                }
                handler2.post(deviceFragment$notifyTimeOut$2);
            } else if (this.isRecHeartbeat) {
                Handler handler3 = this.handler;
                h.a((Object) handler3);
                handler3.post(new DeviceFragment$notifyTimeOut$3(this));
            } else {
                w wVar2 = this.timeOut;
                h.a((Object) wVar2);
                wVar2.a(false);
            }
        }
    }

    public void onAttach(Activity activity) {
        h.d(activity, "activity");
        super.onAttach(activity);
        this.parent = (HostManagerActivity) activity;
    }

    public void onClick(View view) {
        h.d(view, "v");
        int id2 = view.getId();
        if (id2 == com.cfly.uav_pro.R.id.tv_bottom_name) {
            XEagleApp xEagleApp2 = this.xEagleApp;
            h.a((Object) xEagleApp2);
            e a2 = xEagleApp2.a();
            h.b(a2, "xEagleApp!!.function");
            if (!a2.c()) {
                XEagleApp xEagleApp3 = this.xEagleApp;
                h.a((Object) xEagleApp3);
                if (!xEagleApp3.c()) {
                    hf.d.b("setStatus", "===startDefaultFlightView===619");
                    startFlightView();
                    return;
                }
            }
            en.a aVar = this.drone;
            h.a((Object) aVar);
            if (aVar.y() != null) {
                en.a aVar2 = this.drone;
                h.a((Object) aVar2);
                String y2 = aVar2.y();
                h.b(y2, "drone!!.firmwareVersion");
                if (!f.a((CharSequence) y2, (CharSequence) UserGlobal.DRONE_TYPE_DF812, false, 2, (Object) null)) {
                    en.a aVar3 = this.drone;
                    h.a((Object) aVar3);
                    String y3 = aVar3.y();
                    h.b(y3, "drone!!.firmwareVersion");
                    if (!f.a((CharSequence) y3, (CharSequence) UserGlobal.DRONE_TYPE_DF809, false, 2, (Object) null)) {
                        en.a aVar4 = this.drone;
                        h.a((Object) aVar4);
                        String y4 = aVar4.y();
                        h.b(y4, "drone!!.firmwareVersion");
                        if (!f.a((CharSequence) y4, (CharSequence) UserGlobal.DRONE_TYPE_DF808, false, 2, (Object) null)) {
                            en.a aVar5 = this.drone;
                            h.a((Object) aVar5);
                            String y5 = aVar5.y();
                            h.b(y5, "drone!!.firmwareVersion");
                            if (!f.a((CharSequence) y5, (CharSequence) UserGlobal.DRONE_TYPE_DF816, false, 2, (Object) null)) {
                                en.a aVar6 = this.drone;
                                h.a((Object) aVar6);
                                String y6 = aVar6.y();
                                h.b(y6, "drone!!.firmwareVersion");
                                if (!f.a((CharSequence) y6, (CharSequence) UserGlobal.DRONE_TYPE_DF817, false, 2, (Object) null)) {
                                    hf.d.b("setStatus", "===startDefaultFlightView===610");
                                }
                            }
                        }
                    }
                }
                startFlightView();
                return;
            }
            startDefaultFlightView();
        } else if (id2 == com.cfly.uav_pro.R.id.tv_device_status) {
            com.xeagle.android.utils.prefs.a aVar7 = this.prefs;
            if (aVar7 == null) {
                h.b("prefs");
            }
            h.a((Object) aVar7);
            if (aVar7.aH()) {
                Intent intent = new Intent(this.parent, ParamTestActivity.class);
                HostManagerActivity hostManagerActivity = this.parent;
                h.a((Object) hostManagerActivity);
                hostManagerActivity.startActivity(intent);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        View view = this.mLayoutView;
        if (view != null) {
            h.a((Object) view);
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                ((ViewGroup) parent2).removeView(this.mLayoutView);
            }
            return this.mLayoutView;
        }
        this.mLayoutView = layoutInflater.inflate(com.cfly.uav_pro.R.layout.device_fragment_layout, (ViewGroup) null);
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (!this.isRegisteBroadcast) {
            this.isRegisteBroadcast = true;
            HostManagerActivity hostManagerActivity = this.parent;
            h.a((Object) hostManagerActivity);
            hostManagerActivity.registerReceiver(this.mReceiver, intentFilter);
        }
        initView();
        createService();
        com.xeagle.android.utils.prefs.a aVar = this.prefs;
        if (aVar == null) {
            h.b("prefs");
        }
        aVar.j(false);
        if (getActivity() != null) {
            requireActivity().runOnUiThread(new DeviceFragment$onCreateView$1(this));
        }
        timeoutReset(2);
        Handler handler2 = this.handler;
        h.a((Object) handler2);
        handler2.postDelayed(this.keep, 10000);
        return this.mLayoutView;
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
        if (this.isRegisteBroadcast) {
            HostManagerActivity hostManagerActivity = this.parent;
            h.a((Object) hostManagerActivity);
            hostManagerActivity.unregisterReceiver(this.mReceiver);
            this.isRegisteBroadcast = false;
        }
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            h.a((Object) handler2);
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
        unBindService();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @org.greenrobot.eventbus.l
    public final void onDroneConnectEvent(k kVar) {
        Log.i("HEART", "onDroneConnectEvent:-------- 399");
        setupStreamRatesFromPref();
        Log.i("HEART", "onDroneConnectEvent:-------- 401");
        com.flypro.core.MAVLink.b.a(this.drone, (byte) 99);
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void reStartRtsp(an anVar) {
        timeoutReset(3);
        Log.i("HEART", "udpCreateAndConnect: 10005创建成功: " + this.isReceiveVersion);
        this.isReceiveVersion = false;
        ka.a.a().b().execute(new DeviceFragment$reStartRtsp$1(this));
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public final void receivHeartbeatEvent(ax axVar) {
        h.d(axVar, "event");
        if (axVar.a() == 67) {
            if (!this.isRecHeartbeat) {
                this.isRecHeartbeat = true;
                Log.i("HEART", "onDroneConnectEvent:-------- 1001");
                com.flypro.core.MAVLink.b.a(this.drone, (byte) 99);
                XEagleApp xEagleApp2 = this.xEagleApp;
                h.a((Object) xEagleApp2);
                com.xeagle.android.a m2 = xEagleApp2.m();
                h.b(m2, "xEagleApp!!.appState");
                if (m2.a() == 2) {
                    hf.d.b("setStatus", "DRONE_CONNECTED: 2");
                    setStatus(1, 7);
                }
            }
            if (isStartSession) {
                XEagleApp xEagleApp3 = this.xEagleApp;
                if (xEagleApp3 == null || !xEagleApp3.c()) {
                    setStatus(1, 8);
                } else {
                    timeoutReset(2);
                }
            }
        }
    }

    public final void setConnection(ServiceConnection serviceConnection) {
        h.d(serviceConnection, "<set-?>");
        this.connection = serviceConnection;
    }

    public final void setKeep(Runnable runnable) {
        h.d(runnable, "<set-?>");
        this.keep = runnable;
    }

    public final void setLinkWatcher(Runnable runnable) {
        h.d(runnable, "<set-?>");
        this.linkWatcher = runnable;
    }

    public final void setupStreamRatesFromPref() {
        com.xeagle.android.utils.prefs.a aVar = this.prefs;
        if (aVar == null) {
            h.b("prefs");
        }
        h.a((Object) aVar);
        e.a b2 = aVar.b();
        en.a aVar2 = this.drone;
        h.a((Object) aVar2);
        m.a(aVar2.j(), b2.f14210a, b2.f14211b, b2.f14212c, b2.f14213d, b2.f14214e, b2.f14215f, b2.f14216g, b2.f14217h, b2.f14218i);
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void startSessionEvent(ao aoVar) {
        h.d(aoVar, "event");
        hf.d.b("setStatus", "startSessionEvent: 1");
        Log.i("HEART", "onDroneConnectEvent:-------- 972");
        isStartSession = aoVar.a();
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.a((Object) xEagleApp2);
        com.xeagle.android.a m2 = xEagleApp2.m();
        h.b(m2, "xEagleApp!!.appState");
        if (m2.a() == 1) {
            Log.i("HEART", "onDroneConnectEvent:-------- 976");
            com.flypro.core.MAVLink.b.a(this.drone, (byte) 99);
        } else {
            XEagleApp xEagleApp3 = this.xEagleApp;
            h.a((Object) xEagleApp3);
            com.xeagle.android.a m3 = xEagleApp3.m();
            h.b(m3, "xEagleApp!!.appState");
            if (m3.a() == 2) {
                connectToMav(4);
            }
        }
        if (this.isRecHeartbeat) {
            hf.d.b("setStatus", "DRONE_CONNECTED: 1");
            XEagleApp xEagleApp4 = this.xEagleApp;
            if (xEagleApp4 == null || !xEagleApp4.c()) {
                setStatus(1, 6);
            } else {
                timeoutReset(2);
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN, b = true)
    public final void tcpConnectFailEvent(aw awVar) {
        h.d(awVar, "event");
        String a2 = awVar.a();
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.a((Object) xEagleApp2);
        com.flypro.core.util.e a3 = xEagleApp2.a();
        h.b(a3, "xEagleApp!!.function");
        String i2 = a3.i();
        h.b(i2, "xEagleApp!!.function.currSSID");
        if (f.a((CharSequence) i2, (CharSequence) "Ground", false, 2, (Object) null)) {
            h.b(a2, "failMsg");
            CharSequence charSequence = a2;
            if (f.a(charSequence, (CharSequence) "from", false, 2, (Object) null)) {
                String substring = a2.substring(f.a(charSequence, "from", 0, false, 6, (Object) null));
                h.b(substring, "(this as java.lang.String).substring(startIndex)");
                CharSequence charSequence2 = substring;
                if (!f.a(charSequence2, (CharSequence) "172.50.10", false, 2, (Object) null) && !f.a(charSequence2, (CharSequence) "192.168.10", false, 2, (Object) null)) {
                    setStatus(2, 1);
                    return;
                }
                return;
            }
            return;
        }
        XEagleApp xEagleApp3 = this.xEagleApp;
        h.a((Object) xEagleApp3);
        if (!xEagleApp3.c()) {
            setStatus(0, 3);
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN, b = true)
    public final void tcpConnectSuccess(jo.ax axVar) {
        hf.d.b("CmdChannel", "startSession: ---ip---111");
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.a((Object) xEagleApp2);
        if (!xEagleApp2.c() || !isStartSession) {
            connectToMav(3);
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void tcpErrorListener(ay ayVar) {
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.a((Object) xEagleApp2);
        com.xeagle.android.a m2 = xEagleApp2.m();
        h.b(m2, "xEagleApp!!.appState");
        if (m2.a() == 2) {
            XEagleApp xEagleApp3 = this.xEagleApp;
            h.a((Object) xEagleApp3);
            if (xEagleApp3.h() != null) {
                XEagleApp xEagleApp4 = this.xEagleApp;
                h.a((Object) xEagleApp4);
                SochipPresenter h2 = xEagleApp4.h();
                HostManagerActivity hostManagerActivity = this.parent;
                h.a((Object) hostManagerActivity);
                h2.startSession(hostManagerActivity.getApplicationContext());
                return;
            }
            return;
        }
        XEagleApp xEagleApp5 = this.xEagleApp;
        h.a((Object) xEagleApp5);
        com.xeagle.android.a m3 = xEagleApp5.m();
        h.b(m3, "xEagleApp!!.appState");
        if (m3.a() == 1) {
            XEagleApp xEagleApp6 = this.xEagleApp;
            h.a((Object) xEagleApp6);
            if (!xEagleApp6.c()) {
                XEagleApp xEagleApp7 = this.xEagleApp;
                h.a((Object) xEagleApp7);
                if (xEagleApp7.g() != null) {
                    XEagleApp xEagleApp8 = this.xEagleApp;
                    h.a((Object) xEagleApp8);
                    xEagleApp8.g().a();
                    XEagleApp xEagleApp9 = this.xEagleApp;
                    h.a((Object) xEagleApp9);
                    xEagleApp9.g().e();
                }
            }
        }
    }

    public final void toggleDroneConnection() {
        en.a aVar = this.drone;
        h.a((Object) aVar);
        aVar.j().a(14);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (r0.c() == false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN, b = true)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void usbConnectStateEvent(ha.e r8) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.h.d(r8, r0)
            com.xeagle.android.XEagleApp r0 = r7.xEagleApp
            r1 = 5
            r2 = 0
            r3 = 4
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0014
            int r0 = r8.a()
            if (r0 == r3) goto L_0x0039
        L_0x0014:
            int r0 = r8.a()
            if (r0 != r4) goto L_0x0040
            com.xeagle.android.XEagleApp r0 = r7.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            com.flypro.core.util.e r0 = r0.a()
            if (r0 == 0) goto L_0x0040
            com.xeagle.android.XEagleApp r0 = r7.xEagleApp
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            com.flypro.core.util.e r0 = r0.a()
            java.lang.String r6 = "xEagleApp!!.function"
            kotlin.jvm.internal.h.b(r0, r6)
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0040
        L_0x0039:
            r7.setStatus(r2, r3)
            r7.connectToMav(r1)
            goto L_0x0070
        L_0x0040:
            int r0 = r8.a()
            r3 = 7
            if (r0 != r3) goto L_0x004b
            r7.setStatus(r2, r1)
            goto L_0x0070
        L_0x004b:
            int r0 = r8.a()
            if (r0 == r5) goto L_0x0058
            int r0 = r8.a()
            r1 = 3
            if (r0 != r1) goto L_0x0070
        L_0x0058:
            java.lang.String r0 = "setStatus"
            java.lang.String r1 = "startSession: ---ip---111"
            hf.d.b(r0, r1)
            android.os.Handler r0 = r7.handler
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            com.xeagle.android.login.fragment.DeviceFragment$usbConnectStateEvent$1 r1 = new com.xeagle.android.login.fragment.DeviceFragment$usbConnectStateEvent$1
            r1.<init>(r7)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 500(0x1f4, double:2.47E-321)
            r0.postDelayed(r1, r2)
        L_0x0070:
            int r8 = r8.a()
            r0 = 9
            if (r8 != r0) goto L_0x0082
            boolean r8 = isStartSession
            if (r8 == 0) goto L_0x007f
            r7.setStatus(r5, r5)
        L_0x007f:
            r7.timeoutReset(r4)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.DeviceFragment.usbConnectStateEvent(ha.e):void");
    }
}
