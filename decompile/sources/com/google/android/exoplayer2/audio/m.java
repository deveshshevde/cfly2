package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;

final class m extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final int f15334d = Float.floatToIntBits(Float.NaN);

    m() {
    }

    private static void a(int i2, ByteBuffer byteBuffer) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        int floatToIntBits = Float.floatToIntBits((float) (d2 * 4.656612875245797E-10d));
        if (floatToIntBits == f15334d) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public void a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.f15322b.f15198d;
        if (i3 == 536870912) {
            byteBuffer2 = a((i2 / 3) * 4);
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 805306368) {
            byteBuffer2 = a(i2);
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public AudioProcessor.a b(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int i2 = aVar.f15198d;
        if (ad.e(i2)) {
            return i2 != 4 ? new AudioProcessor.a(aVar.f15196b, aVar.f15197c, 4) : AudioProcessor.a.f15195a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }
}
