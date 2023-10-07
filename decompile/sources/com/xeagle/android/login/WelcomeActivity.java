package com.xeagle.android.login;

import android.content.Intent;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.permissionx.guolindev.b;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.ac;
import com.xeagle.android.dialogs.s;
import com.xeagle.android.dialogs.v;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import iy.c;
import iy.d;
import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private static final int REFUSE_TIME = 172800000;
    private static final int REQUEST_CODE = 1024;
    /* access modifiers changed from: private */
    public Handler handler;
    private boolean isClickIntent;
    /* access modifiers changed from: private */
    public a prefs;
    private ImageView welcome_cl;

    /* access modifiers changed from: private */
    public void requestPermission() {
        com.xeagle.android.utils.permission.a aVar = new com.xeagle.android.utils.permission.a(getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.CAMERA");
        if (!aVar.a((ArrayList<String>) arrayList)) {
            ((XEagleApp) getApplicationContext()).p().f();
            ((XEagleApp) getApplicationContext()).p().e();
            startToIntent(this.handler, this.prefs, 3000);
            startLogcatService();
        } else if (System.currentTimeMillis() - this.prefs.aL() < 172800000) {
            startToIntent(this.handler, this.prefs, 3000);
        } else {
            b.a(this).a(arrayList).a().a((iw.b) new iw.b() {
                public void onExplainReason(c cVar, List<String> list, boolean z2) {
                    Log.i("newUI", "onExplainReason: ");
                    WelcomeActivity welcomeActivity = WelcomeActivity.this;
                    cVar.a(new s(welcomeActivity, R.style.dialog, welcomeActivity.getString(R.string.permission_title), WelcomeActivity.this.getString(R.string.bt_allow), WelcomeActivity.this.getString(R.string.bt_deny), list));
                }
            }).a((iw.c) new iw.c() {
                public void onForwardToSettings(d dVar, List<String> list) {
                    WelcomeActivity welcomeActivity = WelcomeActivity.this;
                    dVar.a(new s(welcomeActivity, R.style.dialog, welcomeActivity.getString(R.string.permission_forward_title), WelcomeActivity.this.getString(R.string.bt_allow), WelcomeActivity.this.getString(R.string.bt_deny), list));
                }
            }).a((iw.d) new iw.d() {
                public void onResult(boolean z2, List<String> list, List<String> list2) {
                    if (z2) {
                        ToastUtils.showLong((CharSequence) WelcomeActivity.this.getString(R.string.permission_all_allow));
                    } else {
                        ToastUtils.showLong((CharSequence) WelcomeActivity.this.getString(R.string.lost_location_permission));
                        WelcomeActivity.this.prefs.b(System.currentTimeMillis());
                    }
                    if (list.contains("android.permission.ACCESS_FINE_LOCATION") && list.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                        ((XEagleApp) WelcomeActivity.this.getApplicationContext()).p().f();
                        ((XEagleApp) WelcomeActivity.this.getApplicationContext()).p().e();
                    }
                    WelcomeActivity welcomeActivity = WelcomeActivity.this;
                    welcomeActivity.startToIntent(welcomeActivity.handler, WelcomeActivity.this.prefs, 3000);
                }
            });
        }
    }

    private void showPolicyDlg() {
        v a2 = v.a(getString(R.string.policy_privacy_title), new v.a() {
            public void agree() {
                WelcomeActivity.this.prefs.q(true);
                WelcomeActivity.this.requestPermission();
            }

            public void disagree() {
                WelcomeActivity.this.prefs.q(false);
                WelcomeActivity.this.requestPermission();
            }
        });
        if (!a2.isAdded()) {
            a2.show(getSupportFragmentManager(), "policy warn");
        }
    }

    private void showRefusePolicyDlg() {
        ac a2 = ac.a(getString(R.string.dialog_title), new ac.a() {
            public void agree() {
                WelcomeActivity.this.prefs.q(true);
                WelcomeActivity.this.requestPermission();
            }

            public void disagree() {
                WelcomeActivity.this.prefs.q(false);
                WelcomeActivity.this.finish();
            }
        });
        if (!a2.isAdded()) {
            a2.show(getSupportFragmentManager(), "refuse policy");
        }
    }

    private void startLogcatService() {
    }

    /* access modifiers changed from: private */
    public void startToIntent(final Handler handler2, final a aVar, long j2) {
        if (!aVar.aE().equalsIgnoreCase("-")) {
            try {
                final UserInfo userInfo = UserLiteHelper.getUserInfo(aVar.aE());
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        WelcomeActivity.this.finish();
                        UserInfo userInfo = userInfo;
                        WelcomeActivity.this.startActivity((userInfo == null || (userInfo.getEmail() == null && userInfo.getPhone() == null) || userInfo.getPassword() == null) ? new Intent(WelcomeActivity.this, SplashActivity.class) : new Intent(WelcomeActivity.this, HostManagerActivity.class));
                    }
                }, j2);
            } catch (SQLiteCantOpenDatabaseException unused) {
                com.xeagle.android.utils.c.a((AppCompatActivity) this, (c.b) new c.b() {
                    public void onResultAllow() {
                        final UserInfo userInfo = UserLiteHelper.getUserInfo(aVar.aE());
                        handler2.postDelayed(new Runnable() {
                            public void run() {
                                WelcomeActivity.this.finish();
                                UserInfo userInfo = userInfo;
                                WelcomeActivity.this.startActivity((userInfo == null || (userInfo.getEmail() == null && userInfo.getPhone() == null) || userInfo.getPassword() == null) ? new Intent(WelcomeActivity.this, SplashActivity.class) : new Intent(WelcomeActivity.this, HostManagerActivity.class));
                            }
                        }, 3000);
                    }

                    public void onResultDeny() {
                        WelcomeActivity.this.finish();
                        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, SplashActivity.class));
                    }
                });
            }
        } else {
            handler2.postDelayed(new Runnable() {
                public void run() {
                    WelcomeActivity.this.finish();
                    WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, SplashActivity.class));
                }
            }, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.welcome_activity_layout);
        this.prefs = ((XEagleApp) getApplication()).j();
        this.handler = new Handler();
        this.welcome_cl = (ImageView) findViewById(R.id.iv_pic);
        if (!this.prefs.s()) {
            this.prefs.f(true);
            showPolicyDlg();
            return;
        }
        requestPermission();
    }
}
