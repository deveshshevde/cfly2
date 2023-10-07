package cy;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.ctoo.mediaedit.utils.b;
import cu.e;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class h {

    /* renamed from: h  reason: collision with root package name */
    private static ExecutorService f26581h = Executors.newFixedThreadPool(4);
    private Object A = new Object();
    private boolean B = false;
    /* access modifiers changed from: private */
    public a C;
    private int D = 0;
    private int E = 0;
    /* access modifiers changed from: private */
    public boolean F = false;
    private Runnable G = new Runnable() {
        public void run() {
            try {
                if (h.this.F) {
                    b.a(h.this.f26583b);
                    h.this.c();
                    return;
                }
                h.this.f26587f.selectTrack(h.this.f26590j);
                long sampleTime = h.this.f26587f.getSampleTime();
                h.this.f26587f.seekTo(h.this.f26591k + sampleTime, 0);
                h.this.b();
                h hVar = h.this;
                hVar.a(hVar.f26585d, h.this.f26586e, h.this.f26587f, h.this.f26599s, h.this.f26598r, sampleTime, h.this.f26591k, (long) (h.this.f26596p * 1000));
                boolean unused = h.this.f26603w = true;
                h.this.c();
            } catch (Exception e2) {
                if (h.this.C != null) {
                    h.this.C.a(e2);
                }
            } catch (Throwable th) {
                h.this.c();
                throw th;
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f26582a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f26583b;

    /* renamed from: c  reason: collision with root package name */
    private String f26584c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f26585d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec f26586e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public MediaExtractor f26587f;

    /* renamed from: g  reason: collision with root package name */
    private MediaMuxer f26588g;

    /* renamed from: i  reason: collision with root package name */
    private int f26589i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f26590j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public long f26591k;

    /* renamed from: l  reason: collision with root package name */
    private long f26592l;

    /* renamed from: m  reason: collision with root package name */
    private int f26593m;

    /* renamed from: n  reason: collision with root package name */
    private int f26594n;

    /* renamed from: o  reason: collision with root package name */
    private int f26595o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f26596p;

    /* renamed from: q  reason: collision with root package name */
    private int f26597q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public b f26598r = null;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public c f26599s = null;

    /* renamed from: t  reason: collision with root package name */
    private MediaFormat f26600t;

    /* renamed from: u  reason: collision with root package name */
    private e f26601u;

    /* renamed from: v  reason: collision with root package name */
    private Resources f26602v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f26603w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f26604x = false;

    /* renamed from: y  reason: collision with root package name */
    private long f26605y;

    /* renamed from: z  reason: collision with root package name */
    private long f26606z;

    public interface a {
        void a();

        void a(int i2);

        void a(Exception exc);
    }

    public h(Resources resources) {
        try {
            this.f26585d = MediaCodec.createDecoderByType("video/avc");
            this.f26586e = MediaCodec.createEncoderByType("video/avc");
            this.f26602v = resources;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b6, code lost:
        if (r2 < 4.7d) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "v"
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0031
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r10.getPackageName()
            r2.append(r4)
            java.lang.String r4 = ".fileProvider"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r9.f26584c
            r4.<init>(r5)
            android.net.Uri r2 = androidx.core.content.FileProvider.getUriForFile(r10, r2, r4)
            r1.setDataSource(r10, r2)
            goto L_0x0036
        L_0x0031:
            java.lang.String r10 = r9.f26584c
            r1.setDataSource(r10)
        L_0x0036:
            r10 = 18
            java.lang.String r10 = r1.extractMetadata(r10)
            r2 = 19
            java.lang.String r2 = r1.extractMetadata(r2)
            java.lang.String r3 = r1.extractMetadata(r3)
            r4 = 9
            java.lang.String r5 = r1.extractMetadata(r4)
            r6 = 32
            java.lang.String r1 = r1.extractMetadata(r6)
            int r6 = java.lang.Integer.parseInt(r5)
            r9.f26596p = r6
            int r10 = java.lang.Integer.parseInt(r10)
            r9.f26593m = r10
            int r10 = java.lang.Integer.parseInt(r2)
            r9.f26594n = r10
            int r10 = java.lang.Integer.parseInt(r3)
            r9.f26595o = r10
            r10 = 1
            if (r11 == 0) goto L_0x00b8
            int r2 = r11.indexOf(r0)     // Catch:{ Exception -> 0x00d4 }
            int r2 = r2 + r10
            int r0 = r11.indexOf(r0)     // Catch:{ Exception -> 0x00d4 }
            int r0 = r0 + 4
            java.lang.String r0 = r11.substring(r2, r0)     // Catch:{ Exception -> 0x00d4 }
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "808-D"
            boolean r0 = r11.contains(r0)     // Catch:{ Exception -> 0x00d4 }
            r6 = 0
            if (r0 == 0) goto L_0x0095
            r7 = 4618891777831180698(0x401999999999999a, double:6.4)
            int r11 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x0093
            goto L_0x00b8
        L_0x0093:
            r10 = 0
            goto L_0x00b8
        L_0x0095:
            java.lang.String r0 = "809-E"
            boolean r0 = r11.contains(r0)     // Catch:{ Exception -> 0x00d4 }
            if (r0 == 0) goto L_0x00a7
            r7 = 4617090337980232499(0x4013333333333333, double:4.8)
            int r11 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x0093
            goto L_0x00b8
        L_0x00a7:
            java.lang.String r0 = "809-D"
            boolean r11 = r11.contains(r0)     // Catch:{ Exception -> 0x00d4 }
            if (r11 == 0) goto L_0x00b8
            r7 = 4616977747989548237(0x4012cccccccccccd, double:4.7)
            int r11 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x0093
        L_0x00b8:
            if (r10 == 0) goto L_0x00bd
            r9.f26597q = r4     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d8
        L_0x00bd:
            float r10 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x00d4 }
            float r11 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x00d4 }
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r11 = r11 / r0
            r0 = 1092616192(0x41200000, float:10.0)
            float r11 = r11 / r0
            r0 = 1106247680(0x41f00000, float:30.0)
            float r11 = r11 * r0
            float r10 = r10 / r11
            int r10 = (int) r10     // Catch:{ Exception -> 0x00d4 }
            r9.f26597q = r10     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r10 = 20
            r9.f26597q = r10
        L_0x00d8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "initVideoInfo: ==during=="
            r10.append(r11)
            r10.append(r5)
            java.lang.String r11 = "==videoWidth=="
            r10.append(r11)
            int r11 = r9.f26593m
            r10.append(r11)
            java.lang.String r11 = "==videoHeight==="
            r10.append(r11)
            int r11 = r9.f26594n
            r10.append(r11)
            java.lang.String r11 = "==frameCount=="
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = "==mSamplingInterval==="
            r10.append(r11)
            int r11 = r9.f26597q
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "ssss"
            android.util.Log.i(r11, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cy.h.a(android.content.Context, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.media.MediaCodec r24, android.media.MediaCodec r25, android.media.MediaExtractor r26, cy.c r27, cy.b r28, long r29, long r31, long r33) {
        /*
            r23 = this;
            r1 = r23
            r9 = r24
            r10 = r25
            java.nio.ByteBuffer[] r11 = r24.getInputBuffers()
            java.nio.ByteBuffer[] r0 = r25.getOutputBuffers()
            android.media.MediaCodec$BufferInfo r12 = new android.media.MediaCodec$BufferInfo
            r12.<init>()
            android.media.MediaCodec$BufferInfo r13 = new android.media.MediaCodec$BufferInfo
            r13.<init>()
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x001e:
            if (r15 != 0) goto L_0x0187
            boolean r2 = r1.F
            if (r2 == 0) goto L_0x002a
            java.lang.String r0 = r1.f26583b
            com.ctoo.mediaedit.utils.b.a(r0)
            return
        L_0x002a:
            r6 = 0
            r18 = 1
            if (r16 != 0) goto L_0x0076
            int r3 = r9.dequeueInputBuffer(r6)
            if (r3 < 0) goto L_0x0076
            r2 = r11[r3]
            r2.clear()
            r8 = r26
            int r5 = r8.readSampleData(r2, r14)
            long r19 = r26.getSampleTime()
            long r19 = r19 - r29
            long r19 = r19 - r31
            int r2 = (r19 > r33 ? 1 : (r19 == r33 ? 0 : -1))
            if (r2 >= 0) goto L_0x0066
            if (r5 <= 0) goto L_0x0066
            r4 = 0
            long r19 = r26.getSampleTime()
            r21 = 0
            r2 = r24
            r22 = r15
            r14 = r6
            r6 = r19
            r8 = r21
            r2.queueInputBuffer(r3, r4, r5, r6, r8)
            r26.advance()
            goto L_0x0079
        L_0x0066:
            r22 = r15
            r14 = r6
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 4
            r2 = r24
            r2.queueInputBuffer(r3, r4, r5, r6, r8)
            r16 = 1
            goto L_0x0079
        L_0x0076:
            r22 = r15
            r14 = r6
        L_0x0079:
            r2 = -2
            r3 = -3
            r4 = -1
            if (r17 != 0) goto L_0x00fa
            int r5 = r9.dequeueOutputBuffer(r12, r14)
            if (r5 != r4) goto L_0x0086
            goto L_0x00fa
        L_0x0086:
            if (r5 != r3) goto L_0x008a
            goto L_0x00fa
        L_0x008a:
            if (r5 != r2) goto L_0x0091
            r24.getOutputFormat()
            goto L_0x00fa
        L_0x0091:
            if (r5 >= 0) goto L_0x0094
            goto L_0x00fa
        L_0x0094:
            int r6 = r12.size
            if (r6 == 0) goto L_0x00a2
            long r6 = r12.presentationTimeUs
            long r6 = r6 - r29
            int r8 = (r6 > r31 ? 1 : (r6 == r31 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a2
            r6 = 1
            goto L_0x00a3
        L_0x00a2:
            r6 = 0
        L_0x00a3:
            r9.releaseOutputBuffer(r5, r6)
            if (r6 == 0) goto L_0x00ec
            r28.c()
            r28.d()
            int r5 = r1.E
            int r6 = r1.f26597q
            int r5 = r5 % r6
            if (r5 != 0) goto L_0x00e3
            r5 = 33333(0x8235, float:4.671E-41)
            int r6 = r1.D
            int r6 = r6 * r5
            long r5 = (long) r6
            r12.presentationTimeUs = r5
            long r5 = r12.presentationTimeUs
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            r7 = r27
            r7.a((long) r5)
            r27.c()
            cy.h$a r5 = r1.C
            if (r5 == 0) goto L_0x00dc
            long r2 = r12.presentationTimeUs
            int r3 = (int) r2
            int r3 = r3 * 10
            int r2 = r1.f26596p
            int r3 = r3 / r2
            r5.a((int) r3)
        L_0x00dc:
            int r2 = r1.D
            int r2 = r2 + 1
            r1.D = r2
            goto L_0x00e5
        L_0x00e3:
            r7 = r27
        L_0x00e5:
            int r2 = r1.E
            int r2 = r2 + 1
            r1.E = r2
            goto L_0x00ee
        L_0x00ec:
            r7 = r27
        L_0x00ee:
            int r2 = r12.flags
            r2 = r2 & 4
            if (r2 == 0) goto L_0x00fc
            r25.signalEndOfInputStream()
            r17 = 1
            goto L_0x00fc
        L_0x00fa:
            r7 = r27
        L_0x00fc:
            r2 = r0
            r0 = 1
        L_0x00fe:
            if (r0 == 0) goto L_0x0181
            int r3 = r10.dequeueOutputBuffer(r13, r14)
            if (r3 != r4) goto L_0x010a
            r0 = 0
        L_0x0107:
            r5 = 0
            goto L_0x017d
        L_0x010a:
            r5 = -3
            if (r3 != r5) goto L_0x0112
            java.nio.ByteBuffer[] r2 = r25.getOutputBuffers()
            goto L_0x0107
        L_0x0112:
            r6 = -2
            if (r3 != r6) goto L_0x011e
            android.media.MediaFormat r8 = r25.getOutputFormat()
            r5 = 0
            r1.a((android.media.MediaFormat) r8, (int) r5)
            goto L_0x0120
        L_0x011e:
            if (r3 >= 0) goto L_0x0121
        L_0x0120:
            goto L_0x0107
        L_0x0121:
            r5 = r2[r3]
            int r8 = r13.flags
            r8 = r8 & 4
            if (r8 == 0) goto L_0x012c
            r22 = 1
            goto L_0x012e
        L_0x012c:
            r22 = 0
        L_0x012e:
            if (r22 == 0) goto L_0x0139
            cy.h$a r0 = r1.C
            if (r0 == 0) goto L_0x0137
            r0.a()
        L_0x0137:
            r8 = 0
            goto L_0x013a
        L_0x0139:
            r8 = r0
        L_0x013a:
            long r6 = r13.presentationTimeUs
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0146
            if (r22 != 0) goto L_0x0146
            r7 = r27
            r0 = r8
            goto L_0x00fe
        L_0x0146:
            int r0 = r13.size
            if (r0 == 0) goto L_0x0178
            int r0 = r13.offset
            r5.position(r0)
            int r0 = r13.offset
            int r6 = r13.size
            int r0 = r0 + r6
            r5.limit(r0)
            boolean r0 = r1.B
            if (r0 != 0) goto L_0x0171
            java.lang.Object r6 = r1.A
            monitor-enter(r6)
            boolean r0 = r1.B     // Catch:{ all -> 0x016e }
            if (r0 != 0) goto L_0x016c
            java.lang.Object r0 = r1.A     // Catch:{ InterruptedException -> 0x0168 }
            r0.wait()     // Catch:{ InterruptedException -> 0x0168 }
            goto L_0x016c
        L_0x0168:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x016e }
        L_0x016c:
            monitor-exit(r6)     // Catch:{ all -> 0x016e }
            goto L_0x0171
        L_0x016e:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x016e }
            throw r0
        L_0x0171:
            android.media.MediaMuxer r0 = r1.f26588g
            int r6 = r1.f26589i
            r0.writeSampleData(r6, r5, r13)
        L_0x0178:
            r5 = 0
            r10.releaseOutputBuffer(r3, r5)
            r0 = r8
        L_0x017d:
            r7 = r27
            goto L_0x00fe
        L_0x0181:
            r0 = r2
            r15 = r22
            r14 = 0
            goto L_0x001e
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cy.h.a(android.media.MediaCodec, android.media.MediaCodec, android.media.MediaExtractor, cy.c, cy.b, long, long, long):void");
    }

    private void a(MediaFormat mediaFormat, int i2) {
        if (i2 == 0) {
            this.f26589i = this.f26588g.addTrack(mediaFormat);
        }
        synchronized (this.A) {
            if (this.f26589i != -1 && !this.B) {
                this.f26588g.start();
                this.B = true;
                this.A.notify();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        int i2;
        int i3;
        int i4 = this.f26595o;
        if (i4 == 0 || i4 == 180) {
            i3 = this.f26593m;
            i2 = this.f26594n;
        } else {
            i3 = this.f26594n;
            i2 = this.f26593m;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i3, i2);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 30000000);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", 0);
        this.f26586e.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        c cVar = new c(this.f26586e.createInputSurface());
        this.f26599s = cVar;
        cVar.b();
        this.f26586e.start();
        this.f26598r = new b(this.f26593m, this.f26594n, this.f26602v);
        if (this.f26601u != null) {
            Log.e("hero", "---gpuFilter 不为null哟----设置进outputSurface里面");
            this.f26598r.a(this.f26601u);
        }
        this.f26585d.configure(this.f26600t, this.f26598r.b(), (MediaCrypto) null, 0);
        this.f26585d.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f26603w     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x0061
            boolean r0 = r6.f26604x     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0061
        L_0x000a:
            android.media.MediaExtractor r0 = r6.f26587f     // Catch:{ all -> 0x0063 }
            r0.release()     // Catch:{ all -> 0x0063 }
            android.media.MediaMuxer r0 = r6.f26588g     // Catch:{ all -> 0x0063 }
            r0.stop()     // Catch:{ all -> 0x0063 }
            android.media.MediaMuxer r0 = r6.f26588g     // Catch:{ all -> 0x0063 }
            r0.release()     // Catch:{ all -> 0x0063 }
            cy.b r0 = r6.f26598r     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x0020
            r0.a()     // Catch:{ all -> 0x0063 }
        L_0x0020:
            cy.c r0 = r6.f26599s     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x0027
            r0.a()     // Catch:{ all -> 0x0063 }
        L_0x0027:
            android.media.MediaCodec r0 = r6.f26585d     // Catch:{ all -> 0x0063 }
            r0.stop()     // Catch:{ all -> 0x0063 }
            android.media.MediaCodec r0 = r6.f26585d     // Catch:{ all -> 0x0063 }
            r0.release()     // Catch:{ all -> 0x0063 }
            android.media.MediaCodec r0 = r6.f26586e     // Catch:{ all -> 0x0063 }
            r0.stop()     // Catch:{ all -> 0x0063 }
            android.media.MediaCodec r0 = r6.f26586e     // Catch:{ all -> 0x0063 }
            r0.release()     // Catch:{ all -> 0x0063 }
            r0 = 1
            r6.f26604x = r0     // Catch:{ all -> 0x0063 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0063 }
            r6.f26606z = r0     // Catch:{ all -> 0x0063 }
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r1.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "cutVideo count1="
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            long r2 = r6.f26606z     // Catch:{ all -> 0x0063 }
            long r4 = r6.f26605y     // Catch:{ all -> 0x0063 }
            long r2 = r2 - r4
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0063 }
            r0.println(r1)     // Catch:{ all -> 0x0063 }
            monitor-exit(r6)
            return
        L_0x0061:
            monitor-exit(r6)
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cy.h.c():void");
    }

    public void a() {
        this.F = true;
    }

    public void a(long j2, long j3) throws IOException {
        this.f26605y = System.currentTimeMillis();
        this.f26591k = j2;
        this.f26592l = j3;
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f26587f = mediaExtractor;
        mediaExtractor.setDataSource(this.f26584c);
        this.f26588g = new MediaMuxer(this.f26583b, 0);
        for (int i2 = 0; i2 < this.f26587f.getTrackCount(); i2++) {
            MediaFormat trackFormat = this.f26587f.getTrackFormat(i2);
            if (trackFormat.getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                this.f26590j = i2;
                this.f26600t = trackFormat;
            }
        }
        f26581h.execute(this.G);
    }

    public void a(Context context, String str, String str2) {
        this.f26584c = str;
        a(context, str2);
    }

    public void a(a aVar) {
        this.C = aVar;
    }

    public void a(String str) {
        this.f26583b = str;
    }
}
