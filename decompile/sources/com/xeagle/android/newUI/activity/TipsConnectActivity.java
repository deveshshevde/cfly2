package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;

public class TipsConnectActivity extends BaseActivity {
    private void a(int i2) {
        Intent intent = new Intent(this, TipsImagePreviewActivity.class);
        intent.putExtra("image_id", i2);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a((int) R.drawable.tips_vivo_data);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a((int) R.drawable.tips_xiaomi_data);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a((int) R.drawable.tips_huawei_data);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        a((int) R.drawable.tips_vivo_wlan);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        a((int) R.drawable.tips_xiaomi_wlan);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        a((int) R.drawable.tips_huawei_wlan);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        a((int) R.drawable.tips_vivo_forget);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        a((int) R.drawable.tips_xiaomi_forget);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        a((int) R.drawable.tips_huawei_forget);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tips_connect_activity);
        findViewById(R.id.ib_go_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.j(view);
            }
        });
        findViewById(R.id.iv_method_1).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.i(view);
            }
        });
        findViewById(R.id.iv_method_2).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.h(view);
            }
        });
        findViewById(R.id.iv_method_3).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.g(view);
            }
        });
        findViewById(R.id.iv_method_4).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.f(view);
            }
        });
        findViewById(R.id.iv_method_5).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.e(view);
            }
        });
        findViewById(R.id.iv_method_6).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.d(view);
            }
        });
        findViewById(R.id.iv_method_7).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.c(view);
            }
        });
        findViewById(R.id.iv_method_8).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.b(view);
            }
        });
        findViewById(R.id.iv_method_9).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TipsConnectActivity.this.a(view);
            }
        });
    }
}
