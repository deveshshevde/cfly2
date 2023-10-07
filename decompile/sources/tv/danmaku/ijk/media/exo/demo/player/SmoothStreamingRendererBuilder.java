package tv.danmaku.ijk.media.exo.demo.player;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer.DefaultLoadControl;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecSelector;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.chunk.ChunkSampleSource;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.drm.MediaDrmCallback;
import com.google.android.exoplayer.drm.StreamingDrmSessionManager;
import com.google.android.exoplayer.drm.UnsupportedDrmException;
import com.google.android.exoplayer.smoothstreaming.DefaultSmoothStreamingTrackSelector;
import com.google.android.exoplayer.smoothstreaming.SmoothStreamingChunkSource;
import com.google.android.exoplayer.smoothstreaming.SmoothStreamingManifest;
import com.google.android.exoplayer.smoothstreaming.SmoothStreamingManifestParser;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.text.TextTrackRenderer;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.util.ManifestFetcher;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.HashMap;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;

public class SmoothStreamingRendererBuilder implements DemoPlayer.RendererBuilder {
    private static final int AUDIO_BUFFER_SEGMENTS = 54;
    private static final int BUFFER_SEGMENT_SIZE = 65536;
    private static final int LIVE_EDGE_LATENCY_MS = 30000;
    private static final int TEXT_BUFFER_SEGMENTS = 2;
    private static final int VIDEO_BUFFER_SEGMENTS = 200;
    private final Context context;
    private AsyncRendererBuilder currentAsyncBuilder;
    private final MediaDrmCallback drmCallback;
    private final String url;
    private final String userAgent;

    private static final class AsyncRendererBuilder implements ManifestFetcher.ManifestCallback<SmoothStreamingManifest> {
        private boolean canceled;
        private final Context context;
        private final MediaDrmCallback drmCallback;
        private final ManifestFetcher<SmoothStreamingManifest> manifestFetcher;
        private final DemoPlayer player;
        private final String userAgent;

        public AsyncRendererBuilder(Context context2, String str, String str2, MediaDrmCallback mediaDrmCallback, DemoPlayer demoPlayer) {
            this.context = context2;
            this.userAgent = str;
            this.drmCallback = mediaDrmCallback;
            this.player = demoPlayer;
            this.manifestFetcher = new ManifestFetcher<>(str2, new DefaultHttpDataSource(str, (Predicate) null), new SmoothStreamingManifestParser());
        }

        public void cancel() {
            this.canceled = true;
        }

        public void init() {
            this.manifestFetcher.singleLoad(this.player.getMainHandler().getLooper(), this);
        }

        public void onSingleManifest(SmoothStreamingManifest smoothStreamingManifest) {
            StreamingDrmSessionManager streamingDrmSessionManager;
            SmoothStreamingManifest smoothStreamingManifest2 = smoothStreamingManifest;
            if (!this.canceled) {
                Handler mainHandler = this.player.getMainHandler();
                LoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(SmoothStreamingRendererBuilder.BUFFER_SEGMENT_SIZE));
                BandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter(mainHandler, this.player);
                if (smoothStreamingManifest2.protectionElement == null) {
                    streamingDrmSessionManager = null;
                } else if (Util.SDK_INT < 18) {
                    this.player.onRenderersError(new UnsupportedDrmException(1));
                    return;
                } else {
                    try {
                        streamingDrmSessionManager = StreamingDrmSessionManager.newFrameworkInstance(smoothStreamingManifest2.protectionElement.uuid, this.player.getPlaybackLooper(), this.drmCallback, (HashMap) null, this.player.getMainHandler(), this.player);
                    } catch (UnsupportedDrmException e2) {
                        this.player.onRenderersError(e2);
                        return;
                    }
                }
                StreamingDrmSessionManager streamingDrmSessionManager2 = streamingDrmSessionManager;
                BandwidthMeter bandwidthMeter = defaultBandwidthMeter;
                TrackRenderer mediaCodecVideoTrackRenderer = new MediaCodecVideoTrackRenderer(this.context, new ChunkSampleSource(new SmoothStreamingChunkSource(this.manifestFetcher, DefaultSmoothStreamingTrackSelector.newVideoInstance(this.context, true, false), new DefaultUriDataSource(this.context, defaultBandwidthMeter, this.userAgent), new FormatEvaluator.AdaptiveEvaluator(defaultBandwidthMeter), 30000), defaultLoadControl, 13107200, mainHandler, this.player, 0), MediaCodecSelector.DEFAULT, 1, 5000, streamingDrmSessionManager, true, mainHandler, this.player, 50);
                DataSource defaultUriDataSource = new DefaultUriDataSource(this.context, bandwidthMeter, this.userAgent);
                TrackRenderer mediaCodecAudioTrackRenderer = new MediaCodecAudioTrackRenderer(new ChunkSampleSource(new SmoothStreamingChunkSource(this.manifestFetcher, DefaultSmoothStreamingTrackSelector.newAudioInstance(), defaultUriDataSource, (FormatEvaluator) null, 30000), defaultLoadControl, 3538944, mainHandler, this.player, 1), MediaCodecSelector.DEFAULT, streamingDrmSessionManager2, true, mainHandler, this.player, AudioCapabilities.getCapabilities(this.context), 3);
                DataSource defaultUriDataSource2 = new DefaultUriDataSource(this.context, bandwidthMeter, this.userAgent);
                TrackRenderer textTrackRenderer = new TextTrackRenderer(new ChunkSampleSource(new SmoothStreamingChunkSource(this.manifestFetcher, DefaultSmoothStreamingTrackSelector.newTextInstance(), defaultUriDataSource2, (FormatEvaluator) null, 30000), defaultLoadControl, 131072, mainHandler, this.player, 2), this.player, mainHandler.getLooper(), new SubtitleParser[0]);
                TrackRenderer[] trackRendererArr = new TrackRenderer[4];
                trackRendererArr[0] = mediaCodecVideoTrackRenderer;
                trackRendererArr[1] = mediaCodecAudioTrackRenderer;
                trackRendererArr[2] = textTrackRenderer;
                this.player.onRenderers(trackRendererArr, bandwidthMeter);
            }
        }

        public void onSingleManifestError(IOException iOException) {
            if (!this.canceled) {
                this.player.onRenderersError(iOException);
            }
        }
    }

    public SmoothStreamingRendererBuilder(Context context2, String str, String str2, MediaDrmCallback mediaDrmCallback) {
        this.context = context2;
        this.userAgent = str;
        if (!Util.toLowerInvariant(str2).endsWith("/manifest")) {
            str2 = str2 + "/Manifest";
        }
        this.url = str2;
        this.drmCallback = mediaDrmCallback;
    }

    public void buildRenderers(DemoPlayer demoPlayer) {
        AsyncRendererBuilder asyncRendererBuilder = new AsyncRendererBuilder(this.context, this.userAgent, this.url, this.drmCallback, demoPlayer);
        this.currentAsyncBuilder = asyncRendererBuilder;
        asyncRendererBuilder.init();
    }

    public void cancel() {
        AsyncRendererBuilder asyncRendererBuilder = this.currentAsyncBuilder;
        if (asyncRendererBuilder != null) {
            asyncRendererBuilder.cancel();
            this.currentAsyncBuilder = null;
        }
    }
}
