package gb;

import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.ad;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f28414a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f28415b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e> f28416c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, c> f28417d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f28418e;

    public f(b bVar, Map<String, e> map, Map<String, c> map2, Map<String, String> map3) {
        this.f28414a = bVar;
        this.f28417d = map2;
        this.f28418e = map3;
        this.f28416c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f28415b = bVar.b();
    }

    public int a() {
        return this.f28415b.length;
    }

    public int a(long j2) {
        int b2 = ad.b(this.f28415b, j2, false, false);
        if (b2 < this.f28415b.length) {
            return b2;
        }
        return -1;
    }

    public long a(int i2) {
        return this.f28415b[i2];
    }

    public List<b> b(long j2) {
        return this.f28414a.a(j2, this.f28416c, this.f28417d, this.f28418e);
    }
}
