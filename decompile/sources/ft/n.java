package ft;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.ad;
import fj.d;
import fj.u;
import java.io.IOException;

public final class n extends a {

    /* renamed from: l  reason: collision with root package name */
    private final int f28110l;

    /* renamed from: m  reason: collision with root package name */
    private final Format f28111m;

    /* renamed from: n  reason: collision with root package name */
    private long f28112n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f28113o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(f fVar, h hVar, Format format, int i2, Object obj, long j2, long j3, long j4, int i3, Format format2) {
        super(fVar, hVar, format, i2, obj, j2, j3, -9223372036854775807L, -9223372036854775807L, j4);
        this.f28110l = i3;
        this.f28111m = format2;
    }

    public void a() {
    }

    /* JADX INFO: finally extract failed */
    public void b() throws IOException, InterruptedException {
        c c2 = c();
        c2.a(0);
        u a2 = c2.a(0, this.f28110l);
        a2.a(this.f28111m);
        try {
            long a3 = this.f13117j.a(this.f13110c.a(this.f28112n));
            if (a3 != -1) {
                a3 += this.f28112n;
            }
            d dVar = new d(this.f13117j, this.f28112n, a3);
            for (int i2 = 0; i2 != -1; i2 = a2.a(dVar, SubsamplingScaleImageView.TILE_SIZE_AUTO, true)) {
                this.f28112n += (long) i2;
            }
            a2.a(this.f13115h, 1, (int) this.f28112n, 0, (u.a) null);
            ad.a((f) this.f13117j);
            this.f28113o = true;
        } catch (Throwable th) {
            ad.a((f) this.f13117j);
            throw th;
        }
    }

    public boolean i() {
        return this.f28113o;
    }
}
