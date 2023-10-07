package com.xeagle.android.newUI.activity;

import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;

public class TipsImagePreviewActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private PhotoView f23922a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tips_preview_layout);
        this.f23922a = (PhotoView) findViewById(R.id.image_preview);
        int intExtra = getIntent().getIntExtra("image_id", 0);
        if (intExtra != 0) {
            this.f23922a.setImageResource(intExtra);
        }
        findViewById(R.id.ib_go_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TipsImagePreviewActivity.this.finish();
            }
        });
    }
}
