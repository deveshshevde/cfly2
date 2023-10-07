package ft;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import fj.d;
import fj.g;
import fj.r;
import ft.e;
import java.io.IOException;

public class i extends a {

    /* renamed from: l  reason: collision with root package name */
    private static final r f28095l = new r();

    /* renamed from: m  reason: collision with root package name */
    private final int f28096m;

    /* renamed from: n  reason: collision with root package name */
    private final long f28097n;

    /* renamed from: o  reason: collision with root package name */
    private final e f28098o;

    /* renamed from: p  reason: collision with root package name */
    private long f28099p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f28100q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28101r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(f fVar, h hVar, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, e eVar) {
        super(fVar, hVar, format, i2, obj, j2, j3, j4, j5, j6);
        this.f28096m = i3;
        this.f28097n = j7;
        this.f28098o = eVar;
    }

    public final void a() {
        this.f28100q = true;
    }

    /* access modifiers changed from: protected */
    public e.b b(c cVar) {
        return cVar;
    }

    public final void b() throws IOException, InterruptedException {
        d dVar;
        if (this.f28099p == 0) {
            c c2 = c();
            c2.a(this.f28097n);
            e eVar = this.f28098o;
            e.b b2 = b(c2);
            long j2 = -9223372036854775807L;
            long j3 = this.f28041a == -9223372036854775807L ? -9223372036854775807L : this.f28041a - this.f28097n;
            if (this.f28042b != -9223372036854775807L) {
                j2 = this.f28042b - this.f28097n;
            }
            eVar.a(b2, j3, j2);
        }
        try {
            h a2 = this.f13110c.a(this.f28099p);
            dVar = new d(this.f13117j, a2.f16999e, this.f13117j.a(a2));
            g gVar = this.f28098o.f28050a;
            boolean z2 = false;
            int i2 = 0;
            while (i2 == 0 && !this.f28100q) {
                i2 = gVar.a((fj.h) dVar, f28095l);
            }
            if (i2 != 1) {
                z2 = true;
            }
            a.b(z2);
            this.f28099p = dVar.c() - this.f13110c.f16999e;
            ad.a((f) this.f13117j);
            this.f28101r = true;
        } catch (Throwable th) {
            ad.a((f) this.f13117j);
            throw th;
        }
    }

    public long h() {
        return this.f13118k + ((long) this.f28096m);
    }

    public boolean i() {
        return this.f28101r;
    }
}
