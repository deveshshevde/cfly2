package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import java.util.HashMap;
import ka.a;

public class InsuranceServiceActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f23880a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f23881b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f23882c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f23883d;

    private void a() {
        this.f23880a = (EditText) findViewById(R.id.et_guide_insurance);
        this.f23881b = (TextView) findViewById(R.id.tv_more_insurance);
        String string = getString(R.string.guide_insurance_3);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
            }
        }, 0, string.length(), 17);
        this.f23881b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f23881b.setText(spannableString);
        findViewById(R.id.bt_skip).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InsuranceServiceActivity.this.b(view);
            }
        });
        findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InsuranceServiceActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f23880a.getText().toString().length() == 0) {
            ToastUtils.showLong((int) R.string.guide_insurance_null);
        } else {
            a.a().b().execute(new Runnable() {
                public void run() {
                    UserInfo userInfo = UserLiteHelper.getUserInfo(InsuranceServiceActivity.this.prefs.aE());
                    if (userInfo != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("token", userInfo.getToken());
                        hashMap.put("drone_sn", InsuranceServiceActivity.this.f23882c);
                        Log.i("ServeTest", "run:===== " + InsuranceServiceActivity.this.f23883d);
                        hashMap.put("drone_model", InsuranceServiceActivity.this.f23883d);
                        hashMap.put("sk", InsuranceServiceActivity.this.f23880a.getText().toString());
                        InsuranceServiceActivity.this.regPresenter.boundInsuranceWithUser(UserGlobal.BASE_URL, hashMap);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c a2 = r.a().a(getString(R.string.warning), getString(R.string.insurance_warn), (c.a) new c.a() {
            public void onYes() {
                InsuranceServiceActivity.this.finish();
            }
        });
        if (!a2.isAdded()) {
            a2.show(getSupportFragmentManager(), "insuranceWarn");
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, DeviceManageActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_insurace_service);
        this.f23882c = getIntent().getStringExtra("drone_sn");
        this.f23883d = getIntent().getStringExtra("drone_model");
        a();
    }

    public void regSuccess(int i2, Object obj) {
        super.regSuccess(i2, obj);
        if (i2 == 24 && ((UploadAcceptBeans) obj).isStatus()) {
            onBackPressed();
        }
    }
}
