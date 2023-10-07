package com.shuyu.gsyvideoplayer.video.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import java.io.File;
import java.util.Map;
import jg.a;
import ji.c;

public interface GSYVideoViewBridge {
    boolean cachePreview(Context context, File file, String str);

    void clearCache(Context context, File file, String str);

    void flushQueue();

    int getBufferedPercentage();

    boolean getCurrentBitmap(Bitmap bitmap);

    int getCurrentFrame(String str);

    long getCurrentPosition();

    int getCurrentVideoHeight();

    int getCurrentVideoWidth();

    float getDecodeFps();

    long getDuration();

    int getLastState();

    long getNetSpeed();

    float getOutputFps();

    int getPlayPosition();

    String getPlayTag();

    c getPlayer();

    int getRotateInfoFlag();

    float getSpeed(float f2);

    long getVideoCachedDuration();

    long getVideoCahcedBytes();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    boolean isCacheFile();

    int isLocalRecording();

    boolean isPlaying();

    boolean isSurfaceSupportLockCanvas();

    a lastListener();

    a listener();

    void pause();

    void pauseLocalRecord();

    void prepare(String str, Map<String, String> map, boolean z2, float f2, boolean z3, File file);

    void prepare(String str, Map<String, String> map, boolean z2, float f2, boolean z3, File file, String str2);

    void releaseMediaPlayer();

    void releaseSurface(Surface surface);

    void releaseVideoCache();

    void resumeLocalRecord();

    void seekTo(long j2);

    void setCurrentVideoHeight(int i2);

    void setCurrentVideoWidth(int i2);

    void setDisplay(Surface surface);

    void setDuration(long j2);

    void setLastListener(a aVar);

    void setLastState(int i2);

    void setListener(a aVar);

    void setPlayPosition(int i2);

    void setPlayTag(String str);

    void setSpeed(float f2, boolean z2);

    void setSpeedPlaying(float f2, boolean z2);

    void start();

    int startLocalRecord(String str);

    void stop();

    int stopLocalRecord();
}
