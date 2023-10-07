package com.google.android.exoplayer2.util;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private long f17096a;

    /* renamed from: b  reason: collision with root package name */
    private long f17097b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f17098c = -9223372036854775807L;

    public aa(long j2) {
        a(j2);
    }

    public static long d(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long e(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public long a() {
        return this.f17096a;
    }

    public synchronized void a(long j2) {
        a.b(this.f17098c == -9223372036854775807L);
        this.f17096a = j2;
    }

    public long b() {
        if (this.f17098c != -9223372036854775807L) {
            return this.f17097b + this.f17098c;
        }
        long j2 = this.f17096a;
        if (j2 != Long.MAX_VALUE) {
            return j2;
        }
        return -9223372036854775807L;
    }

    public long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f17098c != -9223372036854775807L) {
            long e2 = e(this.f17098c);
            long j3 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + e2) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            long j4 = ((j3 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j2;
            j2 += j3 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            if (Math.abs(j4 - e2) < Math.abs(j2 - e2)) {
                j2 = j4;
            }
        }
        return c(d(j2));
    }

    public long c() {
        if (this.f17096a == Long.MAX_VALUE) {
            return 0;
        }
        if (this.f17098c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f17097b;
    }

    public long c(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f17098c != -9223372036854775807L) {
            this.f17098c = j2;
        } else {
            long j3 = this.f17096a;
            if (j3 != Long.MAX_VALUE) {
                this.f17097b = j3 - j2;
            }
            synchronized (this) {
                this.f17098c = j2;
                notifyAll();
            }
        }
        return j2 + this.f17097b;
    }

    public void d() {
        this.f17098c = -9223372036854775807L;
    }

    public synchronized void e() throws InterruptedException {
        while (this.f17098c == -9223372036854775807L) {
            wait();
        }
    }
}
