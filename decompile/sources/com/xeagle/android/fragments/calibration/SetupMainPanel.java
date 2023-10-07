package com.xeagle.android.fragments.calibration;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.xeagle.android.activities.ConfigurationActivity;

public abstract class SetupMainPanel extends Fragment {
    protected ConfigurationActivity parentActivity;
    protected SetupSidePanel sidePanel;

    public abstract void doCalibrationStep(int i2);

    public abstract int getPanelLayout();

    public abstract SetupSidePanel getSidePanel();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ConfigurationActivity) {
            this.parentActivity = (ConfigurationActivity) activity;
            return;
        }
        throw new IllegalStateException("Parent activity must be " + ConfigurationActivity.class.getName());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getPanelLayout(), viewGroup, false);
        setupLocalViews(inflate);
        return inflate;
    }

    public void setSidePanel(SetupSidePanel setupSidePanel) {
        this.sidePanel = setupSidePanel;
    }

    public abstract void setupLocalViews(View view);
}
