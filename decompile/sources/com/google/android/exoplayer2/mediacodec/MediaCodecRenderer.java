package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ab;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.z;
import com.xeagle.android.login.common.NetworkUtil;
import fi.e;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaCodecRenderer extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f15772b = {0, 0, 1, 103, 66, -64, NetworkUtil.CURRENT_NETWORK_TYPE_CUC, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private a A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ByteBuffer[] M;
    private ByteBuffer[] N;
    private long O;
    private int P;
    private int Q;
    private ByteBuffer R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V = 0;
    private int W = 0;
    private int X = 0;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    protected fi.d f15773a;

    /* renamed from: aa  reason: collision with root package name */
    private boolean f15774aa;

    /* renamed from: ab  reason: collision with root package name */
    private long f15775ab;

    /* renamed from: ac  reason: collision with root package name */
    private long f15776ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f15777ad;

    /* renamed from: ae  reason: collision with root package name */
    private boolean f15778ae;

    /* renamed from: af  reason: collision with root package name */
    private boolean f15779af;

    /* renamed from: ag  reason: collision with root package name */
    private boolean f15780ag;

    /* renamed from: ah  reason: collision with root package name */
    private boolean f15781ah;

    /* renamed from: ai  reason: collision with root package name */
    private boolean f15782ai;

    /* renamed from: aj  reason: collision with root package name */
    private boolean f15783aj;

    /* renamed from: c  reason: collision with root package name */
    private final b f15784c;

    /* renamed from: d  reason: collision with root package name */
    private final b<f> f15785d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15786e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15787f;

    /* renamed from: g  reason: collision with root package name */
    private final float f15788g;

    /* renamed from: h  reason: collision with root package name */
    private final e f15789h = new e(0);

    /* renamed from: i  reason: collision with root package name */
    private final e f15790i = e.a();

    /* renamed from: j  reason: collision with root package name */
    private final z<Format> f15791j = new z<>();

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<Long> f15792k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private final MediaCodec.BufferInfo f15793l = new MediaCodec.BufferInfo();

    /* renamed from: m  reason: collision with root package name */
    private boolean f15794m;

    /* renamed from: n  reason: collision with root package name */
    private Format f15795n;

    /* renamed from: o  reason: collision with root package name */
    private Format f15796o;

    /* renamed from: p  reason: collision with root package name */
    private DrmSession<f> f15797p;

    /* renamed from: q  reason: collision with root package name */
    private DrmSession<f> f15798q;

    /* renamed from: r  reason: collision with root package name */
    private MediaCrypto f15799r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f15800s;

    /* renamed from: t  reason: collision with root package name */
    private long f15801t = -9223372036854775807L;

    /* renamed from: u  reason: collision with root package name */
    private float f15802u = 1.0f;

    /* renamed from: v  reason: collision with root package name */
    private MediaCodec f15803v;

    /* renamed from: w  reason: collision with root package name */
    private Format f15804w;

    /* renamed from: x  reason: collision with root package name */
    private float f15805x = -1.0f;

    /* renamed from: y  reason: collision with root package name */
    private ArrayDeque<a> f15806y;

    /* renamed from: z  reason: collision with root package name */
    private DecoderInitializationException f15807z;

    public static class DecoderInitializationException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final String f15808a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f15809b;

        /* renamed from: c  reason: collision with root package name */
        public final a f15810c;

        /* renamed from: d  reason: collision with root package name */
        public final String f15811d;

        /* renamed from: e  reason: collision with root package name */
        public final DecoderInitializationException f15812e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r12, java.lang.Throwable r13, boolean r14, int r15) {
            /*
                r11 = this;
                java.lang.String r0 = java.lang.String.valueOf(r12)
                java.lang.String r1 = java.lang.String.valueOf(r0)
                int r1 = r1.length()
                int r1 = r1 + 36
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Decoder init failed: ["
                r2.append(r1)
                r2.append(r15)
                java.lang.String r1 = "], "
                r2.append(r1)
                r2.append(r0)
                java.lang.String r4 = r2.toString()
                java.lang.String r6 = r12.f15092i
                java.lang.String r9 = a((int) r15)
                r8 = 0
                r10 = 0
                r3 = r11
                r5 = r13
                r7 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, int):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r9, java.lang.Throwable r10, boolean r11, com.google.android.exoplayer2.mediacodec.a r12) {
            /*
                r8 = this;
                java.lang.String r0 = r12.f15828a
                java.lang.String r1 = java.lang.String.valueOf(r9)
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 23
                java.lang.String r3 = java.lang.String.valueOf(r1)
                int r3 = r3.length()
                int r2 = r2 + r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Decoder init failed: "
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = ", "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                java.lang.String r3 = r9.f15092i
                int r0 = com.google.android.exoplayer2.util.ad.f11755a
                r2 = 21
                if (r0 < r2) goto L_0x003f
                java.lang.String r0 = a((java.lang.Throwable) r10)
                goto L_0x0040
            L_0x003f:
                r0 = 0
            L_0x0040:
                r6 = r0
                r7 = 0
                r0 = r8
                r2 = r10
                r4 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, com.google.android.exoplayer2.mediacodec.a):void");
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z2, a aVar, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.f15808a = str2;
            this.f15809b = z2;
            this.f15810c = aVar;
            this.f15811d = str3;
            this.f15812e = decoderInitializationException;
        }

        /* access modifiers changed from: private */
        public DecoderInitializationException a(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.f15808a, this.f15809b, this.f15810c, this.f15811d, decoderInitializationException);
        }

        private static String a(int i2) {
            String str = i2 < 0 ? "neg_" : "";
            int abs = Math.abs(i2);
            StringBuilder sb = new StringBuilder(str.length() + 71);
            sb.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb.append(str);
            sb.append(abs);
            return sb.toString();
        }

        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    public MediaCodecRenderer(int i2, b bVar, b<f> bVar2, boolean z2, boolean z3, float f2) {
        super(i2);
        this.f15784c = (b) a.b(bVar);
        this.f15785d = bVar2;
        this.f15786e = z2;
        this.f15787f = z3;
        this.f15788g = f2;
    }

    private void A() {
        if (ad.f11755a < 21) {
            this.M = null;
            this.N = null;
        }
    }

    private boolean L() {
        return this.Q >= 0;
    }

    private void M() {
        this.P = -1;
        this.f15789h.f13099b = null;
    }

    private void N() {
        this.Q = -1;
        this.R = null;
    }

    private boolean O() throws ExoPlaybackException {
        int i2;
        int i3;
        MediaCodec mediaCodec = this.f15803v;
        if (mediaCodec == null || this.W == 2 || this.f15777ad) {
            return false;
        }
        if (this.P < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.P = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.f15789h.f13099b = g(dequeueInputBuffer);
            this.f15789h.clear();
        }
        if (this.W == 1) {
            if (!this.L) {
                this.Z = true;
                this.f15803v.queueInputBuffer(this.P, 0, 0, 0, 4);
                M();
            }
            this.W = 2;
            return false;
        } else if (this.J) {
            this.J = false;
            ByteBuffer byteBuffer = this.f15789h.f13099b;
            byte[] bArr = f15772b;
            byteBuffer.put(bArr);
            this.f15803v.queueInputBuffer(this.P, 0, bArr.length, 0, 0);
            M();
            this.Y = true;
            return true;
        } else {
            o t2 = t();
            if (this.f15779af) {
                i3 = -4;
                i2 = 0;
            } else {
                if (this.V == 1) {
                    for (int i4 = 0; i4 < this.f15804w.f15094k.size(); i4++) {
                        this.f15789h.f13099b.put(this.f15804w.f15094k.get(i4));
                    }
                    this.V = 2;
                }
                i2 = this.f15789h.f13099b.position();
                i3 = a(t2, this.f15789h, false);
            }
            if (g()) {
                this.f15776ac = this.f15775ab;
            }
            if (i3 == -3) {
                return false;
            }
            if (i3 == -5) {
                if (this.V == 2) {
                    this.f15789h.clear();
                    this.V = 1;
                }
                a(t2);
                return true;
            } else if (this.f15789h.isEndOfStream()) {
                if (this.V == 2) {
                    this.f15789h.clear();
                    this.V = 1;
                }
                this.f15777ad = true;
                if (!this.Y) {
                    V();
                    return false;
                }
                try {
                    if (!this.L) {
                        this.Z = true;
                        this.f15803v.queueInputBuffer(this.P, 0, 0, 0, 4);
                        M();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw a((Exception) e2, this.f15795n);
                }
            } else if (!this.f15780ag || this.f15789h.isKeyFrame()) {
                this.f15780ag = false;
                boolean c2 = this.f15789h.c();
                boolean d2 = d(c2);
                this.f15779af = d2;
                if (d2) {
                    return false;
                }
                if (this.D && !c2) {
                    com.google.android.exoplayer2.util.o.a(this.f15789h.f13099b);
                    if (this.f15789h.f13099b.position() == 0) {
                        return true;
                    }
                    this.D = false;
                }
                try {
                    long j2 = this.f15789h.f13101d;
                    if (this.f15789h.isDecodeOnly()) {
                        this.f15792k.add(Long.valueOf(j2));
                    }
                    if (this.f15781ah) {
                        this.f15791j.a(j2, this.f15795n);
                        this.f15781ah = false;
                    }
                    this.f15775ab = Math.max(this.f15775ab, j2);
                    this.f15789h.d();
                    if (this.f15789h.hasSupplementalData()) {
                        b(this.f15789h);
                    }
                    a(this.f15789h);
                    if (c2) {
                        this.f15803v.queueSecureInputBuffer(this.P, 0, a(this.f15789h, i2), j2, 0);
                    } else {
                        this.f15803v.queueInputBuffer(this.P, 0, this.f15789h.f13099b.limit(), j2, 0);
                    }
                    M();
                    this.Y = true;
                    this.V = 0;
                    this.f15773a.f27306c++;
                    return true;
                } catch (MediaCodec.CryptoException e3) {
                    throw a((Exception) e3, this.f15795n);
                }
            } else {
                this.f15789h.clear();
                if (this.V == 2) {
                    this.V = 1;
                }
                return true;
            }
        }
    }

    private void P() throws ExoPlaybackException {
        if (ad.f11755a >= 23) {
            float a2 = a(this.f15802u, this.f15804w, u());
            float f2 = this.f15805x;
            if (f2 != a2) {
                if (a2 == -1.0f) {
                    S();
                } else if (f2 != -1.0f || a2 > this.f15788g) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", a2);
                    this.f15803v.setParameters(bundle);
                    this.f15805x = a2;
                }
            }
        }
    }

    private void Q() {
        if (this.Y) {
            this.W = 1;
            this.X = 1;
        }
    }

    private void R() throws ExoPlaybackException {
        if (ad.f11755a < 23) {
            S();
        } else if (this.Y) {
            this.W = 1;
            this.X = 2;
        } else {
            X();
        }
    }

    private void S() throws ExoPlaybackException {
        if (this.Y) {
            this.W = 1;
            this.X = 3;
            return;
        }
        W();
    }

    private void T() throws ExoPlaybackException {
        this.f15774aa = true;
        MediaFormat outputFormat = this.f15803v.getOutputFormat();
        if (this.B != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.K = true;
            return;
        }
        if (this.I) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.f15803v, outputFormat);
    }

    private void U() {
        if (ad.f11755a < 21) {
            this.N = this.f15803v.getOutputBuffers();
        }
    }

    private void V() throws ExoPlaybackException {
        int i2 = this.X;
        if (i2 == 1) {
            H();
        } else if (i2 == 2) {
            X();
        } else if (i2 != 3) {
            this.f15778ae = true;
            B();
        } else {
            W();
        }
    }

    private void W() throws ExoPlaybackException {
        G();
        C();
    }

    private void X() throws ExoPlaybackException {
        f f2 = this.f15798q.f();
        if (f2 == null) {
            W();
        } else if (com.google.android.exoplayer2.e.f15481e.equals(f2.f15474b)) {
            W();
        } else if (!H()) {
            try {
                this.f15799r.setMediaDrmSession(f2.f15475c);
                b(this.f15798q);
                this.W = 0;
                this.X = 0;
            } catch (MediaCryptoException e2) {
                throw a((Exception) e2, this.f15795n);
            }
        }
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i2) {
        MediaCodec.CryptoInfo a2 = eVar.f13098a.a();
        if (i2 == 0) {
            return a2;
        }
        if (a2.numBytesOfClearData == null) {
            a2.numBytesOfClearData = new int[1];
        }
        int[] iArr = a2.numBytesOfClearData;
        iArr[0] = iArr[0] + i2;
        return a2;
    }

    private void a(MediaCodec mediaCodec) {
        if (ad.f11755a < 21) {
            this.M = mediaCodec.getInputBuffers();
            this.N = mediaCodec.getOutputBuffers();
        }
    }

    private void a(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        if (this.f15806y == null) {
            try {
                List<a> c2 = c(z2);
                ArrayDeque<a> arrayDeque = new ArrayDeque<>();
                this.f15806y = arrayDeque;
                if (this.f15787f) {
                    arrayDeque.addAll(c2);
                } else if (!c2.isEmpty()) {
                    this.f15806y.add(c2.get(0));
                }
                this.f15807z = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(this.f15795n, (Throwable) e2, z2, -49998);
            }
        }
        if (!this.f15806y.isEmpty()) {
            while (this.f15803v == null) {
                a peekFirst = this.f15806y.peekFirst();
                if (a(peekFirst)) {
                    try {
                        a(peekFirst, mediaCrypto);
                    } catch (Exception e3) {
                        String valueOf = String.valueOf(peekFirst);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to initialize decoder: ");
                        sb.append(valueOf);
                        k.a("MediaCodecRenderer", sb.toString(), e3);
                        this.f15806y.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.f15795n, (Throwable) e3, z2, peekFirst);
                        if (this.f15807z == null) {
                            this.f15807z = decoderInitializationException;
                        } else {
                            this.f15807z = this.f15807z.a(decoderInitializationException);
                        }
                        if (this.f15806y.isEmpty()) {
                            throw this.f15807z;
                        }
                    }
                } else {
                    return;
                }
            }
            this.f15806y = null;
            return;
        }
        throw new DecoderInitializationException(this.f15795n, (Throwable) null, z2, -49999);
    }

    private void a(DrmSession<f> drmSession) {
        DrmSession.CC.a(this.f15798q, drmSession);
        this.f15798q = drmSession;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.mediacodec.a r17, android.media.MediaCrypto r18) throws java.lang.Exception {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r8 = r0.f15828a
            int r1 = com.google.android.exoplayer2.util.ad.f11755a
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = 23
            if (r1 >= r3) goto L_0x0011
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x001d
        L_0x0011:
            float r1 = r7.f15802u
            com.google.android.exoplayer2.Format r3 = r7.f15795n
            com.google.android.exoplayer2.Format[] r4 = r16.u()
            float r1 = r7.a((float) r1, (com.google.android.exoplayer2.Format) r3, (com.google.android.exoplayer2.Format[]) r4)
        L_0x001d:
            float r3 = r7.f15788g
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0026
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0027
        L_0x0026:
            r9 = r1
        L_0x0027:
            r1 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r2 = "createCodec:"
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0110 }
            int r4 = r3.length()     // Catch:{ Exception -> 0x0110 }
            if (r4 == 0) goto L_0x003d
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x0110 }
            goto L_0x0043
        L_0x003d:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0110 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0110 }
            r2 = r3
        L_0x0043:
            com.google.android.exoplayer2.util.ab.a(r2)     // Catch:{ Exception -> 0x0110 }
            android.media.MediaCodec r12 = android.media.MediaCodec.createByCodecName(r8)     // Catch:{ Exception -> 0x0110 }
            com.google.android.exoplayer2.util.ab.a()     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "configureCodec"
            com.google.android.exoplayer2.util.ab.a(r1)     // Catch:{ Exception -> 0x010d }
            com.google.android.exoplayer2.Format r4 = r7.f15795n     // Catch:{ Exception -> 0x010d }
            r1 = r16
            r2 = r17
            r3 = r12
            r5 = r18
            r6 = r9
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010d }
            com.google.android.exoplayer2.util.ab.a()     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "startCodec"
            com.google.android.exoplayer2.util.ab.a(r1)     // Catch:{ Exception -> 0x010d }
            r12.start()     // Catch:{ Exception -> 0x010d }
            com.google.android.exoplayer2.util.ab.a()     // Catch:{ Exception -> 0x010d }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x010d }
            r7.a((android.media.MediaCodec) r12)     // Catch:{ Exception -> 0x010d }
            r7.f15803v = r12
            r7.A = r0
            r7.f15805x = r9
            com.google.android.exoplayer2.Format r1 = r7.f15795n
            r7.f15804w = r1
            int r1 = r7.b((java.lang.String) r8)
            r7.B = r1
            boolean r1 = c((java.lang.String) r8)
            r7.C = r1
            com.google.android.exoplayer2.Format r1 = r7.f15804w
            boolean r1 = a((java.lang.String) r8, (com.google.android.exoplayer2.Format) r1)
            r7.D = r1
            boolean r1 = a((java.lang.String) r8)
            r7.E = r1
            boolean r1 = f((java.lang.String) r8)
            r7.F = r1
            boolean r1 = d((java.lang.String) r8)
            r7.G = r1
            boolean r1 = e((java.lang.String) r8)
            r7.H = r1
            com.google.android.exoplayer2.Format r1 = r7.f15804w
            boolean r1 = b((java.lang.String) r8, (com.google.android.exoplayer2.Format) r1)
            r7.I = r1
            boolean r0 = b((com.google.android.exoplayer2.mediacodec.a) r17)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x00c3
            boolean r0 = r16.D()
            if (r0 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r0 = 0
            goto L_0x00c4
        L_0x00c3:
            r0 = 1
        L_0x00c4:
            r7.L = r0
            r16.M()
            r16.N()
            int r0 = r16.m_()
            r5 = 2
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != r5) goto L_0x00e0
            long r5 = android.os.SystemClock.elapsedRealtime()
            r14 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 + r14
            goto L_0x00e1
        L_0x00e0:
            r5 = r12
        L_0x00e1:
            r7.O = r5
            r7.U = r2
            r7.V = r2
            r7.Z = r2
            r7.Y = r2
            r7.f15775ab = r12
            r7.f15776ac = r12
            r7.W = r2
            r7.X = r2
            r7.J = r2
            r7.K = r2
            r7.S = r2
            r7.T = r2
            r7.f15780ag = r1
            fi.d r0 = r7.f15773a
            int r2 = r0.f27304a
            int r2 = r2 + r1
            r0.f27304a = r2
            long r5 = r3 - r10
            r1 = r16
            r2 = r8
            r1.a((java.lang.String) r2, (long) r3, (long) r5)
            return
        L_0x010d:
            r0 = move-exception
            r1 = r12
            goto L_0x0111
        L_0x0110:
            r0 = move-exception
        L_0x0111:
            if (r1 == 0) goto L_0x0119
            r16.A()
            r1.release()
        L_0x0119:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.a(com.google.android.exoplayer2.mediacodec.a, android.media.MediaCrypto):void");
    }

    private static boolean a(DrmSession<f> drmSession, Format format) {
        f f2 = drmSession.f();
        if (f2 == null) {
            return true;
        }
        if (f2.f15476d) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(f2.f15474b, f2.f15475c);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.f15092i);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private static boolean a(IllegalStateException illegalStateException) {
        if (ad.f11755a >= 21 && b(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean a(String str) {
        return ad.f11755a < 18 || (ad.f11755a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (ad.f11755a == 19 && ad.f11758d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean a(String str, Format format) {
        return ad.f11755a < 21 && format.f15094k.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private int b(String str) {
        if (ad.f11755a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (ad.f11758d.startsWith("SM-T585") || ad.f11758d.startsWith("SM-A510") || ad.f11758d.startsWith("SM-A520") || ad.f11758d.startsWith("SM-J700"))) {
            return 2;
        }
        if (ad.f11755a >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(ad.f11756b) || "flounder_lte".equals(ad.f11756b) || "grouper".equals(ad.f11756b) || "tilapia".equals(ad.f11756b)) ? 1 : 0;
        }
        return 0;
    }

    private void b(DrmSession<f> drmSession) {
        DrmSession.CC.a(this.f15797p, drmSession);
        this.f15797p = drmSession;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(long r19, long r21) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r18 = this;
            r14 = r18
            boolean r0 = r18.L()
            r15 = 1
            r13 = 0
            if (r0 != 0) goto L_0x00b5
            boolean r0 = r14.H
            if (r0 == 0) goto L_0x002b
            boolean r0 = r14.Z
            if (r0 == 0) goto L_0x002b
            android.media.MediaCodec r0 = r14.f15803v     // Catch:{ IllegalStateException -> 0x001f }
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l     // Catch:{ IllegalStateException -> 0x001f }
            long r2 = r18.J()     // Catch:{ IllegalStateException -> 0x001f }
            int r0 = r0.dequeueOutputBuffer(r1, r2)     // Catch:{ IllegalStateException -> 0x001f }
            goto L_0x0037
        L_0x001f:
            r18.V()
            boolean r0 = r14.f15778ae
            if (r0 == 0) goto L_0x002a
            r18.G()
        L_0x002a:
            return r13
        L_0x002b:
            android.media.MediaCodec r0 = r14.f15803v
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l
            long r2 = r18.J()
            int r0 = r0.dequeueOutputBuffer(r1, r2)
        L_0x0037:
            if (r0 >= 0) goto L_0x0058
            r1 = -2
            if (r0 != r1) goto L_0x0040
            r18.T()
            return r15
        L_0x0040:
            r1 = -3
            if (r0 != r1) goto L_0x0047
            r18.U()
            return r15
        L_0x0047:
            boolean r0 = r14.L
            if (r0 == 0) goto L_0x0057
            boolean r0 = r14.f15777ad
            if (r0 != 0) goto L_0x0054
            int r0 = r14.W
            r1 = 2
            if (r0 != r1) goto L_0x0057
        L_0x0054:
            r18.V()
        L_0x0057:
            return r13
        L_0x0058:
            boolean r1 = r14.K
            if (r1 == 0) goto L_0x0064
            r14.K = r13
            android.media.MediaCodec r1 = r14.f15803v
            r1.releaseOutputBuffer(r0, r13)
            return r15
        L_0x0064:
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l
            int r1 = r1.size
            if (r1 != 0) goto L_0x0076
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0076
            r18.V()
            return r13
        L_0x0076:
            r14.Q = r0
            java.nio.ByteBuffer r0 = r14.h(r0)
            r14.R = r0
            if (r0 == 0) goto L_0x0095
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r14.R
            android.media.MediaCodec$BufferInfo r1 = r14.f15793l
            int r1 = r1.offset
            android.media.MediaCodec$BufferInfo r2 = r14.f15793l
            int r2 = r2.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x0095:
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            long r0 = r0.presentationTimeUs
            boolean r0 = r14.f((long) r0)
            r14.S = r0
            long r0 = r14.f15776ac
            android.media.MediaCodec$BufferInfo r2 = r14.f15793l
            long r2 = r2.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00ab
            r0 = 1
            goto L_0x00ac
        L_0x00ab:
            r0 = 0
        L_0x00ac:
            r14.T = r0
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            long r0 = r0.presentationTimeUs
            r14.d((long) r0)
        L_0x00b5:
            boolean r0 = r14.H
            if (r0 == 0) goto L_0x00f1
            boolean r0 = r14.Z
            if (r0 == 0) goto L_0x00f1
            android.media.MediaCodec r5 = r14.f15803v     // Catch:{ IllegalStateException -> 0x00e4 }
            java.nio.ByteBuffer r6 = r14.R     // Catch:{ IllegalStateException -> 0x00e4 }
            int r7 = r14.Q     // Catch:{ IllegalStateException -> 0x00e4 }
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l     // Catch:{ IllegalStateException -> 0x00e4 }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x00e4 }
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l     // Catch:{ IllegalStateException -> 0x00e4 }
            long r9 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00e4 }
            boolean r11 = r14.S     // Catch:{ IllegalStateException -> 0x00e4 }
            boolean r12 = r14.T     // Catch:{ IllegalStateException -> 0x00e4 }
            com.google.android.exoplayer2.Format r3 = r14.f15796o     // Catch:{ IllegalStateException -> 0x00e4 }
            r0 = r18
            r1 = r19
            r16 = r3
            r3 = r21
            r17 = 0
            r13 = r16
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)     // Catch:{ IllegalStateException -> 0x00e2 }
            goto L_0x0111
        L_0x00e2:
            goto L_0x00e6
        L_0x00e4:
            r17 = 0
        L_0x00e6:
            r18.V()
            boolean r0 = r14.f15778ae
            if (r0 == 0) goto L_0x00f0
            r18.G()
        L_0x00f0:
            return r17
        L_0x00f1:
            r17 = 0
            android.media.MediaCodec r5 = r14.f15803v
            java.nio.ByteBuffer r6 = r14.R
            int r7 = r14.Q
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            int r8 = r0.flags
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            long r9 = r0.presentationTimeUs
            boolean r11 = r14.S
            boolean r12 = r14.T
            com.google.android.exoplayer2.Format r13 = r14.f15796o
            r0 = r18
            r1 = r19
            r3 = r21
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)
        L_0x0111:
            if (r0 == 0) goto L_0x012e
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            long r0 = r0.presentationTimeUs
            r14.c((long) r0)
            android.media.MediaCodec$BufferInfo r0 = r14.f15793l
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0124
            r13 = 1
            goto L_0x0125
        L_0x0124:
            r13 = 0
        L_0x0125:
            r18.N()
            if (r13 != 0) goto L_0x012b
            return r15
        L_0x012b:
            r18.V()
        L_0x012e:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.b(long, long):boolean");
    }

    private static boolean b(a aVar) {
        String str = aVar.f15828a;
        return (ad.f11755a <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (ad.f11755a <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ("Amazon".equals(ad.f11757c) && "AFTS".equals(ad.f11758d) && aVar.f15834g);
    }

    private static boolean b(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean b(String str, Format format) {
        return ad.f11755a <= 18 && format.f15105v == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z2) throws ExoPlaybackException {
        o t2 = t();
        this.f15790i.clear();
        int a2 = a(t2, this.f15790i, z2);
        if (a2 == -5) {
            a(t2);
            return true;
        } else if (a2 != -4 || !this.f15790i.isEndOfStream()) {
            return false;
        } else {
            this.f15777ad = true;
            V();
            return false;
        }
    }

    private List<a> c(boolean z2) throws MediaCodecUtil.DecoderQueryException {
        List<a> a2 = a(this.f15784c, this.f15795n, z2);
        if (a2.isEmpty() && z2) {
            a2 = a(this.f15784c, this.f15795n, false);
            if (!a2.isEmpty()) {
                String str = this.f15795n.f15092i;
                String valueOf = String.valueOf(a2);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99 + String.valueOf(valueOf).length());
                sb.append("Drm session requires secure decoder for ");
                sb.append(str);
                sb.append(", but no secure decoder available. Trying to proceed with ");
                sb.append(valueOf);
                sb.append(".");
                k.c("MediaCodecRenderer", sb.toString());
            }
        }
        return a2;
    }

    private static boolean c(String str) {
        return ad.f11758d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean d(String str) {
        return (ad.f11755a <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (ad.f11755a <= 19 && (("hb2000".equals(ad.f11756b) || "stvm8".equals(ad.f11756b)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private boolean d(boolean z2) throws ExoPlaybackException {
        DrmSession<f> drmSession = this.f15797p;
        if (drmSession == null || (!z2 && (this.f15786e || drmSession.d()))) {
            return false;
        }
        int c2 = this.f15797p.c();
        if (c2 != 1) {
            return c2 != 4;
        }
        throw a((Exception) this.f15797p.e(), this.f15795n);
    }

    private boolean e(long j2) {
        return this.f15801t == -9223372036854775807L || SystemClock.elapsedRealtime() - j2 < this.f15801t;
    }

    private static boolean e(String str) {
        return ad.f11755a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean f(long j2) {
        int size = this.f15792k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f15792k.get(i2).longValue() == j2) {
                this.f15792k.remove(i2);
                return true;
            }
        }
        return false;
    }

    private static boolean f(String str) {
        return ad.f11755a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private ByteBuffer g(int i2) {
        return ad.f11755a >= 21 ? this.f15803v.getInputBuffer(i2) : this.M[i2];
    }

    private ByteBuffer h(int i2) {
        return ad.f11755a >= 21 ? this.f15803v.getOutputBuffer(i2) : this.N[i2];
    }

    /* access modifiers changed from: protected */
    public void B() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public final void C() throws ExoPlaybackException {
        if (this.f15803v == null && this.f15795n != null) {
            b(this.f15798q);
            String str = this.f15795n.f15092i;
            DrmSession<f> drmSession = this.f15797p;
            if (drmSession != null) {
                if (this.f15799r == null) {
                    f f2 = drmSession.f();
                    if (f2 != null) {
                        try {
                            this.f15799r = new MediaCrypto(f2.f15474b, f2.f15475c);
                            this.f15800s = !f2.f15476d && this.f15799r.requiresSecureDecoderComponent(str);
                        } catch (MediaCryptoException e2) {
                            throw a((Exception) e2, this.f15795n);
                        }
                    } else if (this.f15797p.e() == null) {
                        return;
                    }
                }
                if (f.f15473a) {
                    int c2 = this.f15797p.c();
                    if (c2 == 1) {
                        throw a((Exception) this.f15797p.e(), this.f15795n);
                    } else if (c2 != 4) {
                        return;
                    }
                }
            }
            try {
                a(this.f15799r, this.f15800s);
            } catch (DecoderInitializationException e3) {
                throw a((Exception) e3, this.f15795n);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean D() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec E() {
        return this.f15803v;
    }

    /* access modifiers changed from: protected */
    public final a F() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void G() {
        this.f15806y = null;
        this.A = null;
        this.f15804w = null;
        this.f15774aa = false;
        M();
        N();
        A();
        this.f15779af = false;
        this.O = -9223372036854775807L;
        this.f15792k.clear();
        this.f15775ab = -9223372036854775807L;
        this.f15776ac = -9223372036854775807L;
        try {
            if (this.f15803v != null) {
                this.f15773a.f27305b++;
                if (!this.f15782ai) {
                    this.f15803v.stop();
                }
                this.f15803v.release();
            }
            this.f15803v = null;
            try {
                MediaCrypto mediaCrypto = this.f15799r;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.f15799r = null;
                this.f15800s = false;
                b((DrmSession<f>) null);
            }
        } catch (Throwable th) {
            this.f15803v = null;
            try {
                MediaCrypto mediaCrypto2 = this.f15799r;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.f15799r = null;
                this.f15800s = false;
                b((DrmSession<f>) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean H() throws ExoPlaybackException {
        boolean I2 = I();
        if (I2) {
            C();
        }
        return I2;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        MediaCodec mediaCodec = this.f15803v;
        if (mediaCodec == null) {
            return false;
        }
        if (this.X == 3 || this.E || ((this.F && !this.f15774aa) || (this.G && this.Z))) {
            G();
            return true;
        }
        mediaCodec.flush();
        M();
        N();
        this.O = -9223372036854775807L;
        this.Z = false;
        this.Y = false;
        this.f15780ag = true;
        this.J = false;
        this.K = false;
        this.S = false;
        this.T = false;
        this.f15779af = false;
        this.f15792k.clear();
        this.f15775ab = -9223372036854775807L;
        this.f15776ac = -9223372036854775807L;
        this.W = 0;
        this.X = 0;
        this.V = this.U ? 1 : 0;
        return false;
    }

    /* access modifiers changed from: protected */
    public long J() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void K() {
        this.f15783aj = true;
    }

    /* access modifiers changed from: protected */
    public float a(float f2, Format format, Format[] formatArr) {
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public int a(MediaCodec mediaCodec, a aVar, Format format, Format format2) {
        return 0;
    }

    public final int a(Format format) throws ExoPlaybackException {
        try {
            return a(this.f15784c, this.f15785d, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw a((Exception) e2, format);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int a(b bVar, b<f> bVar2, Format format) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public abstract List<a> a(b bVar, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    public final void a(float f2) throws ExoPlaybackException {
        this.f15802u = f2;
        if (this.f15803v != null && this.X != 3 && m_() != 0) {
            P();
        }
    }

    public void a(long j2, long j3) throws ExoPlaybackException {
        if (this.f15783aj) {
            this.f15783aj = false;
            V();
        }
        try {
            if (this.f15778ae) {
                B();
            } else if (this.f15795n != null || b(true)) {
                C();
                if (this.f15803v != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ab.a("drainAndFeed");
                    while (b(j2, j3)) {
                    }
                    while (O() && e(elapsedRealtime)) {
                    }
                    ab.a();
                } else {
                    this.f15773a.f27307d += b(j2);
                    b(false);
                }
                this.f15773a.a();
            }
        } catch (IllegalStateException e2) {
            if (a(e2)) {
                throw a((Exception) e2, this.f15795n);
            }
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ExoPlaybackException {
        this.f15777ad = false;
        this.f15778ae = false;
        this.f15783aj = false;
        H();
        this.f15791j.a();
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public void a(o oVar) throws ExoPlaybackException {
        boolean z2 = true;
        this.f15781ah = true;
        Format format = (Format) a.b(oVar.f15972c);
        if (oVar.f15970a) {
            a((DrmSession<f>) oVar.f15971b);
        } else {
            this.f15798q = a(this.f15795n, format, this.f15785d, this.f15798q);
        }
        this.f15795n = format;
        if (this.f15803v == null) {
            C();
            return;
        }
        DrmSession<f> drmSession = this.f15798q;
        if ((drmSession != null || this.f15797p == null) && ((drmSession == null || this.f15797p != null) && ((drmSession == this.f15797p || this.A.f15834g || !a(this.f15798q, format)) && (ad.f11755a >= 23 || this.f15798q == this.f15797p)))) {
            int a2 = a(this.f15803v, this.A, this.f15804w, format);
            if (a2 != 0) {
                if (a2 == 1) {
                    this.f15804w = format;
                    P();
                    if (this.f15798q == this.f15797p) {
                        Q();
                        return;
                    }
                } else if (a2 != 2) {
                    if (a2 == 3) {
                        this.f15804w = format;
                        P();
                        if (this.f15798q == this.f15797p) {
                            return;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!this.C) {
                    this.U = true;
                    this.V = 1;
                    int i2 = this.B;
                    if (!(i2 == 2 || (i2 == 1 && format.f15097n == this.f15804w.f15097n && format.f15098o == this.f15804w.f15098o))) {
                        z2 = false;
                    }
                    this.J = z2;
                    this.f15804w = format;
                    P();
                    if (this.f15798q == this.f15797p) {
                        return;
                    }
                }
                R();
                return;
            }
            S();
            return;
        }
        S();
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ExoPlaybackException {
        b<f> bVar = this.f15785d;
        if (bVar != null && !this.f15794m) {
            this.f15794m = true;
            bVar.a();
        }
        this.f15773a = new fi.d();
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public boolean a(a aVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(e eVar) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
    }

    /* access modifiers changed from: protected */
    public final Format d(long j2) {
        Format a2 = this.f15791j.a(j2);
        if (a2 != null) {
            this.f15796o = a2;
        }
        return a2;
    }

    public final int o() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.f15795n = null;
        if (this.f15798q == null && this.f15797p == null) {
            I();
        } else {
            s();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void s() {
        try {
            G();
            a((DrmSession<f>) null);
            b<f> bVar = this.f15785d;
            if (bVar != null && this.f15794m) {
                this.f15794m = false;
                bVar.b();
            }
        } catch (Throwable th) {
            a((DrmSession<f>) null);
            throw th;
        }
    }

    public boolean y() {
        return this.f15795n != null && !this.f15779af && (x() || L() || (this.O != -9223372036854775807L && SystemClock.elapsedRealtime() < this.O));
    }

    public boolean z() {
        return this.f15778ae;
    }
}
