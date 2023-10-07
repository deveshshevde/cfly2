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
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
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

public class PhoneRegisterFragment extends Fragment implements View.OnClickListener, RegContract.lLoadView {
    private String confirm_pwd;
    private String emailNum;
    private EditText et_confirm_pwd;
    private EditText et_email;
    private EditText et_msg_code;
    private EditText et_phone;
    private EditText et_phone_pw;
    private e handler = new e();
    private ImageButton ib_confirm_pwd_show;
    private IButton ib_get_code;
    private ImageButton ib_pwd_show;
    private RegPresenter loadPresenter;
    private String msgCode;
    private RegisterActivity parent;
    private String phoneNum;
    private String pwd;
    private int time = 120;
    Runnable timeOut = new Runnable() {
        public void run() {
            PhoneRegisterFragment.this.updateTimeOut();
        }
    };

    private void initView(View view) {
        this.et_phone = (EditText) view.findViewById(R.id.et_phone);
        this.et_phone_pw = (EditText) view.findViewById(R.id.et_pw);
        this.et_email = (EditText) view.findViewById(R.id.et_email);
        this.et_msg_code = (EditText) view.findViewById(R.id.et_message_code);
        this.ib_pwd_show = (ImageButton) view.findViewById(R.id.ib_pwd_show);
        this.et_confirm_pwd = (EditText) view.findViewById(R.id.et_confirm_pw);
        this.ib_confirm_pwd_show = (ImageButton) view.findViewById(R.id.ib_confirm_pwd_show);
        this.ib_get_code = (IButton) view.findViewById(R.id.bt_get_code);
        this.ib_get_code.setOnClickListener(this);
        ((IButton) view.findViewById(R.id.bt_register_post)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.tv_toLogin)).setOnClickListener(this);
        this.ib_pwd_show.setOnClickListener(this);
        this.ib_confirm_pwd_show.setOnClickListener(this);
    }

    private void startIntent(Class<?> cls) {
        startActivity(new Intent(this.parent, cls));
    }

    /* access modifiers changed from: private */
    public void updateTimeOut() {
        if (this.time == 0) {
            this.handler.b(this.timeOut);
            this.ib_get_code.setText(this.parent.getString(R.string.code_reacquire));
            return;
        }
        IButton iButton = this.ib_get_code;
        Locale locale = Locale.US;
        String string = this.parent.getString(R.string.code_obsolete);
        int i2 = this.time;
        this.time = i2 - 1;
        iButton.setText(String.format(locale, string, new Object[]{Integer.valueOf(i2)}));
        this.handler.a(this.timeOut, 1000);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (RegisterActivity) activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        r7.setSelection(r7.getText().length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0120, code lost:
        com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r7, r7.getString(r0), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            int r7 = r7.getId()
            java.lang.String r0 = "http://api.cfly-cn.com/"
            r1 = 0
            r2 = 2131231186(0x7f0801d2, float:1.8078446E38)
            r3 = 129(0x81, float:1.81E-43)
            r4 = 2131231187(0x7f0801d3, float:1.8078448E38)
            r5 = 128(0x80, float:1.794E-43)
            switch(r7) {
                case 2131296668: goto L_0x0109;
                case 2131296679: goto L_0x006e;
                case 2131297395: goto L_0x0042;
                case 2131297429: goto L_0x0022;
                case 2131299561: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0150
        L_0x0016:
            com.xeagle.android.login.RegisterActivity r7 = r6.parent
            r7.finish()
            java.lang.Class<com.xeagle.android.login.LoginActivity> r7 = com.xeagle.android.login.LoginActivity.class
            r6.startIntent(r7)
            goto L_0x0150
        L_0x0022:
            android.widget.EditText r7 = r6.et_phone_pw
            int r7 = r7.getInputType()
            if (r7 != r5) goto L_0x0035
            android.widget.EditText r7 = r6.et_phone_pw
            r7.setInputType(r3)
            android.widget.ImageButton r7 = r6.ib_pwd_show
            r7.setImageResource(r2)
            goto L_0x003f
        L_0x0035:
            android.widget.EditText r7 = r6.et_phone_pw
            r7.setInputType(r5)
            android.widget.ImageButton r7 = r6.ib_pwd_show
            r7.setImageResource(r4)
        L_0x003f:
            android.widget.EditText r7 = r6.et_phone_pw
            goto L_0x0061
        L_0x0042:
            android.widget.EditText r7 = r6.et_confirm_pwd
            int r7 = r7.getInputType()
            if (r7 != r5) goto L_0x0055
            android.widget.EditText r7 = r6.et_confirm_pwd
            r7.setInputType(r3)
            android.widget.ImageButton r7 = r6.ib_confirm_pwd_show
            r7.setImageResource(r2)
            goto L_0x005f
        L_0x0055:
            android.widget.EditText r7 = r6.et_confirm_pwd
            r7.setInputType(r5)
            android.widget.ImageButton r7 = r6.ib_confirm_pwd_show
            r7.setImageResource(r4)
        L_0x005f:
            android.widget.EditText r7 = r6.et_confirm_pwd
        L_0x0061:
            android.text.Editable r0 = r7.getText()
            int r0 = r0.length()
            r7.setSelection(r0)
            goto L_0x0150
        L_0x006e:
            android.widget.EditText r7 = r6.et_phone_pw
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.pwd = r7
            android.widget.EditText r7 = r6.et_phone
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.phoneNum = r7
            android.widget.EditText r7 = r6.et_msg_code
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.msgCode = r7
            android.widget.EditText r7 = r6.et_confirm_pwd
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.confirm_pwd = r7
            java.lang.String r7 = r6.pwd
            int r7 = r7.length()
            r2 = 1
            r3 = 2131821160(0x7f110268, float:1.9275055E38)
            r4 = 8
            if (r7 < r4) goto L_0x00ff
            java.lang.String r7 = r6.pwd
            int r7 = r7.length()
            r5 = 20
            if (r7 <= r5) goto L_0x00b7
            goto L_0x00ff
        L_0x00b7:
            java.lang.String r7 = r6.confirm_pwd
            int r7 = r7.length()
            if (r7 < r4) goto L_0x00ff
            java.lang.String r7 = r6.confirm_pwd
            int r7 = r7.length()
            if (r7 <= r5) goto L_0x00c8
            goto L_0x00ff
        L_0x00c8:
            java.lang.String r7 = r6.confirm_pwd
            java.lang.String r2 = r6.pwd
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 != 0) goto L_0x00d8
            com.xeagle.android.login.RegisterActivity r7 = r6.parent
            r0 = 2131822019(0x7f1105c3, float:1.9276798E38)
            goto L_0x0120
        L_0x00d8:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r1 = r6.phoneNum
            java.lang.String r2 = "phone"
            r7.put(r2, r1)
            java.lang.String r1 = r6.pwd
            java.lang.String r2 = "password"
            r7.put(r2, r1)
            java.lang.String r1 = r6.confirm_pwd
            java.lang.String r2 = "confrim_password"
            r7.put(r2, r1)
            java.lang.String r1 = r6.msgCode
            java.lang.String r2 = "captcha"
            r7.put(r2, r1)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r6.loadPresenter
            r1.regCart(r0, r7)
            goto L_0x0150
        L_0x00ff:
            com.xeagle.android.login.RegisterActivity r7 = r6.parent
            java.lang.String r0 = r7.getString(r3)
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r7, r0, r2)
            goto L_0x0150
        L_0x0109:
            int r7 = r6.time
            r2 = 120(0x78, float:1.68E-43)
            if (r7 != 0) goto L_0x0119
            com.xeagle.android.vjoystick.utils.e r7 = r6.handler
            java.lang.Runnable r1 = r6.timeOut
            r7.b(r1)
            r6.time = r2
            goto L_0x0128
        L_0x0119:
            if (r7 >= r2) goto L_0x0128
            com.xeagle.android.login.RegisterActivity r7 = r6.parent
            r0 = 2131820899(0x7f110163, float:1.9274526E38)
        L_0x0120:
            java.lang.String r0 = r7.getString(r0)
            com.xeagle.android.login.common.ToastHelper.showToastInnerWithTopCenter(r7, r0, r1)
            goto L_0x0150
        L_0x0128:
            int r7 = r6.time
            if (r7 != r2) goto L_0x0150
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            android.widget.EditText r1 = r6.et_phone
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r6.phoneNum = r1
            java.lang.String r1 = "type"
            java.lang.String r2 = "register"
            r7.put(r1, r2)
            java.lang.String r1 = r6.phoneNum
            java.lang.String r2 = "account"
            r7.put(r2, r1)
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r6.loadPresenter
            r1.regCode(r0, r7)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.PhoneRegisterFragment.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.phone_register_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        this.loadPresenter = new RegPresenter(this);
    }

    public void regError(int i2, String str) {
        String str2;
        RegisterActivity registerActivity;
        Log.i("Register", "regError: ----" + str);
        int i3 = 0;
        if (str.equals("手机号码格式不对")) {
            registerActivity = this.parent;
            str2 = getString(R.string.phone_num_error);
        } else {
            registerActivity = this.parent;
            i3 = 1;
            str2 = String.format(Locale.US, "%s:%s", new Object[]{getString(R.string.request_error), str});
        }
        ToastHelper.showToastInnerWithTopCenter(registerActivity, str2, i3);
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
        RegAcceptBeans regAcceptBeans = (RegAcceptBeans) obj;
        Log.i("Register", "regSuccess: ------" + regAcceptBeans.toString());
        if (i2 == 0) {
            if (regAcceptBeans.isStatus()) {
                updateTimeOut();
            } else {
                ToastHelper.showToastInnerWithTopCenter(getActivity(), regAcceptBeans.getMessage(), 0);
            }
        } else if (i2 == 1) {
            int code = regAcceptBeans.getCode();
            if (code != 200) {
                switch (code) {
                    case GLMapStaticValue.AM_PARAMETERNAME_HALF_LEVEL_ZOOM:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4001;
                        break;
                    case 4002:
                        registerActivity = this.parent;
                        i3 = R.string.code_info_4002;
                        break;
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
