package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.h;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.v;
import fj.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public final class DefaultAudioSink implements AudioSink {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15202a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15203b = false;
    private long A;
    private long B;
    private int C;
    private int D;
    private long E;
    private float F;
    private AudioProcessor[] G;
    private ByteBuffer[] H;
    private ByteBuffer I;
    private ByteBuffer J;
    private byte[] K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private i R;
    private boolean S;
    /* access modifiers changed from: private */
    public long T;

    /* renamed from: c  reason: collision with root package name */
    private final d f15204c;

    /* renamed from: d  reason: collision with root package name */
    private final a f15205d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15206e;

    /* renamed from: f  reason: collision with root package name */
    private final k f15207f;

    /* renamed from: g  reason: collision with root package name */
    private final s f15208g;

    /* renamed from: h  reason: collision with root package name */
    private final AudioProcessor[] f15209h;

    /* renamed from: i  reason: collision with root package name */
    private final AudioProcessor[] f15210i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ConditionVariable f15211j;

    /* renamed from: k  reason: collision with root package name */
    private final h f15212k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayDeque<d> f15213l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public AudioSink.a f15214m;

    /* renamed from: n  reason: collision with root package name */
    private AudioTrack f15215n;

    /* renamed from: o  reason: collision with root package name */
    private b f15216o;

    /* renamed from: p  reason: collision with root package name */
    private b f15217p;

    /* renamed from: q  reason: collision with root package name */
    private AudioTrack f15218q;

    /* renamed from: r  reason: collision with root package name */
    private c f15219r;

    /* renamed from: s  reason: collision with root package name */
    private v f15220s;

    /* renamed from: t  reason: collision with root package name */
    private v f15221t;

    /* renamed from: u  reason: collision with root package name */
    private long f15222u;

    /* renamed from: v  reason: collision with root package name */
    private long f15223v;

    /* renamed from: w  reason: collision with root package name */
    private ByteBuffer f15224w;

    /* renamed from: x  reason: collision with root package name */
    private int f15225x;

    /* renamed from: y  reason: collision with root package name */
    private long f15226y;

    /* renamed from: z  reason: collision with root package name */
    private long f15227z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public interface a {
        long a(long j2);

        v a(v vVar);

        AudioProcessor[] a();

        long b();
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f15231a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15232b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15233c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15234d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15235e;

        /* renamed from: f  reason: collision with root package name */
        public final int f15236f;

        /* renamed from: g  reason: collision with root package name */
        public final int f15237g;

        /* renamed from: h  reason: collision with root package name */
        public final int f15238h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f15239i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f15240j;

        /* renamed from: k  reason: collision with root package name */
        public final AudioProcessor[] f15241k;

        public b(boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, AudioProcessor[] audioProcessorArr) {
            this.f15231a = z2;
            this.f15232b = i2;
            this.f15233c = i3;
            this.f15234d = i4;
            this.f15235e = i5;
            this.f15236f = i6;
            this.f15237g = i7;
            this.f15238h = i8 == 0 ? a() : i8;
            this.f15239i = z3;
            this.f15240j = z4;
            this.f15241k = audioProcessorArr;
        }

        private int a() {
            if (this.f15231a) {
                int minBufferSize = AudioTrack.getMinBufferSize(this.f15235e, this.f15236f, this.f15237g);
                com.google.android.exoplayer2.util.a.b(minBufferSize != -2);
                return ad.a(minBufferSize * 4, ((int) c(250000)) * this.f15234d, (int) Math.max((long) minBufferSize, c(750000) * ((long) this.f15234d)));
            }
            int b2 = DefaultAudioSink.d(this.f15237g);
            if (this.f15237g == 5) {
                b2 *= 2;
            }
            return (int) ((((long) b2) * 250000) / 1000000);
        }

        private AudioTrack b(boolean z2, c cVar, int i2) {
            return new AudioTrack(z2 ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : cVar.a(), new AudioFormat.Builder().setChannelMask(this.f15236f).setEncoding(this.f15237g).setSampleRate(this.f15235e).build(), this.f15238h, 1, i2 != 0 ? i2 : 0);
        }

        public long a(long j2) {
            return (j2 * 1000000) / ((long) this.f15233c);
        }

        public AudioTrack a(boolean z2, c cVar, int i2) throws AudioSink.InitializationException {
            AudioTrack audioTrack;
            if (ad.f11755a >= 21) {
                audioTrack = b(z2, cVar, i2);
            } else {
                int g2 = ad.g(cVar.f15270d);
                int i3 = this.f15235e;
                int i4 = this.f15236f;
                int i5 = this.f15237g;
                int i6 = this.f15238h;
                if (i2 != 0) {
                    audioTrack = new AudioTrack(g2, i3, i4, i5, i6, 1, i2);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, this.f15235e, this.f15236f, this.f15238h);
        }

        public boolean a(b bVar) {
            return bVar.f15237g == this.f15237g && bVar.f15235e == this.f15235e && bVar.f15236f == this.f15236f;
        }

        public long b(long j2) {
            return (j2 * 1000000) / ((long) this.f15235e);
        }

        public long c(long j2) {
            return (j2 * ((long) this.f15235e)) / 1000000;
        }
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final AudioProcessor[] f15242a;

        /* renamed from: b  reason: collision with root package name */
        private final p f15243b;

        /* renamed from: c  reason: collision with root package name */
        private final r f15244c;

        public c(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new p(), new r());
        }

        public c(AudioProcessor[] audioProcessorArr, p pVar, r rVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.f15242a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f15243b = pVar;
            this.f15244c = rVar;
            audioProcessorArr2[audioProcessorArr.length] = pVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = rVar;
        }

        public long a(long j2) {
            return this.f15244c.a(j2);
        }

        public v a(v vVar) {
            this.f15243b.a(vVar.f17194d);
            return new v(this.f15244c.a(vVar.f17192b), this.f15244c.b(vVar.f17193c), vVar.f17194d);
        }

        public AudioProcessor[] a() {
            return this.f15242a;
        }

        public long b() {
            return this.f15243b.k();
        }
    }

    private static final class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final v f15245a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f15246b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f15247c;

        private d(v vVar, long j2, long j3) {
            this.f15245a = vVar;
            this.f15246b = j2;
            this.f15247c = j3;
        }
    }

    private final class e implements h.a {
        private e() {
        }

        public void a(int i2, long j2) {
            if (DefaultAudioSink.this.f15214m != null) {
                DefaultAudioSink.this.f15214m.a(i2, j2, SystemClock.elapsedRealtime() - DefaultAudioSink.this.T);
            }
        }

        public void a(long j2) {
            StringBuilder sb = new StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j2);
            k.c("AudioTrack", sb.toString());
        }

        public void a(long j2, long j3, long j4, long j5) {
            long b2 = DefaultAudioSink.this.q();
            long c2 = DefaultAudioSink.this.r();
            StringBuilder sb = new StringBuilder(182);
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(j5);
            sb.append(", ");
            sb.append(b2);
            sb.append(", ");
            sb.append(c2);
            String sb2 = sb.toString();
            if (!DefaultAudioSink.f15203b) {
                k.c("AudioTrack", sb2);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb2);
        }

        public void b(long j2, long j3, long j4, long j5) {
            long b2 = DefaultAudioSink.this.q();
            long c2 = DefaultAudioSink.this.r();
            StringBuilder sb = new StringBuilder(180);
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(j5);
            sb.append(", ");
            sb.append(b2);
            sb.append(", ");
            sb.append(c2);
            String sb2 = sb.toString();
            if (!DefaultAudioSink.f15203b) {
                k.c("AudioTrack", sb2);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb2);
        }
    }

    public DefaultAudioSink(d dVar, a aVar, boolean z2) {
        this.f15204c = dVar;
        this.f15205d = (a) com.google.android.exoplayer2.util.a.b(aVar);
        this.f15206e = z2;
        this.f15211j = new ConditionVariable(true);
        this.f15212k = new h(new e());
        k kVar = new k();
        this.f15207f = kVar;
        s sVar = new s();
        this.f15208g = sVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new j[]{new o(), kVar, sVar});
        Collections.addAll(arrayList, aVar.a());
        this.f15209h = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f15210i = new AudioProcessor[]{new m()};
        this.F = 1.0f;
        this.D = 0;
        this.f15219r = c.f15267a;
        this.Q = 0;
        this.R = new i(0, 0.0f);
        this.f15221t = v.f17191a;
        this.M = -1;
        this.G = new AudioProcessor[0];
        this.H = new ByteBuffer[0];
        this.f15213l = new ArrayDeque<>();
    }

    public DefaultAudioSink(d dVar, AudioProcessor[] audioProcessorArr) {
        this(dVar, audioProcessorArr, false);
    }

    public DefaultAudioSink(d dVar, AudioProcessor[] audioProcessorArr, boolean z2) {
        this(dVar, (a) new c(audioProcessorArr), z2);
    }

    private static int a(int i2, ByteBuffer byteBuffer) {
        if (i2 == 14) {
            int b2 = a.b(byteBuffer);
            if (b2 == -1) {
                return 0;
            }
            return a.a(byteBuffer, b2) * 16;
        } else if (i2 == 17) {
            return b.a(byteBuffer);
        } else {
            if (i2 != 18) {
                switch (i2) {
                    case 5:
                    case 6:
                        break;
                    case 7:
                    case 8:
                        return l.a(byteBuffer);
                    case 9:
                        return q.b(byteBuffer.get(byteBuffer.position()));
                    default:
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unexpected audio encoding: ");
                        sb.append(i2);
                        throw new IllegalStateException(sb.toString());
                }
            }
            return a.a(byteBuffer);
        }
    }

    private static int a(int i2, boolean z2) {
        if (ad.f11755a <= 28 && !z2) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (ad.f11755a <= 26 && "fugu".equals(ad.f11756b) && !z2 && i2 == 1) {
            i2 = 2;
        }
        return ad.f(i2);
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (ad.f11755a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.f15224w == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f15224w = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f15224w.putInt(1431633921);
        }
        if (this.f15225x == 0) {
            this.f15224w.putInt(4, i2);
            this.f15224w.putLong(8, j2 * 1000);
            this.f15224w.position(0);
            this.f15225x = i2;
        }
        int remaining = this.f15224w.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.f15224w, remaining, 1);
            if (write < 0) {
                this.f15225x = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i2);
        if (a2 < 0) {
            this.f15225x = 0;
            return a2;
        }
        this.f15225x -= a2;
        return a2;
    }

    private void a(long j2) throws AudioSink.InitializationException {
        this.f15211j.block();
        AudioTrack a2 = ((b) com.google.android.exoplayer2.util.a.b(this.f15217p)).a(this.S, this.f15219r, this.Q);
        this.f15218q = a2;
        int audioSessionId = a2.getAudioSessionId();
        if (f15202a && ad.f11755a < 21) {
            AudioTrack audioTrack = this.f15215n;
            if (!(audioTrack == null || audioSessionId == audioTrack.getAudioSessionId())) {
                o();
            }
            if (this.f15215n == null) {
                this.f15215n = c(audioSessionId);
            }
        }
        if (this.Q != audioSessionId) {
            this.Q = audioSessionId;
            AudioSink.a aVar = this.f15214m;
            if (aVar != null) {
                aVar.a(audioSessionId);
            }
        }
        a(this.f15221t, j2);
        this.f15212k.a(this.f15218q, this.f15217p.f15237g, this.f15217p.f15234d, this.f15217p.f15238h);
        n();
        if (this.R.f15320a != 0) {
            this.f15218q.attachAuxEffect(this.R.f15320a);
            this.f15218q.setAuxEffectSendLevel(this.R.f15321b);
        }
    }

    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private void a(v vVar, long j2) {
        this.f15213l.add(new d(this.f15217p.f15240j ? this.f15205d.a(vVar) : v.f17191a, Math.max(0, j2), this.f15217p.b(r())));
        k();
    }

    private void b(long j2) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.G.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.H[i2 - 1];
            } else {
                byteBuffer = this.I;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f15194a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                AudioProcessor audioProcessor = this.G[i2];
                audioProcessor.a(byteBuffer);
                ByteBuffer c2 = audioProcessor.c();
                this.H[i2] = c2;
                if (c2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void b(ByteBuffer byteBuffer, long j2) throws AudioSink.WriteException {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.J;
            boolean z2 = true;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.J = byteBuffer;
                if (ad.f11755a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.K;
                    if (bArr == null || bArr.length < remaining) {
                        this.K = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.K, 0, remaining);
                    byteBuffer.position(position);
                    this.L = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (ad.f11755a < 21) {
                int b2 = this.f15212k.b(this.A);
                if (b2 > 0 && (i2 = this.f15218q.write(this.K, this.L, Math.min(remaining2, b2))) > 0) {
                    this.L += i2;
                    byteBuffer.position(byteBuffer.position() + i2);
                }
            } else if (this.S) {
                if (j2 == -9223372036854775807L) {
                    z2 = false;
                }
                com.google.android.exoplayer2.util.a.b(z2);
                i2 = a(this.f15218q, byteBuffer, remaining2, j2);
            } else {
                i2 = a(this.f15218q, byteBuffer, remaining2);
            }
            this.T = SystemClock.elapsedRealtime();
            if (i2 >= 0) {
                if (this.f15217p.f15231a) {
                    this.A += (long) i2;
                }
                if (i2 == remaining2) {
                    if (!this.f15217p.f15231a) {
                        this.B += (long) this.C;
                    }
                    this.J = null;
                    return;
                }
                return;
            }
            throw new AudioSink.WriteException(i2);
        }
    }

    private long c(long j2) {
        long j3;
        long a2;
        d dVar = null;
        while (!this.f15213l.isEmpty() && j2 >= this.f15213l.getFirst().f15247c) {
            dVar = this.f15213l.remove();
        }
        if (dVar != null) {
            this.f15221t = dVar.f15245a;
            this.f15223v = dVar.f15247c;
            this.f15222u = dVar.f15246b - this.E;
        }
        if (this.f15221t.f17192b == 1.0f) {
            return (j2 + this.f15222u) - this.f15223v;
        }
        if (this.f15213l.isEmpty()) {
            j3 = this.f15222u;
            a2 = this.f15205d.a(j2 - this.f15223v);
        } else {
            j3 = this.f15222u;
            a2 = ad.a(j2 - this.f15223v, this.f15221t.f17192b);
        }
        return j3 + a2;
    }

    private static AudioTrack c(int i2) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
    }

    /* access modifiers changed from: private */
    public static int d(int i2) {
        if (i2 == 5) {
            return 80000;
        }
        if (i2 == 6) {
            return 768000;
        }
        if (i2 == 7) {
            return 192000;
        }
        if (i2 == 8) {
            return 2250000;
        }
        if (i2 == 14) {
            return 3062500;
        }
        if (i2 == 17) {
            return 336000;
        }
        if (i2 == 18) {
            return 768000;
        }
        throw new IllegalArgumentException();
    }

    private long d(long j2) {
        return j2 + this.f15217p.b(this.f15205d.b());
    }

    private void k() {
        AudioProcessor[] audioProcessorArr = this.f15217p.f15241k;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.a()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.e();
            }
        }
        int size = arrayList.size();
        this.G = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.H = new ByteBuffer[size];
        l();
    }

    private void l() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.G;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.e();
                this.H[i2] = audioProcessor.c();
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.M
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0016
            com.google.android.exoplayer2.audio.DefaultAudioSink$b r0 = r9.f15217p
            boolean r0 = r0.f15239i
            if (r0 == 0) goto L_0x000f
            r0 = 0
            goto L_0x0012
        L_0x000f:
            com.google.android.exoplayer2.audio.AudioProcessor[] r0 = r9.G
            int r0 = r0.length
        L_0x0012:
            r9.M = r0
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            int r4 = r9.M
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.G
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x002a
            r4.b()
        L_0x002a:
            r9.b((long) r7)
            boolean r0 = r4.d()
            if (r0 != 0) goto L_0x0034
            return r3
        L_0x0034:
            int r0 = r9.M
            int r0 = r0 + r2
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.J
            if (r0 == 0) goto L_0x0044
            r9.b((java.nio.ByteBuffer) r0, (long) r7)
            java.nio.ByteBuffer r0 = r9.J
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.M = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.m():boolean");
    }

    private void n() {
        if (p()) {
            if (ad.f11755a >= 21) {
                a(this.f15218q, this.F);
            } else {
                b(this.f15218q, this.F);
            }
        }
    }

    private void o() {
        final AudioTrack audioTrack = this.f15215n;
        if (audioTrack != null) {
            this.f15215n = null;
            new Thread(this) {
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean p() {
        return this.f15218q != null;
    }

    /* access modifiers changed from: private */
    public long q() {
        return this.f15217p.f15231a ? this.f15226y / ((long) this.f15217p.f15232b) : this.f15227z;
    }

    /* access modifiers changed from: private */
    public long r() {
        return this.f15217p.f15231a ? this.A / ((long) this.f15217p.f15234d) : this.B;
    }

    private void s() {
        if (!this.O) {
            this.O = true;
            this.f15212k.d(r());
            this.f15218q.stop();
            this.f15225x = 0;
        }
    }

    public long a(boolean z2) {
        if (!p() || this.D == 0) {
            return Long.MIN_VALUE;
        }
        return this.E + d(c(Math.min(this.f15212k.a(z2), this.f15217p.b(r()))));
    }

    public void a() {
        this.P = true;
        if (p()) {
            this.f15212k.a();
            this.f15218q.play();
        }
    }

    public void a(float f2) {
        if (this.F != f2) {
            this.F = f2;
            n();
        }
    }

    public void a(int i2) {
        com.google.android.exoplayer2.util.a.b(ad.f11755a >= 21);
        if (!this.S || this.Q != i2) {
            this.S = true;
            this.Q = i2;
            i();
        }
    }

    public void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7) throws AudioSink.ConfigurationException {
        int[] iArr2;
        int i8;
        int i9;
        int i10;
        int i11 = i3;
        boolean z2 = false;
        if (ad.f11755a < 21 && i11 == 8 && iArr == null) {
            iArr2 = new int[6];
            for (int i12 = 0; i12 < 6; i12++) {
                iArr2[i12] = i12;
            }
        } else {
            iArr2 = iArr;
        }
        boolean d2 = ad.d(i2);
        boolean z3 = this.f15206e && a(i11, 4) && ad.e(i2);
        AudioProcessor[] audioProcessorArr = z3 ? this.f15210i : this.f15209h;
        if (d2) {
            this.f15208g.a(i6, i7);
            this.f15207f.a(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(i4, i11, i2);
            int length = audioProcessorArr.length;
            int i13 = 0;
            while (i13 < length) {
                AudioProcessor audioProcessor = audioProcessorArr[i13];
                try {
                    AudioProcessor.a a2 = audioProcessor.a(aVar);
                    if (audioProcessor.a()) {
                        aVar = a2;
                    }
                    i13++;
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException((Throwable) e2);
                }
            }
            int i14 = aVar.f15196b;
            i10 = aVar.f15197c;
            i8 = aVar.f15198d;
            i9 = i14;
        } else {
            i10 = i11;
            i8 = i2;
            i9 = i4;
        }
        int a3 = a(i10, d2);
        if (a3 != 0) {
            int c2 = d2 ? ad.c(i2, i3) : -1;
            int c3 = d2 ? ad.c(i8, i10) : -1;
            if (d2 && !z3) {
                z2 = true;
            }
            b bVar = new b(d2, c2, i4, c3, i9, a3, i8, i5, d2, z2, audioProcessorArr);
            if (p()) {
                this.f15216o = bVar;
            } else {
                this.f15217p = bVar;
            }
        } else {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unsupported channel count: ");
            sb.append(i10);
            throw new AudioSink.ConfigurationException(sb.toString());
        }
    }

    public void a(AudioSink.a aVar) {
        this.f15214m = aVar;
    }

    public void a(c cVar) {
        if (!this.f15219r.equals(cVar)) {
            this.f15219r = cVar;
            if (!this.S) {
                i();
                this.Q = 0;
            }
        }
    }

    public void a(i iVar) {
        if (!this.R.equals(iVar)) {
            int i2 = iVar.f15320a;
            float f2 = iVar.f15321b;
            if (this.f15218q != null) {
                if (this.R.f15320a != i2) {
                    this.f15218q.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.f15218q.setAuxEffectSendLevel(f2);
                }
            }
            this.R = iVar;
        }
    }

    public void a(v vVar) {
        b bVar = this.f15217p;
        if (bVar != null && !bVar.f15240j) {
            this.f15221t = v.f17191a;
        } else if (vVar.equals(f())) {
        } else {
            if (p()) {
                this.f15220s = vVar;
            } else {
                this.f15221t = vVar;
            }
        }
    }

    public boolean a(int i2, int i3) {
        if (ad.d(i3)) {
            return i3 != 4 || ad.f11755a >= 21;
        }
        d dVar = this.f15204c;
        return dVar != null && dVar.a(i3) && (i2 == -1 || i2 <= this.f15204c.a());
    }

    public boolean a(ByteBuffer byteBuffer, long j2) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        ByteBuffer byteBuffer3 = this.I;
        com.google.android.exoplayer2.util.a.a(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (this.f15216o != null) {
            if (!m()) {
                return false;
            }
            if (!this.f15216o.a(this.f15217p)) {
                s();
                if (e()) {
                    return false;
                }
                i();
            } else {
                this.f15217p = this.f15216o;
                this.f15216o = null;
            }
            a(this.f15221t, j3);
        }
        if (!p()) {
            a(j3);
            if (this.P) {
                a();
            }
        }
        if (!this.f15212k.a(r())) {
            return false;
        }
        if (this.I == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.f15217p.f15231a && this.C == 0) {
                int a2 = a(this.f15217p.f15237g, byteBuffer2);
                this.C = a2;
                if (a2 == 0) {
                    return true;
                }
            }
            if (this.f15220s != null) {
                if (!m()) {
                    return false;
                }
                v vVar = this.f15220s;
                this.f15220s = null;
                a(vVar, j3);
            }
            if (this.D == 0) {
                this.E = Math.max(0, j3);
                this.D = 1;
            } else {
                long a3 = this.E + this.f15217p.a(q() - this.f15208g.l());
                if (this.D == 1 && Math.abs(a3 - j3) > 200000) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Discontinuity detected [expected ");
                    sb.append(a3);
                    sb.append(", got ");
                    sb.append(j3);
                    sb.append("]");
                    k.d("AudioTrack", sb.toString());
                    this.D = 2;
                }
                if (this.D == 2) {
                    long j4 = j3 - a3;
                    this.E += j4;
                    this.D = 1;
                    AudioSink.a aVar = this.f15214m;
                    if (!(aVar == null || j4 == 0)) {
                        aVar.a();
                    }
                }
            }
            if (this.f15217p.f15231a) {
                this.f15226y += (long) byteBuffer.remaining();
            } else {
                this.f15227z += (long) this.C;
            }
            this.I = byteBuffer2;
        }
        if (this.f15217p.f15239i) {
            b(j3);
        } else {
            b(this.I, j3);
        }
        if (!this.I.hasRemaining()) {
            this.I = null;
            return true;
        } else if (!this.f15212k.c(r())) {
            return false;
        } else {
            k.c("AudioTrack", "Resetting stalled audio track");
            i();
            return true;
        }
    }

    public void b() {
        if (this.D == 1) {
            this.D = 2;
        }
    }

    public void c() throws AudioSink.WriteException {
        if (!this.N && p() && m()) {
            s();
            this.N = true;
        }
    }

    public boolean d() {
        return !p() || (this.N && !e());
    }

    public boolean e() {
        return p() && this.f15212k.e(r());
    }

    public v f() {
        v vVar = this.f15220s;
        return vVar != null ? vVar : !this.f15213l.isEmpty() ? this.f15213l.getLast().f15245a : this.f15221t;
    }

    public void g() {
        if (this.S) {
            this.S = false;
            this.Q = 0;
            i();
        }
    }

    public void h() {
        this.P = false;
        if (p() && this.f15212k.c()) {
            this.f15218q.pause();
        }
    }

    public void i() {
        if (p()) {
            this.f15226y = 0;
            this.f15227z = 0;
            this.A = 0;
            this.B = 0;
            this.C = 0;
            v vVar = this.f15220s;
            if (vVar != null) {
                this.f15221t = vVar;
                this.f15220s = null;
            } else if (!this.f15213l.isEmpty()) {
                this.f15221t = this.f15213l.getLast().f15245a;
            }
            this.f15213l.clear();
            this.f15222u = 0;
            this.f15223v = 0;
            this.f15208g.k();
            l();
            this.I = null;
            this.J = null;
            this.O = false;
            this.N = false;
            this.M = -1;
            this.f15224w = null;
            this.f15225x = 0;
            this.D = 0;
            if (this.f15212k.b()) {
                this.f15218q.pause();
            }
            final AudioTrack audioTrack = this.f15218q;
            this.f15218q = null;
            b bVar = this.f15216o;
            if (bVar != null) {
                this.f15217p = bVar;
                this.f15216o = null;
            }
            this.f15212k.d();
            this.f15211j.close();
            new Thread() {
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.f15211j.open();
                    }
                }
            }.start();
        }
    }

    public void j() {
        i();
        o();
        for (AudioProcessor f2 : this.f15209h) {
            f2.f();
        }
        for (AudioProcessor f3 : this.f15210i) {
            f3.f();
        }
        this.Q = 0;
        this.P = false;
    }
}
