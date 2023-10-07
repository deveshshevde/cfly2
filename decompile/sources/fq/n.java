package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;

public final class n implements j {

    /* renamed from: a  reason: collision with root package name */
    private final q f27896a = new q(10);

    /* renamed from: b  reason: collision with root package name */
    private u f27897b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27898c;

    /* renamed from: d  reason: collision with root package name */
    private long f27899d;

    /* renamed from: e  reason: collision with root package name */
    private int f27900e;

    /* renamed from: f  reason: collision with root package name */
    private int f27901f;

    public void a() {
        this.f27898c = false;
    }

    public void a(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f27898c = true;
            this.f27899d = j2;
            this.f27900e = 0;
            this.f27901f = 0;
        }
    }

    public void a(q qVar) {
        if (this.f27898c) {
            int b2 = qVar.b();
            int i2 = this.f27901f;
            if (i2 < 10) {
                int min = Math.min(b2, 10 - i2);
                System.arraycopy(qVar.f17159a, qVar.d(), this.f27896a.f17159a, this.f27901f, min);
                if (this.f27901f + min == 10) {
                    this.f27896a.c(0);
                    if (73 == this.f27896a.h() && 68 == this.f27896a.h() && 51 == this.f27896a.h()) {
                        this.f27896a.d(3);
                        this.f27900e = this.f27896a.u() + 10;
                    } else {
                        k.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.f27898c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(b2, this.f27900e - this.f27901f);
            this.f27897b.a(qVar, min2);
            this.f27901f += min2;
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        u a2 = iVar.a(dVar.b(), 4);
        this.f27897b = a2;
        a2.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    public void b() {
        int i2;
        if (this.f27898c && (i2 = this.f27900e) != 0 && this.f27901f == i2) {
            this.f27897b.a(this.f27899d, 1, i2, 0, (u.a) null);
            this.f27898c = false;
        }
    }
}
