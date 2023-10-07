package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.common.NetworkUtil;
import fj.i;
import fj.u;
import fq.ac;
import java.util.List;

public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private final p f27715a;

    /* renamed from: b  reason: collision with root package name */
    private final q f27716b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27717c;

    /* renamed from: d  reason: collision with root package name */
    private String f27718d;

    /* renamed from: e  reason: collision with root package name */
    private u f27719e;

    /* renamed from: f  reason: collision with root package name */
    private int f27720f;

    /* renamed from: g  reason: collision with root package name */
    private int f27721g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27722h;

    /* renamed from: i  reason: collision with root package name */
    private long f27723i;

    /* renamed from: j  reason: collision with root package name */
    private Format f27724j;

    /* renamed from: k  reason: collision with root package name */
    private int f27725k;

    /* renamed from: l  reason: collision with root package name */
    private long f27726l;

    public b() {
        this((String) null);
    }

    public b(String str) {
        p pVar = new p(new byte[128]);
        this.f27715a = pVar;
        this.f27716b = new q(pVar.f17155a);
        this.f27720f = 0;
        this.f27717c = str;
    }

    private boolean a(q qVar, byte[] bArr, int i2) {
        int min = Math.min(qVar.b(), i2 - this.f27721g);
        qVar.a(bArr, this.f27721g, min);
        int i3 = this.f27721g + min;
        this.f27721g = i3;
        return i3 == i2;
    }

    private boolean b(q qVar) {
        while (true) {
            boolean z2 = false;
            if (qVar.b() <= 0) {
                return false;
            }
            if (this.f27722h) {
                int h2 = qVar.h();
                if (h2 == 119) {
                    this.f27722h = false;
                    return true;
                } else if (h2 != 11) {
                    this.f27722h = z2;
                }
            } else if (qVar.h() != 11) {
                this.f27722h = z2;
            }
            z2 = true;
            this.f27722h = z2;
        }
    }

    private void c() {
        this.f27715a.a(0);
        a.C0108a a2 = a.a(this.f27715a);
        if (!(this.f27724j != null && a2.f15258d == this.f27724j.f15105v && a2.f15257c == this.f27724j.f15106w && a2.f15255a == this.f27724j.f15092i)) {
            Format a3 = Format.a(this.f27718d, a2.f15255a, (String) null, -1, -1, a2.f15258d, a2.f15257c, (List<byte[]>) null, (DrmInitData) null, 0, this.f27717c);
            this.f27724j = a3;
            this.f27719e.a(a3);
        }
        this.f27725k = a2.f15259e;
        this.f27723i = (((long) a2.f15260f) * 1000000) / ((long) this.f27724j.f15106w);
    }

    public void a() {
        this.f27720f = 0;
        this.f27721g = 0;
        this.f27722h = false;
    }

    public void a(long j2, int i2) {
        this.f27726l = j2;
    }

    public void a(q qVar) {
        while (qVar.b() > 0) {
            int i2 = this.f27720f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(qVar.b(), this.f27725k - this.f27721g);
                        this.f27719e.a(qVar, min);
                        int i3 = this.f27721g + min;
                        this.f27721g = i3;
                        int i4 = this.f27725k;
                        if (i3 == i4) {
                            this.f27719e.a(this.f27726l, 1, i4, 0, (u.a) null);
                            this.f27726l += this.f27723i;
                            this.f27720f = 0;
                        }
                    }
                } else if (a(qVar, this.f27716b.f17159a, 128)) {
                    c();
                    this.f27716b.c(0);
                    this.f27719e.a(this.f27716b, 128);
                    this.f27720f = 2;
                }
            } else if (b(qVar)) {
                this.f27720f = 1;
                this.f27716b.f17159a[0] = NetworkUtil.CURRENT_NETWORK_TYPE_CUC;
                this.f27716b.f17159a[1] = 119;
                this.f27721g = 2;
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27718d = dVar.c();
        this.f27719e = iVar.a(dVar.b(), 1);
    }

    public void b() {
    }
}
