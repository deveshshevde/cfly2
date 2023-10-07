package com.xeagle.android.login.common;

import android.net.Uri;
import android.view.Surface;
import com.xeagle.android.login.common.GLVideoView;
import java.util.LinkedList;
import java.util.List;

public class GLVideoModel implements GLVideoView.Callback {
    private static final int sPhysicalAvailable = 2;
    private static final int sPhysicalDestroy = 1;
    private static final int sPlayerComplete = 6;
    private static final int sPlayerError = 4;
    private static final int sPlayerLoading = 5;
    private static final int sPlayerPaused = 3;
    private static final int sPlayerPlay = 2;
    private static final int sPlayerStop = 1;
    private static final int sUserPaused = 1;
    private static final int sUserPlaying = 2;
    private static final int sUserStop = 3;
    private GLVideoView attachedVideoView;
    private Callback callback;
    private int current;
    private int duration;
    private long feedDuration;
    private List<ModelObserver> observers = new LinkedList();
    private int physicalStatus = 1;
    private int playerStatus = 1;
    private final Uri uri;
    private int userStatus = 3;
    private int videoWidth = -1;
    private int viewHeight = -1;

    public interface Callback {
        void onModelTextureAvailable(GLVideoModel gLVideoModel, Surface surface);

        void onModelTextureDestroy(GLVideoModel gLVideoModel);

        void onNeedPause();

        void onNeedPlay(int i2);

        void onNeedStart();

        void onNeedStop();
    }

    public interface ModelObserver {
        void onModelChanged(GLVideoModel gLVideoModel);
    }

    public GLVideoModel(Uri uri2, long j2) {
        this.uri = uri2;
        this.feedDuration = j2;
    }

    private void mergePlayerStatus() {
        Callback callback2;
        Callback callback3;
        int i2 = this.playerStatus;
        if ((i2 == 4 || i2 == 5) && (this.userStatus == 3 || this.physicalStatus == 1)) {
            Callback callback4 = this.callback;
            if (callback4 != null) {
                callback4.onNeedStop();
            }
        } else if (i2 == 3 && this.userStatus == 3) {
            Callback callback5 = this.callback;
            if (callback5 != null) {
                callback5.onNeedStop();
            }
        } else {
            if (i2 == 2) {
                int i3 = this.userStatus;
                if (i3 == 1 || this.physicalStatus == 1) {
                    Callback callback6 = this.callback;
                    if (callback6 != null) {
                        callback6.onNeedPause();
                        return;
                    }
                    return;
                } else if (i3 == 3) {
                    Callback callback7 = this.callback;
                    if (callback7 != null) {
                        callback7.onNeedPause();
                        this.callback.onNeedStop();
                        return;
                    }
                    return;
                }
            }
            if ((i2 == 3 || i2 == 6) && this.userStatus == 2 && this.physicalStatus == 2 && (callback3 = this.callback) != null) {
                callback3.onNeedStart();
            } else if ((i2 == 4 || i2 == 1) && this.userStatus == 2 && this.physicalStatus == 2 && (callback2 = this.callback) != null) {
                callback2.onNeedPlay(this.current);
            }
        }
    }

    private void physicalChanged() {
        mergePlayerStatus();
    }

    private boolean setPlayerStatus(int i2) {
        if (this.playerStatus == i2) {
            return false;
        }
        this.playerStatus = i2;
        notifyModelChanged();
        return true;
    }

    private void userChanged() {
        mergePlayerStatus();
    }

    public void addObserver(ModelObserver modelObserver) {
        this.observers.add(modelObserver);
    }

    public void attachVideoView(GLVideoView gLVideoView) {
        GLVideoView gLVideoView2 = this.attachedVideoView;
        if (gLVideoView != gLVideoView2) {
            if (gLVideoView2 != null) {
                gLVideoView2.setCallback((GLVideoView.Callback) null);
                this.attachedVideoView = null;
            }
            this.attachedVideoView = gLVideoView;
        }
    }

    public void fireAttachSurface() {
        GLVideoView gLVideoView = this.attachedVideoView;
        if (gLVideoView != null) {
            gLVideoView.setCallback(this);
        }
    }

    public int getCurrent() {
        return this.current;
    }

    public long getDuration() {
        long j2 = this.feedDuration;
        return j2 != 0 ? j2 : (long) this.duration;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public boolean isPlayerComplete() {
        return this.playerStatus == 6;
    }

    public boolean isPlayerError() {
        return this.playerStatus == 4;
    }

    public boolean isPlayerLoading() {
        return this.playerStatus == 5;
    }

    public boolean isPlayerPaused() {
        return this.playerStatus == 3;
    }

    public boolean isPlayerPlay() {
        return this.playerStatus == 2;
    }

    public boolean isPlayerStopped() {
        return this.playerStatus == 1;
    }

    public boolean isSurfaceAvailable() {
        return 2 == this.physicalStatus;
    }

    public void notifyModelChanged() {
        for (ModelObserver onModelChanged : this.observers) {
            onModelChanged.onModelChanged(this);
        }
    }

    public void onSurfaceAvailable(Surface surface) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onModelTextureAvailable(this, surface);
        }
        physicalPlay();
    }

    public void onSurfaceDestroyed() {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onModelTextureDestroy(this);
        }
        physicalPause();
        userPause();
    }

    public void physicalPause() {
        if (this.physicalStatus == 2) {
            this.physicalStatus = 1;
            physicalChanged();
        }
    }

    public void physicalPlay() {
        if (this.physicalStatus == 1) {
            this.physicalStatus = 2;
            physicalChanged();
        }
    }

    public void removeObserver(ModelObserver modelObserver) {
        this.observers.remove(modelObserver);
    }

    public void removeObservers() {
        this.observers.clear();
    }

    public void reset() {
        this.userStatus = 3;
        this.playerStatus = 1;
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void setPlayCurrent(int i2) {
        this.current = i2;
    }

    public void setPlayDuration(int i2) {
        this.duration = i2;
    }

    public void setPlayerComplete() {
        if (setPlayerStatus(6)) {
            userPause();
        }
    }

    public void setPlayerError() {
        if (setPlayerStatus(4)) {
            userStop();
        }
    }

    public void setPlayerLoading() {
        setPlayerStatus(5);
    }

    public void setPlayerPaused() {
        setPlayerStatus(3);
    }

    public void setPlayerPlay() {
        setPlayerStatus(2);
    }

    public void setPlayerStop() {
        setPlayerStatus(1);
    }

    public void setVideoSize(int i2, int i3) {
        if (i2 != this.videoWidth || i3 != this.viewHeight) {
            this.videoWidth = i2;
            this.viewHeight = i3;
            notifyModelChanged();
        }
    }

    public void userPause() {
        if (this.userStatus != 1) {
            this.userStatus = 1;
            userChanged();
        }
    }

    public void userPlay() {
        if (this.userStatus != 2) {
            this.userStatus = 2;
        }
        userChanged();
    }

    public void userStop() {
        if (this.userStatus != 3) {
            this.userStatus = 3;
        }
        userChanged();
    }
}
