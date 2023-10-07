package fl;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.i;
import fj.k;
import fj.l;
import fj.m;
import fj.n;
import fj.r;
import fj.s;
import fj.u;
import java.io.IOException;

public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27463a = $$Lambda$b$QbuH88CfP6kb_7pve5RRci3zzic.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f27464b;

    /* renamed from: c  reason: collision with root package name */
    private final q f27465c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f27466d;

    /* renamed from: e  reason: collision with root package name */
    private final l.a f27467e;

    /* renamed from: f  reason: collision with root package name */
    private i f27468f;

    /* renamed from: g  reason: collision with root package name */
    private u f27469g;

    /* renamed from: h  reason: collision with root package name */
    private int f27470h;

    /* renamed from: i  reason: collision with root package name */
    private Metadata f27471i;

    /* renamed from: j  reason: collision with root package name */
    private h f27472j;

    /* renamed from: k  reason: collision with root package name */
    private int f27473k;

    /* renamed from: l  reason: collision with root package name */
    private int f27474l;

    /* renamed from: m  reason: collision with root package name */
    private a f27475m;

    /* renamed from: n  reason: collision with root package name */
    private int f27476n;

    /* renamed from: o  reason: collision with root package name */
    private long f27477o;

    public b() {
        this(0);
    }

    public b(int i2) {
        this.f27464b = new byte[42];
        this.f27465c = new q(new byte[32768], 0);
        this.f27466d = (i2 & 1) == 0 ? false : true;
        this.f27467e = new l.a();
        this.f27470h = 0;
    }

    private long a(q qVar, boolean z2) {
        boolean z3;
        a.b(this.f27472j);
        int d2 = qVar.d();
        while (true) {
            if (d2 <= qVar.c() - 16) {
                qVar.c(d2);
                if (l.a(qVar, this.f27472j, this.f27474l, this.f27467e)) {
                    break;
                }
                d2++;
            } else if (z2) {
                while (d2 <= qVar.c() - this.f27473k) {
                    qVar.c(d2);
                    boolean z4 = false;
                    try {
                        z3 = l.a(qVar, this.f27472j, this.f27474l, this.f27467e);
                    } catch (IndexOutOfBoundsException unused) {
                        z3 = false;
                    }
                    if (qVar.d() <= qVar.c()) {
                        z4 = z3;
                    }
                    if (!z4) {
                        d2++;
                    }
                }
                qVar.c(qVar.c());
                return -1;
            } else {
                qVar.c(d2);
                return -1;
            }
        }
        qVar.c(d2);
        return this.f27467e.f27379a;
    }

    private void a() {
        ((u) ad.a(this.f27469g)).a((this.f27477o * 1000000) / ((long) ((h) ad.a(this.f27472j)).f17117e), 1, this.f27476n, 0, (u.a) null);
    }

    private int b(fj.h hVar, r rVar) throws IOException, InterruptedException {
        boolean z2;
        a.b(this.f27469g);
        a.b(this.f27472j);
        a aVar = this.f27475m;
        if (aVar != null && aVar.b()) {
            return this.f27475m.a(hVar, rVar);
        }
        if (this.f27477o == -1) {
            this.f27477o = l.a(hVar, this.f27472j);
            return 0;
        }
        int c2 = this.f27465c.c();
        if (c2 < 32768) {
            int a2 = hVar.a(this.f27465c.f17159a, c2, 32768 - c2);
            z2 = a2 == -1;
            if (!z2) {
                this.f27465c.b(c2 + a2);
            } else if (this.f27465c.b() == 0) {
                a();
                return -1;
            }
        } else {
            z2 = false;
        }
        int d2 = this.f27465c.d();
        int i2 = this.f27476n;
        int i3 = this.f27473k;
        if (i2 < i3) {
            q qVar = this.f27465c;
            qVar.d(Math.min(i3 - i2, qVar.b()));
        }
        long a3 = a(this.f27465c, z2);
        int d3 = this.f27465c.d() - d2;
        this.f27465c.c(d2);
        this.f27469g.a(this.f27465c, d3);
        this.f27476n += d3;
        if (a3 != -1) {
            a();
            this.f27476n = 0;
            this.f27477o = a3;
        }
        if (this.f27465c.b() < 16) {
            System.arraycopy(this.f27465c.f17159a, this.f27465c.d(), this.f27465c.f17159a, 0, this.f27465c.b());
            q qVar2 = this.f27465c;
            qVar2.a(qVar2.b());
        }
        return 0;
    }

    private s b(long j2, long j3) {
        a.b(this.f27472j);
        if (this.f27472j.f17123k != null) {
            return new n(this.f27472j, j2);
        }
        if (j3 == -1 || this.f27472j.f17122j <= 0) {
            return new s.b(this.f27472j.b());
        }
        a aVar = new a(this.f27472j, this.f27474l, j2, j3);
        this.f27475m = aVar;
        return aVar.a();
    }

    private void b(fj.h hVar) throws IOException, InterruptedException {
        this.f27471i = m.b(hVar, !this.f27466d);
        this.f27470h = 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] b() {
        return new g[]{new b()};
    }

    private void c(fj.h hVar) throws IOException, InterruptedException {
        byte[] bArr = this.f27464b;
        hVar.d(bArr, 0, bArr.length);
        hVar.a();
        this.f27470h = 2;
    }

    private void d(fj.h hVar) throws IOException, InterruptedException {
        m.b(hVar);
        this.f27470h = 3;
    }

    private void e(fj.h hVar) throws IOException, InterruptedException {
        m.a aVar = new m.a(this.f27472j);
        boolean z2 = false;
        while (!z2) {
            z2 = m.a(hVar, aVar);
            this.f27472j = (h) ad.a(aVar.f27380a);
        }
        a.b(this.f27472j);
        this.f27473k = Math.max(this.f27472j.f17115c, 6);
        ((u) ad.a(this.f27469g)).a(this.f27472j.a(this.f27464b, this.f27471i));
        this.f27470h = 4;
    }

    private void f(fj.h hVar) throws IOException, InterruptedException {
        this.f27474l = m.c(hVar);
        ((i) ad.a(this.f27468f)).a(b(hVar.c(), hVar.d()));
        this.f27470h = 5;
    }

    public int a(fj.h hVar, r rVar) throws IOException, InterruptedException {
        int i2 = this.f27470h;
        if (i2 == 0) {
            b(hVar);
            return 0;
        } else if (i2 == 1) {
            c(hVar);
            return 0;
        } else if (i2 == 2) {
            d(hVar);
            return 0;
        } else if (i2 == 3) {
            e(hVar);
            return 0;
        } else if (i2 == 4) {
            f(hVar);
            return 0;
        } else if (i2 == 5) {
            return b(hVar, rVar);
        } else {
            throw new IllegalStateException();
        }
    }

    public void a(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.f27470h = 0;
        } else {
            a aVar = this.f27475m;
            if (aVar != null) {
                aVar.a(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.f27477o = j4;
        this.f27476n = 0;
        this.f27465c.a();
    }

    public void a(i iVar) {
        this.f27468f = iVar;
        this.f27469g = iVar.a(0, 1);
        iVar.a();
    }

    public boolean a(fj.h hVar) throws IOException, InterruptedException {
        m.a(hVar, false);
        return m.a(hVar);
    }

    public void c() {
    }
}
