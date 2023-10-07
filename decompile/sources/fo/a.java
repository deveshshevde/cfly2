package fo;

import com.google.android.exoplayer2.util.ad;
import fj.h;
import fj.s;
import fj.t;
import java.io.EOFException;
import java.io.IOException;

final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final e f27590a = new e();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f27591b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f27592c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final h f27593d;

    /* renamed from: e  reason: collision with root package name */
    private int f27594e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f27595f;

    /* renamed from: g  reason: collision with root package name */
    private long f27596g;

    /* renamed from: h  reason: collision with root package name */
    private long f27597h;

    /* renamed from: i  reason: collision with root package name */
    private long f27598i;

    /* renamed from: j  reason: collision with root package name */
    private long f27599j;

    /* renamed from: k  reason: collision with root package name */
    private long f27600k;

    /* renamed from: l  reason: collision with root package name */
    private long f27601l;

    /* renamed from: fo.a$a  reason: collision with other inner class name */
    private final class C0174a implements s {
        private C0174a() {
        }

        public s.a a(long j2) {
            return new s.a(new t(j2, ad.a((a.this.f27591b + ((a.this.f27593d.b(j2) * (a.this.f27592c - a.this.f27591b)) / a.this.f27595f)) - 30000, a.this.f27591b, a.this.f27592c - 1)));
        }

        public boolean a() {
            return true;
        }

        public long b() {
            return a.this.f27593d.a(a.this.f27595f);
        }
    }

    public a(h hVar, long j2, long j3, long j4, long j5, boolean z2) {
        com.google.android.exoplayer2.util.a.a(j2 >= 0 && j3 > j2);
        this.f27593d = hVar;
        this.f27591b = j2;
        this.f27592c = j3;
        if (j4 == j3 - j2 || z2) {
            this.f27595f = j5;
            this.f27594e = 4;
            return;
        }
        this.f27594e = 0;
    }

    private boolean a(h hVar, long j2) throws IOException, InterruptedException {
        int i2;
        long min = Math.min(j2 + 3, this.f27592c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i4 = 0;
            if (hVar.c() + ((long) i3) <= min || (i3 = (int) (min - hVar.c())) >= 4) {
                hVar.b(bArr, 0, i3, false);
                while (true) {
                    i2 = i3 - 3;
                    if (i4 >= i2) {
                        break;
                    } else if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        hVar.b(i4);
                        return true;
                    } else {
                        i4++;
                    }
                }
            } else {
                return false;
            }
            hVar.b(i2);
        }
    }

    private long d(h hVar) throws IOException, InterruptedException {
        if (this.f27598i == this.f27599j) {
            return -1;
        }
        long c2 = hVar.c();
        if (!a(hVar, this.f27599j)) {
            long j2 = this.f27598i;
            if (j2 != c2) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f27590a.a(hVar, false);
        hVar.a();
        long j3 = this.f27597h - this.f27590a.f27619c;
        int i2 = this.f27590a.f27624h + this.f27590a.f27625i;
        if (0 <= j3 && j3 < 72000) {
            return -1;
        }
        if (j3 < 0) {
            this.f27599j = c2;
            this.f27601l = this.f27590a.f27619c;
        } else {
            this.f27598i = hVar.c() + ((long) i2);
            this.f27600k = this.f27590a.f27619c;
        }
        long j4 = this.f27599j;
        long j5 = this.f27598i;
        if (j4 - j5 < 100000) {
            this.f27599j = j5;
            return j5;
        }
        long c3 = hVar.c() - (((long) i2) * (j3 <= 0 ? 2 : 1));
        long j6 = this.f27599j;
        long j7 = this.f27598i;
        return ad.a(c3 + ((j3 * (j6 - j7)) / (this.f27601l - this.f27600k)), j7, j6 - 1);
    }

    private void e(h hVar) throws IOException, InterruptedException {
        e eVar = this.f27590a;
        while (true) {
            eVar.a(hVar, false);
            if (this.f27590a.f27619c <= this.f27597h) {
                hVar.b(this.f27590a.f27624h + this.f27590a.f27625i);
                this.f27598i = hVar.c();
                this.f27600k = this.f27590a.f27619c;
                eVar = this.f27590a;
            } else {
                hVar.a();
                return;
            }
        }
    }

    public long a(h hVar) throws IOException, InterruptedException {
        int i2 = this.f27594e;
        if (i2 == 0) {
            long c2 = hVar.c();
            this.f27596g = c2;
            this.f27594e = 1;
            long j2 = this.f27592c - 65307;
            if (j2 > c2) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long d2 = d(hVar);
                if (d2 != -1) {
                    return d2;
                }
                this.f27594e = 3;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            e(hVar);
            this.f27594e = 4;
            return -(this.f27600k + 2);
        }
        this.f27595f = c(hVar);
        this.f27594e = 4;
        return this.f27596g;
    }

    /* renamed from: a */
    public C0174a b() {
        if (this.f27595f != 0) {
            return new C0174a();
        }
        return null;
    }

    public void a(long j2) {
        this.f27597h = ad.a(j2, 0, this.f27595f - 1);
        this.f27594e = 2;
        this.f27598i = this.f27591b;
        this.f27599j = this.f27592c;
        this.f27600k = 0;
        this.f27601l = this.f27595f;
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar) throws IOException, InterruptedException {
        if (!a(hVar, this.f27592c)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public long c(h hVar) throws IOException, InterruptedException {
        b(hVar);
        this.f27590a.a();
        while ((this.f27590a.f27618b & 4) != 4 && hVar.c() < this.f27592c) {
            this.f27590a.a(hVar, false);
            hVar.b(this.f27590a.f27624h + this.f27590a.f27625i);
        }
        return this.f27590a.f27619c;
    }
}
