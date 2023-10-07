package jg;

public interface a {
    void onAutoCompletion();

    void onBackFullscreen();

    void onBufferingUpdate(int i2);

    void onCompletion();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onPrepared();

    void onSeekComplete();

    void onVideoPause();

    void onVideoResume();

    void onVideoResume(boolean z2);

    void onVideoSizeChanged();
}
