package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class p extends j {

    /* renamed from: d  reason: collision with root package name */
    private final long f15351d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15352e;

    /* renamed from: f  reason: collision with root package name */
    private final short f15353f;

    /* renamed from: g  reason: collision with root package name */
    private int f15354g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15355h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f15356i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f15357j;

    /* renamed from: k  reason: collision with root package name */
    private int f15358k;

    /* renamed from: l  reason: collision with root package name */
    private int f15359l;

    /* renamed from: m  reason: collision with root package name */
    private int f15360m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15361n;

    /* renamed from: o  reason: collision with root package name */
    private long f15362o;

    public p() {
        this(150000, 20000, 1024);
    }

    public p(long j2, long j3, short s2) {
        a.a(j3 <= j2);
        this.f15351d = j2;
        this.f15352e = j3;
        this.f15353f = s2;
        this.f15356i = ad.f11760f;
        this.f15357j = ad.f11760f;
    }

    private int a(long j2) {
        return (int) ((j2 * ((long) this.f15322b.f15196b)) / 1000000);
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.f15360m);
        int i3 = this.f15360m - min;
        System.arraycopy(bArr, i2 - i3, this.f15357j, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f15357j, i3, min);
    }

    private void a(byte[] bArr, int i2) {
        a(i2).put(bArr, 0, i2).flip();
        if (i2 > 0) {
            this.f15361n = true;
        }
    }

    private void b(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f15356i.length));
        int g2 = g(byteBuffer);
        if (g2 == byteBuffer.position()) {
            this.f15358k = 1;
        } else {
            byteBuffer.limit(g2);
            e(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void c(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        int position = f2 - byteBuffer.position();
        byte[] bArr = this.f15356i;
        int length = bArr.length;
        int i2 = this.f15359l;
        int i3 = length - i2;
        if (f2 >= limit || position >= i3) {
            int min = Math.min(position, i3);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.f15356i, this.f15359l, min);
            int i4 = this.f15359l + min;
            this.f15359l = i4;
            byte[] bArr2 = this.f15356i;
            if (i4 == bArr2.length) {
                if (this.f15361n) {
                    a(bArr2, this.f15360m);
                    this.f15362o += (long) ((this.f15359l - (this.f15360m * 2)) / this.f15354g);
                } else {
                    this.f15362o += (long) ((i4 - this.f15360m) / this.f15354g);
                }
                a(byteBuffer, this.f15356i, this.f15359l);
                this.f15359l = 0;
                this.f15358k = 2;
            }
            byteBuffer.limit(limit);
            return;
        }
        a(bArr, i2);
        this.f15359l = 0;
        this.f15358k = 0;
    }

    private void d(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        byteBuffer.limit(f2);
        this.f15362o += (long) (byteBuffer.remaining() / this.f15354g);
        a(byteBuffer, this.f15357j, this.f15360m);
        if (f2 < limit) {
            a(this.f15357j, this.f15360m);
            this.f15358k = 0;
            byteBuffer.limit(limit);
        }
    }

    private void e(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        a(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f15361n = true;
        }
    }

    private int f(ByteBuffer byteBuffer) {
        a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > this.f15353f) {
                int i2 = this.f15354g;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private int g(ByteBuffer byteBuffer) {
        a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
        int limit = byteBuffer.limit();
        while (true) {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
            if (Math.abs(byteBuffer.getShort(limit)) > this.f15353f) {
                int i2 = this.f15354g;
                return ((limit / i2) * i2) + i2;
            }
        }
    }

    public void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !g()) {
            int i2 = this.f15358k;
            if (i2 == 0) {
                b(byteBuffer);
            } else if (i2 == 1) {
                c(byteBuffer);
            } else if (i2 == 2) {
                d(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void a(boolean z2) {
        this.f15355h = z2;
    }

    public boolean a() {
        return this.f15355h;
    }

    public AudioProcessor.a b(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f15198d == 2) {
            return this.f15355h ? aVar : AudioProcessor.a.f15195a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    /* access modifiers changed from: protected */
    public void h() {
        int i2 = this.f15359l;
        if (i2 > 0) {
            a(this.f15356i, i2);
        }
        if (!this.f15361n) {
            this.f15362o += (long) (this.f15360m / this.f15354g);
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f15355h) {
            this.f15354g = this.f15322b.f15199e;
            int a2 = a(this.f15351d) * this.f15354g;
            if (this.f15356i.length != a2) {
                this.f15356i = new byte[a2];
            }
            int a3 = a(this.f15352e) * this.f15354g;
            this.f15360m = a3;
            if (this.f15357j.length != a3) {
                this.f15357j = new byte[a3];
            }
        }
        this.f15358k = 0;
        this.f15362o = 0;
        this.f15359l = 0;
        this.f15361n = false;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f15355h = false;
        this.f15360m = 0;
        this.f15356i = ad.f11760f;
        this.f15357j = ad.f11760f;
    }

    public long k() {
        return this.f15362o;
    }
}
