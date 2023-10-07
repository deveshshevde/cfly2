package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import java.io.IOException;

public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f15487a = $$Lambda$b$0nYu06QF6kVfgaQsoipdCMWS7OI.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final q f15488b = new q(4);

    /* renamed from: c  reason: collision with root package name */
    private final q f15489c = new q(9);

    /* renamed from: d  reason: collision with root package name */
    private final q f15490d = new q(11);

    /* renamed from: e  reason: collision with root package name */
    private final q f15491e = new q();

    /* renamed from: f  reason: collision with root package name */
    private final c f15492f = new c();

    /* renamed from: g  reason: collision with root package name */
    private i f15493g;

    /* renamed from: h  reason: collision with root package name */
    private int f15494h = 1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15495i;

    /* renamed from: j  reason: collision with root package name */
    private long f15496j;

    /* renamed from: k  reason: collision with root package name */
    private int f15497k;

    /* renamed from: l  reason: collision with root package name */
    private int f15498l;

    /* renamed from: m  reason: collision with root package name */
    private int f15499m;

    /* renamed from: n  reason: collision with root package name */
    private long f15500n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15501o;

    /* renamed from: p  reason: collision with root package name */
    private a f15502p;

    /* renamed from: q  reason: collision with root package name */
    private d f15503q;

    private void a() {
        if (!this.f15501o) {
            this.f15493g.a(new s.b(-9223372036854775807L));
            this.f15501o = true;
        }
    }

    private long b() {
        if (this.f15495i) {
            return this.f15496j + this.f15500n;
        }
        if (this.f15492f.a() == -9223372036854775807L) {
            return 0;
        }
        return this.f15500n;
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        boolean z2 = false;
        if (!hVar.a(this.f15489c.f17159a, 0, 9, true)) {
            return false;
        }
        this.f15489c.c(0);
        this.f15489c.d(4);
        int h2 = this.f15489c.h();
        boolean z3 = (h2 & 4) != 0;
        if ((h2 & 1) != 0) {
            z2 = true;
        }
        if (z3 && this.f15502p == null) {
            this.f15502p = new a(this.f15493g.a(8, 1));
        }
        if (z2 && this.f15503q == null) {
            this.f15503q = new d(this.f15493g.a(9, 2));
        }
        this.f15493g.a();
        this.f15497k = (this.f15489c.p() - 9) + 4;
        this.f15494h = 2;
        return true;
    }

    private void c(h hVar) throws IOException, InterruptedException {
        hVar.b(this.f15497k);
        this.f15497k = 0;
        this.f15494h = 3;
    }

    private boolean d(h hVar) throws IOException, InterruptedException {
        if (!hVar.a(this.f15490d.f17159a, 0, 11, true)) {
            return false;
        }
        this.f15490d.c(0);
        this.f15498l = this.f15490d.h();
        this.f15499m = this.f15490d.l();
        this.f15500n = (long) this.f15490d.l();
        this.f15500n = (((long) (this.f15490d.h() << 24)) | this.f15500n) * 1000;
        this.f15490d.d(3);
        this.f15494h = 4;
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] d() {
        return new g[]{new b()};
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(fj.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            long r0 = r8.b()
            int r2 = r8.f15498l
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            r6 = 1
            r7 = 8
            if (r2 != r7) goto L_0x0024
            com.google.android.exoplayer2.extractor.flv.a r7 = r8.f15502p
            if (r7 == 0) goto L_0x0024
            r8.a()
            com.google.android.exoplayer2.extractor.flv.a r2 = r8.f15502p
            com.google.android.exoplayer2.util.q r9 = r8.f(r9)
            boolean r5 = r2.b(r9, r0)
        L_0x0022:
            r9 = 1
            goto L_0x0069
        L_0x0024:
            r7 = 9
            if (r2 != r7) goto L_0x003a
            com.google.android.exoplayer2.extractor.flv.d r7 = r8.f15503q
            if (r7 == 0) goto L_0x003a
            r8.a()
            com.google.android.exoplayer2.extractor.flv.d r2 = r8.f15503q
            com.google.android.exoplayer2.util.q r9 = r8.f(r9)
            boolean r5 = r2.b(r9, r0)
            goto L_0x0022
        L_0x003a:
            r7 = 18
            if (r2 != r7) goto L_0x0063
            boolean r2 = r8.f15501o
            if (r2 != 0) goto L_0x0063
            com.google.android.exoplayer2.extractor.flv.c r2 = r8.f15492f
            com.google.android.exoplayer2.util.q r9 = r8.f(r9)
            boolean r5 = r2.b(r9, r0)
            com.google.android.exoplayer2.extractor.flv.c r9 = r8.f15492f
            long r0 = r9.a()
            int r9 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r9 == 0) goto L_0x0022
            fj.i r9 = r8.f15493g
            fj.s$b r2 = new fj.s$b
            r2.<init>(r0)
            r9.a(r2)
            r8.f15501o = r6
            goto L_0x0022
        L_0x0063:
            int r0 = r8.f15499m
            r9.b(r0)
            r9 = 0
        L_0x0069:
            boolean r0 = r8.f15495i
            if (r0 != 0) goto L_0x0083
            if (r5 == 0) goto L_0x0083
            r8.f15495i = r6
            com.google.android.exoplayer2.extractor.flv.c r0 = r8.f15492f
            long r0 = r0.a()
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x007f
            long r0 = r8.f15500n
            long r0 = -r0
            goto L_0x0081
        L_0x007f:
            r0 = 0
        L_0x0081:
            r8.f15496j = r0
        L_0x0083:
            r0 = 4
            r8.f15497k = r0
            r0 = 2
            r8.f15494h = r0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.b.e(fj.h):boolean");
    }

    private q f(h hVar) throws IOException, InterruptedException {
        if (this.f15499m > this.f15491e.e()) {
            q qVar = this.f15491e;
            qVar.a(new byte[Math.max(qVar.e() * 2, this.f15499m)], 0);
        } else {
            this.f15491e.c(0);
        }
        this.f15491e.b(this.f15499m);
        hVar.b(this.f15491e.f17159a, 0, this.f15499m);
        return this.f15491e;
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f15494h;
            if (i2 != 1) {
                if (i2 == 2) {
                    c(hVar);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    } else if (e(hVar)) {
                        return 0;
                    }
                } else if (!d(hVar)) {
                    return -1;
                }
            } else if (!b(hVar)) {
                return -1;
            }
        }
    }

    public void a(long j2, long j3) {
        this.f15494h = 1;
        this.f15495i = false;
        this.f15497k = 0;
    }

    public void a(i iVar) {
        this.f15493g = iVar;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        hVar.d(this.f15488b.f17159a, 0, 3);
        this.f15488b.c(0);
        if (this.f15488b.l() != 4607062) {
            return false;
        }
        hVar.d(this.f15488b.f17159a, 0, 2);
        this.f15488b.c(0);
        if ((this.f15488b.i() & 250) != 0) {
            return false;
        }
        hVar.d(this.f15488b.f17159a, 0, 4);
        this.f15488b.c(0);
        int p2 = this.f15488b.p();
        hVar.a();
        hVar.c(p2);
        hVar.d(this.f15488b.f17159a, 0, 4);
        this.f15488b.c(0);
        return this.f15488b.p() == 0;
    }

    public void c() {
    }
}
