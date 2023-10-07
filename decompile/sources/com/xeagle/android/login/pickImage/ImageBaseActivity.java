package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.a;
import com.xeagle.android.login.common.UI;

public abstract class ImageBaseActivity extends UI {
    /* access modifiers changed from: protected */
    public void asFullscreen() {
        requestWindowFeature(1);
    }

    public boolean checkPermission(String str) {
        return a.b((Context) this, str) == 0;
    }

    public abstract void clearMemoryCache();

    public abstract void clearRequest();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        clearMemoryCache();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        clearRequest();
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }
}
