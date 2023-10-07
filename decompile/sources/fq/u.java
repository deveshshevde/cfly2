package fq;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.s;
import java.io.IOException;

public final class u implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27961a = $$Lambda$u$1BJyAeHsGTXYQdV6hWqmQ3Jfk8s.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final aa f27962b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f27963c;

    /* renamed from: d  reason: collision with root package name */
    private final q f27964d;

    /* renamed from: e  reason: collision with root package name */
    private final t f27965e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27966f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27967g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27968h;

    /* renamed from: i  reason: collision with root package name */
    private long f27969i;

    /* renamed from: j  reason: collision with root package name */
    private s f27970j;

    /* renamed from: k  reason: collision with root package name */
    private i f27971k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27972l;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final j f27973a;

        /* renamed from: b  reason: collision with root package name */
        private final aa f27974b;

        /* renamed from: c  reason: collision with root package name */
        private final p f27975c = new p(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f27976d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27977e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27978f;

        /* renamed from: g  reason: collision with root package name */
        private int f27979g;

        /* renamed from: h  reason: collision with root package name */
        private long f27980h;

        public a(j jVar, aa aaVar) {
            this.f27973a = jVar;
            this.f27974b = aaVar;
        }

        private void b() {
            this.f27975c.b(8);
            this.f27976d = this.f27975c.e();
            this.f27977e = this.f27975c.e();
            this.f27975c.b(6);
            this.f27979g = this.f27975c.c(8);
        }

        private void c() {
            this.f27980h = 0;
            if (this.f27976d) {
                this.f27975c.b(4);
                this.f27975c.b(1);
                this.f27975c.b(1);
                long c2 = (((long) this.f27975c.c(3)) << 30) | ((long) (this.f27975c.c(15) << 15)) | ((long) this.f27975c.c(15));
                this.f27975c.b(1);
                if (!this.f27978f && this.f27977e) {
                    this.f27975c.b(4);
                    this.f27975c.b(1);
                    this.f27975c.b(1);
                    this.f27975c.b(1);
                    this.f27974b.b((((long) this.f27975c.c(3)) << 30) | ((long) (this.f27975c.c(15) << 15)) | ((long) this.f27975c.c(15)));
                    this.f27978f = true;
                }
                this.f27980h = this.f27974b.b(c2);
            }
        }

        public void a() {
            this.f27978f = false;
            this.f27973a.a();
        }

        public void a(q qVar) throws ParserException {
            qVar.a(this.f27975c.f17155a, 0, 3);
            this.f27975c.a(0);
            b();
            qVar.a(this.f27975c.f17155a, 0, this.f27979g);
            this.f27975c.a(0);
            c();
            this.f27973a.a(this.f27980h, 4);
            this.f27973a.a(qVar);
            this.f27973a.b();
        }
    }

    public u() {
        this(new aa(0));
    }

    public u(aa aaVar) {
        this.f27962b = aaVar;
        this.f27964d = new q(4096);
        this.f27963c = new SparseArray<>();
        this.f27965e = new t();
    }

    private void a(long j2) {
        s sVar;
        i iVar;
        if (!this.f27972l) {
            this.f27972l = true;
            if (this.f27965e.c() != -9223372036854775807L) {
                s sVar2 = new s(this.f27965e.b(), this.f27965e.c(), j2);
                this.f27970j = sVar2;
                iVar = this.f27971k;
                sVar = sVar2.a();
            } else {
                iVar = this.f27971k;
                sVar = new s.b(this.f27965e.c());
            }
            iVar.a(sVar);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new u()};
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(fj.h r11, fj.r r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = r11.d()
            r2 = -1
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x000e
            r6 = 1
            goto L_0x000f
        L_0x000e:
            r6 = 0
        L_0x000f:
            if (r6 == 0) goto L_0x0020
            fq.t r6 = r10.f27965e
            boolean r6 = r6.a()
            if (r6 != 0) goto L_0x0020
            fq.t r0 = r10.f27965e
            int r11 = r0.a((fj.h) r11, (fj.r) r12)
            return r11
        L_0x0020:
            r10.a((long) r0)
            fq.s r6 = r10.f27970j
            if (r6 == 0) goto L_0x0034
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0034
            fq.s r0 = r10.f27970j
            int r11 = r0.a((fj.h) r11, (fj.r) r12)
            return r11
        L_0x0034:
            r11.a()
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0041
            long r6 = r11.b()
            long r0 = r0 - r6
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            r12 = -1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004e
            r2 = 4
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x004e
            return r12
        L_0x004e:
            com.google.android.exoplayer2.util.q r0 = r10.f27964d
            byte[] r0 = r0.f17159a
            r1 = 4
            boolean r0 = r11.b(r0, r5, r1, r4)
            if (r0 != 0) goto L_0x005a
            return r12
        L_0x005a:
            com.google.android.exoplayer2.util.q r0 = r10.f27964d
            r0.c(r5)
            com.google.android.exoplayer2.util.q r0 = r10.f27964d
            int r0 = r0.p()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r0 != r1) goto L_0x006a
            return r12
        L_0x006a:
            r12 = 442(0x1ba, float:6.2E-43)
            if (r0 != r12) goto L_0x008c
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            byte[] r12 = r12.f17159a
            r0 = 10
            r11.d(r12, r5, r0)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            r0 = 9
            r12.c(r0)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            int r12 = r12.h()
            r12 = r12 & 7
            int r12 = r12 + 14
        L_0x0088:
            r11.b(r12)
            return r5
        L_0x008c:
            r12 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r2 = 6
            if (r0 != r12) goto L_0x00a6
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            byte[] r12 = r12.f17159a
            r11.d(r12, r5, r1)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            r12.c(r5)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            int r12 = r12.i()
            int r12 = r12 + r2
            goto L_0x0088
        L_0x00a6:
            r12 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r12 = r12 >> 8
            if (r12 == r4) goto L_0x00b0
            r11.b(r4)
            return r5
        L_0x00b0:
            r12 = r0 & 255(0xff, float:3.57E-43)
            android.util.SparseArray<fq.u$a> r0 = r10.f27963c
            java.lang.Object r0 = r0.get(r12)
            fq.u$a r0 = (fq.u.a) r0
            boolean r3 = r10.f27966f
            if (r3 != 0) goto L_0x0127
            if (r0 != 0) goto L_0x0107
            r3 = 0
            r6 = 189(0xbd, float:2.65E-43)
            if (r12 != r6) goto L_0x00d3
            fq.b r3 = new fq.b
            r3.<init>()
        L_0x00ca:
            r10.f27967g = r4
        L_0x00cc:
            long r6 = r11.c()
            r10.f27969i = r6
            goto L_0x00ed
        L_0x00d3:
            r6 = r12 & 224(0xe0, float:3.14E-43)
            r7 = 192(0xc0, float:2.69E-43)
            if (r6 != r7) goto L_0x00df
            fq.p r3 = new fq.p
            r3.<init>()
            goto L_0x00ca
        L_0x00df:
            r6 = r12 & 240(0xf0, float:3.36E-43)
            r7 = 224(0xe0, float:3.14E-43)
            if (r6 != r7) goto L_0x00ed
            fq.k r3 = new fq.k
            r3.<init>()
            r10.f27968h = r4
            goto L_0x00cc
        L_0x00ed:
            if (r3 == 0) goto L_0x0107
            fq.ac$d r0 = new fq.ac$d
            r6 = 256(0x100, float:3.59E-43)
            r0.<init>(r12, r6)
            fj.i r6 = r10.f27971k
            r3.a((fj.i) r6, (fq.ac.d) r0)
            fq.u$a r0 = new fq.u$a
            com.google.android.exoplayer2.util.aa r6 = r10.f27962b
            r0.<init>(r3, r6)
            android.util.SparseArray<fq.u$a> r3 = r10.f27963c
            r3.put(r12, r0)
        L_0x0107:
            boolean r12 = r10.f27967g
            if (r12 == 0) goto L_0x0115
            boolean r12 = r10.f27968h
            if (r12 == 0) goto L_0x0115
            long r6 = r10.f27969i
            r8 = 8192(0x2000, double:4.0474E-320)
            long r6 = r6 + r8
            goto L_0x0118
        L_0x0115:
            r6 = 1048576(0x100000, double:5.180654E-318)
        L_0x0118:
            long r8 = r11.c()
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0127
            r10.f27966f = r4
            fj.i r12 = r10.f27971k
            r12.a()
        L_0x0127:
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            byte[] r12 = r12.f17159a
            r11.d(r12, r5, r1)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            r12.c(r5)
            com.google.android.exoplayer2.util.q r12 = r10.f27964d
            int r12 = r12.i()
            int r12 = r12 + r2
            if (r0 != 0) goto L_0x0140
            r11.b(r12)
            goto L_0x015f
        L_0x0140:
            com.google.android.exoplayer2.util.q r1 = r10.f27964d
            r1.a((int) r12)
            com.google.android.exoplayer2.util.q r1 = r10.f27964d
            byte[] r1 = r1.f17159a
            r11.b(r1, r5, r12)
            com.google.android.exoplayer2.util.q r11 = r10.f27964d
            r11.c(r2)
            com.google.android.exoplayer2.util.q r11 = r10.f27964d
            r0.a(r11)
            com.google.android.exoplayer2.util.q r11 = r10.f27964d
            int r12 = r11.e()
            r11.b(r12)
        L_0x015f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.u.a(fj.h, fj.r):int");
    }

    public void a(long j2, long j3) {
        if ((this.f27962b.c() == -9223372036854775807L) || !(this.f27962b.a() == 0 || this.f27962b.a() == j3)) {
            this.f27962b.d();
            this.f27962b.a(j3);
        }
        s sVar = this.f27970j;
        if (sVar != null) {
            sVar.a(j3);
        }
        for (int i2 = 0; i2 < this.f27963c.size(); i2++) {
            this.f27963c.valueAt(i2).a();
        }
    }

    public void a(i iVar) {
        this.f27971k = iVar;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        hVar.d(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        hVar.c(bArr[13] & 7);
        hVar.d(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    public void c() {
    }
}
