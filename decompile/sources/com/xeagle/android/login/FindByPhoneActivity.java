package com.xeagle.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.beans.RegAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.utils.e;
import java.util.HashMap;
import java.util.Locale;
import kw.c;

public class FindByPhoneActivity extends AppCompatActivity implements View.OnClickListener, RegContract.lLoadView {
    private IButton bt_get_code;
    private EditText et_msg_code;
    private EditText et_phone;
    private EditText et_pwd;
    private e handler = new e();
    private ImageButton ib_pw_show;
    private RegPresenter loadPresenter;
    private String msgCode;
    private String phoneNum;
    private String pwd;
    private int time = 120;
    Runnable timeOut = new Runnable() {
        public void run() {
            FindByPhoneActivity.this.updateTimeOut();
        }
    };

    private void initView() {
        this.et_phone = (EditText) findViewById(R.id.et_account);
        this.et_msg_code = (EditText) findViewById(R.id.et_message_code);
        this.bt_get_code = (IButton) findViewById(R.id.bt_get_code);
        this.et_pwd = (EditText) findViewById(R.id.et_pw);
        this.ib_pw_show = (ImageButton) findViewById(R.id.ib_pwd_show);
        this.bt_get_code.setOnClickListener(this);
        ((IButton) findViewById(R.id.bt_login_post)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_toLogin)).setOnClickListener(this);
        ((IImageButton) findViewById(R.id.iv_go_back)).setOnClickListener(this);
        this.ib_pw_show.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void updateTimeOut() {
        if (this.time == 0) {
            this.handler.b(this.timeOut);
            this.bt_get_code.setText(getString(R.string.code_reacquire));
            return;
        }
        IButton iButton = this.bt_get_code;
        Locale locale = Locale.US;
        String string = getString(R.string.code_obsolete);
        int i2 = this.time;
        this.time = i2 - 1;
        iButton.setText(String.format(locale, string, new Object[]{Integer.valueOf(i2)}));
        this.handler.a(this.timeOut, 1000);
    }

    public void onClick(View view) {
        ImageButton imageButton;
        int i2;
        switch (view.getId()) {
            case R.id.bt_get_code:
                int i3 = this.time;
                if (i3 == 0) {
                    this.handler.b(this.timeOut);
                    this.time = 120;
                    return;
                } else if (i3 < 120) {
                    ToastUtils.showShort((int) R.string.code_has_sent);
                    return;
                } else if (i3 == 120) {
                    HashMap hashMap = new HashMap();
                    String obj = this.et_phone.getText().toString();
                    this.phoneNum = obj;
                    if (!c.a(obj)) {
                        ToastUtils.showLong((int) R.string.phone_num_error);
                        return;
                    }
                    hashMap.put("type", "retrieve_pwd");
                    hashMap.put("account", this.phoneNum);
                    this.loadPresenter.regCode(UserGlobal.BASE_URL, hashMap);
                    return;
                } else {
                    return;
                }
            case R.id.bt_login_post:
                this.pwd = this.et_pwd.getText().toString();
                this.phoneNum = this.et_phone.getText().toString();
                this.msgCode = this.et_msg_code.getText().toString();
                if (this.pwd.length() < 8 || this.pwd.length() > 20) {
                    ToastUtils.showShort((CharSequence) getString(R.string.enter_characters_warn));
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("phone", this.phoneNum);
                hashMap2.put("password", this.pwd);
                hashMap2.put("captcha", this.msgCode);
                this.loadPresenter.regChangePwd(UserGlobal.BASE_URL, hashMap2);
                return;
            case R.id.ib_pwd_show:
                if (this.et_pwd.getInputType() == 128) {
                    this.et_pwd.setInputType(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN);
                    imageButton = this.ib_pw_show;
                    i2 = R.drawable.et_gone;
                } else {
                    this.et_pwd.setInputType(128);
                    imageButton = this.ib_pw_show;
                    i2 = R.drawable.et_visible;
                }
                imageButton.setImageResource(i2);
                EditText editText = this.et_pwd;
                editText.setSelection(editText.getText().length());
                return;
            case R.id.iv_go_back:
                finish();
                return;
            case R.id.tv_toLogin:
                startActivity(new Intent(this, LoginActivity.class));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.find_phone_layout);
        initView();
        this.loadPresenter = new RegPresenter(this);
    }

    public void regError(int i2, String str) {
        Log.i("Register", "regError:--- " + str + "--code--" + i2);
    }

    public void regFailure(int i2) {
        if (i2 == 0) {
            ToastUtils.showShort((CharSequence) getString(R.string.verification_failed));
        }
    }

    public void regSuccess(int i2, Object obj) {
        int i3;
        RegAcceptBeans regAcceptBeans = (RegAcceptBeans) obj;
        Log.i("Register", "regSuccess: ------" + regAcceptBeans.toString());
        if (i2 == 0) {
            if (regAcceptBeans.isStatus()) {
                updateTimeOut();
            } else {
                ToastUtils.showShort((CharSequence) getString(R.string.code_get_failed));
            }
        } else if (i2 == 12) {
            int code = regAcceptBeans.getCode();
            if (code != 200) {
                switch (code) {
                    case GLMapStaticValue.AM_PARAMETERNAME_HALF_LEVEL_ZOOM:
                        i3 = R.string.code_info_4001;
                        break;
                    case 4002:
                        i3 = R.string.code_info_4002;
                        break;
                    case 4003:
                        i3 = R.string.code_info_4003;
                        break;
                    case 4004:
                        i3 = R.string.code_info_4004;
                        break;
                    case 4005:
                        i3 = R.string.code_info_4005;
                        break;
                    case 4006:
                        i3 = R.string.code_info_4006;
                        break;
                    case 4007:
                        i3 = R.string.code_info_4007;
                        break;
                    case 4008:
                        i3 = R.string.code_info_4008;
                        break;
                    case 4009:
                        i3 = R.string.code_info_4009;
                        break;
                }
            } else {
                i3 = R.string.code_info_200;
            }
            ToastUtils.showLong((CharSequence) getString(i3));
            if (regAcceptBeans.isStatus()) {
                ToastUtils.showLong((int) R.string.modify_success);
                startActivity(new Intent(this, LoginActivity.class));
            }
        }
    }
}
