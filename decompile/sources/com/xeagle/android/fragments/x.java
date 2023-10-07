package com.xeagle.android.fragments;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.widgets.button.SwitchButton;
import kx.d;

public class x extends b implements View.OnClickListener {
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public boolean F;
    /* access modifiers changed from: private */
    public boolean G;
    /* access modifiers changed from: private */
    public boolean H;
    /* access modifiers changed from: private */
    public boolean I;
    /* access modifiers changed from: private */
    public RelativeLayout J;
    /* access modifiers changed from: private */
    public RelativeLayout K;
    /* access modifiers changed from: private */
    public RelativeLayout L;
    /* access modifiers changed from: private */
    public RelativeLayout M;
    /* access modifiers changed from: private */
    public TextView N;
    /* access modifiers changed from: private */
    public TextView O;
    /* access modifiers changed from: private */
    public TextView P;
    /* access modifiers changed from: private */
    public TextView Q;
    /* access modifiers changed from: private */
    public TextView R;
    /* access modifiers changed from: private */
    public String S;

    /* renamed from: e  reason: collision with root package name */
    protected a f23539e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SwitchButton f23540f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public SwitchButton f23541g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f23542h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f23543i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public SwitchButton f23544j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public SwitchButton f23545k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public SwitchButton f23546l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public SwitchButton f23547m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public SwitchButton f23548n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public SwitchButton f23549o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public SwitchButton f23550p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public SwitchButton f23551q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f23552r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f23553s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f23554t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f23555u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public LinearLayout f23556v;

    /* renamed from: w  reason: collision with root package name */
    private View f23557w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f23558x = false;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f23559y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f23560z;

    private String a(Context context) {
        return d.a(context);
    }

    private void a(View view) {
        this.f23540f = (SwitchButton) view.findViewById(R.id.ui_language);
        this.f23541g = (SwitchButton) view.findViewById(R.id.keep_screen_on);
        this.f23542h = (TextView) view.findViewById(R.id.spoken_interval_sp);
        this.f23543i = (SwitchButton) view.findViewById(R.id.battery_voltage_on);
        this.f23544j = (SwitchButton) view.findViewById(R.id.altitude_on);
        this.f23545k = (SwitchButton) view.findViewById(R.id.airspeed_on);
        this.f23546l = (SwitchButton) view.findViewById(R.id.low_singal_on);
        this.f23547m = (SwitchButton) view.findViewById(R.id.lost_singal_on);
        this.f23548n = (SwitchButton) view.findViewById(R.id.altitude_limit_on);
        this.f23549o = (SwitchButton) view.findViewById(R.id.autopilot_on);
        this.f23550p = (SwitchButton) view.findViewById(R.id.notification_on);
        this.f23551q = (SwitchButton) view.findViewById(R.id.tts_enable_on);
        this.f23552r = (TextView) view.findViewById(R.id.app_version_sp);
        this.f23553s = (TextView) view.findViewById(R.id.file_path_sp);
        this.f23555u = (LinearLayout) view.findViewById(R.id.ll_tts);
        this.f23556v = (LinearLayout) view.findViewById(R.id.ll_tts_data);
        this.f23554t = (TextView) view.findViewById(R.id.app_bt_sp);
        this.J = (RelativeLayout) view.findViewById(R.id.usb_rl);
        this.R = (TextView) view.findViewById(R.id.usb_baud_sp);
        this.K = (RelativeLayout) view.findViewById(R.id.bt_rl);
        this.N = (TextView) view.findViewById(R.id.tele_select_sp);
        this.L = (RelativeLayout) view.findViewById(R.id.tcp_rl);
        this.O = (TextView) view.findViewById(R.id.tcp_ip_sp);
        this.P = (TextView) view.findViewById(R.id.tcp_port_sp);
        this.M = (RelativeLayout) view.findViewById(R.id.udp_rl);
        this.Q = (TextView) view.findViewById(R.id.udp_sp);
        this.N.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.f23554t.setOnClickListener(this);
        this.f23554t.setText(com.xeagle.android.camera.widgets.ablum.b.b(getActivity().getString(R.string.pref_bluetooth_device_address_key), (String) null));
        this.f23542h.setOnClickListener(this);
        this.f23552r.setText(e());
        this.f23553s.setText(a(getActivity().getApplicationContext()));
        this.f23540f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.e(z2);
                    }
                }).start();
            }
        });
        this.f23541g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.k(z2);
                    }
                }).start();
            }
        });
        this.f23543i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.b(z2);
                    }
                }).start();
            }
        });
        this.f23544j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.c(z2);
                    }
                }).start();
            }
        });
        this.f23545k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.d(z2);
                    }
                }).start();
            }
        });
        this.f23546l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.i(z2);
                    }
                }).start();
            }
        });
        this.f23547m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.h(z2);
                    }
                }).start();
            }
        });
        this.f23548n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.g(z2);
                    }
                }).start();
            }
        });
        this.f23549o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.j(z2);
                    }
                }).start();
            }
        });
        this.f23550p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.f(z2);
                    }
                }).start();
            }
        });
        this.f23551q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        x.this.a(z2);
                        if (x.this.getActivity() != null) {
                            x.this.getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    int i2 = 0;
                                    x.this.f23555u.setVisibility(z2 ? 0 : 8);
                                    LinearLayout x2 = x.this.f23556v;
                                    if (!z2) {
                                        i2 = 8;
                                    }
                                    x2.setVisibility(i2);
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        Toast.makeText(getActivity(), this.f23539e.L(), 0).show();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_enable_tts", z2);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_periodic_bat_volt", z2);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f23558x = com.xeagle.android.camera.widgets.ablum.b.b("pref_ui_language_english", false);
        this.f23559y = com.xeagle.android.camera.widgets.ablum.b.b("pref_keep_screen_bright", false);
        this.f23560z = com.xeagle.android.camera.widgets.ablum.b.b("pref_request_max_volume", false);
        this.A = com.xeagle.android.camera.widgets.ablum.b.b("tts_periodic_alt", false);
        this.B = com.xeagle.android.camera.widgets.ablum.b.b("tts_periodic_airspeed", false);
        this.C = com.xeagle.android.camera.widgets.ablum.b.b("tts_periodic_bat_volt", false);
        this.D = com.xeagle.android.camera.widgets.ablum.b.b("pref_enable_tts", true);
        this.E = com.xeagle.android.camera.widgets.ablum.b.b("tts_ceiling_exceeded", true);
        this.F = com.xeagle.android.camera.widgets.ablum.b.b("tts_lost_signal", true);
        this.G = com.xeagle.android.camera.widgets.ablum.b.b("tts_low_signal", false);
        this.H = com.xeagle.android.camera.widgets.ablum.b.b("tts_autopilot_warning", false);
        this.I = com.xeagle.android.camera.widgets.ablum.b.b("pref_permanent_notification", false);
        this.f23542h.setText(com.xeagle.android.camera.widgets.ablum.b.b("tts_periodic_tv", getString(R.string.pref_tts_off)));
        this.N.setText(b());
        this.R.setText(com.xeagle.android.camera.widgets.ablum.b.b("pref_baud_type", "57600"));
        this.O.setText(com.xeagle.android.camera.widgets.ablum.b.b("pref_server_ip", "192.168.4.1"));
        this.P.setText(com.xeagle.android.camera.widgets.ablum.b.b("pref_server_port", "6789"));
        this.Q.setText(com.xeagle.android.camera.widgets.ablum.b.b("pref_udp_server_port", "8090"));
        this.S = b();
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    RelativeLayout D;
                    x.this.f23540f.setChecked(x.this.f23558x);
                    x.this.f23541g.setChecked(x.this.f23559y);
                    x.this.f23544j.setChecked(x.this.A);
                    x.this.f23545k.setChecked(x.this.B);
                    x.this.f23543i.setChecked(x.this.C);
                    x.this.f23548n.setChecked(x.this.E);
                    x.this.f23547m.setChecked(x.this.F);
                    x.this.f23546l.setChecked(x.this.G);
                    x.this.f23549o.setChecked(x.this.H);
                    x.this.f23550p.setChecked(x.this.I);
                    x.this.f23551q.setChecked(x.this.D);
                    int i2 = 8;
                    x.this.f23555u.setVisibility(x.this.D ? 0 : 8);
                    LinearLayout x2 = x.this.f23556v;
                    if (x.this.D) {
                        i2 = 0;
                    }
                    x2.setVisibility(i2);
                    if (x.this.S.equals("BLUETOOTH")) {
                        x.this.d();
                        D = x.this.K;
                    } else if (x.this.S.equals("USB")) {
                        x.this.d();
                        D = x.this.J;
                    } else if (x.this.S.equals("TCP")) {
                        x.this.d();
                        D = x.this.L;
                    } else if (x.this.S.equals("UDP")) {
                        x.this.d();
                        D = x.this.M;
                    } else {
                        return;
                    }
                    D.setVisibility(0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_periodic_alt", z2);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_periodic_airspeed", z2);
    }

    private String e() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_periodic_status_period", str);
    }

    /* access modifiers changed from: private */
    public void e(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_ui_language_english", z2);
    }

    /* access modifiers changed from: private */
    public void f(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a(getString(R.string.pref_connection_type_key), str);
    }

    /* access modifiers changed from: private */
    public void f(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_permanent_notification", z2);
    }

    /* access modifiers changed from: private */
    public void g(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_ceiling_exceeded", z2);
    }

    /* access modifiers changed from: private */
    public void h(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_lost_signal", z2);
    }

    /* access modifiers changed from: private */
    public void i(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_low_signal", z2);
    }

    /* access modifiers changed from: private */
    public void j(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("tts_autopilot_warning", z2);
    }

    /* access modifiers changed from: private */
    public void k(boolean z2) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_keep_screen_bright", z2);
    }

    public void a(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_server_ip", str);
    }

    public String b() {
        return com.xeagle.android.camera.widgets.ablum.b.b(getString(R.string.pref_connection_type_key), "TCP");
    }

    public void b(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_server_port", str);
    }

    public void c(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_udp_server_port", str);
    }

    public void d(String str) {
        com.xeagle.android.camera.widgets.ablum.b.a("pref_baud_type", str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0197, code lost:
        r8.create().show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x014c, code lost:
        r8.setNegativeButton(r0, r1);
        r8.show();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            android.widget.ArrayAdapter r0 = new android.widget.ArrayAdapter
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2130903123(0x7f030053, float:1.7413055E38)
            java.lang.String[] r2 = r2.getStringArray(r3)
            r3 = 2131493431(0x7f0c0237, float:1.8610342E38)
            r0.<init>(r1, r3, r2)
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            android.content.res.Resources r4 = r7.getResources()
            r5 = 2130903057(0x7f030011, float:1.7412921E38)
            java.lang.String[] r4 = r4.getStringArray(r5)
            r1.<init>(r2, r3, r4)
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            androidx.fragment.app.FragmentActivity r4 = r7.getActivity()
            android.content.res.Resources r5 = r7.getResources()
            r6 = 2130903056(0x7f030010, float:1.741292E38)
            java.lang.String[] r5 = r5.getStringArray(r6)
            r2.<init>(r4, r3, r5)
            int r8 = r8.getId()
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 2131823141(0x7f110a25, float:1.9279073E38)
            r5 = 2131821747(0x7f1104b3, float:1.9276246E38)
            java.lang.String r6 = "#FF4081"
            switch(r8) {
                case 2131296494: goto L_0x016c;
                case 2131298991: goto L_0x0153;
                case 2131299104: goto L_0x010d;
                case 2131299105: goto L_0x00ca;
                case 2131299108: goto L_0x00b0;
                case 2131299601: goto L_0x006c;
                case 2131299628: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x019e
        L_0x0052:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "USB波特率"
            android.app.AlertDialog$Builder r8 = r8.setTitle(r0)
            com.xeagle.android.fragments.x$9 r0 = new com.xeagle.android.fragments.x$9
            r0.<init>()
            android.app.AlertDialog$Builder r8 = r8.setAdapter(r2, r0)
            goto L_0x0197
        L_0x006c:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "UDP Port"
            r8.setTitle(r0)
            android.widget.EditText r0 = new android.widget.EditText
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            r0.<init>(r1)
            int r1 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r1)
            android.widget.TextView r1 = r7.Q
            java.lang.CharSequence r1 = r1.getText()
            r0.setText(r1)
            r0.setInputType(r3)
            r8.setView(r0)
            java.lang.String r1 = r7.getString(r5)
            com.xeagle.android.fragments.x$15 r2 = new com.xeagle.android.fragments.x$15
            r2.<init>(r0)
            r8.setPositiveButton(r1, r2)
            java.lang.String r0 = r7.getString(r4)
            com.xeagle.android.fragments.x$16 r1 = new com.xeagle.android.fragments.x$16
            r1.<init>()
            goto L_0x014c
        L_0x00b0:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "数传连接方式"
            android.app.AlertDialog$Builder r8 = r8.setTitle(r0)
            com.xeagle.android.fragments.x$8 r0 = new com.xeagle.android.fragments.x$8
            r0.<init>()
            android.app.AlertDialog$Builder r8 = r8.setAdapter(r1, r0)
            goto L_0x0197
        L_0x00ca:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "TCP Port"
            r8.setTitle(r0)
            android.widget.EditText r0 = new android.widget.EditText
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            r0.<init>(r1)
            int r1 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r1)
            android.widget.TextView r1 = r7.P
            java.lang.CharSequence r1 = r1.getText()
            r0.setText(r1)
            r0.setInputType(r3)
            r8.setView(r0)
            java.lang.String r1 = r7.getString(r5)
            com.xeagle.android.fragments.x$13 r2 = new com.xeagle.android.fragments.x$13
            r2.<init>(r0)
            r8.setPositiveButton(r1, r2)
            java.lang.String r0 = r7.getString(r4)
            com.xeagle.android.fragments.x$14 r1 = new com.xeagle.android.fragments.x$14
            r1.<init>()
            goto L_0x014c
        L_0x010d:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "TCP IP"
            r8.setTitle(r0)
            android.widget.EditText r0 = new android.widget.EditText
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            r0.<init>(r1)
            int r1 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r1)
            android.widget.TextView r1 = r7.O
            java.lang.CharSequence r1 = r1.getText()
            r0.setText(r1)
            r8.setView(r0)
            java.lang.String r1 = r7.getString(r5)
            com.xeagle.android.fragments.x$10 r2 = new com.xeagle.android.fragments.x$10
            r2.<init>(r0)
            r8.setPositiveButton(r1, r2)
            java.lang.String r0 = r7.getString(r4)
            com.xeagle.android.fragments.x$11 r1 = new com.xeagle.android.fragments.x$11
            r1.<init>()
        L_0x014c:
            r8.setNegativeButton(r0, r1)
            r8.show()
            goto L_0x019e
        L_0x0153:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            r8.<init>(r1)
            java.lang.String r1 = "语音播报周期"
            android.app.AlertDialog$Builder r8 = r8.setTitle(r1)
            com.xeagle.android.fragments.x$5 r1 = new com.xeagle.android.fragments.x$5
            r1.<init>()
            android.app.AlertDialog$Builder r8 = r8.setAdapter(r0, r1)
            goto L_0x0197
        L_0x016c:
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r8.<init>(r0)
            java.lang.String r0 = "蓝牙地址"
            android.app.AlertDialog$Builder r8 = r8.setTitle(r0)
            java.lang.String r0 = "确认是否清除蓝牙地址？"
            android.app.AlertDialog$Builder r8 = r8.setMessage(r0)
            com.xeagle.android.fragments.x$7 r0 = new com.xeagle.android.fragments.x$7
            r0.<init>()
            java.lang.String r1 = "Cancel"
            android.app.AlertDialog$Builder r8 = r8.setNegativeButton(r1, r0)
            com.xeagle.android.fragments.x$6 r0 = new com.xeagle.android.fragments.x$6
            r0.<init>()
            java.lang.String r1 = "OK"
            android.app.AlertDialog$Builder r8 = r8.setPositiveButton(r1, r0)
        L_0x0197:
            android.app.AlertDialog r8 = r8.create()
            r8.show()
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.x.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23557w = layoutInflater.inflate(R.layout.system_setting_fragment, viewGroup, false);
        this.f23539e = new a(getActivity().getApplicationContext());
        return this.f23557w;
    }

    public void onResume() {
        super.onResume();
        c();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
        com.xeagle.android.camera.widgets.ablum.b.b(getActivity());
        c();
    }
}
