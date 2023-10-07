package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.v;
import java.nio.ByteBuffer;

public interface AudioSink {

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(String str) {
            super(str);
        }

        public ConfigurationException(Throwable th) {
            super(th);
        }
    }

    public static final class InitializationException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final int f15200a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InitializationException(int r3, int r4, int r5, int r6) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 82
                r0.<init>(r1)
                java.lang.String r1 = "AudioTrack init failed: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = ", Config("
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = ", "
                r0.append(r4)
                r0.append(r5)
                r0.append(r4)
                r0.append(r6)
                java.lang.String r4 = ")"
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4)
                r2.f15200a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.InitializationException.<init>(int, int, int, int):void");
        }
    }

    public static final class WriteException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final int f15201a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public WriteException(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 36
                r0.<init>(r1)
                java.lang.String r1 = "AudioTrack write failed: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.f15201a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.WriteException.<init>(int):void");
        }
    }

    public interface a {
        void a();

        void a(int i2);

        void a(int i2, long j2, long j3);
    }

    long a(boolean z2);

    void a();

    void a(float f2);

    void a(int i2);

    void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7) throws ConfigurationException;

    void a(a aVar);

    void a(c cVar);

    void a(i iVar);

    void a(v vVar);

    boolean a(int i2, int i3);

    boolean a(ByteBuffer byteBuffer, long j2) throws InitializationException, WriteException;

    void b();

    void c() throws WriteException;

    boolean d();

    boolean e();

    v f();

    void g();

    void h();

    void i();

    void j();
}
