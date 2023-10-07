package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;

final class s extends j {

    /* renamed from: d  reason: collision with root package name */
    private int f15400d;

    /* renamed from: e  reason: collision with root package name */
    private int f15401e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15402f;

    /* renamed from: g  reason: collision with root package name */
    private int f15403g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f15404h = ad.f11760f;

    /* renamed from: i  reason: collision with root package name */
    private int f15405i;

    /* renamed from: j  reason: collision with root package name */
    private long f15406j;

    public void a(int i2, int i3) {
        this.f15400d = i2;
        this.f15401e = i3;
    }

    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            int min = Math.min(i2, this.f15403g);
            this.f15406j += (long) (min / this.f15322b.f15199e);
            this.f15403g -= min;
            byteBuffer.position(position + min);
            if (this.f15403g <= 0) {
                int i3 = i2 - min;
                int length = (this.f15405i + i3) - this.f15404h.length;
                ByteBuffer a2 = a(length);
                int a3 = ad.a(length, 0, this.f15405i);
                a2.put(this.f15404h, 0, a3);
                int a4 = ad.a(length - a3, 0, i3);
                byteBuffer.limit(byteBuffer.position() + a4);
                a2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - a4;
                int i5 = this.f15405i - a3;
                this.f15405i = i5;
                byte[] bArr = this.f15404h;
                System.arraycopy(bArr, a3, bArr, 0, i5);
                byteBuffer.get(this.f15404h, this.f15405i, i4);
                this.f15405i += i4;
                a2.flip();
            }
        }
    }

    public AudioProcessor.a b(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f15198d == 2) {
            this.f15402f = true;
            return (this.f15400d == 0 && this.f15401e == 0) ? AudioProcessor.a.f15195a : aVar;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    public ByteBuffer c() {
        int i2;
        if (super.d() && (i2 = this.f15405i) > 0) {
            a(i2).put(this.f15404h, 0, this.f15405i).flip();
            this.f15405i = 0;
        }
        return super.c();
    }

    public boolean d() {
        return super.d() && this.f15405i == 0;
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (this.f15402f) {
            int i2 = this.f15405i;
            if (i2 > 0) {
                this.f15406j += (long) (i2 / this.f15322b.f15199e);
            }
            this.f15405i = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f15402f) {
            this.f15402f = false;
            this.f15404h = new byte[(this.f15401e * this.f15322b.f15199e)];
            this.f15403g = this.f15400d * this.f15322b.f15199e;
        }
        this.f15405i = 0;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f15404h = ad.f11760f;
    }

    public void k() {
        this.f15406j = 0;
    }

    public long l() {
        return this.f15406j;
    }
}
