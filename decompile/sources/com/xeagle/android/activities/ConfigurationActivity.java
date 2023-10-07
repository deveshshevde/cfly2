package com.xeagle.android.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.fragments.ParamsFragment;
import com.xeagle.android.fragments.q;

public class ConfigurationActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22094a = (ConfigurationActivity.class.getPackage().getName() + ".EXTRA_CONFIG_SCREEN_ID");

    /* renamed from: b  reason: collision with root package name */
    private static final String f22095b = "ConfigurationActivity";

    /* renamed from: c  reason: collision with root package name */
    private int f22096c = R.id.navigation_params;

    private int a(Fragment fragment) {
        return fragment instanceof q ? R.id.navigation_calibration : R.id.navigation_params;
    }

    private Fragment a() {
        return getSupportFragmentManager().d((int) R.id.configuration_screen);
    }

    private Fragment a(int i2) {
        return new ParamsFragment();
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra(f22094a, this.f22096c);
        Fragment a2 = a();
        if (a2 == null || a(a2) != intExtra) {
            this.f22096c = intExtra;
            getSupportFragmentManager().a().b(R.id.configuration_screen, a(intExtra)).c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_configuration);
        if (bundle != null) {
            this.f22096c = bundle.getInt(f22094a, this.f22096c);
        }
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f22094a, this.f22096c);
    }
}
