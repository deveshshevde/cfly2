package com.xeagle.android.newUI.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.model.LatLng;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.maps.providers.b;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.f;
import ef.a;
import fg.i;

public class SelectMapActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public /* synthetic */ void a(double d2, double d3, View view) {
        a(1, d2, d3);
    }

    private void a(int i2, double d2, double d3) {
        String str;
        int i3;
        int i4 = i2;
        double d4 = d2;
        double d5 = d3;
        Log.i("TAG", "initView:==onParseSuccess:-- " + d4 + "===" + d5);
        if (d4 == i.f27244a || d5 == i.f27244a) {
            str = "location is null";
        } else {
            if (i4 == 1) {
                if (b.d(getApplicationContext())) {
                    b.a(getApplicationContext(), d4, d5);
                    return;
                }
                i3 = R.string.install_google_warn;
            } else if (i4 == 2) {
                if (b.c(getApplicationContext())) {
                    LatLng a2 = f.a(getApplicationContext(), new a(d4, d5));
                    b.b(getApplicationContext(), i.f27244a, i.f27244a, "当前位置", a2.latitude, a2.longitude, "飞机位置");
                    return;
                }
                i3 = R.string.install_tencent_warn;
            } else if (i4 == 3) {
                if (b.b(getApplicationContext())) {
                    b.c(getApplicationContext(), i.f27244a, i.f27244a, "当前位置", d2, d3, "飞机位置");
                    return;
                }
                i3 = R.string.install_baidu_warn;
            } else if (i4 != 4) {
                return;
            } else {
                if (b.a(getApplicationContext())) {
                    LatLng a3 = f.a(getApplicationContext(), new a(d4, d5));
                    b.a(getApplicationContext(), i.f27244a, i.f27244a, "当前位置", a3.latitude, a3.longitude, "飞机位置");
                    return;
                }
                i3 = R.string.install_amap_warn;
            }
            str = getString(i3);
        }
        ToastUtils.showShort((CharSequence) str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(double d2, double d3, View view) {
        a(3, d2, d3);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(double d2, double d3, View view) {
        a(4, d2, d3);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(double d2, double d3, View view) {
        a(2, d2, d3);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.map_direction_layout);
        double doubleExtra = getIntent().getDoubleExtra("lat", i.f27244a);
        double doubleExtra2 = getIntent().getDoubleExtra("lng", i.f27244a);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_map_select);
        TextView textView = (TextView) findViewById(R.id.tv_map_google);
        if (c.b(getApplicationContext())) {
            linearLayout.setVisibility(0);
            textView.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            textView.setVisibility(0);
        }
        double d2 = doubleExtra;
        double d3 = doubleExtra2;
        findViewById(R.id.tv_map_tencent).setOnClickListener(new View.OnClickListener(d2, d3) {
            public final /* synthetic */ double f$1;
            public final /* synthetic */ double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final void onClick(View view) {
                SelectMapActivity.this.d(this.f$1, this.f$2, view);
            }
        });
        findViewById(R.id.tv_map_gaode).setOnClickListener(new View.OnClickListener(d2, d3) {
            public final /* synthetic */ double f$1;
            public final /* synthetic */ double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final void onClick(View view) {
                SelectMapActivity.this.c(this.f$1, this.f$2, view);
            }
        });
        findViewById(R.id.tv_map_baidu).setOnClickListener(new View.OnClickListener(d2, d3) {
            public final /* synthetic */ double f$1;
            public final /* synthetic */ double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final void onClick(View view) {
                SelectMapActivity.this.b(this.f$1, this.f$2, view);
            }
        });
        findViewById(R.id.tv_map_cancel).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectMapActivity.this.a(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener(d2, d3) {
            public final /* synthetic */ double f$1;
            public final /* synthetic */ double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final void onClick(View view) {
                SelectMapActivity.this.a(this.f$1, this.f$2, view);
            }
        });
    }
}
