package com.xeagle.android.login;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.gsy.video.LandLayoutVideo;

public class InputUrlDetailActivity_ViewBinding implements Unbinder {
    private InputUrlDetailActivity target;

    public InputUrlDetailActivity_ViewBinding(InputUrlDetailActivity inputUrlDetailActivity) {
        this(inputUrlDetailActivity, inputUrlDetailActivity.getWindow().getDecorView());
    }

    public InputUrlDetailActivity_ViewBinding(InputUrlDetailActivity inputUrlDetailActivity, View view) {
        this.target = inputUrlDetailActivity;
        inputUrlDetailActivity.postDetailNestedScroll = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.post_detail_nested_scroll, "field 'postDetailNestedScroll'", NestedScrollView.class);
        inputUrlDetailActivity.detailPlayer = (LandLayoutVideo) Utils.findRequiredViewAsType(view, R.id.detail_player, "field 'detailPlayer'", LandLayoutVideo.class);
        inputUrlDetailActivity.activityDetailPlayer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.activity_detail_player, "field 'activityDetailPlayer'", RelativeLayout.class);
        inputUrlDetailActivity.inputUrl = (Button) Utils.findRequiredViewAsType(view, R.id.inputUrl, "field 'inputUrl'", Button.class);
    }

    public void unbind() {
        InputUrlDetailActivity inputUrlDetailActivity = this.target;
        if (inputUrlDetailActivity != null) {
            this.target = null;
            inputUrlDetailActivity.postDetailNestedScroll = null;
            inputUrlDetailActivity.detailPlayer = null;
            inputUrlDetailActivity.activityDetailPlayer = null;
            inputUrlDetailActivity.inputUrl = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
