package tv.danmaku.ijk.media.exo.demo.player;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer.DefaultLoadControl;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecSelector;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.chunk.ChunkSampleSource;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.dash.DashChunkSource;
import com.google.android.exoplayer.dash.DefaultDashTrackSelector;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescriptionParser;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.UtcTimingElement;
import com.google.android.exoplayer.dash.mpd.UtcTimingElementResolver;
import com.google.android.exoplayer.drm.MediaDrmCallback;
import com.google.android.exoplayer.drm.StreamingDrmSessionManager;
import com.google.android.exoplayer.drm.UnsupportedDrmException;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.text.TextTrackRenderer;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.util.ManifestFetcher;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.HashMap;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;

public class DashRendererBuilder implements DemoPlayer.RendererBuilder {
    private static final int AUDIO_BUFFER_SEGMENTS = 54;
    private static final int BUFFER_SEGMENT_SIZE = 65536;
    private static final int LIVE_EDGE_LATENCY_MS = 30000;
    private static final int SECURITY_LEVEL_1 = 1;
    private static final int SECURITY_LEVEL_3 = 3;
    private static final int SECURITY_LEVEL_UNKNOWN = -1;
    private static final String TAG = "DashRendererBuilder";
    private static final int TEXT_BUFFER_SEGMENTS = 2;
    private static final int VIDEO_BUFFER_SEGMENTS = 200;
    private final Context context;
    private AsyncRendererBuilder currentAsyncBuilder;
    private final MediaDrmCallback drmCallback;
    private final String url;
    private final String userAgent;

    private static final class AsyncRendererBuilder implements UtcTimingElementResolver.UtcTimingCallback, ManifestFetcher.ManifestCallback<MediaPresentationDescription> {
        private boolean canceled;
        private final Context context;
        private final MediaDrmCallback drmCallback;
        private long elapsedRealtimeOffset;
        private MediaPresentationDescription manifest;
        private final UriDataSource manifestDataSource;
        private final ManifestFetcher<MediaPresentationDescription> manifestFetcher;
        private final DemoPlayer player;
        private final String userAgent;

        public AsyncRendererBuilder(Context context2, String str, String str2, MediaDrmCallback mediaDrmCallback, DemoPlayer demoPlayer) {
            this.context = context2;
            this.userAgent = str;
            this.drmCallback = mediaDrmCallback;
            this.player = demoPlayer;
            MediaPresentationDescriptionParser mediaPresentationDescriptionParser = new MediaPresentationDescriptionParser();
            DefaultUriDataSource defaultUriDataSource = new DefaultUriDataSource(context2, str);
            this.manifestDataSource = defaultUriDataSource;
            this.manifestFetcher = new ManifestFetcher<>(str2, defaultUriDataSource, mediaPresentationDescriptionParser);
        }

        private void buildRenderers() {
            boolean z2;
            Period period = this.manifest.getPeriod(0);
            Handler mainHandler = this.player.getMainHandler();
            LoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(DashRendererBuilder.BUFFER_SEGMENT_SIZE));
            BandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter(mainHandler, this.player);
            boolean z3 = false;
            for (int i2 = 0; i2 < period.adaptationSets.size(); i2++) {
                AdaptationSet adaptationSet = (AdaptationSet) period.adaptationSets.get(i2);
                if (adaptationSet.type != -1) {
                    z3 |= adaptationSet.hasContentProtection();
                }
            }
            StreamingDrmSessionManager streamingDrmSessionManager = null;
            if (z3) {
                if (Util.SDK_INT < 18) {
                    this.player.onRenderersError(new UnsupportedDrmException(1));
                    return;
                }
                try {
                    streamingDrmSessionManager = StreamingDrmSessionManager.newWidevineInstance(this.player.getPlaybackLooper(), this.drmCallback, (HashMap) null, this.player.getMainHandler(), this.player);
                    if (getWidevineSecurityLevel(streamingDrmSessionManager) != 1) {
                        z2 = true;
                        DefaultUriDataSource defaultUriDataSource = new DefaultUriDataSource(this.context, defaultBandwidthMeter, this.userAgent);
                        Handler handler = mainHandler;
                        BandwidthMeter bandwidthMeter = defaultBandwidthMeter;
                        LoadControl loadControl = defaultLoadControl;
                        TrackRenderer mediaCodecVideoTrackRenderer = new MediaCodecVideoTrackRenderer(this.context, new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newVideoInstance(this.context, true, z2), defaultUriDataSource, new FormatEvaluator.AdaptiveEvaluator(defaultBandwidthMeter), 30000, this.elapsedRealtimeOffset, handler, this.player, 0), loadControl, 13107200, mainHandler, this.player, 0), MediaCodecSelector.DEFAULT, 1, 5000, streamingDrmSessionManager, true, handler, this.player, 50);
                        TrackRenderer mediaCodecAudioTrackRenderer = new MediaCodecAudioTrackRenderer(new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newAudioInstance(), new DefaultUriDataSource(this.context, bandwidthMeter, this.userAgent), (FormatEvaluator) null, 30000, this.elapsedRealtimeOffset, handler, this.player, 1), loadControl, 3538944, mainHandler, this.player, 1), MediaCodecSelector.DEFAULT, streamingDrmSessionManager, true, mainHandler, this.player, AudioCapabilities.getCapabilities(this.context), 3);
                        TrackRenderer textTrackRenderer = new TextTrackRenderer(new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newTextInstance(), new DefaultUriDataSource(this.context, bandwidthMeter, this.userAgent), (FormatEvaluator) null, 30000, this.elapsedRealtimeOffset, mainHandler, this.player, 2), loadControl, 131072, mainHandler, this.player, 2), this.player, mainHandler.getLooper(), new SubtitleParser[0]);
                        TrackRenderer[] trackRendererArr = new TrackRenderer[4];
                        trackRendererArr[0] = mediaCodecVideoTrackRenderer;
                        trackRendererArr[1] = mediaCodecAudioTrackRenderer;
                        trackRendererArr[2] = textTrackRenderer;
                        this.player.onRenderers(trackRendererArr, bandwidthMeter);
                    }
                } catch (UnsupportedDrmException e2) {
                    this.player.onRenderersError(e2);
                    return;
                }
            }
            z2 = false;
            DefaultUriDataSource defaultUriDataSource2 = new DefaultUriDataSource(this.context, defaultBandwidthMeter, this.userAgent);
            Handler handler2 = mainHandler;
            BandwidthMeter bandwidthMeter2 = defaultBandwidthMeter;
            LoadControl loadControl2 = defaultLoadControl;
            TrackRenderer mediaCodecVideoTrackRenderer2 = new MediaCodecVideoTrackRenderer(this.context, new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newVideoInstance(this.context, true, z2), defaultUriDataSource2, new FormatEvaluator.AdaptiveEvaluator(defaultBandwidthMeter), 30000, this.elapsedRealtimeOffset, handler2, this.player, 0), loadControl2, 13107200, mainHandler, this.player, 0), MediaCodecSelector.DEFAULT, 1, 5000, streamingDrmSessionManager, true, handler2, this.player, 50);
            TrackRenderer mediaCodecAudioTrackRenderer2 = new MediaCodecAudioTrackRenderer(new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newAudioInstance(), new DefaultUriDataSource(this.context, bandwidthMeter2, this.userAgent), (FormatEvaluator) null, 30000, this.elapsedRealtimeOffset, handler2, this.player, 1), loadControl2, 3538944, mainHandler, this.player, 1), MediaCodecSelector.DEFAULT, streamingDrmSessionManager, true, mainHandler, this.player, AudioCapabilities.getCapabilities(this.context), 3);
            TrackRenderer textTrackRenderer2 = new TextTrackRenderer(new ChunkSampleSource(new DashChunkSource(this.manifestFetcher, DefaultDashTrackSelector.newTextInstance(), new DefaultUriDataSource(this.context, bandwidthMeter2, this.userAgent), (FormatEvaluator) null, 30000, this.elapsedRealtimeOffset, mainHandler, this.player, 2), loadControl2, 131072, mainHandler, this.player, 2), this.player, mainHandler.getLooper(), new SubtitleParser[0]);
            TrackRenderer[] trackRendererArr2 = new TrackRenderer[4];
            trackRendererArr2[0] = mediaCodecVideoTrackRenderer2;
            trackRendererArr2[1] = mediaCodecAudioTrackRenderer2;
            trackRendererArr2[2] = textTrackRenderer2;
            this.player.onRenderers(trackRendererArr2, bandwidthMeter2);
        }

        private static int getWidevineSecurityLevel(StreamingDrmSessionManager streamingDrmSessionManager) {
            String propertyString = streamingDrmSessionManager.getPropertyString("securityLevel");
            if (propertyString.equals("L1")) {
                return 1;
            }
            return propertyString.equals("L3") ? 3 : -1;
        }

        public void cancel() {
            this.canceled = true;
        }

        public void init() {
            this.manifestFetcher.singleLoad(this.player.getMainHandler().getLooper(), this);
        }

        public void onSingleManifest(MediaPresentationDescription mediaPresentationDescription) {
            if (!this.canceled) {
                this.manifest = mediaPresentationDescription;
                if (!mediaPresentationDescription.dynamic || mediaPresentationDescription.utcTiming == null) {
                    buildRenderers();
                } else {
                    UtcTimingElementResolver.resolveTimingElement(this.manifestDataSource, mediaPresentationDescription.utcTiming, this.manifestFetcher.getManifestLoadCompleteTimestamp(), this);
                }
            }
        }

        public void onSingleManifestError(IOException iOException) {
            if (!this.canceled) {
                this.player.onRenderersError(iOException);
            }
        }

        public void onTimestampError(UtcTimingElement utcTimingElement, IOException iOException) {
            if (!this.canceled) {
                Log.e(DashRendererBuilder.TAG, "Failed to resolve UtcTiming element [" + utcTimingElement + "]", iOException);
                buildRenderers();
            }
        }

        public void onTimestampResolved(UtcTimingElement utcTimingElement, long j2) {
            if (!this.canceled) {
                this.elapsedRealtimeOffset = j2;
                buildRenderers();
            }
        }
    }

    public DashRendererBuilder(Context context2, String str, String str2, MediaDrmCallback mediaDrmCallback) {
        this.context = context2;
        this.userAgent = str;
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
