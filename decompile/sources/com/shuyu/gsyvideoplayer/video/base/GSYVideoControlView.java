package com.shuyu.gsyvideoplayer.video.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import java.io.File;
import java.util.Map;
import jg.c;
import jg.e;
import jg.h;

public abstract class GSYVideoControlView extends GSYVideoView implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    Runnable dismissControlTask = new Runnable() {
        public void run() {
            if (GSYVideoControlView.this.mCurrentState != 0 && GSYVideoControlView.this.mCurrentState != 7 && GSYVideoControlView.this.mCurrentState != 6) {
                if (GSYVideoControlView.this.getActivityContext() != null) {
                    GSYVideoControlView.this.hideAllWidget();
                    GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                    gSYVideoControlView.setViewShowState(gSYVideoControlView.mLockScreen, 8);
                    if (GSYVideoControlView.this.mHideKey && GSYVideoControlView.this.mIfCurrentIsFullscreen && GSYVideoControlView.this.mShowVKey) {
                        CommonUtil.hideNavKey(GSYVideoControlView.this.mContext);
                    }
                }
                if (GSYVideoControlView.this.mPostDismiss) {
                    GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                    gSYVideoControlView2.postDelayed(this, (long) gSYVideoControlView2.mDismissControlTime);
                }
            }
        }
    };
    protected GestureDetector gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GSYVideoControlView.this.touchDoubleUp();
            return super.onDoubleTap(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            GSYVideoControlView.this.touchLongPress(motionEvent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!GSYVideoControlView.this.mChangePosition && !GSYVideoControlView.this.mChangeVolume && !GSYVideoControlView.this.mBrightness) {
                GSYVideoControlView.this.onClickUiToggle();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    protected boolean isShowDragProgressTextOnSeekBar = false;
    protected ImageView mBackButton;
    protected ViewGroup mBottomContainer;
    protected ProgressBar mBottomProgressBar;
    protected boolean mBrightness = false;
    protected float mBrightnessData = -1.0f;
    protected boolean mChangePosition = false;
    protected boolean mChangeVolume = false;
    protected TextView mCurrentTimeTextView;
    protected int mDismissControlTime = 2500;
    protected int mDownPosition;
    protected float mDownX;
    protected float mDownY;
    protected int mEnlargeImageRes = -1;
    protected boolean mFirstTouch = false;
    protected ImageView mFullscreenButton;
    protected e mGSYVideoProgressListener;
    protected int mGestureDownVolume;
    protected c mGsyStateUiListener;
    protected boolean mHadSeekTouch = false;
    protected boolean mHideKey = true;
    protected boolean mIsTouchWiget = true;
    protected boolean mIsTouchWigetFull = true;
    protected View mLoadingProgressBar;
    protected h mLockClickListener;
    protected boolean mLockCurScreen;
    protected ImageView mLockScreen;
    protected float mMoveY;
    protected boolean mNeedLockFull;
    protected boolean mNeedShowWifiTip = true;
    protected boolean mPostDismiss = false;
    protected boolean mPostProgress = false;
    protected SeekBar mProgressBar;
    protected int mSeekEndOffset;
    protected float mSeekRatio = 1.0f;
    protected int mSeekTimePosition;
    protected boolean mSetUpLazy = false;
    protected boolean mShowVKey = false;
    protected int mShrinkImageRes = -1;
    protected View mStartButton;
    protected int mThreshold = 80;
    protected View mThumbImageView;
    protected RelativeLayout mThumbImageViewLayout;
    protected boolean mThumbPlay;
    protected TextView mTitleTextView;
    protected ViewGroup mTopContainer;
    protected TextView mTotalTimeTextView;
    protected View.OnTouchListener mTouchListener;
    protected boolean mTouchingProgressBar = false;
    float[] martixValue = new float[9];
    Runnable progressTask = new Runnable() {
        public void run() {
            if (GSYVideoControlView.this.mCurrentState == 2 || GSYVideoControlView.this.mCurrentState == 5) {
                GSYVideoControlView.this.setTextAndProgress(0);
            }
            if (GSYVideoControlView.this.mPostProgress) {
                GSYVideoControlView.this.postDelayed(this, 1000);
            }
        }
    };
    protected ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext().getApplicationContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Log.i("newUI", "onScale:------ " + scaleGestureDetector.getScaleFactor());
            return super.onScale(scaleGestureDetector);
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            Log.i("newUI", "onScaleBegin: --------" + scaleGestureDetector.getScaleFactor());
            return super.onScaleBegin(scaleGestureDetector);
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Log.i("newUI", "onScaleEnd: ------" + scaleGestureDetector.getScaleFactor());
            GSYVideoControlView.this.getCurrentScaleFactor(scaleGestureDetector.getScaleFactor());
            super.onScaleEnd(scaleGestureDetector);
        }
    });
    Matrix scaleMatrix = new Matrix();

    public GSYVideoControlView(Context context) {
        super(context);
    }

    public GSYVideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYVideoControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public GSYVideoControlView(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void cancelDismissControlViewTimer() {
        this.mPostDismiss = false;
        removeCallbacks(this.dismissControlTask);
    }

    /* access modifiers changed from: protected */
    public void cancelProgressTimer() {
        this.mPostProgress = false;
        removeCallbacks(this.progressTask);
    }

    /* access modifiers changed from: protected */
    public abstract void changeUiToCompleteShow();

    /* access modifiers changed from: protected */
    public abstract void changeUiToError();

    /* access modifiers changed from: protected */
    public abstract void changeUiToNormal();

    /* access modifiers changed from: protected */
    public abstract void changeUiToPauseShow();

    /* access modifiers changed from: protected */
    public abstract void changeUiToPlayingBufferingShow();

    /* access modifiers changed from: protected */
    public abstract void changeUiToPlayingShow();

    /* access modifiers changed from: protected */
    public abstract void changeUiToPreparingShow();

    public void clearThumbImageView() {
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public void clickStartIcon() {
        if (TextUtils.isEmpty(this.mUrl)) {
            Debuger.printfError("********" + getResources().getString(R.string.no_url));
            Toast.makeText(getActivityContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        if (this.mCurrentState == 0 || this.mCurrentState == 7) {
            if (isShowNetConfirm()) {
                showWifiDialog();
                return;
            }
        } else if (this.mCurrentState == 2) {
            try {
                onVideoPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            setStateAndUi(5);
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                if (this.mIfCurrentIsFullscreen) {
                    Debuger.printfLog("onClickStopFullscreen");
                    this.mVideoAllCallBack.onClickStopFullscreen(this.mOriginUrl, this.mTitle, this);
                    return;
                }
                Debuger.printfLog("onClickStop");
                this.mVideoAllCallBack.onClickStop(this.mOriginUrl, this.mTitle, this);
                return;
            }
            return;
        } else if (this.mCurrentState == 5) {
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                if (this.mIfCurrentIsFullscreen) {
                    Debuger.printfLog("onClickResumeFullscreen");
                    this.mVideoAllCallBack.onClickResumeFullscreen(this.mOriginUrl, this.mTitle, this);
                } else {
                    Debuger.printfLog("onClickResume");
                    this.mVideoAllCallBack.onClickResume(this.mOriginUrl, this.mTitle, this);
                }
            }
            if (!this.mHadPlay && !this.mStartAfterPrepared) {
                startAfterPrepared();
            }
            try {
                getGSYVideoManager().start();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            setStateAndUi(2);
            return;
        } else if (this.mCurrentState != 6) {
            return;
        }
        startButtonLogic();
    }

    /* access modifiers changed from: protected */
    public abstract void dismissBrightnessDialog();

    /* access modifiers changed from: protected */
    public abstract void dismissProgressDialog();

    /* access modifiers changed from: protected */
    public abstract void dismissVolumeDialog();

    public void firstFrameDetect(int i2, int i3) {
        firstFrameDetectView(i2, i3);
    }

    /* access modifiers changed from: protected */
    public abstract void firstFrameDetectView(int i2, int i3);

    public ImageView getBackButton() {
        return this.mBackButton;
    }

    /* access modifiers changed from: protected */
    public void getCurrentScaleFactor(float f2) {
    }

    public int getDismissControlTime() {
        return this.mDismissControlTime;
    }

    public int getEnlargeImageRes() {
        int i2 = this.mEnlargeImageRes;
        return i2 == -1 ? R.drawable.video_enlarge : i2;
    }

    public ImageView getFullscreenButton() {
        return this.mFullscreenButton;
    }

    public c getGSYStateUiListener() {
        return this.mGsyStateUiListener;
    }

    public float getScale() {
        this.scaleMatrix.getValues(this.martixValue);
        return this.martixValue[0];
    }

    public float getSeekRatio() {
        return this.mSeekRatio;
    }

    public int getShrinkImageRes() {
        int i2 = this.mShrinkImageRes;
        return i2 == -1 ? R.drawable.video_shrink : i2;
    }

    public View getStartButton() {
        return this.mStartButton;
    }

    public View getThumbImageView() {
        return this.mThumbImageView;
    }

    public RelativeLayout getThumbImageViewLayout() {
        return this.mThumbImageViewLayout;
    }

    public TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public SeekBar getmProgressBar() {
        return this.mProgressBar;
    }

    /* access modifiers changed from: protected */
    public abstract void hideAllWidget();

    /* access modifiers changed from: protected */
    public void init(Context context) {
        RelativeLayout relativeLayout;
        super.init(context);
        this.mStartButton = findViewById(R.id.start);
        this.mTitleTextView = (TextView) findViewById(R.id.title);
        this.mBackButton = (ImageView) findViewById(R.id.back);
        this.mFullscreenButton = (ImageView) findViewById(R.id.fullscreen);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress);
        this.mCurrentTimeTextView = (TextView) findViewById(R.id.current);
        this.mTotalTimeTextView = (TextView) findViewById(R.id.total);
        this.mBottomContainer = (ViewGroup) findViewById(R.id.layout_bottom);
        this.mTopContainer = (ViewGroup) findViewById(R.id.layout_top);
        this.mBottomProgressBar = (ProgressBar) findViewById(R.id.bottom_progressbar);
        this.mThumbImageViewLayout = (RelativeLayout) findViewById(R.id.thumb);
        this.mLockScreen = (ImageView) findViewById(R.id.lock_screen);
        this.mLoadingProgressBar = findViewById(R.id.loading);
        if (!isInEditMode()) {
            View view = this.mStartButton;
            if (view != null) {
                view.setOnClickListener(this);
            }
            ImageView imageView = this.mFullscreenButton;
            if (imageView != null) {
                imageView.setOnClickListener(this);
                this.mFullscreenButton.setOnTouchListener(this);
            }
            SeekBar seekBar = this.mProgressBar;
            if (seekBar != null) {
                seekBar.setOnSeekBarChangeListener(this);
            }
            ViewGroup viewGroup = this.mBottomContainer;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(this);
            }
            if (this.mTextureViewContainer != null) {
                this.mTextureViewContainer.setOnClickListener(this);
                this.mTextureViewContainer.setOnTouchListener(this);
            }
            SeekBar seekBar2 = this.mProgressBar;
            if (seekBar2 != null) {
                seekBar2.setOnTouchListener(this);
            }
            RelativeLayout relativeLayout2 = this.mThumbImageViewLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                this.mThumbImageViewLayout.setOnClickListener(this);
            }
            if (!(this.mThumbImageView == null || this.mIfCurrentIsFullscreen || (relativeLayout = this.mThumbImageViewLayout) == null)) {
                relativeLayout.removeAllViews();
                resolveThumbImage(this.mThumbImageView);
            }
            ImageView imageView2 = this.mBackButton;
            if (imageView2 != null) {
                imageView2.setOnClickListener(this);
            }
            ImageView imageView3 = this.mLockScreen;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
                this.mLockScreen.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (GSYVideoControlView.this.mCurrentState != 6 && GSYVideoControlView.this.mCurrentState != 7) {
                            GSYVideoControlView.this.lockTouchLogic();
                            if (GSYVideoControlView.this.mLockClickListener != null) {
                                GSYVideoControlView.this.mLockClickListener.onClick(view, GSYVideoControlView.this.mLockCurScreen);
                            }
                        }
                    }
                });
            }
            if (getActivityContext() != null) {
                this.mSeekEndOffset = CommonUtil.dip2px(getActivityContext(), 50.0f);
            }
        }
    }

    public void initUIState() {
        setStateAndUi(0);
    }

    public boolean isHideKey() {
        return this.mHideKey;
    }

    public boolean isNeedLockFull() {
        return this.mNeedLockFull;
    }

    public boolean isNeedShowWifiTip() {
        return this.mNeedShowWifiTip;
    }

    public boolean isShowDragProgressTextOnSeekBar() {
        return this.isShowDragProgressTextOnSeekBar;
    }

    /* access modifiers changed from: protected */
    public boolean isShowNetConfirm() {
        return !this.mOriginUrl.startsWith("file") && !this.mOriginUrl.startsWith("android.resource") && !CommonUtil.isWifiConnected(getContext()) && this.mNeedShowWifiTip && !getGSYVideoManager().cachePreview(this.mContext.getApplicationContext(), this.mCachePath, this.mOriginUrl);
    }

    public boolean isTouchWiget() {
        return this.mIsTouchWiget;
    }

    public boolean isTouchWigetFull() {
        return this.mIsTouchWigetFull;
    }

    /* access modifiers changed from: protected */
    public void lockTouchLogic() {
        if (this.mLockCurScreen) {
            this.mLockScreen.setImageResource(R.drawable.unlock);
            this.mLockCurScreen = false;
            return;
        }
        this.mLockScreen.setImageResource(R.drawable.lock);
        this.mLockCurScreen = true;
        hideAllWidget();
    }

    /* access modifiers changed from: protected */
    public void loopSetProgressAndTime() {
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null && this.mTotalTimeTextView != null && this.mCurrentTimeTextView != null) {
            seekBar.setProgress(0);
            this.mProgressBar.setSecondaryProgress(0);
            this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(0));
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
        }
    }

    public void onAutoCompletion() {
        super.onAutoCompletion();
        if (this.mLockCurScreen) {
            lockTouchLogic();
            this.mLockScreen.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onBrightnessSlide(float f2) {
        float f3 = ((Activity) this.mContext).getWindow().getAttributes().screenBrightness;
        this.mBrightnessData = f3;
        if (f3 <= 0.0f) {
            this.mBrightnessData = 0.5f;
        } else if (f3 < 0.01f) {
            this.mBrightnessData = 0.01f;
        }
        WindowManager.LayoutParams attributes = ((Activity) this.mContext).getWindow().getAttributes();
        attributes.screenBrightness = this.mBrightnessData + f2;
        if (attributes.screenBrightness > 1.0f) {
            attributes.screenBrightness = 1.0f;
        } else if (attributes.screenBrightness < 0.01f) {
            attributes.screenBrightness = 0.01f;
        }
        showBrightnessDialog(attributes.screenBrightness);
        ((Activity) this.mContext).getWindow().setAttributes(attributes);
    }

    public void onBufferingUpdate(final int i2) {
        post(new Runnable() {
            public void run() {
                if (GSYVideoControlView.this.mCurrentState != 0 && GSYVideoControlView.this.mCurrentState != 1) {
                    int i2 = i2;
                    if (i2 != 0) {
                        GSYVideoControlView.this.setTextAndProgress(i2);
                        GSYVideoControlView.this.mBufferPoint = i2;
                        Debuger.printfLog("Net speed: " + GSYVideoControlView.this.getNetSpeedText() + " percent " + i2);
                    }
                    if (GSYVideoControlView.this.mProgressBar != null && GSYVideoControlView.this.mLooping && GSYVideoControlView.this.mHadPlay && i2 == 0 && GSYVideoControlView.this.mProgressBar.getProgress() >= GSYVideoControlView.this.mProgressBar.getMax() - 1) {
                        GSYVideoControlView.this.loopSetProgressAndTime();
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (this.mHideKey && this.mIfCurrentIsFullscreen) {
            CommonUtil.hideNavKey(this.mContext);
        }
        if (id2 == R.id.start) {
            clickStartIcon();
        } else if (id2 == R.id.surface_container && this.mCurrentState == 7) {
            if (this.mVideoAllCallBack != null) {
                Debuger.printfLog("onClickStartError");
                this.mVideoAllCallBack.onClickStartError(this.mOriginUrl, this.mTitle, this);
            }
            prepareVideo();
        } else if (id2 == R.id.thumb) {
            if (this.mThumbPlay) {
                if (TextUtils.isEmpty(this.mUrl)) {
                    Debuger.printfError("********" + getResources().getString(R.string.no_url));
                } else if (this.mCurrentState == 0) {
                    if (isShowNetConfirm()) {
                        showWifiDialog();
                    } else {
                        startPlayLogic();
                    }
                } else if (this.mCurrentState == 6) {
                    onClickUiToggle();
                }
            }
        } else if (id2 == R.id.surface_container) {
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                if (this.mIfCurrentIsFullscreen) {
                    Debuger.printfLog("onClickBlankFullscreen");
                    this.mVideoAllCallBack.onClickBlankFullscreen(this.mOriginUrl, this.mTitle, this);
                } else {
                    Debuger.printfLog("onClickBlank");
                    this.mVideoAllCallBack.onClickBlank(this.mOriginUrl, this.mTitle, this);
                }
            }
            startDismissControlViewTimer();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onClickUiToggle();

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Debuger.printfLog(hashCode() + "------------------------------ dismiss onDetachedFromWindow");
        cancelProgressTimer();
        cancelDismissControlViewTimer();
    }

    public void onError(int i2, int i3) {
        super.onError(i2, i3);
        if (this.mLockCurScreen) {
            lockTouchLogic();
            this.mLockScreen.setVisibility(8);
        }
    }

    public void onPrepared() {
        setTextAndProgress(0, true);
        super.onPrepared();
        if (this.mCurrentState == 1) {
            startProgressTimer();
            Debuger.printfLog(hashCode() + "------------------------------ surface_container onPrepared");
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        showDragProgressTextOnSeekBar(z2, i2);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mHadSeekTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            if (isIfCurrentIsFullscreen()) {
                Debuger.printfLog("onClickSeekbarFullscreen");
                this.mVideoAllCallBack.onClickSeekbarFullscreen(this.mOriginUrl, this.mTitle, this);
            } else {
                Debuger.printfLog("onClickSeekbar");
                this.mVideoAllCallBack.onClickSeekbar(this.mOriginUrl, this.mTitle, this);
            }
        }
        if (getGSYVideoManager() != null && this.mHadPlay) {
            try {
                getGSYVideoManager().seekTo((long) ((seekBar.getProgress() * getDuration()) / 100));
            } catch (Exception e2) {
                Debuger.printfWarning(e2.toString());
            }
        }
        this.mHadSeekTouch = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b5, code lost:
        if (r8 != 2) goto L_0x00fd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            int r0 = r8.getId()
            float r1 = r9.getX()
            float r2 = r9.getY()
            boolean r3 = r7.mIfCurrentIsFullscreen
            r4 = 1
            if (r3 == 0) goto L_0x0020
            boolean r3 = r7.mLockCurScreen
            if (r3 == 0) goto L_0x0020
            boolean r3 = r7.mNeedLockFull
            if (r3 == 0) goto L_0x0020
            r7.onClickUiToggle()
            r7.startDismissControlViewTimer()
            return r4
        L_0x0020:
            int r3 = com.shuyu.gsyvideoplayer.R.id.fullscreen
            r5 = 0
            if (r0 != r3) goto L_0x0026
            return r5
        L_0x0026:
            int r3 = com.shuyu.gsyvideoplayer.R.id.surface_container
            r6 = 2
            if (r0 != r3) goto L_0x00a9
            int r0 = r9.getAction()
            if (r0 == 0) goto L_0x0099
            if (r0 == r4) goto L_0x0068
            if (r0 == r6) goto L_0x0036
            goto L_0x00a3
        L_0x0036:
            float r8 = r7.mDownX
            float r1 = r1 - r8
            float r8 = r7.mDownY
            float r8 = r2 - r8
            float r0 = java.lang.Math.abs(r1)
            float r3 = java.lang.Math.abs(r8)
            boolean r4 = r7.mIfCurrentIsFullscreen
            if (r4 == 0) goto L_0x004d
            boolean r4 = r7.mIsTouchWigetFull
            if (r4 != 0) goto L_0x0055
        L_0x004d:
            boolean r4 = r7.mIsTouchWiget
            if (r4 == 0) goto L_0x0064
            boolean r4 = r7.mIfCurrentIsFullscreen
            if (r4 != 0) goto L_0x0064
        L_0x0055:
            boolean r4 = r7.mChangePosition
            if (r4 != 0) goto L_0x0064
            boolean r4 = r7.mChangeVolume
            if (r4 != 0) goto L_0x0064
            boolean r4 = r7.mBrightness
            if (r4 != 0) goto L_0x0064
            r7.touchSurfaceMoveFullLogic(r0, r3)
        L_0x0064:
            r7.touchSurfaceMove(r1, r8, r2)
            goto L_0x00a3
        L_0x0068:
            r7.startDismissControlViewTimer()
            r7.touchSurfaceUp()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r7.hashCode()
            r0.append(r1)
            java.lang.String r1 = "------------------------------ surface_container ACTION_UP"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r0)
            r7.startProgressTimer()
            android.view.View$OnTouchListener r0 = r7.mTouchListener
            if (r0 == 0) goto L_0x0090
            r0.onTouch(r8, r9)
        L_0x0090:
            boolean r8 = r7.mHideKey
            if (r8 == 0) goto L_0x00a3
            boolean r8 = r7.mShowVKey
            if (r8 == 0) goto L_0x00a3
            return r4
        L_0x0099:
            r7.touchSurfaceDown(r1, r2)
            android.view.View$OnTouchListener r0 = r7.mTouchListener
            if (r0 == 0) goto L_0x00a3
            r0.onTouch(r8, r9)
        L_0x00a3:
            android.view.GestureDetector r8 = r7.gestureDetector
            r8.onTouchEvent(r9)
            goto L_0x00fd
        L_0x00a9:
            int r8 = com.shuyu.gsyvideoplayer.R.id.progress
            if (r0 != r8) goto L_0x00fd
            int r8 = r9.getAction()
            if (r8 == 0) goto L_0x00e9
            if (r8 == r4) goto L_0x00b8
            if (r8 == r6) goto L_0x00ec
            goto L_0x00fd
        L_0x00b8:
            r7.startDismissControlViewTimer()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r7.hashCode()
            r8.append(r9)
            java.lang.String r9 = "------------------------------ progress ACTION_UP"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r8)
            r7.startProgressTimer()
            android.view.ViewParent r8 = r7.getParent()
        L_0x00da:
            if (r8 == 0) goto L_0x00e4
            r8.requestDisallowInterceptTouchEvent(r5)
            android.view.ViewParent r8 = r8.getParent()
            goto L_0x00da
        L_0x00e4:
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.mBrightnessData = r8
            goto L_0x00fd
        L_0x00e9:
            r7.cancelDismissControlViewTimer()
        L_0x00ec:
            r7.cancelProgressTimer()
            android.view.ViewParent r8 = r7.getParent()
        L_0x00f3:
            if (r8 == 0) goto L_0x00fd
            r8.requestDisallowInterceptTouchEvent(r4)
            android.view.ViewParent r8 = r8.getParent()
            goto L_0x00f3
        L_0x00fd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void prepareVideo() {
        if (this.mSetUpLazy) {
            super.setUp(this.mOriginUrl, this.mCache, this.mCachePath, (Map<String, String>) this.mMapHeadData, this.mTitle);
        }
        super.prepareVideo();
    }

    /* access modifiers changed from: protected */
    public void resetProgressAndTime() {
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null && this.mTotalTimeTextView != null && this.mCurrentTimeTextView != null) {
            seekBar.setProgress(0);
            this.mProgressBar.setSecondaryProgress(0);
            this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(0));
            this.mTotalTimeTextView.setText(CommonUtil.stringForTime(0));
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(0);
                this.mBottomProgressBar.setSecondaryProgress(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resolveThumbImage(View view) {
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.mThumbImageViewLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void resolveUIState(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                changeUiToPreparingShow();
            } else if (i2 == 2) {
                changeUiToPlayingShow();
            } else if (i2 == 3) {
                changeUiToPlayingBufferingShow();
                return;
            } else if (i2 == 5) {
                changeUiToPauseShow();
            } else if (i2 == 6) {
                changeUiToCompleteShow();
            } else if (i2 == 7) {
                changeUiToError();
                return;
            } else {
                return;
            }
            startDismissControlViewTimer();
            return;
        }
        changeUiToNormal();
        cancelDismissControlViewTimer();
    }

    public void setDismissControlTime(int i2) {
        this.mDismissControlTime = i2;
    }

    public void setEnlargeImageRes(int i2) {
        this.mEnlargeImageRes = i2;
    }

    public void setGSYStateUiListener(c cVar) {
        this.mGsyStateUiListener = cVar;
    }

    public void setGSYVideoProgressListener(e eVar) {
        this.mGSYVideoProgressListener = eVar;
    }

    public void setHideKey(boolean z2) {
        this.mHideKey = z2;
    }

    public void setIsTouchWiget(boolean z2) {
        this.mIsTouchWiget = z2;
    }

    public void setIsTouchWigetFull(boolean z2) {
        this.mIsTouchWigetFull = z2;
    }

    public void setLockClickListener(h hVar) {
        this.mLockClickListener = hVar;
    }

    public void setNeedLockFull(boolean z2) {
        this.mNeedLockFull = z2;
    }

    public void setNeedShowWifiTip(boolean z2) {
        this.mNeedShowWifiTip = z2;
    }

    /* access modifiers changed from: protected */
    public void setProgressAndTime(int i2, int i3, int i4, int i5, boolean z2) {
        if (this.mGSYVideoProgressListener != null && this.mCurrentState == 2) {
            this.mGSYVideoProgressListener.a(i2, i3, i4, i5);
        }
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null && this.mTotalTimeTextView != null && this.mCurrentTimeTextView != null && !this.mHadSeekTouch) {
            if (!this.mTouchingProgressBar && (i2 != 0 || z2)) {
                seekBar.setProgress(i2);
            }
            if (getGSYVideoManager().getBufferedPercentage() > 0) {
                i3 = getGSYVideoManager().getBufferedPercentage();
            }
            if (i3 > 94) {
                i3 = 100;
            }
            setSecondaryProgress(i3);
            this.mTotalTimeTextView.setText(CommonUtil.stringForTime(i5));
            if (i4 > 0) {
                this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(i4));
            }
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                if (i2 != 0 || z2) {
                    progressBar.setProgress(i2);
                }
                setSecondaryProgress(i3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setSecondaryProgress(int i2) {
        if (!(this.mProgressBar == null || i2 == 0 || getGSYVideoManager().isCacheFile())) {
            this.mProgressBar.setSecondaryProgress(i2);
        }
        if (this.mBottomProgressBar != null && i2 != 0 && !getGSYVideoManager().isCacheFile()) {
            this.mBottomProgressBar.setSecondaryProgress(i2);
        }
    }

    public void setSeekRatio(float f2) {
        if (f2 >= 0.0f) {
            this.mSeekRatio = f2;
        }
    }

    public void setShowDragProgressTextOnSeekBar(boolean z2) {
        this.isShowDragProgressTextOnSeekBar = z2;
    }

    public void setShrinkImageRes(int i2) {
        this.mShrinkImageRes = i2;
    }

    /* access modifiers changed from: protected */
    public void setSmallVideoTextureView(View.OnTouchListener onTouchListener) {
        super.setSmallVideoTextureView(onTouchListener);
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(onTouchListener);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateAndUi(int i2) {
        StringBuilder sb;
        String str;
        TextView textView;
        this.mCurrentState = i2;
        if ((i2 == 0 && isCurrentMediaListener()) || i2 == 6 || i2 == 7) {
            this.mHadPrepared = false;
        }
        int i3 = this.mCurrentState;
        if (i3 == 0) {
            if (isCurrentMediaListener()) {
                Debuger.printfLog(hashCode() + "------------------------------ dismiss CURRENT_STATE_NORMAL");
                cancelProgressTimer();
                getGSYVideoManager().releaseMediaPlayer();
                releasePauseCover();
                this.mBufferPoint = 0;
                this.mSaveChangeViewTIme = 0;
            }
            releaseNetWorkState();
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 5) {
                    sb = new StringBuilder();
                    sb.append(hashCode());
                    str = "------------------------------ CURRENT_STATE_PAUSE";
                } else if (i3 == 6) {
                    Debuger.printfLog(hashCode() + "------------------------------ dismiss CURRENT_STATE_AUTO_COMPLETE");
                    cancelProgressTimer();
                    SeekBar seekBar = this.mProgressBar;
                    if (seekBar != null) {
                        seekBar.setProgress(100);
                    }
                    TextView textView2 = this.mCurrentTimeTextView;
                    if (!(textView2 == null || (textView = this.mTotalTimeTextView) == null)) {
                        textView2.setText(textView.getText());
                    }
                    ProgressBar progressBar = this.mBottomProgressBar;
                    if (progressBar != null) {
                        progressBar.setProgress(100);
                    }
                } else if (i3 == 7 && isCurrentMediaListener()) {
                    getGSYVideoManager().releaseMediaPlayer();
                }
            } else if (isCurrentMediaListener()) {
                sb = new StringBuilder();
                sb.append(hashCode());
                str = "------------------------------ CURRENT_STATE_PLAYING";
            }
            sb.append(str);
            Debuger.printfLog(sb.toString());
            startProgressTimer();
        } else {
            resetProgressAndTime();
        }
        resolveUIState(i2);
        c cVar = this.mGsyStateUiListener;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    public void setSurfaceOnTouch(View.OnTouchListener onTouchListener) {
        this.mTouchListener = onTouchListener;
    }

    /* access modifiers changed from: protected */
    public void setTextAndProgress(int i2) {
        setTextAndProgress(i2, false);
    }

    /* access modifiers changed from: protected */
    public void setTextAndProgress(int i2, boolean z2) {
        int currentPositionWhenPlaying = getCurrentPositionWhenPlaying();
        int duration = getDuration();
        setProgressAndTime((currentPositionWhenPlaying * 100) / (duration == 0 ? 1 : duration), i2, currentPositionWhenPlaying, duration, z2);
    }

    public void setThumbImageView(View view) {
        if (this.mThumbImageViewLayout != null) {
            this.mThumbImageView = view;
            resolveThumbImage(view);
        }
    }

    public void setThumbPlay(boolean z2) {
        this.mThumbPlay = z2;
    }

    public boolean setUp(String str, boolean z2, File file, String str2) {
        int i2;
        ImageView imageView;
        TextView textView;
        if (!super.setUp(str, z2, file, str2)) {
            return false;
        }
        if (!(str2 == null || (textView = this.mTitleTextView) == null)) {
            textView.setText(str2);
        }
        if (this.mIfCurrentIsFullscreen) {
            imageView = this.mFullscreenButton;
            if (imageView == null) {
                return true;
            }
            i2 = getShrinkImageRes();
        } else {
            imageView = this.mFullscreenButton;
            if (imageView == null) {
                return true;
            }
            i2 = getEnlargeImageRes();
        }
        imageView.setImageResource(i2);
        return true;
    }

    public boolean setUp(String str, boolean z2, String str2) {
        return setUp(str, z2, (File) null, str2);
    }

    public boolean setUpLazy(String str, boolean z2, File file, Map<String, String> map, String str2) {
        this.mOriginUrl = str;
        this.mCache = z2;
        this.mCachePath = file;
        this.mSetUpLazy = true;
        this.mTitle = str2;
        this.mMapHeadData = map;
        if (isCurrentMediaListener() && System.currentTimeMillis() - this.mSaveChangeViewTIme < 2000) {
            return false;
        }
        this.mUrl = "waiting";
        this.mCurrentState = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void setViewShowState(View view, int i2) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void showBrightnessDialog(float f2);

    /* access modifiers changed from: protected */
    public void showDragProgressTextOnSeekBar(boolean z2, int i2) {
        if (z2 && this.isShowDragProgressTextOnSeekBar) {
            int duration = getDuration();
            TextView textView = this.mCurrentTimeTextView;
            if (textView != null) {
                textView.setText(CommonUtil.stringForTime((i2 * duration) / 100));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void showProgressDialog(float f2, String str, int i2, String str2, int i3);

    /* access modifiers changed from: protected */
    public abstract void showVolumeDialog(float f2, int i2);

    /* access modifiers changed from: protected */
    public abstract void showWifiDialog();

    /* access modifiers changed from: protected */
    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        this.mPostDismiss = true;
        postDelayed(this.dismissControlTask, (long) this.mDismissControlTime);
    }

    /* access modifiers changed from: protected */
    public void startProgressTimer() {
        cancelProgressTimer();
        this.mPostProgress = true;
        postDelayed(this.progressTask, 300);
    }

    /* access modifiers changed from: protected */
    public void touchDoubleUp() {
        if (this.mHadPlay) {
            clickStartIcon();
        }
    }

    /* access modifiers changed from: protected */
    public void touchLongPress(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceDown(float f2, float f3) {
        this.mTouchingProgressBar = true;
        this.mDownX = f2;
        this.mDownY = f3;
        this.mMoveY = 0.0f;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = true;
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMove(float f2, float f3, float f4) {
        int i2;
        int i3 = 0;
        if (getActivityContext() != null) {
            i3 = CommonUtil.getCurrentScreenLand((Activity) getActivityContext()) ? this.mScreenHeight : this.mScreenWidth;
            i2 = CommonUtil.getCurrentScreenLand((Activity) getActivityContext()) ? this.mScreenWidth : this.mScreenHeight;
        } else {
            i2 = 0;
        }
        if (this.mChangePosition) {
            int duration = getDuration();
            int i4 = (int) (((float) this.mDownPosition) + (((((float) duration) * f2) / ((float) i3)) / this.mSeekRatio));
            this.mSeekTimePosition = i4;
            if (i4 > duration) {
                this.mSeekTimePosition = duration;
            }
            showProgressDialog(f2, CommonUtil.stringForTime(this.mSeekTimePosition), this.mSeekTimePosition, CommonUtil.stringForTime(duration), duration);
        } else if (!this.mChangeVolume && this.mBrightness && Math.abs(f3) > ((float) this.mThreshold)) {
            onBrightnessSlide((-f3) / ((float) i2));
            this.mDownY = f4;
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMoveFullLogic(float f2, float f3) {
        int i2 = getActivityContext() != null ? CommonUtil.getCurrentScreenLand((Activity) getActivityContext()) ? this.mScreenHeight : this.mScreenWidth : 0;
        int i3 = this.mThreshold;
        if (f2 > ((float) i3) || f3 > ((float) i3)) {
            cancelProgressTimer();
            if (f2 < ((float) this.mThreshold)) {
                boolean z2 = Math.abs(((float) CommonUtil.getScreenHeight(getContext())) - this.mDownY) > ((float) this.mSeekEndOffset);
                if (this.mFirstTouch) {
                    this.mBrightness = this.mDownX < ((float) i2) * 0.5f && z2;
                    this.mFirstTouch = false;
                }
                if (!this.mBrightness) {
                    this.mChangeVolume = z2;
                }
                this.mShowVKey = !z2;
            } else if (Math.abs(((float) CommonUtil.getScreenWidth(getContext())) - this.mDownX) > ((float) this.mSeekEndOffset)) {
                this.mChangePosition = true;
                this.mDownPosition = getCurrentPositionWhenPlaying();
            } else {
                this.mShowVKey = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceUp() {
        if (this.mChangePosition) {
            int duration = getDuration();
            int i2 = this.mSeekTimePosition * 100;
            if (duration == 0) {
                duration = 1;
            }
            int i3 = i2 / duration;
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(i3);
            }
        }
        this.mTouchingProgressBar = false;
        dismissProgressDialog();
        dismissVolumeDialog();
        dismissBrightnessDialog();
        if (this.mChangePosition && getGSYVideoManager() != null && (this.mCurrentState == 2 || this.mCurrentState == 5)) {
            try {
                getGSYVideoManager().seekTo((long) this.mSeekTimePosition);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int duration2 = getDuration();
            int i4 = this.mSeekTimePosition * 100;
            if (duration2 == 0) {
                duration2 = 1;
            }
            int i5 = i4 / duration2;
            SeekBar seekBar = this.mProgressBar;
            if (seekBar != null) {
                seekBar.setProgress(i5);
            }
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                Debuger.printfLog("onTouchScreenSeekPosition");
                this.mVideoAllCallBack.onTouchScreenSeekPosition(this.mOriginUrl, this.mTitle, this);
            }
        } else if (this.mBrightness) {
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                Debuger.printfLog("onTouchScreenSeekLight");
                this.mVideoAllCallBack.onTouchScreenSeekLight(this.mOriginUrl, this.mTitle, this);
            }
        } else if (this.mChangeVolume && this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            Debuger.printfLog("onTouchScreenSeekVolume");
            this.mVideoAllCallBack.onTouchScreenSeekVolume(this.mOriginUrl, this.mTitle, this);
        }
    }
}
