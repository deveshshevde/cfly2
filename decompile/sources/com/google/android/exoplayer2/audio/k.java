package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.a;
import java.nio.ByteBuffer;

final class k extends j {

    /* renamed from: d  reason: collision with root package name */
    private int[] f15329d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f15330e;

    k() {
    }

    public void a(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) a.b(this.f15330e);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer a2 = a(((limit - position) / this.f15322b.f15199e) * this.f15323c.f15199e);
        while (position < limit) {
            for (int i2 : iArr) {
                a2.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f15322b.f15199e;
        }
        byteBuffer.position(limit);
        a2.flip();
    }

    public void a(int[] iArr) {
        this.f15329d = iArr;
    }

    public AudioProcessor.a b(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f15329d;
        if (iArr == null) {
            return AudioProcessor.a.f15195a;
        }
        if (aVar.f15198d == 2) {
            boolean z2 = aVar.f15197c != iArr.length;
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 < aVar.f15197c) {
                    z2 |= i3 != i2;
                    i2++;
                } else {
                    throw new AudioProcessor.UnhandledAudioFormatException(aVar);
                }
            }
            return z2 ? new AudioProcessor.a(aVar.f15196b, iArr.length, 2) : AudioProcessor.a.f15195a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.f15330e = this.f15329d;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f15330e = null;
        this.f15329d = null;
    }
}
