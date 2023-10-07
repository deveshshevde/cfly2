package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.ad;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private final a f15283a;

    /* renamed from: b  reason: collision with root package name */
    private int f15284b;

    /* renamed from: c  reason: collision with root package name */
    private long f15285c;

    /* renamed from: d  reason: collision with root package name */
    private long f15286d;

    /* renamed from: e  reason: collision with root package name */
    private long f15287e;

    /* renamed from: f  reason: collision with root package name */
    private long f15288f;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f15289a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f15290b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f15291c;

        /* renamed from: d  reason: collision with root package name */
        private long f15292d;

        /* renamed from: e  reason: collision with root package name */
        private long f15293e;

        public a(AudioTrack audioTrack) {
            this.f15289a = audioTrack;
        }

        public boolean a() {
            boolean timestamp = this.f15289a.getTimestamp(this.f15290b);
            if (timestamp) {
                long j2 = this.f15290b.framePosition;
                if (this.f15292d > j2) {
                    this.f15291c++;
                }
                this.f15292d = j2;
                this.f15293e = j2 + (this.f15291c << 32);
            }
            return timestamp;
        }

        public long b() {
            return this.f15290b.nanoTime / 1000;
        }

        public long c() {
            return this.f15293e;
        }
    }

    public g(AudioTrack audioTrack) {
        if (ad.f11755a >= 19) {
            this.f15283a = new a(audioTrack);
            d();
            return;
        }
        this.f15283a = null;
        a(3);
    }

    private void a(int i2) {
        this.f15284b = i2;
        long j2 = 10000;
        if (i2 == 0) {
            this.f15287e = 0;
            this.f15288f = -1;
            this.f15285c = System.nanoTime() / 1000;
        } else if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                j2 = 10000000;
            } else if (i2 == 4) {
                j2 = 500000;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f15286d = j2;
    }

    public void a() {
        a(4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0 != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r0 == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r8) {
        /*
            r7 = this;
            com.google.android.exoplayer2.audio.g$a r0 = r7.f15283a
            r1 = 0
            if (r0 == 0) goto L_0x0071
            long r2 = r7.f15287e
            long r2 = r8 - r2
            long r4 = r7.f15286d
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0010
            goto L_0x0071
        L_0x0010:
            r7.f15287e = r8
            boolean r0 = r0.a()
            int r2 = r7.f15284b
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L_0x0049
            r8 = 2
            if (r2 == r4) goto L_0x0033
            if (r2 == r8) goto L_0x0030
            if (r2 == r3) goto L_0x002d
            r8 = 4
            if (r2 != r8) goto L_0x0027
            goto L_0x0070
        L_0x0027:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x002d:
            if (r0 == 0) goto L_0x0070
            goto L_0x0045
        L_0x0030:
            if (r0 != 0) goto L_0x0070
            goto L_0x0045
        L_0x0033:
            if (r0 == 0) goto L_0x0045
            com.google.android.exoplayer2.audio.g$a r9 = r7.f15283a
            long r1 = r9.c()
            long r3 = r7.f15288f
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x0070
            r7.a((int) r8)
            goto L_0x0070
        L_0x0045:
            r7.d()
            goto L_0x0070
        L_0x0049:
            if (r0 == 0) goto L_0x0063
            com.google.android.exoplayer2.audio.g$a r8 = r7.f15283a
            long r8 = r8.b()
            long r2 = r7.f15285c
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0071
            com.google.android.exoplayer2.audio.g$a r8 = r7.f15283a
            long r8 = r8.c()
            r7.f15288f = r8
            r7.a((int) r4)
            goto L_0x0070
        L_0x0063:
            long r1 = r7.f15285c
            long r8 = r8 - r1
            r1 = 500000(0x7a120, double:2.47033E-318)
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x0070
            r7.a((int) r3)
        L_0x0070:
            r1 = r0
        L_0x0071:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.g.a(long):boolean");
    }

    public void b() {
        if (this.f15284b == 4) {
            d();
        }
    }

    public boolean c() {
        return this.f15284b == 2;
    }

    public void d() {
        if (this.f15283a != null) {
            a(0);
        }
    }

    public long e() {
        a aVar = this.f15283a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public long f() {
        a aVar = this.f15283a;
        if (aVar != null) {
            return aVar.c();
        }
        return -1;
    }
}
