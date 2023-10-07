package fj;

import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.h;
import fj.s;

public final class n implements s {

    /* renamed from: a  reason: collision with root package name */
    private final h f27381a;

    /* renamed from: b  reason: collision with root package name */
    private final long f27382b;

    public n(h hVar, long j2) {
        this.f27381a = hVar;
        this.f27382b = j2;
    }

    private t a(long j2, long j3) {
        return new t((j2 * 1000000) / ((long) this.f27381a.f17117e), this.f27382b + j3);
    }

    public s.a a(long j2) {
        a.b(this.f27381a.f17123k);
        long[] jArr = this.f27381a.f17123k.f17125a;
        long[] jArr2 = this.f27381a.f17123k.f17126b;
        int a2 = ad.a(jArr, this.f27381a.a(j2), true, false);
        long j3 = 0;
        long j4 = a2 == -1 ? 0 : jArr[a2];
        if (a2 != -1) {
            j3 = jArr2[a2];
        }
        t a3 = a(j4, j3);
        if (a3.f27407b == j2 || a2 == jArr.length - 1) {
            return new s.a(a3);
        }
        int i2 = a2 + 1;
        return new s.a(a3, a(jArr[i2], jArr2[i2]));
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return this.f27381a.b();
    }
}
