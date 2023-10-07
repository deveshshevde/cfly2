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
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.PolicyActivity;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.f;
import com.xeagle.android.dialogs.r;
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
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.ThreadMode;

public class ReMainViewActivity extends SuperUI implements View.OnClickListener, DroneInterfaces.e {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f12333a = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    private IImageButton A;
    private IImageButton B;
    /* access modifiers changed from: private */
    public RelativeLayout C;
    private a D;
    /* access modifiers changed from: private */
    public int[] E = {R.drawable.product_808, R.drawable.product_808, R.drawable.product_808, R.drawable.product_808};
    /* access modifiers changed from: private */
    public int[] F = {R.drawable.product_808, R.drawable.product_808, R.drawable.product_808, R.drawable.product_808};
    private com.xeagle.android.utils.permission.a G;
    private final BroadcastReceiver H = new BroadcastReceiver() {
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
                    str = "wifiState:WIFI_STATE_DISABLED";
                    Log.e("WIFI状态", str);
                    if (ReMainViewActivity.this.f12343r != null) {
                        ReMainViewActivity.this.f12334b.a((Runnable) new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12339n.setEnabled(true);
                                ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                            }
                        });
                        ReMainViewActivity.this.f12343r.a();
                    }
                } else if (intExtra == 2) {
                    Log.e("WIFI状态", "wifiState:WIFI_STATE_ENABLING");
                    boolean unused = ReMainViewActivity.this.f12350y = false;
                    ReMainViewActivity.this.f12339n.setEnabled(false);
                    ReMainViewActivity.this.f12339n.setTextColor(-7829368);
                    ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.connecting));
                    return;
                } else if (intExtra == 3) {
                    Log.e("WIFI状态", "wifiState:WIFI_STATE_ENABLED");
                    if (!ReMainViewActivity.this.f12343r.i().contains("Drone") && !ReMainViewActivity.this.f12343r.i().contains("Controller") && !ReMainViewActivity.this.f12343r.i().contains("Ground")) {
                        Timer unused2 = ReMainViewActivity.this.f12344s = new Timer();
                        new Thread(new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12344s.schedule(new TimerTask() {
                                    public void run() {
                                        ReMainViewActivity.this.f12343r.a();
                                        ReMainViewActivity.this.f12343r.d();
                                        SystemClock.sleep(400);
                                        c.a(ReMainViewActivity.this.f12344s, ReMainViewActivity.this.f12343r, ReMainViewActivity.this.f12334b);
                                    }
                                }, 100, 2000);
                                final Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    public void run() {
                                        ReMainViewActivity.this.f12344s.cancel();
                                        timer.cancel();
                                    }
                                }, 60000);
                            }
                        }).start();
                    }
                    Log.i("version", "onReceive: ------>>>>>>>>>>>enabled::::" + ReMainViewActivity.this.f12343r.i());
                    if (ReMainViewActivity.this.f12343r.i().equalsIgnoreCase("<unknown ssid>")) {
                        ReMainViewActivity.this.f12334b.a((Runnable) new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12339n.setEnabled(true);
                                ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                            }
                        });
                        return;
                    }
                    Log.i("version", "onReceive: isEnable-----" + ReMainViewActivity.this.f12343r.b());
                    boolean unused3 = ReMainViewActivity.this.f12350y = false;
                    Thread unused4 = ReMainViewActivity.this.f12349x = new Thread(ReMainViewActivity.this.f12335c, "link_watcher");
                    ReMainViewActivity.this.f12349x.start();
                    ReMainViewActivity.this.f12345t.a(3000);
                    ReMainViewActivity.this.f12345t.a(ReMainViewActivity.this.f12346u);
                    ReMainViewActivity.this.f12345t.c();
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
    private boolean I = false;

    /* renamed from: b  reason: collision with root package name */
    e f12334b = new e(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 4) {
                    TextView textView = new TextView(ReMainViewActivity.this);
                    textView.setText("current wifi:" + ReMainViewActivity.this.f12343r.i());
                    textView.setTextSize(12.0f);
                    textView.setGravity(8388661);
                    textView.setTextColor(-16777216);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, c.a((Context) ReMainViewActivity.this, 10.0f), c.a((Context) ReMainViewActivity.this, 30.0f), 0);
                    ReMainViewActivity.this.C.addView(textView, layoutParams);
                }
            } else if (!ReMainViewActivity.this.f12358g.j().a()) {
                ReMainViewActivity.this.i();
            }
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    Runnable f12335c = new Runnable() {
        public void run() {
            while (!ReMainViewActivity.this.f12350y) {
                if (!ReMainViewActivity.this.f12358g.j().a()) {
                    Log.i("version", "run: start-------");
                    ReMainViewActivity.this.i();
                    SystemClock.sleep(1200);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public SCViewPager f12336k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public DotsView f12337l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f12338m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public TextView f12339n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f12340o;

    /* renamed from: p  reason: collision with root package name */
    private XEagleApp f12341p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f12342q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public com.flypro.core.util.e f12343r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Timer f12344s = null;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public w f12345t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f12346u = 12;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f12347v = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f12348w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Thread f12349x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f12350y = false;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f12351z = false;

    class a extends androidx.viewpager.widget.a {

        /* renamed from: b  reason: collision with root package name */
        private int[] f22324b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f22325c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f22326d;

        public a(int[] iArr) {
            this.f22324b = iArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f22324b.length;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            int i3;
            Resources resources;
            this.f22326d = new ImageView(viewGroup.getContext().getApplicationContext());
            if (ReMainViewActivity.this.f12358g.y() == null || !ReMainViewActivity.this.f12358g.y().contains("P")) {
                resources = ReMainViewActivity.this.getResources();
                i3 = ReMainViewActivity.this.E[i2];
            } else {
                resources = ReMainViewActivity.this.getResources();
                i3 = ReMainViewActivity.this.F[i2];
            }
            this.f22325c = BitmapFactory.decodeResource(resources, i3);
            this.f22326d.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f22326d.setImageBitmap(this.f22325c);
            viewGroup.addView(this.f22326d, -1, -1);
            return this.f22326d;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private void a() {
        this.f12345t = new w(this);
        this.f12343r = new com.flypro.core.util.e(getApplicationContext());
        TextView textView = (TextView) findViewById(R.id.bt_start);
        this.f12339n = textView;
        textView.setEnabled(false);
        this.f12339n.setTextColor(-7829368);
        this.f12339n.setOnClickListener(this);
        this.f12340o = (TextView) findViewById(R.id.app_policy);
        SpannableString spannableString = new SpannableString("使用前请阅读隐私权政策及用户须知");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(foregroundColorSpan, 6, 11, 17);
        spannableString.setSpan(foregroundColorSpan, 12, spannableString.length(), 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                Log.i("SPAN", "onClick: ---------");
                Intent intent = new Intent(ReMainViewActivity.this, PolicyActivity.class);
                intent.putExtra("policy_title", ReMainViewActivity.this.getString(R.string.policy_privacy_title));
                ReMainViewActivity.this.startActivity(intent);
            }
        }, 6, 11, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
            }
        }, 12, spannableString.length(), 17);
        this.f12340o.setMovementMethod(LinkMovementMethod.getInstance());
        this.f12340o.setText(spannableString);
        findViewById(R.id.bt_help).setOnClickListener(this);
        this.f12336k = (SCViewPager) findViewById(R.id.product_vp);
        this.f12337l = (DotsView) findViewById(R.id.product_dv);
        this.f12338m = (TextView) findViewById(R.id.app_version);
        this.A = (IImageButton) findViewById(R.id.firmware_upload);
        IImageButton iImageButton = (IImageButton) findViewById(R.id.view_more_info);
        this.B = iImageButton;
        iImageButton.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.f12338m.setText(g());
        this.f12337l.a(R.drawable.select_active, R.drawable.select_disactive);
        this.f12337l.setNumberOfPage(4);
        this.C = (RelativeLayout) findViewById(R.id.main_rl);
        a aVar = new a(this.E);
        this.D = aVar;
        this.f12336k.setAdapter(aVar);
        this.f12336k.setOnPageChangeListener(new ViewPager.e() {
            public void onPageScrollStateChanged(int i2) {
            }

            public void onPageScrolled(int i2, float f2, int i3) {
            }

            public void onPageSelected(int i2) {
                ReMainViewActivity reMainViewActivity;
                String str;
                String str2;
                e eVar;
                Runnable runnable;
                ReMainViewActivity.this.f12337l.a(i2);
                if (i2 == 0) {
                    if (!ReMainViewActivity.this.f12343r.i().contains("Drone") && !ReMainViewActivity.this.f12343r.i().contains("Controller") && !ReMainViewActivity.this.f12343r.i().contains("Ground")) {
                        boolean unused = ReMainViewActivity.this.f12350y = true;
                        eVar = ReMainViewActivity.this.f12334b;
                        runnable = new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12339n.setEnabled(true);
                                ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                            }
                        };
                    } else if (ReMainViewActivity.this.f12358g.y() == null) {
                        if (ReMainViewActivity.this.f12348w < 3) {
                            boolean unused2 = ReMainViewActivity.this.f12350y = false;
                            eVar = ReMainViewActivity.this.f12334b;
                            runnable = new Runnable() {
                                public void run() {
                                    ReMainViewActivity.this.f12339n.setEnabled(false);
                                    ReMainViewActivity.this.f12339n.setTextColor(-7829368);
                                    ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.connecting));
                                }
                            };
                        } else {
                            Log.i("version", "onPageSelected: recvvvv----" + ReMainViewActivity.this.f12347v);
                            if (!ReMainViewActivity.this.f12347v) {
                                boolean unused3 = ReMainViewActivity.this.f12350y = true;
                                eVar = ReMainViewActivity.this.f12334b;
                                runnable = new Runnable() {
                                    public void run() {
                                        ReMainViewActivity.this.f12339n.setEnabled(true);
                                        ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                        ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                                    }
                                };
                            } else {
                                boolean unused4 = ReMainViewActivity.this.f12350y = true;
                                eVar = ReMainViewActivity.this.f12334b;
                                runnable = new Runnable() {
                                    public void run() {
                                        ReMainViewActivity.this.f12339n.setEnabled(true);
                                        ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                        ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                                    }
                                };
                            }
                        }
                    } else if (ReMainViewActivity.this.f12358g.y().contains("Faith") || ReMainViewActivity.this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) {
                        boolean unused5 = ReMainViewActivity.this.f12350y = true;
                        eVar = ReMainViewActivity.this.f12334b;
                        runnable = new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12339n.setEnabled(true);
                                ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                                ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                            }
                        };
                    } else {
                        boolean unused6 = ReMainViewActivity.this.f12350y = true;
                        eVar = ReMainViewActivity.this.f12334b;
                        runnable = new Runnable() {
                            public void run() {
                                ReMainViewActivity.this.f12339n.setEnabled(false);
                                ReMainViewActivity.this.f12339n.setTextColor(-7829368);
                                ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.model_not_paired));
                            }
                        };
                    }
                    eVar.a(runnable);
                    return;
                }
                if (i2 == 1) {
                    reMainViewActivity = ReMainViewActivity.this;
                    str = "Smart";
                    str2 = UserGlobal.DRONE_TYPE_DF805;
                } else if (i2 == 2) {
                    reMainViewActivity = ReMainViewActivity.this;
                    str = "Dream";
                    str2 = UserGlobal.DRONE_TYPE_DF801;
                } else if (i2 == 3) {
                    reMainViewActivity = ReMainViewActivity.this;
                    str = "Obtain";
                    str2 = UserGlobal.DRONE_TYPE_DF803;
                } else {
                    return;
                }
                reMainViewActivity.a(str, str2);
            }
        });
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
                int itemId = menuItem.getItemId();
                if (itemId == R.id.menu_enter_cfly) {
                    intent = new Intent(ReMainViewActivity.this, CflyNetActivity.class);
                } else if (itemId != R.id.menu_help_offer) {
                    return true;
                } else {
                    intent = new Intent(ReMainViewActivity.this, PdfListActivity.class);
                }
                ReMainViewActivity.this.startActivity(intent);
                return true;
            }
        });
        vVar.b();
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        Runnable runnable;
        e eVar;
        if (!this.f12343r.i().contains("Drone") && !this.f12343r.i().contains("Controller") && !this.f12343r.i().contains("Ground")) {
            this.f12350y = true;
            eVar = this.f12334b;
            runnable = new Runnable() {
                public void run() {
                    ReMainViewActivity.this.f12339n.setEnabled(true);
                    ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                    ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                }
            };
        } else if (this.f12358g.y() == null) {
            Log.i("version", "onPageSelected: rec----" + this.f12347v);
            if (this.f12348w < 3) {
                this.f12350y = false;
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        ReMainViewActivity.this.f12339n.setEnabled(false);
                        ReMainViewActivity.this.f12339n.setTextColor(-7829368);
                        ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.connecting));
                    }
                };
            } else {
                boolean z2 = this.f12347v;
                this.f12350y = true;
                if (!z2) {
                    eVar = this.f12334b;
                    runnable = new Runnable() {
                        public void run() {
                            ReMainViewActivity.this.f12339n.setEnabled(true);
                            ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                        }
                    };
                } else {
                    eVar = this.f12334b;
                    runnable = new Runnable() {
                        public void run() {
                            ReMainViewActivity.this.f12339n.setEnabled(true);
                            ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    };
                }
            }
        } else if (this.f12358g.y().contains(str) || this.f12358g.y().contains(str2)) {
            this.f12350y = true;
            eVar = this.f12334b;
            runnable = new Runnable() {
                public void run() {
                    ReMainViewActivity.this.f12339n.setEnabled(true);
                    ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                    ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                }
            };
        } else {
            this.f12350y = true;
            eVar = this.f12334b;
            runnable = new Runnable() {
                public void run() {
                    ReMainViewActivity.this.f12339n.setEnabled(false);
                    ReMainViewActivity.this.f12339n.setTextColor(-7829368);
                    ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.model_not_paired));
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
                    ReMainViewActivity.this.e();
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

    private void b() {
        if (!((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            new AlertDialog.Builder(this).setTitle(R.string.warning).setMessage(R.string.gps_message).setCancelable(false).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    ReMainViewActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    Toast.makeText(ReMainViewActivity.this, R.string.gps_close, 0).show();
                }
            }).show();
        }
    }

    private void d() {
        if (!this.f12358g.j().a()) {
            new Thread(new Runnable() {
                public void run() {
                    Looper.prepare();
                    ReMainViewActivity.this.i();
                    Looper.loop();
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f12342q.d("220");
        j();
    }

    private void j() {
        Intent intent = new Intent(this, FlightActionActivity.class);
        intent.putExtra("isFirst", true);
        finish();
        startActivity(intent);
    }

    private void k() {
        PermissionActivity.a(this, 0, f12333a);
    }

    private void l() {
        d a2 = d.a(getString(R.string.warning), getString(R.string.upload_firmware_notify), new d.a() {
            public void onNo() {
            }

            public void onYes() {
                if (ReMainViewActivity.this.f12343r.i().contains("Controller") || ReMainViewActivity.this.f12343r.i().contains("Ground")) {
                    com.xeagle.android.dialogs.c a2 = r.a().a(ReMainViewActivity.this.getString(R.string.dialog_tips), ReMainViewActivity.this.getString(R.string.upload_firmware_rc), (c.a) new c.a() {
                        public void onYes() {
                        }
                    });
                    if (a2 != null) {
                        a2.show(ReMainViewActivity.this.getSupportFragmentManager(), "rc_warn");
                        return;
                    }
                    return;
                }
                f a3 = f.a(ReMainViewActivity.this.getString(R.string.dialog_tips), ReMainViewActivity.this.getString(R.string.upload_firmware_tip), ReMainViewActivity.this.getString(R.string.upload_txt_quit), ReMainViewActivity.this.getString(R.string.upload_txt_upgrade), new f.a() {
                    public void a() {
                        if (ReMainViewActivity.this.f12358g.j().a()) {
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            ReMainViewActivity.this.f12342q.j(true);
                            do {
                                if (ReMainViewActivity.this.f12358g.j().a()) {
                                    com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                                    if (ReMainViewActivity.this.f12358g.j().a()) {
                                        ReMainViewActivity.this.f12358g.j().a(9);
                                    }
                                    SystemClock.sleep(200);
                                }
                            } while (ReMainViewActivity.this.f12358g.j().a());
                            ReMainViewActivity.this.startActivity(new Intent(ReMainViewActivity.this, UploadFirmwareActivity.class));
                        }
                    }

                    public void b() {
                    }
                });
                if (a3 != null) {
                    a3.show(ReMainViewActivity.this.getSupportFragmentManager(), "update_tips");
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
            this.f12342q.m(this.f12358g.A());
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
                l();
            } catch (NumberFormatException e2) {
                Log.e("version", "error:" + e2.getMessage());
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public void droneRcControlEvent(dy.w wVar) {
        if (wVar.a() == 46) {
            this.f12341p.m().d(true);
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
            this.f12345t.b();
            this.f12350y = true;
            this.f12351z = true;
            this.f12334b.a((Runnable) new Runnable() {
                public void run() {
                    ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                    ReMainViewActivity.this.f12339n.setEnabled(true);
                }
            });
            if (this.f12358g.y().contains("Obtain") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF803)) {
                this.f12342q.d("350");
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(3);
                            ReMainViewActivity.this.f12336k.invalidate();
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Dream") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF801)) {
                this.f12342q.d("U21");
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(2);
                            ReMainViewActivity.this.f12336k.invalidate();
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Smart") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF805)) {
                this.f12342q.d("280");
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(1);
                            ReMainViewActivity.this.f12336k.invalidate();
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12358g.y().contains("Faith") || this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) {
                this.f12342q.d("220");
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(0);
                            ReMainViewActivity.this.f12336k.invalidate();
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else {
                this.f12342q.d("220");
                eVar = this.f12334b;
                runnable = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(0);
                            ReMainViewActivity.this.f12336k.invalidate();
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
                    while (!ReMainViewActivity.this.f12351z) {
                        Log.i("HEART", "heartbeatFirst:------- RECEIVE VERSION ");
                        com.flypro.core.MAVLink.b.a(ReMainViewActivity.this.f12358g, (byte) 99);
                        SystemClock.sleep(500);
                    }
                    Log.i("HEART", "heartbeatFirst:------- REQUEST DATA");
                    ReMainViewActivity.this.h();
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
        this.f12348w = i2;
        if (i2 >= this.f12345t.a()) {
            Log.i("version", "notifyTimeOut:::350--->>>>" + this.f12347v);
            if (this.f12347v) {
                this.f12350y = true;
                this.f12342q.d("220");
                eVar = this.f12334b;
                r0 = new Runnable() {
                    public void run() {
                        if (ReMainViewActivity.this.f12336k != null) {
                            ReMainViewActivity.this.f12336k.setCurrentItem(0);
                            ReMainViewActivity.this.f12336k.invalidate();
                            ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                            ReMainViewActivity.this.f12339n.setEnabled(true);
                            ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.click_enter));
                        }
                    }
                };
            } else if (this.f12343r.i().contains("Drone") || this.f12343r.i().contains("Controller") || this.f12343r.i().contains("Ground")) {
                d();
                return;
            } else {
                this.f12350y = true;
                eVar = this.f12334b;
                r0 = new Runnable() {
                    public void run() {
                        ReMainViewActivity.this.f12339n.setEnabled(true);
                        ReMainViewActivity.this.f12339n.setTextColor(-16777216);
                        ReMainViewActivity.this.f12339n.setText(ReMainViewActivity.this.getString(R.string.interface_view));
                    }
                };
            }
            eVar.a(r0);
        } else if (this.f12347v) {
            this.f12350y = true;
            this.f12334b.a((Runnable) new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ac, code lost:
                    if (r5.f22291a.f12358g.y().contains(com.xeagle.android.login.retrofitLogin.UserGlobal.DRONE_TYPE_DF806) == false) goto L_0x00ed;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                        if (r0 == 0) goto L_0x011c
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        r1 = 1
                        r2 = 0
                        java.lang.String r3 = "220"
                        if (r0 != 0) goto L_0x002a
                    L_0x0016:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                        r0.d((java.lang.String) r3)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                    L_0x0025:
                        r0.setCurrentItem(r2)
                        goto L_0x00ed
                    L_0x002a:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Dream"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00d9
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF801"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x004c
                        goto L_0x00d9
                    L_0x004c:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Obtain"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00c5
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF803"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x006d
                        goto L_0x00c5
                    L_0x006d:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Smart"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x00b0
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF805"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x008e
                        goto L_0x00b0
                    L_0x008e:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "Faith"
                        boolean r0 = r0.contains(r4)
                        if (r0 != 0) goto L_0x0016
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        en.a r0 = r0.f12358g
                        java.lang.String r0 = r0.y()
                        java.lang.String r4 = "DF806"
                        boolean r0 = r0.contains(r4)
                        if (r0 == 0) goto L_0x00ed
                        goto L_0x0016
                    L_0x00b0:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                        java.lang.String r2 = "280"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                        r0.setCurrentItem(r1)
                        goto L_0x00ed
                    L_0x00c5:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                        java.lang.String r2 = "350"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                        r2 = 3
                        goto L_0x0025
                    L_0x00d9:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                        java.lang.String r2 = "U21"
                        r0.d((java.lang.String) r2)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                        r2 = 2
                        goto L_0x0025
                    L_0x00ed:
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                        r0.invalidate()
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        android.widget.TextView r0 = r0.f12339n
                        r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                        r0.setTextColor(r2)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        android.widget.TextView r0 = r0.f12339n
                        r0.setEnabled(r1)
                        com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                        android.widget.TextView r0 = r0.f12339n
                        com.xeagle.android.activities.ReMainViewActivity r1 = com.xeagle.android.activities.ReMainViewActivity.this
                        r2 = 2131820887(0x7f110157, float:1.9274502E38)
                        java.lang.String r1 = r1.getString(r2)
                        r0.setText(r1)
                    L_0x011c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.ReMainViewActivity.AnonymousClass17.run():void");
                }
            });
        } else {
            this.f12345t.a(false);
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
                if (this.f12343r.i().contains("Drone") || this.f12343r.i().contains("Controller") || this.f12343r.i().contains("Ground")) {
                    if (this.f12358g.y() == null) {
                        e();
                        return;
                    } else if (((!this.f12358g.y().contains("Obtain") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF803)) || this.f12336k.getCurrentItem() != 3) && (((!this.f12358g.y().contains("Dream") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF801)) || this.f12336k.getCurrentItem() != 2) && (((!this.f12358g.y().contains("Smart") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF805)) || this.f12336k.getCurrentItem() != 1) && ((!this.f12358g.y().contains("Faith") && !this.f12358g.y().contains(UserGlobal.DRONE_TYPE_DF806)) || this.f12336k.getCurrentItem() != 0)))) {
                        a(getString(R.string.tips_pair_drone), false, "tips_pair_drone");
                        return;
                    }
                }
                j();
                return;
            case R.id.firmware_upload /*2131297216*/:
                d a2 = d.a(getString(R.string.dialog_tips), getString(R.string.upload_firmware_tip), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        if (ReMainViewActivity.this.f12358g.A() == null) {
                            if (!ReMainViewActivity.this.f12342q.C()) {
                                com.xeagle.android.dialogs.c a2 = r.a().a(ReMainViewActivity.this.getString(R.string.warning), ReMainViewActivity.this.getString(R.string.upload_txt_wifi_error), (c.a) new c.a() {
                                    public void onYes() {
                                    }
                                });
                                if (a2 != null) {
                                    a2.show(ReMainViewActivity.this.getSupportFragmentManager(), "warn_dlg");
                                    return;
                                }
                                return;
                            } else if (ReMainViewActivity.this.f12342q.D() != null) {
                                ReMainViewActivity.this.f12358g.b(ReMainViewActivity.this.f12342q.D());
                            } else {
                                return;
                            }
                        }
                        if (ReMainViewActivity.this.f12343r.i().contains("Controller") || ReMainViewActivity.this.f12343r.i().contains("Ground")) {
                            com.xeagle.android.dialogs.c a3 = r.a().a(ReMainViewActivity.this.getString(R.string.dialog_tips), ReMainViewActivity.this.getString(R.string.upload_firmware_rc), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                            if (a3 != null) {
                                a3.show(ReMainViewActivity.this.getSupportFragmentManager(), "rc_warn");
                            }
                        } else if (ReMainViewActivity.this.f12358g.j().a()) {
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            SystemClock.sleep(10);
                            com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                            ReMainViewActivity.this.f12342q.j(true);
                            do {
                                if (ReMainViewActivity.this.f12358g.j().a()) {
                                    com.flypro.core.MAVLink.r.a(ReMainViewActivity.this.f12358g);
                                    if (ReMainViewActivity.this.f12358g.j().a()) {
                                        ReMainViewActivity.this.f12358g.j().a(7);
                                    }
                                    SystemClock.sleep(200);
                                }
                            } while (ReMainViewActivity.this.f12358g.j().a());
                            ReMainViewActivity.this.startActivity(new Intent(ReMainViewActivity.this, UploadFirmwareActivity.class));
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
        this.G = new com.xeagle.android.utils.permission.a(this);
        getWindow().setFlags(1024, 1024);
        XEagleApp xEagleApp = (XEagleApp) getApplication();
        this.f12341p = xEagleApp;
        this.f12342q = xEagleApp.j();
        a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        new Thread(new Runnable() {
            public void run() {
                if (!ReMainViewActivity.this.f12358g.j().a()) {
                    ReMainViewActivity.this.i();
                }
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f12342q.j(false);
        runOnUiThread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bd, code lost:
                if (com.xeagle.android.activities.ReMainViewActivity.l(r4.f22322a).j().equals("220") == false) goto L_0x000d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    r1 = 0
                    java.lang.String r2 = "220"
                    if (r0 != 0) goto L_0x002a
                L_0x000d:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    r0.d((java.lang.String) r2)
                L_0x0016:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                L_0x001c:
                    r0.setCurrentItem(r1)
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                    r0.invalidate()
                    goto L_0x012d
                L_0x002a:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Dream"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x0109
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF801"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x004c
                    goto L_0x0109
                L_0x004c:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Obtain"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00e5
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF803"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x006e
                    goto L_0x00e5
                L_0x006e:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Smart"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00c1
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF805"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x008f
                    goto L_0x00c1
                L_0x008f:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "Faith"
                    boolean r0 = r0.contains(r3)
                    if (r0 != 0) goto L_0x00af
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    en.a r0 = r0.f12358g
                    java.lang.String r0 = r0.y()
                    java.lang.String r3 = "DF806"
                    boolean r0 = r0.contains(r3)
                    if (r0 == 0) goto L_0x012d
                L_0x00af:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    java.lang.String r0 = r0.j()
                    boolean r0 = r0.equals(r2)
                    if (r0 != 0) goto L_0x0016
                    goto L_0x000d
                L_0x00c1:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "280"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x00dc
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    r0.d((java.lang.String) r1)
                L_0x00dc:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                    r1 = 1
                    goto L_0x001c
                L_0x00e5:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "350"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x0100
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    r0.d((java.lang.String) r1)
                L_0x0100:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                    r1 = 3
                    goto L_0x001c
                L_0x0109:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    java.lang.String r0 = r0.j()
                    java.lang.String r1 = "U21"
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x0124
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.utils.prefs.a r0 = r0.f12342q
                    r0.d((java.lang.String) r1)
                L_0x0124:
                    com.xeagle.android.activities.ReMainViewActivity r0 = com.xeagle.android.activities.ReMainViewActivity.this
                    com.xeagle.android.widgets.scViewPager.SCViewPager r0 = r0.f12336k
                    r1 = 2
                    goto L_0x001c
                L_0x012d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.ReMainViewActivity.AnonymousClass9.run():void");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        registerReceiver(this.H, intentFilter);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        unregisterReceiver(this.H);
        Timer timer = this.f12344s;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            b();
            if (this.G.a(f12333a)) {
                k();
            }
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void receivHeartbeatEvent(ax axVar) {
        if (axVar.a() == 67 && !this.f12347v) {
            this.f12347v = true;
            com.flypro.core.MAVLink.b.a(this.f12358g, (byte) 99);
        }
    }
}
