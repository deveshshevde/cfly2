package fq;

import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fq.ac;

public final class w implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final v f27981a;

    /* renamed from: b  reason: collision with root package name */
    private final q f27982b = new q(32);

    /* renamed from: c  reason: collision with root package name */
    private int f27983c;

    /* renamed from: d  reason: collision with root package name */
    private int f27984d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27985e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27986f;

    public w(v vVar) {
        this.f27981a = vVar;
    }

    public void a() {
        this.f27986f = true;
    }

    public void a(aa aaVar, i iVar, ac.d dVar) {
        this.f27981a.a(aaVar, iVar, dVar);
        this.f27986f = true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fc A[SYNTHETIC] */
    public void a(com.google.android.exoplayer2.util.q r9, int r10) {
        /*
            r8 = this;
            r0 = 1
            r10 = r10 & r0
            r1 = 0
            if (r10 == 0) goto L_0x0007
            r10 = 1
            goto L_0x0008
        L_0x0007:
            r10 = 0
        L_0x0008:
            r2 = -1
            if (r10 == 0) goto L_0x0015
            int r3 = r9.h()
            int r4 = r9.d()
            int r4 = r4 + r3
            goto L_0x0016
        L_0x0015:
            r4 = -1
        L_0x0016:
            boolean r3 = r8.f27986f
            if (r3 == 0) goto L_0x0024
            if (r10 != 0) goto L_0x001d
            return
        L_0x001d:
            r8.f27986f = r1
            r9.c(r4)
        L_0x0022:
            r8.f27984d = r1
        L_0x0024:
            int r10 = r9.b()
            if (r10 <= 0) goto L_0x00fc
            int r10 = r8.f27984d
            r3 = 3
            if (r10 >= r3) goto L_0x00b2
            if (r10 != 0) goto L_0x0044
            int r10 = r9.h()
            int r4 = r9.d()
            int r4 = r4 - r0
            r9.c(r4)
            r4 = 255(0xff, float:3.57E-43)
            if (r10 != r4) goto L_0x0044
            r8.f27986f = r0
            return
        L_0x0044:
            int r10 = r9.b()
            int r4 = r8.f27984d
            int r4 = 3 - r4
            int r10 = java.lang.Math.min(r10, r4)
            com.google.android.exoplayer2.util.q r4 = r8.f27982b
            byte[] r4 = r4.f17159a
            int r5 = r8.f27984d
            r9.a(r4, r5, r10)
            int r4 = r8.f27984d
            int r4 = r4 + r10
            r8.f27984d = r4
            if (r4 != r3) goto L_0x0024
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            r10.a((int) r3)
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            r10.d(r0)
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            int r10 = r10.h()
            com.google.android.exoplayer2.util.q r4 = r8.f27982b
            int r4 = r4.h()
            r5 = r10 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x007c
            r5 = 1
            goto L_0x007d
        L_0x007c:
            r5 = 0
        L_0x007d:
            r8.f27985e = r5
            r10 = r10 & 15
            int r10 = r10 << 8
            r10 = r10 | r4
            int r10 = r10 + r3
            r8.f27983c = r10
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            int r10 = r10.e()
            int r4 = r8.f27983c
            if (r10 >= r4) goto L_0x0024
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            byte[] r10 = r10.f17159a
            com.google.android.exoplayer2.util.q r4 = r8.f27982b
            r5 = 4098(0x1002, float:5.743E-42)
            int r6 = r8.f27983c
            int r7 = r10.length
            int r7 = r7 * 2
            int r6 = java.lang.Math.max(r6, r7)
            int r5 = java.lang.Math.min(r5, r6)
            r4.a((int) r5)
            com.google.android.exoplayer2.util.q r4 = r8.f27982b
            byte[] r4 = r4.f17159a
            java.lang.System.arraycopy(r10, r1, r4, r1, r3)
            goto L_0x0024
        L_0x00b2:
            int r10 = r9.b()
            int r3 = r8.f27983c
            int r4 = r8.f27984d
            int r3 = r3 - r4
            int r10 = java.lang.Math.min(r10, r3)
            com.google.android.exoplayer2.util.q r3 = r8.f27982b
            byte[] r3 = r3.f17159a
            int r4 = r8.f27984d
            r9.a(r3, r4, r10)
            int r3 = r8.f27984d
            int r3 = r3 + r10
            r8.f27984d = r3
            int r10 = r8.f27983c
            if (r3 != r10) goto L_0x0024
            boolean r3 = r8.f27985e
            if (r3 == 0) goto L_0x00ee
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            byte[] r10 = r10.f17159a
            int r3 = r8.f27983c
            int r10 = com.google.android.exoplayer2.util.ad.a((byte[]) r10, (int) r1, (int) r3, (int) r2)
            if (r10 == 0) goto L_0x00e4
            r8.f27986f = r0
            return
        L_0x00e4:
            com.google.android.exoplayer2.util.q r10 = r8.f27982b
            int r3 = r8.f27983c
            int r3 = r3 + -4
            r10.a((int) r3)
            goto L_0x00f3
        L_0x00ee:
            com.google.android.exoplayer2.util.q r3 = r8.f27982b
            r3.a((int) r10)
        L_0x00f3:
            fq.v r10 = r8.f27981a
            com.google.android.exoplayer2.util.q r3 = r8.f27982b
            r10.a(r3)
            goto L_0x0022
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.w.a(com.google.android.exoplayer2.util.q, int):void");
    }
}
