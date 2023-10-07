package com.xeagle.android.login.pickImage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;

public class GLVideoConfirmActivity extends GLVideoActivity {
    public static void start(Activity activity, Uri uri, long j2) {
        Intent intent = new Intent(activity, GLVideoConfirmActivity.class);
        intent.setData(uri);
        intent.putExtra("duration", j2);
        activity.startActivityForResult(intent, Constants.RESULT_CODE_CONFIRM_VIDEO);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(R.id.btn_back).setVisibility(8);
        findViewById(R.id.retake).setVisibility(0);
        findViewById(R.id.confirm).setVisibility(0);
        findViewById(R.id.retake).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GLVideoConfirmActivity.this.setResult(0);
                GLVideoConfirmActivity.this.finish();
            }
        });
        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GLVideoConfirmActivity.this.setResult(-1);
                GLVideoConfirmActivity.this.finish();
            }
        });
    }
}
