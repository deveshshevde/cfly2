package com.xeagle.android.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import com.cfly.uav_pro.R;
import com.xeagle.android.fragments.r;

public class SettingsActivity extends DrawerNavigationUI {
    /* access modifiers changed from: protected */
    public int a() {
        return R.id.navigation_settings;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentById(R.id.fragment_settings_layout) == null) {
            fragmentManager.beginTransaction().add(R.id.fragment_settings_layout, new r()).commit();
        }
    }
}
