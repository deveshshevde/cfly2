package com.xeagle.android.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.b;
import com.xeagle.android.XEagleApp;
import en.a;
import java.util.Locale;

public class InfoBarFragment extends Fragment implements View.OnClickListener, DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    protected final Handler f23213a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    protected Runnable f23214b = new Runnable() {
        public void run() {
            InfoBarFragment.this.f23213a.removeCallbacks(this);
            if (InfoBarFragment.this.f23215c != null) {
                if (InfoBarFragment.this.f23222j != null) {
                    long n2 = InfoBarFragment.this.f23215c.d().n();
                    InfoBarFragment.this.f23222j.setText(String.format("Air Time\n%02d:%02d", new Object[]{Long.valueOf(n2 / 60), Long.valueOf(n2 % 60)}));
                }
                InfoBarFragment.this.f23213a.postDelayed(this, 10001);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f23215c;

    /* renamed from: d  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f23216d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f23217e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f23218f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f23219g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f23220h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f23221i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public TextView f23222j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f23223k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f23224l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f23225m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f23226n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f23227o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f23228p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f23229q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f23230r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f23231s;

    /* renamed from: t  reason: collision with root package name */
    private LinearLayout f23232t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23233u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23234v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23235w = false;

    /* renamed from: com.xeagle.android.fragments.InfoBarFragment$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23237a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23237a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_FIX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS_COUNT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.RADIO     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f23237a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.InfoBarFragment.AnonymousClass2.<clinit>():void");
        }
    }

    private String a(double d2) {
        if (Math.abs(d2) >= 1000.0d) {
            return String.format(Locale.US, "%2.1f Ah", new Object[]{Double.valueOf(d2 / 1000.0d)});
        }
        return String.format(Locale.ENGLISH, "%2.0f mAh", new Object[]{Double.valueOf(d2)});
    }

    private void a() {
        this.f23218f.setOnClickListener(this);
        this.f23221i.setOnClickListener(this);
        this.f23223k.setOnClickListener(this);
        this.f23222j.setOnClickListener(this);
    }

    private void a(View view) {
        this.f23217e = (TextView) view.findViewById(R.id.bar_home);
        this.f23218f = (TextView) view.findViewById(R.id.bar_gps);
        this.f23219g = (TextView) view.findViewById(R.id.bar_gps_satno);
        this.f23220h = (TextView) view.findViewById(R.id.bar_gps_hdop_status);
        this.f23221i = (TextView) view.findViewById(R.id.bar_battery);
        this.f23222j = (TextView) view.findViewById(R.id.bar_propeller);
        this.f23223k = (TextView) view.findViewById(R.id.bar_signal);
        this.f23224l = (TextView) view.findViewById(R.id.bar_signal_rssi);
        this.f23225m = (TextView) view.findViewById(R.id.bar_signal_remrssi);
        this.f23226n = (TextView) view.findViewById(R.id.bar_signal_noise);
        this.f23227o = (TextView) view.findViewById(R.id.bar_signal_remnoise);
        this.f23228p = (TextView) view.findViewById(R.id.bar_signal_fade);
        this.f23229q = (TextView) view.findViewById(R.id.bar_signal_remfade);
        this.f23215c = ((XEagleApp) getActivity().getApplication()).k();
        this.f23216d = new com.xeagle.android.utils.prefs.a(getActivity().getApplicationContext());
        this.f23230r = (LinearLayout) view.findViewById(R.id.ll_gps);
        this.f23231s = (LinearLayout) view.findViewById(R.id.ll_signal);
        this.f23232t = (LinearLayout) view.findViewById(R.id.ll_mDrawer);
    }

    private void a(a aVar) {
        String str;
        if (this.f23217e != null) {
            if (aVar == null) {
                str = "--";
            } else {
                str = String.format("DistanceToHome\n%s", new Object[]{aVar.q().b().toString()});
            }
            this.f23217e.setText(str);
        }
    }

    private void b(a aVar) {
        String str;
        int i2;
        if (aVar == null) {
            str = "--";
            i2 = R.drawable.ic_gps_off_black_24dp;
            this.f23219g.setText(str);
            this.f23220h.setText(str);
        } else {
            String e2 = aVar.b().e();
            String format = this.f23216d.S() ? String.format(Locale.ENGLISH, "%.1f", new Object[]{Double.valueOf(aVar.b().c())}) : String.format(Locale.ENGLISH, "%s", new Object[]{e2});
            char c2 = 65535;
            int hashCode = e2.hashCode();
            if (hashCode != 1618) {
                if (hashCode != 1649) {
                    if (hashCode == 75412084 && e2.equals("NoFix")) {
                        c2 = 2;
                    }
                } else if (e2.equals("3D")) {
                    c2 = 0;
                }
            } else if (e2.equals("2D")) {
                c2 = 1;
            }
            int i3 = c2 != 0 ? R.drawable.ic_gps_not_fixed_black_24dp : R.drawable.ic_gps_fixed_black_24dp;
            this.f23219g.setText(String.format(Locale.ENGLISH, "Satellites %d", new Object[]{Integer.valueOf(aVar.b().d())}));
            if (this.f23216d.S()) {
                this.f23220h.setText(String.format(Locale.ENGLISH, "%s", new Object[]{e2}));
            } else {
                this.f23220h.setText(String.format(Locale.ENGLISH, "HDOP %.1f", new Object[]{Double.valueOf(aVar.b().c())}));
            }
            str = format;
            i2 = i3;
        }
        this.f23218f.setText(str);
        this.f23218f.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    }

    private void c(a aVar) {
        int i2;
        String str;
        b o2;
        if (aVar == null || (o2 = aVar.o()) == null) {
            i2 = R.drawable.ic_battery_unknown_black_24dp;
            str = "--";
        } else {
            Double d2 = o2.d();
            if (d2 == null) {
                getString(R.string.empty_content);
            } else {
                a(d2.doubleValue());
            }
            str = String.format(Locale.ENGLISH, "%2.1f V", new Object[]{Double.valueOf(o2.a())});
            i2 = R.drawable.ic_battery_std_black_24dp;
        }
        if (aVar.o().a() < 21.4d) {
            this.f23221i.setTextColor(getResources().getColor(R.color.info_bar_low));
        }
        this.f23221i.setText(str);
        this.f23221i.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    }

    private void d(a aVar) {
        if (aVar == null || !aVar.p().h()) {
            String string = getString(R.string.empty_content);
            this.f23223k.setText(string);
            this.f23223k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_signal_wifi_statusbar_null_black_24dp, 0, 0, 0);
            this.f23224l.setText(string);
            this.f23225m.setText(string);
            this.f23226n.setText(string);
            this.f23227o.setText(string);
            this.f23228p.setText(string);
            this.f23229q.setText(string);
            return;
        }
        int g2 = aVar.p().g();
        int i2 = g2 >= 100 ? R.drawable.ic_signal_wifi_4_bar_black_24dp : g2 >= 75 ? R.drawable.ic_signal_wifi_3_bar_black_24dp : g2 >= 50 ? R.drawable.ic_signal_wifi_2_bar_black_24dp : g2 >= 25 ? R.drawable.ic_signal_wifi_1_bar_black_24dp : R.drawable.ic_signal_wifi_0_bar_black_24dp;
        this.f23223k.setText(String.format(Locale.ENGLISH, "%d%%", new Object[]{Integer.valueOf(g2)}));
        if (g2 < 25) {
            this.f23223k.setTextColor(getResources().getColor(R.color.info_bar_low));
        }
        this.f23223k.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        this.f23224l.setText(String.format("RSSI %2.0f dB", new Object[]{Double.valueOf(aVar.p().a())}));
        this.f23225m.setText(String.format("RemRSSI %2.0f dB", new Object[]{Double.valueOf(aVar.p().b())}));
        this.f23226n.setText(String.format("Noise %2.0f dB", new Object[]{Double.valueOf(aVar.p().c())}));
        this.f23227o.setText(String.format("RemNoise %2.0f dB", new Object[]{Double.valueOf(aVar.p().d())}));
        this.f23228p.setText(String.format("Fade %2.0f dB", new Object[]{Double.valueOf(aVar.p().e())}));
        this.f23229q.setText(String.format("RemFade %2.0f dB", new Object[]{Double.valueOf(aVar.p().f())}));
    }

    private void e(a aVar) {
        this.f23213a.removeCallbacks(this.f23214b);
        if (aVar != null) {
            this.f23214b.run();
        } else {
            this.f23222j.setText("00:00");
        }
    }

    private void f(a aVar) {
        a(aVar);
        b(aVar);
        c(aVar);
        e(aVar);
        d(aVar);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar_gps:
                if (!this.f23233u) {
                    this.f23230r.setVisibility(0);
                    this.f23233u = true;
                    return;
                }
                this.f23230r.setVisibility(8);
                this.f23233u = false;
                return;
            case R.id.bar_propeller:
                a aVar = this.f23215c;
                if (aVar != null) {
                    aVar.d().k();
                    return;
                }
                return;
            case R.id.bar_signal:
                if (!this.f23235w) {
                    this.f23231s.setVisibility(0);
                    this.f23235w = true;
                    return;
                }
                this.f23231s.setVisibility(8);
                this.f23235w = false;
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.telem_drawerlayout, viewGroup, false);
        a(inflate);
        a();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        switch (AnonymousClass2.f23237a[droneEventsType.ordinal()]) {
            case 1:
                if (this.f23221i != null) {
                    c(aVar);
                    return;
                }
                return;
            case 2:
            case 3:
                f(aVar);
                return;
            case 4:
            case 5:
                if (this.f23218f != null) {
                    b(aVar);
                    return;
                }
                return;
            case 6:
            case 7:
                if (this.f23217e != null) {
                    a(aVar);
                    return;
                }
                return;
            case 8:
                if (this.f23223k != null) {
                    d(aVar);
                    return;
                }
                return;
            case 9:
                if (this.f23222j != null) {
                    e(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onStart() {
        super.onStart();
        a aVar = this.f23215c;
        if (aVar == null) {
            f(aVar);
        }
        this.f23215c.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        this.f23215c.b((DroneInterfaces.c) this);
    }
}
