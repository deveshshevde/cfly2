package fu;

import android.net.Uri;
import com.google.android.exoplayer2.e;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f28120a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28121b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28122c;

    /* renamed from: d  reason: collision with root package name */
    public final long f28123d;

    /* renamed from: e  reason: collision with root package name */
    public final long f28124e;

    /* renamed from: f  reason: collision with root package name */
    public final long f28125f;

    /* renamed from: g  reason: collision with root package name */
    public final long f28126g;

    /* renamed from: h  reason: collision with root package name */
    public final h f28127h;

    /* renamed from: i  reason: collision with root package name */
    public final Uri f28128i;

    /* renamed from: j  reason: collision with root package name */
    private final List<e> f28129j;

    public final int a() {
        return this.f28129j.size();
    }

    public final e a(int i2) {
        return this.f28129j.get(i2);
    }

    public final long b(int i2) {
        long j2;
        if (i2 == this.f28129j.size() - 1) {
            long j3 = this.f28121b;
            if (j3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = j3 - this.f28129j.get(i2).f28138b;
        } else {
            j2 = this.f28129j.get(i2 + 1).f28138b - this.f28129j.get(i2).f28138b;
        }
        return j2;
    }

    public final long c(int i2) {
        return e.b(b(i2));
    }
}
