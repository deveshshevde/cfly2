package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.AppUtils;
import com.cfly.uav_pro.R;

public class MoreActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23887a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f23888b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f23889c;

    private void a() {
        this.f23887a = (TextView) findViewById(R.id.tv_back);
        this.f23888b = (RelativeLayout) findViewById(R.id.rl_contact);
        TextView textView = (TextView) findViewById(R.id.tv_version);
        this.f23889c = textView;
        textView.setText(AppUtils.getAppVersionName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    private void b() {
        this.f23887a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MoreActivity.this.a(view);
            }
        });
        this.f23888b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MoreActivity.this.startActivity(new Intent(MoreActivity.this, ContactActivity.class));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.newui_activity_more);
        a();
        b();
    }
}
