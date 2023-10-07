package com.shuyu.gsyvideoplayer.video.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.NetInfoModule;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import jg.a;
import jg.i;

public abstract class GSYVideoView extends GSYTextureRenderView implements a {
    public static final int CHANGE_DELAY_TIME = 2000;
    public static final int CURRENT_STATE_AUTO_COMPLETE = 6;
    public static final int CURRENT_STATE_ERROR = 7;
    public static final int CURRENT_STATE_NORMAL = 0;
    public static final int CURRENT_STATE_PAUSE = 5;
    public static final int CURRENT_STATE_PLAYING = 2;
    public static final int CURRENT_STATE_PLAYING_BUFFERING_START = 3;
    public static final int CURRENT_STATE_PREPAREING = 1;
    protected int mBackUpPlayingBufferState = -1;
    protected int mBufferPoint;
    protected boolean mCache = false;
    protected File mCachePath;
    protected Context mContext;
    protected long mCurrentPosition;
    protected int mCurrentState = -1;
    protected boolean mHadPlay = false;
    protected boolean mHadPrepared = false;
    protected boolean mIfCurrentIsFullscreen = false;
    protected boolean mLooping = false;
    protected Map<String, String> mMapHeadData = new HashMap();
    protected boolean mNetChanged = false;
    protected NetInfoModule mNetInfoModule;
    protected String mNetSate = "NORMAL";
    protected String mOriginUrl;
    protected String mOverrideExtension;
    protected boolean mPauseBeforePrepared = false;
    protected int mPlayPosition = -22;
    protected String mPlayTag = "";
    protected long mSaveChangeViewTIme = 0;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected long mSeekOnStart = -1;
    protected boolean mShowPauseCover = false;
    protected boolean mSoundTouch = false;
    protected float mSpeed = 1.0f;
    protected boolean mStartAfterPrepared = true;
    protected String mTitle;
    protected String mUrl;
    protected i mVideoAllCallBack;
    private int mVideoSarDen;
    private int mVideoSarNum;
    protected AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i2) {
            if (i2 == -3) {
                GSYVideoView.this.onLossTransientCanDuck();
            } else if (i2 == -2) {
                GSYVideoView.this.onLossTransientAudio();
            } else if (i2 == -1) {
                GSYVideoView.this.onLossAudio();
            } else if (i2 == 1) {
                GSYVideoView.this.onGankAudio();
            }
        }
    };
    protected long time = 0;

    public GSYVideoView(Context context) {
        super(context);
        init(context);
    }

    public GSYVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GSYVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    public GSYVideoView(Context context, Boolean bool) {
        super(context);
        this.mIfCurrentIsFullscreen = bool.booleanValue();
        init(context);
    }

    /* access modifiers changed from: protected */
    public abstract boolean backFromFull(Context context);

    public void clearCurrentCache() {
        Context context;
        GSYVideoViewBridge gSYVideoViewBridge;
        if (!getGSYVideoManager().isCacheFile() || !this.mCache) {
            String str = this.mUrl;
            if (str != null && str.contains("127.0.0.1")) {
                gSYVideoViewBridge = getGSYVideoManager();
                context = getContext();
                gSYVideoViewBridge.clearCache(context, this.mCachePath, this.mOriginUrl);
            }
        } else {
            Debuger.printfError("Play Error " + this.mUrl);
            this.mUrl = this.mOriginUrl;
        }
        gSYVideoViewBridge = getGSYVideoManager();
        context = this.mContext;
        gSYVideoViewBridge.clearCache(context, this.mCachePath, this.mOriginUrl);
    }

    /* access modifiers changed from: protected */
    public void createNetWorkState() {
        if (this.mNetInfoModule == null) {
            NetInfoModule netInfoModule = new NetInfoModule(this.mContext.getApplicationContext(), new NetInfoModule.NetChangeListener() {
                public void changed(String str) {
                    if (!GSYVideoView.this.mNetSate.equals(str)) {
                        Debuger.printfError("******* change network state ******* " + str);
                        GSYVideoView.this.mNetChanged = true;
                    }
                    GSYVideoView.this.mNetSate = str;
                }
            });
            this.mNetInfoModule = netInfoModule;
            this.mNetSate = netInfoModule.getCurrentConnectionType();
        }
    }

    /* access modifiers changed from: protected */
    public void deleteCacheFileWhenError() {
        clearCurrentCache();
        Debuger.printfError("Link Or mCache Error, Please Try Again " + this.mOriginUrl);
        if (this.mCache) {
            Debuger.printfError("mCache Link " + this.mUrl);
        }
        this.mUrl = this.mOriginUrl;
    }

    public abstract void firstFrameDetect(int i2, int i3);

    public void flushQueue() {
        getGSYVideoManager().flushQueue();
    }

    /* access modifiers changed from: protected */
    public Context getActivityContext() {
        return CommonUtil.getActivityContext(getContext());
    }

    public int getBuffterPoint() {
        return this.mBufferPoint;
    }

    public boolean getCurrentBitmap(Bitmap bitmap) {
        return getGSYVideoManager().getCurrentBitmap(bitmap);
    }

    public int getCurrentFrame(String str) {
        return getGSYVideoManager().getCurrentFrame(str);
    }

    public int getCurrentPositionWhenPlaying() {
        int i2 = this.mCurrentState;
        int i3 = 0;
        if (i2 == 2 || i2 == 5) {
            try {
                i3 = (int) getGSYVideoManager().getCurrentPosition();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        if (i3 == 0) {
            long j2 = this.mCurrentPosition;
            if (j2 > 0) {
                return (int) j2;
            }
        }
        return i3;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public int getCurrentVideoHeight() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoHeight();
        }
        return 0;
    }

    public int getCurrentVideoWidth() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoWidth();
        }
        return 0;
    }

    public float getDecodeFps() {
        return getGSYVideoManager().getDecodeFps();
    }

    public int getDuration() {
        try {
            int duration = (int) getGSYVideoManager().getDuration();
            return duration == 0 ? (int) this.time : duration;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public abstract GSYVideoViewBridge getGSYVideoManager();

    public abstract int getLayoutId();

    public Map<String, String> getMapHeadData() {
        return this.mMapHeadData;
    }

    public long getNetSpeed() {
        return getGSYVideoManager().getNetSpeed();
    }

    public String getNetSpeedText() {
        return CommonUtil.getTextSpeed(getNetSpeed());
    }

    public float getOutputFps() {
        return getGSYVideoManager().getOutputFps();
    }

    public String getOverrideExtension() {
        return this.mOverrideExtension;
    }

    public int getPlayPosition() {
        return this.mPlayPosition;
    }

    public String getPlayTag() {
        return this.mPlayTag;
    }

    public float getPlayingSpeed() {
        return getGSYVideoManager() != null ? getGSYVideoManager().getSpeed(this.mSpeed) : this.mSpeed;
    }

    public long getSeekOnStart() {
        return this.mSeekOnStart;
    }

    public float getSpeed() {
        return getGSYVideoManager() != null ? getGSYVideoManager().getSpeed(this.mSpeed) : this.mSpeed;
    }

    public long getVideoCachedBytes() {
        return getGSYVideoManager().getVideoCahcedBytes();
    }

    public long getVideoCachedDuration() {
        return getGSYVideoManager().getVideoCachedDuration();
    }

    public int getVideoSarDen() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoSarDen();
        }
        return 0;
    }

    public int getVideoSarNum() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoSarNum();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        if (getActivityContext() != null) {
            context = getActivityContext();
        }
        this.mContext = context;
        initInflate(this.mContext);
        this.mTextureViewContainer = (ViewGroup) findViewById(R.id.surface_container);
        if (!isInEditMode()) {
            this.mScreenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
            this.mScreenHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
    }

    /* access modifiers changed from: protected */
    public void initInflate(Context context) {
        try {
            View.inflate(context, getLayoutId(), this);
        } catch (InflateException e2) {
            if (!e2.toString().contains("GSYImageCover")) {
                e2.printStackTrace();
                return;
            }
            Debuger.printfError("********************\n*****   注意   *************************\n*该版本需要清除布局文件中的GSYImageCover\n****  Attention  ***\n*Please remove GSYImageCover from Layout in this Version\n********************\n");
            e2.printStackTrace();
            throw new InflateException("该版本需要清除布局文件中的GSYImageCover，please remove GSYImageCover from your layout");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCurrentMediaListener() {
        return getGSYVideoManager().listener() != null && getGSYVideoManager().listener() == this;
    }

    public boolean isIfCurrentIsFullscreen() {
        return this.mIfCurrentIsFullscreen;
    }

    public boolean isInPlayingState() {
        int i2 = this.mCurrentState;
        return (i2 < 0 || i2 == 0 || i2 == 6 || i2 == 7) ? false : true;
    }

    public int isLocalRecording() {
        return getGSYVideoManager().isLocalRecording();
    }

    public boolean isLooping() {
        return this.mLooping;
    }

    public boolean isShowPauseCover() {
        return this.mShowPauseCover;
    }

    public boolean isStartAfterPrepared() {
        return this.mStartAfterPrepared;
    }

    /* access modifiers changed from: protected */
    public void listenerNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostResume();
        }
    }

    /* access modifiers changed from: protected */
    public void netWorkErrorLogic() {
        final long currentPositionWhenPlaying = (long) getCurrentPositionWhenPlaying();
        Debuger.printfError("******* Net State Changed. renew player to connect *******" + currentPositionWhenPlaying);
        getGSYVideoManager().releaseMediaPlayer();
        postDelayed(new Runnable() {
            public void run() {
                GSYVideoView.this.setSeekOnStart(currentPositionWhenPlaying);
                GSYVideoView.this.startPlayLogic();
            }
        }, 500);
    }

    public void onAutoCompletion() {
        setStateAndUi(6);
        this.mSaveChangeViewTIme = 0;
        this.mCurrentPosition = 0;
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        if (!this.mIfCurrentIsFullscreen) {
            getGSYVideoManager().setLastListener((a) null);
        }
        releaseNetWorkState();
        if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            Debuger.printfLog("onAutoComplete");
            this.mVideoAllCallBack.onAutoComplete(this.mOriginUrl, this.mTitle, this);
        }
        this.mHadPlay = false;
    }

    public void onCompletion() {
        setStateAndUi(0);
        this.mSaveChangeViewTIme = 0;
        this.mCurrentPosition = 0;
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        if (!this.mIfCurrentIsFullscreen) {
            getGSYVideoManager().setListener((a) null);
            getGSYVideoManager().setLastListener((a) null);
        }
        getGSYVideoManager().setCurrentVideoHeight(0);
        getGSYVideoManager().setCurrentVideoWidth(0);
        releaseNetWorkState();
        this.mHadPlay = false;
    }

    public void onError(int i2, int i3) {
        Log.i("CmdChannel", "onError: ---what--" + i2 + "--extra--" + i3);
        if (this.mNetChanged) {
            this.mNetChanged = false;
            netWorkErrorLogic();
            i iVar = this.mVideoAllCallBack;
            if (iVar != null) {
                iVar.onPlayError(this.mOriginUrl, this.mTitle, this);
            }
        } else if (i2 != 38 && i2 != -38) {
            setStateAndUi(7);
            deleteCacheFileWhenError();
            i iVar2 = this.mVideoAllCallBack;
            if (iVar2 != null) {
                iVar2.onPlayError(this.mOriginUrl, this.mTitle, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onGankAudio() {
    }

    public void onInfo(int i2, int i3) {
        int i4;
        if (i2 == 701) {
            int i5 = this.mCurrentState;
            this.mBackUpPlayingBufferState = i5;
            if (this.mHadPlay && i5 != 1 && i5 > 0) {
                setStateAndUi(3);
            }
        } else if (i2 == 702) {
            int i6 = this.mBackUpPlayingBufferState;
            if (i6 != -1) {
                if (i6 == 3) {
                    this.mBackUpPlayingBufferState = 2;
                }
                if (this.mHadPlay && (i4 = this.mCurrentState) != 1 && i4 > 0) {
                    setStateAndUi(this.mBackUpPlayingBufferState);
                }
                this.mBackUpPlayingBufferState = -1;
            }
        } else if (i2 == getGSYVideoManager().getRotateInfoFlag()) {
            this.mRotate = i3;
            Debuger.printfLog("Video Rotate Info " + i3);
            if (this.mTextureView != null) {
                this.mTextureView.setRotation((float) this.mRotate);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLossAudio() {
    }

    /* access modifiers changed from: protected */
    public void onLossTransientAudio() {
        try {
            onVideoPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onLossTransientCanDuck() {
    }

    public void onPrepared() {
        if (this.mCurrentState == 1) {
            this.mHadPrepared = true;
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                Debuger.printfLog("onPrepared");
                this.mVideoAllCallBack.onPrepared(this.mOriginUrl, this.mTitle, this);
            }
            if (!this.mStartAfterPrepared) {
                setStateAndUi(5);
                onVideoPause();
                return;
            }
            startAfterPrepared();
        }
    }

    public void onSeekComplete() {
        Debuger.printfLog("onSeekComplete");
    }

    public void onVideoPause() {
        Log.i("CmdChannel", "onVideoPause:----- ");
        if (this.mCurrentState == 1) {
            this.mPauseBeforePrepared = true;
        }
        try {
            if (getGSYVideoManager() != null && getGSYVideoManager().isPlaying()) {
                setStateAndUi(5);
                this.mCurrentPosition = getGSYVideoManager().getCurrentPosition();
                if (getGSYVideoManager() != null) {
                    getGSYVideoManager().pause();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onVideoReset() {
        setStateAndUi(0);
    }

    public void onVideoResume() {
        onVideoResume(true);
    }

    public void onVideoResume(boolean z2) {
        this.mPauseBeforePrepared = false;
        if (this.mCurrentState == 5) {
            try {
                if (this.mCurrentPosition >= 0 && getGSYVideoManager() != null) {
                    if (z2) {
                        getGSYVideoManager().seekTo(this.mCurrentPosition);
                    }
                    getGSYVideoManager().start();
                    setStateAndUi(2);
                    this.mCurrentPosition = 0;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onVideoSizeChanged() {
        int currentVideoWidth = getGSYVideoManager().getCurrentVideoWidth();
        int currentVideoHeight = getGSYVideoManager().getCurrentVideoHeight();
        firstFrameDetect(currentVideoWidth, currentVideoHeight);
        if (currentVideoWidth != 0 && currentVideoHeight != 0 && this.mTextureView != null) {
            this.mTextureView.requestLayout();
        }
    }

    public void pauseLocalRecord() {
        getGSYVideoManager().pauseLocalRecord();
    }

    /* access modifiers changed from: protected */
    public void prepareVideo() {
        startPrepare();
    }

    public void release() {
        this.mSaveChangeViewTIme = 0;
        if (isCurrentMediaListener() && System.currentTimeMillis() - this.mSaveChangeViewTIme > 2000) {
            releaseVideos();
        }
    }

    /* access modifiers changed from: protected */
    public void releaseNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostPause();
            this.mNetInfoModule = null;
        }
    }

    public void releasePauseCover() {
        try {
            if (this.mCurrentState != 5 && this.mFullPauseBitmap != null && !this.mFullPauseBitmap.isRecycled() && this.mShowPauseCover) {
                this.mFullPauseBitmap.recycle();
                this.mFullPauseBitmap = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void releaseSurface(Surface surface) {
        getGSYVideoManager().releaseSurface(surface);
    }

    public void releaseVideoCache() {
        releaseVideosCache();
    }

    /* access modifiers changed from: protected */
    public abstract void releaseVideos();

    /* access modifiers changed from: protected */
    public abstract void releaseVideosCache();

    public void resumeLocalRecord() {
        getGSYVideoManager().resumeLocalRecord();
    }

    public void seekTo(long j2) {
        try {
            if (getGSYVideoManager() != null && j2 > 0) {
                getGSYVideoManager().seekTo(j2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setDisplay(Surface surface) {
        getGSYVideoManager().setDisplay(surface);
    }

    public void setDuration(long j2) {
        this.time = j2;
        getGSYVideoManager().setDuration(j2);
    }

    public void setIfCurrentIsFullscreen(boolean z2) {
        this.mIfCurrentIsFullscreen = z2;
    }

    public void setLooping(boolean z2) {
        this.mLooping = z2;
    }

    public void setMapHeadData(Map<String, String> map) {
        if (map != null) {
            this.mMapHeadData = map;
        }
    }

    public void setOverrideExtension(String str) {
        this.mOverrideExtension = str;
    }

    public void setPlayPosition(int i2) {
        this.mPlayPosition = i2;
    }

    public void setPlayTag(String str) {
        this.mPlayTag = str;
    }

    public void setReleaseWhenLossAudio(boolean z2) {
    }

    public void setSeekOnStart(long j2) {
        this.mSeekOnStart = j2;
    }

    public void setShowPauseCover(boolean z2) {
        this.mShowPauseCover = z2;
    }

    public void setSpeed(float f2) {
        setSpeed(f2, false);
    }

    public void setSpeed(float f2, boolean z2) {
        this.mSpeed = f2;
        this.mSoundTouch = z2;
        if (getGSYVideoManager() != null) {
            getGSYVideoManager().setSpeed(f2, z2);
        }
    }

    public void setSpeedPlaying(float f2, boolean z2) {
        setSpeed(f2, z2);
        getGSYVideoManager().setSpeedPlaying(f2, z2);
    }

    public void setStartAfterPrepared(boolean z2) {
        this.mStartAfterPrepared = z2;
    }

    /* access modifiers changed from: protected */
    public abstract void setStateAndUi(int i2);

    public boolean setUp(String str, boolean z2, File file, String str2) {
        return setUp(str, z2, file, str2, true);
    }

    /* access modifiers changed from: protected */
    public boolean setUp(String str, boolean z2, File file, String str2, boolean z3) {
        this.mCache = z2;
        this.mCachePath = file;
        this.mOriginUrl = str;
        if (isCurrentMediaListener() && System.currentTimeMillis() - this.mSaveChangeViewTIme < 2000) {
            return false;
        }
        this.mCurrentState = 0;
        this.mUrl = str;
        this.mTitle = str2;
        if (!z3) {
            return true;
        }
        setStateAndUi(0);
        return true;
    }

    public boolean setUp(String str, boolean z2, File file, Map<String, String> map, String str2) {
        if (!setUp(str, z2, file, str2)) {
            return false;
        }
        Map<String, String> map2 = this.mMapHeadData;
        if (map2 != null) {
            map2.clear();
        } else {
            this.mMapHeadData = new HashMap();
        }
        if (map == null) {
            return true;
        }
        this.mMapHeadData.putAll(map);
        return true;
    }

    public boolean setUp(String str, boolean z2, String str2) {
        return setUp(str, z2, (File) null, str2);
    }

    public void setVideoAllCallBack(i iVar) {
        this.mVideoAllCallBack = iVar;
    }

    public void showPauseCover() {
        if (this.mCurrentState == 5 && this.mFullPauseBitmap != null && !this.mFullPauseBitmap.isRecycled() && this.mShowPauseCover && this.mSurface != null && this.mSurface.isValid() && getGSYVideoManager().isSurfaceSupportLockCanvas()) {
            try {
                RectF rectF = new RectF(0.0f, 0.0f, (float) this.mTextureView.getWidth(), (float) this.mTextureView.getHeight());
                Canvas lockCanvas = this.mSurface.lockCanvas(new Rect(0, 0, this.mTextureView.getWidth(), this.mTextureView.getHeight()));
                if (lockCanvas != null) {
                    lockCanvas.drawBitmap(this.mFullPauseBitmap, (Rect) null, rectF, (Paint) null);
                    this.mSurface.unlockCanvasAndPost(lockCanvas);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void startAfterPrepared() {
        if (!this.mHadPrepared) {
            prepareVideo();
        }
        try {
            if (getGSYVideoManager() != null) {
                getGSYVideoManager().start();
            }
            setStateAndUi(2);
            if (getGSYVideoManager() != null && this.mSeekOnStart > 0) {
                getGSYVideoManager().seekTo(this.mSeekOnStart);
                this.mSeekOnStart = 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        addTextureView();
        createNetWorkState();
        listenerNetWorkState();
        this.mHadPlay = true;
        if (this.mTextureView != null) {
            this.mTextureView.onResume();
        }
        if (this.mPauseBeforePrepared) {
            onVideoPause();
            this.mPauseBeforePrepared = false;
        }
    }

    /* access modifiers changed from: protected */
    public void startButtonLogic() {
        int i2;
        i iVar = this.mVideoAllCallBack;
        if (iVar != null && ((i2 = this.mCurrentState) == 0 || i2 == 6)) {
            Debuger.printfLog("onClickStartIcon");
            this.mVideoAllCallBack.onClickStartIcon(this.mOriginUrl, this.mTitle, this);
        } else if (iVar != null) {
            Debuger.printfLog("onClickStartError");
            this.mVideoAllCallBack.onClickStartError(this.mOriginUrl, this.mTitle, this);
        }
        prepareVideo();
    }

    public int startLocalRecord(String str) {
        return getGSYVideoManager().startLocalRecord(str);
    }

    public abstract void startPlayLogic();

    /* access modifiers changed from: protected */
    public void startPrepare() {
        if (getGSYVideoManager().listener() != null) {
            getGSYVideoManager().listener().onCompletion();
        }
        if (this.mVideoAllCallBack != null) {
            Debuger.printfLog("onStartPrepared");
            this.mVideoAllCallBack.onStartPrepared(this.mOriginUrl, this.mTitle, this);
        }
        getGSYVideoManager().setListener(this);
        getGSYVideoManager().setPlayTag(this.mPlayTag);
        getGSYVideoManager().setPlayPosition(this.mPlayPosition);
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).getWindow().addFlags(128);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mBackUpPlayingBufferState = -1;
        GSYVideoViewBridge gSYVideoManager = getGSYVideoManager();
        String str = this.mUrl;
        Map map = this.mMapHeadData;
        if (map == null) {
            map = new HashMap();
        }
        gSYVideoManager.prepare(str, map, this.mLooping, this.mSpeed, this.mCache, this.mCachePath, this.mOverrideExtension);
        setStateAndUi(1);
    }

    public int stopLocalRecord() {
        return getGSYVideoManager().stopLocalRecord();
    }

    /* access modifiers changed from: protected */
    public void unListenerNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostPause();
        }
    }

    /* access modifiers changed from: protected */
    public void updatePauseCover() {
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
