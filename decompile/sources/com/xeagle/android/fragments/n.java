package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.gcs.follow.Follow;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.fragments.h;
import dy.af;
import dy.ag;
import dy.ah;
import dy.k;
import dy.s;
import dy.y;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class n extends Fragment implements View.OnClickListener, DroneInterfaces.c, h.a {

    /* renamed from: a  reason: collision with root package name */
    private a f12684a;

    /* renamed from: b  reason: collision with root package name */
    private Follow f12685b;

    /* renamed from: c  reason: collision with root package name */
    private View f12686c;

    /* renamed from: d  reason: collision with root package name */
    private View f12687d;

    /* renamed from: e  reason: collision with root package name */
    private Button f12688e;

    /* renamed from: f  reason: collision with root package name */
    private Button f12689f;

    /* renamed from: g  reason: collision with root package name */
    private Button f12690g;

    /* renamed from: h  reason: collision with root package name */
    private Button f12691h;

    /* renamed from: com.xeagle.android.fragments.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23449a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23450b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f23451c;

        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|27|28|29|30|(2:31|32)|33|35|36|37|38|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|27|28|29|30|(2:31|32)|33|35|36|37|38|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b2 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23451c = r0
                r1 = 1
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23451c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f23451c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f23451c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r5 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f23451c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r6 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f23451c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_STOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r6 = f23451c     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_UPDATE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.MAVLink.Messages.ApmModes[] r6 = com.MAVLink.Messages.ApmModes.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f23450b = r6
                com.MAVLink.Messages.ApmModes r7 = com.MAVLink.Messages.ApmModes.FIXED_WING_AUTO     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r6 = f23450b     // Catch:{ NoSuchFieldError -> 0x006f }
                com.MAVLink.Messages.ApmModes r7 = com.MAVLink.Messages.ApmModes.FIXED_WING_GUIDED     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r6 = f23450b     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.MAVLink.Messages.ApmModes r7 = com.MAVLink.Messages.ApmModes.FIXED_WING_RTL     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                com.flypro.core.gcs.follow.Follow$FollowStates[] r6 = com.flypro.core.gcs.follow.Follow.FollowStates.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f23449a = r6
                com.flypro.core.gcs.follow.Follow$FollowStates r7 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x008a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008a }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x008a }
            L_0x008a:
                int[] r1 = f23449a     // Catch:{ NoSuchFieldError -> 0x0094 }
                com.flypro.core.gcs.follow.Follow$FollowStates r6 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_RUNNING     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                int[] r0 = f23449a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_END     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f23449a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_INVALID_STATE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f23449a     // Catch:{ NoSuchFieldError -> 0x00b2 }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                int[] r0 = f23449a     // Catch:{ NoSuchFieldError -> 0x00bc }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_NOT_ARMED     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.n.AnonymousClass1.<clinit>():void");
        }
    }

    private void a() {
        Button button;
        int i2 = AnonymousClass1.f23449a[this.f12685b.e().ordinal()];
        boolean z2 = true;
        if (i2 != 1) {
            if (i2 != 2) {
                button = this.f12688e;
                z2 = false;
            } else {
                button = this.f12688e;
            }
            button.setActivated(z2);
            this.f12688e.setBackgroundResource(R.drawable.flight_action_row_bg_selector);
            return;
        }
        this.f12688e.setBackgroundColor(-65536);
    }

    private void b() {
        Button button;
        c();
        int i2 = AnonymousClass1.f23450b[this.f12684a.d().e().ordinal()];
        if (i2 == 1) {
            button = this.f12691h;
        } else if (i2 != 2) {
            if (i2 == 3) {
                button = this.f12689f;
            } else {
                return;
            }
        } else if (this.f12684a.w().d() && !this.f12685b.b()) {
            button = this.f12690g;
        } else {
            return;
        }
        button.setActivated(true);
    }

    private void c() {
        this.f12689f.setActivated(false);
        this.f12690g.setActivated(false);
        this.f12691h.setActivated(false);
    }

    private void d() {
        View view;
        if (this.f12684a.j().a()) {
            this.f12686c.setVisibility(8);
            view = this.f12687d;
        } else {
            this.f12687d.setVisibility(8);
            view = this.f12686c;
        }
        view.setVisibility(0);
    }

    public boolean a(a aVar) {
        return aVar.j().a() && aVar.d().c();
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            d();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            d();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStartEvent(af afVar) {
        if (afVar.a() == 32) {
            b();
            a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStopEvent(ag agVar) {
        if (agVar.a() == 33) {
            b();
            a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followUpdateEvent(ah ahVar) {
        if (ahVar.a() == 34) {
            b();
            a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4) {
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a3, code lost:
        r1 = r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r5.setLabel(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00aa, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
        kt.a.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = new com.google.android.gms.analytics.HitBuilders$EventBuilder
            r0.<init>()
            java.lang.String r1 = "Flight"
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = r0.setCategory(r1)
            int r5 = r5.getId()
            r1 = 0
            java.lang.String r2 = "Copter flight action button"
            switch(r5) {
                case 2131298060: goto L_0x0092;
                case 2131298061: goto L_0x0088;
                case 2131298066: goto L_0x004c;
                case 2131298067: goto L_0x003a;
                case 2131298070: goto L_0x0018;
                default: goto L_0x0015;
            }
        L_0x0015:
            r0 = r1
            goto L_0x00aa
        L_0x0018:
            com.flypro.core.gcs.follow.Follow r5 = r4.f12685b
            boolean r5 = r5.b()
            if (r5 == 0) goto L_0x0025
            com.flypro.core.gcs.follow.Follow r5 = r4.f12685b
            r5.a()
        L_0x0025:
            en.a r5 = r4.f12684a
            com.flypro.core.drone.variables.GuidedPoint r5 = r5.w()
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            r5.a((android.content.Context) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r5 = r0.setAction(r2)
            java.lang.String r1 = "Pause"
            goto L_0x00a7
        L_0x003a:
            en.a r5 = r4.f12684a
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.FIXED_WING_RTL
            r5.b((com.MAVLink.Messages.ApmModes) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r5 = r0.setAction(r2)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.FIXED_WING_RTL
            goto L_0x00a3
        L_0x004c:
            com.flypro.core.gcs.follow.Follow r5 = r4.f12685b
            r5.a()
            int[] r5 = com.xeagle.android.fragments.n.AnonymousClass1.f23449a
            com.flypro.core.gcs.follow.Follow r3 = r4.f12685b
            com.flypro.core.gcs.follow.Follow$FollowStates r3 = r3.e()
            int r3 = r3.ordinal()
            r5 = r5[r3]
            switch(r5) {
                case 1: goto L_0x0072;
                case 2: goto L_0x006f;
                case 3: goto L_0x006c;
                case 4: goto L_0x0069;
                case 5: goto L_0x0066;
                case 6: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x0074
        L_0x0063:
            java.lang.String r1 = "FollowMe error: drone not armed"
            goto L_0x0074
        L_0x0066:
            java.lang.String r1 = "FollowMe error: drone not connected"
            goto L_0x0074
        L_0x0069:
            java.lang.String r1 = "FollowMe error: invalid state"
            goto L_0x0074
        L_0x006c:
            java.lang.String r1 = "FollowMe disabled"
            goto L_0x0074
        L_0x006f:
            java.lang.String r1 = "FollowMe running"
            goto L_0x0074
        L_0x0072:
            java.lang.String r1 = "FollowMe enabled"
        L_0x0074:
            com.google.android.gms.analytics.HitBuilders$EventBuilder r5 = r0.setAction(r2)
            r5.setLabel(r1)
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            r2 = 0
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r1, r2)
            r5.show()
            goto L_0x00aa
        L_0x0088:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            com.xeagle.android.activities.helpers.SuperUI r5 = (com.xeagle.android.activities.helpers.SuperUI) r5
            r5.i()
            goto L_0x00aa
        L_0x0092:
            en.a r5 = r4.f12684a
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.FIXED_WING_AUTO
            r5.b((com.MAVLink.Messages.ApmModes) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r5 = r0.setAction(r2)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.FIXED_WING_AUTO
        L_0x00a3:
            java.lang.String r1 = r1.b()
        L_0x00a7:
            r5.setLabel(r1)
        L_0x00aa:
            if (r0 == 0) goto L_0x00af
            kt.a.a((com.google.android.gms.analytics.HitBuilders.EventBuilder) r0)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.n.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12684a = xEagleApp.k();
        this.f12685b = xEagleApp.l();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_plane_mission_control, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        switch (AnonymousClass1.f23451c[droneEventsType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                d();
                return;
            case 4:
                b();
                return;
            case 5:
            case 6:
            case 7:
                b();
                a();
                return;
            default:
                return;
        }
    }

    public void onStart() {
        super.onStart();
        d();
        b();
        a();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.f12684a.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
        this.f12684a.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f12686c = view.findViewById(R.id.mc_disconnected_buttons);
        this.f12687d = view.findViewById(R.id.mc_connected_buttons);
        ((Button) view.findViewById(R.id.mc_connectBtn)).setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.mc_homeBtn);
        this.f12689f = button;
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.mc_pause);
        this.f12690g = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) view.findViewById(R.id.mc_autoBtn);
        this.f12691h = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.mc_follow);
        this.f12688e = button4;
        button4.setOnClickListener(this);
    }

    @l(a = ThreadMode.MAIN)
    public void stateEvent(y yVar) {
        if (yVar.a() == 2) {
            d();
        }
    }
}
