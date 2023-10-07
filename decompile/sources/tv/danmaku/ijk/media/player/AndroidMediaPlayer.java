package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    private class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                AndroidMediaPlayer.this.notifyOnBufferingUpdate(i2);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                AndroidMediaPlayer.this.notifyOnCompletion();
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            return ((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null && AndroidMediaPlayer.this.notifyOnError(i2, i3);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return ((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null && AndroidMediaPlayer.this.notifyOnInfo(i2, i3);
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                AndroidMediaPlayer.this.notifyOnPrepared();
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                AndroidMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                IjkTimedText ijkTimedText = null;
                if (timedText != null) {
                    ijkTimedText = new IjkTimedText(timedText.getBounds(), timedText.getText());
                }
                AndroidMediaPlayer.this.notifyOnTimedText(ijkTimedText);
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null) {
                AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i2, i3, 1, 1);
            }
        }
    }

    private static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        public void close() throws IOException {
            this.mMediaDataSource.close();
        }

        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        public int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
            return this.mMediaDataSource.readAt(j2, bArr, i2, i3);
        }
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        try {
            return (long) this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return 0;
        }
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDuration() {
        try {
            return (long) this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return 0;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return false;
        }
    }

    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void seekTo(long j2) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j2);
    }

    public void setAudioStreamType(int i2) {
        this.mInternalMediaPlayer.setAudioStreamType(i2);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    public void setKeepInBackground(boolean z2) {
    }

    public void setLogEnabled(boolean z2) {
    }

    public void setLooping(boolean z2) {
        this.mInternalMediaPlayer.setLooping(z2);
    }

    public void setScreenOnWhilePlaying(boolean z2) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z2);
    }

    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f2, float f3) {
        this.mInternalMediaPlayer.setVolume(f2, f3);
    }

    public void setWakeMode(Context context, int i2) {
        this.mInternalMediaPlayer.setWakeMode(context, i2);
    }

    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }
}
