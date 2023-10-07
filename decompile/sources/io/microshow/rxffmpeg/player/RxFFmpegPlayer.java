package io.microshow.rxffmpeg.player;

import android.text.TextUtils;
import android.view.Surface;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.reactivex.disposables.a;
import io.reactivex.disposables.b;
import java.util.concurrent.TimeUnit;
import lv.d;

public abstract class RxFFmpegPlayer extends BaseMediaPlayer {
    protected boolean looping;
    private a mCompositeDisposable = new a();
    protected int mDuration = 0;
    private b mTimeDisposable;
    protected String path;

    static {
        System.loadLibrary("rxffmpeg-core");
        System.loadLibrary("rxffmpeg-player");
    }

    private void cancelTimeDisposable() {
        b bVar = this.mTimeDisposable;
        if (bVar != null && !bVar.isDisposed()) {
            this.mTimeDisposable.dispose();
        }
    }

    private native int nativeGetMuteSolo();

    private native int nativeGetVolume();

    private native boolean nativeIsPlaying();

    private native void nativePause();

    private native void nativePrepare(String str);

    private native void nativeRelease();

    private native void nativeResume();

    private native void nativeSeekTo(int i2);

    private native void nativeSetMuteSolo(int i2);

    private native void nativeSetSurface(Surface surface);

    private native void nativeSetVolume(int i2);

    private native void nativeStart();

    private native void nativeStop();

    public int getDuration() {
        return this.mDuration;
    }

    public int getMuteSolo() {
        return nativeGetMuteSolo();
    }

    public int getVolume() {
        return nativeGetVolume();
    }

    public boolean isLooping() {
        return this.looping;
    }

    public boolean isPlaying() {
        return nativeIsPlaying();
    }

    public void onCompletionNative() {
        if (this.mOnCompletionListener != null) {
            this.mOnCompletionListener.onCompletion(this);
        }
        if (isLooping()) {
            b a2 = io.reactivex.b.b(500, TimeUnit.MILLISECONDS).b(lz.a.b()).a(lu.a.a()).a(new d<Long>() {
                public void accept(Long l2) throws Exception {
                    RxFFmpegPlayer rxFFmpegPlayer = RxFFmpegPlayer.this;
                    rxFFmpegPlayer.play(rxFFmpegPlayer.path, RxFFmpegPlayer.this.looping);
                }
            });
            this.mTimeDisposable = a2;
            this.mCompositeDisposable.a(a2);
        }
    }

    public void onErrorNative(int i2, String str) {
        if (this.mOnErrorListener != null) {
            this.mOnErrorListener.onError(this, i2, str);
        }
    }

    public void onLoadingNative(boolean z2) {
        if (this.mOnLoadingListener != null) {
            this.mOnLoadingListener.onLoading(this, z2);
        }
    }

    public void onPreparedNative() {
        if (this.mOnPreparedListener != null) {
            this.mOnPreparedListener.onPrepared(this);
        }
    }

    public void onTimeUpdateNative(int i2, int i3) {
        if (this.mOnTimeUpdateListener != null) {
            this.mDuration = i3;
            this.mOnTimeUpdateListener.onTimeUpdate(this, i2, i3);
        }
    }

    public void onVideoSizeChangedNative(int i2, int i3, float f2) {
        if (this.mOnVideoSizeChangedListener != null) {
            this.mOnVideoSizeChangedListener.onVideoSizeChanged(this, i2, i3, f2);
        }
    }

    public void pause() {
        nativePause();
    }

    public void prepare() {
        if (!TextUtils.isEmpty(this.path)) {
            nativePrepare(this.path);
        }
    }

    public void release() {
        setOnPreparedListener((IMediaPlayer.OnPreparedListener) null);
        setOnVideoSizeChangedListener((IMediaPlayer.OnVideoSizeChangedListener) null);
        setOnLoadingListener((IMediaPlayer.OnLoadingListener) null);
        setOnTimeUpdateListener((IMediaPlayer.OnTimeUpdateListener) null);
        setOnErrorListener((IMediaPlayer.OnErrorListener) null);
        setOnCompleteListener((IMediaPlayer.OnCompletionListener) null);
        a aVar = this.mCompositeDisposable;
        if (aVar != null) {
            aVar.a();
            this.mCompositeDisposable = null;
        }
        nativeRelease();
    }

    public void repeatPlay() {
        play(this.path, this.looping);
    }

    public void resume() {
        nativeResume();
    }

    public void seekTo(int i2) {
        nativeSeekTo(i2);
    }

    public void setDataSource(String str) {
        this.path = str;
    }

    public void setLooping(boolean z2) {
        this.looping = z2;
    }

    public void setMuteSolo(int i2) {
        nativeSetMuteSolo(i2);
    }

    public void setSurface(Surface surface) {
        if (surface != null) {
            nativeSetSurface(surface);
        }
    }

    public void setVolume(int i2) {
        nativeSetVolume(i2);
    }

    public void start() {
        if (!TextUtils.isEmpty(this.path)) {
            nativeStart();
        }
    }

    public void stop() {
        cancelTimeDisposable();
        nativeStop();
    }
}
