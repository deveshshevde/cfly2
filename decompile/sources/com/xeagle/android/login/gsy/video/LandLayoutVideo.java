package com.xeagle.android.login.gsy.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

public class LandLayoutVideo extends StandardGSYVideoPlayer {
    private boolean isLinkScroll = false;

    public LandLayoutVideo(Context context) {
        super(context);
    }

    public LandLayoutVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LandLayoutVideo(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void changeUiToCompleteClear() {
        super.changeUiToCompleteClear();
        setTextAndProgress(0, true);
    }

    /* access modifiers changed from: protected */
    public void changeUiToCompleteShow() {
        super.changeUiToCompleteShow();
        setTextAndProgress(0, true);
    }

    public int getEnlargeImageRes() {
        return R.drawable.custom_enlarge;
    }

    public int getLayoutId() {
        return this.mIfCurrentIsFullscreen ? R.layout.sample_video_land : R.layout.sample_video_normal;
    }

    public int getShrinkImageRes() {
        return R.drawable.custom_shrink;
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        post(new Runnable() {
            public void run() {
                GestureDetector unused = LandLayoutVideo.this.gestureDetector = new GestureDetector(LandLayoutVideo.this.getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                    public boolean onDoubleTap(MotionEvent motionEvent) {
                        LandLayoutVideo.this.touchDoubleUp();
                        return super.onDoubleTap(motionEvent);
                    }

                    public void onLongPress(MotionEvent motionEvent) {
                        super.onLongPress(motionEvent);
                    }

                    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                        if (!LandLayoutVideo.this.mChangePosition && !LandLayoutVideo.this.mChangeVolume && !LandLayoutVideo.this.mBrightness) {
                            LandLayoutVideo.this.onClickUiToggle();
                        }
                        return super.onSingleTapConfirmed(motionEvent);
                    }
                });
            }
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isLinkScroll && !isIfCurrentIsFullscreen()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer) {
        LandLayoutVideo landLayoutVideo = (LandLayoutVideo) gSYVideoPlayer;
        landLayoutVideo.dismissProgressDialog();
        landLayoutVideo.dismissVolumeDialog();
        landLayoutVideo.dismissBrightnessDialog();
        super.resolveNormalVideoShow(view, viewGroup, gSYVideoPlayer);
    }

    public void setLinkScroll(boolean z2) {
        this.isLinkScroll = z2;
    }

    /* access modifiers changed from: protected */
    public void updateStartImage() {
        if (!this.mIfCurrentIsFullscreen) {
            super.updateStartImage();
        } else if (this.mStartButton instanceof ImageView) {
            ImageView imageView = (ImageView) this.mStartButton;
            if (this.mCurrentState == 2) {
                imageView.setImageResource(R.drawable.video_click_pause_selector);
                return;
            }
            int i2 = this.mCurrentState;
            imageView.setImageResource(R.drawable.video_click_play_selector);
        }
    }
}
