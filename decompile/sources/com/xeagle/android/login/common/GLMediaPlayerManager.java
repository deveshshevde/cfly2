package com.xeagle.android.login.common;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.xeagle.android.login.common.GLMediaPlayer;
import com.xeagle.android.login.common.GLVideoModel;

public class GLMediaPlayerManager implements GLMediaPlayer.PlayerObserver, GLVideoModel.Callback {
    private static final String TAG = "YXMediaPlayerManager";
    private GLVideoModel attachedVideoModel;
    private Context context;
    private PlayInfoListener listener;
    private Handler mainHandler = new Handler();
    private GLMediaPlayer mediaPlayer;

    public interface PlayInfoListener {
        void playInfoListener(int i2, int i3);
    }

    private void ensurePlayer() {
        if (this.mediaPlayer == null) {
            GLMediaPlayer gLMediaPlayer = new GLMediaPlayer(this.mainHandler);
            this.mediaPlayer = gLMediaPlayer;
            gLMediaPlayer.create();
            this.mediaPlayer.addObserver(this);
        }
    }

    private void pause() {
        if (this.attachedVideoModel != null) {
            ensurePlayer();
            this.mediaPlayer.pause();
        }
    }

    private void start() {
        if (this.attachedVideoModel != null) {
            ensurePlayer();
            this.mediaPlayer.start();
        }
    }

    private void stop() {
        if (this.attachedVideoModel != null) {
            ensurePlayer();
            this.mediaPlayer.pause();
            this.mediaPlayer.stop();
        }
    }

    public void attach(Context context2, GLVideoModel gLVideoModel) {
        this.context = context2;
        ensurePlayer();
        GLVideoModel gLVideoModel2 = this.attachedVideoModel;
        if (gLVideoModel2 == gLVideoModel) {
            gLVideoModel2.userPlay();
            return;
        }
        detach();
        this.attachedVideoModel = gLVideoModel;
        gLVideoModel.reset();
        gLVideoModel.setCallback(this);
        gLVideoModel.fireAttachSurface();
        gLVideoModel.userPlay();
    }

    public void detach() {
        GLVideoModel gLVideoModel = this.attachedVideoModel;
        if (gLVideoModel != null) {
            gLVideoModel.userStop();
            this.attachedVideoModel.setCallback((GLVideoModel.Callback) null);
        }
        this.attachedVideoModel = null;
    }

    public void onModelTextureAvailable(GLVideoModel gLVideoModel, Surface surface) {
        ensurePlayer();
        this.mediaPlayer.setSurface(surface);
        GLVideoModel gLVideoModel2 = this.attachedVideoModel;
        if (gLVideoModel2 != null) {
            gLVideoModel2.physicalPlay();
        }
    }

    public void onModelTextureDestroy(GLVideoModel gLVideoModel) {
        ensurePlayer();
        this.mediaPlayer.setSurface((Surface) null);
        GLVideoModel gLVideoModel2 = this.attachedVideoModel;
        if (gLVideoModel2 != null) {
            gLVideoModel2.physicalPause();
        }
    }

    public void onNeedPause() {
        pause();
    }

    public void onNeedPlay(int i2) {
        play(i2);
    }

    public void onNeedStart() {
        start();
    }

    public void onNeedStop() {
        stop();
    }

    public void onPlayProgressChanged(int i2, int i3) {
        GLVideoModel gLVideoModel = this.attachedVideoModel;
        if (gLVideoModel != null) {
            gLVideoModel.setPlayCurrent(i2);
            this.attachedVideoModel.setPlayDuration(i3);
            this.attachedVideoModel.notifyModelChanged();
        }
        PlayInfoListener playInfoListener = this.listener;
        if (playInfoListener != null) {
            playInfoListener.playInfoListener(i2, i3);
        }
    }

    public void onPlaySizeChanged(int i2, int i3) {
        GLVideoModel gLVideoModel = this.attachedVideoModel;
        if (gLVideoModel != null) {
            gLVideoModel.setVideoSize(i2, i3);
        }
    }

    public void onPlayStateChanged(int i2) {
        GLVideoModel gLVideoModel;
        Log.i(TAG, "YXMediaPlayerManager onStateChanged:" + i2);
        if (i2 != 0) {
            if (i2 != 4) {
                if (i2 == 16) {
                    GLVideoModel gLVideoModel2 = this.attachedVideoModel;
                    if (gLVideoModel2 != null) {
                        gLVideoModel2.setPlayerPlay();
                        return;
                    }
                    return;
                } else if (i2 != 32) {
                    if (i2 != 64) {
                        if (i2 == 128) {
                            gLVideoModel = this.attachedVideoModel;
                            if (gLVideoModel == null) {
                                return;
                            }
                        } else if (i2 == 256) {
                            GLVideoModel gLVideoModel3 = this.attachedVideoModel;
                            if (gLVideoModel3 != null) {
                                gLVideoModel3.setPlayCurrent(0);
                                this.attachedVideoModel.setPlayerComplete();
                                return;
                            }
                            return;
                        } else if (i2 == 512) {
                            this.mediaPlayer.removeObservers();
                            this.mediaPlayer.destroy();
                            this.mediaPlayer = null;
                            gLVideoModel = this.attachedVideoModel;
                            if (gLVideoModel == null) {
                                return;
                            }
                        } else {
                            return;
                        }
                        gLVideoModel.setPlayCurrent(0);
                        this.attachedVideoModel.setPlayerStop();
                        return;
                    }
                    GLVideoModel gLVideoModel4 = this.attachedVideoModel;
                    if (gLVideoModel4 != null) {
                        gLVideoModel4.setPlayerPaused();
                        return;
                    }
                    return;
                }
            }
            GLVideoModel gLVideoModel5 = this.attachedVideoModel;
            if (gLVideoModel5 != null) {
                gLVideoModel5.setPlayerLoading();
                return;
            }
            return;
        }
        GLVideoModel gLVideoModel6 = this.attachedVideoModel;
        if (gLVideoModel6 != null) {
            if (!gLVideoModel6.isPlayerPlay()) {
                this.attachedVideoModel.isPlayerLoading();
            }
            this.mediaPlayer.reset();
            this.attachedVideoModel.setPlayerError();
        }
    }

    public void play(int i2) {
        if (this.attachedVideoModel != null) {
            ensurePlayer();
            this.mediaPlayer.stop();
            this.mediaPlayer.reset();
            this.mediaPlayer.setDataSource(this.context, this.attachedVideoModel.getUri());
            this.mediaPlayer.pendingSeek(i2);
            this.mediaPlayer.prepare();
        }
    }

    public void setPlayInfoListener(PlayInfoListener playInfoListener) {
        this.listener = playInfoListener;
    }
}
