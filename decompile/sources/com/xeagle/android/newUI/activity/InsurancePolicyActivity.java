package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.StoreWebviewActivity;

public class InsurancePolicyActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23878a;

    private void a() {
        this.f23878a = (TextView) findViewById(R.id.tv_more_assure);
        String string = getString(R.string.tv_more_assure);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(InsurancePolicyActivity.this, StoreWebviewActivity.class);
                intent.putExtra("target_url", "http://www.cfly-cn.com");
                InsurancePolicyActivity.this.startActivity(intent);
            }
        }, 0, string.length(), 17);
        this.f23878a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f23878a.setText(spannableString);
        findViewById(R.id.bt_ok).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InsurancePolicyActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_insurance_policy);
        a();
    }
}
