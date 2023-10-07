package fq;

import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fq.ac;
import java.io.IOException;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27727a = $$Lambda$c$dhNz0u7ezezzfNnyFG9sqxdT8gE.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final d f27728b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final q f27729c = new q(16384);

    /* renamed from: d  reason: collision with root package name */
    private boolean f27730d;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new c()};
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        int a2 = hVar.a(this.f27729c.f17159a, 0, 16384);
        if (a2 == -1) {
            return -1;
        }
        this.f27729c.c(0);
        this.f27729c.b(a2);
        if (!this.f27730d) {
            this.f27728b.a(0, 4);
            this.f27730d = true;
        }
        this.f27728b.a(this.f27729c);
        return 0;
    }

    public void a(long j2, long j3) {
        this.f27730d = false;
        this.f27728b.a();
    }

    public void a(i iVar) {
        this.f27728b.a(iVar, new ac.d(0, 1));
        iVar.a();
        iVar.a(new s.b(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if ((r4 - r3) < 8192) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r9.a();
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(fj.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            com.google.android.exoplayer2.util.q r0 = new com.google.android.exoplayer2.util.q
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f17159a
            r9.d(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.l()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x005f
            r9.a()
            r9.c(r3)
            r4 = r3
        L_0x0021:
            r1 = 0
        L_0x0022:
            byte[] r5 = r0.f17159a
            r6 = 7
            r9.d(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.i()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x0049
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x0049
            r9.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0045
            return r2
        L_0x0045:
            r9.c(r4)
            goto L_0x0021
        L_0x0049:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x004f
            return r6
        L_0x004f:
            byte[] r6 = r0.f17159a
            int r5 = com.google.android.exoplayer2.audio.b.a((byte[]) r6, (int) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0059
            return r2
        L_0x0059:
            int r5 = r5 + -7
            r9.c(r5)
            goto L_0x0022
        L_0x005f:
            r4 = 3
            r0.d(r4)
            int r4 = r0.u()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.c(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.c.a(fj.h):boolean");
    }

    public void c() {
    }
}
