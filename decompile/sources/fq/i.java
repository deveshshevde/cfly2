package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fj.u;
import fq.ac;
import java.util.Collections;
import java.util.List;

public final class i implements j {

    /* renamed from: a  reason: collision with root package name */
    private final List<ac.a> f27792a;

    /* renamed from: b  reason: collision with root package name */
    private final u[] f27793b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27794c;

    /* renamed from: d  reason: collision with root package name */
    private int f27795d;

    /* renamed from: e  reason: collision with root package name */
    private int f27796e;

    /* renamed from: f  reason: collision with root package name */
    private long f27797f;

    public i(List<ac.a> list) {
        this.f27792a = list;
        this.f27793b = new u[list.size()];
    }

    private boolean a(q qVar, int i2) {
        if (qVar.b() == 0) {
            return false;
        }
        if (qVar.h() != i2) {
            this.f27794c = false;
        }
        this.f27795d--;
        return this.f27794c;
    }

    public void a() {
        this.f27794c = false;
    }

    public void a(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f27794c = true;
            this.f27797f = j2;
            this.f27796e = 0;
            this.f27795d = 2;
        }
    }

    public void a(q qVar) {
        if (!this.f27794c) {
            return;
        }
        if (this.f27795d != 2 || a(qVar, 32)) {
            if (this.f27795d != 1 || a(qVar, 0)) {
                int d2 = qVar.d();
                int b2 = qVar.b();
                for (u a2 : this.f27793b) {
                    qVar.c(d2);
                    a2.a(qVar, b2);
                }
                this.f27796e += b2;
            }
        }
    }

    public void a(fj.i iVar, ac.d dVar) {
        for (int i2 = 0; i2 < this.f27793b.length; i2++) {
            ac.a aVar = this.f27792a.get(i2);
            dVar.a();
            u a2 = iVar.a(dVar.b(), 3);
            a2.a(Format.a(dVar.c(), "application/dvbsubs", (String) null, -1, 0, (List<byte[]>) Collections.singletonList(aVar.f27703c), aVar.f27701a, (DrmInitData) null));
            this.f27793b[i2] = a2;
        }
    }

    public void b() {
        if (this.f27794c) {
            for (u a2 : this.f27793b) {
                a2.a(this.f27797f, 1, this.f27796e, 0, (u.a) null);
            }
            this.f27794c = false;
        }
    }
}
