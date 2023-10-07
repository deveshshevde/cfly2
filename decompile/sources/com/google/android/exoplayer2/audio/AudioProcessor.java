package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f15194a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.a r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.String r0 = java.lang.String.valueOf(r3)
                int r0 = r0.length()
                int r0 = r0 + 18
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Unhandled format: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException.<init>(com.google.android.exoplayer2.audio.AudioProcessor$a):void");
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15195a = new a(-1, -1, -1);

        /* renamed from: b  reason: collision with root package name */
        public final int f15196b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15197c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15198d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15199e;

        public a(int i2, int i3, int i4) {
            this.f15196b = i2;
            this.f15197c = i3;
            this.f15198d = i4;
            this.f15199e = ad.d(i4) ? ad.c(i4, i3) : -1;
        }

        public String toString() {
            int i2 = this.f15196b;
            int i3 = this.f15197c;
            int i4 = this.f15198d;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i2);
            sb.append(", channelCount=");
            sb.append(i3);
            sb.append(", encoding=");
            sb.append(i4);
            sb.append(']');
            return sb.toString();
        }
    }

    a a(a aVar) throws UnhandledAudioFormatException;

    void a(ByteBuffer byteBuffer);

    boolean a();

    void b();

    ByteBuffer c();

    boolean d();

    void e();

    void f();
}
