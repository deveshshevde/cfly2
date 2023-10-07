package com.xeagle.android.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import androidx.fragment.app.s;
import com.MAVLink.Messages.ApmModes;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.customeui.widget.CommonUI;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.q;
import com.flypro.core.database.BatteryInfoData;
import com.flypro.core.database.DroneInfoData;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.ListenerData;
import com.flypro.core.parameters.Parameter;
import com.flypro.core.util.e;
import com.warkiz.tickseekbar.TickSeekBar;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.dialogs.aa;
import com.xeagle.android.dialogs.ai;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.q;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.dialogs.w;
import com.xeagle.android.dialogs.x;
import com.xeagle.android.dialogs.z;
import com.xeagle.android.fragments.calibration.CompassFragment;
import com.xeagle.android.fragments.f;
import com.xeagle.android.login.beans.UdpUnbindServer;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.activity.FindDroneActivity;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.newUI.widgets.NiceSwitchButton;
import com.xeagle.android.utils.g;
import com.xeagle.android.utils.h;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.utils.w;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import dy.ad;
import dy.al;
import dy.am;
import dy.at;
import dy.j;
import dy.y;
import dz.a;
import fg.i;
import io.reactivex.disposables.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jo.bd;
import jo.t;
import lj.a;
import lj.c;
import lj.d;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class f extends c implements DroneInterfaces.c, DroneInterfaces.e {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f12559d = true;
    private LinearLayout A;
    private LinearLayout B;
    private View C;
    private LinearLayout D;
    private View E;
    private IButton F;
    private TextView G;
    private EditText H;
    private TextView I;
    private TextView J;
    private TextView K;
    private LinearLayout L;
    /* access modifiers changed from: private */
    public View M;
    /* access modifiers changed from: private */
    public LinearLayout N;
    private TextView O;
    private View P;
    /* access modifiers changed from: private */
    public TextView Q;
    private View R;
    private TextView S;
    private NiceSwitchButton T;
    private IButton U;
    private IButton V;
    private NiceSwitchButton W;
    private LinearLayout X;
    private LinearLayout Y;
    private FrameLayout Z;

    /* renamed from: a  reason: collision with root package name */
    protected a f12560a;
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public b aB;
    private LinearLayout aC;
    private IImageButton aD;
    private TextView aE;
    private TextView aF;
    private TickSeekBar aG;
    private ImageView aH;
    /* access modifiers changed from: private */
    public TextView aI;
    private LinearLayout aJ;
    private IImageButton aK;
    /* access modifiers changed from: private */
    public LinearLayout aL;
    private IButton aM;
    private NiceSwitchButton aN;
    private TextView aO;
    private TextView aP;
    private TextView aQ;
    private TextView aR;
    private LinearLayout aS;
    /* access modifiers changed from: private */
    public LinearLayout aT;
    /* access modifiers changed from: private */
    public TextView aU;
    /* access modifiers changed from: private */
    public TextView aV;
    /* access modifiers changed from: private */
    public TextView aW;
    private TextView aX;
    /* access modifiers changed from: private */
    public TextView aY;
    /* access modifiers changed from: private */
    public TextView aZ;

    /* renamed from: aa  reason: collision with root package name */
    private IImageButton f12561aa;

    /* renamed from: ab  reason: collision with root package name */
    private TextView f12562ab;

    /* renamed from: ac  reason: collision with root package name */
    private LinearLayout f12563ac;
    /* access modifiers changed from: private */

    /* renamed from: ad  reason: collision with root package name */
    public TickSeekBar f12564ad;
    /* access modifiers changed from: private */

    /* renamed from: ae  reason: collision with root package name */
    public TextView f12565ae;

    /* renamed from: af  reason: collision with root package name */
    private IButton f12566af;

    /* renamed from: ag  reason: collision with root package name */
    private IButton f12567ag;

    /* renamed from: ah  reason: collision with root package name */
    private IButton f12568ah;
    /* access modifiers changed from: private */

    /* renamed from: ai  reason: collision with root package name */
    public LinearLayout f12569ai;
    /* access modifiers changed from: private */

    /* renamed from: aj  reason: collision with root package name */
    public d f12570aj;
    /* access modifiers changed from: private */

    /* renamed from: ak  reason: collision with root package name */
    public lj.c f12571ak;
    /* access modifiers changed from: private */

    /* renamed from: al  reason: collision with root package name */
    public String[] f12572al;
    /* access modifiers changed from: private */

    /* renamed from: am  reason: collision with root package name */
    public TextView f12573am;

    /* renamed from: an  reason: collision with root package name */
    private LinearLayout f12574an;

    /* renamed from: ao  reason: collision with root package name */
    private LinearLayout f12575ao;

    /* renamed from: ap  reason: collision with root package name */
    private ConstraintLayout f12576ap;

    /* renamed from: aq  reason: collision with root package name */
    private LinearLayout f12577aq;
    /* access modifiers changed from: private */

    /* renamed from: ar  reason: collision with root package name */
    public lj.a f12578ar;
    /* access modifiers changed from: private */

    /* renamed from: as  reason: collision with root package name */
    public String[] f12579as;
    /* access modifiers changed from: private */

    /* renamed from: at  reason: collision with root package name */
    public TextView f12580at;

    /* renamed from: au  reason: collision with root package name */
    private View f12581au;

    /* renamed from: av  reason: collision with root package name */
    private View f12582av;

    /* renamed from: aw  reason: collision with root package name */
    private View f12583aw;

    /* renamed from: ax  reason: collision with root package name */
    private IButton f12584ax;

    /* renamed from: ay  reason: collision with root package name */
    private LinearLayout f12585ay;
    /* access modifiers changed from: private */

    /* renamed from: az  reason: collision with root package name */
    public NiceSwitchButton f12586az;

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f12587b = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            UdpDataService unused = f.this.bJ = ((UdpDataService.UdpBinder) iBinder).getService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private int bA = 7;
    /* access modifiers changed from: private */
    public com.xeagle.android.dialogs.c bB;
    /* access modifiers changed from: private */
    public XEagleApp bC;
    /* access modifiers changed from: private */
    public en.a bD;
    private final Handler bE = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public x bF = null;
    /* access modifiers changed from: private */
    public String bG = "";
    /* access modifiers changed from: private */
    public String bH = "";
    /* access modifiers changed from: private */
    public w bI;
    /* access modifiers changed from: private */
    public UdpDataService bJ;
    private boolean bK = false;
    /* access modifiers changed from: private */
    public e bL;
    /* access modifiers changed from: private */
    public FlightActionActivity bM;
    /* access modifiers changed from: private */
    public int bN;
    /* access modifiers changed from: private */
    public SochipPresenter bO;
    /* access modifiers changed from: private */
    public com.xeagle.android.dialogs.d bP;
    private com.xeagle.android.dialogs.c bQ;
    private com.xeagle.android.dialogs.c bR;
    private com.xeagle.android.dialogs.d bS;
    /* access modifiers changed from: private */
    public final HashMap<String, Integer> bT = new HashMap<>();
    /* access modifiers changed from: private */
    public int bU;
    /* access modifiers changed from: private */
    public int bV;
    private boolean bW;
    private int bX = 28;
    private int bY = 28;
    /* access modifiers changed from: private */
    public int bZ = 30;
    /* access modifiers changed from: private */

    /* renamed from: ba  reason: collision with root package name */
    public TextView f12588ba;

    /* renamed from: bb  reason: collision with root package name */
    private TextView f12589bb;

    /* renamed from: bc  reason: collision with root package name */
    private LinearLayout f12590bc;

    /* renamed from: bd  reason: collision with root package name */
    private View f12591bd;

    /* renamed from: be  reason: collision with root package name */
    private LinearLayout f12592be;

    /* renamed from: bf  reason: collision with root package name */
    private LinearLayout f12593bf;

    /* renamed from: bg  reason: collision with root package name */
    private LinearLayout f12594bg;

    /* renamed from: bh  reason: collision with root package name */
    private LinearLayout f12595bh;

    /* renamed from: bi  reason: collision with root package name */
    private TextView f12596bi;

    /* renamed from: bj  reason: collision with root package name */
    private TextView f12597bj;

    /* renamed from: bk  reason: collision with root package name */
    private TextView f12598bk;

    /* renamed from: bl  reason: collision with root package name */
    private LinearLayout f12599bl;

    /* renamed from: bm  reason: collision with root package name */
    private TextView f12600bm;

    /* renamed from: bn  reason: collision with root package name */
    private View f12601bn;

    /* renamed from: bo  reason: collision with root package name */
    private LinearLayout f12602bo;

    /* renamed from: bp  reason: collision with root package name */
    private View f12603bp;

    /* renamed from: bq  reason: collision with root package name */
    private LinearLayout f12604bq;

    /* renamed from: br  reason: collision with root package name */
    private TextView f12605br;

    /* renamed from: bs  reason: collision with root package name */
    private TextView f12606bs;

    /* renamed from: bt  reason: collision with root package name */
    private NiceSwitchButton f12607bt;
    /* access modifiers changed from: private */

    /* renamed from: bu  reason: collision with root package name */
    public NiceSwitchButton f12608bu;
    /* access modifiers changed from: private */

    /* renamed from: bv  reason: collision with root package name */
    public AmbaClient f12609bv;

    /* renamed from: bw  reason: collision with root package name */
    private View f12610bw;

    /* renamed from: bx  reason: collision with root package name */
    private boolean f12611bx;

    /* renamed from: by  reason: collision with root package name */
    private boolean f12612by;

    /* renamed from: bz  reason: collision with root package name */
    private boolean f12613bz;

    /* renamed from: c  reason: collision with root package name */
    Runnable f12614c = new Runnable() {
        public void run() {
            f.this.k();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: ca  reason: collision with root package name */
    public int f12615ca;
    /* access modifiers changed from: private */

    /* renamed from: cb  reason: collision with root package name */
    public int f12616cb;

    /* renamed from: cc  reason: collision with root package name */
    private int f12617cc;

    /* renamed from: cd  reason: collision with root package name */
    private boolean f12618cd;

    /* renamed from: ce  reason: collision with root package name */
    private AlertDialog f12619ce;

    /* renamed from: cf  reason: collision with root package name */
    private Parameter f12620cf;

    /* renamed from: cg  reason: collision with root package name */
    private Parameter f12621cg;

    /* renamed from: ch  reason: collision with root package name */
    private Parameter f12622ch;

    /* renamed from: ci  reason: collision with root package name */
    private Parameter f12623ci;

    /* renamed from: cj  reason: collision with root package name */
    private int f12624cj = -1;

    /* renamed from: ck  reason: collision with root package name */
    private double f12625ck;

    /* renamed from: cl  reason: collision with root package name */
    private double f12626cl;

    /* renamed from: cm  reason: collision with root package name */
    private double f12627cm;
    /* access modifiers changed from: private */

    /* renamed from: cn  reason: collision with root package name */
    public com.xeagle.android.dialogs.c f12628cn;

    /* renamed from: co  reason: collision with root package name */
    private boolean f12629co = false;

    /* renamed from: cp  reason: collision with root package name */
    private int f12630cp = 0;

    /* renamed from: cq  reason: collision with root package name */
    private boolean f12631cq;

    /* renamed from: e  reason: collision with root package name */
    private IImageButton f12632e;

    /* renamed from: f  reason: collision with root package name */
    private IImageButton f12633f;

    /* renamed from: g  reason: collision with root package name */
    private IImageButton f12634g;

    /* renamed from: h  reason: collision with root package name */
    private IImageButton f12635h;

    /* renamed from: i  reason: collision with root package name */
    private IImageButton f12636i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f12637j;

    /* renamed from: k  reason: collision with root package name */
    private View f12638k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f12639l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f12640m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f12641n;

    /* renamed from: o  reason: collision with root package name */
    private IImageButton f12642o;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f12643p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f12644q;

    /* renamed from: r  reason: collision with root package name */
    private NiceSwitchButton f12645r;

    /* renamed from: s  reason: collision with root package name */
    private NiceSwitchButton f12646s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f12647t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f12648u;

    /* renamed from: v  reason: collision with root package name */
    private View f12649v;

    /* renamed from: w  reason: collision with root package name */
    private LinearLayout f12650w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public EditText f12651x;

    /* renamed from: y  reason: collision with root package name */
    private EditText f12652y;

    /* renamed from: z  reason: collision with root package name */
    private View f12653z;

    /* renamed from: com.xeagle.android.fragments.f$60  reason: invalid class name */
    static /* synthetic */ class AnonymousClass60 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23368a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23368a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.CAL_IMU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a() {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (f.this.bD != null && f.this.bD.e() != null) {
                    Log.i("CameraClient", "run: -----get param");
                    f.this.bT.put("SETTING_PSC_limit_alt", 2);
                    f.this.bD.e().a("PSC_limit_alt");
                    SystemClock.sleep(250);
                    f.this.bT.put("SETTING_FENCE_ENABLE", 2);
                    f.this.bD.e().a("FENCE_ENABLE");
                    SystemClock.sleep(250);
                    f.this.bT.put("SETTING_FENCE_ALT_MAX", 3);
                    f.this.bD.e().a("FENCE_ALT_MAX");
                    SystemClock.sleep(250);
                    f.this.bT.put("SETTING_FENCE_RADIUS", 3);
                    f.this.bD.e().a("FENCE_RADIUS");
                    SystemClock.sleep(250);
                    f.this.bT.put("SETTING_FENCE_ENABLE", 2);
                    f.this.bD.e().a("FENCE_ENABLE");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog alertDialog = this.f12619ce;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f12619ce.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.hint);
        builder.setMessage(i2);
        builder.setNegativeButton(R.string.update_deny, onClickListener2);
        builder.setPositiveButton(R.string.update_ok, onClickListener);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.f12619ce = create;
        create.show();
    }

    private void a(View view) {
        if (this.f12560a.aV() && g.b(this.f12560a.j())) {
            final View findViewById = view.findViewById(R.id.rl_newbie_avoidance);
            findViewById.setVisibility(0);
            findViewById.findViewById(R.id.tv_avoidance_guide).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    findViewById.setVisibility(8);
                    f.this.f12560a.aU();
                }
            });
        }
        this.bL = new e(this.bM.getApplicationContext());
        this.f12637j = (LinearLayout) view.findViewById(R.id.ll_fly_setting);
        this.f12639l = (LinearLayout) view.findViewById(R.id.ll_avoidance_setting);
        this.X = (LinearLayout) view.findViewById(R.id.ll_rc_setting);
        this.aC = (LinearLayout) view.findViewById(R.id.ll_battery_setting);
        this.aJ = (LinearLayout) view.findViewById(R.id.ll_other_setting);
        this.f12632e = (IImageButton) view.findViewById(R.id.iv_fly_setting);
        this.f12633f = (IImageButton) view.findViewById(R.id.iv_fly_avoidance);
        this.f12634g = (IImageButton) view.findViewById(R.id.iv_rc_setting);
        this.f12635h = (IImageButton) view.findViewById(R.id.iv_battery_setting);
        this.f12636i = (IImageButton) view.findViewById(R.id.iv_fix_setting);
        this.f12638k = view.findViewById(R.id.ll_fly_avoidance_layout);
        b(view);
        if (g.b(this.f12560a.j())) {
            this.f12638k.setVisibility(0);
            d((View) this.f12639l);
        }
        e(view);
        f(view);
        g(view);
        c(0);
        w wVar = new w(this);
        this.bI = wVar;
        wVar.a(1);
        this.bI.a(3000);
        this.aG.setProgress((float) this.f12560a.l());
        int progress = this.aG.getProgress();
        TextView textView = this.aI;
        textView.setText(progress + "%");
        if (this.f12560a.y().equals("5M")) {
            f(5);
            this.bU = 1;
        } else if (this.f12560a.y().equals("10M")) {
            f(10);
            this.bU = 0;
        }
        this.f12632e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.c(0);
                q.b(f.this.bD);
            }
        });
        this.f12633f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.c(1);
                q.b(f.this.bD);
            }
        });
        this.f12634g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.c(2);
                if (f.this.f12564ad != null && h.a(f.this.f12560a, f.this.bD)) {
                    f.this.bT.put("SETTING_GIMB_ANG", 1);
                    f.this.bD.e().a("GIMB_ANG");
                }
                if (f.this.bC.c()) {
                    f.this.bT.put("SETTING_GIMB_ADV", 1);
                    f.this.bD.e().a("GIMB_ADV");
                }
            }
        });
        this.f12586az.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            /* access modifiers changed from: private */
            public /* synthetic */ void a(boolean z2, Long l2) throws Exception {
                if (!f.this.aA) {
                    f.this.f12586az.b();
                    f.this.f12586az.setChecked(!z2);
                    ToastUtils.showShort((int) R.string.setting_fail);
                }
                f.this.aB.dispose();
                b unused = f.this.aB = null;
            }

            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                double d2;
                en.a aVar;
                if (f.this.bD.a()) {
                    ListenerData Q = f.this.bD.Q();
                    FlightActionActivity i2 = f.this.bM;
                    if (z2) {
                        Q.e(i2.getString(R.string.action_open_adv));
                        aVar = f.this.bD;
                        d2 = 1.0d;
                    } else {
                        Q.e(i2.getString(R.string.action_close_adv));
                        aVar = f.this.bD;
                        d2 = i.f27244a;
                    }
                    com.xeagle.android.utils.c.a(aVar, "GIMB_ADV", d2, (a.C0168a) null);
                    boolean unused = f.this.aA = false;
                    f.this.bT.put("SETTING_GIMB_ADV", 2);
                    f.this.bD.e().a("GIMB_ADV");
                    if (f.this.aB == null) {
                        b unused2 = f.this.aB = io.reactivex.f.a(1200, TimeUnit.MILLISECONDS).a(lu.a.a()).a(new lv.d(z2) {
                            public final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void accept(Object obj) {
                                f.AnonymousClass3.this.a(this.f$1, (Long) obj);
                            }
                        });
                    }
                }
            }
        });
        this.f12635h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.c(3);
                q.a(f.this.bD);
            }
        });
        this.f12636i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.c(4);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NiceSwitchButton niceSwitchButton, boolean z2) {
        this.bD.Q().e(this.bM.getString(z2 ? R.string.action_open_landscape : R.string.action_close_landscape));
        SPUtils.getInstance().put("is_ort", z2);
        org.greenrobot.eventbus.c.a().d(new ha.c(Boolean.valueOf(z2), "landscape_or_vertical"));
        dismiss();
    }

    private void a(final boolean z2) {
        this.bM.runOnUiThread(new Runnable() {
            public void run() {
                if (z2) {
                    if (f.this.bC.c()) {
                        f.this.Q.setVisibility(8);
                    } else {
                        f.this.M.setVisibility(0);
                        f.this.N.setVisibility(0);
                        f.this.Q.setVisibility(0);
                        return;
                    }
                }
                f.this.M.setVisibility(8);
                f.this.N.setVisibility(8);
            }
        });
    }

    private boolean a(String str) {
        return this.bT.containsKey(str);
    }

    private void b() {
        boolean z2;
        NiceSwitchButton niceSwitchButton;
        boolean m2 = this.f12560a.m();
        this.f12612by = m2;
        if (m2) {
            niceSwitchButton = this.f12645r;
            z2 = true;
        } else {
            niceSwitchButton = this.f12645r;
            z2 = false;
        }
        niceSwitchButton.setChecked(z2);
        c(z2);
        e();
    }

    private void b(int i2) {
        this.bT.put("SETTING_FENCE_ENABLE", 1);
        this.f12617cc = i2;
        this.bD.e().a("FENCE_ENABLE");
    }

    private void b(View view) {
        this.f12640m = (LinearLayout) view.findViewById(R.id.ll_safe_setting);
        this.f12641n = (TextView) view.findViewById(R.id.tv_setting_title);
        this.f12642o = (IImageButton) view.findViewById(R.id.iv_fly_close);
        this.f12643p = (FrameLayout) view.findViewById(R.id.ll_settting_compass_calibration);
        this.f12644q = (LinearLayout) view.findViewById(R.id.ll_setting);
        this.f12645r = (NiceSwitchButton) view.findViewById(R.id.beginner_switch_button);
        this.f12646s = (NiceSwitchButton) view.findViewById(R.id.landscape_or_vertical_button);
        this.f12647t = (TextView) view.findViewById(R.id.tv_tip);
        this.f12650w = (LinearLayout) view.findViewById(R.id.limit_alt_ll);
        this.f12649v = view.findViewById(R.id.limit_alt_view);
        this.f12648u = (TextView) view.findViewById(R.id.tv_fly_height_limit);
        this.f12651x = (EditText) view.findViewById(R.id.et_fly_height);
        this.f12652y = (EditText) view.findViewById(R.id.et_rtl_height);
        this.A = (LinearLayout) view.findViewById(R.id.ll_rtl_height);
        this.f12653z = view.findViewById(R.id.rtl_height_view);
        this.G = (TextView) view.findViewById(R.id.tv_fly_distance_limit);
        this.H = (EditText) view.findViewById(R.id.et_fly_distance);
        this.I = (TextView) view.findViewById(R.id.tv_distance_warn);
        this.J = (TextView) view.findViewById(R.id.tv_height_warn);
        this.K = (TextView) view.findViewById(R.id.tv_gear);
        this.L = (LinearLayout) view.findViewById(R.id.ll_gear);
        this.O = (TextView) view.findViewById(R.id.tv_stable_gear);
        this.P = view.findViewById(R.id.gear_line1);
        this.Q = (TextView) view.findViewById(R.id.tv_general_gear);
        this.N = (LinearLayout) view.findViewById(R.id.switch_speed_ll);
        this.M = view.findViewById(R.id.switch_speed_view);
        this.R = view.findViewById(R.id.gear_line2);
        this.S = (TextView) view.findViewById(R.id.tv_sport_gear);
        this.T = (NiceSwitchButton) view.findViewById(R.id.bind_switch_button);
        this.U = (IButton) view.findViewById(R.id.tv_level_calibration);
        this.V = (IButton) view.findViewById(R.id.tv_compass_calibration);
        this.f12601bn = view.findViewById(R.id.drone_active_view);
        this.f12602bo = (LinearLayout) view.findViewById(R.id.ll_drone_active);
        this.f12603bp = view.findViewById(R.id.drone_sn_view);
        this.f12604bq = (LinearLayout) view.findViewById(R.id.ll_drone_sn);
        this.f12605br = (TextView) view.findViewById(R.id.drone_active_tv);
        this.f12606bs = (TextView) view.findViewById(R.id.drone_sn_tv);
        this.B = (LinearLayout) view.findViewById(R.id.vision_follow_ll);
        this.C = view.findViewById(R.id.vision_follow_view);
        NiceSwitchButton niceSwitchButton = (NiceSwitchButton) view.findViewById(R.id.vision_follow_switch);
        this.W = niceSwitchButton;
        niceSwitchButton.setChecked(this.f12560a.B());
        this.D = (LinearLayout) view.findViewById(R.id.update_rth_ll);
        this.E = view.findViewById(R.id.update_rth_view);
        this.F = (IButton) view.findViewById(R.id.bt_update_rth);
        this.f12590bc = (LinearLayout) view.findViewById(R.id.ll_unbind);
        this.f12591bd = view.findViewById(R.id.divide_unbind);
        this.f12592be = (LinearLayout) view.findViewById(R.id.lt_landscape);
        if (this.bC.c()) {
            this.f12592be.setVisibility(0);
        } else {
            this.f12592be.setVisibility(8);
        }
        c(view);
        this.f12640m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.n(view);
            }
        });
        this.f12604bq.setOnLongClickListener(new View.OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return f.this.m(view);
            }
        });
        this.W.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                f.this.f12560a.h(z2);
                org.greenrobot.eventbus.c.a().d(new bd(z2));
            }
        });
        this.f12646s.setChecked(SPUtils.getInstance().getBoolean("is_ort", false));
        this.f12646s.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public final void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                f.this.a(niceSwitchButton, z2);
            }
        });
        Log.i("FTP", "initFlySetting: =======sn====rtl====" + h.c(this.f12560a, this.bD));
        if (h.c(this.f12560a, this.bD)) {
            this.E.setVisibility(0);
            this.D.setVisibility(0);
            this.C.setVisibility(8);
            this.B.setVisibility(8);
            this.f12603bp.setVisibility(0);
            this.f12604bq.setVisibility(0);
            this.f12601bn.setVisibility(0);
            this.f12602bo.setVisibility(0);
            this.f12590bc.setVisibility(8);
            this.f12591bd.setVisibility(8);
            DroneInfoData requestLastDroneInfo = UserLiteHelper.requestLastDroneInfo();
            if (requestLastDroneInfo != null) {
                int parseInt = Integer.parseInt(requestLastDroneInfo.getDroneActiveTime().substring(0, 4));
                if (parseInt > 2100 || parseInt < 2021) {
                    this.f12605br.setText(R.string.device_inactive);
                } else {
                    this.f12605br.setText(requestLastDroneInfo.getDroneActiveTime());
                }
                this.f12606bs.setText(requestLastDroneInfo.getDroneSnId());
            }
            q.b(this.bD);
        } else {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.f12603bp.setVisibility(8);
            this.f12604bq.setVisibility(8);
            this.f12601bn.setVisibility(8);
            this.f12602bo.setVisibility(8);
            this.f12590bc.setVisibility(0);
            this.f12591bd.setVisibility(0);
        }
        if (h.b(this.f12560a, this.bD)) {
            this.f12653z.setVisibility(0);
            this.A.setVisibility(0);
            this.bT.put("SETTING_RTL_ALT", 1);
            this.bD.e().a("RTL_ALT");
        } else {
            this.f12653z.setVisibility(8);
            this.A.setVisibility(8);
        }
        if (this.bD.d().d()) {
            this.f12645r.setEnabled(false);
        } else {
            this.f12645r.setEnabled(true);
        }
        this.F.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.l(view);
            }
        });
        view.findViewById(R.id.fence_ll).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.bD.d().d()) {
                    ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                }
            }
        });
        this.f12652y.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 0) {
                    if (textView.getText().length() == 0) {
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.set_limit_value));
                    } else if (f.this.bD.d().e().equals(ApmModes.ROTOR_RTL)) {
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.rtl_height_warn));
                        return false;
                    } else {
                        try {
                            int parseInt = Integer.parseInt(textView.getText().toString()) * 100;
                            if (f.this.bZ != Integer.parseInt(textView.getText().toString())) {
                                int unused = f.this.bZ = Integer.parseInt(textView.getText().toString());
                                if (parseInt <= 12000) {
                                    if (parseInt >= 3000) {
                                        f.this.bD.Q().e(String.format(Locale.US, f.this.bM.getString(R.string.action_rtl_height), new Object[]{Integer.valueOf(parseInt / 100)}));
                                        com.flypro.core.MAVLink.d.a(f.this.bD, parseInt);
                                    }
                                }
                                ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.set_within_limit));
                            }
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
        this.H.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                String string;
                if (i2 == 0) {
                    return false;
                }
                if (textView.getText().length() == 0) {
                    ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.set_limit_value));
                    return false;
                }
                try {
                    int unused = f.this.f12616cb = Integer.parseInt(textView.getText().toString());
                    if (f.this.f12616cb <= 200) {
                        if (f.this.f12616cb >= 50) {
                            if (f.this.bD.b().f() >= ((double) f.this.f12616cb)) {
                                string = f.this.bM.getString(R.string.param_set_error);
                                ToastUtils.showShort((CharSequence) string);
                                return false;
                            }
                            f.this.bT.put("SETTING_FENCE_RADIUS", 1);
                            f.this.bD.e().a("FENCE_RADIUS");
                            return false;
                        }
                    }
                    string = f.this.bM.getString(R.string.set_within_limit);
                    ToastUtils.showShort((CharSequence) string);
                    return false;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        });
        this.f12651x.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                String string;
                dz.a e2;
                String str;
                if (i2 != 0) {
                    if (textView.getText().length() == 0) {
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.set_limit_value));
                    } else {
                        try {
                            int unused = f.this.f12615ca = Integer.parseInt(textView.getText().toString());
                            if (f.this.bD.t().b() >= ((double) f.this.f12615ca)) {
                                ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.param_set_error));
                                return false;
                            }
                            if (f.this.f12560a.m()) {
                                if (f.this.f12615ca <= 120) {
                                    if (f.this.f12615ca >= 30) {
                                        f.this.bT.put("SETTING_FENCE_ALT_MAX", 1);
                                        e2 = f.this.bD.e();
                                        str = "FENCE_ALT_MAX";
                                    }
                                }
                                string = f.this.bM.getString(R.string.set_within_limit);
                                ToastUtils.showShort((CharSequence) string);
                            } else {
                                if (f.this.f12615ca <= (f.this.bC.c() ? 800 : 500)) {
                                    if (f.this.f12615ca >= 30) {
                                        if (f.this.f12628cn == null) {
                                            com.xeagle.android.dialogs.c unused2 = f.this.f12628cn = r.a().a(f.this.bM.getString(R.string.warning), f.this.bM.getString(R.string.alt_limit_statement), (c.a) new c.a() {
                                                public void onYes() {
                                                }
                                            });
                                        }
                                        if (!f.this.f12628cn.isAdded()) {
                                            f.this.f12628cn.show(f.this.getChildFragmentManager(), "altLimit");
                                        }
                                        f.this.bT.put("SETTING_PSC_limit_alt", 1);
                                        e2 = f.this.bD.e();
                                        str = "PSC_limit_alt";
                                    }
                                }
                                string = f.this.bM.getString(R.string.set_within_limit);
                                ToastUtils.showShort((CharSequence) string);
                            }
                            e2.a(str);
                        } catch (NumberFormatException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
        this.f12642o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.f12645r.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                f.this.bD.Q().e(f.this.bM.getString(z2 ? R.string.action_open_beginner : R.string.action_close_beginner));
                if (f.this.bD.a() && !f.this.bD.d().c()) {
                    Log.i("version", "onCheckedChanged:===isAutoSwitch=== ");
                    f.this.d(z2);
                }
            }
        });
        this.O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!f.this.bC.c()) {
                    f.this.e(0);
                    if (f.this.bD.y() != null) {
                        double z2 = f.this.bD.z();
                        if (UserGlobal.DRONE_NAME_DF808.equals(f.this.f12560a.j()) && z2 < 4.0d && f.this.bD.d().c()) {
                            if (f.this.bV == 0) {
                                f.this.e(0);
                            } else if (f.this.bV == 1) {
                                f.this.e(1);
                            } else if (f.this.bV == 2) {
                                f.this.e(2);
                            }
                            ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                            return;
                        }
                    } else if (f.this.bD.d().c()) {
                        if (f.this.bV == 0) {
                            f.this.e(0);
                        } else if (f.this.bV == 1) {
                            f.this.e(1);
                        } else if (f.this.bV == 2) {
                            f.this.e(2);
                        }
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                        return;
                    }
                    f.this.bD.e().a("WPNAV_LOIT_SPD", new a.C0168a() {
                        public void a(Parameter parameter, String str) {
                            if (parameter != null && parameter.f14455a.equals("WPNAV_LOIT_SPD") && parameter.f14456b != 417.0d) {
                                com.xeagle.android.utils.c.a(f.this.bD, "WPNAV_LOIT_SPD", 417.0d, new a.C0168a() {
                                    public void a(Parameter parameter, String str) {
                                        if (parameter != null && parameter.f14455a.equals("WPNAV_LOIT_SPD")) {
                                            f.this.f12560a.g((int) parameter.f14456b);
                                            f.this.e(0);
                                            int unused = f.this.bV = 0;
                                            ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.switch_success));
                                            com.xeagle.android.utils.c.a(f.this.bD, "PSC_YYZ_UP_SPED", 200.0d, new a.C0168a() {
                                                public void a(Parameter parameter, String str) {
                                                    com.xeagle.android.utils.c.a(f.this.bD, "PSC_YYZ_Dw_SPED", -150.0d, new a.C0168a() {
                                                        public void a(Parameter parameter, String str) {
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!f.this.bC.c()) {
                    f.this.e(1);
                    if (f.this.bD.y() != null) {
                        double z2 = f.this.bD.z();
                        if (UserGlobal.DRONE_NAME_DF808.equals(f.this.f12560a.j()) && z2 < 4.0d && f.this.bD.d().c()) {
                            if (f.this.bV == 0) {
                                f.this.e(0);
                            } else if (f.this.bV == 1) {
                                f.this.e(1);
                            } else if (f.this.bV == 2) {
                                f.this.e(2);
                            }
                            ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                            return;
                        }
                    } else if (f.this.bD.d().c()) {
                        if (f.this.bV == 0) {
                            f.this.e(0);
                        } else if (f.this.bV == 1) {
                            f.this.e(1);
                        } else if (f.this.bV == 2) {
                            f.this.e(2);
                        }
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                        return;
                    }
                    f.this.bD.e().a("WPNAV_LOIT_SPD", new a.C0168a() {
                        public void a(Parameter parameter, String str) {
                            if (parameter != null && parameter.f14455a.equals("WPNAV_LOIT_SPD") && parameter.f14456b != 834.0d) {
                                com.xeagle.android.utils.c.a(f.this.bD, "WPNAV_LOIT_SPD", 834.0d, new a.C0168a() {
                                    public void a(Parameter parameter, String str) {
                                        if (parameter != null && parameter.f14455a.equals("WPNAV_LOIT_SPD")) {
                                            f.this.f12560a.g((int) parameter.f14456b);
                                            f.this.e(1);
                                            int unused = f.this.bV = 1;
                                            ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.switch_success));
                                            com.xeagle.android.utils.c.a(f.this.bD, "PSC_YYZ_UP_SPED", 200.0d, new a.C0168a() {
                                                public void a(Parameter parameter, String str) {
                                                    com.xeagle.android.utils.c.a(f.this.bD, "PSC_YYZ_Dw_SPED", -150.0d, new a.C0168a() {
                                                        public void a(Parameter parameter, String str) {
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
        this.S.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
                if (com.xeagle.android.fragments.f.q(r8.f23290a) == 2) goto L_0x0078;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
                com.xeagle.android.fragments.f.a(r8.f23290a, 2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
                if (com.xeagle.android.fragments.f.q(r8.f23290a) == 2) goto L_0x0078;
             */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x00f9  */
            /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r9) {
                /*
                    r8 = this;
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.XEagleApp r9 = r9.bC
                    boolean r9 = r9.c()
                    if (r9 == 0) goto L_0x000d
                    return
                L_0x000d:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    r0 = 2
                    r9.e((int) r0)
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    en.a r9 = r9.bD
                    java.lang.String r9 = r9.y()
                    r1 = 2131821390(0x7f11034e, float:1.9275522E38)
                    r2 = 0
                    r3 = 1
                    if (r9 == 0) goto L_0x008b
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    en.a r9 = r9.bD
                    double r4 = r9.z()
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.utils.prefs.a r9 = r9.f12560a
                    java.lang.String r9 = r9.j()
                    java.lang.String r6 = "808"
                    boolean r9 = r6.equals(r9)
                    if (r9 == 0) goto L_0x00b6
                    r6 = 4616189618054758400(0x4010000000000000, double:4.0)
                    int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r9 >= 0) goto L_0x00b6
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    en.a r9 = r9.bD
                    com.flypro.core.drone.variables.aa r9 = r9.d()
                    boolean r9 = r9.c()
                    if (r9 == 0) goto L_0x00b6
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != 0) goto L_0x0062
                L_0x005c:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    r9.e((int) r2)
                    goto L_0x007d
                L_0x0062:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != r3) goto L_0x0070
                L_0x006a:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    r9.e((int) r3)
                    goto L_0x007d
                L_0x0070:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != r0) goto L_0x007d
                L_0x0078:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    r9.e((int) r0)
                L_0x007d:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.activities.FlightActionActivity r9 = r9.bM
                    java.lang.String r9 = r9.getString(r1)
                    com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r9)
                    return
                L_0x008b:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    en.a r9 = r9.bD
                    com.flypro.core.drone.variables.aa r9 = r9.d()
                    boolean r9 = r9.c()
                    if (r9 == 0) goto L_0x00b6
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != 0) goto L_0x00a4
                    goto L_0x005c
                L_0x00a4:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != r3) goto L_0x00ad
                    goto L_0x006a
                L_0x00ad:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    int r9 = r9.bV
                    if (r9 != r0) goto L_0x007d
                    goto L_0x0078
                L_0x00b6:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.dialogs.d r9 = r9.bP
                    if (r9 != 0) goto L_0x00e4
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.activities.FlightActionActivity r0 = r9.bM
                    r1 = 2131823185(0x7f110a51, float:1.9279163E38)
                    java.lang.String r0 = r0.getString(r1)
                    com.xeagle.android.fragments.f r1 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.activities.FlightActionActivity r1 = r1.bM
                    r2 = 2131822883(0x7f110923, float:1.927855E38)
                    java.lang.String r1 = r1.getString(r2)
                    com.xeagle.android.fragments.f$19$1 r2 = new com.xeagle.android.fragments.f$19$1
                    r2.<init>()
                    com.xeagle.android.dialogs.d r0 = com.xeagle.android.dialogs.d.a(r0, r1, r2)
                    com.xeagle.android.dialogs.d unused = r9.bP = r0
                L_0x00e4:
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    androidx.fragment.app.FragmentManager r9 = r9.getChildFragmentManager()
                    r9.b()
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.dialogs.d r9 = r9.bP
                    boolean r9 = r9.isAdded()
                    if (r9 != 0) goto L_0x010a
                    com.xeagle.android.fragments.f r9 = com.xeagle.android.fragments.f.this
                    com.xeagle.android.dialogs.d r9 = r9.bP
                    com.xeagle.android.fragments.f r0 = com.xeagle.android.fragments.f.this
                    androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
                    java.lang.String r1 = "sportDlg"
                    r9.show(r0, r1)
                L_0x010a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.f.AnonymousClass19.onClick(android.view.View):void");
            }
        });
        this.T.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                f.this.e(true);
            }
        });
        this.U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_level_calibration));
                if (f.this.bD.d().c()) {
                    Toast.makeText(f.this.bM, R.string.flying_operate_warn, 0).show();
                    return;
                }
                com.xeagle.android.dialogs.d a2 = com.xeagle.android.dialogs.d.a(f.this.getString(R.string.gyro_cal_setting), f.this.bM.getString(R.string.imu_cal_warn), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        f.this.bI.c();
                        f.this.l();
                        x unused = f.this.bF = x.a(f.this.getString(R.string.menu_wait), f.this.getString(R.string.drone_calibrating));
                        if (f.this.bF != null) {
                            f.this.bF.show(f.this.getChildFragmentManager(), "progressDlg");
                        }
                    }
                });
                if (a2 != null) {
                    a2.show(f.this.getChildFragmentManager(), "Confirm imu");
                }
            }
        });
        this.V.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_compass_calibration));
                if (f.this.bD.d().d()) {
                    ToastUtils.showShort((int) R.string.flying_operate_warn);
                } else {
                    f.this.d(2);
                }
            }
        });
    }

    private void b(String str) {
        if (this.bD.C().a() == 0) {
            x xVar = this.bF;
            if (xVar != null) {
                xVar.dismiss();
            }
            com.xeagle.android.dialogs.c a2 = r.a().a(this.bM.getString(R.string.dialog_tips), this.bM.getString(R.string.cal_success), (c.a) new c.a() {
                public void onYes() {
                }
            });
            if (a2 != null) {
                a2.show(getChildFragmentManager(), "Confirm imu result");
            }
        } else if (this.bD.C().a() == -1) {
            this.bE.postDelayed(new Runnable() {
                public void run() {
                    if (f.this.bD.C().a() != 0) {
                        f.this.bD.x().a(false);
                        if (f.this.bF != null) {
                            f.this.bF.dismiss();
                        }
                        com.xeagle.android.dialogs.c a2 = r.a().a(f.this.bM.getString(R.string.dialog_tips), f.this.bM.getString(R.string.cal_fail), (c.a) new c.a() {
                            public void onYes() {
                            }
                        });
                        if (a2 != null) {
                            a2.show(f.this.getChildFragmentManager(), "Confirm imu result");
                        }
                    }
                }
            }, 2000);
        }
    }

    private void b(final boolean z2) {
        this.bM.runOnUiThread(new Runnable() {
            public void run() {
                LinearLayout linearLayout;
                int i2 = 8;
                if (!z2 || !f.this.f12560a.aH()) {
                    linearLayout = f.this.f12569ai;
                } else {
                    linearLayout = f.this.f12569ai;
                    i2 = 0;
                }
                linearLayout.setVisibility(i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void c() {
        boolean m2 = this.f12560a.m();
        this.f12612by = m2;
        b(m2 ? 1 : 0);
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        if (i2 == 0) {
            this.f12632e.setImageResource(R.drawable.newui_fly_settings_seleced);
            this.f12633f.setImageResource(R.drawable.ic_avoidance);
            this.f12634g.setImageResource(R.drawable.newui_rc_settings_normnal);
            this.f12635h.setImageResource(R.drawable.newui_battery_settings_normal);
            this.f12636i.setImageResource(R.drawable.newui_fix_settings_normal);
            this.f12637j.setVisibility(0);
            this.f12639l.setVisibility(8);
        } else if (i2 == 1) {
            this.f12632e.setImageResource(R.drawable.newui_fly_settings_normal);
            this.f12633f.setImageResource(R.drawable.ic_avoidance_select);
            this.f12634g.setImageResource(R.drawable.newui_rc_settings_normnal);
            this.f12635h.setImageResource(R.drawable.newui_battery_settings_normal);
            this.f12636i.setImageResource(R.drawable.newui_fix_settings_normal);
            this.f12637j.setVisibility(8);
            this.f12639l.setVisibility(0);
        } else if (i2 == 2) {
            this.f12632e.setImageResource(R.drawable.newui_fly_settings_normal);
            this.f12633f.setImageResource(R.drawable.ic_avoidance);
            this.f12634g.setImageResource(R.drawable.newui_rc_settings_selected);
            this.f12635h.setImageResource(R.drawable.newui_battery_settings_normal);
            this.f12636i.setImageResource(R.drawable.newui_fix_settings_normal);
            this.f12637j.setVisibility(8);
            this.f12639l.setVisibility(8);
            this.X.setVisibility(0);
            this.aC.setVisibility(8);
            this.aJ.setVisibility(8);
            this.aT.setVisibility(8);
            this.f12576ap.setVisibility(8);
        } else if (i2 == 3) {
            this.f12632e.setImageResource(R.drawable.newui_fly_settings_normal);
            this.f12633f.setImageResource(R.drawable.ic_avoidance);
            this.f12634g.setImageResource(R.drawable.newui_rc_settings_normnal);
            this.f12635h.setImageResource(R.drawable.newui_battery_settings_selected);
            this.f12636i.setImageResource(R.drawable.newui_fix_settings_normal);
            this.f12637j.setVisibility(8);
            this.f12639l.setVisibility(8);
            this.X.setVisibility(8);
            this.aC.setVisibility(0);
            this.aJ.setVisibility(8);
            this.aT.setVisibility(8);
            this.f12576ap.setVisibility(8);
        } else if (i2 == 4) {
            this.f12632e.setImageResource(R.drawable.newui_fly_settings_normal);
            this.f12633f.setImageResource(R.drawable.ic_avoidance);
            this.f12634g.setImageResource(R.drawable.newui_rc_settings_normnal);
            this.f12635h.setImageResource(R.drawable.newui_battery_settings_normal);
            this.f12636i.setImageResource(R.drawable.newui_fix_settings_selected);
            if (this.aT.getVisibility() != 0) {
                this.f12637j.setVisibility(8);
                this.f12639l.setVisibility(8);
                this.X.setVisibility(8);
                this.aC.setVisibility(8);
                this.aJ.setVisibility(0);
                this.aS.setVisibility(0);
                this.aL.setVisibility(0);
                this.f12576ap.setVisibility(8);
            }
            return;
        } else {
            return;
        }
        this.X.setVisibility(8);
        this.aC.setVisibility(8);
        this.aJ.setVisibility(8);
        this.aT.setVisibility(8);
        this.f12576ap.setVisibility(8);
    }

    private void c(View view) {
        int i2;
        FlightActionActivity flightActionActivity;
        TextView textView;
        this.f12576ap = (ConstraintLayout) view.findViewById(R.id.cl_drone_safe_setting);
        this.f12577aq = (LinearLayout) view.findViewById(R.id.rtl_safe_setting_ll);
        this.f12580at = (TextView) view.findViewById(R.id.tv_safe_setting);
        if (this.f12560a.G() == 1) {
            textView = this.f12580at;
            flightActionActivity = this.bM;
            i2 = R.string.action_land;
        } else {
            textView = this.f12580at;
            flightActionActivity = this.bM;
            i2 = R.string.action_rtl;
        }
        textView.setText(flightActionActivity.getString(i2));
        this.f12579as = this.bM.getResources().getStringArray(R.array.action_low_battery);
        f();
        view.findViewById(R.id.iv_safe_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.k(view);
            }
        });
        this.f12580at.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lj.a aVar;
                int i2;
                FlightActionActivity flightActionActivity;
                Context context;
                if (f.this.f12578ar == null || !f.this.f12578ar.isShowing()) {
                    if (f.this.f12560a.G() == 1) {
                        aVar = f.this.f12578ar;
                        context = f.this.bM.getApplicationContext();
                        flightActionActivity = f.this.bM;
                        i2 = R.string.action_land;
                    } else {
                        aVar = f.this.f12578ar;
                        context = f.this.bM.getApplicationContext();
                        flightActionActivity = f.this.bM;
                        i2 = R.string.action_rtl;
                    }
                    aVar.a(context, flightActionActivity.getString(i2));
                    f.this.f12578ar.showAsDropDown(f.this.f12580at, 48, 0, 0);
                    return;
                }
                f.this.f12578ar.dismiss();
            }
        });
    }

    private void c(boolean z2) {
        if (z2) {
            this.bT.put("SETTING_FENCE_RADIUS", 2);
            this.bD.e().a("FENCE_RADIUS");
            this.f12650w.setVisibility(0);
            this.bT.put("SETTING_FENCE_ALT_MAX", 2);
            this.bD.e().a("FENCE_ALT_MAX");
            return;
        }
        this.f12651x.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.f12560a.aC())}));
        this.f12650w.setVisibility(8);
    }

    private void d() {
        this.f12612by = this.f12560a.m();
        this.f12613bz = this.f12560a.k();
        this.f12611bx = this.f12560a.h();
        FlightActionActivity flightActionActivity = this.bM;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public void run() {
                    int i2;
                    f fVar;
                    if (f.this.f12560a.aD() == 0) {
                        fVar = f.this;
                        i2 = 0;
                    } else {
                        i2 = 1;
                        if (f.this.f12560a.aD() != 1) {
                            i2 = 2;
                            if (f.this.f12560a.aD() != 2) {
                                return;
                            }
                        }
                        fVar = f.this;
                    }
                    fVar.g(i2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        if (i2 == 0) {
            this.f12641n.setText(R.string.newui_fly_setting);
            this.f12644q.setVisibility(0);
        } else if (i2 == 1) {
            this.f12641n.setText(R.string.newu_calibration);
            this.f12644q.setVisibility(8);
        } else if (i2 == 2) {
            this.f12641n.setText(R.string.newu_calibration);
            this.f12644q.setVisibility(8);
            this.f12643p.setVisibility(0);
            getChildFragmentManager().a().b(R.id.ll_settting_compass_calibration, new CompassFragment()).d();
            return;
        } else {
            return;
        }
        this.f12643p.setVisibility(8);
    }

    private void d(View view) {
        view.findViewById(R.id.iv_avoidance_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.j(view);
            }
        });
        NiceSwitchButton niceSwitchButton = (NiceSwitchButton) view.findViewById(R.id.radar_chart_switch);
        this.f12608bu = niceSwitchButton;
        niceSwitchButton.setChecked(this.f12560a.aW());
        this.f12608bu.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                f.this.f12560a.r(z2);
            }
        });
        NiceSwitchButton niceSwitchButton2 = (NiceSwitchButton) view.findViewById(R.id.avoidance_switch);
        this.f12607bt = niceSwitchButton2;
        niceSwitchButton2.setChecked(this.f12560a.aX());
        this.f12607bt.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(final NiceSwitchButton niceSwitchButton, boolean z2) {
                if (z2) {
                    if (!f.this.f12608bu.isChecked()) {
                        f.this.f12608bu.setChecked(true);
                    }
                    com.flypro.core.MAVLink.d.a(f.this.bD, true);
                    f.this.f12560a.r(true);
                    return;
                }
                f.this.a(R.string.hint_avoidance, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        com.flypro.core.MAVLink.d.a(f.this.bD, false);
                    }
                }, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        niceSwitchButton.setChecked(true);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(final boolean z2) {
        this.f12618cd = z2;
        FlightActionActivity flightActionActivity = this.bM;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public void run() {
                    f.this.f12560a.e(z2);
                    f.this.c();
                }
            });
        }
    }

    private void e() {
        TextView textView;
        FlightActionActivity flightActionActivity;
        int i2;
        if (this.f12560a.m()) {
            textView = this.J;
            flightActionActivity = this.bM;
            i2 = R.string.newui_alt_fence;
        } else if (this.bC.c()) {
            textView = this.J;
            flightActionActivity = this.bM;
            i2 = R.string.usb_alt_limit;
        } else {
            textView = this.J;
            flightActionActivity = this.bM;
            i2 = R.string.newui_alt_limit;
        }
        textView.setText(flightActionActivity.getString(i2));
    }

    /* access modifiers changed from: private */
    public void e(int i2) {
        TextView textView;
        Drawable drawable;
        TextView textView2;
        Drawable drawable2;
        if (i2 == 0) {
            this.O.setBackground(this.bM.getResources().getDrawable(R.drawable.newui_bg_accent));
            textView2 = this.Q;
            drawable2 = this.bM.getResources().getDrawable(R.drawable.newui_bg_black);
        } else if (i2 == 1) {
            this.O.setBackground(this.bM.getResources().getDrawable(R.drawable.newui_bg_black));
            textView2 = this.Q;
            drawable2 = this.bM.getResources().getDrawable(R.drawable.newui_bg_accent);
        } else if (i2 == 2) {
            this.O.setBackground(this.bM.getResources().getDrawable(R.drawable.newui_bg_black));
            this.Q.setBackground(this.bM.getResources().getDrawable(R.drawable.newui_bg_black));
            textView = this.S;
            drawable = this.bM.getResources().getDrawable(R.drawable.newui_bg_accent);
            textView.setBackground(drawable);
        } else {
            return;
        }
        textView2.setBackground(drawable2);
        textView = this.S;
        drawable = this.bM.getResources().getDrawable(R.drawable.newui_bg_black);
        textView.setBackground(drawable);
    }

    private void e(View view) {
        this.f12561aa = (IImageButton) view.findViewById(R.id.iv_rc_close);
        this.f12562ab = (TextView) view.findViewById(R.id.tv_rc_setting_title);
        this.f12563ac = (LinearLayout) view.findViewById(R.id.gimbal_ll);
        this.f12564ad = (TickSeekBar) view.findViewById(R.id.tickseekbar_gear);
        this.f12565ae = (TextView) view.findViewById(R.id.gimbal_value);
        this.f12566af = (IButton) view.findViewById(R.id.tv_start_pair);
        this.f12567ag = (IButton) view.findViewById(R.id.tv_ten_m);
        this.f12568ah = (IButton) view.findViewById(R.id.tv_five_m);
        this.f12569ai = (LinearLayout) view.findViewById(R.id.switch_bandWidth_ll);
        this.f12584ax = (IButton) view.findViewById(R.id.tv_switch_wifi);
        this.Y = (LinearLayout) view.findViewById(R.id.ll_rc_setting_content);
        this.Z = (FrameLayout) view.findViewById(R.id.ll_setting_rc_speed);
        this.f12575ao = (LinearLayout) view.findViewById(R.id.ll_wifi_switch);
        this.f12585ay = (LinearLayout) view.findViewById(R.id.ll_gimbal_angle);
        this.f12586az = (NiceSwitchButton) view.findViewById(R.id.sb_switch_gimbal);
        this.f12574an = (LinearLayout) view.findViewById(R.id.wifi_channel_ll);
        this.f12573am = (TextView) view.findViewById(R.id.tv_wifi_channel);
        this.f12581au = view.findViewById(R.id.divide_channel);
        this.f12583aw = view.findViewById(R.id.divide_gimbal);
        this.f12582av = view.findViewById(R.id.divide_wifi);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_rc_speed);
        View findViewById = view.findViewById(R.id.divide_speed);
        if (h.c(this.bD)) {
            linearLayout.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
            findViewById.setVisibility(8);
        }
        view.findViewById(R.id.ib_rc_speed).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.i(view);
            }
        });
        if (this.f12560a.aH()) {
            this.f12581au.setVisibility(0);
            this.f12574an.setVisibility(0);
            this.f12573am.setText(this.f12560a.F());
            if (this.bC.c()) {
                this.f12572al = this.bM.getResources().getStringArray(R.array.usb_wifi_channel);
                h();
            } else {
                this.f12572al = this.bM.getResources().getStringArray(R.array.wifi_channel);
                g();
            }
        } else {
            this.f12581au.setVisibility(8);
            this.f12574an.setVisibility(8);
        }
        if (this.bC.c()) {
            this.f12583aw.setVisibility(0);
            this.f12582av.setVisibility(8);
            this.f12585ay.setVisibility(0);
            this.f12575ao.setVisibility(8);
        } else {
            this.f12583aw.setVisibility(8);
            this.f12582av.setVisibility(0);
            this.f12585ay.setVisibility(8);
            this.f12575ao.setVisibility(0);
        }
        this.f12573am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.bC.c()) {
                    if (f.this.f12571ak != null) {
                        if (f.this.f12571ak.isShowing()) {
                            f.this.f12571ak.dismiss();
                            return;
                        }
                        f.this.f12571ak.a(f.this.bM.getApplicationContext(), f.this.f12560a.F());
                        f.this.f12571ak.showAsDropDown(f.this.f12573am, 48, 0, 0);
                    }
                } else if (f.this.f12570aj != null) {
                    if (f.this.f12570aj.isShowing()) {
                        f.this.f12570aj.dismiss();
                        return;
                    }
                    f.this.f12570aj.a(f.this.bM.getApplicationContext(), f.this.f12560a.F());
                    f.this.f12570aj.showAsDropDown(f.this.f12573am, 48, 0, 0);
                }
            }
        });
        this.f12561aa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        if (h.a(this.f12560a, this.bD)) {
            this.f12563ac.setVisibility(0);
        } else {
            this.f12563ac.setVisibility(8);
        }
        this.f12564ad.setOnSeekChangeListener(new com.warkiz.tickseekbar.c() {
            public void a(TickSeekBar tickSeekBar) {
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
            }

            public void b(TickSeekBar tickSeekBar) {
                int progress = tickSeekBar.getProgress();
                Log.i("newUI", "onStopTrackingTouch: ----progress--" + progress);
                final float f2 = ((float) progress) / 100.0f;
                f.this.bD.Q().e(String.format(Locale.US, f.this.bM.getString(R.string.action_seek_ang), new Object[]{Float.valueOf(f2)}));
                f.this.f12565ae.setText(String.format(Locale.US, "%s\t\t%d", new Object[]{f.this.bM.getString(R.string.newui_gimbal_value), Integer.valueOf(progress)}));
                com.xeagle.android.utils.c.a(f.this.bD, "GIMB_ANG", (double) f2, new a.C0168a() {
                    public void a(Parameter parameter, String str) {
                        if (parameter != null && parameter.f14455a.equals("GIMB_ANG")) {
                            double d2 = parameter.f14456b;
                        }
                    }
                });
            }
        });
        this.f12566af.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightActionActivity i2;
                int i3;
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_start_pair));
                if (f.this.bD.d().c()) {
                    i2 = f.this.bM;
                    i3 = R.string.flying_operate_warn;
                } else if (f.this.bL.i().contains("Ground")) {
                    com.xeagle.android.dialogs.w a2 = com.xeagle.android.dialogs.w.a(f.this.bM.getString(R.string.pair_rc), "pair rc", new w.a() {
                        public void onYes() {
                        }
                    });
                    if (a2 != null) {
                        a2.show(f.this.getChildFragmentManager(), "pair");
                        return;
                    }
                    return;
                } else if (f.this.bL.i().contains("Drone")) {
                    com.xeagle.android.dialogs.q a3 = com.xeagle.android.dialogs.q.a(f.this.bM.getString(R.string.pair_rc), "pair rc", new q.b() {
                        public void onYes() {
                        }
                    });
                    if (a3 != null) {
                        a3.show(f.this.getChildFragmentManager(), "wifi-name");
                        return;
                    }
                    return;
                } else if (((XEagleApp) f.this.bM.getApplicationContext()).c()) {
                    ai a4 = ai.a().a(f.this.bM.getString(R.string.pair_rc), "pair rc", new ai.a() {
                        public void onYes() {
                        }
                    });
                    if (!a4.isAdded()) {
                        a4.show(f.this.getChildFragmentManager(), "usb_pair");
                        return;
                    }
                    return;
                } else {
                    i2 = f.this.bM;
                    i3 = R.string.scan_sure_connect;
                }
                ToastUtils.showShort((CharSequence) i2.getString(i3));
            }
        });
        this.f12567ag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.bD.a()) {
                    if (f.this.bD.d().c()) {
                        if (f.this.bU == 0) {
                            f.this.f(10);
                        } else if (f.this.bU == 1) {
                            f.this.f(5);
                        }
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                    }
                    if (f.this.bU == 0) {
                        f.this.f(10);
                    } else {
                        com.xeagle.android.dialogs.d.a(f.this.bM.getString(R.string.warning), f.this.bM.getString(R.string.switch_band_warn), new d.a() {
                            public void onNo() {
                                f fVar;
                                int i2;
                                if (f.this.bU == 0) {
                                    fVar = f.this;
                                    i2 = 10;
                                } else if (f.this.bU == 1) {
                                    fVar = f.this;
                                    i2 = 5;
                                } else {
                                    return;
                                }
                                fVar.f(i2);
                            }

                            public void onYes() {
                                if (f.this.bN == 1 && f.this.f12609bv != null) {
                                    f.this.bJ.send(f.this.f12609bv.b("10", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                    SystemClock.sleep(200);
                                    f.this.bJ.send(f.this.f12609bv.b("10", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                    SystemClock.sleep(200);
                                    f.this.bJ.send(f.this.f12609bv.b("10", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                }
                                f.this.f(10);
                                int unused = f.this.bU = 0;
                            }
                        }).show(f.this.getChildFragmentManager(), "ten");
                    }
                }
            }
        });
        this.f12568ah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.bD.a()) {
                    if (f.this.bD.d().c()) {
                        if (f.this.bU == 0) {
                            f.this.f(10);
                        } else if (f.this.bU == 1) {
                            f.this.f(5);
                        }
                        ToastUtils.showShort((CharSequence) f.this.bM.getString(R.string.flying_operate_warn));
                    }
                    if (f.this.bU == 1) {
                        f.this.f(5);
                    } else {
                        com.xeagle.android.dialogs.d.a(f.this.bM.getString(R.string.warning), f.this.bM.getString(R.string.switch_band_warn), new d.a() {
                            public void onNo() {
                                f fVar;
                                int i2;
                                if (f.this.bU == 0) {
                                    fVar = f.this;
                                    i2 = 10;
                                } else if (f.this.bU == 1) {
                                    fVar = f.this;
                                    i2 = 5;
                                } else {
                                    return;
                                }
                                fVar.f(i2);
                            }

                            public void onYes() {
                                if (f.this.f12609bv != null) {
                                    f.this.bJ.send(f.this.f12609bv.b("5", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                    SystemClock.sleep(200);
                                    f.this.bJ.send(f.this.f12609bv.b("5", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                    SystemClock.sleep(200);
                                    f.this.bJ.send(f.this.f12609bv.b("5", "1"), "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                                }
                                f.this.f(5);
                                int unused = f.this.bU = 1;
                            }
                        }).show(f.this.getChildFragmentManager(), "five");
                    }
                }
            }
        });
        this.f12584ax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.bD.d().c()) {
                    ToastUtils.showShort((int) R.string.flying_operate_warn);
                    return;
                }
                try {
                    CommonUI.a((Context) f.this.bM, Integer.parseInt(f.this.bC.j().H()), f.this.getView(), (CommonUI.a) new CommonUI.a() {
                        public void a(int i2) {
                            if (i2 == 0) {
                                i2 = 14;
                            }
                            if (f.this.f12609bv != null) {
                                AmbaClient G = f.this.f12609bv;
                                G.d(i2 + "");
                            }
                        }
                    });
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void e(final boolean z2) {
        new Thread(new Runnable() {
            public void run() {
                ((XEagleApp) f.this.bM.getApplicationContext()).m().e(true);
                if (f.this.bD.j().e()) {
                    f.this.bD.j().a(12);
                }
                if (f.this.bN == 1) {
                    if (f.this.f12609bv != null) {
                        f.this.f12609bv.f();
                        SystemClock.sleep(200);
                        f.this.f12609bv.disconnect();
                    }
                    new UdpUnbindServer().sendBuffer(new byte[]{-2, -1, -1, -1}, "172.50.10.1", IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
                } else if (f.this.bN == 2 && f.this.bO != null) {
                    f.this.bO.unbindSession(f.this.bM.getApplicationContext());
                    SystemClock.sleep(200);
                    f.this.bO.disconnect();
                }
                if (z2) {
                    f.this.bM.runOnUiThread(new Runnable() {
                        public void run() {
                            com.xeagle.android.dialogs.c unused = f.this.bB = r.a().a(f.this.bM.getString(R.string.warning), String.format(f.this.bM.getString(R.string.unbind_str), new Object[]{5}), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                            if (f.this.bB != null) {
                                f.this.k();
                                f.this.bB.show(f.this.getChildFragmentManager(), "unBind");
                            }
                        }
                    });
                }
            }
        }, "unBind").start();
    }

    private void f() {
        int i2;
        FlightActionActivity flightActionActivity;
        TextView textView;
        if (this.f12578ar == null) {
            if (this.f12560a.G() == 1) {
                textView = this.f12580at;
                flightActionActivity = this.bM;
                i2 = R.string.action_land;
            } else {
                textView = this.f12580at;
                flightActionActivity = this.bM;
                i2 = R.string.action_rtl;
            }
            textView.setText(flightActionActivity.getString(i2));
            this.f12578ar = new lj.a(this.bM, new a.C0218a() {
                public void a(int i2) {
                    if (i2 == 0) {
                        f.this.f12560a.i(2);
                    } else if (i2 == 1) {
                        f.this.f12560a.i(1);
                    }
                    f.this.f12580at.setText(f.this.f12579as[i2]);
                    com.xeagle.android.utils.c.a(f.this.bD, "FS_BATT_ENABLE", (double) f.this.f12560a.G(), (a.C0168a) null);
                    f.this.f12578ar.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f(int i2) {
        IButton iButton;
        Drawable drawable;
        if (i2 == 5) {
            this.f12567ag.setBackground(this.bM.getResources().getDrawable(R.drawable.newui_bg_rc_btn_normal));
            iButton = this.f12568ah;
            drawable = this.bM.getResources().getDrawable(R.drawable.newui_bg_rc_btn_pressed);
        } else if (i2 == 10) {
            this.f12567ag.setBackground(getResources().getDrawable(R.drawable.newui_bg_rc_btn_pressed));
            iButton = this.f12568ah;
            drawable = getResources().getDrawable(R.drawable.newui_bg_rc_btn_normal);
        } else {
            return;
        }
        iButton.setBackground(drawable);
    }

    private void f(View view) {
        this.aD = (IImageButton) view.findViewById(R.id.iv_battery_close);
        this.aE = (TextView) view.findViewById(R.id.tv_battery_num);
        this.aF = (TextView) view.findViewById(R.id.tv_battery_voltage);
        this.aI = (TextView) view.findViewById(R.id.tv_electric);
        this.aG = (TickSeekBar) view.findViewById(R.id.tickseekbar_electric);
        this.aH = (ImageView) view.findViewById(R.id.iv_battery_status);
        this.f12593bf = (LinearLayout) view.findViewById(R.id.ll_bat_active);
        this.f12594bg = (LinearLayout) view.findViewById(R.id.ll_bat_sn);
        this.f12595bh = (LinearLayout) view.findViewById(R.id.ll_bat_version);
        this.f12596bi = (TextView) view.findViewById(R.id.bat_active_tv);
        this.f12597bj = (TextView) view.findViewById(R.id.bat_sn_tv);
        this.f12598bk = (TextView) view.findViewById(R.id.bat_version_tv);
        this.f12599bl = (LinearLayout) view.findViewById(R.id.ll_bat_type);
        this.f12600bm = (TextView) view.findViewById(R.id.bat_type_tv);
        if (h.c(this.f12560a, this.bD)) {
            this.f12595bh.setVisibility(0);
            this.f12594bg.setVisibility(0);
            this.f12593bf.setVisibility(0);
            this.f12599bl.setVisibility(0);
            BatteryInfoData requestLastBatteryInfo = UserLiteHelper.requestLastBatteryInfo();
            if (requestLastBatteryInfo != null) {
                int parseInt = Integer.parseInt(requestLastBatteryInfo.getBatteryActiveTime().substring(0, 4));
                if (parseInt > 2100 || parseInt < 2021 || !g.a(requestLastBatteryInfo.getBatteryType())) {
                    this.f12596bi.setText(R.string.device_inactive);
                } else {
                    this.f12596bi.setText(requestLastBatteryInfo.getBatteryActiveTime());
                }
                if (g.a(requestLastBatteryInfo.getBatteryType())) {
                    this.f12600bm.setText(requestLastBatteryInfo.getBatteryType());
                    this.f12597bj.setText(requestLastBatteryInfo.getBatterySnId());
                    this.f12598bk.setText(requestLastBatteryInfo.getBatteryVersion());
                } else {
                    this.f12600bm.setText("N/A");
                    this.f12598bk.setText("N/A");
                    this.f12597bj.setText("N/A");
                }
            }
            com.flypro.core.MAVLink.q.a(this.bD);
        } else {
            this.f12595bh.setVisibility(8);
            this.f12594bg.setVisibility(8);
            this.f12599bl.setVisibility(8);
            this.f12593bf.setVisibility(8);
        }
        this.aD.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.h(view);
            }
        });
        this.aG.setOnSeekChangeListener(new com.warkiz.tickseekbar.c() {
            public void a(TickSeekBar tickSeekBar) {
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
                int i2 = dVar.f22076b;
                int i3 = 70;
                if (i2 >= 0 && i2 <= 10) {
                    i3 = 10;
                } else if (i2 <= 20) {
                    i3 = 20;
                } else if (i2 <= 30) {
                    i3 = 30;
                } else if (i2 <= 40) {
                    i3 = 40;
                } else if (i2 <= 50) {
                    i3 = 50;
                } else if (i2 <= 60) {
                    i3 = 60;
                } else if (i2 > 70) {
                    i3 = 80;
                }
                f.this.f12560a.a(i3);
                TextView K = f.this.aI;
                K.setText(i3 + "%");
            }

            public void b(TickSeekBar tickSeekBar) {
            }
        });
    }

    private void g() {
        if (this.f12570aj == null) {
            this.f12573am.setText(this.f12560a.F());
            this.f12570aj = new lj.d(this.bM, new d.a() {
                public void a(int i2) {
                    f.this.f12560a.n(f.this.f12572al[i2]);
                    f.this.f12573am.setText(f.this.f12572al[i2]);
                    if (f.this.f12609bv != null && i2 > 0) {
                        f.this.f12609bv.d(f.this.f12572al[i2]);
                    }
                    f.this.f12570aj.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void g(int i2) {
        TextView textView;
        Drawable drawable;
        TextView textView2;
        Drawable drawable2;
        if (i2 == 0) {
            this.aP.setBackground(getResources().getDrawable(R.drawable.newui_bg_accent));
            textView2 = this.aQ;
            drawable2 = getResources().getDrawable(R.drawable.newui_bg_black);
        } else if (i2 == 1) {
            this.aP.setBackground(getResources().getDrawable(R.drawable.newui_bg_black));
            textView2 = this.aQ;
            drawable2 = getResources().getDrawable(R.drawable.newui_bg_accent);
        } else if (i2 == 2) {
            this.aP.setBackground(getResources().getDrawable(R.drawable.newui_bg_black));
            this.aQ.setBackground(getResources().getDrawable(R.drawable.newui_bg_black));
            textView = this.aR;
            drawable = getResources().getDrawable(R.drawable.newui_bg_accent);
            textView.setBackground(drawable);
        } else {
            return;
        }
        textView2.setBackground(drawable2);
        textView = this.aR;
        drawable = getResources().getDrawable(R.drawable.newui_bg_black);
        textView.setBackground(drawable);
    }

    private void g(View view) {
        this.aK = (IImageButton) view.findViewById(R.id.iv_other_close);
        this.aL = (LinearLayout) view.findViewById(R.id.ll_other_setting_content);
        this.aM = (IButton) view.findViewById(R.id.tv_other_seek);
        this.aP = (TextView) view.findViewById(R.id.tv_other_close_grid);
        this.aQ = (TextView) view.findViewById(R.id.tv_other_night_grid);
        this.aR = (TextView) view.findViewById(R.id.tv_other_golden_ratio);
        this.aS = (LinearLayout) view.findViewById(R.id.ll_go_other_version);
        this.aT = (LinearLayout) view.findViewById(R.id.ll_other_version);
        this.aN = (NiceSwitchButton) view.findViewById(R.id.tts_switch_button);
        this.aO = (TextView) view.findViewById(R.id.tv_tts_warn);
        this.aU = (TextView) view.findViewById(R.id.tv_other_app_version);
        this.aV = (TextView) view.findViewById(R.id.tv_other_fly_control_version);
        this.aW = (TextView) view.findViewById(R.id.tv_other_relay_version);
        this.aX = (TextView) view.findViewById(R.id.tv_other_dentifier);
        this.aY = (TextView) view.findViewById(R.id.tv_other_remote_control_version);
        this.aZ = (TextView) view.findViewById(R.id.tv_other_image_version);
        this.f12588ba = (TextView) view.findViewById(R.id.tv_other_hardware_version);
        this.f12589bb = (TextView) view.findViewById(R.id.tv_other_back);
        if (this.bC.c()) {
            String charSequence = this.f12606bs.getText().toString();
            int hashCode = charSequence.hashCode() & 483647;
            String str = null;
            if (com.xeagle.android.utils.c.i(this.f12560a.q()) == 150) {
                str = "01";
            } else if (com.xeagle.android.utils.c.i(this.f12560a.q()) == 160) {
                str = "02";
            } else if (com.xeagle.android.utils.c.i(this.f12560a.q()) == 170) {
                str = "03";
            }
            Log.i("Drone", "initOtherSetting:====== " + hashCode + "==" + charSequence.hashCode());
            String format = String.format(Locale.US, "%d%s", new Object[]{Integer.valueOf(hashCode), str});
            this.aX.setText(getString(R.string.newui_identifier, format));
            this.aX.setVisibility(0);
        } else {
            this.aX.setVisibility(8);
        }
        this.aN.setChecked(this.f12560a.I());
        this.aN.setOnCheckedChangeListener(new NiceSwitchButton.a() {
            public void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2) {
                FlightActionActivity flightActionActivity;
                ListenerData listenerData;
                int i2;
                f.this.f12560a.k(z2);
                km.a i3 = f.this.bC.i();
                if (!z2) {
                    i3.b();
                    f.this.bC.i().a();
                    listenerData = f.this.bD.Q();
                    flightActionActivity = f.this.bM;
                    i2 = R.string.action_close_tts;
                } else {
                    i3.c();
                    listenerData = f.this.bD.Q();
                    flightActionActivity = f.this.bM;
                    i2 = R.string.action_open_tts;
                }
                listenerData.e(flightActionActivity.getString(i2));
            }
        });
        this.aK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.aM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_other_seek));
                if (f.this.bD.d().d()) {
                    ToastUtils.showShort((int) R.string.flying_operate_warn);
                    return;
                }
                f.this.bM.startActivity(new Intent(f.this.bM, FindDroneActivity.class));
            }
        });
        this.aP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_close_grid));
                f.this.g(0);
                f.this.f12560a.p(0);
                org.greenrobot.eventbus.c.a().d(new t(0));
            }
        });
        this.aQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_night_grid));
                f.this.g(1);
                f.this.f12560a.p(1);
                org.greenrobot.eventbus.c.a().d(new t(1));
            }
        });
        this.aR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.bD.Q().e(f.this.bM.getString(R.string.action_golden_ratio));
                f.this.g(2);
                f.this.f12560a.p(2);
                org.greenrobot.eventbus.c.a().d(new t(2));
            }
        });
        this.aS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.aT.setVisibility(0);
                f.this.aL.setVisibility(8);
                ka.a.a().b().execute(new Runnable() {
                    public void run() {
                        String unused = f.this.bG = "N/A";
                        String unused2 = f.this.bH = "N/A";
                        if (f.this.bL.i().contains("Controller") || f.this.bL.i().contains("Ground")) {
                            f.this.bJ.send("cfly_msg version", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, new UdpDataService.OnReceiveDataListener() {
                                public void onReceiveDataListener(String str) {
                                    if ((!str.contains("[") && !str.contains("]") && str.length() >= 14) || str.contains("Addr")) {
                                        String unused = f.this.bG = str;
                                        if (f.this.bG != null && f.this.bG.length() > 6) {
                                            f fVar = f.this;
                                            String unused2 = fVar.bG = f.this.bG.substring(0, 6) + f.this.bG.substring(8, 14);
                                            f.this.f12560a.e(f.this.bG);
                                        }
                                        f.this.bM.runOnUiThread(new Runnable() {
                                            public void run() {
                                                f.this.aW.setText(f.this.getString(R.string.newui_relay_version, f.this.bG));
                                            }
                                        });
                                    }
                                    f.this.i();
                                }

                                public void onReceiveError(String str) {
                                    f fVar;
                                    String str2 = "N/A";
                                    if (!f.this.f12560a.q().equals(str2)) {
                                        fVar = f.this;
                                        str2 = f.this.f12560a.q();
                                    } else {
                                        fVar = f.this;
                                    }
                                    String unused = fVar.bG = str2;
                                    f.this.bM.runOnUiThread(new Runnable() {
                                        public void run() {
                                            f.this.aW.setText(f.this.getString(R.string.newui_relay_version, f.this.bG));
                                        }
                                    });
                                    f.this.i();
                                }
                            });
                        } else {
                            f.this.bM.runOnUiThread(new Runnable() {
                                public void run() {
                                    String str;
                                    TextView textView;
                                    if (com.xeagle.android.utils.c.i(f.this.f12560a.q()) >= 130) {
                                        String unused = f.this.bG = f.this.f12560a.q();
                                        String unused2 = f.this.bH = f.this.f12560a.r();
                                        if (f.this.bG != null && f.this.bG.length() > 6) {
                                            f fVar = f.this;
                                            String unused3 = fVar.bG = f.this.bG.substring(0, 6) + f.this.bG.substring(8, 14);
                                            String unused4 = f.this.bG = f.this.bG.replace("1.6.0", "1.5.0");
                                            f.this.aW.setText(f.this.getString(R.string.newui_relay_version, f.this.bG));
                                            textView = f.this.aY;
                                            str = f.this.getString(R.string.newui_remote_control_version, f.this.bH);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        f.this.aW.setText(f.this.getString(R.string.newui_relay_version, "N/A"));
                                        textView = f.this.aY;
                                        str = f.this.getString(R.string.newui_remote_control_version, "N/A");
                                    }
                                    textView.setText(str);
                                }
                            });
                        }
                    }
                });
                f.this.bM.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.aU.setText(f.this.getString(R.string.newui_app_version, f.this.j()));
                        f.this.aV.setText(f.this.getString(R.string.newui_fly_control_version, f.this.bD.y()));
                        f.this.aZ.setText(f.this.getString(R.string.newui_image_version, f.this.f12560a.t()));
                        f.this.f12588ba.setText(f.this.getString(R.string.newui_hardware_version, f.this.f12560a.u()));
                    }
                });
            }
        });
        this.f12589bb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.aT.setVisibility(8);
                f.this.aL.setVisibility(0);
            }
        });
    }

    private void h() {
        if (this.f12571ak == null) {
            this.f12573am.setText(this.f12560a.F());
            this.f12571ak = new lj.c(this.bM, new c.a() {
                public void a(int i2) {
                    f.this.f12560a.n(f.this.f12572al[i2]);
                    f.this.f12573am.setText(f.this.f12572al[i2]);
                    if (f.this.f12609bv != null && i2 > 0) {
                        f.this.f12609bv.d(f.this.f12572al[i2]);
                    }
                    f.this.f12571ak.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public void i() {
        this.bJ.send("cfly_msg c_version", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, new UdpDataService.OnReceiveDataListener() {
            public void onReceiveDataListener(String str) {
                String unused = f.this.bH = str;
                f.this.f12560a.f(f.this.bH);
                f.this.bM.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.aY.setText(f.this.getString(R.string.newui_remote_control_version, f.this.bH));
                    }
                });
            }

            public void onReceiveError(String str) {
                f fVar;
                String str2 = "N/A";
                if (!f.this.f12560a.r().equalsIgnoreCase(str2)) {
                    fVar = f.this;
                    str2 = fVar.f12560a.r();
                } else {
                    fVar = f.this;
                }
                String unused = fVar.bH = str2;
                f.this.bM.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.aY.setText(f.this.getString(R.string.newui_remote_control_version, f.this.bH));
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        if (this.f12624cj == 1) {
            a(2);
        } else if (this.f12560a.m()) {
            CommonUI.a((Context) this.bM, getView(), Integer.valueOf(R.string.beginner_not_speed), this.bM.getString(R.string.i_see), (CommonUI.b) null);
        } else {
            a(1);
        }
    }

    /* access modifiers changed from: private */
    public String j() {
        try {
            return this.bM.getPackageManager().getPackageInfo(this.bM.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public void k() {
        this.bA--;
        com.xeagle.android.dialogs.c cVar = this.bB;
        if (cVar != null) {
            cVar.a(-65536);
            this.bB.b(String.format(this.bM.getString(R.string.unbind_str), new Object[]{Integer.valueOf(this.bA)}));
        }
        if (this.bA == 0) {
            this.bM.finishAffinity();
        }
        this.bE.removeCallbacks(this.f12614c);
        this.bE.postDelayed(this.f12614c, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        this.f12637j.setVisibility(0);
        this.f12576ap.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void l() {
        en.a aVar = this.bD;
        if (aVar != null) {
            boolean b2 = aVar.x().b();
            this.f12631cq = b2;
            if (!b2) {
                Toast.makeText(this.bM, getString(R.string.failed_start_calibration_message), 1).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        kd.a p2 = ((XEagleApp) this.bM.getApplicationContext()).p();
        final Location c2 = p2.c();
        if (c2 != null) {
            Log.i("UsbDataProxy", "onClick: ===lat==" + c2.getLatitude() + "===lng==" + c2.getLongitude());
            double accuracy = (double) c2.getAccuracy();
            Double.isNaN(accuracy);
            if (accuracy / 5.0d >= 2.4d || c2.getLongitude() == i.f27244a || c2.getLatitude() == i.f27244a || !p2.d()) {
                this.bD.Q().e(this.bM.getString(R.string.action_update_rtl_error));
                if (this.bR == null) {
                    this.bR = r.a().a(this.bM.getString(R.string.warning), this.bM.getString(R.string.rth_update_error), (c.a) new c.a() {
                        public void onYes() {
                        }
                    });
                }
                if (this.bR.isAdded()) {
                    return;
                }
            } else {
                if (this.bS == null) {
                    this.bS = com.xeagle.android.dialogs.d.a(getString(R.string.warning), this.bM.getString(R.string.rth_update_warn));
                }
                if (!this.bS.isAdded()) {
                    this.bS.a(new d.a() {
                        public void onNo() {
                            f.this.bD.Q().e(f.this.bM.getString(R.string.action_update_rtl_deny));
                        }

                        public void onYes() {
                            f.this.bD.Q().e(f.this.bM.getString(R.string.action_update_rtl_success));
                            Log.i("UsbDataProxy", "onYes: ===lat==" + c2.getLatitude() + "===lng==" + c2.getLongitude());
                            com.flypro.core.MAVLink.t.a(f.this.bD, (float) c2.getLatitude(), (float) c2.getLongitude());
                        }
                    });
                    this.bS.show(getChildFragmentManager(), "rthUpdate");
                    return;
                }
                return;
            }
        } else {
            if (this.bR == null) {
                this.bR = r.a().a(this.bM.getString(R.string.warning), this.bM.getString(R.string.rth_update_error), (c.a) new c.a() {
                    public void onYes() {
                    }
                });
            }
            if (this.bR.isAdded()) {
                return;
            }
        }
        this.bR.show(getChildFragmentManager(), "rthError");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean m(View view) {
        ClipboardUtils.copyText(this.f12606bs.getText());
        ToastUtils.showLong((int) R.string.copy_success);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        this.f12637j.setVisibility(8);
        this.f12576ap.setVisibility(0);
        this.bT.put("SETTING_FS_BATT_ENABLE", 1);
        this.bD.e().a("FS_BATT_ENABLE");
    }

    public void a(int i2) {
        s sVar;
        Fragment fragment;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f12630cp = 1;
                this.f12562ab.setText(R.string.setting_speed_change);
                this.Y.setVisibility(8);
                this.Z.setVisibility(0);
                sVar = getChildFragmentManager().a();
                fragment = new z();
            } else if (i2 == 2) {
                this.f12630cp = 2;
                this.f12562ab.setText(R.string.setting_speed_change);
                this.Y.setVisibility(8);
                this.Z.setVisibility(0);
                sVar = getChildFragmentManager().a();
                fragment = new aa();
            } else {
                return;
            }
            sVar.b(R.id.ll_setting_rc_speed, fragment).d();
            return;
        }
        this.f12630cp = 0;
        this.f12562ab.setText(R.string.newui_rc_setting);
        this.Y.setVisibility(0);
        this.Z.setVisibility(8);
    }

    @l(a = ThreadMode.BACKGROUND)
    public void altitudeLevel(jo.a aVar) {
        this.f12625ck = aVar.a();
        this.f12626cl = aVar.b();
        this.f12627cm = aVar.c();
    }

    @l(a = ThreadMode.MAIN)
    public void batRemainEvent(jo.h hVar) {
        ImageView imageView;
        int i2;
        TextView textView = this.aE;
        textView.setText(hVar.a() + "%");
        int a2 = hVar.a();
        if (a2 >= 80) {
            imageView = this.aH;
            i2 = R.drawable.newui_settings_battery_3;
        } else if (a2 >= 40) {
            imageView = this.aH;
            i2 = R.drawable.newui_settings_battery_2;
        } else if (a2 >= 10) {
            imageView = this.aH;
            i2 = R.drawable.newui_settings_battery_1;
        } else {
            imageView = this.aH;
            i2 = R.drawable.newui_settings_battery_0;
        }
        imageView.setImageResource(i2);
    }

    @l(a = ThreadMode.MAIN)
    public void batVolUpdate(jo.i iVar) {
        this.aF.setText(String.format(Locale.US, "  %3.1f v", new Object[]{Double.valueOf(iVar.a() / 1000.0d)}));
    }

    @l(a = ThreadMode.MAIN)
    public void channelMsgEvnet(dy.e eVar) {
        r.a().a(this.bM.getString(R.string.warning), this.bM.getString(R.string.channel_switch_success), (c.a) new c.a() {
            public void onYes() {
            }
        });
    }

    @l(a = ThreadMode.MAIN)
    public void channelSwitchEvent(jo.d dVar) {
        CommonUI.a((Context) this.bM, getView(), dVar.a());
    }

    @l(a = ThreadMode.MAIN)
    public void droneCalImuEvent(j jVar) {
        if (jVar.a() == 52) {
            this.bI.b();
            if (this.f12631cq) {
                b(this.bD.x().c());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02c2, code lost:
        r0.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0302, code lost:
        r0 = r1.bM;
        r2 = com.cfly.uav_pro.R.string.has_no_param;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0307, code lost:
        com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r0.getString(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x04a2, code lost:
        r1.f12622ch.f14456b = r4;
        r0 = r1.bD.e();
        r2 = r1.f12622ch;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0520, code lost:
        r1.f12621cg.f14456b = 32.0d;
        r1.f12622ch.f14456b = 52.0d;
        r1.bD.e().a(r1.f12621cg);
        r1.bD.e().a(r1.f12622ch);
        r1.f12651x.setText("30");
        r0 = r1.H;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x057b, code lost:
        r2.append((int) (r1.f12623ci.f14456b / 100.0d));
        r2.append("");
        r2 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x058c, code lost:
        r0.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d4, code lost:
        r1.bT.put(r2, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0176, code lost:
        r1.bT.put("SETTING_RTL_ALT", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d3, code lost:
        r2.setText(r0);
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void droneParameterEvent(dy.u r19) {
        /*
            r18 = this;
            r1 = r18
            com.flypro.core.parameters.Parameter r0 = r19.a()
            if (r0 == 0) goto L_0x0705
            java.lang.String r2 = r0.f14455a
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            switch(r4) {
                case -2056178156: goto L_0x0068;
                case -1815471759: goto L_0x005d;
                case -1455202176: goto L_0x0052;
                case 245631046: goto L_0x0047;
                case 261056352: goto L_0x003c;
                case 1063068655: goto L_0x0031;
                case 1817033291: goto L_0x0026;
                case 1817033586: goto L_0x001b;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0072
        L_0x001b:
            java.lang.String r4 = "GIMB_ANG"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x0072
        L_0x0024:
            r3 = 7
            goto L_0x0072
        L_0x0026:
            java.lang.String r4 = "GIMB_ADV"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x002f
            goto L_0x0072
        L_0x002f:
            r3 = 6
            goto L_0x0072
        L_0x0031:
            java.lang.String r4 = "FS_BATT_ENABLE "
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x003a
            goto L_0x0072
        L_0x003a:
            r3 = 5
            goto L_0x0072
        L_0x003c:
            java.lang.String r4 = "FENCE_ALT_MAX"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0045
            goto L_0x0072
        L_0x0045:
            r3 = 4
            goto L_0x0072
        L_0x0047:
            java.lang.String r4 = "PSC_limit_alt"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0050
            goto L_0x0072
        L_0x0050:
            r3 = 3
            goto L_0x0072
        L_0x0052:
            java.lang.String r4 = "FENCE_RADIUS"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x005b
            goto L_0x0072
        L_0x005b:
            r3 = 2
            goto L_0x0072
        L_0x005d:
            java.lang.String r4 = "FENCE_ENABLE"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0066
            goto L_0x0072
        L_0x0066:
            r3 = 1
            goto L_0x0072
        L_0x0068:
            java.lang.String r4 = "RTL_ALT"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r3 = 0
        L_0x0072:
            java.lang.String r2 = "50"
            java.lang.String r4 = "30"
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r15 = ""
            java.lang.String r9 = "SETTING_RTL_ALT"
            r10 = 4629700416936869888(0x4040000000000000, double:32.0)
            java.lang.String r12 = "%d"
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            switch(r3) {
                case 0: goto L_0x06af;
                case 1: goto L_0x04bd;
                case 2: goto L_0x0390;
                case 3: goto L_0x02de;
                case 4: goto L_0x0181;
                case 5: goto L_0x0139;
                case 6: goto L_0x00df;
                case 7: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            goto L_0x0705
        L_0x0087:
            java.lang.String r2 = "SETTING_GIMB_ANG"
            boolean r3 = r1.a((java.lang.String) r2)
            if (r3 != 0) goto L_0x0090
            return
        L_0x0090:
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Object r3 = r3.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r7) goto L_0x00d4
            com.warkiz.tickseekbar.TickSeekBar r3 = r1.f12564ad
            double r4 = r0.f14456b
            double r4 = r4 * r16
            long r4 = java.lang.Math.round(r4)
            float r4 = (float) r4
            r3.setProgress(r4)
            android.widget.TextView r3 = r1.f12565ae
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r6]
            com.xeagle.android.activities.FlightActionActivity r6 = r1.bM
            r9 = 2131821979(0x7f11059b, float:1.9276716E38)
            java.lang.String r6 = r6.getString(r9)
            r5[r8] = r6
            double r9 = r0.f14456b
            double r9 = r9 * r16
            long r9 = java.lang.Math.round(r9)
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            r5[r7] = r0
            java.lang.String r0 = "%s\t\t%d"
            java.lang.String r0 = java.lang.String.format(r4, r0, r5)
            r3.setText(r0)
        L_0x00d4:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r1.bT
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r0.put(r2, r3)
            goto L_0x0705
        L_0x00df:
            java.lang.String r2 = "SETTING_GIMB_ADV"
            boolean r3 = r1.a((java.lang.String) r2)
            if (r3 != 0) goto L_0x00e8
            return
        L_0x00e8:
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Object r3 = r3.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r7) goto L_0x0110
            double r3 = r0.f14456b
            r5 = 0
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0104
            com.xeagle.android.newUI.widgets.NiceSwitchButton r0 = r1.f12586az
            r0.setChecked(r8)
            goto L_0x00d4
        L_0x0104:
            double r3 = r0.f14456b
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x00d4
            com.xeagle.android.newUI.widgets.NiceSwitchButton r0 = r1.f12586az
            r0.setChecked(r7)
            goto L_0x00d4
        L_0x0110:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r1.bT
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 != r6) goto L_0x00d4
            r1.aA = r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "onCheckedChanged: =====isCheck=3==="
            r0.append(r3)
            boolean r3 = r1.aA
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "TAG"
            android.util.Log.i(r3, r0)
            goto L_0x00d4
        L_0x0139:
            java.lang.String r2 = "SETTING_FS_BATT_ENABLE"
            boolean r2 = r1.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x0142
            return
        L_0x0142:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.String r3 = "SETTING_FS_BATT_ENABLE"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r7) goto L_0x0176
            com.xeagle.android.utils.prefs.a r2 = r1.f12560a
            double r3 = r0.f14456b
            int r3 = (int) r3
            r2.i((int) r3)
            double r2 = r0.f14456b
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0168
            android.widget.TextView r0 = r1.f12580at
            com.xeagle.android.activities.FlightActionActivity r2 = r1.bM
            r3 = 2131820642(0x7f110062, float:1.9274005E38)
            goto L_0x016f
        L_0x0168:
            android.widget.TextView r0 = r1.f12580at
            com.xeagle.android.activities.FlightActionActivity r2 = r1.bM
            r3 = 2131820660(0x7f110074, float:1.9274041E38)
        L_0x016f:
            java.lang.String r2 = r2.getString(r3)
            r0.setText(r2)
        L_0x0176:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r1.bT
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r0.put(r9, r2)
            goto L_0x0705
        L_0x0181:
            java.lang.String r3 = "SETTING_FENCE_ALT_MAX"
            boolean r9 = r1.a((java.lang.String) r3)
            if (r9 != 0) goto L_0x018a
            return
        L_0x018a:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r1.bT
            java.lang.Object r9 = r9.get(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 != r6) goto L_0x01ff
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12621cg = r0
            double r2 = r0.f14456b
            int r0 = (int) r2
            r2 = 32
            if (r0 > r2) goto L_0x01be
            android.widget.EditText r0 = r1.f12651x
            java.util.Locale r2 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r4 = 30
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r8] = r4
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)
            goto L_0x058c
        L_0x01be:
            int r2 = r0 % 10
            if (r2 != r6) goto L_0x01d8
            android.widget.EditText r2 = r1.f12651x
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r7]
            int r0 = r0 - r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r12, r4)
        L_0x01d3:
            r2.setText(r0)
            goto L_0x0705
        L_0x01d8:
            r3 = 8
            if (r2 != r3) goto L_0x01ee
            android.widget.EditText r2 = r1.f12651x
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r7]
            int r0 = r0 + r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r12, r4)
            goto L_0x01d3
        L_0x01ee:
            android.widget.EditText r2 = r1.f12651x
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r12, r4)
            goto L_0x01d3
        L_0x01ff:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r1.bT
            java.lang.Object r9 = r9.get(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 != r7) goto L_0x0272
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12621cg = r0
            if (r0 != 0) goto L_0x021c
            goto L_0x0302
        L_0x021c:
            int r2 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r2 + r6
            double r2 = (double) r2     // Catch:{ NumberFormatException -> 0x0343 }
            r0.f14456b = r2     // Catch:{ NumberFormatException -> 0x0343 }
            en.a r0 = r1.bD     // Catch:{ NumberFormatException -> 0x0343 }
            dz.a r0 = r0.e()     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r2 = r1.f12621cg     // Catch:{ NumberFormatException -> 0x0343 }
            r0.a((com.flypro.core.parameters.Parameter) r2)     // Catch:{ NumberFormatException -> 0x0343 }
            android.widget.EditText r0 = r1.f12651x     // Catch:{ NumberFormatException -> 0x0343 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0343 }
            int r4 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0343 }
            r3[r8] = r4     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)     // Catch:{ NumberFormatException -> 0x0343 }
            r0.setText(r2)     // Catch:{ NumberFormatException -> 0x0343 }
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            r0.b((int) r2)     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci     // Catch:{ NumberFormatException -> 0x0343 }
            if (r0 == 0) goto L_0x0705
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg     // Catch:{ NumberFormatException -> 0x0343 }
            double r2 = r0.f14456b     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci     // Catch:{ NumberFormatException -> 0x0343 }
            double r4 = r0.f14456b     // Catch:{ NumberFormatException -> 0x0343 }
            double r4 = r4 / r16
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0705
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r2 = r1.f12621cg     // Catch:{ NumberFormatException -> 0x0343 }
            double r2 = r2.f14456b     // Catch:{ NumberFormatException -> 0x0343 }
            double r2 = r2 * r16
            r0.f14456b = r2     // Catch:{ NumberFormatException -> 0x0343 }
            en.a r0 = r1.bD     // Catch:{ NumberFormatException -> 0x0343 }
            dz.a r0 = r0.e()     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r2 = r1.f12623ci     // Catch:{ NumberFormatException -> 0x0343 }
            r0.a((com.flypro.core.parameters.Parameter) r2)     // Catch:{ NumberFormatException -> 0x0343 }
            goto L_0x0705
        L_0x0272:
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r1.bT
            java.lang.Object r6 = r6.get(r3)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 != r5) goto L_0x0705
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r1.bT
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r5.put(r3, r6)
            r1.f12621cg = r0
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x02d1
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            if (r0 == 0) goto L_0x02ae
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r5 = r0.f14456b
            int r0 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x02ae
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            double r5 = r0.f14456b
            r7 = 4643985272004935680(0x4072c00000000000, double:300.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x02ae
            goto L_0x0520
        L_0x02ae:
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r2 = r0.f14456b
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x02c7
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            r0.f14456b = r10
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r2 = r1.f12621cg
        L_0x02c2:
            r0.a((com.flypro.core.parameters.Parameter) r2)
            goto L_0x0705
        L_0x02c7:
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r2 = r0.f14456b
            r4 = 4631952216750555136(0x4048000000000000, double:48.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            goto L_0x0705
        L_0x02d1:
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci
            if (r0 == 0) goto L_0x0705
            android.widget.EditText r0 = r1.f12651x
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x057b
        L_0x02de:
            java.lang.String r2 = "SETTING_PSC_limit_alt"
            boolean r3 = r1.a((java.lang.String) r2)
            if (r3 != 0) goto L_0x02e7
            return
        L_0x02e7:
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Object r3 = r3.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r7) goto L_0x0349
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3.put(r2, r4)
            r1.f12623ci = r0
            if (r0 != 0) goto L_0x0310
        L_0x0302:
            com.xeagle.android.activities.FlightActionActivity r0 = r1.bM
            r2 = 2131821474(0x7f1103a2, float:1.9275692E38)
        L_0x0307:
            java.lang.String r0 = r0.getString(r2)
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r0)
            goto L_0x0705
        L_0x0310:
            int r2 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r2 * 100
            double r2 = (double) r2     // Catch:{ NumberFormatException -> 0x0343 }
            r0.f14456b = r2     // Catch:{ NumberFormatException -> 0x0343 }
            en.a r0 = r1.bD     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.String r2 = "PSC_limit_alt"
            com.flypro.core.parameters.Parameter r3 = r1.f12623ci     // Catch:{ NumberFormatException -> 0x0343 }
            double r3 = r3.f14456b     // Catch:{ NumberFormatException -> 0x0343 }
            boolean r0 = com.xeagle.android.utils.c.b((en.a) r0, (java.lang.String) r2, (double) r3)     // Catch:{ NumberFormatException -> 0x0343 }
            if (r0 == 0) goto L_0x032c
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            r0.o((int) r2)     // Catch:{ NumberFormatException -> 0x0343 }
        L_0x032c:
            android.widget.EditText r0 = r1.f12651x     // Catch:{ NumberFormatException -> 0x0343 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0343 }
            int r4 = r1.f12615ca     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0343 }
            r3[r8] = r4     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)     // Catch:{ NumberFormatException -> 0x0343 }
            r0.setText(r2)     // Catch:{ NumberFormatException -> 0x0343 }
            goto L_0x0705
        L_0x0343:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0705
        L_0x0349:
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Object r3 = r3.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r6) goto L_0x0705
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3.put(r2, r4)
            r1.f12623ci = r0
            double r2 = r0.f14456b
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            int r0 = r0.aC()
            double r4 = (double) r0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x037b
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            com.flypro.core.parameters.Parameter r2 = r1.f12623ci
            double r2 = r2.f14456b
            double r2 = r2 / r16
            int r2 = (int) r2
            r0.o((int) r2)
        L_0x037b:
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x0705
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci
            if (r0 == 0) goto L_0x0705
            android.widget.EditText r0 = r1.f12651x
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x057b
        L_0x0390:
            java.lang.String r3 = "SETTING_FENCE_RADIUS"
            boolean r9 = r1.a((java.lang.String) r3)
            if (r9 != 0) goto L_0x0399
            return
        L_0x0399:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r1.bT
            java.lang.Object r9 = r9.get(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 != r6) goto L_0x0412
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12622ch = r0
            double r2 = r0.f14456b
            int r0 = (int) r2
            r2 = 52
            if (r0 > r2) goto L_0x03cd
            android.widget.EditText r0 = r1.H
            java.util.Locale r2 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r4 = 50
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r8] = r4
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)
            goto L_0x058c
        L_0x03cd:
            int r2 = r0 % 10
            if (r2 != r6) goto L_0x03e4
            android.widget.EditText r2 = r1.H
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r7]
            int r0 = r0 - r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r12, r4)
            goto L_0x01d3
        L_0x03e4:
            r3 = 8
            if (r2 != r3) goto L_0x03fb
            android.widget.EditText r2 = r1.H
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r7]
            int r0 = r0 + r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r8] = r0
            java.lang.String r0 = java.lang.String.format(r3, r12, r4)
            goto L_0x01d3
        L_0x03fb:
            android.widget.EditText r0 = r1.H
            java.util.Locale r2 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r7]
            com.flypro.core.parameters.Parameter r4 = r1.f12622ch
            double r4 = r4.f14456b
            int r4 = (int) r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r8] = r4
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)
            goto L_0x058c
        L_0x0412:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r1.bT
            java.lang.Object r9 = r9.get(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 != r7) goto L_0x045e
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12622ch = r0
            if (r0 != 0) goto L_0x042f
            goto L_0x0302
        L_0x042f:
            int r2 = r1.f12616cb     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r2 + r6
            double r2 = (double) r2     // Catch:{ NumberFormatException -> 0x0343 }
            r0.f14456b = r2     // Catch:{ NumberFormatException -> 0x0343 }
            en.a r0 = r1.bD     // Catch:{ NumberFormatException -> 0x0343 }
            dz.a r0 = r0.e()     // Catch:{ NumberFormatException -> 0x0343 }
            com.flypro.core.parameters.Parameter r2 = r1.f12622ch     // Catch:{ NumberFormatException -> 0x0343 }
            r0.a((com.flypro.core.parameters.Parameter) r2)     // Catch:{ NumberFormatException -> 0x0343 }
            android.widget.EditText r0 = r1.H     // Catch:{ NumberFormatException -> 0x0343 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0343 }
            int r4 = r1.f12616cb     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0343 }
            r3[r8] = r4     // Catch:{ NumberFormatException -> 0x0343 }
            java.lang.String r2 = java.lang.String.format(r2, r12, r3)     // Catch:{ NumberFormatException -> 0x0343 }
            r0.setText(r2)     // Catch:{ NumberFormatException -> 0x0343 }
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a     // Catch:{ NumberFormatException -> 0x0343 }
            int r2 = r1.f12616cb     // Catch:{ NumberFormatException -> 0x0343 }
            r0.c((int) r2)     // Catch:{ NumberFormatException -> 0x0343 }
            goto L_0x0705
        L_0x045e:
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r1.bT
            java.lang.Object r6 = r6.get(r3)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 != r5) goto L_0x0705
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r1.bT
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r5.put(r3, r6)
            r1.f12622ch = r0
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x04b0
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            if (r0 == 0) goto L_0x0498
            double r5 = r0.f14456b
            int r0 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0498
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            double r5 = r0.f14456b
            r7 = 4643985272004935680(0x4072c00000000000, double:300.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0498
            goto L_0x0520
        L_0x0498:
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            double r2 = r0.f14456b
            r4 = 4632515166703976448(0x404a000000000000, double:52.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0705
        L_0x04a2:
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            r0.f14456b = r4
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r2 = r1.f12622ch
            goto L_0x02c2
        L_0x04b0:
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci
            if (r0 == 0) goto L_0x0705
            android.widget.EditText r0 = r1.f12651x
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x057b
        L_0x04bd:
            java.lang.String r3 = "SETTING_FENCE_ENABLE"
            boolean r9 = r1.a((java.lang.String) r3)
            if (r9 != 0) goto L_0x04c6
            return
        L_0x04c6:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r1.bT
            java.lang.Object r9 = r9.get(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 != r6) goto L_0x0591
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r1.bT
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r5.put(r3, r6)
            r1.f12620cf = r0
            double r5 = r0.f14456b
            int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x04f3
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x0500
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            r0.e((boolean) r7)
            goto L_0x0500
        L_0x04f3:
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x0500
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            r0.e((boolean) r8)
        L_0x0500:
            r18.b()
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x0570
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r5 = r0.f14456b
            int r0 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0548
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            double r5 = r0.f14456b
            r7 = 4643985272004935680(0x4072c00000000000, double:300.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0548
        L_0x0520:
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            r0.f14456b = r10
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            r5 = 4632515166703976448(0x404a000000000000, double:52.0)
            r0.f14456b = r5
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r3 = r1.f12621cg
            r0.a((com.flypro.core.parameters.Parameter) r3)
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r3 = r1.f12622ch
            r0.a((com.flypro.core.parameters.Parameter) r3)
            android.widget.EditText r0 = r1.f12651x
            r0.setText(r4)
            android.widget.EditText r0 = r1.H
            goto L_0x058c
        L_0x0548:
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r2 = r0.f14456b
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x0560
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            r0.f14456b = r10
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r2 = r1.f12621cg
            r0.a((com.flypro.core.parameters.Parameter) r2)
            goto L_0x0564
        L_0x0560:
            com.flypro.core.parameters.Parameter r0 = r1.f12621cg
            double r2 = r0.f14456b
        L_0x0564:
            com.flypro.core.parameters.Parameter r0 = r1.f12622ch
            double r2 = r0.f14456b
            r4 = 4632515166703976448(0x404a000000000000, double:52.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0705
            goto L_0x04a2
        L_0x0570:
            com.flypro.core.parameters.Parameter r0 = r1.f12623ci
            if (r0 == 0) goto L_0x0705
            android.widget.EditText r0 = r1.f12651x
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x057b:
            com.flypro.core.parameters.Parameter r3 = r1.f12623ci
            double r3 = r3.f14456b
            double r3 = r3 / r16
            int r3 = (int) r3
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
        L_0x058c:
            r0.setText(r2)
            goto L_0x0705
        L_0x0591:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r7) goto L_0x05d5
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12620cf = r0
            int r2 = r1.f12617cc
            double r6 = (double) r2
            r0.f14456b = r6
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            com.flypro.core.parameters.Parameter r2 = r1.f12620cf
            r0.a((com.flypro.core.parameters.Parameter) r2)
            r6 = 100
            android.os.SystemClock.sleep(r6)
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r1.bT
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0.put(r3, r2)
            en.a r0 = r1.bD
            dz.a r0 = r0.e()
            java.lang.String r2 = "FENCE_ENABLE"
            r0.a((java.lang.String) r2)
            goto L_0x0705
        L_0x05d5:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r5) goto L_0x0705
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r2.put(r3, r4)
            r1.f12620cf = r0
            double r2 = r0.f14456b
            int r0 = r1.f12617cc
            double r4 = (double) r0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0677
            if (r0 != r7) goto L_0x0652
            com.xeagle.android.XEagleApp r0 = r1.bC
            km.a r0 = r0.i()
            com.xeagle.android.activities.FlightActionActivity r2 = r1.bM
            r3 = 2131821271(0x7f1102d7, float:1.927528E38)
            java.lang.String r2 = r2.getString(r3)
            r0.b(r2)
            r18.a()
            r1.c((boolean) r7)
            r18.e()
            boolean r0 = r1.f12618cd
            if (r0 == 0) goto L_0x0705
            com.xeagle.android.dialogs.c r0 = r1.bQ
            if (r0 != 0) goto L_0x063d
            com.xeagle.android.dialogs.r r0 = com.xeagle.android.dialogs.r.a()
            com.xeagle.android.activities.FlightActionActivity r2 = r1.bM
            r3 = 2131821035(0x7f1101eb, float:1.9274802E38)
            java.lang.String r2 = r2.getString(r3)
            com.xeagle.android.activities.FlightActionActivity r3 = r1.bM
            r4 = 2131821272(0x7f1102d8, float:1.9275282E38)
            java.lang.String r3 = r3.getString(r4)
            com.xeagle.android.fragments.f$24 r4 = new com.xeagle.android.fragments.f$24
            r4.<init>()
            com.xeagle.android.dialogs.c r0 = r0.a((java.lang.String) r2, (java.lang.String) r3, (com.xeagle.android.dialogs.c.a) r4)
            r1.bQ = r0
        L_0x063d:
            com.xeagle.android.dialogs.c r0 = r1.bQ
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L_0x0705
            com.xeagle.android.dialogs.c r0 = r1.bQ
            androidx.fragment.app.FragmentManager r2 = r18.getChildFragmentManager()
            java.lang.String r3 = "fence"
            r0.show(r2, r3)
            goto L_0x0705
        L_0x0652:
            if (r0 != 0) goto L_0x0705
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            r0.e((boolean) r8)
            r1.c((boolean) r8)
            r18.e()
            android.widget.EditText r0 = r1.f12651x
            com.xeagle.android.fragments.f$25 r2 = new com.xeagle.android.fragments.f$25
            r2.<init>()
            r0.post(r2)
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            jo.o r2 = new jo.o
            r2.<init>(r7)
            r0.d(r2)
            goto L_0x0705
        L_0x0677:
            if (r0 != r7) goto L_0x069b
            r1.c((boolean) r8)
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            r0.e((boolean) r8)
            com.xeagle.android.activities.FlightActionActivity r0 = r1.bM
            r2 = 2131822652(0x7f11083c, float:1.9278081E38)
            java.lang.String r0 = r0.getString(r2)
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r0)
            r18.e()
            android.widget.EditText r0 = r1.f12651x
            com.xeagle.android.fragments.f$26 r2 = new com.xeagle.android.fragments.f$26
            r2.<init>()
            r0.post(r2)
            goto L_0x0705
        L_0x069b:
            if (r0 != 0) goto L_0x0705
            r18.e()
            r1.c((boolean) r7)
            com.xeagle.android.utils.prefs.a r0 = r1.f12560a
            r0.e((boolean) r7)
            com.xeagle.android.activities.FlightActionActivity r0 = r1.bM
            r2 = 2131822652(0x7f11083c, float:1.9278081E38)
            goto L_0x0307
        L_0x06af:
            boolean r2 = r1.a((java.lang.String) r9)
            if (r2 != 0) goto L_0x06b6
            return
        L_0x06b6:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r1.bT
            java.lang.Object r2 = r2.get(r9)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r7) goto L_0x0176
            double r2 = r0.f14456b
            int r2 = (int) r2
            int r2 = r2 / 100
            r3 = 30
            if (r2 > r3) goto L_0x06d0
            r2 = 30
            goto L_0x06d6
        L_0x06d0:
            r3 = 120(0x78, float:1.68E-43)
            if (r2 < r3) goto L_0x06d6
            r2 = 120(0x78, float:1.68E-43)
        L_0x06d6:
            android.widget.EditText r3 = r1.f12652y
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r5[r8] = r6
            java.lang.String r4 = java.lang.String.format(r4, r12, r5)
            r3.setText(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getTargetParamValue: ---rtl alt--"
            r3.append(r4)
            double r4 = r0.f14456b
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "msg"
            android.util.Log.i(r3, r0)
            r1.bZ = r2
            goto L_0x0176
        L_0x0705:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.f.droneParameterEvent(dy.u):void");
    }

    @l(a = ThreadMode.MAIN)
    public void droneRestore(al alVar) {
        this.bW = true;
    }

    @l(a = ThreadMode.MAIN)
    public void droneWarningEvent(ad adVar) {
        if (this.bD.d().f().equalsIgnoreCase(this.bM.getString(R.string.rtl_height_success_detail)) || this.bD.d().f().equalsIgnoreCase(this.bM.getString(R.string.rtl_height_exceeds_detail)) || this.bD.d().f().equalsIgnoreCase(this.bM.getString(R.string.rtl_height_invalid_detail))) {
            Log.i("msg", "droneWarningEvent: ---success---" + this.bZ);
            EditText editText = this.f12652y;
            editText.setText(this.bZ + "");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void fragmentCancelEvent(jo.q qVar) {
        if (qVar.a().equals("CompassFragment")) {
            d(0);
        } else if (qVar.a().equals("RcSpeedFragment") || qVar.a().equals("RcSportWarnFragment")) {
            a(0);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void gimbalGearEvent(dy.f fVar) {
        byte b2 = fVar.a().f6595i & 1;
        if (b2 == 0 && this.f12624cj != 0) {
            this.f12624cj = 0;
            e(0);
        } else if (b2 == 1 && this.f12624cj != 1) {
            this.f12624cj = 1;
            e(2);
            if (this.f12630cp == 1) {
                a(2);
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void heartbeatTimeoutEvent(am amVar) {
        this.bW = false;
    }

    public void notifyTimeOut(int i2) {
        if (i2 > this.bI.a()) {
            this.bD.x().a(false);
            x xVar = this.bF;
            if (xVar != null) {
                xVar.dismiss();
            }
            com.xeagle.android.dialogs.c a2 = r.a().a(this.bM.getString(R.string.dialog_tips), this.bM.getString(R.string.cal_fail), (c.a) new c.a() {
                public void onYes() {
                }
            });
            if (a2 != null) {
                a2.show(getChildFragmentManager(), "Confirm imu result");
                return;
            }
            return;
        }
        this.bI.a(false);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bM = (FlightActionActivity) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (f12559d || window != null) {
            dialog.show();
            window.setGravity(5);
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 2) / 3, getActivity().getWindowManager().getDefaultDisplay().getHeight());
            return dialog;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        if (!(getDialog() == null || (window = getDialog().getWindow()) == null)) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 5;
            attributes.windowAnimations = R.style.rightSheet_animation;
            getDialog().getWindow().setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f12610bw = layoutInflater.inflate(R.layout.drone_system_setting, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) this.bM.getApplication();
        this.bC = xEagleApp;
        this.bD = xEagleApp.k();
        this.f12560a = this.bC.j();
        this.bN = this.bC.m().a();
        a(this.f12610bw);
        this.bK = this.bM.getApplicationContext().bindService(new Intent(this.bM, UdpDataService.class), this.f12587b, 1);
        if (h.e(this.f12560a, this.bD)) {
            if (this.f12560a.z() == 417) {
                e(0);
                this.bV = 0;
            } else if (this.f12560a.z() == 834) {
                e(1);
                this.bV = 1;
            } else if (this.f12560a.z() == 1580) {
                e(2);
                this.bV = 2;
            }
            a(true);
            this.bD.e().a("WPNAV_LOIT_SPD", new a.C0168a() {
                public void a(Parameter parameter, String str) {
                    f fVar;
                    int i2;
                    if (parameter != null && "WPNAV_LOIT_SPD".equals(parameter.f14455a)) {
                        if (parameter.f14456b < 750.0d) {
                            f.this.f12560a.g(417);
                            fVar = f.this;
                            i2 = 0;
                        } else if (parameter.f14456b >= 750.0d && parameter.f14456b <= 1199.0d) {
                            f.this.f12560a.g(834);
                            fVar = f.this;
                            i2 = 1;
                        } else if (parameter.f14456b >= 1200.0d) {
                            f.this.f12560a.g(1580);
                            fVar = f.this;
                            i2 = 2;
                        } else {
                            return;
                        }
                        fVar.e(i2);
                        int unused = f.this.bV = i2;
                    }
                }
            });
        } else {
            boolean f2 = h.f(this.f12560a, this.bD);
            a(false);
        }
        int i2 = this.bN;
        if (i2 == 1) {
            AmbaClient g2 = ((XEagleApp) this.bM.getApplication()).g();
            this.f12609bv = g2;
            if (g2 != null) {
                g2.n("sw_version");
            }
            if (this.f12560a.aH() && !this.bC.c()) {
                if (!"N/A".equalsIgnoreCase(this.f12560a.q())) {
                    try {
                        if (Integer.parseInt(this.f12560a.q().substring(this.f12560a.q().indexOf("-") + 1)) >= 210117) {
                            b(true);
                        } else {
                            b(false);
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    b(false);
                }
            }
        } else if (i2 == 2) {
            SochipPresenter h2 = ((XEagleApp) this.bM.getApplication()).h();
            this.bO = h2;
            if (h2 != null) {
                h2.getFirmwareVersion(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_VERSION);
            }
        }
        return this.f12610bw;
    }

    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        Log.i("UDP", "onDestroy: -----droneSetting---bind--" + this.bK);
        if (this.bK) {
            UdpDataService udpDataService = this.bJ;
            if (udpDataService != null) {
                udpDataService.stop();
            }
            this.bM.getApplicationContext().unbindService(this.f12587b);
            this.bK = false;
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass60.f23368a[droneEventsType.ordinal()] == 1) {
            this.bI.b();
            if (this.f12631cq) {
                b(aVar.x().c());
            }
        }
    }

    public void onResume() {
        super.onResume();
        a();
        d();
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @l(a = ThreadMode.MAIN)
    public void parameterTimeoutEvent(at atVar) {
    }

    @l(a = ThreadMode.MAIN)
    public void stateEvent(y yVar) {
        NiceSwitchButton niceSwitchButton;
        boolean z2;
        if (this.bD.d().d()) {
            niceSwitchButton = this.f12645r;
            if (niceSwitchButton != null) {
                z2 = false;
            } else {
                return;
            }
        } else {
            niceSwitchButton = this.f12645r;
            if (niceSwitchButton != null) {
                z2 = true;
            } else {
                return;
            }
        }
        niceSwitchButton.setEnabled(z2);
    }

    @l(a = ThreadMode.MAIN)
    public void updateInfo(com.flypro.core.drone.f fVar) {
        TextView textView;
        String str;
        if (fVar.a().equalsIgnoreCase("battery")) {
            int parseInt = Integer.parseInt(this.bD.T().a().substring(0, 4));
            if (parseInt > 2100 || parseInt < 2021 || !g.a(this.bD.T().d())) {
                this.f12596bi.setText(R.string.device_inactive);
            } else {
                this.f12596bi.setText(this.bD.T().a());
            }
            if (g.a(this.bD.T().d())) {
                this.f12600bm.setText(this.bD.T().d());
                this.f12598bk.setText(this.bD.T().b());
                textView = this.f12597bj;
                str = String.format(Locale.US, "%s", new Object[]{this.bD.T().c()});
            } else {
                str = "N/A";
                this.f12600bm.setText(str);
                this.f12598bk.setText(str);
                textView = this.f12597bj;
            }
        } else if (fVar.a().equalsIgnoreCase("drone")) {
            this.f12606bs.setText(this.bD.S().c());
            int parseInt2 = Integer.parseInt(this.bD.S().a().substring(0, 4));
            if (parseInt2 > 2100 || parseInt2 < 2021) {
                this.f12605br.setText(R.string.device_inactive);
                return;
            } else {
                textView = this.f12605br;
                str = this.bD.S().a();
            }
        } else {
            return;
        }
        textView.setText(str);
    }
}
