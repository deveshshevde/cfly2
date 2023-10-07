package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import java.util.List;

public final class p implements j {

    /* renamed from: a  reason: collision with root package name */
    private final q f27922a;

    /* renamed from: b  reason: collision with root package name */
    private final fj.q f27923b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27924c;

    /* renamed from: d  reason: collision with root package name */
    private String f27925d;

    /* renamed from: e  reason: collision with root package name */
    private u f27926e;

    /* renamed from: f  reason: collision with root package name */
    private int f27927f;

    /* renamed from: g  reason: collision with root package name */
    private int f27928g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27929h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27930i;

    /* renamed from: j  reason: collision with root package name */
    private long f27931j;

    /* renamed from: k  reason: collision with root package name */
    private int f27932k;

    /* renamed from: l  reason: collision with root package name */
    private long f27933l;

    public p() {
        this((String) null);
    }

    public p(String str) {
        this.f27927f = 0;
        q qVar = new q(4);
        this.f27922a = qVar;
        qVar.f17159a[0] = -1;
        this.f27923b = new fj.q();
        this.f27924c = str;
    }

    private void b(q qVar) {
        byte[] bArr = qVar.f17159a;
        int c2 = qVar.c();
        for (int d2 = qVar.d(); d2 < c2; d2++) {
            boolean z2 = (bArr[d2] & 255) == 255;
            boolean z3 = this.f27930i && (bArr[d2] & 224) == 224;
            this.f27930i = z2;
            if (z3) {
                qVar.c(d2 + 1);
                this.f27930i = false;
                this.f27922a.f17159a[1] = bArr[d2];
                this.f27928g = 2;
                this.f27927f = 1;
                return;
            }
        }
        qVar.c(c2);
    }

    private void c(q qVar) {
        int min = Math.min(qVar.b(), 4 - this.f27928g);
        qVar.a(this.f27922a.f17159a, this.f27928g, min);
        int i2 = this.f27928g + min;
        this.f27928g = i2;
        if (i2 >= 4) {
            this.f27922a.c(0);
            if (!fj.q.a(this.f27922a.p(), this.f27923b)) {
                this.f27928g = 0;
                this.f27927f = 1;
                return;
            }
            this.f27932k = this.f27923b.f27396c;
            if (!this.f27929h) {
                this.f27931j = (((long) this.f27923b.f27400g) * 1000000) / ((long) this.f27923b.f27397d);
                this.f27926e.a(Format.a(this.f27925d, this.f27923b.f27395b, (String) null, -1, 4096, this.f27923b.f27398e, this.f27923b.f27397d, (List<byte[]>) null, (DrmInitData) null, 0, this.f27924c));
                this.f27929h = true;
            }
            this.f27922a.c(0);
            this.f27926e.a(this.f27922a, 4);
            this.f27927f = 2;
        }
    }

    private void d(q qVar) {
        int min = Math.min(qVar.b(), this.f27932k - this.f27928g);
        this.f27926e.a(qVar, min);
        int i2 = this.f27928g + min;
        this.f27928g = i2;
        int i3 = this.f27932k;
        if (i2 >= i3) {
            this.f27926e.a(this.f27933l, 1, i3, 0, (u.a) null);
            this.f27933l += this.f27931j;
            this.f27928g = 0;
            this.f27927f = 0;
        }
    }

    public void a() {
        this.f27927f = 0;
        this.f27928g = 0;
        this.f27930i = false;
    }

    public void a(long j2, int i2) {
        this.f27933l = j2;
    }

    public void a(q qVar) {
        while (qVar.b() > 0) {
            int i2 = this.f27927f;
            if (i2 == 0) {
                b(qVar);
            } else if (i2 == 1) {
                c(qVar);
            } else if (i2 == 2) {
                d(qVar);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27925d = dVar.c();
        this.f27926e = iVar.a(dVar.b(), 1);
    }

    public void b() {
    }
}
