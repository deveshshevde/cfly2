package com.xeagle.android.newUI.fragment.remindFragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
import com.xeagle.android.newUI.activity.BaseActivity;
import java.util.HashMap;

public class InsuranceActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private EditText f24027a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24028b;

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c a2 = r.a().a(getString(R.string.warning), getString(R.string.insurance_warn), (c.a) new c.a() {
            public void onYes() {
                InsuranceActivity.this.finish();
            }
        });
        if (!a2.isAdded()) {
            a2.show(getSupportFragmentManager(), "insuranceWarn");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        if (this.f24027a.getText().toString().length() == 0) {
            ToastUtils.showLong((int) R.string.guide_insurance_null);
            return;
        }
        UserInfo userInfo = UserLiteHelper.getUserInfo(this.prefs.aE());
        if (userInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("token", userInfo.getToken());
            hashMap.put("drone_sn", str);
            hashMap.put("sk", this.f24027a.getText().toString());
            hashMap.put("drone_model", "DF" + this.prefs.j());
            this.regPresenter.boundInsuranceWithUser(UserGlobal.BASE_URL, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.fragment_insurance_guide);
        this.f24027a = (EditText) findViewById(R.id.et_guide_insurance);
        this.f24028b = (TextView) findViewById(R.id.tv_more_insurance);
        String stringExtra = getIntent().getStringExtra("droneSn");
        String string = getString(R.string.guide_insurance_3);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
            }
        }, 0, string.length(), 17);
        this.f24028b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f24028b.setText(spannableString);
        findViewById(R.id.bt_skip).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InsuranceActivity.this.a(view);
            }
        });
        findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener(stringExtra) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                InsuranceActivity.this.a(this.f$1, view);
            }
        });
    }

    public void regSuccess(int i2, Object obj) {
        super.regSuccess(i2, obj);
        if (i2 == 24 && ((UploadAcceptBeans) obj).isStatus()) {
            finish();
        }
    }
}
