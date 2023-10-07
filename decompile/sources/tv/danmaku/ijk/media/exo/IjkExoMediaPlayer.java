package tv.danmaku.ijk.media.exo;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer.util.Util;
import java.io.FileDescriptor;
import java.util.Map;
import tv.danmaku.ijk.media.exo.demo.EventLogger;
import tv.danmaku.ijk.media.exo.demo.SmoothStreamingTestMediaDrmCallback;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;
import tv.danmaku.ijk.media.exo.demo.player.ExtractorRendererBuilder;
import tv.danmaku.ijk.media.exo.demo.player.HlsRendererBuilder;
import tv.danmaku.ijk.media.exo.demo.player.SmoothStreamingRendererBuilder;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;

public class IjkExoMediaPlayer extends AbstractMediaPlayer {
    private Context mAppContext;
    private String mDataSource;
    private DemoPlayerListener mDemoListener = new DemoPlayerListener();
    private EventLogger mEventLogger;
    /* access modifiers changed from: private */
    public DemoPlayer mInternalPlayer;
    private DemoPlayer.RendererBuilder mRendererBuilder;
    private Surface mSurface;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoWidth;

    private class DemoPlayerListener implements DemoPlayer.Listener {
        private boolean mDidPrepare;
        private boolean mIsBuffering;
        private boolean mIsPrepareing;

        private DemoPlayerListener() {
            this.mIsPrepareing = false;
            this.mDidPrepare = false;
            this.mIsBuffering = false;
        }

        public void onError(Exception exc) {
            boolean unused = IjkExoMediaPlayer.this.notifyOnError(1, 1);
        }

        public void onStateChanged(boolean z2, int i2) {
            if (this.mIsBuffering && (i2 == 4 || i2 == 5)) {
                IjkExoMediaPlayer ijkExoMediaPlayer = IjkExoMediaPlayer.this;
                boolean unused = ijkExoMediaPlayer.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, ijkExoMediaPlayer.mInternalPlayer.getBufferedPercentage());
                this.mIsBuffering = false;
            }
            if (this.mIsPrepareing && i2 == 4) {
                IjkExoMediaPlayer.this.notifyOnPrepared();
                this.mIsPrepareing = false;
                this.mDidPrepare = false;
            }
            if (i2 == 1) {
                IjkExoMediaPlayer.this.notifyOnCompletion();
            } else if (i2 == 2) {
                this.mIsPrepareing = true;
            } else if (i2 == 3) {
                IjkExoMediaPlayer ijkExoMediaPlayer2 = IjkExoMediaPlayer.this;
                boolean unused2 = ijkExoMediaPlayer2.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_START, ijkExoMediaPlayer2.mInternalPlayer.getBufferedPercentage());
                this.mIsBuffering = true;
            } else if (i2 == 5) {
                IjkExoMediaPlayer.this.notifyOnCompletion();
            }
        }

        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            int unused = IjkExoMediaPlayer.this.mVideoWidth = i2;
            int unused2 = IjkExoMediaPlayer.this.mVideoHeight = i3;
            IjkExoMediaPlayer.this.notifyOnVideoSizeChanged(i2, i3, 1, 1);
            if (i4 > 0) {
                boolean unused3 = IjkExoMediaPlayer.this.notifyOnInfo(10001, i4);
            }
        }
    }

    public IjkExoMediaPlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
        EventLogger eventLogger = new EventLogger();
        this.mEventLogger = eventLogger;
        eventLogger.startSession();
    }

    private DemoPlayer.RendererBuilder getRendererBuilder() {
        Uri parse = Uri.parse(this.mDataSource);
        String userAgent = Util.getUserAgent(this.mAppContext, "IjkExoMediaPlayer");
        int inferContentType = inferContentType(parse);
        return inferContentType != 1 ? inferContentType != 2 ? new ExtractorRendererBuilder(this.mAppContext, userAgent, parse) : new HlsRendererBuilder(this.mAppContext, userAgent, parse.toString()) : new SmoothStreamingRendererBuilder(this.mAppContext, userAgent, parse.toString(), new SmoothStreamingTestMediaDrmCallback());
    }

    private static int inferContentType(Uri uri) {
        return Util.inferContentType(uri.getLastPathSegment());
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferedPercentage() {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer == null) {
            return 0;
        }
        return demoPlayer.getBufferedPercentage();
    }

    public long getCurrentPosition() {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer == null) {
            return 0;
        }
        return demoPlayer.getCurrentPosition();
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDuration() {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer == null) {
            return 0;
        }
        return demoPlayer.getDuration();
    }

    public MediaInfo getMediaInfo() {
        return null;
    }

    public IjkTrackInfo[] getTrackInfo() {
        return null;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isLooping() {
        return false;
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer == null) {
            return false;
        }
        int playbackState = demoPlayer.getPlaybackState();
        if (playbackState == 3 || playbackState == 4) {
            return this.mInternalPlayer.getPlayWhenReady();
        }
        return false;
    }

    public void pause() throws IllegalStateException {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.setPlayWhenReady(false);
        }
    }

    public void prepareAsync() throws IllegalStateException {
        if (this.mInternalPlayer == null) {
            DemoPlayer demoPlayer = new DemoPlayer(this.mRendererBuilder);
            this.mInternalPlayer = demoPlayer;
            demoPlayer.addListener(this.mDemoListener);
            this.mInternalPlayer.addListener(this.mEventLogger);
            this.mInternalPlayer.setInfoListener(this.mEventLogger);
            this.mInternalPlayer.setInternalErrorListener(this.mEventLogger);
            Surface surface = this.mSurface;
            if (surface != null) {
                this.mInternalPlayer.setSurface(surface);
            }
            this.mInternalPlayer.prepare();
            this.mInternalPlayer.setPlayWhenReady(false);
            return;
        }
        throw new IllegalStateException("can't prepare a prepared player");
    }

    public void release() {
        if (this.mInternalPlayer != null) {
            reset();
            this.mDemoListener = null;
            this.mEventLogger.endSession();
            this.mEventLogger = null;
        }
    }

    public void reset() {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.release();
            this.mInternalPlayer.removeListener(this.mDemoListener);
            this.mInternalPlayer.removeListener(this.mEventLogger);
            this.mInternalPlayer.setInfoListener((DemoPlayer.InfoListener) null);
            this.mInternalPlayer.setInternalErrorListener((DemoPlayer.InternalErrorListener) null);
            this.mInternalPlayer = null;
        }
        this.mSurface = null;
        this.mDataSource = null;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void seekTo(long j2) throws IllegalStateException {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.seekTo(j2);
        }
    }

    public void setAudioStreamType(int i2) {
    }

    public void setDataSource(Context context, Uri uri) {
        this.mDataSource = uri.toString();
        this.mRendererBuilder = getRendererBuilder();
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnsupportedOperationException("no support");
    }

    public void setDataSource(String str) {
        setDataSource(this.mAppContext, Uri.parse(str));
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        setSurface(surfaceHolder == null ? null : surfaceHolder.getSurface());
    }

    public void setKeepInBackground(boolean z2) {
    }

    public void setLogEnabled(boolean z2) {
    }

    public void setLooping(boolean z2) {
        throw new UnsupportedOperationException("no support");
    }

    public void setScreenOnWhilePlaying(boolean z2) {
    }

    public void setSurface(Surface surface) {
        this.mSurface = surface;
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.setSurface(surface);
        }
    }

    public void setVolume(float f2, float f3) {
    }

    public void setWakeMode(Context context, int i2) {
    }

    public void start() throws IllegalStateException {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.setPlayWhenReady(true);
        }
    }

    public void stop() throws IllegalStateException {
        DemoPlayer demoPlayer = this.mInternalPlayer;
        if (demoPlayer != null) {
            demoPlayer.release();
        }
    }
}
