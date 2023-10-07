package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class r implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f15385b;

    /* renamed from: c  reason: collision with root package name */
    private float f15386c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f15387d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.a f15388e = AudioProcessor.a.f15195a;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.a f15389f = AudioProcessor.a.f15195a;

    /* renamed from: g  reason: collision with root package name */
    private AudioProcessor.a f15390g = AudioProcessor.a.f15195a;

    /* renamed from: h  reason: collision with root package name */
    private AudioProcessor.a f15391h = AudioProcessor.a.f15195a;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15392i;

    /* renamed from: j  reason: collision with root package name */
    private q f15393j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f15394k;

    /* renamed from: l  reason: collision with root package name */
    private ShortBuffer f15395l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f15396m;

    /* renamed from: n  reason: collision with root package name */
    private long f15397n;

    /* renamed from: o  reason: collision with root package name */
    private long f15398o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15399p;

    public r() {
        ByteBuffer byteBuffer = f15194a;
        this.f15394k = byteBuffer;
        this.f15395l = byteBuffer.asShortBuffer();
        this.f15396m = f15194a;
        this.f15385b = -1;
    }

    public float a(float f2) {
        float a2 = ad.a(f2, 0.1f, 8.0f);
        if (this.f15386c != a2) {
            this.f15386c = a2;
            this.f15392i = true;
        }
        return a2;
    }

    public long a(long j2) {
        if (this.f15398o < 1024) {
            double d2 = (double) this.f15386c;
            double d3 = (double) j2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return (long) (d2 * d3);
        } else if (this.f15391h.f15196b == this.f15390g.f15196b) {
            return ad.d(j2, this.f15397n, this.f15398o);
        } else {
            return ad.d(j2, this.f15397n * ((long) this.f15391h.f15196b), this.f15398o * ((long) this.f15390g.f15196b));
        }
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f15198d == 2) {
            int i2 = this.f15385b;
            if (i2 == -1) {
                i2 = aVar.f15196b;
            }
            this.f15388e = aVar;
            AudioProcessor.a aVar2 = new AudioProcessor.a(i2, aVar.f15197c, 2);
            this.f15389f = aVar2;
            this.f15392i = true;
            return aVar2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    public void a(ByteBuffer byteBuffer) {
        q qVar = (q) a.b(this.f15393j);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f15397n += (long) remaining;
            qVar.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int c2 = qVar.c();
        if (c2 > 0) {
            if (this.f15394k.capacity() < c2) {
                ByteBuffer order = ByteBuffer.allocateDirect(c2).order(ByteOrder.nativeOrder());
                this.f15394k = order;
                this.f15395l = order.asShortBuffer();
            } else {
                this.f15394k.clear();
                this.f15395l.clear();
            }
            qVar.b(this.f15395l);
            this.f15398o += (long) c2;
            this.f15394k.limit(c2);
            this.f15396m = this.f15394k;
        }
    }

    public boolean a() {
        return this.f15389f.f15196b != -1 && (Math.abs(this.f15386c - 1.0f) >= 0.01f || Math.abs(this.f15387d - 1.0f) >= 0.01f || this.f15389f.f15196b != this.f15388e.f15196b);
    }

    public float b(float f2) {
        float a2 = ad.a(f2, 0.1f, 8.0f);
        if (this.f15387d != a2) {
            this.f15387d = a2;
            this.f15392i = true;
        }
        return a2;
    }

    public void b() {
        q qVar = this.f15393j;
        if (qVar != null) {
            qVar.a();
        }
        this.f15399p = true;
    }

    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f15396m;
        this.f15396m = f15194a;
        return byteBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f15393j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            boolean r0 = r1.f15399p
            if (r0 == 0) goto L_0x0010
            com.google.android.exoplayer2.audio.q r0 = r1.f15393j
            if (r0 == 0) goto L_0x000e
            int r0 = r0.c()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.r.d():boolean");
    }

    public void e() {
        if (a()) {
            AudioProcessor.a aVar = this.f15388e;
            this.f15390g = aVar;
            this.f15391h = this.f15389f;
            if (this.f15392i) {
                this.f15393j = new q(aVar.f15196b, this.f15390g.f15197c, this.f15386c, this.f15387d, this.f15391h.f15196b);
            } else {
                q qVar = this.f15393j;
                if (qVar != null) {
                    qVar.b();
                }
            }
        }
        this.f15396m = f15194a;
        this.f15397n = 0;
        this.f15398o = 0;
        this.f15399p = false;
    }

    public void f() {
        this.f15386c = 1.0f;
        this.f15387d = 1.0f;
        this.f15388e = AudioProcessor.a.f15195a;
        this.f15389f = AudioProcessor.a.f15195a;
        this.f15390g = AudioProcessor.a.f15195a;
        this.f15391h = AudioProcessor.a.f15195a;
        ByteBuffer byteBuffer = f15194a;
        this.f15394k = byteBuffer;
        this.f15395l = byteBuffer.asShortBuffer();
        this.f15396m = f15194a;
        this.f15385b = -1;
        this.f15392i = false;
        this.f15393j = null;
        this.f15397n = 0;
        this.f15398o = 0;
        this.f15399p = false;
    }
}
