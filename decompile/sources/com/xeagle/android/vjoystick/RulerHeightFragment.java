package com.xeagle.android.vjoystick;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.vjoystick.IWidgets.phasedSeekbar.PhasedSeekBar;
import com.xeagle.android.vjoystick.IWidgets.phasedSeekbar.d;

public class RulerHeightFragment extends b {
    @BindView(2131296429)
    PhasedSeekBar psbLike;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.waypoint_plan_activity, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        Resources resources = getResources();
        this.psbLike.setAdapter(new d(resources, new int[]{R.drawable.ruler_thumb}));
        this.psbLike.setInteractionListener(new com.xeagle.android.vjoystick.IWidgets.phasedSeekbar.b() {
            public void a(int i2, int i3, int i4) {
                Log.i("PSB", String.format("onInteracted %d %d %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(RulerHeightFragment.this.psbLike.getCurrentY()), Integer.valueOf((int) ((((float) (RulerHeightFragment.this.psbLike.getHeight() - i3)) / ((float) RulerHeightFragment.this.psbLike.getHeight())) * 80.0f)), Integer.valueOf(RulerHeightFragment.this.psbLike.getTop())}));
            }
        });
        return inflate;
    }
}
