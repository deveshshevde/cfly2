package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import com.huawei.android.multiscreen.R;

public class SinkActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.d("MIRROR_SDK", "SinkActivity onCreate()");
        super.onCreate(bundle);
        setContentView(R.layout.sink_main);
        Intent intent = new Intent();
        intent.setClass(this, SinkService.class);
        startService(intent);
        Toast.makeText(this, "Sink has been started", 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.d("MIRROR_SDK", "SinkActivity onDestroy()");
        super.onDestroy();
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        GrabDemoActivityTask.destroyInstence();
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d("MIRROR_SDK", "SinkActivity onPause()");
        super.onPause();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d("MIRROR_SDK", "SinkActivity onResume()");
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Log.d("MIRROR_SDK", "SinkActivity onStop()");
        super.onStop();
    }
}
