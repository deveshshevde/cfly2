package com.xeagle.android.vjoystick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.MAVLink.Messages.ApmModes;
import com.MAVLink.common.msg_rc_channels_override;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.ab;
import com.flypro.core.util.d;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.utils.aa;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.utils.b;
import ea.g;
import en.a;
import java.util.List;
import java.util.Locale;

public class RecordViewActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    double[] f24819a = new double[35];
    @BindView(2131296418)
    TextView altRc;

    /* renamed from: b  reason: collision with root package name */
    double[] f24820b = new double[5];

    /* renamed from: c  reason: collision with root package name */
    boolean f24821c = false;
    @BindView(2131297003)
    TextView distanceRc;
    @BindView(2131297161)
    TextView failSafeTv;

    /* renamed from: k  reason: collision with root package name */
    int f24822k;

    /* renamed from: l  reason: collision with root package name */
    private a f24823l;

    /* renamed from: m  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f24824m;

    /* renamed from: n  reason: collision with root package name */
    private kd.a f24825n;

    /* renamed from: o  reason: collision with root package name */
    private aa f24826o;

    /* renamed from: p  reason: collision with root package name */
    private ab f24827p;

    /* renamed from: q  reason: collision with root package name */
    private g f24828q;

    /* renamed from: r  reason: collision with root package name */
    private String f24829r;
    @BindView(2131298531)
    TextView recordProgressTv;
    @BindView(2131298539)
    IImageButton recordViewBack;
    @BindView(2131298540)
    ProgressBar recordViewProgress;
    @BindView(2131298541)
    IImageButton recordViewStart;

    /* renamed from: s  reason: collision with root package name */
    private boolean f24830s;
    @BindView(2131299063)
    GLSurfaceView surface;

    /* renamed from: t  reason: collision with root package name */
    private int f24831t;
    @BindView(2131299343)
    TextView tvBattery;
    @BindView(2131299410)
    TextView tvGps;

    /* renamed from: u  reason: collision with root package name */
    private boolean f24832u = true;

    /* renamed from: v  reason: collision with root package name */
    private Handler f24833v = new Handler();

    /* renamed from: w  reason: collision with root package name */
    private long[] f24834w = {1000, 100, 1000, 200};

    /* renamed from: x  reason: collision with root package name */
    private Runnable f24835x = new Runnable() {
        public void run() {
            RecordViewActivity.this.e();
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private Runnable f24836y = new Runnable() {
        public void run() {
            RecordViewActivity.this.k();
        }
    };

    /* renamed from: z  reason: collision with root package name */
    private Runnable f24837z = new Runnable() {
        public void run() {
            RecordViewActivity.this.l();
        }
    };

    /* renamed from: com.xeagle.android.vjoystick.RecordViewActivity$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24841a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24841a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ATTITUDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.SPEED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_COUNT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_FIX     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.PLAY_PROGRESS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f24841a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.PLAY_END     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.RecordViewActivity.AnonymousClass4.<clinit>():void");
        }
    }

    private void a() {
        if (!this.f24830s) {
            Toast.makeText(this, R.string.record_data_error, 1).show();
            return;
        }
        this.f24827p.b();
        this.f24827p.a(this.f24829r);
        this.f24827p.a(true);
        this.recordViewStart.setImageResource(R.drawable.record_view_stop);
    }

    private void b() {
        this.surface.getHolder().setFormat(-3);
    }

    private void b(a aVar) {
        String str;
        if (aVar == null) {
            this.tvGps.setText("--");
            return;
        }
        String e2 = aVar.b().e();
        int hashCode = e2.hashCode();
        if (hashCode == 1618) {
            str = "2D";
        } else if (hashCode != 1649) {
            if (hashCode == 75412084) {
                str = "NoFix";
            }
            this.tvGps.setText(String.format(Locale.ENGLISH, "GPS %d", new Object[]{Integer.valueOf(aVar.b().d())}));
        } else {
            str = "3D";
        }
        boolean equals = e2.equals(str);
        this.tvGps.setText(String.format(Locale.ENGLISH, "GPS %d", new Object[]{Integer.valueOf(aVar.b().d())}));
    }

    private void c(a aVar) {
        this.altRc.setText(String.format("H:%3.1f", new Object[]{Double.valueOf(aVar.t().a())}));
    }

    private void d() {
    }

    private void d(a aVar) {
        if (aVar != null && aVar.b().a()) {
            Location c2 = this.f24825n.c();
            if (c2 != null) {
                String format = String.format("D:%s", new Object[]{eg.a.c(new ef.a(c2.getLatitude(), c2.getLongitude()), aVar.b().b())});
                if (aVar.b().d() != 0) {
                    this.distanceRc.setText(format);
                    return;
                }
            } else {
                return;
            }
        }
        this.distanceRc.setText("D:0.0");
    }

    /* access modifiers changed from: private */
    public void e() {
        int i2;
        int i3 = this.f24822k;
        if (i3 <= 10 || i3 > 20) {
            if (i3 >= 0 && i3 <= 10) {
                i2 = R.string.battery_warn_10;
            }
            this.f24833v.postDelayed(this.f24835x, 3000);
        }
        i2 = R.string.battery_warn;
        Toast makeText = Toast.makeText(this, i2, 0);
        makeText.setGravity(48, 0, 46);
        makeText.show();
        this.f24833v.postDelayed(this.f24835x, 3000);
    }

    private void e(a aVar) {
        f(aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(en.a r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            if (r17 == 0) goto L_0x01ae
            com.flypro.core.drone.variables.b r2 = r17.o()
            if (r2 != 0) goto L_0x000d
            goto L_0x01ae
        L_0x000d:
            com.flypro.core.drone.variables.b r2 = r17.o()
            double r2 = r2.a()
            double[] r4 = r0.f24819a
            double r2 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4)
            com.flypro.core.drone.variables.aa r4 = r17.d()
            boolean r4 = r4.c()
            r8 = 40
            r9 = 2131230836(0x7f080074, float:1.8077736E38)
            r10 = 60
            r11 = 2131230837(0x7f080075, float:1.8077738E38)
            r12 = 80
            r13 = 2131230839(0x7f080077, float:1.8077742E38)
            r14 = 100
            r15 = 2131230831(0x7f08006f, float:1.8077726E38)
            r5 = 20
            if (r4 != 0) goto L_0x0097
            double[] r4 = r0.f24820b
            r6 = 4665545595513995264(0x40bf590000000000, double:8025.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x0049
            goto L_0x00a4
        L_0x0049:
            double[] r4 = r0.f24820b
            r6 = 4665243229816356864(0x40be460000000000, double:7750.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x0057
            goto L_0x00b7
        L_0x0057:
            double[] r4 = r0.f24820b
            r6 = 4665056312839634944(0x40bd9c0000000000, double:7580.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x0065
            goto L_0x00cc
        L_0x0065:
            double[] r4 = r0.f24820b
            r6 = 4664924371444301824(0x40bd240000000000, double:7460.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x0073
            goto L_0x00e1
        L_0x0073:
            double[] r4 = r0.f24820b
            r6 = 4664825415397801984(0x40bcca0000000000, double:7370.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x0082
            goto L_0x00f6
        L_0x0082:
            double[] r4 = r0.f24820b
            r6 = 4664187698653691904(0x40ba860000000000, double:6790.0)
            boolean r2 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r2 == 0) goto L_0x0091
            goto L_0x010b
        L_0x0091:
            r0.f24822k = r1
            r2 = 10
            goto L_0x0117
        L_0x0097:
            double[] r4 = r0.f24820b
            r6 = 4665298205397745664(0x40be780000000000, double:7800.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x00aa
        L_0x00a4:
            r0.f24822k = r14
            r2 = 10
            goto L_0x011a
        L_0x00aa:
            double[] r4 = r0.f24820b
            r6 = 4665001337258246144(0x40bd6a0000000000, double:7530.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x00bf
        L_0x00b7:
            r0.f24822k = r12
            r2 = 10
            r15 = 2131230839(0x7f080077, float:1.8077742E38)
            goto L_0x011a
        L_0x00bf:
            double[] r4 = r0.f24820b
            r6 = 4664814420281524224(0x40bcc00000000000, double:7360.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x00d4
        L_0x00cc:
            r0.f24822k = r10
            r2 = 10
            r15 = 2131230837(0x7f080075, float:1.8077738E38)
            goto L_0x011a
        L_0x00d4:
            double[] r4 = r0.f24820b
            r6 = 4664693474002468864(0x40bc520000000000, double:7250.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x00e9
        L_0x00e1:
            r0.f24822k = r8
            r2 = 10
            r15 = 2131230836(0x7f080074, float:1.8077736E38)
            goto L_0x011a
        L_0x00e9:
            double[] r4 = r0.f24820b
            r6 = 4664605513072246784(0x40bc020000000000, double:7170.0)
            boolean r4 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r4 == 0) goto L_0x00fe
        L_0x00f6:
            r0.f24822k = r5
            r2 = 10
            r15 = 2131230835(0x7f080073, float:1.8077734E38)
            goto L_0x011a
        L_0x00fe:
            double[] r4 = r0.f24820b
            r6 = 4664088742607192064(0x40ba2c0000000000, double:6700.0)
            boolean r2 = com.xeagle.android.utils.c.a((double) r2, (double[]) r4, (double) r6)
            if (r2 == 0) goto L_0x0113
        L_0x010b:
            r2 = 10
            r0.f24822k = r2
            r15 = 2131230832(0x7f080070, float:1.8077728E38)
            goto L_0x011a
        L_0x0113:
            r2 = 10
            r0.f24822k = r1
        L_0x0117:
            r15 = 2131230830(0x7f08006e, float:1.8077724E38)
        L_0x011a:
            int r3 = r0.f24822k
            r4 = 1
            if (r3 > r2) goto L_0x0158
            android.widget.TextView r2 = r0.tvBattery
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r2.setTextColor(r3)
            com.flypro.core.drone.variables.aa r2 = r17.d()
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x0145
            com.xeagle.android.utils.aa r2 = r0.f24826o
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x01a8
            com.xeagle.android.utils.aa r2 = r0.f24826o
            long[] r3 = r0.f24834w
            r2.a(r3, r1)
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.a((boolean) r4)
            goto L_0x01a8
        L_0x0145:
            com.xeagle.android.utils.aa r2 = r0.f24826o
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x01a8
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.d()
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.a((boolean) r1)
            goto L_0x01a8
        L_0x0158:
            r2 = -1
            if (r3 > r5) goto L_0x0186
            android.widget.TextView r3 = r0.tvBattery
            r3.setTextColor(r2)
            com.xeagle.android.utils.aa r2 = r0.f24826o
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x0172
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.d()
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.a((boolean) r1)
        L_0x0172:
            boolean r2 = r0.f24821c
            if (r2 != 0) goto L_0x01a8
            com.flypro.core.MAVLink.a$a r2 = r17.j()
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x01a8
            r16.e()
            r0.f24821c = r4
            goto L_0x01a8
        L_0x0186:
            android.widget.TextView r3 = r0.tvBattery
            r3.setTextColor(r2)
            com.xeagle.android.utils.aa r2 = r0.f24826o
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x019d
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.d()
            com.xeagle.android.utils.aa r2 = r0.f24826o
            r2.a((boolean) r1)
        L_0x019d:
            java.lang.Runnable r2 = r0.f24835x
            if (r2 == 0) goto L_0x01a8
            android.os.Handler r3 = r0.f24833v
            r3.removeCallbacks(r2)
            r0.f24821c = r1
        L_0x01a8:
            android.widget.TextView r2 = r0.tvBattery
            r2.setCompoundDrawablesWithIntrinsicBounds(r15, r1, r1, r1)
            return
        L_0x01ae:
            android.widget.TextView r2 = r0.tvBattery
            r3 = 2131231464(0x7f0802e8, float:1.807901E38)
            r2.setCompoundDrawablesWithIntrinsicBounds(r3, r1, r1, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.RecordViewActivity.f(en.a):void");
    }

    private void j() {
        c(this.f24823l);
        e(this.f24823l);
        d(this.f24823l);
        b(this.f24823l);
        a(this.f24823l);
    }

    /* access modifiers changed from: private */
    public void k() {
        int i2;
        TextView textView;
        if (!this.f24823l.j().e()) {
            textView = this.failSafeTv;
            i2 = R.drawable.wifi_close;
        } else {
            textView = this.failSafeTv;
            i2 = R.drawable.wifi_open;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        this.f24833v.postDelayed(this.f24836y, 1000);
    }

    /* access modifiers changed from: private */
    public void l() {
        Toast makeText = Toast.makeText(this, getString(R.string.ready_take_off), 0);
        makeText.setGravity(48, 0, 46);
        makeText.show();
        this.f24833v.postDelayed(this.f24837z, 3000);
    }

    public void a(a aVar) {
        TextView textView;
        int i2;
        if (!aVar.j().e()) {
            textView = this.failSafeTv;
            i2 = R.drawable.wifi_close;
        } else {
            textView = this.failSafeTv;
            i2 = R.drawable.wifi_open;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, FlightActionActivity.class));
    }

    @OnClick({2131298541, 2131298539})
    public void onClick(View view) {
        Intent intent;
        int id2 = view.getId();
        if (id2 == R.id.record_view_back) {
            finish();
            intent = new Intent(this, FlightActionActivity.class);
        } else if (id2 == R.id.record_view_start) {
            this.f24827p.a(false);
            finish();
            intent = new Intent(this, FlightActionActivity.class);
        } else {
            return;
        }
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_record_view);
        ButterKnife.bind((Activity) this);
        this.f24823l = ((XEagleApp) getApplicationContext()).k();
        this.f24824m = ((XEagleApp) getApplication()).j();
        this.f24825n = this.f12357f.p();
        this.f24826o = aa.a().a((Context) this);
        this.f24827p = this.f24823l.D();
        this.f24828q = new g();
        String stringExtra = getIntent().getStringExtra("tab_name");
        this.f24829r = stringExtra;
        if (this.f24828q.a(this, stringExtra)) {
            List<msg_rc_channels_override> a2 = this.f24828q.a();
            this.f24827p.a(a2);
            this.f24830s = true;
            i2 = a2.size();
        } else {
            i2 = 0;
            this.f24830s = false;
        }
        this.f24831t = i2;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.f24836y;
        if (runnable != null) {
            this.f24833v.removeCallbacks(runnable);
        }
        this.f24823l.b((DroneInterfaces.c) this);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        Intent intent;
        super.onDroneEvent(droneEventsType, aVar);
        switch (AnonymousClass4.f24841a[droneEventsType.ordinal()]) {
            case 1:
                if (this.f24827p.f14276e && aVar.d().e().b().equalsIgnoreCase("RTL")) {
                    this.recordViewStart.setImageResource(R.drawable.record_view_start);
                    this.f24827p.b(true);
                    this.f24827p.a(false);
                    finish();
                    intent = new Intent(this, FlightActionActivity.class);
                    break;
                } else {
                    return;
                }
            case 2:
            case 3:
                c(aVar);
                return;
            case 4:
                if (this.f24832u) {
                    this.f24832u = false;
                    return;
                } else {
                    e(aVar);
                    return;
                }
            case 5:
            case 6:
                d(aVar);
                return;
            case 7:
            case 8:
                b(aVar);
                return;
            case 9:
                int i2 = aVar.D().f14277f;
                int i3 = this.f24831t;
                if (i3 != 0) {
                    this.recordViewProgress.setProgress((int) ((((float) i2) / ((float) i3)) * ((float) this.recordViewProgress.getMax())));
                    TextView textView = this.recordProgressTv;
                    textView.setText(d.a((long) ((i2 + 1) * 40), false) + "/" + d.a((long) (this.f24831t * 40)));
                    return;
                }
                return;
            case 10:
                a(aVar);
                return;
            case 11:
                Toast.makeText(this, R.string.record_task_finish, 1).show();
                this.recordViewStart.setImageResource(R.drawable.record_view_start);
                this.f24827p.b();
                aVar.d().b(ApmModes.ROTOR_LOITER);
                finish();
                intent = new Intent(this, FlightActionActivity.class);
                break;
            default:
                return;
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        b.b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        b();
        a();
        j();
        this.recordViewProgress.setProgress(0);
        TextView textView = this.recordProgressTv;
        textView.setText("00:00/" + d.a((long) (this.f24831t * 40)));
        this.f24823l.a((DroneInterfaces.c) this);
        k();
        b.a(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        finish();
        d();
        Runnable runnable = this.f24835x;
        if (runnable != null) {
            this.f24821c = false;
            this.f24833v.removeCallbacks(runnable);
            this.f24835x = null;
        }
    }
}
