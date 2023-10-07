package gd;

import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.a;
import java.util.Collections;
import java.util.List;

final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f28433a;

    public c(List<b> list) {
        this.f28433a = Collections.unmodifiableList(list);
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

    public List<b> b(long j2) {
        return j2 >= 0 ? this.f28433a : Collections.emptyList();
    }
}
