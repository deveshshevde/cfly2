package io.microshow.rxffmpeg.player;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.reactivex.disposables.a;
import io.reactivex.disposables.b;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lv.d;

public abstract class SystemMediaPlayer extends BaseMediaPlayer {
    private a mCompositeDisposable = new a();
    public MediaPlayer mMediaPlayer = new MediaPlayer();
    private b mTimeUpdateDisposable;
    protected String path;
    public int volumePercent = -1;

    private void cancelTimeUpdateDisposable() {
        b bVar = this.mTimeUpdateDisposable;
        if (bVar != null && !bVar.isDisposed()) {
            this.mTimeUpdateDisposable.dispose();
        }
    }

    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    public int getMuteSolo() {
        return 0;
    }

    public int getVolume() {
        return this.volumePercent;
    }

    public boolean isLooping() {
        return this.mMediaPlayer.isLooping();
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public void pause() {
        this.mMediaPlayer.pause();
        cancelTimeUpdateDisposable();
    }

    public void prepare() {
        this.mMediaPlayer.prepareAsync();
    }

    public void release() {
        setOnPreparedListener((IMediaPlayer.OnPreparedListener) null);
        setOnVideoSizeChangedListener((IMediaPlayer.OnVideoSizeChangedListener) null);
        setOnLoadingListener((IMediaPlayer.OnLoadingListener) null);
        setOnTimeUpdateListener((IMediaPlayer.OnTimeUpdateListener) null);
        setOnErrorListener((IMediaPlayer.OnErrorListener) null);
        setOnCompleteListener((IMediaPlayer.OnCompletionListener) null);
        cancelTimeUpdateDisposable();
        a aVar = this.mCompositeDisposable;
        if (aVar != null) {
            aVar.a();
            this.mCompositeDisposable = null;
        }
        this.mMediaPlayer.release();
    }

    public void repeatPlay() {
        play(this.path, this.mMediaPlayer.isLooping());
    }

    public void resume() {
        start();
    }

    public void seekTo(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mMediaPlayer.seekTo((long) i2, 3);
        } else {
            this.mMediaPlayer.seekTo(i2);
        }
    }

    public void setDataSource(String str) {
        try {
            this.path = str;
            this.mMediaPlayer.setDataSource(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setLooping(boolean z2) {
        this.mMediaPlayer.setLooping(z2);
    }

    public void setMuteSolo(int i2) {
    }

    public void setOnCompleteListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompleteListener(onCompletionListener);
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                IMediaPlayer.OnCompletionListener onCompletionListener = onCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(SystemMediaPlayer.this);
                }
            }
        });
    }

    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                IMediaPlayer.OnErrorListener onErrorListener = onErrorListener;
                if (onErrorListener == null || i2 == -38) {
                    return true;
                }
                SystemMediaPlayer systemMediaPlayer = SystemMediaPlayer.this;
                onErrorListener.onError(systemMediaPlayer, i2, i3 + "");
                return true;
            }
        });
    }

    public void setOnLoadingListener(IMediaPlayer.OnLoadingListener onLoadingListener) {
        super.setOnLoadingListener(onLoadingListener);
    }

    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                IMediaPlayer.OnPreparedListener onPreparedListener = onPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(SystemMediaPlayer.this);
                }
            }
        });
    }

    public void setOnTimeUpdateListener(IMediaPlayer.OnTimeUpdateListener onTimeUpdateListener) {
        super.setOnTimeUpdateListener(onTimeUpdateListener);
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (i2 == 3 || i2 == 700) {
                    if (SystemMediaPlayer.this.mOnLoadingListener != null) {
                        SystemMediaPlayer.this.mOnLoadingListener.onLoading(SystemMediaPlayer.this, false);
                    }
                    return true;
                } else if (i2 != 701) {
                    return false;
                } else {
                    if (SystemMediaPlayer.this.mOnLoadingListener != null) {
                        SystemMediaPlayer.this.mOnLoadingListener.onLoading(SystemMediaPlayer.this, true);
                    }
                    return true;
                }
            }
        });
    }

    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = onVideoSizeChangedListener;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(SystemMediaPlayer.this, i2, i3, ((float) i2) / ((float) i3));
                }
            }
        });
    }

    public void setSurface(Surface surface) {
        if (surface != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }

    public void setVolume(int i2) {
        this.volumePercent = i2;
        float f2 = ((float) i2) / 100.0f;
        this.mMediaPlayer.setVolume(f2, f2);
    }

    public void start() {
        this.mMediaPlayer.start();
        startTimeUpdateDisposable();
    }

    public void startTimeUpdateDisposable() {
        cancelTimeUpdateDisposable();
        b a2 = io.reactivex.b.a(200, TimeUnit.MILLISECONDS).b(lz.a.b()).a(lu.a.a()).a(new d<Long>() {
            public void accept(Long l2) throws Exception {
                if (SystemMediaPlayer.this.mOnTimeUpdateListener != null) {
                    IMediaPlayer.OnTimeUpdateListener onTimeUpdateListener = SystemMediaPlayer.this.mOnTimeUpdateListener;
                    SystemMediaPlayer systemMediaPlayer = SystemMediaPlayer.this;
                    onTimeUpdateListener.onTimeUpdate(systemMediaPlayer, systemMediaPlayer.mMediaPlayer.getCurrentPosition() / 1000, SystemMediaPlayer.this.getDuration() / 1000);
                }
            }
        });
        this.mTimeUpdateDisposable = a2;
        this.mCompositeDisposable.a(a2);
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }
}
