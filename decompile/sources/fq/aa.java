package fq;

import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.h;
import fj.r;
import java.io.IOException;

final class aa {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.aa f27667a = new com.google.android.exoplayer2.util.aa(0);

    /* renamed from: b  reason: collision with root package name */
    private final q f27668b = new q();

    /* renamed from: c  reason: collision with root package name */
    private boolean f27669c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27670d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27671e;

    /* renamed from: f  reason: collision with root package name */
    private long f27672f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f27673g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f27674h = -9223372036854775807L;

    aa() {
    }

    private int a(h hVar) {
        this.f27668b.a(ad.f11760f);
        this.f27669c = true;
        hVar.a();
        return 0;
    }

    private long a(q qVar, int i2) {
        int c2 = qVar.c();
        for (int d2 = qVar.d(); d2 < c2; d2++) {
            if (qVar.f17159a[d2] == 71) {
                long a2 = ad.a(qVar, d2, i2);
                if (a2 != -9223372036854775807L) {
                    return a2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int b(h hVar, r rVar, int i2) throws IOException, InterruptedException {
        int min = (int) Math.min(112800, hVar.d());
        long j2 = (long) 0;
        if (hVar.c() != j2) {
            rVar.f27401a = j2;
            return 1;
        }
        this.f27668b.a(min);
        hVar.a();
        hVar.d(this.f27668b.f17159a, 0, min);
        this.f27672f = a(this.f27668b, i2);
        this.f27670d = true;
        return 0;
    }

    private long b(q qVar, int i2) {
        int d2 = qVar.d();
        int c2 = qVar.c();
        while (true) {
            c2--;
            if (c2 < d2) {
                return -9223372036854775807L;
            }
            if (qVar.f17159a[c2] == 71) {
                long a2 = ad.a(qVar, c2, i2);
                if (a2 != -9223372036854775807L) {
                    return a2;
                }
            }
        }
    }

    private int c(h hVar, r rVar, int i2) throws IOException, InterruptedException {
        long d2 = hVar.d();
        int min = (int) Math.min(112800, d2);
        long j2 = d2 - ((long) min);
        if (hVar.c() != j2) {
            rVar.f27401a = j2;
            return 1;
        }
        this.f27668b.a(min);
        hVar.a();
        hVar.d(this.f27668b.f17159a, 0, min);
        this.f27673g = b(this.f27668b, i2);
        this.f27671e = true;
        return 0;
    }

    public int a(h hVar, r rVar, int i2) throws IOException, InterruptedException {
        if (i2 <= 0) {
            return a(hVar);
        }
        if (!this.f27671e) {
            return c(hVar, rVar, i2);
        }
        if (this.f27673g == -9223372036854775807L) {
            return a(hVar);
        }
        if (!this.f27670d) {
            return b(hVar, rVar, i2);
        }
        long j2 = this.f27672f;
        if (j2 == -9223372036854775807L) {
            return a(hVar);
        }
        this.f27674h = this.f27667a.b(this.f27673g) - this.f27667a.b(j2);
        return a(hVar);
    }

    public boolean a() {
        return this.f27669c;
    }

    public long b() {
        return this.f27674h;
    }

    public com.google.android.exoplayer2.util.aa c() {
        return this.f27667a;
    }
}
