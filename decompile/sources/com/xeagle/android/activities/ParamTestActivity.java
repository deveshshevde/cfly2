package com.xeagle.android.activities;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.activity.BaseActivity;

public class ParamTestActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.param_test_activity);
        findViewById(R.id.ib_go_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamTestActivity.this.a(view);
            }
        });
    }
}
