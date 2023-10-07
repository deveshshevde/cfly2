package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.r;
import fj.i;
import fj.u;
import fq.ac;
import java.util.Collections;
import java.util.List;

public final class m implements j {

    /* renamed from: a  reason: collision with root package name */
    private final x f27869a;

    /* renamed from: b  reason: collision with root package name */
    private String f27870b;

    /* renamed from: c  reason: collision with root package name */
    private u f27871c;

    /* renamed from: d  reason: collision with root package name */
    private a f27872d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27873e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f27874f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final q f27875g = new q(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final q f27876h = new q(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final q f27877i = new q(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final q f27878j = new q(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final q f27879k = new q(40, 128);

    /* renamed from: l  reason: collision with root package name */
    private long f27880l;

    /* renamed from: m  reason: collision with root package name */
    private long f27881m;

    /* renamed from: n  reason: collision with root package name */
    private final q f27882n = new q();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final u f27883a;

        /* renamed from: b  reason: collision with root package name */
        private long f27884b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27885c;

        /* renamed from: d  reason: collision with root package name */
        private int f27886d;

        /* renamed from: e  reason: collision with root package name */
        private long f27887e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27888f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27889g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f27890h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f27891i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f27892j;

        /* renamed from: k  reason: collision with root package name */
        private long f27893k;

        /* renamed from: l  reason: collision with root package name */
        private long f27894l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f27895m;

        public a(u uVar) {
            this.f27883a = uVar;
        }

        private void a(int i2) {
            boolean z2 = this.f27895m;
            int i3 = (int) (this.f27884b - this.f27893k);
            this.f27883a.a(this.f27894l, z2 ? 1 : 0, i3, i2, (u.a) null);
        }

        private static boolean b(int i2) {
            return (32 <= i2 && i2 <= 35) || i2 == 39;
        }

        private static boolean c(int i2) {
            return i2 < 32 || i2 == 40;
        }

        public void a() {
            this.f27888f = false;
            this.f27889g = false;
            this.f27890h = false;
            this.f27891i = false;
            this.f27892j = false;
        }

        public void a(long j2, int i2, int i3, long j3, boolean z2) {
            boolean z3 = false;
            this.f27889g = false;
            this.f27890h = false;
            this.f27887e = j3;
            this.f27886d = 0;
            this.f27884b = j2;
            if (!c(i3)) {
                if (this.f27891i && !this.f27892j) {
                    if (z2) {
                        a(i2);
                    }
                    this.f27891i = false;
                }
                if (b(i3)) {
                    this.f27890h = !this.f27892j;
                    this.f27892j = true;
                }
            }
            boolean z4 = i3 >= 16 && i3 <= 21;
            this.f27885c = z4;
            if (z4 || i3 <= 9) {
                z3 = true;
            }
            this.f27888f = z3;
        }

        public void a(long j2, int i2, boolean z2) {
            if (this.f27892j && this.f27889g) {
                this.f27895m = this.f27885c;
                this.f27892j = false;
            } else if (this.f27890h || this.f27889g) {
                if (z2 && this.f27891i) {
                    a(i2 + ((int) (j2 - this.f27884b)));
                }
                this.f27893k = this.f27884b;
                this.f27894l = this.f27887e;
                this.f27895m = this.f27885c;
                this.f27891i = true;
            }
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f27888f) {
                int i4 = this.f27886d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f27889g = (bArr[i5] & 128) != 0;
                    this.f27888f = false;
                    return;
                }
                this.f27886d = i4 + (i3 - i2);
            }
        }
    }

    public m(x xVar) {
        this.f27869a = xVar;
    }

    private static Format a(String str, q qVar, q qVar2, q qVar3) {
        float f2;
        q qVar4 = qVar;
        q qVar5 = qVar2;
        q qVar6 = qVar3;
        byte[] bArr = new byte[(qVar4.f27935b + qVar5.f27935b + qVar6.f27935b)];
        System.arraycopy(qVar4.f27934a, 0, bArr, 0, qVar4.f27935b);
        System.arraycopy(qVar5.f27934a, 0, bArr, qVar4.f27935b, qVar5.f27935b);
        System.arraycopy(qVar6.f27934a, 0, bArr, qVar4.f27935b + qVar5.f27935b, qVar6.f27935b);
        r rVar = new r(qVar5.f27934a, 0, qVar5.f27935b);
        rVar.a(44);
        int c2 = rVar.c(3);
        rVar.a();
        rVar.a(88);
        rVar.a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            if (rVar.b()) {
                i2 += 89;
            }
            if (rVar.b()) {
                i2 += 8;
            }
        }
        rVar.a(i2);
        if (c2 > 0) {
            rVar.a((8 - c2) * 2);
        }
        rVar.d();
        int d2 = rVar.d();
        if (d2 == 3) {
            rVar.a();
        }
        int d3 = rVar.d();
        int d4 = rVar.d();
        if (rVar.b()) {
            int d5 = rVar.d();
            int d6 = rVar.d();
            int d7 = rVar.d();
            int d8 = rVar.d();
            d3 -= ((d2 == 1 || d2 == 2) ? 2 : 1) * (d5 + d6);
            d4 -= (d2 == 1 ? 2 : 1) * (d7 + d8);
        }
        int i4 = d3;
        int i5 = d4;
        rVar.d();
        rVar.d();
        int d9 = rVar.d();
        int i6 = rVar.b() ? 0 : c2;
        while (true) {
            rVar.d();
            rVar.d();
            rVar.d();
            if (i6 > c2) {
                break;
            }
            i6++;
        }
        rVar.d();
        rVar.d();
        rVar.d();
        if (rVar.b() && rVar.b()) {
            a(rVar);
        }
        rVar.a(2);
        if (rVar.b()) {
            rVar.a(8);
            rVar.d();
            rVar.d();
            rVar.a();
        }
        b(rVar);
        if (rVar.b()) {
            for (int i7 = 0; i7 < rVar.d(); i7++) {
                rVar.a(d9 + 4 + 1);
            }
        }
        rVar.a(2);
        float f3 = 1.0f;
        if (rVar.b() && rVar.b()) {
            int c3 = rVar.c(8);
            if (c3 == 255) {
                int c4 = rVar.c(16);
                int c5 = rVar.c(16);
                if (!(c4 == 0 || c5 == 0)) {
                    f3 = ((float) c4) / ((float) c5);
                }
                f2 = f3;
            } else if (c3 < o.f17136b.length) {
                f2 = o.f17136b[c3];
            } else {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Unexpected aspect_ratio_idc value: ");
                sb.append(c3);
                k.c("H265Reader", sb.toString());
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
        }
        f2 = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
    }

    private void a(long j2, int i2, int i3, long j3) {
        this.f27872d.a(j2, i2, i3, j3, this.f27873e);
        if (!this.f27873e) {
            this.f27875g.a(i3);
            this.f27876h.a(i3);
            this.f27877i.a(i3);
        }
        this.f27878j.a(i3);
        this.f27879k.a(i3);
    }

    private static void a(r rVar) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (!rVar.b()) {
                    rVar.d();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        rVar.e();
                    }
                    for (int i5 = 0; i5 < min; i5++) {
                        rVar.e();
                    }
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    private void a(byte[] bArr, int i2, int i3) {
        this.f27872d.a(bArr, i2, i3);
        if (!this.f27873e) {
            this.f27875g.a(bArr, i2, i3);
            this.f27876h.a(bArr, i2, i3);
            this.f27877i.a(bArr, i2, i3);
        }
        this.f27878j.a(bArr, i2, i3);
        this.f27879k.a(bArr, i2, i3);
    }

    private void b(long j2, int i2, int i3, long j3) {
        this.f27872d.a(j2, i2, this.f27873e);
        if (!this.f27873e) {
            this.f27875g.b(i3);
            this.f27876h.b(i3);
            this.f27877i.b(i3);
            if (this.f27875g.b() && this.f27876h.b() && this.f27877i.b()) {
                this.f27871c.a(a(this.f27870b, this.f27875g, this.f27876h, this.f27877i));
                this.f27873e = true;
            }
        }
        if (this.f27878j.b(i3)) {
            this.f27882n.a(this.f27878j.f27934a, o.a(this.f27878j.f27934a, this.f27878j.f27935b));
            this.f27882n.d(5);
            this.f27869a.a(j3, this.f27882n);
        }
        if (this.f27879k.b(i3)) {
            this.f27882n.a(this.f27879k.f27934a, o.a(this.f27879k.f27934a, this.f27879k.f27935b));
            this.f27882n.d(5);
            this.f27869a.a(j3, this.f27882n);
        }
    }

    private static void b(r rVar) {
        int d2 = rVar.d();
        boolean z2 = false;
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            if (i3 != 0) {
                z2 = rVar.b();
            }
            if (z2) {
                rVar.a();
                rVar.d();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (rVar.b()) {
                        rVar.a();
                    }
                }
            } else {
                int d3 = rVar.d();
                int d4 = rVar.d();
                int i5 = d3 + d4;
                for (int i6 = 0; i6 < d3; i6++) {
                    rVar.d();
                    rVar.a();
                }
                for (int i7 = 0; i7 < d4; i7++) {
                    rVar.d();
                    rVar.a();
                }
                i2 = i5;
            }
        }
    }

    public void a() {
        o.a(this.f27874f);
        this.f27875g.a();
        this.f27876h.a();
        this.f27877i.a();
        this.f27878j.a();
        this.f27879k.a();
        this.f27872d.a();
        this.f27880l = 0;
    }

    public void a(long j2, int i2) {
        this.f27881m = j2;
    }

    public void a(q qVar) {
        q qVar2 = qVar;
        while (qVar.b() > 0) {
            int d2 = qVar.d();
            int c2 = qVar.c();
            byte[] bArr = qVar2.f17159a;
            this.f27880l += (long) qVar.b();
            this.f27871c.a(qVar2, qVar.b());
            while (true) {
                if (d2 < c2) {
                    int a2 = o.a(bArr, d2, c2, this.f27874f);
                    if (a2 == c2) {
                        a(bArr, d2, c2);
                        return;
                    }
                    int c3 = o.c(bArr, a2);
                    int i2 = a2 - d2;
                    if (i2 > 0) {
                        a(bArr, d2, a2);
                    }
                    int i3 = c2 - a2;
                    long j2 = this.f27880l - ((long) i3);
                    int i4 = i2 < 0 ? -i2 : 0;
                    long j3 = j2;
                    int i5 = i3;
                    b(j3, i5, i4, this.f27881m);
                    a(j3, i5, c3, this.f27881m);
                    d2 = a2 + 3;
                }
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27870b = dVar.c();
        u a2 = iVar.a(dVar.b(), 2);
        this.f27871c = a2;
        this.f27872d = new a(a2);
        this.f27869a.a(iVar, dVar);
    }

    public void b() {
    }
}
