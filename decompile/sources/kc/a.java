package kc;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.MAVLink.Messages.ApmModes;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.gcs.follow.Follow;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.activities.helpers.b;
import dy.aa;
import dy.af;
import dy.ag;
import dy.k;
import dy.s;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class a extends b implements DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    private SuperUI f13821e;

    /* renamed from: f  reason: collision with root package name */
    private Follow f13822f;

    /* renamed from: g  reason: collision with root package name */
    private String f13823g = "RELATE";

    /* renamed from: kc.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29970a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f29971b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        static {
            /*
                com.MAVLink.Messages.ApmModes[] r0 = com.MAVLink.Messages.ApmModes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29971b = r0
                r1 = 1
                com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_GUIDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f29971b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Messages.ApmModes r3 = com.MAVLink.Messages.ApmModes.FIXED_WING_GUIDED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f29971b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Messages.ApmModes r4 = com.MAVLink.Messages.ApmModes.ROVER_GUIDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f29970a = r3
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f29970a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f29970a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f29970a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f29970a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f29970a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_STOP     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kc.a.AnonymousClass1.<clinit>():void");
        }
    }

    private void a(ApmModes apmModes) {
        Fragment fragment;
        SuperUI superUI = this.f13821e;
        if (superUI == null || !superUI.f12358g.j().a()) {
            fragment = new f();
        } else {
            int i2 = AnonymousClass1.f29971b[apmModes.ordinal()];
            fragment = (i2 == 1 || i2 == 2 || i2 == 3) ? ((XEagleApp) getActivity().getApplication()).l().b() ? new h() : new i() : new f();
        }
        getChildFragmentManager().a().b(R.id.modeInfoPanel, fragment).c();
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            a(this.f12363c.d().e());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            a(this.f12363c.d().e());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStartEvent(af afVar) {
        if (afVar.a() == 32) {
            a(this.f12363c.d().e());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStopEvent(ag agVar) {
        if (agVar.a() == 33) {
            a(this.f12363c.d().e());
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4) {
            a(this.f12363c.d().e());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f13821e.f12358g.d().e());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SuperUI) {
            this.f13821e = (SuperUI) activity;
            return;
        }
        throw new IllegalStateException("Parent activity must be an instance of " + SuperUI.class.getName());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13822f = ((XEagleApp) getActivity().getApplication()).l();
        return layoutInflater.inflate(R.layout.fragment_flight_mode_panel, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        switch (AnonymousClass1.f29970a[droneEventsType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                a(aVar.d().e());
                return;
            default:
                return;
        }
    }

    public void onStart() {
        super.onStart();
        SuperUI superUI = this.f13821e;
        if (superUI != null) {
            superUI.f12358g.a((DroneInterfaces.c) this);
        }
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        SuperUI superUI = this.f13821e;
        if (superUI != null) {
            superUI.f12358g.b((DroneInterfaces.c) this);
        }
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void typeEvent(aa aaVar) {
        if (aaVar.a() == 3) {
            a(this.f12363c.d().e());
        }
    }
}
