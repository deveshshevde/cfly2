package jd;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import java.io.File;
import java.util.Map;
import jg.c;
import jg.e;
import jg.h;
import jg.i;

public class a {
    protected boolean isShowDragProgressTextOnSeekBar = false;
    protected boolean mActionBar = false;
    protected boolean mAutoFullWithSize = false;
    protected Drawable mBottomProgressDrawable;
    protected Drawable mBottomShowProgressDrawable;
    protected Drawable mBottomShowProgressThumbDrawable;
    protected File mCachePath;
    protected boolean mCacheWithPlay;
    protected Drawable mDialogProgressBarDrawable;
    protected int mDialogProgressHighLightColor = -11;
    protected int mDialogProgressNormalColor = -11;
    protected int mDismissControlTime = 2500;
    protected GSYVideoGLView.a mEffectFilter = new jk.a();
    protected int mEnlargeImageRes = -1;
    protected c mGSYStateUiListener;
    protected e mGSYVideoProgressListener;
    protected boolean mHideKey = true;
    private boolean mIsOnlyRotateLand = false;
    protected boolean mIsTouchWiget = true;
    protected boolean mIsTouchWigetFull = true;
    protected h mLockClickListener;
    protected boolean mLockLand = false;
    protected boolean mLooping = false;
    protected Map<String, String> mMapHeadData;
    protected boolean mNeedLockFull;
    protected boolean mNeedShowWifiTip = true;
    protected String mOverrideExtension;
    protected int mPlayPosition = -22;
    protected String mPlayTag = "";
    protected boolean mReleaseWhenLossAudio = true;
    protected boolean mRotateViewAuto = true;
    protected boolean mRotateWithSystem = true;
    protected long mSeekOnStart = -1;
    protected float mSeekRatio = 1.0f;
    protected boolean mSetUpLazy = false;
    protected boolean mShowFullAnimation = true;
    protected boolean mShowPauseCover = true;
    protected int mShrinkImageRes = -1;
    protected boolean mSounchTouch;
    protected float mSpeed = 1.0f;
    protected boolean mStartAfterPrepared = true;
    protected boolean mStatusBar = false;
    protected View mThumbImageView;
    protected boolean mThumbPlay;
    protected String mUrl;
    protected i mVideoAllCallBack;
    protected String mVideoTitle = null;
    protected Drawable mVolumeProgressDrawable;

    public void build(StandardGSYVideoPlayer standardGSYVideoPlayer) {
        int i2;
        Drawable drawable;
        Drawable drawable2 = this.mBottomShowProgressDrawable;
        if (!(drawable2 == null || (drawable = this.mBottomShowProgressThumbDrawable) == null)) {
            standardGSYVideoPlayer.setBottomShowProgressBarDrawable(drawable2, drawable);
        }
        Drawable drawable3 = this.mBottomProgressDrawable;
        if (drawable3 != null) {
            standardGSYVideoPlayer.setBottomProgressBarDrawable(drawable3);
        }
        Drawable drawable4 = this.mVolumeProgressDrawable;
        if (drawable4 != null) {
            standardGSYVideoPlayer.setDialogVolumeProgressBar(drawable4);
        }
        Drawable drawable5 = this.mDialogProgressBarDrawable;
        if (drawable5 != null) {
            standardGSYVideoPlayer.setDialogProgressBar(drawable5);
        }
        int i3 = this.mDialogProgressHighLightColor;
        if (i3 > 0 && (i2 = this.mDialogProgressNormalColor) > 0) {
            standardGSYVideoPlayer.setDialogProgressColor(i3, i2);
        }
        build((GSYBaseVideoPlayer) standardGSYVideoPlayer);
    }

    public void build(GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        gSYBaseVideoPlayer.setPlayTag(this.mPlayTag);
        gSYBaseVideoPlayer.setPlayPosition(this.mPlayPosition);
        gSYBaseVideoPlayer.setThumbPlay(this.mThumbPlay);
        View view = this.mThumbImageView;
        if (view != null) {
            gSYBaseVideoPlayer.setThumbImageView(view);
        }
        gSYBaseVideoPlayer.setNeedLockFull(this.mNeedLockFull);
        h hVar = this.mLockClickListener;
        if (hVar != null) {
            gSYBaseVideoPlayer.setLockClickListener(hVar);
        }
        gSYBaseVideoPlayer.setDismissControlTime(this.mDismissControlTime);
        long j2 = this.mSeekOnStart;
        if (j2 > 0) {
            gSYBaseVideoPlayer.setSeekOnStart(j2);
        }
        gSYBaseVideoPlayer.setShowFullAnimation(this.mShowFullAnimation);
        gSYBaseVideoPlayer.setLooping(this.mLooping);
        i iVar = this.mVideoAllCallBack;
        if (iVar != null) {
            gSYBaseVideoPlayer.setVideoAllCallBack(iVar);
        }
        e eVar = this.mGSYVideoProgressListener;
        if (eVar != null) {
            gSYBaseVideoPlayer.setGSYVideoProgressListener(eVar);
        }
        c cVar = this.mGSYStateUiListener;
        if (cVar != null) {
            gSYBaseVideoPlayer.setGSYStateUiListener(cVar);
        }
        gSYBaseVideoPlayer.setOverrideExtension(this.mOverrideExtension);
        gSYBaseVideoPlayer.setAutoFullWithSize(this.mAutoFullWithSize);
        gSYBaseVideoPlayer.setRotateViewAuto(this.mRotateViewAuto);
        gSYBaseVideoPlayer.setOnlyRotateLand(this.mIsOnlyRotateLand);
        gSYBaseVideoPlayer.setLockLand(this.mLockLand);
        gSYBaseVideoPlayer.setSpeed(this.mSpeed, this.mSounchTouch);
        gSYBaseVideoPlayer.setHideKey(this.mHideKey);
        gSYBaseVideoPlayer.setIsTouchWiget(this.mIsTouchWiget);
        gSYBaseVideoPlayer.setIsTouchWigetFull(this.mIsTouchWigetFull);
        gSYBaseVideoPlayer.setNeedShowWifiTip(this.mNeedShowWifiTip);
        gSYBaseVideoPlayer.setEffectFilter(this.mEffectFilter);
        gSYBaseVideoPlayer.setStartAfterPrepared(this.mStartAfterPrepared);
        gSYBaseVideoPlayer.setFullHideActionBar(this.mActionBar);
        gSYBaseVideoPlayer.setShowDragProgressTextOnSeekBar(this.isShowDragProgressTextOnSeekBar);
        gSYBaseVideoPlayer.setFullHideStatusBar(this.mStatusBar);
        int i2 = this.mEnlargeImageRes;
        if (i2 > 0) {
            gSYBaseVideoPlayer.setEnlargeImageRes(i2);
        }
        int i3 = this.mShrinkImageRes;
        if (i3 > 0) {
            gSYBaseVideoPlayer.setShrinkImageRes(i3);
        }
        gSYBaseVideoPlayer.setShowPauseCover(this.mShowPauseCover);
        gSYBaseVideoPlayer.setSeekRatio(this.mSeekRatio);
        gSYBaseVideoPlayer.setRotateWithSystem(this.mRotateWithSystem);
        if (this.mSetUpLazy) {
            gSYBaseVideoPlayer.setUpLazy(this.mUrl, this.mCacheWithPlay, this.mCachePath, this.mMapHeadData, this.mVideoTitle);
            return;
        }
        gSYBaseVideoPlayer.setUp(this.mUrl, this.mCacheWithPlay, this.mCachePath, this.mMapHeadData, this.mVideoTitle);
    }

    public a setAutoFullWithSize(boolean z2) {
        this.mAutoFullWithSize = z2;
        return this;
    }

    public a setBottomProgressBarDrawable(Drawable drawable) {
        this.mBottomProgressDrawable = drawable;
        return this;
    }

    public a setBottomShowProgressBarDrawable(Drawable drawable, Drawable drawable2) {
        this.mBottomShowProgressDrawable = drawable;
        this.mBottomShowProgressThumbDrawable = drawable2;
        return this;
    }

    public a setCachePath(File file) {
        this.mCachePath = file;
        return this;
    }

    public a setCacheWithPlay(boolean z2) {
        this.mCacheWithPlay = z2;
        return this;
    }

    public a setDialogProgressBar(Drawable drawable) {
        this.mDialogProgressBarDrawable = drawable;
        return this;
    }

    public a setDialogProgressColor(int i2, int i3) {
        this.mDialogProgressHighLightColor = i2;
        this.mDialogProgressNormalColor = i3;
        return this;
    }

    public a setDialogVolumeProgressBar(Drawable drawable) {
        this.mVolumeProgressDrawable = drawable;
        return this;
    }

    public a setDismissControlTime(int i2) {
        this.mDismissControlTime = i2;
        return this;
    }

    public a setEffectFilter(GSYVideoGLView.a aVar) {
        this.mEffectFilter = aVar;
        return this;
    }

    public a setEnlargeImageRes(int i2) {
        this.mEnlargeImageRes = i2;
        return this;
    }

    public a setFullHideActionBar(boolean z2) {
        this.mActionBar = z2;
        return this;
    }

    public a setFullHideStatusBar(boolean z2) {
        this.mStatusBar = z2;
        return this;
    }

    public a setGSYStateUiListener(c cVar) {
        this.mGSYStateUiListener = cVar;
        return this;
    }

    public a setGSYVideoProgressListener(e eVar) {
        this.mGSYVideoProgressListener = eVar;
        return this;
    }

    public a setHideKey(boolean z2) {
        this.mHideKey = z2;
        return this;
    }

    public a setIsTouchWiget(boolean z2) {
        this.mIsTouchWiget = z2;
        return this;
    }

    public a setIsTouchWigetFull(boolean z2) {
        this.mIsTouchWigetFull = z2;
        return this;
    }

    public a setLockClickListener(h hVar) {
        this.mLockClickListener = hVar;
        return this;
    }

    public a setLockLand(boolean z2) {
        this.mLockLand = z2;
        return this;
    }

    public a setLooping(boolean z2) {
        this.mLooping = z2;
        return this;
    }

    public a setMapHeadData(Map<String, String> map) {
        this.mMapHeadData = map;
        return this;
    }

    public a setNeedLockFull(boolean z2) {
        this.mNeedLockFull = z2;
        return this;
    }

    public a setNeedShowWifiTip(boolean z2) {
        this.mNeedShowWifiTip = z2;
        return this;
    }

    public a setOnlyRotateLand(boolean z2) {
        this.mIsOnlyRotateLand = z2;
        return this;
    }

    public a setOverrideExtension(String str) {
        this.mOverrideExtension = str;
        return this;
    }

    public a setPlayPosition(int i2) {
        this.mPlayPosition = i2;
        return this;
    }

    public a setPlayTag(String str) {
        this.mPlayTag = str;
        return this;
    }

    public a setReleaseWhenLossAudio(boolean z2) {
        this.mReleaseWhenLossAudio = z2;
        return this;
    }

    public a setRotateViewAuto(boolean z2) {
        this.mRotateViewAuto = z2;
        return this;
    }

    public a setRotateWithSystem(boolean z2) {
        this.mRotateWithSystem = z2;
        return this;
    }

    public a setSeekOnStart(long j2) {
        this.mSeekOnStart = j2;
        return this;
    }

    public a setSeekRatio(float f2) {
        if (f2 < 0.0f) {
            return this;
        }
        this.mSeekRatio = f2;
        return this;
    }

    @Deprecated
    public a setSetUpLazy(boolean z2) {
        this.mSetUpLazy = z2;
        return this;
    }

    public a setShowDragProgressTextOnSeekBar(boolean z2) {
        this.isShowDragProgressTextOnSeekBar = z2;
        return this;
    }

    public a setShowFullAnimation(boolean z2) {
        this.mShowFullAnimation = z2;
        return this;
    }

    public a setShowPauseCover(boolean z2) {
        this.mShowPauseCover = z2;
        return this;
    }

    public a setShrinkImageRes(int i2) {
        this.mShrinkImageRes = i2;
        return this;
    }

    public a setSoundTouch(boolean z2) {
        this.mSounchTouch = z2;
        return this;
    }

    public a setSpeed(float f2) {
        this.mSpeed = f2;
        return this;
    }

    public a setStartAfterPrepared(boolean z2) {
        this.mStartAfterPrepared = z2;
        return this;
    }

    public a setThumbImageView(View view) {
        this.mThumbImageView = view;
        return this;
    }

    public a setThumbPlay(boolean z2) {
        this.mThumbPlay = z2;
        return this;
    }

    public a setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public a setVideoAllCallBack(i iVar) {
        this.mVideoAllCallBack = iVar;
        return this;
    }

    public a setVideoTitle(String str) {
        this.mVideoTitle = str;
        return this;
    }
}
