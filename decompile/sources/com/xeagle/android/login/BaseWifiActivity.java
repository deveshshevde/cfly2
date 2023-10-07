package com.xeagle.android.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.util.e;
import com.xeagle.android.dialogs.d;

public class BaseWifiActivity extends AppCompatActivity {
    private d checkWifiDlg;
    private e function;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e eVar = new e(getApplicationContext());
        this.function = eVar;
        if (eVar.i().contains("Ground") || !this.function.a(getApplicationContext())) {
            if (this.checkWifiDlg == null) {
                this.checkWifiDlg = d.a(getString(R.string.warning), getString(R.string.upload_no_wifi), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        BaseWifiActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    }
                });
            }
            if (!this.checkWifiDlg.isAdded()) {
                this.checkWifiDlg.show(getSupportFragmentManager(), "noWifi");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
