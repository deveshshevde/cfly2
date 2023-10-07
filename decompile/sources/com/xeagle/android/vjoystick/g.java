package com.xeagle.android.vjoystick;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.MAVLink.Messages.ApmModes;
import com.blankj.utilcode.constant.PermissionConstants;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.o;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.h;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.fragments.EditorMapFragment;
import com.xeagle.android.fragments.helpers.GestureMapFragment;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.fragment.WaypointToolFragment;
import com.xeagle.android.vjoystick.utils.e;
import dy.an;
import dy.ap;
import dy.aq;
import dy.ar;
import dy.as;
import dy.aw;
import dy.be;
import dy.s;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jo.af;
import jo.bf;
import jo.f;
import jo.m;
import jo.u;
import jo.v;
import jo.x;
import kn.a;
import kn.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class g extends b implements View.OnClickListener, View.OnLongClickListener, SeekBar.OnSeekBarChangeListener, b.a {
    /* access modifiers changed from: private */
    public LinearLayout A;
    /* access modifiers changed from: private */
    public e B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    private View E;
    /* access modifiers changed from: private */
    public boolean F = false;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public boolean H = false;
    /* access modifiers changed from: private */
    public FlightActionActivity I;
    private String J = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f13029e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.flypro.core.mission.b> f13030f;

    /* renamed from: g  reason: collision with root package name */
    private List<ko.a> f13031g;

    /* renamed from: h  reason: collision with root package name */
    private EditorMapFragment f13032h;

    /* renamed from: i  reason: collision with root package name */
    private GestureMapFragment f13033i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public WaypointToolFragment f13034j;

    /* renamed from: k  reason: collision with root package name */
    private kq.e f13035k;

    /* renamed from: l  reason: collision with root package name */
    private FragmentManager f13036l;

    /* renamed from: m  reason: collision with root package name */
    private View f13037m;

    /* renamed from: n  reason: collision with root package name */
    private RadioButton f13038n;

    /* renamed from: o  reason: collision with root package name */
    private RadioButton f13039o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public IImageButton f13040p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f13041q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f13042r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public VerticalSeekBar f13043s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public IImageButton f13044t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public IImageButton f13045u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public IImageButton f13046v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public IImageButton f13047w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public IImageButton f13048x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f13049y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f13050z;

    /* renamed from: com.xeagle.android.vjoystick.g$28  reason: invalid class name */
    static /* synthetic */ class AnonymousClass28 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25259a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25260b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f25261c;

        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00bc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00da */
        static {
            /*
                com.flypro.core.mission.MissionItemType[] r0 = com.flypro.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25261c = r0
                r1 = 1
                com.flypro.core.mission.MissionItemType r2 = com.flypro.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f25261c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.mission.MissionItemType r3 = com.flypro.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f25261c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.mission.MissionItemType r4 = com.flypro.core.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f25261c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.mission.MissionItemType r5 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f25261c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.mission.MissionItemType r6 = com.flypro.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f25261c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.mission.MissionItemType r7 = com.flypro.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f25261c     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.mission.MissionItemType r8 = com.flypro.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools[] r7 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f25260b = r7
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r8 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.MARKER     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r7 = f25260b     // Catch:{ NoSuchFieldError -> 0x006f }
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r8 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.DRAW     // Catch:{ NoSuchFieldError -> 0x006f }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r7[r8] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r7 = f25260b     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r8 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.POLY     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r7[r8] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r7 = f25260b     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r8 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.TRASH     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r7[r8] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r7 = f25260b     // Catch:{ NoSuchFieldError -> 0x008d }
                com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r8 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.NONE     // Catch:{ NoSuchFieldError -> 0x008d }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r7[r8] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f25259a = r7
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r8 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPDATE     // Catch:{ NoSuchFieldError -> 0x009e }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r1 = f25259a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.RECEIVE_FAILED     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00b2 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPLOAD_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00bc }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.WAYPOINT_REACHED     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00c6 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_RESULT     // Catch:{ NoSuchFieldError -> 0x00c6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c6 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00c6 }
            L_0x00c6:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00d0 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.LAND_FINISH     // Catch:{ NoSuchFieldError -> 0x00d0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d0 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00d0 }
            L_0x00d0:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00da }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_RECEIVED     // Catch:{ NoSuchFieldError -> 0x00da }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                int[] r0 = f25259a     // Catch:{ NoSuchFieldError -> 0x00e6 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.g.AnonymousClass28.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(WaypointToolFragment.EditorTools editorTools) {
        GestureMapFragment gestureMapFragment;
        GestureMapFragment gestureMapFragment2;
        EditorMapFragment editorMapFragment = this.f13032h;
        if (editorMapFragment != null) {
            editorMapFragment.skipMarkerClickEvents(false);
        }
        int i2 = AnonymousClass28.f25260b[editorTools.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                gestureMapFragment = this.f13033i;
                if (gestureMapFragment == null) {
                    return;
                }
            } else if (i2 == 3) {
                Toast.makeText(this.I.getApplicationContext(), R.string.draw_the_survey_region, 0).show();
                gestureMapFragment = this.f13033i;
            } else if ((i2 == 4 || i2 == 5) && (gestureMapFragment2 = this.f13033i) != null) {
                gestureMapFragment2.b();
                return;
            } else {
                return;
            }
            gestureMapFragment.a();
            return;
        }
        GestureMapFragment gestureMapFragment3 = this.f13033i;
        if (gestureMapFragment3 != null) {
            gestureMapFragment3.b();
        }
        EditorMapFragment editorMapFragment2 = this.f13032h;
        if (editorMapFragment2 != null) {
            editorMapFragment2.skipMarkerClickEvents(true);
        }
    }

    private void a(String str) {
        if (!com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.GOOGLE_MAP.name()) && !com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.LBS_AMAP.name())) {
            if (com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.SYSTEM_LOC.name()).equalsIgnoreCase(DPMapProvider.SYSTEM_LOC.name())) {
                boolean equals = Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
            } else {
                return;
            }
        }
        com.xeagle.android.camera.widgets.ablum.b.a("pref_map_type", str);
    }

    private void g() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        this.f13036l = childFragmentManager;
        GestureMapFragment gestureMapFragment = (GestureMapFragment) childFragmentManager.d((int) R.id.gestureMapFragment);
        this.f13033i = gestureMapFragment;
        if (gestureMapFragment == null) {
            this.f13033i = new GestureMapFragment();
        }
        this.f13036l.a().b(R.id.gestureMapFragment, this.f13033i).c();
        this.f13032h = this.f13033i.c();
        WaypointToolFragment waypointToolFragment = (WaypointToolFragment) this.f13036l.d((int) R.id.flightActionsFragment);
        this.f13034j = waypointToolFragment;
        if (waypointToolFragment == null) {
            this.f13034j = new WaypointToolFragment();
        }
        this.f13036l.a().b(R.id.flightActionsFragment, this.f13034j).c();
        this.f13035k = (kq.e) this.f13036l.b("Item Detail Window");
        this.f13037m = this.E.findViewById(R.id.containerItemDetail);
        this.B = new e();
        RadioButton radioButton = (RadioButton) this.E.findViewById(R.id.normalWpToggle);
        this.f13038n = radioButton;
        radioButton.setOnClickListener(this);
        RadioButton radioButton2 = (RadioButton) this.E.findViewById(R.id.splineWpToggle);
        this.f13039o = radioButton2;
        radioButton2.setOnClickListener(this);
        IImageButton iImageButton = (IImageButton) this.E.findViewById(R.id.waypoint_start);
        this.f13040p = iImageButton;
        iImageButton.setOnClickListener(this);
        this.f13041q = (RelativeLayout) this.E.findViewById(R.id.seek_rl);
        this.f13043s = (VerticalSeekBar) this.E.findViewById(R.id.altitude_seek);
        this.f13042r = (TextView) this.E.findViewById(R.id.altitude_seek_tv);
        this.f13045u = (IImageButton) this.E.findViewById(R.id.ib_polyline);
        this.f13044t = (IImageButton) this.E.findViewById(R.id.ib_polypoint);
        this.f13046v = (IImageButton) this.E.findViewById(R.id.ib_map_type);
        this.f13047w = (IImageButton) this.E.findViewById(R.id.ib_user_lock);
        this.f13048x = (IImageButton) this.E.findViewById(R.id.ib_drone_lock);
        this.A = (LinearLayout) this.E.findViewById(R.id.ll_map_type);
        this.f13049y = (TextView) this.E.findViewById(R.id.mode_name);
        this.f13050z = (TextView) this.E.findViewById(R.id.drone_distance);
        this.f13043s.setOnSeekBarChangeListener(this);
        this.f13045u.setOnClickListener(this);
        this.f13044t.setOnClickListener(this);
        this.f13046v.setOnClickListener(this);
        ((IImageButton) this.E.findViewById(R.id.ib_normal_map)).setOnClickListener(this);
        ((IImageButton) this.E.findViewById(R.id.ib_sat_map)).setOnClickListener(this);
        this.f13047w.setOnClickListener(this);
        this.f13048x.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void h() {
        IImageButton iImageButton;
        boolean z2 = this.F;
        int i2 = R.drawable.ib_polypoint_nor;
        if (!z2 || this.G) {
            if (z2 || !this.G) {
                iImageButton = this.f13044t;
            } else {
                iImageButton = this.f13044t;
                i2 = R.drawable.ib_polypoint_pre;
            }
            iImageButton.setImageResource(i2);
            this.f13045u.setImageResource(R.drawable.ib_polyline_nor);
            return;
        }
        this.f13045u.setImageResource(R.drawable.ib_polyline_pre);
        this.f13044t.setImageResource(R.drawable.ib_polypoint_nor);
    }

    private void i() {
        kq.e eVar = this.f13035k;
        if (eVar != null) {
            if (this.f13037m == null) {
                eVar.dismiss();
            } else {
                this.f13036l.a().a((Fragment) this.f13035k).c();
            }
            this.f13035k = null;
        }
    }

    private void j() {
        d a2 = d.a(getString(R.string.dlg_clear_mission_title), getString(R.string.dlg_clear_mission_confirm), new d.a() {
            public void onNo() {
                g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                if (g.this.I != null) {
                    g.this.I.runOnUiThread(new Runnable() {
                        public void run() {
                            boolean unused = g.this.G = false;
                            boolean unused2 = g.this.F = false;
                            g.this.h();
                        }
                    });
                }
            }

            public void onYes() {
                g.this.k();
                g.this.f13029e.a(g.this.f13029e.f13910a);
                g.this.f13029e.f();
                if (g.this.f13029e.f13910a.a().isEmpty()) {
                    g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                    if (g.this.I != null) {
                        g.this.I.runOnUiThread(new Runnable() {
                            public void run() {
                                boolean unused = g.this.G = false;
                                boolean unused2 = g.this.F = false;
                                g.this.h();
                            }
                        });
                    }
                    o.b(g.this.f12363c);
                    g.this.f12363c.d().b(ApmModes.ROTOR_LOITER);
                    boolean unused = g.this.D = false;
                }
            }
        });
        if (a2 != null) {
            a2.show(this.I.getSupportFragmentManager(), "clearMission");
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        a aVar = this.f13029e;
        if (aVar != null) {
            aVar.f13910a.b(this.f13029e.b());
        }
    }

    public void a(List<ko.a> list) {
        if (list.isEmpty()) {
            i();
        }
        EditorMapFragment editorMapFragment = this.f13032h;
        if (editorMapFragment != null) {
            editorMapFragment.postUpdate();
        }
    }

    public void b() {
        FlightActionActivity flightActionActivity = this.I;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.B.a(new Runnable() {
                        public void run() {
                            g.this.f13040p.setVisibility(8);
                            g.this.f13041q.setVisibility(8);
                            g.this.f13044t.setVisibility(8);
                            g.this.f13045u.setVisibility(8);
                            g.this.f13046v.setVisibility(8);
                            g.this.f13047w.setVisibility(8);
                            g.this.f13048x.setVisibility(8);
                            if (g.this.H) {
                                g.this.A.setVisibility(8);
                                boolean unused = g.this.H = false;
                            }
                            g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                            boolean unused2 = g.this.G = false;
                            boolean unused3 = g.this.F = false;
                            g.this.h();
                        }
                    }, 10);
                }
            });
        }
    }

    public void c() {
        FlightActionActivity flightActionActivity = this.I;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.B.a(new Runnable() {
                        public void run() {
                            g gVar;
                            if (!g.this.I.f12359h) {
                                boolean z2 = false;
                                g.this.f13040p.setVisibility(0);
                                g.this.f13041q.setVisibility(0);
                                g.this.f13044t.setVisibility(0);
                                g.this.f13045u.setVisibility(0);
                                g.this.f13046v.setVisibility(0);
                                g.this.f13047w.setVisibility(0);
                                g.this.f13048x.setVisibility(0);
                                if (g.this.f12364d.aG() == 2) {
                                    g.this.f13034j.a(WaypointToolFragment.EditorTools.MARKER);
                                    boolean unused = g.this.F = false;
                                    gVar = g.this;
                                    z2 = true;
                                } else {
                                    g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                                    boolean unused2 = g.this.F = false;
                                    gVar = g.this;
                                }
                                boolean unused3 = gVar.G = z2;
                                g.this.h();
                            }
                        }
                    }, 1000);
                }
            });
        }
    }

    public void d() {
        k();
        a aVar = this.f13029e;
        aVar.a(aVar.f13910a);
        this.f13029e.f();
        o.b(this.f12363c);
    }

    public WaypointToolFragment.EditorTools e() {
        return this.f13034j.a();
    }

    /* access modifiers changed from: protected */
    public List<? extends com.flypro.core.mission.b> f() {
        this.f13031g.clear();
        this.f13031g.addAll(this.f13029e.b());
        if (this.f13031g.isEmpty()) {
            return null;
        }
        this.f13030f.clear();
        for (ko.a b2 : this.f13031g) {
            this.f13030f.add(b2.b());
        }
        return this.f13030f;
    }

    @l(a = ThreadMode.MAIN)
    public void landFinishEvent(an anVar) {
        a aVar;
        if (anVar.a() == 54 && (aVar = this.f13029e) != null && aVar.b().size() > 0) {
            j();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void missionRecEvent(ap apVar) {
        if (apVar.a() == 21) {
            Log.i("google", "onDroneEvent: ---mission received--->>>>");
            this.f12363c.l().a(0);
            this.D = false;
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void missionResultEvent(aq aqVar) {
        if (aqVar.a() == 61 && this.D) {
            Log.i("google", "receiveData: ack----->>>" + this.f12363c.M().a());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void missionUpdateEvent(ar arVar) {
        VerticalSeekBar verticalSeekBar;
        if (arVar.a() == 20 && (verticalSeekBar = this.f13043s) != null && this.f13029e != null && verticalSeekBar.getProgress() != ((int) this.f13029e.a().c().a())) {
            this.f13043s.setProgress((int) this.f13029e.a().c().a());
            TextView textView = this.f13042r;
            textView.setText(((int) this.f13029e.a().c().a()) + "");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void missionUpdateTimeoutEvent(as asVar) {
        c a2;
        if (asVar.a() == 63 && (a2 = r.a().a(this.I.getString(R.string.warning), this.I.getString(R.string.waypoint_send_timeout), (c.a) new c.a() {
            public void onYes() {
            }
        })) != null) {
            a2.show(getChildFragmentManager(), "time out");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4) {
            this.f13049y.setText(this.f12363c.d().e().b());
            if (this.f12363c.d().e().b().equalsIgnoreCase("Auto")) {
                this.C = true;
                this.B.a((Runnable) new Runnable() {
                    public void run() {
                        g.this.f13040p.setImageResource(R.drawable.waypoint_pause);
                    }
                });
            } else if (this.C) {
                this.C = false;
                this.B.a((Runnable) new Runnable() {
                    public void run() {
                        g.this.f13040p.setImageResource(R.drawable.waypoint_start);
                    }
                });
                k();
                a aVar = this.f13029e;
                aVar.a(aVar.f13910a);
                this.f13029e.f();
                if (this.f13029e.f13910a.a().isEmpty()) {
                    this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                    FlightActionActivity flightActionActivity = this.I;
                    if (flightActionActivity != null) {
                        flightActionActivity.runOnUiThread(new Runnable() {
                            public void run() {
                                boolean unused = g.this.G = false;
                                boolean unused2 = g.this.F = false;
                                g.this.h();
                            }
                        });
                    }
                    this.D = false;
                }
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.I = (FlightActionActivity) activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x031a, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0344, code lost:
        r11.d(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r11) {
        /*
            r10 = this;
            int r11 = r11.getId()
            java.lang.String r0 = "gps"
            r1 = 2131820689(0x7f110091, float:1.92741E38)
            r2 = 2131820624(0x7f110050, float:1.9273968E38)
            r3 = 2131822871(0x7f110917, float:1.9278526E38)
            r4 = 2131822800(0x7f1108d0, float:1.9278382E38)
            r5 = 2131821035(0x7f1101eb, float:1.9274802E38)
            java.lang.String r6 = "waypoint"
            r7 = 2131823185(0x7f110a51, float:1.9279163E38)
            r8 = 1
            r9 = 0
            switch(r11) {
                case 2131297397: goto L_0x0366;
                case 2131297417: goto L_0x0348;
                case 2131297422: goto L_0x031e;
                case 2131297426: goto L_0x0225;
                case 2131297427: goto L_0x012e;
                case 2131297435: goto L_0x010d;
                case 2131297440: goto L_0x0104;
                case 2131299846: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x036d
        L_0x0021:
            kn.a r11 = r10.f13029e
            if (r11 == 0) goto L_0x00fc
            java.util.List r11 = r11.b()
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x00fc
            boolean r11 = r10.C
            if (r11 == 0) goto L_0x0061
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.ListenerData r11 = r11.Q()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            r1 = 2131820682(0x7f11008a, float:1.9274086E38)
            java.lang.String r0 = r0.getString(r1)
            r11.e((java.lang.String) r0)
            r10.C = r9
            com.xeagle.android.vjoystick.IWidgets.IImageButton r11 = r10.f13040p
            r0 = 2131232548(0x7f080724, float:1.8081208E38)
            r11.setImageResource(r0)
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r11.b((com.MAVLink.Messages.ApmModes) r0)
            r10.D = r9
            r10.j()
            goto L_0x036d
        L_0x0061:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x00d5
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            com.MAVLink.Messages.ApmModes r11 = r11.e()
            java.lang.String r11 = r11.b()
            java.lang.String r0 = "Loiter"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00ab
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r7)
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            r2 = 2131823238(0x7f110a86, float:1.927927E38)
            java.lang.String r1 = r1.getString(r2)
            com.xeagle.android.vjoystick.g$21 r2 = new com.xeagle.android.vjoystick.g$21
            r2.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r0, (java.lang.String) r1, (com.xeagle.android.dialogs.c.a) r2)
            if (r11 == 0) goto L_0x00aa
            androidx.fragment.app.FragmentManager r0 = r10.getChildFragmentManager()
            java.lang.String r1 = "no loiter"
            r11.show(r0, r1)
        L_0x00aa:
            return
        L_0x00ab:
            com.xeagle.android.activities.FlightActionActivity r11 = r10.I
            r0 = 2131823244(0x7f110a8c, float:1.9279282E38)
            java.lang.String r11 = r11.getString(r0)
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            r1 = 2131823243(0x7f110a8b, float:1.927928E38)
            java.lang.String r0 = r0.getString(r1)
            com.xeagle.android.vjoystick.g$29 r1 = new com.xeagle.android.vjoystick.g$29
            r1.<init>()
            com.xeagle.android.dialogs.d r11 = com.xeagle.android.dialogs.d.a(r11, r0, r1)
            if (r11 == 0) goto L_0x036d
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            java.lang.String r1 = "clearMission"
            r11.show(r0, r1)
            goto L_0x036d
        L_0x00d5:
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r7)
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            r2 = 2131822874(0x7f11091a, float:1.9278532E38)
            java.lang.String r1 = r1.getString(r2)
            com.xeagle.android.vjoystick.g$30 r2 = new com.xeagle.android.vjoystick.g$30
            r2.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r0, (java.lang.String) r1, (com.xeagle.android.dialogs.c.a) r2)
            if (r11 == 0) goto L_0x036d
            androidx.fragment.app.FragmentManager r0 = r10.getChildFragmentManager()
            r11.show(r0, r6)
            goto L_0x036d
        L_0x00fc:
            r11 = 2131821628(0x7f11043c, float:1.9276005E38)
            com.blankj.utilcode.util.ToastUtils.showShort((int) r11)
            goto L_0x036d
        L_0x0104:
            com.xeagle.android.fragments.EditorMapFragment r11 = r10.f13032h
            if (r11 == 0) goto L_0x036d
            r11.goToMyLocation()
            goto L_0x036d
        L_0x010d:
            r11 = 2131821739(0x7f1104ab, float:1.927623E38)
            java.lang.String r11 = r10.getString(r11)
            r10.a((java.lang.String) r11)
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$9 r0 = new com.xeagle.android.vjoystick.g$9
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            r10.H = r9
            org.greenrobot.eventbus.c r11 = org.greenrobot.eventbus.c.a()
            jo.y r0 = new jo.y
            r0.<init>(r8)
            goto L_0x0344
        L_0x012e:
            boolean r11 = r10.G
            if (r11 == 0) goto L_0x0178
            kn.a r11 = r10.f13029e
            if (r11 == 0) goto L_0x0153
            java.util.List r11 = r11.b()
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x0153
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.ListenerData r11 = r11.Q()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r2)
            r11.e((java.lang.String) r0)
            r10.j()
            goto L_0x0174
        L_0x0153:
            kn.a r11 = r10.f13029e
            if (r11 == 0) goto L_0x0174
            java.util.List r11 = r11.b()
            int r11 = r11.size()
            if (r11 > 0) goto L_0x0174
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment r11 = r10.f13034j
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r0 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.NONE
            r11.a((com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools) r0)
            com.xeagle.android.activities.FlightActionActivity r11 = r10.I
            if (r11 == 0) goto L_0x0174
            com.xeagle.android.vjoystick.g$2 r0 = new com.xeagle.android.vjoystick.g$2
            r0.<init>()
            r11.runOnUiThread(r0)
        L_0x0174:
            r10.G = r9
            goto L_0x0221
        L_0x0178:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x01fd
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.j r11 = r11.b()
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x01b3
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            java.lang.String r1 = r1.getString(r7)
            com.xeagle.android.activities.FlightActionActivity r2 = r10.I
            java.lang.String r2 = r2.getString(r3)
            com.xeagle.android.vjoystick.g$3 r3 = new com.xeagle.android.vjoystick.g$3
            r3.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r1, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r3)
            if (r11 == 0) goto L_0x01b2
            androidx.fragment.app.FragmentManager r1 = r10.getChildFragmentManager()
            r11.show(r1, r0)
        L_0x01b2:
            return
        L_0x01b3:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            com.MAVLink.Messages.ApmModes r11 = r11.e()
            java.lang.String r11 = r11.b()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_AUTO
            java.lang.String r0 = r0.b()
            boolean r11 = r11.equalsIgnoreCase(r0)
            if (r11 == 0) goto L_0x01d1
            com.blankj.utilcode.util.ToastUtils.showShort((int) r1)
            return
        L_0x01d1:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.ListenerData r11 = r11.Q()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            r1 = 2131820656(0x7f110070, float:1.9274033E38)
            java.lang.String r0 = r0.getString(r1)
            r11.e((java.lang.String) r0)
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment r11 = r10.f13034j
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r0 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.MARKER
            r11.a((com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools) r0)
            r10.G = r8
            boolean r11 = r10.H
            if (r11 == 0) goto L_0x0221
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$4 r0 = new com.xeagle.android.vjoystick.g$4
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            r10.H = r9
            goto L_0x0221
        L_0x01fd:
            r10.G = r9
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r5)
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            java.lang.String r1 = r1.getString(r4)
            com.xeagle.android.vjoystick.g$5 r2 = new com.xeagle.android.vjoystick.g$5
            r2.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r0, (java.lang.String) r1, (com.xeagle.android.dialogs.c.a) r2)
            if (r11 == 0) goto L_0x0221
            androidx.fragment.app.FragmentManager r0 = r10.getChildFragmentManager()
            r11.show(r0, r6)
        L_0x0221:
            r10.F = r9
            goto L_0x031a
        L_0x0225:
            boolean r11 = r10.F
            if (r11 == 0) goto L_0x0272
            kn.a r11 = r10.f13029e
            if (r11 == 0) goto L_0x024d
            java.util.List r11 = r11.b()
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x024d
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.ListenerData r11 = r11.Q()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            r1 = 2131820683(0x7f11008b, float:1.9274088E38)
            java.lang.String r0 = r0.getString(r1)
            r11.e((java.lang.String) r0)
            r10.j()
            goto L_0x026e
        L_0x024d:
            kn.a r11 = r10.f13029e
            if (r11 == 0) goto L_0x026e
            java.util.List r11 = r11.b()
            int r11 = r11.size()
            if (r11 > 0) goto L_0x026e
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment r11 = r10.f13034j
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r0 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.NONE
            r11.a((com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools) r0)
            com.xeagle.android.activities.FlightActionActivity r11 = r10.I
            if (r11 == 0) goto L_0x026e
            com.xeagle.android.vjoystick.g$31 r0 = new com.xeagle.android.vjoystick.g$31
            r0.<init>()
            r11.runOnUiThread(r0)
        L_0x026e:
            r10.F = r9
            goto L_0x0318
        L_0x0272:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x02f4
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.j r11 = r11.b()
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x02ad
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            java.lang.String r1 = r1.getString(r7)
            com.xeagle.android.activities.FlightActionActivity r2 = r10.I
            java.lang.String r2 = r2.getString(r3)
            com.xeagle.android.vjoystick.g$32 r3 = new com.xeagle.android.vjoystick.g$32
            r3.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r1, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r3)
            if (r11 == 0) goto L_0x02ac
            androidx.fragment.app.FragmentManager r1 = r10.getChildFragmentManager()
            r11.show(r1, r0)
        L_0x02ac:
            return
        L_0x02ad:
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.aa r11 = r11.d()
            com.MAVLink.Messages.ApmModes r11 = r11.e()
            java.lang.String r11 = r11.b()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_AUTO
            java.lang.String r0 = r0.b()
            boolean r11 = r11.equalsIgnoreCase(r0)
            if (r11 == 0) goto L_0x02cb
            com.blankj.utilcode.util.ToastUtils.showShort((int) r1)
            return
        L_0x02cb:
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment r11 = r10.f13034j
            com.xeagle.android.vjoystick.fragment.WaypointToolFragment$EditorTools r0 = com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools.DRAW
            r11.a((com.xeagle.android.vjoystick.fragment.WaypointToolFragment.EditorTools) r0)
            en.a r11 = r10.f12363c
            com.flypro.core.drone.variables.ListenerData r11 = r11.Q()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r2)
            r11.e((java.lang.String) r0)
            r10.F = r8
            boolean r11 = r10.H
            if (r11 == 0) goto L_0x0318
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$33 r0 = new com.xeagle.android.vjoystick.g$33
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            r10.H = r9
            goto L_0x0318
        L_0x02f4:
            r10.F = r9
            com.xeagle.android.dialogs.r r11 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r0 = r10.I
            java.lang.String r0 = r0.getString(r5)
            com.xeagle.android.activities.FlightActionActivity r1 = r10.I
            java.lang.String r1 = r1.getString(r4)
            com.xeagle.android.vjoystick.g$34 r2 = new com.xeagle.android.vjoystick.g$34
            r2.<init>()
            com.xeagle.android.dialogs.c r11 = r11.a((java.lang.String) r0, (java.lang.String) r1, (com.xeagle.android.dialogs.c.a) r2)
            if (r11 == 0) goto L_0x0318
            androidx.fragment.app.FragmentManager r0 = r10.getChildFragmentManager()
            r11.show(r0, r6)
        L_0x0318:
            r10.G = r9
        L_0x031a:
            r10.h()
            goto L_0x036d
        L_0x031e:
            r11 = 2131821742(0x7f1104ae, float:1.9276236E38)
            java.lang.String r11 = r10.getString(r11)
            r10.a((java.lang.String) r11)
            android.widget.LinearLayout r11 = r10.A
            r0 = 8
            r11.setVisibility(r0)
            r10.H = r9
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$8 r0 = new com.xeagle.android.vjoystick.g$8
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            org.greenrobot.eventbus.c r11 = org.greenrobot.eventbus.c.a()
            jo.y r0 = new jo.y
            r0.<init>(r8)
        L_0x0344:
            r11.d(r0)
            goto L_0x036d
        L_0x0348:
            boolean r11 = r10.H
            if (r11 == 0) goto L_0x0359
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$6 r0 = new com.xeagle.android.vjoystick.g$6
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            r10.H = r9
            goto L_0x036d
        L_0x0359:
            com.xeagle.android.vjoystick.utils.e r11 = r10.B
            com.xeagle.android.vjoystick.g$7 r0 = new com.xeagle.android.vjoystick.g$7
            r0.<init>()
            r11.a((java.lang.Runnable) r0)
            r10.H = r8
            goto L_0x036d
        L_0x0366:
            com.xeagle.android.fragments.EditorMapFragment r11 = r10.f13032h
            if (r11 == 0) goto L_0x036d
            r11.goToDroneLocation()
        L_0x036d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.g.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.waypoint_plan_activity, viewGroup, false);
        this.E = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void onDetailDialogDismissed(f fVar) {
        this.f13029e.f13910a.a(fVar.a());
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        switch (AnonymousClass28.f25259a[droneEventsType.ordinal()]) {
            case 1:
                VerticalSeekBar verticalSeekBar = this.f13043s;
                if (verticalSeekBar != null && this.f13029e != null && verticalSeekBar.getProgress() != ((int) this.f13029e.a().c().a())) {
                    this.f13043s.setProgress((int) this.f13029e.a().c().a());
                    TextView textView = this.f13042r;
                    textView.setText(((int) this.f13029e.a().c().a()) + "");
                    return;
                }
                return;
            case 2:
            case 3:
                c a2 = r.a().a(this.I.getString(R.string.warning), this.I.getString(R.string.waypoint_send_timeout), (c.a) new c.a() {
                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(getChildFragmentManager(), "time out");
                    return;
                }
                return;
            case 4:
                aVar.d().b(ApmModes.ROTOR_LOITER);
                return;
            case 5:
                if (this.D) {
                    Log.i("google", "receiveData: ack----->>>" + aVar.M().a());
                    return;
                }
                return;
            case 6:
                a aVar2 = this.f13029e;
                if (aVar2 != null && aVar2.b().size() > 0) {
                    j();
                    return;
                }
                return;
            case 7:
                Log.i("google", "onDroneEvent: ---mission received--->>>>");
                aVar.l().a(0);
                break;
            case 8:
                this.f13049y.setText(aVar.d().e().b());
                Log.i("google", "onDroneEvent:--->>>> " + aVar.d().e().b());
                if (aVar.d().e().b().equalsIgnoreCase("Auto")) {
                    this.C = true;
                    this.B.a((Runnable) new Runnable() {
                        public void run() {
                            g.this.f13040p.setImageResource(R.drawable.waypoint_pause);
                        }
                    });
                    return;
                } else if (this.C) {
                    this.C = false;
                    this.B.a((Runnable) new Runnable() {
                        public void run() {
                            g.this.f13040p.setImageResource(R.drawable.waypoint_start);
                        }
                    });
                    k();
                    a aVar3 = this.f13029e;
                    aVar3.a(aVar3.f13910a);
                    this.f13029e.f();
                    if (this.f13029e.f13910a.a().isEmpty()) {
                        this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                        FlightActionActivity flightActionActivity = this.I;
                        if (flightActionActivity != null) {
                            flightActionActivity.runOnUiThread(new Runnable() {
                                public void run() {
                                    boolean unused = g.this.G = false;
                                    boolean unused2 = g.this.F = false;
                                    g.this.h();
                                }
                            });
                            break;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
        this.D = false;
    }

    @l(a = ThreadMode.MAIN)
    public void onEditorToolChanged(jo.l lVar) {
        this.f13029e.f13910a.b();
        a(lVar.a());
    }

    @l(a = ThreadMode.MAIN)
    public void onEditorToolLongCliked(m mVar) {
        if (AnonymousClass28.f25260b[mVar.a().ordinal()] == 4) {
            j();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void onItemClick(u uVar) {
        ko.a a2 = uVar.a();
        uVar.b();
        if (AnonymousClass28.f25260b[e().ordinal()] == 4) {
            this.f13029e.a(a2);
            this.f13029e.f13910a.b();
            if (this.f13029e.b().size() <= 0) {
                this.f13034j.a(WaypointToolFragment.EditorTools.MARKER);
            }
        } else if (this.f13029e.f13910a.d(a2)) {
            this.f13029e.f13910a.b();
        } else {
            this.f13029e.f13910a.b(a2);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void onItemLongClick(v vVar) {
        this.f13029e.f13910a.b(vVar.a());
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onListVisibilityChanged() {
    }

    public boolean onLongClick(View view) {
        view.getId();
        return false;
    }

    @l(a = ThreadMode.MAIN)
    public void onMapClickEvent(x xVar) {
        this.f13029e.f13910a.b();
        if (AnonymousClass28.f25260b[e().ordinal()] == 1) {
            if (this.f13029e.b().size() < 10) {
                this.f13029e.a(xVar.a());
                return;
            }
            c a2 = r.a().a(this.I.getString(R.string.warning), this.I.getString(R.string.max_mark_warning), (c.a) new c.a() {
                public void onYes() {
                }
            });
            if (a2 != null) {
                a2.show(getChildFragmentManager(), "mark");
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void onPathFinished(af afVar) {
        if (this.f13032h == null) {
            this.f13032h = this.f13033i.c();
        }
        List<ef.a> projectPathIntoMap = this.f13032h.projectPathIntoMap(afVar.a());
        for (ef.a next : projectPathIntoMap) {
            h L = this.f12363c.L();
            if (this.f12363c != null && L.a() != i.f27244a && L.b() != i.f27244a && eg.a.c(next, new ef.a(L.a(), L.b())).a() > 100.0d) {
                c a2 = r.a().a(this.I.getString(R.string.dialog_tips), this.I.getString(R.string.replan_warning), (c.a) new c.a() {
                    public void onYes() {
                        g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                        if (g.this.I != null) {
                            g.this.I.runOnUiThread(new Runnable() {
                                public void run() {
                                    boolean unused = g.this.G = false;
                                    boolean unused2 = g.this.F = false;
                                    g.this.h();
                                }
                            });
                        }
                    }
                });
                if (a2 != null) {
                    a2.show(getChildFragmentManager(), "waypoint");
                    return;
                }
                return;
            }
        }
        if (projectPathIntoMap.size() > 10 || this.f13029e.b().size() > 10 || projectPathIntoMap.size() + this.f13029e.b().size() > 10) {
            c a3 = r.a().a(this.I.getString(R.string.warning), this.I.getString(R.string.waypoint_limit_10), (c.a) new c.a() {
                public void onYes() {
                    g.this.f13034j.a(WaypointToolFragment.EditorTools.NONE);
                    if (g.this.I != null) {
                        g.this.I.runOnUiThread(new Runnable() {
                            public void run() {
                                boolean unused = g.this.G = false;
                                boolean unused2 = g.this.F = false;
                                g.this.h();
                            }
                        });
                    }
                }
            });
            if (a3 != null) {
                a3.show(getChildFragmentManager(), "missionLimit");
                return;
            }
            return;
        }
        int i2 = AnonymousClass28.f25260b[e().ordinal()];
        if (i2 == 2) {
            this.f13029e.c(projectPathIntoMap);
        } else if (i2 == 3) {
            if (afVar.a().size() > 2) {
                this.f13029e.b(projectPathIntoMap);
            } else {
                this.f13034j.a(WaypointToolFragment.EditorTools.POLY);
                return;
            }
        }
        if (projectPathIntoMap.size() > 0) {
            this.f13034j.a(WaypointToolFragment.EditorTools.DRAW);
            FlightActionActivity flightActionActivity = this.I;
            if (flightActionActivity != null) {
                flightActionActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        boolean unused = g.this.G = false;
                        boolean unused2 = g.this.F = true;
                        g.this.h();
                    }
                });
            }
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        if (f() != null) {
            if (i2 >= 0 && i2 <= 10) {
                i2 = 10;
            }
            this.B.a((Runnable) new Runnable() {
                public void run() {
                    String str;
                    TextView textView;
                    if (g.this.f13043s.getProgress() < 0 || g.this.f13043s.getProgress() > 10) {
                        textView = g.this.f13042r;
                        str = String.format("H: %d m", new Object[]{Integer.valueOf(g.this.f13043s.getProgress())});
                    } else {
                        textView = g.this.f13042r;
                        str = String.format("H: %d m", new Object[]{10});
                    }
                    textView.setText(str);
                }
            });
            for (com.flypro.core.mission.b bVar : f()) {
                switch (AnonymousClass28.f25261c[bVar.a().ordinal()]) {
                    case 1:
                        ((em.g) bVar).a(new ej.a((double) i2));
                        break;
                    case 2:
                        ((em.e) bVar).a(new ej.a((double) i2));
                        break;
                    case 3:
                        ((ek.b) bVar).a(new ej.d((double) i2));
                        break;
                    case 4:
                        ((em.b) bVar).a(new ej.a(10.0d));
                        break;
                    case 5:
                        ((ek.f) bVar).a(new ej.a(15.0d));
                        break;
                    case 6:
                        ((em.a) bVar).a(new ej.a((double) i2));
                        break;
                    case 7:
                        ((ek.h) bVar).a(new ej.a(5.0d));
                        break;
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        Log.i(PermissionConstants.CAMERA, "initView: 6");
        FlightActionActivity flightActionActivity = this.I;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public void run() {
                    String str;
                    TextView textView;
                    g gVar = g.this;
                    gVar.a(gVar.e());
                    if (g.this.I.f()) {
                        g.this.b();
                    } else {
                        g.this.c();
                    }
                    if (g.this.f13043s.getProgress() < 0 || g.this.f13043s.getProgress() > 5) {
                        textView = g.this.f13042r;
                        str = String.format(Locale.US, "H: %d m", new Object[]{Integer.valueOf(g.this.f13043s.getProgress())});
                    } else {
                        textView = g.this.f13042r;
                        str = String.format(Locale.US, "H: %d m", new Object[]{5});
                    }
                    textView.setText(str);
                }
            });
        }
        if (this.f13032h != null) {
            if (this.f12363c == null || !this.f12363c.j().a()) {
                this.f13032h.goToMyLocation();
            } else {
                this.f13032h.goToDroneLocation();
            }
        }
        Log.i(PermissionConstants.CAMERA, "initView: 7");
    }

    public void onStart() {
        super.onStart();
        g();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        o.b(this.f12363c);
        this.f13029e.f13910a.a((b.a) this);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStop() {
        super.onStop();
        this.f13029e.f13910a.b((b.a) this);
        k();
        a aVar = this.f13029e;
        aVar.a(aVar.f13910a);
        this.f13029e.f();
        o.b(this.f12363c);
        this.D = false;
        this.C = false;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.I.getWindow().setBackgroundDrawable((Drawable) null);
        this.f13029e = ((XEagleApp) this.I.getApplication()).o();
        this.f13031g = new ArrayList();
        this.f13030f = new ArrayList();
    }

    @l(a = ThreadMode.ASYNC)
    public void onWaypointTypeChanged(bf bfVar) {
        this.f13029e.e(bfVar.a());
    }

    @l(a = ThreadMode.MAIN)
    public void receiveFailedEvent(aw awVar) {
        c a2;
        if (awVar.a() == 66 && (a2 = r.a().a(this.I.getString(R.string.warning), this.I.getString(R.string.waypoint_send_timeout), (c.a) new c.a() {
            public void onYes() {
            }
        })) != null) {
            a2.show(getChildFragmentManager(), "time out");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void switchMapEvent(jo.ar arVar) {
        Log.i(Promotion.ACTION_VIEW, "switchMapEvent:waypoint--------->>>> " + arVar.a());
        if (this.I.f()) {
            b();
        } else {
            c();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void waypointReachedEvent(be beVar) {
        if (beVar.a() == 62) {
            this.f12363c.d().b(ApmModes.ROTOR_LOITER);
        }
    }
}
