package com.xeagle.android.fragments;

import android.view.View;
import android.widget.SeekBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.button.SwitchButton;

public class DroneCameraFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DroneCameraFragment f23178a;

    public DroneCameraFragment_ViewBinding(DroneCameraFragment droneCameraFragment, View view) {
        this.f23178a = droneCameraFragment;
        droneCameraFragment.camera_seek = (SeekBar) Utils.findRequiredViewAsType(view, R.id.camera_seek, "field 'camera_seek'", SeekBar.class);
        droneCameraFragment.camera_selfie = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.camera_selfie_on, "field 'camera_selfie'", SwitchButton.class);
        droneCameraFragment.camera_continuous = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.camera_continuous_on, "field 'camera_continuous'", SwitchButton.class);
    }

    public void unbind() {
        DroneCameraFragment droneCameraFragment = this.f23178a;
        if (droneCameraFragment != null) {
            this.f23178a = null;
            droneCameraFragment.camera_seek = null;
            droneCameraFragment.camera_selfie = null;
            droneCameraFragment.camera_continuous = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
