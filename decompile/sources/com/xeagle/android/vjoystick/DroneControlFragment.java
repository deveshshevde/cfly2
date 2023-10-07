package com.xeagle.android.vjoystick;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import ch.b;
import com.MAVLink.Messages.ApmModes;
import com.MAVLink.common.msg_image_data;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.customeui.widget.CommonUI;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.m;
import com.flypro.core.drone.e;
import com.flypro.core.drone.variables.SonarData;
import com.flypro.core.drone.variables.aa;
import com.flypro.core.drone.variables.ab;
import com.flypro.core.gcs.follow.Follow;
import com.flypro.core.parameters.Parameter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.hoho.android.usb.rtsp.a;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.dialogs.ae;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.x;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.beans.sochipBeans.CmdListener;
import com.xeagle.android.login.beans.sochipBeans.SochipInfoStatus;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordTimeBean;
import com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean;
import com.xeagle.android.login.beans.sochipBeans.SochipStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipVersionBean;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.gsy.video.EmptyControlVideo;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress;
import com.xeagle.android.vjoystick.DroneControlFragment;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.JoyStickView;
import com.xeagle.android.vjoystick.a;
import com.xeagle.android.vjoystick.gallery.CflyGalleryActivity;
import com.xeagle.android.vjoystick.view.DrawRectangleView;
import com.xeagle.android.widgets.GridRelativeLayout;
import com.xeagle.android.widgets.ZJTextView;
import dy.ac;
import dy.ak;
import dy.al;
import dy.an;
import dy.au;
import dy.ax;
import dy.bd;
import dy.bf;
import dy.h;
import dy.k;
import dy.p;
import dy.q;
import dy.u;
import dy.v;
import dy.w;
import dy.y;
import fg.i;
import io.microshow.rxffmpeg.RxFFmpegCommandList;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import io.microshow.rxffmpeg.RxFFmpegSubscriber;
import io.reactivex.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jo.ad;
import jo.ah;
import jo.ai;
import jo.aj;
import jo.am;
import jo.ap;
import jo.aq;
import jo.ar;
import jo.as;
import jo.at;
import jo.av;
import jo.ay;
import jo.az;
import jo.ba;
import jo.bc;
import jo.bg;
import jo.g;
import jo.n;
import jo.r;
import jo.s;
import jo.t;
import jv.b;
import ks.e;
import lj.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class DroneControlFragment extends com.xeagle.android.fragments.a implements TextureView.SurfaceTextureListener, View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f12789g = false;

    /* renamed from: x  reason: collision with root package name */
    static final /* synthetic */ boolean f12790x = true;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static final String f12791y = "com.xeagle.android.vjoystick.DroneControlFragment";
    private TextureView A;
    private JoyStickView B;
    private JoyStickView C;
    /* access modifiers changed from: private */
    public IImageButton D;
    /* access modifiers changed from: private */
    public IImageButton E;
    private IImageButton F;
    /* access modifiers changed from: private */
    public Chronometer G;
    /* access modifiers changed from: private */
    public ImageView H;
    private LinearLayout I;
    /* access modifiers changed from: private */
    public ConstraintLayout J;
    private ConstraintLayout K;
    /* access modifiers changed from: private */
    public IImageButton L;
    private IButton M;
    private TextView N;
    private IButton O;
    private boolean P;
    private int Q = 0;
    private RelativeLayout R;
    private ZJTextView S;
    private ZJTextView T;
    private ZJTextView U;
    private ZJTextView V;
    private TextView W;
    private ZJTextView X;
    private ZJTextView Y;
    private ZJTextView Z;
    /* access modifiers changed from: private */
    public TextView aA;
    /* access modifiers changed from: private */
    public ProgressBar aB;
    private TextView aC;
    private IButton aD;
    private double aE;
    /* access modifiers changed from: private */
    public boolean aF;
    /* access modifiers changed from: private */
    public boolean aG;
    private ab aH;
    /* access modifiers changed from: private */
    public x aI;
    /* access modifiers changed from: private */
    public c aJ;
    /* access modifiers changed from: private */
    public c aK;
    /* access modifiers changed from: private */
    public c aL;
    private d aM;
    private d aN;
    /* access modifiers changed from: private */
    public ProgressBar aO;
    /* access modifiers changed from: private */
    public ImageView aP;
    /* access modifiers changed from: private */
    public TextView aQ;
    private TextView aR;
    /* access modifiers changed from: private */
    public TextView aS;
    /* access modifiers changed from: private */
    public TextView aT;
    /* access modifiers changed from: private */
    public TextView aU;
    private IButton aV;
    private IImageButton aW;
    private TextView aX;
    private TextView aY;
    private TextView aZ;

    /* renamed from: aa  reason: collision with root package name */
    private ZJTextView f12792aa;

    /* renamed from: ab  reason: collision with root package name */
    private ZJTextView f12793ab;

    /* renamed from: ac  reason: collision with root package name */
    private ZJTextView f12794ac;

    /* renamed from: ad  reason: collision with root package name */
    private TextView f12795ad;

    /* renamed from: ae  reason: collision with root package name */
    private TextView f12796ae;

    /* renamed from: af  reason: collision with root package name */
    private TextView f12797af;

    /* renamed from: ag  reason: collision with root package name */
    private TextView f12798ag;

    /* renamed from: ah  reason: collision with root package name */
    private TextView f12799ah;

    /* renamed from: ai  reason: collision with root package name */
    private TextView f12800ai;

    /* renamed from: aj  reason: collision with root package name */
    private TextView f12801aj;

    /* renamed from: ak  reason: collision with root package name */
    private TextView f12802ak;

    /* renamed from: al  reason: collision with root package name */
    private IButton f12803al;

    /* renamed from: am  reason: collision with root package name */
    private TextView f12804am;

    /* renamed from: an  reason: collision with root package name */
    private TextView f12805an;

    /* renamed from: ao  reason: collision with root package name */
    private TextView f12806ao;

    /* renamed from: ap  reason: collision with root package name */
    private TextView f12807ap;

    /* renamed from: aq  reason: collision with root package name */
    private TextView f12808aq;

    /* renamed from: ar  reason: collision with root package name */
    private TextView f12809ar;

    /* renamed from: as  reason: collision with root package name */
    private TextView f12810as;

    /* renamed from: at  reason: collision with root package name */
    private TextView f12811at;

    /* renamed from: au  reason: collision with root package name */
    private TextView f12812au;

    /* renamed from: av  reason: collision with root package name */
    private TextView f12813av;

    /* renamed from: aw  reason: collision with root package name */
    private TextView f12814aw;

    /* renamed from: ax  reason: collision with root package name */
    private TextView f12815ax;

    /* renamed from: ay  reason: collision with root package name */
    private ProgressBar f12816ay;
    /* access modifiers changed from: private */

    /* renamed from: az  reason: collision with root package name */
    public TextView f12817az;
    /* access modifiers changed from: private */
    public en.a bA;
    /* access modifiers changed from: private */
    public com.xeagle.android.utils.prefs.a bB;
    /* access modifiers changed from: private */
    public a bC;
    /* access modifiers changed from: private */
    public com.xeagle.android.dialogs.ab bD;
    private ae bE;
    private b bF;
    private boolean bG = true;
    private boolean bH;
    private boolean bI;
    /* access modifiers changed from: private */
    public boolean bJ;
    /* access modifiers changed from: private */
    public int bK;
    /* access modifiers changed from: private */
    public float bL;
    private boolean bM = true;
    private boolean bN = false;
    private boolean bO = true;
    private double bP = 1.0d;
    private boolean bQ;
    /* access modifiers changed from: private */
    public boolean bR;
    private boolean bS;
    private kd.a bT;
    private Follow bU;
    private RelativeLayout bV;
    private int[] bW;
    private boolean bX = false;
    private boolean bY = false;
    private List<SonarData> bZ = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: ba  reason: collision with root package name */
    public TextView f12818ba;

    /* renamed from: bb  reason: collision with root package name */
    private ImageView f12819bb;
    /* access modifiers changed from: private */

    /* renamed from: bc  reason: collision with root package name */
    public TextView f12820bc;
    /* access modifiers changed from: private */

    /* renamed from: bd  reason: collision with root package name */
    public VerticalSeekBar f12821bd;
    /* access modifiers changed from: private */

    /* renamed from: be  reason: collision with root package name */
    public TextView f12822be;

    /* renamed from: bf  reason: collision with root package name */
    private TextView f12823bf;

    /* renamed from: bg  reason: collision with root package name */
    private TextView f12824bg;
    /* access modifiers changed from: private */

    /* renamed from: bh  reason: collision with root package name */
    public FrameLayout f12825bh;
    /* access modifiers changed from: private */

    /* renamed from: bi  reason: collision with root package name */
    public DrawRectangleView f12826bi;
    /* access modifiers changed from: private */

    /* renamed from: bj  reason: collision with root package name */
    public TextView f12827bj;
    /* access modifiers changed from: private */

    /* renamed from: bk  reason: collision with root package name */
    public TextView f12828bk;
    /* access modifiers changed from: private */

    /* renamed from: bl  reason: collision with root package name */
    public TextView f12829bl;
    /* access modifiers changed from: private */

    /* renamed from: bm  reason: collision with root package name */
    public boolean f12830bm = false;

    /* renamed from: bn  reason: collision with root package name */
    private IButton f12831bn;

    /* renamed from: bo  reason: collision with root package name */
    private IButton f12832bo;

    /* renamed from: bp  reason: collision with root package name */
    private int f12833bp = -1;

    /* renamed from: bq  reason: collision with root package name */
    private int f12834bq = -1;

    /* renamed from: br  reason: collision with root package name */
    private int f12835br = -1;

    /* renamed from: bs  reason: collision with root package name */
    private int f12836bs = 1920;

    /* renamed from: bt  reason: collision with root package name */
    private int f12837bt = 1080;

    /* renamed from: bu  reason: collision with root package name */
    private int f12838bu = 30;

    /* renamed from: bv  reason: collision with root package name */
    private IButton f12839bv;
    /* access modifiers changed from: private */

    /* renamed from: bw  reason: collision with root package name */
    public String[] f12840bw;
    /* access modifiers changed from: private */

    /* renamed from: bx  reason: collision with root package name */
    public lj.b f12841bx;

    /* renamed from: by  reason: collision with root package name */
    private int f12842by = 0;

    /* renamed from: bz  reason: collision with root package name */
    private a f12843bz;
    private boolean cA = false;
    private int cB = -1;
    private int cC = 0;
    private int cD = 0;
    private int cE = 0;
    private float cF = 0.0f;
    private int cG = 7;
    /* access modifiers changed from: private */
    public com.cfly.customeui.widget.a cH;
    private double[] cI = new double[5];
    private OrientationEventListener cJ;
    private int cK;
    private long cL = 0;
    private HashMap<String, Boolean> cM = new HashMap<>();
    /* access modifiers changed from: private */
    public CircleLineProgress cN;
    /* access modifiers changed from: private */
    public IImageButton cO;
    private Bitmap cP;
    /* access modifiers changed from: private */
    public int cQ = 0;
    private boolean cR = false;
    private VisionModeStatus cS;
    /* access modifiers changed from: private */
    public int cT = 0;
    private long cU = 0;
    private int cV = 500;
    private double cW;
    private boolean cX = false;
    private String cY;
    /* access modifiers changed from: private */
    public CountDownTimer cZ;

    /* renamed from: ca  reason: collision with root package name */
    private ef.a f12844ca;

    /* renamed from: cb  reason: collision with root package name */
    private int f12845cb;

    /* renamed from: cc  reason: collision with root package name */
    private int f12846cc;

    /* renamed from: cd  reason: collision with root package name */
    private int f12847cd;

    /* renamed from: ce  reason: collision with root package name */
    private int f12848ce;

    /* renamed from: cf  reason: collision with root package name */
    private int f12849cf;

    /* renamed from: cg  reason: collision with root package name */
    private int f12850cg;

    /* renamed from: ch  reason: collision with root package name */
    private int f12851ch;

    /* renamed from: ci  reason: collision with root package name */
    private int f12852ci;

    /* renamed from: cj  reason: collision with root package name */
    private int f12853cj;

    /* renamed from: ck  reason: collision with root package name */
    private int f12854ck;

    /* renamed from: cl  reason: collision with root package name */
    private int[] f12855cl;

    /* renamed from: cm  reason: collision with root package name */
    private String f12856cm;

    /* renamed from: cn  reason: collision with root package name */
    private boolean f12857cn;

    /* renamed from: co  reason: collision with root package name */
    private String f12858co;

    /* renamed from: cp  reason: collision with root package name */
    private String f12859cp;

    /* renamed from: cq  reason: collision with root package name */
    private double f12860cq = -1.0d;

    /* renamed from: cr  reason: collision with root package name */
    private GridRelativeLayout f12861cr;

    /* renamed from: cs  reason: collision with root package name */
    private ef.a f12862cs;
    /* access modifiers changed from: private */

    /* renamed from: ct  reason: collision with root package name */
    public FlightActionActivity f12863ct;
    /* access modifiers changed from: private */

    /* renamed from: cu  reason: collision with root package name */
    public int f12864cu;

    /* renamed from: cv  reason: collision with root package name */
    private int f12865cv = -1;
    /* access modifiers changed from: private */

    /* renamed from: cw  reason: collision with root package name */
    public int f12866cw;
    /* access modifiers changed from: private */

    /* renamed from: cx  reason: collision with root package name */
    public float f12867cx;
    /* access modifiers changed from: private */

    /* renamed from: cy  reason: collision with root package name */
    public float f12868cy;

    /* renamed from: cz  reason: collision with root package name */
    private boolean f12869cz;
    private double dA = i.f27244a;
    private Runnable dB = new Runnable() {
        public final void run() {
            DroneControlFragment.this.P();
        }
    };
    private boolean dC;
    private x dD;
    private double dE = i.f27244a;
    private boolean dF = false;
    /* access modifiers changed from: private */
    public String dG;
    /* access modifiers changed from: private */
    public String dH;
    /* access modifiers changed from: private */
    public com.cfly.customeui.widget.a dI;
    /* access modifiers changed from: private */
    public ProgressBar dJ;
    /* access modifiers changed from: private */
    public TextView dK;
    private int dL = -1;
    private int dM = -1;
    private Parameter dN;
    private Parameter dO;
    private Parameter dP;
    /* access modifiers changed from: private */
    public boolean dQ = false;
    private boolean dR = false;
    private int dS = -1;
    private int dT = -1;
    private boolean dU;
    private boolean dV;
    /* access modifiers changed from: private */
    public float dW = 0.0f;
    /* access modifiers changed from: private */
    public float dX = 0.0f;
    private c dY;
    private boolean dZ;
    /* access modifiers changed from: private */

    /* renamed from: da  reason: collision with root package name */
    public int f12870da = 0;
    /* access modifiers changed from: private */

    /* renamed from: db  reason: collision with root package name */
    public boolean f12871db;

    /* renamed from: dc  reason: collision with root package name */
    private final BroadcastReceiver f12872dc = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String str;
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                if (intExtra == 0) {
                    str = "wifiState:WIFI_STATE_DISABLING";
                } else if (intExtra == 1) {
                    org.greenrobot.eventbus.c.a().d(new r(true));
                    Log.i("WIFI状态", "wifiState:WIFI_STATE_DISABLED");
                    if (DroneControlFragment.this.f12540a.a() != null && !DroneControlFragment.this.f12540a.a().i().contains("Drone") && !DroneControlFragment.this.f12540a.a().i().contains("Ground")) {
                        boolean contains = DroneControlFragment.this.f12540a.a().i().contains("Controller");
                        return;
                    }
                    return;
                } else if (intExtra == 2) {
                    str = "wifiState:WIFI_STATE_ENABLING";
                } else if (intExtra == 3) {
                    Log.i("WIFI状态", "wifiState:WIFI_STATE_ENABLED");
                    Log.i("HEART", "onReceive: ");
                    if (DroneControlFragment.this.f12540a.a().i().contains("Drone") || DroneControlFragment.this.f12540a.a().i().contains("Ground") || DroneControlFragment.this.f12540a.a().i().contains("Controller")) {
                        if (!DroneControlFragment.this.bA.j().a()) {
                            DroneControlFragment.this.bA.j().a(16);
                            DroneControlFragment.this.f();
                            return;
                        }
                        return;
                    } else if (DroneControlFragment.this.f12540a != null && !DroneControlFragment.this.f12540a.c()) {
                        ToastUtils.showLong((CharSequence) DroneControlFragment.this.f12863ct.getString(R.string.warn_connect_wifi));
                        return;
                    } else {
                        return;
                    }
                } else if (intExtra == 4) {
                    str = "wifiState:WIFI_STATE_UNKNOWN";
                } else {
                    return;
                }
                Log.i("WIFI状态", str);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: dd  reason: collision with root package name */
    public jv.d f12873dd;
    /* access modifiers changed from: private */

    /* renamed from: de  reason: collision with root package name */
    public Surface f12874de;
    /* access modifiers changed from: private */

    /* renamed from: df  reason: collision with root package name */
    public jv.b f12875df = new jv.b();
    /* access modifiers changed from: private */

    /* renamed from: dg  reason: collision with root package name */
    public View f12876dg;

    /* renamed from: dh  reason: collision with root package name */
    private io.reactivex.disposables.b f12877dh;

    /* renamed from: di  reason: collision with root package name */
    private boolean f12878di = false;

    /* renamed from: dj  reason: collision with root package name */
    private IButton f12879dj;

    /* renamed from: dk  reason: collision with root package name */
    private String f12880dk;

    /* renamed from: dl  reason: collision with root package name */
    private long f12881dl;
    /* access modifiers changed from: private */

    /* renamed from: dm  reason: collision with root package name */
    public Runnable f12882dm = new Runnable() {
        public void run() {
            if (DroneControlFragment.this.cT >= 3) {
                int unused = DroneControlFragment.this.cT = 0;
                DroneControlFragment.this.a(VisionModeStatus.RESET);
                ToastUtils.showLong((CharSequence) "设置模式失败");
                return;
            }
            DroneControlFragment.L(DroneControlFragment.this);
            DroneControlFragment.this.bA.d().b(ApmModes.ROTOR_TRACKER);
            DroneControlFragment.this.bA.d().b(ApmModes.ROTOR_TRACKER);
            DroneControlFragment.this.bC.postDelayed(DroneControlFragment.this.f12882dm, 800);
            Log.i("TrackerVisualManager", "mChangeTracker:" + DroneControlFragment.this.cT);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: dn  reason: collision with root package name */
    public Runnable f12883dn = new Runnable() {
        public void run() {
            int unused = DroneControlFragment.this.f12870da = 0;
        }
    };

    /* renamed from: do  reason: not valid java name */
    private ks.c f0do = new ks.c() {
        public void a(int i2) {
            if (i2 == 444) {
                DroneControlFragment.this.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (DroneControlFragment.this.aK == null) {
                            c unused = DroneControlFragment.this.aK = com.xeagle.android.dialogs.r.a().a(DroneControlFragment.this.getString(R.string.warning), DroneControlFragment.this.getString(R.string.target_lost_tip), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                        }
                        if (!DroneControlFragment.this.aK.isAdded() && !DroneControlFragment.this.getActivity().isDestroyed()) {
                            DroneControlFragment.this.aK.show(DroneControlFragment.this.getChildFragmentManager(), "tracker lost");
                        }
                    }
                });
            }
            DroneControlFragment.this.a(VisionModeStatus.RESET);
            String h2 = DroneControlFragment.f12791y;
            Log.e(h2, "==> onTrackerError code = " + i2);
        }

        public void a(int i2, int i3, int i4, int i5) {
            final int i6 = i2;
            final int i7 = i3;
            final int i8 = i4;
            final int i9 = i5;
            DroneControlFragment.this.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    DrawRectangleView p2 = DroneControlFragment.this.f12826bi;
                    int i2 = i6;
                    int i3 = i7;
                    p2.a(i2, i3, i8 + i2, i9 + i3);
                }
            });
            String replaceAll = com.xeagle.android.utils.a.c().replaceAll(" ", "");
            float a2 = com.xeagle.android.utils.a.a();
            long b2 = com.xeagle.android.utils.a.b(DroneControlFragment.this.getContext());
            String h2 = DroneControlFragment.f12791y;
            Log.i(h2, "trackerImp appMem :" + replaceAll + " ,availMem:" + b2);
            if (a2 >= 75.0f || b2 < 1258291200) {
                if (DroneControlFragment.this.f12870da == 0) {
                    DroneControlFragment.this.bC.removeCallbacks(DroneControlFragment.this.f12883dn);
                    DroneControlFragment.this.bC.postDelayed(DroneControlFragment.this.f12883dn, 5000);
                }
                DroneControlFragment.R(DroneControlFragment.this);
                if (DroneControlFragment.this.f12870da >= 5) {
                    int unused = DroneControlFragment.this.f12870da = 0;
                    DroneControlFragment.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            DroneControlFragment.this.O();
                            ToastUtils.showShort((int) R.string.vision_exit_warn);
                        }
                    });
                }
            }
        }
    };

    /* renamed from: dp  reason: collision with root package name */
    private ks.a f12884dp = new ks.a() {

        /* renamed from: b  reason: collision with root package name */
        private int[] f24636b;

        public void a() {
            super.a();
        }

        public void a(int[] iArr) {
            DroneControlFragment.this.a(iArr, this.f24636b);
            this.f24636b = iArr;
        }

        public void b() {
            super.b();
            this.f24636b = null;
        }

        public void d() {
            b();
            super.d();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: dq  reason: collision with root package name */
    public ValueAnimator f12885dq;
    /* access modifiers changed from: private */

    /* renamed from: dr  reason: collision with root package name */
    public boolean f12886dr;
    /* access modifiers changed from: private */

    /* renamed from: ds  reason: collision with root package name */
    public boolean f12887ds;

    /* renamed from: dt  reason: collision with root package name */
    private Runnable f12888dt = new Runnable() {
        public final void run() {
            DroneControlFragment.this.A();
        }
    };

    /* renamed from: du  reason: collision with root package name */
    private boolean f12889du = false;

    /* renamed from: dv  reason: collision with root package name */
    private int f12890dv;

    /* renamed from: dw  reason: collision with root package name */
    private float f12891dw;

    /* renamed from: dx  reason: collision with root package name */
    private Matrix f12892dx = new Matrix();

    /* renamed from: dy  reason: collision with root package name */
    private Matrix f12893dy = new Matrix();

    /* renamed from: dz  reason: collision with root package name */
    private Runnable f12894dz = new Runnable() {
        public final void run() {
            DroneControlFragment.this.L();
        }
    };

    /* renamed from: ea  reason: collision with root package name */
    private int f12895ea = -1;

    /* renamed from: eb  reason: collision with root package name */
    private int f12896eb = 0;

    /* renamed from: ec  reason: collision with root package name */
    private long f12897ec = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12898h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12899i;

    /* renamed from: j  reason: collision with root package name */
    hb.a f12900j = new hb.a() {
        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            DroneControlFragment.this.aO.setVisibility(8);
        }

        public void a(a.b bVar) {
            if (bVar.f20236a != null) {
                DroneControlFragment.this.f12875df.b();
                byte[] bArr = bVar.f20236a.f20242b;
                byte[] bArr2 = bVar.f20236a.f20243c;
                if (bArr == null || bArr2 == null) {
                    Log.w(DroneControlFragment.f12791y, "onRtspConnected: ===RTSP SPS and PPS NAL units missed in SDP");
                } else if (DroneControlFragment.this.f12873dd != null) {
                    DroneControlFragment.this.f12873dd.a(bArr, bArr2);
                }
            }
        }

        public void a(byte[] bArr, int i2, int i3, long j2) {
            if (i3 > 0) {
                boolean unused = DroneControlFragment.this.f12871db = true;
                if (DroneControlFragment.this.aO.getVisibility() != 8) {
                    DroneControlFragment.this.bC.post(new Runnable() {
                        public final void run() {
                            DroneControlFragment.AnonymousClass12.this.a();
                        }
                    });
                }
                DroneControlFragment.this.f12875df.a(new b.C0201b(bArr, i2, i3, j2));
            }
        }
    };

    /* renamed from: k  reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f12901k = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            DroneControlFragment droneControlFragment = DroneControlFragment.this;
            droneControlFragment.checkGridType(new t(droneControlFragment.bB.aD()));
        }
    };

    /* renamed from: l  reason: collision with root package name */
    Runnable f12902l = new Runnable() {
        public final void run() {
            DroneControlFragment.this.C();
        }
    };

    /* renamed from: m  reason: collision with root package name */
    Runnable f12903m = new Runnable() {
        public final void run() {
            DroneControlFragment.this.g();
        }
    };

    /* renamed from: n  reason: collision with root package name */
    JoyStickView.b f12904n = new JoyStickView.b() {
    };

    /* renamed from: o  reason: collision with root package name */
    JoyStickView.b f12905o = new JoyStickView.b() {
    };

    /* renamed from: p  reason: collision with root package name */
    a.C0152a f12906p = new a.C0152a() {
        public final void onSensor(float f2, float f3, float f4) {
            DroneControlFragment.this.a(f2, f3, f4);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    double[] f12907q = new double[5];

    /* renamed from: r  reason: collision with root package name */
    double[] f12908r = new double[5];

    /* renamed from: s  reason: collision with root package name */
    Runnable f12909s = new Runnable() {
        public final void run() {
            DroneControlFragment.this.ac();
        }
    };

    /* renamed from: t  reason: collision with root package name */
    Runnable f12910t = new Runnable() {
        public void run() {
            DroneControlFragment.this.ah();
        }
    };

    /* renamed from: u  reason: collision with root package name */
    int f12911u = 0;

    /* renamed from: v  reason: collision with root package name */
    Runnable f12912v = new Runnable() {
        public void run() {
            if (DroneControlFragment.this.aF) {
                DroneControlFragment.this.aj();
            }
        }
    };

    /* renamed from: w  reason: collision with root package name */
    Runnable f12913w = new Runnable() {
        public void run() {
            if (DroneControlFragment.this.aG) {
                DroneControlFragment.this.ak();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public EmptyControlVideo f12914z;

    public enum VisionModeStatus {
        READY,
        RUN,
        STOP,
        RESET
    }

    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            DroneControlFragment.this.aP.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void a(ImageView imageView) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            imageView.setLayoutParams(layoutParams);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void a(ImageView imageView, String str) {
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            imageView.setLayoutParams(layoutParams);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (DroneControlFragment.this.aO.getVisibility() == 0) {
                Log.i("CmdChannel", "run:-----timeout....... ");
                DroneControlFragment.this.bC.sendEmptyMessage(IChannelListener.CMD_CHANNEL_NO_MORE_SPACE);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            TextView U = DroneControlFragment.this.aA;
            U.setText("Current wifi:" + DroneControlFragment.this.f12540a.a().i());
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a3, code lost:
            r0.setEnabled(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x03bf, code lost:
            com.xeagle.android.vjoystick.DroneControlFragment.an(r11.f24646a).startPlayLogic();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x06f2, code lost:
            if (com.xeagle.android.vjoystick.DroneControlFragment.aJ(r11.f24646a) != null) goto L_0x07e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x07e5, code lost:
            if (com.xeagle.android.vjoystick.DroneControlFragment.aJ(r11.f24646a) != null) goto L_0x07e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x02ad, code lost:
            com.xeagle.android.vjoystick.DroneControlFragment.a(r0, r0.getString(r1));
         */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0500  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r12) {
            /*
                r11 = this;
                r11.obtainMessage()
                int r0 = r12.what
                r1 = 4
                if (r0 == r1) goto L_0x08bc
                r2 = 17
                r3 = 2131230927(0x7f0800cf, float:1.807792E38)
                r4 = 2131232027(0x7f08051b, float:1.8080152E38)
                r5 = 8
                r6 = 0
                if (r0 == r2) goto L_0x0800
                r2 = 19
                r7 = 0
                r8 = 2131230923(0x7f0800cb, float:1.8077912E38)
                r9 = 2131232040(0x7f080528, float:1.8080178E38)
                r10 = 1
                if (r0 == r2) goto L_0x078f
                r2 = 73
                if (r0 == r2) goto L_0x0788
                r2 = 80
                if (r0 == r2) goto L_0x0781
                r2 = 82
                if (r0 == r2) goto L_0x077a
                r2 = 86
                if (r0 == r2) goto L_0x076f
                r2 = 88
                if (r0 == r2) goto L_0x0764
                r2 = 120(0x78, float:1.68E-43)
                if (r0 == r2) goto L_0x0759
                r2 = 257(0x101, float:3.6E-43)
                if (r0 == r2) goto L_0x06f6
                r2 = 55
                if (r0 == r2) goto L_0x06ab
                r2 = 56
                r7 = 2131822822(0x7f1108e6, float:1.9278426E38)
                if (r0 == r2) goto L_0x063e
                r2 = 152(0x98, float:2.13E-43)
                if (r0 == r2) goto L_0x05e5
                r2 = 153(0x99, float:2.14E-43)
                r8 = 2131822823(0x7f1108e7, float:1.9278428E38)
                if (r0 == r2) goto L_0x05c7
                r2 = 2131820824(0x7f110118, float:1.9274374E38)
                switch(r0) {
                    case 113: goto L_0x05c0;
                    case 114: goto L_0x05b9;
                    case 115: goto L_0x0508;
                    case 116: goto L_0x048c;
                    case 117: goto L_0x03f0;
                    case 118: goto L_0x03ca;
                    default: goto L_0x0059;
                }
            L_0x0059:
                r1 = 2131823185(0x7f110a51, float:1.9279163E38)
                switch(r0) {
                    case 128: goto L_0x03a8;
                    case 129: goto L_0x0394;
                    case 130: goto L_0x037f;
                    case 131: goto L_0x0342;
                    case 132: goto L_0x02df;
                    case 133: goto L_0x02b6;
                    case 134: goto L_0x02a8;
                    case 135: goto L_0x023d;
                    case 136: goto L_0x021f;
                    case 137: goto L_0x01fa;
                    default: goto L_0x005f;
                }
            L_0x005f:
                switch(r0) {
                    case 144: goto L_0x01c3;
                    case 145: goto L_0x018c;
                    case 146: goto L_0x0185;
                    default: goto L_0x0062;
                }
            L_0x0062:
                r1 = 2
                java.lang.String r2 = ""
                switch(r0) {
                    case 148: goto L_0x017e;
                    case 149: goto L_0x00a8;
                    case 150: goto L_0x006a;
                    default: goto L_0x0068;
                }
            L_0x0068:
                goto L_0x08ca
            L_0x006a:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x0082
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.k()
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.i()
                goto L_0x08ca
            L_0x0082:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r1) goto L_0x0097
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r0.f12914z
                java.lang.String r1 = "rtsp://172.50.10.1:8554/ch01"
            L_0x0092:
                r0.setUp(r1, r10, r2)
                goto L_0x03bf
            L_0x0097:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r10) goto L_0x03bf
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r0.f12914z
                java.lang.String r1 = "rtsp://172.50.10.1/live"
                goto L_0x0092
            L_0x00a8:
                android.os.Bundle r0 = r12.getData()
                java.lang.String r2 = "vCacheCount"
                int r0 = r0.getInt(r2)
                android.os.Bundle r2 = r12.getData()
                java.lang.String r3 = "outPutFps"
                float r2 = r2.getFloat(r3)
                android.os.Bundle r3 = r12.getData()
                java.lang.String r4 = "decodeFps"
                float r3 = r3.getFloat(r4)
                android.os.Bundle r4 = r12.getData()
                java.lang.String r5 = "vCache"
                java.lang.String r4 = r4.getString(r5)
                android.os.Bundle r5 = r12.getData()
                java.lang.String r7 = "vDuration"
                java.lang.String r5 = r5.getString(r7)
                com.xeagle.android.vjoystick.DroneControlFragment r7 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r7 = r7.aU
                java.util.Locale r8 = java.util.Locale.US
                java.lang.Object[] r9 = new java.lang.Object[r1]
                java.lang.Float r2 = java.lang.Float.valueOf(r2)
                r9[r6] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r3)
                r9[r10] = r2
                java.lang.String r2 = "fps:%.1f/%.1f"
                java.lang.String r2 = java.lang.String.format(r8, r2, r9)
                r7.setText(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r2 = r2.aS
                java.util.Locale r3 = java.util.Locale.US
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r6] = r4
                r1[r10] = r5
                java.lang.String r4 = "vcache:%s/%s"
                java.lang.String r1 = java.lang.String.format(r3, r4, r1)
                r2.setText(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r1 = r1.aT
                java.util.Locale r2 = java.util.Locale.US
                java.lang.Object[] r3 = new java.lang.Object[r10]
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r3[r6] = r0
                java.lang.String r0 = "count:%d"
                java.lang.String r0 = java.lang.String.format(r2, r0, r3)
                r1.setText(r0)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                com.flypro.core.util.e r0 = r0.a()
                if (r0 == 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                com.flypro.core.util.e r0 = r0.a()
                java.lang.String r0 = r0.g()
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r1 = r1.f12817az
                java.lang.CharSequence r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.f12817az
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "IP:"
                r1.append(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r2 = r2.f12540a
                com.flypro.core.util.e r2 = r2.a()
                java.lang.String r2 = r2.g()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                goto L_0x03eb
            L_0x017e:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.b((java.lang.String) r2)
                goto L_0x08ca
            L_0x0185:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r1 = 2131820826(0x7f11011a, float:1.9274378E38)
                goto L_0x02ad
            L_0x018c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.x r0 = r0.aI
                if (r0 == 0) goto L_0x019d
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.x r0 = r0.aI
                r0.dismiss()
            L_0x019d:
                com.xeagle.android.dialogs.r r0 = com.xeagle.android.dialogs.r.a()
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r1 = r2.getString(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r3 = 2131822582(0x7f1107f6, float:1.927794E38)
                java.lang.String r2 = r2.getString(r3)
                com.xeagle.android.vjoystick.DroneControlFragment$a$3 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$a$3
                r3.<init>()
                com.xeagle.android.dialogs.c r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r3)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                java.lang.String r2 = "formatFail"
                goto L_0x02da
            L_0x01c3:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.x r0 = r0.aI
                if (r0 == 0) goto L_0x01d4
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.x r0 = r0.aI
                r0.dismiss()
            L_0x01d4:
                com.xeagle.android.dialogs.r r0 = com.xeagle.android.dialogs.r.a()
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r1 = r2.getString(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r3 = 2131822584(0x7f1107f8, float:1.9277944E38)
                java.lang.String r2 = r2.getString(r3)
                com.xeagle.android.vjoystick.DroneControlFragment$a$4 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$a$4
                r3.<init>()
                com.xeagle.android.dialogs.c r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r3)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                java.lang.String r2 = "formatSuccess"
                goto L_0x02da
            L_0x01fa:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r0 = r0.getString(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r2 = 2131821185(0x7f110281, float:1.9275106E38)
                java.lang.String r1 = r1.getString(r2)
                com.xeagle.android.vjoystick.DroneControlFragment$a$5 r2 = new com.xeagle.android.vjoystick.DroneControlFragment$a$5
                r2.<init>()
                com.xeagle.android.dialogs.d r0 = com.xeagle.android.dialogs.d.a(r0, r1, r2)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                java.lang.String r2 = "formatSd"
                r0.show(r1, r2)
                goto L_0x08ca
            L_0x021f:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                boolean r0 = r0.c()
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r0.bC
                com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$vk8cKINKJzDiTtgjSXmt1cbUZ8A r1 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$vk8cKINKJzDiTtgjSXmt1cbUZ8A
                r1.<init>()
                r2 = 3000(0xbb8, double:1.482E-320)
                r0.postDelayed(r1, r2)
                goto L_0x08ca
            L_0x023d:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x024a
                return
            L_0x024a:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bR
                if (r0 == 0) goto L_0x0257
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean unused = r0.bR = r6
            L_0x0257:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ProgressBar r0 = r0.aO
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x026c
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ProgressBar r0 = r0.aO
                r0.setVisibility(r5)
            L_0x026c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.aQ
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x0281
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.aQ
                r0.setVisibility(r5)
            L_0x0281:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.aP
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x029d
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.aP
                com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$gOADy7JoIqW3zIPiWruCGTeE9Yo r1 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$gOADy7JoIqW3zIPiWruCGTeE9Yo
                r1.<init>()
                r2 = 300(0x12c, double:1.48E-321)
                r0.postDelayed(r1, r2)
            L_0x029d:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r0.f12914z
                r0.onVideoResume()
                goto L_0x08ca
            L_0x02a8:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r1 = 2131820827(0x7f11011b, float:1.927438E38)
            L_0x02ad:
                java.lang.String r1 = r0.getString(r1)
                r0.b((java.lang.String) r1)
                goto L_0x08ca
            L_0x02b6:
                com.xeagle.android.dialogs.r r0 = com.xeagle.android.dialogs.r.a()
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r1 = r2.getString(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r3 = 2131821184(0x7f110280, float:1.9275104E38)
                java.lang.String r2 = r2.getString(r3)
                com.xeagle.android.vjoystick.DroneControlFragment$a$2 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$a$2
                r3.<init>()
                com.xeagle.android.dialogs.c r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r3)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                java.lang.String r2 = "sd protected"
            L_0x02da:
                r0.show(r1, r2)
                goto L_0x08ca
            L_0x02df:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r10) goto L_0x02fe
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.f12898h
                if (r0 == 0) goto L_0x02fe
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.f12542c
                if (r0 == 0) goto L_0x02fe
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.f12542c
                r0.x()
            L_0x02fe:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.c r0 = r0.aJ
                if (r0 != 0) goto L_0x0327
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.r r2 = com.xeagle.android.dialogs.r.a()
                com.xeagle.android.vjoystick.DroneControlFragment r3 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r1 = r3.getString(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r3 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r4 = 2131821205(0x7f110295, float:1.9275147E38)
                java.lang.String r3 = r3.getString(r4)
                com.xeagle.android.vjoystick.DroneControlFragment$a$1 r4 = new com.xeagle.android.vjoystick.DroneControlFragment$a$1
                r4.<init>()
                com.xeagle.android.dialogs.c r1 = r2.a((java.lang.String) r1, (java.lang.String) r3, (com.xeagle.android.dialogs.c.a) r4)
                com.xeagle.android.dialogs.c unused = r0.aJ = r1
            L_0x0327:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.c r0 = r0.aJ
                boolean r0 = r0.isAdded()
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.c r0 = r0.aJ
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
                java.lang.String r2 = "no space"
                goto L_0x02da
            L_0x0342:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                boolean r0 = r0.isEnabled()
                if (r0 != 0) goto L_0x0357
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setEnabled(r10)
            L_0x0357:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                boolean r0 = r0.isEnabled()
                if (r0 != 0) goto L_0x036c
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setEnabled(r10)
            L_0x036c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                boolean r0 = r0.isEnabled()
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                goto L_0x03a3
            L_0x037f:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.activities.FlightActionActivity r0 = r0.f12863ct
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r1 = r1.getString(r2)
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r6)
            L_0x038f:
                r0.show()
                goto L_0x08ca
            L_0x0394:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r0 = r0.getString(r8)
                com.blankj.utilcode.util.ToastUtils.showLong((java.lang.CharSequence) r0)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
            L_0x03a3:
                r0.setEnabled(r10)
                goto L_0x08ca
            L_0x03a8:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.XEagleApp r0 = r0.f12540a
                boolean r0 = r0.c()
                if (r0 == 0) goto L_0x03b6
                goto L_0x08ca
            L_0x03b6:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r0.f12914z
                r0.clearCurrentCache()
            L_0x03bf:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r0.f12914z
                r0.startPlayLogic()
                goto L_0x08ca
            L_0x03ca:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.f12898h
                if (r0 != 0) goto L_0x03d6
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.f12899i
                if (r0 == 0) goto L_0x03db
            L_0x03d6:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.Y()
            L_0x03db:
                com.xeagle.android.vjoystick.DroneControlFragment.f12789g = r6
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r1 = 0
                float unused = r0.bL = r1
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.f12818ba
                java.lang.String r1 = "N/A"
            L_0x03eb:
                r0.setText(r1)
                goto L_0x08ca
            L_0x03f0:
                android.os.Bundle r0 = r12.getData()
                java.lang.String r2 = "recordTime"
                int r0 = r0.getInt(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r2 = r2.bJ
                if (r2 == 0) goto L_0x043a
                boolean r2 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r2 == 0) goto L_0x043a
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setImageResource(r3)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r1)
            L_0x0433:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.y()
                goto L_0x08ca
            L_0x043a:
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r1 = r1.cN
                r1.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r1.cO
                r1.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r1.E
                r1.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r1.E
                r1.setImageResource(r4)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r1 = r1.G
                r1.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r1 = r1.H
                r1.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r1 = r1.G
                long r2 = android.os.SystemClock.elapsedRealtime()
                int r0 = r0 * 1000
                long r4 = (long) r0
                long r2 = r2 - r4
                r1.setBase(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.start()
                goto L_0x08ca
            L_0x048c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.L
                r2 = 2131232031(0x7f08051f, float:1.808016E38)
                r0.setImageResource(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r10) goto L_0x04bb
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setEnabled(r10)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setEnabled(r10)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setEnabled(r10)
            L_0x04bb:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x04df
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                int r0 = r0.getVisibility()
                if (r0 != r5) goto L_0x04f4
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                goto L_0x04f1
            L_0x04df:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                int r0 = r0.getVisibility()
                if (r0 != r1) goto L_0x04f4
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
            L_0x04f1:
                r0.setVisibility(r6)
            L_0x04f4:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                goto L_0x0754
            L_0x0508:
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 != 0) goto L_0x051c
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.f12899i
                if (r0 == 0) goto L_0x051c
                com.xeagle.android.vjoystick.DroneControlFragment r12 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r12 = r12.getString(r2)
                com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r12)
                return
            L_0x051c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.L
                r2 = 2131232032(0x7f080520, float:1.8080162E38)
                r0.setImageResource(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r10) goto L_0x054b
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setEnabled(r10)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setEnabled(r10)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setEnabled(r10)
            L_0x054b:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x057b
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r5)
            L_0x057b:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x05a2
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r5)
            L_0x05a2:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                int r0 = r0.getVisibility()
                if (r0 != r5) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setVisibility(r6)
                goto L_0x08ca
            L_0x05b9:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.b((int) r10)
                goto L_0x08ca
            L_0x05c0:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.H()
                goto L_0x08ca
            L_0x05c7:
                int r0 = r12.arg1
                if (r0 != 0) goto L_0x05da
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.activities.FlightActionActivity r0 = r0.f12863ct
                java.lang.String r0 = r0.getString(r7)
            L_0x05d5:
                com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r0)
                goto L_0x08ca
            L_0x05da:
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 != 0) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                java.lang.String r0 = r0.getString(r8)
                goto L_0x05d5
            L_0x05e5:
                android.os.Bundle r0 = r12.getData()
                java.lang.String r1 = "scale_image_value"
                int r0 = r0.getInt(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r1 = r1.f12864cu
                if (r1 != r10) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.VerticalSeekBar r1 = r1.f12821bd
                int r2 = r0 / 8
                r1.setProgress(r2)
                java.lang.String r1 = "%.1f X"
                if (r2 != 0) goto L_0x061e
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.f12820bc
                java.util.Locale r2 = java.util.Locale.US
                java.lang.Object[] r3 = new java.lang.Object[r10]
                r4 = 0
                java.lang.Double r4 = java.lang.Double.valueOf(r4)
                r3[r6] = r4
                java.lang.String r1 = java.lang.String.format(r2, r1, r3)
                goto L_0x03eb
            L_0x061e:
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r2 = r2.f12820bc
                java.util.Locale r3 = java.util.Locale.US
                java.lang.Object[] r4 = new java.lang.Object[r10]
                double r7 = (double) r0
                r9 = 4636737291354636288(0x4059000000000000, double:100.0)
                java.lang.Double.isNaN(r7)
                double r7 = r7 / r9
                java.lang.Double r0 = java.lang.Double.valueOf(r7)
                r4[r6] = r0
                java.lang.String r0 = java.lang.String.format(r3, r1, r4)
                r2.setText(r0)
                goto L_0x08ca
            L_0x063e:
                java.lang.Object r0 = r12.obj
                if (r0 != 0) goto L_0x064e
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.activities.FlightActionActivity r0 = r0.f12863ct
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r7, r6)
                goto L_0x038f
            L_0x064e:
                java.lang.Object r0 = r12.obj
                java.lang.String r0 = r0.toString()
                com.xeagle.android.vjoystick.DroneControlFragment r1 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.view.View r1 = r1.f12876dg
                r2 = 2131296781(0x7f09020d, float:1.8211488E38)
                android.view.View r1 = r1.findViewById(r2)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                android.graphics.Bitmap r2 = com.xeagle.android.utils.c.b((java.lang.String) r0)
                r1.setImageBitmap(r2)
                r1.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.activities.FlightActionActivity r2 = r2.f12863ct
                android.content.Context r2 = r2.getApplicationContext()
                r3 = 2130771983(0x7f01000f, float:1.7147072E38)
                android.view.animation.Animation r2 = android.view.animation.AnimationUtils.loadAnimation(r2, r3)
                android.view.animation.DecelerateInterpolator r3 = new android.view.animation.DecelerateInterpolator
                r3.<init>()
                r2.setInterpolator(r3)
                r1.startAnimation(r2)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.DroneControlFragment$a r2 = r2.bC
                com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$4eVv-xguSee8S_QFYAQTEdSEKkY r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$4eVv-xguSee8S_QFYAQTEdSEKkY
                r3.<init>(r1)
                r4 = 800(0x320, double:3.953E-321)
                r2.postDelayed(r3, r4)
                com.xeagle.android.vjoystick.DroneControlFragment r2 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.DroneControlFragment$a r2 = r2.bC
                com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$johrO9WVgsfOBbTaxlj_WuIiPhI r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$johrO9WVgsfOBbTaxlj_WuIiPhI
                r3.<init>(r1, r0)
                r0 = 2000(0x7d0, double:9.88E-321)
                r2.postDelayed(r3, r0)
                goto L_0x08ca
            L_0x06ab:
                java.lang.String r0 = "device"
                java.lang.String r2 = "stop rec plan stop"
                android.util.Log.i(r0, r2)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x06c8
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 == 0) goto L_0x06c8
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setImageResource(r8)
                goto L_0x06ec
            L_0x06c8:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setImageResource(r9)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.stop()
            L_0x06ec:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.animation.ValueAnimator r0 = r0.f12885dq
                if (r0 == 0) goto L_0x08ca
                goto L_0x07e7
            L_0x06f6:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                int r0 = r0.f12864cu
                if (r0 != r10) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.utils.prefs.a r0 = r0.bB
                int r0 = r0.E()
                if (r0 != r10) goto L_0x08ca
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setVisibility(r5)
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 == 0) goto L_0x073c
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x073c
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setVisibility(r1)
                goto L_0x08ca
            L_0x073c:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
            L_0x0754:
                r0.setVisibility(r5)
                goto L_0x08ca
            L_0x0759:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.D
                r0.setEnabled(r6)
                goto L_0x08ca
            L_0x0764:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                en.a r1 = r0.bA
                r0.e((en.a) r1)
                goto L_0x08ca
            L_0x076f:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                en.a r1 = r0.bA
                r0.i((en.a) r1)
                goto L_0x08ca
            L_0x077a:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.E()
                goto L_0x08ca
            L_0x0781:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.R()
                goto L_0x08ca
            L_0x0788:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.Q()
                goto L_0x08ca
            L_0x078f:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x07bb
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 == 0) goto L_0x07bb
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                r0.f12898h = r6
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setImageResource(r8)
                goto L_0x07df
            L_0x07bb:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setImageResource(r9)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.stop()
            L_0x07df:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.animation.ValueAnimator r0 = r0.f12885dq
                if (r0 == 0) goto L_0x08ca
            L_0x07e7:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.animation.ValueAnimator r0 = r0.f12885dq
                r0.setRepeatCount(r10)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.animation.ValueAnimator r0 = r0.f12885dq
                r0.cancel()
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.animation.ValueAnimator unused = r0.f12885dq = r7
                goto L_0x08ca
            L_0x0800:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x080d
                return
            L_0x080d:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x0823
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 == 0) goto L_0x0823
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setImageResource(r3)
                goto L_0x083e
            L_0x0823:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.E
                r0.setImageResource(r4)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.ImageView r0 = r0.H
                r0.setVisibility(r6)
            L_0x083e:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                long r1 = android.os.SystemClock.elapsedRealtime()
                r0.setBase(r1)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.Chronometer r0 = r0.G
                r0.start()
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                boolean r0 = r0.bJ
                if (r0 == 0) goto L_0x087f
                boolean r0 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r0 == 0) goto L_0x087f
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                int r0 = r0.getVisibility()
                if (r0 != r5) goto L_0x089d
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r6)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setVisibility(r6)
                goto L_0x089d
            L_0x087f:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x089d
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r0 = r0.cN
                r0.setVisibility(r5)
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.vjoystick.IWidgets.IImageButton r0 = r0.cO
                r0.setVisibility(r5)
            L_0x089d:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.ab r0 = r0.bD
                if (r0 == 0) goto L_0x0433
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.ab r0 = r0.bD
                boolean r0 = r0.isAdded()
                if (r0 == 0) goto L_0x0433
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                com.xeagle.android.dialogs.ab r0 = r0.bD
                r0.dismiss()
                goto L_0x0433
            L_0x08bc:
                com.xeagle.android.vjoystick.DroneControlFragment r0 = com.xeagle.android.vjoystick.DroneControlFragment.this
                android.widget.TextView r0 = r0.aA
                com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$YDn3FvU0ciSJQLMGNRGTDtnEbic r1 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$a$YDn3FvU0ciSJQLMGNRGTDtnEbic
                r1.<init>()
                r0.post(r1)
            L_0x08ca:
                super.handleMessage(r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.a.handleMessage(android.os.Message):void");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A() {
        /*
            r11 = this;
            com.xeagle.android.utils.prefs.a r0 = r11.bB
            boolean r0 = r0.aH()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002c
            en.a r0 = r11.bA
            com.flypro.core.drone.a r0 = r0.P()
            com.xeagle.android.XEagleApp r3 = r11.f12540a
            com.flypro.core.util.e r3 = r3.a()
            int r3 = r3.h()
            int r3 = java.lang.Math.abs(r3)
            com.xeagle.android.utils.prefs.a r4 = r11.bB
            int r4 = r4.aB()
            if (r3 > r4) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            r0.j(r3)
        L_0x002c:
            com.xeagle.android.XEagleApp r0 = r11.f12540a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0035
            return
        L_0x0035:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            r3 = 300(0x12c, double:1.48E-321)
            if (r0 == 0) goto L_0x0191
            long r5 = r0.getVideoCachedBytes()
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x004b
            int r0 = r11.cC
            int r0 = r0 + r1
            r11.cC = r0
            goto L_0x004d
        L_0x004b:
            r11.cC = r2
        L_0x004d:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            long r5 = r0.getVideoCachedDuration()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x005d
            int r0 = r11.cD
            int r0 = r0 + r1
            r11.cD = r0
            goto L_0x0080
        L_0x005d:
            int r0 = r11.cD
            if (r0 <= 0) goto L_0x0063
            r11.cD = r2
        L_0x0063:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            long r5 = r0.getVideoCachedDuration()
            r7 = 150(0x96, double:7.4E-322)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0080
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getPlayingSpeed()
            r5 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            r0.setSpeed(r5)
        L_0x0080:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getDecodeFps()
            float r5 = r11.cF
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0097
            r11.cE = r2
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getDecodeFps()
            r11.cF = r0
            goto L_0x00a9
        L_0x0097:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getDecodeFps()
            double r5 = (double) r0
            r7 = 4620130267728707584(0x401e000000000000, double:7.5)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a9
            int r0 = r11.cE
            int r0 = r0 + r1
            r11.cE = r0
        L_0x00a9:
            com.xeagle.android.XEagleApp r0 = r11.f12540a
            com.flypro.core.util.e r0 = r0.a()
            if (r0 == 0) goto L_0x00de
            com.xeagle.android.XEagleApp r0 = r11.f12540a
            com.flypro.core.util.e r0 = r0.a()
            java.lang.String r0 = r0.g()
            java.lang.String r5 = "172.50.10"
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L_0x00dc
            com.xeagle.android.XEagleApp r0 = r11.f12540a
            com.flypro.core.util.e r0 = r0.a()
            java.lang.String r0 = r0.g()
            java.lang.String r5 = "192.168.10"
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L_0x00dc
            boolean r0 = r11.f12889du
            if (r0 != 0) goto L_0x00de
            r11.f12889du = r1
            goto L_0x00de
        L_0x00dc:
            r11.f12889du = r2
        L_0x00de:
            com.xeagle.android.utils.prefs.a r0 = r11.bB
            boolean r0 = r0.aH()
            if (r0 == 0) goto L_0x0137
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            r1 = 149(0x95, float:2.09E-43)
            r0.what = r1
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.xeagle.android.login.gsy.video.EmptyControlVideo r5 = r11.f12914z
            float r5 = r5.getOutputFps()
            java.lang.String r6 = "outPutFps"
            r1.putFloat(r6, r5)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r5 = r11.f12914z
            float r5 = r5.getDecodeFps()
            java.lang.String r6 = "decodeFps"
            r1.putFloat(r6, r5)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r5 = r11.f12914z
            long r5 = r5.getVideoCachedBytes()
            java.lang.String r5 = com.xeagle.android.utils.c.a((long) r5)
            java.lang.String r6 = "vCache"
            r1.putString(r6, r5)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r5 = r11.f12914z
            long r5 = r5.getVideoCachedDuration()
            java.lang.String r5 = com.xeagle.android.utils.c.b((long) r5)
            java.lang.String r6 = "vDuration"
            r1.putString(r6, r5)
            int r5 = r11.cC
            java.lang.String r6 = "vCacheCount"
            r1.putInt(r6, r5)
            r0.setData(r1)
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r11.bC
            r1.dispatchMessage(r0)
        L_0x0137:
            int r0 = r11.cC
            java.lang.String r1 = "rtsp"
            r5 = 128(0x80, float:1.794E-43)
            r6 = 12
            if (r0 != r6) goto L_0x016e
            r11.cC = r2
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getDecodeFps()
            r7 = 0
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0162
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r11.f12914z
            float r0 = r0.getDecodeFps()
            double r7 = (double) r0
            r9 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0162
            int r0 = r11.cE
            if (r0 != r6) goto L_0x0182
        L_0x0162:
            r11.cE = r2
            r11.cD = r2
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r11.bC
            r0.sendEmptyMessage(r5)
            java.lang.String r0 = "reset rtsp---1"
            goto L_0x017f
        L_0x016e:
            int r0 = r11.cE
            if (r0 != r6) goto L_0x0182
            r11.cE = r2
            r11.cD = r2
            r11.cC = r2
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r11.bC
            r0.sendEmptyMessage(r5)
            java.lang.String r0 = "reset rtsp---2"
        L_0x017f:
            android.util.Log.i(r1, r0)
        L_0x0182:
            int r0 = r11.cD
            if (r0 != r6) goto L_0x0191
            com.xeagle.android.activities.FlightActionActivity r0 = r11.f12863ct
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$UTOge2JqxVTzlYJss6rzLe25KoI r1 = com.xeagle.android.vjoystick.$$Lambda$DroneControlFragment$UTOge2JqxVTzlYJss6rzLe25KoI.INSTANCE
            r0.runOnUiThread(r1)
            r11.cC = r2
            r11.cD = r2
        L_0x0191:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r11.bC
            java.lang.Runnable r1 = r11.f12888dt
            r0.removeCallbacks(r1)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r11.bC
            java.lang.Runnable r1 = r11.f12888dt
            r0.postDelayed(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.A():void");
    }

    private void B() {
        en.a aVar = this.bA;
        if (aVar == null || aVar.m() == null) {
            int[] iArr = new int[4];
            this.bW = iArr;
            Arrays.fill(iArr, 0);
        } else {
            this.bW = this.bA.m().a();
        }
        if (this.bB.aH()) {
            this.bC.post(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aT();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        this.W.post(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aS();
            }
        });
        this.bC.removeCallbacks(this.f12902l);
        this.bC.postDelayed(this.f12902l, 1000);
    }

    private void D() {
        if (this.bF == null) {
            this.bF = new ch.b(this.f12863ct);
        }
        this.f12914z.setAutoFullWithSize(true);
        a(System.currentTimeMillis());
        this.bC.sendEmptyMessage(150);
    }

    /* access modifiers changed from: private */
    public void E() {
        J();
        I();
    }

    private void F() {
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.f12861cr.setVisibility(8);
        if (this.bG) {
            JoyStickView joyStickView = this.B;
            if (joyStickView != null) {
                joyStickView.setVisibility(8);
            }
            JoyStickView joyStickView2 = this.C;
            if (joyStickView2 != null) {
                joyStickView2.setVisibility(8);
                return;
            }
            return;
        }
        JoyStickView joyStickView3 = this.B;
        if (joyStickView3 != null) {
            joyStickView3.setVisibility(8);
        }
        JoyStickView joyStickView4 = this.C;
        if (joyStickView4 != null) {
            joyStickView4.setVisibility(8);
        }
        this.f12843bz.b();
    }

    private void G() {
        this.f12861cr.setVisibility(0);
        if (this.bM) {
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            if (this.bA.d().c()) {
                this.F.setVisibility(8);
            }
        }
        if (this.bG) {
            JoyStickView joyStickView = this.B;
            if (joyStickView != null) {
                joyStickView.setVisibility(0);
            }
            JoyStickView joyStickView2 = this.C;
            if (joyStickView2 != null) {
                joyStickView2.setVisibility(0);
                return;
            }
            return;
        }
        JoyStickView joyStickView3 = this.B;
        if (joyStickView3 != null) {
            joyStickView3.setVisibility(0);
        }
        JoyStickView joyStickView4 = this.C;
        if (joyStickView4 != null) {
            joyStickView4.setVisibility(0);
        }
        this.f12843bz.a();
    }

    /* access modifiers changed from: private */
    public void H() {
        Runnable runnable;
        a aVar;
        a aVar2;
        a aVar3;
        boolean z2 = true;
        if (this.bA.E().a() != 1) {
            z2 = false;
        }
        this.bQ = z2;
        if (z2) {
            this.bC.post(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aL();
                }
            });
            if (!this.bG && (aVar3 = this.f12843bz) != null) {
                aVar3.b();
            }
            JoyStickView joyStickView = this.B;
            if (joyStickView != null && this.C != null) {
                joyStickView.setStickMoveListener((JoyStickView.b) null);
                this.C.setStickMoveListener((JoyStickView.b) null);
                return;
            }
            return;
        }
        JoyStickView joyStickView2 = this.B;
        if (joyStickView2 != null) {
            joyStickView2.setStickMoveListener(this.f12904n);
        }
        JoyStickView joyStickView3 = this.C;
        if (joyStickView3 != null) {
            joyStickView3.setStickMoveListener(this.f12905o);
        }
        if (this.bU.b()) {
            aVar = this.bC;
            runnable = new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aK();
                }
            };
        } else {
            aVar = this.bC;
            runnable = new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aJ();
                }
            };
        }
        aVar.post(runnable);
        if (!this.bG && (aVar2 = this.f12843bz) != null) {
            aVar2.a();
        }
    }

    private void I() {
        boolean h2 = this.bB.h();
        this.bO = h2;
        this.B.setLeftHand(h2);
        this.C.setLeftHand(this.bO);
    }

    private void J() {
        this.bN = this.bB.k();
    }

    private void K() {
        this.cX = true;
        this.bC.postDelayed(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aH();
            }
        }, 5000);
    }

    static /* synthetic */ int L(DroneControlFragment droneControlFragment) {
        int i2 = droneControlFragment.cT;
        droneControlFragment.cT = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void L() {
        if (this.f12540a.e() != null) {
            if (this.bB.q().startsWith("1.6.") || this.bB.q().startsWith("1.7.0")) {
                this.f12540a.e().a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_STRENGTH, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, "csw2200-l".getBytes());
            } else {
                this.f12540a.e().a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_STRENGTH, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, (byte[]) null);
            }
        }
        this.bC.removeCallbacks(this.f12894dz);
        this.bC.postDelayed(this.f12894dz, (long) this.cV);
    }

    private void M() {
        FlightActionActivity flightActionActivity = this.f12863ct;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aF();
                }
            });
        }
    }

    private void N() {
        this.M.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.cO.setOnClickListener(this);
        this.f12914z.setSurfaceOnTouch(this);
        this.bV.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.L.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void O() {
        if (this.bA.d().e().b().equalsIgnoreCase(ApmModes.ROTOR_TRACKER.b()) || this.cQ == 8) {
            this.bA.d().b(ApmModes.ROTOR_LOITER);
            this.bA.d().b(ApmModes.ROTOR_LOITER);
            org.greenrobot.eventbus.c.a().d(new jo.b("operateFragment"));
            Y();
        }
    }

    /* access modifiers changed from: private */
    public void P() {
        int i2 = this.f12864cu;
        if (i2 == 2) {
            this.f12863ct.runOnUiThread(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aE();
                }
            });
        } else if (i2 == 1) {
            this.cB = 4;
            this.bC.sendEmptyMessage(128);
            Log.i("rtsp", "reset rtsp---6");
        }
        this.bC.removeCallbacks(this.dB);
        this.bC.postDelayed(this.dB, 12000);
    }

    /* access modifiers changed from: private */
    public void Q() {
        a aVar = this.f12843bz;
        if (aVar != null) {
            aVar.a((a.C0152a) null);
            this.f12843bz.b();
        }
        if (this.bO) {
            this.aH.a(0, 1500.0d);
            this.aH.a(1, 1500.0d);
            if (this.C.getPoint() != null) {
                JoyStickView joyStickView = this.C;
                joyStickView.setmRockerBtn_X(joyStickView.getPoint().x);
                JoyStickView joyStickView2 = this.C;
                joyStickView2.setmRockerBtn_Y(joyStickView2.getPoint().y);
            }
            this.C.setStickMoveListener(this.f12905o);
            return;
        }
        this.aH.a(0, 1500.0d);
        this.aH.a(1, 1500.0d);
    }

    static /* synthetic */ int R(DroneControlFragment droneControlFragment) {
        int i2 = droneControlFragment.f12870da;
        droneControlFragment.f12870da = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void R() {
        a aVar = this.f12843bz;
        if (aVar != null) {
            aVar.a();
            this.f12843bz.a(this.f12906p);
        }
        if (this.bO) {
            this.aH.a(0, 1500.0d);
            this.aH.a(1, 1500.0d);
            if (this.C.getPoint() != null) {
                JoyStickView joyStickView = this.C;
                joyStickView.setmRockerBtn_X(joyStickView.getPoint().x);
                JoyStickView joyStickView2 = this.C;
                joyStickView2.setmRockerBtn_Y(joyStickView2.getPoint().y);
            }
            this.C.setStickMoveListener((JoyStickView.b) null);
            return;
        }
        this.aH.a(0, 1500.0d);
        this.aH.a(1, 1500.0d);
    }

    private void S() {
        this.f12875df.b();
        if (this.f12540a.f() != null) {
            this.f12540a.a((hb.a) null);
            this.f12540a.f().f11875b = false;
            this.f12540a.f().f11876c = false;
            this.f12540a.f().d(256);
            this.f12540a.f().a(554);
            this.f12540a.f().j();
            this.f12540a.f().m();
            Log.i(f12791y, "==> rtspClientConnected: 关闭RTST流");
        }
    }

    private void T() {
        ka.a.a().b().execute(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aw();
            }
        });
    }

    private void U() {
        int i2 = this.f12864cu;
        if (i2 == 1) {
            if (this.aP.getVisibility() == 8) {
                this.bC.sendEmptyMessage(IChannelListener.CMD_CHANNEL_ERROR_CONNECT);
            }
            if (this.f12542c != null) {
                this.f12542c.v();
            }
            this.D.setEnabled(false);
        } else if (i2 == 2 && this.f12543d != null) {
            this.f12543d.regRemoteTakePhoto(CameraGlobal.BASE_URL, 1, CameraGlobal.SET_REMOTE_TAKEPHOTO, 0);
        }
    }

    private void V() {
        int i2 = this.f12864cu;
        if (i2 == 1) {
            if (this.f12542c != null) {
                this.f12542c.w();
            }
        } else if (i2 == 2 && this.f12543d != null) {
            this.f12543d.regRemoteRecord(CameraGlobal.BASE_URL, 1, 1100, 1);
        }
    }

    private void W() {
        int i2 = this.f12864cu;
        if (i2 == 1) {
            if (this.f12542c != null) {
                this.f12542c.x();
            }
        } else if (i2 == 2 && this.f12543d != null) {
            this.f12543d.regRemoteRecord(CameraGlobal.BASE_URL, 1, 1100, 0);
        }
    }

    private void X() {
        if (f12789g) {
            if (this.bS) {
                this.bS = false;
            }
            if (!this.f12898h) {
                this.f12898h = true;
                V();
            }
        } else if (!this.f12899i) {
            Z();
        } else {
            aa();
            return;
        }
        this.bC.sendEmptyMessage(17);
    }

    /* access modifiers changed from: private */
    public void Y() {
        this.f12881dl = System.currentTimeMillis();
        if (this.f12899i) {
            aa();
        }
        if (f12789g && this.f12898h) {
            this.f12898h = false;
            W();
        }
        this.bC.sendEmptyMessage(19);
    }

    private void Z() {
        String str = "local_" + kw.c.a("yyyyMMddHHmmss", System.currentTimeMillis()) + ".mp4";
        this.dG = kx.d.r(this.f12863ct.getApplicationContext()) + str;
        this.dH = kx.d.q(this.f12863ct.getApplicationContext()) + str;
        if (this.f12540a.c()) {
            jv.d dVar = this.f12873dd;
            if (dVar != null) {
                dVar.a(this.dG);
            }
        } else {
            this.f12914z.startLocalRecord(this.dH);
        }
        this.f12899i = true;
        if (!f12789g) {
            this.bC.sendEmptyMessage(17);
        }
    }

    private void a(double d2, double d3) {
        JoyStickView joyStickView;
        if (this.bO && (joyStickView = this.C) != null) {
            joyStickView.setmRockerBtn_X((((float) (d3 / 9.8d)) * joyStickView.getR()) + this.C.getPoint().x);
            JoyStickView joyStickView2 = this.C;
            joyStickView2.setmRockerBtn_Y((((float) (d2 / 9.8d)) * joyStickView2.getR()) + this.C.getPoint().y);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r26, float r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            double r1 = (double) r1
            double[] r3 = r0.f12907q
            double r3 = com.xeagle.android.utils.c.a((double) r1, (double[]) r3)
            r5 = r27
            double r5 = (double) r5
            double[] r7 = r0.f12908r
            double r7 = com.xeagle.android.utils.c.a((double) r5, (double[]) r7)
            r25.J()
            boolean r9 = r0.bN
            r10 = 0
            r12 = 1500(0x5dc, float:2.102E-42)
            r13 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            r15 = 4611686018427387904(0x4000000000000000, double:2.0)
            r17 = 4621706527598287258(0x402399999999999a, double:9.8)
            r19 = -4613937818241073152(0xbff8000000000000, double:-1.5)
            r21 = 4654311885213007872(0x4097700000000000, double:1500.0)
            r23 = 4645744490609377280(0x4079000000000000, double:400.0)
            if (r9 != 0) goto L_0x0060
            int r9 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r9 < 0) goto L_0x0042
            int r9 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x0042
            int r1 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r1 < 0) goto L_0x0042
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            goto L_0x0070
        L_0x0042:
            double r1 = r3 / r17
            double r1 = r1 * r23
            double r5 = java.lang.Math.sqrt(r15)
            double r1 = r1 * r5
            double r1 = r1 + r21
            int r12 = (int) r1
            double r1 = r7 / r17
            double r1 = r1 * r23
            double r5 = java.lang.Math.sqrt(r15)
            double r1 = r1 * r5
            double r1 = r1 + r21
            int r1 = (int) r1
            r0.a((double) r3, (double) r7)
            goto L_0x0096
        L_0x0060:
            int r9 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r9 < 0) goto L_0x0076
            int r9 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x0076
            int r1 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r1 < 0) goto L_0x0076
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 > 0) goto L_0x0076
        L_0x0070:
            r0.a((double) r10, (double) r10)
            r1 = 1500(0x5dc, float:2.102E-42)
            goto L_0x0096
        L_0x0076:
            double r1 = -r3
            double r3 = r1 / r17
            double r3 = r3 * r23
            double r5 = java.lang.Math.sqrt(r15)
            double r3 = r3 * r5
            double r3 = r3 + r21
            int r12 = (int) r3
            double r3 = -r7
            double r5 = r3 / r17
            double r5 = r5 * r23
            double r7 = java.lang.Math.sqrt(r15)
            double r5 = r5 * r7
            double r5 = r5 + r21
            int r5 = (int) r5
            r0.a((double) r1, (double) r3)
            r1 = r5
        L_0x0096:
            double r2 = r0.bP
            double r4 = r2 * r23
            double r4 = r4 + r21
            int r4 = (int) r4
            double r2 = r2 * r23
            double r2 = r21 - r2
            int r2 = (int) r2
            en.a r3 = r0.bA
            if (r3 == 0) goto L_0x00df
            com.flypro.core.MAVLink.a$a r3 = r3.j()
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x00df
            r3 = 1
            if (r12 < r4) goto L_0x00ba
            com.flypro.core.drone.variables.ab r5 = r0.aH
            double r6 = (double) r4
        L_0x00b6:
            r5.a(r3, r6)
            goto L_0x00c6
        L_0x00ba:
            if (r12 <= r2) goto L_0x00c2
            if (r12 >= r4) goto L_0x00c2
            com.flypro.core.drone.variables.ab r5 = r0.aH
            double r6 = (double) r12
            goto L_0x00b6
        L_0x00c2:
            com.flypro.core.drone.variables.ab r5 = r0.aH
            double r6 = (double) r2
            goto L_0x00b6
        L_0x00c6:
            r3 = 0
            if (r1 < r4) goto L_0x00d0
            com.flypro.core.drone.variables.ab r1 = r0.aH
            double r4 = (double) r4
        L_0x00cc:
            r1.a(r3, r4)
            goto L_0x00df
        L_0x00d0:
            if (r1 <= r2) goto L_0x00db
            if (r1 >= r4) goto L_0x00db
            com.flypro.core.drone.variables.ab r2 = r0.aH
            double r4 = (double) r1
            r2.a(r3, r4)
            goto L_0x00df
        L_0x00db:
            com.flypro.core.drone.variables.ab r1 = r0.aH
            double r4 = (double) r2
            goto L_0x00cc
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.a(float, float):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(float f2, float f3, float f4) {
        a(f2, f3);
    }

    private void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        com.flypro.core.util.d.a("yyyy-MM-dd-HH:mm:ss", System.currentTimeMillis());
        if (this.bY) {
            this.bZ.add(new SonarData(f2, f3, f4, f5, f6, f7));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r3.sendEmptyMessage(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        android.util.Log.i("Error", r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r3, java.lang.Object r4) {
        /*
            r2 = this;
            java.lang.String r0 = "CmdChannel"
            java.lang.String r1 = "Error"
            switch(r3) {
                case 128: goto L_0x0022;
                case 129: goto L_0x0007;
                case 130: goto L_0x001c;
                case 131: goto L_0x0007;
                case 132: goto L_0x0016;
                case 133: goto L_0x0013;
                case 134: goto L_0x0010;
                case 135: goto L_0x0007;
                case 136: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x003d
        L_0x0008:
            com.xeagle.android.vjoystick.DroneControlFragment$a r3 = r2.bC
            r4 = 133(0x85, float:1.86E-43)
        L_0x000c:
            r3.sendEmptyMessage(r4)
            goto L_0x003d
        L_0x0010:
            java.lang.String r3 = "Cannot connect to the Camera. \nPlease make sure the selected camera is on. \nIf problem persists, please reboot both camera and this device."
            goto L_0x001e
        L_0x0013:
            java.lang.String r3 = "Cannot wakeup the Remote Camera"
            goto L_0x001e
        L_0x0016:
            java.lang.String r3 = "Lost connection with Remote Camera!"
            android.util.Log.i(r0, r3)
            goto L_0x003d
        L_0x001c:
            java.lang.String r3 = "Invalid bluetooth device"
        L_0x001e:
            android.util.Log.i(r1, r3)
            goto L_0x003d
        L_0x0022:
            java.lang.String r3 = "Timeout! No response from Remote Camera!---"
            android.util.Log.i(r0, r3)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r3 = "\"msg_id\":4"
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x0038
            com.xeagle.android.vjoystick.DroneControlFragment$a r3 = r2.bC
            r4 = 145(0x91, float:2.03E-43)
            r3.sendEmptyMessage(r4)
        L_0x0038:
            com.xeagle.android.vjoystick.DroneControlFragment$a r3 = r2.bC
            r4 = 131(0x83, float:1.84E-43)
            goto L_0x000c
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.a(int, java.lang.Object):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x057c, code lost:
        android.util.Log.i(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x07cf, code lost:
        r1.bC.sendEmptyMessage(257);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:530:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:545:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05a0  */
    /* JADX WARNING: Removed duplicated region for block: B:531:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r20, java.lang.Object r21, java.lang.String... r22) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = 80
            if (r0 < r3) goto L_0x000e
            r19.a((int) r20, (java.lang.Object) r21)
            return
        L_0x000e:
            r3 = 4
            if (r0 == r3) goto L_0x0a82
            r4 = 12
            java.lang.String r7 = "type"
            java.lang.String r9 = "rval"
            java.lang.String r11 = "CmdChannel"
            r12 = 8
            r13 = 2
            r14 = -1
            r15 = 0
            r5 = 1
            if (r0 == r4) goto L_0x097d
            r4 = 15
            if (r0 == r4) goto L_0x0971
            r6 = 18
            if (r0 == r6) goto L_0x0956
            r6 = 36
            if (r0 == r6) goto L_0x0944
            r6 = 40
            r17 = 9
            java.lang.String r8 = "_"
            r3 = 257(0x101, float:3.6E-43)
            r18 = 10
            if (r0 == r6) goto L_0x0699
            r6 = 51
            java.lang.String r10 = "param"
            if (r0 == r6) goto L_0x060e
            java.lang.String r6 = "off"
            switch(r0) {
                case 21: goto L_0x05b4;
                case 22: goto L_0x0581;
                case 23: goto L_0x04d3;
                default: goto L_0x0044;
            }
        L_0x0044:
            switch(r0) {
                case 54: goto L_0x04cc;
                case 55: goto L_0x0143;
                case 56: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            goto L_0x0a8a
        L_0x0049:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = "info"
            int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x0a7d }
            int r3 = r2 >> 8
            r4 = 65535(0xffff, float:9.1834E-41)
            r3 = r3 & r4
            r2 = r2 & 255(0xff, float:3.57E-43)
            r2 = r2 & r13
            int r2 = r2 >> r5
            java.lang.String r4 = "zoom"
            boolean r4 = r0.isNull(r4)     // Catch:{ JSONException -> 0x0a7d }
            if (r4 != 0) goto L_0x00b3
            java.lang.String r4 = "zoom"
            int r0 = r0.getInt(r4)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.VerticalSeekBar r4 = r1.f12821bd     // Catch:{ JSONException -> 0x0a7d }
            int r4 = r4.getProgress()     // Catch:{ JSONException -> 0x0a7d }
            int r6 = r0 / 8
            if (r4 == r6) goto L_0x00b3
            com.xeagle.android.vjoystick.VerticalSeekBar r4 = r1.f12821bd     // Catch:{ JSONException -> 0x0a7d }
            int r6 = r0 / 8
            r4.setProgress(r6)     // Catch:{ JSONException -> 0x0a7d }
            int r4 = r0 / 8
            if (r4 != 0) goto L_0x0097
            android.widget.TextView r0 = r1.f12820bc     // Catch:{ JSONException -> 0x0a7d }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r6 = "%.1f X"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ JSONException -> 0x0a7d }
            r8 = 0
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ JSONException -> 0x0a7d }
            r7[r15] = r8     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = java.lang.String.format(r4, r6, r7)     // Catch:{ JSONException -> 0x0a7d }
            r0.setText(r4)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x00b3
        L_0x0097:
            android.widget.TextView r4 = r1.f12820bc     // Catch:{ JSONException -> 0x0a7d }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r7 = "%.1f X"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ JSONException -> 0x0a7d }
            double r9 = (double) r0
            r11 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r11
            java.lang.Double r0 = java.lang.Double.valueOf(r9)     // Catch:{ JSONException -> 0x0a7d }
            r8[r15] = r0     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = java.lang.String.format(r6, r7, r8)     // Catch:{ JSONException -> 0x0a7d }
            r4.setText(r0)     // Catch:{ JSONException -> 0x0a7d }
        L_0x00b3:
            int r0 = r1.bK     // Catch:{ JSONException -> 0x0a7d }
            int r4 = r3 * 10
            if (r0 == r4) goto L_0x0106
            r1.bK = r4     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$ZFsSLjQyC3qA1OOWApPI1_3qhHE r4 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$ZFsSLjQyC3qA1OOWApPI1_3qhHE     // Catch:{ JSONException -> 0x0a7d }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0a7d }
            r0.runOnUiThread(r4)     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = f12789g     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x00da
            double r3 = (double) r3     // Catch:{ JSONException -> 0x0a7d }
            r6 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x00da
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r3 = 132(0x84, float:1.85E-43)
            r0.sendEmptyMessage(r3)     // Catch:{ JSONException -> 0x0a7d }
        L_0x00da:
            boolean r0 = r1.f12898h     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x00eb
            if (r2 != 0) goto L_0x00eb
            r1.f12898h = r15     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r2 = 19
            r0.sendEmptyMessage(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x00eb:
            if (r0 != 0) goto L_0x0a8a
            if (r2 != r5) goto L_0x0a8a
            r1.f12898h = r5     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r2 = 17
            r0.sendEmptyMessage(r2)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$94GpW_K7z_POKsasqhxhPabNvLE r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$94GpW_K7z_POKsasqhxhPabNvLE     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            r3 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0106:
            float r0 = (float) r4     // Catch:{ JSONException -> 0x0a7d }
            r2 = 1149239296(0x44800000, float:1024.0)
            float r0 = r0 / r2
            double r6 = (double) r0     // Catch:{ JSONException -> 0x0a7d }
            r8 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0136
            boolean r0 = f12789g     // Catch:{ JSONException -> 0x0a7d }
            if (r0 != 0) goto L_0x011a
            f12789g = r5     // Catch:{ JSONException -> 0x0a7d }
        L_0x011a:
            android.widget.TextView r0 = r1.f12818ba     // Catch:{ JSONException -> 0x0a7d }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "N/A"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0136
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$HQVI3zixSWX6y5N7eqEF46lW4kE r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$HQVI3zixSWX6y5N7eqEF46lW4kE     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0a7d }
            r0.runOnUiThread(r2)     // Catch:{ JSONException -> 0x0a7d }
        L_0x0136:
            if (r3 != 0) goto L_0x0a8a
            f12789g = r15     // Catch:{ JSONException -> 0x0a7d }
            android.widget.TextView r0 = r1.f12818ba     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "N/A"
            r0.setText(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0143:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            int r2 = r0.getInt(r9)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 >= 0) goto L_0x014e
            goto L_0x0a8a
        L_0x014e:
            java.lang.String r2 = r0.getString(r7)     // Catch:{ JSONException -> 0x0a7d }
            int r7 = r2.hashCode()     // Catch:{ JSONException -> 0x0a7d }
            switch(r7) {
                case -1809596527: goto L_0x01cb;
                case -381241383: goto L_0x01c0;
                case -262874663: goto L_0x01b5;
                case -105946049: goto L_0x01aa;
                case 72805: goto L_0x019f;
                case 128417863: goto L_0x0194;
                case 564274843: goto L_0x0189;
                case 1195741850: goto L_0x017e;
                case 1612033776: goto L_0x0173;
                case 1812923459: goto L_0x0167;
                case 2091387836: goto L_0x015b;
                default: goto L_0x0159;
            }     // Catch:{ JSONException -> 0x0a7d }
        L_0x0159:
            goto L_0x01d6
        L_0x015b:
            java.lang.String r7 = "video_timelapse"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 8
            goto L_0x01d8
        L_0x0167:
            java.lang.String r7 = "EV_Value"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 10
            goto L_0x01d8
        L_0x0173:
            java.lang.String r7 = "video_resolution"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 7
            goto L_0x01d8
        L_0x017e:
            java.lang.String r7 = "SecStream_resolution"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 1
            goto L_0x01d8
        L_0x0189:
            java.lang.String r7 = "SecStream_FPS"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 4
            goto L_0x01d8
        L_0x0194:
            java.lang.String r7 = "Vertical_Rec"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 3
            goto L_0x01d8
        L_0x019f:
            java.lang.String r7 = "ISO"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 9
            goto L_0x01d8
        L_0x01aa:
            java.lang.String r7 = "SecStream_BitRate"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 0
            goto L_0x01d8
        L_0x01b5:
            java.lang.String r7 = "Wifi_Channel"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 5
            goto L_0x01d8
        L_0x01c0:
            java.lang.String r7 = "Metering"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 2
            goto L_0x01d8
        L_0x01cb:
            java.lang.String r7 = "Wifi_ChanBW"
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x01d6
            r16 = 6
            goto L_0x01d8
        L_0x01d6:
            r16 = -1
        L_0x01d8:
            switch(r16) {
                case 0: goto L_0x046f;
                case 1: goto L_0x03f8;
                case 2: goto L_0x03e3;
                case 3: goto L_0x033a;
                case 4: goto L_0x02ff;
                case 5: goto L_0x024e;
                case 6: goto L_0x0243;
                case 7: goto L_0x022f;
                case 8: goto L_0x0205;
                case 9: goto L_0x01f1;
                case 10: goto L_0x01dd;
                default: goto L_0x01db;
            }     // Catch:{ JSONException -> 0x0a7d }
        L_0x01db:
            goto L_0x0a8a
        L_0x01dd:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            android.widget.TextView r2 = r1.aY     // Catch:{ JSONException -> 0x0a7d }
            r2.setText(r0)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.XEagleApp r2 = r1.f12540a     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.a r2 = r2.m()     // Catch:{ JSONException -> 0x0a7d }
            r2.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x01f1:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            android.widget.TextView r2 = r1.aX     // Catch:{ JSONException -> 0x0a7d }
            r2.setText(r0)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.XEagleApp r2 = r1.f12540a     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.a r2 = r2.m()     // Catch:{ JSONException -> 0x0a7d }
            r2.b((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0205:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "handleCmdChannelEvent:==time=== "
            r2.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r2.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r11, r2)     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r6.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0226
            r1.bJ = r15     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0228
        L_0x0226:
            r1.bJ = r5     // Catch:{ JSONException -> 0x0a7d }
        L_0x0228:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r0.sendEmptyMessage(r3)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x022f:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "3840x2160"
            boolean r0 = r0.contains(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x023f
            r1.dZ = r5     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x023f:
            r1.dZ = r15     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0243:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            r2.i((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x024e:
            java.lang.String r2 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = "CameraClient"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "handleCmdChannelEvent:==channel=== "
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r2)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r0, r3)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            r0.o((java.lang.String) r2)     // Catch:{ JSONException -> 0x0a7d }
            int r0 = r1.f12895ea     // Catch:{ JSONException -> 0x0a7d }
            if (r0 != r5) goto L_0x02bb
            r1.f12895ea = r14     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r0.t()     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = com.xeagle.android.utils.h.c((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x02bb
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x02b7 }
            int r0 = r0 - r5
            com.xeagle.android.activities.FlightActionActivity r3 = r1.f12863ct     // Catch:{ NumberFormatException -> 0x02b7 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NumberFormatException -> 0x02b7 }
            r4 = 2130903074(0x7f030022, float:1.7412956E38)
            java.lang.String[] r3 = r3.getStringArray(r4)     // Catch:{ NumberFormatException -> 0x02b7 }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ NumberFormatException -> 0x02b7 }
            java.lang.String r6 = "%s\n%s"
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ NumberFormatException -> 0x02b7 }
            com.xeagle.android.activities.FlightActionActivity r8 = r1.f12863ct     // Catch:{ NumberFormatException -> 0x02b7 }
            r9 = 2131821475(0x7f1103a3, float:1.9275694E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x02b7 }
            r7[r15] = r8     // Catch:{ NumberFormatException -> 0x02b7 }
            r0 = r3[r0]     // Catch:{ NumberFormatException -> 0x02b7 }
            r7[r5] = r0     // Catch:{ NumberFormatException -> 0x02b7 }
            java.lang.String r0 = java.lang.String.format(r4, r6, r7)     // Catch:{ NumberFormatException -> 0x02b7 }
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()     // Catch:{ NumberFormatException -> 0x02b7 }
            jo.d r4 = new jo.d     // Catch:{ NumberFormatException -> 0x02b7 }
            r4.<init>(r0)     // Catch:{ NumberFormatException -> 0x02b7 }
            r3.d(r4)     // Catch:{ NumberFormatException -> 0x02b7 }
            goto L_0x02bb
        L_0x02b7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x0a7d }
        L_0x02bb:
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r0.aH()     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$1I0eo3r0H8o8NdoduE9hUgSRe1s r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$1I0eo3r0H8o8NdoduE9hUgSRe1s     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0a7d }
            r0.runOnUiThread(r3)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r0.F()     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.activities.FlightActionActivity r3 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            r4 = 2131822395(0x7f11073b, float:1.927756E38)
            java.lang.String r3 = r3.getString(r4)     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 != 0) goto L_0x0a8a
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r0.F()     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 != 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = r2.F()     // Catch:{ JSONException -> 0x0a7d }
            r0.d(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x02ff:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "30fps"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0310
            r2 = 30
            r1.f12838bu = r2     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x031a
        L_0x0310:
            java.lang.String r2 = "15fps"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x031a
            r1.f12838bu = r4     // Catch:{ JSONException -> 0x0a7d }
        L_0x031a:
            int r2 = r1.f12833bp     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == r14) goto L_0x0320
            r1.f12833bp = r14     // Catch:{ JSONException -> 0x0a7d }
        L_0x0320:
            com.xeagle.android.vjoystick.DroneControlFragment$a r2 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r3 = 150(0x96, float:2.1E-43)
            r2.sendEmptyMessage(r3)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "UsbDataProxy1111"
            java.lang.String r3 = "rtspTearDownEvent: ====重连图像222"
            android.util.Log.i(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.activities.FlightActionActivity r2 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$bJlvY7wO46nAMcR1crXWffxDcSY r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$bJlvY7wO46nAMcR1crXWffxDcSY     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0a7d }
        L_0x0335:
            r2.runOnUiThread(r3)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x033a:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            boolean r2 = r0.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x034f
            r1.bM = r5     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r1.f12879dj     // Catch:{ JSONException -> 0x0a7d }
            r2.setVisibility(r12)     // Catch:{ JSONException -> 0x0a7d }
            r1.b((boolean) r15, (int) r13)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0371
        L_0x034f:
            r1.bM = r15     // Catch:{ JSONException -> 0x0a7d }
            com.blankj.utilcode.util.SPUtils r2 = com.blankj.utilcode.util.SPUtils.getInstance()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "is_ort"
            boolean r2 = r2.getBoolean(r3, r15)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0371
            int r2 = r1.cK     // Catch:{ JSONException -> 0x0a7d }
            boolean r2 = com.xeagle.android.utils.c.a((int) r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 != 0) goto L_0x036a
            r2 = 3
            r1.b((boolean) r5, (int) r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0371
        L_0x036a:
            boolean r0 = r1.bM     // Catch:{ JSONException -> 0x0a7d }
            r1.a((boolean) r0, (boolean) r5)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0371:
            int r2 = r1.f12835br     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == r14) goto L_0x0377
            r1.f12835br = r14     // Catch:{ JSONException -> 0x0a7d }
        L_0x0377:
            java.lang.String r2 = "post_check"
            java.lang.String r3 = r1.f12880dk     // Catch:{ JSONException -> 0x0a7d }
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x038d
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r2.s()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = f12791y     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "VERTICAL_REC startVF "
            android.util.Log.i(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
        L_0x038d:
            int r2 = r1.f12835br     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == r14) goto L_0x0393
            r1.f12835br = r14     // Catch:{ JSONException -> 0x0a7d }
        L_0x0393:
            r1.e((int) r5)     // Catch:{ JSONException -> 0x0a7d }
            r19.k()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = f12791y     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "VERTICAL_REC =====width:"
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            android.view.TextureView r4 = r1.A     // Catch:{ JSONException -> 0x0a7d }
            int r4 = r4.getMeasuredWidth()     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = " ,height"
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            android.view.TextureView r4 = r1.A     // Catch:{ JSONException -> 0x0a7d }
            int r4 = r4.getMeasuredHeight()     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "VERTICAL_REC =====rtsp:"
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = " ,isPortraitMode = "
            r3.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r1.bM     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r2, r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x03e3:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            boolean r2 = r2.aH()     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0a8a
            com.xeagle.android.activities.FlightActionActivity r2 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$kHFKlKWRDxjyR_8MsnlkuNr-_0A r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$kHFKlKWRDxjyR_8MsnlkuNr-_0A     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0335
        L_0x03f8:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = f12791y     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "handleCmdChannelEvent: ====get===resolution=="
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
            r1.cX = r15     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "1080P"
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r3 == 0) goto L_0x0425
            r3 = 1920(0x780, float:2.69E-42)
            r1.f12836bs = r3     // Catch:{ JSONException -> 0x0a7d }
            r3 = 1080(0x438, float:1.513E-42)
            r1.f12837bt = r3     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0446
        L_0x0425:
            java.lang.String r3 = "720P"
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r3 == 0) goto L_0x0436
            r3 = 1280(0x500, float:1.794E-42)
            r1.f12836bs = r3     // Catch:{ JSONException -> 0x0a7d }
            r3 = 720(0x2d0, float:1.009E-42)
            r1.f12837bt = r3     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0446
        L_0x0436:
            java.lang.String r3 = "WVGA"
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r3 == 0) goto L_0x0446
            r3 = 848(0x350, float:1.188E-42)
            r1.f12836bs = r3     // Catch:{ JSONException -> 0x0a7d }
            r3 = 480(0x1e0, float:6.73E-43)
            r1.f12837bt = r3     // Catch:{ JSONException -> 0x0a7d }
        L_0x0446:
            int r3 = r1.f12834bq     // Catch:{ JSONException -> 0x0a7d }
            if (r3 == r14) goto L_0x044c
            r1.f12834bq = r14     // Catch:{ JSONException -> 0x0a7d }
        L_0x044c:
            r19.k()     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.newUI.cameraManager.AmbaClient r3 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r3.n()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "resolution = "
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.d(r2, r3)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r1.f12831bn     // Catch:{ JSONException -> 0x0a7d }
            r2.setText(r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x046f:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "1M"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0485
            r1.Q = r5     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "1M"
        L_0x0481:
            r0.setText(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x04c8
        L_0x0485:
            java.lang.String r2 = "2M"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0494
            r1.Q = r13     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "2M"
            goto L_0x0481
        L_0x0494:
            java.lang.String r2 = "3M"
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x04a4
            r2 = 3
            r1.Q = r2     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "3M"
            goto L_0x0481
        L_0x04a4:
            java.lang.String r2 = "4M"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x04b4
            r2 = 4
            r1.Q = r2     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "4M"
            goto L_0x0481
        L_0x04b4:
            java.lang.String r2 = "0.5M"
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x04c3
            r1.Q = r15     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "0.5M"
            goto L_0x0481
        L_0x04c3:
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r1.M     // Catch:{ JSONException -> 0x0a7d }
            r2.setText(r0)     // Catch:{ JSONException -> 0x0a7d }
        L_0x04c8:
            r1.cX = r15     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x04cc:
            java.lang.String r0 = "handleResponse: ------new device requests to connect"
            android.util.Log.i(r11, r0)
            goto L_0x0a8a
        L_0x04d3:
            com.xeagle.android.XEagleApp r0 = r1.f12540a
            com.xeagle.android.a r0 = r0.m()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x04e0
            return
        L_0x04e0:
            r0 = r2
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r1.f12865cv = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "handleCmdChannelEvent:----new session--- "
            r0.append(r2)
            int r2 = r1.f12865cv
            r0.append(r2)
            java.lang.String r2 = "---ID--"
            r0.append(r2)
            int r2 = r1.cB
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r11, r0)
            int r0 = r1.cB
            if (r0 == r5) goto L_0x0571
            if (r0 == r13) goto L_0x0560
            r2 = 3
            if (r0 == r2) goto L_0x0559
            r6 = 4
            if (r0 == r6) goto L_0x0571
            r10 = 6
            if (r0 == r10) goto L_0x051a
            goto L_0x0a8a
        L_0x051a:
            com.xeagle.android.XEagleApp r0 = r1.f12540a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0523
            return
        L_0x0523:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            if (r0 == 0) goto L_0x0550
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            java.lang.String r0 = r0.t()
            com.xeagle.android.utils.prefs.a r2 = r1.bB
            java.lang.String r2 = r2.t()
            int r2 = r2.lastIndexOf(r8)
            int r2 = r2 + r5
            java.lang.String r0 = r0.substring(r2)
            int r0 = java.lang.Integer.parseInt(r0)
            r2 = 2020121101(0x78689a0d, float:1.8870897E34)
            if (r0 < r2) goto L_0x054b
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.y()
            goto L_0x0550
        L_0x054b:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.A()
        L_0x0550:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 150(0x96, float:2.1E-43)
        L_0x0554:
            r0.sendEmptyMessage(r2)
            goto L_0x0a8a
        L_0x0559:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r1.f12914z
            r0.onVideoResume()
            goto L_0x0a8a
        L_0x0560:
            com.xeagle.android.XEagleApp r0 = r1.f12540a
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0a8a
            long r2 = java.lang.System.currentTimeMillis()
            r1.a((long) r2)
            goto L_0x0a8a
        L_0x0571:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 128(0x80, float:1.794E-43)
            r0.sendEmptyMessage(r2)
            java.lang.String r0 = "rtsp"
            java.lang.String r2 = "reset rtsp---9"
        L_0x057c:
            android.util.Log.i(r0, r2)
            goto L_0x0a8a
        L_0x0581:
            int r0 = r1.f12834bq
            if (r0 != r5) goto L_0x058d
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            java.lang.String r2 = "1080P"
        L_0x0589:
            r0.f(r2)
            goto L_0x059c
        L_0x058d:
            if (r0 != r13) goto L_0x0594
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            java.lang.String r2 = "720P"
            goto L_0x0589
        L_0x0594:
            r7 = 3
            if (r0 != r7) goto L_0x059c
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            java.lang.String r2 = "WVGA"
            goto L_0x0589
        L_0x059c:
            int r0 = r1.f12835br
            if (r0 != r5) goto L_0x0a8a
            boolean r0 = r1.bM
            if (r0 == 0) goto L_0x05ad
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            java.lang.String r2 = "on"
            r0.e(r2)
            goto L_0x0a8a
        L_0x05ad:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.e(r6)
            goto L_0x0a8a
        L_0x05b4:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            int r2 = r0.getInt(r9)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 >= 0) goto L_0x05bf
            goto L_0x0a8a
        L_0x05bf:
            r1.f12898h = r5     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            int r2 = r2.E()     // Catch:{ JSONException -> 0x0a7d }
            if (r2 != r13) goto L_0x05d5
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            r2.h((int) r5)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.DroneControlFragment$a r2 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r3 = 116(0x74, float:1.63E-43)
            r2.sendEmptyMessage(r3)     // Catch:{ JSONException -> 0x0a7d }
        L_0x05d5:
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "handleCmdChannelEvent: --update time--"
            r2.append(r3)     // Catch:{ JSONException -> 0x0a7d }
            r2.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r11, r2)     // Catch:{ JSONException -> 0x0a7d }
            android.os.Message r2 = new android.os.Message     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            r3 = 117(0x75, float:1.64E-43)
            r2.what = r3     // Catch:{ JSONException -> 0x0a7d }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "recordTime"
            r3.putInt(r4, r0)     // Catch:{ JSONException -> 0x0a7d }
            r2.setData(r3)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r0.sendMessage(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x060e:
            java.lang.String r0 = "handleCmdChannelEvent:--- version  "
            android.util.Log.i(r11, r0)
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            int r2 = r0.getInt(r9)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 >= 0) goto L_0x0623
            java.lang.String r0 = "handleCmdChannelEvent: --get version failed."
            android.util.Log.i(r11, r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0623:
            java.lang.String r2 = r0.getString(r7)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "sw_version"
            boolean r3 = r3.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r3 == 0) goto L_0x0657
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            r2.g((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            boolean r2 = r1.dU     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x064a
            r1.dU = r15     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.activities.FlightActionActivity r2 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$AU4Rfn79lq_x2KrzDYdRxU0MbKc r3 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$AU4Rfn79lq_x2KrzDYdRxU0MbKc     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0a7d }
            r2.runOnUiThread(r3)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x064a:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "hw_version"
            r0.n(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0657:
            java.lang.String r3 = "hw_version"
            boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0a8a
            java.lang.String r0 = r0.getString(r10)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            r2.h((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            boolean r0 = r0.aH()     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.utils.prefs.a r0 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r0.t()     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.utils.prefs.a r2 = r1.bB     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = r2.t()     // Catch:{ JSONException -> 0x0a7d }
            int r2 = r2.lastIndexOf(r8)     // Catch:{ JSONException -> 0x0a7d }
            int r2 = r2 + r5
            java.lang.String r0 = r0.substring(r2)     // Catch:{ JSONException -> 0x0a7d }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ JSONException -> 0x0a7d }
            r2 = 20210105(0x13461b9, float:3.313089E-38)
            if (r0 < r2) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r0.j()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0699:
            r6 = 4
            r7 = 3
            r10 = 6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "handleCmdChannelEvent:---recordState---notification--- "
            r0.append(r9)
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r11, r0)
            r2.hashCode()
            int r0 = r2.hashCode()
            switch(r0) {
                case -1963280567: goto L_0x0779;
                case -1882985076: goto L_0x076d;
                case -1844221110: goto L_0x0761;
                case -1175864530: goto L_0x0755;
                case -778038150: goto L_0x0749;
                case -312225049: goto L_0x073d;
                case -245446050: goto L_0x0732;
                case -25537842: goto L_0x0727;
                case 741897753: goto L_0x071a;
                case 770047001: goto L_0x070d;
                case 998445241: goto L_0x0700;
                case 1383208497: goto L_0x06f3;
                case 1478514988: goto L_0x06e6;
                case 1587754437: goto L_0x06d9;
                case 1852333631: goto L_0x06cc;
                case 1922871777: goto L_0x06bf;
                default: goto L_0x06bc;
            }
        L_0x06bc:
            r0 = -1
            goto L_0x0784
        L_0x06bf:
            java.lang.String r0 = "memory_runout"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x06c8
            goto L_0x06bc
        L_0x06c8:
            r0 = 15
            goto L_0x0784
        L_0x06cc:
            java.lang.String r0 = "remote_video_key_stop"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x06d5
            goto L_0x06bc
        L_0x06d5:
            r0 = 14
            goto L_0x0784
        L_0x06d9:
            java.lang.String r0 = "remote_video_key_start"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x06e2
            goto L_0x06bc
        L_0x06e2:
            r0 = 13
            goto L_0x0784
        L_0x06e6:
            java.lang.String r0 = "stop_normal_record"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x06ef
            goto L_0x06bc
        L_0x06ef:
            r0 = 12
            goto L_0x0784
        L_0x06f3:
            java.lang.String r0 = "Card_Removed"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x06fc
            goto L_0x06bc
        L_0x06fc:
            r0 = 11
            goto L_0x0784
        L_0x0700:
            java.lang.String r0 = "card_nonoptim"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0709
            goto L_0x06bc
        L_0x0709:
            r0 = 10
            goto L_0x0784
        L_0x070d:
            java.lang.String r0 = "switch_to_photo"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0716
            goto L_0x06bc
        L_0x0716:
            r0 = 9
            goto L_0x0784
        L_0x071a:
            java.lang.String r0 = "remote_photo_key"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0723
            goto L_0x06bc
        L_0x0723:
            r0 = 8
            goto L_0x0784
        L_0x0727:
            java.lang.String r0 = "start_record"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0730
            goto L_0x06bc
        L_0x0730:
            r0 = 7
            goto L_0x0784
        L_0x0732:
            java.lang.String r0 = "card_full"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x073b
            goto L_0x06bc
        L_0x073b:
            r0 = 6
            goto L_0x0784
        L_0x073d:
            java.lang.String r0 = "Card_New_Insert"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0747
            goto L_0x06bc
        L_0x0747:
            r0 = 5
            goto L_0x0784
        L_0x0749:
            java.lang.String r0 = "take_photo"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0753
            goto L_0x06bc
        L_0x0753:
            r0 = 4
            goto L_0x0784
        L_0x0755:
            java.lang.String r0 = "stop_record"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x075f
            goto L_0x06bc
        L_0x075f:
            r0 = 3
            goto L_0x0784
        L_0x0761:
            java.lang.String r0 = "switch_to_record"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x076b
            goto L_0x06bc
        L_0x076b:
            r0 = 2
            goto L_0x0784
        L_0x076d:
            java.lang.String r0 = "start_normal_record"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0777
            goto L_0x06bc
        L_0x0777:
            r0 = 1
            goto L_0x0784
        L_0x0779:
            java.lang.String r0 = "CAMERA_VF_START_END"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0783
            goto L_0x06bc
        L_0x0783:
            r0 = 0
        L_0x0784:
            switch(r0) {
                case 0: goto L_0x0930;
                case 1: goto L_0x0906;
                case 2: goto L_0x0901;
                case 3: goto L_0x08c8;
                case 4: goto L_0x0879;
                case 5: goto L_0x0841;
                case 6: goto L_0x0830;
                case 7: goto L_0x0906;
                case 8: goto L_0x07dc;
                case 9: goto L_0x0901;
                case 10: goto L_0x07d6;
                case 11: goto L_0x07c8;
                case 12: goto L_0x08c8;
                case 13: goto L_0x07a2;
                case 14: goto L_0x08c8;
                case 15: goto L_0x0789;
                default: goto L_0x0787;
            }
        L_0x0787:
            goto L_0x0a8a
        L_0x0789:
            boolean r0 = r1.f12898h
            if (r0 == 0) goto L_0x0796
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            if (r0 == 0) goto L_0x0796
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.x()
        L_0x0796:
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$xK0o0a0GspDI05riMgYxWT9J5xM r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$xK0o0a0GspDI05riMgYxWT9J5xM
            r2.<init>()
            r0.runOnUiThread(r2)
            goto L_0x0a8a
        L_0x07a2:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x07a9
            r19.k()
        L_0x07a9:
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            int r0 = r0.E()
            if (r0 != r13) goto L_0x07bd
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            r0.h((int) r5)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 116(0x74, float:1.63E-43)
            r0.sendEmptyMessage(r2)
        L_0x07bd:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x07c3
            r1.f12898h = r5
        L_0x07c3:
            r19.X()
            goto L_0x0a8a
        L_0x07c8:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 118(0x76, float:1.65E-43)
            r0.sendEmptyMessage(r2)
        L_0x07cf:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r0.sendEmptyMessage(r3)
            goto L_0x0a8a
        L_0x07d6:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 137(0x89, float:1.92E-43)
            goto L_0x0554
        L_0x07dc:
            r1.dV = r5
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            int r0 = r0.E()
            if (r0 != r5) goto L_0x07fa
            boolean r0 = r1.f12899i
            if (r0 != 0) goto L_0x07fa
            boolean r0 = r1.f12898h
            if (r0 != 0) goto L_0x07fa
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            r0.h((int) r13)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 115(0x73, float:1.61E-43)
            r0.sendEmptyMessage(r2)
        L_0x07fa:
            boolean r0 = r1.f12899i
            if (r0 != 0) goto L_0x082a
            boolean r0 = r1.f12898h
            if (r0 == 0) goto L_0x0803
            goto L_0x082a
        L_0x0803:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x0820
            r1.bS = r5
            android.widget.ImageView r0 = r1.aP
            int r0 = r0.getVisibility()
            if (r0 != r12) goto L_0x0818
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 134(0x86, float:1.88E-43)
            r0.sendEmptyMessage(r2)
        L_0x0818:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 129(0x81, float:1.81E-43)
            r0.sendEmptyMessage(r2)
            goto L_0x0823
        L_0x0820:
            r19.T()
        L_0x0823:
            ch.b r0 = r1.bF
            r0.a()
            goto L_0x0a8a
        L_0x082a:
            java.lang.String r0 = "Camera"
            java.lang.String r2 = "handleCmdChannelEvent:---isSdRecord "
            goto L_0x057c
        L_0x0830:
            java.lang.String r0 = f12791y
            java.lang.String r2 = "handleCmdChannelEvent:====card full "
            android.util.Log.i(r0, r2)
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 132(0x84, float:1.85E-43)
            goto L_0x0554
        L_0x0841:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            if (r0 == 0) goto L_0x07cf
            f12789g = r5
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            java.lang.String r0 = r0.t()
            com.xeagle.android.utils.prefs.a r2 = r1.bB
            java.lang.String r2 = r2.t()
            int r2 = r2.lastIndexOf(r8)
            int r2 = r2 + r5
            java.lang.String r0 = r0.substring(r2)
            int r0 = java.lang.Integer.parseInt(r0)
            r2 = 2020121101(0x78689a0d, float:1.8870897E34)
            if (r0 < r2) goto L_0x086b
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.y()
            goto L_0x0870
        L_0x086b:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.A()
        L_0x0870:
            boolean r0 = r1.f12899i
            if (r0 == 0) goto L_0x07cf
            r19.Y()
            goto L_0x07cf
        L_0x0879:
            boolean r0 = r1.dV
            if (r0 == 0) goto L_0x0881
            r1.dV = r15
            goto L_0x0a8a
        L_0x0881:
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            int r0 = r0.E()
            if (r0 != r5) goto L_0x089d
            boolean r0 = r1.f12899i
            if (r0 != 0) goto L_0x089d
            boolean r0 = r1.f12898h
            if (r0 != 0) goto L_0x089d
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            r0.h((int) r13)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 115(0x73, float:1.61E-43)
            r0.sendEmptyMessage(r2)
        L_0x089d:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x08ba
            r1.bS = r5
            android.widget.ImageView r0 = r1.aP
            int r0 = r0.getVisibility()
            if (r0 != r12) goto L_0x08b2
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 134(0x86, float:1.88E-43)
            r0.sendEmptyMessage(r2)
        L_0x08b2:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 129(0x81, float:1.81E-43)
            r0.sendEmptyMessage(r2)
            goto L_0x08bd
        L_0x08ba:
            r19.T()
        L_0x08bd:
            ch.b r0 = r1.bF
            r0.a()
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 120(0x78, float:1.68E-43)
            goto L_0x0554
        L_0x08c8:
            long r2 = java.lang.System.currentTimeMillis()
            long r6 = r1.f12881dl
            long r2 = r2 - r6
            r6 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x08d6
            return
        L_0x08d6:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x08f6
            android.widget.ImageView r0 = r1.aP
            int r0 = r0.getVisibility()
            if (r0 != r12) goto L_0x08e9
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 146(0x92, float:2.05E-43)
            r0.sendEmptyMessage(r2)
        L_0x08e9:
            r1.f12898h = r15
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            if (r0 == 0) goto L_0x08f4
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.A()
        L_0x08f4:
            r1.bR = r5
        L_0x08f6:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x08fc
            r1.f12898h = r15
        L_0x08fc:
            r19.Y()
            goto L_0x0a8a
        L_0x0901:
            r19.ai()
            goto L_0x0a8a
        L_0x0906:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x090d
            r19.k()
        L_0x090d:
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            int r0 = r0.E()
            if (r0 != r13) goto L_0x0921
            com.xeagle.android.utils.prefs.a r0 = r1.bB
            r0.h((int) r5)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 116(0x74, float:1.63E-43)
            r0.sendEmptyMessage(r2)
        L_0x0921:
            boolean r0 = f12789g
            if (r0 == 0) goto L_0x0927
            r1.f12898h = r5
        L_0x0927:
            r19.X()
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC
            r2 = 17
            goto L_0x0554
        L_0x0930:
            int r0 = r1.f12834bq
            if (r0 == r14) goto L_0x0939
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.o()
        L_0x0939:
            int r0 = r1.f12833bp
            if (r0 == r14) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c
            r0.n()
            goto L_0x0a8a
        L_0x0944:
            r0 = r2
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x0950
            java.lang.String r0 = "Set_Attribute failed"
            goto L_0x0952
        L_0x0950:
            java.lang.String r0 = "Set_Attribute OK"
        L_0x0952:
            java.lang.String r2 = "Info"
            goto L_0x0a87
        L_0x0956:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            int r0 = r0.getInt(r9)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 >= 0) goto L_0x0968
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r2 = 145(0x91, float:2.03E-43)
            r0.sendEmptyMessage(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0968:
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r1.bC     // Catch:{ JSONException -> 0x0a7d }
            r2 = 144(0x90, float:2.02E-43)
            r0.sendEmptyMessage(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0971:
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct
            com.xeagle.android.vjoystick.DroneControlFragment$31 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$31
            r3.<init>(r2)
            r0.runOnUiThread(r3)
            goto L_0x0a8a
        L_0x097d:
            r0 = 3
            r6 = 4
            r10 = 6
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            int r3 = r2.getInt(r9)     // Catch:{ JSONException -> 0x0a7d }
            if (r3 >= 0) goto L_0x09a2
            java.lang.String r0 = r2.getString(r7)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = "handleCmdChannelEvent: ---set failed.=====type=== "
            r2.append(r3)     // Catch:{ JSONException -> 0x0a7d }
            r2.append(r0)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r11, r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x09a2:
            java.lang.String r2 = r2.getString(r7)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a7d }
            r3.<init>()     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r4 = "handleCmdChannelEvent:=======type--- "
            r3.append(r4)     // Catch:{ JSONException -> 0x0a7d }
            r3.append(r2)     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0a7d }
            android.util.Log.i(r11, r3)     // Catch:{ JSONException -> 0x0a7d }
            int r3 = r2.hashCode()     // Catch:{ JSONException -> 0x0a7d }
            switch(r3) {
                case -1809596527: goto L_0x0a13;
                case -1514642965: goto L_0x0a09;
                case -381241383: goto L_0x09ff;
                case -262874663: goto L_0x09f4;
                case -105946049: goto L_0x09ea;
                case 128417863: goto L_0x09e0;
                case 564274843: goto L_0x09d6;
                case 1195741850: goto L_0x09cc;
                case 1401172581: goto L_0x09c2;
                default: goto L_0x09c1;
            }     // Catch:{ JSONException -> 0x0a7d }
        L_0x09c1:
            goto L_0x0a1d
        L_0x09c2:
            java.lang.String r0 = "wifi_ssid"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 0
            goto L_0x0a1e
        L_0x09cc:
            java.lang.String r0 = "SecStream_resolution"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 2
            goto L_0x0a1e
        L_0x09d6:
            java.lang.String r0 = "SecStream_FPS"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 5
            goto L_0x0a1e
        L_0x09e0:
            java.lang.String r0 = "Vertical_Rec"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 4
            goto L_0x0a1e
        L_0x09ea:
            java.lang.String r0 = "SecStream_BitRate"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 1
            goto L_0x0a1e
        L_0x09f4:
            java.lang.String r0 = "Wifi_Channel"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 8
            goto L_0x0a1e
        L_0x09ff:
            java.lang.String r3 = "Metering"
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x0a7d }
            if (r2 == 0) goto L_0x0a1d
            r3 = 3
            goto L_0x0a1e
        L_0x0a09:
            java.lang.String r0 = "DigitalZoom"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 7
            goto L_0x0a1e
        L_0x0a13:
            java.lang.String r0 = "Wifi_ChanBW"
            boolean r0 = r2.equals(r0)     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a1d
            r3 = 6
            goto L_0x0a1e
        L_0x0a1d:
            r3 = -1
        L_0x0a1e:
            switch(r3) {
                case 0: goto L_0x0a72;
                case 1: goto L_0x0a68;
                case 2: goto L_0x0a5a;
                case 3: goto L_0x0a50;
                case 4: goto L_0x0a4a;
                case 5: goto L_0x0a40;
                case 6: goto L_0x0a36;
                case 7: goto L_0x0a21;
                case 8: goto L_0x0a23;
                default: goto L_0x0a21;
            }     // Catch:{ JSONException -> 0x0a7d }
        L_0x0a21:
            goto L_0x0a8a
        L_0x0a23:
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$23WSXzbia7Lew6D--q0aY-_L8o0 r2 = com.xeagle.android.vjoystick.$$Lambda$DroneControlFragment$23WSXzbia7Lew6Dq0aY_L8o0.INSTANCE     // Catch:{ JSONException -> 0x0a7d }
            r0.runOnUiThread(r2)     // Catch:{ JSONException -> 0x0a7d }
            r1.f12895ea = r5     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r0.k()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a36:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r0.j()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a40:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
        L_0x0a46:
            r0.s()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a4a:
            java.lang.String r0 = "post_check"
            r1.f((java.lang.String) r0)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a50:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r0.r()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a5a:
            java.lang.String r0 = f12791y     // Catch:{ JSONException -> 0x0a7d }
            java.lang.String r2 = "handleCmdChannelEvent: ==set===resolution==="
            android.util.Log.i(r0, r2)     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a46
        L_0x0a68:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            if (r0 == 0) goto L_0x0a8a
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12542c     // Catch:{ JSONException -> 0x0a7d }
            r0.p()     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a72:
            com.xeagle.android.activities.FlightActionActivity r0 = r1.f12863ct     // Catch:{ JSONException -> 0x0a7d }
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$CgP6EBG3QyIq6MeFOGRZL0TeG-s r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$CgP6EBG3QyIq6MeFOGRZL0TeG-s     // Catch:{ JSONException -> 0x0a7d }
            r2.<init>()     // Catch:{ JSONException -> 0x0a7d }
            r0.runOnUiThread(r2)     // Catch:{ JSONException -> 0x0a7d }
            goto L_0x0a8a
        L_0x0a7d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0a8a
        L_0x0a82:
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "Warning"
        L_0x0a87:
            android.util.Log.i(r2, r0)
        L_0x0a8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.a(int, java.lang.Object, java.lang.String[]):void");
    }

    private void a(long j2) {
        if (this.f12864cu == 1) {
            if (this.f12542c != null) {
                this.cB = 6;
                if (Integer.parseInt(this.bB.t().substring(this.bB.t().lastIndexOf("_") + 1)) >= 2020121101) {
                    this.f12542c.y();
                } else {
                    this.f12542c.A();
                }
                ka.a.a().b().execute(new Runnable() {
                    public final void run() {
                        DroneControlFragment.this.aO();
                    }
                });
            }
        } else if (this.f12543d != null) {
            this.f12543d.setCmdAndStr(CameraGlobal.BASE_URL, 1, CameraGlobal.SET_DATE, kw.c.a("yyyy-MM-dd", j2));
            this.f12543d.setCmdAndStr(CameraGlobal.BASE_URL, 1, CameraGlobal.SET_TIME, kw.c.a(TimeUtil.DEF_HH_MM_SS, j2));
            this.f12543d.getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
            this.f12863ct.runOnUiThread(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aN();
                }
            });
            SystemClock.sleep(500);
            this.f12543d.getCameraStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_DEVICE_INFO);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.cN.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void a(TextView textView) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(TextView textView, String str, boolean z2) {
        textView.setText(str);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, z2 ? R.drawable.check_pass : R.drawable.check_failed, 0);
    }

    private void a(msg_image_data msg_image_data) {
        if (this.bB.aH()) {
            this.bC.post(new Runnable(msg_image_data) {
                public final /* synthetic */ msg_image_data f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DroneControlFragment.this.b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IButton iButton, View view) {
        if (!iButton.getText().toString().equalsIgnoreCase("开始录制")) {
            com.xeagle.android.utils.c.f12769a = false;
            jv.d dVar = this.f12873dd;
            if (dVar != null) {
                dVar.q();
                this.f12873dd.p();
                iButton.setText("开始录制");
            }
        } else if (this.f12873dd != null) {
            String a2 = com.flypro.core.util.d.a("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis());
            jv.d dVar2 = this.f12873dd;
            dVar2.b(kx.d.n(this.f12863ct.getApplicationContext()) + a2 + ".h264");
            com.xeagle.android.utils.c.f12769a = true;
            com.xeagle.android.utils.c.e(kx.d.l(this.f12863ct.getApplicationContext()) + a2 + ".txt");
            jv.d dVar3 = this.f12873dd;
            dVar3.a(kx.d.n(this.f12863ct.getApplicationContext()) + a2 + ".mp4");
            iButton.setText("停止录制");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IButton iButton, Proxy.MsgType msgType, byte[] bArr) {
        if (msgType == Proxy.MsgType.RELAY_WIFI_STRENGTH) {
            String str = new String(bArr);
            iButton.post(new Runnable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    IButton.this.setText(this.f$1);
                }
            });
            if (this.bB.aH()) {
                this.f12823bf.post(new Runnable() {
                    public final void run() {
                        DroneControlFragment.this.aW();
                    }
                });
            }
            d(str);
            int indexOf = str.indexOf("@") + 1;
            int indexOf2 = str.indexOf("@", indexOf);
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf("@", i2);
            int parseInt = Integer.parseInt(str.substring(indexOf, indexOf2));
            int parseInt2 = Integer.parseInt(str.substring(i2, indexOf3));
            if (parseInt > parseInt2) {
                org.greenrobot.eventbus.c.a().d(new bc(Math.abs(parseInt)));
            } else {
                org.greenrobot.eventbus.c.a().d(new bc(Math.abs(parseInt2)));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Long l2) throws Exception {
        if (this.dG != null) {
            RxFFmpegCommandList rxFFmpegCommandList = new RxFFmpegCommandList();
            rxFFmpegCommandList.append("-i");
            rxFFmpegCommandList.append(this.dG);
            rxFFmpegCommandList.append("-strict");
            rxFFmpegCommandList.append("-2");
            rxFFmpegCommandList.append("-c:v");
            rxFFmpegCommandList.append("libx264");
            rxFFmpegCommandList.append("-crf");
            rxFFmpegCommandList.append("23");
            rxFFmpegCommandList.append("-vf");
            rxFFmpegCommandList.append(!this.bM ? "scale=1080:-1" : "scale=1920:-1");
            rxFFmpegCommandList.append("-threads");
            rxFFmpegCommandList.append("10");
            rxFFmpegCommandList.append("-preset");
            rxFFmpegCommandList.append("ultrafast");
            rxFFmpegCommandList.append(this.dH);
            rxFFmpegCommandList.append("-hide_banner");
            String str = f12791y;
            Log.i(str, "stopLocalRecord: ===ffmpeg cmd===" + rxFFmpegCommandList.toString());
            RxFFmpegInvoke.getInstance().runCommandRxJava(rxFFmpegCommandList.build()).a(new RxFFmpegSubscriber() {
                public void onCancel() {
                }

                public void onError(String str) {
                    String h2 = DroneControlFragment.f12791y;
                    Log.i(h2, "onError: ====stopLocalRecord====" + str);
                    if (DroneControlFragment.this.dI != null) {
                        DroneControlFragment.this.dI.a();
                        com.cfly.customeui.widget.a unused = DroneControlFragment.this.dI = null;
                    }
                }

                public void onFinish() {
                    Log.i(DroneControlFragment.f12791y, "onFinish: ====stopLocalRecord====");
                    File file = new File(DroneControlFragment.this.dG);
                    if (file.exists()) {
                        file.delete();
                    }
                    File file2 = new File(DroneControlFragment.this.dH);
                    if (file2.exists()) {
                        kx.c.b(DroneControlFragment.this.f12863ct.getApplicationContext(), file2);
                    }
                    if (DroneControlFragment.this.dI != null) {
                        DroneControlFragment.this.dI.a();
                        if (DroneControlFragment.this.dJ != null) {
                            ProgressBar unused = DroneControlFragment.this.dJ = null;
                        }
                        if (DroneControlFragment.this.dK != null) {
                            TextView unused2 = DroneControlFragment.this.dK = null;
                        }
                        com.cfly.customeui.widget.a unused3 = DroneControlFragment.this.dI = null;
                    }
                }

                public void onProgress(final int i2, long j2) {
                    String h2 = DroneControlFragment.f12791y;
                    Log.i(h2, "onProgress: ====stopLocalRecord===" + i2 + "==time===" + j2);
                    if (i2 < 0 || i2 >= 100 || DroneControlFragment.this.dI != null) {
                        if (DroneControlFragment.this.dJ != null) {
                            DroneControlFragment.this.dJ.setProgress(i2);
                        }
                        if (DroneControlFragment.this.dK != null) {
                            DroneControlFragment.this.dK.setText(String.format(Locale.US, "%d/100", new Object[]{Integer.valueOf(i2)}));
                            return;
                        }
                        return;
                    }
                    DroneControlFragment droneControlFragment = DroneControlFragment.this;
                    com.cfly.customeui.widget.a unused = droneControlFragment.dI = CommonUI.a((Context) droneControlFragment.f12863ct, DroneControlFragment.this.getView(), DroneControlFragment.this.f12863ct.getString(R.string.camera_stop_record), ScreenUtils.getScreenWidth() / 2, ScreenUtils.getScreenHeight() / 2, (CommonUI.f) new CommonUI.f() {
                        public void a(ProgressBar progressBar, TextView textView) {
                            ProgressBar unused = DroneControlFragment.this.dJ = progressBar;
                            TextView unused2 = DroneControlFragment.this.dK = textView;
                            DroneControlFragment.this.dJ.setMax(100);
                            DroneControlFragment.this.dJ.setProgress(i2);
                            DroneControlFragment.this.dK.setText(String.format(Locale.US, "%d/100", new Object[]{Integer.valueOf(i2)}));
                        }
                    });
                }
            });
        }
    }

    private void a(boolean z2) {
        a aVar;
        int i2;
        this.C.setIsRC(z2);
        this.B.setIsRC(z2);
        if (z2) {
            aVar = this.bC;
            i2 = 73;
        } else {
            aVar = this.bC;
            i2 = 80;
        }
        aVar.sendEmptyMessage(i2);
    }

    private void a(boolean z2, String str, TextView textView) {
        FlightActionActivity flightActionActivity = this.f12863ct;
        if (flightActionActivity != null) {
            flightActionActivity.runOnUiThread(new Runnable(textView, str, z2) {
                public final /* synthetic */ TextView f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ boolean f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    DroneControlFragment.a(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    private void a(boolean z2, boolean z3) {
        if (this.f12871db) {
            b(z2, z3);
        }
        b(z2, 1);
        this.cL = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void a(int[] iArr, int[] iArr2) {
        byte b2;
        if (this.cR) {
            String str = f12791y;
            Log.i(str, "==> onTrackerError mCurrentRect[0] =" + iArr[0] + " ,mCurrentRect[1] =" + iArr[1] + " ,mCurrentRect[2] =" + iArr[2] + " ,mCurrentRect[3] =" + iArr[3] + " ,mIsFollow = " + this.f12830bm);
            msg_image_data msg_image_data = new msg_image_data();
            if (iArr2 != null) {
                msg_image_data.f6846d = (short) (iArr[0] - iArr2[0]);
                msg_image_data.f6847e = (short) (iArr[1] - iArr2[1]);
            } else {
                msg_image_data.f6846d = 0;
                msg_image_data.f6847e = 0;
            }
            msg_image_data.f6848f = (short) (iArr[0] + (iArr[2] / 2));
            msg_image_data.f6849g = (short) (iArr[1] + (iArr[3] / 2));
            msg_image_data.f6851i = (short) this.A.getWidth();
            msg_image_data.f6852j = (short) this.A.getHeight();
            msg_image_data.f6853k = (short) iArr[2];
            msg_image_data.f6854l = (short) iArr[3];
            if (msg_image_data.f6848f < 0) {
                msg_image_data.f6848f = 0;
            } else if (msg_image_data.f6848f > this.A.getWidth()) {
                msg_image_data.f6848f = (short) this.A.getWidth();
            }
            if (msg_image_data.f6849g < 0) {
                msg_image_data.f6849g = 0;
            } else if (msg_image_data.f6849g > this.A.getHeight()) {
                msg_image_data.f6849g = (short) this.A.getHeight();
            }
            msg_image_data.f6856n = this.f12830bm ? Byte.parseByte("00000101", 2) : Byte.parseByte("00000011", 2);
            msg_image_data.f6857o = this.cQ == 8 ? Byte.parseByte("00000001", 2) : Byte.parseByte("00000010", 2);
            String str2 = this.cY;
            if (str2 != null && !str2.isEmpty()) {
                if (this.cY.contains("person")) {
                    b2 = Byte.parseByte("00000001", 2);
                } else if (this.cY.contains("car")) {
                    b2 = Byte.parseByte("00000010", 2);
                } else if (this.cY.contains("truck")) {
                    b2 = Byte.parseByte("00000011", 2);
                } else if (this.cY.contains("boat")) {
                    b2 = Byte.parseByte("00000100", 2);
                }
                msg_image_data.f6855m = b2;
                this.bA.j().a(msg_image_data.a());
                a(msg_image_data);
            }
            b2 = Byte.parseByte("01111111", 2);
            msg_image_data.f6855m = b2;
            this.bA.j().a(msg_image_data.a());
            a(msg_image_data);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aA() {
        this.f12857cn = false;
        this.f12803al.setClickable(true);
        if (this.bA.y() != null) {
            this.bA.P().f(this.bA.y().equalsIgnoreCase(this.bB.ax()));
            this.bA.P().g(this.bB.t().equalsIgnoreCase(this.bB.aA()));
            SystemClock.sleep(600);
            a(this.bA.P().f(), "SD检测：", this.f12804am);
            a(this.bA.P().k(), "Wifi检测：", this.f12805an);
            a(this.bA.P().g(), "飞控版本:", this.f12806ao);
            a(this.bA.P().j(), "中继版本：", this.f12807ap);
            a(this.bA.P().i(), "遥控版本:", this.f12808aq);
            a(this.bA.P().h(), "影像版本:", this.f12809ar);
            a(this.bA.P().a(), "气压检测:", this.f12810as);
            a(this.bA.P().c(), "陀螺仪检测:", this.f12811at);
            a(this.bA.P().b(), "磁罗盘检测:", this.f12812au);
            a(this.bA.P().d(), "水平检测:", this.f12813av);
            a(this.bA.P().e(), "GPS检测:", this.f12814aw);
            FlightActionActivity flightActionActivity = this.f12863ct;
            if (flightActionActivity != null) {
                flightActionActivity.runOnUiThread(new Runnable() {
                    public final void run() {
                        DroneControlFragment.this.aB();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aB() {
        String str;
        TextView textView;
        this.f12816ay.setVisibility(8);
        if (this.bA.P().l()) {
            this.f12815ax.setTextColor(-16711936);
            textView = this.f12815ax;
            str = "PASS!!!";
        } else {
            this.f12815ax.setTextColor(-65536);
            textView = this.f12815ax;
            str = "Failed!!!";
        }
        textView.setText(str);
        this.f12803al.setText("清除");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aC() {
        this.E.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aD() {
        this.D.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aE() {
        this.aO.setVisibility(0);
        this.f12914z.onVideoPause();
        this.cB = 4;
        this.bC.sendEmptyMessage(128);
        Log.i("rtsp", "reset rtsp---5");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aF() {
        this.f12804am.setText("");
        a(this.f12804am);
        this.f12805an.setText("");
        a(this.f12805an);
        this.f12806ao.setText("");
        a(this.f12806ao);
        this.f12807ap.setText("");
        a(this.f12807ap);
        this.f12808aq.setText("");
        a(this.f12808aq);
        this.f12809ar.setText("");
        a(this.f12809ar);
        this.f12810as.setText("");
        a(this.f12810as);
        this.f12811at.setText("");
        a(this.f12811at);
        this.f12812au.setText("");
        a(this.f12812au);
        this.f12813av.setText("");
        a(this.f12813av);
        this.f12814aw.setText("");
        a(this.f12814aw);
        this.f12815ax.setText("");
        a(this.f12815ax);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aG() {
        this.R.setVisibility(0);
        this.K.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aH() {
        if (this.cX) {
            this.cX = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aI() {
        if (this.bZ.size() > 0) {
            af();
            SystemClock.sleep(500);
            this.bZ.clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aJ() {
        JoyStickView joyStickView = this.B;
        if (joyStickView != null) {
            joyStickView.setVisibility(0);
        }
        JoyStickView joyStickView2 = this.C;
        if (joyStickView2 != null) {
            joyStickView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aK() {
        JoyStickView joyStickView = this.B;
        if (joyStickView != null) {
            joyStickView.setVisibility(8);
        }
        JoyStickView joyStickView2 = this.C;
        if (joyStickView2 != null) {
            joyStickView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aL() {
        JoyStickView joyStickView = this.B;
        if (joyStickView != null && this.C != null) {
            joyStickView.setVisibility(8);
            this.C.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aM() {
        if (this.f12540a.c()) {
            this.f12914z.setVisibility(8);
            this.A.setVisibility(0);
            return;
        }
        this.f12914z.setVisibility(0);
        this.A.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aN() {
        this.f12821bd.setVisibility(8);
        this.f12820bc.setVisibility(8);
        this.aR.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aO() {
        this.f12542c.c("video_resolution");
        SystemClock.sleep(50);
        this.f12542c.o();
        SystemClock.sleep(50);
        this.f12542c.p();
        SystemClock.sleep(50);
        this.f12542c.c("ISO");
        SystemClock.sleep(50);
        this.f12542c.c("EV_Value");
        SystemClock.sleep(50);
        this.f12542c.q();
        SystemClock.sleep(50);
        this.f12542c.r();
        this.f12863ct.runOnUiThread(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aR();
            }
        });
        if (Integer.parseInt(this.bB.t().substring(this.bB.t().lastIndexOf("_") + 1)) >= 2021032701 && this.bB.aH()) {
            this.f12542c.k();
        }
        if (Integer.parseInt(this.bB.t().substring(this.bB.t().lastIndexOf("_") + 1)) >= 2021040101) {
            this.f12863ct.runOnUiThread(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aQ();
                }
            });
            SystemClock.sleep(50);
            this.f12542c.l();
            return;
        }
        this.f12863ct.runOnUiThread(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aP();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aP() {
        this.f12821bd.setVisibility(8);
        this.f12820bc.setVisibility(8);
        this.aR.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aQ() {
        this.f12821bd.setVisibility(0);
        this.f12820bc.setVisibility(0);
        this.aR.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aR() {
        this.aX.setText(this.f12540a.m().j());
        this.aY.setText(this.f12540a.m().i());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aS() {
        int[] iArr = this.bW;
        this.f12890dv = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) / 4;
        TextView textView = this.W;
        textView.setText("平均：" + this.f12890dv);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aT() {
        this.bW = this.bA.m().a();
        ZJTextView zJTextView = this.S;
        zJTextView.setText("右前:" + this.bW[0]);
        ZJTextView zJTextView2 = this.T;
        zJTextView2.setText("左后:" + this.bW[1]);
        ZJTextView zJTextView3 = this.U;
        zJTextView3.setText("左前:" + this.bW[2]);
        ZJTextView zJTextView4 = this.V;
        zJTextView4.setText("右后:" + this.bW[3]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void aU() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aV() {
        com.flypro.core.drone.a aVar;
        this.f12859cp = "";
        this.f12858co = "";
        jt.a aVar2 = new jt.a();
        int i2 = 0;
        while (true) {
            if (("".equalsIgnoreCase(this.f12858co) || this.f12858co.isEmpty()) && i2 < 8) {
                aVar2.a("cat /etc/openwrt_build", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                this.f12858co = aVar2.a();
                i2++;
            }
        }
        int i3 = 0;
        while (true) {
            if (("".equalsIgnoreCase(this.f12859cp) || this.f12859cp.isEmpty()) && i3 < 8) {
                aVar2.a("cfly_msg c_version", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                this.f12859cp = aVar2.a();
                i3++;
            }
        }
        String str = this.f12858co;
        if (str == null || str.length() <= 6) {
            this.f12858co = "0";
        } else {
            this.f12858co = this.f12858co.substring(0, 6) + this.f12858co.substring(8, 14);
        }
        String str2 = this.f12859cp;
        if (str2 == null || str2.length() <= 6) {
            this.f12859cp = "0";
        } else {
            this.f12859cp = this.f12859cp.substring(0, 6) + this.f12859cp.substring(8, 16).replace(".", "");
        }
        boolean z2 = true;
        if (UserGlobal.DRONE_TYPE_DF805.equalsIgnoreCase(this.bB.ac()) || this.bA.E().a() != 1) {
            this.bA.P().h(true);
            aVar = this.bA.P();
        } else {
            this.bA.P().h(this.f12859cp.equalsIgnoreCase(this.bB.az()));
            aVar = this.bA.P();
            z2 = this.f12858co.equalsIgnoreCase(this.bB.ay());
        }
        aVar.i(z2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aW() {
        TextView textView = this.f12823bf;
        textView.setText("CPU占用率:" + com.xeagle.android.utils.a.a() + " ,Mem:" + com.xeagle.android.utils.a.c() + "=可用：" + com.xeagle.android.utils.a.a(this.f12863ct.getApplicationContext()));
    }

    /* access modifiers changed from: private */
    public void aa() {
        if (!this.f12540a.c()) {
            EmptyControlVideo emptyControlVideo = this.f12914z;
            if (!(emptyControlVideo == null || emptyControlVideo.isLocalRecording() == 0) || this.f12899i) {
                if (f12790x || this.f12914z != null) {
                    this.f12914z.stopLocalRecord();
                    this.f12899i = false;
                    this.bC.postDelayed(new Runnable() {
                        public void run() {
                            if (DroneControlFragment.this.dH != null) {
                                File file = new File(DroneControlFragment.this.dH);
                                if (file.exists()) {
                                    kx.c.b(DroneControlFragment.this.f12863ct.getApplicationContext(), file);
                                }
                            }
                        }
                    }, 500);
                } else {
                    throw new AssertionError();
                }
            }
        } else if (this.f12899i) {
            jv.d dVar = this.f12873dd;
            if (dVar != null) {
                dVar.p();
            }
            this.f12899i = false;
            ab();
        }
        if (!f12789g) {
            this.bC.sendEmptyMessage(19);
        }
    }

    private void ab() {
        f.a(500, TimeUnit.MILLISECONDS).b(lz.a.b()).a(lu.a.a()).a(new lv.d() {
            public final void accept(Object obj) {
                DroneControlFragment.this.a((Long) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public void ac() {
        if (this.f12914z.getDecodeFps() > 0.0f) {
            this.f12914z.getCurrentFrame(kx.d.g(this.f12863ct.getApplicationContext()));
        }
        this.bC.removeCallbacks(this.f12909s);
        this.bC.postDelayed(this.f12909s, 500);
    }

    private void ad() {
        startActivity(new Intent(getContext(), CflyGalleryActivity.class));
    }

    private void ae() {
        org.greenrobot.eventbus.c.a().d(new g(this.bA.H() == null ? i.f27244a : this.bA.H().a()));
    }

    private void af() {
        ea.f.a(this.f12863ct.getApplicationContext(), this.bZ, com.flypro.core.util.d.a("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()));
    }

    private void ag() {
        if (this.bA.d().c()) {
            com.flypro.core.MAVLink.d.a(this.bA);
            if (this.bA.b().a()) {
                this.bB.o(true);
                this.bB.a((float) this.bA.b().b().d());
                this.bB.b((float) this.bA.b().b().c());
            } else {
                this.bB.o(false);
            }
            if (this.F.getVisibility() == 0) {
                this.F.post(new Runnable() {
                    public final void run() {
                        DroneControlFragment.this.av();
                    }
                });
                return;
            }
            return;
        }
        com.cfly.customeui.widget.a aVar = this.cH;
        if (aVar != null) {
            aVar.a();
            this.cH = null;
        }
        this.f12540a.m().k(false);
        if (this.F.getVisibility() == 8) {
            this.F.post(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.au();
                }
            });
        }
        this.f12540a.i().b(this.f12863ct.getString(R.string.gps_not_locked));
        if (this.bZ.size() > 0) {
            af();
            this.bZ.clear();
        }
        Runnable runnable = this.f12902l;
        if (runnable != null) {
            this.bC.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void ah() {
        this.cG--;
        c cVar = this.aL;
        if (cVar != null) {
            cVar.a(-65536);
            this.aL.b(String.format(this.f12863ct.getString(R.string.channel_switch_success), new Object[]{Integer.valueOf(this.cG)}));
        }
        if (this.cG == 0) {
            System.exit(0);
        }
        this.bC.removeCallbacks(this.f12910t);
        this.bC.postDelayed(this.f12910t, 1000);
    }

    private void ai() {
        com.xeagle.android.utils.prefs.a aVar;
        int i2 = 2;
        if (this.bB.E() == 2) {
            this.bS = false;
            this.bC.sendEmptyMessage(116);
            aVar = this.bB;
            i2 = 1;
        } else {
            this.bC.sendEmptyMessage(115);
            aVar = this.bB;
        }
        aVar.h(i2);
    }

    /* access modifiers changed from: private */
    public void aj() {
        this.aE += 1.0d;
        this.aC.post(new Runnable() {
            public final void run() {
                DroneControlFragment.this.am();
            }
        });
        this.bC.postDelayed(this.f12912v, 333);
    }

    /* access modifiers changed from: private */
    public void ak() {
        this.aE -= 1.0d;
        this.aC.post(new Runnable() {
            public final void run() {
                DroneControlFragment.this.al();
            }
        });
        this.bC.postDelayed(this.f12913w, 333);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void al() {
        TextView textView = this.aC;
        textView.setText(this.aE + "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void am() {
        TextView textView = this.aC;
        textView.setText(this.aE + "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void an() {
        this.aI.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ao() {
        if (this.f12542c != null) {
            this.f12542c.u();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ap() {
        if (this.dY == null) {
            this.dY = com.xeagle.android.dialogs.r.a().a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.sd_speed_warnning), (c.a) new c.a() {
                public void onYes() {
                }
            });
        }
        if (!this.dY.isAdded()) {
            this.dY.show(getChildFragmentManager(), "sdError");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ar() {
        FlightActionActivity flightActionActivity = this.f12863ct;
        Toast.makeText(flightActionActivity, flightActionActivity.getString(R.string.scan_pair_success), 0).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void as() {
        ToastHelper.showCenterToastShort(this.f12863ct, R.layout.toast_fly_sport_warn);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void at() {
        String str;
        dz.a aVar;
        com.flypro.core.MAVLink.b.a(this.bA, (byte) 99);
        this.f12540a.n().e(this.bB.t());
        SystemClock.sleep(100);
        com.flypro.core.MAVLink.d.a(this.bA);
        SystemClock.sleep(100);
        if (this.bA.y() != null && !this.f12540a.c()) {
            String y2 = this.bA.y();
            int i2 = (Double.parseDouble(y2.substring(y2.indexOf("v") + 1, y2.indexOf("v") + 4)) > 2.9d ? 1 : (Double.parseDouble(y2.substring(y2.indexOf("v") + 1, y2.indexOf("v") + 4)) == 2.9d ? 0 : -1));
            HashMap<String, Boolean> hashMap = this.cM;
            if (i2 >= 0) {
                hashMap.put("CONTROL_WPNAV_LOIT_SPD", true);
                aVar = this.bA.e();
                str = "WPNAV_LOIT_SPD";
            } else {
                hashMap.put("CONTROL_PILOT_VELZ_MAX", true);
                aVar = this.bA.e();
                str = "PILOT_VELZ_MAX";
            }
            aVar.a(str);
        }
        if (!this.bA.d().d()) {
            this.cM.put("CONTROL_INAV_TC_KP", true);
            this.bA.e().a("INAV_TC_KP");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void au() {
        this.F.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void av() {
        this.F.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aw() {
        Surface surface;
        int i2;
        int i3;
        final String str = kx.d.s(this.f12863ct.getApplicationContext()) + ("local_" + kw.c.a("yyyyMMddHHmmss", System.currentTimeMillis()) + ".jpg");
        if (Build.VERSION.SDK_INT >= 24) {
            if (this.f12540a.c()) {
                i3 = this.A.getHeight();
                i2 = this.A.getWidth();
                surface = this.f12874de;
            } else {
                EmptyControlVideo emptyControlVideo = this.f12914z;
                if (emptyControlVideo != null && emptyControlVideo.getmSurface() != null && this.f12914z.getmSurface().isValid()) {
                    i2 = this.f12914z.getWidth();
                    i3 = this.f12914z.getHeight();
                    surface = this.f12914z.getmSurface();
                } else {
                    return;
                }
            }
            final Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            PixelCopy.request(surface, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() {
                public void onPixelCopyFinished(int i2) {
                    int i3;
                    if (i2 == 0) {
                        com.xeagle.android.utils.c.a(str, createBitmap);
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    Message message = new Message();
                    message.what = 153;
                    message.arg1 = i3;
                    DroneControlFragment.this.bC.sendMessage(message);
                }
            }, this.bC);
        } else if (!this.f12540a.c()) {
            int currentFrame = this.f12914z.getCurrentFrame(str);
            Message message = new Message();
            message.what = 153;
            message.arg1 = currentFrame;
            this.bC.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ax() {
        this.aB.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ay() {
        TextView textView = this.aC;
        textView.setText(this.aE + "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void az() {
        TextView textView = this.aC;
        textView.setText(this.aE + "");
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        Log.i("viewChange", "viewChange: " + i2);
        FlightActionActivity flightActionActivity = this.f12863ct;
        if (flightActionActivity == null) {
            return;
        }
        if (flightActionActivity.f()) {
            G();
        } else {
            F();
        }
    }

    private void b(View view) {
        this.K = (ConstraintLayout) view.findViewById(R.id.sonar_cl);
        this.R = (RelativeLayout) view.findViewById(R.id.debug_rl);
        if (this.bB.aH()) {
            this.W = (TextView) view.findViewById(R.id.channel_in);
            this.Z = (ZJTextView) view.findViewById(R.id.attitude_info);
            this.f12792aa = (ZJTextView) view.findViewById(R.id.vib_txt_x);
            this.f12793ab = (ZJTextView) view.findViewById(R.id.vib_txt_y);
            this.f12794ac = (ZJTextView) view.findViewById(R.id.vib_txt_z);
            this.S = (ZJTextView) view.findViewById(R.id.servo1);
            this.T = (ZJTextView) view.findViewById(R.id.servo2);
            this.U = (ZJTextView) view.findViewById(R.id.servo3);
            this.V = (ZJTextView) view.findViewById(R.id.servo4);
            this.f12795ad = (TextView) view.findViewById(R.id.bat_alt);
            this.f12796ae = (TextView) view.findViewById(R.id.bat_vel);
            this.f12797af = (TextView) view.findViewById(R.id.bat_dest);
            this.f12798ag = (TextView) view.findViewById(R.id.bat_status);
            this.f12799ah = (TextView) view.findViewById(R.id.sonar_alt);
            this.f12800ai = (TextView) view.findViewById(R.id.sonar_vel);
            this.f12801aj = (TextView) view.findViewById(R.id.sonar_dest);
            this.f12802ak = (TextView) view.findViewById(R.id.sonar_offset);
            this.X = (ZJTextView) view.findViewById(R.id.bat_vol);
            this.Y = (ZJTextView) view.findViewById(R.id.gps_drone);
            c(view);
            M();
            this.bC.post(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aG();
                }
            });
            return;
        }
        this.R.setVisibility(8);
        this.K.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(msg_image_data msg_image_data) {
        this.f12822be.setText("vel_x = " + msg_image_data.f6846d + "\n" + "vel_y = " + msg_image_data.f6847e + "\n" + "offset_x = " + msg_image_data.f6848f + "\n" + "offset_y = " + msg_image_data.f6849g + "\n" + "resolution_x = " + msg_image_data.f6851i + "\n" + "resolution_y = " + msg_image_data.f6852j + "\n" + "factor = " + msg_image_data.f6850h + "\n" + "mode = " + msg_image_data.f6856n + "\n" + "type = " + msg_image_data.f6857o + "\n" + "target_type = " + msg_image_data.f6855m + "\n");
    }

    private void b(en.a aVar) {
        f(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Long l2) throws Exception {
        if (this.f12540a.c() && !this.f12871db) {
            ProgressBar progressBar = this.aO;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            if (this.f12899i) {
                aa();
            }
        }
        if (this.f12871db) {
            this.f12871db = false;
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!this.f12540a.c() && this.f12914z != null) {
            Bitmap a2 = com.xeagle.android.utils.c.a(kx.d.g(this.f12863ct.getApplicationContext()), this.f12914z.getMeasuredWidth(), this.f12914z.getMeasuredHeight());
            this.cP = a2;
            this.aP.setImageBitmap(a2);
            if (this.aP.getVisibility() == 8) {
                this.aP.setVisibility(0);
            }
            if (this.aQ.getVisibility() == 8) {
                this.aQ.setVisibility(0);
            }
            this.aQ.setText(str);
        }
    }

    private void b(boolean z2) {
        if (this.bI != z2) {
            this.bI = z2;
        }
    }

    private void b(boolean z2, int i2) {
        if (z2) {
            this.f12863ct.a(true);
            this.I.setVisibility(8);
            this.f12821bd.setVisibility(8);
        } else if (this.f12863ct.f12359h) {
            this.f12863ct.a(false);
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
            this.f12863ct.b();
        }
        com.xeagle.android.dialogs.ab abVar = this.bD;
        if (abVar != null && abVar.isAdded()) {
            this.bD.dismiss();
        }
    }

    private void b(boolean z2, boolean z3) {
        if (this.f12542c != null) {
            this.f12835br = 1;
            this.bM = z2;
            if (z3) {
                Log.i(f12791y, "handleCmdChannelEvent:====vertical rec======stop vf ");
                this.f12542c.t();
                j();
                return;
            }
            e(2);
        }
    }

    static /* synthetic */ int bh(DroneControlFragment droneControlFragment) {
        int i2 = droneControlFragment.f12866cw;
        droneControlFragment.f12866cw = i2 + 1;
        return i2;
    }

    private void c(int i2) {
        this.cH = CommonUI.a((Context) this.f12863ct, getView(), this.f12863ct.getString(R.string.low_land_warn_title), Integer.valueOf(R.string.not_cancel_land), this.f12863ct.getString(R.string.cancel_rtl_warn), i2, (CommonUI.b) new CommonUI.b() {
            public void a() {
                DroneControlFragment.this.bA.Q().e(DroneControlFragment.this.f12863ct.getString(R.string.action_confirm_low_land));
                DroneControlFragment.this.f12540a.m().k(true);
                com.flypro.core.MAVLink.b.a(DroneControlFragment.this.bA, (byte) 68);
                if (DroneControlFragment.this.cH != null) {
                    DroneControlFragment.this.cH.a();
                    com.cfly.customeui.widget.a unused = DroneControlFragment.this.cH = null;
                }
            }
        });
    }

    private void c(View view) {
        this.f12803al = (IButton) view.findViewById(R.id.start_check);
        this.f12804am = (TextView) view.findViewById(R.id.check_sd);
        this.f12805an = (TextView) view.findViewById(R.id.check_wifi);
        this.f12806ao = (TextView) view.findViewById(R.id.check_drone);
        this.f12807ap = (TextView) view.findViewById(R.id.check_repeater);
        this.f12808aq = (TextView) view.findViewById(R.id.check_rc);
        this.f12809ar = (TextView) view.findViewById(R.id.check_img);
        this.f12810as = (TextView) view.findViewById(R.id.check_pressure);
        this.f12811at = (TextView) view.findViewById(R.id.check_gyro);
        this.f12812au = (TextView) view.findViewById(R.id.check_mag);
        this.f12813av = (TextView) view.findViewById(R.id.check_attitude);
        this.f12814aw = (TextView) view.findViewById(R.id.check_gps);
        this.f12815ax = (TextView) view.findViewById(R.id.check_result);
        this.f12816ay = (ProgressBar) view.findViewById(R.id.pb_check);
        this.aB = (ProgressBar) view.findViewById(R.id.pb_connect);
        this.f12817az = (TextView) view.findViewById(R.id.wifi_rssi_value);
        Button button = (Button) view.findViewById(R.id.gimb_down);
        Button button2 = (Button) view.findViewById(R.id.gimb_up);
        this.aC = (TextView) view.findViewById(R.id.gimb_txt);
        this.aD = (IButton) view.findViewById(R.id.start_connect);
        this.aA = (TextView) view.findViewById(R.id.cur_wifi_name);
        this.aV = (IButton) view.findViewById(R.id.gimbal_cal_ib);
        this.f12839bv = (IButton) view.findViewById(R.id.ib_metering);
        this.f12840bw = this.f12863ct.getResources().getStringArray(R.array.action_metering_value);
        l();
        this.f12839bv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DroneControlFragment.this.d(view);
            }
        });
        ((IButton) view.findViewById(R.id.ib_start_check)).setOnClickListener(this);
        this.aV.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        ((IButton) view.findViewById(R.id.gimb_send)).setOnClickListener(this);
        this.aD.setOnClickListener(this);
        button2.setOnLongClickListener(this);
        button2.setOnTouchListener(this);
        button.setOnLongClickListener(this);
        button.setOnTouchListener(this);
        this.f12803al.setOnClickListener(this);
    }

    private void c(en.a aVar) {
        org.greenrobot.eventbus.c.a().d(new jo.a(aVar.u().b(), aVar.u().a(), aVar.u().c()));
        if (this.bB.aH()) {
            this.bC.post(new Runnable(aVar) {
                public final /* synthetic */ en.a f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DroneControlFragment.this.l(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Long l2) throws Exception {
        f("home_check");
    }

    private void c(String str) {
        c a2 = com.xeagle.android.dialogs.r.a().a(this.f12863ct.getString(R.string.warning), str, (c.a) new c.a() {
            public void onYes() {
            }
        });
        if (a2 != null) {
            a2.show(getChildFragmentManager(), "sdcard");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(boolean z2) {
        ConstraintLayout constraintLayout;
        int i2;
        if (z2) {
            constraintLayout = this.J;
            i2 = 0;
        } else {
            constraintLayout = this.J;
            i2 = 8;
        }
        constraintLayout.setVisibility(i2);
    }

    private void d(int i2) {
        this.cH = CommonUI.a((Context) this.f12863ct, getView(), this.f12863ct.getString(R.string.low_rtl_title), this.f12863ct.getString(R.string.cancel_rtl_warn), (long) i2, (CommonUI.c) new CommonUI.c() {
            public void a() {
                DroneControlFragment.this.f12540a.m().k(true);
                DroneControlFragment.this.bA.Q().e(DroneControlFragment.this.f12863ct.getString(R.string.action_cancel_low_rtl));
                com.flypro.core.MAVLink.b.a(DroneControlFragment.this.bA, (byte) 67);
                if (DroneControlFragment.this.cH != null) {
                    com.cfly.customeui.widget.a unused = DroneControlFragment.this.cH = null;
                }
            }

            public void a(Object... objArr) {
                if (objArr[0] != null && (objArr[0] instanceof TextView)) {
                    objArr[0].setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.warning_first, 0, 0, 0);
                }
            }

            public void b() {
                DroneControlFragment.this.f12540a.m().k(true);
                DroneControlFragment.this.bA.Q().e(DroneControlFragment.this.f12863ct.getString(R.string.action_confirm_low_rtl));
                com.flypro.core.MAVLink.b.a(DroneControlFragment.this.bA, (byte) 68);
                if (DroneControlFragment.this.cH != null) {
                    com.cfly.customeui.widget.a unused = DroneControlFragment.this.cH = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        lj.b bVar = this.f12841bx;
        if (bVar != null) {
            if (bVar.isShowing()) {
                this.f12841bx.dismiss();
                return;
            }
            this.f12841bx.a(this.f12863ct.getApplicationContext(), this.f12839bv.getText().toString());
            this.f12841bx.showAsDropDown(this.f12839bv, 48, 0, 0);
        }
    }

    private void d(en.a aVar) {
        if (this.bB.aH()) {
            this.bC.post(new Runnable(aVar) {
                public final /* synthetic */ en.a f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DroneControlFragment.this.k(this.f$1);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0179, code lost:
        if (r0.f12542c != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r0.f12542c != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d2, code lost:
        if (r0.f12542c != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x012d, code lost:
        if (r0.f12542c != null) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "MCS"
            boolean r2 = r1.contains(r2)
            r3 = 1
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = "S"
            int r2 = r1.indexOf(r2)
            int r2 = r2 + r3
            java.lang.String r4 = "@"
            int r4 = r1.indexOf(r4)
            java.lang.String r1 = r1.substring(r2, r4)
            double r1 = java.lang.Double.parseDouble(r1)
            double[] r4 = r0.cI
            double r1 = com.xeagle.android.utils.c.a((double) r1, (double[]) r4)
        L_0x0028:
            r0.dA = r1
            goto L_0x0044
        L_0x002b:
            java.lang.String r2 = "CCK"
            boolean r2 = r1.contains(r2)
            if (r2 != 0) goto L_0x003b
            java.lang.String r2 = "OFDM"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x0044
        L_0x003b:
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double[] r4 = r0.cI
            double r1 = com.xeagle.android.utils.c.a((double) r1, (double[]) r4)
            goto L_0x0028
        L_0x0044:
            double r1 = r0.dA
            r4 = 4
            r5 = 1280(0x500, float:1.794E-42)
            r6 = 5000(0x1388, float:7.006E-42)
            r7 = 256(0x100, double:1.265E-321)
            r9 = 1
            r11 = 4617315517961601024(0x4014000000000000, double:5.0)
            r13 = 0
            r15 = 2
            int r16 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r16 <= 0) goto L_0x00a1
            double r1 = r0.cW
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x0061
            r0.cU = r13
            goto L_0x0066
        L_0x0061:
            long r1 = r0.cU
            long r1 = r1 + r9
            r0.cU = r1
        L_0x0066:
            int r1 = r0.Q
            if (r1 != r4) goto L_0x0085
            boolean r1 = r0.f12898h
            if (r1 != 0) goto L_0x009a
            int r1 = r0.f12836bs
            if (r1 == r5) goto L_0x009a
            boolean r1 = r0.cX
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
        L_0x007a:
            r20.K()
            r0.f12834bq = r15
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.t()
            goto L_0x009a
        L_0x0085:
            if (r1 >= r4) goto L_0x009a
            long r1 = r0.cU
            int r3 = r0.cV
            int r6 = r6 / r3
            long r3 = (long) r6
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x009a
            r0.cU = r13
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "4M"
        L_0x0097:
            r1.g(r2)
        L_0x009a:
            long r1 = r0.cU
            long r1 = r1 % r7
            r0.cU = r1
            goto L_0x01a0
        L_0x00a1:
            r16 = 2000(0x7d0, float:2.803E-42)
            r17 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r19 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x00ff
            int r19 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r19 > 0) goto L_0x00ff
            double r1 = r0.cW
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x00bd
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x00bd
            long r1 = r0.cU
            long r1 = r1 + r9
            r0.cU = r1
            goto L_0x00bf
        L_0x00bd:
            r0.cU = r13
        L_0x00bf:
            int r1 = r0.Q
            r2 = 3
            if (r1 != r2) goto L_0x00d5
            boolean r1 = r0.f12898h
            if (r1 != 0) goto L_0x009a
            int r1 = r0.f12836bs
            if (r1 == r5) goto L_0x009a
            boolean r1 = r0.cX
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x007a
        L_0x00d5:
            java.lang.String r3 = "3M"
            if (r1 != r4) goto L_0x00ee
            long r1 = r0.cU
            int r4 = r0.cV
            int r4 = r16 / r4
            long r4 = (long) r4
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
        L_0x00e8:
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.g(r3)
            goto L_0x009a
        L_0x00ee:
            if (r1 >= r2) goto L_0x009a
            long r1 = r0.cU
            int r4 = r0.cV
            int r6 = r6 / r4
            long r4 = (long) r6
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x00e8
        L_0x00ff:
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x0155
            int r4 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r4 > 0) goto L_0x0155
            double r1 = r0.cW
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0119
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x0119
            long r1 = r0.cU
            long r1 = r1 + r9
            r0.cU = r1
            goto L_0x011b
        L_0x0119:
            r0.cU = r13
        L_0x011b:
            int r1 = r0.Q
            if (r1 != r15) goto L_0x0131
            boolean r1 = r0.f12898h
            if (r1 != 0) goto L_0x009a
            int r1 = r0.f12836bs
            if (r1 == r5) goto L_0x009a
            boolean r1 = r0.cX
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x007a
        L_0x0131:
            java.lang.String r2 = "2M"
            long r3 = r0.cU
            if (r1 <= r15) goto L_0x0145
            int r1 = r0.cV
            int r1 = r16 / r1
            long r5 = (long) r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x0151
        L_0x0145:
            int r1 = r0.cV
            int r6 = r6 / r1
            long r5 = (long) r6
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
        L_0x0151:
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            goto L_0x0097
        L_0x0155:
            int r4 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x01a0
            double r1 = r0.cW
            int r4 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x0165
            long r1 = r0.cU
            long r1 = r1 + r9
            r0.cU = r1
            goto L_0x0167
        L_0x0165:
            r0.cU = r13
        L_0x0167:
            int r1 = r0.Q
            if (r1 != r3) goto L_0x017d
            boolean r1 = r0.f12898h
            if (r1 != 0) goto L_0x009a
            int r1 = r0.f12836bs
            if (r1 == r5) goto L_0x009a
            boolean r1 = r0.cX
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x007a
        L_0x017d:
            java.lang.String r2 = "1M"
            if (r1 >= r3) goto L_0x0190
            long r3 = r0.cU
            int r1 = r0.cV
            int r6 = r6 / r1
            long r5 = (long) r6
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
            goto L_0x019f
        L_0x0190:
            long r3 = r0.cU
            int r1 = r0.cV
            int r1 = r16 / r1
            long r5 = (long) r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x009a
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x009a
        L_0x019f:
            goto L_0x0151
        L_0x01a0:
            double r1 = r0.dA
            r0.cW = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.d(java.lang.String):void");
    }

    private void e(int i2) {
        int requestedOrientation = this.f12863ct.getRequestedOrientation();
        String str = f12791y;
        Log.i(str, "==> current orientation = " + requestedOrientation + " change = " + this.cK + "====flag==" + i2);
        int i3 = this.cK;
        if (requestedOrientation != i3) {
            this.f12863ct.setRequestedOrientation(i3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        int i2;
        if (this.f12832bo.getText().toString().equalsIgnoreCase("30fps")) {
            if (this.f12542c != null) {
                i2 = 1;
            } else {
                return;
            }
        } else if (this.f12542c != null) {
            i2 = 2;
        } else {
            return;
        }
        this.f12833bp = i2;
        this.f12542c.t();
    }

    /* access modifiers changed from: private */
    public void e(en.a aVar) {
        this.bC.post(new Runnable(aVar) {
            public final /* synthetic */ en.a f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DroneControlFragment.this.j(this.f$1);
            }
        });
    }

    private void e(String str) {
        c a2 = com.xeagle.android.dialogs.r.a().a(getString(R.string.warning), str, (c.a) new c.a() {
            public void onYes() {
            }
        });
        if (a2 != null) {
            a2.show(getChildFragmentManager(), "show");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(int i2) {
        this.f12818ba.setText(String.format(Locale.US, "%.1fGB", new Object[]{Float.valueOf(((float) (i2 * 10)) / 1024.0f)}));
        f12789g = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        int i2;
        if (this.f12831bn.getText().toString().equalsIgnoreCase("1080P")) {
            if (this.f12542c != null) {
                i2 = 2;
            } else {
                return;
            }
        } else if (this.f12831bn.getText().toString().equalsIgnoreCase("720P")) {
            if (this.f12542c != null) {
                i2 = 3;
            } else {
                return;
            }
        } else if (this.f12542c != null) {
            i2 = 1;
        } else {
            return;
        }
        this.f12834bq = i2;
        this.f12542c.t();
    }

    private void f(en.a aVar) {
        ab abVar;
        double d2;
        String b2 = aVar.d().e().b();
        b2.hashCode();
        char c2 = 65535;
        switch (b2.hashCode()) {
            case -2013398213:
                if (b2.equals("Loiter")) {
                    c2 = 0;
                    break;
                }
                break;
            case -592836561:
                if (b2.equals("Stabilize")) {
                    c2 = 1;
                    break;
                }
                break;
            case 81482:
                if (b2.equals("RTL")) {
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
            case 2018617584:
                if (b2.equals("Circle")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2032461078:
                if (b2.equals("Alt Hold")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                abVar = this.aH;
                d2 = 1400.0d;
                break;
            case 1:
                if (!this.bH) {
                    abVar = this.aH;
                    d2 = 1250.0d;
                    break;
                } else {
                    abVar = this.aH;
                    d2 = 1420.0d;
                    break;
                }
            case 2:
                this.aH.a(2, 1500.0d);
                abVar = this.aH;
                d2 = 1900.0d;
                break;
            case 3:
                this.aH.a(2, 1500.0d);
                abVar = this.aH;
                d2 = 1680.0d;
                break;
            case 4:
                this.aH.a(4, 1520.0d);
                return;
            case 5:
                abVar = this.aH;
                d2 = 1300.0d;
                break;
            default:
                return;
        }
        abVar.a(4, d2);
        b(false);
    }

    private void f(String str) {
        Log.i(f12791y, "getCameraState: ========");
        if (this.f12540a.c()) {
            this.f12880dk = str;
            if (this.f12542c != null) {
                this.f12542c.m();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(int i2) {
        if (i2 == 0) {
            f12789g = false;
            this.f12818ba.setText("N/A");
            return;
        }
        f12789g = true;
        this.f12818ba.setText(String.format(Locale.US, "%.1fGB", new Object[]{Float.valueOf(((float) (i2 * 10)) / 1024.0f)}));
    }

    private void g(en.a aVar) {
        this.f12846cc = aVar.I().a();
        this.f12847cd = aVar.I().b();
        this.f12848ce = aVar.I().c();
        this.f12849cf = aVar.I().d();
        this.f12850cg = aVar.I().e();
        this.f12851ch = aVar.I().f();
        this.f12852ci = aVar.I().g();
        this.f12853cj = aVar.I().h();
        this.f12854ck = aVar.I().i();
        if (!this.f12540a.m().g()) {
            return;
        }
        if (this.f12846cc != 0 || this.f12847cd != 0 || this.f12848ce != 0) {
            this.f12540a.m().h(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(String str) {
        this.N.setText(String.format(Locale.US, "Wifi信道：%s", new Object[]{str}));
    }

    private void h(en.a aVar) {
        this.f12856cm = aVar.d() != null ? aVar.d().e().b() : "UNKNOWN";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        this.f12832bo.setText(str);
    }

    /* access modifiers changed from: private */
    public void i() {
        Log.i(f12791y, "==> 创建RTSP流");
        this.f12875df.b();
        XEagleApp.d().a(this.f12900j);
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (XEagleApp.d().f() != null) {
                    XEagleApp.d().f().b(2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void i(en.a aVar) {
        B();
        ag();
        e(aVar);
        ae();
        h(aVar);
        a(aVar);
        g(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(String str) {
        int i2;
        String str2 = "center";
        if (str.equalsIgnoreCase(str2)) {
            i2 = 1;
        } else {
            str2 = "multi";
            if (str.equalsIgnoreCase(str2)) {
                i2 = 2;
            } else {
                str2 = "spot";
                if (str.equalsIgnoreCase(str2)) {
                    i2 = 3;
                } else {
                    str2 = "fly";
                    if (str.equalsIgnoreCase(str2)) {
                        i2 = 4;
                    } else {
                        return;
                    }
                }
            }
        }
        this.f12842by = i2;
        this.f12839bv.setText(str2);
    }

    private void j() {
        jv.d dVar = this.f12873dd;
        if (dVar != null) {
            dVar.d(false);
            this.f12873dd.interrupt();
            this.f12873dd = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        if (r12.Q != 2) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        if (r12.Q != 1) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void j(en.a r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0124
            com.flypro.core.drone.variables.j r0 = r13.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0124
            com.flypro.core.drone.variables.j r0 = r13.b()
            ef.a r0 = r0.b()
            r12.f12844ca = r0
            com.flypro.core.util.a r0 = com.flypro.core.util.a.a()
            double r0 = r0.c()
            r12.f12860cq = r0
            boolean r0 = com.xeagle.android.utils.h.a((en.a) r13)
            if (r0 == 0) goto L_0x013b
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            boolean r0 = r0.aH()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L_0x0056
            com.xeagle.android.widgets.ZJTextView r0 = r12.Y
            java.lang.Object[] r4 = new java.lang.Object[r2]
            ef.a r5 = r12.f12844ca
            double r5 = r5.d()
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r4[r1] = r5
            ef.a r5 = r12.f12844ca
            double r5 = r5.c()
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r4[r3] = r5
            java.lang.String r5 = "lat:%s\t\tlng:%s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            r0.setText(r4)
        L_0x0056:
            int r0 = r12.f12864cu
            if (r0 != r3) goto L_0x00e2
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            if (r0 == 0) goto L_0x00e2
            com.xeagle.android.XEagleApp r0 = r12.f12540a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0068
            goto L_0x00e2
        L_0x0068:
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            java.lang.String r0 = r0.t()
            java.lang.String r4 = "vC"
            boolean r0 = r0.contains(r4)
            java.lang.String r4 = "1M"
            java.lang.String r5 = "2M"
            if (r0 != 0) goto L_0x00a9
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            java.lang.String r0 = r0.t()
            java.lang.String r6 = "vA1.0.1_2021092801"
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0089
            goto L_0x00a9
        L_0x0089:
            double r6 = r12.f12860cq
            r8 = 4648488871632306176(0x4082c00000000000, double:600.0)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a0
            int r0 = r12.Q
            if (r0 == r3) goto L_0x00a0
        L_0x0098:
            r12.Q = r3
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            r0.g(r4)
            goto L_0x00e2
        L_0x00a0:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e2
            int r0 = r12.Q
            if (r0 == r2) goto L_0x00e2
            goto L_0x00be
        L_0x00a9:
            double r6 = r12.f12860cq
            r8 = 4656510908468559872(0x409f400000000000, double:2000.0)
            r10 = 4650248090236747776(0x4089000000000000, double:800.0)
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c6
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x00c6
            int r0 = r12.Q
            if (r0 == r2) goto L_0x00c6
        L_0x00be:
            r12.Q = r2
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            r0.g(r5)
            goto L_0x00e2
        L_0x00c6:
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x00d9
            int r0 = r12.Q
            r2 = 4
            if (r0 == r2) goto L_0x00d9
            r12.Q = r2
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            java.lang.String r2 = "4M"
            r0.g(r2)
            goto L_0x00e2
        L_0x00d9:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e2
            int r0 = r12.Q
            if (r0 == r3) goto L_0x00e2
            goto L_0x0098
        L_0x00e2:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r3]
            double r3 = r12.f12860cq
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            r2[r1] = r3
            java.lang.String r1 = "D: %.1f"
            java.lang.String r0 = java.lang.String.format(r0, r1, r2)
            com.flypro.core.drone.variables.j r1 = r13.b()
            int r1 = r1.d()
            r2 = 6
            if (r1 > r2) goto L_0x010e
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            jo.p r1 = new jo.p
            java.lang.String r2 = "D: 0.0"
            r1.<init>(r2)
            r0.d(r1)
            goto L_0x011a
        L_0x010e:
            org.greenrobot.eventbus.c r1 = org.greenrobot.eventbus.c.a()
            jo.p r2 = new jo.p
            r2.<init>(r0)
            r1.d(r2)
        L_0x011a:
            com.flypro.core.drone.variables.j r13 = r13.b()
            double r0 = r12.f12860cq
            r13.a((double) r0)
            goto L_0x013b
        L_0x0124:
            org.greenrobot.eventbus.c r13 = org.greenrobot.eventbus.c.a()
            jo.p r0 = new jo.p
            java.lang.String r1 = "D: N/A"
            r0.<init>(r1)
            r13.d(r0)
            ef.a r13 = new ef.a
            r0 = 0
            r13.<init>(r0, r0)
            r12.f12844ca = r13
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.j(en.a):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(final String str) {
        if (this.aM == null) {
            this.aM = d.a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.channel_switch_content), new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    AmbaClient ambaClient;
                    String str = str;
                    if (Integer.parseInt(str.substring(str.lastIndexOf("_") + 1)) >= 2021032701) {
                        String str2 = "149";
                        if (str2.equals(DroneControlFragment.this.bB.H())) {
                            if (DroneControlFragment.this.f12542c != null) {
                                ambaClient = DroneControlFragment.this.f12542c;
                                str2 = "161";
                            } else {
                                return;
                            }
                        } else if (DroneControlFragment.this.f12542c != null) {
                            ambaClient = DroneControlFragment.this.f12542c;
                        } else {
                            return;
                        }
                        ambaClient.d(str2);
                        DroneControlFragment.this.bB.o(str2);
                        return;
                    }
                    com.flypro.core.MAVLink.b.a(DroneControlFragment.this.bA, (byte) 66);
                    if (DroneControlFragment.this.aL == null) {
                        c unused = DroneControlFragment.this.aL = com.xeagle.android.dialogs.r.a().a(DroneControlFragment.this.f12863ct.getString(R.string.warning), String.format(DroneControlFragment.this.f12863ct.getString(R.string.channel_switch_success), new Object[]{5}), (c.a) new c.a() {
                            public void onYes() {
                            }
                        });
                    }
                    DroneControlFragment.this.ah();
                    DroneControlFragment.this.aL.show(DroneControlFragment.this.getChildFragmentManager(), "channel");
                }
            });
        }
        if (!this.aM.isAdded()) {
            this.aM.show(getChildFragmentManager(), "channel");
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        this.f12875df.b();
        jv.d dVar = this.f12873dd;
        if (dVar != null) {
            dVar.d(false);
            this.f12873dd.interrupt();
            this.f12873dd = null;
        }
        SystemClock.sleep(200);
        if (this.f12873dd == null) {
            jv.d dVar2 = new jv.d(this.f12874de, "video/avc", this.f12836bs, this.f12837bt, this.f12838bu, this.bM, this.f12875df);
            this.f12873dd = dVar2;
            dVar2.d(true);
            this.f12873dd.start();
        }
        String str = f12791y;
        Log.d(str, "preWidth = " + this.f12836bs + " preHeight = " + this.f12837bt + " preFps = " + this.f12838bu);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(en.a aVar) {
        float a2 = aVar.O().a();
        float b2 = aVar.O().b();
        float c2 = aVar.O().c();
        if (a2 < 5.0f && a2 >= 0.0f) {
            this.f12792aa.setTextColor(-16711936);
        } else if (a2 < 5.0f || a2 >= 10.0f) {
            this.f12792aa.setTextColor(-65536);
        } else {
            this.f12792aa.setTextColor(-256);
        }
        if (b2 < 5.0f && b2 >= 0.0f) {
            this.f12793ab.setTextColor(-16711936);
        } else if (b2 < 5.0f || b2 >= 10.0f) {
            this.f12793ab.setTextColor(-65536);
        } else {
            this.f12793ab.setTextColor(-256);
        }
        if (c2 < 8.0f && c2 >= 0.0f) {
            this.f12794ac.setTextColor(-16711936);
        } else if (c2 < 8.0f || c2 >= 15.0f) {
            this.f12794ac.setTextColor(-65536);
        } else {
            this.f12794ac.setTextColor(-256);
        }
        this.f12792aa.setText(String.format(Locale.US, "vib_x:%.2f", new Object[]{Float.valueOf(aVar.O().a())}));
        this.f12793ab.setText(String.format(Locale.US, "vib_y:%.2f", new Object[]{Float.valueOf(aVar.O().b())}));
        this.f12794ac.setText(String.format(Locale.US, "vib_z:%.2f", new Object[]{Float.valueOf(aVar.O().c())}));
    }

    private void l() {
        if (this.f12841bx == null) {
            this.f12841bx = new lj.b(this.f12863ct, new b.a() {
                public void a(int i2) {
                    if (DroneControlFragment.this.f12542c != null) {
                        DroneControlFragment.this.f12542c.i(DroneControlFragment.this.f12840bw[i2]);
                    }
                    DroneControlFragment.this.f12841bx.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(en.a aVar) {
        this.Z.setText(String.format(Locale.US, "pitch:%.2f\nroll:%.2f\nyaw:%.2f", new Object[]{Double.valueOf(aVar.u().b()), Double.valueOf(aVar.u().a()), Double.valueOf(aVar.u().c())}));
    }

    private void m() {
        this.cJ = new OrientationEventListener(this.f12863ct) {
            public void onOrientationChanged(int i2) {
                if (!DroneControlFragment.this.f12898h && !DroneControlFragment.this.f12899i && DroneControlFragment.this.cQ != 9 && i2 != -1) {
                    if (i2 > 350 || i2 < 10) {
                        if (DroneControlFragment.this.f12863ct.f12359h) {
                            DroneControlFragment.this.f12863ct.e();
                            DroneControlFragment.this.n();
                            return;
                        }
                        ToastUtils.showShort((int) R.string.can_not_portrait);
                    } else if (i2 <= 80 || i2 >= 100) {
                        if ((i2 <= 170 || i2 >= 190) && i2 > 260 && i2 < 280 && DroneControlFragment.this.f12863ct.f12359h) {
                            DroneControlFragment.this.o();
                        }
                    } else if (DroneControlFragment.this.f12863ct.f12359h) {
                        DroneControlFragment.this.p();
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void n() {
        if (this.cK != 1 && System.currentTimeMillis() - this.cL >= 3000) {
            Log.i(f12791y, "change SCREEN_ORIENTATION_PORTRAIT");
            this.cK = 1;
            a(true, true);
            this.f12863ct.a();
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        if (this.cK != 0 && System.currentTimeMillis() - this.cL >= 3000) {
            Log.i(f12791y, "change SCREEN_ORIENTATION_LANDSCAPE");
            int i2 = this.cK;
            this.cK = 0;
            a(false, i2 != 8);
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        if (this.cK != 8 && System.currentTimeMillis() - this.cL >= 3000) {
            Log.i(f12791y, "change SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
            int i2 = this.cK;
            this.cK = 8;
            a(false, i2 != 0);
        }
    }

    private void q() {
        if (SPUtils.getInstance().getBoolean("is_ort", false)) {
            OrientationEventListener orientationEventListener = this.cJ;
            if (orientationEventListener != null) {
                orientationEventListener.enable();
                return;
            }
            return;
        }
        OrientationEventListener orientationEventListener2 = this.cJ;
        if (orientationEventListener2 != null) {
            orientationEventListener2.disable();
        }
        this.cK = 6;
        e(3);
    }

    private void r() {
        if (this.f12877dh == null) {
            this.f12877dh = f.a(5, 5, TimeUnit.SECONDS).b(lz.a.b()).a(lu.a.a()).a(new lv.d() {
                public final void accept(Object obj) {
                    DroneControlFragment.this.b((Long) obj);
                }
            });
        }
    }

    private void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.f12863ct.registerReceiver(this.f12872dc, intentFilter);
    }

    /* access modifiers changed from: private */
    public void t() {
        msg_image_data msg_image_data = new msg_image_data();
        msg_image_data.f6856n = 0;
        msg_image_data.f6857o = 0;
        this.bA.j().a(msg_image_data.a());
        SystemClock.sleep(20);
        this.bA.j().a(msg_image_data.a());
        SystemClock.sleep(20);
        this.bA.j().a(msg_image_data.a());
        a(msg_image_data);
    }

    /* access modifiers changed from: private */
    public void u() {
        this.f12884dp.b();
        ks.f.a().c();
        v();
        w();
    }

    private void v() {
        this.f12830bm = false;
        if (this.bA.d().e() == ApmModes.ROTOR_TRACKER) {
            this.bA.d().b(ApmModes.ROTOR_LOITER);
            this.bA.d().b(ApmModes.ROTOR_LOITER);
        }
        t();
        x();
        this.f12829bl.setBackground(getResources().getDrawable(R.drawable.bg_start_follow));
        this.f12829bl.setText(R.string.mission_control_follow);
    }

    private void w() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                DroneControlFragment.this.f12828bk.setVisibility(8);
                DroneControlFragment.this.f12829bl.setVisibility(8);
                DroneControlFragment.this.f12827bj.setVisibility(0);
                DroneControlFragment.this.f12826bi.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void x() {
        if (this.cZ != null) {
            this.f12826bi.setText("");
            this.cZ.cancel();
            this.cZ = null;
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        ValueAnimator valueAnimator = this.f12885dq;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
            this.f12885dq = ofInt;
            ofInt.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    boolean unused = DroneControlFragment.this.f12887ds = true;
                }

                public void onAnimationEnd(Animator animator) {
                    DroneControlFragment.this.cN.setProgressStartColor(-1);
                    DroneControlFragment.this.cN.setProgressEndColor(-1);
                    DroneControlFragment.this.cN.setProgressBackgroundColor(-1);
                }

                public void onAnimationRepeat(Animator animator) {
                    Log.i("newUI", "onAnimationRepeat: ");
                    if (DroneControlFragment.this.f12886dr) {
                        DroneControlFragment.this.cN.setProgressBackgroundColor(-1);
                        DroneControlFragment.this.cN.setProgressStartColor(0);
                        DroneControlFragment.this.cN.setProgressEndColor(0);
                    } else if (!DroneControlFragment.this.f12887ds) {
                        DroneControlFragment.this.cN.setProgressBackgroundColor(0);
                        DroneControlFragment.this.cN.setProgressStartColor(-1);
                        DroneControlFragment.this.cN.setProgressEndColor(-1);
                    } else {
                        return;
                    }
                    DroneControlFragment droneControlFragment = DroneControlFragment.this;
                    boolean unused = droneControlFragment.f12886dr = !droneControlFragment.f12886dr;
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.f12885dq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DroneControlFragment.this.a(valueAnimator);
                }
            });
            this.f12885dq.setRepeatCount(-1);
            this.f12885dq.setDuration(1000);
            this.f12886dr = true;
            this.f12887ds = false;
            this.f12885dq.start();
        }
    }

    private void z() {
        new Thread(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aV();
            }
        }, "getRcVersion").start();
    }

    @l(a = ThreadMode.ASYNC)
    public void LogDataEvent(bd bdVar) {
    }

    @l(a = ThreadMode.MAIN)
    public void OrientationStateEvent(dy.t tVar) {
        if (tVar.a() == 15) {
            c(this.bA);
            if (this.f12857cn) {
                if (this.dL != 8) {
                    if (Math.abs(this.bA.u().a()) <= 2.0d) {
                        this.dL++;
                    } else {
                        this.dL = 0;
                    }
                }
                if (this.dM == 8) {
                    return;
                }
                if (Math.abs(this.bA.u().b()) <= 2.0d) {
                    this.dM++;
                } else {
                    this.dM = 0;
                }
            } else if (this.dL == 8 && this.dM == 8) {
                if (!this.bA.P().d()) {
                    this.bA.P().d(true);
                }
            } else if (this.bA.P().d()) {
                this.bA.P().d(false);
            }
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void RcInEvent(au auVar) {
        if (auVar.a() == 17) {
            a(this.bA);
        }
    }

    public void a(int i2) {
        this.cQ = i2;
        if (i2 != 8) {
            this.f12827bj.setVisibility(8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0489  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r0.f12876dg = r1
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            android.view.Window r2 = r2.getWindow()
            r3 = 0
            r2.setBackgroundDrawable(r3)
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            android.app.Application r2 = r2.getApplication()
            com.xeagle.android.XEagleApp r2 = (com.xeagle.android.XEagleApp) r2
            r0.f12540a = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            en.a r2 = r2.k()
            r0.bA = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            kd.a r2 = r2.p()
            r0.bT = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            com.xeagle.android.utils.prefs.a r2 = r2.j()
            r0.bB = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            com.flypro.core.gcs.follow.Follow r2 = r2.l()
            r0.bU = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            com.xeagle.android.a r2 = r2.m()
            int r2 = r2.a()
            r0.f12864cu = r2
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            android.content.Intent r2 = r2.getIntent()
            java.lang.String r3 = "isFirst"
            r4 = 0
            r2.putExtra(r3, r4)
            r17.s()
            com.xeagle.android.utils.prefs.a r2 = r0.bB
            int r2 = r2.v()
            r0.f12838bu = r2
            com.xeagle.android.utils.prefs.a r2 = r0.bB
            int r2 = r2.w()
            r0.f12837bt = r2
            com.xeagle.android.utils.prefs.a r2 = r0.bB
            int r2 = r2.x()
            r0.f12836bs = r2
            en.a r2 = r0.bA
            com.flypro.core.drone.variables.ab r2 = r2.D()
            r0.aH = r2
            com.xeagle.android.vjoystick.JoyStickView r2 = r0.B
            r3 = 1
            if (r2 != 0) goto L_0x0088
            r2 = 2131297805(0x7f09060d, float:1.8213565E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.JoyStickView r2 = (com.xeagle.android.vjoystick.JoyStickView) r2
            r0.B = r2
            r2.setLeftStick(r3)
        L_0x0088:
            com.xeagle.android.vjoystick.JoyStickView r2 = r0.C
            if (r2 != 0) goto L_0x009a
            r2 = 2131298601(0x7f090929, float:1.821518E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.JoyStickView r2 = (com.xeagle.android.vjoystick.JoyStickView) r2
            r0.C = r2
            r2.setLeftStick(r4)
        L_0x009a:
            r2 = 2131299063(0x7f090af7, float:1.8216117E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r2 = (com.xeagle.android.login.gsy.video.EmptyControlVideo) r2
            r0.f12914z = r2
            r2 = 2131299631(0x7f090d2f, float:1.8217269E38)
            android.view.View r2 = r1.findViewById(r2)
            android.view.TextureView r2 = (android.view.TextureView) r2
            r0.A = r2
            r2 = 2131297313(0x7f090421, float:1.8212567E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.widgets.GridRelativeLayout r2 = (com.xeagle.android.widgets.GridRelativeLayout) r2
            r0.f12861cr = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            boolean r2 = r2.c()
            if (r2 == 0) goto L_0x00dd
            com.xeagle.android.widgets.GridRelativeLayout r5 = r0.f12861cr
            com.xeagle.android.utils.prefs.a r2 = r0.bB
            int r6 = r2.aD()
            android.view.TextureView r2 = r0.A
            int r7 = r2.getMeasuredWidth()
            android.view.TextureView r2 = r0.A
            int r8 = r2.getMeasuredHeight()
            r9 = 0
            r10 = 2
            r5.a(r6, r7, r8, r9, r10)
            goto L_0x0107
        L_0x00dd:
            com.xeagle.android.widgets.GridRelativeLayout r11 = r0.f12861cr
            com.xeagle.android.utils.prefs.a r2 = r0.bB
            int r12 = r2.aD()
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            android.view.WindowManager r2 = r2.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            int r13 = r2.getWidth()
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            android.view.WindowManager r2 = r2.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            int r14 = r2.getHeight()
            r15 = 0
            r16 = 3
            r11.a(r12, r13, r14, r15, r16)
        L_0x0107:
            r2 = 2131296748(0x7f0901ec, float:1.8211421E38)
            android.view.View r2 = r1.findViewById(r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r0.J = r2
            r2 = 2131299101(0x7f090b1d, float:1.8216194E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.D = r2
            r2 = 2131296763(0x7f0901fb, float:1.8211452E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.E = r2
            r2 = 2131298373(0x7f090845, float:1.8214717E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.F = r2
            r2 = 2131298536(0x7f0908e8, float:1.8215048E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Chronometer r2 = (android.widget.Chronometer) r2
            r0.G = r2
            r2 = 2131297653(0x7f090575, float:1.8213257E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.H = r2
            r2 = 2131297960(0x7f0906a8, float:1.821388E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            r0.aO = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            boolean r2 = r2.c()
            r5 = 8
            if (r2 == 0) goto L_0x0173
            android.view.TextureView r2 = r0.A
            r2.setVisibility(r4)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r2 = r0.f12914z
            r2.setVisibility(r5)
            android.view.TextureView r2 = r0.A
            r2.setOnTouchListener(r0)
            android.view.TextureView r2 = r0.A
            r2.setSurfaceTextureListener(r0)
            goto L_0x017d
        L_0x0173:
            android.view.TextureView r2 = r0.A
            r2.setVisibility(r5)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r2 = r0.f12914z
            r2.setVisibility(r4)
        L_0x017d:
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x018a
            android.widget.ProgressBar r2 = r0.aO
            r2.setVisibility(r4)
        L_0x018a:
            r2 = 2131296643(0x7f090183, float:1.8211208E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aQ = r2
            r2 = 2131296644(0x7f090184, float:1.821121E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.aP = r2
            r2 = 2131297502(0x7f0904de, float:1.821295E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aR = r2
            r2 = 2131299112(0x7f090b28, float:1.8216216E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r0.I = r2
            r2 = 2131296579(0x7f090143, float:1.8211079E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = (com.xeagle.android.vjoystick.IWidgets.IButton) r2
            r0.f12879dj = r2
            r2 = 2131297389(0x7f09046d, float:1.8212722E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.aW = r2
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r0.f12879dj
            r2.setOnClickListener(r0)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = r0.aW
            r2.setOnClickListener(r0)
            r2 = 2131298270(0x7f0907de, float:1.8214508E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aX = r2
            r2 = 2131298269(0x7f0907dd, float:1.8214506E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aY = r2
            r2 = 2131298268(0x7f0907dc, float:1.8214504E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aZ = r2
            r2 = 2131298271(0x7f0907df, float:1.821451E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f12818ba = r2
            r2 = 2131297575(0x7f090527, float:1.8213099E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.f12819bb = r2
            r2 = 2131297036(0x7f09030c, float:1.8212006E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r0.bV = r2
            r2 = 2131299075(0x7f090b03, float:1.8216141E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.L = r2
            r2 = 2131298634(0x7f09094a, float:1.8215247E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress r2 = (com.xeagle.android.newUI.widgets.timelapseProgress.CircleLineProgress) r2
            r0.cN = r2
            r2 = 2131296688(0x7f0901b0, float:1.82113E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r2 = (com.xeagle.android.vjoystick.IWidgets.IImageButton) r2
            r0.cO = r2
            r2 = 2131297269(0x7f0903f5, float:1.8212478E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aU = r2
            r2 = 2131298242(0x7f0907c2, float:1.8214452E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aT = r2
            r2 = 2131299693(0x7f090d6d, float:1.8217395E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.aS = r2
            ef.a r2 = new ef.a
            r6 = 0
            r2.<init>(r6, r6)
            r0.f12862cs = r2
            r2 = 2131296906(0x7f09028a, float:1.8211742E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = (com.xeagle.android.vjoystick.IWidgets.IButton) r2
            r0.O = r2
            r2 = 2131298586(0x7f09091a, float:1.821515E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = (com.xeagle.android.vjoystick.IWidgets.IButton) r2
            r0.M = r2
            r2 = 2131299585(0x7f090d01, float:1.8217176E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.N = r2
            com.xeagle.android.vjoystick.a r2 = new com.xeagle.android.vjoystick.a
            com.xeagle.android.activities.FlightActionActivity r6 = r0.f12863ct
            android.content.Context r6 = r6.getApplicationContext()
            r2.<init>(r6)
            r0.f12843bz = r2
            r2 = 2131299502(0x7f090cae, float:1.8217007E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f12824bg = r2
            com.xeagle.android.vjoystick.DroneControlFragment$a r2 = new com.xeagle.android.vjoystick.DroneControlFragment$a
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            r2.<init>(r6)
            r0.bC = r2
            r2 = 2131297407(0x7f09047f, float:1.8212758E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = (com.xeagle.android.vjoystick.IWidgets.IButton) r2
            r6 = 2131299300(0x7f090be4, float:1.8216598E38)
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f12822be = r6
            r6 = 2131299285(0x7f090bd5, float:1.8216567E38)
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f12823bf = r6
            r6 = 2131299257(0x7f090bb9, float:1.821651E38)
            android.view.View r6 = r1.findViewById(r6)
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r0.f12825bh = r6
            r7 = 2131298543(0x7f0908ef, float:1.8215062E38)
            android.view.View r6 = r6.findViewById(r7)
            com.xeagle.android.vjoystick.view.DrawRectangleView r6 = (com.xeagle.android.vjoystick.view.DrawRectangleView) r6
            r0.f12826bi = r6
            android.widget.FrameLayout r6 = r0.f12825bh
            r7 = 2131299559(0x7f090ce7, float:1.8217123E38)
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f12827bj = r6
            android.widget.FrameLayout r6 = r0.f12825bh
            r7 = 2131299353(0x7f090c19, float:1.8216705E38)
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f12828bk = r6
            android.widget.FrameLayout r6 = r0.f12825bh
            r7 = 2131299544(0x7f090cd8, float:1.8217092E38)
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f12829bl = r6
            com.xeagle.android.vjoystick.DroneControlFragment$34 r7 = new com.xeagle.android.vjoystick.DroneControlFragment$34
            r7.<init>()
            r6.setOnClickListener(r7)
            com.xeagle.android.vjoystick.view.DrawRectangleView r6 = r0.f12826bi
            com.xeagle.android.vjoystick.DroneControlFragment$39 r7 = new com.xeagle.android.vjoystick.DroneControlFragment$39
            r7.<init>()
            r6.setOnDrawRectFinishListener(r7)
            com.xeagle.android.XEagleApp r6 = r0.f12540a
            boolean r6 = r6.c()
            if (r6 == 0) goto L_0x0339
            com.xeagle.android.XEagleApp r6 = r0.f12540a
            com.hoho.android.usb.usb.data_proxy.d r6 = r6.e()
            java.lang.String r7 = f12791y
            r6.a((java.lang.String) r7)
            com.xeagle.android.XEagleApp r6 = r0.f12540a
            com.hoho.android.usb.usb.data_proxy.d r6 = r6.e()
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$0XFmECx1T28TReO3WQK10M3pTHE r8 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$0XFmECx1T28TReO3WQK10M3pTHE
            r8.<init>(r2)
            r6.a((java.lang.String) r7, (com.hoho.android.usb.usb.data_proxy.g) r8)
            r17.L()
        L_0x0339:
            r6 = 2131297433(0x7f090499, float:1.821281E38)
            android.view.View r6 = r1.findViewById(r6)
            com.xeagle.android.vjoystick.IWidgets.IButton r6 = (com.xeagle.android.vjoystick.IWidgets.IButton) r6
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$UVhnkkfojwQKMRBnIFuxnadaXWs r7 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$UVhnkkfojwQKMRBnIFuxnadaXWs
            r7.<init>(r6)
            r6.setOnClickListener(r7)
            r7 = 2131297392(0x7f090470, float:1.8212728E38)
            android.view.View r7 = r1.findViewById(r7)
            com.xeagle.android.vjoystick.IWidgets.IButton r7 = (com.xeagle.android.vjoystick.IWidgets.IButton) r7
            r0.f12831bn = r7
            int r8 = r0.f12836bs
            r9 = 1280(0x500, float:1.794E-42)
            if (r8 != r9) goto L_0x0361
            java.lang.String r8 = "720P"
        L_0x035d:
            r7.setText(r8)
            goto L_0x036b
        L_0x0361:
            r9 = 848(0x350, float:1.188E-42)
            if (r8 != r9) goto L_0x0368
            java.lang.String r8 = "WVGA"
            goto L_0x035d
        L_0x0368:
            java.lang.String r8 = "1080P"
            goto L_0x035d
        L_0x036b:
            com.xeagle.android.vjoystick.IWidgets.IButton r7 = r0.f12831bn
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$9iRDWODd9w9MIJajhQ3Cjo6sf0g r8 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$9iRDWODd9w9MIJajhQ3Cjo6sf0g
            r8.<init>()
            r7.setOnClickListener(r8)
            r7 = 2131297391(0x7f09046f, float:1.8212726E38)
            android.view.View r7 = r1.findViewById(r7)
            com.xeagle.android.vjoystick.IWidgets.IButton r7 = (com.xeagle.android.vjoystick.IWidgets.IButton) r7
            r0.f12832bo = r7
            int r8 = r0.f12838bu
            r9 = 15
            if (r8 != r9) goto L_0x0389
            java.lang.String r8 = "15fps"
            goto L_0x038b
        L_0x0389:
            java.lang.String r8 = "30fps"
        L_0x038b:
            r7.setText(r8)
            com.xeagle.android.vjoystick.IWidgets.IButton r7 = r0.f12832bo
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$hWr5u2onk4l7LuATeqSIUqaq67c r8 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$hWr5u2onk4l7LuATeqSIUqaq67c
            r8.<init>()
            r7.setOnClickListener(r8)
            com.xeagle.android.utils.prefs.a r7 = r0.bB
            boolean r7 = r7.aH()
            if (r7 == 0) goto L_0x03b6
            r2.setVisibility(r4)
            r6.setVisibility(r4)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r0.f12832bo
            r2.setVisibility(r4)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r0.f12831bn
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f12823bf
            r2.setVisibility(r4)
            goto L_0x03cb
        L_0x03b6:
            r2.setVisibility(r5)
            r6.setVisibility(r5)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r0.f12832bo
            r2.setVisibility(r5)
            com.xeagle.android.vjoystick.IWidgets.IButton r2 = r0.f12831bn
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.f12823bf
            r2.setVisibility(r5)
        L_0x03cb:
            r2 = 2131298678(0x7f090976, float:1.8215336E38)
            android.view.View r2 = r1.findViewById(r2)
            com.xeagle.android.vjoystick.VerticalSeekBar r2 = (com.xeagle.android.vjoystick.VerticalSeekBar) r2
            r0.f12821bd = r2
            r5 = 50
            r2.setMax(r5)
            r2 = 2131299509(0x7f090cb5, float:1.8217021E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f12820bc = r2
            com.xeagle.android.XEagleApp r2 = r0.f12540a
            boolean r2 = r2.c()
            if (r2 == 0) goto L_0x03f4
            com.xeagle.android.vjoystick.VerticalSeekBar r2 = r0.f12821bd
            r2.setEnabled(r4)
            goto L_0x03f9
        L_0x03f4:
            com.xeagle.android.vjoystick.VerticalSeekBar r2 = r0.f12821bd
            r2.setEnabled(r3)
        L_0x03f9:
            com.xeagle.android.vjoystick.VerticalSeekBar r2 = r0.f12821bd
            com.xeagle.android.vjoystick.DroneControlFragment$40 r5 = new com.xeagle.android.vjoystick.DroneControlFragment$40
            r5.<init>()
            r2.setOnSeekBarChangeListener(r5)
            r17.b((android.view.View) r18)
            r17.N()
            r17.A()
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            int r1 = r1.E()
            r2 = 2
            if (r1 != r2) goto L_0x041d
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            r2 = 115(0x73, float:1.61E-43)
        L_0x0419:
            r1.sendEmptyMessage(r2)
            goto L_0x042a
        L_0x041d:
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            int r1 = r1.E()
            if (r1 != r3) goto L_0x042a
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x0419
        L_0x042a:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.ListenerData r1 = r1.Q()
            en.a r2 = r0.bA
            com.flypro.core.drone.variables.aa r2 = r2.d()
            com.MAVLink.Messages.ApmModes r2 = r2.e()
            java.lang.String r2 = r2.b()
            r1.a((java.lang.String) r2)
            r1 = 1
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            io.reactivex.f r1 = io.reactivex.f.a(r1, r3)
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$P0NGbOOmORPMeQCIWj77YlLFr80 r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$P0NGbOOmORPMeQCIWj77YlLFr80
            r2.<init>()
            r1.a(r2)
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            int r1 = r1.getRequestedOrientation()
            r0.cK = r1
            long r1 = java.lang.System.currentTimeMillis()
            r0.cL = r1
            java.lang.String r1 = f12791y
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "init mCurrentOrientation = "
            r2.append(r3)
            int r3 = r0.cK
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0489
            r17.m()
            android.view.TextureView r1 = r0.A
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            goto L_0x048f
        L_0x0489:
            com.xeagle.android.login.gsy.video.EmptyControlVideo r1 = r0.f12914z
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
        L_0x048f:
            android.view.ViewTreeObserver$OnGlobalLayoutListener r2 = r0.f12901k
            r1.addOnGlobalLayoutListener(r2)
            r0.f12870da = r4
            r17.O()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.a(android.view.View):void");
    }

    public void a(VisionModeStatus visionModeStatus) {
        FragmentActivity activity;
        Runnable r1;
        if (visionModeStatus == VisionModeStatus.RUN) {
            this.J.setVisibility(0);
            int width = this.A.getWidth();
            int height = this.A.getHeight();
            File b2 = e.b(getContext());
            File c2 = e.c(getContext());
            File a2 = e.a(getContext());
            String path = b2.getPath();
            String path2 = c2.getPath();
            String path3 = a2.getPath();
            File d2 = e.d(getContext());
            File e2 = e.e(getContext());
            if (d2.exists() && e2.exists()) {
                path = d2.getPath();
                path2 = e2.getPath();
            }
            Rect currentRect = this.f12826bi.getCurrentRect();
            int i2 = currentRect.right - currentRect.left;
            int i3 = currentRect.bottom - currentRect.top;
            if (i2 >= 8 || i3 >= 8) {
                ks.d dVar = new ks.d();
                dVar.a(this.A);
                dVar.a(20);
                dVar.a(currentRect);
                dVar.a(width, height);
                dVar.a(this.f12884dp);
                dVar.a(path);
                dVar.b(path2);
                dVar.c(path3);
                ks.f.a().a(this.f0do, dVar);
                ks.f.a().b();
            } else {
                ToastUtils.showShort((int) R.string.target_small_tip);
                w();
                return;
            }
        } else if (visionModeStatus == VisionModeStatus.STOP) {
            Log.i("MMMMMM", "VisionModeStatus.STOP");
            this.bC.removeCallbacks(this.f12883dn);
            this.f12884dp.b();
            ks.f.a().c();
            v();
            w();
            this.f12825bh.setVisibility(8);
            if (this.bB.aH()) {
                this.f12822be.setVisibility(8);
            }
            this.J.setVisibility(0);
        } else {
            if (visionModeStatus == VisionModeStatus.READY) {
                this.bC.removeCallbacks(this.f12883dn);
                this.bA.d().b(ApmModes.ROTOR_LOITER);
                this.bA.d().b(ApmModes.ROTOR_LOITER);
                ks.f.a().c();
                activity = getActivity();
                r1 = new Runnable() {
                    public void run() {
                        boolean z2 = false;
                        DroneControlFragment.this.f12825bh.setVisibility(0);
                        if (DroneControlFragment.this.bB.aH()) {
                            DroneControlFragment.this.f12822be.setText("");
                            DroneControlFragment.this.f12822be.setVisibility(0);
                        }
                        DroneControlFragment.this.J.setVisibility(8);
                        DroneControlFragment.this.f12827bj.setVisibility(0);
                        DrawRectangleView p2 = DroneControlFragment.this.f12826bi;
                        if (DroneControlFragment.this.cQ == 8) {
                            z2 = true;
                        }
                        p2.setShowMode(z2);
                    }
                };
            } else if (visionModeStatus == VisionModeStatus.RESET) {
                Log.i("MMMMMM", "VisionModeStatus.RESET");
                activity = getActivity();
                r1 = new Runnable() {
                    public void run() {
                        DroneControlFragment.this.u();
                        DroneControlFragment.this.Y();
                    }
                };
            }
            activity.runOnUiThread(r1);
        }
        this.cS = visionModeStatus;
    }

    public void a(en.a aVar) {
        if (aVar == null || aVar.m() == null) {
            int[] iArr = new int[8];
            this.f12855cl = iArr;
            Arrays.fill(iArr, 0);
            return;
        }
        this.f12855cl = aVar.m().b();
    }

    public void a(boolean z2, int i2) {
        this.f12863ct.runOnUiThread(new Runnable(z2) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DroneControlFragment.this.c(this.f$1);
            }
        });
    }

    public boolean a(String str) {
        return this.cM.containsKey(str);
    }

    @l(a = ThreadMode.ASYNC)
    public void armStateEvent(h hVar) {
        if (hVar.a() == 9) {
            ag();
        }
    }

    public int b() {
        return R.layout.control_drone_activity;
    }

    @l(a = ThreadMode.MAIN)
    public void batRemain(jo.i iVar) {
        if (this.bB.aH()) {
            this.X.setText(String.format(Locale.US, "Vol: %3.1f mV", new Object[]{Double.valueOf(iVar.a())}));
        }
    }

    @l(a = ThreadMode.MAIN)
    public void channelEvent(jo.c cVar) {
        if ((cVar.a() & IChannelListener.MSG_MASK) == 0) {
            a(cVar.a(), cVar.b(), new String[0]);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void checkBackEvent(r rVar) {
        if (rVar.a()) {
            this.bC.sendEmptyMessage(68);
            if (this.f12899i) {
                aa();
            }
            this.bC.postDelayed(new Runnable() {
                public final void run() {
                    DroneControlFragment.this.aI();
                }
            }, 3000);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void checkGridType(t tVar) {
        if (!this.f12540a.c()) {
            this.f12861cr.a(tVar.a(), this.f12863ct.getWindowManager().getDefaultDisplay().getWidth(), this.f12863ct.getWindowManager().getDefaultDisplay().getHeight(), 0, 6);
        } else if (this.A != null) {
            this.f12861cr.a(tVar.a(), this.A.getMeasuredWidth(), this.A.getMeasuredHeight(), 0, 5);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void checkRcHand(ai aiVar) {
        boolean h2 = this.bB.h();
        this.bO = h2;
        this.B.setLeftHand(h2);
        this.C.setLeftHand(this.bO);
    }

    public boolean d() {
        String str = f12791y;
        Log.i(str, "isSdCardEnough: =====hasSdCard===" + f12789g + "===lastFree===" + this.bK);
        return f12789g && this.bK != 0;
    }

    @l(a = ThreadMode.MAIN)
    public void decodeResetEvent(jo.e eVar) {
        Log.i(f12791y, "decodeResetEvent");
        k();
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            i(this.bA);
            b(this.bA);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            Log.i("msg", "droneConnectEvent: ====drone connected...");
            if (this.bA.j().e()) {
                i(this.bA);
                ka.a.a().b().execute(new Runnable() {
                    public final void run() {
                        DroneControlFragment.this.at();
                    }
                });
            }
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneParamEvent(u uVar) {
        Parameter parameter;
        Parameter parameter2;
        Parameter a2 = uVar.a();
        if (a2 != null) {
            String str = a2.f14455a;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1815471759:
                    if (str.equals("FENCE_ENABLE")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1574216496:
                    if (str.equals("INAV_TC_KP")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1455202176:
                    if (str.equals("FENCE_RADIUS")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1342282679:
                    if (str.equals("PILOT_VELZ_MAX")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 245631046:
                    if (str.equals("PSC_limit_alt")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 261056352:
                    if (str.equals("FENCE_ALT_MAX")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 853019851:
                    if (str.equals("WPNAV_LOIT_SPD")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.dP = a2;
                    if (a("CONTROL_FENCE_ENABLE") && this.cM.get("CONTROL_FENCE_ENABLE").booleanValue()) {
                        this.cM.put("CONTROL_FENCE_ENABLE", false);
                        this.bA.e().a("PSC_limit_alt");
                        if (a2.f14456b != 1.0d) {
                            this.cM.put("CONTROL_PSC_limit_alt", true);
                            this.bB.e(false);
                            break;
                        } else {
                            this.bB.e(true);
                            this.cM.put("CONTROL_FENCE_ALT_MAX", true);
                            this.bA.e().a("FENCE_ALT_MAX");
                            this.cM.put("CONTROL_FENCE_RADIUS", true);
                            this.bA.e().a("FENCE_RADIUS");
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1:
                    if (a("CONTROL_INAV_TC_KP") && this.cM.get("CONTROL_INAV_TC_KP").booleanValue()) {
                        this.cM.put("CONTROL_INAV_TC_KP", false);
                        if (a2.f14456b != 3.0d) {
                            com.xeagle.android.utils.c.a(this.bA, "INAV_TC_KP", 3.0d);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (a("CONTROL_FENCE_RADIUS") && this.cM.get("CONTROL_FENCE_RADIUS").booleanValue()) {
                        this.cM.put("CONTROL_FENCE_RADIUS", false);
                        this.bB.c((int) a2.f14456b);
                        return;
                    }
                    return;
                case 3:
                    if (a("CONTROL_PILOT_VELZ_MAX") && this.cM.get("CONTROL_PILOT_VELZ_MAX").booleanValue()) {
                        this.cM.put("CONTROL_PILOT_VELZ_MAX", false);
                        if (a2.f14456b != 220.0d) {
                            com.xeagle.android.utils.c.a(this.bA, "PILOT_VELZ_MAX", 220.0d);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    this.dO = a2;
                    if (a("CONTROL_PSC_limit_alt") && this.cM.get("CONTROL_PSC_limit_alt").booleanValue()) {
                        this.cM.put("CONTROL_PSC_limit_alt", false);
                        this.bB.o((int) (a2.f14456b / 100.0d));
                        if (this.dN == null || (parameter = this.dP) == null || parameter.f14456b != 1.0d || ((double) ((int) (this.dO.f14456b / 100.0d))) >= this.dN.f14456b) {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 5:
                    this.dN = a2;
                    if (a("CONTROL_FENCE_ALT_MAX") && this.cM.get("CONTROL_FENCE_ALT_MAX").booleanValue()) {
                        this.cM.put("CONTROL_FENCE_ALT_MAX", false);
                        this.bB.b((int) a2.f14456b);
                        if (this.dO == null || (parameter2 = this.dP) == null || parameter2.f14456b != 1.0d || this.dN.f14456b <= ((double) ((int) (this.dO.f14456b / 100.0d)))) {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
                case 6:
                    if (a("CONTROL_WPNAV_LOIT_SPD") && this.cM.get("CONTROL_WPNAV_LOIT_SPD").booleanValue()) {
                        this.cM.put("CONTROL_WPNAV_LOIT_SPD", false);
                        if (a2.f14456b < 750.0d) {
                            this.bB.g(417);
                            return;
                        } else if (a2.f14456b >= 750.0d && a2.f14456b <= 1199.0d) {
                            this.bB.g(834);
                            this.bC.post(new Runnable() {
                                public void run() {
                                    ToastHelper.showCenterToastShort(DroneControlFragment.this.f12863ct, R.layout.toast_fly_normal_warn);
                                }
                            });
                            return;
                        } else if (a2.f14456b >= 1200.0d) {
                            this.bB.g(1580);
                            this.bC.post(new Runnable() {
                                public final void run() {
                                    DroneControlFragment.this.as();
                                }
                            });
                            this.bA.d().c(this.f12863ct.getString(R.string.sport_mode_warn));
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
            this.dO.f14456b = this.dN.f14456b * 100.0d;
            this.bA.e().a(this.dO);
            SystemClock.sleep(100);
            this.cM.put("CONTROL_PSC_limit_alt", true);
            this.bA.e().a("PSC_limit_alt");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneRcControlEvent(w wVar) {
        if (wVar.a() == 46) {
            if (this.bA.E().a() == 1) {
                this.bA.D().a();
            } else if (this.bA.E().a() == 0 && this.dF) {
                this.bA.D().e();
                this.dF = false;
            }
            H();
            if (this.f12540a.a().i().contains("Drone") && this.bA.E().a() == 1) {
                this.bA.d().a(this.f12863ct.getString(R.string.warn_toast_rc));
            }
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneUpdateFirmwareEvent(dy.ab abVar) {
        if (abVar.a() == 65) {
            this.f12540a.n().d(this.bA.y());
            this.f12540a.n().b(this.bA.y().substring(0, this.bA.y().indexOf("-v")));
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneVibrationEvent(ac acVar) {
        if (acVar.a() == 69) {
            d(this.bA);
        }
    }

    public void e() {
        this.f12830bm = true;
        this.f12829bl.setBackground(getResources().getDrawable(R.drawable.bg_stop_follow));
        this.f12829bl.setText(R.string.stop);
        if (this.f12828bk.getVisibility() == 0) {
            this.f12828bk.setVisibility(8);
            this.bB.aT();
        }
        this.f12884dp.a();
    }

    public void f() {
        e.a b2 = this.bA.k().b();
        m.a(this.bA.j(), b2.f14210a, b2.f14211b, b2.f14212c, b2.f14213d, b2.f14214e, b2.f14215f, b2.f14216g, b2.f14217h, b2.f14218i);
    }

    @l(a = ThreadMode.MAIN)
    public void firstFrameEvent(jf.a aVar) {
        Log.i("CmdChannel", "firstFrameEvent: ---width--" + aVar.a() + "--height--" + aVar.b());
        this.cD = 0;
        this.cC = 0;
        this.cE = 0;
        if (!this.f12540a.c() && this.aP.getVisibility() == 0) {
            this.bC.sendEmptyMessage(IChannelListener.CMD_CHANNEL_NO_MORE_SPACE);
        }
    }

    public void g() {
        org.greenrobot.eventbus.c.a().d(new bd(59));
        this.bC.postDelayed(this.f12903m, 120);
    }

    @l(a = ThreadMode.BACKGROUND)
    public void getDroneHdop(jo.k kVar) {
    }

    @l(a = ThreadMode.BACKGROUND)
    public void getErrMsg(n nVar) {
    }

    @l(a = ThreadMode.BACKGROUND)
    public void getGpsInfo(s sVar) {
        this.f12844ca = sVar.a().b();
        this.f12845cb = sVar.a().d();
        this.bA.Q().a(this.f12844ca);
    }

    @l(a = ThreadMode.MAIN)
    public void getMessageEvent(ha.c cVar) {
        if (!cVar.b().equals("landscape_or_vertical")) {
            return;
        }
        if (this.f12898h) {
            ToastUtils.showShort((int) R.string.camera_record_warn);
            SPUtils.getInstance().put("is_ort", !((Boolean) cVar.a()).booleanValue());
            return;
        }
        q();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void gpsEvent(p pVar) {
        if (pVar.a() == 23) {
            e(this.bA);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatFirst(ak akVar) {
        if (akVar.a() == 6) {
            Log.i("HEART", "heartbeatFirst: ");
            f();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void heartbeatRestoredEvent(al alVar) {
        if (alVar.a() == 7) {
            Log.i("HEART", "heartbeatRestoredEvent: ");
            if (this.bA.d().d() && !this.bX) {
                this.bX = true;
            }
            f();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void homeEvent(q qVar) {
        if (qVar.a() == 22) {
            e(this.bA);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void ijkCompletionEvent(jp.a aVar) {
        Log.i("newUI", "ijkCompletionEvent: ");
        this.bC.removeCallbacks(this.f12909s);
        if (this.f12899i) {
            aa();
            if (this.bA.d().e().equals(ApmModes.ROTOR_POSHOLD)) {
                Z();
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void ijkPrepareEvent(jp.b bVar) {
        Log.i("ijkPlayer", "run: ===takePhoto==fps==" + this.f12914z.getDecodeFps());
        ac();
    }

    @l(a = ThreadMode.MAIN)
    public void initSurfaceView(ha.e eVar) {
        if (eVar.a() == 6) {
            this.A.setVisibility(0);
            this.f12914z.setVisibility(8);
            this.A.setOnTouchListener(this);
            this.A.setSurfaceTextureListener(this);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void landFinishEvent(an anVar) {
        aa aaVar;
        ApmModes apmModes;
        if (anVar.a() == 54) {
            Toast.makeText(this.f12863ct.getApplicationContext(), getString(R.string.land_finish), 0).show();
            this.f12540a.i().a(getString(R.string.land_finish));
            if (this.bH) {
                aaVar = this.bA.d();
                apmModes = ApmModes.ROTOR_LOITER;
            } else {
                aaVar = this.bA.d();
                apmModes = ApmModes.ROTOR_ALT_HOLD;
            }
            aaVar.b(apmModes);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void modeEvent(dy.s sVar) {
        if (sVar.a() == 4) {
            h(this.bA);
            if (!"Auto".equals(this.bA.d().e().b())) {
                b(this.bA);
            }
            if ("Guided".equalsIgnoreCase(this.bA.d().e().b())) {
                SystemClock.sleep(200);
                Follow follow = this.bU;
                if (follow == null || follow.b()) {
                    return;
                }
            } else {
                Follow follow2 = this.bU;
                if (follow2 == null || !follow2.b()) {
                    return;
                }
            }
            this.bU.a();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12863ct = (FlightActionActivity) activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c9, code lost:
        android.widget.Toast.makeText(r1, r2, 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02ff, code lost:
        r1.runOnUiThread(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x032f, code lost:
        r1.g(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0557, code lost:
        if (r0.f12898h != false) goto L_0x0559;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0559, code lost:
        Y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x055c, code lost:
        r0.f12540a.m().b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0566, code lost:
        X();
        r0.f12540a.m().b(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r17.getId()
            r2 = 2020121101(0x78689a0d, float:1.8870897E34)
            java.lang.String r3 = "_"
            r4 = 2131822727(0x7f110887, float:1.9278234E38)
            r7 = 2131822768(0x7f1108b0, float:1.9278317E38)
            r8 = 2131820659(0x7f110073, float:1.927404E38)
            r9 = 3000(0xbb8, double:1.482E-320)
            r11 = 2131823185(0x7f110a51, float:1.9279163E38)
            r12 = 2131821016(0x7f1101d8, float:1.9274763E38)
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r15 = 2
            r5 = 0
            r6 = 1
            switch(r1) {
                case 2131296579: goto L_0x0573;
                case 2131296688: goto L_0x04fb;
                case 2131296763: goto L_0x037c;
                case 2131296906: goto L_0x0378;
                case 2131297036: goto L_0x035b;
                case 2131297290: goto L_0x0334;
                case 2131297292: goto L_0x0304;
                case 2131297294: goto L_0x02db;
                case 2131297295: goto L_0x02d2;
                case 2131297389: goto L_0x026b;
                case 2131297437: goto L_0x0256;
                case 2131298373: goto L_0x0218;
                case 2131298586: goto L_0x01da;
                case 2131299025: goto L_0x018b;
                case 2131299026: goto L_0x0110;
                case 2131299075: goto L_0x0094;
                case 2131299101: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x0576
        L_0x0026:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r0.D
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$n1hSvUn64Be0GbhDXzMXhXrd3xo r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$n1hSvUn64Be0GbhDXzMXhXrd3xo
            r2.<init>()
            r1.postDelayed(r2, r9)
            en.a r1 = r0.bA
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x003c
            com.blankj.utilcode.util.ToastUtils.showShort((int) r12)
            return
        L_0x003c:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            java.lang.String r2 = r2.getString(r7)
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005e
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            java.lang.String r2 = r1.getString(r4)
            goto L_0x02c9
        L_0x005e:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.ListenerData r1 = r1.Q()
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            r3 = 2131820675(0x7f110083, float:1.9274072E38)
            java.lang.String r2 = r2.getString(r3)
            r1.e((java.lang.String) r2)
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.xeagle.android.a r1 = r1.m()
            r1.a((boolean) r6)
            boolean r1 = f12789g
            if (r1 == 0) goto L_0x0081
            r16.U()
            goto L_0x0086
        L_0x0081:
            ch.b r1 = r0.bF
            r1.a()
        L_0x0086:
            r16.T()
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.xeagle.android.a r1 = r1.m()
            r1.a((boolean) r5)
            goto L_0x0576
        L_0x0094:
            en.a r1 = r0.bA
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x00a0
            com.blankj.utilcode.util.ToastUtils.showShort((int) r12)
            return
        L_0x00a0:
            boolean r1 = r0.f12898h
            if (r1 == 0) goto L_0x00ac
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            r2 = 130(0x82, float:1.82E-43)
            r1.sendEmptyMessage(r2)
            return
        L_0x00ac:
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            int r1 = r1.E()
            if (r1 != r15) goto L_0x00f0
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x00e2
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x00d1
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.h()
            boolean r1 = r0.bS
            if (r1 == 0) goto L_0x00d1
            r1 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r1)
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.h()
            r0.bS = r5
        L_0x00d1:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r0.E
            r1.setEnabled(r5)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r0.D
            r1.setEnabled(r5)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r0.cO
            r1.setEnabled(r5)
            goto L_0x0576
        L_0x00e2:
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            r1.h((int) r6)
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            r2 = 116(0x74, float:1.63E-43)
        L_0x00eb:
            r1.sendEmptyMessage(r2)
            goto L_0x0576
        L_0x00f0:
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            int r1 = r1.E()
            if (r1 != r6) goto L_0x0576
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x0106
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x00d1
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.h()
            goto L_0x00d1
        L_0x0106:
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            r1.h((int) r15)
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x00eb
        L_0x0110:
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.flypro.core.util.e r1 = r1.a()
            java.lang.String r1 = r1.i()
            java.lang.String r2 = "Drone"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x016b
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.flypro.core.util.e r1 = r1.a()
            java.lang.String r1 = r1.i()
            java.lang.String r2 = "Controller"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x016b
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.flypro.core.util.e r1 = r1.a()
            java.lang.String r1 = r1.i()
            java.lang.String r2 = "Ground"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x016b
            r0.dF = r6
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r0.aD
            r1.setClickable(r5)
            android.widget.ProgressBar r1 = r0.aB
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$HbIdpMSxCBOKlOiVadJmXAfiEd4 r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$HbIdpMSxCBOKlOiVadJmXAfiEd4
            r2.<init>()
            r1.post(r2)
            java.util.Timer r1 = new java.util.Timer
            r1.<init>()
            java.lang.Thread r2 = new java.lang.Thread
            com.xeagle.android.vjoystick.DroneControlFragment$22 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$22
            r3.<init>(r1)
            r2.<init>(r3)
            r2.start()
            goto L_0x0576
        L_0x016b:
            com.xeagle.android.dialogs.r r1 = com.xeagle.android.dialogs.r.a()
            java.lang.String r2 = r0.getString(r11)
            com.xeagle.android.vjoystick.DroneControlFragment$24 r3 = new com.xeagle.android.vjoystick.DroneControlFragment$24
            r3.<init>()
            java.lang.String r4 = "请先关闭当前连接的WiFi的飞机，并确认将要连接的飞机已开启！"
            com.xeagle.android.dialogs.c r1 = r1.a((java.lang.String) r2, (java.lang.String) r4, (com.xeagle.android.dialogs.c.a) r3)
            if (r1 == 0) goto L_0x0576
            androidx.fragment.app.FragmentManager r2 = r16.getChildFragmentManager()
            java.lang.String r3 = "warning"
            r1.show(r2, r3)
            goto L_0x0576
        L_0x018b:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r0.f12803al
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r2 = "检测"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01c2
            r16.M()
            r1 = -1
            r0.dT = r1
            r0.dS = r1
            r0.dL = r1
            r0.dM = r1
            r0.f12857cn = r6
            android.widget.ProgressBar r1 = r0.f12816ay
            r1.setVisibility(r5)
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r0.f12803al
            r1.setClickable(r5)
            r16.z()
            com.xeagle.android.vjoystick.DroneControlFragment$a r1 = r0.bC
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$VqFxIJyMHVriC5k81cbTLRBihf0 r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$VqFxIJyMHVriC5k81cbTLRBihf0
            r2.<init>()
            r3 = 7400(0x1ce8, double:3.656E-320)
            r1.postDelayed(r2, r3)
            goto L_0x0576
        L_0x01c2:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r0.f12803al
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r3 = "清除"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0576
            r16.M()
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r0.f12803al
            r1.setText(r2)
            goto L_0x0576
        L_0x01da:
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x0576
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x0576
            int r1 = r0.Q
            if (r1 != 0) goto L_0x01ee
            r0.Q = r6
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "1M"
            goto L_0x032f
        L_0x01ee:
            if (r1 != r6) goto L_0x01f8
            r0.Q = r15
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "2M"
            goto L_0x032f
        L_0x01f8:
            r2 = 3
            if (r1 != r15) goto L_0x0203
            r0.Q = r2
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "3M"
            goto L_0x032f
        L_0x0203:
            r3 = 4
            if (r1 != r2) goto L_0x020e
            r0.Q = r3
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "4M"
            goto L_0x032f
        L_0x020e:
            if (r1 != r3) goto L_0x0576
            r0.Q = r5
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.String r2 = "0.5M"
            goto L_0x032f
        L_0x0218:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.ListenerData r1 = r1.Q()
            com.xeagle.android.activities.FlightActionActivity r2 = r0.f12863ct
            r3 = 2131820678(0x7f110086, float:1.9274078E38)
            java.lang.String r2 = r2.getString(r3)
            r1.e((java.lang.String) r2)
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x0246
            boolean r1 = r0.bQ
            if (r1 != 0) goto L_0x0246
            r1 = 2131822500(0x7f1107a4, float:1.9277773E38)
            java.lang.String r1 = r0.getString(r1)
            r0.e((java.lang.String) r1)
            goto L_0x0576
        L_0x0246:
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0251
            r16.S()
        L_0x0251:
            r16.ad()
            goto L_0x0576
        L_0x0256:
            com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.a()
            boolean r2 = r1.isAdded()
            if (r2 != 0) goto L_0x0576
            androidx.fragment.app.FragmentManager r2 = r16.getChildFragmentManager()
            java.lang.String r3 = "servoDlg"
            r1.show(r2, r3)
            goto L_0x0576
        L_0x026b:
            boolean r1 = r0.f12898h
            if (r1 != 0) goto L_0x02c0
            boolean r1 = r0.f12899i
            if (r1 != 0) goto L_0x02c0
            int r1 = r0.cQ
            r2 = 9
            if (r1 != r2) goto L_0x027a
            goto L_0x02c0
        L_0x027a:
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x029e
            com.xeagle.android.dialogs.ab r1 = r0.bD
            if (r1 != 0) goto L_0x0289
            com.xeagle.android.dialogs.ab r1 = new com.xeagle.android.dialogs.ab
            r1.<init>()
            r0.bD = r1
        L_0x0289:
            com.xeagle.android.dialogs.ab r1 = r0.bD
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0576
            com.xeagle.android.dialogs.ab r1 = r0.bD
            androidx.fragment.app.FragmentManager r2 = r16.getChildFragmentManager()
            java.lang.String r3 = "cameraSetting"
            r1.show((androidx.fragment.app.FragmentManager) r2, (java.lang.String) r3)
            goto L_0x0576
        L_0x029e:
            if (r1 != r15) goto L_0x0576
            com.xeagle.android.dialogs.ae r1 = r0.bE
            if (r1 != 0) goto L_0x02ab
            com.xeagle.android.dialogs.ae r1 = new com.xeagle.android.dialogs.ae
            r1.<init>()
            r0.bE = r1
        L_0x02ab:
            com.xeagle.android.dialogs.ae r1 = r0.bE
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0576
            com.xeagle.android.dialogs.ae r1 = r0.bE
            androidx.fragment.app.FragmentManager r2 = r16.getChildFragmentManager()
            java.lang.String r3 = "sochipCameraSetting"
            r1.show((androidx.fragment.app.FragmentManager) r2, (java.lang.String) r3)
            goto L_0x0576
        L_0x02c0:
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            r2 = 2131822729(0x7f110889, float:1.9278238E38)
            java.lang.String r2 = r1.getString(r2)
        L_0x02c9:
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r5)
            r1.show()
            goto L_0x0576
        L_0x02d2:
            en.a r1 = r0.bA
            r2 = 44
            com.flypro.core.MAVLink.b.a(r1, r2)
            goto L_0x0576
        L_0x02db:
            android.widget.TextView r1 = r0.aC
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            double r1 = java.lang.Double.parseDouble(r1)
            r0.aE = r1
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x02f1
            r0.aE = r13
        L_0x02f1:
            double r1 = r0.aE
            double r1 = r1 + r13
            r0.aE = r1
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            if (r1 == 0) goto L_0x0576
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$GFEaFaD9NdOkl71BxdgTXvWZFWs r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$GFEaFaD9NdOkl71BxdgTXvWZFWs
            r2.<init>()
        L_0x02ff:
            r1.runOnUiThread(r2)
            goto L_0x0576
        L_0x0304:
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x0576
            double r1 = r0.aE
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r5 = "M"
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            if (r6 >= 0) goto L_0x031f
            r2.<init>()
            double r3 = r0.aE
            r2.append(r3)
            goto L_0x0328
        L_0x031f:
            r2.<init>()
            double r3 = r0.aE
            int r3 = (int) r3
            r2.append(r3)
        L_0x0328:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
        L_0x032f:
            r1.g(r2)
            goto L_0x0576
        L_0x0334:
            android.widget.TextView r1 = r0.aC
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            double r1 = java.lang.Double.parseDouble(r1)
            r0.aE = r1
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x034e
            r1 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            goto L_0x034f
        L_0x034e:
            double r1 = r1 - r13
        L_0x034f:
            r0.aE = r1
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            if (r1 == 0) goto L_0x0576
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$Ng6wUV0CWZVR_thGFq7yvbNJFS8 r2 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$Ng6wUV0CWZVR_thGFq7yvbNJFS8
            r2.<init>()
            goto L_0x02ff
        L_0x035b:
            java.lang.String r1 = "AMap"
            java.lang.String r2 = "onClick: ----view switch drone controller"
            android.util.Log.i(r1, r2)
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0576
            org.greenrobot.eventbus.c r1 = org.greenrobot.eventbus.c.a()
            jo.be r2 = new jo.be
            r2.<init>(r6)
            r1.d(r2)
            goto L_0x0576
        L_0x0378:
            boolean r1 = r0.P
            goto L_0x0576
        L_0x037c:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r0.E
            com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$wMjvIeyDSFPxsvH0EDwh12WjQD4 r13 = new com.xeagle.android.vjoystick.-$$Lambda$DroneControlFragment$wMjvIeyDSFPxsvH0EDwh12WjQD4
            r13.<init>()
            r1.postDelayed(r13, r9)
            en.a r1 = r0.bA
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x0392
            com.blankj.utilcode.util.ToastUtils.showShort((int) r12)
            return
        L_0x0392:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.xeagle.android.activities.FlightActionActivity r9 = r0.f12863ct
            java.lang.String r7 = r9.getString(r7)
            boolean r1 = r1.equals(r7)
            r7 = 8
            if (r1 == 0) goto L_0x03bd
            int r1 = r0.cQ
            if (r1 == r7) goto L_0x03bd
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            java.lang.String r1 = r1.getString(r4)
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r1)
            goto L_0x0576
        L_0x03bd:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.ListenerData r1 = r1.Q()
            com.xeagle.android.activities.FlightActionActivity r4 = r0.f12863ct
            java.lang.String r4 = r4.getString(r8)
            r1.e((java.lang.String) r4)
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x03fb
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x040a
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            java.lang.String r1 = r1.t()
            com.xeagle.android.utils.prefs.a r4 = r0.bB
            java.lang.String r4 = r4.t()
            int r3 = r4.lastIndexOf(r3)
            int r3 = r3 + r6
            java.lang.String r1 = r1.substring(r3)
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 < r2) goto L_0x03f5
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.y()
            goto L_0x040a
        L_0x03f5:
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.A()
            goto L_0x040a
        L_0x03fb:
            if (r1 != r15) goto L_0x040a
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r1 = r0.f12543d
            if (r1 == 0) goto L_0x040a
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r1 = r0.f12543d
            r2 = 2004(0x7d4, float:2.808E-42)
            java.lang.String r3 = "http://172.50.10.1:8082/"
            r1.getSdcardStatus(r3, r6, r2)
        L_0x040a:
            r1 = 200(0xc8, double:9.9E-322)
            android.os.SystemClock.sleep(r1)
            boolean r1 = f12789g
            java.lang.String r2 = "channel"
            r3 = 2131822812(0x7f1108dc, float:1.9278406E38)
            r4 = 2131823178(0x7f110a4a, float:1.9279148E38)
            if (r1 == 0) goto L_0x0483
            boolean r1 = r0.f12898h
            if (r1 == 0) goto L_0x0461
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.MAVLink.Messages.ApmModes r4 = com.MAVLink.Messages.ApmModes.ROTOR_TRACKER
            java.lang.String r4 = r4.b()
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x043d
            int r1 = r0.cQ
            if (r1 != r7) goto L_0x0559
        L_0x043d:
            com.xeagle.android.dialogs.d r1 = r0.aN
            if (r1 != 0) goto L_0x0458
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            java.lang.String r1 = r1.getString(r11)
            com.xeagle.android.activities.FlightActionActivity r4 = r0.f12863ct
            java.lang.String r3 = r4.getString(r3)
            com.xeagle.android.vjoystick.DroneControlFragment$20 r4 = new com.xeagle.android.vjoystick.DroneControlFragment$20
            r4.<init>()
            com.xeagle.android.dialogs.d r1 = com.xeagle.android.dialogs.d.a(r1, r3, r4)
            r0.aN = r1
        L_0x0458:
            com.xeagle.android.dialogs.d r1 = r0.aN
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0576
            goto L_0x04ce
        L_0x0461:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_TRACKER
            java.lang.String r2 = r2.b()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x047f
            int r1 = r0.cQ
            if (r1 != r7) goto L_0x0566
        L_0x047f:
            com.blankj.utilcode.util.ToastUtils.showShort((int) r4)
            return
        L_0x0483:
            boolean r1 = r0.f12899i
            if (r1 == 0) goto L_0x04d9
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.MAVLink.Messages.ApmModes r4 = com.MAVLink.Messages.ApmModes.ROTOR_TRACKER
            java.lang.String r4 = r4.b()
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x04ab
            int r1 = r0.cQ
            if (r1 != r7) goto L_0x04a6
            goto L_0x04ab
        L_0x04a6:
            r16.aa()
            goto L_0x055c
        L_0x04ab:
            com.xeagle.android.dialogs.d r1 = r0.aN
            if (r1 != 0) goto L_0x04c6
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            java.lang.String r1 = r1.getString(r11)
            com.xeagle.android.activities.FlightActionActivity r4 = r0.f12863ct
            java.lang.String r3 = r4.getString(r3)
            com.xeagle.android.vjoystick.DroneControlFragment$21 r4 = new com.xeagle.android.vjoystick.DroneControlFragment$21
            r4.<init>()
            com.xeagle.android.dialogs.d r1 = com.xeagle.android.dialogs.d.a(r1, r3, r4)
            r0.aN = r1
        L_0x04c6:
            com.xeagle.android.dialogs.d r1 = r0.aN
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x0576
        L_0x04ce:
            com.xeagle.android.dialogs.d r1 = r0.aN
            androidx.fragment.app.FragmentManager r3 = r16.getChildFragmentManager()
            r1.show(r3, r2)
            goto L_0x0576
        L_0x04d9:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.aa r1 = r1.d()
            com.MAVLink.Messages.ApmModes r1 = r1.e()
            java.lang.String r1 = r1.b()
            com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_TRACKER
            java.lang.String r2 = r2.b()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x04f7
            int r1 = r0.cQ
            if (r1 != r7) goto L_0x0566
        L_0x04f7:
            com.blankj.utilcode.util.ToastUtils.showShort((int) r4)
            return
        L_0x04fb:
            boolean r1 = r0.bJ
            if (r1 == 0) goto L_0x050f
            boolean r1 = f12789g
            if (r1 != 0) goto L_0x050f
            com.xeagle.android.activities.FlightActionActivity r1 = r0.f12863ct
            r4 = 2131822958(0x7f11096e, float:1.9278702E38)
            java.lang.String r1 = r1.getString(r4)
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r1)
        L_0x050f:
            en.a r1 = r0.bA
            com.flypro.core.drone.variables.ListenerData r1 = r1.Q()
            com.xeagle.android.activities.FlightActionActivity r4 = r0.f12863ct
            java.lang.String r4 = r4.getString(r8)
            r1.e((java.lang.String) r4)
            int r1 = r0.f12864cu
            if (r1 != r6) goto L_0x054c
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            if (r1 == 0) goto L_0x054c
            com.xeagle.android.utils.prefs.a r1 = r0.bB
            java.lang.String r1 = r1.t()
            com.xeagle.android.utils.prefs.a r4 = r0.bB
            java.lang.String r4 = r4.t()
            int r3 = r4.lastIndexOf(r3)
            int r3 = r3 + r6
            java.lang.String r1 = r1.substring(r3)
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 < r2) goto L_0x0547
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.y()
            goto L_0x054c
        L_0x0547:
            com.xeagle.android.newUI.cameraManager.AmbaClient r1 = r0.f12542c
            r1.A()
        L_0x054c:
            r1 = 200(0xc8, double:9.9E-322)
            android.os.SystemClock.sleep(r1)
            boolean r1 = f12789g
            if (r1 == 0) goto L_0x0576
            boolean r1 = r0.f12898h
            if (r1 == 0) goto L_0x0566
        L_0x0559:
            r16.Y()
        L_0x055c:
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.xeagle.android.a r1 = r1.m()
            r1.b((boolean) r5)
            goto L_0x0576
        L_0x0566:
            r16.X()
            com.xeagle.android.XEagleApp r1 = r0.f12540a
            com.xeagle.android.a r1 = r1.m()
            r1.b((boolean) r6)
            goto L_0x0576
        L_0x0573:
            r16.p()
        L_0x0576:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.onClick(android.view.View):void");
    }

    public void onDestroy() {
        super.onDestroy();
        x();
        this.f12540a.m().l(false);
        if (this.A != null) {
            this.A = null;
        }
        OrientationEventListener orientationEventListener = this.cJ;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        if (this.f12540a.c()) {
            j();
            XEagleApp.d().a((hb.a) null);
            ks.f.a().d();
        }
        a aVar = this.f12843bz;
        if (aVar != null) {
            aVar.b();
        }
        if (this.bY) {
            this.bY = false;
            if (this.bZ.size() > 0) {
                af();
                this.bZ.clear();
            }
        }
        this.bB.b(true);
        ad.a.a((Context) this.f12863ct).a(new Intent("switch_rc_gravity"));
        if (this.f12899i) {
            aa();
        }
        this.f12869cz = true;
        if (!this.f12540a.c()) {
            this.f12914z.onVideoPause();
        }
        if (this.bY) {
            this.bY = false;
            if (this.bZ.size() > 0) {
                af();
                SystemClock.sleep(500);
                this.bZ.clear();
            }
        }
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        a aVar2 = this.f12843bz;
        if (aVar2 != null) {
            aVar2.b();
            this.f12843bz = null;
        }
        this.dC = false;
        if (!this.f12540a.c()) {
            this.f12914z.release();
            if (this.f12540a.e() != null) {
                this.f12540a.e().a(f12791y);
            }
        }
        io.reactivex.disposables.b bVar = this.f12877dh;
        if (bVar != null) {
            bVar.dispose();
            this.f12877dh = null;
        }
        this.f12863ct.unregisterReceiver(this.f12872dc);
        JoyStickView joyStickView = this.B;
        if (joyStickView != null) {
            joyStickView.setStickMoveListener((JoyStickView.b) null);
            this.B = null;
            JoyStickView joyStickView2 = this.C;
            if (joyStickView2 != null) {
                joyStickView2.setStickMoveListener((JoyStickView.b) null);
                this.C = null;
                S();
                this.bC.removeCallbacksAndMessages((Object) null);
            }
        }
    }

    public boolean onLongClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.gimb_down) {
            this.aG = true;
            ak();
            return false;
        } else if (id2 != R.id.gimb_up) {
            return false;
        } else {
            this.aF = true;
            aj();
            return false;
        }
    }

    public void onPause() {
        super.onPause();
        if (this.bA.d().e().b().equalsIgnoreCase(ApmModes.ROTOR_TRACKER.b()) || this.cQ == 8) {
            O();
            ToastUtils.showLong((int) R.string.exit_tracker);
        }
        if (this.f12899i) {
            aa();
        }
        OrientationEventListener orientationEventListener = this.cJ;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
    }

    public void onResume() {
        int i2;
        IImageButton iImageButton;
        super.onResume();
        String str = f12791y;
        Log.d(str, "onResume");
        if (!org.opencv.android.h.a()) {
            Log.d(str, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            org.opencv.android.h.a("3.0.0", getContext(), new org.opencv.android.g() {
                public void a(int i2) {
                }

                public void a(int i2, org.opencv.android.f fVar) {
                }
            });
        }
        this.f12540a.m().c(false);
        this.bC.sendEmptyMessage(114);
        D();
        int i3 = this.f12864cu;
        if (i3 == 1) {
            if (this.bB.E() == 1 && this.D.getVisibility() == 0) {
                this.D.setVisibility(8);
                if (!f12789g || !this.bJ) {
                    this.cN.setVisibility(8);
                    this.cO.setVisibility(8);
                    this.E.setVisibility(0);
                } else {
                    this.cN.setVisibility(0);
                    this.cO.setVisibility(0);
                    this.E.setVisibility(4);
                }
                iImageButton = this.L;
                i2 = R.drawable.newui_switch_camera;
            } else {
                if (this.bB.E() == 2 && (this.E.getVisibility() == 0 || this.cN.getVisibility() == 0)) {
                    this.E.setVisibility(4);
                    this.cN.setVisibility(8);
                    this.cO.setVisibility(8);
                    this.D.setVisibility(0);
                    iImageButton = this.L;
                    i2 = R.drawable.newui_switch_video;
                }
                this.bC.sendEmptyMessage(128);
            }
            iImageButton.setImageResource(i2);
            this.bC.sendEmptyMessage(128);
        } else if (i3 == 2) {
            if (this.f12543d == null) {
                this.f12543d = this.f12540a.h();
            }
            if (this.f12869cz) {
                this.f12869cz = false;
                this.f12914z.onVideoPause();
                this.bC.sendEmptyMessage(128);
                Log.i("rtsp", "reset rtsp---4");
            }
            if (this.f12543d != null) {
                this.f12543d.getRecordStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_RECORD_STATUS);
            }
        }
        if (!this.bA.j().a()) {
            this.bA.j().a(18);
        }
        b(this.bA);
        this.bC.sendEmptyMessage(82);
        if (this.bA != null) {
            this.cM.put("CONTROL_FENCE_ENABLE", true);
            this.bA.e().a("FENCE_ENABLE");
        }
        TextView textView = this.aC;
        if (textView != null) {
            com.xeagle.android.utils.c.a(this.bA, "GIMB_VALUE", textView);
            this.aE = Double.parseDouble(this.aC.getText().toString());
        }
        r();
    }

    public void onStart() {
        c a2;
        super.onStart();
        Log.d(f12791y, "onStart");
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.bH = this.bB.i();
        if (this.bA.j().e() && this.bB.m() && (a2 = com.xeagle.android.dialogs.r.a().a(this.f12863ct.getString(R.string.dialog_tips), this.f12863ct.getString(R.string.fence_enable_tips), (c.a) new c.a() {
            public void onYes() {
            }
        })) != null) {
            a2.show(getChildFragmentManager(), "fence");
        }
        if (this.f12540a.c()) {
            q();
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Log.i("onSurfaceTexture", "onSurfaceTextureAvailable width:" + i2 + " ,height:" + i3);
        if (this.A != null) {
            this.f12874de = new Surface(this.A.getSurfaceTexture());
            this.f12861cr.a(this.bB.aD(), this.A.getMeasuredWidth(), this.A.getMeasuredHeight(), 0, 4);
        }
        if (this.f12878di) {
            Message message = new Message();
            message.what = 150;
            this.bC.sendMessage(message);
            this.f12878di = false;
        }
        O();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.e("onSurfaceTexture", "onSurfaceTextureDestroyed !!!");
        this.A.getSurfaceTexture().release();
        surfaceTexture.release();
        this.f12878di = true;
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        String str = f12791y;
        Log.i(str, "SurfaceTexture width:" + i2 + " ,height:" + i3);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onSwitchMode(as asVar) {
        this.bH = asVar.a();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onSwitchRcEvent(at atVar) {
        this.bG = atVar.a();
        a(atVar.a());
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onSystemRtlEvent(av avVar) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id2 = view.getId();
        if (id2 != R.id.gimb_down) {
            if (id2 == R.id.gimb_up && motionEvent.getAction() != 0 && motionEvent.getAction() != 2 && motionEvent.getAction() == 1) {
                this.aF = false;
            }
        } else if (!(motionEvent.getAction() == 0 || motionEvent.getAction() == 2 || motionEvent.getAction() != 1)) {
            this.aG = false;
        }
        return false;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void rcOutEvent(dy.av avVar) {
        if (avVar.a() == 18) {
            B();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rcRecordReusultEvent(ah ahVar) {
        c a2;
        if (!this.f12540a.m().b() && (a2 = com.xeagle.android.dialogs.r.a().a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.rc_record_warning), (c.a) new c.a() {
            public void onYes() {
            }
        })) != null) {
            a2.show(getChildFragmentManager(), "rc_record");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void reStartRtsp(jo.an anVar) {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (XEagleApp.d().f() != null) {
                    XEagleApp.d().f().b(2);
                }
            }
        });
    }

    @l(a = ThreadMode.ASYNC)
    public void receivHeartbeatEvent(ax axVar) {
        if (axVar.a() == 67 && !this.dR) {
            this.dR = true;
            com.flypro.core.MAVLink.b.a(this.bA, (byte) 99);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void recentAppsEvent(aj ajVar) {
        if (ajVar.a() && !this.bA.j().a()) {
            this.bA.j().a(17);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rtlCountDownEvent(dy.f fVar) {
        aa aaVar;
        String str;
        aa d2;
        FlightActionActivity flightActionActivity;
        int i2;
        byte b2 = fVar.a().f6594h;
        if (com.xeagle.android.utils.g.b(this.bB.j())) {
            this.f12819bb.setImageResource(fVar.a().g() ? R.drawable.ic_avoidance_open : R.drawable.ic_avoidance_select);
            this.f12819bb.setVisibility(0);
            if (!this.f12540a.m().o() && !fVar.a().g()) {
                this.f12540a.m().l(true);
                if ((fVar.a().f6595i & 1) == 1) {
                    d2 = this.bA.d();
                    flightActionActivity = this.f12863ct;
                    i2 = R.string.sport_no_avoid;
                } else {
                    byte[] a2 = ei.a.a(fVar.a().f6595i);
                    String format = String.format(Locale.US, "%d%d%d", new Object[]{Byte.valueOf(a2[3]), Byte.valueOf(a2[2]), Byte.valueOf(a2[1])});
                    ApmModes e2 = this.bA.d().e();
                    if (format.equalsIgnoreCase("001") || format.equalsIgnoreCase("010") || format.equalsIgnoreCase("011") || e2.equals(ApmModes.ROTOR_POSHOLD) || e2.equals(ApmModes.ROTOR_CIRCLE)) {
                        d2 = this.bA.d();
                        flightActionActivity = this.f12863ct;
                        i2 = R.string.model_no_avoid;
                    } else {
                        d2 = this.bA.d();
                        flightActionActivity = this.f12863ct;
                        i2 = R.string.normal_no_avoid;
                    }
                }
                d2.a(flightActionActivity.getString(i2));
                CommonUI.a((Context) this.f12863ct, getView(), this.f12863ct.getString(i2), 5, (CommonUI.e) null);
            }
        } else {
            this.f12819bb.setVisibility(8);
        }
        if (com.xeagle.android.utils.h.d(this.bA)) {
            com.cfly.customeui.widget.a aVar = this.cH;
            if (aVar != null || b2 <= 0 || b2 > 10) {
                if (b2 <= 0 || b2 > 10) {
                    if (aVar != null) {
                        aVar.a();
                        this.cH = null;
                    }
                    if (this.f12540a.m().m()) {
                        this.f12540a.m().k(false);
                        return;
                    }
                    return;
                } else if (fVar.a().b()) {
                    aaVar = this.bA.d();
                    str = String.format(Locale.US, this.f12863ct.getString(R.string.low_rtl_count), new Object[]{Integer.valueOf(b2)});
                } else {
                    aaVar = this.bA.d();
                    str = String.format(Locale.US, this.f12863ct.getString(R.string.low_land_count), new Object[]{Integer.valueOf(b2)});
                }
            } else if (this.f12540a.m().m()) {
                return;
            } else {
                if (fVar.a().b()) {
                    this.bA.d().a(String.format(Locale.US, this.f12863ct.getString(R.string.low_rtl_count), new Object[]{Integer.valueOf(b2)}));
                    d((int) b2);
                    return;
                }
                this.bA.d().a(String.format(Locale.US, this.f12863ct.getString(R.string.low_land_count), new Object[]{Integer.valueOf(b2)}));
                c((int) b2);
                return;
            }
        } else if (this.f12824bg.getVisibility() == 8 && b2 > 0 && b2 <= 10) {
            this.f12824bg.setVisibility(0);
            this.f12824bg.setText(String.format(Locale.US, this.f12863ct.getString(R.string.rth_execute_time), new Object[]{Integer.valueOf(b2)}));
            aaVar = this.bA.d();
            str = this.f12824bg.getText().toString();
        } else if (this.f12824bg.getVisibility() == 0) {
            TextView textView = this.f12824bg;
            if (b2 > 0) {
                textView.setText(String.format(Locale.US, this.f12863ct.getString(R.string.rth_execute_time), new Object[]{Integer.valueOf(b2)}));
                return;
            } else {
                textView.setVisibility(8);
                return;
            }
        } else {
            return;
        }
        aaVar.a(str);
    }

    @l(a = ThreadMode.MAIN)
    public void rtspConnectEvent(com.shuyu.gsyvideoplayer.d dVar) {
        this.dC = true;
        int i2 = this.f12864cu;
        if (i2 == 2) {
            if (this.f12543d != null) {
                this.f12543d.getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
            }
            if (this.cA) {
                this.bC.removeCallbacks(this.dB);
                this.cA = false;
            }
        } else if (i2 == 1 && this.f12542c != null) {
            if (Integer.parseInt(this.bB.t().substring(this.bB.t().lastIndexOf("_") + 1)) >= 2020121101) {
                this.f12542c.y();
            } else {
                this.f12542c.A();
            }
        }
        if (this.aO.getVisibility() == 0) {
            this.aO.setVisibility(8);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rtspDestoryViewEvent(com.shuyu.gsyvideoplayer.e eVar) {
        String str;
        if (eVar.a() && this.dC && this.bB.aI()) {
            this.dC = false;
            int i2 = this.f12864cu;
            if (i2 == 2) {
                this.bC.sendEmptyMessage(128);
                str = "reset rtsp---7";
            } else if (i2 == 1) {
                Log.i("rtsp", "rtspDestoryViewEvent: ----");
                if (this.aP.getVisibility() == 8) {
                    this.bC.sendEmptyMessage(148);
                }
                this.cB = 5;
                this.bC.sendEmptyMessage(128);
                str = "reset rtsp---8";
            } else {
                return;
            }
            Log.i("rtsp", str);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rtspDisconnect(com.shuyu.gsyvideoplayer.f fVar) {
        if (!this.cA) {
            this.cA = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r10 > 400) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        if (r10 > 400) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scaleImageEvent(jp.c r10) {
        /*
            r9 = this;
            float r10 = r10.a()
            r9.f12891dw = r10
            int r10 = r9.f12864cu
            r0 = 1
            if (r10 != r0) goto L_0x00a2
            com.xeagle.android.utils.prefs.a r10 = r9.bB
            java.lang.String r10 = r10.t()
            com.xeagle.android.utils.prefs.a r1 = r9.bB
            java.lang.String r1 = r1.t()
            java.lang.String r2 = "_"
            int r1 = r1.lastIndexOf(r2)
            int r1 = r1 + r0
            java.lang.String r10 = r10.substring(r1)
            int r10 = java.lang.Integer.parseInt(r10)
            r1 = 2021040101(0x78769fe5, float:2.0008564E34)
            if (r10 < r1) goto L_0x00f5
            com.xeagle.android.vjoystick.VerticalSeekBar r10 = r9.f12821bd
            int r10 = r10.getProgress()
            int r10 = r10 * 8
            r1 = 0
            r2 = 1090519040(0x41000000, float:8.0)
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 400(0x190, float:5.6E-43)
            float r5 = r9.f12891dw
            if (r10 != 0) goto L_0x004a
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0060
            float r10 = (float) r10
            float r5 = r5 * r2
            float r10 = r10 + r5
            int r10 = (int) r10
            if (r10 <= r4) goto L_0x0060
            goto L_0x0055
        L_0x004a:
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            float r10 = (float) r10
            if (r6 <= 0) goto L_0x0058
            float r5 = r5 * r2
            float r10 = r10 + r5
            int r10 = (int) r10
            if (r10 <= r4) goto L_0x0060
        L_0x0055:
            r10 = 400(0x190, float:5.6E-43)
            goto L_0x0060
        L_0x0058:
            float r3 = r3 / r5
            float r3 = r3 * r2
            float r10 = r10 - r3
            int r10 = (int) r10
            if (r10 >= 0) goto L_0x0060
            r10 = 0
        L_0x0060:
            com.xeagle.android.vjoystick.VerticalSeekBar r2 = r9.f12821bd
            int r3 = r10 / 8
            r2.setProgress(r3)
            java.lang.String r2 = "%.1f X"
            if (r3 != 0) goto L_0x007e
            android.widget.TextView r3 = r9.f12820bc
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r5 = 0
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r0[r1] = r5
            java.lang.String r0 = java.lang.String.format(r4, r2, r0)
            goto L_0x0095
        L_0x007e:
            android.widget.TextView r3 = r9.f12820bc
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r0 = new java.lang.Object[r0]
            double r5 = (double) r10
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r0[r1] = r5
            java.lang.String r0 = java.lang.String.format(r4, r2, r0)
        L_0x0095:
            r3.setText(r0)
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r9.f12542c
            if (r0 == 0) goto L_0x00f5
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r9.f12542c
            r0.a((int) r10)
            goto L_0x00f5
        L_0x00a2:
            r0 = 2
            if (r10 != r0) goto L_0x00f5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "scaleImageEvent:--scale-- "
            r10.append(r0)
            float r0 = r9.f12891dw
            r10.append(r0)
            java.lang.String r0 = "--width--"
            r10.append(r0)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r0 = r9.f12914z
            int r0 = r0.getWidth()
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "Sochip"
            android.util.Log.i(r0, r10)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r10 = r9.f12914z
            android.graphics.Matrix r10 = r10.getVideoTransform()
            if (r10 == 0) goto L_0x00f5
            com.xeagle.android.login.gsy.video.EmptyControlVideo r10 = r9.f12914z
            android.graphics.Matrix r10 = r10.getVideoTransform()
            r9.f12892dx = r10
            android.graphics.Matrix r0 = r9.f12893dy
            r0.set(r10)
            android.graphics.Matrix r10 = r9.f12893dy
            float r0 = r9.f12891dw
            r10.postScale(r0, r0)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r10 = r9.f12914z
            android.graphics.Matrix r0 = r9.f12893dy
            r10.setVideoTransform(r0)
            com.xeagle.android.login.gsy.video.EmptyControlVideo r10 = r9.f12914z
            float r0 = r9.f12891dw
            r10.adjustVideoView(r0)
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.scaleImageEvent(jp.c):void");
    }

    @l(a = ThreadMode.MAIN)
    public void socErrorEvent(jp.d dVar) {
        Log.i("rtsp", "regError:---type--- " + dVar.a() + "---error---" + dVar.b());
    }

    @l(a = ThreadMode.MAIN)
    public void socFailureEvent(jp.e eVar) {
    }

    @l(a = ThreadMode.MAIN)
    public void socSuccessEvent(jp.f fVar) {
        if (fVar.b() instanceof SochipStatusBean) {
            SochipStatusBean sochipStatusBean = (SochipStatusBean) fVar.b();
            List asList = Arrays.asList(this.f12863ct.getResources().getStringArray(R.array.ev_value_sochip_no));
            List asList2 = Arrays.asList(this.f12863ct.getResources().getStringArray(R.array.video_resolution_sochip_no));
            this.aY.setText(String.format(Locale.US, "%s", new Object[]{asList.get(sochipStatusBean.getInfo().get(3).getStatus())}));
            this.aX.setText(String.format(Locale.US, "%s", new Object[]{asList2.get(sochipStatusBean.getInfo().get(0).getStatus())}));
            return;
        }
        int a2 = fVar.a();
        if (a2 == 1013) {
            x xVar = this.aI;
            if (xVar != null) {
                xVar.dismiss();
            }
            if (this.f12543d != null) {
                this.f12543d.getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
            }
        } else if (a2 == 1100 || a2 == 1101 || a2 == 3005 || a2 == 3006) {
            CmdListener cmdListener = (CmdListener) fVar.b();
            Log.i("Sochip", "regSuccess: ---cmd--" + cmdListener.getCmd() + "---value--" + cmdListener.getValue());
        } else {
            switch (a2) {
                case CameraGlobal.GET_VERSION /*2001*/:
                    SochipVersionBean sochipVersionBean = (SochipVersionBean) fVar.b();
                    if (sochipVersionBean != null && sochipVersionBean.getVersion() != null) {
                        Log.i("Sochip", "socSuccess:--version--- " + sochipVersionBean.getVersion());
                        this.bB.g(sochipVersionBean.getVersion());
                        return;
                    }
                    return;
                case CameraGlobal.GET_DEVICE_INFO /*2002*/:
                    SochipInfoStatus sochipInfoStatus = (SochipInfoStatus) fVar.b();
                    return;
                case CameraGlobal.GET_RECORD_TIME /*2003*/:
                    SochipRecordTimeBean sochipRecordTimeBean = (SochipRecordTimeBean) fVar.b();
                    if (sochipRecordTimeBean != null && sochipRecordTimeBean.getRecodTime() > 0) {
                        this.f12898h = true;
                        int recodTime = sochipRecordTimeBean.getRecodTime();
                        Message message = new Message();
                        message.what = 117;
                        Bundle bundle = new Bundle();
                        bundle.putInt("recordTime", recodTime);
                        message.setData(bundle);
                        this.bC.sendMessage(message);
                        return;
                    }
                    return;
                case CameraGlobal.GET_SDCARD_STATUS /*2004*/:
                    SochipSdcardBean sochipSdcardBean = (SochipSdcardBean) fVar.b();
                    if (sochipSdcardBean != null) {
                        Log.i("Sochip", "socSuccess: ----sdcard---" + sochipSdcardBean.getDisk_status());
                        if (sochipSdcardBean.getDisk_status() == 0) {
                            f12789g = true;
                            this.f12867cx = ((float) sochipSdcardBean.getCapacity()) / 1024.0f;
                            float free_space = ((float) sochipSdcardBean.getFree_space()) / 1024.0f;
                            this.f12868cy = free_space;
                            if (((double) free_space) <= 0.4d) {
                                this.bC.sendEmptyMessage(IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL);
                            }
                            this.f12818ba.setText(String.format(Locale.US, "%.1fGB", new Object[]{Float.valueOf(this.f12868cy)}));
                            if (this.bB.aH()) {
                                com.flypro.core.MAVLink.b.a(this.bA, (byte) 77);
                                return;
                            }
                            return;
                        }
                        f12789g = false;
                        if (sochipSdcardBean.getDisk_status() == 3) {
                            d.a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.error_sd_unformat), new d.a() {
                                public void onNo() {
                                }

                                public void onYes() {
                                    if (DroneControlFragment.this.f12543d != null) {
                                        DroneControlFragment.this.f12543d.setCmdAndInt(CameraGlobal.BASE_URL, 1, CameraGlobal.SET_FORMAT_SDCARD, 0);
                                    }
                                }
                            }).show(getChildFragmentManager(), IjkMediaMeta.IJKM_KEY_FORMAT);
                            return;
                        } else if (sochipSdcardBean.getDisk_status() == 1) {
                            if (this.f12911u != 1) {
                                this.f12911u = 1;
                                com.xeagle.android.dialogs.r.a().a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.sd_not_mounted), (c.a) new c.a() {
                                    public void onYes() {
                                    }
                                }).show(getChildFragmentManager(), "unload");
                                return;
                            }
                            return;
                        } else if (sochipSdcardBean.getDisk_status() == 2) {
                            x a3 = x.a(this.f12863ct.getString(R.string.warning), this.f12863ct.getString(R.string.sd_format_ing));
                            this.aI = a3;
                            a3.show(getChildFragmentManager(), "formatShow");
                            this.bC.postDelayed(new Runnable() {
                                public final void run() {
                                    DroneControlFragment.this.an();
                                }
                            }, 6000);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case CameraGlobal.GET_RECORD_STATUS /*2005*/:
                    SochipRecordStatusBean sochipRecordStatusBean = (SochipRecordStatusBean) fVar.b();
                    if (sochipRecordStatusBean != null && sochipRecordStatusBean.getRecodStatus() == 1) {
                        if (this.f12543d != null) {
                            this.f12543d.getRecordTime(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_RECORD_TIME);
                        }
                        if (this.bB.E() == 2) {
                            this.bB.h(1);
                            this.bC.sendEmptyMessage(116);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0129, code lost:
        if (r6.f12899i != false) goto L_0x012b;
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sochipTcpEvent(jp.g r7) {
        /*
            r6 = this;
            int r0 = r7.a()
            r1 = 2004(0x7d4, float:2.808E-42)
            r2 = -1
            r3 = 2
            java.lang.String r4 = "Sochip"
            r5 = 1
            if (r0 == r5) goto L_0x00c6
            if (r0 == r3) goto L_0x0099
            r1 = 3
            if (r0 == r1) goto L_0x0044
            r1 = 4
            if (r0 == r1) goto L_0x0025
            r1 = 5
            if (r0 == r1) goto L_0x001a
            goto L_0x012f
        L_0x001a:
            java.lang.Object r7 = r7.b()
            java.lang.Integer r7 = (java.lang.Integer) r7
            r7.intValue()
            goto L_0x012f
        L_0x0025:
            java.lang.Object r7 = r7.b()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x012f
            en.a r7 = r6.bA
            com.flypro.core.MAVLink.a$a r7 = r7.j()
            r7.d()
            r0 = 200(0xc8, double:9.9E-322)
            android.os.SystemClock.sleep(r0)
            r6.f()
            goto L_0x012f
        L_0x0044:
            com.xeagle.android.utils.prefs.a r0 = r6.bB
            int r0 = r0.E()
            if (r0 != r5) goto L_0x0069
            boolean r0 = r6.f12899i
            if (r0 != 0) goto L_0x005e
            boolean r0 = r6.f12898h
            if (r0 != 0) goto L_0x005e
            com.xeagle.android.utils.prefs.a r0 = r6.bB
            r0.h((int) r3)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r6.bC
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x0066
        L_0x005e:
            boolean r0 = r6.f12898h
            if (r0 == 0) goto L_0x0069
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r6.bC
            r1 = 130(0x82, float:1.82E-43)
        L_0x0066:
            r0.sendEmptyMessage(r1)
        L_0x0069:
            java.lang.Object r7 = r7.b()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != r2) goto L_0x007a
            boolean r0 = f12789g
            if (r0 != 0) goto L_0x007a
            goto L_0x0094
        L_0x007a:
            if (r7 != r5) goto L_0x0094
            ch.b r7 = r6.bF
            r7.a()
            com.xeagle.android.vjoystick.DroneControlFragment$a r7 = r6.bC
            r0 = 129(0x81, float:1.81E-43)
            r7.sendEmptyMessage(r0)
            com.xeagle.android.activities.FlightActionActivity r7 = r6.f12863ct
            r0 = 2131822823(0x7f1108e7, float:1.9278428E38)
            java.lang.String r7 = r7.getString(r0)
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.CharSequence) r7)
        L_0x0094:
            r6.T()
            goto L_0x012f
        L_0x0099:
            java.lang.Object r7 = r7.b()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x00b3
            java.lang.String r7 = "onTcpListener: ----卡拔出"
            android.util.Log.i(r4, r7)
            com.xeagle.android.vjoystick.DroneControlFragment$a r7 = r6.bC
            r0 = 118(0x76, float:1.65E-43)
        L_0x00ae:
            r7.sendEmptyMessage(r0)
            goto L_0x012f
        L_0x00b3:
            java.lang.String r7 = "onTcpListener: ----卡插入"
            android.util.Log.i(r4, r7)
            f12789g = r5
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r7 = r6.f12543d
            if (r7 == 0) goto L_0x012f
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r7 = r6.f12543d
            java.lang.String r0 = "rtsp://172.50.10.1:8554/ch01"
            r7.getSdcardStatus(r0, r5, r1)
            goto L_0x012f
        L_0x00c6:
            com.xeagle.android.utils.prefs.a r0 = r6.bB
            int r0 = r0.E()
            if (r0 != r3) goto L_0x00da
            com.xeagle.android.utils.prefs.a r0 = r6.bB
            r0.h((int) r5)
            com.xeagle.android.vjoystick.DroneControlFragment$a r0 = r6.bC
            r3 = 116(0x74, float:1.63E-43)
            r0.sendEmptyMessage(r3)
        L_0x00da:
            java.lang.Object r7 = r7.b()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0 = 19
            r3 = 0
            if (r7 != 0) goto L_0x0102
            java.lang.String r7 = "onTcpListener:----录像停止 "
            android.util.Log.i(r4, r7)
            boolean r7 = f12789g
            if (r7 == 0) goto L_0x012b
            r6.f12898h = r3
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r7 = r6.f12543d
            if (r7 == 0) goto L_0x00ff
            com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter r7 = r6.f12543d
            java.lang.String r2 = "http://172.50.10.1:8082/"
            r7.getSdcardStatus(r2, r5, r1)
        L_0x00ff:
            com.xeagle.android.vjoystick.DroneControlFragment$a r7 = r6.bC
            goto L_0x00ae
        L_0x0102:
            r1 = 17
            if (r7 != r5) goto L_0x0121
            java.lang.String r7 = "onTcpListener:----录像开始 "
            android.util.Log.i(r4, r7)
            boolean r7 = f12789g
            if (r7 == 0) goto L_0x0117
            r6.f12898h = r5
        L_0x0111:
            com.xeagle.android.vjoystick.DroneControlFragment$a r7 = r6.bC
            r7.sendEmptyMessage(r1)
            goto L_0x012f
        L_0x0117:
            r6.f12898h = r3
            boolean r7 = r6.f12899i
            if (r7 != 0) goto L_0x012f
        L_0x011d:
            r6.Z()
            goto L_0x0111
        L_0x0121:
            if (r7 != r2) goto L_0x012f
            boolean r7 = f12789g
            if (r7 != 0) goto L_0x012f
            boolean r7 = r6.f12899i
            if (r7 == 0) goto L_0x011d
        L_0x012b:
            r6.aa()
            goto L_0x00ff
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.sochipTcpEvent(jp.g):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b8, code lost:
        if (r12.Q != 2) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f1, code lost:
        if (r12.Q != 1) goto L_0x00ad;
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sonarEvent(dy.ba r13) {
        /*
            r12 = this;
            com.xeagle.android.XEagleApp r0 = r12.f12540a
            boolean r0 = r0.c()
            r1 = 4621819117588971520(0x4024000000000000, double:10.0)
            java.lang.String r3 = "%.1f°"
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x002a
            android.widget.TextView r0 = r12.aZ
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r8 = r13.a()
            short r8 = r8.f7259d
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r1
            java.lang.Double r1 = java.lang.Double.valueOf(r8)
            r7[r4] = r1
            java.lang.String r1 = java.lang.String.format(r6, r3, r7)
            goto L_0x0049
        L_0x002a:
            android.widget.TextView r0 = r12.aZ
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r8 = r13.a()
            short r8 = r8.f7259d
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r1
            double r1 = java.lang.Math.abs(r8)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r7[r4] = r1
            java.lang.String r1 = java.lang.String.format(r6, r3, r7)
        L_0x0049:
            r0.setText(r1)
            en.a r0 = r12.bA
            boolean r0 = com.xeagle.android.utils.h.b((en.a) r0)
            if (r0 == 0) goto L_0x012e
            en.a r0 = r12.bA
            com.flypro.core.drone.variables.j r0 = r0.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x012e
            com.flypro.core.util.a r0 = com.flypro.core.util.a.a()
            double r0 = r0.c()
            r12.f12860cq = r0
            int r0 = r12.f12864cu
            if (r0 != r5) goto L_0x00f4
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            if (r0 == 0) goto L_0x00f4
            com.xeagle.android.XEagleApp r0 = r12.f12540a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x007c
            goto L_0x00f4
        L_0x007c:
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            java.lang.String r0 = r0.t()
            java.lang.String r1 = "vC"
            boolean r0 = r0.contains(r1)
            java.lang.String r1 = "1M"
            java.lang.String r2 = "2M"
            r3 = 2
            if (r0 != 0) goto L_0x00bb
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            java.lang.String r0 = r0.t()
            java.lang.String r6 = "vA1.0.1_2021092801"
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x009e
            goto L_0x00bb
        L_0x009e:
            double r6 = r12.f12860cq
            r8 = 4648488871632306176(0x4082c00000000000, double:600.0)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b2
            int r0 = r12.Q
            if (r0 == r5) goto L_0x00b2
        L_0x00ad:
            r12.Q = r5
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            goto L_0x00e7
        L_0x00b2:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f4
            int r0 = r12.Q
            if (r0 == r3) goto L_0x00f4
            goto L_0x00d0
        L_0x00bb:
            double r6 = r12.f12860cq
            r8 = 4656510908468559872(0x409f400000000000, double:2000.0)
            r10 = 4650248090236747776(0x4089000000000000, double:800.0)
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d8
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x00d8
            int r0 = r12.Q
            if (r0 == r3) goto L_0x00d8
        L_0x00d0:
            r12.Q = r3
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            r0.g(r2)
            goto L_0x00f4
        L_0x00d8:
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x00eb
            int r0 = r12.Q
            r2 = 4
            if (r0 == r2) goto L_0x00eb
            r12.Q = r2
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r12.f12542c
            java.lang.String r1 = "4M"
        L_0x00e7:
            r0.g(r1)
            goto L_0x00f4
        L_0x00eb:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f4
            int r0 = r12.Q
            if (r0 == r5) goto L_0x00f4
            goto L_0x00ad
        L_0x00f4:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r1 = new java.lang.Object[r5]
            double r2 = r12.f12860cq
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r1[r4] = r2
            java.lang.String r2 = "D: %.1f"
            java.lang.String r0 = java.lang.String.format(r0, r2, r1)
            en.a r1 = r12.bA
            com.flypro.core.drone.variables.j r1 = r1.b()
            int r1 = r1.d()
            r2 = 6
            if (r1 > r2) goto L_0x0122
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            jo.p r1 = new jo.p
            java.lang.String r2 = "D: 0.0"
            r1.<init>(r2)
            r0.d(r1)
            goto L_0x012e
        L_0x0122:
            org.greenrobot.eventbus.c r1 = org.greenrobot.eventbus.c.a()
            jo.p r2 = new jo.p
            r2.<init>(r0)
            r1.d(r2)
        L_0x012e:
            com.xeagle.android.utils.prefs.a r0 = r12.bB
            boolean r0 = r0.aH()
            if (r0 != 0) goto L_0x0137
            return
        L_0x0137:
            android.widget.TextView r0 = r12.f12795ad
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7259d
            float r3 = (float) r3
            r6 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 / r6
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "bat_alt: %.1f"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12796ae
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7260e
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "bat_vel: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12797af
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7261f
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "bat_dest: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12798ag
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7262g
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "bat_status: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12799ah
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7263h
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "sonar_alt: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12800ai
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7264i
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "sonar_vel: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12801aj
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7265j
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "sonar_dest: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            android.widget.TextView r0 = r12.f12802ak
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.MAVLink.common.msg_sonar_dug r3 = r13.a()
            short r3 = r3.f7266k
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r2[r4] = r3
            java.lang.String r3 = "sonar_offset: %3d"
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            r0.setText(r1)
            com.MAVLink.common.msg_sonar_dug r0 = r13.a()
            short r0 = r0.f7259d
            float r2 = (float) r0
            com.MAVLink.common.msg_sonar_dug r0 = r13.a()
            short r0 = r0.f7260e
            float r3 = (float) r0
            com.MAVLink.common.msg_sonar_dug r0 = r13.a()
            short r0 = r0.f7261f
            float r4 = (float) r0
            com.MAVLink.common.msg_sonar_dug r0 = r13.a()
            short r0 = r0.f7263h
            float r5 = (float) r0
            com.MAVLink.common.msg_sonar_dug r0 = r13.a()
            short r0 = r0.f7264i
            float r6 = (float) r0
            com.MAVLink.common.msg_sonar_dug r13 = r13.a()
            short r13 = r13.f7265j
            float r7 = (float) r13
            r1 = r12
            r1.a(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.DroneControlFragment.sonarEvent(dy.ba):void");
    }

    @l(a = ThreadMode.MAIN)
    public void startDrone(am amVar) {
        if (amVar.a()) {
            this.f12540a.f().d(2);
        } else {
            this.f12540a.f().b(2183);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void stateEvent(y yVar) {
        yVar.a();
    }

    @l(a = ThreadMode.MAIN)
    public void storageCover(ap apVar) {
        IButton iButton;
        String str;
        if (apVar.a()) {
            this.P = true;
            iButton = this.O;
            str = "覆盖";
        } else {
            this.P = false;
            iButton = this.O;
            str = "不覆盖";
        }
        iButton.setText(str);
    }

    @l(a = ThreadMode.MAIN)
    public void storageFormatEvent(aq aqVar) {
        int i2;
        if (aqVar.a() == 0) {
            x a2 = x.a(getString(R.string.menu_wait), getString(R.string.sd_format_ing));
            this.dD = a2;
            if (a2 != null) {
                a2.show(getChildFragmentManager(), "show_progress");
                return;
            }
            return;
        }
        if (aqVar.a() == 1) {
            x xVar = this.dD;
            if (xVar != null) {
                xVar.dismiss();
            }
            i2 = R.string.sd_format_succeed;
        } else if (aqVar.a() == 2) {
            x xVar2 = this.dD;
            if (xVar2 != null) {
                xVar2.dismiss();
            }
            i2 = R.string.sd_format_failed;
        } else if (aqVar.a() == 3) {
            i2 = R.string.sd_unknown_format;
        } else {
            return;
        }
        c(getString(i2));
    }

    @l(a = ThreadMode.MAIN)
    public void switchMapEvent(ar arVar) {
        Log.i(Promotion.ACTION_VIEW, "switchMapEvent:drone control ---->>>" + arVar.a());
        b(2);
    }

    @l(a = ThreadMode.BACKGROUND)
    public void switchWifiChannelEvent(jo.au auVar) {
        if (this.f12864cu == 1 && this.f12542c != null) {
            this.dU = true;
            this.f12542c.n("sw_version");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void tcpErrorListener(ay ayVar) {
        int i2 = this.f12864cu;
        if (i2 == 2) {
            if (this.f12543d != null) {
                this.f12543d.startSession(this.f12863ct.getApplicationContext());
                this.f12543d.getRecordStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_RECORD_STATUS);
            }
            this.cB = 2;
            this.bA.j().d();
            if (!this.cA) {
                Log.i("Sochip", "tcpErrorListener:----rtsp disconnect... ");
                return;
            }
            Log.i("Sochip", "tcpErrorListener: ----drone control");
            this.bC.sendEmptyMessageDelayed(128, 200);
            Log.i("rtsp", "reset rtsp---3");
        } else if (i2 == 1) {
            AmbaClient ambaClient = this.f12542c;
            this.cB = 2;
            this.bA.j().d();
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void tcpReadResetEvent(az azVar) {
        this.cA = true;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void tcpSuccessEvent(jo.ax axVar) {
        Log.i(f12791y, "tcpSuccessEvent: ==============");
        this.f12863ct.runOnUiThread(new Runnable() {
            public final void run() {
                DroneControlFragment.this.aM();
            }
        });
        if (axVar.a() == 1) {
            if (this.f12540a.g() != null) {
                this.bA.j().d();
            }
        } else if (axVar.a() == 2) {
            if (this.f12540a.h() != null) {
                this.f12540a.h().startSession(this.f12863ct.getApplicationContext());
            }
            a(System.currentTimeMillis());
        }
        this.cB = 2;
    }

    @l(a = ThreadMode.MAIN)
    public void trackerEvent(ba baVar) {
        String str = f12791y;
        Log.i(str, "==> onTrackerError trackerEvent = " + baVar.a());
        if (!baVar.a().isEmpty()) {
            this.cY = baVar.a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void trackerModelEvent(ad adVar) {
        boolean equalsIgnoreCase = adVar.a().equalsIgnoreCase(ApmModes.ROTOR_TRACKER.b());
        this.cR = equalsIgnoreCase;
        if (equalsIgnoreCase && this.cS != VisionModeStatus.RUN) {
            this.cT = 0;
            this.bC.removeCallbacks(this.f12882dm);
            a(VisionModeStatus.RUN);
            this.f12884dp.a();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void updateImuEvent(dy.bc bcVar) {
        if (bcVar.a() == 60) {
            g(this.bA);
            if (this.f12857cn) {
                if (this.dS != 6) {
                    if (Math.abs(this.bA.I().d()) > 8 || Math.abs(this.bA.I().e()) > 8 || Math.abs(this.bA.I().f()) > 8) {
                        this.dS = 0;
                    } else {
                        this.dS++;
                    }
                }
                if (this.dT == 6) {
                    return;
                }
                if (Math.abs(this.bA.I().g()) > 500 || Math.abs(this.bA.I().h()) > 500 || Math.abs(this.bA.I().i()) > 500) {
                    this.dT = 0;
                } else {
                    this.dT++;
                }
            } else {
                if (this.dS == 6) {
                    if (!this.bA.P().c()) {
                        this.bA.P().c(true);
                    }
                } else if (this.bA.P().c()) {
                    this.bA.P().c(false);
                }
                if (this.dT == 6) {
                    if (!this.bA.P().b()) {
                        this.bA.P().b(true);
                    }
                } else if (this.bA.P().b()) {
                    this.bA.P().b(false);
                }
            }
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void updatePressureEvent(v vVar) {
        com.flypro.core.drone.a aVar;
        boolean z2;
        if (vVar.a() < 96000 || vVar.a() > 106000) {
            aVar = this.bA.P();
            z2 = false;
        } else {
            aVar = this.bA.P();
            z2 = true;
        }
        aVar.a(z2);
    }

    @l(a = ThreadMode.MAIN)
    public void wifiLinkState(bg bgVar) {
        Log.i("version", "wifiLinkState:---- " + bgVar.a());
        if (!bgVar.a() && this.aA != null && this.f12540a.a() != null) {
            this.dQ = false;
            TextView textView = this.aA;
            textView.setText("Current wifi:" + this.f12540a.a().i());
            this.bA.a("null");
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void yawChangeEvent(bf bfVar) {
        if (bfVar.a() == 58) {
            ae();
        }
    }
}
