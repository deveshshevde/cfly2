package com.xeagle.android.login.common;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GLMediaPlayer {
    private static final String TAG = "YXMediaPlayer";
    /* access modifiers changed from: private */
    public Handler handler;
    private MediaPlayer mPlayer;
    /* access modifiers changed from: private */
    public int mStatus = -1;
    private List<PlayerObserver> observers = new LinkedList();
    /* access modifiers changed from: private */
    public int pendingSeek;
    /* access modifiers changed from: private */
    public int playerHeight;
    /* access modifiers changed from: private */
    public int playerWidth;
    /* access modifiers changed from: private */
    public Runnable progressRunnable = new Runnable() {
        public void run() {
            GLMediaPlayer.this.handler.removeCallbacks(GLMediaPlayer.this.progressRunnable);
            int access$200 = GLMediaPlayer.this.getCurrentPosition();
            int access$300 = GLMediaPlayer.this.getDuration();
            if (GLMediaPlayer.this.mStatus == 16) {
                GLMediaPlayer.this.notifyProgress(access$200, access$300);
                GLMediaPlayer.this.handler.postDelayed(GLMediaPlayer.this.progressRunnable, 500);
            }
        }
    };

    public interface PlayerObserver {
        void onPlayProgressChanged(int i2, int i3);

        void onPlaySizeChanged(int i2, int i3);

        void onPlayStateChanged(int i2);
    }

    public interface PlayerState {
        public static final int PLAYER_ERROR = 0;
        public static final int PLAYER_IDLE = 1;
        public static final int PLAYER_INIT = -1;
        public static final int PLAYER_INITIALIZED = 2;
        public static final int PLAYER_PAUSED = 64;
        public static final int PLAYER_PENDING_DESTROY = 512;
        public static final int PLAYER_PLAYBACK_COMPLETE = 256;
        public static final int PLAYER_PREPARED = 8;
        public static final int PLAYER_PREPARING = 4;
        public static final int PLAYER_SEEKING = 32;
        public static final int PLAYER_STARTED = 16;
        public static final int PLAYER_STOPPED = 128;
    }

    public GLMediaPlayer(Handler handler2) {
        this.handler = handler2;
    }

    /* access modifiers changed from: private */
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        int i2 = this.mStatus;
        if (i2 == 16 || i2 == 64 || i2 == 128 || i2 == 8 || i2 == 256) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int getDuration() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        int i2 = this.mStatus;
        if (i2 == 16 || i2 == 64 || i2 == 128 || i2 == 8 || i2 == 256) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void seekTo(int i2) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && this.mStatus == 4) {
            mediaPlayer.seekTo(i2);
        }
    }

    public void addObserver(PlayerObserver playerObserver) {
        this.observers.add(playerObserver);
    }

    public void create() {
        this.mStatus = -1;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mPlayer = mediaPlayer;
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (GLMediaPlayer.this.mStatus == 4) {
                    if (GLMediaPlayer.this.pendingSeek != 0) {
                        GLMediaPlayer gLMediaPlayer = GLMediaPlayer.this;
                        gLMediaPlayer.seekTo(gLMediaPlayer.pendingSeek);
                        return;
                    }
                    int unused = GLMediaPlayer.this.mStatus = 8;
                    GLMediaPlayer.this.notifyChanged();
                    GLMediaPlayer.this.start();
                } else if (GLMediaPlayer.this.mStatus == 512) {
                    GLMediaPlayer.this.destroy();
                }
            }
        });
        this.mPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                if (i2 != 0 && i3 != 0) {
                    if (GLMediaPlayer.this.playerWidth != i2 || GLMediaPlayer.this.playerHeight != i3) {
                        int unused = GLMediaPlayer.this.playerWidth = i2;
                        int unused2 = GLMediaPlayer.this.playerHeight = i3;
                        GLMediaPlayer gLMediaPlayer = GLMediaPlayer.this;
                        gLMediaPlayer.notifySizeChanged(gLMediaPlayer.playerWidth, GLMediaPlayer.this.playerHeight);
                    }
                }
            }
        });
        this.mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            }
        });
        this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                int unused = GLMediaPlayer.this.mStatus = 256;
                GLMediaPlayer.this.notifyChanged();
            }
        });
        this.mPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                if (GLMediaPlayer.this.mStatus == 4) {
                    int unused = GLMediaPlayer.this.pendingSeek = 0;
                    int unused2 = GLMediaPlayer.this.mStatus = 8;
                    GLMediaPlayer.this.notifyChanged();
                    GLMediaPlayer.this.start();
                } else if (GLMediaPlayer.this.mStatus == 512) {
                    GLMediaPlayer.this.destroy();
                }
            }
        });
        this.mPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                Log.i(GLMediaPlayer.TAG, "onInfo:" + i2 + ", extra:" + i3);
                return false;
            }
        });
        this.mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                Log.i(GLMediaPlayer.TAG, "onError:" + i2 + ", extra:" + i3);
                if (!(GLMediaPlayer.this.mStatus == 512 || GLMediaPlayer.this.mStatus == 0)) {
                    int unused = GLMediaPlayer.this.mStatus = 0;
                    GLMediaPlayer.this.notifyChanged();
                }
                return true;
            }
        });
    }

    public void destroy() {
        pause();
        stop();
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface((Surface) null);
            this.mPlayer.release();
        }
        this.mPlayer = null;
        this.mStatus = -1;
    }

    public MediaPlayer getPlayer() {
        return this.mPlayer;
    }

    public void notifyChanged() {
        for (PlayerObserver onPlayStateChanged : this.observers) {
            onPlayStateChanged.onPlayStateChanged(this.mStatus);
        }
    }

    public void notifyProgress(int i2, int i3) {
        for (PlayerObserver onPlayProgressChanged : this.observers) {
            onPlayProgressChanged.onPlayProgressChanged(i2, i3);
        }
    }

    public void notifySizeChanged(int i2, int i3) {
        for (PlayerObserver onPlaySizeChanged : this.observers) {
            onPlaySizeChanged.onPlaySizeChanged(i2, i3);
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && this.mStatus == 16) {
            mediaPlayer.pause();
            this.mStatus = 64;
            notifyChanged();
        }
    }

    public void pendingDestroy() {
        this.mStatus = 512;
        notifyChanged();
    }

    public void pendingSeek(int i2) {
        this.pendingSeek = i2;
    }

    public void prepare() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            int i2 = this.mStatus;
            if (i2 == 2 || i2 == 128) {
                mediaPlayer.prepareAsync();
                this.mStatus = 4;
                notifyChanged();
            }
        }
    }

    public void removeObserver(PlayerObserver playerObserver) {
        this.observers.remove(playerObserver);
    }

    public void removeObservers() {
        this.observers.clear();
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            int i2 = this.mStatus;
            if (i2 == 128 || i2 == 0 || i2 == -1) {
                mediaPlayer.reset();
                this.mStatus = 1;
                notifyChanged();
            }
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.mStatus == 1) {
            try {
                this.mPlayer.setDataSource(context, uri);
                this.mStatus = 2;
                notifyChanged();
            } catch (IOException e2) {
                e2.printStackTrace();
                this.mStatus = 0;
                notifyChanged();
            }
        }
    }

    public void setSurface(Surface surface) {
        if (getPlayer() != null) {
            getPlayer().setSurface(surface);
        }
    }

    public void start() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            int i2 = this.mStatus;
            if (i2 == 8 || i2 == 64 || i2 == 256) {
                mediaPlayer.start();
                this.mStatus = 16;
                notifyChanged();
                this.progressRunnable.run();
            }
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            int i2 = this.mStatus;
            if (i2 == 4) {
                pendingDestroy();
            } else if (i2 == 8 || i2 == 16 || i2 == 64 || i2 == 256) {
                mediaPlayer.stop();
                this.mStatus = 128;
                notifyChanged();
            }
        }
    }
}
