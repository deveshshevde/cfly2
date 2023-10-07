package com.xeagle.android.newUI.fragment.remindFragment;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.xeagle.android.newUI.activity.BaseActivity;

public abstract class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected BaseActivity f24034a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f24034a = (BaseActivity) activity;
    }
}
