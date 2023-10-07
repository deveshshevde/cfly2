package ft;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.a;

public abstract class l extends d {

    /* renamed from: k  reason: collision with root package name */
    public final long f13118k;

    public l(f fVar, h hVar, Format format, int i2, Object obj, long j2, long j3, long j4) {
        super(fVar, hVar, 1, format, i2, obj, j2, j3);
        a.b(format);
        this.f13118k = j4;
    }

    public long h() {
        long j2 = this.f13118k;
        if (j2 != -1) {
            return 1 + j2;
        }
        return -1;
    }

    public abstract boolean i();
}
