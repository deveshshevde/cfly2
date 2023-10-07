package com.xeagle.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.aa;
import com.flypro.core.gcs.follow.Follow;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActivity;
import com.xeagle.android.dialogs.al;
import com.xeagle.android.dialogs.am;
import com.xeagle.android.fragments.h;
import dy.af;
import dy.ag;
import dy.ah;
import dy.k;
import dy.s;
import dy.y;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class c extends Fragment implements View.OnClickListener, DroneInterfaces.c, h.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f12547a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public kn.a f12548b;

    /* renamed from: c  reason: collision with root package name */
    private Follow f12549c;

    /* renamed from: d  reason: collision with root package name */
    private View f12550d;

    /* renamed from: e  reason: collision with root package name */
    private View f12551e;

    /* renamed from: f  reason: collision with root package name */
    private View f12552f;

    /* renamed from: g  reason: collision with root package name */
    private View f12553g;

    /* renamed from: h  reason: collision with root package name */
    private Button f12554h;

    /* renamed from: i  reason: collision with root package name */
    private Button f12555i;

    /* renamed from: j  reason: collision with root package name */
    private Button f12556j;

    /* renamed from: k  reason: collision with root package name */
    private Button f12557k;

    /* renamed from: l  reason: collision with root package name */
    private Button f12558l;

    /* renamed from: com.xeagle.android.fragments.c$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23261a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23262b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f23263c;

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00be */
        static {
            /*
                com.MAVLink.Messages.ApmModes[] r0 = com.MAVLink.Messages.ApmModes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23263c = r0
                r1 = 1
                com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_GUIDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23263c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Messages.ApmModes r3 = com.MAVLink.Messages.ApmModes.ROTOR_RTL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f23263c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Messages.ApmModes r4 = com.MAVLink.Messages.ApmModes.ROTOR_LAND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f23262b = r3
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ARMING     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f23262b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f23262b     // Catch:{ NoSuchFieldError -> 0x004d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r3 = 4
                int[] r4 = f23262b     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r5 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                r4 = 5
                int[] r5 = f23262b     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r6 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                r5 = 6
                int[] r6 = f23262b     // Catch:{ NoSuchFieldError -> 0x006e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r6 = f23262b     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_STOP     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r6 = f23262b     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r7 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.FOLLOW_UPDATE     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                com.flypro.core.gcs.follow.Follow$FollowStates[] r6 = com.flypro.core.gcs.follow.Follow.FollowStates.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f23261a = r6
                com.flypro.core.gcs.follow.Follow$FollowStates r7 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                int[] r1 = f23261a     // Catch:{ NoSuchFieldError -> 0x00a0 }
                com.flypro.core.gcs.follow.Follow$FollowStates r6 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_RUNNING     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                int[] r0 = f23261a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_END     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = f23261a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_INVALID_STATE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f23261a     // Catch:{ NoSuchFieldError -> 0x00be }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                int[] r0 = f23261a     // Catch:{ NoSuchFieldError -> 0x00c8 }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_NOT_ARMED     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.c.AnonymousClass3.<clinit>():void");
        }
    }

    private void a() {
        am a2 = am.a(getActivity().getApplicationContext(), getString(R.string.pref_dronie_creation_title), getString(R.string.pref_dronie_creation_message), new al.a() {
            public void a() {
                FlightActivity flightActivity;
                float b2 = c.this.f12548b.b(c.this.getActivity().getApplicationContext());
                if (b2 >= 0.0f && (flightActivity = (FlightActivity) c.this.getActivity()) != null) {
                    flightActivity.a(b2);
                }
            }

            public void b() {
            }
        }, getString(R.string.pref_warn_on_dronie_creation_key));
        if (a2 != null) {
            a2.show(getChildFragmentManager(), "Confirm dronie creation");
        }
    }

    private void b() {
        am a2 = am.a(getActivity().getApplicationContext(), getString(R.string.dialog_confirm_arming_title), getString(R.string.dialog_confirm_arming_msg), new al.a() {
            public void a() {
                com.flypro.core.MAVLink.c.a(c.this.f12547a, true);
            }

            public void b() {
            }
        }, getString(R.string.pref_warn_on_arm_key));
        if (a2 != null) {
            a2.show(getChildFragmentManager(), "Confirm arming");
        }
    }

    private void c() {
        Button button;
        d();
        int i2 = AnonymousClass3.f23263c[this.f12547a.d().e().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                button = this.f12555i;
            } else if (i2 == 3) {
                button = this.f12556j;
            } else {
                return;
            }
        } else if (this.f12547a.w().e() && !this.f12549c.b()) {
            button = this.f12557k;
        } else {
            return;
        }
        button.setActivated(true);
    }

    private void d() {
        this.f12555i.setActivated(false);
        this.f12556j.setActivated(false);
        this.f12557k.setActivated(false);
        this.f12558l.setActivated(false);
    }

    private void e() {
        Button button;
        int i2 = AnonymousClass3.f23261a[this.f12549c.e().ordinal()];
        boolean z2 = true;
        if (i2 != 1) {
            if (i2 != 2) {
                button = this.f12554h;
                z2 = false;
            } else {
                button = this.f12554h;
            }
            button.setActivated(z2);
            this.f12554h.setBackgroundResource(R.drawable.flight_action_row_bg_selector);
            return;
        }
        this.f12554h.setBackgroundColor(-65536);
    }

    private void f() {
        this.f12550d.setVisibility(8);
        this.f12551e.setVisibility(8);
        this.f12552f.setVisibility(8);
        this.f12553g.setVisibility(8);
    }

    private void g() {
        if (!this.f12547a.j().a()) {
            h();
        } else if (!this.f12547a.d().c()) {
            i();
        } else if (this.f12547a.d().d()) {
            k();
        } else {
            j();
        }
    }

    private void h() {
        f();
        this.f12550d.setVisibility(0);
    }

    private void i() {
        f();
        this.f12551e.setVisibility(0);
    }

    private void j() {
        f();
        this.f12552f.setVisibility(0);
    }

    private void k() {
        f();
        this.f12553g.setVisibility(0);
    }

    public boolean a(a aVar) {
        aa d2 = aVar.d();
        return aVar.j().a() && d2.c() && d2.d();
    }

    @l(a = ThreadMode.MAIN)
    public void armStateEvent(dy.h hVar) {
        if (hVar.a() == 9) {
            g();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            g();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            g();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStartEvent(af afVar) {
        if (afVar.a() == 32) {
            c();
            e();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStopEvent(ag agVar) {
        if (agVar.a() == 33) {
            c();
            e();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followUpdateEvent(ah ahVar) {
        if (ahVar.a() == 34) {
            c();
            e();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4) {
            c();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof FlightActivity)) {
            throw new IllegalStateException("Parent activity must be an instance of " + FlightActivity.class.getName());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007e, code lost:
        r1 = r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e9, code lost:
        r7.setLabel(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ec, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ee, code lost:
        kt.a.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = new com.google.android.gms.analytics.HitBuilders$EventBuilder
            r0.<init>()
            java.lang.String r1 = "Flight"
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = r0.setCategory(r1)
            int r7 = r7.getId()
            r1 = 0
            r2 = 0
            java.lang.String r3 = "Copter flight action button"
            switch(r7) {
                case 2131298056: goto L_0x00e0;
                case 2131298057: goto L_0x0016;
                case 2131298058: goto L_0x00d6;
                case 2131298059: goto L_0x0016;
                case 2131298060: goto L_0x0016;
                case 2131298061: goto L_0x00cc;
                case 2131298062: goto L_0x0016;
                case 2131298063: goto L_0x00c0;
                case 2131298064: goto L_0x0016;
                case 2131298065: goto L_0x0016;
                case 2131298066: goto L_0x0083;
                case 2131298067: goto L_0x006d;
                case 2131298068: goto L_0x0016;
                case 2131298069: goto L_0x005b;
                case 2131298070: goto L_0x0039;
                case 2131298071: goto L_0x0019;
                default: goto L_0x0016;
            }
        L_0x0016:
            r0 = r2
            goto L_0x00ec
        L_0x0019:
            en.a r7 = r6.f12547a
            com.flypro.core.drone.variables.aa r7 = r7.d()
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            android.content.Context r1 = r1.getApplicationContext()
            ej.a r2 = new ej.a
            r4 = 4621819117588971520(0x4024000000000000, double:10.0)
            r2.<init>(r4)
            r7.a(r1, r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            java.lang.String r1 = "Takeoff"
            goto L_0x00e9
        L_0x0039:
            com.flypro.core.gcs.follow.Follow r7 = r6.f12549c
            boolean r7 = r7.b()
            if (r7 == 0) goto L_0x0046
            com.flypro.core.gcs.follow.Follow r7 = r6.f12549c
            r7.a()
        L_0x0046:
            en.a r7 = r6.f12547a
            com.flypro.core.drone.variables.GuidedPoint r7 = r7.w()
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            r7.a((android.content.Context) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            java.lang.String r1 = "Pause"
            goto L_0x00e9
        L_0x005b:
            en.a r7 = r6.f12547a
            com.flypro.core.drone.variables.aa r7 = r7.d()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_LAND
            r7.b((com.MAVLink.Messages.ApmModes) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_LAND
            goto L_0x007e
        L_0x006d:
            en.a r7 = r6.f12547a
            com.flypro.core.drone.variables.aa r7 = r7.d()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_RTL
            r7.b((com.MAVLink.Messages.ApmModes) r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_RTL
        L_0x007e:
            java.lang.String r1 = r1.b()
            goto L_0x00e9
        L_0x0083:
            com.flypro.core.gcs.follow.Follow r7 = r6.f12549c
            r7.a()
            int[] r7 = com.xeagle.android.fragments.c.AnonymousClass3.f23261a
            com.flypro.core.gcs.follow.Follow r4 = r6.f12549c
            com.flypro.core.gcs.follow.Follow$FollowStates r4 = r4.e()
            int r4 = r4.ordinal()
            r7 = r7[r4]
            switch(r7) {
                case 1: goto L_0x00a9;
                case 2: goto L_0x00a6;
                case 3: goto L_0x00a3;
                case 4: goto L_0x00a0;
                case 5: goto L_0x009d;
                case 6: goto L_0x009a;
                default: goto L_0x0099;
            }
        L_0x0099:
            goto L_0x00ab
        L_0x009a:
            java.lang.String r2 = "FollowMe error: drone not armed"
            goto L_0x00ab
        L_0x009d:
            java.lang.String r2 = "FollowMe error: drone not connected"
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r2 = "FollowMe error: invalid state"
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r2 = "FollowMe disabled"
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r2 = "FollowMe running"
            goto L_0x00ab
        L_0x00a9:
            java.lang.String r2 = "FollowMe enabled"
        L_0x00ab:
            if (r2 == 0) goto L_0x00ec
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            r7.setLabel(r2)
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r2, r1)
            r7.show()
            goto L_0x00ec
        L_0x00c0:
            en.a r7 = r6.f12547a
            com.flypro.core.MAVLink.c.a(r7, r1)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            java.lang.String r1 = "Disarm"
            goto L_0x00e9
        L_0x00cc:
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            com.xeagle.android.activities.helpers.SuperUI r7 = (com.xeagle.android.activities.helpers.SuperUI) r7
            r7.i()
            goto L_0x00ec
        L_0x00d6:
            r6.b()
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            java.lang.String r1 = "Arm"
            goto L_0x00e9
        L_0x00e0:
            r6.a()
            com.google.android.gms.analytics.HitBuilders$EventBuilder r7 = r0.setAction(r3)
            java.lang.String r1 = "Selfie uploaded"
        L_0x00e9:
            r7.setLabel(r1)
        L_0x00ec:
            if (r0 == 0) goto L_0x00f1
            kt.a.a((com.google.android.gms.analytics.HitBuilders.EventBuilder) r0)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.c.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_copter_mission_control, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12547a = xEagleApp.k();
        this.f12549c = xEagleApp.l();
        this.f12548b = xEagleApp.o();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        switch (AnonymousClass3.f23262b[droneEventsType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                g();
                return;
            case 5:
                c();
                return;
            case 6:
            case 7:
            case 8:
                c();
                e();
                return;
            default:
                return;
        }
    }

    public void onStart() {
        super.onStart();
        g();
        c();
        e();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f12547a.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        this.f12547a.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f12550d = view.findViewById(R.id.mc_disconnected_buttons);
        this.f12551e = view.findViewById(R.id.mc_disarmed_buttons);
        this.f12552f = view.findViewById(R.id.mc_armed_buttons);
        this.f12553g = view.findViewById(R.id.mc_in_flight_buttons);
        ((Button) view.findViewById(R.id.mc_connectBtn)).setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.mc_homeBtn);
        this.f12555i = button;
        button.setOnClickListener(this);
        ((Button) view.findViewById(R.id.mc_armBtn)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.mc_disarmBtn)).setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.mc_land);
        this.f12556j = button2;
        button2.setOnClickListener(this);
        ((Button) view.findViewById(R.id.mc_takeoff)).setOnClickListener(this);
        Button button3 = (Button) view.findViewById(R.id.mc_pause);
        this.f12557k = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.mc_autoBtn);
        this.f12558l = button4;
        button4.setOnClickListener(this);
        ((Button) view.findViewById(R.id.mc_TakeoffInAutoBtn)).setOnClickListener(this);
        Button button5 = (Button) view.findViewById(R.id.mc_follow);
        this.f12554h = button5;
        button5.setOnClickListener(this);
        ((Button) view.findViewById(R.id.mc_SelfBtn)).setOnClickListener(this);
    }

    @l(a = ThreadMode.MAIN)
    public void stateEvent(y yVar) {
        if (yVar.a() == 2) {
            g();
        }
    }
}
