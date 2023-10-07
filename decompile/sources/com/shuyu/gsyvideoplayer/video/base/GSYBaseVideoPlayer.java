package com.shuyu.gsyvideoplayer.video.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.OrientationOption;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.transitionseverywhere.e;
import java.io.File;
import java.util.Map;
import jg.a;

public abstract class GSYBaseVideoPlayer extends GSYVideoControlView {
    protected boolean isNeedAutoAdaptation = false;
    protected boolean mActionBar = false;
    protected boolean mAutoFullWithSize = false;
    protected View.OnClickListener mBackFromFullScreenListener;
    protected Runnable mCheckoutTask = new Runnable() {
        public void run() {
            GSYVideoPlayer fullWindowPlayer = GSYBaseVideoPlayer.this.getFullWindowPlayer();
            if (fullWindowPlayer != null && fullWindowPlayer.mCurrentState != GSYBaseVideoPlayer.this.mCurrentState && fullWindowPlayer.mCurrentState == 3 && GSYBaseVideoPlayer.this.mCurrentState != 1) {
                fullWindowPlayer.setStateAndUi(GSYBaseVideoPlayer.this.mCurrentState);
            }
        }
    };
    protected boolean mFullAnimEnd = true;
    protected Handler mInnerHandler = new Handler();
    private boolean mIsOnlyRotateLand = false;
    protected int[] mListItemRect;
    protected int[] mListItemSize;
    protected boolean mLockLand = false;
    protected OrientationUtils mOrientationUtils;
    protected boolean mRotateViewAuto = true;
    protected boolean mRotateWithSystem = true;
    protected boolean mShowFullAnimation = true;
    protected View mSmallClose;
    protected boolean mStatusBar = false;
    protected int mSystemUiVisibility;

    public GSYBaseVideoPlayer(Context context) {
        super(context);
    }

    public GSYBaseVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYBaseVideoPlayer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public GSYBaseVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    private ViewGroup getViewGroup() {
        return (ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290);
    }

    private void pauseFullBackCoverLogic(GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        Bitmap bitmap;
        if (gSYBaseVideoPlayer.mCurrentState == 5 && gSYBaseVideoPlayer.mTextureView != null && this.mShowPauseCover) {
            if (gSYBaseVideoPlayer.mFullPauseBitmap != null && !gSYBaseVideoPlayer.mFullPauseBitmap.isRecycled() && this.mShowPauseCover) {
                bitmap = gSYBaseVideoPlayer.mFullPauseBitmap;
                this.mFullPauseBitmap = bitmap;
            } else if (this.mShowPauseCover) {
                try {
                    initCover();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bitmap = null;
                }
            }
        }
    }

    private void pauseFullCoverLogic() {
        if (this.mCurrentState == 5 && this.mTextureView != null) {
            if ((this.mFullPauseBitmap == null || this.mFullPauseBitmap.isRecycled()) && this.mShowPauseCover) {
                try {
                    initCover();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.mFullPauseBitmap = null;
                }
            }
        }
    }

    private void removeVideo(ViewGroup viewGroup, int i2) {
        View findViewById = viewGroup.findViewById(i2);
        if (findViewById != null && findViewById.getParent() != null) {
            viewGroup.removeView((ViewGroup) findViewById.getParent());
        }
    }

    private void saveLocationStatus(Context context, boolean z2, boolean z3) {
        getLocationOnScreen(this.mListItemRect);
        if (context instanceof Activity) {
            int statusBarHeight = CommonUtil.getStatusBarHeight(context);
            Activity activity = (Activity) context;
            int actionBarHeight = CommonUtil.getActionBarHeight(activity);
            boolean z4 = (activity.getWindow().getAttributes().flags & 67108864) == 67108864;
            Debuger.printfLog("*************isTranslucent*************** " + z4);
            if (z2 && !z4) {
                int[] iArr = this.mListItemRect;
                iArr[1] = iArr[1] - statusBarHeight;
            }
            if (z3) {
                int[] iArr2 = this.mListItemRect;
                iArr2[1] = iArr2[1] - actionBarHeight;
            }
        }
        this.mListItemSize[0] = getWidth();
        this.mListItemSize[1] = getHeight();
    }

    /* access modifiers changed from: protected */
    public void autoAdaptation() {
        String str;
        Context context = getContext();
        if (isVerticalVideo()) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                setPadding(0, CommonUtil.getStatusBarHeight(context), 0, 0);
                str = "竖屏，系统未将布局下移";
            } else {
                str = "竖屏，系统将布局下移；y:" + iArr[1];
            }
            Debuger.printfLog(str);
        }
    }

    /* access modifiers changed from: protected */
    public void backToNormal() {
        final ViewGroup viewGroup = getViewGroup();
        final View findViewById = viewGroup.findViewById(getFullId());
        if (findViewById != null) {
            final GSYVideoPlayer gSYVideoPlayer = (GSYVideoPlayer) findViewById;
            pauseFullBackCoverLogic(gSYVideoPlayer);
            if (this.mShowFullAnimation) {
                e.a(viewGroup);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gSYVideoPlayer.getLayoutParams();
                int[] iArr = this.mListItemRect;
                layoutParams.setMargins(iArr[0], iArr[1], 0, 0);
                layoutParams.width = this.mListItemSize[0];
                layoutParams.height = this.mListItemSize[1];
                layoutParams.gravity = 0;
                gSYVideoPlayer.setLayoutParams(layoutParams);
                this.mInnerHandler.postDelayed(new Runnable() {
                    public void run() {
                        GSYBaseVideoPlayer.this.resolveNormalVideoShow(findViewById, viewGroup, gSYVideoPlayer);
                    }
                }, 400);
                return;
            }
            resolveNormalVideoShow(findViewById, viewGroup, gSYVideoPlayer);
            return;
        }
        resolveNormalVideoShow((View) null, viewGroup, (GSYVideoPlayer) null);
    }

    /* access modifiers changed from: protected */
    public void checkAutoFullSizeWhenFull() {
        OrientationUtils orientationUtils;
        if (this.mIfCurrentIsFullscreen) {
            boolean isVerticalFullByVideoSize = isVerticalFullByVideoSize();
            Debuger.printfLog("GSYVideoBase onPrepared isVerticalFullByVideoSize " + isVerticalFullByVideoSize);
            if (isVerticalFullByVideoSize && (orientationUtils = this.mOrientationUtils) != null) {
                orientationUtils.backToProtVideo();
                checkAutoFullWithSizeAndAdaptation(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkAutoFullWithSizeAndAdaptation(final GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        if (gSYBaseVideoPlayer != null && this.isNeedAutoAdaptation && isAutoFullWithSize() && isVerticalVideo() && isFullHideStatusBar()) {
            this.mInnerHandler.postDelayed(new Runnable() {
                public void run() {
                    gSYBaseVideoPlayer.getCurrentPlayer().autoAdaptation();
                }
            }, 100);
        }
    }

    /* access modifiers changed from: protected */
    public void checkoutState() {
        removeCallbacks(this.mCheckoutTask);
        this.mInnerHandler.postDelayed(this.mCheckoutTask, 500);
    }

    /* access modifiers changed from: protected */
    public void clearFullscreenLayout() {
        int i2;
        if (this.mFullAnimEnd) {
            this.mIfCurrentIsFullscreen = false;
            OrientationUtils orientationUtils = this.mOrientationUtils;
            if (orientationUtils != null) {
                i2 = orientationUtils.backToProtVideo();
                this.mOrientationUtils.setEnable(false);
                OrientationUtils orientationUtils2 = this.mOrientationUtils;
                if (orientationUtils2 != null) {
                    orientationUtils2.releaseListener();
                    this.mOrientationUtils = null;
                }
            } else {
                i2 = 0;
            }
            if (!this.mShowFullAnimation) {
                i2 = 0;
            }
            View findViewById = getViewGroup().findViewById(getFullId());
            if (findViewById != null) {
                ((GSYVideoPlayer) findViewById).mIfCurrentIsFullscreen = false;
            }
            this.mInnerHandler.postDelayed(new Runnable() {
                public void run() {
                    GSYBaseVideoPlayer.this.backToNormal();
                }
            }, (long) i2);
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        gSYBaseVideoPlayer2.mHadPlay = gSYBaseVideoPlayer.mHadPlay;
        gSYBaseVideoPlayer2.mPlayTag = gSYBaseVideoPlayer.mPlayTag;
        gSYBaseVideoPlayer2.mPlayPosition = gSYBaseVideoPlayer.mPlayPosition;
        gSYBaseVideoPlayer2.mEffectFilter = gSYBaseVideoPlayer.mEffectFilter;
        gSYBaseVideoPlayer2.mFullPauseBitmap = gSYBaseVideoPlayer.mFullPauseBitmap;
        gSYBaseVideoPlayer2.mNeedShowWifiTip = gSYBaseVideoPlayer.mNeedShowWifiTip;
        gSYBaseVideoPlayer2.mShrinkImageRes = gSYBaseVideoPlayer.mShrinkImageRes;
        gSYBaseVideoPlayer2.mEnlargeImageRes = gSYBaseVideoPlayer.mEnlargeImageRes;
        gSYBaseVideoPlayer2.mRotate = gSYBaseVideoPlayer.mRotate;
        gSYBaseVideoPlayer2.mShowPauseCover = gSYBaseVideoPlayer.mShowPauseCover;
        gSYBaseVideoPlayer2.mDismissControlTime = gSYBaseVideoPlayer.mDismissControlTime;
        gSYBaseVideoPlayer2.mSeekRatio = gSYBaseVideoPlayer.mSeekRatio;
        gSYBaseVideoPlayer2.mNetChanged = gSYBaseVideoPlayer.mNetChanged;
        gSYBaseVideoPlayer2.mNetSate = gSYBaseVideoPlayer.mNetSate;
        gSYBaseVideoPlayer2.mRotateWithSystem = gSYBaseVideoPlayer.mRotateWithSystem;
        gSYBaseVideoPlayer2.mBackUpPlayingBufferState = gSYBaseVideoPlayer.mBackUpPlayingBufferState;
        gSYBaseVideoPlayer2.mRenderer = gSYBaseVideoPlayer.mRenderer;
        gSYBaseVideoPlayer2.mMode = gSYBaseVideoPlayer.mMode;
        gSYBaseVideoPlayer2.mBackFromFullScreenListener = gSYBaseVideoPlayer.mBackFromFullScreenListener;
        gSYBaseVideoPlayer2.mGSYVideoProgressListener = gSYBaseVideoPlayer.mGSYVideoProgressListener;
        gSYBaseVideoPlayer2.mHadPrepared = gSYBaseVideoPlayer.mHadPrepared;
        gSYBaseVideoPlayer2.mStartAfterPrepared = gSYBaseVideoPlayer.mStartAfterPrepared;
        gSYBaseVideoPlayer2.mPauseBeforePrepared = gSYBaseVideoPlayer.mPauseBeforePrepared;
        gSYBaseVideoPlayer2.mVideoAllCallBack = gSYBaseVideoPlayer.mVideoAllCallBack;
        gSYBaseVideoPlayer2.mActionBar = gSYBaseVideoPlayer.mActionBar;
        gSYBaseVideoPlayer2.mStatusBar = gSYBaseVideoPlayer.mStatusBar;
        gSYBaseVideoPlayer2.mAutoFullWithSize = gSYBaseVideoPlayer.mAutoFullWithSize;
        gSYBaseVideoPlayer2.mOverrideExtension = gSYBaseVideoPlayer.mOverrideExtension;
        boolean z2 = gSYBaseVideoPlayer.mSetUpLazy;
        String str = gSYBaseVideoPlayer.mOriginUrl;
        boolean z3 = gSYBaseVideoPlayer.mCache;
        File file = gSYBaseVideoPlayer.mCachePath;
        Map map = gSYBaseVideoPlayer.mMapHeadData;
        String str2 = gSYBaseVideoPlayer.mTitle;
        GSYBaseVideoPlayer gSYBaseVideoPlayer3 = gSYBaseVideoPlayer2;
        if (z2) {
            gSYBaseVideoPlayer3.setUpLazy(str, z3, file, map, str2);
            gSYBaseVideoPlayer2.mUrl = gSYBaseVideoPlayer.mUrl;
        } else {
            gSYBaseVideoPlayer3.setUp(str, z3, file, (Map<String, String>) map, str2);
        }
        gSYBaseVideoPlayer2.setLooping(gSYBaseVideoPlayer.isLooping());
        gSYBaseVideoPlayer2.setIsTouchWigetFull(gSYBaseVideoPlayer.mIsTouchWigetFull);
        gSYBaseVideoPlayer2.setSpeed(gSYBaseVideoPlayer.getSpeed(), gSYBaseVideoPlayer.mSoundTouch);
        gSYBaseVideoPlayer2.setStateAndUi(gSYBaseVideoPlayer.mCurrentState);
    }

    public GSYBaseVideoPlayer getCurrentPlayer() {
        return getFullWindowPlayer() != null ? getFullWindowPlayer() : getSmallWindowPlayer() != null ? getSmallWindowPlayer() : this;
    }

    /* access modifiers changed from: protected */
    public abstract int getFullId();

    public GSYVideoPlayer getFullWindowPlayer() {
        View findViewById = ((ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290)).findViewById(getFullId());
        if (findViewById != null) {
            return (GSYVideoPlayer) findViewById;
        }
        return null;
    }

    public OrientationOption getOrientationOption() {
        return null;
    }

    public int getSaveBeforeFullSystemUiVisibility() {
        return this.mSystemUiVisibility;
    }

    /* access modifiers changed from: protected */
    public abstract int getSmallId();

    public GSYVideoPlayer getSmallWindowPlayer() {
        View findViewById = ((ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290)).findViewById(getSmallId());
        if (findViewById != null) {
            return (GSYVideoPlayer) findViewById;
        }
        return null;
    }

    public void hideSmallVideo() {
        ViewGroup viewGroup = getViewGroup();
        GSYVideoPlayer gSYVideoPlayer = (GSYVideoPlayer) viewGroup.findViewById(getSmallId());
        removeVideo(viewGroup, getSmallId());
        this.mCurrentState = getGSYVideoManager().getLastState();
        if (gSYVideoPlayer != null) {
            cloneParams(gSYVideoPlayer, this);
        }
        getGSYVideoManager().setListener(getGSYVideoManager().lastListener());
        getGSYVideoManager().setLastListener((a) null);
        setStateAndUi(this.mCurrentState);
        addTextureView();
        this.mSaveChangeViewTIme = System.currentTimeMillis();
        if (this.mVideoAllCallBack != null) {
            Debuger.printfLog("onQuitSmallWidget");
            this.mVideoAllCallBack.onQuitSmallWidget(this.mOriginUrl, this.mTitle, this);
        }
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        this.mSmallClose = findViewById(R.id.small_close);
    }

    public boolean isAutoFullWithSize() {
        return this.mAutoFullWithSize;
    }

    public boolean isFullHideActionBar() {
        return this.mActionBar;
    }

    public boolean isFullHideStatusBar() {
        return this.mStatusBar;
    }

    public boolean isLockLand() {
        return this.mLockLand;
    }

    /* access modifiers changed from: protected */
    public boolean isLockLandByAutoFullSize() {
        return isAutoFullWithSize() ? isVerticalVideo() : this.mLockLand;
    }

    public boolean isNeedAutoAdaptation() {
        return this.isNeedAutoAdaptation;
    }

    public boolean isOnlyRotateLand() {
        return this.mIsOnlyRotateLand;
    }

    public boolean isRotateViewAuto() {
        if (this.mAutoFullWithSize) {
            return false;
        }
        return this.mRotateViewAuto;
    }

    public boolean isRotateWithSystem() {
        return this.mRotateWithSystem;
    }

    public boolean isShowFullAnimation() {
        return this.mShowFullAnimation;
    }

    public boolean isVerticalFullByVideoSize() {
        return isVerticalVideo() && isAutoFullWithSize();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004f A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isVerticalVideo() {
        /*
            r6 = this;
            int r0 = r6.getCurrentVideoHeight()
            int r1 = r6.getCurrentVideoWidth()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "GSYVideoBase isVerticalVideo  videoHeight "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " videoWidth "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "GSYVideoBase isVerticalVideo  mRotate "
            r2.append(r3)
            int r3 = r6.mRotate
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r2)
            r2 = 0
            if (r0 <= 0) goto L_0x0054
            if (r1 <= 0) goto L_0x0054
            int r3 = r6.mRotate
            r4 = 90
            r5 = 1
            if (r3 == r4) goto L_0x0051
            int r3 = r6.mRotate
            r4 = 270(0x10e, float:3.78E-43)
            if (r3 != r4) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            if (r0 <= r1) goto L_0x0054
        L_0x004f:
            r2 = 1
            goto L_0x0054
        L_0x0051:
            if (r1 <= r0) goto L_0x0054
            goto L_0x004f
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer.isVerticalVideo():boolean");
    }

    /* access modifiers changed from: protected */
    public void lockTouchLogic() {
        boolean z2;
        OrientationUtils orientationUtils;
        super.lockTouchLogic();
        if (!this.mLockCurScreen) {
            orientationUtils = this.mOrientationUtils;
            if (orientationUtils != null) {
                z2 = isRotateViewAuto();
            } else {
                return;
            }
        } else {
            orientationUtils = this.mOrientationUtils;
            if (orientationUtils != null) {
                z2 = false;
            } else {
                return;
            }
        }
        orientationUtils.setEnable(z2);
    }

    public void onBackFullscreen() {
        clearFullscreenLayout();
    }

    public void onConfigurationChanged(Activity activity, Configuration configuration, OrientationUtils orientationUtils) {
        onConfigurationChanged(activity, configuration, orientationUtils, true, true);
    }

    public void onConfigurationChanged(Activity activity, Configuration configuration, OrientationUtils orientationUtils, boolean z2, boolean z3) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 2) {
            if (isIfCurrentIsFullscreen() && !isVerticalFullByVideoSize()) {
                backFromFull(activity);
            }
            if (orientationUtils != null) {
                orientationUtils.setEnable(true);
            }
        } else if (!isIfCurrentIsFullscreen()) {
            startWindowFullscreen(activity, z2, z3);
        }
    }

    public void onInfo(int i2, int i3) {
        super.onInfo(i2, i3);
        if (i2 == getGSYVideoManager().getRotateInfoFlag()) {
            checkAutoFullSizeWhenFull();
        }
    }

    public void onPrepared() {
        super.onPrepared();
        checkAutoFullSizeWhenFull();
    }

    /* access modifiers changed from: protected */
    public void resolveFullVideoShow(Context context, GSYBaseVideoPlayer gSYBaseVideoPlayer, FrameLayout frameLayout) {
        OrientationUtils orientationUtils;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gSYBaseVideoPlayer.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.gravity = 17;
        gSYBaseVideoPlayer.setLayoutParams(layoutParams);
        gSYBaseVideoPlayer.setIfCurrentIsFullscreen(true);
        OrientationUtils orientationUtils2 = new OrientationUtils((Activity) context, gSYBaseVideoPlayer, getOrientationOption());
        this.mOrientationUtils = orientationUtils2;
        orientationUtils2.setEnable(isRotateViewAuto());
        this.mOrientationUtils.setRotateWithSystem(this.mRotateWithSystem);
        this.mOrientationUtils.setOnlyRotateLand(this.mIsOnlyRotateLand);
        gSYBaseVideoPlayer.mOrientationUtils = this.mOrientationUtils;
        final boolean isVerticalFullByVideoSize = isVerticalFullByVideoSize();
        final boolean isLockLandByAutoFullSize = isLockLandByAutoFullSize();
        if (isShowFullAnimation()) {
            final GSYBaseVideoPlayer gSYBaseVideoPlayer2 = gSYBaseVideoPlayer;
            final FrameLayout frameLayout2 = frameLayout;
            this.mInnerHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!isVerticalFullByVideoSize && isLockLandByAutoFullSize && GSYBaseVideoPlayer.this.mOrientationUtils != null && GSYBaseVideoPlayer.this.mOrientationUtils.getIsLand() != 1) {
                        GSYBaseVideoPlayer.this.mOrientationUtils.resolveByClick();
                    }
                    gSYBaseVideoPlayer2.setVisibility(0);
                    frameLayout2.setVisibility(0);
                }
            }, 300);
        } else {
            if (!isVerticalFullByVideoSize && isLockLandByAutoFullSize && (orientationUtils = this.mOrientationUtils) != null) {
                orientationUtils.resolveByClick();
            }
            gSYBaseVideoPlayer.setVisibility(0);
            frameLayout.setVisibility(0);
        }
        if (this.mVideoAllCallBack != null) {
            Debuger.printfError("onEnterFullscreen");
            this.mVideoAllCallBack.onEnterFullscreen(this.mOriginUrl, this.mTitle, gSYBaseVideoPlayer);
        }
        this.mIfCurrentIsFullscreen = true;
        checkoutState();
        checkAutoFullWithSizeAndAdaptation(gSYBaseVideoPlayer);
    }

    /* access modifiers changed from: protected */
    public void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer) {
        if (!(view == null || view.getParent() == null)) {
            viewGroup.removeView((ViewGroup) view.getParent());
        }
        this.mCurrentState = getGSYVideoManager().getLastState();
        if (gSYVideoPlayer != null) {
            cloneParams(gSYVideoPlayer, this);
        }
        if (!(this.mCurrentState == 0 && this.mCurrentState == 6)) {
            createNetWorkState();
        }
        getGSYVideoManager().setListener(getGSYVideoManager().lastListener());
        getGSYVideoManager().setLastListener((a) null);
        setStateAndUi(this.mCurrentState);
        addTextureView();
        this.mSaveChangeViewTIme = System.currentTimeMillis();
        if (this.mVideoAllCallBack != null) {
            Debuger.printfError("onQuitFullscreen");
            this.mVideoAllCallBack.onQuitFullscreen(this.mOriginUrl, this.mTitle, this);
        }
        this.mIfCurrentIsFullscreen = false;
        if (this.mHideKey) {
            CommonUtil.showNavKey(this.mContext, this.mSystemUiVisibility);
        }
        CommonUtil.showSupportActionBar(this.mContext, this.mActionBar, this.mStatusBar);
        if (getFullscreenButton() != null) {
            getFullscreenButton().setImageResource(getEnlargeImageRes());
        }
    }

    public void setAutoFullWithSize(boolean z2) {
        this.mAutoFullWithSize = z2;
    }

    public void setBackFromFullScreenListener(View.OnClickListener onClickListener) {
        this.mBackFromFullScreenListener = onClickListener;
    }

    public void setFullHideActionBar(boolean z2) {
        this.mActionBar = z2;
    }

    public void setFullHideStatusBar(boolean z2) {
        this.mStatusBar = z2;
    }

    public void setLockLand(boolean z2) {
        this.mLockLand = z2;
    }

    public void setNeedAutoAdaptation(boolean z2) {
        this.isNeedAutoAdaptation = z2;
    }

    public void setOnlyRotateLand(boolean z2) {
        this.mIsOnlyRotateLand = z2;
        OrientationUtils orientationUtils = this.mOrientationUtils;
        if (orientationUtils != null) {
            orientationUtils.setOnlyRotateLand(z2);
        }
    }

    public void setRotateViewAuto(boolean z2) {
        this.mRotateViewAuto = z2;
        OrientationUtils orientationUtils = this.mOrientationUtils;
        if (orientationUtils != null) {
            orientationUtils.setEnable(z2);
        }
    }

    public void setRotateWithSystem(boolean z2) {
        this.mRotateWithSystem = z2;
        OrientationUtils orientationUtils = this.mOrientationUtils;
        if (orientationUtils != null) {
            orientationUtils.setRotateWithSystem(z2);
        }
    }

    public void setSaveBeforeFullSystemUiVisibility(int i2) {
        this.mSystemUiVisibility = i2;
    }

    public void setShowFullAnimation(boolean z2) {
        this.mShowFullAnimation = z2;
    }

    /* access modifiers changed from: protected */
    public void setSmallVideoTextureView() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setOnTouchListener((View.OnTouchListener) null);
            this.mProgressBar.setVisibility(4);
        }
        if (this.mFullscreenButton != null) {
            this.mFullscreenButton.setOnTouchListener((View.OnTouchListener) null);
            this.mFullscreenButton.setVisibility(4);
        }
        if (this.mCurrentTimeTextView != null) {
            this.mCurrentTimeTextView.setVisibility(4);
        }
        if (this.mTextureViewContainer != null) {
            this.mTextureViewContainer.setOnClickListener((View.OnClickListener) null);
        }
        View view = this.mSmallClose;
        if (view != null) {
            view.setVisibility(0);
            this.mSmallClose.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GSYBaseVideoPlayer.this.hideSmallVideo();
                    GSYBaseVideoPlayer.this.releaseVideos();
                }
            });
        }
    }

    public GSYBaseVideoPlayer showSmallVideo(Point point, boolean z2, boolean z3) {
        ViewGroup viewGroup = getViewGroup();
        removeVideo(viewGroup, getSmallId());
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        try {
            GSYBaseVideoPlayer gSYBaseVideoPlayer = (GSYBaseVideoPlayer) getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getActivityContext()});
            gSYBaseVideoPlayer.setId(getSmallId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(point.x, point.y);
            int screenWidth = CommonUtil.getScreenWidth(this.mContext) - point.x;
            int screenHeight = CommonUtil.getScreenHeight(this.mContext) - point.y;
            if (z2) {
                screenHeight -= CommonUtil.getActionBarHeight((Activity) this.mContext);
            }
            if (z3) {
                screenHeight -= CommonUtil.getStatusBarHeight(this.mContext);
            }
            layoutParams2.setMargins(screenWidth, screenHeight, 0, 0);
            frameLayout.addView(gSYBaseVideoPlayer, layoutParams2);
            viewGroup.addView(frameLayout, layoutParams);
            cloneParams(this, gSYBaseVideoPlayer);
            gSYBaseVideoPlayer.setIsTouchWiget(false);
            gSYBaseVideoPlayer.addTextureView();
            gSYBaseVideoPlayer.onClickUiToggle();
            gSYBaseVideoPlayer.setVideoAllCallBack(this.mVideoAllCallBack);
            gSYBaseVideoPlayer.setSmallVideoTextureView(new jn.a(gSYBaseVideoPlayer, screenWidth, screenHeight));
            getGSYVideoManager().setLastListener(this);
            getGSYVideoManager().setListener(gSYBaseVideoPlayer);
            if (this.mVideoAllCallBack != null) {
                Debuger.printfError("onEnterSmallWidget");
                this.mVideoAllCallBack.onEnterSmallWidget(this.mOriginUrl, this.mTitle, gSYBaseVideoPlayer);
            }
            return gSYBaseVideoPlayer;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z2, boolean z3) {
        boolean z4;
        Object newInstance;
        this.mSystemUiVisibility = ((Activity) context).getWindow().getDecorView().getSystemUiVisibility();
        CommonUtil.hideSupportActionBar(context, z2, z3);
        if (this.mHideKey) {
            CommonUtil.hideNavKey(context);
        }
        this.mActionBar = z2;
        this.mStatusBar = z3;
        this.mListItemRect = new int[2];
        this.mListItemSize = new int[2];
        final ViewGroup viewGroup = getViewGroup();
        removeVideo(viewGroup, getFullId());
        pauseFullCoverLogic();
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        saveLocationStatus(context, z3, z2);
        cancelProgressTimer();
        try {
            getClass().getConstructor(new Class[]{Context.class, Boolean.class});
            z4 = true;
        } catch (Exception unused) {
            z4 = false;
        }
        if (!z4) {
            try {
                newInstance = getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            newInstance = getClass().getConstructor(new Class[]{Context.class, Boolean.class}).newInstance(new Object[]{this.mContext, true});
        }
        GSYBaseVideoPlayer gSYBaseVideoPlayer = (GSYBaseVideoPlayer) newInstance;
        gSYBaseVideoPlayer.setId(getFullId());
        gSYBaseVideoPlayer.setIfCurrentIsFullscreen(true);
        gSYBaseVideoPlayer.setVideoAllCallBack(this.mVideoAllCallBack);
        cloneParams(this, gSYBaseVideoPlayer);
        if (gSYBaseVideoPlayer.getFullscreenButton() != null) {
            gSYBaseVideoPlayer.getFullscreenButton().setImageResource(getShrinkImageRes());
            gSYBaseVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (GSYBaseVideoPlayer.this.mBackFromFullScreenListener == null) {
                        GSYBaseVideoPlayer.this.clearFullscreenLayout();
                    } else {
                        GSYBaseVideoPlayer.this.mBackFromFullScreenListener.onClick(view);
                    }
                }
            });
        }
        if (gSYBaseVideoPlayer.getBackButton() != null) {
            gSYBaseVideoPlayer.getBackButton().setVisibility(0);
            gSYBaseVideoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (GSYBaseVideoPlayer.this.mBackFromFullScreenListener == null) {
                        GSYBaseVideoPlayer.this.clearFullscreenLayout();
                    } else {
                        GSYBaseVideoPlayer.this.mBackFromFullScreenListener.onClick(view);
                    }
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        final FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(-16777216);
        if (this.mShowFullAnimation) {
            this.mFullAnimEnd = false;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(getWidth(), getHeight());
            int[] iArr = this.mListItemRect;
            layoutParams2.setMargins(iArr[0], iArr[1], 0, 0);
            frameLayout.addView(gSYBaseVideoPlayer, layoutParams2);
            viewGroup.addView(frameLayout, layoutParams);
            final Context context2 = context;
            final GSYBaseVideoPlayer gSYBaseVideoPlayer2 = gSYBaseVideoPlayer;
            this.mInnerHandler.postDelayed(new Runnable() {
                public void run() {
                    e.a(viewGroup);
                    GSYBaseVideoPlayer.this.resolveFullVideoShow(context2, gSYBaseVideoPlayer2, frameLayout);
                    GSYBaseVideoPlayer.this.mFullAnimEnd = true;
                }
            }, 300);
        } else {
            frameLayout.addView(gSYBaseVideoPlayer, new FrameLayout.LayoutParams(getWidth(), getHeight()));
            viewGroup.addView(frameLayout, layoutParams);
            gSYBaseVideoPlayer.setVisibility(4);
            frameLayout.setVisibility(4);
            resolveFullVideoShow(context, gSYBaseVideoPlayer, frameLayout);
        }
        gSYBaseVideoPlayer.addTextureView();
        gSYBaseVideoPlayer.startProgressTimer();
        getGSYVideoManager().setLastListener(this);
        getGSYVideoManager().setListener(gSYBaseVideoPlayer);
        checkoutState();
        return gSYBaseVideoPlayer;
    }
}
