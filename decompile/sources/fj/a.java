package fj;

import com.google.android.exoplayer2.util.ad;
import fj.s;
import java.io.IOException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final C0171a f27327a;

    /* renamed from: b  reason: collision with root package name */
    protected final f f27328b;

    /* renamed from: c  reason: collision with root package name */
    protected c f27329c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27330d;

    /* renamed from: fj.a$a  reason: collision with other inner class name */
    public static class C0171a implements s {

        /* renamed from: a  reason: collision with root package name */
        private final d f27331a;

        /* renamed from: b  reason: collision with root package name */
        private final long f27332b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f27333c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f27334d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f27335e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final long f27336f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final long f27337g;

        public C0171a(d dVar, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f27331a = dVar;
            this.f27332b = j2;
            this.f27333c = j3;
            this.f27334d = j4;
            this.f27335e = j5;
            this.f27336f = j6;
            this.f27337g = j7;
        }

        public s.a a(long j2) {
            return new s.a(new t(j2, c.a(this.f27331a.timeUsToTargetTime(j2), this.f27333c, this.f27334d, this.f27335e, this.f27336f, this.f27337g)));
        }

        public boolean a() {
            return true;
        }

        public long b() {
            return this.f27332b;
        }

        public long b(long j2) {
            return this.f27331a.timeUsToTargetTime(j2);
        }
    }

    public static final class b implements d {
        public long timeUsToTargetTime(long j2) {
            return j2;
        }
    }

    protected static class c {

        /* renamed from: a  reason: collision with root package name */
        private final long f27338a;

        /* renamed from: b  reason: collision with root package name */
        private final long f27339b;

        /* renamed from: c  reason: collision with root package name */
        private final long f27340c;

        /* renamed from: d  reason: collision with root package name */
        private long f27341d;

        /* renamed from: e  reason: collision with root package name */
        private long f27342e;

        /* renamed from: f  reason: collision with root package name */
        private long f27343f;

        /* renamed from: g  reason: collision with root package name */
        private long f27344g;

        /* renamed from: h  reason: collision with root package name */
        private long f27345h;

        protected c(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f27338a = j2;
            this.f27339b = j3;
            this.f27341d = j4;
            this.f27342e = j5;
            this.f27343f = j6;
            this.f27344g = j7;
            this.f27340c = j8;
            this.f27345h = a(j3, j4, j5, j6, j7, j8);
        }

        /* access modifiers changed from: private */
        public long a() {
            return this.f27343f;
        }

        protected static long a(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) (((float) (j2 - j3)) * (((float) (j6 - j5)) / ((float) (j4 - j3))));
            return ad.a(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }

        /* access modifiers changed from: private */
        public void a(long j2, long j3) {
            this.f27341d = j2;
            this.f27343f = j3;
            f();
        }

        /* access modifiers changed from: private */
        public long b() {
            return this.f27344g;
        }

        /* access modifiers changed from: private */
        public void b(long j2, long j3) {
            this.f27342e = j2;
            this.f27344g = j3;
            f();
        }

        /* access modifiers changed from: private */
        public long c() {
            return this.f27339b;
        }

        /* access modifiers changed from: private */
        public long d() {
            return this.f27338a;
        }

        /* access modifiers changed from: private */
        public long e() {
            return this.f27345h;
        }

        private void f() {
            this.f27345h = a(this.f27339b, this.f27341d, this.f27342e, this.f27343f, this.f27344g, this.f27340c);
        }
    }

    protected interface d {
        long timeUsToTargetTime(long j2);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f27346a = new e(-3, -9223372036854775807L, -1);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f27347b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f27348c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f27349d;

        private e(int i2, long j2, long j3) {
            this.f27347b = i2;
            this.f27348c = j2;
            this.f27349d = j3;
        }

        public static e a(long j2) {
            return new e(0, -9223372036854775807L, j2);
        }

        public static e a(long j2, long j3) {
            return new e(-1, j2, j3);
        }

        public static e b(long j2, long j3) {
            return new e(-2, j2, j3);
        }
    }

    protected interface f {

        /* renamed from: fj.a$f$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$a(f fVar) {
            }
        }

        e a(h hVar, long j2) throws IOException, InterruptedException;

        void a();
    }

    protected a(d dVar, f fVar, long j2, long j3, long j4, long j5, long j6, long j7, int i2) {
        this.f27328b = fVar;
        this.f27330d = i2;
        this.f27327a = new C0171a(dVar, j2, j3, j4, j5, j6, j7);
    }

    /* access modifiers changed from: protected */
    public final int a(h hVar, long j2, r rVar) {
        if (j2 == hVar.c()) {
            return 0;
        }
        rVar.f27401a = j2;
        return 1;
    }

    public int a(h hVar, r rVar) throws InterruptedException, IOException {
        f fVar = (f) com.google.android.exoplayer2.util.a.b(this.f27328b);
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.b(this.f27329c);
            long b2 = cVar.a();
            long c2 = cVar.b();
            long d2 = cVar.e();
            if (c2 - b2 <= ((long) this.f27330d)) {
                a(false, b2);
                return a(hVar, b2, rVar);
            } else if (!a(hVar, d2)) {
                return a(hVar, d2, rVar);
            } else {
                hVar.a();
                e a2 = fVar.a(hVar, cVar.c());
                int a3 = a2.f27347b;
                if (a3 == -3) {
                    a(false, d2);
                    return a(hVar, d2, rVar);
                } else if (a3 == -2) {
                    cVar.a(a2.f27348c, a2.f27349d);
                } else if (a3 == -1) {
                    cVar.b(a2.f27348c, a2.f27349d);
                } else if (a3 == 0) {
                    a(true, a2.f27349d);
                    a(hVar, a2.f27349d);
                    return a(hVar, a2.f27349d, rVar);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final s a() {
        return this.f27327a;
    }

    public final void a(long j2) {
        c cVar = this.f27329c;
        if (cVar == null || cVar.d() != j2) {
            this.f27329c = b(j2);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2, long j2) {
        this.f27329c = null;
        this.f27328b.a();
        b(z2, j2);
    }

    /* access modifiers changed from: protected */
    public final boolean a(h hVar, long j2) throws IOException, InterruptedException {
        long c2 = j2 - hVar.c();
        if (c2 < 0 || c2 > 262144) {
            return false;
        }
        hVar.b((int) c2);
        return true;
    }

    /* access modifiers changed from: protected */
    public c b(long j2) {
        long j3 = j2;
        return new c(j3, this.f27327a.b(j3), this.f27327a.f27333c, this.f27327a.f27334d, this.f27327a.f27335e, this.f27327a.f27336f, this.f27327a.f27337g);
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2, long j2) {
    }

    public final boolean b() {
        return this.f27329c != null;
    }
}
