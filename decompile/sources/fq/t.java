package fq;

import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fj.h;
import fj.r;
import java.io.IOException;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private final aa f27953a = new aa(0);

    /* renamed from: b  reason: collision with root package name */
    private final q f27954b = new q();

    /* renamed from: c  reason: collision with root package name */
    private boolean f27955c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27956d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27957e;

    /* renamed from: f  reason: collision with root package name */
    private long f27958f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f27959g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f27960h = -9223372036854775807L;

    t() {
    }

    private int a(h hVar) {
        this.f27954b.a(ad.f11760f);
        this.f27955c = true;
        hVar.a();
        return 0;
    }

    private int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static long a(q qVar) {
        int d2 = qVar.d();
        if (qVar.b() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        qVar.a(bArr, 0, 9);
        qVar.c(d2);
        if (!a(bArr)) {
            return -9223372036854775807L;
        }
        return b(bArr);
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(h hVar, r rVar) throws IOException, InterruptedException {
        int min = (int) Math.min(20000, hVar.d());
        long j2 = (long) 0;
        if (hVar.c() != j2) {
            rVar.f27401a = j2;
            return 1;
        }
        this.f27954b.a(min);
        hVar.a();
        hVar.d(this.f27954b.f17159a, 0, min);
        this.f27958f = b(this.f27954b);
        this.f27956d = true;
        return 0;
    }

    private long b(q qVar) {
        int c2 = qVar.c();
        for (int d2 = qVar.d(); d2 < c2 - 3; d2++) {
            if (a(qVar.f17159a, d2) == 442) {
                qVar.c(d2 + 4);
                long a2 = a(qVar);
                if (a2 != -9223372036854775807L) {
                    return a2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private static long b(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    private int c(h hVar, r rVar) throws IOException, InterruptedException {
        long d2 = hVar.d();
        int min = (int) Math.min(20000, d2);
        long j2 = d2 - ((long) min);
        if (hVar.c() != j2) {
            rVar.f27401a = j2;
            return 1;
        }
        this.f27954b.a(min);
        hVar.a();
        hVar.d(this.f27954b.f17159a, 0, min);
        this.f27959g = c(this.f27954b);
        this.f27957e = true;
        return 0;
    }

    private long c(q qVar) {
        int d2 = qVar.d();
        for (int c2 = qVar.c() - 4; c2 >= d2; c2--) {
            if (a(qVar.f17159a, c2) == 442) {
                qVar.c(c2 + 4);
                long a2 = a(qVar);
                if (a2 != -9223372036854775807L) {
                    return a2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        if (!this.f27957e) {
            return c(hVar, rVar);
        }
        if (this.f27959g == -9223372036854775807L) {
            return a(hVar);
        }
        if (!this.f27956d) {
            return b(hVar, rVar);
        }
        long j2 = this.f27958f;
        if (j2 == -9223372036854775807L) {
            return a(hVar);
        }
        this.f27960h = this.f27953a.b(this.f27959g) - this.f27953a.b(j2);
        return a(hVar);
    }

    public boolean a() {
        return this.f27955c;
    }

    public aa b() {
        return this.f27953a;
    }

    public long c() {
        return this.f27960h;
    }
}
