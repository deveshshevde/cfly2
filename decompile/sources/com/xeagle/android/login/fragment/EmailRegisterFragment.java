package com.xeagle.android.login.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.LoginActivity;
import com.xeagle.android.login.RegisterActivity;
import com.xeagle.android.login.beans.RegAcceptBeans;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.utils.e;
import java.util.Locale;

public class EmailRegisterFragment extends Fragment implements View.OnClickListener, RegContract.lLoadView {
    private IButton bt_get_code;
    private String confirmPwd;
    private String emailCode;
    private String emailNum;
    private EditText et_confirm_pw;
    private EditText et_email;
    private EditText et_email_code;
    private EditText et_pw;
    private e handler = new e();
    private ImageButton ib_pwd_confirm_visible;
    private ImageButton ib_pwd_visible;
    private RegPresenter loadPresenter;
    private RegisterActivity parent;
    private String pwd;
    private int time = 120;
    Runnable timeOut = new Runnable() {
        public void run() {
            EmailRegisterFragment.this.updateTimeOut();
        }
    };

    private void initView(View view) {
        this.et_email = (EditText) view.findViewById(R.id.et_email_register);
        this.et_pw = (EditText) view.findViewById(R.id.et_pw_email);
        this.et_email_code = (EditText) view.findViewById(R.id.et_email_code);
        this.bt_get_code = (IButton) view.findViewById(R.id.bt_get_code);
        this.ib_pwd_visible = (ImageButton) view.findViewById(R.id.ib_pwd_visible);
        this.et_confirm_pw = (EditText) view.findViewById(R.id.et_pw_confirm_email);
        this.ib_pwd_confirm_visible = (ImageButton) view.findViewById(R.id.ib_pwd_confirm_visible);
        ((IButton) view.findViewById(R.id.bt_post_email)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.tv_toLogin_email)).setOnClickListener(this);
        this.bt_get_code.setOnClickListener(this);
        this.ib_pwd_visible.setOnClickListener(this);
        this.ib_pwd_confirm_visible.setOnClickListener(this);
    }

    private void startIntent(Class<?> cls) {
        startActivity(new Intent(getActivity(), cls));
    }

    /* access modifiers changed from: private */
    public void updateTimeOut() {
        int i2 = this.time;
        if (i2 == 0) {
            this.handler.b(this.timeOut);
            this.bt_get_code.setText(this.parent.getString(R.string.code_reacquire));
            return;
        }
        IButton iButton = this.bt_get_code;
        RegisterActivity registerActivity = this.parent;
        this.time = i2 - 1;
        iButton.setText(registerActivity.getString(R.string.code_obsolete, new Object[]{Integer.valueOf(i2)}));
        this.handler.a(this.timeOut, 1000);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (RegisterActivity) activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        r8.setSelection(r8.getText().length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b1, code lost:
        com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r8, r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r8.getId()
            java.lang.String r0 = "http://api.cfly-cn.com/"
            java.lang.String r1 = "email"
            r2 = 2131231186(0x7f0801d2, float:1.8078446E38)
            r3 = 129(0x81, float:1.81E-43)
            r4 = 2131231187(0x7f0801d3, float:1.8078448E38)
            r5 = 0
            r6 = 128(0x80, float:1.794E-43)
            switch(r8) {
                case 2131296668: goto L_0x0134;
                case 2131296677: goto L_0x0070;
                case 2131297428: goto L_0x0044;
                case 2131297430: goto L_0x0024;
                case 2131299562: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x01a0
        L_0x0018:
            com.xeagle.android.login.RegisterActivity r8 = r7.parent
            r8.finish()
            java.lang.Class<com.xeagle.android.login.LoginActivity> r8 = com.xeagle.android.login.LoginActivity.class
            r7.startIntent(r8)
            goto L_0x01a0
        L_0x0024:
            android.widget.EditText r8 = r7.et_pw
            int r8 = r8.getInputType()
            if (r8 != r6) goto L_0x0037
            android.widget.EditText r8 = r7.et_pw
            r8.setInputType(r3)
            android.widget.ImageButton r8 = r7.ib_pwd_visible
            r8.setImageResource(r2)
            goto L_0x0041
        L_0x0037:
            android.widget.EditText r8 = r7.et_pw
            r8.setInputType(r6)
            android.widget.ImageButton r8 = r7.ib_pwd_visible
            r8.setImageResource(r4)
        L_0x0041:
            android.widget.EditText r8 = r7.et_pw
            goto L_0x0063
        L_0x0044:
            android.widget.EditText r8 = r7.et_confirm_pw
            int r8 = r8.getInputType()
            if (r8 != r6) goto L_0x0057
            android.widget.EditText r8 = r7.et_confirm_pw
            r8.setInputType(r3)
            android.widget.ImageButton r8 = r7.ib_pwd_confirm_visible
            r8.setImageResource(r2)
            goto L_0x0061
        L_0x0057:
            android.widget.EditText r8 = r7.et_confirm_pw
            r8.setInputType(r6)
            android.widget.ImageButton r8 = r7.ib_pwd_confirm_visible
            r8.setImageResource(r4)
        L_0x0061:
            android.widget.EditText r8 = r7.et_confirm_pw
        L_0x0063:
            android.text.Editable r0 = r8.getText()
            int r0 = r0.length()
            r8.setSelection(r0)
            goto L_0x01a0
        L_0x0070:
            android.widget.EditText r8 = r7.et_email
            android.text.Editable r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            r7.emailNum = r8
            android.widget.EditText r8 = r7.et_pw
            android.text.Editable r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            r7.pwd = r8
            android.widget.EditText r8 = r7.et_email_code
            android.text.Editable r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            r7.emailCode = r8
            android.widget.EditText r8 = r7.et_confirm_pw
            android.text.Editable r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            r7.confirmPwd = r8
            java.lang.String r8 = r7.emailNum
            int r8 = r8.length()
            if (r8 > 0) goto L_0x00b6
            com.xeagle.android.login.RegisterActivity r8 = r7.parent
            r0 = 2131822168(0x7f110658, float:1.92771E38)
        L_0x00ad:
            java.lang.String r0 = r8.getString(r0)
        L_0x00b1:
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r8, r0, r5)
            goto L_0x01a0
        L_0x00b6:
            java.lang.String r8 = r7.emailNum
            boolean r8 = kw.c.b(r8)
            if (r8 != 0) goto L_0x00ca
            com.xeagle.android.login.RegisterActivity r8 = r7.parent
            r2 = 2131821152(0x7f110260, float:1.927504E38)
            java.lang.String r2 = r8.getString(r2)
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r8, r2, r5)
        L_0x00ca:
            java.lang.String r8 = r7.pwd
            int r8 = r8.length()
            r2 = 1
            r3 = 2131821160(0x7f110268, float:1.9275055E38)
            r4 = 8
            if (r8 < r4) goto L_0x012a
            java.lang.String r8 = r7.pwd
            int r8 = r8.length()
            r6 = 20
            if (r8 <= r6) goto L_0x00e3
            goto L_0x012a
        L_0x00e3:
            java.lang.String r8 = r7.confirmPwd
            int r8 = r8.length()
            if (r8 < r4) goto L_0x012a
            java.lang.String r8 = r7.confirmPwd
            int r8 = r8.length()
            if (r8 <= r6) goto L_0x00f4
            goto L_0x012a
        L_0x00f4:
            java.lang.String r8 = r7.confirmPwd
            java.lang.String r2 = r7.pwd
            boolean r8 = r8.equalsIgnoreCase(r2)
            if (r8 != 0) goto L_0x0104
            com.xeagle.android.login.RegisterActivity r8 = r7.parent
            r0 = 2131822019(0x7f1105c3, float:1.9276798E38)
            goto L_0x00ad
        L_0x0104:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r2 = r7.emailNum
            r8.put(r1, r2)
            java.lang.String r1 = r7.confirmPwd
            java.lang.String r2 = "confrim_password"
            r8.put(r2, r1)
            java.lang.String r1 = r7.pwd
            java.lang.String r2 = "password"
            r8.put(r2, r1)
            java.lang.String r1 = r7.emailCode
            java.lang.String r2 = "captcha"
            r8.put(r2, r1)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r7.loadPresenter
            r1.regCart(r0, r8)
            goto L_0x01a0
        L_0x012a:
            com.xeagle.android.login.RegisterActivity r8 = r7.parent
            java.lang.String r0 = r8.getString(r3)
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r8, r0, r2)
            goto L_0x01a0
        L_0x0134:
            int r8 = r7.time
            r2 = 120(0x78, float:1.68E-43)
            if (r8 != 0) goto L_0x0144
            com.xeagle.android.vjoystick.utils.e r8 = r7.handler
            java.lang.Runnable r3 = r7.timeOut
            r8.b(r3)
            r7.time = r2
            goto L_0x0155
        L_0x0144:
            if (r8 >= r2) goto L_0x0155
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            com.xeagle.android.login.RegisterActivity r0 = r7.parent
            r1 = 2131820899(0x7f110163, float:1.9274526E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x00b1
        L_0x0155:
            int r8 = r7.time
            if (r8 != r2) goto L_0x01a0
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            android.widget.EditText r2 = r7.et_email
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r7.emailNum = r2
            java.lang.String r2 = "action"
            java.lang.String r3 = "register"
            r8.put(r2, r3)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getCountry()
            java.util.Locale r3 = java.util.Locale.CHINA
            java.lang.String r3 = r3.getCountry()
            boolean r2 = r2.equals(r3)
            java.lang.String r3 = "lang"
            if (r2 == 0) goto L_0x018a
            java.lang.String r2 = "CN"
            goto L_0x018c
        L_0x018a:
            java.lang.String r2 = "EN"
        L_0x018c:
            r8.put(r3, r2)
            java.lang.String r2 = "type"
            r8.put(r2, r1)
            java.lang.String r1 = r7.emailNum
            java.lang.String r2 = "account"
            r8.put(r2, r1)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r7.loadPresenter
            r1.regCode(r0, r8)
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.EmailRegisterFragment.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.email_register_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        this.loadPresenter = new RegPresenter(this);
    }

    public void regError(int i2, String str) {
        ToastHelper.showToastInnerWithTopCenter(this.parent, String.format(Locale.US, "%s:%s", new Object[]{getString(R.string.request_error), str}), 1);
        Log.i("Register", "regError: ----" + str);
    }

    public void regFailure(int i2) {
        RegisterActivity registerActivity;
        int i3;
        if (i2 == 1) {
            registerActivity = this.parent;
            i3 = R.string.register_failed;
        } else if (i2 == 0) {
            registerActivity = this.parent;
            i3 = R.string.verification_failed;
        } else {
            return;
        }
        ToastHelper.showToastInnerWithTopCenter(registerActivity, registerActivity.getString(i3), 0);
    }

    public void regSuccess(int i2, Object obj) {
        RegisterActivity registerActivity;
        int i3;
        FragmentActivity activity;
        RegisterActivity registerActivity2;
        int i4;
        RegAcceptBeans regAcceptBeans = (RegAcceptBeans) obj;
        Log.i("Register", "regSuccess: ------" + regAcceptBeans.toString());
        if (i2 == 0) {
            if (regAcceptBeans.isStatus()) {
                updateTimeOut();
                return;
            }
            if (regAcceptBeans.getCode() == 4015) {
                activity = getActivity();
                registerActivity2 = this.parent;
                i4 = R.string.code_4015;
            } else if (regAcceptBeans.getCode() == 4010) {
                activity = getActivity();
                registerActivity2 = this.parent;
                i4 = R.string.code_4010;
            } else if (regAcceptBeans.getCode() == 400) {
                activity = getActivity();
                registerActivity2 = this.parent;
                i4 = R.string.code_400;
            } else {
                activity = getActivity();
                registerActivity2 = this.parent;
                i4 = R.string.code_get_failed;
            }
            ToastHelper.showToastInnerWithTopCenter(activity, registerActivity2.getString(i4), 0);
        } else if (i2 == 1) {
            int code = regAcceptBeans.getCode();
            if (code != 200) {
                switch (code) {
                    case 4003:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4003;
                        break;
                    case 4004:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4004;
                        break;
                    case 4005:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4005;
                        break;
                    case 4006:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4006;
                        break;
                    case 4007:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4007;
                        break;
                    case 4008:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4008;
                        break;
                    case 4009:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4009;
                        break;
                }
            } else {
                registerActivity = this.parent;
                i3 = R.string.code_info_200;
            }
            ToastHelper.showToastInnerWithTopCenter(registerActivity, registerActivity.getString(i3), 1);
            if (regAcceptBeans.isStatus()) {
                this.parent.finish();
                startIntent(LoginActivity.class);
            }
        }
    }
}
