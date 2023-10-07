package com.xeagle.android.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.beans.UserInfoAcceptBeans;
import com.xeagle.android.login.common.CircleImageView;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.common.UI;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import java.io.File;
import java.util.ArrayList;
import okhttp3.aa;
import okhttp3.v;
import okhttp3.w;
import org.litepal.crud.callback.SaveCallback;

public class UserSettingActivity extends UI implements View.OnClickListener, RegContract.lLoadView {
    /* access modifiers changed from: private */
    public String iconPath;
    private ArrayList<GLImage> images;
    /* access modifiers changed from: private */

    /* renamed from: info  reason: collision with root package name */
    public UserInfo f23791info;
    private boolean isAvatar = false;
    /* access modifiers changed from: private */
    public TextView nick_tv;
    private String path;
    /* access modifiers changed from: private */
    public a prefs;
    /* access modifiers changed from: private */
    public RegPresenter presenter;
    /* access modifiers changed from: private */
    public ProgressBar update_pb;
    /* access modifiers changed from: private */
    public CircleImageView userIcon;
    private RelativeLayout user_logout_rl;
    private RelativeLayout user_pwd_rl;

    private void initView() {
        a j2 = ((XEagleApp) getApplication()).j();
        this.prefs = j2;
        this.f23791info = UserLiteHelper.getUserInfo(j2.aE());
        this.presenter = new RegPresenter(this);
        this.userIcon = (CircleImageView) findViewById(R.id.cv_user_icon);
        this.nick_tv = (TextView) findViewById(R.id.user_nick_tv);
        this.update_pb = (ProgressBar) findViewById(R.id.update_pb);
        findViewById(R.id.ib_go_back).setOnClickListener(this);
        this.nick_tv.setText(this.f23791info.getUserName());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.user_logout_rl);
        this.user_logout_rl = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.user_pwd_rl);
        this.user_pwd_rl = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        if (this.f23791info.getIconPath() == null || this.f23791info.getIconPath().equals("-") || this.f23791info.getIconPath().equals("") || !new File(this.f23791info.getIconPath()).exists()) {
            this.userIcon.setImageDrawable(getDrawable(R.drawable.avatar_default));
        } else {
            this.userIcon.setImageBitmap(c.b(this.f23791info.getIconPath()));
        }
        this.userIcon.setOnClickListener(this);
        this.nick_tv.setOnClickListener(this);
        findViewById(R.id.save_rl).setOnClickListener(this);
    }

    private void onPicked(Intent intent) {
        ArrayList arrayList;
        if (intent != null && (arrayList = (ArrayList) intent.getSerializableExtra(Constants.EXTRA_RESULT_ITEMS)) != null && !arrayList.isEmpty()) {
            GLImage gLImage = (GLImage) arrayList.get(0);
            this.path = gLImage.getPath();
            updateAvatar(gLImage.getPath());
        }
    }

    private aa toRequestBody(String str) {
        return aa.create(v.b("text/plain"), str);
    }

    private w.b toRequestBodyOfImage(String str, File file) {
        return w.b.a(str, file.getName(), aa.create(v.b("multipart/form-data"), file));
    }

    /* access modifiers changed from: private */
    public w.b toRequestBodyOfText(String str, String str2) {
        return w.b.a(str, str2);
    }

    private void updateAvatar(String str) {
        if (!TextUtils.isEmpty(str)) {
            new File(str);
            this.isAvatar = true;
            final Bitmap b2 = c.b(str);
            runOnUiThread(new Runnable() {
                public void run() {
                    UserSettingActivity.this.userIcon.setImageBitmap(b2);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1010 && i3 == -1) {
            onPicked(intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, HostManagerActivity.class));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.xeagle.android.login.UserSettingActivity$6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.xeagle.android.login.UserSettingActivity$4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: com.xeagle.android.login.UserSettingActivity$4} */
    /* JADX WARNING: type inference failed for: r0v7, types: [android.view.View$OnClickListener] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r14) {
        /*
            r13 = this;
            int r14 = r14.getId()
            r0 = 2131297390(0x7f09046e, float:1.8212724E38)
            r1 = 2131297423(0x7f09048f, float:1.821279E38)
            r2 = 2131297080(0x7f090338, float:1.8212095E38)
            r3 = 2131298289(0x7f0907f1, float:1.8214547E38)
            r4 = 2131886906(0x7f12033a, float:1.9408404E38)
            r5 = 2131493032(0x7f0c00a8, float:1.8609533E38)
            r6 = 301989888(0x12000000, float:4.0389678E-28)
            switch(r14) {
                case 2131296919: goto L_0x0274;
                case 2131297408: goto L_0x0266;
                case 2131298672: goto L_0x01c1;
                case 2131299637: goto L_0x01ab;
                case 2131299639: goto L_0x00ec;
                case 2131299641: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0280
        L_0x001d:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r7 = "onClick: ---get oldPassword--"
            r14.append(r7)
            com.flypro.core.database.UserInfo r7 = r13.f23791info
            java.lang.String r7 = r7.getPassword()
            r14.append(r7)
            java.lang.String r14 = r14.toString()
            java.lang.String r7 = "newUI"
            android.util.Log.i(r7, r14)
            android.app.AlertDialog$Builder r14 = new android.app.AlertDialog$Builder     // Catch:{ NoSuchMethodError -> 0x003f }
            r14.<init>(r13, r4)     // Catch:{ NoSuchMethodError -> 0x003f }
            goto L_0x0044
        L_0x003f:
            android.app.AlertDialog$Builder r14 = new android.app.AlertDialog$Builder
            r14.<init>(r13)
        L_0x0044:
            r14.setView(r5)
            android.app.AlertDialog r14 = r14.create()
            r14.show()
            android.view.Window r4 = r14.getWindow()
            if (r4 != 0) goto L_0x0055
            return
        L_0x0055:
            android.view.WindowManager r5 = r4.getWindowManager()
            android.view.Display r5 = r5.getDefaultDisplay()
            int r5 = r5.getWidth()
            int r5 = r5 * 3
            int r5 = r5 / 4
            android.view.WindowManager r7 = r4.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            int r7 = r7.getHeight()
            int r7 = r7 * 2
            int r7 = r7 / 5
            r4.setLayout(r5, r7)
            r5 = 2131493398(0x7f0c0216, float:1.8610275E38)
            r4.setContentView(r5)
            r5 = 2131297103(0x7f09034f, float:1.8212141E38)
            android.view.View r5 = r4.findViewById(r5)
            r9 = r5
            android.widget.EditText r9 = (android.widget.EditText) r9
            r5 = 2131297102(0x7f09034e, float:1.821214E38)
            android.view.View r5 = r4.findViewById(r5)
            r10 = r5
            android.widget.EditText r10 = (android.widget.EditText) r10
            r5 = 2131297110(0x7f090356, float:1.8212156E38)
            android.view.View r5 = r4.findViewById(r5)
            r11 = r5
            android.widget.EditText r11 = (android.widget.EditText) r11
            r9.setImeOptions(r6)
            r9.setSingleLine()
            r10.setImeOptions(r6)
            r10.setSingleLine()
            r11.setImeOptions(r6)
            r11.setSingleLine()
            android.view.View r3 = r4.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r5 = 2131820851(0x7f110133, float:1.9274429E38)
            java.lang.String r5 = r13.getString(r5)
            r3.setText(r5)
            android.view.View r2 = r4.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131820864(0x7f110140, float:1.9274455E38)
            java.lang.String r3 = r13.getString(r3)
            r2.setText(r3)
            android.view.View r1 = r4.findViewById(r1)
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = (com.xeagle.android.vjoystick.IWidgets.IButton) r1
            android.view.View r0 = r4.findViewById(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            com.xeagle.android.login.UserSettingActivity$3 r2 = new com.xeagle.android.login.UserSettingActivity$3
            r2.<init>(r14)
            r0.setOnClickListener(r2)
            com.xeagle.android.login.UserSettingActivity$4 r0 = new com.xeagle.android.login.UserSettingActivity$4
            r7 = r0
            r8 = r13
            r12 = r14
            r7.<init>(r9, r10, r11, r12)
            goto L_0x01a3
        L_0x00ec:
            android.app.AlertDialog$Builder r14 = new android.app.AlertDialog$Builder     // Catch:{ NoSuchMethodError -> 0x00f2 }
            r14.<init>(r13, r4)     // Catch:{ NoSuchMethodError -> 0x00f2 }
            goto L_0x00fe
        L_0x00f2:
            java.lang.String r14 = "TEST"
            java.lang.String r4 = "Older SDK, using old Builder"
            android.util.Log.e(r14, r4)
            android.app.AlertDialog$Builder r14 = new android.app.AlertDialog$Builder
            r14.<init>(r13)
        L_0x00fe:
            r14.setView(r5)
            android.app.AlertDialog r14 = r14.create()
            r14.show()
            android.view.Window r4 = r14.getWindow()
            if (r4 != 0) goto L_0x010f
            return
        L_0x010f:
            android.view.WindowManager r7 = r4.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            int r7 = r7.getWidth()
            int r7 = r7 * 3
            int r7 = r7 / 4
            android.view.WindowManager r8 = r4.getWindowManager()
            android.view.Display r8 = r8.getDefaultDisplay()
            int r8 = r8.getHeight()
            int r8 = r8 * 2
            int r8 = r8 / 5
            r4.setLayout(r7, r8)
            r4.setContentView(r5)
            r5 = 2131297071(0x7f09032f, float:1.8212077E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            r5.setImeOptions(r6)
            r5.setSingleLine()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.flypro.core.database.UserInfo r7 = r13.f23791info
            java.lang.String r7 = r7.getUserName()
            r6.append(r7)
            java.lang.String r7 = ""
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.setHint(r6)
            r6 = 1
            r5.setFocusable(r6)
            r5.setFocusableInTouchMode(r6)
            android.view.View r3 = r4.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r6 = 2131820850(0x7f110132, float:1.9274427E38)
            java.lang.String r6 = r13.getString(r6)
            r3.setText(r6)
            android.view.View r2 = r4.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131822081(0x7f110601, float:1.9276923E38)
            java.lang.String r3 = r13.getString(r3)
            r2.setText(r3)
            r3 = 8
            r2.setVisibility(r3)
            android.view.View r1 = r4.findViewById(r1)
            com.xeagle.android.vjoystick.IWidgets.IButton r1 = (com.xeagle.android.vjoystick.IWidgets.IButton) r1
            android.view.View r0 = r4.findViewById(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            com.xeagle.android.login.UserSettingActivity$5 r2 = new com.xeagle.android.login.UserSettingActivity$5
            r2.<init>(r14)
            r0.setOnClickListener(r2)
            com.xeagle.android.login.UserSettingActivity$6 r0 = new com.xeagle.android.login.UserSettingActivity$6
            r0.<init>(r5, r14)
        L_0x01a3:
            r1.setOnClickListener(r0)
            r14.show()
            goto L_0x0280
        L_0x01ab:
            android.content.Intent r14 = new android.content.Intent
            java.lang.Class<com.xeagle.android.login.SplashActivity> r0 = com.xeagle.android.login.SplashActivity.class
            r14.<init>(r13, r0)
            com.xeagle.android.utils.prefs.a r0 = r13.prefs
            java.lang.String r1 = "-"
            r0.K(r1)
            r13.startActivity(r14)
            r13.finish()
            goto L_0x0280
        L_0x01c1:
            boolean r14 = r13.isAvatar
            java.lang.String r0 = "http://api.cfly-cn.com/"
            java.lang.String r1 = "nickname"
            r2 = 0
            java.lang.String r3 = "token"
            if (r14 == 0) goto L_0x021a
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.flypro.core.database.UserInfo r4 = r13.f23791info
            if (r4 != 0) goto L_0x01d6
            return
        L_0x01d6:
            java.lang.String r4 = r4.getToken()
            okhttp3.aa r4 = r13.toRequestBody(r4)
            r14.put(r3, r4)
            com.flypro.core.database.UserInfo r3 = r13.f23791info
            java.lang.String r3 = r3.getUserName()
            android.widget.TextView r4 = r13.nick_tv
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0208
            android.widget.TextView r3 = r13.nick_tv
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            okhttp3.aa r3 = r13.toRequestBody(r3)
            r14.put(r1, r3)
        L_0x0208:
            android.widget.ProgressBar r1 = r13.update_pb
            r1.setVisibility(r2)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r13.presenter
            java.lang.String r2 = r13.path
            com.xeagle.android.login.UserSettingActivity$1 r3 = new com.xeagle.android.login.UserSettingActivity$1
            r3.<init>()
            r1.uploadAvatar(r0, r2, r14, r3)
            goto L_0x0280
        L_0x021a:
            com.flypro.core.database.UserInfo r14 = r13.f23791info
            if (r14 != 0) goto L_0x021f
            return
        L_0x021f:
            java.lang.String r14 = r14.getUserName()
            android.widget.TextView r4 = r13.nick_tv
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            boolean r14 = r14.equals(r4)
            if (r14 != 0) goto L_0x0280
            android.widget.ProgressBar r14 = r13.update_pb
            r14.setVisibility(r2)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.flypro.core.database.UserInfo r2 = r13.f23791info
            java.lang.String r2 = r2.getToken()
            okhttp3.w$b r2 = r13.toRequestBodyOfText(r3, r2)
            r14.add(r2)
            android.widget.TextView r2 = r13.nick_tv
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            okhttp3.w$b r1 = r13.toRequestBodyOfText(r1, r2)
            r14.add(r1)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r13.presenter
            com.xeagle.android.login.UserSettingActivity$2 r2 = new com.xeagle.android.login.UserSettingActivity$2
            r2.<init>()
            r1.getUserInfoResult(r0, r14, r2)
            goto L_0x0280
        L_0x0266:
            r13.finish()
            android.content.Intent r14 = new android.content.Intent
            java.lang.Class<com.xeagle.android.login.HostManagerActivity> r0 = com.xeagle.android.login.HostManagerActivity.class
            r14.<init>(r13, r0)
            r13.startActivity(r14)
            goto L_0x0280
        L_0x0274:
            android.content.Intent r14 = new android.content.Intent
            java.lang.Class<com.xeagle.android.login.pickImage.TakeIconActivity> r0 = com.xeagle.android.login.pickImage.TakeIconActivity.class
            r14.<init>(r13, r0)
            r0 = 1010(0x3f2, float:1.415E-42)
            r13.startActivityForResult(r14, r0)
        L_0x0280:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.UserSettingActivity.onClick(android.view.View):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.user_setting_activity);
        initView();
    }

    public void regError(int i2, String str) {
        Log.i("Listener", "regError: ---修改---" + str + "...type..." + i2);
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
        if (i2 == 9) {
            UserInfoAcceptBeans userInfoAcceptBeans = (UserInfoAcceptBeans) obj;
            if (!this.f23791info.getUserName().equals(userInfoAcceptBeans.getData().getNickname())) {
                UserLiteHelper.updateUserName(this.prefs.aE(), userInfoAcceptBeans.getData().getNickname(), new SaveCallback() {
                    public void onFinish(boolean z2) {
                        UserSettingActivity.this.update_pb.post(new Runnable() {
                            public void run() {
                                UserSettingActivity.this.update_pb.setVisibility(8);
                                ToastHelper.showToast((Context) UserSettingActivity.this, UserSettingActivity.this.getString(R.string.modify_success));
                                UserSettingActivity.this.startActivity(new Intent(UserSettingActivity.this, HostManagerActivity.class));
                                UserSettingActivity.this.finish();
                            }
                        });
                    }
                });
            }
        }
    }
}
