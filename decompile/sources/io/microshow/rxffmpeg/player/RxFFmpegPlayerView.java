package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.microshow.rxffmpeg.player.MeasureHelper;
import java.lang.ref.WeakReference;

public class RxFFmpegPlayerView extends FrameLayout {
    public static final int MODE_FULL_SCREEN = 1;
    public static final int MODE_NORMAL = 0;
    /* access modifiers changed from: private */
    public FrameLayout mContainer;
    private Context mContext;
    /* access modifiers changed from: private */
    public int mCurrentMode;
    /* access modifiers changed from: private */
    public MeasureHelper mMeasureHelper;
    public BaseMediaPlayer mPlayer;
    private RxFFmpegPlayerController mPlayerController;
    public PlayerCoreType mPlayerCoreType;
    /* access modifiers changed from: private */
    public TextureView mTextureView;

    public enum PlayerCoreType {
        PCT_RXFFMPEG_PLAYER,
        PCT_SYSTEM_MEDIA_PLAYER
    }

    public static class VideoSizeChangedListener implements IMediaPlayer.OnVideoSizeChangedListener {
        private WeakReference<RxFFmpegPlayerView> mWeakReference;

        VideoSizeChangedListener(RxFFmpegPlayerView rxFFmpegPlayerView) {
            this.mWeakReference = new WeakReference<>(rxFFmpegPlayerView);
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, float f2) {
            RxFFmpegPlayerView rxFFmpegPlayerView = (RxFFmpegPlayerView) this.mWeakReference.get();
            if (rxFFmpegPlayerView != null) {
                rxFFmpegPlayerView.updateVideoLayoutParams(i2, i3, f2);
            }
        }
    }

    public RxFFmpegPlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RxFFmpegPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayerCoreType = PlayerCoreType.PCT_RXFFMPEG_PLAYER;
        this.mCurrentMode = 0;
        this.mContext = context;
        this.mMeasureHelper = new MeasureHelper(this) {
            public boolean isFullScreen() {
                return RxFFmpegPlayerView.this.mCurrentMode == 1;
            }
        };
        initContainer();
        setKeepScreenOn(true);
    }

    private void addTextureView() {
        this.mContainer.removeView(this.mTextureView);
        this.mContainer.addView(this.mTextureView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void initContainer() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initPlayer() {
        if (this.mTextureView == null) {
            this.mTextureView = new ScaleTextureView(this.mContext);
        }
        this.mPlayer = this.mPlayerCoreType == PlayerCoreType.PCT_SYSTEM_MEDIA_PLAYER ? new SystemMediaPlayerImpl() : new RxFFmpegPlayerImpl();
        this.mPlayer.setTextureView(this.mTextureView);
        this.mPlayer.setOnVideoSizeChangedListener(new VideoSizeChangedListener(this));
    }

    /* access modifiers changed from: private */
    public void updateVideoLayoutParams(final int i2, final int i3, final float f2) {
        post(new Runnable() {
            public void run() {
                RxFFmpegPlayerView.this.mMeasureHelper.setVideoSizeInfo(new MeasureHelper.VideoSizeInfo(i2, i3, f2));
                RxFFmpegPlayerView.this.mMeasureHelper.setVideoLayoutParams(RxFFmpegPlayerView.this.mTextureView, RxFFmpegPlayerView.this.mContainer);
            }
        });
    }

    public boolean enterFullScreen() {
        ViewGroup fullScreen;
        if (this.mCurrentMode == 1 || (fullScreen = Helper.setFullScreen(this.mContext, true)) == null) {
            return false;
        }
        removeView(this.mContainer);
        fullScreen.addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mCurrentMode = 1;
        return true;
    }

    public boolean exitFullScreen() {
        ViewGroup fullScreen;
        if (this.mCurrentMode != 1 || (fullScreen = Helper.setFullScreen(this.mContext, false)) == null) {
            return false;
        }
        fullScreen.removeView(this.mContainer);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mCurrentMode = 0;
        return false;
    }

    public FrameLayout getContainerView() {
        return this.mContainer;
    }

    public int getMuteSolo() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer == null || baseMediaPlayer.getMuteSolo() == -1) {
            return 0;
        }
        return this.mPlayer.getMuteSolo();
    }

    public TextureView getTextureView() {
        return this.mTextureView;
    }

    public int getVolume() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer == null || baseMediaPlayer.getVolume() == -1) {
            return 100;
        }
        return this.mPlayer.getVolume();
    }

    public boolean isFullScreenModel() {
        return this.mCurrentMode == 1;
    }

    public boolean isLooping() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        return baseMediaPlayer != null && baseMediaPlayer.isLooping();
    }

    public boolean isPlaying() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        return baseMediaPlayer != null && baseMediaPlayer.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MeasureHelper measureHelper = this.mMeasureHelper;
        if (measureHelper != null) {
            measureHelper.setVideoLayoutParams(this.mTextureView, this.mContainer);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int[] doMeasure = this.mMeasureHelper.doMeasure(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(doMeasure[0], doMeasure[1]);
    }

    public void pause() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.pause();
            RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
            if (rxFFmpegPlayerController != null) {
                rxFFmpegPlayerController.onPause();
            }
        }
    }

    public void play(String str, boolean z2) {
        if (this.mPlayer != null && !Helper.isFastClick()) {
            this.mPlayer.play(str, z2);
            RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
            if (rxFFmpegPlayerController != null) {
                rxFFmpegPlayerController.onResume();
            }
        }
    }

    public void release() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.release();
            this.mPlayer = null;
        }
        setKeepScreenOn(false);
    }

    public void repeatPlay() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.repeatPlay();
        }
    }

    public void resume() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.resume();
            RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
            if (rxFFmpegPlayerController != null) {
                rxFFmpegPlayerController.onResume();
            }
        }
    }

    public void setController(RxFFmpegPlayerController rxFFmpegPlayerController, MeasureHelper.FitModel fitModel) {
        initPlayer();
        setFitModel(fitModel);
        this.mContainer.removeView(this.mPlayerController);
        this.mPlayerController = rxFFmpegPlayerController;
        rxFFmpegPlayerController.setPlayerView(this);
        this.mContainer.addView(this.mPlayerController, new FrameLayout.LayoutParams(-1, -1));
        addTextureView();
    }

    public void setFitModel(MeasureHelper.FitModel fitModel) {
        MeasureHelper measureHelper = this.mMeasureHelper;
        if (measureHelper != null && fitModel != null) {
            measureHelper.setFitModel(fitModel);
            this.mMeasureHelper.setDefaultVideoLayoutParams();
        }
    }

    public void setMuteSolo(int i2) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setMuteSolo(i2);
        }
    }

    public void setOnCompleteListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setOnCompleteListener(onCompletionListener);
        }
    }

    public void setPlayerBackgroundColor(int i2) {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(i2);
        }
    }

    public void setTextureViewEnabledTouch(boolean z2) {
        TextureView textureView = this.mTextureView;
        if (textureView != null && (textureView instanceof ScaleTextureView)) {
            ((ScaleTextureView) textureView).setEnabledTouch(z2);
        }
    }

    public void setVolume(int i2) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setVolume(i2);
        }
    }

    public void switchPlayerCore(PlayerCoreType playerCoreType) {
        this.mPlayerCoreType = playerCoreType;
    }

    public boolean switchScreen() {
        return isFullScreenModel() ? exitFullScreen() : enterFullScreen();
    }
}
