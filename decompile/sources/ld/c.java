package ld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.MAVLink.Messages.ApmModes;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView;
import com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView;
import en.a;
import jo.ak;
import jo.z;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class c extends Fragment implements View.OnClickListener, CardWheelHorizontalView.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ImageView f13977a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ImageView f13978b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f13979c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f13980d;

    /* renamed from: e  reason: collision with root package name */
    private WheelView f13981e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CardWheelHorizontalView f13982f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CardWheelHorizontalView f13983g;

    /* renamed from: h  reason: collision with root package name */
    private IButton f13984h;

    /* renamed from: i  reason: collision with root package name */
    private a f13985i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f13986j = "normalMode";

    /* renamed from: k  reason: collision with root package name */
    private int f13987k;

    /* renamed from: l  reason: collision with root package name */
    private int f13988l;

    /* renamed from: m  reason: collision with root package name */
    private FlightActionActivity f13989m;

    /* renamed from: n  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f13990n;

    private void a() {
        this.f13989m.runOnUiThread(new Runnable() {
            public void run() {
                c.this.f13977a.setVisibility(8);
                c.this.f13978b.setVisibility(8);
                c.this.f13979c.setVisibility(8);
                c.this.f13980d.setVisibility(8);
                c.this.f13982f.setVisibility(8);
                c.this.f13983g.setVisibility(8);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r11) {
        /*
            r10 = this;
            com.xeagle.android.activities.FlightActionActivity r0 = r10.f13989m
            android.content.Context r0 = r0.getApplicationContext()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            com.xeagle.android.utils.prefs.a r0 = r0.j()
            r10.f13990n = r0
            r0 = 2131296416(0x7f0900a0, float:1.8210748E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r10.f13977a = r0
            r0 = 2131298502(0x7f0908c6, float:1.8214979E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r10.f13978b = r0
            r0 = 2131296419(0x7f0900a3, float:1.8210754E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.f13979c = r0
            r0 = 2131298504(0x7f0908c8, float:1.8214983E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.f13980d = r0
            r0 = 2131296432(0x7f0900b0, float:1.821078E38)
            android.view.View r0 = r11.findViewById(r0)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r0 = (com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView) r0
            r10.f13982f = r0
            r0 = 2131298503(0x7f0908c7, float:1.821498E38)
            android.view.View r0 = r11.findViewById(r0)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r0 = (com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView) r0
            r10.f13983g = r0
            r0 = 2131298501(0x7f0908c5, float:1.8214977E38)
            android.view.View r0 = r11.findViewById(r0)
            com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView r0 = (com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView) r0
            r10.f13981e = r0
            ld.c$1 r1 = new ld.c$1
            r1.<init>()
            r0.setAdapter(r1)
            com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView r0 = r10.f13981e
            r1 = 39
            r0.setCurrentItem(r1)
            r0 = 2131297420(0x7f09048c, float:1.8212784E38)
            android.view.View r11 = r11.findViewById(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r11 = (com.xeagle.android.vjoystick.IWidgets.IButton) r11
            r10.f13984h = r11
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r11 = r10.f13982f
            r11.a((com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView.a) r10)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r11 = r10.f13983g
            r11.a((com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView.a) r10)
            en.a r11 = r10.f13985i
            com.flypro.core.drone.variables.a r11 = r11.t()
            r0 = 0
            if (r11 == 0) goto L_0x0094
            en.a r11 = r10.f13985i
            com.flypro.core.drone.variables.a r11 = r11.t()
            double r1 = r11.b()
            int r11 = (int) r1
            goto L_0x0095
        L_0x0094:
            r11 = 0
        L_0x0095:
            com.xeagle.android.utils.prefs.a r1 = r10.f13990n
            boolean r1 = r1.m()
            r2 = 10
            if (r1 == 0) goto L_0x0127
            com.xeagle.android.utils.prefs.a r1 = r10.f13990n
            int r1 = r1.n()
            com.xeagle.android.utils.prefs.a r3 = r10.f13990n
            int r3 = r3.o()
            en.a r4 = r10.f13985i
            com.flypro.core.drone.variables.j r4 = r4.b()
            boolean r4 = r4.a()
            if (r4 == 0) goto L_0x012f
            aq.a r4 = new aq.a
            en.a r5 = r10.f13985i
            com.flypro.core.drone.variables.h r5 = r5.L()
            double r5 = r5.a()
            en.a r7 = r10.f13985i
            com.flypro.core.drone.variables.h r7 = r7.L()
            double r7 = r7.b()
            r4.<init>(r5, r7)
            aq.a r5 = new aq.a
            en.a r6 = r10.f13985i
            com.flypro.core.drone.variables.j r6 = r6.b()
            ef.a r6 = r6.b()
            double r6 = r6.d()
            en.a r8 = r10.f13985i
            com.flypro.core.drone.variables.j r8 = r8.b()
            ef.a r8 = r8.b()
            double r8 = r8.c()
            r5.<init>(r6, r8)
            aq.c r4 = aq.b.b(r4, r5)
            double r4 = r4.a()
            int r4 = (int) r4
            int r3 = r3 - r4
            if (r3 >= r2) goto L_0x012f
            r3 = 3
            com.xeagle.android.dialogs.r r4 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r5 = r10.f13989m
            r6 = 2131823185(0x7f110a51, float:1.9279163E38)
            java.lang.String r5 = r5.getString(r6)
            com.xeagle.android.activities.FlightActionActivity r6 = r10.f13989m
            r7 = 2131821848(0x7f110518, float:1.927645E38)
            java.lang.String r6 = r6.getString(r7)
            ld.c$2 r7 = new ld.c$2
            r7.<init>()
            com.xeagle.android.dialogs.c r4 = r4.a((java.lang.String) r5, (java.lang.String) r6, (com.xeagle.android.dialogs.c.a) r7)
            androidx.fragment.app.FragmentManager r5 = r10.getChildFragmentManager()
            java.lang.String r6 = "modeWarn"
            r4.show(r5, r6)
            goto L_0x0131
        L_0x0127:
            com.xeagle.android.utils.prefs.a r0 = r10.f13990n
            int r1 = r0.aC()
            r3 = 200(0xc8, float:2.8E-43)
        L_0x012f:
            r0 = 10
        L_0x0131:
            int r4 = r1 - r11
            if (r4 < r2) goto L_0x0138
            int r11 = r11 + 11
            goto L_0x013a
        L_0x0138:
            int r11 = r11 + 1
        L_0x013a:
            ll.c r2 = new ll.c
            com.xeagle.android.activities.FlightActionActivity r4 = r10.f13989m
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "%d"
            r2.<init>(r4, r11, r1, r5)
            r1 = 2131493511(0x7f0c0287, float:1.8610504E38)
            r2.a((int) r1)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r4 = r10.f13982f
            r4.setViewAdapter(r2)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r2 = r10.f13982f
            r2.setCurrentValue(r11)
            ll.c r2 = new ll.c
            com.xeagle.android.activities.FlightActionActivity r4 = r10.f13989m
            android.content.Context r4 = r4.getApplicationContext()
            r2.<init>(r4, r0, r3, r5)
            r2.a((int) r1)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r1 = r10.f13983g
            r1.setViewAdapter(r2)
            com.xeagle.android.widgets.spinnerWheel.CardWheelHorizontalView r1 = r10.f13983g
            r1.setCurrentValue(r0)
            r10.f13987k = r11
            r10.f13988l = r0
            com.xeagle.android.vjoystick.IWidgets.IButton r11 = r10.f13984h
            r11.setOnClickListener(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ld.c.a(android.view.View):void");
    }

    public void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3) {
        int id2 = cardWheelHorizontalView.getId();
        if (id2 == R.id.altitude_spinner) {
            this.f13987k = i3;
            if (this.f13990n.m() && this.f13987k == this.f13990n.n()) {
                this.f13987k -= 2;
            }
        } else if (id2 == R.id.radius_spinner) {
            this.f13988l = i3;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13989m = (FlightActionActivity) activity;
    }

    public void onClick(View view) {
        org.greenrobot.eventbus.c a2;
        z zVar;
        if (view.getId() == R.id.ib_mode_start) {
            Log.i("Shot", "onClick:---alt-- " + this.f13987k + "---radius---" + this.f13988l);
            String str = this.f13986j;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1729768619:
                    if (str.equals("skyRocket")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1711183949:
                    if (str.equals("cometMode")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1255891158:
                    if (str.equals("normalMode")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1111063917:
                    if (str.equals("circleMode")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -758156799:
                    if (str.equals("flyAway")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -58867007:
                    if (str.equals("spiralFlight")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2 = org.greenrobot.eventbus.c.a();
                    zVar = new z(this.f13986j, 0, this.f13987k, 0);
                    break;
                case 1:
                case 2:
                case 3:
                case 5:
                    a2 = org.greenrobot.eventbus.c.a();
                    zVar = new z(this.f13986j, 0, 0, 0);
                    break;
                case 4:
                    a2 = org.greenrobot.eventbus.c.a();
                    zVar = new z(this.f13986j, this.f13988l, 0, 0);
                    break;
                default:
                    return;
            }
            a2.d(zVar);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mode_set_laout, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13985i = ((XEagleApp) this.f13989m.getApplicationContext()).k();
        a(view);
        if (!this.f13985i.d().e().equals(ApmModes.ROTOR_POSHOLD)) {
            a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void selectModel(ak akVar) {
        Runnable runnable;
        FlightActionActivity flightActionActivity;
        String a2 = akVar.a();
        a2.hashCode();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -1729768619:
                if (a2.equals("skyRocket")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1711183949:
                if (a2.equals("cometMode")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1255891158:
                if (a2.equals("normalMode")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1111063917:
                if (a2.equals("circleMode")) {
                    c2 = 3;
                    break;
                }
                break;
            case -758156799:
                if (a2.equals("flyAway")) {
                    c2 = 4;
                    break;
                }
                break;
            case -58867007:
                if (a2.equals("spiralFlight")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                a();
                flightActionActivity = this.f13989m;
                runnable = new Runnable() {
                    public void run() {
                        c.this.f13979c.setVisibility(0);
                        c.this.f13977a.setVisibility(0);
                        c.this.f13982f.setVisibility(0);
                    }
                };
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                a();
                break;
            case 4:
                a();
                flightActionActivity = this.f13989m;
                runnable = new Runnable() {
                    public void run() {
                        c.this.f13978b.setVisibility(0);
                        c.this.f13980d.setVisibility(0);
                        c.this.f13983g.setVisibility(0);
                    }
                };
                break;
            default:
                return;
        }
        flightActionActivity.runOnUiThread(runnable);
        this.f13986j = akVar.a();
    }
}
