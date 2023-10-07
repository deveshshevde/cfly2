package io.microshow.rxffmpeg.player;

import android.view.Surface;

public interface IMediaPlayer {

    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    public interface OnErrorListener {
        void onError(IMediaPlayer iMediaPlayer, int i2, String str);
    }

    public interface OnLoadingListener {
        void onLoading(IMediaPlayer iMediaPlayer, boolean z2);
    }

    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    public interface OnTimeUpdateListener {
        void onTimeUpdate(IMediaPlayer iMediaPlayer, int i2, int i3);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, float f2);
    }

    int getDuration();

    int getMuteSolo();

    int getVolume();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    void prepare();

    void release();

    void resume();

    void seekTo(int i2);

    void setDataSource(String str);

    void setLooping(boolean z2);

    void setMuteSolo(int i2);

    void setSurface(Surface surface);

    void setVolume(int i2);

    void start();

    void stop();
}
