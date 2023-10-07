package com.xeagle.android.vjoystick;

import ad.a;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.MAVLink.Messages.ApmModes;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.customeui.widget.CommonUI;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.b;
import com.flypro.core.MAVLink.n;
import com.flypro.core.drone.variables.aa;
import com.flypro.core.gcs.follow.Follow;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.utils.h;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.utils.e;
import dy.af;
import dy.ag;
import dy.ah;
import dy.al;
import dy.az;
import dy.k;
import dy.s;
import dy.y;
import java.util.Locale;
import jo.ae;
import jo.ar;
import jo.as;
import jo.av;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class StickOperateFragment extends Fragment implements View.OnClickListener {
    private static final IntentFilter F;
    private c A;
    private d B;
    private d C;
    /* access modifiers changed from: private */
    public XEagleApp D;
    private a E;
    private c G;
    private d H;
    private d I;
    /* access modifiers changed from: private */
    public com.cfly.customeui.widget.a J;
    private d K;

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f12915a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("take_off_center")) {
                if (StickOperateFragment.this.f12928n.d().i()) {
                    StickOperateFragment.this.f();
                    return;
                }
                if (StickOperateFragment.this.f12939y == null) {
                    c unused = StickOperateFragment.this.f12939y = r.a().a(StickOperateFragment.this.f12938x.getString(R.string.mission_control_takeoff), StickOperateFragment.this.f12938x.getString(R.string.no_take_off), (c.a) new c.a() {
                        public void onYes() {
                        }
                    });
                } else {
                    StickOperateFragment.this.f12939y.a(StickOperateFragment.this.f12938x.getString(R.string.mission_control_takeoff));
                    StickOperateFragment.this.f12939y.b(StickOperateFragment.this.f12938x.getString(R.string.no_take_off));
                }
                if (!StickOperateFragment.this.f12939y.isAdded()) {
                    StickOperateFragment.this.f12939y.show(StickOperateFragment.this.getChildFragmentManager(), "slide to take off");
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IImageButton f12916b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IImageButton f12917c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f12918d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f12919e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12920f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f12921g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public IImageButton f12922h;

    /* renamed from: i  reason: collision with root package name */
    private IImageButton f12923i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public TextView f12924j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public VerticalSeekBar f12925k;

    /* renamed from: l  reason: collision with root package name */
    private ConstraintLayout f12926l;

    /* renamed from: m  reason: collision with root package name */
    private Follow f12927m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public en.a f12928n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f12929o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f12930p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12931q = false;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f12932r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f12933s = true;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f12934t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f12935u;

    /* renamed from: v  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f12936v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public e f12937w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public FlightActionActivity f12938x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public c f12939y;

    /* renamed from: z  reason: collision with root package name */
    private ld.a f12940z;

    /* renamed from: com.xeagle.android.vjoystick.StickOperateFragment$17  reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24910a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f24911b;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                com.MAVLink.Messages.ApmModes[] r0 = com.MAVLink.Messages.ApmModes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24911b = r0
                r1 = 1
                com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_RTL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f24911b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Messages.ApmModes r3 = com.MAVLink.Messages.ApmModes.ROTOR_LAND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.flypro.core.gcs.follow.Follow$FollowStates[] r2 = com.flypro.core.gcs.follow.Follow.FollowStates.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f24910a = r2
                com.flypro.core.gcs.follow.Follow$FollowStates r3 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_INVALID_STATE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f24910a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.flypro.core.gcs.follow.Follow$FollowStates r2 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_RUNNING     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f24910a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.gcs.follow.Follow$FollowStates r1 = com.flypro.core.gcs.follow.Follow.FollowStates.FOLLOW_END     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.StickOperateFragment.AnonymousClass17.<clinit>():void");
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        F = intentFilter;
        intentFilter.addAction("switch_rc_gravity");
        intentFilter.addAction("take_off_center");
    }

    private void a(View view) {
        this.f12926l = (ConstraintLayout) view.findViewById(R.id.operate_fragment);
        this.f12916b = (IImageButton) view.findViewById(R.id.editor_takeOff_arm);
        this.f12923i = (IImageButton) view.findViewById(R.id.bt_shoot_mode);
        this.f12918d = view.findViewById(R.id.bt_shoot_cancel);
        this.f12917c = (IImageButton) view.findViewById(R.id.editor_land);
        this.f12922h = (IImageButton) view.findViewById(R.id.editor_rtl);
        this.f12919e = (ProgressBar) view.findViewById(R.id.mode_pb);
        this.f12920f = (TextView) view.findViewById(R.id.tv_mode_pb);
        this.f12921g = (LinearLayout) view.findViewById(R.id.mode_pb_ll);
        VerticalSeekBar verticalSeekBar = (VerticalSeekBar) view.findViewById(R.id.follow_seek);
        this.f12925k = verticalSeekBar;
        verticalSeekBar.setMax(50);
        this.f12924j = (TextView) view.findViewById(R.id.tv_follow_alt);
        this.f12925k.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                Log.i("newUI", "onStopTrackingTouch:---- " + seekBar.getProgress());
                TextView e2 = StickOperateFragment.this.f12924j;
                e2.setText(i2 + "");
                StickOperateFragment.this.f12928n.w().a(StickOperateFragment.this.f12938x.getApplicationContext(), (double) i2);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.f12916b.setOnClickListener(this);
        this.f12923i.setOnClickListener(this);
        this.f12918d.setOnClickListener(this);
        this.f12917c.setOnClickListener(this);
        this.f12922h.setOnClickListener(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r6 != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r5 = r4.D.i();
        r6 = r4.f12938x.getString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ac, code lost:
        r6 = r6.getString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b0, code lost:
        r5.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        if (r6 != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        if (r6 != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0118, code lost:
        r0.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0130, code lost:
        org.greenrobot.eventbus.c.a().d(new jo.av(r4.f12933s));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final en.a r5, final boolean r6) {
        /*
            r4 = this;
            com.flypro.core.drone.variables.aa r0 = r5.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = -1
            switch(r1) {
                case -2013398213: goto L_0x0067;
                case 81482: goto L_0x005c;
                case 2360843: goto L_0x0051;
                case 2576154: goto L_0x0046;
                case 597258008: goto L_0x003b;
                case 2018617584: goto L_0x0030;
                case 2032461078: goto L_0x0025;
                case 2143949064: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0071
        L_0x001a:
            java.lang.String r1 = "Guided"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0023
            goto L_0x0071
        L_0x0023:
            r3 = 7
            goto L_0x0071
        L_0x0025:
            java.lang.String r1 = "Alt Hold"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002e
            goto L_0x0071
        L_0x002e:
            r3 = 6
            goto L_0x0071
        L_0x0030:
            java.lang.String r1 = "Circle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0039
            goto L_0x0071
        L_0x0039:
            r3 = 5
            goto L_0x0071
        L_0x003b:
            java.lang.String r1 = "Tracker"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0044
            goto L_0x0071
        L_0x0044:
            r3 = 4
            goto L_0x0071
        L_0x0046:
            java.lang.String r1 = "Shot"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004f
            goto L_0x0071
        L_0x004f:
            r3 = 3
            goto L_0x0071
        L_0x0051:
            java.lang.String r1 = "Land"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005a
            goto L_0x0071
        L_0x005a:
            r3 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r1 = "RTL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0065
            goto L_0x0071
        L_0x0065:
            r3 = 1
            goto L_0x0071
        L_0x0067:
            java.lang.String r1 = "Loiter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r3 = 0
        L_0x0071:
            switch(r3) {
                case 0: goto L_0x011c;
                case 1: goto L_0x010c;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00cd;
                case 5: goto L_0x00b5;
                case 6: goto L_0x009a;
                case 7: goto L_0x0076;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x0130
        L_0x0076:
            r4.k()
            r4.f12933s = r2
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.xeagle.android.activities.FlightActionActivity r0 = r4.f12938x
            r1 = 2131821394(0x7f110352, float:1.927553E38)
            java.lang.String r0 = r0.getString(r1)
            r5.a((java.lang.String) r0)
            if (r6 == 0) goto L_0x0130
        L_0x008d:
            com.xeagle.android.XEagleApp r5 = r4.D
            km.a r5 = r5.i()
            com.xeagle.android.activities.FlightActionActivity r6 = r4.f12938x
            java.lang.String r6 = r6.getString(r1)
            goto L_0x00b0
        L_0x009a:
            r4.k()
            r4.f12933s = r2
            if (r6 == 0) goto L_0x0130
            com.xeagle.android.XEagleApp r5 = r4.D
            km.a r5 = r5.i()
            com.xeagle.android.activities.FlightActionActivity r6 = r4.f12938x
            r0 = 2131822762(0x7f1108aa, float:1.9278305E38)
        L_0x00ac:
            java.lang.String r6 = r6.getString(r0)
        L_0x00b0:
            r5.a(r6)
            goto L_0x0130
        L_0x00b5:
            r4.k()
            r4.f12933s = r2
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.xeagle.android.activities.FlightActionActivity r0 = r4.f12938x
            r1 = 2131820882(0x7f110152, float:1.9274491E38)
            java.lang.String r0 = r0.getString(r1)
            r5.a((java.lang.String) r0)
            if (r6 == 0) goto L_0x0130
            goto L_0x008d
        L_0x00cd:
            r4.k()
            r4.f12933s = r2
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.xeagle.android.activities.FlightActionActivity r0 = r4.f12938x
            r1 = 2131823176(0x7f110a48, float:1.9279144E38)
            java.lang.String r0 = r0.getString(r1)
            r5.a((java.lang.String) r0)
            if (r6 == 0) goto L_0x0130
            goto L_0x008d
        L_0x00e5:
            r4.k()
            r4.f12933s = r2
            if (r6 == 0) goto L_0x0130
            com.flypro.core.drone.variables.aa r5 = r5.d()
            com.xeagle.android.activities.FlightActionActivity r6 = r4.f12938x
            r0 = 2131822768(0x7f1108b0, float:1.9278317E38)
            java.lang.String r6 = r6.getString(r0)
            r5.a((java.lang.String) r6)
            goto L_0x0130
        L_0x00fd:
            r4.k()
            r4.f12930p = r2
            r4.f12933s = r2
            com.xeagle.android.vjoystick.utils.e r0 = r4.f12937w
            com.xeagle.android.vjoystick.StickOperateFragment$11 r1 = new com.xeagle.android.vjoystick.StickOperateFragment$11
            r1.<init>(r5, r6)
            goto L_0x0118
        L_0x010c:
            r4.k()
            r4.f12929o = r2
            com.xeagle.android.vjoystick.utils.e r0 = r4.f12937w
            com.xeagle.android.vjoystick.StickOperateFragment$10 r1 = new com.xeagle.android.vjoystick.StickOperateFragment$10
            r1.<init>(r5, r6)
        L_0x0118:
            r0.a((java.lang.Runnable) r1)
            goto L_0x0130
        L_0x011c:
            r4.k()
            r4.f12933s = r2
            if (r6 == 0) goto L_0x0130
            com.xeagle.android.XEagleApp r5 = r4.D
            km.a r5 = r5.i()
            com.xeagle.android.activities.FlightActionActivity r6 = r4.f12938x
            r0 = 2131822766(0x7f1108ae, float:1.9278313E38)
            goto L_0x00ac
        L_0x0130:
            org.greenrobot.eventbus.c r5 = org.greenrobot.eventbus.c.a()
            jo.av r6 = new jo.av
            boolean r0 = r4.f12933s
            r6.<init>(r0)
            r5.d(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.StickOperateFragment.a(en.a, boolean):void");
    }

    /* access modifiers changed from: private */
    public void a(Runnable runnable) {
        FlightActionActivity flightActionActivity = this.f12938x;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(runnable);
        }
    }

    private void a(String str) {
        c cVar = this.G;
        if (cVar == null) {
            this.G = r.a().a(getString(R.string.warning), str, (c.a) new c.a() {
                public void onYes() {
                }
            });
        } else {
            cVar.b(str);
        }
        c cVar2 = this.G;
        if (cVar2 != null) {
            cVar2.show(getChildFragmentManager(), "show");
        }
    }

    private void d() {
        this.f12938x.runOnUiThread(new Runnable() {
            public void run() {
                if (StickOperateFragment.this.f12924j.getVisibility() == 0) {
                    StickOperateFragment.this.f12924j.setVisibility(8);
                    StickOperateFragment.this.f12925k.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void e() {
        org.greenrobot.eventbus.c.a().d(new ae(true));
        if (this.f12940z == null) {
            this.f12940z = new ld.a();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("nowFlyType", this.f12934t);
        bundle.putBoolean("isSetFlyModel", this.f12935u);
        this.f12940z.setArguments(bundle);
        if (!this.f12940z.isAdded()) {
            this.f12940z.show(getChildFragmentManager(), "showMode");
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.H == null) {
            this.H = d.a(getString(R.string.mission_control_takeoff), getString(R.string.slide_take_off), new d.a() {
                public void onNo() {
                    StickOperateFragment.this.f12937w.a((Runnable) new Runnable() {
                        public void run() {
                            StickOperateFragment.this.f12916b.setImageResource(R.drawable.newui_one_key_fly);
                        }
                    });
                }

                public void onYes() {
                    Log.i("newUI", "onYes: ------take off");
                    StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_take_off));
                    com.flypro.core.MAVLink.c.a(StickOperateFragment.this.f12928n, true);
                    StickOperateFragment.this.f12937w.a(new Runnable() {
                        public void run() {
                            n.a(StickOperateFragment.this.f12928n, new ej.a(2.0d));
                        }
                    }, 1500);
                }
            });
        }
        if (!this.H.isAdded()) {
            this.H.show(getChildFragmentManager(), "slide to take off");
        }
    }

    private void g() {
        if (!h.d(this.f12928n)) {
            if (this.I == null) {
                this.I = d.a(this.f12938x.getString(R.string.string_mode_rtl), getString(R.string.drone_cancel_rtl), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        if (h.d(StickOperateFragment.this.f12928n)) {
                            b.a(StickOperateFragment.this.f12928n, (byte) 67);
                        }
                        StickOperateFragment.this.f12928n.d().b(ApmModes.ROTOR_LOITER);
                        boolean unused = StickOperateFragment.this.f12929o = false;
                        boolean unused2 = StickOperateFragment.this.f12933s = true;
                        StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_rtl_cancel));
                    }
                });
            }
            if (!this.I.isAdded()) {
                this.I.show(getChildFragmentManager(), "Confirm rtl");
            }
        } else if (this.J == null) {
            this.J = CommonUI.a((Context) this.f12938x, getView(), this.f12938x.getString(R.string.comfirm_cancel_low_rtl), (CommonUI.d) new CommonUI.d() {
                public void a() {
                    if (h.d(StickOperateFragment.this.f12928n)) {
                        b.a(StickOperateFragment.this.f12928n, (byte) 67);
                    }
                    StickOperateFragment.this.f12928n.d().a(StickOperateFragment.this.f12938x.getString(R.string.action_slide_cancel_rtl));
                    StickOperateFragment.this.f12928n.d().b(ApmModes.ROTOR_LOITER);
                    boolean unused = StickOperateFragment.this.f12929o = false;
                    boolean unused2 = StickOperateFragment.this.f12933s = true;
                    StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_rtl_cancel));
                    com.cfly.customeui.widget.a unused3 = StickOperateFragment.this.J = null;
                }

                public void a(Object... objArr) {
                    TextView textView;
                    int i2;
                    StickOperateFragment stickOperateFragment;
                    String str;
                    TextView textView2;
                    if (objArr[0] != null && (objArr[0] instanceof TextView)) {
                        if (StickOperateFragment.this.f12928n.d().h().equalsIgnoreCase("010")) {
                            textView2 = objArr[0];
                            str = StickOperateFragment.this.f12938x.getString(R.string.comfirm_cancel_low_rtl);
                        } else {
                            textView2 = objArr[0];
                            str = StickOperateFragment.this.getString(R.string.drone_cancel_rtl);
                        }
                        textView2.setText(str);
                    }
                    if (objArr[1] != null && (objArr[1] instanceof TextView)) {
                        if (StickOperateFragment.this.f12928n.d().h().equalsIgnoreCase("010")) {
                            textView = objArr[1];
                            stickOperateFragment = StickOperateFragment.this;
                            i2 = R.string.swipe_cancel_low_rtl;
                        } else {
                            textView = objArr[1];
                            stickOperateFragment = StickOperateFragment.this;
                            i2 = R.string.swipe_cancel_rtl;
                        }
                        textView.setText(stickOperateFragment.getString(i2));
                    }
                }

                public void b() {
                    if (StickOperateFragment.this.J != null) {
                        com.cfly.customeui.widget.a unused = StickOperateFragment.this.J = null;
                    }
                }
            });
        }
    }

    private void h() {
        if (this.f12928n.d().h().equalsIgnoreCase("100")) {
            CommonUI.a((Context) this.f12938x, getView(), Integer.valueOf(R.string.not_cancel_land), this.f12938x.getString(R.string.i_see), (CommonUI.b) new CommonUI.b() {
                public void a() {
                }
            });
            return;
        }
        if (this.K == null) {
            this.K = d.a(this.f12938x.getString(R.string.mission_control_land), getString(R.string.drone_cancel_land), new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    ApmModes apmModes;
                    aa aaVar;
                    if (StickOperateFragment.this.f12932r) {
                        StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_land_loiter));
                        aaVar = StickOperateFragment.this.f12928n.d();
                        apmModes = ApmModes.ROTOR_LOITER;
                    } else {
                        StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_land_alt));
                        aaVar = StickOperateFragment.this.f12928n.d();
                        apmModes = ApmModes.ROTOR_ALT_HOLD;
                    }
                    aaVar.b(apmModes);
                    boolean unused = StickOperateFragment.this.f12930p = false;
                }
            });
        }
        if (!this.K.isAdded()) {
            this.K.show(getChildFragmentManager(), "Confirm land");
        }
    }

    private void i() {
        IImageButton iImageButton;
        j();
        int i2 = AnonymousClass17.f24911b[this.f12928n.d().e().ordinal()];
        if (i2 == 1) {
            iImageButton = this.f12922h;
        } else if (i2 == 2) {
            iImageButton = this.f12917c;
        } else {
            return;
        }
        iImageButton.setActivated(true);
    }

    private void j() {
        this.f12917c.setActivated(false);
    }

    private void k() {
        this.f12929o = false;
        this.f12930p = false;
        this.f12937w.a((Runnable) new Runnable() {
            public void run() {
                StickOperateFragment.this.f12917c.setImageResource(R.drawable.newui_fly_down);
                StickOperateFragment.this.f12922h.setImageResource(R.drawable.newui_one_key_back);
            }
        });
    }

    private void l() {
        if (this.f12928n.d().c()) {
            m();
        } else {
            n();
        }
    }

    private void m() {
        o();
        this.f12937w.a((Runnable) new Runnable() {
            public void run() {
                StickOperateFragment.this.f12917c.setVisibility(0);
                StickOperateFragment.this.f12922h.setVisibility(0);
                StickOperateFragment.this.f12922h.setClickable(true);
                if (!StickOperateFragment.this.f12928n.d().e().b().equalsIgnoreCase("RTL")) {
                    StickOperateFragment.this.f12922h.setImageResource(R.drawable.newui_one_key_back);
                }
            }
        });
    }

    private void n() {
        o();
        this.f12937w.a((Runnable) new Runnable() {
            public void run() {
                StickOperateFragment.this.f12916b.setVisibility(0);
                StickOperateFragment.this.f12922h.setImageResource(R.drawable.newui_one_key_back);
            }
        });
    }

    private void o() {
        this.f12937w.a((Runnable) new Runnable() {
            public void run() {
                StickOperateFragment.this.f12916b.setVisibility(4);
                StickOperateFragment.this.f12916b.setImageResource(R.drawable.newui_one_key_fly);
                StickOperateFragment.this.f12917c.setVisibility(8);
            }
        });
    }

    public void a() {
        if (this.f12927m != null) {
            if (this.f12928n.d().e().b().equalsIgnoreCase("Guided")) {
                Log.i("newUI", "updateFollowView:---- " + this.f12927m.e());
                int i2 = AnonymousClass17.f24910a[this.f12927m.e().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    if (this.f12924j.getVisibility() == 8) {
                        int i3 = 50;
                        this.f12925k.setMax(50);
                        int b2 = (int) this.f12928n.t().b();
                        if (b2 < 5) {
                            i3 = 5;
                        } else if (b2 <= 50) {
                            i3 = b2;
                        }
                        this.f12924j.setVisibility(0);
                        this.f12925k.setVisibility(0);
                        this.f12925k.setProgress(i3);
                        this.f12924j.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(i3)}));
                        return;
                    }
                    return;
                }
            } else if (this.f12927m.b()) {
                this.f12927m.a();
            }
        }
        d();
    }

    public void a(int i2) {
        this.f12934t = i2;
    }

    public void a(final boolean z2) {
        a((Runnable) new Runnable() {
            public void run() {
                if (z2) {
                    if (StickOperateFragment.this.f12934t != 2) {
                        StickOperateFragment.this.f12921g.setVisibility(0);
                    }
                    StickOperateFragment.this.f12918d.setVisibility(0);
                    return;
                }
                if (StickOperateFragment.this.f12918d.getVisibility() == 0 && !StickOperateFragment.this.f12935u && !StickOperateFragment.this.f12928n.d().e().equals(ApmModes.ROTOR_AUTO)) {
                    StickOperateFragment.this.f12918d.setVisibility(8);
                }
                StickOperateFragment.this.f12921g.setVisibility(8);
            }
        });
    }

    public void a(boolean z2, int i2) {
        Log.i("SET_MODEL", "setSetModel: =====FLAG===" + i2);
        this.f12935u = z2;
    }

    public void a(boolean z2, int i2, int i3) {
        int i4;
        IImageButton iImageButton;
        if (z2) {
            this.f12918d.setVisibility(0);
            Log.i("newUI", "updateShootView: ---type--" + i2);
            switch (i2) {
                case 0:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.newui_op_ui_selector;
                    break;
                case 1:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_follow_selected;
                    break;
                case 2:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_waypoint_selected;
                    break;
                case 3:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_rocket_selected;
                    break;
                case 4:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_dronie_selected;
                    break;
                case 5:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_helix_selected;
                    break;
                case 6:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_boomrang_selected;
                    break;
                case 7:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.iv_circle_selected;
                    break;
                case 8:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.newui_vision_selector;
                    break;
                case 9:
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 3) {
                                    iImageButton = this.f12923i;
                                    i4 = R.drawable.quanjing_mode_un;
                                    break;
                                } else {
                                    iImageButton = this.f12923i;
                                    i4 = R.drawable.quan_jing_01_selector;
                                    break;
                                }
                            } else {
                                iImageButton = this.f12923i;
                                i4 = R.drawable.quan_jing_02_selector;
                                break;
                            }
                        } else {
                            iImageButton = this.f12923i;
                            i4 = R.drawable.quan_jing_03_selector;
                            break;
                        }
                    } else {
                        iImageButton = this.f12923i;
                        i4 = R.drawable.quan_jing_04_selector;
                        break;
                    }
                case 10:
                    iImageButton = this.f12923i;
                    i4 = R.drawable.time_lapse_unselect;
                    break;
                default:
                    return;
            }
            iImageButton.setImageResource(i4);
            return;
        }
        this.f12918d.setVisibility(8);
        this.f12923i.setImageResource(R.drawable.newui_key_operation);
        if (this.f12925k.getVisibility() == 0) {
            if (this.f12927m.e() == Follow.FollowStates.FOLLOW_INVALID_STATE) {
                this.f12928n.d().b(ApmModes.ROTOR_LOITER);
            }
            this.f12925k.setVisibility(8);
            this.f12924j.setVisibility(8);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void armStateEvent(dy.h hVar) {
        if (hVar.a() == 9) {
            a(this.f12928n, false);
            l();
            if (this.f12928n.d().c()) {
                this.D.i().a(this.f12938x.getString(R.string.notify_take_off));
            }
        }
    }

    public void b(int i2) {
        this.f12919e.setProgress(i2);
        this.f12920f.setText(String.format(Locale.US, "%d%s", new Object[]{Integer.valueOf(i2), "%"}));
    }

    public void b(final boolean z2) {
        this.f12938x.runOnUiThread(new Runnable() {
            public void run() {
                if (z2) {
                    if (StickOperateFragment.this.f12928n.d().c()) {
                        StickOperateFragment.this.f12916b.setVisibility(4);
                        StickOperateFragment.this.f12917c.setVisibility(0);
                    } else {
                        StickOperateFragment.this.f12916b.setVisibility(0);
                        StickOperateFragment.this.f12917c.setVisibility(4);
                    }
                    StickOperateFragment.this.f12922h.setVisibility(0);
                    return;
                }
                StickOperateFragment.this.f12916b.setVisibility(4);
                StickOperateFragment.this.f12917c.setVisibility(4);
                StickOperateFragment.this.f12922h.setVisibility(4);
            }
        });
    }

    public void b(boolean z2, int i2) {
        a(z2, i2, 0);
    }

    public boolean b() {
        return this.f12921g.getVisibility() == 0;
    }

    public void c() {
        if (!this.f12928n.d().e().equals(ApmModes.ROTOR_AUTO)) {
            if (this.f12918d.getVisibility() == 0) {
                this.f12918d.setVisibility(8);
            }
            if (this.f12923i.getVisibility() == 0) {
                this.f12923i.setVisibility(8);
            }
        }
        if (this.f12921g.getVisibility() == 0) {
            this.f12921g.setVisibility(8);
        }
    }

    public void c(int i2) {
        if (this.f12918d.getVisibility() == 8) {
            this.f12918d.setVisibility(0);
            b(true, i2);
        }
    }

    public void c(boolean z2) {
        ConstraintLayout constraintLayout;
        int i2;
        if (z2) {
            constraintLayout = this.f12926l;
            i2 = 8;
        } else {
            constraintLayout = this.f12926l;
            i2 = 0;
        }
        constraintLayout.setVisibility(i2);
    }

    @l(a = ThreadMode.ASYNC)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            a(this.f12928n, false);
            l();
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            a(this.f12928n, false);
            l();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStartEvent(af afVar) {
        if (afVar.a() == 32) {
            i();
            int b2 = (int) this.f12928n.t().b();
            if (b2 < 5) {
                b2 = 5;
            } else if (b2 > 50) {
                b2 = 50;
            }
            if (this.f12924j.getVisibility() == 8) {
                Log.i("newUI", "updateFollowView:--currentAlt-- " + b2);
                this.f12924j.setVisibility(0);
                this.f12925k.setVisibility(0);
                this.f12925k.setProgress(b2);
                this.f12924j.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(b2)}));
            }
            this.f12928n.w().a(this.f12938x.getApplicationContext(), (double) b2);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followStopEvent(ag agVar) {
        if (agVar.a() == 33) {
            i();
            d();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void followUpdateEvent(ah ahVar) {
        if (ahVar.a() == 34) {
            i();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatRestoredEvent(al alVar) {
        if (alVar.a() == 7) {
            a(this.f12928n, false);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(s sVar) {
        if (sVar.a() == 4) {
            if (!this.f12928n.d().c()) {
                this.f12928n.d().a(false);
                this.f12928n.d().a(this.f12938x.getString(R.string.takeoff_readying));
            }
            l();
            a(this.f12928n, true);
            i();
            if (this.f12928n.d().e().equals(ApmModes.ROTOR_AUTO)) {
                if (this.f12918d.getVisibility() == 8) {
                    this.f12918d.setVisibility(0);
                }
                if (this.f12923i.getVisibility() == 8) {
                    this.f12923i.setVisibility(0);
                }
                b(true, 2);
            } else if (this.f12935u) {
            } else {
                if (!this.f12938x.f12359h) {
                    this.f12918d.setVisibility(8);
                    this.f12923i.setVisibility(8);
                    return;
                }
                this.f12923i.setImageResource(R.drawable.newui_op_ui_selector);
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12938x = (FlightActionActivity) activity;
    }

    public void onClick(View view) {
        org.greenrobot.eventbus.c cVar;
        Object obj;
        FlightActionActivity flightActionActivity;
        int i2;
        FlightActionActivity flightActionActivity2;
        int i3;
        switch (view.getId()) {
            case R.id.bt_shoot_cancel /*2131296683*/:
                this.f12928n.d().b(ApmModes.ROTOR_LOITER);
                this.f12928n.d().b(ApmModes.ROTOR_LOITER);
                b(false, 0);
                this.f12935u = false;
                this.f12934t = 0;
                this.f12936v.q(0);
                cVar = org.greenrobot.eventbus.c.a();
                obj = new jo.b("operateFragment");
                break;
            case R.id.bt_shoot_mode /*2131296684*/:
                if (!this.f12928n.d().c()) {
                    flightActionActivity = this.f12938x;
                    i2 = R.string.shot_not_flying;
                } else if (this.f12938x.u_()) {
                    flightActionActivity = this.f12938x;
                    i2 = R.string.shot_stop_record;
                } else if (this.f12935u) {
                    flightActionActivity = this.f12938x;
                    i2 = R.string.shoot_is_running;
                } else if (this.f12936v.aO()) {
                    cVar = org.greenrobot.eventbus.c.a();
                    obj = new az(new Runnable() {
                        public void run() {
                            StickOperateFragment.this.e();
                        }
                    });
                    break;
                } else {
                    e();
                    return;
                }
                ToastUtils.showShort((CharSequence) flightActionActivity.getString(i2));
                return;
            case R.id.editor_arm /*2131297062*/:
                this.f12916b.setVisibility(4);
                com.flypro.core.MAVLink.c.a(this.f12928n, true);
                return;
            case R.id.editor_disArm /*2131297065*/:
                com.flypro.core.MAVLink.c.a(this.f12928n, false);
                return;
            case R.id.editor_land /*2131297068*/:
                if (this.f12927m.b()) {
                    this.f12927m.a();
                }
                if (this.f12930p) {
                    h();
                    return;
                } else if (!h.d(this.f12928n) || !this.f12928n.d().h().equalsIgnoreCase("010")) {
                    if (this.B == null) {
                        this.B = d.a(this.f12938x.getString(R.string.dialog_land_title), this.f12938x.getString(R.string.dialog_land_content), new d.a() {
                            public void onNo() {
                                StickOperateFragment.this.f12937w.a((Runnable) new Runnable() {
                                    public void run() {
                                        StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_no_land));
                                        StickOperateFragment.this.f12917c.setImageResource(R.drawable.newui_fly_down);
                                    }
                                });
                            }

                            public void onYes() {
                                StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_land_activate));
                                StickOperateFragment.this.f12928n.d().b(ApmModes.ROTOR_LAND);
                                boolean unused = StickOperateFragment.this.f12930p = true;
                            }
                        });
                    }
                    if (!this.B.isAdded()) {
                        this.B.show(getChildFragmentManager(), "Land");
                        return;
                    }
                    return;
                } else {
                    CommonUI.a((Context) this.f12938x, getView(), Integer.valueOf(R.string.low_rtl_to_land), this.f12938x.getString(R.string.i_see), (CommonUI.b) new CommonUI.b() {
                        public void a() {
                        }
                    });
                    return;
                }
            case R.id.editor_rtl /*2131297070*/:
                if (!this.f12928n.d().c()) {
                    this.f12928n.Q().e(this.f12938x.getString(R.string.action_rtl_not_fly));
                    flightActionActivity2 = this.f12938x;
                    i3 = R.string.sure_take_off;
                } else if (!this.f12928n.d().e().b().equalsIgnoreCase("Alt Hold")) {
                    if (this.f12927m.b()) {
                        this.f12927m.a();
                    }
                    if (this.f12929o) {
                        g();
                    } else if (this.f12928n.d().h().equalsIgnoreCase("100")) {
                        CommonUI.a((Context) this.f12938x, getView(), Integer.valueOf(R.string.not_cancel_land), this.f12938x.getString(R.string.i_see), (CommonUI.b) new CommonUI.b() {
                            public void a() {
                            }
                        });
                    } else {
                        if (this.C == null) {
                            this.C = d.a(this.f12938x.getString(R.string.rtl_confirm_title), this.f12938x.getString(R.string.rtl_confirm_content), new d.a() {
                                public void onNo() {
                                    StickOperateFragment.this.f12937w.a((Runnable) new Runnable() {
                                        public void run() {
                                            StickOperateFragment.this.f12922h.setImageResource(R.drawable.newui_one_key_back);
                                        }
                                    });
                                }

                                public void onYes() {
                                    StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_rtl_active));
                                    StickOperateFragment.this.f12928n.d().b(ApmModes.ROTOR_RTL);
                                    boolean unused = StickOperateFragment.this.f12929o = true;
                                    boolean unused2 = StickOperateFragment.this.f12933s = false;
                                }
                            });
                        }
                        if (!this.C.isAdded()) {
                            this.C.show(getChildFragmentManager(), "rtl confirm");
                        }
                    }
                    cVar = org.greenrobot.eventbus.c.a();
                    obj = new av(this.f12933s);
                    break;
                } else {
                    this.f12928n.Q().e(this.f12938x.getString(R.string.action_rtl_alt));
                    flightActionActivity2 = this.f12938x;
                    i3 = R.string.in_door_mode;
                }
                a(flightActionActivity2.getString(i3));
                cVar = org.greenrobot.eventbus.c.a();
                obj = new av(this.f12933s);
            case R.id.editor_takeOff_arm /*2131297073*/:
                this.f12916b.setImageResource(R.drawable.ib_takeoff_selected);
                if (this.f12928n.d().i()) {
                    f();
                    return;
                }
                if (this.A == null) {
                    this.A = r.a().a(this.f12938x.getString(R.string.warning), this.f12938x.getString(R.string.no_take_off), (c.a) new c.a() {
                        public void onYes() {
                            StickOperateFragment.this.a((Runnable) new Runnable() {
                                public void run() {
                                    StickOperateFragment.this.f12928n.Q().e(StickOperateFragment.this.f12938x.getString(R.string.action_takeoff_not_ready));
                                    StickOperateFragment.this.f12916b.setImageResource(R.drawable.newui_one_key_fly);
                                }
                            });
                        }
                    });
                }
                if (!this.A.isAdded()) {
                    this.A.show(getChildFragmentManager(), "slide to take off");
                    return;
                }
                return;
            default:
                return;
        }
        cVar.d(obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.stick_dorne_operate, viewGroup, false);
        this.f12938x.getWindow().setBackgroundDrawable((Drawable) null);
        this.D = (XEagleApp) this.f12938x.getApplication();
        this.E = a.a((Context) this.f12938x);
        this.f12928n = this.D.k();
        this.f12936v = this.D.j();
        this.f12927m = this.D.l();
        this.f12937w = new e();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        a(this.f12928n, false);
        l();
        i();
        a();
        this.E.a(this.f12915a, F);
    }

    public void onStop() {
        super.onStop();
        this.E.a(this.f12915a);
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onSwitchMode(as asVar) {
        this.f12932r = asVar.a();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
        com.flypro.core.MAVLink.d.a(this.f12928n, com.xeagle.android.utils.c.c(getContext()));
    }

    @l(a = ThreadMode.ASYNC)
    public void stateEvent(y yVar) {
        if (yVar.a() == 2) {
            a(this.f12928n, false);
            l();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void switchMapEvent(ar arVar) {
        if (arVar.a() && this.f12923i.getVisibility() == 8) {
            this.f12923i.setVisibility(0);
            if (!this.f12935u) {
                this.f12923i.setImageResource(R.drawable.newui_op_ui_normal);
            }
        }
        if (this.f12935u) {
            this.f12918d.setVisibility(0);
            if (this.f12934t != 2 && this.f12921g.getVisibility() == 8) {
                this.f12921g.setVisibility(0);
            }
        }
    }
}
