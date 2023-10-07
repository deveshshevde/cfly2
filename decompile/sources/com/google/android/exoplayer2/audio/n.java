package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.v;
import fi.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class n extends MediaCodecRenderer implements m {

    /* renamed from: b  reason: collision with root package name */
    private final Context f15335b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final f.a f15336c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioSink f15337d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f15338e = new long[10];

    /* renamed from: f  reason: collision with root package name */
    private int f15339f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15340g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15341h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15342i;

    /* renamed from: j  reason: collision with root package name */
    private MediaFormat f15343j;

    /* renamed from: k  reason: collision with root package name */
    private Format f15344k;

    /* renamed from: l  reason: collision with root package name */
    private long f15345l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15346m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f15347n;

    /* renamed from: o  reason: collision with root package name */
    private long f15348o = -9223372036854775807L;

    /* renamed from: p  reason: collision with root package name */
    private int f15349p;

    private final class a implements AudioSink.a {
        private a() {
        }

        public void a() {
            n.this.A();
            boolean unused = n.this.f15347n = true;
        }

        public void a(int i2) {
            n.this.f15336c.a(i2);
            n.this.g(i2);
        }

        public void a(int i2, long j2, long j3) {
            n.this.f15336c.a(i2, j2, j3);
            n.this.a(i2, j2, j3);
        }
    }

    @Deprecated
    public n(Context context, b bVar, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> bVar2, boolean z2, boolean z3, Handler handler, f fVar, AudioSink audioSink) {
        super(1, bVar, bVar2, z2, z3, 44100.0f);
        this.f15335b = context.getApplicationContext();
        this.f15337d = audioSink;
        this.f15336c = new f.a(handler, fVar);
        audioSink.a((AudioSink.a) new a());
    }

    private void L() {
        long a2 = this.f15337d.a(z());
        if (a2 != Long.MIN_VALUE) {
            if (!this.f15347n) {
                a2 = Math.max(this.f15345l, a2);
            }
            this.f15345l = a2;
            this.f15347n = false;
        }
    }

    private static boolean M() {
        return ad.f11755a == 23 && ("ZTE B2017G".equals(ad.f11758d) || "AXON 7 mini".equals(ad.f11758d));
    }

    private int a(com.google.android.exoplayer2.mediacodec.a aVar, Format format) {
        if (!"OMX.google.raw.decoder".equals(aVar.f15828a) || ad.f11755a >= 24 || (ad.f11755a == 23 && ad.c(this.f15335b))) {
            return format.f15093j;
        }
        return -1;
    }

    private static boolean a(String str) {
        return ad.f11755a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(ad.f11757c) && (ad.f11756b.startsWith("zeroflte") || ad.f11756b.startsWith("herolte") || ad.f11756b.startsWith("heroqlte"));
    }

    private static int b(Format format) {
        if ("audio/raw".equals(format.f15092i)) {
            return format.f15107x;
        }
        return 2;
    }

    private static boolean b(String str) {
        return ad.f11755a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(ad.f11757c) && (ad.f11756b.startsWith("baffin") || ad.f11756b.startsWith("grand") || ad.f11756b.startsWith("fortuna") || ad.f11756b.startsWith("gprimelte") || ad.f11756b.startsWith("j2y18lte") || ad.f11756b.startsWith("ms01"));
    }

    /* access modifiers changed from: protected */
    public void A() {
    }

    /* access modifiers changed from: protected */
    public void B() throws ExoPlaybackException {
        try {
            this.f15337d.c();
        } catch (AudioSink.WriteException e2) {
            throw a((Exception) e2, this.f15344k);
        }
    }

    /* access modifiers changed from: protected */
    public float a(float f2, Format format, Format[] formatArr) {
        int i2 = -1;
        for (Format format2 : formatArr) {
            int i3 = format2.f15106w;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return f2 * ((float) i2);
    }

    /* access modifiers changed from: protected */
    public int a(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.a aVar, Format format, Format format2) {
        if (a(aVar, format2) <= this.f15339f && format.f15108y == 0 && format.f15109z == 0 && format2.f15108y == 0 && format2.f15109z == 0) {
            if (aVar.a(format, format2, true)) {
                return 3;
            }
            if (a(format, format2)) {
                return 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int a(com.google.android.exoplayer2.mediacodec.a aVar, Format format, Format[] formatArr) {
        int a2 = a(aVar, format);
        if (formatArr.length == 1) {
            return a2;
        }
        for (Format format2 : formatArr) {
            if (aVar.a(format, format2, false)) {
                a2 = Math.max(a2, a(aVar, format2));
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public int a(b bVar, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> bVar2, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.f15092i;
        if (!com.google.android.exoplayer2.util.n.a(str)) {
            return aa.CC.b(0);
        }
        int i2 = ad.f11755a >= 21 ? 32 : 0;
        boolean z2 = format.f15095l == null || com.google.android.exoplayer2.drm.f.class.equals(format.C) || (format.C == null && a((com.google.android.exoplayer2.drm.b<?>) bVar2, format.f15095l));
        int i3 = 8;
        int i4 = 4;
        if (z2 && a(format.f15105v, str) && bVar.a() != null) {
            return aa.CC.a(4, 8, i2);
        }
        if (("audio/raw".equals(str) && !this.f15337d.a(format.f15105v, format.f15107x)) || !this.f15337d.a(format.f15105v, 2)) {
            return aa.CC.b(1);
        }
        List<com.google.android.exoplayer2.mediacodec.a> a2 = a(bVar, format, false);
        if (a2.isEmpty()) {
            return aa.CC.b(1);
        }
        if (!z2) {
            return aa.CC.b(2);
        }
        com.google.android.exoplayer2.mediacodec.a aVar = a2.get(0);
        boolean a3 = aVar.a(format);
        if (a3 && aVar.c(format)) {
            i3 = 16;
        }
        if (!a3) {
            i4 = 3;
        }
        return aa.CC.a(i4, i3, i2);
    }

    /* access modifiers changed from: protected */
    public MediaFormat a(Format format, String str, int i2, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("channel-count", format.f15105v);
        mediaFormat.setInteger("sample-rate", format.f15106w);
        c.a(mediaFormat, format.f15094k);
        c.a(mediaFormat, "max-input-size", i2);
        if (ad.f11755a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f && !M()) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (ad.f11755a <= 28 && "audio/ac4".equals(format.f15092i)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public List<com.google.android.exoplayer2.mediacodec.a> a(b bVar, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.a a2;
        String str = format.f15092i;
        if (str == null) {
            return Collections.emptyList();
        }
        if (a(format.f15105v, str) && (a2 = bVar.a()) != null) {
            return Collections.singletonList(a2);
        }
        List<com.google.android.exoplayer2.mediacodec.a> a3 = MediaCodecUtil.a(bVar.a(str, z2, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(a3);
            arrayList.addAll(bVar.a("audio/eac3", z2, false));
            a3 = arrayList;
        }
        return Collections.unmodifiableList(a3);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, long j2, long j3) {
    }

    public void a(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.f15337d.a(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.f15337d.a((c) obj);
        } else if (i2 != 5) {
            super.a(i2, obj);
        } else {
            this.f15337d.a((i) obj);
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ExoPlaybackException {
        super.a(j2, z2);
        this.f15337d.i();
        this.f15345l = j2;
        this.f15346m = true;
        this.f15347n = true;
        this.f15348o = -9223372036854775807L;
        this.f15349p = 0;
    }

    /* access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i2;
        int[] iArr;
        MediaFormat mediaFormat2 = this.f15343j;
        if (mediaFormat2 != null) {
            i2 = b(mediaFormat2.getInteger("channel-count"), mediaFormat2.getString(IMediaFormat.KEY_MIME));
            mediaFormat = mediaFormat2;
        } else {
            i2 = mediaFormat.containsKey("v-bits-per-sample") ? ad.c(mediaFormat.getInteger("v-bits-per-sample")) : b(this.f15344k);
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.f15341h || integer != 6 || this.f15344k.f15105v >= 6) {
            iArr = null;
        } else {
            iArr = new int[this.f15344k.f15105v];
            for (int i3 = 0; i3 < this.f15344k.f15105v; i3++) {
                iArr[i3] = i3;
            }
        }
        try {
            this.f15337d.a(i2, integer, integer2, 0, iArr, this.f15344k.f15108y, this.f15344k.f15109z);
        } catch (AudioSink.ConfigurationException e2) {
            throw a((Exception) e2, this.f15344k);
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.google.android.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f2) {
        this.f15339f = a(aVar, format, u());
        this.f15341h = a(aVar.f15828a);
        this.f15342i = b(aVar.f15828a);
        boolean z2 = aVar.f15835h;
        this.f15340g = z2;
        MediaFormat a2 = a(format, z2 ? "audio/raw" : aVar.f15830c, this.f15339f, f2);
        mediaCodec.configure(a2, (Surface) null, mediaCrypto, 0);
        if (this.f15340g) {
            this.f15343j = a2;
            a2.setString(IMediaFormat.KEY_MIME, format.f15092i);
            return;
        }
        this.f15343j = null;
    }

    /* access modifiers changed from: protected */
    public void a(o oVar) throws ExoPlaybackException {
        super.a(oVar);
        Format format = oVar.f15972c;
        this.f15344k = format;
        this.f15336c.a(format);
    }

    public void a(v vVar) {
        this.f15337d.a(vVar);
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
        if (this.f15346m && !eVar.isDecodeOnly()) {
            if (Math.abs(eVar.f13101d - this.f15345l) > 500000) {
                this.f15345l = eVar.f13101d;
            }
            this.f15346m = false;
        }
        this.f15348o = Math.max(eVar.f13101d, this.f15348o);
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3) {
        this.f15336c.a(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ExoPlaybackException {
        super.a(z2);
        this.f15336c.a(this.f15773a);
        int i2 = v().f15121b;
        if (i2 != 0) {
            this.f15337d.a(i2);
        } else {
            this.f15337d.g();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws ExoPlaybackException {
        super.a(formatArr, j2);
        if (this.f15348o != -9223372036854775807L) {
            int i2 = this.f15349p;
            long[] jArr = this.f15338e;
            if (i2 == jArr.length) {
                long j3 = jArr[i2 - 1];
                StringBuilder sb = new StringBuilder(67);
                sb.append("Too many stream changes, so dropping change at ");
                sb.append(j3);
                k.c("MediaCodecAudioRenderer", sb.toString());
            } else {
                this.f15349p = i2 + 1;
            }
            this.f15338e[this.f15349p - 1] = this.f15348o;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, String str) {
        return b(i2, str) != 0;
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        if (this.f15342i && j4 == 0 && (i3 & 4) != 0) {
            long j5 = this.f15348o;
            if (j5 != -9223372036854775807L) {
                j4 = j5;
            }
        }
        if (this.f15340g && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z2) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.f15773a.f27309f++;
            this.f15337d.b();
            return true;
        } else {
            try {
                if (!this.f15337d.a(byteBuffer, j4)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i2, false);
                this.f15773a.f27308e++;
                return true;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e2) {
                throw a(e2, this.f15344k);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Format format, Format format2) {
        return ad.a((Object) format.f15092i, (Object) format2.f15092i) && format.f15105v == format2.f15105v && format.f15106w == format2.f15106w && format.f15107x == format2.f15107x && format.b(format2) && !"audio/opus".equals(format.f15092i);
    }

    /* access modifiers changed from: protected */
    public int b(int i2, String str) {
        if ("audio/eac3-joc".equals(str)) {
            if (this.f15337d.a(-1, 18)) {
                return com.google.android.exoplayer2.util.n.i("audio/eac3-joc");
            }
            str = "audio/eac3";
        }
        int i3 = com.google.android.exoplayer2.util.n.i(str);
        if (this.f15337d.a(i2, i3)) {
            return i3;
        }
        return 0;
    }

    public m c() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        while (this.f15349p != 0 && j2 >= this.f15338e[0]) {
            this.f15337d.b();
            int i2 = this.f15349p - 1;
            this.f15349p = i2;
            long[] jArr = this.f15338e;
            System.arraycopy(jArr, 1, jArr, 0, i2);
        }
    }

    public v d() {
        return this.f15337d.f();
    }

    /* access modifiers changed from: protected */
    public void g(int i2) {
    }

    public long l_() {
        if (m_() == 2) {
            L();
        }
        return this.f15345l;
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        this.f15337d.a();
    }

    /* access modifiers changed from: protected */
    public void q() {
        L();
        this.f15337d.h();
        super.q();
    }

    /* access modifiers changed from: protected */
    public void r() {
        try {
            this.f15348o = -9223372036854775807L;
            this.f15349p = 0;
            this.f15337d.i();
            try {
                super.r();
            } finally {
                this.f15336c.b(this.f15773a);
            }
        } catch (Throwable th) {
            super.r();
            throw th;
        } finally {
            this.f15336c.b(this.f15773a);
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        try {
            super.s();
        } finally {
            this.f15337d.j();
        }
    }

    public boolean y() {
        return this.f15337d.e() || super.y();
    }

    public boolean z() {
        return super.z() && this.f15337d.d();
    }
}
