package com.xeagle.android.vjoystick;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.phasedSeekbar.PhasedSeekBar;

public class RulerHeightFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RulerHeightFragment f24869a;

    public RulerHeightFragment_ViewBinding(RulerHeightFragment rulerHeightFragment, View view) {
        this.f24869a = rulerHeightFragment;
        rulerHeightFragment.psbLike = (PhasedSeekBar) Utils.findRequiredViewAsType(view, R.id.altitude_seek, "field 'psbLike'", PhasedSeekBar.class);
    }

    public void unbind() {
        RulerHeightFragment rulerHeightFragment = this.f24869a;
        if (rulerHeightFragment != null) {
            this.f24869a = null;
            rulerHeightFragment.psbLike = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
