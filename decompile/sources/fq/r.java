package fq;

import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fq.ac;

public final class r implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final j f27939a;

    /* renamed from: b  reason: collision with root package name */
    private final p f27940b = new p(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f27941c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f27942d;

    /* renamed from: e  reason: collision with root package name */
    private aa f27943e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27944f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27945g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27946h;

    /* renamed from: i  reason: collision with root package name */
    private int f27947i;

    /* renamed from: j  reason: collision with root package name */
    private int f27948j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27949k;

    /* renamed from: l  reason: collision with root package name */
    private long f27950l;

    public r(j jVar) {
        this.f27939a = jVar;
    }

    private void a(int i2) {
        this.f27941c = i2;
        this.f27942d = 0;
    }

    private boolean a(q qVar, byte[] bArr, int i2) {
        int min = Math.min(qVar.b(), i2 - this.f27942d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            qVar.d(min);
        } else {
            qVar.a(bArr, this.f27942d, min);
        }
        int i3 = this.f27942d + min;
        this.f27942d = i3;
        return i3 == i2;
    }

    private boolean b() {
        this.f27940b.a(0);
        int c2 = this.f27940b.c(24);
        if (c2 != 1) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Unexpected start code prefix: ");
            sb.append(c2);
            k.c("PesReader", sb.toString());
            this.f27948j = -1;
            return false;
        }
        this.f27940b.b(8);
        int c3 = this.f27940b.c(16);
        this.f27940b.b(5);
        this.f27949k = this.f27940b.e();
        this.f27940b.b(2);
        this.f27944f = this.f27940b.e();
        this.f27945g = this.f27940b.e();
        this.f27940b.b(6);
        int c4 = this.f27940b.c(8);
        this.f27947i = c4;
        if (c3 == 0) {
            this.f27948j = -1;
        } else {
            this.f27948j = ((c3 + 6) - 9) - c4;
        }
        return true;
    }

    private void c() {
        this.f27940b.a(0);
        this.f27950l = -9223372036854775807L;
        if (this.f27944f) {
            this.f27940b.b(4);
            this.f27940b.b(1);
            this.f27940b.b(1);
            long c2 = (((long) this.f27940b.c(3)) << 30) | ((long) (this.f27940b.c(15) << 15)) | ((long) this.f27940b.c(15));
            this.f27940b.b(1);
            if (!this.f27946h && this.f27945g) {
                this.f27940b.b(4);
                this.f27940b.b(1);
                this.f27940b.b(1);
                this.f27940b.b(1);
                this.f27943e.b((((long) this.f27940b.c(3)) << 30) | ((long) (this.f27940b.c(15) << 15)) | ((long) this.f27940b.c(15)));
                this.f27946h = true;
            }
            this.f27950l = this.f27943e.b(c2);
        }
    }

    public final void a() {
        this.f27941c = 0;
        this.f27942d = 0;
        this.f27946h = false;
        this.f27939a.a();
    }

    public void a(aa aaVar, i iVar, ac.d dVar) {
        this.f27943e = aaVar;
        this.f27939a.a(iVar, dVar);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d3 A[SYNTHETIC] */
    public final void a(com.google.android.exoplayer2.util.q r9, int r10) throws com.google.android.exoplayer2.ParserException {
        /*
            r8 = this;
            r0 = r10 & 1
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x0042
            int r0 = r8.f27941c
            if (r0 == 0) goto L_0x003f
            if (r0 == r4) goto L_0x003f
            java.lang.String r5 = "PesReader"
            if (r0 == r3) goto L_0x003a
            if (r0 != r2) goto L_0x0034
            int r0 = r8.f27948j
            if (r0 == r1) goto L_0x0077
            r6 = 59
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Unexpected start indicator: expected "
            r7.append(r6)
            r7.append(r0)
            java.lang.String r0 = " more bytes"
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            com.google.android.exoplayer2.util.k.c(r5, r0)
            goto L_0x0077
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x003a:
            java.lang.String r0 = "Unexpected start indicator reading extended header"
            com.google.android.exoplayer2.util.k.c(r5, r0)
        L_0x003f:
            r8.a(r4)
        L_0x0042:
            int r0 = r9.b()
            if (r0 <= 0) goto L_0x00d3
            int r0 = r8.f27941c
            if (r0 == 0) goto L_0x00ca
            r5 = 0
            if (r0 == r4) goto L_0x00b2
            if (r0 == r3) goto L_0x0083
            if (r0 != r2) goto L_0x007d
            int r0 = r9.b()
            int r6 = r8.f27948j
            if (r6 != r1) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            int r5 = r0 - r6
        L_0x005e:
            if (r5 <= 0) goto L_0x0069
            int r0 = r0 - r5
            int r5 = r9.d()
            int r5 = r5 + r0
            r9.b(r5)
        L_0x0069:
            fq.j r5 = r8.f27939a
            r5.a(r9)
            int r5 = r8.f27948j
            if (r5 == r1) goto L_0x0042
            int r5 = r5 - r0
            r8.f27948j = r5
            if (r5 != 0) goto L_0x0042
        L_0x0077:
            fq.j r0 = r8.f27939a
            r0.b()
            goto L_0x003f
        L_0x007d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x0083:
            r0 = 10
            int r6 = r8.f27947i
            int r0 = java.lang.Math.min(r0, r6)
            com.google.android.exoplayer2.util.p r6 = r8.f27940b
            byte[] r6 = r6.f17155a
            boolean r0 = r8.a((com.google.android.exoplayer2.util.q) r9, (byte[]) r6, (int) r0)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            int r6 = r8.f27947i
            boolean r0 = r8.a((com.google.android.exoplayer2.util.q) r9, (byte[]) r0, (int) r6)
            if (r0 == 0) goto L_0x0042
            r8.c()
            boolean r0 = r8.f27949k
            if (r0 == 0) goto L_0x00a6
            r5 = 4
        L_0x00a6:
            r10 = r10 | r5
            fq.j r0 = r8.f27939a
            long r5 = r8.f27950l
            r0.a((long) r5, (int) r10)
            r8.a(r2)
            goto L_0x0042
        L_0x00b2:
            com.google.android.exoplayer2.util.p r0 = r8.f27940b
            byte[] r0 = r0.f17155a
            r6 = 9
            boolean r0 = r8.a((com.google.android.exoplayer2.util.q) r9, (byte[]) r0, (int) r6)
            if (r0 == 0) goto L_0x0042
            boolean r0 = r8.b()
            if (r0 == 0) goto L_0x00c5
            r5 = 2
        L_0x00c5:
            r8.a(r5)
            goto L_0x0042
        L_0x00ca:
            int r0 = r9.b()
            r9.d(r0)
            goto L_0x0042
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.r.a(com.google.android.exoplayer2.util.q, int):void");
    }
}
