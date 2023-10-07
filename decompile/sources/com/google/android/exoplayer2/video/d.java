package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.ab;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.video.j;
import fi.e;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class d extends MediaCodecRenderer {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f17222c = {1920, 1600, 1440, 1280, 960, 854, GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 540, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH};

    /* renamed from: d  reason: collision with root package name */
    private static boolean f17223d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f17224e;
    private long A;
    private int B;
    private float C = -1.0f;
    private MediaFormat D;
    private int E = -1;
    private int F = -1;
    private int G;
    private float H = -1.0f;
    private int I;
    private int J;
    private int K;
    private float L;
    private boolean M;
    private int N;
    private long O = -9223372036854775807L;
    private long P = -9223372036854775807L;
    private int Q;
    private g R;

    /* renamed from: b  reason: collision with root package name */
    b f17225b;

    /* renamed from: f  reason: collision with root package name */
    private final Context f17226f;

    /* renamed from: g  reason: collision with root package name */
    private final h f17227g;

    /* renamed from: h  reason: collision with root package name */
    private final j.a f17228h;

    /* renamed from: i  reason: collision with root package name */
    private final long f17229i;

    /* renamed from: j  reason: collision with root package name */
    private final int f17230j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f17231k = T();

    /* renamed from: l  reason: collision with root package name */
    private final long[] f17232l = new long[10];

    /* renamed from: m  reason: collision with root package name */
    private final long[] f17233m = new long[10];

    /* renamed from: n  reason: collision with root package name */
    private a f17234n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17235o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f17236p;

    /* renamed from: q  reason: collision with root package name */
    private Surface f17237q;

    /* renamed from: r  reason: collision with root package name */
    private Surface f17238r;

    /* renamed from: s  reason: collision with root package name */
    private int f17239s = 1;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17240t;

    /* renamed from: u  reason: collision with root package name */
    private long f17241u;

    /* renamed from: v  reason: collision with root package name */
    private long f17242v = -9223372036854775807L;

    /* renamed from: w  reason: collision with root package name */
    private long f17243w;

    /* renamed from: x  reason: collision with root package name */
    private int f17244x;

    /* renamed from: y  reason: collision with root package name */
    private int f17245y;

    /* renamed from: z  reason: collision with root package name */
    private int f17246z;

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f17247a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17248b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17249c;

        public a(int i2, int i3, int i4) {
            this.f17247a = i2;
            this.f17248b = i3;
            this.f17249c = i4;
        }
    }

    private final class b implements MediaCodec.OnFrameRenderedListener, Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f17251b;

        public b(MediaCodec mediaCodec) {
            Handler handler = new Handler(this);
            this.f17251b = handler;
            mediaCodec.setOnFrameRenderedListener(this, handler);
        }

        private void a(long j2) {
            if (this == d.this.f17225b) {
                if (j2 == Long.MAX_VALUE) {
                    d.this.L();
                } else {
                    d.this.e(j2);
                }
            }
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a(ad.b(message.arg1, message.arg2));
            return true;
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
            if (ad.f11755a < 30) {
                this.f17251b.sendMessageAtFrontOfQueue(Message.obtain(this.f17251b, 0, (int) (j2 >> 32), (int) j2));
                return;
            }
            a(j2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(Context context, com.google.android.exoplayer2.mediacodec.b bVar, long j2, com.google.android.exoplayer2.drm.b<f> bVar2, boolean z2, boolean z3, Handler handler, j jVar, int i2) {
        super(2, bVar, bVar2, z2, z3, 30.0f);
        this.f17229i = j2;
        this.f17230j = i2;
        Context applicationContext = context.getApplicationContext();
        this.f17226f = applicationContext;
        this.f17227g = new h(applicationContext);
        this.f17228h = new j.a(handler, jVar);
        P();
    }

    /* access modifiers changed from: private */
    public void L() {
        K();
    }

    private void M() {
        this.f17242v = this.f17229i > 0 ? SystemClock.elapsedRealtime() + this.f17229i : -9223372036854775807L;
    }

    private void N() {
        MediaCodec E2;
        this.f17240t = false;
        if (ad.f11755a >= 23 && this.M && (E2 = E()) != null) {
            this.f17225b = new b(E2);
        }
    }

    private void O() {
        if (this.f17240t) {
            this.f17228h.a(this.f17237q);
        }
    }

    private void P() {
        this.I = -1;
        this.J = -1;
        this.L = -1.0f;
        this.K = -1;
    }

    private void Q() {
        int i2 = this.E;
        if (i2 != -1 || this.F != -1) {
            if (this.I != i2 || this.J != this.F || this.K != this.G || this.L != this.H) {
                this.f17228h.a(i2, this.F, this.G, this.H);
                this.I = this.E;
                this.J = this.F;
                this.K = this.G;
                this.L = this.H;
            }
        }
    }

    private void R() {
        int i2 = this.I;
        if (i2 != -1 || this.J != -1) {
            this.f17228h.a(i2, this.J, this.K, this.L);
        }
    }

    private void S() {
        if (this.f17244x > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f17228h.a(this.f17244x, elapsedRealtime - this.f17243w);
            this.f17244x = 0;
            this.f17243w = elapsedRealtime;
        }
    }

    private static boolean T() {
        return "NVIDIA".equals(ad.f11757c);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.exoplayer2.mediacodec.a r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x00a6
            if (r8 != r0) goto L_0x0007
            goto L_0x00a6
        L_0x0007:
            r6.hashCode()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r6 = -1
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r6 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r6 = 4
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r6 = 3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r6 = 2
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r6 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r6 = 0
        L_0x0057:
            switch(r6) {
                case 0: goto L_0x009d;
                case 1: goto L_0x009a;
                case 2: goto L_0x009d;
                case 3: goto L_0x005b;
                case 4: goto L_0x009d;
                case 5: goto L_0x009a;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            java.lang.String r6 = com.google.android.exoplayer2.util.ad.f11758d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = com.google.android.exoplayer2.util.ad.f11757c
            java.lang.String r1 = "Amazon"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0088
            java.lang.String r6 = com.google.android.exoplayer2.util.ad.f11758d
            java.lang.String r1 = "KFSOWI"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = com.google.android.exoplayer2.util.ad.f11758d
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0088
            boolean r5 = r5.f15834g
            if (r5 == 0) goto L_0x0088
            goto L_0x0099
        L_0x0088:
            r5 = 16
            int r6 = com.google.android.exoplayer2.util.ad.a((int) r7, (int) r5)
            int r7 = com.google.android.exoplayer2.util.ad.a((int) r8, (int) r5)
            int r6 = r6 * r7
            int r6 = r6 * 16
            int r7 = r6 * 16
            goto L_0x009f
        L_0x0099:
            return r0
        L_0x009a:
            int r7 = r7 * r8
            goto L_0x00a0
        L_0x009d:
            int r7 = r7 * r8
        L_0x009f:
            r2 = 2
        L_0x00a0:
            int r7 = r7 * 3
            int r2 = r2 * 2
            int r7 = r7 / r2
            return r7
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(com.google.android.exoplayer2.mediacodec.a, java.lang.String, int, int):int");
    }

    private static Point a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) {
        boolean z2 = format.f15098o > format.f15097n;
        int i2 = z2 ? format.f15098o : format.f15097n;
        int i3 = z2 ? format.f15097n : format.f15098o;
        float f2 = ((float) i3) / ((float) i2);
        for (int i4 : f17222c) {
            int i5 = (int) (((float) i4) * f2);
            if (i4 <= i2 || i5 <= i3) {
                break;
            }
            if (ad.f11755a >= 21) {
                int i6 = z2 ? i5 : i4;
                if (!z2) {
                    i4 = i5;
                }
                Point a2 = aVar.a(i6, i4);
                if (aVar.a(a2.x, a2.y, (double) format.f15099p)) {
                    return a2;
                }
            } else {
                try {
                    int a3 = ad.a(i4, 16) * 16;
                    int a4 = ad.a(i5, 16) * 16;
                    if (a3 * a4 <= MediaCodecUtil.b()) {
                        int i7 = z2 ? a4 : a3;
                        if (!z2) {
                            a3 = a4;
                        }
                        return new Point(i7, a3);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static List<com.google.android.exoplayer2.mediacodec.a> a(com.google.android.exoplayer2.mediacodec.b bVar, Format format, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> a2;
        String str;
        String str2 = format.f15092i;
        if (str2 == null) {
            return Collections.emptyList();
        }
        List<com.google.android.exoplayer2.mediacodec.a> a3 = MediaCodecUtil.a(bVar.a(str2, z2, z3), format);
        if ("video/dolby-vision".equals(str2) && (a2 = MediaCodecUtil.a(format)) != null) {
            int intValue = ((Integer) a2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                str = "video/hevc";
            } else if (intValue == 512) {
                str = "video/avc";
            }
            a3.addAll(bVar.a(str, z2, z3));
        }
        return Collections.unmodifiableList(a3);
    }

    private void a(long j2, long j3, Format format, MediaFormat mediaFormat) {
        g gVar = this.R;
        if (gVar != null) {
            gVar.a(j2, j3, format, mediaFormat);
        }
    }

    private void a(MediaCodec mediaCodec, int i2, int i3) {
        this.E = i2;
        this.F = i3;
        this.H = this.C;
        if (ad.f11755a >= 21) {
            int i4 = this.B;
            if (i4 == 90 || i4 == 270) {
                int i5 = this.E;
                this.E = this.F;
                this.F = i5;
                this.H = 1.0f / this.H;
            }
        } else {
            this.G = this.B;
        }
        mediaCodec.setVideoScalingMode(this.f17239s);
    }

    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private static void a(MediaCodec mediaCodec, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    private static void a(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private void a(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.f17238r;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.a F2 = F();
                if (F2 != null && b(F2)) {
                    surface = DummySurface.a(this.f17226f, F2.f15834g);
                    this.f17238r = surface;
                }
            }
        }
        if (this.f17237q != surface) {
            this.f17237q = surface;
            int m_ = m_();
            MediaCodec E2 = E();
            if (E2 != null) {
                if (ad.f11755a < 23 || surface == null || this.f17235o) {
                    G();
                    C();
                } else {
                    a(E2, surface);
                }
            }
            if (surface == null || surface == this.f17238r) {
                P();
                N();
                return;
            }
            R();
            N();
            if (m_ == 2) {
                M();
            }
        } else if (surface != null && surface != this.f17238r) {
            R();
            O();
        }
    }

    private static int b(com.google.android.exoplayer2.mediacodec.a aVar, Format format) {
        if (format.f15093j == -1) {
            return a(aVar, format.f15092i, format.f15097n, format.f15098o);
        }
        int size = format.f15094k.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.f15094k.get(i3).length;
        }
        return format.f15093j + i2;
    }

    private boolean b(com.google.android.exoplayer2.mediacodec.a aVar) {
        return ad.f11755a >= 23 && !this.M && !a(aVar.f15828a) && (!aVar.f15834g || DummySurface.a(this.f17226f));
    }

    private static boolean f(long j2) {
        return j2 < -30000;
    }

    private static boolean g(long j2) {
        return j2 < -500000;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        if (!this.f17240t) {
            this.f17240t = true;
            this.f17228h.a(this.f17237q);
        }
    }

    /* access modifiers changed from: protected */
    public boolean D() {
        return this.M && ad.f11755a < 23;
    }

    /* access modifiers changed from: protected */
    public void G() {
        try {
            super.G();
        } finally {
            this.f17246z = 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        try {
            return super.I();
        } finally {
            this.f17246z = 0;
        }
    }

    /* access modifiers changed from: protected */
    public float a(float f2, Format format, Format[] formatArr) {
        float f3 = -1.0f;
        for (Format format2 : formatArr) {
            float f4 = format2.f15099p;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    /* access modifiers changed from: protected */
    public int a(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.a aVar, Format format, Format format2) {
        if (!aVar.a(format, format2, true) || format2.f15097n > this.f17234n.f17247a || format2.f15098o > this.f17234n.f17248b || b(aVar, format2) > this.f17234n.f17249c) {
            return 0;
        }
        return format.b(format2) ? 3 : 2;
    }

    /* access modifiers changed from: protected */
    public int a(com.google.android.exoplayer2.mediacodec.b bVar, com.google.android.exoplayer2.drm.b<f> bVar2, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2 = 0;
        if (!n.b(format.f15092i)) {
            return aa.CC.b(0);
        }
        DrmInitData drmInitData = format.f15095l;
        boolean z2 = drmInitData != null;
        List<com.google.android.exoplayer2.mediacodec.a> a2 = a(bVar, format, z2, false);
        if (z2 && a2.isEmpty()) {
            a2 = a(bVar, format, false, false);
        }
        if (a2.isEmpty()) {
            return aa.CC.b(1);
        }
        if (!(drmInitData == null || f.class.equals(format.C) || (format.C == null && a((com.google.android.exoplayer2.drm.b<?>) bVar2, drmInitData)))) {
            return aa.CC.b(2);
        }
        com.google.android.exoplayer2.mediacodec.a aVar = a2.get(0);
        boolean a3 = aVar.a(format);
        int i3 = aVar.c(format) ? 16 : 8;
        if (a3) {
            List<com.google.android.exoplayer2.mediacodec.a> a4 = a(bVar, format, z2, true);
            if (!a4.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.a aVar2 = a4.get(0);
                if (aVar2.a(format) && aVar2.c(format)) {
                    i2 = 32;
                }
            }
        }
        return aa.CC.a(a3 ? 4 : 3, i3, i2);
    }

    /* access modifiers changed from: protected */
    public MediaFormat a(Format format, String str, a aVar, float f2, boolean z2, int i2) {
        Pair<Integer, Integer> a2;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("width", format.f15097n);
        mediaFormat.setInteger("height", format.f15098o);
        c.a(mediaFormat, format.f15094k);
        c.a(mediaFormat, "frame-rate", format.f15099p);
        c.a(mediaFormat, "rotation-degrees", format.f15100q);
        c.a(mediaFormat, format.f15104u);
        if ("video/dolby-vision".equals(format.f15092i) && (a2 = MediaCodecUtil.a(format)) != null) {
            c.a(mediaFormat, "profile", ((Integer) a2.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f17247a);
        mediaFormat.setInteger("max-height", aVar.f17248b);
        c.a(mediaFormat, "max-input-size", aVar.f17249c);
        if (ad.f11755a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            a(mediaFormat, i2);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public a a(com.google.android.exoplayer2.mediacodec.a aVar, Format format, Format[] formatArr) {
        int a2;
        int i2 = format.f15097n;
        int i3 = format.f15098o;
        int b2 = b(aVar, format);
        if (formatArr.length == 1) {
            if (!(b2 == -1 || (a2 = a(aVar, format.f15092i, format.f15097n, format.f15098o)) == -1)) {
                b2 = Math.min((int) (((float) b2) * 1.5f), a2);
            }
            return new a(i2, i3, b2);
        }
        boolean z2 = false;
        for (Format format2 : formatArr) {
            if (aVar.a(format, format2, false)) {
                z2 |= format2.f15097n == -1 || format2.f15098o == -1;
                i2 = Math.max(i2, format2.f15097n);
                i3 = Math.max(i3, format2.f15098o);
                b2 = Math.max(b2, b(aVar, format2));
            }
        }
        if (z2) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            k.c("MediaCodecVideoRenderer", sb.toString());
            Point a3 = a(aVar, format);
            if (a3 != null) {
                i2 = Math.max(i2, a3.x);
                i3 = Math.max(i3, a3.y);
                b2 = Math.max(b2, a(aVar, format.f15092i, i2, i3));
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i2);
                sb2.append("x");
                sb2.append(i3);
                k.c("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new a(i2, i3, b2);
    }

    /* access modifiers changed from: protected */
    public List<com.google.android.exoplayer2.mediacodec.a> a(com.google.android.exoplayer2.mediacodec.b bVar, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return a(bVar, format, z2, this.M);
    }

    public void a(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 1) {
            a((Surface) obj);
        } else if (i2 == 4) {
            this.f17239s = ((Integer) obj).intValue();
            MediaCodec E2 = E();
            if (E2 != null) {
                E2.setVideoScalingMode(this.f17239s);
            }
        } else if (i2 == 6) {
            this.R = (g) obj;
        } else {
            super.a(i2, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ExoPlaybackException {
        super.a(j2, z2);
        N();
        this.f17241u = -9223372036854775807L;
        this.f17245y = 0;
        this.O = -9223372036854775807L;
        int i2 = this.Q;
        if (i2 != 0) {
            this.P = this.f17232l[i2 - 1];
            this.Q = 0;
        }
        if (z2) {
            M();
        } else {
            this.f17242v = -9223372036854775807L;
        }
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, int i2, long j2) {
        ab.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        ab.a();
        this.f15773a.f27309f++;
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, int i2, long j2, long j3) {
        Q();
        ab.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        ab.a();
        this.A = SystemClock.elapsedRealtime() * 1000;
        this.f15773a.f27308e++;
        this.f17245y = 0;
        A();
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.D = mediaFormat;
        boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        a(mediaCodec, z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width"), z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height"));
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2) {
        String str = aVar.f15830c;
        a a2 = a(aVar, format, u());
        this.f17234n = a2;
        MediaFormat a3 = a(format, str, a2, f2, this.f17231k, this.N);
        if (this.f17237q == null) {
            com.google.android.exoplayer2.util.a.b(b(aVar));
            if (this.f17238r == null) {
                this.f17238r = DummySurface.a(this.f17226f, aVar.f15834g);
            }
            this.f17237q = this.f17238r;
        }
        mediaCodec.configure(a3, this.f17237q, mediaCrypto, 0);
        if (ad.f11755a >= 23 && this.M) {
            this.f17225b = new b(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public void a(o oVar) throws ExoPlaybackException {
        super.a(oVar);
        Format format = oVar.f15972c;
        this.f17228h.a(format);
        this.C = format.f15101r;
        this.B = format.f15100q;
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
        if (!this.M) {
            this.f17246z++;
        }
        this.O = Math.max(eVar.f13101d, this.O);
        if (ad.f11755a < 23 && this.M) {
            e(eVar.f13101d);
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f17228h.a(str, j2, j3);
        this.f17235o = a(str);
        this.f17236p = ((com.google.android.exoplayer2.mediacodec.a) com.google.android.exoplayer2.util.a.b(F())).b();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ExoPlaybackException {
        super.a(z2);
        int i2 = this.N;
        int i3 = v().f15121b;
        this.N = i3;
        this.M = i3 != 0;
        if (i3 != i2) {
            G();
        }
        this.f17228h.a(this.f15773a);
        this.f17227g.a();
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws ExoPlaybackException {
        if (this.P == -9223372036854775807L) {
            this.P = j2;
        } else {
            int i2 = this.Q;
            long[] jArr = this.f17232l;
            if (i2 == jArr.length) {
                long j3 = jArr[i2 - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j3);
                k.c("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.Q = i2 + 1;
            }
            long[] jArr2 = this.f17232l;
            int i3 = this.Q;
            jArr2[i3 - 1] = j2;
            this.f17233m[i3 - 1] = this.O;
        }
        super.a(formatArr, j2);
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        long j5 = j2;
        MediaCodec mediaCodec2 = mediaCodec;
        int i4 = i2;
        long j6 = j4;
        if (this.f17241u == -9223372036854775807L) {
            this.f17241u = j5;
        }
        long j7 = j6 - this.P;
        if (!z2 || z3) {
            long j8 = j6 - j5;
            if (this.f17237q != this.f17238r) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                long j9 = elapsedRealtime - this.A;
                long j10 = elapsedRealtime;
                boolean z4 = m_() == 2;
                if (this.f17242v == -9223372036854775807L && j5 >= this.P && (!this.f17240t || (z4 && b(j8, j9)))) {
                    long nanoTime = System.nanoTime();
                    a(j7, nanoTime, format, this.D);
                    if (ad.f11755a >= 21) {
                        a(mediaCodec, i2, j7, nanoTime);
                        return true;
                    }
                    c(mediaCodec2, i4, j7);
                    return true;
                }
                if (z4 && j5 != this.f17241u) {
                    long nanoTime2 = System.nanoTime();
                    long a2 = this.f17227g.a(j4, ((j8 - (j10 - j3)) * 1000) + nanoTime2);
                    long j11 = (a2 - nanoTime2) / 1000;
                    boolean z5 = this.f17242v != -9223372036854775807L;
                    if (b(j11, j3, z3) && a(mediaCodec, i2, j7, j2, z5)) {
                        return false;
                    }
                    if (a(j11, j3, z3)) {
                        if (z5) {
                            a(mediaCodec2, i4, j7);
                            return true;
                        }
                        b(mediaCodec2, i4, j7);
                        return true;
                    } else if (ad.f11755a >= 21) {
                        if (j11 < 50000) {
                            a(j7, a2, format, this.D);
                            a(mediaCodec, i2, j7, a2);
                            return true;
                        }
                    } else if (j11 < 30000) {
                        if (j11 > 11000) {
                            try {
                                Thread.sleep((j11 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        a(j7, a2, format, this.D);
                        c(mediaCodec2, i4, j7);
                        return true;
                    }
                }
                return false;
            } else if (!f(j8)) {
                return false;
            } else {
                a(mediaCodec2, i4, j7);
                return true;
            }
        } else {
            a(mediaCodec2, i4, j7);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, boolean z2) {
        return f(j2) && !z2;
    }

    /* access modifiers changed from: protected */
    public boolean a(MediaCodec mediaCodec, int i2, long j2, long j3, boolean z2) throws ExoPlaybackException {
        int b2 = b(j3);
        if (b2 == 0) {
            return false;
        }
        this.f15773a.f27312i++;
        int i3 = this.f17246z + b2;
        if (z2) {
            this.f15773a.f27309f += i3;
        } else {
            g(i3);
        }
        H();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(com.google.android.exoplayer2.mediacodec.a aVar) {
        return this.f17237q != null || b(aVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0619, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x061a, code lost:
        switch(r3) {
            case 0: goto L_0x061e;
            case 1: goto L_0x061e;
            case 2: goto L_0x061e;
            case 3: goto L_0x061e;
            case 4: goto L_0x061e;
            case 5: goto L_0x061e;
            case 6: goto L_0x061e;
            case 7: goto L_0x061e;
            case 8: goto L_0x061e;
            case 9: goto L_0x061e;
            case 10: goto L_0x061e;
            case 11: goto L_0x061e;
            case 12: goto L_0x061e;
            case 13: goto L_0x061e;
            case 14: goto L_0x061e;
            case 15: goto L_0x061e;
            case 16: goto L_0x061e;
            case 17: goto L_0x061e;
            case 18: goto L_0x061e;
            case 19: goto L_0x061e;
            case 20: goto L_0x061e;
            case 21: goto L_0x061e;
            case 22: goto L_0x061e;
            case 23: goto L_0x061e;
            case 24: goto L_0x061e;
            case 25: goto L_0x061e;
            case 26: goto L_0x061e;
            case 27: goto L_0x061e;
            case 28: goto L_0x061e;
            case 29: goto L_0x061e;
            case 30: goto L_0x061e;
            case 31: goto L_0x061e;
            case 32: goto L_0x061e;
            case 33: goto L_0x061e;
            case 34: goto L_0x061e;
            case 35: goto L_0x061e;
            case 36: goto L_0x061e;
            case 37: goto L_0x061e;
            case 38: goto L_0x061e;
            case 39: goto L_0x061e;
            case 40: goto L_0x061e;
            case 41: goto L_0x061e;
            case 42: goto L_0x061e;
            case 43: goto L_0x061e;
            case 44: goto L_0x061e;
            case 45: goto L_0x061e;
            case 46: goto L_0x061e;
            case 47: goto L_0x061e;
            case 48: goto L_0x061e;
            case 49: goto L_0x061e;
            case 50: goto L_0x061e;
            case 51: goto L_0x061e;
            case 52: goto L_0x061e;
            case 53: goto L_0x061e;
            case 54: goto L_0x061e;
            case 55: goto L_0x061e;
            case 56: goto L_0x061e;
            case 57: goto L_0x061e;
            case 58: goto L_0x061e;
            case 59: goto L_0x061e;
            case 60: goto L_0x061e;
            case 61: goto L_0x061e;
            case 62: goto L_0x061e;
            case 63: goto L_0x061e;
            case 64: goto L_0x061e;
            case 65: goto L_0x061e;
            case 66: goto L_0x061e;
            case 67: goto L_0x061e;
            case 68: goto L_0x061e;
            case 69: goto L_0x061e;
            case 70: goto L_0x061e;
            case 71: goto L_0x061e;
            case 72: goto L_0x061e;
            case 73: goto L_0x061e;
            case 74: goto L_0x061e;
            case 75: goto L_0x061e;
            case 76: goto L_0x061e;
            case 77: goto L_0x061e;
            case 78: goto L_0x061e;
            case 79: goto L_0x061e;
            case 80: goto L_0x061e;
            case 81: goto L_0x061e;
            case 82: goto L_0x061e;
            case 83: goto L_0x061e;
            case 84: goto L_0x061e;
            case 85: goto L_0x061e;
            case 86: goto L_0x061e;
            case 87: goto L_0x061e;
            case 88: goto L_0x061e;
            case 89: goto L_0x061e;
            case 90: goto L_0x061e;
            case 91: goto L_0x061e;
            case 92: goto L_0x061e;
            case 93: goto L_0x061e;
            case 94: goto L_0x061e;
            case 95: goto L_0x061e;
            case 96: goto L_0x061e;
            case 97: goto L_0x061e;
            case 98: goto L_0x061e;
            case 99: goto L_0x061e;
            case 100: goto L_0x061e;
            case 101: goto L_0x061e;
            case 102: goto L_0x061e;
            case 103: goto L_0x061e;
            case 104: goto L_0x061e;
            case 105: goto L_0x061e;
            case 106: goto L_0x061e;
            case 107: goto L_0x061e;
            case 108: goto L_0x061e;
            case 109: goto L_0x061e;
            case 110: goto L_0x061e;
            case 111: goto L_0x061e;
            case 112: goto L_0x061e;
            case 113: goto L_0x061e;
            case 114: goto L_0x061e;
            case 115: goto L_0x061e;
            case 116: goto L_0x061e;
            case 117: goto L_0x061e;
            case 118: goto L_0x061e;
            case 119: goto L_0x061e;
            case 120: goto L_0x061e;
            case 121: goto L_0x061e;
            case 122: goto L_0x061e;
            case 123: goto L_0x061e;
            case 124: goto L_0x061e;
            case 125: goto L_0x061e;
            default: goto L_0x061d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x061e, code lost:
        f17224e = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0620, code lost:
        r1 = com.google.android.exoplayer2.util.ad.f11758d;
        r3 = r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0629, code lost:
        if (r3 == -594534941) goto L_0x0649;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x062e, code lost:
        if (r3 == 2006354) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0633, code lost:
        if (r3 == 2006367) goto L_0x0636;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x063c, code lost:
        if (r1.equals("AFTN") == false) goto L_0x0653;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x063e, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0646, code lost:
        if (r1.equals("AFTA") == false) goto L_0x0653;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x064f, code lost:
        if (r1.equals("JSN-L21") == false) goto L_0x0653;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x0651, code lost:
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0653, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0654, code lost:
        if (r0 == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x0656, code lost:
        if (r0 == 1) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0658, code lost:
        if (r0 == 2) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "OMX.google"
            boolean r8 = r8.startsWith(r0)
            r0 = 0
            if (r8 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class<com.google.android.exoplayer2.video.d> r8 = com.google.android.exoplayer2.video.d.class
            monitor-enter(r8)
            boolean r1 = f17223d     // Catch:{ all -> 0x0660 }
            if (r1 != 0) goto L_0x065c
            java.lang.String r1 = "dangal"
            java.lang.String r2 = com.google.android.exoplayer2.util.ad.f11756b     // Catch:{ all -> 0x0660 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0660 }
            r2 = 1
            if (r1 == 0) goto L_0x0020
        L_0x001c:
            f17224e = r2     // Catch:{ all -> 0x0660 }
            goto L_0x065a
        L_0x0020:
            int r1 = com.google.android.exoplayer2.util.ad.f11755a     // Catch:{ all -> 0x0660 }
            r3 = 27
            if (r1 > r3) goto L_0x0031
            java.lang.String r1 = "HWEML"
            java.lang.String r4 = com.google.android.exoplayer2.util.ad.f11756b     // Catch:{ all -> 0x0660 }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0031
            goto L_0x001c
        L_0x0031:
            int r1 = com.google.android.exoplayer2.util.ad.f11755a     // Catch:{ all -> 0x0660 }
            if (r1 < r3) goto L_0x0037
            goto L_0x065a
        L_0x0037:
            java.lang.String r1 = com.google.android.exoplayer2.util.ad.f11756b     // Catch:{ all -> 0x0660 }
            int r4 = r1.hashCode()     // Catch:{ all -> 0x0660 }
            r5 = -1
            r6 = 2
            switch(r4) {
                case -2144781245: goto L_0x060e;
                case -2144781185: goto L_0x0603;
                case -2144781160: goto L_0x05f8;
                case -2097309513: goto L_0x05ed;
                case -2022874474: goto L_0x05e2;
                case -1978993182: goto L_0x05d7;
                case -1978990237: goto L_0x05cc;
                case -1936688988: goto L_0x05c1;
                case -1936688066: goto L_0x05b6;
                case -1936688065: goto L_0x05aa;
                case -1931988508: goto L_0x059e;
                case -1696512866: goto L_0x0592;
                case -1680025915: goto L_0x0586;
                case -1615810839: goto L_0x057a;
                case -1554255044: goto L_0x056e;
                case -1481772737: goto L_0x0562;
                case -1481772730: goto L_0x0556;
                case -1481772729: goto L_0x054a;
                case -1320080169: goto L_0x053e;
                case -1217592143: goto L_0x0532;
                case -1180384755: goto L_0x0526;
                case -1139198265: goto L_0x051a;
                case -1052835013: goto L_0x050e;
                case -993250464: goto L_0x0503;
                case -993250458: goto L_0x04f8;
                case -965403638: goto L_0x04ec;
                case -958336948: goto L_0x04e0;
                case -879245230: goto L_0x04d4;
                case -842500323: goto L_0x04c8;
                case -821392978: goto L_0x04bd;
                case -797483286: goto L_0x04b1;
                case -794946968: goto L_0x04a5;
                case -788334647: goto L_0x0499;
                case -782144577: goto L_0x048d;
                case -575125681: goto L_0x0481;
                case -521118391: goto L_0x0475;
                case -430914369: goto L_0x0469;
                case -290434366: goto L_0x045d;
                case -282781963: goto L_0x0451;
                case -277133239: goto L_0x0445;
                case -173639913: goto L_0x0439;
                case -56598463: goto L_0x042d;
                case 2126: goto L_0x0421;
                case 2564: goto L_0x0415;
                case 2715: goto L_0x0409;
                case 2719: goto L_0x03fd;
                case 3483: goto L_0x03f1;
                case 73405: goto L_0x03e5;
                case 75739: goto L_0x03d9;
                case 76779: goto L_0x03cd;
                case 78669: goto L_0x03c1;
                case 79305: goto L_0x03b5;
                case 80618: goto L_0x03a9;
                case 88274: goto L_0x039d;
                case 98846: goto L_0x0391;
                case 98848: goto L_0x0385;
                case 99329: goto L_0x0379;
                case 101481: goto L_0x036d;
                case 1513190: goto L_0x0362;
                case 1514184: goto L_0x0357;
                case 1514185: goto L_0x034c;
                case 2436959: goto L_0x0340;
                case 2463773: goto L_0x0334;
                case 2464648: goto L_0x0328;
                case 2689555: goto L_0x031c;
                case 3154429: goto L_0x0310;
                case 3284551: goto L_0x0304;
                case 3351335: goto L_0x02f8;
                case 3386211: goto L_0x02ec;
                case 41325051: goto L_0x02e0;
                case 55178625: goto L_0x02d4;
                case 61542055: goto L_0x02c9;
                case 65355429: goto L_0x02bd;
                case 66214468: goto L_0x02b1;
                case 66214470: goto L_0x02a5;
                case 66214473: goto L_0x0299;
                case 66215429: goto L_0x028d;
                case 66215431: goto L_0x0281;
                case 66215433: goto L_0x0275;
                case 66216390: goto L_0x0269;
                case 76402249: goto L_0x025d;
                case 76404105: goto L_0x0251;
                case 76404911: goto L_0x0245;
                case 80963634: goto L_0x0239;
                case 82882791: goto L_0x022d;
                case 98715550: goto L_0x0221;
                case 101370885: goto L_0x0215;
                case 102844228: goto L_0x0209;
                case 165221241: goto L_0x01fe;
                case 182191441: goto L_0x01f2;
                case 245388979: goto L_0x01e6;
                case 287431619: goto L_0x01da;
                case 307593612: goto L_0x01ce;
                case 308517133: goto L_0x01c2;
                case 316215098: goto L_0x01b6;
                case 316215116: goto L_0x01aa;
                case 316246811: goto L_0x019e;
                case 316246818: goto L_0x0192;
                case 407160593: goto L_0x0186;
                case 507412548: goto L_0x017a;
                case 793982701: goto L_0x016e;
                case 794038622: goto L_0x0162;
                case 794040393: goto L_0x0156;
                case 835649806: goto L_0x014a;
                case 917340916: goto L_0x013e;
                case 958008161: goto L_0x0132;
                case 1060579533: goto L_0x0126;
                case 1150207623: goto L_0x011a;
                case 1176899427: goto L_0x010e;
                case 1280332038: goto L_0x0102;
                case 1306947716: goto L_0x00f6;
                case 1349174697: goto L_0x00ea;
                case 1522194893: goto L_0x00de;
                case 1691543273: goto L_0x00d2;
                case 1709443163: goto L_0x00c6;
                case 1865889110: goto L_0x00ba;
                case 1906253259: goto L_0x00ae;
                case 1977196784: goto L_0x00a2;
                case 2006372676: goto L_0x0096;
                case 2029784656: goto L_0x008a;
                case 2030379515: goto L_0x007e;
                case 2033393791: goto L_0x0072;
                case 2047190025: goto L_0x0068;
                case 2047252157: goto L_0x005c;
                case 2048319463: goto L_0x0050;
                case 2048855701: goto L_0x0044;
                default: goto L_0x0042;
            }     // Catch:{ all -> 0x0660 }
        L_0x0042:
            goto L_0x0619
        L_0x0044:
            java.lang.String r3 = "HWWAS-H"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 55
            goto L_0x061a
        L_0x0050:
            java.lang.String r3 = "HWVNS-H"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 54
            goto L_0x061a
        L_0x005c:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 28
            goto L_0x061a
        L_0x0068:
            java.lang.String r4 = "ELUGA_Note"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            goto L_0x061a
        L_0x0072:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 12
            goto L_0x061a
        L_0x007e:
            java.lang.String r3 = "HWCAM-H"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 53
            goto L_0x061a
        L_0x008a:
            java.lang.String r3 = "HWBLN-H"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 52
            goto L_0x061a
        L_0x0096:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 16
            goto L_0x061a
        L_0x00a2:
            java.lang.String r3 = "Infinix-X572"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 58
            goto L_0x061a
        L_0x00ae:
            java.lang.String r3 = "PB2-670M"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 87
            goto L_0x061a
        L_0x00ba:
            java.lang.String r3 = "santoni"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x061a
        L_0x00c6:
            java.lang.String r3 = "iball8735_9806"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 57
            goto L_0x061a
        L_0x00d2:
            java.lang.String r3 = "CPH1609"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 20
            goto L_0x061a
        L_0x00de:
            java.lang.String r3 = "woods_f"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x061a
        L_0x00ea:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 50
            goto L_0x061a
        L_0x00f6:
            java.lang.String r3 = "EverStar_S"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 30
            goto L_0x061a
        L_0x0102:
            java.lang.String r3 = "hwALE-H"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 51
            goto L_0x061a
        L_0x010e:
            java.lang.String r3 = "itel_S41"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 60
            goto L_0x061a
        L_0x011a:
            java.lang.String r3 = "LS-5017"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 67
            goto L_0x061a
        L_0x0126:
            java.lang.String r3 = "panell_d"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 83
            goto L_0x061a
        L_0x0132:
            java.lang.String r3 = "j2xlteins"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 61
            goto L_0x061a
        L_0x013e:
            java.lang.String r3 = "A7000plus"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 8
            goto L_0x061a
        L_0x014a:
            java.lang.String r3 = "manning"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 69
            goto L_0x061a
        L_0x0156:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 48
            goto L_0x061a
        L_0x0162:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 47
            goto L_0x061a
        L_0x016e:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 46
            goto L_0x061a
        L_0x017a:
            java.lang.String r3 = "QM16XE_U"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x061a
        L_0x0186:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 93
            goto L_0x061a
        L_0x0192:
            java.lang.String r3 = "TB3-850M"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x061a
        L_0x019e:
            java.lang.String r3 = "TB3-850F"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x061a
        L_0x01aa:
            java.lang.String r3 = "TB3-730X"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x061a
        L_0x01b6:
            java.lang.String r3 = "TB3-730F"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x061a
        L_0x01c2:
            java.lang.String r3 = "A7020a48"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 10
            goto L_0x061a
        L_0x01ce:
            java.lang.String r3 = "A7010a48"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 9
            goto L_0x061a
        L_0x01da:
            java.lang.String r3 = "griffin"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 49
            goto L_0x061a
        L_0x01e6:
            java.lang.String r3 = "marino_f"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 70
            goto L_0x061a
        L_0x01f2:
            java.lang.String r3 = "CPY83_I00"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 21
            goto L_0x061a
        L_0x01fe:
            java.lang.String r3 = "A2016a40"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 6
            goto L_0x061a
        L_0x0209:
            java.lang.String r3 = "le_x6"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 66
            goto L_0x061a
        L_0x0215:
            java.lang.String r3 = "l5460"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 65
            goto L_0x061a
        L_0x0221:
            java.lang.String r3 = "i9031"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 56
            goto L_0x061a
        L_0x022d:
            java.lang.String r3 = "X3_HK"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x061a
        L_0x0239:
            java.lang.String r3 = "V23GB"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x061a
        L_0x0245:
            java.lang.String r3 = "Q4310"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 99
            goto L_0x061a
        L_0x0251:
            java.lang.String r3 = "Q4260"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 97
            goto L_0x061a
        L_0x025d:
            java.lang.String r3 = "PRO7S"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 95
            goto L_0x061a
        L_0x0269:
            java.lang.String r3 = "F3311"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 37
            goto L_0x061a
        L_0x0275:
            java.lang.String r3 = "F3215"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 36
            goto L_0x061a
        L_0x0281:
            java.lang.String r3 = "F3213"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 35
            goto L_0x061a
        L_0x028d:
            java.lang.String r3 = "F3211"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 34
            goto L_0x061a
        L_0x0299:
            java.lang.String r3 = "F3116"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 33
            goto L_0x061a
        L_0x02a5:
            java.lang.String r3 = "F3113"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 32
            goto L_0x061a
        L_0x02b1:
            java.lang.String r3 = "F3111"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 31
            goto L_0x061a
        L_0x02bd:
            java.lang.String r3 = "E5643"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 25
            goto L_0x061a
        L_0x02c9:
            java.lang.String r3 = "A1601"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 5
            goto L_0x061a
        L_0x02d4:
            java.lang.String r3 = "Aura_Note_2"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 13
            goto L_0x061a
        L_0x02e0:
            java.lang.String r3 = "MEIZU_M5"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 71
            goto L_0x061a
        L_0x02ec:
            java.lang.String r3 = "p212"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 80
            goto L_0x061a
        L_0x02f8:
            java.lang.String r3 = "mido"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 73
            goto L_0x061a
        L_0x0304:
            java.lang.String r3 = "kate"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 64
            goto L_0x061a
        L_0x0310:
            java.lang.String r3 = "fugu"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 39
            goto L_0x061a
        L_0x031c:
            java.lang.String r3 = "XE2X"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x061a
        L_0x0328:
            java.lang.String r3 = "Q427"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 98
            goto L_0x061a
        L_0x0334:
            java.lang.String r3 = "Q350"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 96
            goto L_0x061a
        L_0x0340:
            java.lang.String r3 = "P681"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 81
            goto L_0x061a
        L_0x034c:
            java.lang.String r3 = "1714"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 2
            goto L_0x061a
        L_0x0357:
            java.lang.String r3 = "1713"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 1
            goto L_0x061a
        L_0x0362:
            java.lang.String r3 = "1601"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 0
            goto L_0x061a
        L_0x036d:
            java.lang.String r3 = "flo"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 38
            goto L_0x061a
        L_0x0379:
            java.lang.String r3 = "deb"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 24
            goto L_0x061a
        L_0x0385:
            java.lang.String r3 = "cv3"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 23
            goto L_0x061a
        L_0x0391:
            java.lang.String r3 = "cv1"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 22
            goto L_0x061a
        L_0x039d:
            java.lang.String r3 = "Z80"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x061a
        L_0x03a9:
            java.lang.String r3 = "QX1"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x061a
        L_0x03b5:
            java.lang.String r3 = "PLE"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 94
            goto L_0x061a
        L_0x03c1:
            java.lang.String r3 = "P85"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 82
            goto L_0x061a
        L_0x03cd:
            java.lang.String r3 = "MX6"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 74
            goto L_0x061a
        L_0x03d9:
            java.lang.String r3 = "M5c"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 68
            goto L_0x061a
        L_0x03e5:
            java.lang.String r3 = "JGZ"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 62
            goto L_0x061a
        L_0x03f1:
            java.lang.String r3 = "mh"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 72
            goto L_0x061a
        L_0x03fd:
            java.lang.String r3 = "V5"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x061a
        L_0x0409:
            java.lang.String r3 = "V1"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x061a
        L_0x0415:
            java.lang.String r3 = "Q5"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 100
            goto L_0x061a
        L_0x0421:
            java.lang.String r3 = "C1"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 17
            goto L_0x061a
        L_0x042d:
            java.lang.String r3 = "woods_fn"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x061a
        L_0x0439:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 26
            goto L_0x061a
        L_0x0445:
            java.lang.String r3 = "Z12_PRO"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x061a
        L_0x0451:
            java.lang.String r3 = "BLACK-1X"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 14
            goto L_0x061a
        L_0x045d:
            java.lang.String r3 = "taido_row"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x061a
        L_0x0469:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 92
            goto L_0x061a
        L_0x0475:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 42
            goto L_0x061a
        L_0x0481:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 40
            goto L_0x061a
        L_0x048d:
            java.lang.String r3 = "OnePlus5T"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 79
            goto L_0x061a
        L_0x0499:
            java.lang.String r3 = "whyred"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x061a
        L_0x04a5:
            java.lang.String r3 = "watson"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x061a
        L_0x04b1:
            java.lang.String r3 = "SVP-DTV15"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x061a
        L_0x04bd:
            java.lang.String r3 = "A7000-a"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 7
            goto L_0x061a
        L_0x04c8:
            java.lang.String r3 = "nicklaus_f"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 76
            goto L_0x061a
        L_0x04d4:
            java.lang.String r3 = "tcl_eu"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x061a
        L_0x04e0:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 29
            goto L_0x061a
        L_0x04ec:
            java.lang.String r3 = "s905x018"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x061a
        L_0x04f8:
            java.lang.String r3 = "A10-70L"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 4
            goto L_0x061a
        L_0x0503:
            java.lang.String r3 = "A10-70F"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 3
            goto L_0x061a
        L_0x050e:
            java.lang.String r3 = "namath"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 75
            goto L_0x061a
        L_0x051a:
            java.lang.String r3 = "Slate_Pro"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x061a
        L_0x0526:
            java.lang.String r3 = "iris60"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 59
            goto L_0x061a
        L_0x0532:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 15
            goto L_0x061a
        L_0x053e:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 41
            goto L_0x061a
        L_0x054a:
            java.lang.String r3 = "panell_dt"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 86
            goto L_0x061a
        L_0x0556:
            java.lang.String r3 = "panell_ds"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 85
            goto L_0x061a
        L_0x0562:
            java.lang.String r3 = "panell_dl"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 84
            goto L_0x061a
        L_0x056e:
            java.lang.String r3 = "vernee_M5"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x061a
        L_0x057a:
            java.lang.String r3 = "Phantom6"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 91
            goto L_0x061a
        L_0x0586:
            java.lang.String r3 = "ComioS1"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 18
            goto L_0x061a
        L_0x0592:
            java.lang.String r3 = "XT1663"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x061a
        L_0x059e:
            java.lang.String r3 = "AquaPowerM"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 11
            goto L_0x061a
        L_0x05aa:
            java.lang.String r3 = "PGN611"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 90
            goto L_0x061a
        L_0x05b6:
            java.lang.String r3 = "PGN610"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 89
            goto L_0x061a
        L_0x05c1:
            java.lang.String r3 = "PGN528"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 88
            goto L_0x061a
        L_0x05cc:
            java.lang.String r3 = "NX573J"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 78
            goto L_0x061a
        L_0x05d7:
            java.lang.String r3 = "NX541J"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 77
            goto L_0x061a
        L_0x05e2:
            java.lang.String r3 = "CP8676_I02"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 19
            goto L_0x061a
        L_0x05ed:
            java.lang.String r3 = "K50a40"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 63
            goto L_0x061a
        L_0x05f8:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 45
            goto L_0x061a
        L_0x0603:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 44
            goto L_0x061a
        L_0x060e:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0619
            r3 = 43
            goto L_0x061a
        L_0x0619:
            r3 = -1
        L_0x061a:
            switch(r3) {
                case 0: goto L_0x061e;
                case 1: goto L_0x061e;
                case 2: goto L_0x061e;
                case 3: goto L_0x061e;
                case 4: goto L_0x061e;
                case 5: goto L_0x061e;
                case 6: goto L_0x061e;
                case 7: goto L_0x061e;
                case 8: goto L_0x061e;
                case 9: goto L_0x061e;
                case 10: goto L_0x061e;
                case 11: goto L_0x061e;
                case 12: goto L_0x061e;
                case 13: goto L_0x061e;
                case 14: goto L_0x061e;
                case 15: goto L_0x061e;
                case 16: goto L_0x061e;
                case 17: goto L_0x061e;
                case 18: goto L_0x061e;
                case 19: goto L_0x061e;
                case 20: goto L_0x061e;
                case 21: goto L_0x061e;
                case 22: goto L_0x061e;
                case 23: goto L_0x061e;
                case 24: goto L_0x061e;
                case 25: goto L_0x061e;
                case 26: goto L_0x061e;
                case 27: goto L_0x061e;
                case 28: goto L_0x061e;
                case 29: goto L_0x061e;
                case 30: goto L_0x061e;
                case 31: goto L_0x061e;
                case 32: goto L_0x061e;
                case 33: goto L_0x061e;
                case 34: goto L_0x061e;
                case 35: goto L_0x061e;
                case 36: goto L_0x061e;
                case 37: goto L_0x061e;
                case 38: goto L_0x061e;
                case 39: goto L_0x061e;
                case 40: goto L_0x061e;
                case 41: goto L_0x061e;
                case 42: goto L_0x061e;
                case 43: goto L_0x061e;
                case 44: goto L_0x061e;
                case 45: goto L_0x061e;
                case 46: goto L_0x061e;
                case 47: goto L_0x061e;
                case 48: goto L_0x061e;
                case 49: goto L_0x061e;
                case 50: goto L_0x061e;
                case 51: goto L_0x061e;
                case 52: goto L_0x061e;
                case 53: goto L_0x061e;
                case 54: goto L_0x061e;
                case 55: goto L_0x061e;
                case 56: goto L_0x061e;
                case 57: goto L_0x061e;
                case 58: goto L_0x061e;
                case 59: goto L_0x061e;
                case 60: goto L_0x061e;
                case 61: goto L_0x061e;
                case 62: goto L_0x061e;
                case 63: goto L_0x061e;
                case 64: goto L_0x061e;
                case 65: goto L_0x061e;
                case 66: goto L_0x061e;
                case 67: goto L_0x061e;
                case 68: goto L_0x061e;
                case 69: goto L_0x061e;
                case 70: goto L_0x061e;
                case 71: goto L_0x061e;
                case 72: goto L_0x061e;
                case 73: goto L_0x061e;
                case 74: goto L_0x061e;
                case 75: goto L_0x061e;
                case 76: goto L_0x061e;
                case 77: goto L_0x061e;
                case 78: goto L_0x061e;
                case 79: goto L_0x061e;
                case 80: goto L_0x061e;
                case 81: goto L_0x061e;
                case 82: goto L_0x061e;
                case 83: goto L_0x061e;
                case 84: goto L_0x061e;
                case 85: goto L_0x061e;
                case 86: goto L_0x061e;
                case 87: goto L_0x061e;
                case 88: goto L_0x061e;
                case 89: goto L_0x061e;
                case 90: goto L_0x061e;
                case 91: goto L_0x061e;
                case 92: goto L_0x061e;
                case 93: goto L_0x061e;
                case 94: goto L_0x061e;
                case 95: goto L_0x061e;
                case 96: goto L_0x061e;
                case 97: goto L_0x061e;
                case 98: goto L_0x061e;
                case 99: goto L_0x061e;
                case 100: goto L_0x061e;
                case 101: goto L_0x061e;
                case 102: goto L_0x061e;
                case 103: goto L_0x061e;
                case 104: goto L_0x061e;
                case 105: goto L_0x061e;
                case 106: goto L_0x061e;
                case 107: goto L_0x061e;
                case 108: goto L_0x061e;
                case 109: goto L_0x061e;
                case 110: goto L_0x061e;
                case 111: goto L_0x061e;
                case 112: goto L_0x061e;
                case 113: goto L_0x061e;
                case 114: goto L_0x061e;
                case 115: goto L_0x061e;
                case 116: goto L_0x061e;
                case 117: goto L_0x061e;
                case 118: goto L_0x061e;
                case 119: goto L_0x061e;
                case 120: goto L_0x061e;
                case 121: goto L_0x061e;
                case 122: goto L_0x061e;
                case 123: goto L_0x061e;
                case 124: goto L_0x061e;
                case 125: goto L_0x061e;
                default: goto L_0x061d;
            }     // Catch:{ all -> 0x0660 }
        L_0x061d:
            goto L_0x0620
        L_0x061e:
            f17224e = r2     // Catch:{ all -> 0x0660 }
        L_0x0620:
            java.lang.String r1 = com.google.android.exoplayer2.util.ad.f11758d     // Catch:{ all -> 0x0660 }
            int r3 = r1.hashCode()     // Catch:{ all -> 0x0660 }
            r4 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r3 == r4) goto L_0x0649
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r3 == r4) goto L_0x0640
            r0 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r3 == r0) goto L_0x0636
            goto L_0x0653
        L_0x0636:
            java.lang.String r0 = "AFTN"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0660 }
            if (r0 == 0) goto L_0x0653
            r0 = 1
            goto L_0x0654
        L_0x0640:
            java.lang.String r3 = "AFTA"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0660 }
            if (r1 == 0) goto L_0x0653
            goto L_0x0654
        L_0x0649:
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0660 }
            if (r0 == 0) goto L_0x0653
            r0 = 2
            goto L_0x0654
        L_0x0653:
            r0 = -1
        L_0x0654:
            if (r0 == 0) goto L_0x001c
            if (r0 == r2) goto L_0x001c
            if (r0 == r6) goto L_0x001c
        L_0x065a:
            f17223d = r2     // Catch:{ all -> 0x0660 }
        L_0x065c:
            monitor-exit(r8)     // Catch:{ all -> 0x0660 }
            boolean r8 = f17224e
            return r8
        L_0x0660:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0660 }
            goto L_0x0664
        L_0x0663:
            throw r0
        L_0x0664:
            goto L_0x0663
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public void b(MediaCodec mediaCodec, int i2, long j2) {
        ab.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        ab.a();
        g(1);
    }

    /* access modifiers changed from: protected */
    public void b(e eVar) throws ExoPlaybackException {
        if (this.f17236p) {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.b(eVar.f13102e);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s2 == 60 && s3 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    a(E(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(long j2, long j3) {
        return f(j2) && j3 > 100000;
    }

    /* access modifiers changed from: protected */
    public boolean b(long j2, long j3, boolean z2) {
        return g(j2) && !z2;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        if (!this.M) {
            this.f17246z--;
        }
        while (true) {
            int i2 = this.Q;
            if (i2 != 0 && j2 >= this.f17233m[0]) {
                long[] jArr = this.f17232l;
                this.P = jArr[0];
                int i3 = i2 - 1;
                this.Q = i3;
                System.arraycopy(jArr, 1, jArr, 0, i3);
                long[] jArr2 = this.f17233m;
                System.arraycopy(jArr2, 1, jArr2, 0, this.Q);
                N();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(MediaCodec mediaCodec, int i2, long j2) {
        Q();
        ab.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        ab.a();
        this.A = SystemClock.elapsedRealtime() * 1000;
        this.f15773a.f27308e++;
        this.f17245y = 0;
        A();
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        Format d2 = d(j2);
        if (d2 != null) {
            a(E(), d2.f15097n, d2.f15098o);
        }
        Q();
        this.f15773a.f27308e++;
        A();
        c(j2);
    }

    /* access modifiers changed from: protected */
    public void g(int i2) {
        this.f15773a.f27310g += i2;
        this.f17244x += i2;
        this.f17245y += i2;
        this.f15773a.f27311h = Math.max(this.f17245y, this.f15773a.f27311h);
        int i3 = this.f17230j;
        if (i3 > 0 && this.f17244x >= i3) {
            S();
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        this.f17244x = 0;
        this.f17243w = SystemClock.elapsedRealtime();
        this.A = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    public void q() {
        this.f17242v = -9223372036854775807L;
        S();
        super.q();
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.O = -9223372036854775807L;
        this.P = -9223372036854775807L;
        this.Q = 0;
        this.D = null;
        P();
        N();
        this.f17227g.b();
        this.f17225b = null;
        try {
            super.r();
        } finally {
            this.f17228h.b(this.f15773a);
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        try {
            super.s();
            Surface surface = this.f17238r;
            if (surface != null) {
                if (this.f17237q == surface) {
                    this.f17237q = null;
                }
                surface.release();
                this.f17238r = null;
            }
        } catch (Throwable th) {
            if (this.f17238r != null) {
                Surface surface2 = this.f17237q;
                Surface surface3 = this.f17238r;
                if (surface2 == surface3) {
                    this.f17237q = null;
                }
                surface3.release();
                this.f17238r = null;
            }
            throw th;
        }
    }

    public boolean y() {
        Surface surface;
        if (super.y() && (this.f17240t || (((surface = this.f17238r) != null && this.f17237q == surface) || E() == null || this.M))) {
            this.f17242v = -9223372036854775807L;
            return true;
        } else if (this.f17242v == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f17242v) {
                return true;
            }
            this.f17242v = -9223372036854775807L;
            return false;
        }
    }
}
