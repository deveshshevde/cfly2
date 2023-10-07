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

public final class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final r f28104a = new r();

    /* renamed from: b  reason: collision with root package name */
    private final e f28105b;

    /* renamed from: k  reason: collision with root package name */
    private e.b f28106k;

    /* renamed from: l  reason: collision with root package name */
    private long f28107l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f28108m;

    public k(f fVar, h hVar, Format format, int i2, Object obj, e eVar) {
        super(fVar, hVar, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f28105b = eVar;
    }

    public void a() {
        this.f28108m = true;
    }

    public void a(e.b bVar) {
        this.f28106k = bVar;
    }

    public void b() throws IOException, InterruptedException {
        d dVar;
        if (this.f28107l == 0) {
            this.f28105b.a(this.f28106k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            h a2 = this.f13110c.a(this.f28107l);
            dVar = new d(this.f13117j, a2.f16999e, this.f13117j.a(a2));
            g gVar = this.f28105b.f28050a;
            boolean z2 = false;
            int i2 = 0;
            while (i2 == 0 && !this.f28108m) {
                i2 = gVar.a((fj.h) dVar, f28104a);
            }
            if (i2 != 1) {
                z2 = true;
            }
            a.b(z2);
            this.f28107l = dVar.c() - this.f13110c.f16999e;
            ad.a((f) this.f13117j);
        } catch (Throwable th) {
            ad.a((f) this.f13117j);
            throw th;
        }
    }
}
