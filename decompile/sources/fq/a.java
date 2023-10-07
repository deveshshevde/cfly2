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

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27663a = $$Lambda$a$RV99yDROz5fu_ObDbzPlE3nvv8.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final b f27664b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final q f27665c = new q(2786);

    /* renamed from: d  reason: collision with root package name */
    private boolean f27666d;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new a()};
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        int a2 = hVar.a(this.f27665c.f17159a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f27665c.c(0);
        this.f27665c.b(a2);
        if (!this.f27666d) {
            this.f27664b.a(0, 4);
            this.f27666d = true;
        }
        this.f27664b.a(this.f27665c);
        return 0;
    }

    public void a(long j2, long j3) {
        this.f27666d = false;
        this.f27664b.a();
    }

    public void a(i iVar) {
        this.f27664b.a(iVar, new ac.d(0, 1));
        iVar.a();
        iVar.a(new s.b(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        r8.a();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if ((r4 - r3) < 8192) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(fj.h r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            com.google.android.exoplayer2.util.q r0 = new com.google.android.exoplayer2.util.q
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f17159a
            r8.d(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.l()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x0059
            r8.a()
            r8.c(r3)
            r4 = r3
        L_0x0021:
            r1 = 0
        L_0x0022:
            byte[] r5 = r0.f17159a
            r6 = 6
            r8.d(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.i()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0043
            r8.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x003f
            return r2
        L_0x003f:
            r8.c(r4)
            goto L_0x0021
        L_0x0043:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x0049
            return r5
        L_0x0049:
            byte[] r5 = r0.f17159a
            int r5 = com.google.android.exoplayer2.audio.a.a((byte[]) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0053
            return r2
        L_0x0053:
            int r5 = r5 + -6
            r8.c(r5)
            goto L_0x0022
        L_0x0059:
            r4 = 3
            r0.d(r4)
            int r4 = r0.u()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.c(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.a.a(fj.h):boolean");
    }

    public void c() {
    }
}
