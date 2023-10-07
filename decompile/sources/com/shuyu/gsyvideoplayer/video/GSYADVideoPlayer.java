package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.a;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;

public class GSYADVideoPlayer extends StandardGSYVideoPlayer {
    protected boolean isFirstPrepared;
    protected TextView mADTime;
    protected View mJumpAd;

    public GSYADVideoPlayer(Context context) {
        super(context);
    }

    public GSYADVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYADVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public boolean backFromFull(Context context) {
        return a.a(context);
    }

    /* access modifiers changed from: protected */
    public void changeAdUIState() {
        View view = this.mJumpAd;
        int i2 = 8;
        int i3 = 0;
        if (view != null) {
            view.setVisibility(this.isFirstPrepared ? 0 : 8);
        }
        TextView textView = this.mADTime;
        if (textView != null) {
            if (this.isFirstPrepared) {
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
        if (this.mBottomContainer != null) {
            this.mBottomContainer.setBackgroundColor(this.isFirstPrepared ? 0 : getContext().getResources().getColor(R.color.bottom_container_bg));
        }
        if (this.mCurrentTimeTextView != null) {
            this.mCurrentTimeTextView.setVisibility(this.isFirstPrepared ? 4 : 0);
        }
        if (this.mTotalTimeTextView != null) {
            this.mTotalTimeTextView.setVisibility(this.isFirstPrepared ? 4 : 0);
        }
        if (this.mProgressBar != null) {
            SeekBar seekBar = this.mProgressBar;
            if (this.isFirstPrepared) {
                i3 = 4;
            }
            seekBar.setVisibility(i3);
            this.mProgressBar.setEnabled(!this.isFirstPrepared);
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        GSYADVideoPlayer gSYADVideoPlayer = (GSYADVideoPlayer) gSYBaseVideoPlayer2;
        gSYADVideoPlayer.isFirstPrepared = ((GSYADVideoPlayer) gSYBaseVideoPlayer).isFirstPrepared;
        gSYADVideoPlayer.changeAdUIState();
    }

    /* access modifiers changed from: protected */
    public int getFullId() {
        return a.f21616b;
    }

    public GSYVideoViewBridge getGSYVideoManager() {
        a.a().b(getContext().getApplicationContext());
        return a.a();
    }

    public int getLayoutId() {
        return R.layout.video_layout_ad;
    }

    /* access modifiers changed from: protected */
    public int getSmallId() {
        return a.f21615a;
    }

    /* access modifiers changed from: protected */
    public void hideAllWidget() {
        if (!this.isFirstPrepared) {
            super.hideAllWidget();
        }
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        this.mJumpAd = findViewById(R.id.jump_ad);
        this.mADTime = (TextView) findViewById(R.id.ad_time);
        View view = this.mJumpAd;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (GSYADVideoPlayer.this.getGSYVideoManager().listener() != null) {
                        GSYADVideoPlayer.this.getGSYVideoManager().listener().onAutoCompletion();
                    }
                }
            });
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.start) {
            super.onClick(view);
        } else if (this.mCurrentState == 7) {
            clickStartIcon();
        }
    }

    public void onPrepared() {
        super.onPrepared();
        this.isFirstPrepared = true;
        changeAdUIState();
    }

    public void release() {
        super.release();
        TextView textView = this.mADTime;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void releaseVideos() {
        a.b();
    }

    public void removeFullWindowViewOnly() {
        ViewGroup viewGroup = (ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290);
        View findViewById = viewGroup.findViewById(getFullId());
        if (!(findViewById == null || findViewById.getParent() == null)) {
            viewGroup.removeView((ViewGroup) findViewById.getParent());
        }
        this.mIfCurrentIsFullscreen = false;
    }

    /* access modifiers changed from: protected */
    public void setProgressAndTime(int i2, int i3, int i4, int i5, boolean z2) {
        super.setProgressAndTime(i2, i3, i4, i5, z2);
        TextView textView = this.mADTime;
        if (textView != null && i4 > 0) {
            textView.setText("" + ((i5 / 1000) - (i4 / 1000)));
        }
    }

    /* access modifiers changed from: protected */
    public void touchDoubleUp() {
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMove(float f2, float f3, float f4) {
        if (!this.mChangePosition) {
            super.touchSurfaceMove(f2, f3, f4);
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMoveFullLogic(float f2, float f3) {
        if (f2 > ((float) this.mThreshold) || f3 > ((float) this.mThreshold)) {
            int screenWidth = CommonUtil.getScreenWidth(getContext());
            if (f2 < ((float) this.mThreshold) || Math.abs(((float) screenWidth) - this.mDownX) <= ((float) this.mSeekEndOffset)) {
                super.touchSurfaceMoveFullLogic(f2, f3);
                return;
            }
            this.mChangePosition = true;
            this.mDownPosition = getCurrentPositionWhenPlaying();
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceUp() {
        if (!this.mChangePosition) {
            super.touchSurfaceUp();
        }
    }

    /* access modifiers changed from: protected */
    public void updateStartImage() {
        if (this.mStartButton != null && (this.mStartButton instanceof ImageView)) {
            ((ImageView) this.mStartButton).setImageResource((this.mCurrentState != 2 && this.mCurrentState == 7) ? R.drawable.video_click_error_selector : R.drawable.empty_drawable);
        }
    }
}
