package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.util.ad;
import java.lang.reflect.Method;

final class h {
    private long A;
    private boolean B;
    private long C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    private final a f15294a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f15295b;

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f15296c;

    /* renamed from: d  reason: collision with root package name */
    private int f15297d;

    /* renamed from: e  reason: collision with root package name */
    private int f15298e;

    /* renamed from: f  reason: collision with root package name */
    private g f15299f;

    /* renamed from: g  reason: collision with root package name */
    private int f15300g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15301h;

    /* renamed from: i  reason: collision with root package name */
    private long f15302i;

    /* renamed from: j  reason: collision with root package name */
    private long f15303j;

    /* renamed from: k  reason: collision with root package name */
    private long f15304k;

    /* renamed from: l  reason: collision with root package name */
    private Method f15305l;

    /* renamed from: m  reason: collision with root package name */
    private long f15306m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15307n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15308o;

    /* renamed from: p  reason: collision with root package name */
    private long f15309p;

    /* renamed from: q  reason: collision with root package name */
    private long f15310q;

    /* renamed from: r  reason: collision with root package name */
    private long f15311r;

    /* renamed from: s  reason: collision with root package name */
    private long f15312s;

    /* renamed from: t  reason: collision with root package name */
    private int f15313t;

    /* renamed from: u  reason: collision with root package name */
    private int f15314u;

    /* renamed from: v  reason: collision with root package name */
    private long f15315v;

    /* renamed from: w  reason: collision with root package name */
    private long f15316w;

    /* renamed from: x  reason: collision with root package name */
    private long f15317x;

    /* renamed from: y  reason: collision with root package name */
    private long f15318y;

    /* renamed from: z  reason: collision with root package name */
    private long f15319z;

    public interface a {
        void a(int i2, long j2);

        void a(long j2);

        void a(long j2, long j3, long j4, long j5);

        void b(long j2, long j3, long j4, long j5);
    }

    public h(a aVar) {
        this.f15294a = (a) com.google.android.exoplayer2.util.a.b(aVar);
        if (ad.f11755a >= 18) {
            try {
                this.f15305l = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f15295b = new long[10];
    }

    private void a(long j2, long j3) {
        g gVar = (g) com.google.android.exoplayer2.util.a.b(this.f15299f);
        if (gVar.a(j2)) {
            long e2 = gVar.e();
            long f2 = gVar.f();
            if (Math.abs(e2 - j2) > 5000000) {
                this.f15294a.b(f2, e2, j2, j3);
            } else if (Math.abs(g(f2) - j3) > 5000000) {
                this.f15294a.a(f2, e2, j2, j3);
            } else {
                gVar.b();
                return;
            }
            gVar.a();
        }
    }

    private static boolean a(int i2) {
        return ad.f11755a < 23 && (i2 == 5 || i2 == 6);
    }

    private void e() {
        long h2 = h();
        if (h2 != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f15304k >= 30000) {
                long[] jArr = this.f15295b;
                int i2 = this.f15313t;
                jArr[i2] = h2 - nanoTime;
                this.f15313t = (i2 + 1) % 10;
                int i3 = this.f15314u;
                if (i3 < 10) {
                    this.f15314u = i3 + 1;
                }
                this.f15304k = nanoTime;
                this.f15303j = 0;
                int i4 = 0;
                while (true) {
                    int i5 = this.f15314u;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f15303j += this.f15295b[i4] / ((long) i5);
                    i4++;
                }
            }
            if (!this.f15301h) {
                a(nanoTime, h2);
                f(nanoTime);
            }
        }
    }

    private void f() {
        this.f15303j = 0;
        this.f15314u = 0;
        this.f15313t = 0;
        this.f15304k = 0;
        this.A = 0;
        this.D = 0;
    }

    private void f(long j2) {
        Method method;
        if (this.f15308o && (method = this.f15305l) != null && j2 - this.f15309p >= 500000) {
            try {
                long intValue = (((long) ((Integer) ad.a((Integer) method.invoke(com.google.android.exoplayer2.util.a.b(this.f15296c), new Object[0]))).intValue()) * 1000) - this.f15302i;
                this.f15306m = intValue;
                long max = Math.max(intValue, 0);
                this.f15306m = max;
                if (max > 5000000) {
                    this.f15294a.a(max);
                    this.f15306m = 0;
                }
            } catch (Exception unused) {
                this.f15305l = null;
            }
            this.f15309p = j2;
        }
    }

    private long g(long j2) {
        return (j2 * 1000000) / ((long) this.f15300g);
    }

    private boolean g() {
        return this.f15301h && ((AudioTrack) com.google.android.exoplayer2.util.a.b(this.f15296c)).getPlayState() == 2 && i() == 0;
    }

    private long h() {
        return g(i());
    }

    private long i() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.util.a.b(this.f15296c);
        if (this.f15315v != -9223372036854775807L) {
            return Math.min(this.f15318y, this.f15317x + ((((SystemClock.elapsedRealtime() * 1000) - this.f15315v) * ((long) this.f15300g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.f15301h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f15312s = this.f15310q;
            }
            playbackHeadPosition += this.f15312s;
        }
        if (ad.f11755a <= 29) {
            if (playbackHeadPosition == 0 && this.f15310q > 0 && playState == 3) {
                if (this.f15316w == -9223372036854775807L) {
                    this.f15316w = SystemClock.elapsedRealtime();
                }
                return this.f15310q;
            }
            this.f15316w = -9223372036854775807L;
        }
        if (this.f15310q > playbackHeadPosition) {
            this.f15311r++;
        }
        this.f15310q = playbackHeadPosition;
        return playbackHeadPosition + (this.f15311r << 32);
    }

    public long a(boolean z2) {
        long j2;
        if (((AudioTrack) com.google.android.exoplayer2.util.a.b(this.f15296c)).getPlayState() == 3) {
            e();
        }
        long nanoTime = System.nanoTime() / 1000;
        g gVar = (g) com.google.android.exoplayer2.util.a.b(this.f15299f);
        boolean c2 = gVar.c();
        if (c2) {
            j2 = g(gVar.f()) + (nanoTime - gVar.e());
        } else {
            j2 = this.f15314u == 0 ? h() : this.f15303j + nanoTime;
            if (!z2) {
                j2 = Math.max(0, j2 - this.f15306m);
            }
        }
        if (this.B != c2) {
            this.D = this.A;
            this.C = this.f15319z;
        }
        long j3 = nanoTime - this.D;
        if (j3 < 1000000) {
            long j4 = this.C + j3;
            long j5 = (j3 * 1000) / 1000000;
            j2 = ((j2 * j5) + ((1000 - j5) * j4)) / 1000;
        }
        this.A = nanoTime;
        this.f15319z = j2;
        this.B = c2;
        return j2;
    }

    public void a() {
        ((g) com.google.android.exoplayer2.util.a.b(this.f15299f)).d();
    }

    public void a(AudioTrack audioTrack, int i2, int i3, int i4) {
        this.f15296c = audioTrack;
        this.f15297d = i3;
        this.f15298e = i4;
        this.f15299f = new g(audioTrack);
        this.f15300g = audioTrack.getSampleRate();
        this.f15301h = a(i2);
        boolean d2 = ad.d(i2);
        this.f15308o = d2;
        this.f15302i = d2 ? g((long) (i4 / i3)) : -9223372036854775807L;
        this.f15310q = 0;
        this.f15311r = 0;
        this.f15312s = 0;
        this.f15307n = false;
        this.f15315v = -9223372036854775807L;
        this.f15316w = -9223372036854775807L;
        this.f15309p = 0;
        this.f15306m = 0;
    }

    public boolean a(long j2) {
        a aVar;
        int playState = ((AudioTrack) com.google.android.exoplayer2.util.a.b(this.f15296c)).getPlayState();
        if (this.f15301h) {
            if (playState == 2) {
                this.f15307n = false;
                return false;
            } else if (playState == 1 && i() == 0) {
                return false;
            }
        }
        boolean z2 = this.f15307n;
        boolean e2 = e(j2);
        this.f15307n = e2;
        if (z2 && !e2 && playState != 1 && (aVar = this.f15294a) != null) {
            aVar.a(this.f15298e, e.a(this.f15302i));
        }
        return true;
    }

    public int b(long j2) {
        return this.f15298e - ((int) (j2 - (i() * ((long) this.f15297d))));
    }

    public boolean b() {
        return ((AudioTrack) com.google.android.exoplayer2.util.a.b(this.f15296c)).getPlayState() == 3;
    }

    public boolean c() {
        f();
        if (this.f15315v != -9223372036854775807L) {
            return false;
        }
        ((g) com.google.android.exoplayer2.util.a.b(this.f15299f)).d();
        return true;
    }

    public boolean c(long j2) {
        return this.f15316w != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.f15316w >= 200;
    }

    public void d() {
        f();
        this.f15296c = null;
        this.f15299f = null;
    }

    public void d(long j2) {
        this.f15317x = i();
        this.f15315v = SystemClock.elapsedRealtime() * 1000;
        this.f15318y = j2;
    }

    public boolean e(long j2) {
        return j2 > i() || g();
    }
}
