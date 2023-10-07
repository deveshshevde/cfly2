package fo;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.r;
import fj.s;
import fj.u;
import java.io.IOException;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private final d f27630a = new d();

    /* renamed from: b  reason: collision with root package name */
    private u f27631b;

    /* renamed from: c  reason: collision with root package name */
    private i f27632c;

    /* renamed from: d  reason: collision with root package name */
    private f f27633d;

    /* renamed from: e  reason: collision with root package name */
    private long f27634e;

    /* renamed from: f  reason: collision with root package name */
    private long f27635f;

    /* renamed from: g  reason: collision with root package name */
    private long f27636g;

    /* renamed from: h  reason: collision with root package name */
    private int f27637h;

    /* renamed from: i  reason: collision with root package name */
    private int f27638i;

    /* renamed from: j  reason: collision with root package name */
    private a f27639j;

    /* renamed from: k  reason: collision with root package name */
    private long f27640k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27641l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f27642m;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Format f27643a;

        /* renamed from: b  reason: collision with root package name */
        f f27644b;

        a() {
        }
    }

    private static final class b implements f {
        private b() {
        }

        public long a(fj.h hVar) {
            return -1;
        }

        public void a(long j2) {
        }

        public s b() {
            return new s.b(-9223372036854775807L);
        }
    }

    private int a(fj.h hVar) throws IOException, InterruptedException {
        f bVar;
        boolean z2 = true;
        while (z2) {
            if (!this.f27630a.a(hVar)) {
                this.f27637h = 3;
                return -1;
            }
            this.f27640k = hVar.c() - this.f27635f;
            z2 = a(this.f27630a.c(), this.f27635f, this.f27639j);
            if (z2) {
                this.f27635f = hVar.c();
            }
        }
        fj.h hVar2 = hVar;
        this.f27638i = this.f27639j.f27643a.f15106w;
        if (!this.f27642m) {
            this.f27631b.a(this.f27639j.f27643a);
            this.f27642m = true;
        }
        if (this.f27639j.f27644b != null) {
            bVar = this.f27639j.f27644b;
        } else if (hVar.d() == -1) {
            bVar = new b();
        } else {
            e b2 = this.f27630a.b();
            this.f27633d = new a(this, this.f27635f, hVar.d(), (long) (b2.f27624h + b2.f27625i), b2.f27619c, (b2.f27618b & 4) != 0);
            this.f27639j = null;
            this.f27637h = 2;
            this.f27630a.d();
            return 0;
        }
        this.f27633d = bVar;
        this.f27639j = null;
        this.f27637h = 2;
        this.f27630a.d();
        return 0;
    }

    private int b(fj.h hVar, r rVar) throws IOException, InterruptedException {
        fj.h hVar2 = hVar;
        long a2 = this.f27633d.a(hVar2);
        if (a2 >= 0) {
            rVar.f27401a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.f27641l) {
            this.f27632c.a(this.f27633d.b());
            this.f27641l = true;
        }
        if (this.f27640k > 0 || this.f27630a.a(hVar2)) {
            this.f27640k = 0;
            q c2 = this.f27630a.c();
            long b2 = b(c2);
            if (b2 >= 0) {
                long j2 = this.f27636g;
                if (j2 + b2 >= this.f27634e) {
                    long a3 = a(j2);
                    this.f27631b.a(c2, c2.c());
                    this.f27631b.a(a3, 1, c2.c(), 0, (u.a) null);
                    this.f27634e = -1;
                }
            }
            this.f27636g += b2;
            return 0;
        }
        this.f27637h = 3;
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int a(fj.h hVar, r rVar) throws IOException, InterruptedException {
        int i2 = this.f27637h;
        if (i2 == 0) {
            return a(hVar);
        }
        if (i2 == 1) {
            hVar.b((int) this.f27635f);
            this.f27637h = 2;
            return 0;
        } else if (i2 == 2) {
            return b(hVar, rVar);
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public long a(long j2) {
        return (j2 * 1000000) / ((long) this.f27638i);
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, long j3) {
        this.f27630a.a();
        if (j2 == 0) {
            a(!this.f27641l);
        } else if (this.f27637h != 0) {
            long b2 = b(j3);
            this.f27634e = b2;
            this.f27633d.a(b2);
            this.f27637h = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar, u uVar) {
        this.f27632c = iVar;
        this.f27631b = uVar;
        a(true);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        int i2;
        if (z2) {
            this.f27639j = new a();
            this.f27635f = 0;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f27637h = i2;
        this.f27634e = -1;
        this.f27636g = 0;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(q qVar, long j2, a aVar) throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (((long) this.f27638i) * j2) / 1000000;
    }

    /* access modifiers changed from: protected */
    public abstract long b(q qVar);

    /* access modifiers changed from: protected */
    public void c(long j2) {
        this.f27636g = j2;
    }
}
