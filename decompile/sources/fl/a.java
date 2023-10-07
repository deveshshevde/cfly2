package fl;

import com.google.android.exoplayer2.util.h;
import fj.a;
import fj.l;
import java.io.IOException;

final class a extends fj.a {

    /* renamed from: fl.a$a  reason: collision with other inner class name */
    private static final class C0172a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final h f27460a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27461b;

        /* renamed from: c  reason: collision with root package name */
        private final l.a f27462c;

        private C0172a(h hVar, int i2) {
            this.f27460a = hVar;
            this.f27461b = i2;
            this.f27462c = new l.a();
        }

        private long a(fj.h hVar) throws IOException, InterruptedException {
            while (hVar.b() < hVar.d() - 6 && !l.a(hVar, this.f27460a, this.f27461b, this.f27462c)) {
                hVar.c(1);
            }
            if (hVar.b() < hVar.d() - 6) {
                return this.f27462c.f27379a;
            }
            hVar.c((int) (hVar.d() - hVar.b()));
            return this.f27460a.f17122j;
        }

        public a.e a(fj.h hVar, long j2) throws IOException, InterruptedException {
            long c2 = hVar.c();
            long a2 = a(hVar);
            long b2 = hVar.b();
            hVar.c(Math.max(6, this.f27460a.f17115c));
            long a3 = a(hVar);
            return (a2 > j2 || a3 <= j2) ? a3 <= j2 ? a.e.b(a3, hVar.b()) : a.e.a(a2, c2) : a.e.a(b2);
        }

        public /* synthetic */ void a() {
            a.f.CC.$default$a(this);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.google.android.exoplayer2.util.h r17, int r18, long r19, long r21) {
        /*
            r16 = this;
            r0 = r17
            java.util.Objects.requireNonNull(r17)
            fl.-$$Lambda$LY7zkkojFJU9lIBdyuB8JJUbjOM r1 = new fl.-$$Lambda$LY7zkkojFJU9lIBdyuB8JJUbjOM
            r1.<init>()
            fl.a$a r2 = new fl.a$a
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.b()
            long r7 = r0.f17122j
            long r13 = r17.c()
            int r0 = r0.f17115c
            r5 = 6
            int r15 = java.lang.Math.max(r5, r0)
            r5 = 0
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fl.a.<init>(com.google.android.exoplayer2.util.h, int, long, long):void");
    }
}
