package com.xeagle.android.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.customeui.widget.CommonUI;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.d;
import com.flypro.core.parameters.Parameter;
import com.warkiz.tickseekbar.TickSeekBar;
import com.warkiz.tickseekbar.c;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.utils.h;
import com.xeagle.android.utils.x;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import dy.ad;
import dy.u;
import en.a;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class z extends Fragment {
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    private int F;
    private IButton G;
    private final x.c H;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public FlightActionActivity f12473a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f12474b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f12475c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String[] f12476d = {"10", "15", "20", "25", "30", "35"};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Double[] f12477e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String[] f12478f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Double[] f12479g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String[] f12480h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Integer[] f12481i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String[] f12482j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Integer[] f12483k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String[] f12484l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Integer[] f12485m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f12486n;

    /* renamed from: o  reason: collision with root package name */
    private TickSeekBar f12487o;

    /* renamed from: p  reason: collision with root package name */
    private TickSeekBar f12488p;

    /* renamed from: q  reason: collision with root package name */
    private TickSeekBar f12489q;

    /* renamed from: r  reason: collision with root package name */
    private TickSeekBar f12490r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Parameter f12491s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public double f12492t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f12493u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f12494v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f12495w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public double f12496x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f12497y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f12498z;

    public z() {
        Double valueOf = Double.valueOf(0.22d);
        Double valueOf2 = Double.valueOf(0.33d);
        Double valueOf3 = Double.valueOf(0.44d);
        Double valueOf4 = Double.valueOf(0.55d);
        Double valueOf5 = Double.valueOf(0.66d);
        this.f12477e = new Double[]{valueOf, valueOf2, valueOf3, valueOf4, valueOf5, Double.valueOf(0.8d)};
        this.f12478f = new String[]{"10", "15", "20", "25", "30", "35"};
        this.f12479g = new Double[]{valueOf, valueOf2, valueOf3, valueOf4, valueOf5, Double.valueOf(0.77d)};
        this.f12480h = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        this.f12481i = new Integer[]{170, 250, Integer.valueOf(AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID), 417, 500, 583, 667, 750, 834};
        this.f12482j = new String[]{"1.0", "1.5", "2.0", "2.5", "3.0"};
        this.f12483k = new Integer[]{100, 150, 200, 250, 300};
        this.f12484l = new String[]{"1.0", "1.5", "2.0", "2.5", "3.0"};
        this.f12485m = new Integer[]{-100, -150, -200, -250, -300};
        this.f12486n = new ConcurrentHashMap<>();
        this.f12492t = -1.0d;
        this.f12493u = -1;
        this.f12494v = -1;
        this.f12495w = -1;
        this.f12496x = -1.0d;
        this.f12497y = -1;
        this.f12498z = -1;
        this.A = -1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.H = new x.c() {
            public void a(String str) {
                Log.i("RcSpeed", "onComplete: =====keyStr====" + str);
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -850979327:
                        if (str.equals("READ_WPNAV_LOIT_SPD_TWO")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -202882816:
                        if (str.equals("READ_PSC_YYZ_UP_SPED_TWO")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -43167946:
                        if (str.equals("READ_ACRO_YAW_P_TWO")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1206427112:
                        if (str.equals("READ_PSC_YYZ_Dw_SPED_TWO")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        boolean unused = z.this.C = false;
                        break;
                    case 1:
                        boolean unused2 = z.this.D = false;
                        break;
                    case 2:
                        boolean unused3 = z.this.B = false;
                        break;
                    case 3:
                        boolean unused4 = z.this.E = false;
                        break;
                    default:
                        return;
                }
                CommonUI.a((Context) z.this.f12473a, z.this.getView(), Integer.valueOf(R.string.speed_param_success));
            }

            public void a(String str, int i2) {
                String str2;
                z zVar;
                String str3;
                Log.i("RcSpeed", "notifyTimeout: ======keyStr===" + str + "===timeCount==" + i2);
                str.hashCode();
                String str4 = "READ_PSC_YYZ_UP_SPED_ONE";
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -850984421:
                        if (str.equals("READ_WPNAV_LOIT_SPD_ONE")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -850979327:
                        if (str.equals("READ_WPNAV_LOIT_SPD_TWO")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -202887910:
                        if (str.equals(str4)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -202882816:
                        if (str.equals("READ_PSC_YYZ_UP_SPED_TWO")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -43173040:
                        if (str.equals("READ_ACRO_YAW_P_ONE")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -43167946:
                        if (str.equals("READ_ACRO_YAW_P_TWO")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1206427112:
                        if (str.equals("READ_PSC_YYZ_Dw_SPED_TWO")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (i2 >= 3) {
                            zVar = z.this;
                            str2 = "SETTING_PSC_YYZ_UP_SPED";
                            str3 = "PSC_YYZ_UP_SPED";
                            break;
                        } else {
                            return;
                        }
                    case 1:
                        if (i2 >= 3) {
                            boolean unused = z.this.C = false;
                            return;
                        }
                        return;
                    case 2:
                        if (i2 >= 3) {
                            zVar = z.this;
                            str2 = "SETTING_PSC_YYZ_Dw_SPED";
                            str3 = "PSC_YYZ_Dw_SPED";
                            str4 = "READ_PSC_YYZ_Dw_SPED_ONE";
                            break;
                        } else {
                            return;
                        }
                    case 3:
                        if (i2 >= 3) {
                            boolean unused2 = z.this.D = false;
                            return;
                        }
                        return;
                    case 4:
                        if (i2 >= 3) {
                            z.this.a("SETTING_WPNAV_LOIT_SPD", "WPNAV_LOIT_SPD", "READ_WPNAV_LOIT_SPD_ONE", 1);
                            return;
                        }
                        return;
                    case 5:
                        if (i2 >= 3) {
                            boolean unused3 = z.this.B = false;
                            return;
                        }
                        return;
                    case 6:
                        if (i2 >= 3) {
                            boolean unused4 = z.this.E = false;
                            return;
                        }
                        return;
                    default:
                        return;
                }
                zVar.a(str2, str3, str4, 1);
            }
        };
    }

    private void a() {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                int i2;
                if (h.b(z.this.f12475c)) {
                    if (z.this.f12496x != 0.8d) {
                        if (z.this.f12491s == null) {
                            Parameter unused = z.this.f12491s = new Parameter("ACRO_YAW_P");
                        }
                        double unused2 = z.this.f12492t = 0.8d;
                        z.this.f12491s.f14456b = 0.8d;
                        z.this.f12474b.e().a(z.this.f12491s);
                        SystemClock.sleep(100);
                        z.this.a("SETTING_ACRO_YAW_P", "ACRO_YAW_P", "READ_ACRO_YAW_P_TWO", 2);
                    }
                    if (z.this.f12497y != 834) {
                        d.a(z.this.f12474b, 834, 1);
                    }
                    if (z.this.f12498z != 300) {
                        d.a(z.this.f12474b, 300, 2);
                    }
                    i2 = -300;
                    if (z.this.A == -300) {
                        return;
                    }
                } else if (h.a(z.this.f12475c)) {
                    if (z.this.f12496x != 0.44d) {
                        if (z.this.f12491s == null) {
                            Parameter unused3 = z.this.f12491s = new Parameter("ACRO_YAW_P");
                        }
                        double unused4 = z.this.f12492t = 0.44d;
                        z.this.f12491s.f14456b = 0.44d;
                        z.this.f12474b.e().a(z.this.f12491s);
                        SystemClock.sleep(100);
                        z.this.a("SETTING_ACRO_YAW_P", "ACRO_YAW_P", "READ_ACRO_YAW_P_TWO", 2);
                    }
                    if (z.this.f12497y != 667) {
                        d.a(z.this.f12474b, 667, 1);
                    }
                    if (z.this.f12498z != 250) {
                        d.a(z.this.f12474b, 250, 2);
                    }
                    i2 = -200;
                    if (z.this.A == -200) {
                        return;
                    }
                } else {
                    return;
                }
                d.a(z.this.f12474b, i2, 3);
            }
        });
    }

    private void a(View view) {
        this.f12487o = (TickSeekBar) view.findViewById(R.id.seek_steering_speed);
        this.f12488p = (TickSeekBar) view.findViewById(R.id.seek_level_flight);
        this.f12489q = (TickSeekBar) view.findViewById(R.id.seek_ascent_rate);
        this.f12490r = (TickSeekBar) view.findViewById(R.id.seek_decline_rate);
        this.G = (IButton) view.findViewById(R.id.bt_default);
        if (h.a(this.f12475c)) {
            this.f12487o.setTickCount(this.f12478f.length);
            this.f12487o.a(this.f12478f);
        } else if (h.b(this.f12475c)) {
            this.f12487o.setTickCount(this.f12476d.length);
            this.f12487o.a(this.f12476d);
        }
        this.f12488p.setTickCount(this.f12480h.length);
        this.f12488p.a(this.f12480h);
        this.f12489q.setTickCount(this.f12482j.length);
        this.f12489q.a(this.f12482j);
        this.f12490r.setTickCount(this.f12484l.length);
        this.f12490r.a(this.f12484l);
        view.findViewById(R.id.bt_submit).setOnClickListener($$Lambda$z$OVwFHHvOXXEVofHl7YWDsJ4Yo.INSTANCE);
        view.findViewById(R.id.bt_default).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                z.this.b(view);
            }
        });
        this.f12487o.setOnSeekChangeListener(new c() {
            public void a(TickSeekBar tickSeekBar) {
                Log.i("RcSpeed", "onStartTrackingTouch: ====");
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
                Log.i("RcSpeed", "onSeeking: ======" + dVar.f22080f);
            }

            public void b(TickSeekBar tickSeekBar) {
                if (!z.this.B) {
                    if (h.a(z.this.f12475c)) {
                        int ceil = (int) Math.ceil((double) ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12478f.length)));
                        Log.i("RcSpeed", "onStopTrackingTouch: ====progress percent=====" + ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12478f.length)) + "===index===" + ceil);
                        if (ceil >= 1) {
                            ceil--;
                        }
                        Log.i("RcSpeed", "onStopTrackingTouch: ========steering====" + ceil + "===value==" + z.this.f12479g[ceil]);
                        z zVar = z.this;
                        double unused = zVar.f12492t = zVar.f12479g[ceil].doubleValue();
                    } else if (h.b(z.this.f12475c)) {
                        int ceil2 = (int) Math.ceil((double) ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12476d.length)));
                        if (ceil2 >= 1) {
                            ceil2--;
                        }
                        Log.i("RcSpeed", "onStopTrackingTouch: ========steering====" + ceil2 + "===value==" + z.this.f12476d[ceil2]);
                        z zVar2 = z.this;
                        double unused2 = zVar2.f12492t = zVar2.f12477e[ceil2].doubleValue();
                    }
                    Log.e("RcSpeed", "onStopTrackingTouch: ====current==" + z.this.f12492t + "===last===" + z.this.f12496x);
                    if (z.this.f12492t != -1.0d && z.this.f12496x != -1.0d && z.this.f12492t != z.this.f12496x) {
                        if (z.this.f12491s == null) {
                            Parameter unused3 = z.this.f12491s = new Parameter("ACRO_YAW_P");
                        }
                        z.this.f12491s.f14456b = z.this.f12492t;
                        z.this.f12474b.e().a(z.this.f12491s);
                        SystemClock.sleep(100);
                        z.this.a("SETTING_ACRO_YAW_P", "ACRO_YAW_P", "READ_ACRO_YAW_P_TWO", 2);
                    }
                }
            }
        });
        this.f12488p.setOnSeekChangeListener(new c() {
            public void a(TickSeekBar tickSeekBar) {
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
            }

            public void b(TickSeekBar tickSeekBar) {
                if (!z.this.C) {
                    int ceil = (int) Math.ceil((double) ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12480h.length)));
                    if (ceil >= 1) {
                        ceil--;
                    }
                    z zVar = z.this;
                    int unused = zVar.f12493u = zVar.f12481i[ceil].intValue();
                    Log.e("RcSpeed", "onStopTrackingTouch: ====current==" + z.this.f12493u + "===last===" + z.this.f12497y);
                    if (z.this.f12493u != -1 && z.this.f12497y != -1 && z.this.f12493u != z.this.f12497y) {
                        d.a(z.this.f12474b, z.this.f12493u, 1);
                    }
                }
            }
        });
        this.f12489q.setOnSeekChangeListener(new c() {
            public void a(TickSeekBar tickSeekBar) {
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
            }

            public void b(TickSeekBar tickSeekBar) {
                Log.i("RcSpeed", "onStopTrackingTouch: ===isChanging===" + z.this.D);
                if (!z.this.D) {
                    boolean unused = z.this.D = true;
                    int ceil = (int) Math.ceil((double) ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12482j.length)));
                    if (ceil >= 1) {
                        ceil--;
                    }
                    z zVar = z.this;
                    int unused2 = zVar.f12494v = zVar.f12483k[ceil].intValue();
                    Log.e("RcSpeed", "onStopTrackingTouch: ====current==" + z.this.f12494v + "===last===" + z.this.f12498z);
                    if (z.this.f12494v != -1 && z.this.f12498z != -1 && z.this.f12494v != z.this.f12498z) {
                        d.a(z.this.f12474b, z.this.f12494v, 2);
                    }
                }
            }
        });
        this.f12490r.setOnSeekChangeListener(new c() {
            public void a(TickSeekBar tickSeekBar) {
            }

            public void a(com.warkiz.tickseekbar.d dVar) {
            }

            public void b(TickSeekBar tickSeekBar) {
                if (!z.this.E) {
                    int ceil = (int) Math.ceil((double) ((((float) tickSeekBar.getProgress()) / 100.0f) * ((float) z.this.f12484l.length)));
                    if (ceil >= 1) {
                        ceil--;
                    }
                    z zVar = z.this;
                    int unused = zVar.f12495w = zVar.f12485m[ceil].intValue();
                    Log.e("RcSpeed", "onStopTrackingTouch: ====current==" + z.this.f12495w + "===last===" + z.this.A);
                    if (z.this.f12495w != -1 && z.this.A != -1 && z.this.f12495w != z.this.A) {
                        d.a(z.this.f12474b, z.this.f12495w, 3);
                    }
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005a, code lost:
        if (r9.G.isEnabled() != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        if (r9.G.isEnabled() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        r9.G.setEnabled(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c0, code lost:
        if (r9.G.isEnabled() != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c9, code lost:
        if (r9.G.isEnabled() == false) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.flypro.core.parameters.Parameter r10) {
        /*
            r9 = this;
            r9.f12491s = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.xeagle.android.utils.prefs.a r1 = r9.f12475c
            boolean r1 = com.xeagle.android.utils.h.a((com.xeagle.android.utils.prefs.a) r1)
            java.lang.String r2 = "%.2f"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0071
            java.lang.Double[] r0 = r9.f12479g
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r4]
            double r6 = r10.f14456b
            java.lang.Double r10 = java.lang.Double.valueOf(r6)
            r5[r3] = r10
            java.lang.String r10 = java.lang.String.format(r1, r2, r5)
            double r1 = java.lang.Double.parseDouble(r10)
            r9.f12496x = r1
            java.lang.Double r10 = java.lang.Double.valueOf(r1)
            int r10 = r0.indexOf(r10)
            double r1 = r9.f12496x
            r5 = 4601597955262077993(0x3fdc28f5c28f5c29, double:0.44)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0062
            int r1 = r9.f12497y
            r2 = 667(0x29b, float:9.35E-43)
            if (r1 != r2) goto L_0x0062
            int r1 = r9.f12498z
            r2 = 250(0xfa, float:3.5E-43)
            if (r1 != r2) goto L_0x0062
            int r1 = r9.A
            r2 = -200(0xffffffffffffff38, float:NaN)
            if (r1 != r2) goto L_0x0062
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x006f
        L_0x005c:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            r1.setEnabled(r3)
            goto L_0x006f
        L_0x0062:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x006f
        L_0x006a:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            r1.setEnabled(r4)
        L_0x006f:
            r3 = r10
            goto L_0x00cc
        L_0x0071:
            com.xeagle.android.utils.prefs.a r1 = r9.f12475c
            boolean r1 = com.xeagle.android.utils.h.b((com.xeagle.android.utils.prefs.a) r1)
            if (r1 == 0) goto L_0x00cc
            java.lang.Double[] r0 = r9.f12477e
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r4]
            double r6 = r10.f14456b
            java.lang.Double r10 = java.lang.Double.valueOf(r6)
            r5[r3] = r10
            java.lang.String r10 = java.lang.String.format(r1, r2, r5)
            double r1 = java.lang.Double.parseDouble(r10)
            r9.f12496x = r1
            java.lang.Double r10 = java.lang.Double.valueOf(r1)
            int r10 = r0.indexOf(r10)
            double r1 = r9.f12496x
            r5 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00c3
            int r1 = r9.f12497y
            r2 = 834(0x342, float:1.169E-42)
            if (r1 != r2) goto L_0x00c3
            int r1 = r9.f12498z
            r2 = 300(0x12c, float:4.2E-43)
            if (r1 != r2) goto L_0x00c3
            int r1 = r9.A
            r2 = -300(0xfffffffffffffed4, float:NaN)
            if (r1 != r2) goto L_0x00c3
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x006f
            goto L_0x005c
        L_0x00c3:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r9.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x006f
            goto L_0x006a
        L_0x00cc:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r10 = r9.f12486n
            java.lang.String r1 = "SETTING_ACRO_YAW_P"
            java.lang.Object r10 = r10.get(r1)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r1 = 2
            r2 = 1120403456(0x42c80000, float:100.0)
            if (r10 != r1) goto L_0x00e7
            double r5 = r9.f12492t
            double r7 = r9.f12496x
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x00fb
        L_0x00e7:
            com.warkiz.tickseekbar.TickSeekBar r10 = r9.f12487o
            float r1 = (float) r3
            int r0 = r0.size()
            int r0 = r0 - r4
            float r0 = (float) r0
            float r1 = r1 / r0
            float r1 = r1 * r2
            int r0 = java.lang.Math.round(r1)
            float r0 = (float) r0
            r10.setProgress(r0)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.z.a(com.flypro.core.parameters.Parameter):void");
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2, String str3, final int i2) {
        x.a().a(str3, 3, 300, this.H, new x.a() {
            /* access modifiers changed from: protected */
            public void a() {
                Log.i("RcSpeed", "doRun: ======" + str);
                z.this.f12486n.put(str, Integer.valueOf(i2));
                z.this.f12474b.e().a(str2);
            }
        });
    }

    private boolean a(String str) {
        return this.f12486n.containsKey(str);
    }

    private void b() {
        a("SETTING_ACRO_YAW_P", "ACRO_YAW_P", "READ_ACRO_YAW_P_ONE", 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r8.G.isEnabled() != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        r8.G.setEnabled(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
        if (r8.G.isEnabled() != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.flypro.core.parameters.Parameter r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Integer[] r0 = r8.f12481i
            java.util.List r0 = java.util.Arrays.asList(r0)
            double r1 = r9.f14456b
            int r9 = (int) r1
            r8.f12497y = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r0.indexOf(r9)
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.a((com.xeagle.android.utils.prefs.a) r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x005b
            double r4 = r8.f12496x
            r6 = 4601597955262077993(0x3fdc28f5c28f5c29, double:0.44)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x004d
            int r1 = r8.f12497y
            r4 = 667(0x29b, float:9.35E-43)
            if (r1 != r4) goto L_0x004d
            int r1 = r8.f12498z
            r4 = 250(0xfa, float:3.5E-43)
            if (r1 != r4) goto L_0x004d
            int r1 = r8.A
            r4 = -200(0xffffffffffffff38, float:NaN)
            if (r1 != r4) goto L_0x004d
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x0092
        L_0x0047:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r2)
            goto L_0x0092
        L_0x004d:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x0092
        L_0x0055:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r3)
            goto L_0x0092
        L_0x005b:
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.b((com.xeagle.android.utils.prefs.a) r1)
            if (r1 == 0) goto L_0x0092
            double r4 = r8.f12496x
            r6 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0089
            int r1 = r8.f12497y
            r4 = 834(0x342, float:1.169E-42)
            if (r1 != r4) goto L_0x0089
            int r1 = r8.f12498z
            r4 = 300(0x12c, float:4.2E-43)
            if (r1 != r4) goto L_0x0089
            int r1 = r8.A
            r4 = -300(0xfffffffffffffed4, float:NaN)
            if (r1 != r4) goto L_0x0089
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x0092
            goto L_0x0047
        L_0x0089:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x0092
            goto L_0x0055
        L_0x0092:
            com.warkiz.tickseekbar.TickSeekBar r1 = r8.f12488p
            float r9 = (float) r9
            int r0 = r0.size()
            int r0 = r0 - r3
            float r0 = (float) r0
            float r9 = r9 / r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 * r0
            int r9 = java.lang.Math.round(r9)
            float r9 = (float) r9
            r1.setProgress(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.z.b(com.flypro.core.parameters.Parameter):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (r8.G.isEnabled() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
        r8.G.setEnabled(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r8.G.isEnabled() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.flypro.core.parameters.Parameter r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "droneParameterEvent: ===ascent==="
            r0.append(r1)
            double r1 = r9.f14456b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RcSpeed"
            android.util.Log.i(r1, r0)
            java.lang.Integer[] r0 = r8.f12483k
            java.util.List r0 = java.util.Arrays.asList(r0)
            double r1 = r9.f14456b
            int r9 = (int) r1
            r8.f12498z = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r0.indexOf(r9)
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.a((com.xeagle.android.utils.prefs.a) r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x006e
            double r4 = r8.f12496x
            r6 = 4601597955262077993(0x3fdc28f5c28f5c29, double:0.44)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0060
            int r1 = r8.f12497y
            r4 = 667(0x29b, float:9.35E-43)
            if (r1 != r4) goto L_0x0060
            int r1 = r8.f12498z
            r4 = 250(0xfa, float:3.5E-43)
            if (r1 != r4) goto L_0x0060
            int r1 = r8.A
            r4 = -200(0xffffffffffffff38, float:NaN)
            if (r1 != r4) goto L_0x0060
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x00a5
        L_0x005a:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r2)
            goto L_0x00a5
        L_0x0060:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x00a5
        L_0x0068:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r3)
            goto L_0x00a5
        L_0x006e:
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.b((com.xeagle.android.utils.prefs.a) r1)
            if (r1 == 0) goto L_0x00a5
            double r4 = r8.f12496x
            r6 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x009c
            int r1 = r8.f12497y
            r4 = 834(0x342, float:1.169E-42)
            if (r1 != r4) goto L_0x009c
            int r1 = r8.f12498z
            r4 = 300(0x12c, float:4.2E-43)
            if (r1 != r4) goto L_0x009c
            int r1 = r8.A
            r4 = -300(0xfffffffffffffed4, float:NaN)
            if (r1 != r4) goto L_0x009c
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x00a5
            goto L_0x005a
        L_0x009c:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x00a5
            goto L_0x0068
        L_0x00a5:
            com.warkiz.tickseekbar.TickSeekBar r1 = r8.f12489q
            float r9 = (float) r9
            int r0 = r0.size()
            int r0 = r0 - r3
            float r0 = (float) r0
            float r9 = r9 / r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 * r0
            int r9 = java.lang.Math.round(r9)
            float r9 = (float) r9
            r1.setProgress(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.z.c(com.flypro.core.parameters.Parameter):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (r8.G.isEnabled() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
        r8.G.setEnabled(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r8.G.isEnabled() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r8.G.isEnabled() == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.flypro.core.parameters.Parameter r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "droneParameterEvent: ===decline==="
            r0.append(r1)
            double r1 = r9.f14456b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RcSpeed"
            android.util.Log.i(r1, r0)
            java.lang.Integer[] r0 = r8.f12485m
            java.util.List r0 = java.util.Arrays.asList(r0)
            double r1 = r9.f14456b
            int r9 = (int) r1
            r8.A = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r0.indexOf(r9)
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.a((com.xeagle.android.utils.prefs.a) r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x006e
            double r4 = r8.f12496x
            r6 = 4601597955262077993(0x3fdc28f5c28f5c29, double:0.44)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0060
            int r1 = r8.f12497y
            r4 = 667(0x29b, float:9.35E-43)
            if (r1 != r4) goto L_0x0060
            int r1 = r8.f12498z
            r4 = 250(0xfa, float:3.5E-43)
            if (r1 != r4) goto L_0x0060
            int r1 = r8.A
            r4 = -200(0xffffffffffffff38, float:NaN)
            if (r1 != r4) goto L_0x0060
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x00a5
        L_0x005a:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r2)
            goto L_0x00a5
        L_0x0060:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x00a5
        L_0x0068:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            r1.setEnabled(r3)
            goto L_0x00a5
        L_0x006e:
            com.xeagle.android.utils.prefs.a r1 = r8.f12475c
            boolean r1 = com.xeagle.android.utils.h.b((com.xeagle.android.utils.prefs.a) r1)
            if (r1 == 0) goto L_0x00a5
            double r4 = r8.f12496x
            r6 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x009c
            int r1 = r8.f12497y
            r4 = 834(0x342, float:1.169E-42)
            if (r1 != r4) goto L_0x009c
            int r1 = r8.f12498z
            r4 = 300(0x12c, float:4.2E-43)
            if (r1 != r4) goto L_0x009c
            int r1 = r8.A
            r4 = -300(0xfffffffffffffed4, float:NaN)
            if (r1 != r4) goto L_0x009c
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto L_0x00a5
            goto L_0x005a
        L_0x009c:
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = r8.G
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x00a5
            goto L_0x0068
        L_0x00a5:
            com.warkiz.tickseekbar.TickSeekBar r1 = r8.f12490r
            float r9 = (float) r9
            int r0 = r0.size()
            int r0 = r0 - r3
            float r0 = (float) r0
            float r9 = r9 / r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 * r0
            int r9 = java.lang.Math.round(r9)
            float r9 = (float) r9
            r1.setProgress(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.z.d(com.flypro.core.parameters.Parameter):void");
    }

    @l(a = ThreadMode.MAIN)
    public void droneParameterEvent(u uVar) {
        x a2;
        Parameter a3 = uVar.a();
        if (a3 != null) {
            String str = a3.f14455a;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -772545884:
                    if (str.equals("PSC_YYZ_Dw_SPED")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 313577916:
                    if (str.equals("PSC_YYZ_UP_SPED")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 350018560:
                    if (str.equals("ACRO_YAW_P")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 853019851:
                    if (str.equals("WPNAV_LOIT_SPD")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            String str2 = "READ_PSC_YYZ_Dw_SPED_ONE";
            switch (c2) {
                case 0:
                    if (a("SETTING_PSC_YYZ_Dw_SPED")) {
                        if (this.f12486n.get("SETTING_PSC_YYZ_Dw_SPED").intValue() == 1) {
                            d(a3);
                            a2 = x.a();
                        } else {
                            if (this.f12486n.get("SETTING_PSC_YYZ_Dw_SPED").intValue() == 2) {
                                d(a3);
                                if (this.f12495w == this.A) {
                                    a2 = x.a();
                                    str2 = "READ_PSC_YYZ_Dw_SPED_TWO";
                                }
                            }
                            this.f12486n.put("SETTING_PSC_YYZ_Dw_SPED", 0);
                            return;
                        }
                        a2.a(str2, true);
                        this.f12486n.put("SETTING_PSC_YYZ_Dw_SPED", 0);
                        return;
                    }
                    return;
                case 1:
                    if (a("SETTING_PSC_YYZ_UP_SPED")) {
                        if (this.f12486n.get("SETTING_PSC_YYZ_UP_SPED").intValue() == 1) {
                            c(a3);
                            x.a().a("READ_PSC_YYZ_UP_SPED_ONE", true);
                            a("SETTING_PSC_YYZ_Dw_SPED", "PSC_YYZ_Dw_SPED", str2, 1);
                        } else if (this.f12486n.get("SETTING_PSC_YYZ_UP_SPED").intValue() == 2) {
                            c(a3);
                            if (this.f12494v == this.f12498z) {
                                x.a().a("READ_PSC_YYZ_UP_SPED_TWO", true);
                            }
                        }
                        this.f12486n.put("SETTING_PSC_YYZ_UP_SPED", 0);
                        return;
                    }
                    return;
                case 2:
                    if (a("SETTING_ACRO_YAW_P")) {
                        if (this.f12486n.get("SETTING_ACRO_YAW_P").intValue() == 1) {
                            a(a3);
                            x.a().a("READ_ACRO_YAW_P_ONE", true);
                            a("SETTING_WPNAV_LOIT_SPD", "WPNAV_LOIT_SPD", "READ_WPNAV_LOIT_SPD_ONE", 1);
                        } else if (this.f12486n.get("SETTING_ACRO_YAW_P").intValue() == 2) {
                            a(a3);
                            Log.i("RcSpeed", "droneParameterEvent: =====current===" + this.f12492t + "==last===" + this.f12496x);
                            if (this.f12492t == this.f12496x) {
                                x.a().a("READ_ACRO_YAW_P_TWO", true);
                            }
                        }
                        this.f12486n.put("SETTING_ACRO_YAW_P", 0);
                        return;
                    }
                    return;
                case 3:
                    if (a("SETTING_WPNAV_LOIT_SPD")) {
                        if (this.f12486n.get("SETTING_WPNAV_LOIT_SPD").intValue() == 1) {
                            b(a3);
                            x.a().a("READ_WPNAV_LOIT_SPD_ONE", true);
                            a("SETTING_PSC_YYZ_UP_SPED", "PSC_YYZ_UP_SPED", "READ_PSC_YYZ_UP_SPED_ONE", 1);
                        } else if (this.f12486n.get("SETTING_WPNAV_LOIT_SPD").intValue() == 2) {
                            b(a3);
                            if (this.f12493u == this.f12497y) {
                                x.a().a("READ_WPNAV_LOIT_SPD_TWO", true);
                            }
                        }
                        this.f12486n.put("SETTING_WPNAV_LOIT_SPD", 0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneWarnning(ad adVar) {
        String str;
        String str2;
        String str3;
        if (this.f12474b.d().f().equalsIgnoreCase(this.f12473a.getString(R.string.level_speed_success))) {
            str = "SETTING_WPNAV_LOIT_SPD";
            str2 = "WPNAV_LOIT_SPD";
            str3 = "READ_WPNAV_LOIT_SPD_TWO";
        } else if (this.f12474b.d().f().equalsIgnoreCase(this.f12473a.getString(R.string.up_speed_success))) {
            str = "SETTING_PSC_YYZ_UP_SPED";
            str2 = "PSC_YYZ_UP_SPED";
            str3 = "READ_PSC_YYZ_UP_SPED_TWO";
        } else if (this.f12474b.d().f().equalsIgnoreCase(this.f12473a.getString(R.string.down_speed_success))) {
            str = "SETTING_PSC_YYZ_Dw_SPED";
            str2 = "PSC_YYZ_Dw_SPED";
            str3 = "READ_PSC_YYZ_Dw_SPED_TWO";
        } else if (this.f12474b.d().f().equalsIgnoreCase(this.f12473a.getString(R.string.beginner_not_set))) {
            CommonUI.a((Context) this.f12473a, getView(), Integer.valueOf(R.string.beginner_not_speed), this.f12473a.getString(R.string.i_see), (CommonUI.b) null);
            return;
        } else {
            return;
        }
        a(str, str2, str3, 2);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12473a = (FlightActionActivity) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.rc_speed_dlg, viewGroup, false);
        this.f12474b = ((XEagleApp) this.f12473a.getApplicationContext()).k();
        this.f12475c = ((XEagleApp) this.f12473a.getApplicationContext()).j();
        a(inflate);
        b();
        return inflate;
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
}
