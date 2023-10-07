package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class AccountActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23811a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f23812b;

    private void a() {
        this.f23811a = (TextView) findViewById(R.id.tv_back);
        this.f23812b = (RelativeLayout) findViewById(R.id.rl_change_pwd);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    private void b() {
        this.f23811a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AccountActivity.this.a(view);
            }
        });
        this.f23812b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AccountActivity.this.startActivity(new Intent(AccountActivity.this, ChangePwdActivity.class));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.newui_activity_account);
        a();
        b();
    }
}
