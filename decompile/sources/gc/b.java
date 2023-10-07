package gc;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.a;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final b f28426a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final List<com.google.android.exoplayer2.text.b> f28427b;

    private b() {
        this.f28427b = Collections.emptyList();
    }

    public b(com.google.android.exoplayer2.text.b bVar) {
        this.f28427b = Collections.singletonList(bVar);
    }

    public int a() {
        return 1;
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public long a(int i2) {
        a.a(i2 == 0);
        return 0;
    }

    public List<com.google.android.exoplayer2.text.b> b(long j2) {
        return j2 >= 0 ? this.f28427b : Collections.emptyList();
    }
}
