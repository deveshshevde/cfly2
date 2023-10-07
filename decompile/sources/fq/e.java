package fq;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.c;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fq.ac;
import java.io.EOFException;
import java.io.IOException;

public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27744a = $$Lambda$e$9fusI8zZqQ1OvsZk22KYOR0i1M.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final int f27745b;

    /* renamed from: c  reason: collision with root package name */
    private final f f27746c;

    /* renamed from: d  reason: collision with root package name */
    private final q f27747d;

    /* renamed from: e  reason: collision with root package name */
    private final q f27748e;

    /* renamed from: f  reason: collision with root package name */
    private final p f27749f;

    /* renamed from: g  reason: collision with root package name */
    private i f27750g;

    /* renamed from: h  reason: collision with root package name */
    private long f27751h;

    /* renamed from: i  reason: collision with root package name */
    private long f27752i;

    /* renamed from: j  reason: collision with root package name */
    private int f27753j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27754k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27755l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f27756m;

    public e() {
        this(0);
    }

    public e(int i2) {
        this.f27745b = i2;
        this.f27746c = new f(true);
        this.f27747d = new q(2048);
        this.f27753j = -1;
        this.f27752i = -1;
        q qVar = new q(10);
        this.f27748e = qVar;
        this.f27749f = new p(qVar.f17159a);
    }

    private static int a(int i2, long j2) {
        return (int) ((((long) (i2 * 8)) * 1000000) / j2);
    }

    private s a(long j2) {
        return new c(j2, this.f27752i, a(this.f27753j, this.f27746c.c()), this.f27753j);
    }

    private void a(long j2, boolean z2, boolean z3) {
        if (!this.f27756m) {
            boolean z4 = z2 && this.f27753j > 0;
            if (!z4 || this.f27746c.c() != -9223372036854775807L || z3) {
                ((i) a.b(this.f27750g)).a((!z4 || this.f27746c.c() == -9223372036854775807L) ? new s.b(-9223372036854775807L) : a(j2));
                this.f27756m = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new e()};
    }

    private int b(h hVar) throws IOException, InterruptedException {
        int i2 = 0;
        while (true) {
            hVar.d(this.f27748e.f17159a, 0, 10);
            this.f27748e.c(0);
            if (this.f27748e.l() != 4801587) {
                break;
            }
            this.f27748e.d(3);
            int u2 = this.f27748e.u();
            i2 += u2 + 10;
            hVar.c(u2);
        }
        hVar.a();
        hVar.c(i2);
        if (this.f27752i == -1) {
            this.f27752i = (long) i2;
        }
        return i2;
    }

    private void c(h hVar) throws IOException, InterruptedException {
        if (!this.f27754k) {
            this.f27753j = -1;
            hVar.a();
            long j2 = 0;
            if (hVar.c() == 0) {
                b(hVar);
            }
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    if (!hVar.b(this.f27748e.f17159a, 0, 2, true)) {
                        break;
                    }
                    this.f27748e.c(0);
                    if (!f.a(this.f27748e.i())) {
                        break;
                    } else if (!hVar.b(this.f27748e.f17159a, 0, 4, true)) {
                        break;
                    } else {
                        this.f27749f.a(14);
                        int c2 = this.f27749f.c(13);
                        if (c2 > 6) {
                            j2 += (long) c2;
                            i3++;
                            if (i3 != 1000) {
                                if (!hVar.b(c2 - 6, true)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            this.f27754k = true;
                            throw new ParserException("Malformed ADTS stream");
                        }
                    }
                } catch (EOFException unused) {
                }
            }
            i2 = i3;
            hVar.a();
            if (i2 > 0) {
                this.f27753j = (int) (j2 / ((long) i2));
            } else {
                this.f27753j = -1;
            }
            this.f27754k = true;
        }
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        long d2 = hVar.d();
        boolean z2 = ((this.f27745b & 1) == 0 || d2 == -1) ? false : true;
        if (z2) {
            c(hVar);
        }
        int a2 = hVar.a(this.f27747d.f17159a, 0, 2048);
        boolean z3 = a2 == -1;
        a(d2, z2, z3);
        if (z3) {
            return -1;
        }
        this.f27747d.c(0);
        this.f27747d.b(a2);
        if (!this.f27755l) {
            this.f27746c.a(this.f27751h, 4);
            this.f27755l = true;
        }
        this.f27746c.a(this.f27747d);
        return 0;
    }

    public void a(long j2, long j3) {
        this.f27755l = false;
        this.f27746c.a();
        this.f27751h = j3;
    }

    public void a(i iVar) {
        this.f27750g = iVar;
        this.f27746c.a(iVar, new ac.d(0, 1));
        iVar.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r9.a();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if ((r3 - r0) < 8192) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(fj.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            int r0 = r8.b(r9)
            r1 = 0
            r3 = r0
        L_0x0006:
            r2 = 0
            r4 = 0
        L_0x0008:
            com.google.android.exoplayer2.util.q r5 = r8.f27748e
            byte[] r5 = r5.f17159a
            r6 = 2
            r9.d(r5, r1, r6)
            com.google.android.exoplayer2.util.q r5 = r8.f27748e
            r5.c(r1)
            com.google.android.exoplayer2.util.q r5 = r8.f27748e
            int r5 = r5.i()
            boolean r5 = fq.f.a((int) r5)
            if (r5 != 0) goto L_0x0031
            r9.a()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L_0x002d
            return r1
        L_0x002d:
            r9.c(r3)
            goto L_0x0006
        L_0x0031:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L_0x003b
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L_0x003b
            return r5
        L_0x003b:
            com.google.android.exoplayer2.util.q r5 = r8.f27748e
            byte[] r5 = r5.f17159a
            r9.d(r5, r1, r6)
            com.google.android.exoplayer2.util.p r5 = r8.f27749f
            r6 = 14
            r5.a((int) r6)
            com.google.android.exoplayer2.util.p r5 = r8.f27749f
            r6 = 13
            int r5 = r5.c(r6)
            r6 = 6
            if (r5 > r6) goto L_0x0055
            return r1
        L_0x0055:
            int r6 = r5 + -6
            r9.c(r6)
            int r4 = r4 + r5
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.e.a(fj.h):boolean");
    }

    public void c() {
    }
}
