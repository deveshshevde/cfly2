package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.multiscreen.R;

public class PopupActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.sink_popup);
    }
}
