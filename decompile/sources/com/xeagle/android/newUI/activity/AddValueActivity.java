package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;

public class AddValueActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        startActivity(new Intent(this, InsurancePolicyActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_value);
        findViewById(R.id.tv_return).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddValueActivity.this.b(view);
            }
        });
        findViewById(R.id.tv_service_view).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddValueActivity.this.a(view);
            }
        });
    }
}
