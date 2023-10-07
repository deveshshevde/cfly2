package com.xeagle.android.activities;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.v;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.g;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.f;
import com.xeagle.android.dialogs.q;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.dialogs.u;
import com.xeagle.android.dialogs.w;
import com.xeagle.android.login.common.service.RcUdpReceiver;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.permission.PermissionActivity;
import com.xeagle.android.utils.w;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.activity.PdfListActivity;
import com.xeagle.android.vjoystick.utils.e;
import com.xeagle.android.widgets.scViewPager.DotsView;
import com.xeagle.android.widgets.scViewPager.SCViewPager;
import dy.ab;
import dy.ak;
import dy.al;
import dy.ax;
import dy.b;
import dy.k;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.ThreadMode;

public class MainViewActivity extends SuperUI implements View.OnClickListener, DroneInterfaces.e {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f12314a = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static int f12315k = 5;
    private IImageButton A;
    /* access modifiers changed from: private */
    public RelativeLayout B;
    private a C;
    /* access modifiers changed from: private */
    public int[] D = {R.drawable.product_808};
    /* access modifiers changed from: private */
    public int[] E = {R.drawable.product_808};
    private com.xeagle.android.utils.permission.a F;
    private final BroadcastReceiver G = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            intent.getExtras();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                Log.e("WIFI状态", "wifiState:---" + intExtra);
                if (intExtra == 0) {
                    str = "wifiState:WIFI_STATE_DISABLING";
                } else if (intExtra == 1) {
                    Log.e("WIFI状态", "wifiState:WIFI_STATE_DISABLED");
                    if (MainViewActivity.this.f12324r != null) {
                        MainViewActivity.this.f12316b.a((Runnable) new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12321o.setEnabled(true);
                                MainViewActivity.this.f12321o.setTextColor(-16777216);
                                MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                            }
                        });
                        MainViewActivity.this.f12324r.a();
                        return;
                    }
                    return;
                } else if (intExtra == 2) {
                    Log.e("WIFI状态", "wifiState:WIFI_STATE_ENABLING");
                    boolean unused = MainViewActivity.this.f12330x = false;
                    MainViewActivity.this.f12321o.setEnabled(false);
                    MainViewActivity.this.f12321o.setTextColor(-7829368);
                    MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.connecting));
                    return;
                } else if (intExtra == 3) {
                    Log.e("WIFI状态", "wifiState:WIFI_STATE_ENABLED");
                    if (!MainViewActivity.this.f12324r.i().contains("Drone") && !MainViewActivity.this.f12324r.i().contains("Controller") && !MainViewActivity.this.f12324r.i().contains("Ground")) {
                        Timer unused2 = MainViewActivity.this.f12325s = new Timer();
                        new Thread(new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12325s.schedule(new TimerTask() {
                                    public void run() {
                                        MainViewActivity.this.f12324r.a();
                                        MainViewActivity.this.f12324r.d();
                                        SystemClock.sleep(400);
                                        c.a(MainViewActivity.this.f12325s, MainViewActivity.this.f12324r, MainViewActivity.this.f12316b);
                                    }
                                }, 100, 2000);
                                final Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    public void run() {
                                        MainViewActivity.this.f12325s.cancel();
                                        timer.cancel();
                                    }
                                }, 60000);
                            }
                        }).start();
                    }
                    Log.i("version", "onReceive: ------>>>>>>>>>>>enabled::::" + MainViewActivity.this.f12324r.i());
                    if (MainViewActivity.this.f12324r.i().equalsIgnoreCase("<unknown ssid>") || (!MainViewActivity.this.f12324r.i().contains("Drone") && !MainViewActivity.this.f12324r.i().contains("Controller") && !MainViewActivity.this.f12324r.i().contains("Ground"))) {
                        MainViewActivity.this.f12316b.a((Runnable) new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12321o.setEnabled(true);
                                MainViewActivity.this.f12321o.setTextColor(-16777216);
                                MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                            }
                        });
                        return;
                    }
                    Log.i("version", "onReceive: isEnable-----" + MainViewActivity.this.f12324r.b());
                    boolean unused3 = MainViewActivity.this.f12330x = false;
                    MainViewActivity.this.b();
                    MainViewActivity.this.f12326t.a(3000);
                    MainViewActivity.this.f12326t.a(MainViewActivity.this.f12327u);
                    MainViewActivity.this.f12326t.c();
                    if (MainViewActivity.this.f12324r.i().contains("Controller") || MainViewActivity.this.f12324r.i().contains("Ground")) {
                        MainViewActivity.this.startService(new Intent(MainViewActivity.this, RcUdpReceiver.class));
                        return;
                    }
                    return;
                } else if (intExtra == 4) {
                    str = "wifiState:WIFI_STATE_UNKNOWN";
                } else {
                    return;
                }
                Log.e("WIFI状态", str);
                return;
            }
            "android.net.wifi.SCAN_RESULTS".equals(action);
        }
    };
    private final Runnable H = new Runnable() {
        public void run() {
            g.a(MainViewActivity.this.f12358g);
        }
    };
    private boolean I = false;

    /* renamed from: b  reason: collision with root package name */
    e f12316b = new e(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 4) {
                    TextView textView = new TextView(MainViewActivity.this);
                    textView.setText("current wifi:" + MainViewActivity.this.f12324r.i());
                    textView.setTextSize(12.0f);
                    textView.setGravity(8388661);
                    textView.setTextColor(-16777216);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, c.a((Context) MainViewActivity.this, 10.0f), c.a((Context) MainViewActivity.this, 30.0f), 0);
                    MainViewActivity.this.B.addView(textView, layoutParams);
                }
            } else if (!MainViewActivity.this.f12358g.j().a()) {
                MainViewActivity.this.i();
            }
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    Runnable f12317c = new Runnable() {
        public void run() {
            MainViewActivity.this.b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public SCViewPager f12318l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public DotsView f12319m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f12320n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public TextView f12321o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public XEagleApp f12322p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f12323q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public com.flypro.core.util.e f12324r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Timer f12325s = null;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public w f12326t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f12327u = 12;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f12328v = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f12329w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f12330x = false;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f12331y = false;

    /* renamed from: z  reason: collision with root package name */
    private IImageButton f12332z;

    class a extends androidx.viewpager.widget.a {

        /* renamed from: b  reason: collision with root package name */
        private int[] f22267b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f22268c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f22269d;

        public a(int[] iArr) {
            this.f22267b = iArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f22267b.length;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            int i3;
            Resources resources;
            this.f22269d = new ImageView(viewGroup.getContext().getApplicationContext());
            if (MainViewActivity.this.f12358g.y() == null || !MainViewActivity.this.f12358g.y().contains("P")) {
                resources = MainViewActivity.this.getResources();
                i3 = MainViewActivity.this.D[i2];
            } else {
                resources = MainViewActivity.this.getResources();
                i3 = MainViewActivity.this.E[i2];
            }
            this.f22268c = BitmapFactory.decodeResource(resources, i3);
            this.f22269d.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f22269d.setImageBitmap(this.f22268c);
            viewGroup.addView(this.f22269d, -1, -1);
            return this.f22269d;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private void a(Context context, View view) {
        v vVar = new v(context, view);
        try {
            Field declaredField = vVar.getClass().getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            ((l) declaredField.get(vVar)).a(true);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        vVar.a((int) R.menu.menu_more_info);
        vVar.a((v.b) new v.b() {
            public boolean a(MenuItem menuItem) {
                Intent intent;
                Toast makeText;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.menu_enter_cfly) {
                    intent = new Intent(MainViewActivity.this, CflyNetActivity.class);
                } else if (itemId != R.id.menu_help_offer) {
                    if (itemId == R.id.menu_pair_rc) {
                        if (MainViewActivity.this.f12358g.d().c()) {
                            makeText = Toast.makeText(MainViewActivity.this, R.string.cal_is_flying, 0);
                        } else if (MainViewActivity.this.f12324r.i().contains("Ground")) {
                            com.xeagle.android.dialogs.w a2 = com.xeagle.android.dialogs.w.a(MainViewActivity.this.getString(R.string.pair_rc), "pair rc", new w.a() {
                                public void onYes() {
                                }
                            });
                            if (a2 != null) {
                                a2.show(MainViewActivity.this.getSupportFragmentManager(), "pair");
                            }
                        } else if (MainViewActivity.this.f12324r.i().contains("Drone")) {
                            q a3 = q.a(MainViewActivity.this.getString(R.string.pair_rc), "wifi name", new q.b() {
                                public void onYes() {
                                }
                            });
                            if (a3 != null) {
                                a3.show(MainViewActivity.this.getSupportFragmentManager(), "wifi-name");
                            }
                        } else {
                            MainViewActivity mainViewActivity = MainViewActivity.this;
                            makeText = Toast.makeText(mainViewActivity, mainViewActivity.getString(R.string.scan_sure_connect), 1);
                        }
                        makeText.show();
                    }
                    return true;
                } else {
                    intent = new Intent(MainViewActivity.this, PdfListActivity.class);
                }
                MainViewActivity.this.startActivity(intent);
                return true;
            }
        });
        vVar.b();
    }

    private void a(SpannableString spannableString, int i2, int i3, int i4, int i5) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(foregroundColorSpan, i2, i3, 17);
        spannableString.setSpan(foregroundColorSpan, i4, i5, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(MainViewActivity.this.getString(R.string.policy_privacy_title), MainViewActivity.this.getString(R.string.policy_privacy_text), new u.a() {
                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(MainViewActivity.this.getSupportFragmentManager(), "policy");
                }
            }
        }, i2, i3, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(MainViewActivity.this.getString(R.string.user_notice_title), MainViewActivity.this.getString(R.string.user_notice_text), new u.a() {
                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(MainViewActivity.this.getSupportFragmentManager(), "user");
                }
            }
        }, i4, i5, 17);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        Runnable runnable;
        e eVar;
        if (!this.f12324r.i().contains("Drone") && !this.f12324r.i().contains("Controller") && !this.f12324r.i().contains("Ground")) {
            this.f12330x = true;
            eVar = this.f12316b;
            runnable = new Runnable() {
                public void run() {
                    MainViewActivity.this.f12321o.setEnabled(true);
                    MainViewActivity.this.f12321o.setTextColor(-16777216);
                    MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                }
            };
        } else if (this.f12358g.y() == null) {
            Log.i("version", "onPageSelected: rec----" + this.f12328v);
            if (this.f12329w < f12315k) {
                this.f12330x = false;
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        MainViewActivity.this.f12321o.setEnabled(false);
                        MainViewActivity.this.f12321o.setTextColor(-7829368);
                        MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.connecting));
                    }
                };
            } else {
                boolean z2 = this.f12328v;
                this.f12330x = true;
                if (!z2) {
                    eVar = this.f12316b;
                    runnable = new Runnable() {
                        public void run() {
                            MainViewActivity.this.f12321o.setEnabled(true);
                            MainViewActivity.this.f12321o.setTextColor(-16777216);
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                        }
                    };
                } else {
                    eVar = this.f12316b;
                    runnable = new Runnable() {
                        public void run() {
                            MainViewActivity.this.f12321o.setEnabled(true);
                            MainViewActivity.this.f12321o.setTextColor(-16777216);
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                        }
                    };
                }
            }
        } else if (this.f12358g.y().contains(str) || this.f12358g.y().contains(str2)) {
            this.f12330x = true;
            eVar = this.f12316b;
            runnable = new Runnable() {
                public void run() {
                    MainViewActivity.this.f12321o.setEnabled(true);
                    MainViewActivity.this.f12321o.setTextColor(-16777216);
                    MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                }
            };
        } else {
            this.f12330x = true;
            eVar = this.f12316b;
            runnable = new Runnable() {
                public void run() {
                    MainViewActivity.this.f12321o.setEnabled(false);
                    MainViewActivity.this.f12321o.setTextColor(-7829368);
                    MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.model_not_paired));
                }
            };
        }
        eVar.a(runnable);
    }

    private void a(String str, boolean z2, String str2) {
        if (z2) {
            d a2 = d.a(getString(R.string.dialog_tips), str, new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    MainViewActivity.this.k();
                }
            });
            if (a2 != null) {
                a2.show(getSupportFragmentManager(), str2);
                return;
            }
            return;
        }
        com.xeagle.android.dialogs.c a3 = r.a().a(getString(R.string.dialog_tips), str, (c.a) new c.a() {
            public void onYes() {
            }
        });
        if (a3 != null) {
            a3.show(getSupportFragmentManager(), str2);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.f12358g.j().a()) {
            i();
            this.f12316b.b(this.f12317c);
            this.f12316b.a(this.f12317c, 1500);
            return;
        }
        this.f12316b.b(this.f12317c);
    }

    private void d() {
        int i2;
        int i3;
        int i4;
        int i5;
        this.f12326t = new com.xeagle.android.utils.w(this);
        this.f12324r = new com.flypro.core.util.e(getApplicationContext());
        TextView textView = (TextView) findViewById(R.id.bt_start);
        this.f12321o = textView;
        textView.setEnabled(false);
        this.f12321o.setTextColor(-7829368);
        this.f12321o.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.app_policy);
        SpannableString spannableString = new SpannableString(getString(R.string.policy_notice_text));
        if (!com.xeagle.android.utils.c.b((Context) this) && !com.xeagle.android.utils.c.a((Context) this)) {
            i2 = 16;
            i3 = 30;
            i4 = 35;
            i5 = 46;
        } else {
            i2 = 6;
            i3 = 11;
            i4 = 12;
            i5 = spannableString.length();
        }
        a(spannableString, i2, i3, i4, i5);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(spannableString);
        findViewById(R.id.bt_help).setOnClickListener(this);
        this.f12318l = (SCViewPager) findViewById(R.id.product_vp);
        DotsView dotsView = (DotsView) findViewById(R.id.product_dv);
        this.f12319m = dotsView;
        dotsView.setVisibility(8);
        this.f12320n = (TextView) findViewById(R.id.app_version);
        this.f12332z = (IImageButton) findViewById(R.id.firmware_upload);
        IImageButton iImageButton = (IImageButton) findViewById(R.id.view_more_info);
        this.A = iImageButton;
        iImageButton.setOnClickListener(this);
        this.f12332z.setOnClickListener(this);
        this.f12320n.setText(g());
        this.f12319m.a(R.drawable.select_active, R.drawable.select_disactive);
        this.f12319m.setNumberOfPage(4);
        this.B = (RelativeLayout) findViewById(R.id.main_rl);
        a aVar = new a(this.D);
        this.C = aVar;
        this.f12318l.setAdapter(aVar);
        this.f12318l.setOnPageChangeListener(new ViewPager.e() {
            public void onPageScrollStateChanged(int i2) {
            }

            public void onPageScrolled(int i2, float f2, int i3) {
            }

            public void onPageSelected(int i2) {
                MainViewActivity mainViewActivity;
                String str;
                String str2;
                e eVar;
                Runnable runnable;
                MainViewActivity.this.f12319m.a(i2);
                if (i2 == 0) {
                    if (!MainViewActivity.this.f12324r.i().contains("Drone") && !MainViewActivity.this.f12324r.i().contains("Controller") && !MainViewActivity.this.f12324r.i().contains("Ground")) {
                        boolean unused = MainViewActivity.this.f12330x = true;
                        eVar = MainViewActivity.this.f12316b;
                        runnable = new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12321o.setEnabled(true);
                                MainViewActivity.this.f12321o.setTextColor(-16777216);
                                MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                            }
                        };
                    } else if (MainViewActivity.this.f12358g.y() == null) {
                        if (MainViewActivity.this.f12329w < MainViewActivity.f12315k) {
                            boolean unused2 = MainViewActivity.this.f12330x = false;
                            eVar = MainViewActivity.this.f12316b;
                            runnable = new Runnable() {
                                public void run() {
                                    MainViewActivity.this.f12321o.setEnabled(false);
                                    MainViewActivity.this.f12321o.setTextColor(-7829368);
                                    MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.connecting));
                                }
                            };
                        } else {
                            Log.i("version", "onPageSelected: recvvvv----" + MainViewActivity.this.f12328v);
                            if (!MainViewActivity.this.f12328v) {
                                boolean unused3 = MainViewActivity.this.f12330x = true;
                                eVar = MainViewActivity.this.f12316b;
                                runnable = new Runnable() {
                                    public void run() {
                                        MainViewActivity.this.f12321o.setEnabled(true);
                                        MainViewActivity.this.f12321o.setTextColor(-16777216);
                                        MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                                    }
                                };
                            } else {
                                boolean unused4 = MainViewActivity.this.f12330x = true;
                                eVar = MainViewActivity.this.f12316b;
                                runnable = new Runnable() {
                                    public void run() {
                                        MainViewActivity.this.f12321o.setEnabled(true);
                                        MainViewActivity.this.f12321o.setTextColor(-16777216);
                                        MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                                    }
                                };
                            }
                        }
                    } else if (MainViewActivity.this.f12358g.y().contains("Faith") || MainViewActivity.this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) {
                        boolean unused5 = MainViewActivity.this.f12330x = true;
                        eVar = MainViewActivity.this.f12316b;
                        runnable = new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12321o.setEnabled(true);
                                MainViewActivity.this.f12321o.setTextColor(-16777216);
                                MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                            }
                        };
                    } else {
                        boolean unused6 = MainViewActivity.this.f12330x = true;
                        eVar = MainViewActivity.this.f12316b;
                        runnable = new Runnable() {
                            public void run() {
                                MainViewActivity.this.f12321o.setEnabled(false);
                                MainViewActivity.this.f12321o.setTextColor(-7829368);
                                MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.model_not_paired));
                            }
                        };
                    }
                    eVar.a(runnable);
                    return;
                }
                if (i2 == 1) {
                    mainViewActivity = MainViewActivity.this;
                    str = "Smart";
                    str2 = UserGlobal.DRONE_TYPE_DF805;
                } else if (i2 == 2) {
                    mainViewActivity = MainViewActivity.this;
                    str = "Dream";
                    str2 = UserGlobal.DRONE_TYPE_DF801;
                } else if (i2 == 3) {
                    mainViewActivity = MainViewActivity.this;
                    str = "Obtain";
                    str2 = UserGlobal.DRONE_TYPE_DF803;
                } else {
                    return;
                }
                mainViewActivity.a(str, str2);
            }
        });
    }

    private void e() {
        if (!((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            new AlertDialog.Builder(this).setTitle(R.string.warning).setMessage(R.string.gps_message).setCancelable(false).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    MainViewActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    Toast.makeText(MainViewActivity.this, R.string.gps_close, 0).show();
                }
            }).show();
        }
    }

    private void j() {
        if (!this.f12358g.j().a()) {
            new Thread(new Runnable() {
                public void run() {
                    Looper.prepare();
                    MainViewActivity.this.i();
                    Looper.loop();
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        this.f12323q.d("220");
        l();
    }

    private void l() {
        Intent intent = new Intent(this, FlightActionActivity.class);
        intent.putExtra("isFirst", true);
        finish();
        startActivity(intent);
    }

    private void m() {
        PermissionActivity.a(this, 0, f12314a);
    }

    private void n() {
        d a2 = d.a(getString(R.string.warning), getString(R.string.upload_firmware_notify), new d.a() {
            public void onNo() {
            }

            public void onYes() {
                if (MainViewActivity.this.f12324r.i().contains("Controller") || MainViewActivity.this.f12324r.i().contains("Ground")) {
                    com.xeagle.android.dialogs.c a2 = r.a().a(MainViewActivity.this.getString(R.string.dialog_tips), MainViewActivity.this.getString(R.string.upload_firmware_rc), (c.a) new c.a() {
                        public void onYes() {
                        }
                    });
                    if (a2 != null) {
                        a2.show(MainViewActivity.this.getSupportFragmentManager(), "rc_warn");
                        return;
                    }
                    return;
                }
                f a3 = f.a(MainViewActivity.this.getString(R.string.dialog_tips), MainViewActivity.this.getString(R.string.upload_firmware_tip), MainViewActivity.this.getString(R.string.upload_txt_quit), MainViewActivity.this.getString(R.string.upload_txt_upgrade), new f.a() {
                    public void a() {
                        if (MainViewActivity.this.f12358g.j().a()) {
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            MainViewActivity.this.f12323q.j(true);
                            do {
                                if (MainViewActivity.this.f12358g.j().a()) {
                                    com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                                    if (MainViewActivity.this.f12358g.j().a()) {
                                        MainViewActivity.this.f12358g.j().a(6);
                                    }
                                    SystemClock.sleep(200);
                                }
                            } while (MainViewActivity.this.f12358g.j().a());
                            MainViewActivity.this.startActivity(new Intent(MainViewActivity.this, UploadFirmwareActivity.class));
                        }
                    }

                    public void b() {
                    }
                });
                if (a3 != null) {
                    a3.show(MainViewActivity.this.getSupportFragmentManager(), "update_tips");
                }
            }
        });
        if (a2 != null) {
            a2.show(getSupportFragmentManager(), "obtain_update");
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void bootVersionEvent(b bVar) {
        if (bVar.a() == 68 && !this.I) {
            this.I = true;
            this.f12323q.m(this.f12358g.A());
            if (this.f12358g.y() == null) {
                SystemClock.sleep(50);
                this.I = false;
                com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 88);
                return;
            }
            try {
                if (this.f12358g.A().contains("Obtain")) {
                    if (Double.valueOf(this.f12358g.y().substring(8, 11)).doubleValue() >= 4.4d) {
                        return;
                    }
                } else if (!this.f12358g.A().contains(UserGlobal.DRONE_TYPE_DF803)) {
                    if (!this.f12358g.A().contains("Dream")) {
                        if (!this.f12358g.A().contains(UserGlobal.DRONE_TYPE_DF801)) {
                            if (!this.f12358g.A().contains("Smart")) {
                                if (!this.f12358g.A().contains(UserGlobal.DRONE_TYPE_DF805)) {
                                    if ((!this.f12358g.A().contains("Faith") && !this.f12358g.A().contains(UserGlobal.DRONE_TYPE_DF806)) || Double.valueOf(this.f12358g.y().substring(7, 10)).doubleValue() >= 1.1d) {
                                        return;
                                    }
                                }
                            }
                            if (Double.valueOf(this.f12358g.y().substring(7, 10)).doubleValue() >= 1.1d) {
                                return;
                            }
                        }
                    }
                    if (Double.valueOf(this.f12358g.y().substring(7, 10)).doubleValue() >= 3.6d) {
                        return;
                    }
                } else if (Double.valueOf(this.f12358g.y().substring(7, 10)).doubleValue() >= 4.4d) {
                    return;
                }
                n();
            } catch (NumberFormatException e2) {
                Log.e("version", "error:" + e2.getMessage());
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public void droneRcControlEvent(dy.w wVar) {
        if (wVar.a() == 46) {
            this.f12322p.m().d(true);
            if (this.f12358g.E().a() == 1) {
                this.f12358g.D().a();
                return;
            }
            this.f12358g.D().e();
            if (!this.f12358g.d().e().b().equalsIgnoreCase("RTL") && !this.f12358g.d().e().b().equalsIgnoreCase("Land")) {
                this.f12358g.D().a(4, 1410.0d);
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public void droneUpdateFirmwareEvent(ab abVar) {
        e eVar;
        Runnable runnable;
        if (abVar.a() == 65) {
            this.f12326t.b();
            this.f12330x = true;
            this.f12331y = true;
            this.f12316b.a((Runnable) new Runnable() {
                public void run() {
                    MainViewActivity.this.f12321o.setTextColor(-16777216);
                    MainViewActivity.this.f12321o.setEnabled(true);
                }
            });
            if (this.f12358g.y().contains("Obtain") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF803)) {
                this.f12323q.d("350");
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(3);
                            MainViewActivity.this.f12318l.invalidate();
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Dream") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF801)) {
                this.f12323q.d("U21");
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(2);
                            MainViewActivity.this.f12318l.invalidate();
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Smart") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF805)) {
                this.f12323q.d("280");
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        com.xeagle.android.dialogs.c a2;
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(1);
                            MainViewActivity.this.f12318l.invalidate();
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                            if (MainViewActivity.this.f12322p.m().c() && MainViewActivity.this.f12358g.y().contains("DF805B") && (a2 = r.a().a(MainViewActivity.this.getString(R.string.warning), MainViewActivity.this.getString(R.string.warning), (c.a) new c.a() {
                                public void onYes() {
                                }
                            })) != null) {
                                a2.show(MainViewActivity.this.getSupportFragmentManager(), "smart");
                            }
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Faith") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) {
                this.f12323q.d("220");
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(0);
                            MainViewActivity.this.f12318l.invalidate();
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else {
                this.f12323q.d("220");
                eVar = this.f12316b;
                runnable = new Runnable() {
                    public void run() {
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(0);
                            MainViewActivity.this.f12318l.invalidate();
                        }
                    }
                };
            }
            eVar.a(runnable);
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public void heartbeatFirst(ak akVar) {
        if (akVar.a() == 6) {
            Log.i("HEART", "heartbeatFirst: ");
            new Thread(new Runnable() {
                public void run() {
                    while (!MainViewActivity.this.f12331y) {
                        Log.i("HEART", "heartbeatFirst:------- RECEIVE VERSION ");
                        com.flypro.core.MAVLink.b.a(MainViewActivity.this.f12358g, (byte) 99);
                        SystemClock.sleep(500);
                    }
                    Log.i("HEART", "heartbeatFirst:------- REQUEST DATA");
                    MainViewActivity.this.h();
                }
            }).start();
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public void heartbeatRestored(al alVar) {
        if (alVar.a() == 7) {
            com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
            SystemClock.sleep(20);
            com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
            SystemClock.sleep(20);
            com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
            SystemClock.sleep(20);
        }
    }

    public void notifyTimeOut(int i2) {
        e eVar;
        Runnable r0;
        this.f12329w = i2;
        if (i2 >= this.f12326t.a()) {
            Log.i("version", "notifyTimeOut:::350--->>>>" + this.f12328v);
            if (this.f12328v) {
                this.f12330x = true;
                this.f12323q.d("220");
                eVar = this.f12316b;
                r0 = new Runnable() {
                    public void run() {
                        if (MainViewActivity.this.f12318l != null) {
                            MainViewActivity.this.f12318l.setCurrentItem(0);
                            MainViewActivity.this.f12318l.invalidate();
                            MainViewActivity.this.f12321o.setTextColor(-16777216);
                            MainViewActivity.this.f12321o.setEnabled(true);
                            MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12324r.i().contains("Drone") || this.f12324r.i().contains("Controller") || this.f12324r.i().contains("Ground")) {
                j();
                return;
            } else {
                this.f12330x = true;
                eVar = this.f12316b;
                r0 = new Runnable() {
                    public void run() {
                        MainViewActivity.this.f12321o.setEnabled(true);
                        MainViewActivity.this.f12321o.setTextColor(-16777216);
                        MainViewActivity.this.f12321o.setText(MainViewActivity.this.getString(R.string.interface_view));
                    }
                };
            }
            eVar.a(r0);
        } else if (this.f12328v) {
            this.f12330x = true;
            this.f12316b.a((Runnable) new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ac, code lost:
                    if (r5.f22231a.f12358g.y().contains(com.xeagle.android.login.retrofitLogin.UserGlobal.DRONE_TYPE_DF806) == false) goto L_0x00ed;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                        if (r0 == 0) goto L_0x011c
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        r1 = 1
                        r2 = 0
                        java.lang.String r3 = "220"
                        if (r0 != 0) goto L_0x002a
                    L_0x0016:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                        r0.d((java.lang.String) r3)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                    L_0x0025:
                        r0.setCurrentItem(r2)
                        goto L_0x00ed
                    L_0x002a:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Dream"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00d9
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF801"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x004c
                        goto L_0x00d9
                    L_0x004c:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Obtain"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00c5
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF803"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x006d
                        goto L_0x00c5
                    L_0x006d:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Smart"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00b0
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF805"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x008e
                        goto L_0x00b0
                    L_0x008e:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Faith"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x0016
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF806"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x00ed
                        goto L_0x0016
                    L_0x00b0:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                        java.lang.String r2 = "280"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                        r0.setCurrentItem(r1)
                        goto L_0x00ed
                    L_0x00c5:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                        java.lang.String r2 = "350"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                        r2 = 3
                        goto L_0x0025
                    L_0x00d9:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                        java.lang.String r2 = "U21"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                        r2 = 2
                        goto L_0x0025
                    L_0x00ed:
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                        r0.invalidate()
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        android.widget.TextView r0 = r0.f12321o
                        r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                        r0.setTextColor(r2)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        android.widget.TextView r0 = r0.f12321o
                        r0.setEnabled(r1)
                        com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                        android.widget.TextView r0 = r0.f12321o
                        com.xeagle.android.activities.MainViewActivity r1 = com.xeagle.android.activities.MainViewActivity.this
                        r2 = 2131820887(0x7f110157, float:1.9274502E38)
                        java.lang.String r1 = r1.getString(r2)
                        r0.setText(r1)
                    L_0x011c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.MainViewActivity.AnonymousClass18.run():void");
                }
            });
        } else {
            this.f12326t.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == 1) {
            finish();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_help /*2131296669*/:
                finish();
                startActivity(new Intent(this, HelpActivity.class));
                return;
            case R.id.bt_start /*2131296686*/:
                if (this.f12324r.i().contains("Drone") || this.f12324r.i().contains("Controller") || this.f12324r.i().contains("Ground")) {
                    if (this.f12358g.y() == null) {
                        k();
                        return;
                    } else if (((!this.f12358g.y().contains("Obtain") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF803)) || this.f12318l.getCurrentItem() != 3) && (((!this.f12358g.y().contains("Dream") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF801)) || this.f12318l.getCurrentItem() != 2) && (((!this.f12358g.y().contains("Smart") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF805)) || this.f12318l.getCurrentItem() != 1) && ((!this.f12358g.y().contains("Faith") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) || this.f12318l.getCurrentItem() != 0)))) {
                        a(getString(R.string.tips_pair_drone), false, "tips_pair_drone");
                        return;
                    }
                }
                l();
                return;
            case R.id.firmware_upload /*2131297216*/:
                d a2 = d.a(getString(R.string.dialog_tips), getString(R.string.upload_firmware_tip), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        if (MainViewActivity.this.f12358g.A() == null) {
                            if (!MainViewActivity.this.f12323q.C()) {
                                com.xeagle.android.dialogs.c a2 = r.a().a(MainViewActivity.this.getString(R.string.warning), MainViewActivity.this.getString(R.string.upload_txt_wifi_error), (c.a) new c.a() {
                                    public void onYes() {
                                    }
                                });
                                if (a2 != null) {
                                    a2.show(MainViewActivity.this.getSupportFragmentManager(), "warn_dlg");
                                    return;
                                }
                                return;
                            } else if (MainViewActivity.this.f12323q.D() != null) {
                                MainViewActivity.this.f12358g.b(MainViewActivity.this.f12323q.D());
                            } else {
                                return;
                            }
                        }
                        if (MainViewActivity.this.f12324r.i().contains("Controller") || MainViewActivity.this.f12324r.i().contains("Ground")) {
                            com.xeagle.android.dialogs.c a3 = r.a().a(MainViewActivity.this.getString(R.string.dialog_tips), MainViewActivity.this.getString(R.string.upload_firmware_rc), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                            if (a3 != null) {
                                a3.show(MainViewActivity.this.getSupportFragmentManager(), "rc_warn");
                            }
                        } else if (MainViewActivity.this.f12358g.j().a()) {
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                            MainViewActivity.this.f12323q.j(true);
                            do {
                                if (MainViewActivity.this.f12358g.j().a()) {
                                    com.flypro.core.MAVLink.r.a(MainViewActivity.this.f12358g);
                                    if (MainViewActivity.this.f12358g.j().a()) {
                                        MainViewActivity.this.f12358g.j().a(4);
                                    }
                                    SystemClock.sleep(200);
                                }
                            } while (MainViewActivity.this.f12358g.j().a());
                            MainViewActivity.this.startActivity(new Intent(MainViewActivity.this, UploadFirmwareActivity.class));
                        }
                    }
                });
                if (a2 != null) {
                    a2.show(getSupportFragmentManager(), "upload_dlg");
                    return;
                }
                return;
            case R.id.view_more_info /*2131299799*/:
                a((Context) this, view);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.main_xeagle_view);
        this.F = new com.xeagle.android.utils.permission.a(this);
        getWindow().setFlags(1024, 1024);
        XEagleApp xEagleApp = (XEagleApp) getApplication();
        this.f12322p = xEagleApp;
        this.f12323q = xEagleApp.j();
        d();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @org.greenrobot.eventbus.l
    public void onDroneConnectEvent(k kVar) {
        h();
        com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        new Thread(new Runnable() {
            public void run() {
                if (!MainViewActivity.this.f12358g.j().a()) {
                    MainViewActivity.this.i();
                }
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f12323q.j(false);
        runOnUiThread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bd, code lost:
                if (com.xeagle.android.activities.MainViewActivity.k(r4.f22213a).j().equals("220") == false) goto L_0x000d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    r1 = 0
                    java.lang.String r2 = "220"
                    if (r0 != 0) goto L_0x002a
                L_0x000d:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    r0.d((java.lang.String) r2)
                L_0x0016:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                L_0x001c:
                    r0.setCurrentItem(r1)
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                    r0.invalidate()
                    goto L_0x012d
                L_0x002a:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Dream"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x0109
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF801"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x004c
                    goto L_0x0109
                L_0x004c:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Obtain"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00e5
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF803"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x006e
                    goto L_0x00e5
                L_0x006e:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Smart"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00c1
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF805"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x008f
                    goto L_0x00c1
                L_0x008f:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Faith"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00af
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF806"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x012d
                L_0x00af:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    java.lang.String r0 = r0.j()
                    boolean r0 = r0.equals(r2)
                    if (r0 != 0) goto L_0x0016
                    goto L_0x000d
                L_0x00c1:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "280"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x00dc
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    r0.d((java.lang.String) r1)
                L_0x00dc:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                    r1 = 1
                    goto L_0x001c
                L_0x00e5:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "350"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x0100
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    r0.d((java.lang.String) r1)
                L_0x0100:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                    r1 = 3
                    goto L_0x001c
                L_0x0109:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "U21"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x0124
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12323q
                    r0.d((java.lang.String) r1)
                L_0x0124:
                    com.xeagle.android.activities.MainViewActivity r0 = com.xeagle.android.activities.MainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12318l
                    r1 = 2
                    goto L_0x001c
                L_0x012d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.MainViewActivity.AnonymousClass10.run():void");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        registerReceiver(this.G, intentFilter);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        unregisterReceiver(this.G);
        Timer timer = this.f12325s;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            e();
            if (this.F.a(f12314a)) {
                m();
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void receivHeartbeatEvent(ax axVar) {
        if (axVar.a() == 67 && !this.f12328v) {
            this.f12328v = true;
            com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
        }
    }
}
