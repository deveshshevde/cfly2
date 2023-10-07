package tv.danmaku.ijk.media.exo.demo.player;

import android.content.Context;
import com.google.android.exoplayer.hls.HlsPlaylist;
import com.google.android.exoplayer.hls.HlsPlaylistParser;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.util.ManifestFetcher;
import java.io.IOException;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;

public class HlsRendererBuilder implements DemoPlayer.RendererBuilder {
    private static final int AUDIO_BUFFER_SEGMENTS = 54;
    private static final int BUFFER_SEGMENT_SIZE = 65536;
    private static final int MAIN_BUFFER_SEGMENTS = 254;
    private static final int TEXT_BUFFER_SEGMENTS = 2;
    private final Context context;
    private AsyncRendererBuilder currentAsyncBuilder;
    private final String url;
    private final String userAgent;

    private static final class AsyncRendererBuilder implements ManifestFetcher.ManifestCallback<HlsPlaylist> {
        private boolean canceled;
        private final Context context;
        private final DemoPlayer player;
        private final ManifestFetcher<HlsPlaylist> playlistFetcher;
        private final String userAgent;

        public AsyncRendererBuilder(Context context2, String str, String str2, DemoPlayer demoPlayer) {
            this.context = context2;
            this.userAgent = str;
            this.player = demoPlayer;
            this.playlistFetcher = new ManifestFetcher<>(str2, new DefaultUriDataSource(context2, str), new HlsPlaylistParser());
        }

        public void cancel() {
            this.canceled = true;
        }

        public void init() {
            this.playlistFetcher.singleLoad(this.player.getMainHandler().getLooper(), this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.exoplayer.TrackRenderer[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSingleManifest(com.google.android.exoplayer.hls.HlsPlaylist r36) {
            /*
                r35 = this;
                r0 = r35
                r8 = r36
                boolean r1 = r0.canceled
                if (r1 == 0) goto L_0x0009
                return
            L_0x0009:
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.os.Handler r19 = r1.getMainHandler()
                com.google.android.exoplayer.DefaultLoadControl r15 = new com.google.android.exoplayer.DefaultLoadControl
                com.google.android.exoplayer.upstream.DefaultAllocator r1 = new com.google.android.exoplayer.upstream.DefaultAllocator
                r2 = 65536(0x10000, float:9.18355E-41)
                r1.<init>(r2)
                r15.<init>(r1)
                com.google.android.exoplayer.upstream.DefaultBandwidthMeter r14 = new com.google.android.exoplayer.upstream.DefaultBandwidthMeter
                r14.<init>()
                com.google.android.exoplayer.hls.PtsTimestampAdjusterProvider r20 = new com.google.android.exoplayer.hls.PtsTimestampAdjusterProvider
                r20.<init>()
                boolean r1 = r8 instanceof com.google.android.exoplayer.hls.HlsMasterPlaylist
                r21 = 1
                r13 = 0
                if (r1 == 0) goto L_0x0044
                r1 = r8
                com.google.android.exoplayer.hls.HlsMasterPlaylist r1 = (com.google.android.exoplayer.hls.HlsMasterPlaylist) r1
                java.util.List r2 = r1.subtitles
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ 1
                java.util.List r1 = r1.audios
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ 1
                r22 = r1
                r23 = r2
                goto L_0x0048
            L_0x0044:
                r22 = 0
                r23 = 0
            L_0x0048:
                com.google.android.exoplayer.upstream.DefaultUriDataSource r3 = new com.google.android.exoplayer.upstream.DefaultUriDataSource
                android.content.Context r1 = r0.context
                java.lang.String r2 = r0.userAgent
                r3.<init>(r1, r14, r2)
                com.google.android.exoplayer.hls.HlsChunkSource r10 = new com.google.android.exoplayer.hls.HlsChunkSource
                r2 = 1
                android.content.Context r1 = r0.context
                com.google.android.exoplayer.hls.DefaultHlsTrackSelector r5 = com.google.android.exoplayer.hls.DefaultHlsTrackSelector.newDefaultInstance(r1)
                r1 = r10
                r4 = r36
                r6 = r14
                r7 = r20
                r1.<init>(r2, r3, r4, r5, r6, r7)
                com.google.android.exoplayer.hls.HlsSampleSource r7 = new com.google.android.exoplayer.hls.HlsSampleSource
                r12 = 16646144(0xfe0000, float:2.3326216E-38)
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                r2 = 0
                r9 = r7
                r11 = r15
                r6 = 0
                r13 = r19
                r5 = r14
                r14 = r1
                r33 = r15
                r15 = r2
                r9.<init>(r10, r11, r12, r13, r14, r15)
                com.google.android.exoplayer.MediaCodecVideoTrackRenderer r34 = new com.google.android.exoplayer.MediaCodecVideoTrackRenderer
                android.content.Context r10 = r0.context
                com.google.android.exoplayer.MediaCodecSelector r12 = com.google.android.exoplayer.MediaCodecSelector.DEFAULT
                r13 = 1
                r14 = 5000(0x1388, double:2.4703E-320)
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                r18 = 50
                r9 = r34
                r11 = r7
                r16 = r19
                r17 = r1
                r9.<init>(r10, r11, r12, r13, r14, r16, r17, r18)
                com.google.android.exoplayer.metadata.MetadataTrackRenderer r15 = new com.google.android.exoplayer.metadata.MetadataTrackRenderer
                com.google.android.exoplayer.metadata.id3.Id3Parser r1 = new com.google.android.exoplayer.metadata.id3.Id3Parser
                r1.<init>()
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r2 = r0.player
                android.os.Looper r3 = r19.getLooper()
                r15.<init>(r7, r1, r2, r3)
                r14 = 2
                if (r22 == 0) goto L_0x00fd
                com.google.android.exoplayer.upstream.DefaultUriDataSource r3 = new com.google.android.exoplayer.upstream.DefaultUriDataSource
                android.content.Context r1 = r0.context
                java.lang.String r2 = r0.userAgent
                r3.<init>(r1, r5, r2)
                com.google.android.exoplayer.hls.HlsChunkSource r10 = new com.google.android.exoplayer.hls.HlsChunkSource
                r2 = 0
                com.google.android.exoplayer.hls.DefaultHlsTrackSelector r9 = com.google.android.exoplayer.hls.DefaultHlsTrackSelector.newAudioInstance()
                r1 = r10
                r4 = r36
                r13 = r5
                r5 = r9
                r12 = 0
                r6 = r13
                r11 = r7
                r7 = r20
                r1.<init>(r2, r3, r4, r5, r6, r7)
                com.google.android.exoplayer.hls.HlsSampleSource r1 = new com.google.android.exoplayer.hls.HlsSampleSource
                r2 = 3538944(0x360000, float:4.959117E-39)
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r3 = r0.player
                r4 = 1
                r9 = r1
                r5 = r11
                r11 = r33
                r7 = 0
                r12 = r2
                r13 = r19
                r2 = 2
                r14 = r3
                r16 = r15
                r15 = r4
                r9.<init>(r10, r11, r12, r13, r14, r15)
                com.google.android.exoplayer.MediaCodecAudioTrackRenderer r3 = new com.google.android.exoplayer.MediaCodecAudioTrackRenderer
                com.google.android.exoplayer.SampleSource[] r4 = new com.google.android.exoplayer.SampleSource[r2]
                r4[r7] = r5
                r4[r21] = r1
                com.google.android.exoplayer.MediaCodecSelector r26 = com.google.android.exoplayer.MediaCodecSelector.DEFAULT
                r27 = 0
                r28 = 1
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.os.Handler r29 = r1.getMainHandler()
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.content.Context r9 = r0.context
                com.google.android.exoplayer.audio.AudioCapabilities r31 = com.google.android.exoplayer.audio.AudioCapabilities.getCapabilities(r9)
                r32 = 3
                r24 = r3
                r25 = r4
                r30 = r1
                r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)
                goto L_0x0124
            L_0x00fd:
                r6 = r5
                r5 = r7
                r16 = r15
                r2 = 2
                r7 = 0
                com.google.android.exoplayer.MediaCodecAudioTrackRenderer r3 = new com.google.android.exoplayer.MediaCodecAudioTrackRenderer
                com.google.android.exoplayer.MediaCodecSelector r26 = com.google.android.exoplayer.MediaCodecSelector.DEFAULT
                r27 = 0
                r28 = 1
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.os.Handler r29 = r1.getMainHandler()
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.content.Context r4 = r0.context
                com.google.android.exoplayer.audio.AudioCapabilities r31 = com.google.android.exoplayer.audio.AudioCapabilities.getCapabilities(r4)
                r32 = 3
                r24 = r3
                r25 = r5
                r30 = r1
                r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)
            L_0x0124:
                r9 = r3
                if (r23 == 0) goto L_0x0161
                com.google.android.exoplayer.upstream.DefaultUriDataSource r3 = new com.google.android.exoplayer.upstream.DefaultUriDataSource
                android.content.Context r1 = r0.context
                java.lang.String r4 = r0.userAgent
                r3.<init>(r1, r6, r4)
                com.google.android.exoplayer.hls.HlsChunkSource r10 = new com.google.android.exoplayer.hls.HlsChunkSource
                r4 = 0
                com.google.android.exoplayer.hls.DefaultHlsTrackSelector r5 = com.google.android.exoplayer.hls.DefaultHlsTrackSelector.newSubtitleInstance()
                r1 = r10
                r11 = 2
                r2 = r4
                r4 = r36
                r12 = r6
                r13 = 0
                r7 = r20
                r1.<init>(r2, r3, r4, r5, r6, r7)
                com.google.android.exoplayer.hls.HlsSampleSource r1 = new com.google.android.exoplayer.hls.HlsSampleSource
                r5 = 131072(0x20000, float:1.83671E-40)
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r7 = r0.player
                r8 = 2
                r2 = r1
                r3 = r10
                r4 = r33
                r6 = r19
                r2.<init>(r3, r4, r5, r6, r7, r8)
                com.google.android.exoplayer.text.TextTrackRenderer r2 = new com.google.android.exoplayer.text.TextTrackRenderer
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r3 = r0.player
                android.os.Looper r4 = r19.getLooper()
                com.google.android.exoplayer.text.SubtitleParser[] r5 = new com.google.android.exoplayer.text.SubtitleParser[r13]
                r2.<init>(r1, r3, r4, r5)
                goto L_0x016f
            L_0x0161:
                r12 = r6
                r11 = 2
                r13 = 0
                com.google.android.exoplayer.text.eia608.Eia608TrackRenderer r2 = new com.google.android.exoplayer.text.eia608.Eia608TrackRenderer
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r1 = r0.player
                android.os.Looper r3 = r19.getLooper()
                r2.<init>(r5, r1, r3)
            L_0x016f:
                r1 = 4
                com.google.android.exoplayer.TrackRenderer[] r1 = new com.google.android.exoplayer.TrackRenderer[r1]
                r1[r13] = r34
                r1[r21] = r9
                r3 = 3
                r1[r3] = r16
                r1[r11] = r2
                tv.danmaku.ijk.media.exo.demo.player.DemoPlayer r2 = r0.player
                r2.onRenderers(r1, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.exo.demo.player.HlsRendererBuilder.AsyncRendererBuilder.onSingleManifest(com.google.android.exoplayer.hls.HlsPlaylist):void");
        }

        public void onSingleManifestError(IOException iOException) {
            if (!this.canceled) {
                this.player.onRenderersError(iOException);
            }
        }
    }

    public HlsRendererBuilder(Context context2, String str, String str2) {
        this.context = context2;
        this.userAgent = str;
        this.url = str2;
    }

    public void buildRenderers(DemoPlayer demoPlayer) {
        AsyncRendererBuilder asyncRendererBuilder = new AsyncRendererBuilder(this.context, this.userAgent, this.url, demoPlayer);
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
