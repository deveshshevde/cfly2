package com.xeagle.android.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.MAVLink.Messages.ApmModes;
import com.cfly.uav_pro.R;
import com.flypro.core.gcs.follow.Follow;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.event.RcJsonEvent;
import com.xeagle.android.newUI.widgets.NiceMarqueeText;
import com.xeagle.android.utils.aa;
import com.xeagle.android.utils.g;
import com.xeagle.android.vjoystick.utils.e;
import com.xeagle.android.widgets.marquee.a;
import dy.ab;
import dy.aj;
import dy.ao;
import dy.ay;
import dy.bb;
import dy.f;
import dy.o;
import dy.x;
import dy.z;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jo.as;
import jo.b;
import jo.bc;
import jo.h;
import jo.k;
import jo.n;
import jo.p;
import jo.s;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class FlightInfoFragment extends Fragment implements View.OnClickListener {
    private Follow A;
    private aa B;
    private double C;
    private int D = -1;
    private boolean E = true;
    /* access modifiers changed from: private */
    public boolean F;
    private boolean G = false;
    private String H;
    private double I = -1.0d;
    /* access modifiers changed from: private */
    public int J;
    private int K = 16000;
    private float L;
    private float M;
    /* access modifiers changed from: private */
    public boolean N;
    private boolean O = false;
    private String P = "";
    private String Q = ApmModes.ROTOR_LOITER.b();
    private e R = new e();
    private List<a> S = new ArrayList();
    /* access modifiers changed from: private */
    public SuperUI T;
    private f U;
    private boolean V = false;
    private long[] W = {1000, 100, 1000, 200};
    private Runnable X = new Runnable() {
        public void run() {
            FlightInfoFragment.this.g();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Runnable f12506a = new Runnable() {
        public void run() {
            FlightInfoFragment.this.b();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    double[] f12507b = new double[15];

    /* renamed from: c  reason: collision with root package name */
    double[] f12508c = new double[5];

    /* renamed from: d  reason: collision with root package name */
    boolean f12509d = false;

    /* renamed from: e  reason: collision with root package name */
    int f12510e;

    /* renamed from: f  reason: collision with root package name */
    boolean f12511f;

    /* renamed from: g  reason: collision with root package name */
    double f12512g;

    /* renamed from: h  reason: collision with root package name */
    private NiceMarqueeText f12513h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f12514i;

    /* renamed from: j  reason: collision with root package name */
    private RelativeLayout f12515j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f12516k;

    /* renamed from: l  reason: collision with root package name */
    private FrameLayout f12517l;

    /* renamed from: m  reason: collision with root package name */
    private FrameLayout f12518m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f12519n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f12520o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f12521p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public TextView f12522q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f12523r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f12524s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f12525t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f12526u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f12527v;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f12528w;

    /* renamed from: x  reason: collision with root package name */
    private BubbleSeekBar f12529x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public en.a f12530y;

    /* renamed from: z  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f12531z;

    /* access modifiers changed from: private */
    public void a(int i2) {
        ImageView imageView;
        int i3;
        if (i2 == 1) {
            imageView = this.f12521p;
            i3 = R.drawable.newui_operation_sa_5;
        } else if (i2 == 2) {
            imageView = this.f12521p;
            i3 = R.drawable.newui_operation_sa_4;
        } else if (i2 == 3) {
            imageView = this.f12521p;
            i3 = R.drawable.newui_operation_sa_3;
        } else if (i2 == 4) {
            imageView = this.f12521p;
            i3 = R.drawable.newui_operation_sa_2;
        } else if (i2 == 5) {
            imageView = this.f12521p;
            i3 = R.drawable.newui_operation_sa_1;
        } else {
            return;
        }
        imageView.setImageResource(i3);
    }

    private void a(int i2, double d2) {
        int i3;
        ImageView imageView;
        this.f12520o.setText(String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(d2)}));
        if (i2 == 1) {
            imageView = this.f12519n;
            i3 = R.drawable.newui_operation_si_1;
        } else if (i2 == 2) {
            imageView = this.f12519n;
            i3 = R.drawable.newui_operation_si_2;
        } else if (i2 == 3) {
            imageView = this.f12519n;
            i3 = R.drawable.newui_operation_si_3;
        } else {
            return;
        }
        imageView.setImageResource(i3);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (!this.P.equalsIgnoreCase(str) || !this.Q.equalsIgnoreCase(this.f12530y.d().e().b())) {
            this.P = str;
            this.Q = this.f12530y.d().e().b();
            String d2 = d();
            if (d2.equals("")) {
                this.S.add(new a(String.format("%s%s", new Object[]{str, ""}), -1));
            } else {
                this.S.add(new a(String.format("%s(%s)", new Object[]{str, d2}), -1));
            }
            if (this.S.size() > 1) {
                this.S.remove(0);
            }
            this.f12513h.setContentWithMarqueeText(this.S);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r3) {
        /*
            r2 = this;
            r0 = 2131298620(0x7f09093c, float:1.8215218E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r2.f12515j = r0
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            android.app.Application r0 = r0.getApplication()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            en.a r0 = r0.k()
            r2.f12530y = r0
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            android.app.Application r0 = r0.getApplication()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            com.flypro.core.gcs.follow.Follow r0 = r0.l()
            r2.A = r0
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            android.app.Application r0 = r0.getApplication()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            com.xeagle.android.utils.prefs.a r0 = r0.j()
            r2.f12531z = r0
            r0 = 2131298259(0x7f0907d3, float:1.8214486E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.f12514i = r0
            r0 = 2131298262(0x7f0907d6, float:1.8214492E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.f12516k = r0
            r0 = 2131298264(0x7f0907d8, float:1.8214496E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r2.f12517l = r0
            r0 = 2131298263(0x7f0907d7, float:1.8214494E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r2.f12518m = r0
            r0 = 2131298255(0x7f0907cf, float:1.8214478E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.f12519n = r0
            r0 = 2131298274(0x7f0907e2, float:1.8214517E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12520o = r0
            r0 = 2131298254(0x7f0907ce, float:1.8214476E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.f12521p = r0
            r0 = 2131298272(0x7f0907e0, float:1.8214512E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12522q = r0
            r0 = 2131298273(0x7f0907e1, float:1.8214515E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12523r = r0
            r0 = 2131298266(0x7f0907da, float:1.82145E38)
            android.view.View r0 = r3.findViewById(r0)
            com.xeagle.android.newUI.widgets.NiceMarqueeText r0 = (com.xeagle.android.newUI.widgets.NiceMarqueeText) r0
            r2.f12513h = r0
            r0 = 2131298258(0x7f0907d2, float:1.8214484E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12524s = r0
            r0 = 2131298256(0x7f0907d0, float:1.821448E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12525t = r0
            r0 = 2131298260(0x7f0907d4, float:1.8214488E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12526u = r0
            r0 = 2131298267(0x7f0907db, float:1.8214502E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f12527v = r0
            r0 = 2131298261(0x7f0907d5, float:1.821449E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.f12528w = r0
            r0 = 2131298653(0x7f09095d, float:1.8215285E38)
            android.view.View r3 = r3.findViewById(r0)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = (com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar) r3
            r2.f12529x = r3
            com.xeagle.android.utils.prefs.a r3 = r2.f12531z
            java.lang.String r3 = r3.j()
            r2.H = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "initView: ====droneType==="
            r3.append(r0)
            java.lang.String r0 = r2.H
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "Drone"
            android.util.Log.i(r0, r3)
            com.xeagle.android.utils.prefs.a r3 = r2.f12531z
            en.a r1 = r2.f12530y
            boolean r3 = com.xeagle.android.utils.h.c(r3, r1)
            r1 = 8
            if (r3 != 0) goto L_0x011c
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x012a
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            goto L_0x0127
        L_0x011c:
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            int r3 = r3.getVisibility()
            if (r3 != r1) goto L_0x012a
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            r1 = 0
        L_0x0127:
            r3.setVisibility(r1)
        L_0x012a:
            java.lang.String r3 = r2.H
            boolean r3 = com.xeagle.android.utils.h.a((java.lang.String) r3)
            if (r3 == 0) goto L_0x0142
            java.lang.String r3 = "initView: ====droneType==11111111111111="
            android.util.Log.i(r0, r3)
            r3 = 1093035622(0x41266666, float:10.4)
            r2.M = r3
            r3 = 1110823284(0x4235d174, float:45.454544)
        L_0x013f:
            r2.L = r3
            goto L_0x0156
        L_0x0142:
            java.lang.String r3 = r2.H
            boolean r3 = com.xeagle.android.utils.h.b((java.lang.String) r3)
            if (r3 == 0) goto L_0x0156
            java.lang.String r3 = "initView: ====droneType==2222222222222="
            android.util.Log.i(r0, r3)
            r3 = 1088421888(0x40e00000, float:7.0)
            r2.M = r3
            r3 = 1115291648(0x427a0000, float:62.5)
            goto L_0x013f
        L_0x0156:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "initView:===max=== "
            r3.append(r1)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r1 = r2.f12529x
            float r1 = r1.getMax()
            r3.append(r1)
            java.lang.String r1 = "==min=="
            r3.append(r1)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r1 = r2.f12529x
            float r1 = r1.getMin()
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r0, r3)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            r0 = 1090309325(0x40fccccd, float:7.9)
            r3.setProgress(r0)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            r1 = 2131099824(0x7f0600b0, float:1.7812012E38)
            int r0 = androidx.core.content.b.c(r0, r1)
            r3.setSecondTrackColor(r0)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar r3 = r2.f12529x
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            r1 = 2131099742(0x7f06005e, float:1.7811846E38)
            int r0 = androidx.core.content.b.c(r0, r1)
            r3.setThumbColor(r0)
            en.a r3 = r2.f12530y
            com.flypro.core.MAVLink.a$a r3 = r3.j()
            boolean r3 = r3.e()
            if (r3 == 0) goto L_0x01b7
            r3 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            r1 = 2131822904(0x7f110938, float:1.9278593E38)
            goto L_0x01be
        L_0x01b7:
            r3 = -65536(0xffffffffffff0000, float:NaN)
            com.xeagle.android.activities.helpers.SuperUI r0 = r2.T
            r1 = 2131821039(0x7f1101ef, float:1.927481E38)
        L_0x01be:
            java.lang.String r0 = r0.getString(r1)
            r2.a((int) r3, (java.lang.String) r0)
            com.xeagle.android.utils.aa r3 = com.xeagle.android.utils.aa.a()
            android.content.Context r0 = r2.getContext()
            com.xeagle.android.utils.aa r3 = r3.a((android.content.Context) r0)
            r2.B = r3
            android.widget.ImageView r3 = r2.f12514i
            r3.setOnClickListener(r2)
            android.widget.ImageView r3 = r2.f12528w
            r3.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.a(android.view.View):void");
    }

    private boolean a(f fVar) {
        boolean z2 = false;
        if (fVar.a().d() && fVar.a().g() && fVar.a().h()) {
            boolean aX = this.f12531z.aX();
            if (this.f12531z.aW() && aX) {
                if (!g.b(this.f12531z.j())) {
                    return false;
                }
                z2 = true;
                if (getString(R.string.detected_obstacles).equals(this.P)) {
                    return true;
                }
                this.P = getString(R.string.detected_obstacles);
                this.f12513h.setBackgroundColor(-65536);
                this.f12513h.setContent(getString(R.string.detected_obstacles));
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f12530y.j().e()) {
            if (!this.f12530y.d().d() && this.f12530y.d().a() != 0 && System.currentTimeMillis() - this.f12530y.d().a() > 5000) {
                this.f12530y.d().a(false);
            }
            c();
        } else {
            this.V = false;
            a(-65536, this.T.getString(R.string.disconnected));
        }
        this.R.b(this.f12506a);
        this.R.a(this.f12506a, 10000);
    }

    private void b(final int i2) {
        this.T.runOnUiThread(new Runnable() {
            public void run() {
                TextView e2;
                int i2;
                int i3 = i2;
                if (i3 >= 80) {
                    e2 = FlightInfoFragment.this.f12523r;
                    i2 = R.drawable.newui_operation_ba_1;
                } else if (i3 >= 20) {
                    e2 = FlightInfoFragment.this.f12523r;
                    i2 = R.drawable.newui_operation_ba_2;
                } else if (i3 >= 10) {
                    e2 = FlightInfoFragment.this.f12523r;
                    i2 = R.drawable.newui_operation_ba_3;
                } else {
                    e2 = FlightInfoFragment.this.f12523r;
                    i2 = R.drawable.newui_operation_ba_4;
                }
                e2.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(dy.f r7) {
        /*
            r6 = this;
            boolean r0 = r6.a((dy.f) r7)
            if (r0 != 0) goto L_0x00fa
            com.MAVLink.common.msg_complex_data r0 = r7.a()
            byte r0 = r0.f6595i
            byte[] r0 = ei.a.a(r0)
            java.util.Locale r1 = java.util.Locale.US
            r2 = 3
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            byte r2 = r0[r2]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r3[r4] = r2
            r2 = 2
            byte r4 = r0[r2]
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
            r5 = 1
            r3[r5] = r4
            byte r0 = r0[r5]
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
            r3[r2] = r0
            java.lang.String r0 = "%d%d%d"
            java.lang.String r0 = java.lang.String.format(r1, r0, r3)
            java.lang.String r1 = "001"
            boolean r2 = r0.equalsIgnoreCase(r1)
            java.lang.String r3 = "100"
            r4 = -65536(0xffffffffffff0000, float:NaN)
            if (r2 == 0) goto L_0x0058
            com.xeagle.android.activities.helpers.SuperUI r2 = r6.T
            r5 = 2131822551(0x7f1107d7, float:1.9277877E38)
        L_0x0047:
            java.lang.String r2 = r2.getString(r5)
            r6.a((int) r4, (java.lang.String) r2)
            en.a r2 = r6.f12530y
            com.flypro.core.drone.variables.aa r2 = r2.d()
            r2.b((java.lang.String) r1)
            goto L_0x00c9
        L_0x0058:
            java.lang.String r1 = "010"
            boolean r2 = r0.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0066
            com.xeagle.android.activities.helpers.SuperUI r2 = r6.T
            r5 = 2131822552(0x7f1107d8, float:1.9277879E38)
            goto L_0x0047
        L_0x0066:
            java.lang.String r1 = "011"
            boolean r2 = r0.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0074
            com.xeagle.android.activities.helpers.SuperUI r2 = r6.T
            r5 = 2131822553(0x7f1107d9, float:1.927788E38)
            goto L_0x0047
        L_0x0074:
            java.lang.String r1 = "000"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0090
            com.xeagle.android.newUI.widgets.NiceMarqueeText r1 = r6.f12513h
            android.content.res.Resources r2 = r6.getResources()
            r4 = 2131099820(0x7f0600ac, float:1.7812004E38)
            int r2 = r2.getColor(r4)
            r1.setBackgroundColor(r2)
            r6.c()
            goto L_0x00c9
        L_0x0090:
            boolean r1 = r0.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x00c9
            en.a r1 = r6.f12530y
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.xeagle.android.activities.helpers.SuperUI r2 = r6.T
            r5 = 2131821613(0x7f11042d, float:1.9275974E38)
            java.lang.String r2 = r2.getString(r5)
            r1.c(r2)
            com.xeagle.android.activities.helpers.SuperUI r1 = r6.T
            java.lang.String r1 = r1.getString(r5)
            r6.a((int) r4, (java.lang.String) r1)
            en.a r1 = r6.f12530y
            com.flypro.core.drone.variables.aa r1 = r1.d()
            r1.b((java.lang.String) r3)
            en.a r1 = r6.f12530y
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.xeagle.android.activities.helpers.SuperUI r2 = r6.T
            java.lang.String r2 = r2.getString(r5)
            r1.a((java.lang.String) r2)
        L_0x00c9:
            com.MAVLink.common.msg_complex_data r7 = r7.a()
            boolean r7 = r7.c()
            if (r7 == 0) goto L_0x00fa
            boolean r7 = r0.equalsIgnoreCase(r3)
            if (r7 != 0) goto L_0x00fa
            en.a r7 = r6.f12530y
            com.flypro.core.drone.variables.aa r7 = r7.d()
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131821620(0x7f110434, float:1.9275988E38)
            java.lang.String r0 = r0.getString(r1)
            r7.c(r0)
            en.a r7 = r6.f12530y
            com.flypro.core.drone.variables.aa r7 = r7.d()
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            java.lang.String r0 = r0.getString(r1)
            r7.a((java.lang.String) r0)
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.b(dy.f):void");
    }

    private void b(en.a aVar) {
        String str;
        TextView textView;
        String str2;
        int i2 = (com.flypro.core.util.a.a().e() > -1.0d ? 1 : (com.flypro.core.util.a.a().e() == -1.0d ? 0 : -1));
        TextView textView2 = this.f12526u;
        if (i2 == 0) {
            str = "HS: N/A";
        } else {
            str = String.format(Locale.US, "HS: %3.1f m/s", new Object[]{Double.valueOf(com.flypro.core.util.a.a().e())});
        }
        textView2.setText(str);
        if (com.flypro.core.util.a.a().f() != -1.0d) {
            textView = this.f12527v;
            str2 = String.format(Locale.US, "VS: %3.1f m/s", new Object[]{Double.valueOf(com.flypro.core.util.a.a().f())});
        } else if (aVar.a()) {
            textView = this.f12527v;
            str2 = String.format(Locale.US, "VS: %3.1f m/s", new Object[]{Double.valueOf(-1.0d)});
        } else {
            textView = this.f12527v;
            str2 = "VS: N/A";
        }
        textView.setText(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005c, code lost:
        if (r6.f12530y.b().d() >= 6) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "updateFailSafeStatus:====== "
            r0.append(r1)
            en.a r1 = r6.f12530y
            com.flypro.core.drone.variables.aa r1 = r1.d()
            boolean r1 = r1.i()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TAG"
            android.util.Log.i(r1, r0)
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r2 = 2131822904(0x7f110938, float:1.9278593E38)
            r3 = 2131822493(0x7f11079d, float:1.9277759E38)
            r4 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            if (r0 != r1) goto L_0x006c
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0051
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131821605(0x7f110425, float:1.9275958E38)
        L_0x0048:
            java.lang.String r0 = r0.getString(r1)
        L_0x004c:
            r6.a((int) r4, (java.lang.String) r0)
            goto L_0x0225
        L_0x0051:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.j r0 = r0.b()
            int r0 = r0.d()
            r1 = 6
            if (r0 < r1) goto L_0x0065
        L_0x005e:
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            java.lang.String r0 = r0.getString(r3)
            goto L_0x004c
        L_0x0065:
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            java.lang.String r0 = r0.getString(r2)
            goto L_0x004c
        L_0x006c:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            r1 = -256(0xffffffffffffff00, float:NaN)
            if (r0 == 0) goto L_0x00a9
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            com.MAVLink.Messages.ApmModes r5 = com.MAVLink.Messages.ApmModes.ROTOR_ALT_HOLD
            if (r0 != r5) goto L_0x00a9
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x009e
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r2 = 2131820709(0x7f1100a5, float:1.927414E38)
        L_0x0099:
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00a4
        L_0x009e:
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            java.lang.String r0 = r0.getString(r3)
        L_0x00a4:
            r6.a((int) r1, (java.lang.String) r0)
            goto L_0x0225
        L_0x00a9:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x00c2
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.i()
            if (r0 != 0) goto L_0x00c2
            goto L_0x0065
        L_0x00c2:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x00db
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.i()
            if (r0 == 0) goto L_0x00db
            goto L_0x005e
        L_0x00db:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x015f
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r2 = "RTL"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x015f
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            android.content.Context r0 = r0.getApplicationContext()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0112
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131822554(0x7f1107da, float:1.9277883E38)
            goto L_0x0048
        L_0x0112:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            java.lang.String r0 = r0.h()
            java.lang.String r1 = "001"
            boolean r0 = r0.equalsIgnoreCase(r1)
            r1 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 == 0) goto L_0x012d
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r2 = 2131822551(0x7f1107d7, float:1.9277877E38)
            goto L_0x0099
        L_0x012d:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            java.lang.String r0 = r0.h()
            java.lang.String r2 = "010"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0146
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r2 = 2131822552(0x7f1107d8, float:1.9277879E38)
            goto L_0x0099
        L_0x0146:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            java.lang.String r0 = r0.h()
            java.lang.String r2 = "011"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0225
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r2 = 2131822553(0x7f1107d9, float:1.927788E38)
            goto L_0x0099
        L_0x015f:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0188
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r2 = "Tracker"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0188
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131823176(0x7f110a48, float:1.9279144E38)
            goto L_0x0048
        L_0x0188:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01b1
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r2 = "Land"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x01b1
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r2 = 2131821565(0x7f1103fd, float:1.9275877E38)
            goto L_0x0099
        L_0x01b1:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r1 = "Stabilize"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01d3
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r0.b((com.MAVLink.Messages.ApmModes) r1)
            goto L_0x0225
        L_0x01d3:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01fc
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r1 = "GUIDED"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x01fc
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131821393(0x7f110351, float:1.9275528E38)
            goto L_0x0048
        L_0x01fc:
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0225
            en.a r0 = r6.f12530y
            com.flypro.core.drone.variables.aa r0 = r0.d()
            com.MAVLink.Messages.ApmModes r0 = r0.e()
            java.lang.String r0 = r0.b()
            java.lang.String r1 = "AUTO"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0225
            com.xeagle.android.activities.helpers.SuperUI r0 = r6.T
            r1 = 2131820735(0x7f1100bf, float:1.9274193E38)
            goto L_0x0048
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.c():void");
    }

    private void c(int i2) {
        ImageView imageView;
        int i3;
        if (i2 == 1) {
            imageView = this.f12516k;
            i3 = R.drawable.newui_operation_rc_1;
        } else if (i2 == 2) {
            imageView = this.f12516k;
            i3 = R.drawable.newui_operation_rc_2;
        } else if (i2 == 3) {
            imageView = this.f12516k;
            i3 = R.drawable.newui_operation_rc_3;
        } else {
            return;
        }
        imageView.setImageResource(i3);
    }

    private void c(en.a aVar) {
        if (aVar.F() != null) {
            final double a2 = aVar.F().a();
            c.a().d(new k(a2));
            this.T.runOnUiThread(new Runnable() {
                public void run() {
                    FlightInfoFragment flightInfoFragment;
                    int i2;
                    double d2 = a2;
                    if (d2 >= i.f27244a && d2 <= 1.0d) {
                        flightInfoFragment = FlightInfoFragment.this;
                        i2 = 5;
                    } else if (d2 > 1.0d && d2 <= 1.8d) {
                        flightInfoFragment = FlightInfoFragment.this;
                        i2 = 4;
                    } else if (d2 <= 2.4d && d2 > 1.8d) {
                        flightInfoFragment = FlightInfoFragment.this;
                        i2 = 3;
                    } else if (d2 > 4.0d || d2 <= 2.4d) {
                        flightInfoFragment = FlightInfoFragment.this;
                        i2 = 1;
                    } else {
                        flightInfoFragment = FlightInfoFragment.this;
                        i2 = 2;
                    }
                    flightInfoFragment.a(i2);
                }
            });
        }
    }

    private String d() {
        String b2 = this.f12530y.d().e().b();
        b2.hashCode();
        char c2 = 65535;
        switch (b2.hashCode()) {
            case -2013398213:
                if (b2.equals("Loiter")) {
                    c2 = 0;
                    break;
                }
                break;
            case 81482:
                if (b2.equals("RTL")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2052559:
                if (b2.equals("Auto")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2360843:
                if (b2.equals("Land")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2576154:
                if (b2.equals("Shot")) {
                    c2 = 4;
                    break;
                }
                break;
            case 597258008:
                if (b2.equals("Tracker")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1379812394:
                if (b2.equals("Unknown")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2018617584:
                if (b2.equals("Circle")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2032461078:
                if (b2.equals("Alt Hold")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2143949064:
                if (b2.equals("Guided")) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.T.getString(R.string.spinner_mode_loiter);
            case 1:
                return this.T.getString(R.string.spinner_mode_rth);
            case 2:
                return this.T.getString(R.string.auto_flight_mode);
            case 3:
                return this.T.getString(R.string.spinner_mode_land);
            case 4:
                return this.T.getString(R.string.spinner_mode_shot);
            case 5:
                return this.T.getString(R.string.vision_follow);
            case 6:
                return "";
            case 7:
                return this.T.getString(R.string.spinner_mode_circle);
            case 8:
                return this.T.getString(R.string.spinner_mode_althold);
            case 9:
                return this.T.getString(R.string.spinner_mode_follow);
            default:
                return this.T.getString(R.string.spinner_mode_loiter);
        }
    }

    private void d(final en.a aVar) {
        if (aVar == null) {
            this.f12522q.setText("--");
        } else {
            this.T.runOnUiThread(new Runnable() {
                public void run() {
                    if (aVar.b().a()) {
                        if (aVar.b().d() != -1) {
                            aVar.P().e(true);
                            FlightInfoFragment.this.f12522q.setText(String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(aVar.b().d())}));
                            c.a().d(new s(aVar.b()));
                            return;
                        }
                    } else if (aVar.b().d() == 0) {
                        FlightInfoFragment.this.f12522q.setText("0");
                        aVar.P().e(true);
                        return;
                    }
                    FlightInfoFragment.this.f12522q.setText("N/A");
                    aVar.P().e(false);
                }
            });
        }
    }

    private void e() {
        if (!this.f12530y.d().e().b().equals("Loiter") && (this.f12530y.d().e().b().equals("Alt Hold") || (this.f12530y.d().e().b().equals("Land") && !this.f12531z.i()))) {
            this.f12531z.c(false);
        } else {
            this.f12531z.c(true);
        }
        this.F = this.f12531z.i();
        en.a aVar = this.f12530y;
        if (aVar != null && !aVar.d().e().b().equals("N/A")) {
            if (this.F) {
                c.a().d(new as(true));
                this.f12530y.d().f11567a = true;
                return;
            }
            c.a().d(new as(false));
            this.f12530y.d().f11567a = false;
        }
    }

    private void e(en.a aVar) {
        f(aVar);
    }

    private void f() {
        c.a().d(new h(this.f12510e));
        if (this.f12510e <= this.J) {
            this.f12511f = true;
            this.f12523r.post(new Runnable() {
                public void run() {
                    FlightInfoFragment.this.f12523r.setTextColor(-65536);
                }
            });
            if (this.f12530y.d().d()) {
                if (!this.B.b()) {
                    this.B.a(this.W, 0);
                    this.B.a(true);
                }
            } else if (this.B.b()) {
                this.B.d();
                this.B.a(false);
            }
            if (!this.f12509d) {
                g();
                this.f12509d = true;
                return;
            }
            return;
        }
        if (this.f12511f) {
            Log.i("BAT", "low battery");
        }
        this.f12523r.post(new Runnable() {
            public void run() {
                FlightInfoFragment.this.f12523r.setTextColor(-1);
            }
        });
        if (this.B.b()) {
            this.B.d();
            this.B.a(false);
        }
        Runnable runnable = this.X;
        if (runnable != null) {
            this.R.b(runnable);
            this.f12509d = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        if (r9 >= 10590.0d) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        r13.f12510e = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a5, code lost:
        r13.f12510e = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f4, code lost:
        if (r9 >= 10430.0d) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(en.a r14) {
        /*
            r13 = this;
            if (r14 == 0) goto L_0x0109
            com.flypro.core.drone.variables.b r0 = r14.o()
            if (r0 != 0) goto L_0x000a
            goto L_0x0109
        L_0x000a:
            com.flypro.core.drone.variables.b r0 = r14.o()
            double r0 = r0.a()
            double[] r2 = r13.f12507b
            double r2 = com.xeagle.android.utils.c.a((double) r0, (double[]) r2)
            r13.f12512g = r2
            org.greenrobot.eventbus.c r2 = org.greenrobot.eventbus.c.a()
            jo.i r3 = new jo.i
            double r4 = r13.f12512g
            r3.<init>(r4)
            r2.d(r3)
            com.xeagle.android.utils.prefs.a r2 = r13.f12531z
            boolean r2 = com.xeagle.android.utils.h.d(r2, r14)
            if (r2 == 0) goto L_0x0031
            return
        L_0x0031:
            r13.h()
            java.lang.String r2 = r13.H
            java.lang.String r3 = "808"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00f7
            com.flypro.core.drone.variables.aa r14 = r14.d()
            boolean r14 = r14.c()
            r2 = 10
            r3 = 20
            r4 = 40
            r5 = 60
            r6 = 80
            r7 = 100
            r8 = 0
            if (r14 != 0) goto L_0x00a8
            r13.N = r8
            double r9 = r13.f12512g
            r11 = 4667998605955563520(0x40c8100000000000, double:12320.0)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x0066
        L_0x0062:
            r13.f12510e = r7
            goto L_0x00f7
        L_0x0066:
            r11 = 4667690742699786240(0x40c6f80000000000, double:11760.0)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x0073
        L_0x006f:
            r13.f12510e = r6
            goto L_0x00f7
        L_0x0073:
            r6 = 4667498328164925440(0x40c6490000000000, double:11410.0)
            int r14 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r14 < 0) goto L_0x0080
        L_0x007c:
            r13.f12510e = r5
            goto L_0x00f7
        L_0x0080:
            r5 = 4667349894095175680(0x40c5c20000000000, double:11140.0)
            int r14 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r14 < 0) goto L_0x008d
        L_0x0089:
            r13.f12510e = r4
            goto L_0x00f7
        L_0x008d:
            r4 = 4667278425839370240(0x40c5810000000000, double:11010.0)
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x0099
        L_0x0096:
            r13.f12510e = r3
            goto L_0x00f7
        L_0x0099:
            r3 = 4667047528397537280(0x40c4af0000000000, double:10590.0)
            int r14 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r14 < 0) goto L_0x00a5
        L_0x00a2:
            r13.f12510e = r2
            goto L_0x00f7
        L_0x00a5:
            r13.f12510e = r8
            goto L_0x00f7
        L_0x00a8:
            boolean r14 = r13.N
            if (r14 == 0) goto L_0x00b9
            com.xeagle.android.vjoystick.utils.e r14 = r13.R
            com.xeagle.android.fragments.FlightInfoFragment$12 r0 = new com.xeagle.android.fragments.FlightInfoFragment$12
            r0.<init>()
            r1 = 5000(0x1388, double:2.4703E-320)
            r14.a(r0, r1)
            return
        L_0x00b9:
            double r9 = r13.f12512g
            r11 = 4667833679211397120(0x40c77a0000000000, double:12020.0)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00c5
            goto L_0x0062
        L_0x00c5:
            r11 = 4667542308630036480(0x40c6710000000000, double:11490.0)
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00cf
            goto L_0x006f
        L_0x00cf:
            r6 = 4667338898978897920(0x40c5b80000000000, double:11120.0)
            int r14 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r14 < 0) goto L_0x00d9
            goto L_0x007c
        L_0x00d9:
            r5 = 4667201460025425920(0x40c53b0000000000, double:10870.0)
            int r14 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r14 < 0) goto L_0x00e3
            goto L_0x0089
        L_0x00e3:
            r4 = 4667135489327759360(0x40c4ff0000000000, double:10750.0)
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x00ed
            goto L_0x0096
        L_0x00ed:
            r3 = 4666959567467315200(0x40c45f0000000000, double:10430.0)
            int r14 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r14 < 0) goto L_0x00a5
            goto L_0x00a2
        L_0x00f7:
            int r14 = r13.f12510e
            r13.b((int) r14)
            r13.f()
            com.xeagle.android.activities.helpers.SuperUI r14 = r13.T
            com.xeagle.android.fragments.FlightInfoFragment$2 r2 = new com.xeagle.android.fragments.FlightInfoFragment$2
            r2.<init>(r0)
            r14.runOnUiThread(r2)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.f(en.a):void");
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f12530y.d().d() && this.f12510e <= this.J && this.f12512g > i.f27244a) {
            this.T.runOnUiThread(new Runnable() {
                public void run() {
                    FlightInfoFragment flightInfoFragment = FlightInfoFragment.this;
                    String string = flightInfoFragment.T.getString(R.string.battery_warn);
                    flightInfoFragment.a(-65536, String.format(string, new Object[]{FlightInfoFragment.this.J + "%"}));
                    com.flypro.core.drone.variables.aa d2 = FlightInfoFragment.this.f12530y.d();
                    String string2 = FlightInfoFragment.this.T.getString(R.string.battery_warn);
                    d2.d(String.format(string2, new Object[]{FlightInfoFragment.this.J + "%"}));
                }
            });
        }
        Runnable runnable = this.X;
        if (runnable != null) {
            this.R.a(runnable, 5000);
        }
    }

    private void g(en.a aVar) {
        this.H = this.f12531z.j();
        h();
        a(aVar);
        b(aVar);
        e(aVar);
        d(aVar);
        c(aVar);
    }

    private void h() {
        this.J = this.f12531z.l();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void BatteryStateEvent(dy.i iVar) {
        if (iVar.a() == 10) {
            if (!this.V) {
                this.V = true;
            }
            e(this.f12530y);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void SpeedStateEvent(x xVar) {
        if (xVar.a() == 12) {
            a(this.f12530y);
        }
    }

    public void a() {
        f fVar = this.U;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public void a(en.a aVar) {
        TextView textView;
        String str;
        if (this.C != -1.0d) {
            textView = this.f12524s;
            str = String.format(Locale.US, "H: %3.1fm", new Object[]{Double.valueOf(com.flypro.core.util.a.a().g())});
        } else if (aVar.a()) {
            textView = this.f12524s;
            str = String.format(Locale.US, "H: %3.1fm", new Object[]{Double.valueOf(-1.0d)});
        } else {
            textView = this.f12524s;
            str = "H: N/A";
        }
        textView.setText(str);
    }

    public void a(boolean z2) {
        RelativeLayout relativeLayout;
        int i2;
        if (z2) {
            relativeLayout = this.f12515j;
            i2 = 8;
        } else {
            relativeLayout = this.f12515j;
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
    }

    @l(a = ThreadMode.BACKGROUND)
    public void armState(dy.h hVar) {
        if (hVar.a() == 9 && this.f12530y.d().c()) {
            this.N = true;
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            a(-65536, this.T.getString(R.string.disconnected));
            g(this.f12530y);
            this.K = 16000;
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneTakeoffEvent(z zVar) {
        if (zVar.a() == 53) {
            this.R.a(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x01a1, code lost:
                    if (com.xeagle.android.fragments.FlightInfoFragment.b(r6.f23206a).d().i() != false) goto L_0x01d2;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x01d0, code lost:
                    if (com.xeagle.android.fragments.FlightInfoFragment.b(r6.f23206a).d().i() != false) goto L_0x01d2;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x01d2, code lost:
                    r0 = r6.f23206a;
                    r1 = com.xeagle.android.fragments.FlightInfoFragment.c(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d9, code lost:
                    r0 = r6.f23206a;
                    r1 = com.xeagle.android.fragments.FlightInfoFragment.c(r0).getString(com.cfly.uav_pro.R.string.takeoff_readying);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r1 = r1.f12530y
                        com.flypro.core.drone.variables.aa r1 = r1.d()
                        java.lang.String r1 = r1.g()
                        r0.c((java.lang.String) r1)
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        java.lang.String r1 = ""
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0033
                        goto L_0x01f6
                    L_0x0033:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r1.T
                        r2 = 2131822493(0x7f11079d, float:1.9277759E38)
                        java.lang.String r1 = r1.getString(r2)
                        boolean r0 = r0.equals(r1)
                        java.lang.String r1 = "#00ff64"
                        if (r0 == 0) goto L_0x006b
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        int r1 = android.graphics.Color.parseColor(r1)
                        com.xeagle.android.fragments.FlightInfoFragment r3 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r3 = r3.T
                        java.lang.String r2 = r3.getString(r2)
                    L_0x0066:
                        r0.a((int) r1, (java.lang.String) r2)
                        goto L_0x01f6
                    L_0x006b:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        com.xeagle.android.fragments.FlightInfoFragment r3 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r3 = r3.T
                        r4 = 2131822904(0x7f110938, float:1.9278593E38)
                        java.lang.String r3 = r3.getString(r4)
                        boolean r0 = r0.equals(r3)
                        if (r0 == 0) goto L_0x009d
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        int r1 = android.graphics.Color.parseColor(r1)
                        com.xeagle.android.fragments.FlightInfoFragment r2 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r2 = r2.T
                        java.lang.String r2 = r2.getString(r4)
                        goto L_0x0066
                    L_0x009d:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        com.xeagle.android.fragments.FlightInfoFragment r3 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r3 = r3.T
                        r5 = 2131821270(0x7f1102d6, float:1.9275278E38)
                        java.lang.String r3 = r3.getString(r5)
                        boolean r0 = r0.equals(r3)
                        if (r0 == 0) goto L_0x00cf
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        int r1 = android.graphics.Color.parseColor(r1)
                        com.xeagle.android.fragments.FlightInfoFragment r2 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r2 = r2.T
                        java.lang.String r2 = r2.getString(r5)
                        goto L_0x0066
                    L_0x00cf:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r1.T
                        r3 = 2131821145(0x7f110259, float:1.9275025E38)
                        java.lang.String r1 = r1.getString(r3)
                        boolean r0 = r0.equalsIgnoreCase(r1)
                        if (r0 == 0) goto L_0x0122
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r0 = r0.T
                        r1 = 2131823185(0x7f110a51, float:1.9279163E38)
                        java.lang.String r0 = r0.getString(r1)
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r1.T
                        r2 = 2131821147(0x7f11025b, float:1.9275029E38)
                        java.lang.String r1 = r1.getString(r2)
                        com.xeagle.android.fragments.FlightInfoFragment$6$1 r2 = new com.xeagle.android.fragments.FlightInfoFragment$6$1
                        r2.<init>()
                        com.xeagle.android.dialogs.d r0 = com.xeagle.android.dialogs.d.a(r0, r1, r2)
                        if (r0 == 0) goto L_0x01f6
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                        java.lang.String r2 = "compass"
                        r0.show(r1, r2)
                        goto L_0x01f6
                    L_0x0122:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        java.lang.String r0 = r0.g()
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        boolean r1 = r1.isAdded()
                        if (r1 != 0) goto L_0x0139
                        return
                    L_0x0139:
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        r3 = 2131820935(0x7f110187, float:1.9274599E38)
                        java.lang.String r1 = r1.getString(r3)
                        boolean r1 = r0.contains(r1)
                        r3 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
                        if (r1 == 0) goto L_0x015e
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r1 = r0.f12530y
                        com.flypro.core.drone.variables.aa r1 = r1.d()
                        java.lang.String r1 = r1.g()
                    L_0x0159:
                        r0.a((int) r3, (java.lang.String) r1)
                        goto L_0x01f6
                    L_0x015e:
                        com.xeagle.android.fragments.FlightInfoFragment r1 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r1.T
                        r5 = 2131822209(0x7f110681, float:1.9277183E38)
                        java.lang.String r1 = r1.getString(r5)
                        boolean r0 = r0.equalsIgnoreCase(r1)
                        if (r0 != 0) goto L_0x01e5
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        boolean r0 = r0.F
                        if (r0 == 0) goto L_0x01a4
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        boolean r0 = r0.d()
                        if (r0 == 0) goto L_0x0193
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r0.T
                        r2 = 2131821605(0x7f110425, float:1.9275958E38)
                        goto L_0x01bd
                    L_0x0193:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        boolean r0 = r0.i()
                        if (r0 == 0) goto L_0x01d9
                        goto L_0x01d2
                    L_0x01a4:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        boolean r0 = r0.d()
                        if (r0 == 0) goto L_0x01c2
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r0.T
                        r2 = 2131820709(0x7f1100a5, float:1.927414E38)
                    L_0x01bd:
                        java.lang.String r1 = r1.getString(r2)
                        goto L_0x0159
                    L_0x01c2:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        en.a r0 = r0.f12530y
                        com.flypro.core.drone.variables.aa r0 = r0.d()
                        boolean r0 = r0.i()
                        if (r0 == 0) goto L_0x01d9
                    L_0x01d2:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r0.T
                        goto L_0x01bd
                    L_0x01d9:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        com.xeagle.android.activities.helpers.SuperUI r1 = r0.T
                        java.lang.String r1 = r1.getString(r4)
                        goto L_0x0159
                    L_0x01e5:
                        com.xeagle.android.fragments.FlightInfoFragment r0 = com.xeagle.android.fragments.FlightInfoFragment.this
                        r1 = -65536(0xffffffffffff0000, float:NaN)
                        com.xeagle.android.activities.helpers.SuperUI r2 = r0.T
                        r3 = 2131822210(0x7f110682, float:1.9277185E38)
                        java.lang.String r2 = r2.getString(r3)
                        goto L_0x0066
                    L_0x01f6:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.AnonymousClass6.run():void");
                }
            }, 500);
            c.a().d(new n(this.f12530y.d().g()));
        }
    }

    @l(a = ThreadMode.MAIN)
    public void flightDistanceEvent(p pVar) {
        String str;
        TextView textView;
        if (pVar.a().contains("N/A")) {
            textView = this.f12525t;
            str = String.format(Locale.US, "%s", new Object[]{pVar.a()});
        } else {
            textView = this.f12525t;
            str = String.format(Locale.US, "%sm", new Object[]{pVar.a()});
        }
        textView.setText(str);
    }

    @l(a = ThreadMode.MAIN)
    public void gpsCountEvent(dy.n nVar) {
        if (nVar.a() == 25 && this.f12522q != null) {
            if (!this.V) {
                this.V = true;
            }
            d(this.f12530y);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void gpsFixEvent(o oVar) {
        if (oVar.a() == 24 && this.f12522q != null) {
            if (!this.V) {
                this.V = true;
            }
            d(this.f12530y);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void hdopValueEvent(aj ajVar) {
        if (ajVar.a() == 56) {
            c(this.f12530y);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void localHdop(ao aoVar) {
        double a2 = aoVar.a();
        this.I = a2;
        a((a2 < i.f27244a || a2 >= 1.2d) ? (a2 < 1.2d || a2 >= 2.4d) ? 3 : 2 : 1, a2);
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(dy.s sVar) {
        if (sVar.a() == 4) {
            if (!this.V) {
                this.V = true;
            }
            this.f12530y.d().a(false);
            e();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.T = (SuperUI) activity;
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.newui_operation_home) {
            if (this.f12530y.d().e().b().equalsIgnoreCase(ApmModes.ROTOR_TRACKER.b())) {
                this.f12530y.d().b(ApmModes.ROTOR_LOITER);
                this.f12530y.d().b(ApmModes.ROTOR_LOITER);
                c.a().d(new b("operateFragment"));
            }
            XEagleApp xEagleApp = (XEagleApp) this.T.getApplicationContext();
            if (xEagleApp.c() && xEagleApp.f() != null) {
                xEagleApp.a((hb.a) null);
                xEagleApp.f().f11875b = false;
                xEagleApp.f().f11876c = false;
                xEagleApp.f().d(256);
                xEagleApp.f().a(554);
                xEagleApp.f().j();
                xEagleApp.f().m();
                Log.i("RTSP", "rtspClientConnected: 关闭RTST流");
            }
            xEagleApp.m().l(false);
            this.T.finish();
            startActivity(new Intent(this.T.getApplicationContext(), HostManagerActivity.class));
        } else if (id2 == R.id.newui_operation_navigation) {
            this.f12530y.Q().e(this.T.getString(R.string.action_system_set));
            if (this.U == null) {
                this.U = new f();
            }
            if (!this.U.isAdded()) {
                this.U.show(getChildFragmentManager(), "SystemSetting");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.xeagle_flight_info, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        c.a().c(this);
        this.f12513h.b();
        Runnable runnable = this.f12506a;
        if (runnable != null) {
            this.R.b(runnable);
            this.f12506a = null;
        }
        this.U = null;
        this.R.a((Object) null);
    }

    public void onResume() {
        super.onResume();
        this.f12530y.e().a("FENCE_ENABLE");
        this.f12530y.e().a("FENCE_ALT_MAX");
        this.f12530y.e().a("FENCE_RADIUS");
        b();
        e();
        g(this.f12530y);
    }

    public void onStart() {
        super.onStart();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        g(this.f12530y);
        Runnable runnable = this.X;
        if (runnable != null) {
            this.f12509d = false;
            this.R.b(runnable);
            this.X = null;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }

    @l(a = ThreadMode.MAIN)
    public void parseRcJsonEvent(RcJsonEvent rcJsonEvent) {
        int signal = 100 - rcJsonEvent.getBeans().getSignal();
        c(signal >= 75 ? 1 : signal >= 50 ? 2 : 3);
    }

    @l(a = ThreadMode.MAIN)
    public void parseUsbRcSignalEvent(bc bcVar) {
        int a2 = 100 - bcVar.a();
        c(a2 >= 65 ? 1 : a2 >= 35 ? 2 : 3);
    }

    @l(a = ThreadMode.MAIN)
    public void recvDroneVersion(ab abVar) {
        BubbleSeekBar bubbleSeekBar;
        if (abVar.a() == 65 && this.f12530y.y() != null) {
            int i2 = 8;
            if (com.xeagle.android.utils.h.c(this.f12531z, this.f12530y)) {
                if (this.f12529x.getVisibility() == 8) {
                    bubbleSeekBar = this.f12529x;
                    i2 = 0;
                } else {
                    return;
                }
            } else if (this.f12529x.getVisibility() == 0) {
                bubbleSeekBar = this.f12529x;
            } else {
                return;
            }
            bubbleSeekBar.setVisibility(i2);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rtlBatteryEvent(f fVar) {
        b(fVar);
        byte b2 = fVar.a().f6595i & 1;
        if (((XEagleApp) this.T.getApplicationContext()).m().l() != b2) {
            ((XEagleApp) this.T.getApplicationContext()).m().b((int) b2);
            if (b2 == 1) {
                if (g.b(this.f12531z.j())) {
                    ToastHelper.showCenterToastShort(getContext(), R.layout.toast_fly_sport_warn);
                }
                this.f12530y.d().c(this.T.getString(R.string.usb_sport_gear_warn));
            } else if (g.b(this.f12531z.j())) {
                ToastHelper.showCenterToastShort(getContext(), R.layout.toast_fly_normal_warn);
            }
        }
        if (this.f12529x.getWarnProgress() != ((float) fVar.a().f6590d) / 1000.0f) {
            this.f12529x.a(((((float) fVar.a().f6590d) / 1000.0f) - this.M) * this.L);
        }
        if (this.f12529x.getmProgress() * 1000.0f != ((float) fVar.a().f6591e) && fVar.a().f6591e < this.K) {
            float f2 = ((((float) fVar.a().f6591e) / 1000.0f) - this.M) * this.L;
            if (f2 >= 100.0f) {
                this.f12529x.setProgress(100.0f);
            } else {
                this.f12529x.setProgress(f2);
            }
            this.K = fVar.a().f6591e;
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void rtlFinishEvent(ay ayVar) {
        if (ayVar.a() == 55) {
            this.f12511f = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r3 > 100) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        if (r3 > 100) goto L_0x005c;
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sonarEvent(dy.ba r3) {
        /*
            r2 = this;
            en.a r0 = r2.f12530y
            java.lang.String r0 = r0.y()
            if (r0 == 0) goto L_0x0070
            com.xeagle.android.utils.prefs.a r0 = r2.f12531z
            en.a r1 = r2.f12530y
            boolean r0 = com.xeagle.android.utils.h.d(r0, r1)
            if (r0 == 0) goto L_0x0070
            r2.h()
            com.MAVLink.common.msg_sonar_dug r3 = r3.a()
            short r3 = r3.f7262g
            r2.f12510e = r3
            com.xeagle.android.activities.helpers.SuperUI r3 = r2.T
            android.content.Context r3 = r3.getApplicationContext()
            com.xeagle.android.XEagleApp r3 = (com.xeagle.android.XEagleApp) r3
            boolean r3 = r3.c()
            r0 = 100
            if (r3 == 0) goto L_0x0045
            int r3 = r2.f12510e
            r1 = 90
            if (r3 < r1) goto L_0x005e
            int r3 = r3 - r1
            float r3 = (float) r3
            r1 = 1084227584(0x40a00000, float:5.0)
            float r3 = r3 / r1
            r1 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 * r1
            r1 = 1119092736(0x42b40000, float:90.0)
            float r3 = r3 + r1
            int r3 = (int) r3
            r2.f12510e = r3
            if (r3 <= r0) goto L_0x005e
            goto L_0x005c
        L_0x0045:
            int r3 = r2.f12510e
            r1 = 60
            if (r3 < r1) goto L_0x005e
            int r3 = r3 - r1
            float r3 = (float) r3
            r1 = 1108082688(0x420c0000, float:35.0)
            float r3 = r3 / r1
            r1 = 1109393408(0x42200000, float:40.0)
            float r3 = r3 * r1
            r1 = 1114636288(0x42700000, float:60.0)
            float r3 = r3 + r1
            int r3 = (int) r3
            r2.f12510e = r3
            if (r3 <= r0) goto L_0x005e
        L_0x005c:
            r2.f12510e = r0
        L_0x005e:
            int r3 = r2.f12510e
            r2.b((int) r3)
            r2.f()
            com.xeagle.android.activities.helpers.SuperUI r3 = r2.T
            com.xeagle.android.fragments.FlightInfoFragment$9 r0 = new com.xeagle.android.fragments.FlightInfoFragment$9
            r0.<init>()
            r3.runOnUiThread(r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.FlightInfoFragment.sonarEvent(dy.ba):void");
    }

    @l(a = ThreadMode.MAIN)
    public void speedChangeEvent(bb bbVar) {
        if (bbVar.a() == 57) {
            b(this.f12530y);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void typeEvent(dy.aa aaVar) {
        if (aaVar.a() == 3) {
            e();
        }
    }
}
