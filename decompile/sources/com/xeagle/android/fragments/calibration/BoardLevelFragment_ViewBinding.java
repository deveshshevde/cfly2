package com.xeagle.android.fragments.calibration;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;

public class BoardLevelFragment_ViewBinding implements Unbinder {
    private BoardLevelFragment target;
    private View view7f0901c9;

    public BoardLevelFragment_ViewBinding(final BoardLevelFragment boardLevelFragment, View view) {
        this.target = boardLevelFragment;
        boardLevelFragment.textViewDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewDesc, "field 'textViewDesc'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.buttonStep, "field 'buttonStep' and method 'onClick'");
        boardLevelFragment.buttonStep = (Button) Utils.castView(findRequiredView, R.id.buttonStep, "field 'buttonStep'", Button.class);
        this.view7f0901c9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                boardLevelFragment.onClick();
            }
        });
    }

    public void unbind() {
        BoardLevelFragment boardLevelFragment = this.target;
        if (boardLevelFragment != null) {
            this.target = null;
            boardLevelFragment.textViewDesc = null;
            boardLevelFragment.buttonStep = null;
            this.view7f0901c9.setOnClickListener((View.OnClickListener) null);
            this.view7f0901c9 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
