package com.xeagle.android.login.gsy.video;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.bumptech.glide.c;
import com.bumptech.glide.request.h;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.xeagle.android.newUI.widgets.RoundProgressBar;

public class SampleCoverVideo extends StandardGSYVideoPlayer {
    protected boolean byStartedClick;
    RoundProgressBar imagePb;
    ImageView mCoverImage;
    int mCoverOriginId = 0;
    String mCoverOriginUrl;
    int mDefaultRes;

    public SampleCoverVideo(Context context) {
        super(context);
    }

    public SampleCoverVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SampleCoverVideo(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void changeUiToNormal() {
        super.changeUiToNormal();
        this.byStartedClick = false;
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingBufferingShow() {
        super.changeUiToPlayingBufferingShow();
        Debuger.printfLog("Sample changeUiToPlayingBufferingShow");
        if (!this.byStartedClick) {
            setViewShowState(this.mBottomContainer, 4);
            setViewShowState(this.mStartButton, 4);
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
        Debuger.printfLog("Sample changeUiToPlayingShow");
        if (!this.byStartedClick) {
            setViewShowState(this.mBottomContainer, 4);
            setViewShowState(this.mStartButton, 4);
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToPreparingShow() {
        super.changeUiToPreparingShow();
        Debuger.printfLog("Sample changeUiToPreparingShow");
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
    }

    public void clearFullscreenLayout() {
        int i2;
        if (this.mFullAnimEnd) {
            this.mIfCurrentIsFullscreen = false;
            if (this.mOrientationUtils != null) {
                i2 = this.mOrientationUtils.backToProtVideo();
                this.mOrientationUtils.setEnable(false);
                if (this.mOrientationUtils != null) {
                    this.mOrientationUtils.releaseListener();
                    this.mOrientationUtils = null;
                }
            } else {
                i2 = 0;
            }
            if (!this.mShowFullAnimation) {
                i2 = 0;
            }
            View findViewById = ((ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290)).findViewById(getFullId());
            if (findViewById != null) {
                ((SampleCoverVideo) findViewById).mIfCurrentIsFullscreen = false;
            }
            if (i2 == 0) {
                backToNormal();
            } else {
                postDelayed(new Runnable() {
                    public void run() {
                        SampleCoverVideo.this.backToNormal();
                    }
                }, (long) i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        ((SampleCoverVideo) gSYBaseVideoPlayer2).mShowFullAnimation = ((SampleCoverVideo) gSYBaseVideoPlayer).mShowFullAnimation;
    }

    public RoundProgressBar getImagePb() {
        return this.imagePb;
    }

    public int getLayoutId() {
        return R.layout.video_layout_cover;
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        this.mCoverImage = (ImageView) findViewById(R.id.thumbImage);
        this.imagePb = (RoundProgressBar) findViewById(R.id.image_pb);
        if (this.mThumbImageViewLayout == null) {
            return;
        }
        if (this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 7) {
            this.mThumbImageViewLayout.setVisibility(0);
        }
    }

    public void loadCoverImage(String str, int i2) {
        this.mCoverOriginUrl = str;
        this.mDefaultRes = i2;
        c.b(getContext().getApplicationContext()).b((h) ((h) ((h) ((h) new h().a(1000000)).i()).b(i2)).a(i2)).a(str).a(this.mCoverImage);
    }

    public void loadCoverImageBy(int i2, int i3) {
        this.mCoverOriginId = i2;
        this.mDefaultRes = i3;
        this.mCoverImage.setImageResource(i2);
    }

    /* access modifiers changed from: protected */
    public void onClickUiToggle() {
        if (!this.mIfCurrentIsFullscreen || !this.mLockCurScreen || !this.mNeedLockFull) {
            this.byStartedClick = true;
            super.onClickUiToggle();
            return;
        }
        setViewShowState(this.mLockScreen, 0);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.byStartedClick = true;
        super.onStartTrackingTouch(seekBar);
    }

    public void onSurfaceAvailable(Surface surface) {
        super.onSurfaceAvailable(surface);
        if (GSYVideoType.getRenderType() != 0 && this.mThumbImageViewLayout != null && this.mThumbImageViewLayout.getVisibility() == 0) {
            this.mThumbImageViewLayout.setVisibility(4);
        }
    }

    public void onSurfaceUpdated(Surface surface) {
        super.onSurfaceUpdated(surface);
        if (this.mThumbImageViewLayout != null && this.mThumbImageViewLayout.getVisibility() == 0) {
            this.mThumbImageViewLayout.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void setViewShowState(View view, int i2) {
        if (view != this.mThumbImageViewLayout || i2 == 0) {
            super.setViewShowState(view, i2);
        }
    }

    public GSYBaseVideoPlayer showSmallVideo(Point point, boolean z2, boolean z3) {
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) super.showSmallVideo(point, z2, z3);
        sampleCoverVideo.mStartButton.setVisibility(8);
        sampleCoverVideo.mStartButton = null;
        return sampleCoverVideo;
    }

    public void startAfterPrepared() {
        super.startAfterPrepared();
        Debuger.printfLog("Sample startAfterPrepared");
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mBottomProgressBar, 0);
    }

    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z2, boolean z3) {
        GSYBaseVideoPlayer startWindowFullscreen = super.startWindowFullscreen(context, z2, z3);
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) startWindowFullscreen;
        String str = this.mCoverOriginUrl;
        if (str != null) {
            sampleCoverVideo.loadCoverImage(str, this.mDefaultRes);
        } else {
            int i2 = this.mCoverOriginId;
            if (i2 != 0) {
                sampleCoverVideo.loadCoverImageBy(i2, this.mDefaultRes);
            }
        }
        return startWindowFullscreen;
    }
}
