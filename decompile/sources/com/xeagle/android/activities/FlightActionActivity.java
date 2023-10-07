package com.xeagle.android.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import com.MAVLink.Messages.ApmModes;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.aa;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.PathMotion;
import com.transitionseverywhere.Transition;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.fragments.FlightInfoFragment;
import com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog;
import com.xeagle.android.newUI.widgets.RoundRelativeLayout;
import com.xeagle.android.utils.ab;
import com.xeagle.android.vjoystick.DroneControlFragment;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.StickOperateFragment;
import com.xeagle.android.vjoystick.g;
import com.xeagle.android.vjoystick.utils.e;
import com.xeagle.android.widgets.DroneIndicatorView;
import dy.ad;
import dy.az;
import dy.ba;
import dy.bf;
import dy.p;
import dy.y;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import jo.ae;
import jo.ag;
import jo.al;
import jo.ar;
import jo.b;
import jo.be;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class FlightActionActivity extends SuperUI implements View.OnClickListener, View.OnTouchListener {
    /* access modifiers changed from: private */
    public ef.a A;
    private float B = 0.0f;
    private View C;
    private float D = 0.0f;
    private RoundRelativeLayout E;
    private View F;
    private View G;
    private XEagleApp H;
    /* access modifiers changed from: private */
    public com.xeagle.android.utils.prefs.a I;
    /* access modifiers changed from: private */
    public List<a> J;
    /* access modifiers changed from: private */
    public LinearLayout K;
    private View L;
    private View M;
    private View N;
    private View O;
    private View P;
    private ImageView Q;
    private TextView R;
    private ImageView S;
    private TextView T;
    private ImageView U;
    private TextView V;
    private ImageView W;
    private TextView X;
    private ImageView Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    private e f12279a = new e();

    /* renamed from: aa  reason: collision with root package name */
    private ImageView f12280aa;
    /* access modifiers changed from: private */

    /* renamed from: ab  reason: collision with root package name */
    public Timer f12281ab;
    /* access modifiers changed from: private */

    /* renamed from: ac  reason: collision with root package name */
    public Timer f12282ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f12283ad = false;

    /* renamed from: ae  reason: collision with root package name */
    private boolean f12284ae = false;
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public ObjectAnimator f12285af;
    /* access modifiers changed from: private */

    /* renamed from: ag  reason: collision with root package name */
    public ObjectAnimator f12286ag;

    /* renamed from: ah  reason: collision with root package name */
    private AlertDialog f12287ah;

    /* renamed from: ai  reason: collision with root package name */
    private AlertDialog f12288ai;
    /* access modifiers changed from: private */

    /* renamed from: aj  reason: collision with root package name */
    public boolean f12289aj = false;

    /* renamed from: ak  reason: collision with root package name */
    private al f12290ak;

    /* renamed from: al  reason: collision with root package name */
    private c f12291al;
    /* access modifiers changed from: private */

    /* renamed from: am  reason: collision with root package name */
    public boolean f12292am = false;
    /* access modifiers changed from: private */

    /* renamed from: an  reason: collision with root package name */
    public String f12293an;

    /* renamed from: ao  reason: collision with root package name */
    private ImuCalibrationDialog f12294ao;

    /* renamed from: ap  reason: collision with root package name */
    private c f12295ap;

    /* renamed from: b  reason: collision with root package name */
    private g f12296b;

    /* renamed from: c  reason: collision with root package name */
    private FlightInfoFragment f12297c;

    /* renamed from: k  reason: collision with root package name */
    private DroneControlFragment f12298k;

    /* renamed from: l  reason: collision with root package name */
    private FragmentManager f12299l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public StickOperateFragment f12300m;

    /* renamed from: n  reason: collision with root package name */
    private IButton f12301n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f12302o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f12303p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public DroneIndicatorView f12304q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f12305r;

    /* renamed from: s  reason: collision with root package name */
    private int f12306s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f12307t;

    /* renamed from: u  reason: collision with root package name */
    private float f12308u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f12309v;

    /* renamed from: w  reason: collision with root package name */
    private int f12310w = 0;

    /* renamed from: x  reason: collision with root package name */
    private ConstraintLayout f12311x;

    /* renamed from: y  reason: collision with root package name */
    private View f12312y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public ef.a f12313z;

    private enum AvoidanceLevel {
        ONE,
        TWO,
        THREE;

        public static AvoidanceLevel a(int i2) {
            if (i2 >= 60 && i2 <= 150) {
                return ONE;
            }
            if (i2 >= 40 && i2 < 60) {
                return TWO;
            }
            if (i2 < 40) {
                return THREE;
            }
            return null;
        }
    }

    private enum OrientationType {
        LEFT,
        RIGHT,
        FRONT,
        BEHIND,
        TOP;

        public static OrientationType a(int i2) {
            if (i2 == 1) {
                return FRONT;
            }
            if (i2 > 1 && i2 < 5) {
                return RIGHT;
            }
            if (i2 == 5) {
                return BEHIND;
            }
            if (i2 > 5 && i2 < 9) {
                return LEFT;
            }
            if (i2 == 9) {
                return TOP;
            }
            return null;
        }
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f22141b;

        /* renamed from: c  reason: collision with root package name */
        private View f22142c;

        public a(String str, View view) {
            this.f22141b = str;
            this.f22142c = view;
        }

        public String a() {
            return this.f22141b;
        }

        public void run() {
            FlightActionActivity.this.K.removeView(this.f22142c);
            if (this.f22141b.equals(FlightActionActivity.this.f12293an)) {
                String unused = FlightActionActivity.this.f12293an = null;
            }
            synchronized (FlightActionActivity.this.J) {
                FlightActionActivity.this.J.remove(this);
            }
        }
    }

    private void a(int i2) {
        this.f12309v.setImageResource(i2);
    }

    private void a(View view) {
        if (this.f12285af == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, -100.0f, 0.0f});
            this.f12285af = ofFloat;
            ofFloat.setDuration(1000);
            this.f12285af.setInterpolator(new LinearInterpolator());
            this.f12285af.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FlightActionActivity.this.f12286ag.start();
                }
            });
        }
        if (this.f12286ag == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, 100.0f, 0.0f});
            this.f12286ag = ofFloat2;
            ofFloat2.setDuration(1000);
            this.f12286ag.setInterpolator(new LinearInterpolator());
            this.f12286ag.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FlightActionActivity.this.f12285af.start();
                }
            });
        }
        this.f12286ag.start();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (str != null) {
            String str2 = this.f12293an;
            if (str2 == null || !str2.equals(str)) {
                synchronized (this.J) {
                    for (a a2 : this.J) {
                        if (a2.a().equals(str)) {
                            return;
                        }
                    }
                    View inflate = View.inflate(this, R.layout.toast_view_layout, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
                    this.K.addView(inflate, 0);
                    a aVar = new a(str, inflate);
                    synchronized (this.J) {
                        this.J.add(aVar);
                    }
                    this.K.postDelayed(aVar, 4000);
                    this.f12293an = str;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f12359h) {
            org.greenrobot.eventbus.c.a().d(new be(true));
        }
    }

    private void b(boolean z2) {
        IButton iButton;
        int i2;
        if (z2) {
            this.f12301n.bringToFront();
            this.f12302o.bringToFront();
            this.f12303p.bringToFront();
            iButton = this.f12301n;
            i2 = 0;
        } else {
            iButton = this.f12301n;
            i2 = 8;
        }
        iButton.setVisibility(i2);
        this.f12302o.setVisibility(i2);
        this.f12303p.setVisibility(i2);
    }

    private void j() {
        s sVar;
        s sVar2;
        this.J = new ArrayList();
        this.f12299l = getSupportFragmentManager();
        XEagleApp xEagleApp = (XEagleApp) getApplication().getApplicationContext();
        this.H = xEagleApp;
        this.I = xEagleApp.j();
        this.H.i().c();
        if (this.f12298k == null) {
            this.f12298k = new DroneControlFragment();
        }
        if (this.f12296b == null) {
            this.f12296b = new g();
        }
        if (!this.f12298k.isAdded()) {
            this.f12299l.a().a((Fragment) this.f12298k).d();
            this.f12298k = new DroneControlFragment();
            sVar = this.f12299l.a().a((int) R.id.big_container, (Fragment) this.f12298k, "dca");
        } else {
            sVar = this.f12299l.a().c((Fragment) this.f12298k);
        }
        sVar.d();
        if (!this.f12296b.isAdded()) {
            this.f12299l.a().a((Fragment) this.f12296b).d();
            this.f12296b = new g();
            sVar2 = this.f12299l.a().a((int) R.id.small_container, (Fragment) this.f12296b, "wpa");
        } else {
            sVar2 = this.f12299l.a().c((Fragment) this.f12296b);
        }
        sVar2.d();
        StickOperateFragment stickOperateFragment = (StickOperateFragment) getSupportFragmentManager().d((int) R.id.flight_operate);
        this.f12300m = stickOperateFragment;
        if (stickOperateFragment == null) {
            this.f12300m = new StickOperateFragment();
        }
        getSupportFragmentManager().a().b(R.id.flight_operate, this.f12300m).d();
    }

    private void k() {
        float f2;
        Context context;
        this.f12313z = new ef.a(i.f27244a, i.f27244a);
        this.A = new ef.a(i.f27244a, i.f27244a);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_tip_layout);
        this.K = linearLayout;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) linearLayout.getLayoutParams();
        Log.i("FlightActionActivity", "initView: ====" + com.xeagle.android.utils.c.a(getRequestedOrientation()));
        layoutParams.f2569i = R.id.flightInfoFragment;
        if (com.xeagle.android.utils.c.a(getRequestedOrientation())) {
            layoutParams.setMarginStart(com.xeagle.android.utils.c.a(getApplicationContext(), 120.0f));
            context = getApplicationContext();
            f2 = 50.0f;
        } else {
            layoutParams.setMarginStart(com.xeagle.android.utils.c.a(getApplicationContext(), 10.0f));
            context = getApplicationContext();
            f2 = 140.0f;
        }
        layoutParams.topMargin = com.xeagle.android.utils.c.a(context, f2);
        this.K.setLayoutParams(layoutParams);
        this.L = findViewById(R.id.rl_avoidance_left_layout);
        this.M = findViewById(R.id.rl_avoidance_right_layout);
        this.N = findViewById(R.id.rl_avoidance_front_layout);
        this.O = findViewById(R.id.rl_avoidance_behind_layout);
        this.P = findViewById(R.id.rl_avoidance_top_layout);
        this.Q = (ImageView) this.L.findViewById(R.id.iv_avoidance_left_level);
        this.R = (TextView) this.L.findViewById(R.id.tv_left_avoidance_distance);
        this.S = (ImageView) this.M.findViewById(R.id.iv_avoidance_right_level);
        this.T = (TextView) this.M.findViewById(R.id.tv_right_avoidance_distance);
        this.U = (ImageView) this.N.findViewById(R.id.iv_avoidance_front_level);
        this.V = (TextView) this.N.findViewById(R.id.tv_front_avoidance_distance);
        this.W = (ImageView) this.O.findViewById(R.id.iv_avoidance_behind_level);
        this.X = (TextView) this.O.findViewById(R.id.tv_behind_avoidance_distance);
        this.Y = (ImageView) this.P.findViewById(R.id.iv_avoidance_top_level);
        this.Z = (TextView) this.P.findViewById(R.id.tv_top_avoidance_distance);
        this.f12280aa = (ImageView) findViewById(R.id.iv_avoidance_warning_mask);
        this.F = findViewById(R.id.flightInfoFragment);
        this.G = findViewById(R.id.flight_operate);
        this.f12304q = (DroneIndicatorView) findViewById(R.id.drone_indicator);
        FlightInfoFragment flightInfoFragment = (FlightInfoFragment) getSupportFragmentManager().d((int) R.id.flightInfoFragment);
        this.f12297c = flightInfoFragment;
        if (flightInfoFragment == null) {
            this.f12297c = new FlightInfoFragment();
        }
        getSupportFragmentManager().a().b(R.id.flightInfoFragment, this.f12297c).d();
        this.E = (RoundRelativeLayout) findViewById(R.id.small_container);
        this.C = findViewById(R.id.big_container);
        this.f12301n = (IButton) findViewById(R.id.send_mode_ib);
        this.f12302o = (ImageView) findViewById(R.id.focuse_indicator);
        this.f12303p = (TextView) findViewById(R.id.focuse_tv);
        this.f12301n.setOnClickListener(this);
        this.f12311x = (ConstraintLayout) findViewById(R.id.cl_main_view);
        ImageView imageView = (ImageView) findViewById(R.id.iv_newer_guide);
        this.f12309v = imageView;
        imageView.setOnClickListener(this);
        this.f12312y = findViewById(R.id.layout_visual_follow_guide);
        findViewById(R.id.tv_visual_follow_guide).setOnClickListener(this);
        this.f12304q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightActionActivity.this.b(view);
            }
        });
    }

    private void l() {
        int i2;
        int i3 = this.f12310w + 1;
        this.f12310w = i3;
        switch (i3) {
            case 1:
                i2 = R.drawable.newer_guide_second;
                break;
            case 2:
                i2 = R.drawable.newer_guide_third;
                break;
            case 3:
                i2 = R.drawable.newer_guide_forth;
                break;
            case 4:
                i2 = R.drawable.newer_guide_fifth;
                break;
            case 5:
                i2 = R.drawable.newer_guide_sixth;
                break;
            case 6:
                i2 = R.drawable.newer_guide_seventh;
                break;
            case 7:
                this.I.g(false);
                this.f12309v.setVisibility(8);
                this.f12311x.setVisibility(0);
                return;
            default:
                return;
        }
        a(i2);
    }

    /* access modifiers changed from: private */
    public void m() {
        Log.i(Promotion.ACTION_VIEW, "switchView: ----->>>" + this.f12359h);
        if (this.f12359h) {
            com.transitionseverywhere.e.a(this.E, new ChangeBounds().a((PathMotion) new ArcMotion()).a(0).a((TimeInterpolator) new DecelerateInterpolator()).a((Transition.c) new Transition.c() {
                public void a(Transition transition) {
                }

                public void b(Transition transition) {
                    c a2;
                    if (!FlightActionActivity.this.f12359h && (a2 = r.a().a(FlightActionActivity.this.getString(R.string.dialog_tips), FlightActionActivity.this.getString(R.string.way_point_warn), (c.a) new c.a() {
                        public void onYes() {
                        }
                    })) != null) {
                        a2.show(FlightActionActivity.this.getSupportFragmentManager(), "wayPoint");
                    }
                }

                public void c(Transition transition) {
                }

                public void d(Transition transition) {
                }

                public void e(Transition transition) {
                }
            }));
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.E.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams2.width = (int) getResources().getDimension(R.dimen.dp_130);
            layoutParams2.height = (int) getResources().getDimension(R.dimen.dp_65);
            if (Locale.getDefault().getCountry().equalsIgnoreCase("IR")) {
                layoutParams2.f2564d = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            } else {
                layoutParams2.f2567g = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            }
            layoutParams2.f2568h = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            this.C.setLayoutParams(layoutParams2);
            this.C.bringToFront();
            this.F.bringToFront();
            this.G.bringToFront();
            this.f12359h = false;
            this.E.setMap(false);
            this.f12304q.setVisibility(8);
        } else {
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            this.C.setLayoutParams(layoutParams3);
            com.transitionseverywhere.e.a(this.E, new ChangeBounds().a((PathMotion) new ArcMotion()).a(0).a((TimeInterpolator) new DecelerateInterpolator()));
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams4.width = (int) getResources().getDimension(R.dimen.dp_130);
            layoutParams4.height = (int) getResources().getDimension(R.dimen.dp_65);
            if (Locale.getDefault().getCountry().equalsIgnoreCase("IR")) {
                layoutParams4.f2564d = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            } else {
                layoutParams4.f2567g = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            }
            layoutParams4.f2568h = com.xeagle.android.utils.c.a(getApplicationContext(), 1.0f);
            this.E.setLayoutParams(layoutParams4);
            this.f12311x.bringToFront();
            this.E.bringToFront();
            this.F.bringToFront();
            this.G.bringToFront();
            this.f12359h = true;
            this.E.setMap(true);
            this.f12304q.setVisibility(0);
            this.f12304q.bringToFront();
            this.K.bringToFront();
            this.L.bringToFront();
            this.M.bringToFront();
            this.N.bringToFront();
            this.O.bringToFront();
            this.P.bringToFront();
            this.f12280aa.bringToFront();
        }
        Log.i(Promotion.ACTION_VIEW, "switchView:---finish---->>> " + this.f12359h);
        org.greenrobot.eventbus.c.a().d(new ar(this.f12359h));
    }

    private void n() {
        o();
        ab.b().a((int) R.raw.avoidance_warn);
        Timer timer = this.f12281ab;
        if (timer != null) {
            timer.cancel();
            this.f12281ab = null;
        }
    }

    private void o() {
        if (this.f12284ae) {
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
            this.P.setVisibility(8);
            if (this.f12280aa.getVisibility() != 8) {
                this.f12280aa.clearAnimation();
                this.f12280aa.setVisibility(8);
            }
            Timer timer = this.f12282ac;
            if (timer != null) {
                timer.cancel();
                this.f12282ac = null;
            }
            this.f12284ae = false;
        }
    }

    private void p() {
        ObjectAnimator objectAnimator = this.f12285af;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.f12285af.cancel();
            }
            this.f12285af.removeAllListeners();
            this.f12285af = null;
        }
        ObjectAnimator objectAnimator2 = this.f12286ag;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f12286ag.cancel();
            }
            this.f12286ag.removeAllListeners();
            this.f12286ag = null;
        }
    }

    private void q() {
        AlertDialog alertDialog = this.f12287ah;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.stop_record_tip);
            builder.setTitle(R.string.hint);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.f14099ok, (DialogInterface.OnClickListener) null);
            AlertDialog create = builder.create();
            this.f12287ah = create;
            create.show();
        }
    }

    private void r() {
        AlertDialog alertDialog = this.f12288ai;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.not_more_power_return_avoidance);
            builder.setTitle(R.string.hint);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.f14099ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (FlightActionActivity.this.f12282ac != null) {
                        FlightActionActivity.this.f12282ac.cancel();
                        Timer unused = FlightActionActivity.this.f12282ac = null;
                    }
                    Timer unused2 = FlightActionActivity.this.f12282ac = new Timer();
                    FlightActionActivity.this.f12282ac.schedule(new TimerTask() {
                        public void run() {
                            FlightActionActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (XEagleApp.d().c()) {
                                        String unused = FlightActionActivity.this.f12293an = null;
                                        FlightActionActivity.this.a(FlightActionActivity.this.getString(R.string.not_more_power_return_avoidance_hint));
                                        return;
                                    }
                                    FlightActionActivity.this.f12282ac.cancel();
                                    Timer unused2 = FlightActionActivity.this.f12282ac = null;
                                }
                            });
                        }
                    }, 100, 4000);
                }
            });
            AlertDialog create = builder.create();
            this.f12288ai = create;
            create.show();
        }
    }

    private void s() {
        this.K.postDelayed(new Runnable() {
            public void run() {
                Log.i("newUI", "run: ---circle--" + FlightActionActivity.this.f12289aj);
                if (FlightActionActivity.this.f12289aj) {
                    return;
                }
                if (FlightActionActivity.this.f12292am) {
                    boolean unused = FlightActionActivity.this.f12292am = false;
                    return;
                }
                boolean unused2 = FlightActionActivity.this.f12305r = false;
                FlightActionActivity.this.cancelShootMode(new b("operateFragment"));
            }
        }, 3000);
    }

    private void t() {
        this.f12279a.a((Object) null);
        this.f12279a = null;
    }

    @l(a = ThreadMode.MAIN)
    public void BatteryStateEvent(dy.i iVar) {
        DroneIndicatorView droneIndicatorView = this.f12304q;
        if (droneIndicatorView != null) {
            droneIndicatorView.setConnected(true);
        }
    }

    public void a() {
        FlightInfoFragment flightInfoFragment = this.f12297c;
        if (flightInfoFragment != null) {
            flightInfoFragment.a();
        }
    }

    public void a(boolean z2) {
        DroneIndicatorView droneIndicatorView;
        int i2;
        if (z2) {
            this.f12300m.c(true);
            droneIndicatorView = this.f12304q;
            i2 = 8;
        } else {
            i2 = 0;
            this.f12300m.c(false);
            droneIndicatorView = this.f12304q;
        }
        droneIndicatorView.setVisibility(i2);
        this.E.setVisibility(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0238  */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void avoidanceEvent(dy.f r11) {
        /*
            r10 = this;
            com.xeagle.android.utils.prefs.a r0 = r10.I
            java.lang.String r0 = r0.j()
            boolean r0 = com.xeagle.android.utils.g.b(r0)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            com.MAVLink.common.msg_complex_data r0 = r11.a()
            boolean r0 = r0.h()
            com.xeagle.android.utils.prefs.a r1 = r10.I
            r1.s((boolean) r0)
            com.MAVLink.common.msg_complex_data r1 = r11.a()
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x02bb
            if (r0 != 0) goto L_0x0028
            goto L_0x02bb
        L_0x0028:
            com.MAVLink.common.msg_complex_data r0 = r11.a()
            int r0 = r0.f()
            r1 = 100
            if (r0 <= r1) goto L_0x0038
            r10.n()
            return
        L_0x0038:
            float r1 = (float) r0
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r0 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.a(r0)
            if (r0 != 0) goto L_0x0046
            r10.n()
            return
        L_0x0046:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r2 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            r3 = 0
            if (r2 == r0) goto L_0x005a
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r2 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.THREE
            if (r2 != r0) goto L_0x0050
            goto L_0x005a
        L_0x0050:
            java.util.Timer r2 = r10.f12281ab
            if (r2 == 0) goto L_0x0079
            r2.cancel()
            r10.f12281ab = r3
            goto L_0x0079
        L_0x005a:
            com.xeagle.android.utils.prefs.a r2 = r10.I
            boolean r2 = r2.I()
            if (r2 == 0) goto L_0x0079
            java.util.Timer r2 = r10.f12281ab
            if (r2 != 0) goto L_0x0079
            java.util.Timer r4 = new java.util.Timer
            r4.<init>()
            r10.f12281ab = r4
            com.xeagle.android.activities.FlightActionActivity$4 r5 = new com.xeagle.android.activities.FlightActionActivity$4
            r5.<init>()
            r6 = 100
            r8 = 8000(0x1f40, double:3.9525E-320)
            r4.schedule(r5, r6, r8)
        L_0x0079:
            com.xeagle.android.utils.prefs.a r2 = r10.I
            boolean r2 = r2.aW()
            if (r2 != 0) goto L_0x0085
            r10.o()
            return
        L_0x0085:
            com.MAVLink.common.msg_complex_data r2 = r11.a()
            int r2 = r2.e()
            com.xeagle.android.activities.FlightActionActivity$OrientationType r2 = com.xeagle.android.activities.FlightActionActivity.OrientationType.a(r2)
            if (r2 != 0) goto L_0x0094
            return
        L_0x0094:
            r4 = 1
            r10.f12284ae = r4
            com.xeagle.android.activities.FlightActionActivity$OrientationType r5 = com.xeagle.android.activities.FlightActionActivity.OrientationType.FRONT
            java.lang.String r6 = "%.1fM"
            r7 = 0
            r8 = 8
            if (r5 != r2) goto L_0x00e6
            android.view.View r5 = r10.L
            r5.setVisibility(r8)
            android.view.View r5 = r10.M
            r5.setVisibility(r8)
            android.view.View r5 = r10.N
            r5.setVisibility(r7)
            android.view.View r5 = r10.O
            r5.setVisibility(r8)
            android.view.View r5 = r10.P
            r5.setVisibility(r8)
            r10.p()
            r5 = 2131232068(0x7f080544, float:1.8080235E38)
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.ONE
            if (r9 != r0) goto L_0x00c7
            r5 = 2131232066(0x7f080542, float:1.808023E38)
            goto L_0x00ce
        L_0x00c7:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r9 != r0) goto L_0x00ce
            r5 = 2131232067(0x7f080543, float:1.8080233E38)
        L_0x00ce:
            android.widget.ImageView r9 = r10.U
            r9.setImageResource(r5)
            android.widget.TextView r5 = r10.V
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r9[r7] = r1
            java.lang.String r1 = java.lang.String.format(r6, r9)
        L_0x00e1:
            r5.setText(r1)
            goto L_0x0213
        L_0x00e6:
            com.xeagle.android.activities.FlightActionActivity$OrientationType r5 = com.xeagle.android.activities.FlightActionActivity.OrientationType.RIGHT
            if (r5 != r2) goto L_0x012c
            android.view.View r5 = r10.L
            r5.setVisibility(r8)
            android.view.View r5 = r10.M
            r5.setVisibility(r7)
            android.view.View r5 = r10.N
            r5.setVisibility(r8)
            android.view.View r5 = r10.O
            r5.setVisibility(r8)
            android.view.View r5 = r10.P
            r5.setVisibility(r8)
            r10.p()
            r5 = 2131232074(0x7f08054a, float:1.8080247E38)
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.ONE
            if (r9 != r0) goto L_0x0111
            r5 = 2131232072(0x7f080548, float:1.8080243E38)
            goto L_0x0118
        L_0x0111:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r9 != r0) goto L_0x0118
            r5 = 2131232073(0x7f080549, float:1.8080245E38)
        L_0x0118:
            android.widget.ImageView r9 = r10.S
            r9.setImageResource(r5)
            android.widget.TextView r5 = r10.T
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r9[r7] = r1
            java.lang.String r1 = java.lang.String.format(r6, r9)
            goto L_0x00e1
        L_0x012c:
            com.xeagle.android.activities.FlightActionActivity$OrientationType r5 = com.xeagle.android.activities.FlightActionActivity.OrientationType.BEHIND
            if (r5 != r2) goto L_0x0173
            android.view.View r5 = r10.L
            r5.setVisibility(r8)
            android.view.View r5 = r10.M
            r5.setVisibility(r8)
            android.view.View r5 = r10.N
            r5.setVisibility(r8)
            android.view.View r5 = r10.O
            r5.setVisibility(r7)
            android.view.View r5 = r10.P
            r5.setVisibility(r8)
            r10.p()
            r5 = 2131232065(0x7f080541, float:1.8080229E38)
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.ONE
            if (r9 != r0) goto L_0x0157
            r5 = 2131232063(0x7f08053f, float:1.8080225E38)
            goto L_0x015e
        L_0x0157:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r9 != r0) goto L_0x015e
            r5 = 2131232064(0x7f080540, float:1.8080227E38)
        L_0x015e:
            android.widget.ImageView r9 = r10.W
            r9.setImageResource(r5)
            android.widget.TextView r5 = r10.X
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r9[r7] = r1
            java.lang.String r1 = java.lang.String.format(r6, r9)
            goto L_0x00e1
        L_0x0173:
            com.xeagle.android.activities.FlightActionActivity$OrientationType r5 = com.xeagle.android.activities.FlightActionActivity.OrientationType.LEFT
            if (r5 != r2) goto L_0x01ba
            android.view.View r5 = r10.L
            r5.setVisibility(r7)
            android.view.View r5 = r10.M
            r5.setVisibility(r8)
            android.view.View r5 = r10.N
            r5.setVisibility(r8)
            android.view.View r5 = r10.O
            r5.setVisibility(r8)
            android.view.View r5 = r10.P
            r5.setVisibility(r8)
            r10.p()
            r5 = 2131232071(0x7f080547, float:1.808024E38)
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.ONE
            if (r9 != r0) goto L_0x019e
            r5 = 2131232069(0x7f080545, float:1.8080237E38)
            goto L_0x01a5
        L_0x019e:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r9 != r0) goto L_0x01a5
            r5 = 2131232070(0x7f080546, float:1.8080239E38)
        L_0x01a5:
            android.widget.ImageView r9 = r10.Q
            r9.setImageResource(r5)
            android.widget.TextView r5 = r10.R
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r9[r7] = r1
            java.lang.String r1 = java.lang.String.format(r6, r9)
            goto L_0x00e1
        L_0x01ba:
            com.xeagle.android.activities.FlightActionActivity$OrientationType r5 = com.xeagle.android.activities.FlightActionActivity.OrientationType.TOP
            if (r5 != r2) goto L_0x0213
            android.view.View r5 = r10.P
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x01cb
            android.animation.ObjectAnimator r5 = r10.f12285af
            if (r5 == 0) goto L_0x01cb
            return
        L_0x01cb:
            android.view.View r5 = r10.L
            r5.setVisibility(r8)
            android.view.View r5 = r10.M
            r5.setVisibility(r8)
            android.view.View r5 = r10.N
            r5.setVisibility(r8)
            android.view.View r5 = r10.O
            r5.setVisibility(r8)
            android.view.View r5 = r10.P
            r5.setVisibility(r7)
            r5 = 2131232077(0x7f08054d, float:1.8080253E38)
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.ONE
            if (r9 != r0) goto L_0x01ef
            r5 = 2131232075(0x7f08054b, float:1.808025E38)
            goto L_0x01f6
        L_0x01ef:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r9 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r9 != r0) goto L_0x01f6
            r5 = 2131232076(0x7f08054c, float:1.8080251E38)
        L_0x01f6:
            android.widget.ImageView r9 = r10.Y
            r9.setImageResource(r5)
            r10.p()
            android.widget.ImageView r5 = r10.Y
            r10.a((android.view.View) r5)
            android.widget.TextView r5 = r10.Z
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r9[r7] = r1
            java.lang.String r1 = java.lang.String.format(r6, r9)
            goto L_0x00e1
        L_0x0213:
            com.MAVLink.common.msg_complex_data r11 = r11.a()
            boolean r11 = r11.a()
            if (r11 == 0) goto L_0x0238
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r11 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.THREE
            if (r0 != r11) goto L_0x022e
            r11 = 2131822181(0x7f110665, float:1.9277126E38)
            java.lang.String r11 = r10.getString(r11)
            r10.a((java.lang.String) r11)
            r10.f12283ad = r4
            goto L_0x0270
        L_0x022e:
            boolean r11 = r10.f12283ad
            if (r11 == 0) goto L_0x0270
            r10.r()
            r10.f12283ad = r7
            goto L_0x0270
        L_0x0238:
            int r11 = r10.f12306s
            if (r11 != r4) goto L_0x024d
            com.xeagle.android.activities.FlightActionActivity$OrientationType r11 = com.xeagle.android.activities.FlightActionActivity.OrientationType.FRONT
            if (r2 != r11) goto L_0x0267
            r10.f12293an = r3
            r11 = 2131822810(0x7f1108da, float:1.9278402E38)
            java.lang.String r11 = r10.getString(r11)
            r10.a((java.lang.String) r11)
            goto L_0x0267
        L_0x024d:
            r1 = 9
            if (r11 == r1) goto L_0x0267
            r1 = 10
            if (r11 == r1) goto L_0x0267
            r1 = 3
            if (r11 == r1) goto L_0x0267
            if (r11 == 0) goto L_0x0267
            jo.b r11 = new jo.b
            java.lang.String r1 = "operateFragment"
            r11.<init>(r1)
            r10.cancelShootMode(r11)
            r10.q()
        L_0x0267:
            java.util.Timer r11 = r10.f12282ac
            if (r11 == 0) goto L_0x0270
            r11.cancel()
            r10.f12282ac = r3
        L_0x0270:
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r11 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.TWO
            if (r11 == r0) goto L_0x028c
            com.xeagle.android.activities.FlightActionActivity$AvoidanceLevel r11 = com.xeagle.android.activities.FlightActionActivity.AvoidanceLevel.THREE
            if (r11 != r0) goto L_0x0279
            goto L_0x028c
        L_0x0279:
            android.widget.ImageView r11 = r10.f12280aa
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x02ba
            android.widget.ImageView r11 = r10.f12280aa
            r11.clearAnimation()
            android.widget.ImageView r11 = r10.f12280aa
            r11.setVisibility(r8)
            goto L_0x02ba
        L_0x028c:
            android.widget.ImageView r11 = r10.f12280aa
            int r11 = r11.getVisibility()
            if (r11 == 0) goto L_0x02ba
            android.widget.ImageView r11 = r10.f12280aa
            r11.setVisibility(r7)
            android.view.animation.AlphaAnimation r11 = new android.view.animation.AlphaAnimation
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r11.<init>(r0, r1)
            r0 = 2000(0x7d0, double:9.88E-321)
            r11.setDuration(r0)
            r0 = -1
            r11.setRepeatCount(r0)
            r11.setFillAfter(r4)
            android.view.animation.LinearInterpolator r0 = new android.view.animation.LinearInterpolator
            r0.<init>()
            r11.setInterpolator(r0)
            android.widget.ImageView r0 = r10.f12280aa
            r0.startAnimation(r11)
        L_0x02ba:
            return
        L_0x02bb:
            r10.n()
            int r0 = r10.f12306s
            if (r0 == 0) goto L_0x02cc
            r0 = 2131822726(0x7f110886, float:1.9278232E38)
            java.lang.String r0 = r10.getString(r0)
            r10.a((java.lang.String) r0)
        L_0x02cc:
            com.MAVLink.common.msg_complex_data r11 = r11.a()
            boolean r11 = r11.a()
            if (r11 == 0) goto L_0x02e0
            r11 = 2131822535(0x7f1107c7, float:1.9277844E38)
            java.lang.String r11 = r10.getString(r11)
            r10.a((java.lang.String) r11)
        L_0x02e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.FlightActionActivity.avoidanceEvent(dy.f):void");
    }

    public void b() {
        this.f12304q.setVisibility(8);
        this.E.setVisibility(0);
        this.f12300m.c(false);
        this.f12297c.a(false);
    }

    @l(a = ThreadMode.MAIN)
    public void beyondLimitEvent(dy.a aVar) {
        this.f12292am = true;
        if (aVar.a().equalsIgnoreCase(getString(R.string.beyond_radius))) {
            if (this.f12291al == null) {
                this.f12291al = r.a().a(getString(R.string.warning), aVar.a(), (c.a) new c.a() {
                    public void onYes() {
                    }
                });
            }
            if (!this.f12291al.isAdded()) {
                if (this.f12301n.getVisibility() == 8) {
                    b(true);
                    DroneControlFragment droneControlFragment = this.f12298k;
                    if (droneControlFragment != null) {
                        droneControlFragment.a(false, 7);
                    }
                    StickOperateFragment stickOperateFragment = this.f12300m;
                    if (stickOperateFragment != null) {
                        stickOperateFragment.b(false);
                    }
                }
                this.f12291al.show(getSupportFragmentManager(), "beyondLimit");
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void cancelShootMode(b bVar) {
        g gVar;
        if ("operateFragment".equalsIgnoreCase(bVar.a())) {
            if (this.f12306s == 2 && (gVar = this.f12296b) != null) {
                gVar.d();
            }
            this.f12289aj = false;
            int i2 = this.f12306s;
            if (i2 <= 8 && i2 >= 3) {
                this.f12298k.a(DroneControlFragment.VisionModeStatus.STOP);
            }
            if (this.f12301n.getVisibility() == 0 || this.f12306s == 8) {
                b(false);
                DroneControlFragment droneControlFragment = this.f12298k;
                if (droneControlFragment != null) {
                    droneControlFragment.a(true, 3);
                }
                StickOperateFragment stickOperateFragment = this.f12300m;
                if (stickOperateFragment != null) {
                    stickOperateFragment.a(false, 5);
                    this.f12300m.a(0);
                    this.f12300m.b(false, 0);
                    this.f12300m.b(true);
                }
            }
            this.f12306s = 0;
            DroneControlFragment droneControlFragment2 = this.f12298k;
            if (droneControlFragment2 != null) {
                droneControlFragment2.a(0);
            }
            if (!this.f12359h) {
                this.C.setVisibility(0);
                m();
            }
        }
    }

    public boolean d() {
        DroneControlFragment droneControlFragment = this.f12298k;
        if (droneControlFragment != null) {
            return droneControlFragment.d();
        }
        Log.i("FlightActionActivity", "isSdCardEnough: ======is null");
        return false;
    }

    public void e() {
        c cVar = this.f12295ap;
        if (cVar != null && cVar.isAdded()) {
            this.f12295ap.dismiss();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void failSafeWarn(ad adVar) {
        km.a i2;
        int i3;
        String f2 = this.f12358g.d().f();
        if (f2 == null || !f2.equalsIgnoreCase(getString(R.string.prearm_acc_cal_detail))) {
            if (!this.f12358g.x().d()) {
                a(f2);
                String str = this.f12293an;
                if (str != null && str.equals(getString(R.string.acc_cal_reboot))) {
                    return;
                }
            } else {
                return;
            }
        } else if (!this.H.m().g()) {
            if (this.f12294ao == null) {
                this.f12294ao = ImuCalibrationDialog.a("imu", (ImuCalibrationDialog.a) new ImuCalibrationDialog.a() {
                });
            }
            if (!this.f12294ao.isAdded()) {
                this.f12294ao.show(getSupportFragmentManager(), "imuCalibration");
            }
        } else {
            return;
        }
        if (f2 != null) {
            if (f2.equalsIgnoreCase(getString(R.string.gimbal_tips))) {
                i2 = this.H.i();
                i3 = R.string.tts_gimbal_tips;
            } else if (f2.equalsIgnoreCase(getString(R.string.battert_invalid))) {
                i2 = this.H.i();
                i3 = R.string.tts_battery_invalid;
            } else if (f2.equalsIgnoreCase(getString(R.string.prearm_acc_cal_detail)) || f2.equalsIgnoreCase(getString(R.string.gps_not_locked))) {
                this.H.i().a(f2, false);
                return;
            } else {
                this.H.i().a(f2, adVar.b());
                return;
            }
            i2.a(getString(i3), adVar.b());
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void gpsEvent(p pVar) {
        if (pVar.a() == 23 && this.H.p().c() != null) {
            if (!(this.A.d() == this.H.p().c().getLatitude() && this.A.c() == this.H.p().c().getLongitude())) {
                this.A.a(this.H.p().c().getLatitude(), this.H.p().c().getLongitude());
            }
            if (!(this.f12313z.d() == this.f12358g.b().b().d() && this.f12313z.c() == this.f12358g.b().b().c())) {
                this.f12313z.a(this.f12358g.b().b().d(), this.f12358g.b().b().c());
            }
            runOnUiThread(new Runnable() {
                public void run() {
                    FlightActionActivity.this.f12304q.a(FlightActionActivity.this.f12313z, FlightActionActivity.this.A, FlightActionActivity.this.f12307t);
                }
            });
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeStateEvent(dy.s sVar) {
        String b2 = this.f12358g.d().e().b();
        if (this.f12359h || this.I.aG() != 2) {
            org.greenrobot.eventbus.c.a().d(new jo.ad(b2));
            if (b2.equalsIgnoreCase(ApmModes.ROTOR_LOITER.b()) || b2.equalsIgnoreCase(ApmModes.ROTOR_ALT_HOLD.b()) || b2.equalsIgnoreCase(ApmModes.ROTOR_RTL.b()) || b2.equalsIgnoreCase(ApmModes.ROTOR_LAND.b())) {
                if (this.f12306s != 8 || b2.equalsIgnoreCase(ApmModes.ROTOR_RTL.b()) || b2.equalsIgnoreCase(ApmModes.ROTOR_LAND.b())) {
                    this.f12298k.a(DroneControlFragment.VisionModeStatus.STOP);
                    if (this.f12306s != 0) {
                        this.f12305r = false;
                        this.f12306s = 0;
                        this.f12300m.b(false, 0);
                        this.f12300m.a(false);
                        this.f12300m.a(false, 3);
                        this.f12300m.a(0);
                        this.f12289aj = false;
                        if (this.f12301n.getVisibility() == 0) {
                            b(false);
                            DroneControlFragment droneControlFragment = this.f12298k;
                            if (droneControlFragment != null) {
                                droneControlFragment.a(true, 2);
                            }
                        }
                    }
                }
            } else if (this.f12301n.getVisibility() == 0) {
                b(false);
                DroneControlFragment droneControlFragment2 = this.f12298k;
                if (droneControlFragment2 != null) {
                    droneControlFragment2.a(true, 4);
                }
                StickOperateFragment stickOperateFragment = this.f12300m;
                if (stickOperateFragment != null) {
                    stickOperateFragment.b(true);
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f2, code lost:
        r5 = r14.f12290ak.e();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011e, code lost:
        com.flypro.core.MAVLink.p.a(r3, r4, r5, r6, r7, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0122, code lost:
        s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015a, code lost:
        r14.I.q(r14.f12290ak.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x016b, code lost:
        if (r14.f12290ak.b() != 8) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016d, code lost:
        r14.f12298k.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r15) {
        /*
            r14 = this;
            int r15 = r15.getId()
            r0 = 2131297637(0x7f090565, float:1.8213225E38)
            r1 = 0
            if (r15 == r0) goto L_0x0174
            r0 = 2131298772(0x7f0909d4, float:1.8215527E38)
            r2 = 8
            if (r15 == r0) goto L_0x0039
            r0 = 2131299568(0x7f090cf0, float:1.8217141E38)
            if (r15 == r0) goto L_0x0018
            goto L_0x017c
        L_0x0018:
            android.view.View r15 = r14.f12312y
            r15.setVisibility(r2)
            android.view.View r15 = r14.f12312y
            java.lang.Object r15 = r15.getTag()
            dy.az r15 = (dy.az) r15
            java.lang.Runnable r15 = r15.a()
            r15.run()
            android.view.View r15 = r14.f12312y
            r0 = 0
            r15.setTag(r0)
            com.xeagle.android.utils.prefs.a r15 = r14.I
            r15.aP()
            goto L_0x017c
        L_0x0039:
            com.xeagle.android.vjoystick.DroneControlFragment r15 = r14.f12298k
            if (r15 == 0) goto L_0x0173
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r14.f12300m
            if (r0 != 0) goto L_0x0043
            goto L_0x0173
        L_0x0043:
            boolean r0 = r14.f12292am
            if (r0 == 0) goto L_0x004e
            r15 = 2131820780(0x7f1100ec, float:1.9274285E38)
            com.blankj.utilcode.util.ToastUtils.showShort((int) r15)
            return
        L_0x004e:
            boolean r15 = r15.f12898h
            r0 = 1
            if (r15 != 0) goto L_0x005c
            com.xeagle.android.vjoystick.DroneControlFragment r15 = r14.f12298k
            boolean r15 = r15.f12899i
            if (r15 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r7 = 0
            goto L_0x005d
        L_0x005c:
            r7 = 1
        L_0x005d:
            jo.al r15 = r14.f12290ak
            int r15 = r15.b()
            java.lang.String r1 = "FlightActionActivity"
            switch(r15) {
                case 1: goto L_0x0126;
                case 2: goto L_0x0068;
                case 3: goto L_0x00fa;
                case 4: goto L_0x00ef;
                case 5: goto L_0x00de;
                case 6: goto L_0x00cd;
                case 7: goto L_0x00a4;
                case 8: goto L_0x0068;
                case 9: goto L_0x0086;
                case 10: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x015a
        L_0x006a:
            en.a r8 = r14.f12358g
            r9 = 8
            jo.al r15 = r14.f12290ak
            int r10 = r15.e()
            jo.al r15 = r14.f12290ak
            int r11 = r15.d()
            jo.al r15 = r14.f12290ak
            int r12 = r15.a()
            r13 = 1
            com.flypro.core.MAVLink.p.a(r8, r9, r10, r11, r12, r13)
            goto L_0x0122
        L_0x0086:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "onClick: =====panora===="
            r15.append(r0)
            jo.al r0 = r14.f12290ak
            int r0 = r0.e()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            android.util.Log.i(r1, r15)
            en.a r3 = r14.f12358g
            r4 = 6
            goto L_0x00f2
        L_0x00a4:
            jo.al r15 = r14.f12290ak
            int r15 = r15.e()
            if (r15 != r0) goto L_0x00b9
            en.a r15 = r14.f12358g
            com.flypro.core.drone.variables.aa r15 = r15.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_CIRCLE
        L_0x00b4:
            r15.b((com.MAVLink.Messages.ApmModes) r0)
            goto L_0x015a
        L_0x00b9:
            en.a r3 = r14.f12358g
            r4 = 5
            r5 = 0
            r6 = 0
            r8 = 1
            com.flypro.core.MAVLink.p.a(r3, r4, r5, r6, r7, r8)
            boolean r15 = r14.f12305r
            if (r15 != 0) goto L_0x0122
            com.xeagle.android.vjoystick.StickOperateFragment r15 = r14.f12300m
            r1 = 7
        L_0x00c9:
            r15.b((boolean) r0, (int) r1)
            goto L_0x0122
        L_0x00cd:
            en.a r3 = r14.f12358g
            r4 = 4
            r5 = 0
            r6 = 0
            r8 = 1
            com.flypro.core.MAVLink.p.a(r3, r4, r5, r6, r7, r8)
            boolean r15 = r14.f12305r
            if (r15 != 0) goto L_0x0122
            com.xeagle.android.vjoystick.StickOperateFragment r15 = r14.f12300m
            r1 = 6
            goto L_0x00c9
        L_0x00de:
            en.a r3 = r14.f12358g
            r4 = 3
            r5 = 0
            r6 = 0
            r8 = 1
            com.flypro.core.MAVLink.p.a(r3, r4, r5, r6, r7, r8)
            boolean r15 = r14.f12305r
            if (r15 != 0) goto L_0x0122
            com.xeagle.android.vjoystick.StickOperateFragment r15 = r14.f12300m
            r1 = 5
            goto L_0x00c9
        L_0x00ef:
            en.a r3 = r14.f12358g
            r4 = 1
        L_0x00f2:
            jo.al r15 = r14.f12290ak
            int r5 = r15.e()
            r6 = 0
            goto L_0x011e
        L_0x00fa:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "onClick: ====mode=="
            r15.append(r0)
            jo.al r0 = r14.f12290ak
            int r0 = r0.b()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            android.util.Log.i(r1, r15)
            en.a r3 = r14.f12358g
            r4 = 2
            r5 = 0
            jo.al r15 = r14.f12290ak
            int r6 = r15.d()
        L_0x011e:
            r8 = 1
            com.flypro.core.MAVLink.p.a(r3, r4, r5, r6, r7, r8)
        L_0x0122:
            r14.s()
            goto L_0x015a
        L_0x0126:
            com.xeagle.android.XEagleApp r15 = r14.H
            com.flypro.core.gcs.follow.Follow r15 = r15.l()
            if (r15 == 0) goto L_0x015a
            com.xeagle.android.XEagleApp r15 = r14.H
            com.flypro.core.gcs.follow.Follow r15 = r15.l()
            boolean r15 = r15.b()
            if (r15 != 0) goto L_0x015a
            en.a r15 = r14.f12358g
            com.flypro.core.drone.variables.aa r15 = r15.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_GUIDED
            r15.b((com.MAVLink.Messages.ApmModes) r0)
            en.a r15 = r14.f12358g
            com.flypro.core.drone.variables.aa r15 = r15.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_GUIDED
            r15.b((com.MAVLink.Messages.ApmModes) r0)
            en.a r15 = r14.f12358g
            com.flypro.core.drone.variables.aa r15 = r15.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_GUIDED
            goto L_0x00b4
        L_0x015a:
            com.xeagle.android.utils.prefs.a r15 = r14.I
            jo.al r0 = r14.f12290ak
            int r0 = r0.b()
            r15.q((int) r0)
            jo.al r15 = r14.f12290ak
            int r15 = r15.b()
            if (r15 != r2) goto L_0x017c
            com.xeagle.android.vjoystick.DroneControlFragment r15 = r14.f12298k
            r15.e()
            goto L_0x017c
        L_0x0173:
            return
        L_0x0174:
            com.xeagle.android.utils.prefs.a r15 = r14.I
            r15.g((boolean) r1)
            r14.l()
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.FlightActionActivity.onClick(android.view.View):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        float f2;
        Context context;
        super.onConfigurationChanged(configuration);
        Log.i("FlightActionActivity", "onConfigurationChangedqqq: =====" + configuration.orientation);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.K.getLayoutParams();
        if (com.xeagle.android.utils.c.a(getRequestedOrientation())) {
            layoutParams.setMarginStart(com.xeagle.android.utils.c.a(getApplicationContext(), 120.0f));
            context = getApplicationContext();
            f2 = 50.0f;
        } else {
            layoutParams.setMarginStart(com.xeagle.android.utils.c.a(getApplicationContext(), 10.0f));
            context = getApplicationContext();
            f2 = 140.0f;
        }
        layoutParams.topMargin = com.xeagle.android.utils.c.a(context, f2);
        Log.i("FlightActionActivity", "onConfigurationChangedqqq:=== " + layoutParams.getMarginStart() + "===top===" + layoutParams.topMargin);
        this.K.setLayoutParams(layoutParams);
        if (this.f12297c != null) {
            this.f12297c = null;
        }
        this.f12297c = new FlightInfoFragment();
        getSupportFragmentManager().a().b(R.id.flightInfoFragment, this.f12297c).d();
        getSupportFragmentManager().a().a((Fragment) this.f12298k).d();
        if (this.f12298k != null) {
            this.f12298k = null;
        }
        this.f12298k = new DroneControlFragment();
        getSupportFragmentManager().a().a((int) R.id.big_container, (Fragment) this.f12298k, "dca").d();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(com.xeagle.R.style.AppTheme_NoActionBar);
        setContentView((int) R.layout.flight_action_view);
        j();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        t();
        this.H.m().b(-1);
        if (this.I.I()) {
            this.H.i().b();
            this.H.i().a();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.xeagle.android.vjoystick.utils.b.b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.xeagle.android.vjoystick.utils.b.a(this);
        k();
        if (!this.I.aI()) {
            this.I.m(true);
        }
        if (this.f12300m == null) {
            Log.i("newUI", "onResume:-operation -- ");
        } else if (this.I.aG() == 0 || (!this.f12358g.d().e().equals(ApmModes.ROTOR_GUIDED) && !this.f12358g.d().e().equals(ApmModes.ROTOR_AUTO) && !this.f12358g.d().e().equals(ApmModes.ROTOR_POSHOLD) && !this.f12358g.d().e().equals(ApmModes.ROTOR_CIRCLE))) {
            this.f12289aj = false;
            this.I.q(0);
            this.f12300m.a(0);
            this.f12300m.a(false, 15);
        } else {
            this.f12300m.a(this.I.aG());
            this.f12300m.a(true, 14);
            this.f12289aj = true;
            this.f12300m.b(true, this.I.aG());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.I.m(false);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("FlightActionActivity", "onTouch: ===================mapview");
        if (this.f12359h) {
            r.a().a(getString(R.string.warning), getString(R.string.switch_warn), (c.a) new c.a() {
                public void onYes() {
                    FlightActionActivity.this.m();
                }
            }).show(getSupportFragmentManager(), "switchDlg");
            return true;
        }
        m();
        return true;
    }

    @l(a = ThreadMode.MAIN)
    public void operateModeClick(ae aeVar) {
        if (this.f12301n.getVisibility() == 0) {
            b(false);
            DroneControlFragment droneControlFragment = this.f12298k;
            if (droneControlFragment != null) {
                droneControlFragment.a(true, 4);
            }
            StickOperateFragment stickOperateFragment = this.f12300m;
            if (stickOperateFragment != null) {
                this.f12289aj = false;
                stickOperateFragment.a(false, 6);
                this.f12300m.a(0);
                this.f12300m.b(false, 0);
                this.f12300m.b(true);
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void phoneRotateDegreeEvent(ag agVar) {
        float a2 = agVar.a();
        this.f12307t = a2;
        this.f12304q.a(this.f12308u, a2, getWindowManager().getDefaultDisplay().getRotation());
        this.f12304q.a(this.f12313z, this.A, this.f12307t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007a, code lost:
        r0.a(true, r1);
        r5.f12300m.a(r6.b());
        r5.f12300m.b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c1, code lost:
        r5.I.q(r6.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d7, code lost:
        r6.a(false, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00da, code lost:
        r5.f12300m.a(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00df, code lost:
        r5.f12289aj = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01af, code lost:
        r5.I.q(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shootModeStatus(jo.al r6) {
        /*
            r5 = this;
            r5.f12290ak = r6
            int r0 = r6.b()
            r5.f12306s = r0
            int r0 = r6.b()
            r1 = 2131820628(0x7f110054, float:1.9273976E38)
            r2 = 8
            r3 = 1
            r4 = 0
            switch(r0) {
                case 0: goto L_0x017e;
                case 1: goto L_0x00e3;
                case 2: goto L_0x008c;
                case 3: goto L_0x00e3;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00e3;
                case 6: goto L_0x00e3;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00e3;
                case 9: goto L_0x00e3;
                case 10: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x01b4
        L_0x0018:
            boolean r0 = r6.c()
            if (r0 != 0) goto L_0x0060
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            if (r6 == 0) goto L_0x0048
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0048
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            r6.a()
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.ListenerData r6 = r6.Q()
            java.lang.String r0 = r5.getString(r1)
            r6.e((java.lang.String) r0)
        L_0x0048:
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.aa r6 = r6.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r6.b((com.MAVLink.Messages.ApmModes) r0)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            if (r6 == 0) goto L_0x00df
            r6.b((boolean) r4, (int) r4)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r0 = 10
            goto L_0x00d7
        L_0x0060:
            r5.b((boolean) r3)
            com.xeagle.android.vjoystick.DroneControlFragment r0 = r5.f12298k
            if (r0 == 0) goto L_0x006b
            r1 = 6
            r0.a((boolean) r4, (int) r1)
        L_0x006b:
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            if (r0 == 0) goto L_0x00c1
            int r1 = r6.b()
            r0.b((boolean) r3, (int) r1)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            r1 = 11
        L_0x007a:
            r0.a((boolean) r3, (int) r1)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            int r1 = r6.b()
            r0.a((int) r1)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            r0.b((boolean) r4)
            goto L_0x00c1
        L_0x008c:
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r5.f12359h
            if (r0 == 0) goto L_0x00a6
            com.xeagle.android.newUI.widgets.RoundRelativeLayout r0 = r5.E
            int r0 = r0.getVisibility()
            if (r0 != r2) goto L_0x00a3
            com.xeagle.android.newUI.widgets.RoundRelativeLayout r0 = r5.E
            r0.setVisibility(r4)
        L_0x00a3:
            r5.m()
        L_0x00a6:
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            if (r0 == 0) goto L_0x00c1
            int r1 = r6.b()
            r0.b((boolean) r3, (int) r1)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            r1 = 12
            r0.a((boolean) r3, (int) r1)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            int r1 = r6.b()
            r0.a((int) r1)
        L_0x00c1:
            com.xeagle.android.utils.prefs.a r0 = r5.I
            int r6 = r6.b()
            r0.q((int) r6)
            goto L_0x01b4
        L_0x00cc:
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            if (r6 == 0) goto L_0x00df
            r6.b((boolean) r4, (int) r4)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r0 = 13
        L_0x00d7:
            r6.a((boolean) r4, (int) r0)
        L_0x00da:
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r6.a((int) r4)
        L_0x00df:
            r5.f12289aj = r4
            goto L_0x01af
        L_0x00e3:
            boolean r0 = r6.c()
            if (r0 != 0) goto L_0x012b
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            if (r6 == 0) goto L_0x0113
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0113
            com.xeagle.android.XEagleApp r6 = r5.H
            com.flypro.core.gcs.follow.Follow r6 = r6.l()
            r6.a()
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.ListenerData r6 = r6.Q()
            java.lang.String r0 = r5.getString(r1)
            r6.e((java.lang.String) r0)
        L_0x0113:
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.aa r6 = r6.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r6.b((com.MAVLink.Messages.ApmModes) r0)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            if (r6 == 0) goto L_0x00df
            r6.b((boolean) r4, (int) r4)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r6.a((boolean) r4, (int) r2)
            goto L_0x00da
        L_0x012b:
            com.xeagle.android.vjoystick.DroneControlFragment r0 = r5.f12298k
            if (r0 == 0) goto L_0x013a
            r1 = 5
            r0.a((boolean) r4, (int) r1)
            com.xeagle.android.vjoystick.DroneControlFragment r0 = r5.f12298k
            int r1 = r5.f12306s
            r0.a((int) r1)
        L_0x013a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "shootModeStatus: =====mode==="
            r0.append(r1)
            jo.al r1 = r5.f12290ak
            int r1 = r1.b()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FlightActionActivity"
            android.util.Log.i(r1, r0)
            jo.al r0 = r5.f12290ak
            int r0 = r0.b()
            if (r0 != r2) goto L_0x0166
            com.xeagle.android.vjoystick.DroneControlFragment r0 = r5.f12298k
            com.xeagle.android.vjoystick.DroneControlFragment$VisionModeStatus r1 = com.xeagle.android.vjoystick.DroneControlFragment.VisionModeStatus.READY
            r0.a((com.xeagle.android.vjoystick.DroneControlFragment.VisionModeStatus) r1)
            goto L_0x0169
        L_0x0166:
            r5.b((boolean) r3)
        L_0x0169:
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            if (r0 == 0) goto L_0x00c1
            int r1 = r6.b()
            int r2 = r6.e()
            r0.a(r3, r1, r2)
            com.xeagle.android.vjoystick.StickOperateFragment r0 = r5.f12300m
            r1 = 9
            goto L_0x007a
        L_0x017e:
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.aa r6 = r6.d()
            com.MAVLink.Messages.ApmModes r6 = r6.e()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x019b
            en.a r6 = r5.f12358g
            com.flypro.core.drone.variables.aa r6 = r6.d()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.ROTOR_LOITER
            r6.b((com.MAVLink.Messages.ApmModes) r0)
        L_0x019b:
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            if (r6 == 0) goto L_0x01af
            r5.f12289aj = r4
            r6.b((boolean) r4, (int) r4)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r0 = 7
            r6.a((boolean) r4, (int) r0)
            com.xeagle.android.vjoystick.StickOperateFragment r6 = r5.f12300m
            r6.a((int) r4)
        L_0x01af:
            com.xeagle.android.utils.prefs.a r6 = r5.I
            r6.q((int) r4)
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.FlightActionActivity.shootModeStatus(jo.al):void");
    }

    @l(a = ThreadMode.MAIN)
    public void showVisualFollowGuide(az azVar) {
        this.f12312y.setVisibility(0);
        this.f12312y.setTag(azVar);
    }

    @l(a = ThreadMode.MAIN)
    public void sonarEvent(ba baVar) {
        int i2;
        aa aaVar;
        if (this.f12358g.d().e().equals(ApmModes.ROTOR_POSHOLD)) {
            StickOperateFragment stickOperateFragment = this.f12300m;
            if (stickOperateFragment != null && !stickOperateFragment.b() && baVar.a().f7261f < 99) {
                this.f12300m.a(true);
                this.f12289aj = true;
                this.f12300m.c(this.f12306s);
                Log.i("FlightActionActivity", "sonarEvent: ====mode==sonar bar_vel======" + baVar.a().f7260e);
                switch (baVar.a().f7260e) {
                    case 1:
                        aaVar = this.f12358g.d();
                        i2 = R.string.dronie_running;
                        break;
                    case 2:
                        aaVar = this.f12358g.d();
                        i2 = R.string.rocket_running;
                        break;
                    case 3:
                        aaVar = this.f12358g.d();
                        i2 = R.string.helix_running;
                        break;
                    case 4:
                        aaVar = this.f12358g.d();
                        i2 = R.string.boomerang_running;
                        break;
                    case 5:
                        aaVar = this.f12358g.d();
                        i2 = R.string.crew_running;
                        break;
                    case 6:
                        aaVar = this.f12358g.d();
                        i2 = R.string.panorama_running;
                        break;
                }
                aaVar.a(getString(i2));
            }
            if (this.f12300m != null && baVar.a().f7261f <= 100) {
                this.f12300m.b((int) baVar.a().f7261f);
                if (baVar.a().f7261f == 99) {
                    DroneControlFragment droneControlFragment = this.f12298k;
                    if (droneControlFragment != null) {
                        droneControlFragment.a(0);
                    }
                    if (this.f12300m.b()) {
                        this.f12289aj = false;
                        this.f12305r = false;
                        this.f12306s = 0;
                        this.f12300m.b(false, 0);
                        this.f12300m.a(false);
                        this.f12300m.a(false, 2);
                        this.f12300m.a(0);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        StickOperateFragment stickOperateFragment2 = this.f12300m;
        if (stickOperateFragment2 != null) {
            stickOperateFragment2.a(false);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void stateEvent(y yVar) {
        if (yVar.a() == 2) {
            boolean d2 = this.f12358g.d().d();
            boolean aX = this.I.aX();
            if (d2 && !aX) {
                a(getString(R.string.flight_avoidance_hint));
            }
        }
    }

    public boolean u_() {
        DroneControlFragment droneControlFragment = this.f12298k;
        if (droneControlFragment == null) {
            return false;
        }
        return droneControlFragment.f12898h;
    }

    @l(a = ThreadMode.MAIN)
    public void waypointSwitch(be beVar) {
        Log.i("Map", "waypointSwitch: ---view is MAP----" + this.f12359h);
        if (this.f12306s == 2) {
            ToastUtils.showShort((CharSequence) getString(R.string.switch_view_warn));
        } else if (this.f12359h) {
            if (this.f12295ap == null) {
                this.f12295ap = r.a().a(getString(R.string.warning), getString(R.string.switch_warn), (c.a) new c.a() {
                    public void onYes() {
                        if (FlightActionActivity.this.f12300m != null) {
                            FlightActionActivity.this.f12300m.c();
                        }
                        FlightActionActivity.this.m();
                    }
                });
            }
            if (!this.f12295ap.isAdded()) {
                this.f12295ap.show(getSupportFragmentManager(), "switchDlg");
            }
        } else if (this.f12305r || this.f12358g.d().equals(ApmModes.ROTOR_AUTO)) {
            ToastUtils.showShort((CharSequence) getString(R.string.shoot_is_running));
        } else {
            m();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void yawChangeEvent(bf bfVar) {
        float a2 = (float) this.f12358g.H().a();
        if (Math.abs(a2 - this.f12308u) > 1.0E-6f) {
            this.f12308u = a2;
            this.f12304q.a(a2, this.f12307t, getWindowManager().getDefaultDisplay().getRotation());
        }
    }
}
