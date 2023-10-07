package tv.danmaku.ijk.media.exo.demo;

import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer.MediaCodecTrackRenderer;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.audio.AudioTrack;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.VerboseLogUtil;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;

public class EventLogger implements DemoPlayer.InfoListener, DemoPlayer.InternalErrorListener, DemoPlayer.Listener {
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private long[] availableRangeValuesUs;
    private long[] loadStartTimeMs = new long[4];
    private long sessionStartTimeMs;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
    }

    private String getSessionTimeString() {
        return getTimeString(SystemClock.elapsedRealtime() - this.sessionStartTimeMs);
    }

    private String getStateString(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "?" : "E" : "R" : "B" : "P" : "I";
    }

    private String getTimeString(long j2) {
        return TIME_FORMAT.format((double) (((float) j2) / 1000.0f));
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    public void endSession() {
        Log.d(TAG, "end [" + getSessionTimeString() + "]");
    }

    public void onAudioFormatEnabled(Format format, int i2, long j2) {
        Log.d(TAG, "audioFormat [" + getSessionTimeString() + ", " + format.id + ", " + Integer.toString(i2) + "]");
    }

    public void onAudioTrackInitializationError(AudioTrack.InitializationException initializationException) {
        printInternalError("audioTrackInitializationError", initializationException);
    }

    public void onAudioTrackUnderrun(int i2, long j2, long j3) {
        printInternalError("audioTrackUnderrun [" + i2 + ", " + j2 + ", " + j3 + "]", (Exception) null);
    }

    public void onAudioTrackWriteError(AudioTrack.WriteException writeException) {
        printInternalError("audioTrackWriteError", writeException);
    }

    public void onAvailableRangeChanged(int i2, TimeRange timeRange) {
        this.availableRangeValuesUs = timeRange.getCurrentBoundsUs(this.availableRangeValuesUs);
        Log.d(TAG, "availableRange [" + timeRange.isStatic() + ", " + this.availableRangeValuesUs[0] + ", " + this.availableRangeValuesUs[1] + "]");
    }

    public void onBandwidthSample(int i2, long j2, long j3) {
        Log.d(TAG, "bandwidth [" + getSessionTimeString() + ", " + j2 + ", " + getTimeString((long) i2) + ", " + j3 + "]");
    }

    public void onCryptoError(MediaCodec.CryptoException cryptoException) {
        printInternalError("cryptoError", cryptoException);
    }

    public void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException decoderInitializationException) {
        printInternalError("decoderInitializationError", decoderInitializationException);
    }

    public void onDecoderInitialized(String str, long j2, long j3) {
        Log.d(TAG, "decoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    public void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    public void onDroppedFrames(int i2, long j2) {
        Log.d(TAG, "droppedFrames [" + getSessionTimeString() + ", " + i2 + "]");
    }

    public void onError(Exception exc) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", exc);
    }

    public void onLoadCompleted(int i2, long j2, int i3, int i4, Format format, long j3, long j4, long j5, long j6) {
        if (VerboseLogUtil.isTagEnabled(TAG)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.loadStartTimeMs[i2];
            Log.v(TAG, "loadEnd [" + getSessionTimeString() + ", " + i2 + ", " + elapsedRealtime + "]");
        }
    }

    public void onLoadError(int i2, IOException iOException) {
        printInternalError("loadError", iOException);
    }

    public void onLoadStarted(int i2, long j2, int i3, int i4, Format format, long j3, long j4) {
        this.loadStartTimeMs[i2] = SystemClock.elapsedRealtime();
        if (VerboseLogUtil.isTagEnabled(TAG)) {
            Log.v(TAG, "loadStart [" + getSessionTimeString() + ", " + i2 + ", " + i3 + ", " + j3 + ", " + j4 + "]");
        }
    }

    public void onRendererInitializationError(Exception exc) {
        printInternalError("rendererInitError", exc);
    }

    public void onStateChanged(boolean z2, int i2) {
        Log.d(TAG, "state [" + getSessionTimeString() + ", " + z2 + ", " + getStateString(i2) + "]");
    }

    public void onVideoFormatEnabled(Format format, int i2, long j2) {
        Log.d(TAG, "videoFormat [" + getSessionTimeString() + ", " + format.id + ", " + Integer.toString(i2) + "]");
    }

    public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
        Log.d(TAG, "videoSizeChanged [" + i2 + ", " + i3 + ", " + i4 + ", " + f2 + "]");
    }

    public void startSession() {
        this.sessionStartTimeMs = SystemClock.elapsedRealtime();
        Log.d(TAG, "start [0]");
    }
}
