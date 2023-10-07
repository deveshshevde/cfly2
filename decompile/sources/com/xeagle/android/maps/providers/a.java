package com.xeagle.android.maps.providers;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceFragment;

public abstract class a extends PreferenceFragment {
    public abstract DPMapProvider a();

    public Context getContext() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return activity.getApplicationContext();
    }
}
