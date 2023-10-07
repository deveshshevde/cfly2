package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.shuyu.gsyvideoplayer.R;

public class NormalGSYVideoPlayer extends StandardGSYVideoPlayer {
    public NormalGSYVideoPlayer(Context context) {
        super(context);
    }

    public NormalGSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NormalGSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    public int getLayoutId() {
        return R.layout.video_layout_normal;
    }

    /* access modifiers changed from: protected */
    public void updateStartImage() {
        int i2;
        if (this.mStartButton instanceof ImageView) {
            ImageView imageView = (ImageView) this.mStartButton;
            if (this.mCurrentState == 2) {
                i2 = R.drawable.video_click_pause_selector;
            } else {
                int i3 = this.mCurrentState;
                i2 = R.drawable.video_click_play_selector;
            }
            imageView.setImageResource(i2);
        }
    }
}
