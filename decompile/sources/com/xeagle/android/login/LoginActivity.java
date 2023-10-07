package com.xeagle.android.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.u;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.beans.LoginAcceptBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.common.service.DownloadImageService;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UploadCallBack;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.HashMap;
import java.util.Locale;
import kx.d;
import kx.e;
import okhttp3.aa;
import okhttp3.v;
import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends BaseWifiActivity implements View.OnClickListener, RegContract.lLoadView {
    private String account;
    /* access modifiers changed from: private */
    public IButton bt_upload;
    ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DownloadImageService unused = LoginActivity.this.imageService = ((DownloadImageService.DownloadBinder) iBinder).getService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private EditText et_account;
    /* access modifiers changed from: private */
    public EditText et_pw_account;
    private IImageButton ib_et_psw;
    /* access modifiers changed from: private */
    public DownloadImageService imageService;
    /* access modifiers changed from: private */
    public boolean isBind = false;
    /* access modifiers changed from: private */
    public LoginAcceptBeans lab;
    private ListenerListBeans llb;
    private String password;
    /* access modifiers changed from: private */
    public a prefs;
    private RegPresenter presenter;
    /* access modifiers changed from: private */
    public RelativeLayout read_notify_rl;
    private CheckBox sc_read_policy;

    private void initView() {
        int i2;
        int i3;
        int i4;
        int i5;
        IImageButton iImageButton = (IImageButton) findViewById(R.id.iv_go_back);
        this.et_account = (EditText) findViewById(R.id.et_account);
        this.et_pw_account = (EditText) findViewById(R.id.et_pw_account);
        this.bt_upload = (IButton) findViewById(R.id.upload_bt);
        TextView textView = (TextView) findViewById(R.id.tv_forget_pw);
        TextView textView2 = (TextView) findViewById(R.id.tv_toRegister);
        IButton iButton = (IButton) findViewById(R.id.bt_login_post);
        this.ib_et_psw = (IImageButton) findViewById(R.id.ib_et_psw);
        this.read_notify_rl = (RelativeLayout) findViewById(R.id.read_notify_rl);
        CheckBox checkBox = (CheckBox) findViewById(R.id.sc_read_policy);
        this.sc_read_policy = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2) {
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            LoginActivity.this.read_notify_rl.setVisibility(8);
                        }
                    });
                }
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.app_policy);
        SpannableString spannableString = new SpannableString(getString(R.string.policy_notice_text));
        if (!c.b((Context) this) && !c.a((Context) this)) {
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
        spanLocalize(spannableString, i2, i3, i4, i5);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        textView3.setText(spannableString);
        iImageButton.setOnClickListener(this);
        iButton.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.bt_upload.setOnClickListener(this);
        this.ib_et_psw.setOnClickListener(this);
    }

    private void spanLocalize(SpannableString spannableString, int i2, int i3, int i4, int i5) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(foregroundColorSpan, i2, i3, 17);
        spannableString.setSpan(foregroundColorSpan, i4, i5, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(LoginActivity.this.getString(R.string.policy_privacy_title), LoginActivity.this.getString(R.string.policy_privacy_text), new u.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(LoginActivity.this.getSupportFragmentManager(), "policy");
                }
            }
        }, i2, i3, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(LoginActivity.this.getString(R.string.user_notice_title), LoginActivity.this.getString(R.string.user_notice_text), new u.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(LoginActivity.this.getSupportFragmentManager(), "user");
                }
            }
        }, i4, i5, 17);
    }

    private aa toRequestBody(String str) {
        return aa.create(v.b("text/plain"), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047 A[SYNTHETIC, Splitter:B:35:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0051 A[SYNTHETIC, Splitter:B:40:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005c A[SYNTHETIC, Splitter:B:47:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0066 A[SYNTHETIC, Splitter:B:52:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0072 A[SYNTHETIC, Splitter:B:58:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x007c A[SYNTHETIC, Splitter:B:63:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0042=Splitter:B:32:0x0042, B:44:0x0057=Splitter:B:44:0x0057} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFileByByte(byte[] r3, java.lang.String r4) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x000e
            r0.delete()
        L_0x000e:
            r4 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0040, all -> 0x003d }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0040, all -> 0x003d }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x0035, all -> 0x0031 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x0035, all -> 0x0031 }
            r0.write(r3)     // Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002b }
            r0.flush()     // Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002b }
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0027:
            r0.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x002b:
            r3 = move-exception
            goto L_0x0033
        L_0x002d:
            r3 = move-exception
            goto L_0x0037
        L_0x002f:
            r3 = move-exception
            goto L_0x003b
        L_0x0031:
            r3 = move-exception
            r0 = r4
        L_0x0033:
            r4 = r1
            goto L_0x0070
        L_0x0035:
            r3 = move-exception
            r0 = r4
        L_0x0037:
            r4 = r1
            goto L_0x0042
        L_0x0039:
            r3 = move-exception
            r0 = r4
        L_0x003b:
            r4 = r1
            goto L_0x0057
        L_0x003d:
            r3 = move-exception
            r0 = r4
            goto L_0x0070
        L_0x0040:
            r3 = move-exception
            r0 = r4
        L_0x0042:
            r3.printStackTrace()     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x004f
            r4.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004f:
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x0055:
            r3 = move-exception
            r0 = r4
        L_0x0057:
            r3.printStackTrace()     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0064:
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x006e:
            return
        L_0x006f:
            r3 = move-exception
        L_0x0070:
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007a:
            if (r0 == 0) goto L_0x0084
            r0.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0084:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.LoginActivity.writeFileByByte(byte[], java.lang.String):void");
    }

    public void onClick(View view) {
        IImageButton iImageButton;
        int i2;
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_login_post:
                if (!this.sc_read_policy.isChecked()) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            LoginActivity.this.read_notify_rl.setVisibility(0);
                        }
                    });
                    return;
                }
                String obj = this.et_account.getText().toString();
                this.account = obj;
                if (kw.c.b(obj) || kw.c.a(this.account)) {
                    this.password = this.et_pw_account.getText().toString();
                    HashMap hashMap = new HashMap();
                    hashMap.put("account", this.account);
                    hashMap.put("password", this.password);
                    this.presenter.login(UserGlobal.BASE_URL, hashMap);
                    return;
                }
                ToastUtils.showLong((CharSequence) getString(R.string.login_error_account));
                return;
            case R.id.ib_et_psw:
                if (this.et_pw_account.getInputType() == 128) {
                    this.et_pw_account.setInputType(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN);
                    iImageButton = this.ib_et_psw;
                    i2 = R.drawable.et_gone;
                } else {
                    this.et_pw_account.setInputType(128);
                    iImageButton = this.ib_et_psw;
                    i2 = R.drawable.et_visible;
                }
                iImageButton.setImageResource(i2);
                EditText editText = this.et_pw_account;
                editText.setSelection(editText.getText().length());
                return;
            case R.id.iv_go_back:
                finish();
                intent = new Intent(this, SplashActivity.class);
                break;
            case R.id.tv_forget_pw:
                intent = new Intent(this, ForgetPwActivity.class);
                break;
            case R.id.tv_toRegister:
                intent = new Intent(this, RegisterActivity.class);
                break;
            case R.id.upload_bt:
                if (this.lab != null) {
                    String[] b2 = e.b(getApplicationContext());
                    String str = d.d(getApplicationContext()) + b2[b2.length - 1];
                    Log.i("Register", "onClick: ----str path----" + b2[b2.length - 1] + "----path---" + str);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("token", toRequestBody(this.lab.getData().getToken()));
                    hashMap2.put("flying_off", toRequestBody("2020-03-03 15:14:20"));
                    hashMap2.put("fly_total_time", toRequestBody("235"));
                    hashMap2.put("mileage", toRequestBody("107.5"));
                    this.presenter.uploadFile(UserGlobal.BASE_URL, str, hashMap2, new UploadCallBack<UploadAcceptBeans>() {
                        public void onFailure(Call<UploadAcceptBeans> call, final Throwable th) {
                            LoginActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    LoginActivity.this.bt_upload.setText("upload");
                                    Log.i("Register", "run: -----" + th.getMessage());
                                }
                            });
                        }

                        public void onLoading(long j2, long j3) {
                            super.onLoading(j2, j3);
                            final long j4 = j3;
                            final long j5 = j2;
                            LoginActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    LoginActivity.this.bt_upload.setText(String.format(Locale.US, "%d/%d", new Object[]{Long.valueOf(j4), Long.valueOf(j5)}));
                                }
                            });
                        }

                        public void onSuccess(Call<UploadAcceptBeans> call, Response<UploadAcceptBeans> response) {
                            LoginActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    LoginActivity.this.bt_upload.setText("upload");
                                }
                            });
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.login_activity_layout);
        initView();
        this.presenter = new RegPresenter(this);
        this.prefs = ((XEagleApp) getApplication()).j();
        this.isBind = bindService(new Intent(this, DownloadImageService.class), this.connection, 1);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void regError(int i2, String str) {
        Log.i("ServeTest", "regError:---" + i2 + "--- " + str);
        if (i2 == 2) {
            ToastHelper.showToastInnerWithTopCenter(this, String.format(Locale.US, "%s:%s", new Object[]{getString(R.string.request_error), str}), 1);
        }
    }

    public void regFailure(int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void regSuccess(int r2, final java.lang.Object r3) {
        /*
            r1 = this;
            r0 = 2
            if (r2 != r0) goto L_0x0094
            com.xeagle.android.login.beans.LoginAcceptBeans r3 = (com.xeagle.android.login.beans.LoginAcceptBeans) r3
            r1.lab = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "regSuccess: ----"
            r2.append(r3)
            com.xeagle.android.login.beans.LoginAcceptBeans r3 = r1.lab
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ServeTest"
            android.util.Log.i(r3, r2)
            com.xeagle.android.login.beans.LoginAcceptBeans r2 = r1.lab
            int r2 = r2.getCode()
            r3 = 200(0xc8, float:2.8E-43)
            r0 = 1
            if (r2 == r3) goto L_0x003f
            r3 = 4011(0xfab, float:5.62E-42)
            if (r2 == r3) goto L_0x003b
            r3 = 4012(0xfac, float:5.622E-42)
            if (r2 == r3) goto L_0x0037
            goto L_0x0049
        L_0x0037:
            r2 = 2131820911(0x7f11016f, float:1.927455E38)
            goto L_0x0042
        L_0x003b:
            r2 = 2131820910(0x7f11016e, float:1.9274548E38)
            goto L_0x0042
        L_0x003f:
            r2 = 2131820912(0x7f110170, float:1.9274552E38)
        L_0x0042:
            java.lang.String r2 = r1.getString(r2)
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r1, r2, r0)
        L_0x0049:
            com.xeagle.android.login.beans.LoginAcceptBeans r2 = r1.lab
            boolean r2 = r2.isStatus()
            if (r2 != 0) goto L_0x0052
            return
        L_0x0052:
            com.xeagle.android.utils.prefs.a r2 = r1.prefs
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.xeagle.android.login.beans.LoginAcceptBeans r0 = r1.lab
            com.xeagle.android.login.beans.LoginData r0 = r0.getData()
            int r0 = r0.getUid()
            r3.append(r0)
            java.lang.String r0 = ""
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.K(r3)
            ka.a r2 = ka.a.a()
            java.util.concurrent.ThreadPoolExecutor r2 = r2.b()
            com.xeagle.android.login.LoginActivity$7 r3 = new com.xeagle.android.login.LoginActivity$7
            r3.<init>()
            r2.execute(r3)
            com.xeagle.android.login.retrofitLogin.RegPresenter r2 = r1.presenter
            com.xeagle.android.login.beans.LoginAcceptBeans r3 = r1.lab
            com.xeagle.android.login.beans.LoginData r3 = r3.getData()
            java.lang.String r3 = r3.getToken()
            java.lang.String r0 = "http://api.cfly-cn.com/"
            r2.getUserInfo(r0, r3)
            goto L_0x00a8
        L_0x0094:
            r0 = 9
            if (r2 != r0) goto L_0x00a8
            ka.a r2 = ka.a.a()
            java.util.concurrent.ThreadPoolExecutor r2 = r2.b()
            com.xeagle.android.login.LoginActivity$8 r0 = new com.xeagle.android.login.LoginActivity$8
            r0.<init>(r3)
            r2.execute(r0)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.LoginActivity.regSuccess(int, java.lang.Object):void");
    }
}
